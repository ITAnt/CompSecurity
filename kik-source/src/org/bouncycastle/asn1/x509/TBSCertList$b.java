// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Sequence;

// Referenced classes of package org.bouncycastle.asn1.x509:
//            TBSCertList

private final class b
    implements Enumeration
{

    final TBSCertList a;
    private final Enumeration b;

    public final boolean hasMoreElements()
    {
        return b.hasMoreElements();
    }

    public final Object nextElement()
    {
        return new LEntry(ASN1Sequence.a(b.nextElement()));
    }

    LEntry(TBSCertList tbscertlist, Enumeration enumeration)
    {
        a = tbscertlist;
        super();
        b = enumeration;
    }
}
