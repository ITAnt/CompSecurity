// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            e

public class PlayLoggerContext
    implements SafeParcelable
{

    public static final e CREATOR = new e();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final int j;

    public PlayLoggerContext(int k, String s, int l, int i1, String s1, String s2, boolean flag, 
            String s3, boolean flag1, int j1)
    {
        a = k;
        b = s;
        c = l;
        d = i1;
        e = s1;
        f = s2;
        g = flag;
        h = s3;
        i = flag1;
        j = j1;
    }

    public PlayLoggerContext(String s, int k, int l)
    {
        a = 1;
        b = (String)zzx.zzv(s);
        c = k;
        d = 10;
        h = null;
        e = null;
        f = null;
        g = true;
        i = false;
        j = 0;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof PlayLoggerContext)
            {
                if (a != ((PlayLoggerContext) (obj = (PlayLoggerContext)obj)).a || !b.equals(((PlayLoggerContext) (obj)).b) || c != ((PlayLoggerContext) (obj)).c || d != ((PlayLoggerContext) (obj)).d || !zzw.equal(h, ((PlayLoggerContext) (obj)).h) || !zzw.equal(e, ((PlayLoggerContext) (obj)).e) || !zzw.equal(f, ((PlayLoggerContext) (obj)).f) || g != ((PlayLoggerContext) (obj)).g || i != ((PlayLoggerContext) (obj)).i || j != ((PlayLoggerContext) (obj)).j)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(a), b, Integer.valueOf(c), Integer.valueOf(d), h, e, f, Boolean.valueOf(g), Boolean.valueOf(i), Integer.valueOf(j)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("PlayLoggerContext[");
        stringbuilder.append("versionCode=").append(a).append(',');
        stringbuilder.append("package=").append(b).append(',');
        stringbuilder.append("packageVersionCode=").append(c).append(',');
        stringbuilder.append("logSource=").append(d).append(',');
        stringbuilder.append("logSourceName=").append(h).append(',');
        stringbuilder.append("uploadAccount=").append(e).append(',');
        stringbuilder.append("loggingId=").append(f).append(',');
        stringbuilder.append("logAndroidId=").append(g).append(',');
        stringbuilder.append("isAnonymous=").append(i).append(',');
        stringbuilder.append("qosTier=").append(j);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        com.google.android.gms.playlog.internal.e.a(this, parcel);
    }

}
