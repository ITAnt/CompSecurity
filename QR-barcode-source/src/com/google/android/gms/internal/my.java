// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            mx

public class my
    implements android.os.Parcelable.Creator
{

    public my()
    {
    }

    static void a(mx mx1, Parcel parcel, int i)
    {
        i = b.D(parcel);
        b.a(parcel, 1, mx1.aij, false);
        b.c(parcel, 1000, mx1.versionCode);
        b.a(parcel, 2, mx1.aik, false);
        b.a(parcel, 3, mx1.Dv, false);
        b.H(parcel, i);
    }

    public mx cF(Parcel parcel)
    {
        String s2 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.C(parcel);
        int i = 0;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aD(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;

                case 3: // '\003'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new mx(i, s, s1, s2);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return cF(parcel);
    }

    public mx[] ev(int i)
    {
        return new mx[i];
    }

    public Object[] newArray(int i)
    {
        return ev(i);
    }
}
