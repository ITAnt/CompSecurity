// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Interpolator;

final class agk
    implements Interpolator
{

    agk()
    {
    }

    public final float getInterpolation(float f)
    {
        return f * f * f * f * f;
    }
}
