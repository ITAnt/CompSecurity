// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

// Referenced classes of package com.squareup.picasso:
//            Dispatcher, Utils

static final class dispatcher extends BroadcastReceiver
{

    private final Dispatcher dispatcher;

    public final void onReceive(Context context, Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = intent.getAction();
        if (!"android.intent.action.AIRPLANE_MODE".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!intent.hasExtra("state")) goto _L1; else goto _L3
_L3:
        dispatcher.dispatchAirplaneModeChange(intent.getBooleanExtra("state", false));
        return;
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(s)) goto _L1; else goto _L4
_L4:
        context = (ConnectivityManager)Utils.getService(context, "connectivity");
        dispatcher.dispatchNetworkStateChange(context.getActiveNetworkInfo());
        return;
    }

    final void register()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (dispatcher.scansNetworkChanges)
        {
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        dispatcher.context.registerReceiver(this, intentfilter);
    }

    (Dispatcher dispatcher1)
    {
        dispatcher = dispatcher1;
    }
}
