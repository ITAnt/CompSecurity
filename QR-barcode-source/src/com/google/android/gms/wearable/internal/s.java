// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.c;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            r

public class s
    implements android.os.Parcelable.Creator
{

    public s()
    {
    }

    static void a(r r1, Parcel parcel, int i)
    {
        int j = b.D(parcel);
        b.c(parcel, 1, r1.versionCode);
        b.c(parcel, 2, r1.statusCode);
        b.a(parcel, 3, r1.avx, i, false);
        b.H(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return dW(parcel);
    }

    public r dW(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.C(parcel);
        c c1 = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aD(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 3: // '\003'
                    c1 = (c)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, c.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new r(i, j, c1);
            }
        } while (true);
    }

    public r[] fZ(int i)
    {
        return new r[i];
    }

    public Object[] newArray(int i)
    {
        return fZ(i);
    }
}
