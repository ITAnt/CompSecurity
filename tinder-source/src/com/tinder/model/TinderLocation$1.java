// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tinder.model;

import android.os.Parcel;

// Referenced classes of package com.tinder.model:
//            TinderLocation

static final class 
    implements android.os.r
{

    public final TinderLocation createFromParcel(Parcel parcel)
    {
        return new TinderLocation(parcel);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final TinderLocation[] newArray(int i)
    {
        return new TinderLocation[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
