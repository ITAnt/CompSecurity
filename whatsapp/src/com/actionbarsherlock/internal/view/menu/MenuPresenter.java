// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuBuilder, MenuItemImpl, SubMenuBuilder

public interface MenuPresenter
{

    public abstract boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl);

    public abstract boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl);

    public abstract boolean flagActionItems();

    public abstract void initForMenu(Context context, MenuBuilder menubuilder);

    public abstract void onCloseMenu(MenuBuilder menubuilder, boolean flag);

    public abstract boolean onSubMenuSelected(SubMenuBuilder submenubuilder);

    public abstract void updateMenuView(boolean flag);
}
