// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ford.syncV4.e;

import com.ford.syncV4.e.b.b;
import com.ford.syncV4.e.c.bh;

// Referenced classes of package com.ford.syncV4.e:
//            j

final class w
    implements Runnable
{

    final bh a;
    final j b;

    w(j j1, bh bh)
    {
        b = j1;
        a = bh;
        super();
    }

    public final void run()
    {
        j.e(b).onSetMediaClockTimerResponse(a);
    }
}
