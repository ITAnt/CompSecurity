// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jcp.fragments;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.jcp.fragments:
//            JCPCreateAccountFragment

class ba extends DebouncingOnClickListener
{

    final JCPCreateAccountFragment a;
    final JCPCreateAccountFragment..ViewInjector b;

    ba(JCPCreateAccountFragment..ViewInjector viewinjector, JCPCreateAccountFragment jcpcreateaccountfragment)
    {
        b = viewinjector;
        a = jcpcreateaccountfragment;
        super();
    }

    public void doClick(View view)
    {
        a.onCreateAccountClick();
    }
}
