// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.app.signin;

import com.skype.android.event.EventFilter;

// Referenced classes of package com.skype.android.app.signin:
//            LandingPageActivity

final class this._cls0
    implements EventFilter
{

    final accept this$0;

    public final boolean accept(com.skype.android.gen.nge nge)
    {
        return ((LandingPageActivity)tTarget()).onAcceptEvent(nge);
    }

    public final volatile boolean accept(Object obj)
    {
        return accept((com.skype.android.gen.nge)obj);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
