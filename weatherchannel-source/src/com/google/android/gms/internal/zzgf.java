// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzdt, zzbr, zzbz, zzce, 
//            zzge, zzdu, zzgl, zzgk, 
//            zzgh, zzgg, zzfa, zzbu, 
//            zzgz, zzbv, zzhl, zzgj, 
//            zzgw, zzhg, zzcb, zzgi, 
//            zzhc, zzcd

public final class zzgf extends com.google.android.gms.ads.internal.request.zzi.zza
{

    private static zzgf zzDv;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final zzge zzDw;
    private final zzbr zzDx;
    private final zzdt zzqC;

    zzgf(Context context, zzbr zzbr1, zzge zzge1)
    {
        mContext = context;
        zzDw = zzge1;
        zzDx = zzbr1;
        if (context.getApplicationContext() != null)
        {
            context = context.getApplicationContext();
        }
        zzqC = new zzdt(context, new VersionInfoParcel(0x738638, 0x738638, true), zzbr1.zzcW(), new _cls5(), new zzdt.zzc());
    }

    private static AdResponseParcel zza(Context context, zzdt zzdt1, zzbr zzbr1, zzge zzge1, AdRequestInfoParcel adrequestinfoparcel)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Starting ad request from service.");
        zzbz.zzw(context);
        zzce zzce1 = new zzce("load_ad");
        zzcd zzcd = zzce1.zzdo();
        zzge1.zzDs.init();
        Object obj1 = zzo.zzbB().zzC(context);
        if (((zzgk) (obj1)).zzEy == -1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Device is offline.");
            return new AdResponseParcel(2);
        }
        Object obj;
        zzgh zzgh1;
        if (adrequestinfoparcel.versionCode >= 7)
        {
            obj = adrequestinfoparcel.zzCE;
        } else
        {
            obj = UUID.randomUUID().toString();
        }
        zzgh1 = new zzgh(((String) (obj)), adrequestinfoparcel.applicationInfo.packageName);
        if (adrequestinfoparcel.zzCm.extras != null)
        {
            String s = adrequestinfoparcel.zzCm.extras.getString("_ad");
            if (s != null)
            {
                return zzgg.zza(context, adrequestinfoparcel, s);
            }
        }
        android.location.Location location = zzge1.zzDs.zzc(250L);
        String s1 = zzge1.zzDt.zzc(context, adrequestinfoparcel.zzCn.packageName);
        List list = zzge1.zzDr.zza(adrequestinfoparcel);
        obj1 = zzgg.zza(adrequestinfoparcel, ((zzgk) (obj1)), location, zzbr1, s1, zzge1.zzDu.zzar(adrequestinfoparcel.zzCo), list);
        if (adrequestinfoparcel.versionCode < 7)
        {
            try
            {
                ((JSONObject) (obj1)).put("request_id", obj);
            }
            catch (JSONException jsonexception) { }
        }
        if (obj1 == null)
        {
            return new AdResponseParcel(0);
        }
        obj = ((JSONObject) (obj1)).toString();
        zzce1.zza(zzcd, new String[] {
            "arc"
        });
        obj1 = zzce1.zzdo();
        if (((Boolean)zzbz.zztE.get()).booleanValue())
        {
            zzhl.zzGk.post(new _cls1(zzdt1, zzgh1, zzce1, ((zzcd) (obj1)), ((String) (obj))));
        } else
        {
            zzhl.zzGk.post(new _cls2(context, adrequestinfoparcel, zzgh1, zzce1, ((zzcd) (obj1)), ((String) (obj)), zzbr1));
        }
        zzbr1 = (zzgj)zzgh1.zzfE().get(10L, TimeUnit.SECONDS);
        if (zzbr1 != null)
        {
            break MISSING_BLOCK_LABEL_443;
        }
        context = new AdResponseParcel(0);
        zzhl.zzGk.post(new _cls3(zzgh1));
        return context;
        context;
        context = new AdResponseParcel(0);
        zzhl.zzGk.post(new _cls3(zzgh1));
        return context;
        if (zzbr1.getErrorCode() == -2)
        {
            break MISSING_BLOCK_LABEL_482;
        }
        context = new AdResponseParcel(zzbr1.getErrorCode());
        zzhl.zzGk.post(new _cls3(zzgh1));
        return context;
        if (zzce1.zzds() != null)
        {
            zzce1.zza(zzce1.zzds(), new String[] {
                "rur"
            });
        }
        zzdt1 = null;
        if (zzbr1.zzfI())
        {
            zzdt1 = zzge1.zzDq.zzaq(adrequestinfoparcel.zzCn.packageName);
        }
        obj = zzce1.zzdo();
        zzdt1 = zza(adrequestinfoparcel, context, adrequestinfoparcel.zzpJ.zzGG, zzbr1.getUrl(), ((String) (zzdt1)), s1, ((zzgj) (zzbr1)));
        if (((AdResponseParcel) (zzdt1)).zzCW == 1)
        {
            zzge1.zzDt.clearToken(context, adrequestinfoparcel.zzCn.packageName);
        }
        zzce1.zza(((zzcd) (obj)), new String[] {
            "ufe"
        });
        zzce1.zza(zzcd, new String[] {
            "tts"
        });
        if (zzhg.zzfY() != null)
        {
            zzhg.zzfY().zza(zzce1);
        }
        zzhl.zzGk.post(new _cls3(zzgh1));
        return zzdt1;
        context;
        zzhl.zzGk.post(new _cls3(zzgh1));
        throw context;
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adrequestinfoparcel, Context context, String s, String s1, String s2, String s3, zzgj zzgj1)
    {
        zzgi zzgi1;
        byte abyte0[];
        Map map;
        BufferedOutputStream bufferedoutputstream;
        int i;
        int j;
        long l;
        try
        {
            zzgi1 = new zzgi(adrequestinfoparcel);
            com.google.android.gms.ads.internal.util.client.zzb.zzay((new StringBuilder()).append("AdRequestServiceImpl: Sending request: ").append(s1).toString());
            adrequestinfoparcel = new URL(s1);
            l = SystemClock.elapsedRealtime();
        }
        // Misplaced declaration of an exception variable
        catch (AdRequestInfoParcel adrequestinfoparcel)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC((new StringBuilder()).append("Error while connecting to ad server: ").append(adrequestinfoparcel.getMessage()).toString());
            return new AdResponseParcel(2);
        }
        i = 0;
        s1 = (HttpURLConnection)adrequestinfoparcel.openConnection();
        zzo.zzbv().zza(context, s, false, s1);
        if (!TextUtils.isEmpty(s2))
        {
            s1.addRequestProperty("x-afma-drt-cookie", s2);
        }
        if (!TextUtils.isEmpty(s3))
        {
            s1.addRequestProperty("Authorization", (new StringBuilder()).append("Bearer ").append(s3).toString());
        }
        if (zzgj1 == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (!TextUtils.isEmpty(zzgj1.zzfH()))
        {
            s1.setDoOutput(true);
            abyte0 = zzgj1.zzfH().getBytes();
            s1.setFixedLengthStreamingMode(abyte0.length);
            bufferedoutputstream = new BufferedOutputStream(s1.getOutputStream());
            bufferedoutputstream.write(abyte0);
            bufferedoutputstream.close();
        }
        j = s1.getResponseCode();
        map = s1.getHeaderFields();
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        adrequestinfoparcel = adrequestinfoparcel.toString();
        context = zzo.zzbv().zza(new InputStreamReader(s1.getInputStream()));
        zza(((String) (adrequestinfoparcel)), map, ((String) (context)), j);
        zzgi1.zza(adrequestinfoparcel, map, context);
        adrequestinfoparcel = zzgi1.zzj(l);
        s1.disconnect();
        return adrequestinfoparcel;
        zza(adrequestinfoparcel.toString(), map, null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        adrequestinfoparcel = s1.getHeaderField("Location");
        if (!TextUtils.isEmpty(adrequestinfoparcel))
        {
            break MISSING_BLOCK_LABEL_331;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("No location header to follow redirect.");
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        adrequestinfoparcel = new URL(adrequestinfoparcel);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Too many redirects.");
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        com.google.android.gms.ads.internal.util.client.zzb.zzaC((new StringBuilder()).append("Received error HTTP response code: ").append(j).toString());
        adrequestinfoparcel = new AdResponseParcel(0);
        s1.disconnect();
        return adrequestinfoparcel;
        zzgi1.zzi(map);
        s1.disconnect();
        break MISSING_BLOCK_LABEL_50;
        adrequestinfoparcel;
        s1.disconnect();
        throw adrequestinfoparcel;
    }

    public static zzgf zza(Context context, zzbr zzbr1, zzge zzge1)
    {
        Object obj = zzoW;
        obj;
        JVM INSTR monitorenter ;
        if (zzDv != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Context context1 = context;
        if (context.getApplicationContext() != null)
        {
            context1 = context.getApplicationContext();
        }
        zzDv = new zzgf(context1, zzbr1, zzge1);
        context = zzDv;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static zzie.zza zza(String s, zzce zzce1, zzcd zzcd)
    {
        return new _cls4(zzce1, zzcd, s);
    }

    private static void zza(String s, Map map, String s1, int i)
    {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB((new StringBuilder()).append("Http Response: {\n  URL:\n    ").append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB((new StringBuilder()).append("    ").append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB((new StringBuilder()).append("      ").append(s2).toString());
                    }
                }

            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB((new StringBuilder()).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    static zzie.zza zzb(String s, zzce zzce1, zzcd zzcd)
    {
        return zza(s, zzce1, zzcd);
    }

    public void zza(AdRequestInfoParcel adrequestinfoparcel, zzj zzj)
    {
        zzo.zzby().zzb(mContext, adrequestinfoparcel.zzpJ);
        (new _cls6(adrequestinfoparcel, zzj)).zzgi();
    }

    public AdResponseParcel zze(AdRequestInfoParcel adrequestinfoparcel)
    {
        zzhg.zze(mContext, adrequestinfoparcel.zzpJ.zzGG);
        return zza(mContext, zzqC, zzDx, zzDw, adrequestinfoparcel);
    }


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls6 {}

}
