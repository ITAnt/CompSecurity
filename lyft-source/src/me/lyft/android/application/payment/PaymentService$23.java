// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.application.payment;

import me.lyft.android.infrastructure.lyft.payment.PayPalClientTokenDTO;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import rx.Observable;
import rx.functions.Func1;

// Referenced classes of package me.lyft.android.application.payment:
//            PaymentService

class this._cls0
    implements Func1
{

    final PaymentService this$0;

    public volatile Object call(Object obj)
    {
        return call((PayPalClientTokenDTO)obj);
    }

    public Observable call(PayPalClientTokenDTO paypalclienttokendto)
    {
        return PaymentService.access$600(PaymentService.this).obtainPayPalChargeData(paypalclienttokendto.getClientToken());
    }

    ntTokenDTO()
    {
        this$0 = PaymentService.this;
        super();
    }
}
