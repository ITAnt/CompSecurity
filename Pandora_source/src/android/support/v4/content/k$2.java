// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v4.content:
//            k

class <init> extends <init>
{

    final k a;

    public Object call()
        throws Exception
    {
        k.a(a).set(true);
        Process.setThreadPriority(10);
        return k.a(a, a.a(b));
    }

    micBoolean(k k1)
    {
        a = k1;
        super(null);
    }
}
