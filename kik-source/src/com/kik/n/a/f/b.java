// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kik.n.a.f;

import com.b.a.k;
import com.b.a.o;
import com.b.a.u;
import java.util.HashMap;

// Referenced classes of package com.kik.n.a.f:
//            a

final class b
    implements u
{

    final HashMap a = new HashMap();

    b()
    {
        a.put("icon", Integer.valueOf(1));
        a.put("pngPreview", Integer.valueOf(2));
        a.put("compatPreview", Integer.valueOf(3));
    }

    public final Object a()
    {
        return new a();
    }

    public final void a(k k1, Object obj)
    {
        int i;
        obj = (a)obj;
        i = k1.a(this);
_L7:
        i;
        JVM INSTR tableswitch 0 3: default 44
    //                   0 102
    //                   1 63
    //                   2 76
    //                   3 89;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_89;
_L2:
        break MISSING_BLOCK_LABEL_102;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        k1.a(i, this);
_L8:
        i = k1.a(this);
        if (true) goto _L7; else goto _L6
_L6:
        obj.b = k1.g();
          goto _L8
_L4:
        obj.c = k1.g();
          goto _L8
        obj.d = k1.g();
          goto _L8
    }

    public final volatile void a(o o1, Object obj)
    {
        obj = (a)obj;
        if (((a) (obj)).b != null)
        {
            o1.a(1, ((a) (obj)).b, false);
        }
        if (((a) (obj)).c != null)
        {
            o1.a(2, ((a) (obj)).c, false);
        }
        if (((a) (obj)).d != null)
        {
            o1.a(3, ((a) (obj)).d, false);
        }
    }

    public final volatile boolean a(Object obj)
    {
        return true;
    }
}
