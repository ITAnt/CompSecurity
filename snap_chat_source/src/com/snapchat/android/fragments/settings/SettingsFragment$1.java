// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.snapchat.android.fragments.settings;

import android.view.View;

// Referenced classes of package com.snapchat.android.fragments.settings:
//            SettingsFragment

final class a
    implements Runnable
{

    private SettingsFragment a;

    public final void run()
    {
        SettingsFragment.d(a).setPadding(SettingsFragment.a(a).getPaddingLeft(), 0, SettingsFragment.b(a).getPaddingRight(), SettingsFragment.c(a).getPaddingBottom());
    }

    (SettingsFragment settingsfragment)
    {
        a = settingsfragment;
        super();
    }
}
