// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.cache:
//            CacheBuilderSpec

static class  extends 
{

    protected void parseInteger(CacheBuilderSpec cachebuilderspec, int i)
    {
        boolean flag;
        if (cachebuilderspec.concurrencyLevel == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "concurrency level was already set to ", new Object[] {
            cachebuilderspec.concurrencyLevel
        });
        cachebuilderspec.concurrencyLevel = Integer.valueOf(i);
    }

    ()
    {
    }
}
