// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import kg;
import kk;

public final class zzi
{

    private final kk a[];
    private final String b;

    public zzi(Context context, AttributeSet attributeset)
    {
        boolean flag1 = true;
        super();
        context = context.getResources().obtainAttributes(attributeset, kg.AdsAttrs);
        attributeset = context.getString(kg.AdsAttrs_adSize);
        String s = context.getString(kg.AdsAttrs_adSizes);
        boolean flag;
        if (!TextUtils.isEmpty(attributeset))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (TextUtils.isEmpty(s))
        {
            flag1 = false;
        }
        if (flag && !flag1)
        {
            a = a(attributeset);
        } else
        if (!flag && flag1)
        {
            a = a(s);
        } else
        if (flag)
        {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else
        {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        b = context.getString(kg.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(b))
        {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        } else
        {
            return;
        }
    }

    private static kk[] a(String s)
    {
        String as[];
        kk akk[];
        int i;
        as = s.split("\\s*,\\s*");
        akk = new kk[as.length];
        i = 0;
_L9:
        String s1;
        String as1[];
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        s1 = as[i].trim();
        if (!s1.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        as1 = s1.split("[xX]");
        as1[0] = as1[0].trim();
        as1[1] = as1[1].trim();
        if (!"FULL_WIDTH".equals(as1[0])) goto _L2; else goto _L1
_L1:
        int j = -1;
_L5:
        int k;
        boolean flag;
        try
        {
            flag = "AUTO_HEIGHT".equals(as1[1]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException((new StringBuilder("Could not parse XML attribute \"adSize\": ")).append(s1).toString());
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        k = -2;
_L6:
        akk[i] = new kk(j, k);
_L7:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        j = Integer.parseInt(as1[0]);
          goto _L5
_L4:
        k = Integer.parseInt(as1[1]);
          goto _L6
        if ("BANNER".equals(s1))
        {
            akk[i] = kk.a;
        } else
        if ("LARGE_BANNER".equals(s1))
        {
            akk[i] = kk.c;
        } else
        if ("FULL_BANNER".equals(s1))
        {
            akk[i] = kk.b;
        } else
        if ("LEADERBOARD".equals(s1))
        {
            akk[i] = kk.d;
        } else
        if ("MEDIUM_RECTANGLE".equals(s1))
        {
            akk[i] = kk.e;
        } else
        if ("SMART_BANNER".equals(s1))
        {
            akk[i] = kk.g;
        } else
        if ("WIDE_SKYSCRAPER".equals(s1))
        {
            akk[i] = kk.f;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Could not parse XML attribute \"adSize\": ")).append(s1).toString());
        }
          goto _L7
        if (akk.length == 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Could not parse XML attribute \"adSize\": ")).append(s).toString());
        }
        return akk;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final String a()
    {
        return b;
    }

    public final kk[] a(boolean flag)
    {
        if (!flag && a.length != 1)
        {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        } else
        {
            return a;
        }
    }
}
