// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.b;


// Referenced classes of package com.c.b:
//            c, av, g, aq

final class m extends c
{

    m()
    {
    }

    private static i.a.d b(g g, aq aq)
    {
        try
        {
            g = new i.a.d(g, aq, (byte)0);
        }
        // Misplaced declaration of an exception variable
        catch (g g)
        {
            if (g.getCause() instanceof av)
            {
                throw (av)g.getCause();
            } else
            {
                throw g;
            }
        }
        return g;
    }

    public final Object a(g g, aq aq)
    {
        return b(g, aq);
    }
}
