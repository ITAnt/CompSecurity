// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.service;

import com.netflix.mediaclient.Log;

// Referenced classes of package com.netflix.mediaclient.service:
//            NetflixService

class this._cls0
    implements Runnable
{

    final NetflixService this$0;

    public void run()
    {
        Log.i("NetflixService", "Stopping service via runnable");
        stopSelf();
    }

    ()
    {
        this$0 = NetflixService.this;
        super();
    }
}
