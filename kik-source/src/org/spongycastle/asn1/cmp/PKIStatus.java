// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class PKIStatus extends ASN1Object
{

    public static final PKIStatus a = new PKIStatus(0);
    public static final PKIStatus b = new PKIStatus(1);
    public static final PKIStatus c = new PKIStatus(2);
    public static final PKIStatus d = new PKIStatus(3);
    public static final PKIStatus e = new PKIStatus(4);
    public static final PKIStatus f = new PKIStatus(5);
    public static final PKIStatus g = new PKIStatus(6);
    private ASN1Integer h;

    private PKIStatus(int i)
    {
        this(new ASN1Integer(i));
    }

    private PKIStatus(ASN1Integer asn1integer)
    {
        h = asn1integer;
    }

    public final ASN1Primitive a()
    {
        return h;
    }

}
