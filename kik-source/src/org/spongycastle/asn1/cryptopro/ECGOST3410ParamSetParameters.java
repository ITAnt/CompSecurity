// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cryptopro;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object
{

    ASN1Integer a;
    ASN1Integer b;
    ASN1Integer c;
    ASN1Integer d;
    ASN1Integer e;
    ASN1Integer f;

    public final ASN1Primitive a()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.a(c);
        asn1encodablevector.a(d);
        asn1encodablevector.a(a);
        asn1encodablevector.a(b);
        asn1encodablevector.a(e);
        asn1encodablevector.a(f);
        return new DERSequence(asn1encodablevector);
    }
}
