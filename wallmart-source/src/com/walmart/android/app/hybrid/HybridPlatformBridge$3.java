// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.walmart.android.app.hybrid;

import android.content.DialogInterface;

// Referenced classes of package com.walmart.android.app.hybrid:
//            HybridPlatformBridge

class allback
    implements android.content.lListener
{

    final HybridPlatformBridge this$0;
    final allback val$bridgeCallback;

    public void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface = new kerDialogResponse();
        dialoginterface.action = "cancel";
        val$bridgeCallback.respond(dialoginterface);
    }

    allback()
    {
        this$0 = final_hybridplatformbridge;
        val$bridgeCallback = allback.this;
        super();
    }
}
