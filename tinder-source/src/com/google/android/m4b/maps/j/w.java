// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.m4b.maps.j;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.m4b.maps.k.c;

// Referenced classes of package com.google.android.m4b.maps.j:
//            z

public final class w
    implements c
{

    public static final android.os.Parcelable.Creator CREATOR = new z();
    final int a;
    final Account b;
    final int c;

    w(int i, Account account, int j)
    {
        a = i;
        b = account;
        c = j;
    }

    public w(Account account, int i)
    {
        this(1, account, i);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        z.a(this, parcel, i);
    }

}
