// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.fragment.productfeed;

import android.view.View;
import android.view.animation.Animation;
import com.contextlogic.wish.ui.components.grid.StaggeredGridView;

// Referenced classes of package com.contextlogic.wish.ui.fragment.productfeed:
//            ProductFeedFragment

class this._cls1
    implements Runnable
{

    final View this$1;

    public void run()
    {
        ProductFeedFragment.access$000(_fld0).removeHeaderView();
    }

    l.bannerView()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/contextlogic/wish/ui/fragment/productfeed/ProductFeedFragment$30

/* anonymous class */
    class ProductFeedFragment._cls30
        implements android.view.animation.Animation.AnimationListener
    {

        final ProductFeedFragment this$0;
        final View val$bannerView;

        public void onAnimationEnd(Animation animation)
        {
            bannerView.post(new ProductFeedFragment._cls30._cls1());
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = final_productfeedfragment;
                bannerView = View.this;
                super();
            }
    }

}
