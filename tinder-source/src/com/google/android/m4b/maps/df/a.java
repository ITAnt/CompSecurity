// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.m4b.maps.df;


public final class a
{

    public static byte a(Boolean boolean1)
    {
        if (boolean1 != null)
        {
            return ((byte)(!boolean1.booleanValue() ? 0 : 1));
        } else
        {
            return -1;
        }
    }

    public static Boolean a(byte byte0)
    {
        switch (byte0)
        {
        default:
            return null;

        case 1: // '\001'
            return Boolean.TRUE;

        case 0: // '\0'
            return Boolean.FALSE;
        }
    }
}
