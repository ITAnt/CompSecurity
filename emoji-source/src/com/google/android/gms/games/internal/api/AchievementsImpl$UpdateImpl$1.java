// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AchievementsImpl

class yJ
    implements com.google.android.gms.games.achievement.Result
{

    final yJ Pl;
    final Status yJ;

    public String getAchievementId()
    {
        return esult(Pl);
    }

    public Status getStatus()
    {
        return yJ;
    }

    esult(esult esult, Status status)
    {
        Pl = esult;
        yJ = status;
        super();
    }
}
