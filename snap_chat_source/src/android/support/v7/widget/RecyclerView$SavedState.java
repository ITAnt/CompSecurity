// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

static class a extends android.view.w.SavedState
{

    public static final android.os.iew.SavedState.a CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new RecyclerView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new RecyclerView.SavedState[i];
        }

    };
    Parcelable a;

    static void a(a a1, a a2)
    {
        a1.a = a2.a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.eToParcel(parcel, i);
        parcel.writeParcelable(a, 0);
    }


    _cls1(Parcel parcel)
    {
        super(parcel);
        a = parcel.readParcelable(android/support/v7/widget/RecyclerView$i.getClassLoader());
    }

    a(Parcelable parcelable)
    {
        super(parcelable);
    }
}
