// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.utils;

import android.content.Context;
import dagger.a.b;
import dagger.a.l;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.soundcloud.android.utils:
//            DeviceHelper, BuildHelper

public final class  extends b
    implements Provider
{

    private b buildHelper;
    private b context;

    public final void attach(l l1)
    {
        context = l1.a("android.content.Context", com/soundcloud/android/utils/DeviceHelper, getClass().getClassLoader());
        buildHelper = l1.a("com.soundcloud.android.utils.BuildHelper", com/soundcloud/android/utils/DeviceHelper, getClass().getClassLoader());
    }

    public final DeviceHelper get()
    {
        return new DeviceHelper((Context)context.get(), (BuildHelper)buildHelper.get());
    }

    public final volatile Object get()
    {
        return get();
    }

    public final void getDependencies(Set set, Set set1)
    {
        set.add(context);
        set.add(buildHelper);
    }

    public ()
    {
        super("com.soundcloud.android.utils.DeviceHelper", "members/com.soundcloud.android.utils.DeviceHelper", true, com/soundcloud/android/utils/DeviceHelper);
    }
}
