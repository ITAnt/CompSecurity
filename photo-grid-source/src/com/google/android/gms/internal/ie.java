// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            id, il

public final class ie
{

    public final List a;
    public final long b;
    public final List c;
    public final List d;
    public final List e;
    public final String f;
    public final long g;
    public final String h;
    public final int i;
    public int j;
    public int k;

    public ie(String s)
    {
        s = new JSONObject(s);
        if (zzb.zzN(2))
        {
            zzb.v((new StringBuilder("Mediation Response JSON: ")).append(s.toString(2)).toString());
        }
        JSONArray jsonarray = s.getJSONArray("ad_networks");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        int i1 = -1;
        for (int l = 0; l < jsonarray.length();)
        {
            id id1 = new id(jsonarray.getJSONObject(l));
            arraylist.add(id1);
            int j1 = i1;
            if (i1 < 0)
            {
                j1 = i1;
                if (a(id1))
                {
                    j1 = l;
                }
            }
            l++;
            i1 = j1;
        }

        j = i1;
        k = jsonarray.length();
        a = Collections.unmodifiableList(arraylist);
        f = s.getString("qdata");
        s = s.optJSONObject("settings");
        if (s != null)
        {
            b = s.optLong("ad_network_timeout_millis", -1L);
            zzp.zzbH();
            c = il.a(s, "click_urls");
            zzp.zzbH();
            d = il.a(s, "imp_urls");
            zzp.zzbH();
            e = il.a(s, "nofill_urls");
            long l1 = s.optLong("refresh", -1L);
            if (l1 > 0L)
            {
                l1 *= 1000L;
            } else
            {
                l1 = -1L;
            }
            g = l1;
            s = s.optJSONArray("rewards");
            if (s == null || s.length() == 0)
            {
                h = null;
                i = 0;
                return;
            } else
            {
                h = s.getJSONObject(0).optString("rb_type");
                i = s.getJSONObject(0).optInt("rb_amount");
                return;
            }
        } else
        {
            b = -1L;
            c = null;
            d = null;
            e = null;
            g = -1L;
            h = null;
            i = 0;
            return;
        }
    }

    private static boolean a(id id1)
    {
        for (id1 = id1.c.iterator(); id1.hasNext();)
        {
            if (((String)id1.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"))
            {
                return true;
            }
        }

        return false;
    }
}
