// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.payment;

import rx.functions.Action1;

// Referenced classes of package me.lyft.android.ui.payment:
//            BaseCreditCardView

class this._cls0
    implements Action1
{

    final BaseCreditCardView this$0;

    public void call(Integer integer)
    {
        if (integer.intValue() == 0x7f0d0024)
        {
            BaseCreditCardView.access$100(BaseCreditCardView.this);
        }
    }

    public volatile void call(Object obj)
    {
        call((Integer)obj);
    }

    ()
    {
        this$0 = BaseCreditCardView.this;
        super();
    }
}
