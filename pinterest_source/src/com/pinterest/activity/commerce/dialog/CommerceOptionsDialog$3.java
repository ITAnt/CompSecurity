// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.commerce.dialog;


class pe
{

    static final int $SwitchMap$com$pinterest$activity$commerce$dialog$CommerceOptionsDialog$Type[];

    static 
    {
        $SwitchMap$com$pinterest$activity$commerce$dialog$CommerceOptionsDialog$Type = new int[pe.values().length];
        try
        {
            $SwitchMap$com$pinterest$activity$commerce$dialog$CommerceOptionsDialog$Type[pe.PaymentMethod.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$pinterest$activity$commerce$dialog$CommerceOptionsDialog$Type[pe.ShippingAddress.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
