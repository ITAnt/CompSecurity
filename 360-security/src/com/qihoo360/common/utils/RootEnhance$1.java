// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.qihoo360.common.utils;

import android.content.Context;
import com.qihoo360.mobilesafe.support.a;
import com.qihoo360.mobilesafe.support.a.b;
import java.util.ArrayList;

// Referenced classes of package com.qihoo360.common.utils:
//            RootEnhance, Utils

class c
    implements Runnable
{

    final String a = "app_process";
    private final Context b;
    private final String c[];

    public void run()
    {
        Object obj;
        Object obj1;
        Object aobj[];
        aobj = new Object[2];
        obj = null;
        obj1 = obj;
        Object obj2 = com.qihoo360.mobilesafe.support.a.a("app_process");
        obj1 = obj;
        obj = com.qihoo360.mobilesafe.support.a.a(b, aobj);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        if (((b) (obj)).a()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        boolean flag = ((b) (obj)).a(20000L);
        if (flag) goto _L4; else goto _L2
_L2:
        if (obj != null)
        {
            com.qihoo360.mobilesafe.support.a.b(b, aobj);
        }
_L6:
        return;
_L4:
        obj1 = obj;
        ArrayList arraylist = new ArrayList(4);
        obj1 = obj;
        arraylist.add(obj2);
        obj1 = obj;
        arraylist.add("com.qihoo360.RFS");
        obj1 = obj;
        arraylist.add("-fs");
        obj1 = obj;
        arraylist.add("pkg");
        obj1 = obj;
        ArrayList arraylist1 = new ArrayList();
        obj1 = obj;
        arraylist1.add((new StringBuilder("CLASSPATH=")).append(com.qihoo360.mobilesafe.support.a.e(b)).toString());
        obj1 = obj;
        String as[] = c;
        obj1 = obj;
        int j = as.length;
        int i = 0;
_L7:
label0:
        {
            if (i < j)
            {
                break label0;
            }
            if (obj != null)
            {
                com.qihoo360.mobilesafe.support.a.b(b, aobj);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        arraylist.set(3, as[i]);
        obj1 = obj;
        com.qihoo360.mobilesafe.support.a.a(((b) (obj)), Utils.pathAppend(((String) (obj2)), "app_process"), arraylist, arraylist1, 0L);
        i++;
          goto _L7
        obj;
        if (obj1 == null) goto _L6; else goto _L8
_L8:
        com.qihoo360.mobilesafe.support.a.b(b, aobj);
        return;
        obj;
        obj2 = null;
        obj1 = obj;
_L10:
        if (obj2 != null)
        {
            com.qihoo360.mobilesafe.support.a.b(b, aobj);
        }
        throw obj1;
        obj1;
        obj2 = obj;
        if (true) goto _L10; else goto _L9
_L9:
    }

    (Context context, String as[])
    {
        b = context;
        c = as;
        super();
    }
}
