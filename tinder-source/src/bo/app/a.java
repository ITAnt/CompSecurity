// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import com.appboy.Appboy;

public final class a
    implements Runnable
{

    final Appboy a;

    public a(Appboy appboy)
    {
        a = appboy;
        super();
    }

    public final void run()
    {
        Appboy.a(a);
    }
}
