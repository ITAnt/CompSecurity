// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class iq
    implements android.os.Parcelable.ClassLoaderCreator
{

    private final ip a;

    public iq(ip ip1)
    {
        a = ip1;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a.a(parcel, null);
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return a.a(parcel, classloader);
    }

    public final Object[] newArray(int i)
    {
        return a.a(i);
    }
}
