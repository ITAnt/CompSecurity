// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.chat.fragment;

import android.content.DialogInterface;

// Referenced classes of package kik.android.chat.fragment:
//            KikAddToBlockFragment

final class bj
    implements android.content.DialogInterface.OnClickListener
{

    final KikAddToBlockFragment a;

    bj(KikAddToBlockFragment kikaddtoblockfragment)
    {
        a = kikaddtoblockfragment;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }
}
