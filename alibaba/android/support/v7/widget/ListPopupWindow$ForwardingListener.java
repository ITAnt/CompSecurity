// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import df;

// Referenced classes of package android.support.v7.widget:
//            ListPopupWindow

public static abstract class mTapTimeout
    implements android.view.dingListener
{
    class DisallowIntercept
        implements Runnable
    {

        final ListPopupWindow.ForwardingListener this$0;

        public void run()
        {
            mSrc.getParent().requestDisallowInterceptTouchEvent(true);
        }

        private DisallowIntercept()
        {
            this$0 = ListPopupWindow.ForwardingListener.this;
            super();
        }

        DisallowIntercept(ListPopupWindow._cls1 _pcls1)
        {
            this();
        }
    }

    class TriggerLongPress
        implements Runnable
    {

        final ListPopupWindow.ForwardingListener this$0;

        public void run()
        {
            onLongPress();
        }

        private TriggerLongPress()
        {
            this$0 = ListPopupWindow.ForwardingListener.this;
            super();
        }

        TriggerLongPress(ListPopupWindow._cls1 _pcls1)
        {
            this();
        }
    }


    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    private final View mSrc;
    private final int mTapTimeout = ViewConfiguration.getTapTimeout();
    private final int mTmpLocation[] = new int[2];
    private Runnable mTriggerLongPress;
    private boolean mWasLongPress;

    private void clearCallbacks()
    {
        if (mTriggerLongPress != null)
        {
            mSrc.removeCallbacks(mTriggerLongPress);
        }
        if (mDisallowIntercept != null)
        {
            mSrc.removeCallbacks(mDisallowIntercept);
        }
    }

    private void onLongPress()
    {
        clearCallbacks();
        while (!mSrc.isEnabled() || !onForwardingStarted()) 
        {
            return;
        }
        mSrc.getParent().requestDisallowInterceptTouchEvent(true);
        long l = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        mSrc.onTouchEvent(motionevent);
        motionevent.recycle();
        mForwarding = true;
        mWasLongPress = true;
    }

    private boolean onTouchForwarded(MotionEvent motionevent)
    {
        boolean flag = true;
        View view = mSrc;
        Object obj = getPopup();
        if (obj != null && ((ListPopupWindow) (obj)).isShowing())
        {
            if ((obj = ListPopupWindow.access$600(((ListPopupWindow) (obj)))) != null && ((getPopup) (obj)).Shown())
            {
                MotionEvent motionevent1 = MotionEvent.obtainNoHistory(motionevent);
                toGlobalMotionEvent(view, motionevent1);
                toLocalMotionEvent(((View) (obj)), motionevent1);
                boolean flag1 = ((toLocalMotionEvent) (obj)).ForwardedEvent(motionevent1, mActivePointerId);
                motionevent1.recycle();
                int i = df.a(motionevent);
                if (i != 1 && i != 3)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (!flag1 || !i)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    private boolean onTouchObserved(MotionEvent motionevent)
    {
        View view = mSrc;
        if (view.isEnabled()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (df.a(motionevent))
        {
        default:
            return false;

        case 0: // '\0'
            mActivePointerId = motionevent.getPointerId(0);
            mWasLongPress = false;
            if (mDisallowIntercept == null)
            {
                mDisallowIntercept = new DisallowIntercept(null);
            }
            view.postDelayed(mDisallowIntercept, mTapTimeout);
            if (mTriggerLongPress == null)
            {
                mTriggerLongPress = new TriggerLongPress(null);
            }
            view.postDelayed(mTriggerLongPress, mLongPressTimeout);
            return false;

        case 2: // '\002'
            int i = motionevent.findPointerIndex(mActivePointerId);
            if (i >= 0 && !pointInView(view, motionevent.getX(i), motionevent.getY(i), mScaledTouchSlop))
            {
                clearCallbacks();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            clearCallbacks();
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static boolean pointInView(View view, float f, float f1, float f2)
    {
        return f >= -f2 && f1 >= -f2 && f < (float)(view.getRight() - view.getLeft()) + f2 && f1 < (float)(view.getBottom() - view.getTop()) + f2;
    }

    private boolean toGlobalMotionEvent(View view, MotionEvent motionevent)
    {
        int ai[] = mTmpLocation;
        view.getLocationOnScreen(ai);
        motionevent.offsetLocation(ai[0], ai[1]);
        return true;
    }

    private boolean toLocalMotionEvent(View view, MotionEvent motionevent)
    {
        int ai[] = mTmpLocation;
        view.getLocationOnScreen(ai);
        motionevent.offsetLocation(-ai[0], -ai[1]);
        return true;
    }

    public abstract ListPopupWindow getPopup();

    public boolean onForwardingStarted()
    {
        ListPopupWindow listpopupwindow = getPopup();
        if (listpopupwindow != null && !listpopupwindow.isShowing())
        {
            listpopupwindow.show();
        }
        return true;
    }

    public boolean onForwardingStopped()
    {
        ListPopupWindow listpopupwindow = getPopup();
        if (listpopupwindow != null && listpopupwindow.isShowing())
        {
            listpopupwindow.dismiss();
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = mForwarding;
        if (!flag2) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (mWasLongPress)
        {
            flag = onTouchForwarded(motionevent);
        } else
        if (onTouchForwarded(motionevent) || !onForwardingStopped())
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
label0:
        {
            mForwarding = flag;
            if (!flag)
            {
                flag = flag1;
                if (!flag2)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
_L2:
        if (onTouchObserved(motionevent) && onForwardingStarted())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            long l = SystemClock.uptimeMillis();
            view = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            mSrc.onTouchEvent(view);
            view.recycle();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



    public TriggerLongPress(View view)
    {
        mSrc = view;
        mScaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        mLongPressTimeout = (mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }
}
