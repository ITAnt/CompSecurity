// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.af;
import com.google.b.al;
import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.d.d;
import java.math.BigInteger;

final class ag extends al
{

    ag()
    {
    }

    private static BigInteger b(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        try
        {
            a1 = new BigInteger(a1.h());
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new af(a1);
        }
        return a1;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(d d1, Object obj)
    {
        d1.a((BigInteger)obj);
    }
}
