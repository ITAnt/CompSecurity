// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.wallet.funding;

import com.google.android.apps.wallet.bankaccount.api.BankAccountsModelEvent;
import com.google.android.apps.wallet.eventbus.EventHandler;
import com.google.common.base.Optional;

// Referenced classes of package com.google.android.apps.wallet.funding:
//            SelectFundingSourceActivity

final class this._cls0
    implements EventHandler
{

    final SelectFundingSourceActivity this$0;

    private void handleEvent(BankAccountsModelEvent bankaccountsmodelevent)
    {
        if (SelectFundingSourceActivity.access$400(SelectFundingSourceActivity.this, bankaccountsmodelevent.getFailureCause()))
        {
            return;
        } else
        {
            SelectFundingSourceActivity.access$502(SelectFundingSourceActivity.this, Optional.of(bankaccountsmodelevent));
            SelectFundingSourceActivity.access$600(SelectFundingSourceActivity.this);
            return;
        }
    }

    public final volatile void handleEvent(Object obj)
    {
        handleEvent((BankAccountsModelEvent)obj);
    }

    ()
    {
        this$0 = SelectFundingSourceActivity.this;
        super();
    }
}
