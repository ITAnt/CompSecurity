// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            hi, hq

public class hj
    implements android.os.Parcelable.Creator
{

    public hj()
    {
    }

    static void a(hi hi1, Parcel parcel, int i)
    {
        int j = b.D(parcel);
        b.a(parcel, 1, hi1.Ce, false);
        b.c(parcel, 1000, hi1.BR);
        b.a(parcel, 3, hi1.Cf, i, false);
        b.c(parcel, 4, hi1.Cg);
        b.a(parcel, 5, hi1.Ch, false);
        b.H(parcel, j);
    }

    public hi[] K(int i)
    {
        return new hi[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return n(parcel);
    }

    public hi n(Parcel parcel)
    {
        byte abyte0[] = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.C(parcel);
        int j = 0;
        int i = -1;
        hq hq1 = null;
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 3: // '\003'
                    hq1 = (hq)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, hq.CREATOR);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 5: // '\005'
                    abyte0 = com.google.android.gms.common.internal.safeparcel.a.r(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new hi(j, s, hq1, i, abyte0);
            }
        } while (true);
    }

    public Object[] newArray(int i)
    {
        return K(i);
    }
}
