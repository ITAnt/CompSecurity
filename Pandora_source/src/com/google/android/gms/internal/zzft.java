// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            zzfv, f

public class zzft
    implements zzfv
{

    private final Object zzCM;
    private final f zzCO = new f();

    public zzft(Object obj)
    {
        zzCM = obj;
        zzCO.a();
    }

    public boolean cancel(boolean flag)
    {
        return false;
    }

    public Object get()
    {
        return zzCM;
    }

    public Object get(long l, TimeUnit timeunit)
    {
        return zzCM;
    }

    public boolean isCancelled()
    {
        return false;
    }

    public boolean isDone()
    {
        return true;
    }

    public void zzb(Runnable runnable)
    {
        zzCO.a(runnable);
    }
}
