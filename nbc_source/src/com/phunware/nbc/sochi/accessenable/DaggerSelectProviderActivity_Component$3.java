// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.phunware.nbc.sochi.accessenable;

import com.nbcsports.liveextra.ApplicationComponent;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;

// Referenced classes of package com.phunware.nbc.sochi.accessenable:
//            DaggerSelectProviderActivity_Component

class val.builder
    implements Factory
{

    private final ApplicationComponent applicationComponent;
    final DaggerSelectProviderActivity_Component this$0;
    final ilder val$builder;

    public Picasso get()
    {
        Picasso picasso = applicationComponent.picasso();
        if (picasso == null)
        {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        } else
        {
            return picasso;
        }
    }

    public volatile Object get()
    {
        return get();
    }

    ilder()
    {
        this$0 = final_daggerselectprovideractivity_component;
        val$builder = ilder.this;
        super();
        applicationComponent = ilder.access._mth100(val$builder);
    }
}
