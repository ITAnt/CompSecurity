// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a.a.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.f;
import java.util.ArrayList;

public final class am extends b
{

    public static final am a[] = new am[0];
    public String b;
    public String c;
    public String d;

    public am()
    {
        b = "";
        c = "";
        d = "";
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = CodedOutputByteBufferNano.b(2, b) + 0;
        }
        int i = j;
        if (!c.equals(""))
        {
            i = j + CodedOutputByteBufferNano.b(3, c);
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + CodedOutputByteBufferNano.b(4, d);
        }
        i = j + f.a(dl);
        dm = i;
        return i;
    }

    public final c a(a a1)
    {
        do
        {
            int i = a1.a();
            switch (i)
            {
            default:
                if (dl == null)
                {
                    dl = new ArrayList();
                }
                if (f.a(dl, a1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 18: // '\022'
                b = a1.f();
                break;

            case 26: // '\032'
                c = a1.f();
                break;

            case 34: // '"'
                d = a1.f();
                break;
            }
        } while (true);
    }

    public final void a(CodedOutputByteBufferNano codedoutputbytebuffernano)
    {
        if (!b.equals(""))
        {
            codedoutputbytebuffernano.a(2, b);
        }
        if (!c.equals(""))
        {
            codedoutputbytebuffernano.a(3, c);
        }
        if (!d.equals(""))
        {
            codedoutputbytebuffernano.a(4, d);
        }
        f.a(dl, codedoutputbytebuffernano);
    }

}
