// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.core.client;

import com.android.volley.VolleyError;
import com.android.volley.n;

// Referenced classes of package com.google.android.apps.youtube.core.client:
//            VideoStats2Client

final class cg
    implements n
{

    final VideoStats2Client a;

    cg(VideoStats2Client videostats2client)
    {
        a = videostats2client;
        super();
    }

    public final void a(VolleyError volleyerror)
    {
        VideoStats2Client.a(a, true);
    }
}
