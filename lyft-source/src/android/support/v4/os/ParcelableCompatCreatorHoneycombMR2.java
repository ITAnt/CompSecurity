// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.os;

import android.os.Parcel;

// Referenced classes of package android.support.v4.os:
//            ParcelableCompatCreatorCallbacks

class ParcelableCompatCreatorHoneycombMR2
    implements android.os.Parcelable.ClassLoaderCreator
{

    private final ParcelableCompatCreatorCallbacks a;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks parcelablecompatcreatorcallbacks)
    {
        a = parcelablecompatcreatorcallbacks;
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a.a(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classloader)
    {
        return a.a(parcel, classloader);
    }

    public Object[] newArray(int i)
    {
        return a.a(i);
    }
}
