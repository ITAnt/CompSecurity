// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arist.MusicPlayer;

import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.arist.MusicPlayer:
//            MainActivity

class <init> extends AdListener
{

    final MainActivity this$0;

    public void onAdLoaded()
    {
        super.onAdLoaded();
        isExitAdLoad = true;
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
