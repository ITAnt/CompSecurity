// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.passenger.v2.confirm;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package me.lyft.android.ui.passenger.v2.confirm:
//            ConfirmPickupView, ConfirmPresenter, RequestRideButtonPresenter

public final class  extends Binding
    implements MembersInjector
{

    private Binding confirmPresenter;
    private Binding requestRideButtonController;

    public void attach(Linker linker)
    {
        confirmPresenter = linker.requestBinding("me.lyft.android.ui.passenger.v2.confirm.ConfirmPresenter", me/lyft/android/ui/passenger/v2/confirm/ConfirmPickupView, getClass().getClassLoader());
        requestRideButtonController = linker.requestBinding("me.lyft.android.ui.passenger.v2.confirm.RequestRideButtonPresenter", me/lyft/android/ui/passenger/v2/confirm/ConfirmPickupView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(confirmPresenter);
        set1.add(requestRideButtonController);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ConfirmPickupView)obj);
    }

    public void injectMembers(ConfirmPickupView confirmpickupview)
    {
        confirmpickupview.confirmPresenter = (ConfirmPresenter)confirmPresenter.get();
        confirmpickupview.requestRideButtonController = (RequestRideButtonPresenter)requestRideButtonController.get();
    }

    public ()
    {
        super(null, "members/me.lyft.android.ui.passenger.v2.confirm.ConfirmPickupView", false, me/lyft/android/ui/passenger/v2/confirm/ConfirmPickupView);
    }
}
