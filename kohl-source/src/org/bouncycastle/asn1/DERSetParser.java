// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.asn1;

import java.io.IOException;

// Referenced classes of package org.bouncycastle.asn1:
//            ASN1SetParser, DERSet, ASN1StreamParser, ASN1ParsingException, 
//            ASN1Primitive, ASN1Encodable

public class DERSetParser
    implements ASN1SetParser
{

    private ASN1StreamParser _parser;

    DERSetParser(ASN1StreamParser asn1streamparser)
    {
        _parser = asn1streamparser;
    }

    public ASN1Primitive getLoadedObject()
        throws IOException
    {
        return new DERSet(_parser.readVector(), false);
    }

    public ASN1Encodable readObject()
        throws IOException
    {
        return _parser.readObject();
    }

    public ASN1Primitive toASN1Primitive()
    {
        ASN1Primitive asn1primitive;
        try
        {
            asn1primitive = getLoadedObject();
        }
        catch (IOException ioexception)
        {
            throw new ASN1ParsingException(ioexception.getMessage(), ioexception);
        }
        return asn1primitive;
    }
}
