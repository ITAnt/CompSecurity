// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;


// Referenced classes of package android.support.v4.view.a:
//            ah, af, ae, ai, 
//            ag

public final class ad
{

    private static final ag a;
    private final Object b;

    public ad(Object obj)
    {
        b = obj;
    }

    public final void a(int i)
    {
        a.b(b, i);
    }

    public final void a(boolean flag)
    {
        a.a(b, flag);
    }

    public final void b(int i)
    {
        a.a(b, i);
    }

    public final void c(int i)
    {
        a.e(b, i);
    }

    public final void d(int i)
    {
        a.c(b, i);
    }

    public final void e(int i)
    {
        a.d(b, i);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ad)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ad) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(((ad) (obj)).b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final void f(int i)
    {
        a.f(b, i);
    }

    public final void g(int i)
    {
        a.g(b, i);
    }

    public final int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new ah();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            a = new af();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new ae();
        } else
        {
            a = new ai();
        }
    }
}
