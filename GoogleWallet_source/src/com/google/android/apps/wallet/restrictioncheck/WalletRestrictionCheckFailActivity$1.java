// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.wallet.restrictioncheck;

import android.content.DialogInterface;
import com.google.android.apps.wallet.filter.ActivityFilters;

// Referenced classes of package com.google.android.apps.wallet.restrictioncheck:
//            WalletRestrictionCheckFailActivity

final class this._cls0
    implements android.content.tRestrictionCheckFailActivity._cls1
{

    final WalletRestrictionCheckFailActivity this$0;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            return;

        case -1: 
            startActivity(ActivityFilters.getRedirectIntent(getIntent()));
            finish();
            return;

        case -2: 
            WalletRestrictionCheckFailActivity.access$000(WalletRestrictionCheckFailActivity.this);
            return;
        }
    }

    ()
    {
        this$0 = WalletRestrictionCheckFailActivity.this;
        super();
    }
}
