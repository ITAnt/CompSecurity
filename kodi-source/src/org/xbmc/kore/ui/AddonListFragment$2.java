// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.xbmc.kore.ui;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package org.xbmc.kore.ui:
//            AddonListFragment

class this._cls0
    implements android.widget.ickListener
{

    final AddonListFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ewHolder)view.getTag();
        AddonListFragment.access$000(AddonListFragment.this).onAddonSelected(((ewHolder) (adapterview)).addonId, ((ewHolder) (adapterview)).addonName);
    }

    AddonSelectedListener()
    {
        this$0 = AddonListFragment.this;
        super();
    }
}
