// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ford.syncV4.e;

import com.ford.syncV4.e.b.b;
import com.ford.syncV4.e.c.ac;

// Referenced classes of package com.ford.syncV4.e:
//            j

final class bm
    implements Runnable
{

    final ac a;
    final j b;

    bm(j j1, ac ac)
    {
        b = j1;
        a = ac;
        super();
    }

    public final void run()
    {
        j.e(b).onOnAudioPassThru(a);
    }
}
