// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class gd
    implements android.os.Parcelable.Creator
{

    public gd()
    {
    }

    static void a(fv.f f, Parcel parcel, int i)
    {
        i = b.k(parcel);
        Set set = f.di();
        if (set.contains(Integer.valueOf(1)))
        {
            b.c(parcel, 1, f.getVersionCode());
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.a(parcel, 2, f.getDepartment(), true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.a(parcel, 3, f.getDescription(), true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            b.a(parcel, 4, f.getEndDate(), true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            b.a(parcel, 5, f.getLocation(), true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            b.a(parcel, 6, f.getName(), true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            b.a(parcel, 7, f.isPrimary());
        }
        if (set.contains(Integer.valueOf(8)))
        {
            b.a(parcel, 8, f.getStartDate(), true);
        }
        if (set.contains(Integer.valueOf(9)))
        {
            b.a(parcel, 9, f.getTitle(), true);
        }
        if (set.contains(Integer.valueOf(10)))
        {
            b.c(parcel, 10, f.getType());
        }
        b.C(parcel, i);
    }

    public fv.f K(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.j(parcel);
        HashSet hashset = new HashSet();
        String s1 = null;
        boolean flag = false;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.i(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.y(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    s6 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    hashset.add(Integer.valueOf(7));
                    break;

                case 8: // '\b'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(8));
                    break;

                case 9: // '\t'
                    s = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    hashset.add(Integer.valueOf(9));
                    break;

                case 10: // '\n'
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    hashset.add(Integer.valueOf(10));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != k)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
                }
                return new fv.f(hashset, j, s6, s5, s4, s3, s2, flag, s1, s, i);
            }
        } while (true);
    }

    public fv.f[] ap(int i)
    {
        return new fv.f[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return K(parcel);
    }

    public Object[] newArray(int i)
    {
        return ap(i);
    }
}
