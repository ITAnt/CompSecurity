// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.walmart.android.app.shop;

import android.view.View;

// Referenced classes of package com.walmart.android.app.shop:
//            ShopFilterPresenter

class this._cls0
    implements android.view.lterPresenter._cls4
{

    final ShopFilterPresenter this$0;

    public void onClick(View view)
    {
        ShopFilterPresenter.access$200(ShopFilterPresenter.this);
        setInStoreActive(false);
        reloadData();
    }

    ()
    {
        this$0 = ShopFilterPresenter.this;
        super();
    }
}
