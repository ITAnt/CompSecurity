// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.Collections;
import java.util.Set;

final class imc
    implements ilq
{

    private final Context a;

    imc(Context context)
    {
        a = context;
    }

    public final ekf a(int i, Object obj)
    {
        obj = (ily)obj;
        if (((ily) (obj)).b == euv.c)
        {
            return jdy.a(((ily) (obj)).a, (jdr)olm.a(a, jdr));
        } else
        {
            return null;
        }
    }

    public final Set a()
    {
        return Collections.emptySet();
    }

    public final Class b()
    {
        return jdy;
    }
}
