// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ubercab.rider.realtime.response;


public abstract class OnboardingPitchPoint
{

    public OnboardingPitchPoint()
    {
    }

    public abstract String getBodyText();

    public abstract String getTitle();

    abstract void setBodyText(String s);

    abstract void setTitle(String s);
}
