// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.Executor;

// Referenced classes of package io.fabric.sdk.android.services.concurrency:
//            PriorityAsyncTask, PriorityFutureTask

private static class task
    implements Executor
{

    private final Executor executor;
    private final PriorityAsyncTask task;

    public void execute(Runnable runnable)
    {
        executor.execute(new PriorityFutureTask(runnable, null, task));
    }

    public (Executor executor1, PriorityAsyncTask priorityasynctask)
    {
        executor = executor1;
        task = priorityasynctask;
    }
}
