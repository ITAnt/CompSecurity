// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.api.jar.a;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.apps.youtube.api.jar.a:
//            dl, dn

public abstract class dm extends Binder
    implements dl
{

    public dm()
    {
        attachInterface(this, "com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
    }

    public static dl a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
        if (iinterface != null && (iinterface instanceof dl))
        {
            return (dl)iinterface;
        } else
        {
            return new dn(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
            a();
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
            b();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
            c();
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.apps.youtube.api.jar.client.IThumbnailOverlayClient");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        a(parcel);
        parcel1.writeNoException();
        return true;
    }
}
