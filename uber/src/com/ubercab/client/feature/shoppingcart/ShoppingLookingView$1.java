// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ubercab.client.feature.shoppingcart;

import android.view.ViewGroup;
import android.view.animation.Animation;
import dru;

// Referenced classes of package com.ubercab.client.feature.shoppingcart:
//            ShoppingLookingView

final class a extends dru
{

    final ShoppingLookingView a;

    public final void onAnimationStart(Animation animation)
    {
        a.mShoppingCartAreaOld.setVisibility(8);
    }

    (ShoppingLookingView shoppinglookingview)
    {
        a = shoppinglookingview;
        super();
    }
}
