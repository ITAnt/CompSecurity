// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.a.a.a;
import android.support.v4.view.d;
import android.support.v4.view.j;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater
{
    private static class InflatedOnMenuItemClickListener
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        private static final Class PARAM_TYPES[] = {
            android/view/MenuItem
        };
        private Method mMethod;
        private Object mRealOwner;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            try
            {
                if (mMethod.getReturnType() == Boolean.TYPE)
                {
                    return ((Boolean)mMethod.invoke(mRealOwner, new Object[] {
                        menuitem
                    })).booleanValue();
                }
                mMethod.invoke(mRealOwner, new Object[] {
                    menuitem
                });
            }
            // Misplaced declaration of an exception variable
            catch (MenuItem menuitem)
            {
                throw new RuntimeException(menuitem);
            }
            return true;
        }


        public InflatedOnMenuItemClickListener(Object obj, String s)
        {
            mRealOwner = obj;
            Class class1 = obj.getClass();
            try
            {
                mMethod = class1.getMethod(s, PARAM_TYPES);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                s = new InflateException((new StringBuilder()).append("Couldn't resolve menu item onClick handler ").append(s).append(" in class ").append(class1.getName()).toString());
            }
            s.initCause(((Throwable) (obj)));
            throw s;
        }
    }

    private class MenuState
    {

        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        private d itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemEnabled;
        private int itemIconResId;
        private int itemId;
        private String itemListenerMethodName;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private boolean itemVisible;
        private Menu menu;
        final SupportMenuInflater this$0;

        private char getShortcut(String s)
        {
            if (s == null)
            {
                return '\0';
            } else
            {
                return s.charAt(0);
            }
        }

        private Object newInstance(String s, Class aclass[], Object aobj[])
        {
            try
            {
                aclass = ((Class []) (mContext.getClassLoader().loadClass(s).getConstructor(aclass).newInstance(aobj)));
            }
            // Misplaced declaration of an exception variable
            catch (Class aclass[])
            {
                Log.w("SupportMenuInflater", (new StringBuilder()).append("Cannot instantiate class: ").append(s).toString(), aclass);
                return null;
            }
            return aclass;
        }

        private void setItem(MenuItem menuitem)
        {
            boolean flag = true;
            Object obj = menuitem.setChecked(itemChecked).setVisible(itemVisible).setEnabled(itemEnabled);
            boolean flag1;
            if (itemCheckable >= 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((MenuItem) (obj)).setCheckable(flag1).setTitleCondensed(itemTitleCondensed).setIcon(itemIconResId).setAlphabeticShortcut(itemAlphabeticShortcut).setNumericShortcut(itemNumericShortcut);
            if (itemShowAsAction >= 0)
            {
                j.a(menuitem, itemShowAsAction);
            }
            if (itemListenerMethodName != null)
            {
                if (mContext.isRestricted())
                {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuitem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(mRealOwner, itemListenerMethodName));
            }
            if (menuitem instanceof MenuItemImpl)
            {
                obj = (MenuItemImpl)menuitem;
            }
            if (itemCheckable >= 2)
            {
                if (menuitem instanceof MenuItemImpl)
                {
                    ((MenuItemImpl)menuitem).setExclusiveCheckable(true);
                } else
                if (menuitem instanceof MenuItemWrapperICS)
                {
                    ((MenuItemWrapperICS)menuitem).setExclusiveCheckable(true);
                }
            }
            if (itemActionViewClassName != null)
            {
                j.a(menuitem, (View)newInstance(itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, mActionViewConstructorArguments));
            } else
            {
                flag = false;
            }
            if (itemActionViewLayout > 0)
            {
                if (!flag)
                {
                    j.b(menuitem, itemActionViewLayout);
                } else
                {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (itemActionProvider != null)
            {
                j.a(menuitem, itemActionProvider);
            }
        }

        public void addItem()
        {
            itemAdded = true;
            setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
        }

        public SubMenu addSubMenuItem()
        {
            itemAdded = true;
            SubMenu submenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            setItem(submenu.getItem());
            return submenu;
        }

        public boolean hasAddedItem()
        {
            return itemAdded;
        }

        public void readGroup(AttributeSet attributeset)
        {
            attributeset = mContext.obtainStyledAttributes(attributeset, android.support.v7.a.a.j.MenuGroup);
            groupId = attributeset.getResourceId(1, 0);
            groupCategory = attributeset.getInt(3, 0);
            groupOrder = attributeset.getInt(4, 0);
            groupCheckable = attributeset.getInt(5, 0);
            groupVisible = attributeset.getBoolean(2, true);
            groupEnabled = attributeset.getBoolean(0, true);
            attributeset.recycle();
        }

        public void readItem(AttributeSet attributeset)
        {
            boolean flag = true;
            attributeset = mContext.obtainStyledAttributes(attributeset, android.support.v7.a.a.j.MenuItem);
            itemId = attributeset.getResourceId(2, 0);
            itemCategoryOrder = attributeset.getInt(5, groupCategory) & 0xffff0000 | attributeset.getInt(6, groupOrder) & 0xffff;
            itemTitle = attributeset.getText(7);
            itemTitleCondensed = attributeset.getText(8);
            itemIconResId = attributeset.getResourceId(0, 0);
            itemAlphabeticShortcut = getShortcut(attributeset.getString(9));
            itemNumericShortcut = getShortcut(attributeset.getString(10));
            int i;
            if (attributeset.hasValue(11))
            {
                if (attributeset.getBoolean(11, false))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                itemCheckable = i;
            } else
            {
                itemCheckable = groupCheckable;
            }
            itemChecked = attributeset.getBoolean(3, false);
            itemVisible = attributeset.getBoolean(4, groupVisible);
            itemEnabled = attributeset.getBoolean(1, groupEnabled);
            itemShowAsAction = attributeset.getInt(13, -1);
            itemListenerMethodName = attributeset.getString(12);
            itemActionViewLayout = attributeset.getResourceId(14, 0);
            itemActionViewClassName = attributeset.getString(15);
            itemActionProviderClassName = attributeset.getString(16);
            if (itemActionProviderClassName != null)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            if (i != 0 && itemActionViewLayout == 0 && itemActionViewClassName == null)
            {
                itemActionProvider = (d)newInstance(itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, mActionProviderConstructorArguments);
            } else
            {
                if (i != 0)
                {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                itemActionProvider = null;
            }
            attributeset.recycle();
            itemAdded = false;
        }

        public void resetGroup()
        {
            groupId = 0;
            groupCategory = 0;
            groupOrder = 0;
            groupCheckable = 0;
            groupVisible = true;
            groupEnabled = true;
        }


        public MenuState(Menu menu1)
        {
            this$0 = SupportMenuInflater.this;
            super();
            menu = menu1;
            resetGroup();
        }
    }


    private static final Class ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE[] = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    private static final Class ACTION_VIEW_CONSTRUCTOR_SIGNATURE[] = {
        android/content/Context
    };
    private static final String LOG_TAG = "SupportMenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object mActionProviderConstructorArguments[];
    private final Object mActionViewConstructorArguments[];
    private Context mContext;
    private Object mRealOwner;

    public SupportMenuInflater(Context context)
    {
        super(context);
        mContext = context;
        mRealOwner = context;
        mActionViewConstructorArguments = (new Object[] {
            context
        });
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }

    private void parseMenu(XmlPullParser xmlpullparser, AttributeSet attributeset, Menu menu)
        throws XmlPullParserException, IOException
    {
        MenuState menustate;
        int i;
        menustate = new MenuState(menu);
        i = xmlpullparser.getEventType();
_L12:
        if (i != 2) goto _L2; else goto _L1
_L1:
        menu = xmlpullparser.getName();
        if (!menu.equals("menu")) goto _L4; else goto _L3
_L3:
        i = xmlpullparser.next();
_L13:
        int j;
        int k;
        menu = null;
        boolean flag = false;
        k = i;
        j = 0;
        i = ((flag) ? 1 : 0);
_L10:
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        k;
        JVM INSTR tableswitch 1 3: default 100
    //                   1 368
    //                   2 163
    //                   3 250;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
_L14:
        k = xmlpullparser.next();
        if (true) goto _L10; else goto _L9
_L4:
        throw new RuntimeException((new StringBuilder()).append("Expecting menu, got ").append(menu).toString());
_L2:
        j = xmlpullparser.next();
        i = j;
        if (j != 1) goto _L12; else goto _L11
_L11:
        i = j;
          goto _L13
_L9:
        if (i == 0)
        {
            String s = xmlpullparser.getName();
            if (s.equals("group"))
            {
                menustate.readGroup(attributeset);
            } else
            if (s.equals("item"))
            {
                menustate.readItem(attributeset);
            } else
            if (s.equals("menu"))
            {
                parseMenu(xmlpullparser, attributeset, ((Menu) (menustate.addSubMenuItem())));
            } else
            {
                menu = s;
                i = 1;
            }
        }
          goto _L14
_L8:
        String s1 = xmlpullparser.getName();
        if (i != 0 && s1.equals(menu))
        {
            menu = null;
            i = 0;
        } else
        if (s1.equals("group"))
        {
            menustate.resetGroup();
        } else
        if (s1.equals("item"))
        {
            if (!menustate.hasAddedItem())
            {
                if (menustate.itemActionProvider != null && menustate.itemActionProvider.hasSubMenu())
                {
                    menustate.addSubMenuItem();
                } else
                {
                    menustate.addItem();
                }
            }
        } else
        if (s1.equals("menu"))
        {
            j = 1;
        }
          goto _L14
_L6:
        throw new RuntimeException("Unexpected end of document");
          goto _L13
    }

    public void inflate(int i, Menu menu)
    {
        if (menu instanceof a) goto _L2; else goto _L1
_L1:
        super.inflate(i, menu);
_L4:
        return;
_L2:
        XmlResourceParser xmlresourceparser;
        XmlResourceParser xmlresourceparser1;
        XmlResourceParser xmlresourceparser2;
        xmlresourceparser = null;
        xmlresourceparser2 = null;
        xmlresourceparser1 = null;
        XmlResourceParser xmlresourceparser3 = mContext.getResources().getLayout(i);
        xmlresourceparser1 = xmlresourceparser3;
        xmlresourceparser = xmlresourceparser3;
        xmlresourceparser2 = xmlresourceparser3;
        parseMenu(xmlresourceparser3, Xml.asAttributeSet(xmlresourceparser3), menu);
        if (xmlresourceparser3 != null)
        {
            xmlresourceparser3.close();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        menu;
        xmlresourceparser = xmlresourceparser1;
        throw new InflateException("Error inflating menu XML", menu);
        menu;
        if (xmlresourceparser != null)
        {
            xmlresourceparser.close();
        }
        throw menu;
        menu;
        xmlresourceparser = xmlresourceparser2;
        throw new InflateException("Error inflating menu XML", menu);
    }







}
