// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.auth.api.proxy:
//            ProxyResponse

public final class c
    implements android.os.Parcelable.Creator
{

    public c()
    {
    }

    static void a(ProxyResponse proxyresponse, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, 1, proxyresponse.b);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, 1000, proxyresponse.a);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, proxyresponse.c, i);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, 3, proxyresponse.d);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 4, proxyresponse.e);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 5, proxyresponse.f);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        byte abyte0[] = null;
        int i = 0;
        int l = zza.a(parcel);
        android.os.Bundle bundle = null;
        PendingIntent pendingintent = null;
        int j = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    zza.b(parcel, i1);
                    break;

                case 1: // '\001'
                    j = zza.e(parcel, i1);
                    break;

                case 1000: 
                    k = zza.e(parcel, i1);
                    break;

                case 2: // '\002'
                    pendingintent = (PendingIntent)zza.a(parcel, i1, PendingIntent.CREATOR);
                    break;

                case 3: // '\003'
                    i = zza.e(parcel, i1);
                    break;

                case 4: // '\004'
                    bundle = zza.n(parcel, i1);
                    break;

                case 5: // '\005'
                    abyte0 = zza.o(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new ProxyResponse(k, j, pendingintent, i, bundle, abyte0);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ProxyResponse[i];
    }
}
