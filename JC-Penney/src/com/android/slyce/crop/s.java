// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.slyce.crop;

import android.os.Handler;

// Referenced classes of package com.android.slyce.crop:
//            q

class s
    implements Runnable
{

    final float a;
    final long b;
    final float c;
    final float d;
    final float e;
    final float f;
    final q g;

    s(q q1, float f1, long l, float f2, float f3, float f4, 
            float f5)
    {
        g = q1;
        a = f1;
        b = l;
        c = f2;
        d = f3;
        e = f4;
        f = f5;
        super();
    }

    public void run()
    {
        long l = System.currentTimeMillis();
        float f1 = Math.min(a, l - b);
        float f2 = c;
        float f3 = d;
        g.a(f2 + f3 * f1, e, f);
        if (f1 < a)
        {
            g.p.post(this);
        }
    }
}
