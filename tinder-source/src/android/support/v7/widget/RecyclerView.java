// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.e.d;
import android.support.v4.view.a.a;
import android.support.v4.view.a.c;
import android.support.v4.view.a.g;
import android.support.v4.view.ab;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.support.v4.view.w;
import android.support.v4.view.x;
import android.support.v4.widget.i;
import android.support.v4.widget.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            DefaultItemAnimator, RecyclerViewAccessibilityDelegate, ChildHelper, AdapterHelper

public class RecyclerView extends ViewGroup
    implements o, u
{
    public static abstract class Adapter
    {

        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();

        public final void bindViewHolder(ViewHolder viewholder, int j)
        {
            viewholder.mPosition = j;
            if (hasStableIds())
            {
                viewholder.mItemId = getItemId(j);
            }
            viewholder.setFlags(1, 519);
            d.a("RV OnBindView");
            onBindViewHolder(viewholder, j, viewholder.getUnmodifiedPayloads());
            viewholder.clearPayload();
            d.a();
        }

        public final ViewHolder createViewHolder(ViewGroup viewgroup, int j)
        {
            d.a("RV CreateView");
            viewgroup = onCreateViewHolder(viewgroup, j);
            viewgroup.mItemViewType = j;
            d.a();
            return viewgroup;
        }

        public abstract int getItemCount();

        public long getItemId(int j)
        {
            return -1L;
        }

        public int getItemViewType(int j)
        {
            return 0;
        }

        public final boolean hasObservers()
        {
            return mObservable.hasObservers();
        }

        public final boolean hasStableIds()
        {
            return mHasStableIds;
        }

        public final void notifyDataSetChanged()
        {
            mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int j)
        {
            mObservable.notifyItemRangeChanged(j, 1);
        }

        public final void notifyItemChanged(int j, Object obj)
        {
            mObservable.notifyItemRangeChanged(j, 1, obj);
        }

        public final void notifyItemInserted(int j)
        {
            mObservable.notifyItemRangeInserted(j, 1);
        }

        public final void notifyItemMoved(int j, int k)
        {
            mObservable.notifyItemMoved(j, k);
        }

        public final void notifyItemRangeChanged(int j, int k)
        {
            mObservable.notifyItemRangeChanged(j, k);
        }

        public final void notifyItemRangeChanged(int j, int k, Object obj)
        {
            mObservable.notifyItemRangeChanged(j, k, obj);
        }

        public final void notifyItemRangeInserted(int j, int k)
        {
            mObservable.notifyItemRangeInserted(j, k);
        }

        public final void notifyItemRangeRemoved(int j, int k)
        {
            mObservable.notifyItemRangeRemoved(j, k);
        }

        public final void notifyItemRemoved(int j)
        {
            mObservable.notifyItemRangeRemoved(j, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerview)
        {
        }

        public abstract void onBindViewHolder(ViewHolder viewholder, int j);

        public void onBindViewHolder(ViewHolder viewholder, int j, List list)
        {
            onBindViewHolder(viewholder, j);
        }

        public abstract ViewHolder onCreateViewHolder(ViewGroup viewgroup, int j);

        public void onDetachedFromRecyclerView(RecyclerView recyclerview)
        {
        }

        public boolean onFailedToRecycleView(ViewHolder viewholder)
        {
            return false;
        }

        public void onViewAttachedToWindow(ViewHolder viewholder)
        {
        }

        public void onViewDetachedFromWindow(ViewHolder viewholder)
        {
        }

        public void onViewRecycled(ViewHolder viewholder)
        {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterdataobserver)
        {
            mObservable.registerObserver(adapterdataobserver);
        }

        public void setHasStableIds(boolean flag)
        {
            if (hasObservers())
            {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            } else
            {
                mHasStableIds = flag;
                return;
            }
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterdataobserver)
        {
            mObservable.unregisterObserver(adapterdataobserver);
        }

        public Adapter()
        {
            mHasStableIds = false;
        }
    }

    static class AdapterDataObservable extends Observable
    {

        public boolean hasObservers()
        {
            return !mObservers.isEmpty();
        }

        public void notifyChanged()
        {
            for (int j = mObservers.size() - 1; j >= 0; j--)
            {
                ((AdapterDataObserver)mObservers.get(j)).onChanged();
            }

        }

        public void notifyItemMoved(int j, int k)
        {
            for (int l = mObservers.size() - 1; l >= 0; l--)
            {
                ((AdapterDataObserver)mObservers.get(l)).onItemRangeMoved(j, k, 1);
            }

        }

        public void notifyItemRangeChanged(int j, int k)
        {
            notifyItemRangeChanged(j, k, null);
        }

        public void notifyItemRangeChanged(int j, int k, Object obj)
        {
            for (int l = mObservers.size() - 1; l >= 0; l--)
            {
                ((AdapterDataObserver)mObservers.get(l)).onItemRangeChanged(j, k, obj);
            }

        }

        public void notifyItemRangeInserted(int j, int k)
        {
            for (int l = mObservers.size() - 1; l >= 0; l--)
            {
                ((AdapterDataObserver)mObservers.get(l)).onItemRangeInserted(j, k);
            }

        }

        public void notifyItemRangeRemoved(int j, int k)
        {
            for (int l = mObservers.size() - 1; l >= 0; l--)
            {
                ((AdapterDataObserver)mObservers.get(l)).onItemRangeRemoved(j, k);
            }

        }

        AdapterDataObservable()
        {
        }
    }

    public static abstract class AdapterDataObserver
    {

        public void onChanged()
        {
        }

        public void onItemRangeChanged(int j, int k)
        {
        }

        public void onItemRangeChanged(int j, int k, Object obj)
        {
            onItemRangeChanged(j, k);
        }

        public void onItemRangeInserted(int j, int k)
        {
        }

        public void onItemRangeMoved(int j, int k, int l)
        {
        }

        public void onItemRangeRemoved(int j, int k)
        {
        }

        public AdapterDataObserver()
        {
        }
    }

    public static interface ChildDrawingOrderCallback
    {

        public abstract int onGetChildDrawingOrder(int j, int k);
    }

    public static abstract class ItemAnimator
    {

        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;
        private boolean mSupportsChangeAnimations;

        public abstract boolean animateAdd(ViewHolder viewholder);

        public abstract boolean animateChange(ViewHolder viewholder, ViewHolder viewholder1, int j, int k, int l, int i1);

        public abstract boolean animateMove(ViewHolder viewholder, int j, int k, int l, int i1);

        public abstract boolean animateRemove(ViewHolder viewholder);

        public final void dispatchAddFinished(ViewHolder viewholder)
        {
            onAddFinished(viewholder);
            if (mListener != null)
            {
                mListener.onAddFinished(viewholder);
            }
        }

        public final void dispatchAddStarting(ViewHolder viewholder)
        {
            onAddStarting(viewholder);
        }

        public final void dispatchAnimationsFinished()
        {
            int k = mFinishedListeners.size();
            for (int j = 0; j < k; j++)
            {
                ((ItemAnimatorFinishedListener)mFinishedListeners.get(j)).onAnimationsFinished();
            }

            mFinishedListeners.clear();
        }

        public final void dispatchChangeFinished(ViewHolder viewholder, boolean flag)
        {
            onChangeFinished(viewholder, flag);
            if (mListener != null)
            {
                mListener.onChangeFinished(viewholder);
            }
        }

        public final void dispatchChangeStarting(ViewHolder viewholder, boolean flag)
        {
            onChangeStarting(viewholder, flag);
        }

        public final void dispatchMoveFinished(ViewHolder viewholder)
        {
            onMoveFinished(viewholder);
            if (mListener != null)
            {
                mListener.onMoveFinished(viewholder);
            }
        }

        public final void dispatchMoveStarting(ViewHolder viewholder)
        {
            onMoveStarting(viewholder);
        }

        public final void dispatchRemoveFinished(ViewHolder viewholder)
        {
            onRemoveFinished(viewholder);
            if (mListener != null)
            {
                mListener.onRemoveFinished(viewholder);
            }
        }

        public final void dispatchRemoveStarting(ViewHolder viewholder)
        {
            onRemoveStarting(viewholder);
        }

        public abstract void endAnimation(ViewHolder viewholder);

        public abstract void endAnimations();

        public long getAddDuration()
        {
            return mAddDuration;
        }

        public long getChangeDuration()
        {
            return mChangeDuration;
        }

        public long getMoveDuration()
        {
            return mMoveDuration;
        }

        public long getRemoveDuration()
        {
            return mRemoveDuration;
        }

        public boolean getSupportsChangeAnimations()
        {
            return mSupportsChangeAnimations;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(ItemAnimatorFinishedListener itemanimatorfinishedlistener)
        {
            boolean flag;
label0:
            {
                flag = isRunning();
                if (itemanimatorfinishedlistener != null)
                {
                    if (flag)
                    {
                        break label0;
                    }
                    itemanimatorfinishedlistener.onAnimationsFinished();
                }
                return flag;
            }
            mFinishedListeners.add(itemanimatorfinishedlistener);
            return flag;
        }

        public void onAddFinished(ViewHolder viewholder)
        {
        }

        public void onAddStarting(ViewHolder viewholder)
        {
        }

        public void onChangeFinished(ViewHolder viewholder, boolean flag)
        {
        }

        public void onChangeStarting(ViewHolder viewholder, boolean flag)
        {
        }

        public void onMoveFinished(ViewHolder viewholder)
        {
        }

        public void onMoveStarting(ViewHolder viewholder)
        {
        }

        public void onRemoveFinished(ViewHolder viewholder)
        {
        }

        public void onRemoveStarting(ViewHolder viewholder)
        {
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long l)
        {
            mAddDuration = l;
        }

        public void setChangeDuration(long l)
        {
            mChangeDuration = l;
        }

        void setListener(ItemAnimatorListener itemanimatorlistener)
        {
            mListener = itemanimatorlistener;
        }

        public void setMoveDuration(long l)
        {
            mMoveDuration = l;
        }

        public void setRemoveDuration(long l)
        {
            mRemoveDuration = l;
        }

        public void setSupportsChangeAnimations(boolean flag)
        {
            mSupportsChangeAnimations = flag;
        }

        public ItemAnimator()
        {
            mListener = null;
            mFinishedListeners = new ArrayList();
            mAddDuration = 120L;
            mRemoveDuration = 120L;
            mMoveDuration = 250L;
            mChangeDuration = 250L;
            mSupportsChangeAnimations = true;
        }
    }

    public static interface ItemAnimator.ItemAnimatorFinishedListener
    {

        public abstract void onAnimationsFinished();
    }

    static interface ItemAnimator.ItemAnimatorListener
    {

        public abstract void onAddFinished(ViewHolder viewholder);

        public abstract void onChangeFinished(ViewHolder viewholder);

        public abstract void onMoveFinished(ViewHolder viewholder);

        public abstract void onRemoveFinished(ViewHolder viewholder);
    }

    private class ItemAnimatorRestoreListener
        implements ItemAnimator.ItemAnimatorListener
    {

        final RecyclerView this$0;

        public void onAddFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onChangeFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (viewholder.mShadowedHolder != null && viewholder.mShadowingHolder == null)
            {
                viewholder.mShadowedHolder = null;
                viewholder.setFlags(-65, viewholder.mFlags);
            }
            viewholder.mShadowingHolder = null;
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onMoveFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onRemoveFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!removeAnimatingView(viewholder.itemView) && viewholder.isTmpDetached())
            {
                removeDetachedView(viewholder.itemView, false);
            }
        }

        private ItemAnimatorRestoreListener()
        {
            this$0 = RecyclerView.this;
            super();
        }

    }

    public static abstract class ItemDecoration
    {

        public void getItemOffsets(Rect rect, int j, RecyclerView recyclerview)
        {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, State state)
        {
            getItemOffsets(rect, ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition(), recyclerview);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerview, State state)
        {
            onDraw(canvas, recyclerview);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview, State state)
        {
            onDrawOver(canvas, recyclerview);
        }

        public ItemDecoration()
        {
        }
    }

    private static class ItemHolderInfo
    {

        int bottom;
        ViewHolder holder;
        int left;
        int right;
        int top;

        ItemHolderInfo(ViewHolder viewholder, int j, int k, int l, int i1)
        {
            holder = viewholder;
            left = j;
            top = k;
            right = l;
            bottom = i1;
        }
    }

    public static abstract class LayoutManager
    {

        ChildHelper mChildHelper;
        private boolean mIsAttachedToWindow;
        RecyclerView mRecyclerView;
        private boolean mRequestedSimpleAnimations;
        SmoothScroller mSmoothScroller;

        private void addViewInt(View view, int j, boolean flag)
        {
            ViewHolder viewholder;
            LayoutParams layoutparams;
            viewholder = RecyclerView.getChildViewHolderInt(view);
            if (flag || viewholder.isRemoved())
            {
                mRecyclerView.mState.addToDisappearingList(view);
            } else
            {
                mRecyclerView.mState.removeFromDisappearingList(view);
            }
            layoutparams = (LayoutParams)view.getLayoutParams();
            if (!viewholder.wasReturnedFromScrap() && !viewholder.isScrap()) goto _L2; else goto _L1
_L1:
            if (viewholder.isScrap())
            {
                viewholder.unScrap();
            } else
            {
                viewholder.clearReturnedFromScrapFlag();
            }
            mChildHelper.attachViewToParent(view, j, view.getLayoutParams(), false);
_L4:
            if (layoutparams.mPendingInvalidate)
            {
                viewholder.itemView.invalidate();
                layoutparams.mPendingInvalidate = false;
            }
            return;
_L2:
            if (view.getParent() == mRecyclerView)
            {
                int l = mChildHelper.indexOfChild(view);
                int k = j;
                if (j == -1)
                {
                    k = mChildHelper.getChildCount();
                }
                if (l == -1)
                {
                    throw new IllegalStateException((new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:")).append(mRecyclerView.indexOfChild(view)).toString());
                }
                if (l != k)
                {
                    mRecyclerView.mLayout.moveView(l, k);
                }
            } else
            {
                mChildHelper.addView(view, j, false);
                layoutparams.mInsetsDirty = true;
                if (mSmoothScroller != null && mSmoothScroller.isRunning())
                {
                    mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void detachViewInternal(int j, View view)
        {
            mChildHelper.detachViewFromParent(j);
        }

        public static int getChildMeasureSpec(int j, int k, int l, boolean flag)
        {
            int i1;
            int j1;
            j1 = 0x40000000;
            i1 = Math.max(0, j - k);
            if (!flag) goto _L2; else goto _L1
_L1:
            if (l >= 0)
            {
                j = l;
                k = j1;
            } else
            {
                k = 0;
                j = 0;
            }
_L4:
            return android.view.View.MeasureSpec.makeMeasureSpec(j, k);
_L2:
            k = j1;
            j = l;
            if (l < 0)
            {
                if (l == -1)
                {
                    j = i1;
                    k = j1;
                } else
                if (l == -2)
                {
                    k = 0x80000000;
                    j = i1;
                } else
                {
                    k = 0;
                    j = 0;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public static Properties getProperties(Context context, AttributeSet attributeset, int j, int k)
        {
            Properties properties = new Properties();
            context = context.obtainStyledAttributes(attributeset, android.support.v7.recyclerview.R.styleable.RecyclerView, j, k);
            properties.orientation = context.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = context.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = context.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = context.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            context.recycle();
            return properties;
        }

        private void onSmoothScrollerStopped(SmoothScroller smoothscroller)
        {
            if (mSmoothScroller == smoothscroller)
            {
                mSmoothScroller = null;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int j, View view)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.shouldIgnore())
            {
                return;
            }
            if (viewholder.isInvalid() && !viewholder.isRemoved() && !viewholder.isChanged() && !mRecyclerView.mAdapter.hasStableIds())
            {
                removeViewAt(j);
                recycler.recycleViewHolderInternal(viewholder);
                return;
            } else
            {
                detachViewAt(j);
                recycler.scrapView(view);
                return;
            }
        }

        public void addDisappearingView(View view)
        {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int j)
        {
            addViewInt(view, j, true);
        }

        public void addView(View view)
        {
            addView(view, -1);
        }

        public void addView(View view, int j)
        {
            addViewInt(view, j, false);
        }

        public void assertInLayoutOrScroll(String s)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.assertInLayoutOrScroll(s);
            }
        }

        public void assertNotInLayoutOrScroll(String s)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.assertNotInLayoutOrScroll(s);
            }
        }

        public void attachView(View view)
        {
            attachView(view, -1);
        }

        public void attachView(View view, int j)
        {
            attachView(view, j, (LayoutParams)view.getLayoutParams());
        }

        public void attachView(View view, int j, LayoutParams layoutparams)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.isRemoved())
            {
                mRecyclerView.mState.addToDisappearingList(view);
            } else
            {
                mRecyclerView.mState.removeFromDisappearingList(view);
            }
            mChildHelper.attachViewToParent(view, j, layoutparams, viewholder.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect)
        {
            if (mRecyclerView == null)
            {
                rect.set(0, 0, 0, 0);
                return;
            } else
            {
                rect.set(mRecyclerView.getItemDecorInsetsForChild(view));
                return;
            }
        }

        public boolean canScrollHorizontally()
        {
            return false;
        }

        public boolean canScrollVertically()
        {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutparams)
        {
            return layoutparams != null;
        }

        public int computeHorizontalScrollExtent(State state)
        {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state)
        {
            return 0;
        }

        public int computeHorizontalScrollRange(State state)
        {
            return 0;
        }

        public int computeVerticalScrollExtent(State state)
        {
            return 0;
        }

        public int computeVerticalScrollOffset(State state)
        {
            return 0;
        }

        public int computeVerticalScrollRange(State state)
        {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler)
        {
            for (int j = getChildCount() - 1; j >= 0; j--)
            {
                scrapOrRecycleView(recycler, j, getChildAt(j));
            }

        }

        public void detachAndScrapView(View view, Recycler recycler)
        {
            scrapOrRecycleView(recycler, mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int j, Recycler recycler)
        {
            scrapOrRecycleView(recycler, j, getChildAt(j));
        }

        public void detachView(View view)
        {
            int j = mChildHelper.indexOfChild(view);
            if (j >= 0)
            {
                detachViewInternal(j, view);
            }
        }

        public void detachViewAt(int j)
        {
            detachViewInternal(j, getChildAt(j));
        }

        void dispatchAttachedToWindow(RecyclerView recyclerview)
        {
            mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerview);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerview, Recycler recycler)
        {
            mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerview, recycler);
        }

        public void endAnimation(View view)
        {
            if (mRecyclerView.mItemAnimator != null)
            {
                mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findViewByPosition(int j)
        {
            int l = getChildCount();
            for (int k = 0; k < l; k++)
            {
                View view = getChildAt(k);
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (viewholder != null && viewholder.getLayoutPosition() == j && !viewholder.shouldIgnore() && (mRecyclerView.mState.isPreLayout() || !viewholder.isRemoved()))
                {
                    return view;
                }
            }

            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeset)
        {
            return new LayoutParams(context, attributeset);
        }

        public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            if (layoutparams instanceof LayoutParams)
            {
                return new LayoutParams((LayoutParams)layoutparams);
            }
            if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
            } else
            {
                return new LayoutParams(layoutparams);
            }
        }

        public int getBaseline()
        {
            return -1;
        }

        public int getBottomDecorationHeight(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int j)
        {
            if (mChildHelper != null)
            {
                return mChildHelper.getChildAt(j);
            } else
            {
                return null;
            }
        }

        public int getChildCount()
        {
            if (mChildHelper != null)
            {
                return mChildHelper.getChildCount();
            } else
            {
                return 0;
            }
        }

        public boolean getClipToPadding()
        {
            return mRecyclerView != null && mRecyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state)
        {
            while (mRecyclerView == null || mRecyclerView.mAdapter == null || !canScrollHorizontally()) 
            {
                return 1;
            }
            return mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view)
        {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public int getDecoratedLeft(View view)
        {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            int j = view.getMeasuredHeight();
            int k = rect.top;
            return rect.bottom + (j + k);
        }

        public int getDecoratedMeasuredWidth(View view)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            int j = view.getMeasuredWidth();
            int k = rect.left;
            return rect.right + (j + k);
        }

        public int getDecoratedRight(View view)
        {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view)
        {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild()
        {
            View view;
            if (mRecyclerView != null)
            {
                if ((view = mRecyclerView.getFocusedChild()) != null && !mChildHelper.isHidden(view))
                {
                    return view;
                }
            }
            return null;
        }

        public int getHeight()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getHeight();
            } else
            {
                return 0;
            }
        }

        public int getItemCount()
        {
            Adapter adapter;
            if (mRecyclerView != null)
            {
                adapter = mRecyclerView.getAdapter();
            } else
            {
                adapter = null;
            }
            if (adapter != null)
            {
                return adapter.getItemCount();
            } else
            {
                return 0;
            }
        }

        public int getItemViewType(View view)
        {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection()
        {
            return x.h(mRecyclerView);
        }

        public int getLeftDecorationWidth(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight()
        {
            return x.r(mRecyclerView);
        }

        public int getMinimumWidth()
        {
            return x.q(mRecyclerView);
        }

        public int getPaddingBottom()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingBottom();
            } else
            {
                return 0;
            }
        }

        public int getPaddingEnd()
        {
            if (mRecyclerView != null)
            {
                return x.n(mRecyclerView);
            } else
            {
                return 0;
            }
        }

        public int getPaddingLeft()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingLeft();
            } else
            {
                return 0;
            }
        }

        public int getPaddingRight()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingRight();
            } else
            {
                return 0;
            }
        }

        public int getPaddingStart()
        {
            if (mRecyclerView != null)
            {
                return x.m(mRecyclerView);
            } else
            {
                return 0;
            }
        }

        public int getPaddingTop()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingTop();
            } else
            {
                return 0;
            }
        }

        public int getPosition(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state)
        {
            while (mRecyclerView == null || mRecyclerView.mAdapter == null || !canScrollVertically()) 
            {
                return 1;
            }
            return mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state)
        {
            return 0;
        }

        public int getTopDecorationHeight(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.top;
        }

        public int getWidth()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getWidth();
            } else
            {
                return 0;
            }
        }

        public boolean hasFocus()
        {
            return mRecyclerView != null && mRecyclerView.hasFocus();
        }

        public void ignoreView(View view)
        {
            if (view.getParent() != mRecyclerView || mRecyclerView.indexOfChild(view) == -1)
            {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            } else
            {
                view = RecyclerView.getChildViewHolderInt(view);
                view.addFlags(128);
                mRecyclerView.mState.onViewIgnored(view);
                return;
            }
        }

        public boolean isAttachedToWindow()
        {
            return mIsAttachedToWindow;
        }

        public boolean isFocused()
        {
            return mRecyclerView != null && mRecyclerView.isFocused();
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state)
        {
            return false;
        }

        public boolean isSmoothScrolling()
        {
            return mSmoothScroller != null && mSmoothScroller.isRunning();
        }

        public void layoutDecorated(View view, int j, int k, int l, int i1)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            view.layout(rect.left + j, rect.top + k, l - rect.right, i1 - rect.bottom);
        }

        public void measureChild(View view, int j, int k)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            Rect rect = mRecyclerView.getItemDecorInsetsForChild(view);
            int l = rect.left;
            int i1 = rect.right;
            int j1 = rect.top;
            int k1 = rect.bottom;
            view.measure(getChildMeasureSpec(getWidth(), l + i1 + j + (getPaddingLeft() + getPaddingRight()), layoutparams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), k1 + j1 + k + (getPaddingTop() + getPaddingBottom()), layoutparams.height, canScrollVertically()));
        }

        public void measureChildWithMargins(View view, int j, int k)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            Rect rect = mRecyclerView.getItemDecorInsetsForChild(view);
            int l = rect.left;
            int i1 = rect.right;
            int j1 = rect.top;
            int k1 = rect.bottom;
            view.measure(getChildMeasureSpec(getWidth(), l + i1 + j + (getPaddingLeft() + getPaddingRight() + layoutparams.leftMargin + layoutparams.rightMargin), layoutparams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), k1 + j1 + k + (getPaddingTop() + getPaddingBottom() + layoutparams.topMargin + layoutparams.bottomMargin), layoutparams.height, canScrollVertically()));
        }

        public void moveView(int j, int k)
        {
            View view = getChildAt(j);
            if (view == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Cannot move a child from non-existing index:")).append(j).toString());
            } else
            {
                detachViewAt(j);
                attachView(view, k);
                return;
            }
        }

        public void offsetChildrenHorizontal(int j)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.offsetChildrenHorizontal(j);
            }
        }

        public void offsetChildrenVertical(int j)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.offsetChildrenVertical(j);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter1)
        {
        }

        public boolean onAddFocusables(RecyclerView recyclerview, ArrayList arraylist, int j, int k)
        {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerview)
        {
        }

        public void onDetachedFromWindow(RecyclerView recyclerview)
        {
        }

        public void onDetachedFromWindow(RecyclerView recyclerview, Recycler recycler)
        {
            onDetachedFromWindow(recyclerview);
        }

        public View onFocusSearchFailed(View view, int j, Recycler recycler, State state)
        {
            return null;
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityevent)
        {
            boolean flag1 = true;
            recycler = a.a(accessibilityevent);
            if (mRecyclerView != null)
            {
                boolean flag = flag1;
                if (!x.b(mRecyclerView, 1))
                {
                    flag = flag1;
                    if (!x.b(mRecyclerView, -1))
                    {
                        flag = flag1;
                        if (!x.a(mRecyclerView, -1))
                        {
                            if (x.a(mRecyclerView, 1))
                            {
                                flag = flag1;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
                recycler.a(flag);
                if (mRecyclerView.mAdapter != null)
                {
                    recycler.a(mRecyclerView.mAdapter.getItemCount());
                    return;
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            onInitializeAccessibilityEvent(mRecyclerView.mRecycler, mRecyclerView.mState, accessibilityevent);
        }

        void onInitializeAccessibilityNodeInfo(c c1)
        {
            onInitializeAccessibilityNodeInfo(mRecyclerView.mRecycler, mRecyclerView.mState, c1);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, c c1)
        {
            if (x.b(mRecyclerView, -1) || x.a(mRecyclerView, -1))
            {
                c1.a(8192);
                c1.f(true);
            }
            if (x.b(mRecyclerView, 1) || x.a(mRecyclerView, 1))
            {
                c1.a(4096);
                c1.f(true);
            }
            int j = getRowCountForAccessibility(recycler, state);
            int k = getColumnCountForAccessibility(recycler, state);
            boolean flag = isLayoutHierarchical(recycler, state);
            int l = getSelectionModeForAccessibility(recycler, state);
            recycler = new android.support.v4.view.a.c.k(c.m().a(j, k, flag, l));
            c.a.b(c1.b, ((android.support.v4.view.a.c.k)recycler).a);
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, c c1)
        {
            int j;
            int k;
            if (canScrollVertically())
            {
                j = getPosition(view);
            } else
            {
                j = 0;
            }
            if (canScrollHorizontally())
            {
                k = getPosition(view);
            } else
            {
                k = 0;
            }
            c1.a(android.support.v4.view.a.c.l.a(j, 1, k, 1, false));
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, c c1)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder != null && !viewholder.isRemoved() && !mChildHelper.isHidden(viewholder.itemView))
            {
                onInitializeAccessibilityNodeInfoForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, c1);
            }
        }

        public View onInterceptFocusSearch(View view, int j)
        {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerview, int j, int k)
        {
        }

        public void onItemsChanged(RecyclerView recyclerview)
        {
        }

        public void onItemsMoved(RecyclerView recyclerview, int j, int k, int l)
        {
        }

        public void onItemsRemoved(RecyclerView recyclerview, int j, int k)
        {
        }

        public void onItemsUpdated(RecyclerView recyclerview, int j, int k)
        {
        }

        public void onItemsUpdated(RecyclerView recyclerview, int j, int k, Object obj)
        {
            onItemsUpdated(recyclerview, j, k);
        }

        public void onLayoutChildren(Recycler recycler, State state)
        {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(Recycler recycler, State state, int j, int k)
        {
            mRecyclerView.defaultOnMeasure(j, k);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerview, State state, View view, View view1)
        {
            return onRequestChildFocus(recyclerview, view, view1);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerview, View view, View view1)
        {
            return isSmoothScrolling() || recyclerview.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable)
        {
        }

        public Parcelable onSaveInstanceState()
        {
            return null;
        }

        public void onScrollStateChanged(int j)
        {
        }

        boolean performAccessibilityAction(int j, Bundle bundle)
        {
            return performAccessibilityAction(mRecyclerView.mRecycler, mRecyclerView.mState, j, bundle);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int j, Bundle bundle)
        {
            if (mRecyclerView != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            j;
            JVM INSTR lookupswitch 2: default 36
        //                       4096: 129
        //                       8192: 62;
               goto _L3 _L4 _L5
_L3:
            int k;
            j = 0;
            k = 0;
_L8:
            if (k != 0 || j != 0)
            {
                mRecyclerView.scrollBy(j, k);
                return true;
            }
              goto _L1
_L5:
            int l;
            int i1;
            int j1;
            if (x.b(mRecyclerView, -1))
            {
                j = -(getHeight() - getPaddingTop() - getPaddingBottom());
            } else
            {
                j = 0;
            }
            k = j;
            if (!x.a(mRecyclerView, -1)) goto _L7; else goto _L6
_L6:
            l = -(getWidth() - getPaddingLeft() - getPaddingRight());
            k = j;
            j = l;
              goto _L8
_L4:
            if (x.b(mRecyclerView, 1))
            {
                j = getHeight() - getPaddingTop() - getPaddingBottom();
            } else
            {
                j = 0;
            }
            k = j;
            if (!x.a(mRecyclerView, 1)) goto _L7; else goto _L9
_L9:
            l = getWidth();
            i1 = getPaddingLeft();
            j1 = getPaddingRight();
            k = j;
            j = l - i1 - j1;
              goto _L8
_L7:
            j = 0;
              goto _L8
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int j, Bundle bundle)
        {
            return false;
        }

        boolean performAccessibilityActionForItem(View view, int j, Bundle bundle)
        {
            return performAccessibilityActionForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, j, bundle);
        }

        public void postOnAnimation(Runnable runnable)
        {
            if (mRecyclerView != null)
            {
                x.a(mRecyclerView, runnable);
            }
        }

        public void removeAllViews()
        {
            for (int j = getChildCount() - 1; j >= 0; j--)
            {
                mChildHelper.removeViewAt(j);
            }

        }

        public void removeAndRecycleAllViews(Recycler recycler)
        {
            for (int j = getChildCount() - 1; j >= 0; j--)
            {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(j)).shouldIgnore())
                {
                    removeAndRecycleViewAt(j, recycler);
                }
            }

        }

        void removeAndRecycleScrapInt(Recycler recycler)
        {
            int k = recycler.getScrapCount();
            for (int j = k - 1; j >= 0; j--)
            {
                View view = recycler.getScrapViewAt(j);
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (viewholder.shouldIgnore())
                {
                    continue;
                }
                viewholder.setIsRecyclable(false);
                if (viewholder.isTmpDetached())
                {
                    mRecyclerView.removeDetachedView(view, false);
                }
                if (mRecyclerView.mItemAnimator != null)
                {
                    mRecyclerView.mItemAnimator.endAnimation(viewholder);
                }
                viewholder.setIsRecyclable(true);
                recycler.quickRecycleScrapView(view);
            }

            recycler.clearScrap();
            if (k > 0)
            {
                mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler)
        {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int j, Recycler recycler)
        {
            View view = getChildAt(j);
            removeViewAt(j);
            recycler.recycleView(view);
        }

        public boolean removeCallbacks(Runnable runnable)
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.removeCallbacks(runnable);
            } else
            {
                return false;
            }
        }

        public void removeDetachedView(View view)
        {
            mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view)
        {
            mChildHelper.removeView(view);
        }

        public void removeViewAt(int j)
        {
            if (getChildAt(j) != null)
            {
                mChildHelper.removeViewAt(j);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerview, View view, Rect rect, boolean flag)
        {
            int l1 = getPaddingLeft();
            int i1 = getPaddingTop();
            int i2 = getWidth() - getPaddingRight();
            int k1 = getHeight();
            int l2 = getPaddingBottom();
            int j2 = view.getLeft() + rect.left;
            int j1 = view.getTop() + rect.top;
            int k2 = j2 + rect.width();
            int i3 = rect.height();
            int j = Math.min(0, j2 - l1);
            int k = Math.min(0, j1 - i1);
            int l = Math.max(0, k2 - i2);
            k1 = Math.max(0, (j1 + i3) - (k1 - l2));
            if (getLayoutDirection() == 1)
            {
                if (l != 0)
                {
                    j = l;
                } else
                {
                    j = Math.max(j, k2 - i2);
                }
            } else
            if (j == 0)
            {
                j = Math.min(j2 - l1, l);
            }
            if (k == 0)
            {
                k = Math.min(j1 - i1, k1);
            }
            if (j != 0 || k != 0)
            {
                if (flag)
                {
                    recyclerview.scrollBy(j, k);
                } else
                {
                    recyclerview.smoothScrollBy(j, k);
                }
                return true;
            } else
            {
                return false;
            }
        }

        public void requestLayout()
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout()
        {
            mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int j, Recycler recycler, State state)
        {
            return 0;
        }

        public void scrollToPosition(int j)
        {
        }

        public int scrollVerticallyBy(int j, Recycler recycler, State state)
        {
            return 0;
        }

        public void setMeasuredDimension(int j, int k)
        {
            mRecyclerView.setMeasuredDimension(j, k);
        }

        void setRecyclerView(RecyclerView recyclerview)
        {
            if (recyclerview == null)
            {
                mRecyclerView = null;
                mChildHelper = null;
                return;
            } else
            {
                mRecyclerView = recyclerview;
                mChildHelper = recyclerview.mChildHelper;
                return;
            }
        }

        public void smoothScrollToPosition(RecyclerView recyclerview, State state, int j)
        {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothscroller)
        {
            if (mSmoothScroller != null && smoothscroller != mSmoothScroller && mSmoothScroller.isRunning())
            {
                mSmoothScroller.stop();
            }
            mSmoothScroller = smoothscroller;
            mSmoothScroller.start(mRecyclerView, this);
        }

        public void stopIgnoringView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.stopIgnoring();
            view.resetInternal();
            view.addFlags(4);
        }

        void stopSmoothScroller()
        {
            if (mSmoothScroller != null)
            {
                mSmoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations()
        {
            return false;
        }



/*
        static boolean access$1902(LayoutManager layoutmanager, boolean flag)
        {
            layoutmanager.mRequestedSimpleAnimations = flag;
            return flag;
        }

*/


        public LayoutManager()
        {
            mRequestedSimpleAnimations = false;
            mIsAttachedToWindow = false;
        }
    }

    public static class LayoutManager.Properties
    {

        public int orientation;
        public boolean reverseLayout;
        public int spanCount;
        public boolean stackFromEnd;

        public LayoutManager.Properties()
        {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        final Rect mDecorInsets;
        public boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public int getViewAdapterPosition()
        {
            return mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition()
        {
            return mViewHolder.getLayoutPosition();
        }

        public int getViewPosition()
        {
            return mViewHolder.getPosition();
        }

        public boolean isItemChanged()
        {
            return mViewHolder.isChanged();
        }

        public boolean isItemRemoved()
        {
            return mViewHolder.isRemoved();
        }

        public boolean isViewInvalid()
        {
            return mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate()
        {
            return mViewHolder.needsUpdate();
        }

        public LayoutParams(int j, int k)
        {
            super(j, k);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }
    }

    public static interface OnChildAttachStateChangeListener
    {

        public abstract void onChildViewAttachedToWindow(View view);

        public abstract void onChildViewDetachedFromWindow(View view);
    }

    public static interface OnItemTouchListener
    {

        public abstract boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent);

        public abstract void onRequestDisallowInterceptTouchEvent(boolean flag);

        public abstract void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent);
    }

    public static abstract class OnScrollListener
    {

        public void onScrollStateChanged(RecyclerView recyclerview, int j)
        {
        }

        public void onScrolled(RecyclerView recyclerview, int j, int k)
        {
        }

        public OnScrollListener()
        {
        }
    }

    public static class RecycledViewPool
    {

        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        private SparseIntArray mMaxScrap;
        private SparseArray mScrap;

        private ArrayList getScrapHeapForType(int j)
        {
            ArrayList arraylist1 = (ArrayList)mScrap.get(j);
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                ArrayList arraylist2 = new ArrayList();
                mScrap.put(j, arraylist2);
                arraylist = arraylist2;
                if (mMaxScrap.indexOfKey(j) < 0)
                {
                    mMaxScrap.put(j, 5);
                    arraylist = arraylist2;
                }
            }
            return arraylist;
        }

        void attach(Adapter adapter)
        {
            mAttachCount = mAttachCount + 1;
        }

        public void clear()
        {
            mScrap.clear();
        }

        void detach()
        {
            mAttachCount = mAttachCount - 1;
        }

        public ViewHolder getRecycledView(int j)
        {
            ArrayList arraylist = (ArrayList)mScrap.get(j);
            if (arraylist != null && !arraylist.isEmpty())
            {
                j = arraylist.size() - 1;
                ViewHolder viewholder = (ViewHolder)arraylist.get(j);
                arraylist.remove(j);
                return viewholder;
            } else
            {
                return null;
            }
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter1, boolean flag)
        {
            if (adapter != null)
            {
                detach();
            }
            if (!flag && mAttachCount == 0)
            {
                clear();
            }
            if (adapter1 != null)
            {
                attach(adapter1);
            }
        }

        public void putRecycledView(ViewHolder viewholder)
        {
            int j = viewholder.getItemViewType();
            ArrayList arraylist = getScrapHeapForType(j);
            if (mMaxScrap.get(j) <= arraylist.size())
            {
                return;
            } else
            {
                viewholder.resetInternal();
                arraylist.add(viewholder);
                return;
            }
        }

        public void setMaxRecycledViews(int j, int k)
        {
            mMaxScrap.put(j, k);
            ArrayList arraylist = (ArrayList)mScrap.get(j);
            if (arraylist != null)
            {
                for (; arraylist.size() > k; arraylist.remove(arraylist.size() - 1)) { }
            }
        }

        int size()
        {
            int j = 0;
            int k;
            int l;
            for (k = 0; j < mScrap.size(); k = l)
            {
                ArrayList arraylist = (ArrayList)mScrap.valueAt(j);
                l = k;
                if (arraylist != null)
                {
                    l = k + arraylist.size();
                }
                j++;
            }

            return k;
        }

        public RecycledViewPool()
        {
            mScrap = new SparseArray();
            mMaxScrap = new SparseIntArray();
            mAttachCount = 0;
        }
    }

    public final class Recycler
    {

        private static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList mAttachedScrap = new ArrayList();
        final ArrayList mCachedViews = new ArrayList();
        private ArrayList mChangedScrap;
        private RecycledViewPool mRecyclerPool;
        private final List mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        private int mViewCacheMax;
        final RecyclerView this$0;

        private void attachAccessibilityDelegate(View view)
        {
            if (isAccessibilityEnabled())
            {
                if (x.e(view) == 0)
                {
                    x.d(view, 1);
                }
                if (!x.b(view))
                {
                    x.a(view, mAccessibilityDelegate.getItemDelegate());
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewholder)
        {
            if (viewholder.itemView instanceof ViewGroup)
            {
                invalidateDisplayListInt((ViewGroup)viewholder.itemView, false);
            }
        }

        private void invalidateDisplayListInt(ViewGroup viewgroup, boolean flag)
        {
            for (int j = viewgroup.getChildCount() - 1; j >= 0; j--)
            {
                View view = viewgroup.getChildAt(j);
                if (view instanceof ViewGroup)
                {
                    invalidateDisplayListInt((ViewGroup)view, true);
                }
            }

            if (!flag)
            {
                return;
            }
            if (viewgroup.getVisibility() == 4)
            {
                viewgroup.setVisibility(0);
                viewgroup.setVisibility(4);
                return;
            } else
            {
                int k = viewgroup.getVisibility();
                viewgroup.setVisibility(4);
                viewgroup.setVisibility(k);
                return;
            }
        }

        final void addViewHolderToRecycledViewPool(ViewHolder viewholder)
        {
            x.a(viewholder.itemView, null);
            dispatchViewRecycled(viewholder);
            viewholder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewholder);
        }

        public final void bindViewToPosition(View view, int j)
        {
            boolean flag = true;
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder == null)
            {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int k = mAdapterHelper.findPositionOffset(j);
            if (k < 0 || k >= mAdapter.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid item position ")).append(j).append("(offset:").append(k).append(").state:").append(mState.getItemCount()).toString());
            }
            viewholder.mOwnerRecyclerView = RecyclerView.this;
            mAdapter.bindViewHolder(viewholder, k);
            attachAccessibilityDelegate(view);
            if (mState.isPreLayout())
            {
                viewholder.mPreLayoutPosition = j;
            }
            view = viewholder.itemView.getLayoutParams();
            if (view == null)
            {
                view = (LayoutParams)generateDefaultLayoutParams();
                viewholder.itemView.setLayoutParams(view);
            } else
            if (!checkLayoutParams(view))
            {
                view = (LayoutParams)generateLayoutParams(view);
                viewholder.itemView.setLayoutParams(view);
            } else
            {
                view = (LayoutParams)view;
            }
            view.mInsetsDirty = true;
            view.mViewHolder = viewholder;
            if (viewholder.itemView.getParent() != null)
            {
                flag = false;
            }
            view.mPendingInvalidate = flag;
        }

        public final void clear()
        {
            mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        final void clearOldPositions()
        {
            boolean flag = false;
            int i1 = mCachedViews.size();
            for (int j = 0; j < i1; j++)
            {
                ((ViewHolder)mCachedViews.get(j)).clearOldPosition();
            }

            i1 = mAttachedScrap.size();
            for (int k = 0; k < i1; k++)
            {
                ((ViewHolder)mAttachedScrap.get(k)).clearOldPosition();
            }

            if (mChangedScrap != null)
            {
                int j1 = mChangedScrap.size();
                for (int l = ((flag) ? 1 : 0); l < j1; l++)
                {
                    ((ViewHolder)mChangedScrap.get(l)).clearOldPosition();
                }

            }
        }

        final void clearScrap()
        {
            mAttachedScrap.clear();
        }

        public final int convertPreLayoutPositionToPostLayout(int j)
        {
            if (j < 0 || j >= mState.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("invalid position ")).append(j).append(". State item count is ").append(mState.getItemCount()).toString());
            }
            if (!mState.isPreLayout())
            {
                return j;
            } else
            {
                return mAdapterHelper.findPositionOffset(j);
            }
        }

        final void dispatchViewRecycled(ViewHolder viewholder)
        {
            if (mRecyclerListener != null)
            {
                mRecyclerListener.onViewRecycled(viewholder);
            }
            if (mAdapter != null)
            {
                mAdapter.onViewRecycled(viewholder);
            }
            if (mState != null)
            {
                mState.onViewRecycled(viewholder);
            }
        }

        final ViewHolder getChangedScrapViewForPosition(int j)
        {
            boolean flag;
            int l;
label0:
            {
                flag = false;
                if (mChangedScrap != null)
                {
                    l = mChangedScrap.size();
                    if (l != 0)
                    {
                        break label0;
                    }
                }
                return null;
            }
            for (int k = 0; k < l; k++)
            {
                ViewHolder viewholder = (ViewHolder)mChangedScrap.get(k);
                if (!viewholder.wasReturnedFromScrap() && viewholder.getLayoutPosition() == j)
                {
                    viewholder.addFlags(32);
                    return viewholder;
                }
            }

            if (mAdapter.hasStableIds())
            {
                j = mAdapterHelper.findPositionOffset(j);
                if (j > 0 && j < mAdapter.getItemCount())
                {
                    long l1 = mAdapter.getItemId(j);
                    for (j = ((flag) ? 1 : 0); j < l; j++)
                    {
                        ViewHolder viewholder1 = (ViewHolder)mChangedScrap.get(j);
                        if (!viewholder1.wasReturnedFromScrap() && viewholder1.getItemId() == l1)
                        {
                            viewholder1.addFlags(32);
                            return viewholder1;
                        }
                    }

                }
            }
            return null;
        }

        final RecycledViewPool getRecycledViewPool()
        {
            if (mRecyclerPool == null)
            {
                mRecyclerPool = new RecycledViewPool();
            }
            return mRecyclerPool;
        }

        final int getScrapCount()
        {
            return mAttachedScrap.size();
        }

        public final List getScrapList()
        {
            return mUnmodifiableAttachedScrap;
        }

        final View getScrapViewAt(int j)
        {
            return ((ViewHolder)mAttachedScrap.get(j)).itemView;
        }

        final ViewHolder getScrapViewForId(long l, int j, boolean flag)
        {
            int k = mAttachedScrap.size() - 1;
_L5:
            if (k < 0) goto _L2; else goto _L1
_L1:
            ViewHolder viewholder1;
            viewholder1 = (ViewHolder)mAttachedScrap.get(k);
            if (viewholder1.getItemId() != l || viewholder1.wasReturnedFromScrap())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j != viewholder1.getItemViewType()) goto _L4; else goto _L3
_L3:
            ViewHolder viewholder;
            viewholder1.addFlags(32);
            viewholder = viewholder1;
            if (viewholder1.isRemoved())
            {
                viewholder = viewholder1;
                if (!mState.isPreLayout())
                {
                    viewholder1.setFlags(2, 14);
                    viewholder = viewholder1;
                }
            }
_L8:
            return viewholder;
_L4:
            if (!flag)
            {
                mAttachedScrap.remove(k);
                removeDetachedView(viewholder1.itemView, false);
                quickRecycleScrapView(viewholder1.itemView);
            }
            k--;
              goto _L5
_L2:
            k = mCachedViews.size() - 1;
_L9:
            if (k < 0) goto _L7; else goto _L6
_L6:
label0:
            {
                ViewHolder viewholder2 = (ViewHolder)mCachedViews.get(k);
                if (viewholder2.getItemId() != l)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (j != viewholder2.getItemViewType())
                {
                    break label0;
                }
                viewholder = viewholder2;
                if (!flag)
                {
                    mCachedViews.remove(k);
                    return viewholder2;
                }
            }
              goto _L8
            if (!flag)
            {
                recycleCachedViewAt(k);
            }
            k--;
              goto _L9
_L7:
            return null;
              goto _L8
        }

        final ViewHolder getScrapViewForPosition(int j, int k, boolean flag)
        {
            int l;
            boolean flag1;
            int i1;
            flag1 = false;
            i1 = mAttachedScrap.size();
            l = 0;
_L10:
            if (l >= i1) goto _L2; else goto _L1
_L1:
            Object obj = (ViewHolder)mAttachedScrap.get(l);
            if (((ViewHolder) (obj)).wasReturnedFromScrap() || ((ViewHolder) (obj)).getLayoutPosition() != j || ((ViewHolder) (obj)).isInvalid() || !mState.mInPreLayout && ((ViewHolder) (obj)).isRemoved()) goto _L4; else goto _L3
_L3:
            if (k == -1 || ((ViewHolder) (obj)).getItemViewType() == k) goto _L6; else goto _L5
_L5:
            Log.e("RecyclerView", (new StringBuilder("Scrap view for position ")).append(j).append(" isn't dirty but has wrong view type! (found ").append(((ViewHolder) (obj)).getItemViewType()).append(" but expected ").append(k).append(")").toString());
_L2:
            if (!flag)
            {
                obj = mChildHelper.findHiddenNonRemovedView(j, k);
                if (obj != null)
                {
                    mItemAnimator.endAnimation(getChildViewHolder(((View) (obj))));
                }
            }
            l = mCachedViews.size();
            k = ((flag1) ? 1 : 0);
_L8:
            if (k >= l)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (ViewHolder)mCachedViews.get(k);
            if (!((ViewHolder) (obj)).isInvalid() && ((ViewHolder) (obj)).getLayoutPosition() == j)
            {
                if (!flag)
                {
                    mCachedViews.remove(k);
                }
                return ((ViewHolder) (obj));
            }
            k++;
            continue; /* Loop/switch isn't completed */
_L6:
            ((ViewHolder) (obj)).addFlags(32);
            return ((ViewHolder) (obj));
_L4:
            l++;
            continue; /* Loop/switch isn't completed */
            if (true) goto _L8; else goto _L7
_L7:
            return null;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public final View getViewForPosition(int j)
        {
            return getViewForPosition(j, false);
        }

        final View getViewForPosition(int j, boolean flag)
        {
            boolean flag1 = true;
            if (j < 0 || j >= mState.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Invalid item position ")).append(j).append("(").append(j).append("). Item count:").append(mState.getItemCount()).toString());
            }
            Object obj;
            Object obj1;
            Object obj2;
            int k;
            int l;
            int i1;
            int j1;
            if (mState.isPreLayout())
            {
                obj1 = getChangedScrapViewForPosition(j);
                if (obj1 != null)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
            } else
            {
                obj1 = null;
                k = 0;
            }
            obj = obj1;
            if (obj1 != null) goto _L2; else goto _L1
_L1:
            obj1 = getScrapViewForPosition(j, -1, flag);
            obj = obj1;
            if (obj1 == null) goto _L2; else goto _L3
_L3:
            if (validateViewHolderForOffsetPosition(((ViewHolder) (obj1)))) goto _L5; else goto _L4
_L4:
            if (flag) goto _L7; else goto _L6
_L6:
            ((ViewHolder) (obj1)).addFlags(4);
            if (!((ViewHolder) (obj1)).isScrap()) goto _L9; else goto _L8
_L8:
            removeDetachedView(((ViewHolder) (obj1)).itemView, false);
            ((ViewHolder) (obj1)).unScrap();
_L17:
            recycleViewHolderInternal(((ViewHolder) (obj1)));
_L7:
            obj = null;
_L2:
            obj2 = obj;
            i1 = k;
            if (obj != null) goto _L11; else goto _L10
_L10:
            i1 = mAdapterHelper.findPositionOffset(j);
            if (i1 < 0 || i1 >= mAdapter.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid item position ")).append(j).append("(offset:").append(i1).append(").state:").append(mState.getItemCount()).toString());
            }
            j1 = mAdapter.getItemViewType(i1);
            obj1 = obj;
            l = k;
            if (mAdapter.hasStableIds())
            {
                obj = getScrapViewForId(mAdapter.getItemId(i1), j1, flag);
                obj1 = obj;
                l = k;
                if (obj != null)
                {
                    obj.mPosition = i1;
                    l = 1;
                    obj1 = obj;
                }
            }
            obj = obj1;
            if (obj1 == null)
            {
                obj = obj1;
                if (mViewCacheExtension != null)
                {
                    obj2 = mViewCacheExtension.getViewForPositionAndType(this, j, j1);
                    obj = obj1;
                    if (obj2 != null)
                    {
                        obj1 = getChildViewHolder(((View) (obj2)));
                        if (obj1 == null)
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                        }
                        obj = obj1;
                        if (((ViewHolder) (obj1)).shouldIgnore())
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                        }
                    }
                }
            }
            obj1 = obj;
            if (obj == null)
            {
                obj = getRecycledViewPool().getRecycledView(j1);
                obj1 = obj;
                if (obj != null)
                {
                    ((ViewHolder) (obj)).resetInternal();
                    obj1 = obj;
                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                    {
                        invalidateDisplayListInt(((ViewHolder) (obj)));
                        obj1 = obj;
                    }
                }
            }
            obj2 = obj1;
            i1 = l;
              goto _L12
_L9:
            if (((ViewHolder) (obj1)).wasReturnedFromScrap())
            {
                ((ViewHolder) (obj1)).clearReturnedFromScrapFlag();
            }
            continue; /* Loop/switch isn't completed */
_L5:
            k = 1;
            obj = obj1;
              goto _L2
_L12:
            if (obj1 != null) goto _L11; else goto _L13
_L13:
            obj1 = mAdapter.createViewHolder(RecyclerView.this, j1);
            k = l;
_L15:
            if (mState.isPreLayout() && ((ViewHolder) (obj1)).isBound())
            {
                obj1.mPreLayoutPosition = j;
                j = 0;
            } else
            if (!((ViewHolder) (obj1)).isBound() || ((ViewHolder) (obj1)).needsUpdate() || ((ViewHolder) (obj1)).isInvalid())
            {
                l = mAdapterHelper.findPositionOffset(j);
                obj1.mOwnerRecyclerView = RecyclerView.this;
                mAdapter.bindViewHolder(((ViewHolder) (obj1)), l);
                attachAccessibilityDelegate(((ViewHolder) (obj1)).itemView);
                if (mState.isPreLayout())
                {
                    obj1.mPreLayoutPosition = j;
                }
                j = 1;
            } else
            {
                j = 0;
            }
            obj = ((ViewHolder) (obj1)).itemView.getLayoutParams();
            if (obj == null)
            {
                obj = (LayoutParams)generateDefaultLayoutParams();
                ((ViewHolder) (obj1)).itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
            {
                obj = (LayoutParams)generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                ((ViewHolder) (obj1)).itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj = (LayoutParams)obj;
            }
            obj.mViewHolder = ((ViewHolder) (obj1));
            if (k != 0 && j != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            obj.mPendingInvalidate = flag;
            return ((ViewHolder) (obj1)).itemView;
_L11:
            k = i1;
            obj1 = obj2;
            if (true) goto _L15; else goto _L14
_L14:
            if (true) goto _L17; else goto _L16
_L16:
        }

        final void markItemDecorInsetsDirty()
        {
            int k = mCachedViews.size();
            for (int j = 0; j < k; j++)
            {
                LayoutParams layoutparams = (LayoutParams)((ViewHolder)mCachedViews.get(j)).itemView.getLayoutParams();
                if (layoutparams != null)
                {
                    layoutparams.mInsetsDirty = true;
                }
            }

        }

        final void markKnownViewsInvalid()
        {
            if (mAdapter != null && mAdapter.hasStableIds())
            {
                int k = mCachedViews.size();
                for (int j = 0; j < k; j++)
                {
                    ViewHolder viewholder = (ViewHolder)mCachedViews.get(j);
                    if (viewholder != null)
                    {
                        viewholder.addFlags(6);
                        viewholder.addChangePayload(null);
                    }
                }

            } else
            {
                recycleAndClearCachedViews();
            }
        }

        final void offsetPositionRecordsForInsert(int j, int k)
        {
            int i1 = mCachedViews.size();
            for (int l = 0; l < i1; l++)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(l);
                if (viewholder != null && viewholder.getLayoutPosition() >= j)
                {
                    viewholder.offsetPosition(k, true);
                }
            }

        }

        final void offsetPositionRecordsForMove(int j, int k)
        {
            byte byte0;
            int l;
            int i1;
            int j1;
            int k1;
            if (j < k)
            {
                byte0 = -1;
                l = k;
                i1 = j;
            } else
            {
                byte0 = 1;
                l = j;
                i1 = k;
            }
            k1 = mCachedViews.size();
            j1 = 0;
            while (j1 < k1) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(j1);
                if (viewholder != null && viewholder.mPosition >= i1 && viewholder.mPosition <= l)
                {
                    if (viewholder.mPosition == j)
                    {
                        viewholder.offsetPosition(k - j, false);
                    } else
                    {
                        viewholder.offsetPosition(byte0, false);
                    }
                }
                j1++;
            }
        }

        final void offsetPositionRecordsForRemove(int j, int k, boolean flag)
        {
            int l = mCachedViews.size() - 1;
            while (l >= 0) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(l);
                if (viewholder != null)
                {
                    if (viewholder.getLayoutPosition() >= j + k)
                    {
                        viewholder.offsetPosition(-k, flag);
                    } else
                    if (viewholder.getLayoutPosition() >= j)
                    {
                        viewholder.addFlags(8);
                        recycleCachedViewAt(l);
                    }
                }
                l--;
            }
        }

        final void onAdapterChanged(Adapter adapter, Adapter adapter1, boolean flag)
        {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter1, flag);
        }

        final void quickRecycleScrapView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.mScrapContainer = null;
            view.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(view);
        }

        final void recycleAndClearCachedViews()
        {
            for (int j = mCachedViews.size() - 1; j >= 0; j--)
            {
                recycleCachedViewAt(j);
            }

            mCachedViews.clear();
        }

        final void recycleCachedViewAt(int j)
        {
            addViewHolderToRecycledViewPool((ViewHolder)mCachedViews.get(j));
            mCachedViews.remove(j);
        }

        public final void recycleView(View view)
        {
            ViewHolder viewholder;
            viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.isTmpDetached())
            {
                removeDetachedView(view, false);
            }
            if (!viewholder.isScrap()) goto _L2; else goto _L1
