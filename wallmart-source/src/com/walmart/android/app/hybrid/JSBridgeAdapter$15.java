// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.walmart.android.app.hybrid;


// Referenced classes of package com.walmart.android.app.hybrid:
//            JSBridgeAdapter

class aHandlerMain extends aHandlerMain
{

    final JSBridgeAdapter this$0;

    public void handleOnMain(String s, com.walmartlabs.hybrid.idge.JsCallback jscallback)
    {
        s = (te)JSBridgeAdapter.access$200(JSBridgeAdapter.this, s, com/walmart/android/app/hybrid/JSBridgeAdapter$State);
        if (s != null)
        {
            JSBridgeAdapter.access$500(JSBridgeAdapter.this).onStateReplaced(s);
        }
    }

    allback()
    {
        this$0 = JSBridgeAdapter.this;
        super(JSBridgeAdapter.this, null);
    }
}
