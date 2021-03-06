// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.X509CertStoreSelector;

// Referenced classes of package org.spongycastle.jce.provider:
//            AnnotatedException, BouncyCastleProvider, CertPathValidatorUtilities

public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi
{

    private Exception a;

    public PKIXCertPathBuilderSpi()
    {
    }

    private CertPathBuilderResult a(X509Certificate x509certificate, ExtendedPKIXBuilderParameters extendedpkixbuilderparameters, List list)
    {
        Object obj;
        java.security.cert.CertPath certpath;
        certpath = null;
        obj = null;
        if (!list.contains(x509certificate)) goto _L2; else goto _L1
_L1:
        obj = null;
_L5:
        return ((CertPathBuilderResult) (obj));
_L2:
        Object obj1;
        if (extendedpkixbuilderparameters.a().contains(x509certificate))
        {
            return null;
        }
        if (extendedpkixbuilderparameters.b() != -1 && list.size() - 1 > extendedpkixbuilderparameters.b())
        {
            return null;
        }
        list.add(x509certificate);
        CertPathValidator certpathvalidator;
        CertificateFactory certificatefactory;
        java.security.cert.TrustAnchor trustanchor;
        try
        {
            certificatefactory = CertificateFactory.getInstance("X.509", BouncyCastleProvider.a);
            certpathvalidator = CertPathValidator.getInstance("PKIX", BouncyCastleProvider.a);
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            throw new RuntimeException("Exception creating support classes.");
        }
        obj1 = obj;
        trustanchor = CertPathValidatorUtilities.a(x509certificate, extendedpkixbuilderparameters.getTrustAnchors(), extendedpkixbuilderparameters.getSigProvider());
        if (trustanchor == null) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        certpath = certificatefactory.generateCertPath(list);
        obj1 = obj;
        extendedpkixbuilderparameters = (PKIXCertPathValidatorResult)certpathvalidator.validate(certpath, extendedpkixbuilderparameters);
        obj1 = obj;
        extendedpkixbuilderparameters = new PKIXCertPathBuilderResult(certpath, extendedpkixbuilderparameters.getTrustAnchor(), extendedpkixbuilderparameters.getPolicyTree(), extendedpkixbuilderparameters.getPublicKey());
        return extendedpkixbuilderparameters;
        extendedpkixbuilderparameters;
        obj1 = obj;
        try
        {
            throw new AnnotatedException("Certification path could not be constructed from certificate list.", extendedpkixbuilderparameters);
        }
        // Misplaced declaration of an exception variable
        catch (ExtendedPKIXBuilderParameters extendedpkixbuilderparameters)
        {
            a = extendedpkixbuilderparameters;
        }
        extendedpkixbuilderparameters = ((ExtendedPKIXBuilderParameters) (obj1));
_L8:
        obj = extendedpkixbuilderparameters;
        if (extendedpkixbuilderparameters == null)
        {
            list.remove(x509certificate);
            return extendedpkixbuilderparameters;
        }
          goto _L5
        extendedpkixbuilderparameters;
        obj1 = obj;
        throw new AnnotatedException("Certification path could not be validated.", extendedpkixbuilderparameters);
_L4:
        obj1 = obj;
        CertPathValidatorUtilities.a(x509certificate, extendedpkixbuilderparameters);
        obj1 = obj;
        Object obj2 = new HashSet();
        ((Collection) (obj2)).addAll(CertPathValidatorUtilities.a(x509certificate, extendedpkixbuilderparameters));
        obj1 = obj;
        if (!((Collection) (obj2)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_333;
        }
        obj1 = obj;
        throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
        extendedpkixbuilderparameters;
        obj1 = obj;
        throw new AnnotatedException("No additiontal X.509 stores can be added from certificate locations.", extendedpkixbuilderparameters);
        extendedpkixbuilderparameters;
        obj1 = obj;
        throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", extendedpkixbuilderparameters);
        obj1 = obj;
        obj2 = ((Collection) (obj2)).iterator();
        obj = certpath;
_L7:
        obj1 = obj;
        if (!((Iterator) (obj2)).hasNext() || obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj = a((X509Certificate)((Iterator) (obj2)).next(), extendedpkixbuilderparameters, list);
        if (true) goto _L7; else goto _L6
_L6:
        extendedpkixbuilderparameters = ((ExtendedPKIXBuilderParameters) (obj));
          goto _L8
    }

    public CertPathBuilderResult engineBuild(CertPathParameters certpathparameters)
    {
        if (!(certpathparameters instanceof PKIXBuilderParameters) && !(certpathparameters instanceof ExtendedPKIXBuilderParameters))
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("Parameters must be an instance of ")).append(java/security/cert/PKIXBuilderParameters.getName()).append(" or ").append(org/spongycastle/x509/ExtendedPKIXBuilderParameters.getName()).append(".").toString());
        }
        Object obj;
        ArrayList arraylist;
        if (certpathparameters instanceof ExtendedPKIXBuilderParameters)
        {
            certpathparameters = (ExtendedPKIXBuilderParameters)certpathparameters;
        } else
        {
            certpathparameters = (ExtendedPKIXBuilderParameters)ExtendedPKIXBuilderParameters.b((PKIXBuilderParameters)certpathparameters);
        }
        arraylist = new ArrayList();
        obj = certpathparameters.h();
        if (!(obj instanceof X509CertStoreSelector))
        {
            throw new CertPathBuilderException((new StringBuilder("TargetConstraints must be an instance of ")).append(org/spongycastle/x509/X509CertStoreSelector.getName()).append(" for ").append(getClass().getName()).append(" class.").toString());
        }
        Object obj1;
        try
        {
            obj1 = CertPathValidatorUtilities.a((X509CertStoreSelector)obj, certpathparameters.f());
            ((Collection) (obj1)).addAll(CertPathValidatorUtilities.a((X509CertStoreSelector)obj, certpathparameters.getCertStores()));
        }
        // Misplaced declaration of an exception variable
        catch (CertPathParameters certpathparameters)
        {
            throw new ExtCertPathBuilderException("Error finding target certificate.", certpathparameters);
        }
        if (((Collection) (obj1)).isEmpty())
        {
            throw new CertPathBuilderException("No certificate found matching targetContraints.");
        }
        obj = null;
        for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext() && obj == null; obj = a((X509Certificate)((Iterator) (obj1)).next(), certpathparameters, arraylist)) { }
        if (obj == null && a != null)
        {
            if (a instanceof AnnotatedException)
            {
                throw new CertPathBuilderException(a.getMessage(), a.getCause());
            } else
            {
                throw new CertPathBuilderException("Possible certificate chain could not be validated.", a);
            }
        }
        if (obj == null && a == null)
        {
            throw new CertPathBuilderException("Unable to find certificate chain.");
        } else
        {
            return ((CertPathBuilderResult) (obj));
        }
    }
}
