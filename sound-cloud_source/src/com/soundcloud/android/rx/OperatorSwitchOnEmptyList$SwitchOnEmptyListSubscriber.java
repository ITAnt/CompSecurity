// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.rx;

import java.util.List;
import rx.X;
import rx.b;

// Referenced classes of package com.soundcloud.android.rx:
//            OperatorSwitchOnEmptyList

private class child extends X
{

    private final X child;
    private boolean isOriginalSource;
    final OperatorSwitchOnEmptyList this$0;

    public void onCompleted()
    {
        if (isOriginalSource)
        {
            child.onCompleted();
        }
    }

    public void onError(Throwable throwable)
    {
        if (isOriginalSource)
        {
            child.onError(throwable);
        }
    }

    public volatile void onNext(Object obj)
    {
        onNext((List)obj);
    }

    public void onNext(List list)
    {
label0:
        {
            if (isOriginalSource)
            {
                if (list == null || !list.isEmpty())
                {
                    break label0;
                }
                add(OperatorSwitchOnEmptyList.access$000(OperatorSwitchOnEmptyList.this).subscribe(child));
                isOriginalSource = false;
            }
            return;
        }
        child.onNext(list);
    }

    public (X x)
    {
        this$0 = OperatorSwitchOnEmptyList.this;
        super(x);
        isOriginalSource = true;
        child = x;
    }
}
