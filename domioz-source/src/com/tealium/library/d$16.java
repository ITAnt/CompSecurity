// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tealium.library;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.tealium.library:
//            d, g, C

final class a
    implements Runnable
{

    private C a;

    public final void run()
    {
        Iterator iterator = d.n().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj instanceof g)
            {
                ((g)obj).a(a);
            }
        } while (true);
        iterator = d.m().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = iterator.next();
            if (obj1 instanceof g)
            {
                ((g)obj1).a(a);
            }
        } while (true);
    }

    (long l, C c)
    {
        a = c;
        super();
    }
}
