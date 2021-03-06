// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

// Referenced classes of package com.google.ads.mediation.customevent:
//            CustomEventBanner, CustomEventInterstitial, CustomEventServerParameters, CustomEventBannerListener, 
//            CustomEventInterstitialListener

public final class CustomEventAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{
    static final class zza
        implements CustomEventBannerListener
    {

        private final CustomEventAdapter zzbb;
        private final MediationBannerListener zzbc;

        public void onClick()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            zzbc.onClick(zzbb);
        }

        public void onDismissScreen()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            zzbc.onDismissScreen(zzbb);
        }

        public void onFailedToReceiveAd()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            zzbc.onFailedToReceiveAd(zzbb, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            zzbc.onLeaveApplication(zzbb);
        }

        public void onPresentScreen()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            zzbc.onPresentScreen(zzbb);
        }

        public void onReceivedAd(View view)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onReceivedAd.");
            CustomEventAdapter.zza(zzbb, view);
            zzbc.onReceivedAd(zzbb);
        }

        public zza(CustomEventAdapter customeventadapter, MediationBannerListener mediationbannerlistener)
        {
            zzbb = customeventadapter;
            zzbc = mediationbannerlistener;
        }
    }

    class zzb
        implements CustomEventInterstitialListener
    {

        private final CustomEventAdapter zzbb;
        private final MediationInterstitialListener zzbd;
        final CustomEventAdapter zzbe;

        public void onDismissScreen()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onDismissScreen.");
            zzbd.onDismissScreen(zzbb);
        }

        public void onFailedToReceiveAd()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onFailedToReceiveAd.");
            zzbd.onFailedToReceiveAd(zzbb, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onLeaveApplication.");
            zzbd.onLeaveApplication(zzbb);
        }

        public void onPresentScreen()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onPresentScreen.");
            zzbd.onPresentScreen(zzbb);
        }

        public void onReceivedAd()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Custom event adapter called onReceivedAd.");
            zzbd.onReceivedAd(zzbe);
        }

        public zzb(CustomEventAdapter customeventadapter1, MediationInterstitialListener mediationinterstitiallistener)
        {
            zzbe = CustomEventAdapter.this;
            super();
            zzbb = customeventadapter1;
            zzbd = mediationinterstitiallistener;
        }
    }


    private View zzaY;
    CustomEventBanner zzaZ;
    CustomEventInterstitial zzba;

    public CustomEventAdapter()
    {
    }

    private void zza(View view)
    {
        zzaY = view;
    }

    static void zza(CustomEventAdapter customeventadapter, View view)
    {
        customeventadapter.zza(view);
    }

    private static Object zzj(String s)
    {
        Object obj;
        try
        {
            obj = Class.forName(s).newInstance();
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE((new StringBuilder()).append("Could not instantiate custom event adapter: ").append(s).append(". ").append(throwable.getMessage()).toString());
            return null;
        }
        return obj;
    }

    public void destroy()
    {
        if (zzaZ != null)
        {
            zzaZ.destroy();
        }
        if (zzba != null)
        {
            zzba.destroy();
        }
    }

    public Class getAdditionalParametersType()
    {
        return com/google/android/gms/ads/mediation/customevent/CustomEventExtras;
    }

    public View getBannerView()
    {
        return zzaY;
    }

    public Class getServerParametersType()
    {
        return com/google/ads/mediation/customevent/CustomEventServerParameters;
    }

    public volatile void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, MediationServerParameters mediationserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestBannerAd(mediationbannerlistener, activity, (CustomEventServerParameters)mediationserverparameters, adsize, mediationadrequest, (CustomEventExtras)networkextras);
    }

    public void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, CustomEventServerParameters customeventserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, CustomEventExtras customeventextras)
    {
        zzaZ = (CustomEventBanner)zzj(customeventserverparameters.className);
        if (zzaZ == null)
        {
            mediationbannerlistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customeventextras == null)
        {
            customeventextras = null;
        } else
        {
            customeventextras = ((CustomEventExtras) (customeventextras.getExtra(customeventserverparameters.label)));
        }
        zzaZ.requestBannerAd(new zza(this, mediationbannerlistener), activity, customeventserverparameters.label, customeventserverparameters.parameter, adsize, mediationadrequest, customeventextras);
    }

    public volatile void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, MediationServerParameters mediationserverparameters, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestInterstitialAd(mediationinterstitiallistener, activity, (CustomEventServerParameters)mediationserverparameters, mediationadrequest, (CustomEventExtras)networkextras);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, CustomEventServerParameters customeventserverparameters, MediationAdRequest mediationadrequest, CustomEventExtras customeventextras)
    {
        zzba = (CustomEventInterstitial)zzj(customeventserverparameters.className);
        if (zzba == null)
        {
            mediationinterstitiallistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customeventextras == null)
        {
            customeventextras = null;
        } else
        {
            customeventextras = ((CustomEventExtras) (customeventextras.getExtra(customeventserverparameters.label)));
        }
        zzba.requestInterstitialAd(zza(mediationinterstitiallistener), activity, customeventserverparameters.label, customeventserverparameters.parameter, mediationadrequest, customeventextras);
    }

    public void showInterstitial()
    {
        zzba.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationinterstitiallistener)
    {
        return new zzb(this, mediationinterstitiallistener);
    }
}
