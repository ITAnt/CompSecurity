// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package com.google.android.gms.maps.model.internal:
//            zzj

public abstract class zza extends Binder
    implements zzj
{

    public static zzj a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
        class zza
            implements zzj
        {

            private IBinder a;

            public void a()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(1, parcel, parcel1, 0);
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

            public void a(float f1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                parcel.writeFloat(f1);
                a.transact(7, parcel, parcel1, 0);
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

            public void a(int l)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                parcel.writeInt(l);
                a.transact(9, parcel, parcel1, 0);
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

            public void a(List list)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                parcel.writeTypedList(list);
                a.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                list;
                parcel1.recycle();
                parcel.recycle();
                throw list;
            }

            public void a(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int l;
                l = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                if (flag)
                {
                    l = 1;
                }
                parcel.writeInt(l);
                a.transact(15, parcel, parcel1, 0);
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

            public boolean a(zzj zzj1)
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                if (zzj1 == null)
                {
                    break MISSING_BLOCK_LABEL_77;
                }
                zzj1 = zzj1.asBinder();
_L1:
                int l;
                parcel.writeStrongBinder(zzj1);
                a.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                if (l != 0)
                {
                    flag = true;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                zzj1 = null;
                  goto _L1
                zzj1;
                parcel1.recycle();
                parcel.recycle();
                throw zzj1;
            }

            public IBinder asBinder()
            {
                return a;
            }

            public String b()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(2, parcel, parcel1, 0);
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

            public void b(float f1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                parcel.writeFloat(f1);
                a.transact(13, parcel, parcel1, 0);
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

            public void b(int l)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                parcel.writeInt(l);
                a.transact(11, parcel, parcel1, 0);
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

            public void b(List list)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                parcel.writeList(list);
                a.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                list;
                parcel1.recycle();
                parcel.recycle();
                throw list;
            }

            public void b(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int l;
                l = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                if (flag)
                {
                    l = 1;
                }
                parcel.writeInt(l);
                a.transact(17, parcel, parcel1, 0);
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

            public List c()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(LatLng.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List d()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.readArrayList(getClass().getClassLoader());
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float e()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                float f1;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                f1 = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int f()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int g()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public float h()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                float f1;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                f1 = parcel1.readFloat();
                parcel1.recycle();
                parcel.recycle();
                return f1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean i()
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                if (l != 0)
                {
                    flag = true;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean j()
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                if (l != 0)
                {
                    flag = true;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int k()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int l;
                parcel.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            zza(IBinder ibinder)
            {
                a = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzj))
        {
            return (zzj)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        boolean flag = false;
        boolean flag8 = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            a();
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            parcel = b();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            a(parcel.createTypedArrayList(LatLng.CREATOR));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            parcel = c();
            parcel1.writeNoException();
            parcel1.writeTypedList(parcel);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            b(parcel.readArrayList(getClass().getClassLoader()));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            parcel = d();
            parcel1.writeNoException();
            parcel1.writeList(parcel);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            a(parcel.readFloat());
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            float f = e();
            parcel1.writeNoException();
            parcel1.writeFloat(f);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            a(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            i = f();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            b(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            i = g();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            b(parcel.readFloat());
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            float f1 = h();
            parcel1.writeNoException();
            parcel1.writeFloat(f1);
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            if (parcel.readInt() != 0)
            {
                flag3 = true;
            }
            a(flag3);
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            boolean flag4 = i();
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag4)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            boolean flag5 = flag8;
            if (parcel.readInt() != 0)
            {
                flag5 = true;
            }
            b(flag5);
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            boolean flag6 = j();
            parcel1.writeNoException();
            i = ((flag1) ? 1 : 0);
            if (flag6)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            boolean flag7 = a(a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            i = ((flag2) ? 1 : 0);
            if (flag7)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            i = k();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;
        }
    }
}
