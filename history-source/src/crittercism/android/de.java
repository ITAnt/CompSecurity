// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            di

public final class de extends di
{

    private Runnable a;

    public de(Runnable runnable)
    {
        a = runnable;
    }

    public final void a()
    {
        a.run();
    }
}
