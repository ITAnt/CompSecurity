// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fitbit.data.domain.device;

import android.os.Parcel;

// Referenced classes of package com.fitbit.data.domain.device:
//            ExerciseOption

static final class 
    implements android.os.r
{

    public ExerciseOption a(Parcel parcel)
    {
        ExerciseOption exerciseoption = new ExerciseOption();
        ExerciseOption.a(exerciseoption, parcel.readString());
        ExerciseOption.b(exerciseoption, parcel.readString());
        return exerciseoption;
    }

    public ExerciseOption[] a(int i)
    {
        return new ExerciseOption[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
