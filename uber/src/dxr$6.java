// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ang.Object
    implements hst
{

    final dxs a;
    final dxr b;

    private cys b()
    {
        cys cys = dxs.a(a).X();
        if (cys == null)
        {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        } else
        {
            return cys;
        }
    }

    public final Object a()
    {
        return b();
    }

    (dxr dxr1, dxs dxs1)
    {
        b = dxr1;
        a = dxs1;
        super();
    }
}
