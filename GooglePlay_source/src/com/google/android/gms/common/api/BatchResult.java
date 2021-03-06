// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, BatchResultToken, PendingResult, Status

public final class BatchResult
    implements Result
{

    private final PendingResult mPendingResults[];
    public final Status mStatus;

    BatchResult(Status status, PendingResult apendingresult[])
    {
        mStatus = status;
        mPendingResults = apendingresult;
    }

    public final Status getStatus()
    {
        return mStatus;
    }

    public final Result take(BatchResultToken batchresulttoken)
    {
        boolean flag;
        if (batchresulttoken.mId < mPendingResults.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "The result token does not belong to this batch");
        return mPendingResults[batchresulttoken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
