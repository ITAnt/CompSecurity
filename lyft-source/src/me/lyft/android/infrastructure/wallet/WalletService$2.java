// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.infrastructure.wallet;

import android.content.Intent;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;
import me.lyft.android.infrastructure.activity.ActivityResult;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

// Referenced classes of package me.lyft.android.infrastructure.wallet:
//            WalletService

class this._cls0
    implements Func1
{

    final WalletService this$0;

    public volatile Object call(Object obj)
    {
        return call((ActivityResult)obj);
    }

    public Observable call(ActivityResult activityresult)
    {
        if (activityresult.getResultCode() == -1)
        {
            activityresult = (MaskedWallet)activityresult.getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
            activityresult = FullWalletRequest.a().a(activityresult.b()).a();
            Wallet.b.a(WalletService.access$100(WalletService.this).getApi(), activityresult, 19);
            return WalletService.access$200(WalletService.this).first(new Func1() {

                final WalletService._cls2 this$1;

                public Boolean call(ActivityResult activityresult1)
                {
                    boolean flag;
                    if (activityresult1.getRequestCode() == 19)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    return Boolean.valueOf(flag);
                }

                public volatile Object call(Object obj)
                {
                    return call((ActivityResult)obj);
                }

            
            {
                this$1 = WalletService._cls2.this;
                super();
            }
            });
        }
        if (activityresult.getResultCode() == 0)
        {
            return Observable.empty();
        } else
        {
            return Observable.error(WalletService.access$000(WalletService.this, activityresult.getIntent()));
        }
    }

    _cls1.this._cls1()
    {
        this$0 = WalletService.this;
        super();
    }
}
