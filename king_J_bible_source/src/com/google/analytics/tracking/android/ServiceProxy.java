// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.List;
import java.util.Map;

interface ServiceProxy
{

    public abstract void clearHits();

    public abstract void createService();

    public abstract void dispatch();

    public abstract void putHit(Map map, long l, String s, List list);
}
