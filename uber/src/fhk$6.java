// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ang.Object
    implements hst
{

    final fhl a;
    final fhk b;

    private cys b()
    {
        cys cys = fhl.a(a).X();
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

    (fhk fhk1, fhl fhl1)
    {
        b = fhk1;
        a = fhl1;
        super();
    }
}
