// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.af;
import android.support.v4.view.aj;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            ScrollingTabContainerView

protected class mCanceled
    implements aj
{

    private boolean mCanceled;
    private int mFinalVisibility;
    final ScrollingTabContainerView this$0;

    public void onAnimationCancel(View view)
    {
        mCanceled = true;
    }

    public void onAnimationEnd(View view)
    {
        if (mCanceled)
        {
            return;
        } else
        {
            mVisibilityAnim = null;
            setVisibility(mFinalVisibility);
            return;
        }
    }

    public void onAnimationStart(View view)
    {
        setVisibility(0);
        mCanceled = false;
    }

    public mCanceled withFinalVisibility(af af, int i)
    {
        mFinalVisibility = i;
        mVisibilityAnim = af;
        return this;
    }

    protected Y()
    {
        this$0 = ScrollingTabContainerView.this;
        super();
        mCanceled = false;
    }
}
