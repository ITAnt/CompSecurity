// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznd, zzmb, zzng, zzmm

class eApiClient extends c
{

    final DataType zzalk;
    final zznd zzalo;

    protected volatile void zza(com.google.android.gms.common.api.ent ent)
        throws RemoteException
    {
        zza((zzmb)ent);
    }

    protected void zza(zzmb zzmb1)
        throws RemoteException
    {
        zzng zzng1 = new zzng(this);
        String s = zzmb1.getContext().getPackageName();
        ((zzmm)zzmb1.zznM()).zza(new UnsubscribeRequest(zzalk, null, zzng1, s));
    }

    eApiClient(zznd zznd1, GoogleApiClient googleapiclient, DataType datatype)
    {
        zzalo = zznd1;
        zzalk = datatype;
        super(googleapiclient);
    }
}
