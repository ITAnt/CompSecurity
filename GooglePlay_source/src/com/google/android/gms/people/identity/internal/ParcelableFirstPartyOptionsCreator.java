// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.people.identity.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

// Referenced classes of package com.google.android.gms.people.identity.internal:
//            ParcelableFirstPartyOptions

public final class ParcelableFirstPartyOptionsCreator
    implements android.os.Parcelable.Creator
{

    public ParcelableFirstPartyOptionsCreator()
    {
    }

    static void writeToParcel$5e4c5a8c(ParcelableFirstPartyOptions parcelablefirstpartyoptions, Parcel parcel)
    {
        int i = SafeParcelWriter.beginVariableData(parcel, 20293);
        SafeParcelWriter.writeString(parcel, 1, parcelablefirstpartyoptions.mAccountName, false);
        SafeParcelWriter.writeInt(parcel, 1000, parcelablefirstpartyoptions.mVersionCode);
        SafeParcelWriter.writeString(parcel, 2, parcelablefirstpartyoptions.mPageId, false);
        SafeParcelWriter.finishVariableData(parcel, i);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        String s1 = null;
        int j = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    SafeParcelReader.skipUnknownField(parcel, k);
                    break;

                case 1: // '\001'
                    s = SafeParcelReader.createString(parcel, k);
                    break;

                case 1000: 
                    i = SafeParcelReader.readInt(parcel, k);
                    break;

                case 2: // '\002'
                    s1 = SafeParcelReader.createString(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new ParcelableFirstPartyOptions(i, s, s1);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ParcelableFirstPartyOptions[i];
    }
}
