// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gtalkservice;

import android.os.Parcel;

// Referenced classes of package com.google.android.gtalkservice:
//            Presence

final class d
    implements android.os.Parcelable.Creator
{

    d()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new Presence(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new Presence[i];
    }
}
