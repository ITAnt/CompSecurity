// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tune.crosspromo;

import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ViewSwitcher;

// Referenced classes of package com.tune.crosspromo:
//            TuneBanner, TuneAdParams, TuneAdClient

class t> extends WebViewClient
{

    final TuneBanner a;

    public void onPageFinished(WebView webview, String s)
    {
        TuneBanner.a(a);
        if (TuneBanner.b(a) != null)
        {
            TuneBanner.b(a).setVisibility(0);
            if (TuneBanner.b(a).getCurrentView() == TuneBanner.c(a))
            {
                TuneBanner.d(a).postDelayed(new Runnable() {

                    final TuneBanner._cls1 a;

                    public void run()
                    {
                        if (TuneBanner.b(a.a) != null)
                        {
                            TuneBanner.b(a.a).showNext();
                        }
                    }

            
            {
                a = TuneBanner._cls1.this;
                super();
            }
                }, 50L);
            } else
            {
                TuneBanner.d(a).postDelayed(new Runnable() {

                    final TuneBanner._cls1 a;

                    public void run()
                    {
                        if (TuneBanner.b(a.a) != null)
                        {
                            TuneBanner.b(a.a).showPrevious();
                        }
                    }

            
            {
                a = TuneBanner._cls1.this;
                super();
            }
                }, 50L);
            }
            TuneAdClient.a(TuneBanner.e(a), TuneBanner.f(a).a());
            TuneBanner.g(a);
            TuneBanner.h(a);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        TuneBanner.a(a, s);
        return true;
    }

    _cls2.a(TuneBanner tunebanner)
    {
        a = tunebanner;
        super();
    }
}
