// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.g;


public final class g
{

    public final Object a;
    public final Object b;

    public g(Object obj, Object obj1)
    {
        a = obj;
        b = obj1;
    }

    private static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof g)
        {
            if (a(((g) (obj = (g)obj)).a, a) && a(((g) (obj)).b, b))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        int j = 0;
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b != null)
        {
            j = b.hashCode();
        }
        return i ^ j;
    }
}
