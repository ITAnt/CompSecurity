// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;
import me.lyft.android.application.system.ILyftSystemRepository;
import me.lyft.android.persistence.ISimpleStorage;

// Referenced classes of package me.lyft.android.application:
//            ApplicationServicesModule

public final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ApplicationServicesModule module;
    private Binding simpleStorage;

    public void attach(Linker linker)
    {
        simpleStorage = linker.requestBinding("me.lyft.android.persistence.ISimpleStorage", me/lyft/android/application/ApplicationServicesModule, getClass().getClassLoader());
    }

    public volatile Object get()
    {
        return get();
    }

    public ILyftSystemRepository get()
    {
        return module.provideLyftSystemRepository((ISimpleStorage)simpleStorage.get());
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(simpleStorage);
    }

    public (ApplicationServicesModule applicationservicesmodule)
    {
        super("me.lyft.android.application.system.ILyftSystemRepository", false, "me.lyft.android.application.ApplicationServicesModule", "provideLyftSystemRepository");
        module = applicationservicesmodule;
        setLibrary(true);
    }
}
