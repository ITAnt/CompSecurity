// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.asymmetric.ec;

import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.signers.ECDSASigner;

// Referenced classes of package org.bouncycastle.jcajce.provider.asymmetric.ec:
//            SignatureSpi

public static class der extends SignatureSpi
{

    public der()
    {
        super(new NullDigest(), new ECDSASigner(), new der(null));
    }
}
