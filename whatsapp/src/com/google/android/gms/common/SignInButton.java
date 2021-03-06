// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.jy;
import com.google.android.gms.internal.jz;

// Referenced classes of package com.google.android.gms.common:
//            GooglePlayServicesUtil

public final class SignInButton extends FrameLayout
    implements android.view.View.OnClickListener
{

    private View Jk;
    private android.view.View.OnClickListener Jl;
    private int mColor;
    private int mSize;

    public SignInButton(Context context)
    {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SignInButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Jl = null;
        setStyle(0, 0);
    }

    private void G(Context context)
    {
        try
        {
            if (Jk != null)
            {
                removeView(Jk);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
        try
        {
            Jk = jy.b(context, mSize, mColor);
        }
        catch (com.google.android.gms.dynamic.g.a a1)
        {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            Jk = a(context, mSize, mColor);
        }
        addView(Jk);
        Jk.setEnabled(isEnabled());
        Jk.setOnClickListener(this);
    }

    private static Button a(Context context, int i, int j)
    {
        jz jz1 = new jz(context);
        jz1.a(context.getResources(), i, j);
        return jz1;
    }

    public void onClick(View view)
    {
        if (Jl != null && view == Jk)
        {
            Jl.onClick(this);
        }
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        Jk.setEnabled(flag);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        Jl = onclicklistener;
        if (Jk != null)
        {
            Jk.setOnClickListener(this);
        }
    }

    public void setStyle(int i, int j)
    {
        int k = GooglePlayServicesUtil.a;
        boolean flag;
        if (i >= 0 && i < 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jx.a(flag, "Unknown button size %d", new Object[] {
            Integer.valueOf(i)
        });
        if (j >= 0 && j < 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jx.a(flag, "Unknown color scheme %s", new Object[] {
            Integer.valueOf(j)
        });
        mSize = i;
        mColor = j;
        G(getContext());
        if (k != 0)
        {
            jx.a++;
        }
    }
}
