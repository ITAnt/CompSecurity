// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.events:
//            ChangeEvent

public class a
    implements android.os.Parcelable.Creator
{

    public a()
    {
    }

    static void a(ChangeEvent changeevent, Parcel parcel, int i)
    {
        int j = b.D(parcel);
        b.c(parcel, 1, changeevent.BR);
        b.a(parcel, 2, changeevent.MW, i, false);
        b.c(parcel, 3, changeevent.NM);
        b.H(parcel, j);
    }

    public ChangeEvent T(Parcel parcel)
    {
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.C(parcel);
        DriveId driveid = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aD(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ChangeEvent(j, driveid, i);
            }
        } while (true);
    }

    public ChangeEvent[] ba(int i)
    {
        return new ChangeEvent[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return T(parcel);
    }

    public Object[] newArray(int i)
    {
        return ba(i);
    }
}
