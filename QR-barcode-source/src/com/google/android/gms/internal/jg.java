// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            jf

public class jg
    implements android.os.Parcelable.Creator
{

    public jg()
    {
    }

    static void a(jf jf1, Parcel parcel, int i)
    {
        i = b.D(parcel);
        b.c(parcel, 1, jf1.getVersionCode());
        b.c(parcel, 2, jf1.hc(), false);
        b.H(parcel, i);
    }

    public jf G(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.C(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, k, jf.a.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new jf(i, arraylist);
            }
        } while (true);
    }

    public jf[] aG(int i)
    {
        return new jf[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return G(parcel);
    }

    public Object[] newArray(int i)
    {
        return aG(i);
    }
}
