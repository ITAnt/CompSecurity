// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            GOST28147

public static class ator extends BaseKeyGenerator
{

    public ator()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        super("GOST28147", 256, new CipherKeyGenerator());
    }
}
