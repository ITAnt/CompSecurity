// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.appconfig;

import android.os.Parcel;

// Referenced classes of package com.facebook.appconfig:
//            AppConfig

final class a
    implements android.os.Parcelable.Creator
{

    a()
    {
    }

    public AppConfig a(Parcel parcel)
    {
        return new AppConfig(parcel);
    }

    public AppConfig[] a(int i)
    {
        return new AppConfig[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
