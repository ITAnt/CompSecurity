// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.dp;
import com.google.android.gms.wearable.c;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            ap, aq, z

public final class bb
    implements c
{

    private static final ab.a a = new ab.a() {

        public final void a(ap ap1, com.google.android.gms.internal.dg.b b, Object obj, dp dp)
            throws RemoteException
        {
            obj = (com.google.android.gms.wearable.c.a)obj;
            ap1.h.a(ap1, b, obj, aq.e(dp));
        }

    };

    public bb()
    {
    }

}
