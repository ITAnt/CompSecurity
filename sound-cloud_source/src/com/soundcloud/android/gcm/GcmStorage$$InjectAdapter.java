// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.gcm;

import android.content.SharedPreferences;
import dagger.a.b;
import dagger.a.l;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.soundcloud.android.gcm:
//            GcmStorage

public final class  extends b
    implements Provider
{

    private b sharedPreferences;

    public final void attach(l l1)
    {
        sharedPreferences = l1.a("@javax.inject.Named(value=gcm)/android.content.SharedPreferences", com/soundcloud/android/gcm/GcmStorage, getClass().getClassLoader());
    }

    public final GcmStorage get()
    {
        return new GcmStorage((SharedPreferences)sharedPreferences.get());
    }

    public final volatile Object get()
    {
        return get();
    }

    public final void getDependencies(Set set, Set set1)
    {
        set.add(sharedPreferences);
    }

    public ()
    {
        super("com.soundcloud.android.gcm.GcmStorage", "members/com.soundcloud.android.gcm.GcmStorage", false, com/soundcloud/android/gcm/GcmStorage);
    }
}
