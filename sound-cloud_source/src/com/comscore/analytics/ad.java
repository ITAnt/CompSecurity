// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.analytics;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.comscore.analytics:
//            Core

class ad
    implements Runnable
{

    final Core a;

    ad(Core core)
    {
        a = core;
        super();
    }

    public void run()
    {
        while (a.z() || a.z.get() <= 0) 
        {
            return;
        }
        a.z.getAndDecrement();
        a.n();
    }
}
