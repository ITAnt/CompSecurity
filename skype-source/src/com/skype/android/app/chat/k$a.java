// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.app.chat;

import android.view.View;
import com.skype.Transfer;

// Referenced classes of package com.skype.android.app.chat:
//            k

private final class transfer
    implements android.view..OnClickListener
{

    final k this$0;
    private Transfer transfer;

    public final void onClick(View view)
    {
        k.access$200(k.this, transfer);
        refreshContent();
    }

    public er(Transfer transfer1)
    {
        this$0 = k.this;
        super();
        transfer = transfer1;
    }
}
