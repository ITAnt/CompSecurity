// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.crypto.tls;


// Referenced classes of package org.bouncycastle.crypto.tls:
//            TlsAuthentication, Certificate, CertificateVerifyer, TlsFatalAlert, 
//            CertificateRequest, TlsCredentials

public class LegacyTlsAuthentication
    implements TlsAuthentication
{

    protected CertificateVerifyer a;

    public LegacyTlsAuthentication(CertificateVerifyer certificateverifyer)
    {
        a = certificateverifyer;
    }

    public TlsCredentials getClientCredentials(CertificateRequest certificaterequest)
    {
        return null;
    }

    public void notifyServerCertificate(Certificate certificate)
    {
        if (!a.isValid(certificate.getCerts()))
        {
            throw new TlsFatalAlert((short)90);
        } else
        {
            return;
        }
    }
}
