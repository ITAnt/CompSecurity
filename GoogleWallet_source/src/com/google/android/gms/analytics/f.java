// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

interface f
{

    public abstract void dispatch();

    public abstract void forceDispatch();

    public abstract LinkedBlockingQueue getQueue();

    public abstract Thread getThread();

    public abstract void sendHit(Map map);

    public abstract void setForceLocalDispatch();
}
