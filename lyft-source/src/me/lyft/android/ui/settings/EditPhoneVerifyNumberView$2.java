// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.settings;

import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import rx.functions.Action1;

// Referenced classes of package me.lyft.android.ui.settings:
//            EditPhoneVerifyNumberView

class this._cls0
    implements Action1
{

    final EditPhoneVerifyNumberView this$0;

    public volatile void call(Object obj)
    {
        call((Unit)obj);
    }

    public void call(Unit unit)
    {
        appFlow.resetTo(new en());
    }

    en()
    {
        this$0 = EditPhoneVerifyNumberView.this;
        super();
    }
}
