// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.app.fragments;


final class bk
{

    static final int a[];

    static 
    {
        a = new int[com.google.android.apps.youtube.app.remote.RemoteControl.State.values().length];
        try
        {
            a[com.google.android.apps.youtube.app.remote.RemoteControl.State.CONNECTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.google.android.apps.youtube.app.remote.RemoteControl.State.OFFLINE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.google.android.apps.youtube.app.remote.RemoteControl.State.CONNECTING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
