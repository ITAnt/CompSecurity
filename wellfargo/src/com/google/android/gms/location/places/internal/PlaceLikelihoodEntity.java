// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            c, PlaceImpl

public class PlaceLikelihoodEntity
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new c();
    final int a;
    final PlaceImpl b;
    final float c;

    PlaceLikelihoodEntity(int i, PlaceImpl placeimpl, float f)
    {
        a = i;
        b = placeimpl;
        c = f;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceLikelihoodEntity))
            {
                return false;
            }
            obj = (PlaceLikelihoodEntity)obj;
            if (!b.equals(((PlaceLikelihoodEntity) (obj)).b) || c != ((PlaceLikelihoodEntity) (obj)).c)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ar.a(new Object[] {
            b, Float.valueOf(c)
        });
    }

    public String toString()
    {
        return ar.a(this).a("place", b).a("likelihood", Float.valueOf(c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.location.places.internal.c.a(this, parcel, i);
    }

}
