// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digby.mm.android.library.exception;


// Referenced classes of package com.digby.mm.android.library.exception:
//            DigbyException

public class DisabledBrandException extends DigbyException
{

    public transient DisabledBrandException(String s, Object aobj[])
    {
        super(String.format(s, aobj), new Object[0]);
    }

    public transient DisabledBrandException(Throwable throwable, String s, Object aobj[])
    {
        super(String.format(s, aobj), new Object[] {
            throwable
        });
    }
}
