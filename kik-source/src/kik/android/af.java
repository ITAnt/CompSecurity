// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android;

import a.a;
import com.kik.cache.ad;
import javax.inject.Provider;
import kik.a.e.l;
import kik.a.e.r;
import kik.a.e.v;

// Referenced classes of package kik.android:
//            KikNotificationHandler

public final class af
    implements a
{

    static final boolean a;
    private final a b;
    private final Provider c;
    private final Provider d;
    private final Provider e;
    private final Provider f;
    private final Provider g;

    private af(a a1, Provider provider, Provider provider1, Provider provider2, Provider provider3, Provider provider4)
    {
        if (!a && a1 == null)
        {
            throw new AssertionError();
        }
        b = a1;
        if (!a && provider == null)
        {
            throw new AssertionError();
        }
        c = provider;
        if (!a && provider1 == null)
        {
            throw new AssertionError();
        }
        d = provider1;
        if (!a && provider2 == null)
        {
            throw new AssertionError();
        }
        e = provider2;
        if (!a && provider3 == null)
        {
            throw new AssertionError();
        }
        f = provider3;
        if (!a && provider4 == null)
        {
            throw new AssertionError();
        } else
        {
            g = provider4;
            return;
        }
    }

    public static a a(a a1, Provider provider, Provider provider1, Provider provider2, Provider provider3, Provider provider4)
    {
        return new af(a1, provider, provider1, provider2, provider3, provider4);
    }

    public final void a(Object obj)
    {
        obj = (KikNotificationHandler)obj;
        if (obj == null)
        {
            throw new NullPointerException("Cannot inject members into a null reference");
        } else
        {
            b.a(obj);
            obj.a = (ad)c.get();
            obj.b = (r)d.get();
            obj.c = (l)e.get();
            obj.d = (v)f.get();
            obj.e = (com.kik.android.a)g.get();
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!kik/android/af.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
