// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzv, MobileAdsSettingsParcel

private static class zznF
    implements zzv
{

    private IBinder zznF;

    public IBinder asBinder()
    {
        return zznF;
    }

    public void zza(String s, MobileAdsSettingsParcel mobileadssettingsparcel)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
        parcel.writeString(s);
        if (mobileadssettingsparcel == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        parcel.writeInt(1);
        mobileadssettingsparcel.writeToParcel(parcel, 0);
_L1:
        zznF.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    tingsParcel(IBinder ibinder)
    {
        zznF = ibinder;
    }
}
