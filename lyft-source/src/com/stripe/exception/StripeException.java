// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.exception;


public abstract class StripeException extends Exception
{

    private static final long serialVersionUID = 1L;

    public StripeException(String s)
    {
        super(s, null);
    }

    public StripeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
