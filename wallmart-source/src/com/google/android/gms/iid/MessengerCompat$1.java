// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.iid:
//            MessengerCompat

static final class 
    implements android.os.
{

    public Object createFromParcel(Parcel parcel)
    {
        return zzen(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgA(i);
    }

    public MessengerCompat zzen(Parcel parcel)
    {
        parcel = parcel.readStrongBinder();
        if (parcel != null)
        {
            return new MessengerCompat(parcel);
        } else
        {
            return null;
        }
    }

    public MessengerCompat[] zzgA(int i)
    {
        return new MessengerCompat[i];
    }

    ()
    {
    }
}
