// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.f.a;

import android.os.Bundle;
import com.kik.g.p;
import com.kik.g.r;

// Referenced classes of package kik.android.f.a:
//            f

final class h extends r
{

    final p a;
    final f b;

    h(f f, p p1)
    {
        b = f;
        a = p1;
        super();
    }

    public final void a(Object obj)
    {
        obj = ((Bundle)obj).getString("SendToFragment.RESULT_JID");
        a.a(obj);
    }

    public final void b()
    {
        a.e();
    }

    public final void b(Throwable throwable)
    {
        a.a(throwable);
    }
}
