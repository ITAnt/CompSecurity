// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.exceptions;

import java.io.IOException;

public class BraintreeException extends IOException
{

    public BraintreeException()
    {
    }

    public BraintreeException(String s)
    {
        super(s);
    }
}
