// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface dc
    extends IInterface
{
    public static abstract class a extends Binder
        implements dc
    {

        public static dc p(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            if (iinterface != null && (iinterface instanceof dc))
            {
                return (dc)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                parcel = getProductId();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                recordResolution(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                recordPlayBillingResolution(parcel.readInt());
                parcel1.writeNoException();
                return true;
            }
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        }
    }

    private static class a.a
        implements dc
    {

        private IBinder ko;

        public IBinder asBinder()
        {
            return ko;
        }

        public String getProductId()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            ko.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void recordPlayBillingResolution(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            parcel.writeInt(i);
            ko.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void recordResolution(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            parcel.writeInt(i);
            ko.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        a.a(IBinder ibinder)
        {
            ko = ibinder;
        }
    }


    public abstract String getProductId()
        throws RemoteException;

    public abstract void recordPlayBillingResolution(int i)
        throws RemoteException;

    public abstract void recordResolution(int i)
        throws RemoteException;
}
