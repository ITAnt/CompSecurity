// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.app.signin;

import com.skype.android.event.EventFilter;

// Referenced classes of package com.skype.android.app.signin:
//            UnifiedLandingPageActivity

final class this._cls0
    implements EventFilter
{

    final accept this$0;

    public final boolean accept(com.skype.android.gen.roxy._cls1 _pcls1)
    {
        return ((UnifiedLandingPageActivity)tTarget()).onAcceptEvent(_pcls1);
    }

    public final volatile boolean accept(Object obj)
    {
        return accept((com.skype.android.gen.roxy._cls1.accept)obj);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
