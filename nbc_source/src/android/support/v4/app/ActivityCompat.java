// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v4.app:
//            ActivityCompatJB, ActivityCompat21, SharedElementCallback

public class ActivityCompat extends ContextCompat
{
    private static class SharedElementCallback21Impl extends ActivityCompat21.SharedElementCallback21
    {

        private SharedElementCallback mCallback;

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectf)
        {
            return mCallback.onCaptureSharedElementSnapshot(view, matrix, rectf);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable)
        {
            return mCallback.onCreateSnapshotView(context, parcelable);
        }

        public void onMapSharedElements(List list, Map map)
        {
            mCallback.onMapSharedElements(list, map);
        }

        public void onRejectSharedElements(List list)
        {
            mCallback.onRejectSharedElements(list);
        }

        public void onSharedElementEnd(List list, List list1, List list2)
        {
            mCallback.onSharedElementEnd(list, list1, list2);
        }

        public void onSharedElementStart(List list, List list1, List list2)
        {
            mCallback.onSharedElementStart(list, list1, list2);
        }

        public SharedElementCallback21Impl(SharedElementCallback sharedelementcallback)
        {
            mCallback = sharedelementcallback;
        }
    }


    private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback sharedelementcallback)
    {
        SharedElementCallback21Impl sharedelementcallback21impl = null;
        if (sharedelementcallback != null)
        {
            sharedelementcallback21impl = new SharedElementCallback21Impl(sharedelementcallback);
        }
        return sharedelementcallback21impl;
    }

    public static void finishAffinity(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityCompatJB.finishAffinity(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static void finishAfterTransition(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ActivityCompat21.finishAfterTransition(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static void postponeEnterTransition(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ActivityCompat21.postponeEnterTransition(activity);
        }
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedelementcallback)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ActivityCompat21.setEnterSharedElementCallback(activity, createCallback(sharedelementcallback));
        }
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedelementcallback)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ActivityCompat21.setExitSharedElementCallback(activity, createCallback(sharedelementcallback));
        }
    }

    public static void startPostponedEnterTransition(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ActivityCompat21.startPostponedEnterTransition(activity);
        }
    }
}
