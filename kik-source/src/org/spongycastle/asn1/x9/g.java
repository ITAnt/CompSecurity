// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ECParametersHolder, X9ECParameters

final class g extends X9ECParametersHolder
{

    g()
    {
    }

    protected final X9ECParameters a()
    {
        BigInteger biginteger = new BigInteger("0101BAF95C9723C57B6C21DA2EFF2D5ED588BDD5717E212F9D", 16);
        BigInteger biginteger1 = BigInteger.valueOf(65096L);
        org.spongycastle.math.ec.ECCurve.F2m f2m = new org.spongycastle.math.ec.ECCurve.F2m(208, 1, 2, 83, new BigInteger("0", 16), new BigInteger("00C8619ED45A62E6212E1160349E2BFA844439FAFC2A3FD1638F9E", 16), biginteger, biginteger1);
        return new X9ECParameters(f2m, f2m.a(Hex.a("0289FDFBE4ABE193DF9559ECF07AC0CE78554E2784EB8C1ED1A57A")), biginteger, biginteger1, null);
    }
}
