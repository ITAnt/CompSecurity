// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a.a.d;

import b.a.a.a.a.b.l;

// Referenced classes of package b.a.a.a.a.d:
//            g, o

final class j
    implements Runnable
{

    final g a;

    j(g g1)
    {
        a = g1;
        super();
    }

    public final void run()
    {
        try
        {
            a.c.b();
            return;
        }
        catch (Exception exception)
        {
            l.b(a.a, "Failed to send events files.");
        }
    }
}
