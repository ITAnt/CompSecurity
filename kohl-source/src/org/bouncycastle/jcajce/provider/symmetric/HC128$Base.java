// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.engines.HC128Engine;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;

// Referenced classes of package org.bouncycastle.jcajce.provider.symmetric:
//            HC128

public static class reamCipher extends BaseStreamCipher
{

    public reamCipher()
    {
        super(new HC128Engine(), 16);
    }
}
