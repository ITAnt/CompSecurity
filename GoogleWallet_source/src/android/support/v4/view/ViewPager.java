// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            PagerAdapter, ViewCompat, KeyEventCompat, ViewConfigurationCompat, 
//            MotionEventCompat, VelocityTrackerCompat, AccessibilityDelegateCompat

public class ViewPager extends ViewGroup
{
    static interface Decor
    {
    }

    static final class ItemInfo
    {

        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo()
        {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams()
        {
            super(-1, -1);
            widthFactor = 0.0F;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            widthFactor = 0.0F;
            context = context.obtainStyledAttributes(attributeset, ViewPager.LAYOUT_ATTRS);
            gravity = context.getInteger(0, 48);
            context.recycle();
        }
    }

    final class MyAccessibilityDelegate extends AccessibilityDelegateCompat
    {

        final ViewPager this$0;

        private boolean canScroll()
        {
            return mAdapter != null && mAdapter.getCount() > 1;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
        {
            super.onInitializeAccessibilityEvent(view, accessibilityevent);
            accessibilityevent.setClassName(android/support/v4/view/ViewPager.getName());
            view = AccessibilityRecordCompat.obtain();
            view.setScrollable(canScroll());
            if (accessibilityevent.getEventType() == 4096 && mAdapter != null)
            {
                view.setItemCount(mAdapter.getCount());
                view.setFromIndex(mCurItem);
                view.setToIndex(mCurItem);
            }
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
            accessibilitynodeinfocompat.setClassName(android/support/v4/view/ViewPager.getName());
            accessibilitynodeinfocompat.setScrollable(canScroll());
            if (canScrollHorizontally(1))
            {
                accessibilitynodeinfocompat.addAction(4096);
            }
            if (canScrollHorizontally(-1))
            {
                accessibilitynodeinfocompat.addAction(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle)
        {
            if (super.performAccessibilityAction(view, i, bundle))
            {
                return true;
            }
            switch (i)
            {
            default:
                return false;

            case 4096: 
                if (canScrollHorizontally(1))
                {
                    setCurrentItem(mCurItem + 1);
                    return true;
                } else
                {
                    return false;
                }

            case 8192: 
                break;
            }
            if (canScrollHorizontally(-1))
            {
                setCurrentItem(mCurItem - 1);
                return true;
            } else
            {
                return false;
            }
        }

        MyAccessibilityDelegate()
        {
            this$0 = ViewPager.this;
            super();
        }
    }

    static interface OnAdapterChangeListener
    {

        public abstract void onAdapterChanged(PagerAdapter pageradapter, PagerAdapter pageradapter1);
    }

    public static interface OnPageChangeListener
    {

        public abstract void onPageScrollStateChanged(int i);

        public abstract void onPageScrolled(int i, float f, int j);

        public abstract void onPageSelected(int i);
    }

    public static interface PageTransformer
    {

        public abstract void transformPage(View view, float f);
    }

    final class PagerObserver extends DataSetObserver
    {

        final ViewPager this$0;

        public final void onChanged()
        {
            dataSetChanged();
        }

        public final void onInvalidated()
        {
            dataSetChanged();
        }

        private PagerObserver()
        {
            this$0 = ViewPager.this;
            super();
        }

    }

    public static final class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {

            private static SavedState createFromParcel(Parcel parcel, ClassLoader classloader)
            {
                return new SavedState(parcel, classloader);
            }

            private static SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public final volatile Object createFromParcel(Parcel parcel, ClassLoader classloader)
            {
                return createFromParcel(parcel, classloader);
            }

            public final volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public final String toString()
        {
            return (new StringBuilder("FragmentPager.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(position).append("}").toString();
        }

        public final void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(position);
            parcel.writeParcelable(adapterState, i);
        }


        SavedState(Parcel parcel, ClassLoader classloader)
        {
            super(parcel);
            ClassLoader classloader1 = classloader;
            if (classloader == null)
            {
                classloader1 = getClass().getClassLoader();
            }
            position = parcel.readInt();
            adapterState = parcel.readParcelable(classloader1);
            loader = classloader1;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static class SimpleOnPageChangeListener
        implements OnPageChangeListener
    {

        public final void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
        }

        public void onPageSelected(int i)
        {
        }

        public SimpleOnPageChangeListener()
        {
        }
    }

    static final class ViewPositionComparator
        implements Comparator
    {

        private static int compare(View view, View view1)
        {
            view = (LayoutParams)view.getLayoutParams();
            view1 = (LayoutParams)view1.getLayoutParams();
            if (((LayoutParams) (view)).isDecor != ((LayoutParams) (view1)).isDecor)
            {
                return !((LayoutParams) (view)).isDecor ? -1 : 1;
            } else
            {
                return ((LayoutParams) (view)).position - ((LayoutParams) (view1)).position;
            }
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((View)obj, (View)obj1);
        }

        ViewPositionComparator()
        {
        }
    }


    private static final Comparator COMPARATOR = new Comparator() {

        private static int compare(ItemInfo iteminfo, ItemInfo iteminfo1)
        {
            return iteminfo.position - iteminfo1.position;
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((ItemInfo)obj, (ItemInfo)obj1);
        }

    };
    private static final int LAYOUT_ATTRS[] = {
        0x10100b3
    };
    private static final Interpolator sInterpolator = new Interpolator() {

        public final float getInterpolation(float f)
        {
            f--;
            return f * f * f * f * f + 1.0F;
        }

    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public ViewPager(Context context)
    {
        super(context);
        mItems = new ArrayList();
        mTempItem = new ItemInfo();
        mTempRect = new Rect();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mFirstOffset = -3.402823E+38F;
        mLastOffset = 3.402823E+38F;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mNeedCalculatePageOffsets = false;
        mEndScrollRunnable = new Runnable() {

            final ViewPager this$0;

            public final void run()
            {
                setScrollState(0);
                populate();
            }

            
            {
                this$0 = ViewPager.this;
                super();
            }
        };
        mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mItems = new ArrayList();
        mTempItem = new ItemInfo();
        mTempRect = new Rect();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mFirstOffset = -3.402823E+38F;
        mLastOffset = 3.402823E+38F;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mNeedCalculatePageOffsets = false;
        mEndScrollRunnable = new _cls3();
        mScrollState = 0;
        initViewPager();
    }

    private ItemInfo addNewItem(int i, int j)
    {
        ItemInfo iteminfo = new ItemInfo();
        iteminfo.position = i;
        iteminfo.object = mAdapter.instantiateItem(this, i);
        PagerAdapter pageradapter = mAdapter;
        iteminfo.widthFactor = PagerAdapter.getPageWidth(i);
        if (j < 0 || j >= mItems.size())
        {
            mItems.add(iteminfo);
            return iteminfo;
        } else
        {
            mItems.add(j, iteminfo);
            return iteminfo;
        }
    }

    private boolean arrowScroll(int i)
    {
        View view = findFocus();
        if (view != this) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        boolean flag1 = false;
        view = FocusFinder.getInstance().findNextFocus(this, ((View) (obj)), i);
        if (view != null && view != obj)
        {
            if (i == 17)
            {
                int j = getChildRectInPagerCoordinates(mTempRect, view).left;
                int l = getChildRectInPagerCoordinates(mTempRect, ((View) (obj))).left;
                StringBuilder stringbuilder;
                boolean flag;
                if (obj != null && j >= l)
                {
                    flag1 = pageLeft();
                } else
                {
                    flag1 = view.requestFocus();
                }
            } else
            if (i == 66)
            {
                int k = getChildRectInPagerCoordinates(mTempRect, view).left;
                int i1 = getChildRectInPagerCoordinates(mTempRect, ((View) (obj))).left;
                if (obj != null && k <= i1)
                {
                    flag1 = pageRight();
                } else
                {
                    flag1 = view.requestFocus();
                }
            }
        } else
        if (i == 17 || i == 1)
        {
            flag1 = pageLeft();
        } else
        if (i == 66 || i == 2)
        {
            flag1 = pageRight();
        }
        if (flag1)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return flag1;
_L2:
        obj = view;
        if (view == null) goto _L4; else goto _L3
_L3:
        l = 0;
        obj = view.getParent();
_L5:
label0:
        {
            flag = l;
            if (obj instanceof ViewGroup)
            {
                if (obj != this)
                {
                    break label0;
                }
                flag = true;
            }
            obj = view;
            if (!flag)
            {
                stringbuilder = new StringBuilder();
                stringbuilder.append(view.getClass().getSimpleName());
                for (obj = view.getParent(); obj instanceof ViewGroup; obj = ((ViewParent) (obj)).getParent())
                {
                    stringbuilder.append(" => ").append(obj.getClass().getSimpleName());
                }

                break MISSING_BLOCK_LABEL_214;
            }
        }
          goto _L4
        obj = ((ViewParent) (obj)).getParent();
          goto _L5
        Log.e("ViewPager", (new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ")).append(stringbuilder.toString()).toString());
        obj = null;
          goto _L4
    }

    private void calculatePageOffsets(ItemInfo iteminfo, int i, ItemInfo iteminfo1)
    {
        int j2 = mAdapter.getCount();
        int j = getClientWidth();
        float f3;
        if (j > 0)
        {
            f3 = (float)mPageMargin / (float)j;
        } else
        {
            f3 = 0.0F;
        }
        if (iteminfo1 != null)
        {
            j = iteminfo1.position;
            if (j < iteminfo.position)
            {
                int l = 0;
                float f = iteminfo1.offset + iteminfo1.widthFactor + f3;
                int k1;
                for (j++; j <= iteminfo.position && l < mItems.size(); j = k1 + 1)
                {
                    iteminfo1 = (ItemInfo)mItems.get(l);
                    float f4;
                    do
                    {
                        f4 = f;
                        k1 = j;
                        if (j <= iteminfo1.position)
                        {
                            break;
                        }
                        f4 = f;
                        k1 = j;
                        if (l >= mItems.size() - 1)
                        {
                            break;
                        }
                        l++;
                        iteminfo1 = (ItemInfo)mItems.get(l);
                    } while (true);
                    for (; k1 < iteminfo1.position; k1++)
                    {
                        PagerAdapter pageradapter = mAdapter;
                        f4 += PagerAdapter.getPageWidth(k1) + f3;
                    }

                    iteminfo1.offset = f4;
                    f = f4 + (iteminfo1.widthFactor + f3);
                }

            } else
            if (j > iteminfo.position)
            {
                int i1 = mItems.size() - 1;
                float f1 = iteminfo1.offset;
                int l1;
                for (j--; j >= iteminfo.position && i1 >= 0; j = l1 - 1)
                {
                    iteminfo1 = (ItemInfo)mItems.get(i1);
                    float f5;
                    do
                    {
                        f5 = f1;
                        l1 = j;
                        if (j >= iteminfo1.position)
                        {
                            break;
                        }
                        f5 = f1;
                        l1 = j;
                        if (i1 <= 0)
                        {
                            break;
                        }
                        i1--;
                        iteminfo1 = (ItemInfo)mItems.get(i1);
                    } while (true);
                    for (; l1 > iteminfo1.position; l1--)
                    {
                        PagerAdapter pageradapter1 = mAdapter;
                        f5 -= PagerAdapter.getPageWidth(l1) + f3;
                    }

                    f1 = f5 - (iteminfo1.widthFactor + f3);
                    iteminfo1.offset = f1;
                }

            }
        }
        int i2 = mItems.size();
        float f6 = iteminfo.offset;
        j = iteminfo.position - 1;
        float f2;
        int j1;
        if (iteminfo.position == 0)
        {
            f2 = iteminfo.offset;
        } else
        {
            f2 = -3.402823E+38F;
        }
        mFirstOffset = f2;
        if (iteminfo.position == j2 - 1)
        {
            f2 = (iteminfo.offset + iteminfo.widthFactor) - 1.0F;
        } else
        {
            f2 = 3.402823E+38F;
        }
        mLastOffset = f2;
        j1 = i - 1;
        f2 = f6;
        while (j1 >= 0) 
        {
            for (iteminfo1 = (ItemInfo)mItems.get(j1); j > iteminfo1.position; j--)
            {
                PagerAdapter pageradapter2 = mAdapter;
                f2 -= PagerAdapter.getPageWidth(j) + f3;
            }

            f2 -= iteminfo1.widthFactor + f3;
            iteminfo1.offset = f2;
            if (iteminfo1.position == 0)
            {
                mFirstOffset = f2;
            }
            j1--;
            j--;
        }
        f2 = iteminfo.offset + iteminfo.widthFactor + f3;
        j = iteminfo.position + 1;
        j1 = i + 1;
        i = j;
        for (int k = j1; k < i2;)
        {
            for (iteminfo = (ItemInfo)mItems.get(k); i < iteminfo.position; i++)
            {
                iteminfo1 = mAdapter;
                f2 += PagerAdapter.getPageWidth(i) + f3;
            }

            if (iteminfo.position == j2 - 1)
            {
                mLastOffset = (iteminfo.widthFactor + f2) - 1.0F;
            }
            iteminfo.offset = f2;
            f2 += iteminfo.widthFactor + f3;
            k++;
            i++;
        }

        mNeedCalculatePageOffsets = false;
    }

    private boolean canScroll(View view, boolean flag, int i, int j, int k)
    {
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = view.getScrollX();
            int j1 = view.getScrollY();
            for (int l = viewgroup.getChildCount() - 1; l >= 0; l--)
            {
                View view1 = viewgroup.getChildAt(l);
                if (j + i1 >= view1.getLeft() && j + i1 < view1.getRight() && k + j1 >= view1.getTop() && k + j1 < view1.getBottom() && canScroll(view1, true, i, (j + i1) - view1.getLeft(), (k + j1) - view1.getTop()))
                {
                    return true;
                }
            }

        }
        return flag && ViewCompat.canScrollHorizontally(view, -i);
    }

    private void completeScroll(boolean flag)
    {
label0:
        {
            int i;
            boolean flag1;
            boolean flag2;
            if (mScrollState == 2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                setScrollingCacheEnabled(false);
                mScroller.abortAnimation();
                int j = getScrollX();
                int k = getScrollY();
                int l = mScroller.getCurrX();
                int i1 = mScroller.getCurrY();
                if (j != l || k != i1)
                {
                    scrollTo(l, i1);
                }
            }
            mPopulatePending = false;
            flag2 = false;
            flag1 = i;
            for (i = ((flag2) ? 1 : 0); i < mItems.size(); i++)
            {
                ItemInfo iteminfo = (ItemInfo)mItems.get(i);
                if (iteminfo.scrolling)
                {
                    flag1 = true;
                    iteminfo.scrolling = false;
                }
            }

            if (flag1)
            {
                if (!flag)
                {
                    break label0;
                }
                ViewCompat.postOnAnimation(this, mEndScrollRunnable);
            }
            return;
        }
        mEndScrollRunnable.run();
    }

    private int determineTargetPage(int i, float f, int j, int k)
    {
        if (Math.abs(k) > mFlingDistance && Math.abs(j) > mMinimumVelocity)
        {
            if (j <= 0)
            {
                i++;
            }
        } else
        {
            float f1;
            if (i >= mCurItem)
            {
                f1 = 0.4F;
            } else
            {
                f1 = 0.6F;
            }
            i = (int)((float)i + f + f1);
        }
        j = i;
        if (mItems.size() > 0)
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(0);
            ItemInfo iteminfo1 = (ItemInfo)mItems.get(mItems.size() - 1);
            j = Math.max(iteminfo.position, Math.min(i, iteminfo1.position));
        }
        return j;
    }

    private static float distanceInfluenceForSnapDuration(float f)
    {
        return (float)Math.sin((float)((double)(f - 0.5F) * 0.4712389167638204D));
    }

    private void enableLayers(boolean flag)
    {
        int j = getChildCount();
        int i = 0;
        while (i < j) 
        {
            byte byte0;
            if (flag)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            ViewCompat.setLayerType(getChildAt(i), byte0, null);
            i++;
        }
    }

    private void endDrag()
    {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private boolean executeKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 44
    //                   21: 46
    //                   22: 53
    //                   61: 60;
           goto _L2 _L3 _L4 _L5
_L2:
        return false;
_L3:
        return arrowScroll(17);
_L4:
        return arrowScroll(66);
_L5:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            if (KeyEventCompat.hasNoModifiers(keyevent))
            {
                return arrowScroll(2);
            }
            if (KeyEventCompat.hasModifiers(keyevent, 1))
            {
                return arrowScroll(1);
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view)
    {
        Rect rect1 = rect;
        if (rect == null)
        {
            rect1 = new Rect();
        }
        if (view == null)
        {
            rect1.set(0, 0, 0, 0);
        } else
        {
            rect1.left = view.getLeft();
            rect1.right = view.getRight();
            rect1.top = view.getTop();
            rect1.bottom = view.getBottom();
            rect = view.getParent();
            while ((rect instanceof ViewGroup) && rect != this) 
            {
                rect = (ViewGroup)rect;
                rect1.left = rect1.left + rect.getLeft();
                rect1.right = rect1.right + rect.getRight();
                rect1.top = rect1.top + rect.getTop();
                rect1.bottom = rect1.bottom + rect.getBottom();
                rect = rect.getParent();
            }
        }
        return rect1;
    }

    private int getClientWidth()
    {
        return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    private ItemInfo infoForAnyChild(View view)
    {
        do
        {
            ViewParent viewparent = view.getParent();
            if (viewparent != this)
            {
                if (viewparent == null || !(viewparent instanceof View))
                {
                    return null;
                }
                view = (View)viewparent;
            } else
            {
                return infoForChild(view);
            }
        } while (true);
    }

    private ItemInfo infoForChild(View view)
    {
        for (int i = 0; i < mItems.size(); i++)
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(i);
            if (mAdapter.isViewFromObject(view, iteminfo.object))
            {
                return iteminfo;
            }
        }

        return null;
    }

    private ItemInfo infoForCurrentScrollPosition()
    {
        float f1 = 0.0F;
        int i = getClientWidth();
        float f;
        float f2;
        float f3;
        Object obj1;
        boolean flag;
        int j;
        if (i > 0)
        {
            f = (float)getScrollX() / (float)i;
        } else
        {
            f = 0.0F;
        }
        if (i > 0)
        {
            f1 = (float)mPageMargin / (float)i;
        }
        j = -1;
        f2 = 0.0F;
        f3 = 0.0F;
        flag = true;
        obj1 = null;
        i = 0;
        do
        {
            Object obj;
            int k;
label0:
            {
                Object obj2;
label1:
                {
                    obj2 = obj1;
                    if (i >= mItems.size())
                    {
                        break label1;
                    }
                    obj2 = (ItemInfo)mItems.get(i);
                    k = i;
                    obj = obj2;
                    if (!flag)
                    {
                        k = i;
                        obj = obj2;
                        if (((ItemInfo) (obj2)).position != j + 1)
                        {
                            obj = mTempItem;
                            obj.offset = f2 + f3 + f1;
                            obj.position = j + 1;
                            obj2 = mAdapter;
                            obj.widthFactor = PagerAdapter.getPageWidth(((ItemInfo) (obj)).position);
                            k = i - 1;
                        }
                    }
                    f2 = ((ItemInfo) (obj)).offset;
                    f3 = ((ItemInfo) (obj)).widthFactor;
                    if (!flag)
                    {
                        obj2 = obj1;
                        if (f < f2)
                        {
                            break label1;
                        }
                    }
                    if (f >= f3 + f2 + f1 && k != mItems.size() - 1)
                    {
                        break label0;
                    }
                    obj2 = obj;
                }
                return ((ItemInfo) (obj2));
            }
            flag = false;
            j = ((ItemInfo) (obj)).position;
            f3 = ((ItemInfo) (obj)).widthFactor;
            i = k + 1;
            obj1 = obj;
        } while (true);
    }

    private ItemInfo infoForPosition(int i)
    {
        for (int j = 0; j < mItems.size(); j++)
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(j);
            if (iteminfo.position == i)
            {
                return iteminfo;
            }
        }

        return null;
    }

    private void initViewPager()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewconfiguration);
        mMinimumVelocity = (int)(400F * f);
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mLeftEdge = new EdgeEffectCompat(context);
        mRightEdge = new EdgeEffectCompat(context);
        mFlingDistance = (int)(25F * f);
        mCloseEnough = (int)(2.0F * f);
        mDefaultGutterSize = (int)(16F * f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0)
        {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    private boolean isGutterDrag(float f, float f1)
    {
        return f < (float)mGutterSize && f1 > 0.0F || f > (float)(getWidth() - mGutterSize) && f1 < 0.0F;
    }

    private void onPageScrolled(int i, float f, int j)
    {
        if (mDecorChildCount <= 0) goto _L2; else goto _L1
_L1:
        int k;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        i2 = getScrollX();
        k = getPaddingLeft();
        j1 = getPaddingRight();
        j2 = getWidth();
        k2 = getChildCount();
        k1 = 0;
_L12:
        if (k1 >= k2) goto _L2; else goto _L3
_L3:
        View view;
        LayoutParams layoutparams;
        int i1;
        int l1;
        view = getChildAt(k1);
        layoutparams = (LayoutParams)view.getLayoutParams();
        i1 = k;
        l1 = j1;
        if (!layoutparams.isDecor) goto _L5; else goto _L4
_L4:
        layoutparams.gravity & 7;
        JVM INSTR tableswitch 1 5: default 124
    //                   1 203
    //                   2 124
    //                   3 186
    //                   4 124
    //                   5 223;
           goto _L6 _L7 _L6 _L8 _L6 _L9
_L6:
        i1 = k;
_L10:
        int l2 = (i1 + i2) - view.getLeft();
        i1 = k;
        l1 = j1;
        if (l2 != 0)
        {
            view.offsetLeftAndRight(l2);
            l1 = j1;
            i1 = k;
        }
_L5:
        k1++;
        k = i1;
        j1 = l1;
        continue; /* Loop/switch isn't completed */
_L8:
        i1 = k;
        k += view.getWidth();
        continue; /* Loop/switch isn't completed */
_L7:
        i1 = Math.max((j2 - view.getMeasuredWidth()) / 2, k);
        continue; /* Loop/switch isn't completed */
_L9:
        i1 = j2 - j1 - view.getMeasuredWidth();
        j1 += view.getMeasuredWidth();
        if (true) goto _L10; else goto _L2
_L2:
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageScrolled(i, f, j);
        }
        if (mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.onPageScrolled(i, f, j);
        }
        if (mPageTransformer != null)
        {
            j = getScrollX();
            int l = getChildCount();
            for (i = 0; i < l; i++)
            {
                View view1 = getChildAt(i);
                if (!((LayoutParams)view1.getLayoutParams()).isDecor)
                {
                    f = (float)(view1.getLeft() - j) / (float)getClientWidth();
                    mPageTransformer.transformPage(view1, f);
                }
            }

        }
        mCalledSuper = true;
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void onSecondaryPointerUp(MotionEvent motionevent)
    {
        int i = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i) == mActivePointerId)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            mLastMotionX = MotionEventCompat.getX(motionevent, i);
            mActivePointerId = MotionEventCompat.getPointerId(motionevent, i);
            if (mVelocityTracker != null)
            {
                mVelocityTracker.clear();
            }
        }
    }

    private boolean pageLeft()
    {
        if (mCurItem > 0)
        {
            setCurrentItem(mCurItem - 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    private boolean pageRight()
    {
        if (mAdapter != null && mCurItem < mAdapter.getCount() - 1)
        {
            setCurrentItem(mCurItem + 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    private boolean pageScrolled(int i)
    {
        boolean flag = false;
        if (mItems.size() == 0)
        {
            mCalledSuper = false;
            onPageScrolled(0, 0.0F, 0);
            if (!mCalledSuper)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else
        {
            ItemInfo iteminfo = infoForCurrentScrollPosition();
            int k = getClientWidth();
            int l = mPageMargin;
            float f = (float)mPageMargin / (float)k;
            int j = iteminfo.position;
            f = ((float)i / (float)k - iteminfo.offset) / (iteminfo.widthFactor + f);
            i = (int)((float)(k + l) * f);
            mCalledSuper = false;
            onPageScrolled(j, f, i);
            if (!mCalledSuper)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            flag = true;
        }
        return flag;
    }

    private boolean performDrag(float f)
    {
        float f1;
        float f2;
        boolean flag;
        boolean flag1;
        int i;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = false;
        flag3 = false;
        flag2 = false;
        f1 = mLastMotionX;
        mLastMotionX = f;
        f2 = (float)getScrollX() + (f1 - f);
        i = getClientWidth();
        f = (float)i * mFirstOffset;
        f1 = (float)i * mLastOffset;
        flag = true;
        flag1 = true;
        ItemInfo iteminfo = (ItemInfo)mItems.get(0);
        ItemInfo iteminfo1 = (ItemInfo)mItems.get(mItems.size() - 1);
        if (iteminfo.position != 0)
        {
            flag = false;
            f = iteminfo.offset * (float)i;
        }
        if (iteminfo1.position != mAdapter.getCount() - 1)
        {
            flag1 = false;
            f1 = iteminfo1.offset * (float)i;
        }
        if (f2 >= f) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            flag2 = mLeftEdge.onPull(Math.abs(f - f2) / (float)i);
        }
_L4:
        mLastMotionX = mLastMotionX + (f - (float)(int)f);
        scrollTo((int)f, getScrollY());
        pageScrolled((int)f);
        return flag2;
_L2:
        flag2 = flag4;
        f = f2;
        if (f2 > f1)
        {
            flag2 = flag3;
            if (flag1)
            {
                flag2 = mRightEdge.onPull(Math.abs(f2 - f1) / (float)i);
            }
            f = f1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void populate(int i)
    {
        ItemInfo iteminfo2;
        byte byte1;
        iteminfo2 = null;
        byte1 = 2;
        if (mCurItem != i)
        {
            byte byte0;
            if (mCurItem < i)
            {
                byte0 = 66;
            } else
            {
                byte0 = 17;
            }
            iteminfo2 = infoForPosition(mCurItem);
            mCurItem = i;
            byte1 = byte0;
        }
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        sortChildDrawingOrder();
_L4:
        return;
_L2:
        if (mPopulatePending)
        {
            sortChildDrawingOrder();
            return;
        }
        if (getWindowToken() == null) goto _L4; else goto _L3
_L3:
        ItemInfo iteminfo4;
        int i2;
        int j2;
        int k2;
        PagerAdapter pageradapter = mAdapter;
        i = mOffscreenPageLimit;
        k2 = Math.max(0, mCurItem - i);
        i2 = mAdapter.getCount();
        j2 = Math.min(i2 - 1, mCurItem + i);
        if (i2 != mExpectedAdapterCount)
        {
            String s;
            try
            {
                s = getResources().getResourceName(getId());
            }
            catch (android.content.res.Resources.NotFoundException notfoundexception)
            {
                notfoundexception = Integer.toHexString(getId());
            }
            throw new IllegalStateException((new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ")).append(mExpectedAdapterCount).append(", found: ").append(i2).append(" Pager id: ").append(s).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(mAdapter.getClass()).toString());
        }
        iteminfo4 = null;
        i = 0;
_L6:
        int i1;
        int l2;
label0:
        {
            ItemInfo iteminfo = iteminfo4;
            if (i < mItems.size())
            {
                ItemInfo iteminfo5 = (ItemInfo)mItems.get(i);
                if (iteminfo5.position < mCurItem)
                {
                    break MISSING_BLOCK_LABEL_550;
                }
                iteminfo = iteminfo4;
                if (iteminfo5.position == mCurItem)
                {
                    iteminfo = iteminfo5;
                }
            }
            iteminfo4 = iteminfo;
            if (iteminfo == null)
            {
                iteminfo4 = iteminfo;
                if (i2 > 0)
                {
                    iteminfo4 = addNewItem(mCurItem, i);
                }
            }
            if (iteminfo4 == null)
            {
                break MISSING_BLOCK_LABEL_1075;
            }
            float f4 = 0.0F;
            int l1 = i - 1;
            float f2;
            ItemInfo iteminfo6;
            int j1;
            if (l1 >= 0)
            {
                iteminfo = (ItemInfo)mItems.get(l1);
            } else
            {
                iteminfo = null;
            }
            l2 = getClientWidth();
            if (l2 <= 0)
            {
                f2 = 0.0F;
            } else
            {
                f2 = (2.0F - iteminfo4.widthFactor) + (float)getPaddingLeft() / (float)l2;
            }
            j1 = mCurItem - 1;
            iteminfo6 = iteminfo;
            i1 = i;
            do
            {
                if (j1 < 0)
                {
                    break label0;
                }
                float f;
                int j;
                if (f4 >= f2 && j1 < k2)
                {
                    if (iteminfo6 == null)
                    {
                        break label0;
                    }
                    i = i1;
                    f = f4;
                    iteminfo = iteminfo6;
                    j = l1;
                    if (j1 == iteminfo6.position)
                    {
                        i = i1;
                        f = f4;
                        iteminfo = iteminfo6;
                        j = l1;
                        if (!iteminfo6.scrolling)
                        {
                            mItems.remove(l1);
                            mAdapter.destroyItem(this, j1, iteminfo6.object);
                            j = l1 - 1;
                            i = i1 - 1;
                            if (j >= 0)
                            {
                                iteminfo = (ItemInfo)mItems.get(j);
                                f = f4;
                            } else
                            {
                                iteminfo = null;
                                f = f4;
                            }
                        }
                    }
                } else
                if (iteminfo6 != null && j1 == iteminfo6.position)
                {
                    f = f4 + iteminfo6.widthFactor;
                    j = l1 - 1;
                    if (j >= 0)
                    {
                        iteminfo = (ItemInfo)mItems.get(j);
                    } else
                    {
                        iteminfo = null;
                    }
                    i = i1;
                } else
                {
                    f = f4 + addNewItem(j1, l1 + 1).widthFactor;
                    i = i1 + 1;
                    if (l1 >= 0)
                    {
                        iteminfo = (ItemInfo)mItems.get(l1);
                    } else
                    {
                        iteminfo = null;
                    }
                    j = l1;
                }
                j1--;
                i1 = i;
                f4 = f;
                iteminfo6 = iteminfo;
                l1 = j;
            } while (true);
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
label1:
        {
            float f5 = iteminfo4.widthFactor;
            int k1 = i1 + 1;
            if (f5 >= 2.0F)
            {
                break label1;
            }
            float f3;
            ItemInfo iteminfo1;
            ItemInfo iteminfo7;
            int k;
            if (k1 < mItems.size())
            {
                iteminfo1 = (ItemInfo)mItems.get(k1);
            } else
            {
                iteminfo1 = null;
            }
            if (l2 <= 0)
            {
                f3 = 0.0F;
            } else
            {
                f3 = (float)getPaddingRight() / (float)l2 + 2.0F;
            }
            k = mCurItem + 1;
            iteminfo7 = iteminfo1;
            do
            {
                if (k >= i2)
                {
                    break label1;
                }
                float f1;
                if (f5 >= f3 && k > j2)
                {
                    if (iteminfo7 == null)
                    {
                        break label1;
                    }
                    f1 = f5;
                    iteminfo1 = iteminfo7;
                    i = k1;
                    if (k == iteminfo7.position)
                    {
                        f1 = f5;
                        iteminfo1 = iteminfo7;
                        i = k1;
                        if (!iteminfo7.scrolling)
                        {
                            mItems.remove(k1);
                            mAdapter.destroyItem(this, k, iteminfo7.object);
                            if (k1 < mItems.size())
                            {
                                iteminfo1 = (ItemInfo)mItems.get(k1);
                                i = k1;
                                f1 = f5;
                            } else
                            {
                                iteminfo1 = null;
                                f1 = f5;
                                i = k1;
                            }
                        }
                    }
                } else
                if (iteminfo7 != null && k == iteminfo7.position)
                {
                    f1 = f5 + iteminfo7.widthFactor;
                    i = k1 + 1;
                    if (i < mItems.size())
                    {
                        iteminfo1 = (ItemInfo)mItems.get(i);
                    } else
                    {
                        iteminfo1 = null;
                    }
                } else
                {
                    iteminfo1 = addNewItem(k, k1);
                    i = k1 + 1;
                    f1 = f5 + iteminfo1.widthFactor;
                    if (i < mItems.size())
                    {
                        iteminfo1 = (ItemInfo)mItems.get(i);
                    } else
                    {
                        iteminfo1 = null;
                    }
                }
                k++;
                f5 = f1;
                iteminfo7 = iteminfo1;
                k1 = i;
            } while (true);
        }
        calculatePageOffsets(iteminfo4, i1, iteminfo2);
        PagerAdapter pageradapter1 = mAdapter;
        i = mCurItem;
        Object obj;
        int l;
        if (iteminfo4 != null)
        {
            obj = iteminfo4.object;
        } else
        {
            obj = null;
        }
        pageradapter1.setPrimaryItem(this, i, obj);
        mAdapter.finishUpdate(this);
        l = getChildCount();
        for (i = 0; i < l; i++)
        {
            Object obj2 = getChildAt(i);
            obj = (LayoutParams)((View) (obj2)).getLayoutParams();
            obj.childIndex = i;
            if (((LayoutParams) (obj)).isDecor || ((LayoutParams) (obj)).widthFactor != 0.0F)
            {
                continue;
            }
            obj2 = infoForChild(((View) (obj2)));
            if (obj2 != null)
            {
                obj.widthFactor = ((ItemInfo) (obj2)).widthFactor;
                obj.position = ((ItemInfo) (obj2)).position;
            }
        }

        sortChildDrawingOrder();
        if (!hasFocus()) goto _L4; else goto _L7
_L7:
        Object obj1 = findFocus();
        ItemInfo iteminfo3;
        if (obj1 != null)
        {
            obj1 = infoForAnyChild(((View) (obj1)));
        } else
        {
            obj1 = null;
        }
        if (obj1 != null && ((ItemInfo) (obj1)).position == mCurItem) goto _L4; else goto _L8
_L8:
        i = 0;
_L11:
        if (i >= getChildCount()) goto _L4; else goto _L9
_L9:
        obj1 = getChildAt(i);
        iteminfo3 = infoForChild(((View) (obj1)));
        if (iteminfo3 != null && iteminfo3.position == mCurItem && ((View) (obj1)).requestFocus(byte1)) goto _L4; else goto _L10
_L10:
        i++;
          goto _L11
    }

    private void recomputeScrollPosition(int i, int j, int k, int l)
    {
        if (j > 0 && !mItems.isEmpty())
        {
            int i1 = getPaddingLeft();
            int j1 = getPaddingRight();
            int k1 = getPaddingLeft();
            int l1 = getPaddingRight();
            float f = (float)getScrollX() / (float)((j - k1 - l1) + l);
            j = (int)((float)((i - i1 - j1) + k) * f);
            scrollTo(j, getScrollY());
            if (!mScroller.isFinished())
            {
                k = mScroller.getDuration();
                l = mScroller.timePassed();
                ItemInfo iteminfo = infoForPosition(mCurItem);
                mScroller.startScroll(j, 0, (int)(iteminfo.offset * (float)i), 0, k - l);
            }
        } else
        {
            ItemInfo iteminfo1 = infoForPosition(mCurItem);
            float f1;
            if (iteminfo1 != null)
            {
                f1 = Math.min(iteminfo1.offset, mLastOffset);
            } else
            {
                f1 = 0.0F;
            }
            i = (int)((float)(i - getPaddingLeft() - getPaddingRight()) * f1);
            if (i != getScrollX())
            {
                completeScroll(false);
                scrollTo(i, getScrollY());
                return;
            }
        }
    }

    private void removeNonDecorViews()
    {
        int j;
        for (int i = 0; i < getChildCount(); i = j + 1)
        {
            j = i;
            if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
            {
                removeViewAt(i);
                j = i - 1;
            }
        }

    }

    private void requestParentDisallowInterceptTouchEvent(boolean flag)
    {
        ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(flag);
        }
    }

    private void scrollToItem(int i, boolean flag, int j, boolean flag1)
    {
        ItemInfo iteminfo = infoForPosition(i);
        int k = 0;
        if (iteminfo != null)
        {
            k = (int)((float)getClientWidth() * Math.max(mFirstOffset, Math.min(iteminfo.offset, mLastOffset)));
        }
        if (flag)
        {
            smoothScrollTo(k, 0, j);
            if (flag1 && mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageSelected(i);
            }
            if (flag1 && mInternalPageChangeListener != null)
            {
                mInternalPageChangeListener.onPageSelected(i);
            }
            return;
        }
        if (flag1 && mOnPageChangeListener != null)
        {
            mOnPageChangeListener.onPageSelected(i);
        }
        if (flag1 && mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.onPageSelected(i);
        }
        completeScroll(false);
        scrollTo(k, 0);
        pageScrolled(k);
    }

    private void setChildrenDrawingOrderEnabledCompat(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if (mSetChildrenDrawingOrderEnabled == null)
        {
            try
            {
                mSetChildrenDrawingOrderEnabled = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                    Boolean.TYPE
                });
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", nosuchmethodexception);
            }
        }
        mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] {
            Boolean.valueOf(flag)
        });
        return;
        Exception exception;
        exception;
        Log.e("ViewPager", "Error changing children drawing order", exception);
        return;
    }

    private void setCurrentItemInternal(int i, boolean flag, boolean flag1)
    {
        setCurrentItemInternal(i, flag, flag1, 0);
    }

    private void setCurrentItemInternal(int i, boolean flag, boolean flag1, int j)
    {
        boolean flag2;
        flag2 = true;
        if (mAdapter == null || mAdapter.getCount() <= 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!flag1 && mCurItem == i && mItems.size() != 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        i = mOffscreenPageLimit;
        if (k > mCurItem + i || k < mCurItem - i)
        {
            for (i = 0; i < mItems.size(); i++)
            {
                ((ItemInfo)mItems.get(i)).scrolling = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        k = i;
        if (i >= mAdapter.getCount())
        {
            k = mAdapter.getCount() - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mCurItem != k)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        if (mFirstLayout)
        {
            mCurItem = k;
            if (flag1 && mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageSelected(k);
            }
            if (flag1 && mInternalPageChangeListener != null)
            {
                mInternalPageChangeListener.onPageSelected(k);
            }
            requestLayout();
            return;
        } else
        {
            populate(k);
            scrollToItem(k, flag, j, flag1);
            return;
        }
    }

    private void setScrollState(int i)
    {
        if (mScrollState != i)
        {
            mScrollState = i;
            if (mPageTransformer != null)
            {
                boolean flag;
                if (i != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                enableLayers(flag);
            }
            if (mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageScrollStateChanged(i);
                return;
            }
        }
    }

    private void setScrollingCacheEnabled(boolean flag)
    {
        if (mScrollingCacheEnabled != flag)
        {
            mScrollingCacheEnabled = flag;
        }
    }

    private void smoothScrollTo(int i, int j, int k)
    {
        if (getChildCount() == 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        int l = getScrollX();
        int i1 = getScrollY();
        int j1 = i - l;
        j -= i1;
        if (j1 == 0 && j == 0)
        {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        i = getClientWidth();
        int k1 = i / 2;
        float f4 = Math.min(1.0F, (1.0F * (float)Math.abs(j1)) / (float)i);
        float f = k1;
        float f2 = k1;
        f4 = distanceInfluenceForSnapDuration(f4);
        k = Math.abs(k);
        if (k > 0)
        {
            i = Math.round(1000F * Math.abs((f + f2 * f4) / (float)k)) * 4;
        } else
        {
            float f1 = i;
            PagerAdapter pageradapter = mAdapter;
            float f3 = PagerAdapter.getPageWidth(mCurItem);
            i = (int)((1.0F + (float)Math.abs(j1) / ((float)mPageMargin + f1 * f3)) * 100F);
        }
        i = Math.min(i, 600);
        mScroller.startScroll(l, i1, j1, j, i);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void sortChildDrawingOrder()
    {
        if (mDrawingOrder != 0)
        {
            int j;
            if (mDrawingOrderedChildren == null)
            {
                mDrawingOrderedChildren = new ArrayList();
            } else
            {
                mDrawingOrderedChildren.clear();
            }
            j = getChildCount();
            for (int i = 0; i < j; i++)
            {
                View view = getChildAt(i);
                mDrawingOrderedChildren.add(view);
            }

            Collections.sort(mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        int l = arraylist.size();
        int i1 = getDescendantFocusability();
        if (i1 != 0x60000)
        {
            for (int k = 0; k < getChildCount(); k++)
            {
                View view = getChildAt(k);
                if (view.getVisibility() == 0)
                {
                    ItemInfo iteminfo = infoForChild(view);
                    if (iteminfo != null && iteminfo.position == mCurItem)
                    {
                        view.addFocusables(arraylist, i, j);
                    }
                }
            }

        }
        while (i1 == 0x40000 && l != arraylist.size() || !isFocusable() || (j & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode() || arraylist == null) 
        {
            return;
        }
        arraylist.add(this);
    }

    public void addTouchables(ArrayList arraylist)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view);
            if (iteminfo != null && iteminfo.position == mCurItem)
            {
                view.addTouchables(arraylist);
            }
        }

    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = layoutparams;
        if (!checkLayoutParams(layoutparams))
        {
            layoutparams1 = generateLayoutParams(layoutparams);
        }
        layoutparams = (LayoutParams)layoutparams1;
        layoutparams.isDecor = ((LayoutParams) (layoutparams)).isDecor | (view instanceof Decor);
        if (mInLayout)
        {
            if (layoutparams != null && ((LayoutParams) (layoutparams)).isDecor)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                layoutparams.needsMeasure = true;
                addViewInLayout(view, i, layoutparams1);
                return;
            }
        } else
        {
            super.addView(view, i, layoutparams1);
            return;
        }
    }

    public boolean canScrollHorizontally(int i)
    {
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j;
        int k;
        j = getClientWidth();
        k = getScrollX();
        if (i >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k <= (int)((float)j * mFirstOffset)) goto _L1; else goto _L3
_L3:
        return true;
        if (i <= 0 || k >= (int)((float)j * mLastOffset)) goto _L1; else goto _L4
_L4:
        return true;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!mScroller.isFinished() && mScroller.computeScrollOffset())
        {
            int i = getScrollX();
            int j = getScrollY();
            int k = mScroller.getCurrX();
            int l = mScroller.getCurrY();
            if (i != k || j != l)
            {
                scrollTo(k, l);
                if (!pageScrolled(k))
                {
                    mScroller.abortAnimation();
                    scrollTo(0, l);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        } else
        {
            completeScroll(true);
            return;
        }
    }

    final void dataSetChanged()
    {
        int l2 = mAdapter.getCount();
        mExpectedAdapterCount = l2;
        int i;
        int k;
        int l;
        int k1;
        int j2;
        if (mItems.size() < (mOffscreenPageLimit << 1) + 1 && mItems.size() < l2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        k = mCurItem;
        l = 0;
        k1 = 0;
        j2 = i;
        while (k1 < mItems.size()) 
        {
            ItemInfo iteminfo = (ItemInfo)mItems.get(k1);
            int k2 = mAdapter.getItemPosition(iteminfo.object);
            int i2 = k1;
            int l1 = l;
            i = j2;
            int j1 = k;
            if (k2 != -1)
            {
                if (k2 == -2)
                {
                    mItems.remove(k1);
                    j2 = k1 - 1;
                    k1 = l;
                    if (l == 0)
                    {
                        PagerAdapter pageradapter = mAdapter;
                        k1 = 1;
                    }
                    mAdapter.destroyItem(this, iteminfo.position, iteminfo.object);
                    i = 1;
                    i2 = j2;
                    l1 = k1;
                    j1 = k;
                    if (mCurItem == iteminfo.position)
                    {
                        j1 = Math.max(0, Math.min(mCurItem, l2 - 1));
                        i = 1;
                        l1 = k1;
                        i2 = j2;
                    }
                } else
                {
                    i2 = k1;
                    l1 = l;
                    i = j2;
                    j1 = k;
                    if (iteminfo.position != k2)
                    {
                        if (iteminfo.position == mCurItem)
                        {
                            k = k2;
                        }
                        iteminfo.position = k2;
                        i = 1;
                        i2 = k1;
                        l1 = l;
                        j1 = k;
                    }
                }
            }
            k1 = i2 + 1;
            l = l1;
            j2 = i;
            k = j1;
        }
        if (l != 0)
        {
            mAdapter.finishUpdate(this);
        }
        Collections.sort(mItems, COMPARATOR);
        if (j2 != 0)
        {
            int i1 = getChildCount();
            for (int j = 0; j < i1; j++)
            {
                LayoutParams layoutparams = (LayoutParams)getChildAt(j).getLayoutParams();
                if (!layoutparams.isDecor)
                {
                    layoutparams.widthFactor = 0.0F;
                }
            }

            setCurrentItemInternal(k, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        if (accessibilityevent.getEventType() == 4096)
        {
            return super.dispatchPopulateAccessibilityEvent(accessibilityevent);
        }
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view);
            if (iteminfo != null && iteminfo.position == mCurItem && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
            {
                return true;
            }
        }

        return false;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int j = 0;
        int i = 0;
        int k = ViewCompat.getOverScrollMode(this);
        if (k == 0 || k == 1 && mAdapter != null && mAdapter.getCount() > 1)
        {
            if (!mLeftEdge.isFinished())
            {
                j = canvas.save();
                i = getHeight() - getPaddingTop() - getPaddingBottom();
                int l = getWidth();
                canvas.rotate(270F);
                canvas.translate(-i + getPaddingTop(), mFirstOffset * (float)l);
                mLeftEdge.setSize(i, l);
                i = mLeftEdge.draw(canvas) | false;
                canvas.restoreToCount(j);
            }
            j = i;
            if (!mRightEdge.isFinished())
            {
                int i1 = canvas.save();
                j = getWidth();
                int j1 = getHeight();
                int k1 = getPaddingTop();
                int l1 = getPaddingBottom();
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -(mLastOffset + 1.0F) * (float)j);
                mRightEdge.setSize(j1 - k1 - l1, j);
                j = i | mRightEdge.draw(canvas);
                canvas.restoreToCount(i1);
            }
        } else
        {
            mLeftEdge.finish();
            mRightEdge.finish();
        }
        if (j != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = mMarginDrawable;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    public final PagerAdapter getAdapter()
    {
        return mAdapter;
    }

    protected int getChildDrawingOrder(int i, int j)
    {
        if (mDrawingOrder == 2)
        {
            i = i - 1 - j;
        } else
        {
            i = j;
        }
        return ((LayoutParams)((View)mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
    }

    public final int getCurrentItem()
    {
        return mCurItem;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mPageMargin > 0 && mMarginDrawable != null && mItems.size() > 0 && mAdapter != null)
        {
            int k = getScrollX();
            int l = getWidth();
            float f2 = (float)mPageMargin / (float)l;
            int j = 0;
            Object obj = (ItemInfo)mItems.get(0);
            float f = ((ItemInfo) (obj)).offset;
            int i1 = mItems.size();
            int i = ((ItemInfo) (obj)).position;
            int j1 = ((ItemInfo)mItems.get(i1 - 1)).position;
            do
            {
                if (i >= j1)
                {
                    break;
                }
                for (; i > ((ItemInfo) (obj)).position && j < i1; obj = (ItemInfo)((ArrayList) (obj)).get(j))
                {
                    obj = mItems;
                    j++;
                }

                float f1;
                if (i == ((ItemInfo) (obj)).position)
                {
                    f1 = (((ItemInfo) (obj)).offset + ((ItemInfo) (obj)).widthFactor) * (float)l;
                    f = ((ItemInfo) (obj)).offset + ((ItemInfo) (obj)).widthFactor + f2;
                } else
                {
                    PagerAdapter pageradapter = mAdapter;
                    float f3 = PagerAdapter.getPageWidth(i);
                    f1 = (f + f3) * (float)l;
                    f += f3 + f2;
                }
                if ((float)mPageMargin + f1 > (float)k)
                {
                    mMarginDrawable.setBounds((int)f1, mTopPageBounds, (int)((float)mPageMargin + f1 + 0.5F), mBottomPageBounds);
                    mMarginDrawable.draw(canvas);
                }
                if (f1 > (float)(k + l))
                {
                    break;
                }
                i++;
            } while (true);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        i = motionevent.getAction() & 0xff;
        if (i == 3 || i == 1)
        {
            mIsBeingDragged = false;
            mIsUnableToDrag = false;
            mActivePointerId = -1;
            if (mVelocityTracker != null)
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
            return false;
        }
        if (i != 0)
        {
            if (mIsBeingDragged)
            {
                return true;
            }
            if (mIsUnableToDrag)
            {
                return false;
            }
        }
        i;
        JVM INSTR lookupswitch 3: default 116
    //                   0: 381
    //                   2: 143
    //                   6: 513;
           goto _L1 _L2 _L3 _L4
_L1:
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        return mIsBeingDragged;
_L3:
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int j = mActivePointerId;
        if (j == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = MotionEventCompat.findPointerIndex(motionevent, j);
        f2 = MotionEventCompat.getX(motionevent, j);
        f = f2 - mLastMotionX;
        f4 = Math.abs(f);
        f3 = MotionEventCompat.getY(motionevent, j);
        f5 = Math.abs(f3 - mInitialMotionY);
        if (f != 0.0F && !isGutterDrag(mLastMotionX, f) && canScroll(this, false, (int)f, (int)f2, (int)f3))
        {
            mLastMotionX = f2;
            mLastMotionY = f3;
            mIsUnableToDrag = true;
            return false;
        }
        if (f4 <= (float)mTouchSlop || 0.5F * f4 <= f5) goto _L6; else goto _L5
_L5:
        mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        if (f > 0.0F)
        {
            f = mInitialMotionX + (float)mTouchSlop;
        } else
        {
            f = mInitialMotionX - (float)mTouchSlop;
        }
        mLastMotionX = f;
        mLastMotionY = f3;
        setScrollingCacheEnabled(true);
_L7:
        if (mIsBeingDragged && performDrag(f2))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (f5 > (float)mTouchSlop)
        {
            mIsUnableToDrag = true;
        }
        if (true) goto _L7; else goto _L2
_L2:
        float f1 = motionevent.getX();
        mInitialMotionX = f1;
        mLastMotionX = f1;
        f1 = motionevent.getY();
        mInitialMotionY = f1;
        mLastMotionY = f1;
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, 0);
        mIsUnableToDrag = false;
        mScroller.computeScrollOffset();
        if (mScrollState == 2 && Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) > mCloseEnough)
        {
            mScroller.abortAnimation();
            mPopulatePending = false;
            populate();
            mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
        } else
        {
            completeScroll(false);
            mIsBeingDragged = false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        onSecondaryPointerUp(motionevent);
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1;
        int l1;
        int i2;
        int i3;
        int j3;
        int k3;
        int l3;
        i3 = getChildCount();
        k3 = k - i;
        j3 = l - j;
        j = getPaddingLeft();
        i = getPaddingTop();
        i1 = getPaddingRight();
        l = getPaddingBottom();
        l3 = getScrollX();
        l1 = 0;
        i2 = 0;
_L17:
        if (i2 >= i3) goto _L2; else goto _L1
_L1:
        View view;
        int j1;
        int j2;
        int k2;
        int l2;
        view = getChildAt(i2);
        l2 = l1;
        k2 = l;
        j1 = j;
        j2 = i1;
        k = i;
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        LayoutParams layoutparams;
        layoutparams = (LayoutParams)view.getLayoutParams();
        l2 = l1;
        k2 = l;
        j1 = j;
        j2 = i1;
        k = i;
        if (!layoutparams.isDecor) goto _L4; else goto _L5
_L5:
        k = layoutparams.gravity;
        j2 = layoutparams.gravity;
        k & 7;
        JVM INSTR tableswitch 1 5: default 184
    //                   1 319
    //                   2 184
    //                   3 304
    //                   4 184
    //                   5 341;
           goto _L6 _L7 _L6 _L8 _L6 _L9
_L6:
        k = j;
        j1 = j;
_L14:
        j2 & 0x70;
        JVM INSTR lookupswitch 3: default 228
    //                   16: 383
    //                   48: 370
    //                   80: 401;
           goto _L10 _L11 _L12 _L13
_L10:
        j = i;
_L15:
        k += l3;
        view.layout(k, j, view.getMeasuredWidth() + k, view.getMeasuredHeight() + j);
        l2 = l1 + 1;
        k = i;
        j2 = i1;
        k2 = l;
_L4:
        i2++;
        l1 = l2;
        l = k2;
        j = j1;
        i1 = j2;
        i = k;
        continue; /* Loop/switch isn't completed */
_L8:
        k = j;
        j1 = j + view.getMeasuredWidth();
          goto _L14
_L7:
        k = Math.max((k3 - view.getMeasuredWidth()) / 2, j);
        j1 = j;
          goto _L14
_L9:
        k = k3 - i1 - view.getMeasuredWidth();
        i1 += view.getMeasuredWidth();
        j1 = j;
          goto _L14
_L12:
        j = i;
        i += view.getMeasuredHeight();
          goto _L15
_L11:
        j = Math.max((j3 - view.getMeasuredHeight()) / 2, i);
          goto _L15
_L13:
        j = j3 - l - view.getMeasuredHeight();
        l += view.getMeasuredHeight();
          goto _L15
_L2:
        i1 = k3 - j - i1;
        for (k = 0; k < i3; k++)
        {
            View view1 = getChildAt(k);
            if (view1.getVisibility() == 8)
            {
                continue;
            }
            LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
            if (layoutparams1.isDecor)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view1);
            if (iteminfo == null)
            {
                continue;
            }
            int k1 = j + (int)((float)i1 * iteminfo.offset);
            if (layoutparams1.needsMeasure)
            {
                layoutparams1.needsMeasure = false;
                view1.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)i1 * layoutparams1.widthFactor), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j3 - i - l, 0x40000000));
            }
            view1.layout(k1, i, view1.getMeasuredWidth() + k1, view1.getMeasuredHeight() + i);
        }

        mTopPageBounds = i;
        mBottomPageBounds = j3 - l;
        mDecorChildCount = l1;
        if (mFirstLayout)
        {
            scrollToItem(mCurItem, false, 0, false);
        }
        mFirstLayout = false;
        return;
        if (true) goto _L17; else goto _L16
_L16:
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, j));
        i = getMeasuredWidth();
        mGutterSize = Math.min(i / 10, mDefaultGutterSize);
        i = i - getPaddingLeft() - getPaddingRight();
        j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int i3 = getChildCount();
        int j1 = 0;
        do
        {
            if (j1 < i3)
            {
                View view = getChildAt(j1);
                int k = j;
                int i1 = i;
                if (view.getVisibility() != 8)
                {
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    k = j;
                    i1 = i;
                    if (layoutparams != null)
                    {
                        k = j;
                        i1 = i;
                        if (layoutparams.isDecor)
                        {
                            i1 = layoutparams.gravity & 7;
                            int k1 = layoutparams.gravity & 0x70;
                            int l1 = 0x80000000;
                            k = 0x80000000;
                            boolean flag;
                            boolean flag1;
                            int i2;
                            int j2;
                            if (k1 == 48 || k1 == 80)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (i1 == 3 || i1 == 5)
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (flag)
                            {
                                i1 = 0x40000000;
                            } else
                            {
                                i1 = l1;
                                if (flag1)
                                {
                                    k = 0x40000000;
                                    i1 = l1;
                                }
                            }
                            j2 = i;
                            l1 = j;
                            i2 = j2;
                            if (layoutparams.width != -2)
                            {
                                int k2 = 0x40000000;
                                i1 = k2;
                                i2 = j2;
                                if (layoutparams.width != -1)
                                {
                                    i2 = layoutparams.width;
                                    i1 = k2;
                                }
                            }
                            j2 = l1;
                            if (layoutparams.height != -2)
                            {
                                int l2 = 0x40000000;
                                k = l2;
                                j2 = l1;
                                if (layoutparams.height != -1)
                                {
                                    j2 = layoutparams.height;
                                    k = l2;
                                }
                            }
                            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i2, i1), android.view.View.MeasureSpec.makeMeasureSpec(j2, k));
                            if (flag)
                            {
                                k = j - view.getMeasuredHeight();
                                i1 = i;
                            } else
                            {
                                k = j;
                                i1 = i;
                                if (flag1)
                                {
                                    i1 = i - view.getMeasuredWidth();
                                    k = j;
                                }
                            }
                        }
                    }
                }
                j1++;
                j = k;
                i = i1;
                continue;
            }
            mChildWidthMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
            mChildHeightMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            mInLayout = true;
            populate();
            mInLayout = false;
            int l = getChildCount();
            for (j = 0; j < l; j++)
            {
                View view1 = getChildAt(j);
                if (view1.getVisibility() == 8)
                {
                    continue;
                }
                LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
                if (layoutparams1 == null || !layoutparams1.isDecor)
                {
                    view1.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)i * layoutparams1.widthFactor), 0x40000000), mChildHeightMeasureSpec);
                }
            }

            return;
        } while (true);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        int k = getChildCount();
        int j;
        byte byte0;
        if ((i & 2) != 0)
        {
            j = 0;
            byte0 = 1;
        } else
        {
            j = k - 1;
            byte0 = -1;
            k = -1;
        }
        for (; j != k; j += byte0)
        {
            View view = getChildAt(j);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ItemInfo iteminfo = infoForChild(view);
            if (iteminfo != null && iteminfo.position == mCurItem && view.requestFocus(i, rect))
            {
                return true;
            }
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (mAdapter != null)
        {
            mAdapter.restoreState(((SavedState) (parcelable)).adapterState, ((SavedState) (parcelable)).loader);
            setCurrentItemInternal(((SavedState) (parcelable)).position, false, true);
            return;
        } else
        {
            mRestoredCurItem = ((SavedState) (parcelable)).position;
            mRestoredAdapterState = ((SavedState) (parcelable)).adapterState;
            mRestoredClassLoader = ((SavedState) (parcelable)).loader;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.position = mCurItem;
        if (mAdapter != null)
        {
            savedstate.adapterState = mAdapter.saveState();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k)
        {
            recomputeScrollPosition(i, k, mPageMargin, mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        int j;
        int k;
        if (mFakeDragging)
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (mAdapter == null || mAdapter.getCount() == 0)
        {
            return false;
        }
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        k = motionevent.getAction();
        j = 0;
        i = j;
        k & 0xff;
        JVM INSTR tableswitch 0 6: default 128
    //                   0 143
    //                   1 396
    //                   2 205
    //                   3 546
    //                   4 132
    //                   5 597
    //                   6 630;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L1:
        i = j;
_L10:
        if (i != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
_L2:
        mScroller.abortAnimation();
        mPopulatePending = false;
        populate();
        float f = motionevent.getX();
        mInitialMotionX = f;
        mLastMotionX = f;
        f = motionevent.getY();
        mInitialMotionY = f;
        mLastMotionY = f;
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, 0);
        i = j;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!mIsBeingDragged)
        {
            i = MotionEventCompat.findPointerIndex(motionevent, mActivePointerId);
            float f1 = MotionEventCompat.getX(motionevent, i);
            float f3 = Math.abs(f1 - mLastMotionX);
            float f2 = MotionEventCompat.getY(motionevent, i);
            float f4 = Math.abs(f2 - mLastMotionY);
            if (f3 > (float)mTouchSlop && f3 > f4)
            {
                mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                ViewParent viewparent;
                if (f1 - mInitialMotionX > 0.0F)
                {
                    f1 = mInitialMotionX + (float)mTouchSlop;
                } else
                {
                    f1 = mInitialMotionX - (float)mTouchSlop;
                }
                mLastMotionX = f1;
                mLastMotionY = f2;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                viewparent = getParent();
                if (viewparent != null)
                {
                    viewparent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        i = j;
        if (mIsBeingDragged)
        {
            i = performDrag(MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId))) | false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i = j;
        if (mIsBeingDragged)
        {
            Object obj = mVelocityTracker;
            ((VelocityTracker) (obj)).computeCurrentVelocity(1000, mMaximumVelocity);
            i = (int)VelocityTrackerCompat.getXVelocity(((VelocityTracker) (obj)), mActivePointerId);
            mPopulatePending = true;
            j = getClientWidth();
            int l = getScrollX();
            obj = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(((ItemInfo) (obj)).position, ((float)l / (float)j - ((ItemInfo) (obj)).offset) / ((ItemInfo) (obj)).widthFactor, i, (int)(MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId)) - mInitialMotionX)), true, true, i);
            mActivePointerId = -1;
            endDrag();
            i = mLeftEdge.onRelease() | mRightEdge.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i = j;
        if (mIsBeingDragged)
        {
            scrollToItem(mCurItem, true, 0, false);
            mActivePointerId = -1;
            endDrag();
            i = mLeftEdge.onRelease() | mRightEdge.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        i = MotionEventCompat.getActionIndex(motionevent);
        mLastMotionX = MotionEventCompat.getX(motionevent, i);
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, i);
        i = j;
        continue; /* Loop/switch isn't completed */
_L8:
        onSecondaryPointerUp(motionevent);
        mLastMotionX = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId));
        i = j;
        if (true) goto _L10; else goto _L9
_L9:
    }

    final void populate()
    {
        populate(mCurItem);
    }

    public void removeView(View view)
    {
        if (mInLayout)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(PagerAdapter pageradapter)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mObserver);
            PagerAdapter pageradapter1 = mAdapter;
            for (int i = 0; i < mItems.size(); i++)
            {
                ItemInfo iteminfo = (ItemInfo)mItems.get(i);
                mAdapter.destroyItem(this, iteminfo.position, iteminfo.object);
            }

            mAdapter.finishUpdate(this);
            mItems.clear();
            removeNonDecorViews();
            mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pageradapter2 = mAdapter;
        mAdapter = pageradapter;
        mExpectedAdapterCount = 0;
        if (mAdapter != null)
        {
            if (mObserver == null)
            {
                mObserver = new PagerObserver();
            }
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            boolean flag = mFirstLayout;
            mFirstLayout = true;
            mExpectedAdapterCount = mAdapter.getCount();
            if (mRestoredCurItem >= 0)
            {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } else
            if (!flag)
            {
                populate();
            } else
            {
                requestLayout();
            }
        }
        if (mAdapterChangeListener != null && pageradapter2 != pageradapter)
        {
            mAdapterChangeListener.onAdapterChanged(pageradapter2, pageradapter);
        }
    }

    public void setCurrentItem(int i)
    {
        mPopulatePending = false;
        boolean flag;
        if (!mFirstLayout)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setCurrentItemInternal(i, flag, false);
    }

    public void setCurrentItem(int i, boolean flag)
    {
        mPopulatePending = false;
        setCurrentItemInternal(i, flag, false);
    }

    final OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        OnPageChangeListener onpagechangelistener1 = mInternalPageChangeListener;
        mInternalPageChangeListener = onpagechangelistener;
        return onpagechangelistener1;
    }

    public void setOffscreenPageLimit(int i)
    {
        int j = i;
        if (i <= 0)
        {
            Log.w("ViewPager", (new StringBuilder("Requested offscreen page limit ")).append(i).append(" too small; defaulting to 1").toString());
            j = 1;
        }
        if (j != mOffscreenPageLimit)
        {
            mOffscreenPageLimit = j;
            populate();
        }
    }

    final void setOnAdapterChangeListener(OnAdapterChangeListener onadapterchangelistener)
    {
        mAdapterChangeListener = onadapterchangelistener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        mOnPageChangeListener = onpagechangelistener;
    }

    public void setPageMargin(int i)
    {
        int j = mPageMargin;
        mPageMargin = i;
        int k = getWidth();
        recomputeScrollPosition(k, k, i, j);
        requestLayout();
    }

    public void setPageMarginDrawable(int i)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        mMarginDrawable = drawable;
        if (drawable != null)
        {
            refreshDrawableState();
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setPageTransformer(boolean flag, PageTransformer pagetransformer)
    {
        int i = 1;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (pagetransformer != null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (mPageTransformer != null)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag2 != flag3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            mPageTransformer = pagetransformer;
            setChildrenDrawingOrderEnabledCompat(flag2);
            if (flag2)
            {
                if (flag)
                {
                    i = 2;
                }
                mDrawingOrder = i;
            } else
            {
                mDrawingOrder = 0;
            }
            if (flag1)
            {
                populate();
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == mMarginDrawable;
    }





}
