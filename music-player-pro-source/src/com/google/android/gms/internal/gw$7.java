// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            gw

static class Level
{

    static final int xq[];

    static 
    {
        xq = new int[android.webkit.leMessage.MessageLevel.values().length];
        try
        {
            xq[android.webkit.leMessage.MessageLevel.ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            xq[android.webkit.leMessage.MessageLevel.WARNING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            xq[android.webkit.leMessage.MessageLevel.LOG.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            xq[android.webkit.leMessage.MessageLevel.TIP.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            xq[android.webkit.leMessage.MessageLevel.DEBUG.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
