// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.QRBS.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.scannerfire.utils.Utils;

// Referenced classes of package com.QRBS.activity:
//            MyResultActivity

class val.text
    implements android.view.r
{

    final MyResultActivity this$0;
    private final String val$text;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.DIAL", Uri.parse(val$text));
        try
        {
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Utils.showToastNotification(MyResultActivity.this, getString(0x7f080157));
        }
    }

    tion()
    {
        this$0 = final_myresultactivity;
        val$text = String.this;
        super();
    }
}
