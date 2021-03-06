// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.y;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.maps.model:
//            n, StreetViewPanoramaOrientation

public class StreetViewPanoramaCamera
    implements SafeParcelable
{

    public static final n CREATOR = new n();
    public final float a;
    public final float b;
    public final float c;
    private final int d;
    private StreetViewPanoramaOrientation e;

    StreetViewPanoramaCamera(int i, float f, float f1, float f2)
    {
        float f3;
        StreetViewPanoramaOrientation.a a1;
        boolean flag;
        if (-90F <= f1 && f1 <= 90F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        y.b(flag, "Tilt needs to be between -90 and 90 inclusive");
        d = i;
        f3 = f;
        if ((double)f <= 0.0D)
        {
            f3 = 0.0F;
        }
        a = f3;
        b = f1 + 0.0F;
        if ((double)f2 <= 0.0D)
        {
            f = f2 % 360F + 360F;
        } else
        {
            f = f2;
        }
        c = f % 360F;
        a1 = new StreetViewPanoramaOrientation.a();
        a1.b = f1;
        a1.a = f2;
        e = new StreetViewPanoramaOrientation(a1.b, a1.a);
    }

    final int a()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof StreetViewPanoramaCamera))
            {
                return false;
            }
            obj = (StreetViewPanoramaCamera)obj;
            if (Float.floatToIntBits(a) != Float.floatToIntBits(((StreetViewPanoramaCamera) (obj)).a) || Float.floatToIntBits(b) != Float.floatToIntBits(((StreetViewPanoramaCamera) (obj)).b) || Float.floatToIntBits(c) != Float.floatToIntBits(((StreetViewPanoramaCamera) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Float.valueOf(a), Float.valueOf(b), Float.valueOf(c)
        });
    }

    public String toString()
    {
        return x.a(this).a("zoom", Float.valueOf(a)).a("tilt", Float.valueOf(b)).a("bearing", Float.valueOf(c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        n.a(this, parcel);
    }

}
