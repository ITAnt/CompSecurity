// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnSyncMoreResponseCreator

public class OnSyncMoreResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new OnSyncMoreResponseCreator();
    final boolean mMoreEntriesMayExist;
    final int mVersionCode;

    OnSyncMoreResponse(int i, boolean flag)
    {
        mVersionCode = i;
        mMoreEntriesMayExist = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        OnSyncMoreResponseCreator.writeToParcel$e884fb9(this, parcel);
    }

}
