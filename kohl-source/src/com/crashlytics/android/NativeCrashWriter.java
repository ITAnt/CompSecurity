// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android;

import com.crashlytics.android.internal.models.BinaryImageData;
import com.crashlytics.android.internal.models.CustomAttributeData;
import com.crashlytics.android.internal.models.SessionEventData;
import com.crashlytics.android.internal.models.SignalData;
import com.crashlytics.android.internal.models.ThreadData;
import java.io.IOException;

// Referenced classes of package com.crashlytics.android:
//            CodedOutputStream, ByteString

class NativeCrashWriter
{
    private static final class ApplicationMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 3;

        public ApplicationMessage(ExecutionMessage executionmessage, RepeatedMessage repeatedmessage)
        {
            super(3, new ProtobufMessage[] {
                executionmessage, repeatedmessage
            });
        }
    }

    private static final class BinaryImageMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 4;
        private final long baseAddr;
        private final String filePath;
        private final long imageSize;
        private final String uuid;

        public int getPropertiesSize()
        {
            int i = CodedOutputStream.computeUInt64Size(1, baseAddr);
            int j = CodedOutputStream.computeUInt64Size(2, imageSize);
            return CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(filePath)) + i + j + CodedOutputStream.computeBytesSize(4, ByteString.copyFromUtf8(uuid));
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeUInt64(1, baseAddr);
            codedoutputstream.writeUInt64(2, imageSize);
            codedoutputstream.writeBytes(3, ByteString.copyFromUtf8(filePath));
            codedoutputstream.writeBytes(4, ByteString.copyFromUtf8(uuid));
        }

        public BinaryImageMessage(BinaryImageData binaryimagedata)
        {
            super(4, new ProtobufMessage[0]);
            baseAddr = binaryimagedata.baseAddress;
            imageSize = binaryimagedata.size;
            filePath = binaryimagedata.path;
            uuid = binaryimagedata.id;
        }
    }

    private static final class CustomAttributeMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 2;
        private final String key;
        private final String value;

        public int getPropertiesSize()
        {
            int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(key));
            String s;
            if (value == null)
            {
                s = "";
            } else
            {
                s = value;
            }
            return i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(key));
            String s;
            if (value == null)
            {
                s = "";
            } else
            {
                s = value;
            }
            codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(s));
        }

        public CustomAttributeMessage(CustomAttributeData customattributedata)
        {
            super(2, new ProtobufMessage[0]);
            key = customattributedata.key;
            value = customattributedata.value;
        }
    }

    private static final class DeviceMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 5;

        public int getPropertiesSize()
        {
            return 0 + CodedOutputStream.computeFloatSize(1, 0.0F) + CodedOutputStream.computeInt32Size(2, 0) + CodedOutputStream.computeBoolSize(3, false) + CodedOutputStream.computeUInt32Size(4, 0) + CodedOutputStream.computeUInt64Size(5, 0L) + CodedOutputStream.computeUInt64Size(6, 0L);
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeFloat(1, 0.0F);
            codedoutputstream.writeInt32(2, 0);
            codedoutputstream.writeBool(3, false);
            codedoutputstream.writeUInt32(4, 0);
            codedoutputstream.writeUInt64(5, 0L);
            codedoutputstream.writeUInt64(6, 0L);
        }

        public DeviceMessage()
        {
            super(5, new ProtobufMessage[0]);
        }
    }

    private static final class EventMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 10;
        private final String crashType;
        private final long time;

        public int getPropertiesSize()
        {
            return CodedOutputStream.computeUInt64Size(1, time) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(crashType));
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeUInt64(1, time);
            codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(crashType));
        }

        public EventMessage(long l, String s, ApplicationMessage applicationmessage, DeviceMessage devicemessage)
        {
            super(10, new ProtobufMessage[] {
                applicationmessage, devicemessage
            });
            time = l;
            crashType = s;
        }
    }

    private static final class ExecutionMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 1;

        public ExecutionMessage(SignalMessage signalmessage, RepeatedMessage repeatedmessage, RepeatedMessage repeatedmessage1)
        {
            super(1, new ProtobufMessage[] {
                repeatedmessage, signalmessage, repeatedmessage1
            });
        }
    }

    private static final class FrameMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 3;
        private final long address;
        private final String file;
        private final int importance;
        private final long offset;
        private final String symbol;

        public int getPropertiesSize()
        {
            return CodedOutputStream.computeUInt64Size(1, address) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(symbol)) + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(file)) + CodedOutputStream.computeUInt64Size(4, offset) + CodedOutputStream.computeUInt32Size(5, importance);
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeUInt64(1, address);
            codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(symbol));
            codedoutputstream.writeBytes(3, ByteString.copyFromUtf8(file));
            codedoutputstream.writeUInt64(4, offset);
            codedoutputstream.writeUInt32(5, importance);
        }

        public FrameMessage(com.crashlytics.android.internal.models.ThreadData.FrameData framedata)
        {
            super(3, new ProtobufMessage[0]);
            address = framedata.address;
            symbol = framedata.symbol;
            file = framedata.file;
            offset = framedata.offset;
            importance = framedata.importance;
        }
    }

    private static abstract class ProtobufMessage
    {

        private final ProtobufMessage children[];
        private final int tag;

        public int getPropertiesSize()
        {
            return 0;
        }

        public int getSize()
        {
            int i = getSizeNoTag();
            return i + CodedOutputStream.computeRawVarint32Size(i) + CodedOutputStream.computeTagSize(tag);
        }

        public int getSizeNoTag()
        {
            int j = getPropertiesSize();
            ProtobufMessage aprotobufmessage[] = children;
            int k = aprotobufmessage.length;
            for (int i = 0; i < k; i++)
            {
                j += aprotobufmessage[i].getSize();
            }

            return j;
        }

        public void write(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeTag(tag, 2);
            codedoutputstream.writeRawVarint32(getSizeNoTag());
            writeProperties(codedoutputstream);
            ProtobufMessage aprotobufmessage[] = children;
            int j = aprotobufmessage.length;
            for (int i = 0; i < j; i++)
            {
                aprotobufmessage[i].write(codedoutputstream);
            }

        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
        }

        public transient ProtobufMessage(int i, ProtobufMessage aprotobufmessage[])
        {
            tag = i;
            if (aprotobufmessage == null)
            {
                aprotobufmessage = NativeCrashWriter.EMPTY_CHILDREN;
            }
            children = aprotobufmessage;
        }
    }

    private static final class RepeatedMessage extends ProtobufMessage
    {

        private final ProtobufMessage messages[];

        public int getSize()
        {
            int j = 0;
            ProtobufMessage aprotobufmessage[] = messages;
            int k = aprotobufmessage.length;
            for (int i = 0; i < k; i++)
            {
                j += aprotobufmessage[i].getSize();
            }

            return j;
        }

        public void write(CodedOutputStream codedoutputstream)
            throws IOException
        {
            ProtobufMessage aprotobufmessage[] = messages;
            int j = aprotobufmessage.length;
            for (int i = 0; i < j; i++)
            {
                aprotobufmessage[i].write(codedoutputstream);
            }

        }

        public transient RepeatedMessage(ProtobufMessage aprotobufmessage[])
        {
            super(0, new ProtobufMessage[0]);
            messages = aprotobufmessage;
        }
    }

    private static final class SignalMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 3;
        private final long sigAddr;
        private final String sigCode;
        private final String sigName;

        public int getPropertiesSize()
        {
            return CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(sigName)) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(sigCode)) + CodedOutputStream.computeUInt64Size(3, sigAddr);
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(sigName));
            codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(sigCode));
            codedoutputstream.writeUInt64(3, sigAddr);
        }

        public SignalMessage(SignalData signaldata)
        {
            super(3, new ProtobufMessage[0]);
            sigName = signaldata.name;
            sigCode = signaldata.code;
            sigAddr = signaldata.faultAddress;
        }
    }

    private static final class ThreadMessage extends ProtobufMessage
    {

        private static final int PROTOBUF_TAG = 1;
        private final int importance;
        private final String name;

        private boolean hasName()
        {
            return name != null && name.length() > 0;
        }

        public int getPropertiesSize()
        {
            int i;
            if (hasName())
            {
                i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(name));
            } else
            {
                i = 0;
            }
            return CodedOutputStream.computeUInt32Size(2, importance) + i;
        }

        public void writeProperties(CodedOutputStream codedoutputstream)
            throws IOException
        {
            if (hasName())
            {
                codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(name));
            }
            codedoutputstream.writeUInt32(2, importance);
        }

        public ThreadMessage(ThreadData threaddata, RepeatedMessage repeatedmessage)
        {
            super(1, new ProtobufMessage[] {
                repeatedmessage
            });
            name = threaddata.name;
            importance = threaddata.importance;
        }
    }


    private static final SignalData DEFAULT_SIGNAL = new SignalData("", "", 0L);
    private static final BinaryImageMessage EMPTY_BINARY_IMAGE_MESSAGES[] = new BinaryImageMessage[0];
    private static final ProtobufMessage EMPTY_CHILDREN[] = new ProtobufMessage[0];
    private static final CustomAttributeMessage EMPTY_CUSTOM_ATTRIBUTE_MESSAGES[] = new CustomAttributeMessage[0];
    private static final FrameMessage EMPTY_FRAME_MESSAGES[] = new FrameMessage[0];
    private static final ThreadMessage EMPTY_THREAD_MESSAGES[] = new ThreadMessage[0];
    static final String NDK_CRASH_TYPE = "ndk-crash";

    NativeCrashWriter()
    {
    }

    private static RepeatedMessage createBinaryImagesMessage(BinaryImageData abinaryimagedata[])
    {
        BinaryImageMessage abinaryimagemessage[];
        int i;
        if (abinaryimagedata != null)
        {
            abinaryimagemessage = new BinaryImageMessage[abinaryimagedata.length];
        } else
        {
            abinaryimagemessage = EMPTY_BINARY_IMAGE_MESSAGES;
        }
        for (i = 0; i < abinaryimagemessage.length; i++)
        {
            abinaryimagemessage[i] = new BinaryImageMessage(abinaryimagedata[i]);
        }

        return new RepeatedMessage(abinaryimagemessage);
    }

    private static RepeatedMessage createCustomAttributesMessage(CustomAttributeData acustomattributedata[])
    {
        CustomAttributeMessage acustomattributemessage[];
        int i;
        if (acustomattributedata != null)
        {
            acustomattributemessage = new CustomAttributeMessage[acustomattributedata.length];
        } else
        {
            acustomattributemessage = EMPTY_CUSTOM_ATTRIBUTE_MESSAGES;
        }
        for (i = 0; i < acustomattributemessage.length; i++)
        {
            acustomattributemessage[i] = new CustomAttributeMessage(acustomattributedata[i]);
        }

        return new RepeatedMessage(acustomattributemessage);
    }

    private static RepeatedMessage createFramesMessage(com.crashlytics.android.internal.models.ThreadData.FrameData aframedata[])
    {
        FrameMessage aframemessage[];
        int i;
        if (aframedata != null)
        {
            aframemessage = new FrameMessage[aframedata.length];
        } else
        {
            aframemessage = EMPTY_FRAME_MESSAGES;
        }
        for (i = 0; i < aframemessage.length; i++)
        {
            aframemessage[i] = new FrameMessage(aframedata[i]);
        }

        return new RepeatedMessage(aframemessage);
    }

    private static RepeatedMessage createThreadsMessage(ThreadData athreaddata[])
    {
        ThreadMessage athreadmessage[];
        int i;
        if (athreaddata != null)
        {
            athreadmessage = new ThreadMessage[athreaddata.length];
        } else
        {
            athreadmessage = EMPTY_THREAD_MESSAGES;
        }
        for (i = 0; i < athreadmessage.length; i++)
        {
            ThreadData threaddata = athreaddata[i];
            athreadmessage[i] = new ThreadMessage(threaddata, createFramesMessage(threaddata.frames));
        }

        return new RepeatedMessage(athreadmessage);
    }

    private static EventMessage readCrashEventData(SessionEventData sessioneventdata)
        throws IOException
    {
        Object obj;
        DeviceMessage devicemessage;
        if (sessioneventdata.signal != null)
        {
            obj = sessioneventdata.signal;
        } else
        {
            obj = DEFAULT_SIGNAL;
        }
        obj = new ApplicationMessage(new ExecutionMessage(new SignalMessage(((SignalData) (obj))), createThreadsMessage(sessioneventdata.threads), createBinaryImagesMessage(sessioneventdata.binaryImages)), createCustomAttributesMessage(sessioneventdata.customAttributes));
        devicemessage = new DeviceMessage();
        return new EventMessage(sessioneventdata.timestamp, "ndk-crash", ((ApplicationMessage) (obj)), devicemessage);
    }

    public static void writeNativeCrash(SessionEventData sessioneventdata, CodedOutputStream codedoutputstream)
        throws IOException
    {
        readCrashEventData(sessioneventdata).write(codedoutputstream);
    }


}
