// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;

// Referenced classes of package com.google.ads.mediation:
//            AbstractAdViewAdapter

public final class AdUrlAdapter extends AbstractAdViewAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{

    public AdUrlAdapter()
    {
    }

    public final String getAdUnitId(Bundle bundle)
    {
        return "adurl";
    }

    protected final Bundle zza(Bundle bundle, Bundle bundle1)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle1);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }
}
