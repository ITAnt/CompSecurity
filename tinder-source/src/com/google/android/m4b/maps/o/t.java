// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.m4b.maps.o;

import android.location.Location;
import android.os.Parcel;
import com.google.android.m4b.maps.k.a;
import com.google.android.m4b.maps.k.b;

// Referenced classes of package com.google.android.m4b.maps.o:
//            r

public final class t
    implements android.os.Parcelable.Creator
{

    public t()
    {
    }

    static void a(r r1, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        b.a(parcel, 1, r1.c);
        b.b(parcel, 1000, r1.b);
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = com.google.android.m4b.maps.k.a.a(parcel);
        int i = 0;
        Object obj = com.google.android.m4b.maps.o.r.a;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.m4b.maps.k.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    obj = com.google.android.m4b.maps.k.a.c(parcel, k, Location.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.m4b.maps.k.a.e(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.m4b.maps.k.a.a((new StringBuilder(37)).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new r(i, ((java.util.List) (obj)));
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new r[i];
    }
}
