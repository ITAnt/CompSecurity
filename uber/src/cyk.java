// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cyk
{

    private diw a;
    private dfp b;

    private cyk()
    {
    }

    cyk(byte byte0)
    {
        this();
    }

    static dfp a(cyk cyk1)
    {
        return cyk1.b;
    }

    static diw b(cyk cyk1)
    {
        return cyk1.a;
    }

    public final cyk a(dfp dfp)
    {
        if (dfp == null)
        {
            throw new NullPointerException("riderApplicationComponent");
        } else
        {
            b = dfp;
            return this;
        }
    }

    public final cyk a(diw diw)
    {
        a = diw;
        return this;
    }

    public final cyq a()
    {
        if (a == null)
        {
            throw new IllegalStateException("riderDialogFragmentModule must be set");
        }
        if (b == null)
        {
            throw new IllegalStateException("riderApplicationComponent must be set");
        } else
        {
            return new cyj(this, (byte)0);
        }
    }
}
