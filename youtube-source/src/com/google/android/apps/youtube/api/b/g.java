// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.api.b;


// Referenced classes of package com.google.android.apps.youtube.api.b:
//            a, h

final class g
    implements Runnable
{

    final a a;

    g(a a1)
    {
        a = a1;
        super();
    }

    public final void run()
    {
        com.google.android.apps.youtube.api.b.a.b(a).a();
        System.gc();
    }
}
