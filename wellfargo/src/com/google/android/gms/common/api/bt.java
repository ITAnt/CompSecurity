// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.d;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            bp

class bt
    implements Runnable
{

    final bp a;
    private final int b;
    private final ConnectionResult c;

    public bt(bp bp1, int i, ConnectionResult connectionresult)
    {
        a = bp1;
        super();
        b = i;
        c = connectionresult;
    }

    public void run()
    {
        if (c.a())
        {
            try
            {
                int i = a.getActivity().getSupportFragmentManager().getFragments().indexOf(a);
                c.a(a.getActivity(), (i + 1 << 16) + 1);
                return;
            }
            catch (android.content.IntentSender.SendIntentException sendintentexception)
            {
                bp.a(a);
            }
            return;
        }
        if (d.b(c.c()))
        {
            d.a(c.c(), a.getActivity(), a, 2, a);
            return;
        } else
        {
            bp.a(a, b, c);
            return;
        }
    }
}
