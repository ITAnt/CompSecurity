// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.util;


public class StreamParsingException extends Exception
{

    Throwable a;

    public Throwable getCause()
    {
        return a;
    }
}
