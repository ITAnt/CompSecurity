// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.crmf:
//            CertRequest, ProofOfPossession

public class CertReqMsg extends ASN1Object
{

    private CertRequest a;
    private ProofOfPossession b;
    private ASN1Sequence c;

    private static void a(ASN1EncodableVector asn1encodablevector, ASN1Encodable asn1encodable)
    {
        if (asn1encodable != null)
        {
            asn1encodablevector.a(asn1encodable);
        }
    }

    public final ASN1Primitive a()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.a(a);
        a(asn1encodablevector, ((ASN1Encodable) (b)));
        a(asn1encodablevector, ((ASN1Encodable) (c)));
        return new DERSequence(asn1encodablevector);
    }
}
