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

// Referenced classes of package com.google.a.a.a.a:
//            cv

public final class cx extends b
{

    public static final cx a[] = new cx[0];
    public cv b[];

    public cx()
    {
        b = com.google.a.a.a.a.cv.a;
    }

    public final int a()
    {
        int k = 0;
        int i = 0;
        if (b != null)
        {
            cv acv[] = b;
            int l = acv.length;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                k = CodedOutputByteBufferNano.b(1, acv[j]);
                j++;
                i = k + i;
            } while (true);
        }
        i = k + f.a(dl);
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

            case 10: // '\n'
                int k = f.a(a1, 10);
                cv acv[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                acv = new cv[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, acv, 0, j);
                }
                for (b = acv; j < b.length - 1; j++)
                {
                    b[j] = new cv();
                    a1.a(b[j]);
                    a1.a();
                }

                b[j] = new cv();
                a1.a(b[j]);
                break;
            }
        } while (true);
    }

    public final void a(CodedOutputByteBufferNano codedoutputbytebuffernano)
    {
        if (b != null)
        {
            cv acv[] = b;
            int j = acv.length;
            for (int i = 0; i < j; i++)
            {
                codedoutputbytebuffernano.a(1, acv[i]);
            }

        }
        f.a(dl, codedoutputbytebuffernano);
    }

}
