// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.k;
import com.google.android.gms.dynamic.l;

// Referenced classes of package com.google.android.gms.internal:
//            ja

final class jc
    implements ja
{

    private IBinder a;

    jc(IBinder ibinder)
    {
        a = ibinder;
    }

    public final k a(k k1, int i, int j, String s, int i1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        k1 = k1.asBinder();
_L1:
        parcel.writeStrongBinder(k1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeInt(i1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        k1 = l.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return k1;
        k1 = null;
          goto _L1
        k1;
        parcel1.recycle();
        parcel.recycle();
        throw k1;
    }

    public final k a(k k1, int i, int j, String s, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        k1 = k1.asBinder();
_L1:
        parcel.writeStrongBinder(k1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeString(s1);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        k1 = l.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return k1;
        k1 = null;
          goto _L1
        k1;
        parcel1.recycle();
        parcel.recycle();
        throw k1;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}
