// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p.bq.c;
import p.bq.d;
import p.bq.f;
import p.bq.h;
import p.bq.i;

// Referenced classes of package com.google.android.gms.internal:
//            zzcy, zzcz, zzct

public final class zzcx extends zzcs.zza
{

    private final c zzvc;
    private final i zzvd;

    public zzcx(c c1, i i)
    {
        zzvc = c1;
        zzvd = i;
    }

    private h zzb(String s, int i, String s1)
        throws RemoteException
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        try
        {
            obj = new JSONObject(s);
            s1 = new HashMap(((JSONObject) (obj)).length());
            iterator = ((JSONObject) (obj)).keys();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get MediationServerParameters.", s);
            throw new RemoteException();
        }
        s = s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        s1.put(s, ((JSONObject) (obj)).getString(s));
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_34;
_L2:
        s = new HashMap(0);
_L3:
        obj = zzvc.c();
        s1 = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s1 = (h)((Class) (obj)).newInstance();
        s1.a(s);
        return s1;
    }

    public void destroy()
        throws RemoteException
    {
        try
        {
            zzvc.a();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public zzd getView()
        throws RemoteException
    {
        if (!(zzvc instanceof d))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzan((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzvc.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzd zzd;
        try
        {
            zzd = zze.zzt(((d)zzvc).d());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return zzd;
    }

    public void pause()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void resume()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void showInterstitial()
        throws RemoteException
    {
        if (!(zzvc instanceof f))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzan((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzvc.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Showing interstitial from adapter.");
        try
        {
            ((f)zzvc).d();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, zzct zzct)
        throws RemoteException
    {
        zza(zzd, adrequestparcel, s, null, zzct);
    }

    public void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, String s1, zzct zzct)
        throws RemoteException
    {
        if (!(zzvc instanceof f))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzan((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzvc.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Requesting interstitial ad from adapter.");
        try
        {
            ((f)zzvc).a(new zzcy(zzct), (Activity)zze.zzg(zzd), zzb(s, adrequestparcel.zzpM, s1), com.google.android.gms.internal.zzcz.zzd(adrequestparcel), zzvd);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", zzd);
        }
        throw new RemoteException();
    }

    public void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, zzct zzct)
        throws RemoteException
    {
        zza(zzd, adsizeparcel, adrequestparcel, s, null, zzct);
    }

    public void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, zzct zzct)
        throws RemoteException
    {
        if (!(zzvc instanceof d))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzan((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzvc.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Requesting banner ad from adapter.");
        try
        {
            ((d)zzvc).a(new zzcy(zzct), (Activity)zze.zzg(zzd), zzb(s, adrequestparcel.zzpM, s1), com.google.android.gms.internal.zzcz.zzb(adsizeparcel), com.google.android.gms.internal.zzcz.zzd(adrequestparcel), zzvd);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", zzd);
        }
        throw new RemoteException();
    }
}
