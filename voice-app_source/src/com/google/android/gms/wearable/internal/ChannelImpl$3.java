// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            zzf, ChannelImpl, zzbk

class zzaTR extends zzf
{

    final ChannelImpl zzaTR;

    public Result createFailedResult(Status status)
    {
        return zzbb(status);
    }

    protected volatile void zza(com.google.android.gms.common.api.Impl._cls3 _pcls3)
        throws RemoteException
    {
        zza((zzbk)_pcls3);
    }

    protected void zza(zzbk zzbk1)
        throws RemoteException
    {
        zzbk1.zzu(this, ChannelImpl.zza(zzaTR));
    }

    public com.google.android.gms.wearable.utStreamResult zzbb(Status status)
    {
        return new a(status, null);
    }

    esult(ChannelImpl channelimpl, GoogleApiClient googleapiclient)
    {
        zzaTR = channelimpl;
        super(googleapiclient);
    }
}
