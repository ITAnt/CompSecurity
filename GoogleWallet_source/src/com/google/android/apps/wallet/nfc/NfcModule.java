// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.wallet.nfc;

import com.google.android.apps.wallet.eventbus.InitializedEventPublisher;

// Referenced classes of package com.google.android.apps.wallet.nfc:
//            NfcAdapterStateEventPublisher

public class NfcModule
{

    public NfcModule()
    {
    }

    static InitializedEventPublisher getInitializedEventPublishers(NfcAdapterStateEventPublisher nfcadapterstateeventpublisher)
    {
        return nfcadapterstateeventpublisher;
    }
}
