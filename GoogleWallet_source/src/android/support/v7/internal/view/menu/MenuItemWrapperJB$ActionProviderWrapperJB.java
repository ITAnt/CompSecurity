// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuItemWrapperJB

final class init> extends init>
    implements android.view.S.ActionProviderWrapper
{

    android.support.v4.view.iderWrapperJB.mInner mListener;
    final MenuItemWrapperJB this$0;

    public final boolean isVisible()
    {
        return mInner.isVisible();
    }

    public final void onActionProviderVisibilityChanged(boolean flag)
    {
        if (mListener != null)
        {
            mListener.ProviderVisibilityChanged(flag);
        }
    }

    public final View onCreateActionView(MenuItem menuitem)
    {
        return mInner.onCreateActionView(menuitem);
    }

    public final boolean overridesItemVisibility()
    {
        return mInner.overridesItemVisibility();
    }

    public final void setVisibilityListener(android.support.v4.view.iderWrapperJB iderwrapperjb)
    {
        mListener = iderwrapperjb;
        ActionProvider actionprovider = mInner;
        if (iderwrapperjb != null)
        {
            iderwrapperjb = this;
        } else
        {
            iderwrapperjb = null;
        }
        actionprovider.setVisibilityListener(iderwrapperjb);
    }

    public (Context context, ActionProvider actionprovider)
    {
        this$0 = MenuItemWrapperJB.this;
        super(MenuItemWrapperJB.this, context, actionprovider);
    }
}
