// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;

public final class aus
    implements atm
{

    private Context a;

    public aus(Context context)
    {
        a = context.getApplicationContext();
    }

    public final atn a(Object obj, int i, int j, ani ani)
    {
        obj = (Uri)obj;
        if (b.b(i, j))
        {
            return new atn(new azw(obj), aof.a(a, ((Uri) (obj)), new aog()));
        } else
        {
            return null;
        }
    }

    public final boolean a(Object obj)
    {
        obj = (Uri)obj;
        return b.a(((Uri) (obj))) && !b.b(((Uri) (obj)));
    }
}
