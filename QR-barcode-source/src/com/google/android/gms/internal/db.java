// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            ay, av

public final class db
{

    public static int a(com.google.ads.AdRequest.ErrorCode errorcode)
    {
        static class _cls1
        {

            static final int qK[];
            static final int qL[];

            static 
            {
                qL = new int[com.google.ads.AdRequest.ErrorCode.values().length];
                try
                {
                    qL[com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    qL[com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    qL[com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    qL[com.google.ads.AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                qK = new int[com.google.ads.AdRequest.Gender.values().length];
                try
                {
                    qK[com.google.ads.AdRequest.Gender.FEMALE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    qK[com.google.ads.AdRequest.Gender.MALE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    qK[com.google.ads.AdRequest.Gender.UNKNOWN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.qL[errorcode.ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;
        }
    }

    public static AdSize b(ay ay1)
    {
        int i = 0;
        AdSize aadsize[] = new AdSize[6];
        aadsize[0] = AdSize.SMART_BANNER;
        aadsize[1] = AdSize.BANNER;
        aadsize[2] = AdSize.IAB_MRECT;
        aadsize[3] = AdSize.IAB_BANNER;
        aadsize[4] = AdSize.IAB_LEADERBOARD;
        aadsize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
        for (; i < aadsize.length; i++)
        {
            if (aadsize[i].getWidth() == ay1.width && aadsize[i].getHeight() == ay1.height)
            {
                return aadsize[i];
            }
        }

        return new AdSize(com.google.android.gms.ads.a.a(ay1.width, ay1.height, ay1.of));
    }

    public static MediationAdRequest d(av av1)
    {
        HashSet hashset;
        if (av1.nV != null)
        {
            hashset = new HashSet(av1.nV);
        } else
        {
            hashset = null;
        }
        return new MediationAdRequest(new Date(av1.nT), k(av1.nU), hashset, av1.nW, av1.ob);
    }

    public static com.google.ads.AdRequest.Gender k(int i)
    {
        switch (i)
        {
        default:
            return com.google.ads.AdRequest.Gender.UNKNOWN;

        case 2: // '\002'
            return com.google.ads.AdRequest.Gender.FEMALE;

        case 1: // '\001'
            return com.google.ads.AdRequest.Gender.MALE;
        }
    }
}
