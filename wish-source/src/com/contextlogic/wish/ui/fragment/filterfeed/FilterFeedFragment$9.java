// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.fragment.filterfeed;

import com.contextlogic.wish.ui.components.navigation.NavigationBarButtonCallback;

// Referenced classes of package com.contextlogic.wish.ui.fragment.filterfeed:
//            FilterFeedFragment

class this._cls0
    implements NavigationBarButtonCallback
{

    final FilterFeedFragment this$0;

    public void onMenuItemClicked()
    {
        handleFilterApply();
    }

    Callback()
    {
        this$0 = FilterFeedFragment.this;
        super();
    }
}
