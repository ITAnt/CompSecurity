// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1.sec:
//            SECNamedCurves

final class af extends X9ECParametersHolder
{

    af()
    {
    }

    protected final X9ECParameters a()
    {
        Object obj = SECNamedCurves.c("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37");
        BigInteger biginteger2 = ECConstants.f;
        BigInteger biginteger3 = BigInteger.valueOf(3L);
        BigInteger biginteger = SECNamedCurves.c("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D");
        BigInteger biginteger1 = BigInteger.valueOf(1L);
        obj = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj)), biginteger2, biginteger3);
        return new X9ECParameters(((ECCurve) (obj)), ((ECCurve) (obj)).a(Hex.a("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), biginteger, biginteger1, null);
    }
}
