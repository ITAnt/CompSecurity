// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zza;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            j, zzdf

class ce extends j
{

    private static final String a;
    private final Context b;

    public ce(Context context)
    {
        super(a, new String[0]);
        b = context;
    }

    public com.google.android.gms.internal.zzd.zza zzD(Map map)
    {
        return zzdf.zzE(b.getPackageName());
    }

    public boolean zzwn()
    {
        return true;
    }

    static 
    {
        a = zza.zzw.toString();
    }
}
