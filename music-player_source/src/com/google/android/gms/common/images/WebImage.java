// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gq;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.images:
//            g

public final class WebImage
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new g();
    private final int a;
    private final Uri b;
    private final int c;
    private final int d;

    WebImage(int i, Uri uri, int j, int k)
    {
        a = i;
        b = uri;
        c = j;
        d = k;
    }

    final int a()
    {
        return a;
    }

    public final Uri b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final int d()
    {
        return d;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof WebImage))
            {
                return false;
            }
            obj = (WebImage)obj;
            if (!gq.a(b, ((WebImage) (obj)).b) || c != ((WebImage) (obj)).c || d != ((WebImage) (obj)).d)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, Integer.valueOf(c), Integer.valueOf(d)
        });
    }

    public final String toString()
    {
        return String.format("Image %dx%d %s", new Object[] {
            Integer.valueOf(c), Integer.valueOf(d), b.toString()
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        g.a(this, parcel, i);
    }

}
