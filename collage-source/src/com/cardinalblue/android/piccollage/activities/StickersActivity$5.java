// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cardinalblue.android.piccollage.activities;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.cardinalblue.android.b.k;
import com.cardinalblue.android.piccollage.a.b;
import com.cardinalblue.android.piccollage.controller.o;
import com.cardinalblue.android.piccollage.iab.util.d;
import com.cardinalblue.android.piccollage.iab.util.e;
import com.cardinalblue.android.piccollage.iab.util.f;
import com.cardinalblue.android.piccollage.iab.util.g;
import com.cardinalblue.android.piccollage.model.StickerBundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cardinalblue.android.piccollage.activities:
//            StickersActivity

class a
    implements com.cardinalblue.android.piccollage.iab.util._cls5
{

    final String a;
    final StickersActivity b;

    public void a(e e1, g g1)
    {
        boolean flag;
        Log.v("StickersActivity", (new StringBuilder()).append("Purchase finished: ").append(e1).append(", purchase: ").append(g1).toString());
        while (b.a == null || e1 == null) 
        {
            return;
        }
        if (e1.a() == 7)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!e1.d() || flag) goto _L2; else goto _L1
_L1:
        e1.a();
        JVM INSTR tableswitch 6 6: default 96
    //                   6 128;
           goto _L3 _L4
_L3:
        Log.v("StickersActivity", (new StringBuilder()).append("Error purchasing: ").append(e1).toString());
        return;
_L4:
        ArrayList arraylist = new ArrayList();
        arraylist.add(a);
        b.a.a(true, arraylist, new com.cardinalblue.android.piccollage.iab.util.d.e(g1) {

            final g a;
            final StickersActivity._cls5 b;

            public void a(e e2, f f1)
            {
                Log.v("StickersActivity", "Query inventory finished.");
                if (e2.d())
                {
                    Log.v("StickersActivity", (new StringBuilder()).append("Failed to query inventory: ").append(e2).toString());
                } else
                {
                    Log.v("StickersActivity", "Query inventory was successful.");
                    e2 = f1.a(b.a);
                    if (a != null)
                    {
                        b.b.a.a(e2, null);
                        return;
                    }
                }
            }

            
            {
                b = StickersActivity._cls5.this;
                a = g1;
                super();
            }
        });
        if (true) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            k.a(b, 0x7f0701ef, 0);
        } else
        {
            String s1 = g1.d();
            String s;
            if (b.getIntent().hasExtra("key_purchase_bundle"))
            {
                s = "IAP interstitial";
            } else
            {
                s = "sticker store";
            }
            com.cardinalblue.android.piccollage.a.b.f(s1, s);
        }
        Log.v("StickersActivity", "Purchase successful.");
        (new Handler()).post(new Runnable(g1, e1) {

            final g a;
            final e b;
            final StickersActivity._cls5 c;

            public void run()
            {
                if (a != null)
                {
                    com.cardinalblue.android.piccollage.a.f.a(a.b(), a.c(), a.d(), StickersActivity.c(c.b).d());
                } else
                {
                    com.cardinalblue.android.piccollage.a.f.a(new com.cardinalblue.android.piccollage.model.k.a(b.b()));
                }
                o.a().a(StickersActivity.c(c.b));
            }

            
            {
                c = StickersActivity._cls5.this;
                a = g1;
                b = e1;
                super();
            }
        });
        return;
    }

    _cls2.b(StickersActivity stickersactivity, String s)
    {
        b = stickersactivity;
        a = s;
        super();
    }
}
