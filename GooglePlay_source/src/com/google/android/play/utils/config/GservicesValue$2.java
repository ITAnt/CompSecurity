// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.play.utils.config;


// Referenced classes of package com.google.android.play.utils.config:
//            GservicesValue

static final class nit> extends GservicesValue
{

    final Long val$defaultValue;
    final String val$key;

    protected final volatile Object retrieve()
    {
        return GservicesValue.sGservicesReader.getLong(val$key, val$defaultValue);
    }

    ervicesReader(String s, String s1, Long long1)
    {
        val$key = s1;
        val$defaultValue = long1;
        super(s, (byte)0);
    }
}
