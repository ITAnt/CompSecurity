// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.Cursor;

public final class dyz
    implements gfk
{

    public static final String a[] = {
        "ab_test_push_notifications"
    };
    private final dzb b;

    dyz(dzb dzb1)
    {
        b = dzb1;
    }

    public final void a(gfi gfi, Cursor cursor)
    {
        if (!cursor.moveToFirst())
        {
            return;
        } else
        {
            b.a(gcw.a(cursor, 0));
            return;
        }
    }

}
