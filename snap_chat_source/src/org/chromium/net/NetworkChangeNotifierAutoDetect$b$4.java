// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;


// Referenced classes of package org.chromium.net:
//            NetworkChangeNotifierAutoDetect

final class a
    implements Runnable
{

    private int a;
    private a b;

    public final void run()
    {
        NetworkChangeNotifierAutoDetect.b(b.b).c(a);
    }

    rver(rver rver, int i)
    {
        b = rver;
        a = i;
        super();
    }
}
