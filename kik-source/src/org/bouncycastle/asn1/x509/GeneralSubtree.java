// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

// Referenced classes of package org.bouncycastle.asn1.x509:
//            GeneralName

public class GeneralSubtree extends ASN1Encodable
{

    private static final BigInteger a = BigInteger.valueOf(0L);
    private GeneralName b;
    private DERInteger c;
    private DERInteger d;

    private GeneralSubtree(ASN1Sequence asn1sequence)
    {
        b = GeneralName.a(asn1sequence.a(0));
        asn1sequence.f();
        JVM INSTR tableswitch 1 3: default 48
    //                   1 148
    //                   2 75
    //                   3 159;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.f()).toString());
_L3:
        asn1sequence = ASN1TaggedObject.a(asn1sequence.a(1));
        asn1sequence.e();
        JVM INSTR tableswitch 0 1: default 112
    //                   0 139
    //                   1 149;
           goto _L5 _L6 _L7
_L5:
        throw new IllegalArgumentException((new StringBuilder("Bad tag number: ")).append(asn1sequence.e()).toString());
_L6:
        c = DERInteger.a(asn1sequence, false);
_L2:
        return;
_L7:
        d = DERInteger.a(asn1sequence, false);
        return;
_L4:
        ASN1TaggedObject asn1taggedobject = ASN1TaggedObject.a(asn1sequence.a(1));
        if (asn1taggedobject.e() != 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad tag number for 'minimum': ")).append(asn1taggedobject.e()).toString());
        }
        c = DERInteger.a(asn1taggedobject, false);
        asn1sequence = ASN1TaggedObject.a(asn1sequence.a(2));
        if (asn1sequence.e() != 1)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad tag number for 'maximum': ")).append(asn1sequence.e()).toString());
        } else
        {
            d = DERInteger.a(asn1sequence, false);
            return;
        }
    }

    public static GeneralSubtree a(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof GeneralSubtree)
        {
            return (GeneralSubtree)obj;
        } else
        {
            return new GeneralSubtree(ASN1Sequence.a(obj));
        }
    }

    public final DERObject d()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.a(b);
        if (c != null && !c.e().equals(a))
        {
            asn1encodablevector.a(new DERTaggedObject(false, 0, c));
        }
        if (d != null)
        {
            asn1encodablevector.a(new DERTaggedObject(false, 1, d));
        }
        return new DERSequence(asn1encodablevector);
    }

    public final GeneralName e()
    {
        return b;
    }

}
