// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;

// Referenced classes of package com.google.android.gms.games.internal.request:
//            GameRequestCluster

public class GameRequestClusterCreator
    implements android.os.Parcelable.Creator
{

    public GameRequestClusterCreator()
    {
    }

    static void a(GameRequestCluster gamerequestcluster, Parcel parcel, int i)
    {
        i = b.H(parcel);
        b.c(parcel, 1, gamerequestcluster.mD(), false);
        b.c(parcel, 1000, gamerequestcluster.getVersionCode());
        b.H(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return cy(parcel);
    }

    public GameRequestCluster cy(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, GameRequestEntity.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new GameRequestCluster(i, arraylist);
            }
        } while (true);
    }

    public GameRequestCluster[] ej(int i)
    {
        return new GameRequestCluster[i];
    }

    public Object[] newArray(int i)
    {
        return ej(i);
    }
}