_L1:
            viewholder.unScrap();
_L4:
            recycleViewHolderInternal(viewholder);
            return;
_L2:
            if (viewholder.wasReturnedFromScrap())
            {
                viewholder.clearReturnedFromScrapFlag();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        final void recycleViewHolderInternal(ViewHolder viewholder)
        {
            int j;
            boolean flag1 = true;
            boolean flag = false;
            if (viewholder.isScrap() || viewholder.itemView.getParent() != null)
            {
                StringBuilder stringbuilder = (new StringBuilder("Scrapped or attached views may not be recycled. isScrap:")).append(viewholder.isScrap()).append(" isAttached:");
                if (viewholder.itemView.getParent() == null)
                {
                    flag1 = false;
                }
                throw new IllegalArgumentException(stringbuilder.append(flag1).toString());
            }
            if (viewholder.isTmpDetached())
            {
                throw new IllegalArgumentException((new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ")).append(viewholder).toString());
            }
            if (viewholder.shouldIgnore())
            {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            }
            flag1 = viewholder.doesTransientStatePreventRecycling();
            if (mAdapter != null && flag1 && mAdapter.onFailedToRecycleView(viewholder))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j == 0 && !viewholder.isRecyclable())
            {
                break MISSING_BLOCK_LABEL_287;
            }
            if (viewholder.hasAnyOfTheFlags(78)) goto _L2; else goto _L1
_L1:
            j = mCachedViews.size();
            if (j == mViewCacheMax && j > 0)
            {
                recycleCachedViewAt(0);
            }
            if (j >= mViewCacheMax) goto _L2; else goto _L3
_L3:
            mCachedViews.add(viewholder);
            j = 1;
_L4:
            if (j == 0)
            {
                addViewHolderToRecycledViewPool(viewholder);
                flag = true;
            }
_L5:
            mState.onViewRecycled(viewholder);
            if (j == 0 && !flag && flag1)
            {
                viewholder.mOwnerRecyclerView = null;
            }
            return;
_L2:
            j = 0;
              goto _L4
            j = 0;
              goto _L5
        }

        final void recycleViewInternal(View view)
        {
            recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(view));
        }

        final void scrapView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.setScrapContainer(this);
            if (!view.isChanged() || !supportsChangeAnimations())
            {
                if (view.isInvalid() && !view.isRemoved() && !mAdapter.hasStableIds())
                {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                } else
                {
                    mAttachedScrap.add(view);
                    return;
                }
            }
            if (mChangedScrap == null)
            {
                mChangedScrap = new ArrayList();
            }
            mChangedScrap.add(view);
        }

        final void setAdapterPositionsAsUnknown()
        {
            int k = mCachedViews.size();
            for (int j = 0; j < k; j++)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(j);
                if (viewholder != null)
                {
                    viewholder.addFlags(512);
                }
            }

        }

        final void setRecycledViewPool(RecycledViewPool recycledviewpool)
        {
            if (mRecyclerPool != null)
            {
                mRecyclerPool.detach();
            }
            mRecyclerPool = recycledviewpool;
            if (recycledviewpool != null)
            {
                mRecyclerPool.attach(getAdapter());
            }
        }

        final void setViewCacheExtension(ViewCacheExtension viewcacheextension)
        {
            mViewCacheExtension = viewcacheextension;
        }

        public final void setViewCacheSize(int j)
        {
            mViewCacheMax = j;
            for (int k = mCachedViews.size() - 1; k >= 0 && mCachedViews.size() > j; k--)
            {
                recycleCachedViewAt(k);
            }

        }

        final void unscrapView(ViewHolder viewholder)
        {
            if (!viewholder.isChanged() || !supportsChangeAnimations() || mChangedScrap == null)
            {
                mAttachedScrap.remove(viewholder);
            } else
            {
                mChangedScrap.remove(viewholder);
            }
            viewholder.mScrapContainer = null;
            viewholder.clearReturnedFromScrapFlag();
        }

        final boolean validateViewHolderForOffsetPosition(ViewHolder viewholder)
        {
            if (!viewholder.isRemoved())
            {
                if (viewholder.mPosition < 0 || viewholder.mPosition >= mAdapter.getItemCount())
                {
                    throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid view holder adapter position")).append(viewholder).toString());
                }
                if (!mState.isPreLayout() && mAdapter.getItemViewType(viewholder.mPosition) != viewholder.getItemViewType())
                {
                    return false;
                }
                if (mAdapter.hasStableIds() && viewholder.getItemId() != mAdapter.getItemId(viewholder.mPosition))
                {
                    return false;
                }
            }
            return true;
        }

        final void viewRangeUpdate(int j, int k)
        {
            for (int l = mCachedViews.size() - 1; l >= 0; l--)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(l);
                if (viewholder == null)
                {
                    continue;
                }
                int i1 = viewholder.getLayoutPosition();
                if (i1 >= j && i1 < j + k)
                {
                    viewholder.addFlags(2);
                    recycleCachedViewAt(l);
                }
            }

        }


        public Recycler()
        {
            this$0 = RecyclerView.this;
            super();
            mChangedScrap = null;
            mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
            mViewCacheMax = 2;
        }
    }

    public static interface RecyclerListener
    {

        public abstract void onViewRecycled(ViewHolder viewholder);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver
    {

        final RecyclerView this$0;

        public void onChanged()
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapter.hasStableIds())
            {
                mState.mStructureChanged = true;
                setDataSetChangedAfterLayout();
            } else
            {
                mState.mStructureChanged = true;
                setDataSetChangedAfterLayout();
            }
            if (!mAdapterHelper.hasPendingUpdates())
            {
                requestLayout();
            }
        }

        public void onItemRangeChanged(int j, int k, Object obj)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeChanged(j, k, obj))
            {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeInserted(int j, int k)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeInserted(j, k))
            {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeMoved(int j, int k, int l)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeMoved(j, k, l))
            {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeRemoved(int j, int k)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeRemoved(j, k))
            {
                triggerUpdateProcessor();
            }
        }

        void triggerUpdateProcessor()
        {
            if (mPostUpdatesOnAnimation && mHasFixedSize && mIsAttached)
            {
                x.a(RecyclerView.this, mUpdateChildViewsRunnable);
                return;
            } else
            {
                mAdapterUpdateDuringMeasure = true;
                requestLayout();
                return;
            }
        }

        private RecyclerViewDataObserver()
        {
            this$0 = RecyclerView.this;
            super();
        }

    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final SavedState[] newArray(int j)
            {
                return new SavedState[j];
            }

            public final volatile Object[] newArray(int j)
            {
                return newArray(j);
            }

        };
        Parcelable mLayoutState;

        private void copyFrom(SavedState savedstate)
        {
            mLayoutState = savedstate.mLayoutState;
        }

        public void writeToParcel(Parcel parcel, int j)
        {
            super.writeToParcel(parcel, j);
            parcel.writeParcelable(mLayoutState, 0);
        }



        SavedState(Parcel parcel)
        {
            super(parcel);
            mLayoutState = parcel.readParcelable(android/support/v7/widget/RecyclerView$LayoutManager.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static class SimpleOnItemTouchListener
        implements OnItemTouchListener
    {

        public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
        {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean flag)
        {
        }

        public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
        {
        }

        public SimpleOnItemTouchListener()
        {
        }
    }

    public static abstract class SmoothScroller
    {

        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction = new Action(0, 0);
        private boolean mRunning;
        private int mTargetPosition;
        private View mTargetView;

        private void onAnimation(int j, int k)
        {
label0:
            {
                RecyclerView recyclerview = mRecyclerView;
                if (!mRunning || mTargetPosition == -1 || recyclerview == null)
                {
                    stop();
                }
                mPendingInitialRun = false;
                if (mTargetView != null)
                {
                    if (getChildPosition(mTargetView) == mTargetPosition)
                    {
                        onTargetFound(mTargetView, recyclerview.mState, mRecyclingAction);
                        mRecyclingAction.runIfNecessary(recyclerview);
                        stop();
                    } else
                    {
                        Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                        mTargetView = null;
                    }
                }
                if (mRunning)
                {
                    onSeekTargetStep(j, k, recyclerview.mState, mRecyclingAction);
                    boolean flag = mRecyclingAction.hasJumpTarget();
                    mRecyclingAction.runIfNecessary(recyclerview);
                    if (flag)
                    {
                        if (!mRunning)
                        {
                            break label0;
                        }
                        mPendingInitialRun = true;
                        recyclerview.mViewFlinger.postOnAnimation();
                    }
                }
                return;
            }
            stop();
        }

        public View findViewByPosition(int j)
        {
            return mRecyclerView.mLayout.findViewByPosition(j);
        }

        public int getChildCount()
        {
            return mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view)
        {
            return mRecyclerView.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager()
        {
            return mLayoutManager;
        }

        public int getTargetPosition()
        {
            return mTargetPosition;
        }

        public void instantScrollToPosition(int j)
        {
            mRecyclerView.scrollToPosition(j);
        }

        public boolean isPendingInitialRun()
        {
            return mPendingInitialRun;
        }

        public boolean isRunning()
        {
            return mRunning;
        }

        protected void normalize(PointF pointf)
        {
            double d1 = Math.sqrt(pointf.x * pointf.x + pointf.y * pointf.y);
            pointf.x = (float)((double)pointf.x / d1);
            pointf.y = (float)((double)pointf.y / d1);
        }

        protected void onChildAttachedToWindow(View view)
        {
            if (getChildPosition(view) == getTargetPosition())
            {
                mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(int j, int k, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        public void setTargetPosition(int j)
        {
            mTargetPosition = j;
        }

        void start(RecyclerView recyclerview, LayoutManager layoutmanager)
        {
            mRecyclerView = recyclerview;
            mLayoutManager = layoutmanager;
            if (mTargetPosition == -1)
            {
                throw new IllegalArgumentException("Invalid target position");
            } else
            {
                mRecyclerView.mState.mTargetPosition = mTargetPosition;
                mRunning = true;
                mPendingInitialRun = true;
                mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                mRecyclerView.mViewFlinger.postOnAnimation();
                return;
            }
        }

        protected final void stop()
        {
            if (!mRunning)
            {
                return;
            } else
            {
                onStop();
                mRecyclerView.mState.mTargetPosition = -1;
                mTargetView = null;
                mTargetPosition = -1;
                mPendingInitialRun = false;
                mRunning = false;
                mLayoutManager.onSmoothScrollerStopped(this);
                mLayoutManager = null;
                mRecyclerView = null;
                return;
            }
        }


        public SmoothScroller()
        {
            mTargetPosition = -1;
        }
    }

    public static class SmoothScroller.Action
    {

        public static final int UNDEFINED_DURATION = 0x80000000;
        private boolean changed;
        private int consecutiveUpdates;
        private int mDuration;
        private int mDx;
        private int mDy;
        private Interpolator mInterpolator;
        private int mJumpToPosition;

        private void runIfNecessary(RecyclerView recyclerview)
        {
            if (mJumpToPosition >= 0)
            {
                int j = mJumpToPosition;
                mJumpToPosition = -1;
                recyclerview.jumpToPositionForSmoothScroller(j);
                changed = false;
                return;
            }
            if (changed)
            {
                validate();
                if (mInterpolator == null)
                {
                    if (mDuration == 0x80000000)
                    {
                        recyclerview.mViewFlinger.smoothScrollBy(mDx, mDy);
                    } else
                    {
                        recyclerview.mViewFlinger.smoothScrollBy(mDx, mDy, mDuration);
                    }
                } else
                {
                    recyclerview.mViewFlinger.smoothScrollBy(mDx, mDy, mDuration, mInterpolator);
                }
                consecutiveUpdates = consecutiveUpdates + 1;
                if (consecutiveUpdates > 10)
                {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                changed = false;
                return;
            } else
            {
                consecutiveUpdates = 0;
                return;
            }
        }

        private void validate()
        {
            if (mInterpolator != null && mDuration <= 0)
            {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            if (mDuration <= 0)
            {
                throw new IllegalStateException("Scroll duration must be a positive number");
            } else
            {
                return;
            }
        }

        public int getDuration()
        {
            return mDuration;
        }

        public int getDx()
        {
            return mDx;
        }

        public int getDy()
        {
            return mDy;
        }

        public Interpolator getInterpolator()
        {
            return mInterpolator;
        }

        boolean hasJumpTarget()
        {
            return mJumpToPosition >= 0;
        }

        public void jumpTo(int j)
        {
            mJumpToPosition = j;
        }

        public void setDuration(int j)
        {
            changed = true;
            mDuration = j;
        }

        public void setDx(int j)
        {
            changed = true;
            mDx = j;
        }

        public void setDy(int j)
        {
            changed = true;
            mDy = j;
        }

        public void setInterpolator(Interpolator interpolator)
        {
            changed = true;
            mInterpolator = interpolator;
        }

        public void update(int j, int k, int l, Interpolator interpolator)
        {
            mDx = j;
            mDy = k;
            mDuration = l;
            mInterpolator = interpolator;
            changed = true;
        }


        public SmoothScroller.Action(int j, int k)
        {
            this(j, k, 0x80000000, null);
        }

        public SmoothScroller.Action(int j, int k, int l)
        {
            this(j, k, l, null);
        }

        public SmoothScroller.Action(int j, int k, int l, Interpolator interpolator)
        {
            mJumpToPosition = -1;
            changed = false;
            consecutiveUpdates = 0;
            mDx = j;
            mDy = k;
            mDuration = l;
            mInterpolator = interpolator;
        }
    }

    public static class State
    {

        private SparseArray mData;
        private int mDeletedInvisibleItemCountSincePreviousLayout;
        final List mDisappearingViewsInLayoutPass = new ArrayList();
        private boolean mInPreLayout;
        int mItemCount;
        android.support.v4.g.a mOldChangedHolders;
        android.support.v4.g.a mPostLayoutHolderMap;
        android.support.v4.g.a mPreLayoutHolderMap;
        private int mPreviousLayoutItemCount;
        private boolean mRunPredictiveAnimations;
        private boolean mRunSimpleAnimations;
        private boolean mStructureChanged;
        private int mTargetPosition;

        private void removeFrom(android.support.v4.g.a a1, ViewHolder viewholder)
        {
            int j = a1.size() - 1;
            do
            {
label0:
                {
                    if (j >= 0)
                    {
                        if (viewholder != a1.c(j))
                        {
                            break label0;
                        }
                        a1.d(j);
                    }
                    return;
                }
                j--;
            } while (true);
        }

        void addToDisappearingList(View view)
        {
            if (!mDisappearingViewsInLayoutPass.contains(view))
            {
                mDisappearingViewsInLayoutPass.add(view);
            }
        }

        public boolean didStructureChange()
        {
            return mStructureChanged;
        }

        public Object get(int j)
        {
            if (mData == null)
            {
                return null;
            } else
            {
                return mData.get(j);
            }
        }

        public int getItemCount()
        {
            if (mInPreLayout)
            {
                return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
            } else
            {
                return mItemCount;
            }
        }

        public int getTargetScrollPosition()
        {
            return mTargetPosition;
        }

        public boolean hasTargetScrollPosition()
        {
            return mTargetPosition != -1;
        }

        public boolean isPreLayout()
        {
            return mInPreLayout;
        }

        public void onViewIgnored(ViewHolder viewholder)
        {
            onViewRecycled(viewholder);
        }

        void onViewRecycled(ViewHolder viewholder)
        {
            mPreLayoutHolderMap.remove(viewholder);
            mPostLayoutHolderMap.remove(viewholder);
            if (mOldChangedHolders != null)
            {
                removeFrom(mOldChangedHolders, viewholder);
            }
            mDisappearingViewsInLayoutPass.remove(viewholder.itemView);
        }

        public void put(int j, Object obj)
        {
            if (mData == null)
            {
                mData = new SparseArray();
            }
            mData.put(j, obj);
        }

        public void remove(int j)
        {
            if (mData == null)
            {
                return;
            } else
            {
                mData.remove(j);
                return;
            }
        }

        void removeFromDisappearingList(View view)
        {
            mDisappearingViewsInLayoutPass.remove(view);
        }

        State reset()
        {
            mTargetPosition = -1;
            if (mData != null)
            {
                mData.clear();
            }
            mItemCount = 0;
            mStructureChanged = false;
            return this;
        }

        public String toString()
        {
            return (new StringBuilder("State{mTargetPosition=")).append(mTargetPosition).append(", mPreLayoutHolderMap=").append(mPreLayoutHolderMap).append(", mPostLayoutHolderMap=").append(mPostLayoutHolderMap).append(", mData=").append(mData).append(", mItemCount=").append(mItemCount).append(", mPreviousLayoutItemCount=").append(mPreviousLayoutItemCount).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(mDeletedInvisibleItemCountSincePreviousLayout).append(", mStructureChanged=").append(mStructureChanged).append(", mInPreLayout=").append(mInPreLayout).append(", mRunSimpleAnimations=").append(mRunSimpleAnimations).append(", mRunPredictiveAnimations=").append(mRunPredictiveAnimations).append('}').toString();
        }

        public boolean willRunPredictiveAnimations()
        {
            return mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations()
        {
            return mRunSimpleAnimations;
        }


/*
        static int access$1202(State state, int j)
        {
            state.mDeletedInvisibleItemCountSincePreviousLayout = j;
            return j;
        }

*/


/*
        static int access$1212(State state, int j)
        {
            j = state.mDeletedInvisibleItemCountSincePreviousLayout + j;
            state.mDeletedInvisibleItemCountSincePreviousLayout = j;
            return j;
        }

*/



/*
        static boolean access$1402(State state, boolean flag)
        {
            state.mStructureChanged = flag;
            return flag;
        }

*/



/*
        static boolean access$1602(State state, boolean flag)
        {
            state.mRunPredictiveAnimations = flag;
            return flag;
        }

*/



/*
        static boolean access$1702(State state, boolean flag)
        {
            state.mInPreLayout = flag;
            return flag;
        }

*/



/*
        static boolean access$1802(State state, boolean flag)
        {
            state.mRunSimpleAnimations = flag;
            return flag;
        }

*/


/*
        static int access$2102(State state, int j)
        {
            state.mPreviousLayoutItemCount = j;
            return j;
        }

*/


/*
        static int access$4802(State state, int j)
        {
            state.mTargetPosition = j;
            return j;
        }

*/

        public State()
        {
            mTargetPosition = -1;
            mPreLayoutHolderMap = new android.support.v4.g.a();
            mPostLayoutHolderMap = new android.support.v4.g.a();
            mOldChangedHolders = new android.support.v4.g.a();
            mItemCount = 0;
            mPreviousLayoutItemCount = 0;
            mDeletedInvisibleItemCountSincePreviousLayout = 0;
            mStructureChanged = false;
            mInPreLayout = false;
            mRunSimpleAnimations = false;
            mRunPredictiveAnimations = false;
        }
    }

    public static abstract class ViewCacheExtension
    {

        public abstract View getViewForPositionAndType(Recycler recycler, int j, int k);

        public ViewCacheExtension()
        {
        }
    }

    private class ViewFlinger
        implements Runnable
    {

        private boolean mEatRunOnAnimationRequest;
        private Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        private boolean mReSchedulePostAnimationCallback;
        private r mScroller;
        final RecyclerView this$0;

        private int computeScrollDuration(int j, int k, int l, int i1)
        {
            int j1 = Math.abs(j);
            int k1 = Math.abs(k);
            float f;
            float f1;
            float f2;
            boolean flag;
            if (j1 > k1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l = (int)Math.sqrt(l * l + i1 * i1);
            k = (int)Math.sqrt(j * j + k * k);
            if (flag)
            {
                j = getWidth();
            } else
            {
                j = getHeight();
            }
            i1 = j / 2;
            f2 = Math.min(1.0F, ((float)k * 1.0F) / (float)j);
            f = i1;
            f1 = i1;
            f2 = distanceInfluenceForSnapDuration(f2);
            if (l > 0)
            {
                j = Math.round(1000F * Math.abs((f2 * f1 + f) / (float)l)) * 4;
            } else
            {
                if (flag)
                {
                    k = j1;
                } else
                {
                    k = k1;
                }
                j = (int)(((float)k / (float)j + 1.0F) * 300F);
            }
            return Math.min(j, 2000);
        }

        private void disableRunOnAnimationRequests()
        {
            mReSchedulePostAnimationCallback = false;
            mEatRunOnAnimationRequest = true;
        }

        private float distanceInfluenceForSnapDuration(float f)
        {
            return (float)Math.sin((float)((double)(f - 0.5F) * 0.4712389167638204D));
        }

        private void enableRunOnAnimationRequests()
        {
            mEatRunOnAnimationRequest = false;
            if (mReSchedulePostAnimationCallback)
            {
                postOnAnimation();
            }
        }

        public void fling(int j, int k)
        {
            setScrollState(2);
            mLastFlingY = 0;
            mLastFlingX = 0;
            mScroller.a(0, j, k, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
            postOnAnimation();
        }

        void postOnAnimation()
        {
            if (mEatRunOnAnimationRequest)
            {
                mReSchedulePostAnimationCallback = true;
                return;
            } else
            {
                removeCallbacks(this);
                x.a(RecyclerView.this, this);
                return;
            }
        }

        public void run()
        {
            r r1;
            SmoothScroller smoothscroller;
            disableRunOnAnimationRequests();
            consumePendingUpdateOperations();
            r1 = mScroller;
            smoothscroller = mLayout.mSmoothScroller;
            if (!r1.g()) goto _L2; else goto _L1
_L1:
            int j;
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            l2 = r1.b();
            i3 = r1.c();
            j2 = l2 - mLastFlingX;
            k2 = i3 - mLastFlingY;
            k1 = 0;
            j = 0;
            l1 = 0;
            i1 = 0;
            mLastFlingX = l2;
            mLastFlingY = i3;
            i2 = 0;
            k = 0;
            j1 = 0;
            l = 0;
            if (mAdapter == null)
            {
                break MISSING_BLOCK_LABEL_840;
            }
            eatRequestLayout();
            onEnterLayoutOrScroll();
            d.a("RV Scroll");
            if (j2 != 0)
            {
                j = mLayout.scrollHorizontallyBy(j2, mRecycler, mState);
                k = j2 - j;
            }
            if (k2 != 0)
            {
                i1 = mLayout.scrollVerticallyBy(k2, mRecycler, mState);
                l = k2 - i1;
            }
            d.a();
            if (supportsChangeAnimations())
            {
                k1 = mChildHelper.getChildCount();
                for (j1 = 0; j1 < k1; j1++)
                {
                    View view = mChildHelper.getChildAt(j1);
                    Object obj = getChildViewHolder(view);
                    if (obj == null || ((ViewHolder) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((ViewHolder) (obj)).mShadowingHolder.itemView;
                    l1 = view.getLeft();
                    i2 = view.getTop();
                    if (l1 != ((View) (obj)).getLeft() || i2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(l1, i2, ((View) (obj)).getWidth() + l1, ((View) (obj)).getHeight() + i2);
                    }
                }

            }
            onExitLayoutOrScroll();
            resumeRequestLayout(false);
            j1 = l;
            l1 = i1;
            i2 = k;
            k1 = j;
            if (smoothscroller == null)
            {
                break MISSING_BLOCK_LABEL_840;
            }
            j1 = l;
            l1 = i1;
            i2 = k;
            k1 = j;
            if (smoothscroller.isPendingInitialRun())
            {
                break MISSING_BLOCK_LABEL_840;
            }
            j1 = l;
            l1 = i1;
            i2 = k;
            k1 = j;
            if (!smoothscroller.isRunning())
            {
                break MISSING_BLOCK_LABEL_840;
            }
            j1 = mState.getItemCount();
            if (j1 != 0) goto _L4; else goto _L3
_L3:
            smoothscroller.stop();
            k1 = j;
_L5:
            if (!mItemDecorations.isEmpty())
            {
                invalidate();
            }
            if (x.a(RecyclerView.this) != 2)
            {
                considerReleasingGlowsOnScroll(j2, k2);
            }
            if (k != 0 || l != 0)
            {
                j1 = (int)r1.f();
                if (k != l2)
                {
                    if (k < 0)
                    {
                        j = -j1;
                    } else
                    if (k > 0)
                    {
                        j = j1;
                    } else
                    {
                        j = 0;
                    }
                    l1 = j;
                } else
                {
                    l1 = 0;
                }
                if (l != i3)
                {
                    if (l < 0)
                    {
                        j = -j1;
                    } else
                    {
                        j = j1;
                        if (l <= 0)
                        {
                            j = 0;
                        }
                    }
                } else
                {
                    j = 0;
                }
                if (x.a(RecyclerView.this) != 2)
                {
                    absorbGlows(l1, j);
                }
                if ((l1 != 0 || k == l2 || r1.d() == 0) && (j != 0 || l == i3 || r1.e() == 0))
                {
                    r1.h();
                }
            }
            if (k1 != 0 || i1 != 0)
            {
                dispatchOnScrolled(k1, i1);
            }
            if (!awakenScrollBars())
            {
                invalidate();
            }
            if (k2 != 0 && mLayout.canScrollVertically() && i1 == k2)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j2 != 0 && mLayout.canScrollHorizontally() && k1 == j2)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (j2 == 0 && k2 == 0 || k != 0 || j != 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (r1.a() || j == 0)
            {
                setScrollState(0);
            } else
            {
                postOnAnimation();
            }
_L2:
            if (smoothscroller != null)
            {
                if (smoothscroller.isPendingInitialRun())
                {
                    smoothscroller.onAnimation(0, 0);
                }
                if (!mReSchedulePostAnimationCallback)
                {
                    smoothscroller.stop();
                }
            }
            enableRunOnAnimationRequests();
            return;
_L4:
            if (smoothscroller.getTargetPosition() >= j1)
            {
                smoothscroller.setTargetPosition(j1 - 1);
            }
            smoothscroller.onAnimation(j2 - k, k2 - l);
            k1 = j;
            i2 = k;
            l1 = i1;
            j1 = l;
            i1 = l1;
            k = i2;
            l = j1;
              goto _L5
        }

        public void smoothScrollBy(int j, int k)
        {
            smoothScrollBy(j, k, 0, 0);
        }

        public void smoothScrollBy(int j, int k, int l)
        {
            smoothScrollBy(j, k, l, RecyclerView.sQuinticInterpolator);
        }

        public void smoothScrollBy(int j, int k, int l, int i1)
        {
            smoothScrollBy(j, k, computeScrollDuration(j, k, l, i1));
        }

        public void smoothScrollBy(int j, int k, int l, Interpolator interpolator)
        {
            if (mInterpolator != interpolator)
            {
                mInterpolator = interpolator;
                mScroller = r.a(getContext(), interpolator);
            }
            setScrollState(2);
            mLastFlingY = 0;
            mLastFlingX = 0;
            mScroller.a(0, 0, j, k, l);
            postOnAnimation();
        }

        public void stop()
        {
            removeCallbacks(this);
            mScroller.h();
        }

        public ViewFlinger()
        {
            this$0 = RecyclerView.this;
            super();
            mInterpolator = RecyclerView.sQuinticInterpolator;
            mEatRunOnAnimationRequest = false;
            mReSchedulePostAnimationCallback = false;
            mScroller = r.a(getContext(), RecyclerView.sQuinticInterpolator);
        }
    }

    public static abstract class ViewHolder
    {

        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_BOUND = 1;
        static final int FLAG_CHANGED = 64;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List FULLUPDATE_PAYLOADS;
        public final View itemView;
        private int mFlags;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List mPayloads;
        int mPosition;
        int mPreLayoutPosition;
        private Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        private void createPayloadsIfNeeded()
        {
            if (mPayloads == null)
            {
                mPayloads = new ArrayList();
                mUnmodifiedPayloads = Collections.unmodifiableList(mPayloads);
            }
        }

        private boolean doesTransientStatePreventRecycling()
        {
            return (mFlags & 0x10) == 0 && x.c(itemView);
        }

        private void onEnteredHiddenState()
        {
            mWasImportantForAccessibilityBeforeHidden = x.e(itemView);
            x.d(itemView, 4);
        }

        private void onLeftHiddenState()
        {
            x.d(itemView, mWasImportantForAccessibilityBeforeHidden);
            mWasImportantForAccessibilityBeforeHidden = 0;
        }

        private boolean shouldBeKeptAsChild()
        {
            return (mFlags & 0x10) != 0;
        }

        void addChangePayload(Object obj)
        {
            if (obj == null)
            {
                addFlags(1024);
            } else
            if ((mFlags & 0x400) == 0)
            {
                createPayloadsIfNeeded();
                mPayloads.add(obj);
                return;
            }
        }

        void addFlags(int j)
        {
            mFlags = mFlags | j;
        }

        void clearOldPosition()
        {
            mOldPosition = -1;
            mPreLayoutPosition = -1;
        }

        void clearPayload()
        {
            if (mPayloads != null)
            {
                mPayloads.clear();
            }
            mFlags = mFlags & 0xfffffbff;
        }

        void clearReturnedFromScrapFlag()
        {
            mFlags = mFlags & 0xffffffdf;
        }

        void clearTmpDetachFlag()
        {
            mFlags = mFlags & 0xfffffeff;
        }

        void flagRemovedAndOffsetPosition(int j, int k, boolean flag)
        {
            addFlags(8);
            offsetPosition(k, flag);
            mPosition = j;
        }

        public final int getAdapterPosition()
        {
            if (mOwnerRecyclerView == null)
            {
                return -1;
            } else
            {
                return mOwnerRecyclerView.getAdapterPositionFor(this);
            }
        }

        public final long getItemId()
        {
            return mItemId;
        }

        public final int getItemViewType()
        {
            return mItemViewType;
        }

        public final int getLayoutPosition()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        public final int getOldPosition()
        {
            return mOldPosition;
        }

        public final int getPosition()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        List getUnmodifiedPayloads()
        {
            if ((mFlags & 0x400) == 0)
            {
                if (mPayloads == null || mPayloads.size() == 0)
                {
                    return FULLUPDATE_PAYLOADS;
                } else
                {
                    return mUnmodifiedPayloads;
                }
            } else
            {
                return FULLUPDATE_PAYLOADS;
            }
        }

        boolean hasAnyOfTheFlags(int j)
        {
            return (mFlags & j) != 0;
        }

        boolean isAdapterPositionUnknown()
        {
            return (mFlags & 0x200) != 0 || isInvalid();
        }

        boolean isBound()
        {
            return (mFlags & 1) != 0;
        }

        boolean isChanged()
        {
            return (mFlags & 0x40) != 0;
        }

        boolean isInvalid()
        {
            return (mFlags & 4) != 0;
        }

        public final boolean isRecyclable()
        {
            return (mFlags & 0x10) == 0 && !x.c(itemView);
        }

        boolean isRemoved()
        {
            return (mFlags & 8) != 0;
        }

        boolean isScrap()
        {
            return mScrapContainer != null;
        }

        boolean isTmpDetached()
        {
            return (mFlags & 0x100) != 0;
        }

        boolean needsUpdate()
        {
            return (mFlags & 2) != 0;
        }

        void offsetPosition(int j, boolean flag)
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
            if (mPreLayoutPosition == -1)
            {
                mPreLayoutPosition = mPosition;
            }
            if (flag)
            {
                mPreLayoutPosition = mPreLayoutPosition + j;
            }
            mPosition = mPosition + j;
            if (itemView.getLayoutParams() != null)
            {
                ((LayoutParams)itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void resetInternal()
        {
            mFlags = 0;
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mPreLayoutPosition = -1;
            mIsRecyclableCount = 0;
            mShadowedHolder = null;
            mShadowingHolder = null;
            clearPayload();
            mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void saveOldPosition()
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
        }

        void setFlags(int j, int k)
        {
            mFlags = mFlags & ~k | j & k;
        }

        public final void setIsRecyclable(boolean flag)
        {
            int j;
            if (flag)
            {
                j = mIsRecyclableCount - 1;
            } else
            {
                j = mIsRecyclableCount + 1;
            }
            mIsRecyclableCount = j;
            if (mIsRecyclableCount < 0)
            {
                mIsRecyclableCount = 0;
                Log.e("View", (new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ")).append(this).toString());
            } else
            {
                if (!flag && mIsRecyclableCount == 1)
                {
                    mFlags = mFlags | 0x10;
                    return;
                }
                if (flag && mIsRecyclableCount == 0)
                {
                    mFlags = mFlags & 0xffffffef;
                    return;
                }
            }
        }

        void setScrapContainer(Recycler recycler)
        {
            mScrapContainer = recycler;
        }

        boolean shouldIgnore()
        {
            return (mFlags & 0x80) != 0;
        }

        void stopIgnoring()
        {
            mFlags = mFlags & 0xffffff7f;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder("ViewHolder{")).append(Integer.toHexString(hashCode())).append(" position=").append(mPosition).append(" id=").append(mItemId).append(", oldPos=").append(mOldPosition).append(", pLpos:").append(mPreLayoutPosition).toString());
            if (isScrap())
            {
                stringbuilder.append(" scrap");
            }
            if (isInvalid())
            {
                stringbuilder.append(" invalid");
            }
            if (!isBound())
            {
                stringbuilder.append(" unbound");
            }
            if (needsUpdate())
            {
                stringbuilder.append(" update");
            }
            if (isRemoved())
            {
                stringbuilder.append(" removed");
            }
            if (shouldIgnore())
            {
                stringbuilder.append(" ignored");
            }
            if (isChanged())
            {
                stringbuilder.append(" changed");
            }
            if (isTmpDetached())
            {
                stringbuilder.append(" tmpDetached");
            }
            if (!isRecyclable())
            {
                stringbuilder.append((new StringBuilder(" not recyclable(")).append(mIsRecyclableCount).append(")").toString());
            }
            if (isAdapterPositionUnknown())
            {
                stringbuilder.append("undefined adapter position");
            }
            if (itemView.getParent() == null)
            {
                stringbuilder.append(" no parent");
            }
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        void unScrap()
        {
            mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap()
        {
            return (mFlags & 0x20) != 0;
        }

        static 
        {
            FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        }





/*
        static Recycler access$4202(ViewHolder viewholder, Recycler recycler)
        {
            viewholder.mScrapContainer = recycler;
            return recycler;
        }

*/



        public ViewHolder(View view)
        {
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mItemViewType = -1;
            mPreLayoutPosition = -1;
            mShadowedHolder = null;
            mShadowingHolder = null;
            mPayloads = null;
            mUnmodifiedPayloads = null;
            mIsRecyclableCount = 0;
            mScrapContainer = null;
            mWasImportantForAccessibilityBeforeHidden = 0;
            if (view == null)
            {
                throw new IllegalArgumentException("itemView may not be null");
            } else
            {
                itemView = view;
                return;
            }
        }
    }


    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE[];
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    private static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator = new Interpolator() {

        public final float getInterpolation(float f)
        {
            f--;
            return f * (f * f * f * f) + 1.0F;
        }

    };
    private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    private Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private i mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    private boolean mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner = new Runnable() {

        final RecyclerView this$0;

        public void run()
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.runPendingAnimations();
            }
            mPostedAnimatorRunner = false;
        }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
    };
    private final ArrayList mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    private LayoutManager mLayout;
    private boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    private boolean mLayoutRequestEaten;
    private i mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int mMinMaxLayoutPositions[];
    private final int mNestedOffsets[];
    private final RecyclerViewDataObserver mObserver;
    private List mOnChildAttachStateListeners;
    private final ArrayList mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final Recycler mRecycler;
    private RecyclerListener mRecyclerListener;
    private i mRightGlow;
    private final int mScrollConsumed[];
    private float mScrollFactor;
    private OnScrollListener mScrollListener;
    private List mScrollListeners;
    private final int mScrollOffset[];
    private int mScrollPointerId;
    private int mScrollState;
    private final p mScrollingChildHelper;
    final State mState;
    private final Rect mTempRect;
    private i mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final ViewFlinger mViewFlinger;

    public RecyclerView(Context context)
    {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        mObserver = new RecyclerViewDataObserver();
        mRecycler = new Recycler();
        mUpdateChildViewsRunnable = new Runnable() {

            final RecyclerView this$0;

            public void run()
            {
                if (mFirstLayoutComplete)
                {
                    if (mDataSetHasChangedAfterLayout)
                    {
                        d.a("RV FullInvalidate");
                        dispatchLayout();
                        d.a();
                        return;
                    }
                    if (mAdapterHelper.hasPendingUpdates())
                    {
                        d.a("RV PartialInvalidate");
                        eatRequestLayout();
                        mAdapterHelper.preProcess();
                        if (!mLayoutRequestEaten)
                        {
                            rebindUpdatedViewHolders();
                        }
                        resumeRequestLayout(true);
                        d.a();
                        return;
                    }
                }
            }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
        };
        mTempRect = new Rect();
        mItemDecorations = new ArrayList();
        mOnItemTouchListeners = new ArrayList();
        mDataSetHasChangedAfterLayout = false;
        mLayoutOrScrollCounter = 0;
        mItemAnimator = new DefaultItemAnimator();
        mScrollState = 0;
        mScrollPointerId = -1;
        mScrollFactor = 1.401298E-45F;
        mViewFlinger = new ViewFlinger();
        mState = new State();
        mItemsAddedOrRemoved = false;
        mItemsChanged = false;
        mItemAnimatorListener = new ItemAnimatorRestoreListener();
        mPostedAnimatorRunner = false;
        mMinMaxLayoutPositions = new int[2];
        mScrollOffset = new int[2];
        mScrollConsumed = new int[2];
        mNestedOffsets = new int[2];
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewconfiguration;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPostUpdatesOnAnimation = flag;
        viewconfiguration = ViewConfiguration.get(context);
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        if (x.a(this) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        mItemAnimator.setListener(mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (x.e(this) == 0)
        {
            x.d(this, 1);
        }
        mAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeset != null)
        {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.v7.recyclerview.R.styleable.RecyclerView, j, 0);
            String s = typedarray.getString(android.support.v7.recyclerview.R.styleable.RecyclerView_layoutManager);
            typedarray.recycle();
            createLayoutManager(context, s, attributeset, j, 0);
        }
        mScrollingChildHelper = new p(this);
        setNestedScrollingEnabled(true);
    }

    private void addAnimatingView(ViewHolder viewholder)
    {
        View view = viewholder.itemView;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecycler.unscrapView(getChildViewHolder(view));
        if (viewholder.isTmpDetached())
        {
            mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            mChildHelper.addView(view, true);
            return;
        } else
        {
            mChildHelper.hide(view);
            return;
        }
    }

    private void animateAppearance(ViewHolder viewholder, Rect rect, int j, int k)
    {
        View view = viewholder.itemView;
        if (rect != null && (rect.left != j || rect.top != k))
        {
            viewholder.setIsRecyclable(false);
            if (mItemAnimator.animateMove(viewholder, rect.left, rect.top, j, k))
            {
                postAnimationRunner();
            }
        } else
        {
            viewholder.setIsRecyclable(false);
            if (mItemAnimator.animateAdd(viewholder))
            {
                postAnimationRunner();
                return;
            }
        }
    }

    private void animateChange(ViewHolder viewholder, ViewHolder viewholder1)
    {
        viewholder.setIsRecyclable(false);
        addAnimatingView(viewholder);
        viewholder.mShadowedHolder = viewholder1;
        mRecycler.unscrapView(viewholder);
        int l = viewholder.itemView.getLeft();
        int i1 = viewholder.itemView.getTop();
        int j;
        int k;
        if (viewholder1 == null || viewholder1.shouldIgnore())
        {
            k = i1;
            j = l;
        } else
        {
            j = viewholder1.itemView.getLeft();
            k = viewholder1.itemView.getTop();
            viewholder1.setIsRecyclable(false);
            viewholder1.mShadowingHolder = viewholder;
        }
        if (mItemAnimator.animateChange(viewholder, viewholder1, l, i1, j, k))
        {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(ItemHolderInfo itemholderinfo)
    {
        View view = itemholderinfo.holder.itemView;
        addAnimatingView(itemholderinfo.holder);
        int j = itemholderinfo.left;
        int k = itemholderinfo.top;
        int l = view.getLeft();
        int i1 = view.getTop();
        if (!itemholderinfo.holder.isRemoved() && (j != l || k != i1))
        {
            itemholderinfo.holder.setIsRecyclable(false);
            view.layout(l, i1, view.getWidth() + l, view.getHeight() + i1);
            if (mItemAnimator.animateMove(itemholderinfo.holder, j, k, l, i1))
            {
                postAnimationRunner();
            }
        } else
        {
            itemholderinfo.holder.setIsRecyclable(false);
            if (mItemAnimator.animateRemove(itemholderinfo.holder))
            {
                postAnimationRunner();
                return;
            }
        }
    }

    private void cancelTouch()
    {
        resetTouch();
        setScrollState(0);
    }

    private void considerReleasingGlowsOnScroll(int j, int k)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mLeftGlow != null)
        {
            flag = flag1;
            if (!mLeftGlow.a())
            {
                flag = flag1;
                if (j > 0)
                {
                    flag = mLeftGlow.c();
                }
            }
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag;
            if (!mRightGlow.a())
            {
                flag1 = flag;
                if (j < 0)
                {
                    flag1 = flag | mRightGlow.c();
                }
            }
        }
        flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1;
            if (!mTopGlow.a())
            {
                flag = flag1;
                if (k > 0)
                {
                    flag = flag1 | mTopGlow.c();
                }
            }
        }
        flag1 = flag;
        if (mBottomGlow != null)
        {
            flag1 = flag;
            if (!mBottomGlow.a())
            {
                flag1 = flag;
                if (k < 0)
                {
                    flag1 = flag | mBottomGlow.c();
                }
            }
        }
        if (flag1)
        {
            x.d(this);
        }
    }

    private void consumePendingUpdateOperations()
    {
        mUpdateChildViewsRunnable.run();
    }

    private void createLayoutManager(Context context, String s, AttributeSet attributeset, int j, int k)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        s = s.trim();
        if (s.length() == 0) goto _L2; else goto _L3
_L3:
        String s1 = getFullClassName(context, s);
        if (!isInEditMode()) goto _L5; else goto _L4
_L4:
        s = getClass().getClassLoader();
_L8:
        Class class1 = s.loadClass(s1).asSubclass(android/support/v7/widget/RecyclerView$LayoutManager);
        Object aobj[];
        s = class1.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
        aobj = new Object[4];
        aobj[0] = context;
        aobj[1] = attributeset;
        aobj[2] = Integer.valueOf(j);
        aobj[3] = Integer.valueOf(k);
        context = ((Context) (aobj));
_L6:
        try
        {
            s.setAccessible(true);
            setLayoutManager((LayoutManager)s.newInstance(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Unable to find LayoutManager ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Cannot access non-public constructor ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Class is not a LayoutManager ").append(s1).toString(), context);
        }
_L5:
        s = context.getClassLoader();
        continue; /* Loop/switch isn't completed */
        context;
        s = class1.getConstructor(new Class[0]);
        context = null;
          goto _L6
        s;
        s.initCause(context);
        throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error creating LayoutManager ").append(s1).toString(), s);
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void defaultOnMeasure(int j, int k)
    {
        int i1 = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getMode(k);
        j = android.view.View.MeasureSpec.getSize(j);
        k = android.view.View.MeasureSpec.getSize(k);
        switch (i1)
        {
        default:
            j = x.q(this);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (l)
            {
            default:
                k = x.r(this);
                // fall through

            case -2147483648: 
            case 1073741824: 
                setMeasuredDimension(j, k);
                break;
            }
            break;
        }
    }

    private boolean didChildRangeChange(int j, int k)
    {
        int i1;
        boolean flag1;
        flag1 = false;
        i1 = mChildHelper.getChildCount();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (j == 0)
            {
                flag = flag1;
                if (k == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        int l = 0;
        do
        {
            flag = flag1;
            if (l >= i1)
            {
                continue;
            }
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(l));
            if (!viewholder.shouldIgnore())
            {
                int j1 = viewholder.getLayoutPosition();
                if (j1 < j || j1 > k)
                {
                    return true;
                }
            }
            l++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void dispatchChildAttached(View view)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (mAdapter != null && viewholder != null)
        {
            mAdapter.onViewAttachedToWindow(viewholder);
        }
        if (mOnChildAttachStateListeners != null)
        {
            for (int j = mOnChildAttachStateListeners.size() - 1; j >= 0; j--)
            {
                ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(j)).onChildViewAttachedToWindow(view);
            }

        }
    }

    private void dispatchChildDetached(View view)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (mAdapter != null && viewholder != null)
        {
            mAdapter.onViewDetachedFromWindow(viewholder);
        }
        if (mOnChildAttachStateListeners != null)
        {
            for (int j = mOnChildAttachStateListeners.size() - 1; j >= 0; j--)
            {
                ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(j)).onChildViewDetachedFromWindow(view);
            }

        }
    }

    private void dispatchContentChangedIfNecessary()
    {
        int j = mEatenAccessibilityChangeFlags;
        mEatenAccessibilityChangeFlags = 0;
        if (j != 0 && isAccessibilityEnabled())
        {
            AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain();
            accessibilityevent.setEventType(2048);
            a.a(accessibilityevent, j);
            sendAccessibilityEventUnchecked(accessibilityevent);
        }
    }

    private boolean dispatchOnItemTouch(MotionEvent motionevent)
    {
        int j = motionevent.getAction();
        if (mActiveOnItemTouchListener == null) goto _L2; else goto _L1
_L1:
        if (j != 0) goto _L4; else goto _L3
_L3:
        mActiveOnItemTouchListener = null;
_L2:
        if (j == 0) goto _L6; else goto _L5
_L5:
        int k;
        k = mOnItemTouchListeners.size();
        j = 0;
_L7:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        OnItemTouchListener onitemtouchlistener = (OnItemTouchListener)mOnItemTouchListeners.get(j);
        if (onitemtouchlistener.onInterceptTouchEvent(this, motionevent))
        {
            mActiveOnItemTouchListener = onitemtouchlistener;
            return true;
        }
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        mActiveOnItemTouchListener.onTouchEvent(this, motionevent);
        if (j == 3 || j == 1)
        {
            mActiveOnItemTouchListener = null;
        }
        return true;
        if (true) goto _L7; else goto _L6
_L6:
        return false;
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionevent)
    {
        int k = motionevent.getAction();
        if (k == 3 || k == 0)
        {
            mActiveOnItemTouchListener = null;
        }
        int l = mOnItemTouchListeners.size();
        for (int j = 0; j < l; j++)
        {
            OnItemTouchListener onitemtouchlistener = (OnItemTouchListener)mOnItemTouchListeners.get(j);
            if (onitemtouchlistener.onInterceptTouchEvent(this, motionevent) && k != 3)
            {
                mActiveOnItemTouchListener = onitemtouchlistener;
                return true;
            }
        }

        return false;
    }

    private void findMinMaxChildLayoutPositions(int ai[])
    {
        int j;
        int l;
        int j1;
        int l1;
        l1 = mChildHelper.getChildCount();
        if (l1 == 0)
        {
            ai[0] = 0;
            ai[1] = 0;
            return;
        }
        j = 0x7fffffff;
        l = 0x80000000;
        j1 = 0;
_L2:
        int k;
        int i1;
        if (j1 >= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(j1));
        i1 = j;
        if (viewholder.shouldIgnore())
        {
            break MISSING_BLOCK_LABEL_123;
        }
        int k1 = viewholder.getLayoutPosition();
        k = j;
        if (k1 < j)
        {
            k = k1;
        }
        i1 = k;
        if (k1 <= l)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        j = k1;
_L3:
        j1++;
        l = j;
        j = k;
        if (true) goto _L2; else goto _L1
_L1:
        ai[0] = j;
        ai[1] = l;
        return;
        j = l;
        k = i1;
          goto _L3
    }

    private int getAdapterPositionFor(ViewHolder viewholder)
    {
        if (viewholder.hasAnyOfTheFlags(524) || !viewholder.isBound())
        {
            return -1;
        } else
        {
            return mAdapterHelper.applyPendingUpdatesToPosition(viewholder.mPosition);
        }
    }

    static ViewHolder getChildViewHolderInt(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((LayoutParams)view.getLayoutParams()).mViewHolder;
        }
    }

    private String getFullClassName(Context context, String s)
    {
        if (s.charAt(0) == '.')
        {
            context = (new StringBuilder()).append(context.getPackageName()).append(s).toString();
        } else
        {
            context = s;
            if (!s.contains("."))
            {
                return (new StringBuilder()).append(android/support/v7/widget/RecyclerView.getPackage().getName()).append('.').append(s).toString();
            }
        }
        return context;
    }

    private float getScrollFactor()
    {
label0:
        {
            if (mScrollFactor == 1.401298E-45F)
            {
                TypedValue typedvalue = new TypedValue();
                if (!getContext().getTheme().resolveAttribute(0x101004d, typedvalue, true))
                {
                    break label0;
                }
                mScrollFactor = typedvalue.getDimension(getContext().getResources().getDisplayMetrics());
            }
            return mScrollFactor;
        }
        return 0.0F;
    }

    private void initChildrenHelper()
    {
        mChildHelper = new ChildHelper(new ChildHelper.Callback() {

            final RecyclerView this$0;

            public void addView(View view, int j)
            {
                RecyclerView.this.addView(view, j);
                dispatchChildAttached(view);
            }

            public void attachViewToParent(View view, int j, android.view.ViewGroup.LayoutParams layoutparams)
            {
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (viewholder != null)
                {
                    if (!viewholder.isTmpDetached() && !viewholder.shouldIgnore())
                    {
                        throw new IllegalArgumentException((new StringBuilder("Called attach on a child which is not detached: ")).append(viewholder).toString());
                    }
                    viewholder.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, j, layoutparams);
            }

            public void detachViewFromParent(int j)
            {
                Object obj = getChildAt(j);
                if (obj != null)
                {
                    obj = RecyclerView.getChildViewHolderInt(((View) (obj)));
                    if (obj != null)
                    {
                        if (((ViewHolder) (obj)).isTmpDetached() && !((ViewHolder) (obj)).shouldIgnore())
                        {
                            throw new IllegalArgumentException((new StringBuilder("called detach on an already detached child ")).append(obj).toString());
                        }
                        ((ViewHolder) (obj)).addFlags(256);
                    }
                }
                RecyclerView.this.detachViewFromParent(j);
            }

            public View getChildAt(int j)
            {
                return RecyclerView.this.getChildAt(j);
            }

            public int getChildCount()
            {
                return RecyclerView.this.getChildCount();
            }

            public ViewHolder getChildViewHolder(View view)
            {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public int indexOfChild(View view)
            {
                return RecyclerView.this.indexOfChild(view);
            }

            public void onEnteredHiddenState(View view)
            {
                view = RecyclerView.getChildViewHolderInt(view);
                if (view != null)
                {
                    view.onEnteredHiddenState();
                }
            }

            public void onLeftHiddenState(View view)
            {
                view = RecyclerView.getChildViewHolderInt(view);
                if (view != null)
                {
                    view.onLeftHiddenState();
                }
            }

            public void removeAllViews()
            {
                int k = getChildCount();
                for (int j = 0; j < k; j++)
                {
                    dispatchChildDetached(getChildAt(j));
                }

                RecyclerView.this.removeAllViews();
            }

            public void removeViewAt(int j)
            {
                View view = RecyclerView.this.getChildAt(j);
                if (view != null)
                {
                    dispatchChildDetached(view);
                }
                RecyclerView.this.removeViewAt(j);
            }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
        });
    }

    private void jumpToPositionForSmoothScroller(int j)
    {
        if (mLayout == null)
        {
            return;
        } else
        {
            mLayout.scrollToPosition(j);
            awakenScrollBars();
            return;
        }
    }

    private void onEnterLayoutOrScroll()
    {
        mLayoutOrScrollCounter = mLayoutOrScrollCounter + 1;
    }

    private void onExitLayoutOrScroll()
    {
        mLayoutOrScrollCounter = mLayoutOrScrollCounter - 1;
        if (mLayoutOrScrollCounter <= 0)
        {
            mLayoutOrScrollCounter = 0;
            dispatchContentChangedIfNecessary();
        }
    }

    private void onPointerUp(MotionEvent motionevent)
    {
        int j = n.b(motionevent);
        if (n.b(motionevent, j) == mScrollPointerId)
        {
            int k;
            if (j == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            mScrollPointerId = n.b(motionevent, j);
            k = (int)(n.c(motionevent, j) + 0.5F);
            mLastTouchX = k;
            mInitialTouchX = k;
            j = (int)(n.d(motionevent, j) + 0.5F);
            mLastTouchY = j;
            mInitialTouchY = j;
        }
    }

    private void postAnimationRunner()
    {
        if (!mPostedAnimatorRunner && mIsAttached)
        {
            x.a(this, mItemAnimatorRunner);
            mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled()
    {
        return mItemAnimator != null && mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags()
    {
        boolean flag2 = true;
        if (mDataSetHasChangedAfterLayout)
        {
            mAdapterHelper.reset();
            markKnownViewsInvalid();
            mLayout.onItemsChanged(this);
        }
        State state;
        boolean flag;
        boolean flag1;
        if (mItemAnimator != null && mLayout.supportsPredictiveItemAnimations())
        {
            mAdapterHelper.preProcess();
        } else
        {
            mAdapterHelper.consumeUpdatesInOnePass();
        }
        if (mItemsAddedOrRemoved && !mItemsChanged || mItemsAddedOrRemoved || mItemsChanged && supportsChangeAnimations())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        state = mState;
        if (mFirstLayoutComplete && mItemAnimator != null && (mDataSetHasChangedAfterLayout || flag || mLayout.mRequestedSimpleAnimations) && (!mDataSetHasChangedAfterLayout || mAdapter.hasStableIds()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        state.mRunSimpleAnimations = flag1;
        state = mState;
        if (mState.mRunSimpleAnimations && flag && !mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        state.mRunPredictiveAnimations = flag1;
    }

    private void processDisappearingList(android.support.v4.g.a a1)
    {
        List list = mState.mDisappearingViewsInLayoutPass;
        int j = list.size() - 1;
        while (j >= 0) 
        {
            View view = (View)list.get(j);
            ViewHolder viewholder = getChildViewHolderInt(view);
            ItemHolderInfo itemholderinfo = (ItemHolderInfo)mState.mPreLayoutHolderMap.remove(viewholder);
            if (!mState.isPreLayout())
            {
                mState.mPostLayoutHolderMap.remove(viewholder);
            }
            if (a1.remove(view) != null)
            {
                mLayout.removeAndRecycleView(view, mRecycler);
            } else
            if (itemholderinfo != null)
            {
                animateDisappearance(itemholderinfo);
            } else
            {
                animateDisappearance(new ItemHolderInfo(viewholder, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
            j--;
        }
        list.clear();
    }

    private void pullGlows(float f, float f1, float f2, float f3)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        boolean flag2 = false;
        if (f1 < 0.0F)
        {
            ensureLeftGlow();
            flag = flag2;
            if (mLeftGlow.a(-f1 / (float)getWidth(), 1.0F - f2 / (float)getHeight()))
            {
                flag = true;
            }
        } else
        {
            flag = flag2;
            if (f1 > 0.0F)
            {
                ensureRightGlow();
                flag = flag2;
                if (mRightGlow.a(f1 / (float)getWidth(), f2 / (float)getHeight()))
                {
                    flag = true;
                }
            }
        }
        if (f3 >= 0.0F) goto _L2; else goto _L1
_L1:
        ensureTopGlow();
        if (!mTopGlow.a(-f3 / (float)getHeight(), f / (float)getWidth())) goto _L4; else goto _L3
_L3:
        if (flag1 || f1 != 0.0F || f3 != 0.0F)
        {
            x.d(this);
        }
        return;
_L2:
        if (f3 > 0.0F)
        {
            ensureBottomGlow();
            if (mBottomGlow.a(f3 / (float)getHeight(), 1.0F - f / (float)getWidth()))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
_L4:
        flag1 = flag;
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void releaseGlows()
    {
        boolean flag1 = false;
        if (mLeftGlow != null)
        {
            flag1 = mLeftGlow.c();
        }
        boolean flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1 | mTopGlow.c();
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag | mRightGlow.c();
        }
        flag = flag1;
        if (mBottomGlow != null)
        {
            flag = flag1 | mBottomGlow.c();
        }
        if (flag)
        {
            x.d(this);
        }
    }

    private boolean removeAnimatingView(View view)
    {
        eatRequestLayout();
        boolean flag = mChildHelper.removeViewIfHidden(view);
        if (flag)
        {
            view = getChildViewHolderInt(view);
            mRecycler.unscrapView(view);
            mRecycler.recycleViewHolderInternal(view);
        }
        resumeRequestLayout(false);
        return flag;
    }

    private void resetTouch()
    {
        if (mVelocityTracker != null)
        {
            mVelocityTracker.clear();
        }
        stopNestedScroll();
        releaseGlows();
    }

    private void setAdapterInternal(Adapter adapter, boolean flag, boolean flag1)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterAdapterDataObserver(mObserver);
            mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!flag || flag1)
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.endAnimations();
            }
            if (mLayout != null)
            {
                mLayout.removeAndRecycleAllViews(mRecycler);
                mLayout.removeAndRecycleScrapInt(mRecycler);
            }
            mRecycler.clear();
        }
        mAdapterHelper.reset();
        Adapter adapter1 = mAdapter;
        mAdapter = adapter;
        if (adapter != null)
        {
            adapter.registerAdapterDataObserver(mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        if (mLayout != null)
        {
            mLayout.onAdapterChanged(adapter1, mAdapter);
        }
        mRecycler.onAdapterChanged(adapter1, mAdapter, flag);
        mState.mStructureChanged = true;
        markKnownViewsInvalid();
    }

    private void setDataSetChangedAfterLayout()
    {
        if (mDataSetHasChangedAfterLayout)
        {
            return;
        }
        mDataSetHasChangedAfterLayout = true;
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                viewholder.addFlags(512);
            }
        }

        mRecycler.setAdapterPositionsAsUnknown();
    }

    private void setScrollState(int j)
    {
        if (j == mScrollState)
        {
            return;
        }
        mScrollState = j;
        if (j != 2)
        {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(j);
    }

    private void stopScrollersInternal()
    {
        mViewFlinger.stop();
        if (mLayout != null)
        {
            mLayout.stopSmoothScroller();
        }
    }

    private boolean supportsChangeAnimations()
    {
        return mItemAnimator != null && mItemAnimator.getSupportsChangeAnimations();
    }

    void absorbGlows(int j, int k)
    {
        if (j < 0)
        {
            ensureLeftGlow();
            mLeftGlow.a(-j);
        } else
        if (j > 0)
        {
            ensureRightGlow();
            mRightGlow.a(j);
        }
        if (k < 0)
        {
            ensureTopGlow();
            mTopGlow.a(-k);
        } else
        if (k > 0)
        {
            ensureBottomGlow();
            mBottomGlow.a(k);
        }
        if (j != 0 || k != 0)
        {
            x.d(this);
        }
    }

    public void addFocusables(ArrayList arraylist, int j, int k)
    {
        if (mLayout == null || !mLayout.onAddFocusables(this, arraylist, j, k))
        {
            super.addFocusables(arraylist, j, k);
        }
    }

    public void addItemDecoration(ItemDecoration itemdecoration)
    {
        addItemDecoration(itemdecoration, -1);
    }

    public void addItemDecoration(ItemDecoration itemdecoration, int j)
    {
        if (mLayout != null)
        {
            mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (mItemDecorations.isEmpty())
        {
            setWillNotDraw(false);
        }
        if (j < 0)
        {
            mItemDecorations.add(itemdecoration);
        } else
        {
            mItemDecorations.add(j, itemdecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onchildattachstatechangelistener)
    {
        if (mOnChildAttachStateListeners == null)
        {
            mOnChildAttachStateListeners = new ArrayList();
        }
        mOnChildAttachStateListeners.add(onchildattachstatechangelistener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onitemtouchlistener)
    {
        mOnItemTouchListeners.add(onitemtouchlistener);
    }

    public void addOnScrollListener(OnScrollListener onscrolllistener)
    {
        if (mScrollListeners == null)
        {
            mScrollListeners = new ArrayList();
        }
        mScrollListeners.add(onscrolllistener);
    }

    void assertInLayoutOrScroll(String s)
    {
        if (!isComputingLayout())
        {
            if (s == null)
            {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return;
        }
    }

    void assertNotInLayoutOrScroll(String s)
    {
        if (isComputingLayout())
        {
            if (s == null)
            {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && mLayout.checkLayoutParams((LayoutParams)layoutparams);
    }

    void clearOldPositions()
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (!viewholder.shouldIgnore())
            {
                viewholder.clearOldPosition();
            }
        }

        mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners()
    {
        if (mOnChildAttachStateListeners != null)
        {
            mOnChildAttachStateListeners.clear();
        }
    }

    public void clearOnScrollListeners()
    {
        if (mScrollListeners != null)
        {
            mScrollListeners.clear();
        }
    }

    public int computeHorizontalScrollExtent()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollExtent(mState);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollOffset()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollOffset(mState);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollRange()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollRange(mState);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollExtent()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollExtent(mState);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollOffset()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollOffset(mState);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollRange()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollRange(mState);
        } else
        {
            return 0;
        }
    }

    void dispatchLayout()
    {
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "No adapter attached; skipping layout");
_L13:
        return;
_L2:
        if (mLayout == null)
        {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        mState.mDisappearingViewsInLayoutPass.clear();
        eatRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        State state1 = mState;
        Object obj;
        if (mState.mRunSimpleAnimations && mItemsChanged && supportsChangeAnimations())
        {
            obj = new android.support.v4.g.a();
        } else
        {
            obj = null;
        }
        state1.mOldChangedHolders = ((android.support.v4.g.a) (obj));
        mItemsChanged = false;
        mItemsAddedOrRemoved = false;
        mState.mInPreLayout = mState.mRunPredictiveAnimations;
        mState.mItemCount = mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
        if (mState.mRunSimpleAnimations)
        {
            mState.mPreLayoutHolderMap.clear();
            mState.mPostLayoutHolderMap.clear();
            int j1 = mChildHelper.getChildCount();
            for (int j = 0; j < j1; j++)
            {
                obj = getChildViewHolderInt(mChildHelper.getChildAt(j));
                if (!((ViewHolder) (obj)).shouldIgnore() && (!((ViewHolder) (obj)).isInvalid() || mAdapter.hasStableIds()))
                {
                    View view1 = ((ViewHolder) (obj)).itemView;
                    mState.mPreLayoutHolderMap.put(obj, new ItemHolderInfo(((ViewHolder) (obj)), view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom()));
                }
            }

        }
        if (!mState.mRunPredictiveAnimations) goto _L4; else goto _L3
_L3:
        Object obj2;
        int l;
        saveOldPositions();
        if (mState.mOldChangedHolders != null)
        {
            int k1 = mChildHelper.getChildCount();
            for (int k = 0; k < k1; k++)
            {
                ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(k));
                if (viewholder.isChanged() && !viewholder.isRemoved() && !viewholder.shouldIgnore())
                {
                    long l2 = getChangedHolderKey(viewholder);
                    mState.mOldChangedHolders.put(Long.valueOf(l2), viewholder);
                    mState.mPreLayoutHolderMap.remove(viewholder);
                }
            }

        }
        boolean flag = mState.mStructureChanged;
        mState.mStructureChanged = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = flag;
        obj2 = new android.support.v4.g.a();
        l = 0;
_L11:
        if (l >= mChildHelper.getChildCount()) goto _L6; else goto _L5
_L5:
        View view = mChildHelper.getChildAt(l);
        if (getChildViewHolderInt(view).shouldIgnore()) goto _L8; else goto _L7
_L7:
        int l1 = 0;
_L12:
        if (l1 >= mState.mPreLayoutHolderMap.size())
        {
            break MISSING_BLOCK_LABEL_1674;
        }
        if (((ViewHolder)mState.mPreLayoutHolderMap.b(l1)).itemView != view) goto _L10; else goto _L9
_L9:
        l1 = 1;
_L15:
        if (l1 == 0)
        {
            ((android.support.v4.g.a) (obj2)).put(view, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        }
_L8:
        l++;
          goto _L11
_L10:
        l1++;
          goto _L12
_L6:
        clearOldPositions();
        mAdapterHelper.consumePostponedUpdates();
_L14:
        mState.mItemCount = mAdapter.getItemCount();
        mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        mState.mInPreLayout = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = false;
        mPendingSavedState = null;
        State state = mState;
        boolean flag1;
        if (mState.mRunSimpleAnimations && mItemAnimator != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        state.mRunSimpleAnimations = flag1;
        if (mState.mRunSimpleAnimations)
        {
            Object obj1;
            int i1;
            if (mState.mOldChangedHolders != null)
            {
                obj1 = new android.support.v4.g.a();
            } else
            {
                obj1 = null;
            }
            l1 = mChildHelper.getChildCount();
            i1 = 0;
            while (i1 < l1) 
            {
                ViewHolder viewholder1 = getChildViewHolderInt(mChildHelper.getChildAt(i1));
                if (!viewholder1.shouldIgnore())
                {
                    View view3 = viewholder1.itemView;
                    long l3 = getChangedHolderKey(viewholder1);
                    if (obj1 != null && mState.mOldChangedHolders.get(Long.valueOf(l3)) != null)
                    {
                        ((android.support.v4.g.a) (obj1)).put(Long.valueOf(l3), viewholder1);
                    } else
                    {
                        mState.mPostLayoutHolderMap.put(viewholder1, new ItemHolderInfo(viewholder1, view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom()));
                    }
                }
                i1++;
            }
            processDisappearingList(((android.support.v4.g.a) (obj2)));
            for (i1 = mState.mPreLayoutHolderMap.size() - 1; i1 >= 0; i1--)
            {
                ViewHolder viewholder2 = (ViewHolder)mState.mPreLayoutHolderMap.b(i1);
                if (!mState.mPostLayoutHolderMap.containsKey(viewholder2))
                {
                    ItemHolderInfo itemholderinfo = (ItemHolderInfo)mState.mPreLayoutHolderMap.c(i1);
                    mState.mPreLayoutHolderMap.d(i1);
                    View view4 = itemholderinfo.holder.itemView;
                    mRecycler.unscrapView(itemholderinfo.holder);
                    animateDisappearance(itemholderinfo);
                }
            }

            i1 = mState.mPostLayoutHolderMap.size();
            if (i1 > 0)
            {
                i1--;
                while (i1 >= 0) 
                {
                    ViewHolder viewholder3 = (ViewHolder)mState.mPostLayoutHolderMap.b(i1);
                    ItemHolderInfo itemholderinfo3 = (ItemHolderInfo)mState.mPostLayoutHolderMap.c(i1);
                    if (mState.mPreLayoutHolderMap.isEmpty() || !mState.mPreLayoutHolderMap.containsKey(viewholder3))
                    {
                        mState.mPostLayoutHolderMap.d(i1);
                        Rect rect;
                        if (obj2 != null)
                        {
                            rect = (Rect)((android.support.v4.g.a) (obj2)).get(viewholder3.itemView);
                        } else
                        {
                            rect = null;
                        }
                        animateAppearance(viewholder3, rect, itemholderinfo3.left, itemholderinfo3.top);
                    }
                    i1--;
                }
            }
            l1 = mState.mPostLayoutHolderMap.size();
            for (i1 = 0; i1 < l1; i1++)
            {
                obj2 = (ViewHolder)mState.mPostLayoutHolderMap.b(i1);
                ItemHolderInfo itemholderinfo1 = (ItemHolderInfo)mState.mPostLayoutHolderMap.c(i1);
                ItemHolderInfo itemholderinfo2 = (ItemHolderInfo)mState.mPreLayoutHolderMap.get(obj2);
                if (itemholderinfo2 == null || itemholderinfo1 == null || itemholderinfo2.left == itemholderinfo1.left && itemholderinfo2.top == itemholderinfo1.top)
                {
                    continue;
                }
                ((ViewHolder) (obj2)).setIsRecyclable(false);
                if (mItemAnimator.animateMove(((ViewHolder) (obj2)), itemholderinfo2.left, itemholderinfo2.top, itemholderinfo1.left, itemholderinfo1.top))
                {
                    postAnimationRunner();
                }
            }

            if (mState.mOldChangedHolders != null)
            {
                i1 = mState.mOldChangedHolders.size();
            } else
            {
                i1 = 0;
            }
            for (i1--; i1 >= 0; i1--)
            {
                long l4 = ((Long)mState.mOldChangedHolders.b(i1)).longValue();
                obj2 = (ViewHolder)mState.mOldChangedHolders.get(Long.valueOf(l4));
                View view2 = ((ViewHolder) (obj2)).itemView;
                if (!((ViewHolder) (obj2)).shouldIgnore() && mRecycler.mChangedScrap != null && mRecycler.mChangedScrap.contains(obj2))
                {
                    animateChange(((ViewHolder) (obj2)), (ViewHolder)((android.support.v4.g.a) (obj1)).get(Long.valueOf(l4)));
                }
            }

        }
        resumeRequestLayout(false);
        mLayout.removeAndRecycleScrapInt(mRecycler);
        mState.mPreviousLayoutItemCount = mState.mItemCount;
        mDataSetHasChangedAfterLayout = false;
        mState.mRunSimpleAnimations = false;
        mState.mRunPredictiveAnimations = false;
        onExitLayoutOrScroll();
        mLayout.mRequestedSimpleAnimations = false;
        if (mRecycler.mChangedScrap != null)
        {
            mRecycler.mChangedScrap.clear();
        }
        mState.mOldChangedHolders = null;
        if (didChildRangeChange(mMinMaxLayoutPositions[0], mMinMaxLayoutPositions[1]))
        {
            dispatchOnScrolled(0, 0);
            return;
        }
          goto _L13
_L4:
        clearOldPositions();
        mAdapterHelper.consumeUpdatesInOnePass();
        if (mState.mOldChangedHolders != null)
        {
            l1 = mChildHelper.getChildCount();
            for (i1 = 0; i1 < l1; i1++)
            {
                obj1 = getChildViewHolderInt(mChildHelper.getChildAt(i1));
                if (((ViewHolder) (obj1)).isChanged() && !((ViewHolder) (obj1)).isRemoved() && !((ViewHolder) (obj1)).shouldIgnore())
                {
                    l3 = getChangedHolderKey(((ViewHolder) (obj1)));
                    mState.mOldChangedHolders.put(Long.valueOf(l3), obj1);
                    mState.mPreLayoutHolderMap.remove(obj1);
                }
            }

        }
        obj2 = null;
          goto _L14
        l1 = 0;
          goto _L15
    }

    public boolean dispatchNestedFling(float f, float f1, boolean flag)
    {
        return mScrollingChildHelper.a(f, f1, flag);
    }

    public boolean dispatchNestedPreFling(float f, float f1)
    {
        return mScrollingChildHelper.a(f, f1);
    }

    public boolean dispatchNestedPreScroll(int j, int k, int ai[], int ai1[])
    {
        return mScrollingChildHelper.a(j, k, ai, ai1);
    }

    public boolean dispatchNestedScroll(int j, int k, int l, int i1, int ai[])
    {
        return mScrollingChildHelper.a(j, k, l, i1, ai);
    }

    void dispatchOnScrollStateChanged(int j)
    {
        if (mLayout != null)
        {
            mLayout.onScrollStateChanged(j);
        }
        onScrollStateChanged(j);
        if (mScrollListener != null)
        {
            mScrollListener.onScrollStateChanged(this, j);
        }
        if (mScrollListeners != null)
        {
            for (int k = mScrollListeners.size() - 1; k >= 0; k--)
            {
                ((OnScrollListener)mScrollListeners.get(k)).onScrollStateChanged(this, j);
            }

        }
    }

    void dispatchOnScrolled(int j, int k)
    {
        int l = getScrollX();
        int j1 = getScrollY();
        onScrollChanged(l, j1, l, j1);
        onScrolled(j, k);
        if (mScrollListener != null)
        {
            mScrollListener.onScrolled(this, j, k);
        }
        if (mScrollListeners != null)
        {
            for (int i1 = mScrollListeners.size() - 1; i1 >= 0; i1--)
            {
                ((OnScrollListener)mScrollListeners.get(i1)).onScrolled(this, j, k);
            }

        }
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        boolean flag1 = false;
        super.draw(canvas);
        int l = mItemDecorations.size();
        for (int j = 0; j < l; j++)
        {
            ((ItemDecoration)mItemDecorations.get(j)).onDrawOver(canvas, this, mState);
        }

        int k;
        if (mLeftGlow != null && !mLeftGlow.a())
        {
            int i1 = canvas.save();
            int j1;
            if (mClipToPadding)
            {
                k = getPaddingBottom();
            } else
            {
                k = 0;
            }
            canvas.rotate(270F);
            canvas.translate(k + -getHeight(), 0.0F);
            if (mLeftGlow != null && mLeftGlow.a(canvas))
            {
                l = 1;
            } else
            {
                l = 0;
            }
            canvas.restoreToCount(i1);
        } else
        {
            l = 0;
        }
        k = l;
        if (mTopGlow != null)
        {
            k = l;
            if (!mTopGlow.a())
            {
                i1 = canvas.save();
                if (mClipToPadding)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (mTopGlow != null && mTopGlow.a(canvas))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                k = l | k;
                canvas.restoreToCount(i1);
            }
        }
        l = k;
        if (mRightGlow != null)
        {
            l = k;
            if (!mRightGlow.a())
            {
                i1 = canvas.save();
                j1 = getWidth();
                if (mClipToPadding)
                {
                    l = getPaddingTop();
                } else
                {
                    l = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-l, -j1);
                if (mRightGlow != null && mRightGlow.a(canvas))
                {
                    l = 1;
                } else
                {
                    l = 0;
                }
                l = k | l;
                canvas.restoreToCount(i1);
            }
        }
        k = l;
        if (mBottomGlow != null)
        {
            k = l;
            if (!mBottomGlow.a())
            {
                i1 = canvas.save();
                canvas.rotate(180F);
                if (mClipToPadding)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                k = ((flag1) ? 1 : 0);
                if (mBottomGlow != null)
                {
                    k = ((flag1) ? 1 : 0);
                    if (mBottomGlow.a(canvas))
                    {
                        k = 1;
                    }
                }
                k = l | k;
                canvas.restoreToCount(i1);
            }
        }
        if (k == 0 && mItemAnimator != null && mItemDecorations.size() > 0 && mItemAnimator.isRunning())
        {
            k = ((flag) ? 1 : 0);
        }
        if (k != 0)
        {
            x.d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l)
    {
        return super.drawChild(canvas, view, l);
    }

    void eatRequestLayout()
    {
        if (!mEatRequestLayout)
        {
            mEatRequestLayout = true;
            if (!mLayoutFrozen)
            {
                mLayoutRequestEaten = false;
            }
        }
    }

    void ensureBottomGlow()
    {
        if (mBottomGlow != null)
        {
            return;
        }
        mBottomGlow = new i(getContext());
        if (mClipToPadding)
        {
            mBottomGlow.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mBottomGlow.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    void ensureLeftGlow()
    {
        if (mLeftGlow != null)
        {
            return;
        }
        mLeftGlow = new i(getContext());
        if (mClipToPadding)
        {
            mLeftGlow.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mLeftGlow.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void ensureRightGlow()
    {
        if (mRightGlow != null)
        {
            return;
        }
        mRightGlow = new i(getContext());
        if (mClipToPadding)
        {
            mRightGlow.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mRightGlow.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void ensureTopGlow()
    {
        if (mTopGlow != null)
        {
            return;
        }
        mTopGlow = new i(getContext());
        if (mClipToPadding)
        {
            mTopGlow.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mTopGlow.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    public View findChildViewUnder(float f, float f1)
    {
        for (int j = mChildHelper.getChildCount() - 1; j >= 0; j--)
        {
            View view = mChildHelper.getChildAt(j);
            float f2 = x.o(view);
            float f3 = x.p(view);
            if (f >= (float)view.getLeft() + f2 && f <= f2 + (float)view.getRight() && f1 >= (float)view.getTop() + f3 && f1 <= (float)view.getBottom() + f3)
            {
                return view;
            }
        }

        return null;
    }

    public ViewHolder findViewHolderForAdapterPosition(int j)
    {
        if (!mDataSetHasChangedAfterLayout)
        {
            int l = mChildHelper.getUnfilteredChildCount();
            int k = 0;
            while (k < l) 
            {
                ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(k));
                if (viewholder != null && !viewholder.isRemoved() && getAdapterPositionFor(viewholder) == j)
                {
                    return viewholder;
                }
                k++;
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForItemId(long l)
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (viewholder != null && viewholder.getItemId() == l)
            {
                return viewholder;
            }
        }

        return null;
    }

    public ViewHolder findViewHolderForLayoutPosition(int j)
    {
        return findViewHolderForPosition(j, false);
    }

    public ViewHolder findViewHolderForPosition(int j)
    {
        return findViewHolderForPosition(j, false);
    }

    ViewHolder findViewHolderForPosition(int j, boolean flag)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        for (int k = 0; k < l; k++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(k));
            if (viewholder != null && !viewholder.isRemoved() && (flag ? viewholder.mPosition == j : viewholder.getLayoutPosition() == j))
            {
                return viewholder;
            }
        }

        return null;
    }

    public boolean fling(int j, int k)
    {
        if (mLayout != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
_L4:
        return false;
_L2:
        int l;
        boolean flag;
        boolean flag1;
label0:
        {
            if (mLayoutFrozen)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag = mLayout.canScrollHorizontally();
            flag1 = mLayout.canScrollVertically();
            if (flag)
            {
                l = j;
                if (Math.abs(j) >= mMinFlingVelocity)
                {
                    break label0;
                }
            }
            l = 0;
        }
        if (flag1)
        {
            j = k;
            if (Math.abs(k) >= mMinFlingVelocity)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j = 0;
        if (l == 0 && j == 0 || dispatchNestedPreFling(l, j)) goto _L4; else goto _L3
_L3:
        if (flag || flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dispatchNestedFling(l, j, flag);
        if (flag)
        {
            k = Math.max(-mMaxFlingVelocity, Math.min(l, mMaxFlingVelocity));
            j = Math.max(-mMaxFlingVelocity, Math.min(j, mMaxFlingVelocity));
            mViewFlinger.fling(k, j);
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public View focusSearch(View view, int j)
    {
        View view2 = mLayout.onInterceptFocusSearch(view, j);
        if (view2 == null)
        {
            view2 = FocusFinder.getInstance().findNextFocus(this, view, j);
            View view1 = view2;
            if (view2 == null)
            {
                view1 = view2;
                if (mAdapter != null)
                {
                    view1 = view2;
                    if (mLayout != null)
                    {
                        view1 = view2;
                        if (!isComputingLayout())
                        {
                            view1 = view2;
                            if (!mLayoutFrozen)
                            {
                                eatRequestLayout();
                                view1 = mLayout.onFocusSearchFailed(view, j, mRecycler, mState);
                                resumeRequestLayout(false);
                            }
                        }
                    }
                }
            }
            view2 = view1;
            if (view1 == null)
            {
                return super.focusSearch(view, j);
            }
        }
        return view2;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateDefaultLayoutParams();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateLayoutParams(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateLayoutParams(layoutparams);
        }
    }

    public Adapter getAdapter()
    {
        return mAdapter;
    }

    public int getBaseline()
    {
        if (mLayout != null)
        {
            return mLayout.getBaseline();
        } else
        {
            return super.getBaseline();
        }
    }

    long getChangedHolderKey(ViewHolder viewholder)
    {
        if (mAdapter.hasStableIds())
        {
            return viewholder.getItemId();
        } else
        {
            return (long)viewholder.mPosition;
        }
    }

    public int getChildAdapterPosition(View view)
    {
        view = getChildViewHolderInt(view);
        if (view != null)
        {
            return view.getAdapterPosition();
        } else
        {
            return -1;
        }
    }

    protected int getChildDrawingOrder(int j, int k)
    {
        if (mChildDrawingOrderCallback == null)
        {
            return super.getChildDrawingOrder(j, k);
        } else
        {
            return mChildDrawingOrderCallback.onGetChildDrawingOrder(j, k);
        }
    }

    public long getChildItemId(View view)
    {
        if (mAdapter != null && mAdapter.hasStableIds())
        {
            if ((view = getChildViewHolderInt(view)) != null)
            {
                return view.getItemId();
            }
        }
        return -1L;
    }

    public int getChildLayoutPosition(View view)
    {
        view = getChildViewHolderInt(view);
        if (view != null)
        {
            return view.getLayoutPosition();
        } else
        {
            return -1;
        }
    }

    public int getChildPosition(View view)
    {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view)
    {
        ViewParent viewparent = view.getParent();
        if (viewparent != null && viewparent != this)
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a direct child of ").append(this).toString());
        } else
        {
            return getChildViewHolderInt(view);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
    {
        return mAccessibilityDelegate;
    }

    public ItemAnimator getItemAnimator()
    {
        return mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.mInsetsDirty)
        {
            return layoutparams.mDecorInsets;
        }
        Rect rect = layoutparams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int k = mItemDecorations.size();
        for (int j = 0; j < k; j++)
        {
            mTempRect.set(0, 0, 0, 0);
            ((ItemDecoration)mItemDecorations.get(j)).getItemOffsets(mTempRect, view, this, mState);
            rect.left = rect.left + mTempRect.left;
            rect.top = rect.top + mTempRect.top;
            rect.right = rect.right + mTempRect.right;
            rect.bottom = rect.bottom + mTempRect.bottom;
        }

        layoutparams.mInsetsDirty = false;
        return rect;
    }

    public LayoutManager getLayoutManager()
    {
        return mLayout;
    }

    public int getMaxFlingVelocity()
    {
        return mMaxFlingVelocity;
    }

    public int getMinFlingVelocity()
    {
        return mMinFlingVelocity;
    }

    public RecycledViewPool getRecycledViewPool()
    {
        return mRecycler.getRecycledViewPool();
    }

    public int getScrollState()
    {
        return mScrollState;
    }

    public boolean hasFixedSize()
    {
        return mHasFixedSize;
    }

    public boolean hasNestedScrollingParent()
    {
        return mScrollingChildHelper.a();
    }

    public boolean hasPendingAdapterUpdates()
    {
        return !mFirstLayoutComplete || mDataSetHasChangedAfterLayout || mAdapterHelper.hasPendingUpdates();
    }

    void initAdapterManager()
    {
        mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {

            final RecyclerView this$0;

            void dispatchUpdate(AdapterHelper.UpdateOp updateop)
            {
                switch (updateop.cmd)
                {
                default:
                    return;

                case 0: // '\0'
                    mLayout.onItemsAdded(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                    return;

                case 1: // '\001'
                    mLayout.onItemsRemoved(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                    return;

                case 2: // '\002'
                    mLayout.onItemsUpdated(RecyclerView.this, updateop.positionStart, updateop.itemCount, updateop.payload);
                    return;

                case 3: // '\003'
                    mLayout.onItemsMoved(RecyclerView.this, updateop.positionStart, updateop.itemCount, 1);
                    break;
                }
            }

            public ViewHolder findViewHolder(int j)
            {
                ViewHolder viewholder;
                for (viewholder = findViewHolderForPosition(j, true); viewholder == null || mChildHelper.isHidden(viewholder.itemView);)
                {
                    return null;
                }

                return viewholder;
            }

            public void markViewHoldersUpdated(int j, int k, Object obj)
            {
                viewRangeUpdate(j, k, obj);
                mItemsChanged = true;
            }

            public void offsetPositionsForAdd(int j, int k)
            {
                offsetPositionRecordsForInsert(j, k);
                mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForMove(int j, int k)
            {
                offsetPositionRecordsForMove(j, k);
                mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForRemovingInvisible(int j, int k)
            {
                offsetPositionRecordsForRemove(j, k, true);
                mItemsAddedOrRemoved = true;
                j = ((LayoutManager) (this)).onItemsUpdated + j;
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int j, int k)
            {
                offsetPositionRecordsForRemove(j, k, false);
                mItemsAddedOrRemoved = true;
            }

            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateop)
            {
                dispatchUpdate(updateop);
            }

            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateop)
            {
                dispatchUpdate(updateop);
            }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
        });
    }

    void invalidateGlows()
    {
        mBottomGlow = null;
        mTopGlow = null;
        mRightGlow = null;
        mLeftGlow = null;
    }

    public void invalidateItemDecorations()
    {
        if (mItemDecorations.size() == 0)
        {
            return;
        }
        if (mLayout != null)
        {
            mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled()
    {
        return mAccessibilityManager != null && mAccessibilityManager.isEnabled();
    }

    public boolean isAnimating()
    {
        return mItemAnimator != null && mItemAnimator.isRunning();
    }

    public boolean isAttachedToWindow()
    {
        return mIsAttached;
    }

    public boolean isComputingLayout()
    {
        return mLayoutOrScrollCounter > 0;
    }

    public boolean isLayoutFrozen()
    {
        return mLayoutFrozen;
    }

    public boolean isNestedScrollingEnabled()
    {
        return mScrollingChildHelper.a;
    }

    void markItemDecorInsetsDirty()
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ((LayoutParams)mChildHelper.getUnfilteredChildAt(j).getLayoutParams()).mInsetsDirty = true;
        }

        mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid()
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                viewholder.addFlags(6);
            }
        }

        markItemDecorInsetsDirty();
        mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(int j)
    {
        int l = mChildHelper.getChildCount();
        for (int k = 0; k < l; k++)
        {
            mChildHelper.getChildAt(k).offsetLeftAndRight(j);
        }

    }

    public void offsetChildrenVertical(int j)
    {
        int l = mChildHelper.getChildCount();
        for (int k = 0; k < l; k++)
        {
            mChildHelper.getChildAt(k).offsetTopAndBottom(j);
        }

    }

    void offsetPositionRecordsForInsert(int j, int k)
    {
        int i1 = mChildHelper.getUnfilteredChildCount();
        for (int l = 0; l < i1; l++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(l));
            if (viewholder != null && !viewholder.shouldIgnore() && viewholder.mPosition >= j)
            {
                viewholder.offsetPosition(k, false);
                mState.mStructureChanged = true;
            }
        }

        mRecycler.offsetPositionRecordsForInsert(j, k);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int j, int k)
    {
        int k1 = mChildHelper.getUnfilteredChildCount();
        byte byte0;
        int l;
        int i1;
        int j1;
        if (j < k)
        {
            byte0 = -1;
            l = k;
            i1 = j;
        } else
        {
            byte0 = 1;
            l = j;
            i1 = k;
        }
        j1 = 0;
        while (j1 < k1) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j1));
            if (viewholder != null && viewholder.mPosition >= i1 && viewholder.mPosition <= l)
            {
                if (viewholder.mPosition == j)
                {
                    viewholder.offsetPosition(k - j, false);
                } else
                {
                    viewholder.offsetPosition(byte0, false);
                }
                mState.mStructureChanged = true;
            }
            j1++;
        }
        mRecycler.offsetPositionRecordsForMove(j, k);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int j, int k, boolean flag)
    {
        int i1 = mChildHelper.getUnfilteredChildCount();
        int l = 0;
        while (l < i1) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(l));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                if (viewholder.mPosition >= j + k)
                {
                    viewholder.offsetPosition(-k, flag);
                    mState.mStructureChanged = true;
                } else
                if (viewholder.mPosition >= j)
                {
                    viewholder.flagRemovedAndOffsetPosition(j - 1, -k, flag);
                    mState.mStructureChanged = true;
                }
            }
            l++;
        }
        mRecycler.offsetPositionRecordsForRemove(j, k, flag);
        requestLayout();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mLayoutOrScrollCounter = 0;
        mIsAttached = true;
        mFirstLayoutComplete = false;
        if (mLayout != null)
        {
            mLayout.dispatchAttachedToWindow(this);
        }
        mPostedAnimatorRunner = false;
    }

    public void onChildAttachedToWindow(View view)
    {
    }

    public void onChildDetachedFromWindow(View view)
    {
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mItemAnimator != null)
        {
            mItemAnimator.endAnimations();
        }
        mFirstLayoutComplete = false;
        stopScroll();
        mIsAttached = false;
        if (mLayout != null)
        {
            mLayout.dispatchDetachedFromWindow(this, mRecycler);
        }
        removeCallbacks(mItemAnimatorRunner);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int k = mItemDecorations.size();
        for (int j = 0; j < k; j++)
        {
            ((ItemDecoration)mItemDecorations.get(j)).onDraw(canvas, this, mState);
        }

    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if (mLayout != null && !mLayoutFrozen && (n.d(motionevent) & 2) != 0 && motionevent.getAction() == 8)
        {
            float f;
            float f1;
            if (mLayout.canScrollVertically())
            {
                f = -n.e(motionevent, 9);
            } else
            {
                f = 0.0F;
            }
            if (mLayout.canScrollHorizontally())
            {
                f1 = n.e(motionevent, 10);
            } else
            {
                f1 = 0.0F;
            }
            if (f != 0.0F || f1 != 0.0F)
            {
                float f2 = getScrollFactor();
                scrollByInternal((int)(f1 * f2), (int)(f * f2), motionevent);
                return false;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        byte byte0;
        boolean flag;
        byte0 = -1;
        flag = true;
        if (!mLayoutFrozen) goto _L2; else goto _L1
_L1:
        flag = false;
_L11:
        return flag;
_L2:
        int j;
        int k;
        boolean flag1;
        boolean flag2;
        if (dispatchOnItemTouchIntercept(motionevent))
        {
            cancelTouch();
            return true;
        }
        if (mLayout == null)
        {
            return false;
        }
        flag1 = mLayout.canScrollHorizontally();
        flag2 = mLayout.canScrollVertically();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        k = n.a(motionevent);
        j = n.b(motionevent);
        k;
        JVM INSTR tableswitch 0 6: default 136
    //                   0 146
    //                   1 546
    //                   2 311
    //                   3 560
    //                   4 136
    //                   5 257
    //                   6 538;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L8 _L9
_L7:
        break MISSING_BLOCK_LABEL_560;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L12:
        if (mScrollState != 1)
        {
            return false;
        }
        if (true) goto _L11; else goto _L10
_L10:
        if (mIgnoreMotionEventTillDown)
        {
            mIgnoreMotionEventTillDown = false;
        }
        mScrollPointerId = n.b(motionevent, 0);
        j = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = j;
        mInitialTouchX = j;
        j = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = j;
        mInitialTouchY = j;
        if (mScrollState == 2)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
        }
        int l;
        int i1;
        int j1;
        if (flag1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        l = j;
        if (flag2)
        {
            l = j | 2;
        }
        startNestedScroll(l);
          goto _L12
_L8:
        mScrollPointerId = n.b(motionevent, j);
        l = (int)(n.c(motionevent, j) + 0.5F);
        mLastTouchX = l;
        mInitialTouchX = l;
        j = (int)(n.d(motionevent, j) + 0.5F);
        mLastTouchY = j;
        mInitialTouchY = j;
          goto _L12
_L6:
        l = n.a(motionevent, mScrollPointerId);
        if (l < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        j = (int)(n.c(motionevent, l) + 0.5F);
        l = (int)(n.d(motionevent, l) + 0.5F);
        if (mScrollState != 1)
        {
            j -= mInitialTouchX;
            i1 = l - mInitialTouchY;
            if (flag1 && Math.abs(j) > mTouchSlop)
            {
                l = mInitialTouchX;
                j1 = mTouchSlop;
                if (j < 0)
                {
                    j = -1;
                } else
                {
                    j = 1;
                }
                mLastTouchX = j * j1 + l;
                j = 1;
            } else
            {
                j = 0;
            }
            l = j;
            if (flag2)
            {
                l = j;
                if (Math.abs(i1) > mTouchSlop)
                {
                    l = mInitialTouchY;
                    j1 = mTouchSlop;
                    if (i1 < 0)
                    {
                        j = byte0;
                    } else
                    {
                        j = 1;
                    }
                    mLastTouchY = l + j * j1;
                    l = 1;
                }
            }
            if (l != 0)
            {
                motionevent = getParent();
                if (motionevent != null)
                {
                    motionevent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        }
          goto _L12
_L9:
        onPointerUp(motionevent);
          goto _L12
_L5:
        mVelocityTracker.clear();
        stopNestedScroll();
          goto _L12
        cancelTouch();
          goto _L12
    }

    protected void onLayout(boolean flag, int j, int k, int l, int i1)
    {
        eatRequestLayout();
        d.a("RV OnLayout");
        dispatchLayout();
        d.a();
        resumeRequestLayout(false);
        mFirstLayoutComplete = true;
    }

    protected void onMeasure(int j, int k)
    {
        if (mAdapterUpdateDuringMeasure)
        {
            eatRequestLayout();
            processAdapterUpdatesAndSetAnimationFlags();
            if (mState.mRunPredictiveAnimations)
            {
                mState.mInPreLayout = true;
            } else
            {
                mAdapterHelper.consumeUpdatesInOnePass();
                mState.mInPreLayout = false;
            }
            mAdapterUpdateDuringMeasure = false;
            resumeRequestLayout(false);
        }
        if (mAdapter != null)
        {
            mState.mItemCount = mAdapter.getItemCount();
        } else
        {
            mState.mItemCount = 0;
        }
        if (mLayout == null)
        {
            defaultOnMeasure(j, k);
        } else
        {
            mLayout.onMeasure(mRecycler, mState, j, k);
        }
        mState.mInPreLayout = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        mPendingSavedState = (SavedState)parcelable;
        super.onRestoreInstanceState(mPendingSavedState.getSuperState());
        if (mLayout != null && mPendingSavedState.mLayoutState != null)
        {
            mLayout.onRestoreInstanceState(mPendingSavedState.mLayoutState);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (mPendingSavedState != null)
        {
            savedstate.copyFrom(mPendingSavedState);
            return savedstate;
        }
        if (mLayout != null)
        {
            savedstate.mLayoutState = mLayout.onSaveInstanceState();
            return savedstate;
        } else
        {
            savedstate.mLayoutState = null;
            return savedstate;
        }
    }

    public void onScrollStateChanged(int j)
    {
    }

    public void onScrolled(int j, int k)
    {
    }

    protected void onSizeChanged(int j, int k, int l, int i1)
    {
        super.onSizeChanged(j, k, l, i1);
        if (j != l || k != i1)
        {
            invalidateGlows();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        if (!mLayoutFrozen && !mIgnoreMotionEventTillDown) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (dispatchOnItemTouch(motionevent))
        {
            cancelTouch();
            return true;
        }
        if (mLayout == null) goto _L1; else goto _L3
_L3:
        MotionEvent motionevent1;
        int j;
        int k;
        int l;
        boolean flag1;
        boolean flag2;
        flag1 = mLayout.canScrollHorizontally();
        flag2 = mLayout.canScrollVertically();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        motionevent1 = MotionEvent.obtain(motionevent);
        l = n.a(motionevent);
        k = n.b(motionevent);
        if (l == 0)
        {
            int ai[] = mNestedOffsets;
            mNestedOffsets[1] = 0;
            ai[0] = 0;
        }
        motionevent1.offsetLocation(mNestedOffsets[0], mNestedOffsets[1]);
        j = ((flag) ? 1 : 0);
        l;
        JVM INSTR tableswitch 0 6: default 180
    //                   0 205
    //                   1 833
    //                   2 364
    //                   3 941
    //                   4 184
    //                   5 297
    //                   6 821;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L9:
        break; /* Loop/switch isn't completed */
_L4:
        j = ((flag) ? 1 : 0);
_L13:
        if (j == 0)
        {
            mVelocityTracker.addMovement(motionevent1);
        }
        motionevent1.recycle();
        return true;
_L5:
        mScrollPointerId = n.b(motionevent, 0);
        j = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = j;
        mInitialTouchX = j;
        j = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = j;
        mInitialTouchY = j;
        float f;
        float f1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (flag1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        k = j;
        if (flag2)
        {
            k = j | 2;
        }
        startNestedScroll(k);
        j = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L10:
        mScrollPointerId = n.b(motionevent, k);
        j = (int)(n.c(motionevent, k) + 0.5F);
        mLastTouchX = j;
        mInitialTouchX = j;
        j = (int)(n.d(motionevent, k) + 0.5F);
        mLastTouchY = j;
        mInitialTouchY = j;
        j = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L7:
        j = n.a(motionevent, mScrollPointerId);
        if (j < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        i2 = (int)(n.c(motionevent, j) + 0.5F);
        j2 = (int)(n.d(motionevent, j) + 0.5F);
        j1 = mLastTouchX - i2;
        i1 = mLastTouchY - j2;
        j = i1;
        k = j1;
        if (dispatchNestedPreScroll(j1, i1, mScrollConsumed, mScrollOffset))
        {
            k = j1 - mScrollConsumed[0];
            j = i1 - mScrollConsumed[1];
            motionevent1.offsetLocation(mScrollOffset[0], mScrollOffset[1]);
            motionevent = mNestedOffsets;
            motionevent[0] = motionevent[0] + mScrollOffset[0];
            motionevent = mNestedOffsets;
            motionevent[1] = motionevent[1] + mScrollOffset[1];
        }
        i1 = j;
        j1 = k;
        if (mScrollState != 1)
        {
            if (flag1 && Math.abs(k) > mTouchSlop)
            {
                if (k > 0)
                {
                    k -= mTouchSlop;
                } else
                {
                    k += mTouchSlop;
                }
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            k1 = j;
            l1 = i1;
            if (flag2)
            {
                k1 = j;
                l1 = i1;
                if (Math.abs(j) > mTouchSlop)
                {
                    if (j > 0)
                    {
                        k1 = j - mTouchSlop;
                    } else
                    {
                        k1 = j + mTouchSlop;
                    }
                    l1 = 1;
                }
            }
            i1 = k1;
            j1 = k;
            if (l1 != 0)
            {
                motionevent = getParent();
                if (motionevent != null)
                {
                    motionevent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
                j1 = k;
                i1 = k1;
            }
        }
        j = ((flag) ? 1 : 0);
        if (mScrollState == 1)
        {
            mLastTouchX = i2 - mScrollOffset[0];
            mLastTouchY = j2 - mScrollOffset[1];
            if (!flag1)
            {
                j1 = 0;
            }
            if (!flag2)
            {
                i1 = 0;
            }
            j = ((flag) ? 1 : 0);
            if (scrollByInternal(j1, i1, motionevent1))
            {
                getParent().requestDisallowInterceptTouchEvent(true);
                j = ((flag) ? 1 : 0);
            }
        }
        continue; /* Loop/switch isn't completed */
_L11:
        onPointerUp(motionevent);
        j = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L6:
        mVelocityTracker.addMovement(motionevent1);
        mVelocityTracker.computeCurrentVelocity(1000, mMaxFlingVelocity);
        if (flag1)
        {
            f = -w.a(mVelocityTracker, mScrollPointerId);
        } else
        {
            f = 0.0F;
        }
        if (flag2)
        {
            f1 = -w.b(mVelocityTracker, mScrollPointerId);
        } else
        {
            f1 = 0.0F;
        }
        if (f == 0.0F && f1 == 0.0F || !fling((int)f, (int)f1))
        {
            setScrollState(0);
        }
        resetTouch();
        j = 1;
        continue; /* Loop/switch isn't completed */
_L8:
        cancelTouch();
        j = ((flag) ? 1 : 0);
        if (true) goto _L13; else goto _L12
_L12:
    }

    void rebindUpdatedViewHolders()
    {
        int j;
        int k;
        k = mChildHelper.getChildCount();
        j = 0;
_L2:
        ViewHolder viewholder;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        viewholder = getChildViewHolderInt(mChildHelper.getChildAt(j));
        if (viewholder != null && !viewholder.shouldIgnore())
        {
            if (!viewholder.isRemoved() && !viewholder.isInvalid())
            {
                break; /* Loop/switch isn't completed */
            }
            requestLayout();
        }
_L4:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!viewholder.needsUpdate()) goto _L4; else goto _L3
_L3:
label0:
        {
            int l = mAdapter.getItemViewType(viewholder.mPosition);
            if (viewholder.getItemViewType() != l)
            {
                break label0;
            }
            if (!viewholder.isChanged() || !supportsChangeAnimations())
            {
                mAdapter.bindViewHolder(viewholder, viewholder.mPosition);
            } else
            {
                requestLayout();
            }
        }
          goto _L4
        requestLayout();
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        if (viewholder != null)
        {
            if (viewholder.isTmpDetached())
            {
                viewholder.clearTmpDetachFlag();
            } else
            if (!viewholder.shouldIgnore())
            {
                throw new IllegalArgumentException((new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.")).append(viewholder).toString());
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, flag);
    }

    public void removeItemDecoration(ItemDecoration itemdecoration)
    {
        if (mLayout != null)
        {
            mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        mItemDecorations.remove(itemdecoration);
        if (mItemDecorations.isEmpty())
        {
            boolean flag;
            if (x.a(this) == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            setWillNotDraw(flag);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onchildattachstatechangelistener)
    {
        if (mOnChildAttachStateListeners == null)
        {
            return;
        } else
        {
            mOnChildAttachStateListeners.remove(onchildattachstatechangelistener);
            return;
        }
    }

    public void removeOnItemTouchListener(OnItemTouchListener onitemtouchlistener)
    {
        mOnItemTouchListeners.remove(onitemtouchlistener);
        if (mActiveOnItemTouchListener == onitemtouchlistener)
        {
            mActiveOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onscrolllistener)
    {
        if (mScrollListeners != null)
        {
            mScrollListeners.remove(onscrolllistener);
        }
    }

    public void requestChildFocus(View view, View view1)
    {
        if (!mLayout.onRequestChildFocus(this, mState, view, view1) && view1 != null)
        {
            mTempRect.set(0, 0, view1.getWidth(), view1.getHeight());
            Object obj = view1.getLayoutParams();
            if (obj instanceof LayoutParams)
            {
                obj = (LayoutParams)obj;
                if (!((LayoutParams) (obj)).mInsetsDirty)
                {
                    obj = ((LayoutParams) (obj)).mDecorInsets;
                    Rect rect = mTempRect;
                    rect.left = rect.left - ((Rect) (obj)).left;
                    rect = mTempRect;
                    rect.right = rect.right + ((Rect) (obj)).right;
                    rect = mTempRect;
                    rect.top = rect.top - ((Rect) (obj)).top;
                    rect = mTempRect;
                    int j = rect.bottom;
                    rect.bottom = ((Rect) (obj)).bottom + j;
                }
            }
            offsetDescendantRectToMyCoords(view1, mTempRect);
            offsetRectIntoDescendantCoords(view, mTempRect);
            obj = mTempRect;
            boolean flag;
            if (!mFirstLayoutComplete)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            requestChildRectangleOnScreen(view, ((Rect) (obj)), flag);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        return mLayout.requestChildRectangleOnScreen(this, view, rect, flag);
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        int k = mOnItemTouchListeners.size();
        for (int j = 0; j < k; j++)
        {
            ((OnItemTouchListener)mOnItemTouchListeners.get(j)).onRequestDisallowInterceptTouchEvent(flag);
        }

        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!mEatRequestLayout && !mLayoutFrozen)
        {
            super.requestLayout();
            return;
        } else
        {
            mLayoutRequestEaten = true;
            return;
        }
    }

    void resumeRequestLayout(boolean flag)
    {
        if (mEatRequestLayout)
        {
            if (flag && mLayoutRequestEaten && !mLayoutFrozen && mLayout != null && mAdapter != null)
            {
                dispatchLayout();
            }
            mEatRequestLayout = false;
            if (!mLayoutFrozen)
            {
                mLayoutRequestEaten = false;
            }
        }
    }

    void saveOldPositions()
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (!viewholder.shouldIgnore())
            {
                viewholder.saveOldPosition();
            }
        }

    }

    public void scrollBy(int j, int k)
    {
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        if (!mLayoutFrozen)
        {
            boolean flag = mLayout.canScrollHorizontally();
            boolean flag1 = mLayout.canScrollVertically();
            if (flag || flag1)
            {
                if (!flag)
                {
                    j = 0;
                }
                if (!flag1)
                {
                    k = 0;
                }
                scrollByInternal(j, k, null);
                return;
            }
        }
    }

    boolean scrollByInternal(int j, int k, MotionEvent motionevent)
    {
        int i1 = 0;
        boolean flag2 = false;
        int k1 = 0;
        boolean flag = false;
        int l = 0;
        boolean flag3 = false;
        int j1 = 0;
        boolean flag1 = false;
        consumePendingUpdateOperations();
        if (mAdapter != null)
        {
            eatRequestLayout();
            onEnterLayoutOrScroll();
            d.a("RV Scroll");
            l = ((flag3) ? 1 : 0);
            i1 = ((flag2) ? 1 : 0);
            if (j != 0)
            {
                l = mLayout.scrollHorizontallyBy(j, mRecycler, mState);
                i1 = j - l;
            }
            j1 = ((flag1) ? 1 : 0);
            k1 = ((flag) ? 1 : 0);
            if (k != 0)
            {
                j1 = mLayout.scrollVerticallyBy(k, mRecycler, mState);
                k1 = k - j1;
            }
            d.a();
            if (supportsChangeAnimations())
            {
                int i2 = mChildHelper.getChildCount();
                int l1 = 0;
                while (l1 < i2) 
                {
                    View view = mChildHelper.getChildAt(l1);
                    Object obj = getChildViewHolder(view);
                    if (obj == null || ((ViewHolder) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((ViewHolder) (obj)).mShadowingHolder;
                    int j2;
                    int k2;
                    if (obj != null)
                    {
                        obj = ((ViewHolder) (obj)).itemView;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    j2 = view.getLeft();
                    k2 = view.getTop();
                    if (j2 != ((View) (obj)).getLeft() || k2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(j2, k2, ((View) (obj)).getWidth() + j2, ((View) (obj)).getHeight() + k2);
                    }
                    l1++;
                }
            }
            onExitLayoutOrScroll();
            resumeRequestLayout(false);
        }
        if (!mItemDecorations.isEmpty())
        {
            invalidate();
        }
        if (dispatchNestedScroll(l, j1, i1, k1, mScrollOffset))
        {
            mLastTouchX = mLastTouchX - mScrollOffset[0];
            mLastTouchY = mLastTouchY - mScrollOffset[1];
            if (motionevent != null)
            {
                motionevent.offsetLocation(mScrollOffset[0], mScrollOffset[1]);
            }
            motionevent = mNestedOffsets;
            motionevent[0] = motionevent[0] + mScrollOffset[0];
            motionevent = mNestedOffsets;
            motionevent[1] = motionevent[1] + mScrollOffset[1];
        } else
        if (x.a(this) != 2)
        {
            if (motionevent != null)
            {
                pullGlows(motionevent.getX(), i1, motionevent.getY(), k1);
            }
            considerReleasingGlowsOnScroll(j, k);
        }
        if (l != 0 || j1 != 0)
        {
            dispatchOnScrolled(l, j1);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        return l != 0 || j1 != 0;
    }

    public void scrollTo(int j, int k)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollToPosition(int j)
    {
        if (mLayoutFrozen)
        {
            return;
        }
        stopScroll();
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        } else
        {
            mLayout.scrollToPosition(j);
            awakenScrollBars();
            return;
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent)
    {
        if (shouldDeferAccessibilityEvent(accessibilityevent))
        {
            return;
        } else
        {
            super.sendAccessibilityEventUnchecked(accessibilityevent);
            return;
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerviewaccessibilitydelegate)
    {
        mAccessibilityDelegate = recyclerviewaccessibilitydelegate;
        x.a(this, mAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter)
    {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childdrawingordercallback)
    {
        if (childdrawingordercallback == mChildDrawingOrderCallback)
        {
            return;
        }
        mChildDrawingOrderCallback = childdrawingordercallback;
        boolean flag;
        if (mChildDrawingOrderCallback != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChildrenDrawingOrderEnabled(flag);
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != mClipToPadding)
        {
            invalidateGlows();
        }
        mClipToPadding = flag;
        super.setClipToPadding(flag);
        if (mFirstLayoutComplete)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        mHasFixedSize = flag;
    }

    public void setItemAnimator(ItemAnimator itemanimator)
    {
        if (mItemAnimator != null)
        {
            mItemAnimator.endAnimations();
            mItemAnimator.setListener(null);
        }
        mItemAnimator = itemanimator;
        if (mItemAnimator != null)
        {
            mItemAnimator.setListener(mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int j)
    {
        mRecycler.setViewCacheSize(j);
    }

    public void setLayoutFrozen(boolean flag)
    {
label0:
        {
            if (flag != mLayoutFrozen)
            {
                assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
                if (flag)
                {
                    break label0;
                }
                mLayoutFrozen = flag;
                if (mLayoutRequestEaten && mLayout != null && mAdapter != null)
                {
                    requestLayout();
                }
                mLayoutRequestEaten = false;
            }
            return;
        }
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        mLayoutFrozen = flag;
        mIgnoreMotionEventTillDown = true;
        stopScroll();
    }

    public void setLayoutManager(LayoutManager layoutmanager)
    {
        if (layoutmanager == mLayout)
        {
            return;
        }
        if (mLayout != null)
        {
            if (mIsAttached)
            {
                mLayout.dispatchDetachedFromWindow(this, mRecycler);
            }
            mLayout.setRecyclerView(null);
        }
        mRecycler.clear();
        mChildHelper.removeAllViewsUnfiltered();
        mLayout = layoutmanager;
        if (layoutmanager != null)
        {
            if (layoutmanager.mRecyclerView != null)
            {
                throw new IllegalArgumentException((new StringBuilder("LayoutManager ")).append(layoutmanager).append(" is already attached to a RecyclerView: ").append(layoutmanager.mRecyclerView).toString());
            }
            mLayout.setRecyclerView(this);
            if (mIsAttached)
            {
                mLayout.dispatchAttachedToWindow(this);
            }
        }
        requestLayout();
    }

    public void setNestedScrollingEnabled(boolean flag)
    {
        mScrollingChildHelper.a(flag);
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener)
    {
        mScrollListener = onscrolllistener;
    }

    public void setRecycledViewPool(RecycledViewPool recycledviewpool)
    {
        mRecycler.setRecycledViewPool(recycledviewpool);
    }

    public void setRecyclerListener(RecyclerListener recyclerlistener)
    {
        mRecyclerListener = recyclerlistener;
    }

    public void setScrollingTouchSlop(int j)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (j)
        {
        default:
            Log.w("RecyclerView", (new StringBuilder("setScrollingTouchSlop(): bad argument constant ")).append(j).append("; using default value").toString());
            // fall through

        case 0: // '\0'
            mTouchSlop = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            mTouchSlop = ab.a(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(ViewCacheExtension viewcacheextension)
    {
        mRecycler.setViewCacheExtension(viewcacheextension);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        boolean flag1 = false;
        boolean flag = false;
        if (isComputingLayout())
        {
            int j;
            if (accessibilityevent != null)
            {
                j = a.b(accessibilityevent);
            } else
            {
                j = 0;
            }
            if (j == 0)
            {
                j = ((flag) ? 1 : 0);
            }
            mEatenAccessibilityChangeFlags = j | mEatenAccessibilityChangeFlags;
            flag1 = true;
        }
        return flag1;
    }

    public void smoothScrollBy(int j, int k)
    {
        boolean flag = false;
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        if (!mLayoutFrozen)
        {
            if (!mLayout.canScrollHorizontally())
            {
                j = 0;
            }
            if (!mLayout.canScrollVertically())
            {
                k = ((flag) ? 1 : 0);
            }
            if (j != 0 || k != 0)
            {
                mViewFlinger.smoothScrollBy(j, k);
                return;
            }
        }
    }

    public void smoothScrollToPosition(int j)
    {
        if (mLayoutFrozen)
        {
            return;
        }
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        } else
        {
            mLayout.smoothScrollToPosition(this, mState, j);
            return;
        }
    }

    public boolean startNestedScroll(int j)
    {
        return mScrollingChildHelper.a(j);
    }

    public void stopNestedScroll()
    {
        mScrollingChildHelper.b();
    }

    public void stopScroll()
    {
        setScrollState(0);
        stopScrollersInternal();
    }

    public void swapAdapter(Adapter adapter, boolean flag)
    {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, flag);
        setDataSetChangedAfterLayout();
        requestLayout();
    }

    void viewRangeUpdate(int j, int k, Object obj)
    {
        int i1 = mChildHelper.getUnfilteredChildCount();
        for (int l = 0; l < i1; l++)
        {
            View view = mChildHelper.getUnfilteredChildAt(l);
            ViewHolder viewholder = getChildViewHolderInt(view);
            if (viewholder == null || viewholder.shouldIgnore() || viewholder.mPosition < j || viewholder.mPosition >= j + k)
            {
                continue;
            }
            viewholder.addFlags(2);
            viewholder.addChangePayload(obj);
            if (supportsChangeAnimations())
            {
                viewholder.addFlags(64);
            }
            ((LayoutParams)view.getLayoutParams()).mInsetsDirty = true;
        }

        mRecycler.viewRangeUpdate(j, k);
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 18 || android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = flag;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = (new Class[] {
            android/content/Context, android/util/AttributeSet, Integer.TYPE, Integer.TYPE
        });
    }





















/*
    static boolean access$3802(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mAdapterUpdateDuringMeasure = flag;
        return flag;
    }

*/










/*
    static boolean access$502(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mPostedAnimatorRunner = flag;
        return flag;
    }

*/






}
