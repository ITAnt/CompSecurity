// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.appboy.Constants;

// Referenced classes of package com.appboy.ui.inappmessage.views:
//            AppboyInAppMessageHtmlBaseView

public class AppboyInAppMessageHtmlFullView extends AppboyInAppMessageHtmlBaseView
{

    private static final String TAG;

    public AppboyInAppMessageHtmlFullView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public WebView getMessageWebView()
    {
        return (WebView)findViewById(com.appboy.ui.R.id.com_appboy_inappmessage_html_full_webview);
    }

    static 
    {
        TAG = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, com/appboy/ui/inappmessage/views/AppboyInAppMessageHtmlFullView.getName()
        });
    }
}
