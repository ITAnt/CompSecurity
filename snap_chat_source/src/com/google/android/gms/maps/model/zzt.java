// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            StreetViewPanoramaOrientation

public class zzt
    implements android.os.Parcelable.Creator
{

    public zzt()
    {
    }

    static void zza(StreetViewPanoramaOrientation streetviewpanoramaorientation, Parcel parcel, int i)
    {
        i = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, streetviewpanoramaorientation.getVersionCode());
        zzb.zza(parcel, 2, streetviewpanoramaorientation.tilt);
        zzb.zza(parcel, 3, streetviewpanoramaorientation.bearing);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzed(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgg(i);
    }

    public StreetViewPanoramaOrientation zzed(Parcel parcel)
    {
        float f1 = 0.0F;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        float f = 0.0F;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, k);
                    break;

                case 3: // '\003'
                    f1 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaOrientation(i, f, f1);
            }
        } while (true);
    }

    public StreetViewPanoramaOrientation[] zzgg(int i)
    {
        return new StreetViewPanoramaOrientation[i];
    }
}
