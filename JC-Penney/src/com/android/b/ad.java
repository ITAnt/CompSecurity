// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.b;

import android.util.Log;
import java.util.Locale;

public class ad
{

    public static String a;
    public static boolean b;

    public ad()
    {
    }

    public static transient void a(String s, Object aobj[])
    {
        if (b)
        {
            Log.v(a, e(s, aobj));
        }
    }

    public static transient void a(Throwable throwable, String s, Object aobj[])
    {
        Log.e(a, e(s, aobj), throwable);
    }

    public static transient void b(String s, Object aobj[])
    {
        Log.d(a, e(s, aobj));
    }

    public static transient void c(String s, Object aobj[])
    {
        Log.e(a, e(s, aobj));
    }

    public static transient void d(String s, Object aobj[])
    {
        Log.wtf(a, e(s, aobj));
    }

    private static transient String e(String s, Object aobj[])
    {
        int i;
        String s1;
        if (aobj != null)
        {
            s = String.format(Locale.US, s, aobj);
        }
        aobj = (new Throwable()).fillInStackTrace().getStackTrace();
        i = 2;
_L3:
        if (i >= aobj.length)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        if (aobj[i].getClass().equals(com/android/b/ad)) goto _L2; else goto _L1
_L1:
        s1 = ((StackTraceElement) (aobj[i])).getClassName();
        s1 = s1.substring(s1.lastIndexOf('.') + 1);
        s1 = s1.substring(s1.lastIndexOf('$') + 1);
        aobj = (new StringBuilder()).append(s1).append(".").append(((StackTraceElement) (aobj[i])).getMethodName()).toString();
_L4:
        return String.format(Locale.US, "[%d] %s: %s", new Object[] {
            Long.valueOf(Thread.currentThread().getId()), aobj, s
        });
_L2:
        i++;
          goto _L3
        aobj = "<unknown>";
          goto _L4
    }

    static 
    {
        a = "Volley";
        b = Log.isLoggable(a, 2);
    }
}
