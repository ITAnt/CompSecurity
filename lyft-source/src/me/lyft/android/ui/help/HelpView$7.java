// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.help;

import me.lyft.android.common.Unit;
import me.lyft.android.ui.SlideMenuController;
import rx.functions.Action1;

// Referenced classes of package me.lyft.android.ui.help:
//            HelpView

class this._cls0
    implements Action1
{

    final HelpView this$0;

    public volatile void call(Object obj)
    {
        call((Unit)obj);
    }

    public void call(Unit unit)
    {
        slideMenuController.open();
    }

    ler()
    {
        this$0 = HelpView.this;
        super();
    }
}
