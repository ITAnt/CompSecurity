// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.app;

import com.skype.android.SkypeDialogFragment_MembersInjector;
import dagger.MembersInjector;
import javax.inject.Provider;

// Referenced classes of package com.skype.android.app:
//            ListItemMenuDialog

public final class ListItemMenuDialog_MembersInjector
    implements MembersInjector
{

    static final boolean $assertionsDisabled;
    private final Provider objectInterfaceFinderProvider;

    public ListItemMenuDialog_MembersInjector(Provider provider)
    {
        if (!$assertionsDisabled && provider == null)
        {
            throw new AssertionError();
        } else
        {
            objectInterfaceFinderProvider = provider;
            return;
        }
    }

    public static MembersInjector create(Provider provider)
    {
        return new ListItemMenuDialog_MembersInjector(provider);
    }

    public final void injectMembers(ListItemMenuDialog listitemmenudialog)
    {
        if (listitemmenudialog == null)
        {
            throw new NullPointerException("Cannot inject members into a null reference");
        } else
        {
            SkypeDialogFragment_MembersInjector.injectObjectInterfaceFinder(listitemmenudialog, objectInterfaceFinderProvider);
            return;
        }
    }

    public final volatile void injectMembers(Object obj)
    {
        injectMembers((ListItemMenuDialog)obj);
    }

    static 
    {
        boolean flag;
        if (!com/skype/android/app/ListItemMenuDialog_MembersInjector.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
