// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.placesearch;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.AppFlow;

// Referenced classes of package me.lyft.android.ui.placesearch:
//            PickupSearchView, IPlaceSearchPresenter

public final class  extends Binding
    implements MembersInjector
{

    private Binding appFlow;
    private Binding placeSearchPresenter;
    private Binding rideRequestSession;
    private Binding supertype;

    public void attach(Linker linker)
    {
        placeSearchPresenter = linker.requestBinding("me.lyft.android.ui.placesearch.IPlaceSearchPresenter", me/lyft/android/ui/placesearch/PickupSearchView, getClass().getClassLoader());
        rideRequestSession = linker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", me/lyft/android/ui/placesearch/PickupSearchView, getClass().getClassLoader());
        appFlow = linker.requestBinding("me.lyft.android.common.AppFlow", me/lyft/android/ui/placesearch/PickupSearchView, getClass().getClassLoader());
        supertype = linker.requestBinding("members/me.lyft.android.ui.placesearch.PlaceSearchView", me/lyft/android/ui/placesearch/PickupSearchView, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(placeSearchPresenter);
        set1.add(rideRequestSession);
        set1.add(appFlow);
        set1.add(supertype);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((PickupSearchView)obj);
    }

    public void injectMembers(PickupSearchView pickupsearchview)
    {
        pickupsearchview.placeSearchPresenter = (IPlaceSearchPresenter)placeSearchPresenter.get();
        pickupsearchview.rideRequestSession = (IRideRequestSession)rideRequestSession.get();
        pickupsearchview.appFlow = (AppFlow)appFlow.get();
        supertype.injectMembers(pickupsearchview);
    }

    public ()
    {
        super(null, "members/me.lyft.android.ui.placesearch.PickupSearchView", false, me/lyft/android/ui/placesearch/PickupSearchView);
    }
}
