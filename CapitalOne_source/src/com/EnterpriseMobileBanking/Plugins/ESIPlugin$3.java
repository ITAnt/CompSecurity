// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.EnterpriseMobileBanking.Plugins;

import android.view.View;
import com.EnterpriseMobileBanking.EnterpriseMobileBanking;
import com.EnterpriseMobileBanking.Utils.Log;

// Referenced classes of package com.EnterpriseMobileBanking.Plugins:
//            ESIPlugin

class this._cls0
    implements Runnable
{

    final ESIPlugin this$0;

    public void run()
    {
        Log.i(ESIPlugin.access$000(), "in the dismissLoginPage runOnUiThread");
        activity.findViewById(0x7f080024).setVisibility(0);
        activity.findViewById(0x7f0800a4).setVisibility(8);
    }

    ing()
    {
        this$0 = ESIPlugin.this;
        super();
    }
}
