// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.g.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.g;

// Referenced classes of package com.google.g.a.a:
//            m

public final class t extends b
{

    public m a;
    public m b;

    public t()
    {
        a = null;
        b = null;
        unknownFieldData = null;
        cachedSize = -1;
    }

    protected final int computeSerializedSize()
    {
        int j = super.computeSerializedSize();
        int i = j;
        if (a != null)
        {
            i = j + CodedOutputByteBufferNano.c(1, a);
        }
        j = i;
        if (b != null)
        {
            j = i + CodedOutputByteBufferNano.c(2, b);
        }
        return j;
    }

    public final g mergeFrom(a a1)
    {
        do
        {
            int i = a1.a();
            switch (i)
            {
            default:
                if (super.storeUnknownField(a1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (a == null)
                {
                    a = new m();
                }
                a1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new m();
                }
                a1.a(b);
                break;
            }
        } while (true);
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
    {
        if (a != null)
        {
            codedoutputbytebuffernano.a(1, a);
        }
        if (b != null)
        {
            codedoutputbytebuffernano.a(2, b);
        }
        super.writeTo(codedoutputbytebuffernano);
    }
}
