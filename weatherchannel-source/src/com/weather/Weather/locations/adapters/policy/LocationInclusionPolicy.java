// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.weather.Weather.locations.adapters.policy;

import com.weather.dal2.locations.SavedLocation;

public interface LocationInclusionPolicy
{

    public abstract boolean includes(SavedLocation savedlocation);
}
