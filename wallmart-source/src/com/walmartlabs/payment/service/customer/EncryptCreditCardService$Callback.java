// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.walmartlabs.payment.service.customer;


// Referenced classes of package com.walmartlabs.payment.service.customer:
//            EncryptCreditCardService

public static interface Cc
{

    public abstract void onError(com.walmartlabs.kangaroo.ervice.Callback callback);

    public abstract void onResult(Cc cc);
}
