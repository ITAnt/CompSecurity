// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotContentsEntity

public class SnapshotContentsEntityCreator
    implements android.os.Parcelable.Creator
{

    public SnapshotContentsEntityCreator()
    {
    }

    static void zza(SnapshotContentsEntity snapshotcontentsentity, Parcel parcel, int i)
    {
        int j = zzb.zzac(parcel);
        zzb.zza(parcel, 1, snapshotcontentsentity.zzpe(), i, false);
        zzb.zzc(parcel, 1000, snapshotcontentsentity.getVersionCode());
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdR(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgb(i);
    }

    public SnapshotContentsEntity zzdR(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        Contents contents = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    contents = (Contents)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Contents.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SnapshotContentsEntity(i, contents);
            }
        } while (true);
    }

    public SnapshotContentsEntity[] zzgb(int i)
    {
        return new SnapshotContentsEntity[i];
    }
}
