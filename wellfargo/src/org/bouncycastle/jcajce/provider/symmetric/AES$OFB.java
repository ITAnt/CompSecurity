// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;

public class > extends BaseBlockCipher
{

    public eBlockCipher()
    {
        super(new BufferedBlockCipher(new OFBBlockCipher(new AESFastEngine(), 128)), 128);
    }
}
