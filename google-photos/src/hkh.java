// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import java.util.Locale;

public final class hkh
    implements ekf
{

    public static final android.os.Parcelable.Creator CREATOR = new hki();
    public final diy a;

    hkh(Parcel parcel)
    {
        a = (diy)parcel.readParcelable(diy.getClassLoader());
    }

    public hkh(diy diy1)
    {
        a = (diy)p.b(diy1, "contributor must be non-null");
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return String.format(Locale.US, "ContributorFeature {contributor: %s}", new Object[] {
            a
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, i);
    }

}
