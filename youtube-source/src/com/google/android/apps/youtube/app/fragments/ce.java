// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.app.fragments;

import com.google.android.apps.youtube.app.WatchWhileActivity;
import com.google.android.apps.youtube.app.ui.ab;
import com.google.android.apps.youtube.core.Analytics;
import com.google.android.apps.youtube.datalib.model.gdata.Video;

// Referenced classes of package com.google.android.apps.youtube.app.fragments:
//            WatchLaterFragment

final class ce
    implements ab
{

    final WatchLaterFragment a;

    ce(WatchLaterFragment watchlaterfragment)
    {
        a = watchlaterfragment;
        super();
    }

    public final void a(Object obj)
    {
        obj = (Video)obj;
        a.c.P().b("RemoveWatchLater");
        WatchLaterFragment.a(a, ((Video) (obj)));
    }
}
