// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

// Referenced classes of package org.bouncycastle.jcajce.provider.symmetric:
//            Salsa20

public class  extends AlgorithmProvider
{

    private static final String PREFIX = org/bouncycastle/jcajce/provider/symmetric/Salsa20.getName();

    public void configure(ConfigurableProvider configurableprovider)
    {
        configurableprovider.addAlgorithm("Cipher.SALSA20", (new StringBuilder()).append(PREFIX).append("$Base").toString());
        configurableprovider.addAlgorithm("KeyGenerator.SALSA20", (new StringBuilder()).append(PREFIX).append("$KeyGen").toString());
    }


    public ()
    {
    }
}
