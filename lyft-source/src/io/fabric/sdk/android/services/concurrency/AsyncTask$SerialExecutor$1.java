// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.concurrency;


class a
    implements Runnable
{

    final Runnable a;
    final b b;

    public void run()
    {
        a.run();
        b.b();
        return;
        Exception exception;
        exception;
        b.b();
        throw exception;
    }

    ( , Runnable runnable)
    {
        b = ;
        a = runnable;
        super();
    }
}
