// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.u;
import com.google.android.gms.common.internal.ap;

public final class f extends m
{

    private Dialog a;
    private android.content.DialogInterface.OnCancelListener b;

    public f()
    {
        a = null;
        b = null;
    }

    public static f a(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        f f1 = new f();
        dialog = (Dialog)ap.a(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        f1.a = dialog;
        if (oncancellistener != null)
        {
            f1.b = oncancellistener;
        }
        return f1;
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        if (b != null)
        {
            b.onCancel(dialoginterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        if (a == null)
        {
            setShowsDialog(false);
        }
        return a;
    }

    public final void show(u u, String s)
    {
        super.show(u, s);
    }
}
