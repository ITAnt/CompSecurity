// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.plus.internal:
//            a, e

final class alv extends a
{

    private final com.google.android.gms.common.api.Implementation.b alv;
    final e alw;

    public void a(DataHolder dataholder, String s, String s1)
    {
        Object obj;
        if (dataholder.gy() != null)
        {
            obj = (PendingIntent)dataholder.gy().getParcelable("pendingIntent");
        } else
        {
            obj = null;
        }
        obj = new Status(dataholder.getStatusCode(), null, ((PendingIntent) (obj)));
        if (!((Status) (obj)).isSuccess() && dataholder != null)
        {
            if (!dataholder.isClosed())
            {
                dataholder.close();
            }
            dataholder = null;
        }
        alw.a(new <init>(alw, alv, ((Status) (obj)), dataholder, s, s1));
    }

    public ntation.b(e e1, com.google.android.gms.common.api.Implementation.b b1)
    {
        alw = e1;
        super();
        alv = b1;
    }
}
