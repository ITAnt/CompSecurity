// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

// Referenced classes of package android.support.v7.app:
//            d, b

final class f extends CursorAdapter
{

    final ListView a;
    final b b;
    final d c;
    private final int d;
    private final int e;

    f(d d1, Context context, Cursor cursor, ListView listview, b b1)
    {
        c = d1;
        a = listview;
        b = b1;
        super(context, cursor, false);
        d1 = getCursor();
        d = d1.getColumnIndexOrThrow(c.I);
        e = d1.getColumnIndexOrThrow(c.J);
    }

    public final void bindView(View view, Context context, Cursor cursor)
    {
        ((CheckedTextView)view.findViewById(0x1020014)).setText(cursor.getString(d));
        view = a;
        int i = cursor.getPosition();
        boolean flag;
        if (cursor.getInt(e) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setItemChecked(i, flag);
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return c.b.inflate(android.support.v7.app.b.j(b), viewgroup, false);
    }
}
