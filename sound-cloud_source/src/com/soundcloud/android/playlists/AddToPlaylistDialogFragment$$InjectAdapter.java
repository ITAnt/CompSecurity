// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.playlists;

import com.soundcloud.android.configuration.FeatureOperations;
import com.soundcloud.rx.eventbus.EventBus;
import dagger.a;
import dagger.a.b;
import dagger.a.l;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.soundcloud.android.playlists:
//            AddToPlaylistDialogFragment, PlaylistOperations

public final class Q extends b
    implements a, Provider
{

    private b eventBus;
    private b featureOperations;
    private b playlistOperations;

    public final void attach(l l1)
    {
        playlistOperations = l1.a("com.soundcloud.android.playlists.PlaylistOperations", com/soundcloud/android/playlists/AddToPlaylistDialogFragment, getClass().getClassLoader());
        featureOperations = l1.a("com.soundcloud.android.configuration.FeatureOperations", com/soundcloud/android/playlists/AddToPlaylistDialogFragment, getClass().getClassLoader());
        eventBus = l1.a("com.soundcloud.rx.eventbus.EventBus", com/soundcloud/android/playlists/AddToPlaylistDialogFragment, getClass().getClassLoader());
    }

    public final AddToPlaylistDialogFragment get()
    {
        AddToPlaylistDialogFragment addtoplaylistdialogfragment = new AddToPlaylistDialogFragment();
        injectMembers(addtoplaylistdialogfragment);
        return addtoplaylistdialogfragment;
    }

    public final volatile Object get()
    {
        return get();
    }

    public final void getDependencies(Set set, Set set1)
    {
        set1.add(playlistOperations);
        set1.add(featureOperations);
        set1.add(eventBus);
    }

    public final void injectMembers(AddToPlaylistDialogFragment addtoplaylistdialogfragment)
    {
        addtoplaylistdialogfragment.playlistOperations = (PlaylistOperations)playlistOperations.get();
        addtoplaylistdialogfragment.featureOperations = (FeatureOperations)featureOperations.get();
        addtoplaylistdialogfragment.eventBus = (EventBus)eventBus.get();
    }

    public final volatile void injectMembers(Object obj)
    {
        injectMembers((AddToPlaylistDialogFragment)obj);
    }

    public Q()
    {
        super("com.soundcloud.android.playlists.AddToPlaylistDialogFragment", "members/com.soundcloud.android.playlists.AddToPlaylistDialogFragment", false, com/soundcloud/android/playlists/AddToPlaylistDialogFragment);
    }
}
