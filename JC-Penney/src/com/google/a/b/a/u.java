// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ab;
import com.google.a.af;
import com.google.a.ag;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Referenced classes of package com.google.a.b.a:
//            v

public final class u extends af
{

    public static final ag a = new v();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public u()
    {
    }

    public Date a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.f() != c.i) goto _L2; else goto _L1
_L1:
        a1.j();
        a1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = new Date(b.parse(a1.h()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw new ab(a1);
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public volatile void a(d d1, Object obj)
    {
        a(d1, (Date)obj);
    }

    public void a(d d1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        date = null;
_L4:
        d1.b(date);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        date = b.format(date);
        if (true) goto _L4; else goto _L3
_L3:
        d1;
        throw d1;
    }

    public Object b(a a1)
    {
        return a(a1);
    }

}
