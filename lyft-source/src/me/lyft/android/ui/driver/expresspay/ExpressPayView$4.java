// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.driver.expresspay;

import android.view.View;
import me.lyft.android.analytics.studies.ExpressPayAnalytics;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ExpressPayAccount;

// Referenced classes of package me.lyft.android.ui.driver.expresspay:
//            ExpressPayView

class this._cls0
    implements android.view.ner
{

    final ExpressPayView this$0;

    public void onClick(View view)
    {
        ExpressPayAnalytics.trackConfirmDepositTaps();
        view = expressPayRepository.getExpressPayAccount();
        if (view.isNull())
        {
            dialogFlow.show(new .AddDebitCardDialog());
            return;
        }
        if (view.isFailed())
        {
            appFlow.goTo(new me.lyft.android.ui.driver.tDebitCardScreen());
            return;
        } else
        {
            ExpressPayView.access$100(ExpressPayView.this);
            return;
        }
    }

    creen()
    {
        this$0 = ExpressPayView.this;
        super();
    }
}
