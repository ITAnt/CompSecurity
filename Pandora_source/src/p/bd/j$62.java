// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package p.bd;

import p.bf.b;

// Referenced classes of package p.bd:
//            j

class Object
    implements Runnable
{

    final Exception a;
    final j b;

    public void run()
    {
        j.d(b).a("Error handing proxy event.", a);
    }

    Exception(j j1, Exception exception)
    {
        b = j1;
        a = exception;
        super();
    }
}
