// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hm
    implements android.os.Parcelable.Creator
{

    public hm()
    {
    }

    static void a(hl.a a1, Parcel parcel, int i)
    {
        int j = b.H(parcel);
        b.a(parcel, 1, a1.Dc, i, false);
        b.c(parcel, 1000, a1.CK);
        b.H(parcel, j);
    }

    public hl.a[] N(int i)
    {
        return new hl.a[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return p(parcel);
    }

    public Object[] newArray(int i)
    {
        return N(i);
    }

    public hl.a p(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        Account account = null;
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
                    account = (Account)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Account.CREATOR);
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
                return new hl.a(i, account);
            }
        } while (true);
    }
}
