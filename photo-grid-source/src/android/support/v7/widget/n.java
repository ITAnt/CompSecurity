// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            r, p, g

final class n extends r
{

    final p a;
    final ViewPropertyAnimatorCompat b;
    final g c;

    n(g g1, p p1, ViewPropertyAnimatorCompat viewpropertyanimatorcompat)
    {
        c = g1;
        a = p1;
        b = viewpropertyanimatorcompat;
        super((byte)0);
    }

    public final void onAnimationEnd(View view)
    {
        b.setListener(null);
        ViewCompat.setAlpha(view, 1.0F);
        ViewCompat.setTranslationX(view, 0.0F);
        ViewCompat.setTranslationY(view, 0.0F);
        c.g(a.a);
        g.h(c).remove(a.a);
        g.e(c);
    }

    public final void onAnimationStart(View view)
    {
    }
}
