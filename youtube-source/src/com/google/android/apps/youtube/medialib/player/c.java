// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.medialib.player;


// Referenced classes of package com.google.android.apps.youtube.medialib.player:
//            DefaultPlayerSurface

final class c
    implements Runnable
{

    final DefaultPlayerSurface a;

    c(DefaultPlayerSurface defaultplayersurface)
    {
        a = defaultplayersurface;
        super();
    }

    public final void run()
    {
        a.removeView(DefaultPlayerSurface.b(a));
        a.addView(DefaultPlayerSurface.b(a), 0);
    }
}
