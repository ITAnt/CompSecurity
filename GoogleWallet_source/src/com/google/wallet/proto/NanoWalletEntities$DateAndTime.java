// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.wallet.proto;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

// Referenced classes of package com.google.wallet.proto:
//            NanoWalletEntities

public static final class clear extends ExtendableMessageNano
{

    public Integer day;
    public Integer month;
    public Integer year;

    private clear clear()
    {
        year = null;
        day = null;
        month = null;
        unknownFieldData = null;
        cachedSize = -1;
        return this;
    }

    private cachedSize mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        do
        {
            int i = codedinputbytebuffernano.readTag();
            switch (i)
            {
            default:
                if (storeUnknownField(codedinputbytebuffernano, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                year = Integer.valueOf(codedinputbytebuffernano.readInt32());
                break;

            case 16: // '\020'
                day = Integer.valueOf(codedinputbytebuffernano.readInt32());
                break;

            case 24: // '\030'
                month = Integer.valueOf(codedinputbytebuffernano.readInt32());
                break;
            }
        } while (true);
    }

    protected final int computeSerializedSize()
    {
        int j = super.computeSerializedSize();
        int i = j;
        if (year != null)
        {
            i = j + CodedOutputByteBufferNano.computeInt32Size(1, year.intValue());
        }
        j = i;
        if (day != null)
        {
            j = i + CodedOutputByteBufferNano.computeInt32Size(2, day.intValue());
        }
        i = j;
        if (month != null)
        {
            i = j + CodedOutputByteBufferNano.computeInt32Size(3, month.intValue());
        }
        return i;
    }

    public final volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return mergeFrom(codedinputbytebuffernano);
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if (year != null)
        {
            codedoutputbytebuffernano.writeInt32(1, year.intValue());
        }
        if (day != null)
        {
            codedoutputbytebuffernano.writeInt32(2, day.intValue());
        }
        if (month != null)
        {
            codedoutputbytebuffernano.writeInt32(3, month.intValue());
        }
        super.writeTo(codedoutputbytebuffernano);
    }

    public ()
    {
        clear();
    }
}
