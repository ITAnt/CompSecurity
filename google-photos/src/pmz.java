// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class pmz extends qlq
{

    private static volatile pmz a[];
    private pna b;
    private String c;

    public pmz()
    {
        b = null;
        c = null;
        F = null;
        G = -1;
    }

    public static pmz[] b()
    {
        if (a == null)
        {
            synchronized (qlu.a)
            {
                if (a == null)
                {
                    a = new pmz[0];
                }
            }
        }
        return a;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final int a()
    {
        int j = super.a();
        int i = j;
        if (b != null)
        {
            i = j + qlp.c(1, b);
        }
        j = i;
        if (c != null)
        {
            j = i + qlp.b(2, c);
        }
        return j;
    }

    public final qlw a(qlo qlo1)
    {
        do
        {
            int i = qlo1.a();
            switch (i)
            {
            default:
                if (super.a(qlo1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (b == null)
                {
                    b = new pna();
                }
                qlo1.a(b);
                break;

            case 18: // '\022'
                c = qlo1.g();
                break;
            }
        } while (true);
    }

    public final void a(qlp qlp1)
    {
        if (b != null)
        {
            qlp1.a(1, b);
        }
        if (c != null)
        {
            qlp1.a(2, c);
        }
        super.a(qlp1);
    }
}
