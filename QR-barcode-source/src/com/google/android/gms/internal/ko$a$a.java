// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

// Referenced classes of package com.google.android.gms.internal:
//            ko

private static class lb
    implements ko
{

    private IBinder lb;

    public void a(DataTypeResult datatyperesult)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataTypeCallback");
        if (datatyperesult == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        datatyperesult.writeToParcel(parcel, 0);
_L1:
        lb.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        datatyperesult;
        parcel1.recycle();
        parcel.recycle();
        throw datatyperesult;
    }

    public IBinder asBinder()
    {
        return lb;
    }

    ataTypeResult(IBinder ibinder)
    {
        lb = ibinder;
    }
}
