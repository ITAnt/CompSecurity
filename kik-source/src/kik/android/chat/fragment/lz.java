// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.chat.fragment;

import android.content.DialogInterface;

// Referenced classes of package kik.android.chat.fragment:
//            KikIqFragmentBase

final class lz
    implements android.content.DialogInterface.OnCancelListener
{

    final KikIqFragmentBase a;

    lz(KikIqFragmentBase kikiqfragmentbase)
    {
        a = kikiqfragmentbase;
        super();
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.X();
    }
}
