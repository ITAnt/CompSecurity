// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.snapchat.android.ui;

import android.media.MediaPlayer;

// Referenced classes of package com.snapchat.android.ui:
//            TextureVideoView

final class a
    implements android.media.istener
{

    private TextureVideoView a;

    public final boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        if (TextureVideoView.k(a) != null)
        {
            TextureVideoView.k(a).onInfo(mediaplayer, i, j);
        }
        return true;
    }

    (TextureVideoView texturevideoview)
    {
        a = texturevideoview;
        super();
    }
}
