// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.af;
import android.support.v4.view.ak;
import android.support.v4.view.x;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package android.support.design.widget:
//            Snackbar

final class a extends ak
{

    final Snackbar a;

    public final void onAnimationEnd(View view)
    {
        Snackbar.d(a);
    }

    public final void onAnimationStart(View view)
    {
        view = Snackbar.c(a);
        x.c(((ackbarLayout) (view)).a, 1.0F);
        x.s(((ackbarLayout) (view)).a).a(0.0F).a(180L).b(0L).b();
        if (((ackbarLayout) (view)).b.getVisibility() == 0)
        {
            x.c(((ackbarLayout) (view)).b, 1.0F);
            x.s(((ackbarLayout) (view)).b).a(0.0F).a(180L).b(0L).b();
        }
    }

    ackbarLayout(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }
}
