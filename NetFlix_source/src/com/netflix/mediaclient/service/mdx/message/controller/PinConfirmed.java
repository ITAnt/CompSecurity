// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.service.mdx.message.controller;

import com.netflix.mediaclient.service.mdx.message.MdxMessage;

public final class PinConfirmed extends MdxMessage
{

    public PinConfirmed()
    {
        super("PIN_VERIFICATION_RESPONSE");
        createObj();
    }

    private void createObj()
    {
    }
}
