// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.fragment.cartmodal.ui;

import com.contextlogic.wish.api.data.WishCart;
import com.contextlogic.wish.ui.fragment.cartmodal.CartManager;

// Referenced classes of package com.contextlogic.wish.ui.fragment.cartmodal.ui:
//            CartAbandonOfferModal

class llback
    implements com.contextlogic.wish.api.service.vice.SuccessCallback
{

    final CartAbandonOfferModal this$0;
    final llback val$callback;

    public void onServiceSucceeded(WishCart wishcart)
    {
        CartAbandonOfferModal.access$300(CartAbandonOfferModal.this).hideLoadingSpinner();
        val$callback.onClaim(wishcart);
    }

    llback()
    {
        this$0 = final_cartabandonoffermodal;
        val$callback = llback.this;
        super();
    }
}
