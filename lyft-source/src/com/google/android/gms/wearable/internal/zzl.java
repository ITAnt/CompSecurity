// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            ChannelImpl

public class zzl
    implements android.os.Parcelable.Creator
{

    public zzl()
    {
    }

    static void a(ChannelImpl channelimpl, Parcel parcel, int i)
    {
        i = zzb.a(parcel);
        zzb.a(parcel, 1, channelimpl.a);
        zzb.a(parcel, 2, channelimpl.c(), false);
        zzb.a(parcel, 3, channelimpl.a(), false);
        zzb.a(parcel, 4, channelimpl.b(), false);
        zzb.a(parcel, i);
    }

    public ChannelImpl a(Parcel parcel)
    {
        String s2 = null;
        int j = zza.b(parcel);
        int i = 0;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = zza.a(parcel);
                switch (zza.a(k))
                {
                default:
                    zza.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = zza.f(parcel, k);
                    break;

                case 2: // '\002'
                    s = zza.m(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = zza.m(parcel, k);
                    break;

                case 4: // '\004'
                    s2 = zza.m(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ChannelImpl(i, s, s1, s2);
            }
        } while (true);
    }

    public ChannelImpl[] a(int i)
    {
        return new ChannelImpl[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
