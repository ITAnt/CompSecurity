// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            a

public final class DeleteRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    final int a;
    private final Credential b;

    DeleteRequest(int i, Credential credential)
    {
        a = i;
        b = credential;
    }

    public Credential a()
    {
        return b;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.auth.api.credentials.internal.a.a(this, parcel, i);
    }

}
