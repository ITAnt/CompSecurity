// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ng.Object
    implements hst
{

    final eun a;
    final eum b;

    private cev b()
    {
        cev cev = eun.a(a).D();
        if (cev == null)
        {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        } else
        {
            return cev;
        }
    }

    public final Object a()
    {
        return b();
    }

    ct(eum eum1, eun eun1)
    {
        b = eum1;
        a = eun1;
        super();
    }
}
