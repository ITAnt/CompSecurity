// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.cache;


// Referenced classes of package com.google.android.gms.games.cache:
//            TransientDataHolderCache

public final class ProfileSettingsCache extends TransientDataHolderCache
{

    public ProfileSettingsCache(String as[])
    {
        super(as, 0x240c8400L, null, null);
    }

    protected final String getDebugColumn()
    {
        return "profile_visible";
    }
}
