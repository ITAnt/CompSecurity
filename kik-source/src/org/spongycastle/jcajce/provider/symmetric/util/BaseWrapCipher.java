// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.PrintStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jce.provider.BouncyCastleProvider;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            PBE, BCPBEKey

public abstract class BaseWrapCipher extends CipherSpi
    implements PBE
{

    protected int a;
    protected int b;
    protected AlgorithmParameters c;
    protected Wrapper d;
    private Class e[] = {
        javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec
    };
    private int f;
    private byte g[];

    protected BaseWrapCipher()
    {
        a = 2;
        b = 1;
        c = null;
        d = null;
    }

    protected BaseWrapCipher(Wrapper wrapper)
    {
        this(wrapper, 0);
    }

    protected BaseWrapCipher(Wrapper wrapper, int i)
    {
        a = 2;
        b = 1;
        c = null;
        d = null;
        d = wrapper;
        f = i;
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        return 0;
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        return null;
    }

    protected int engineGetBlockSize()
    {
        return 0;
    }

    protected byte[] engineGetIV()
    {
        return (byte[])g.clone();
    }

    protected int engineGetKeySize(Key key)
    {
        return key.getEncoded().length;
    }

    protected int engineGetOutputSize(int i)
    {
        return -1;
    }

    protected AlgorithmParameters engineGetParameters()
    {
        return null;
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        if (algorithmparameters == null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        if (j == e.length)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        Object obj = algorithmparameters.getParameterSpec(e[j]);
_L5:
        Object obj1;
        obj1 = obj;
        if (obj == null)
        {
            throw new InvalidAlgorithmParameterException((new StringBuilder("can't handle parameter ")).append(algorithmparameters.toString()).toString());
        }
          goto _L3
        obj;
        j++;
          goto _L4
_L2:
        obj1 = null;
_L3:
        c = algorithmparameters;
        engineInit(i, key, ((AlgorithmParameterSpec) (obj1)), securerandom);
        return;
        obj = null;
          goto _L5
    }

    protected void engineInit(int i, Key key, SecureRandom securerandom)
    {
        try
        {
            engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new IllegalArgumentException(key.getMessage());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (key instanceof BCPBEKey)
        {
            key = (BCPBEKey)key;
            Object obj;
            if (algorithmparameterspec instanceof PBEParameterSpec)
            {
                key = PBE.Util.a(key, algorithmparameterspec, d.a());
            } else
            if (((BCPBEKey) (key)).g != null)
            {
                key = ((BCPBEKey) (key)).g;
            } else
            {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        } else
        {
            key = new KeyParameter(key.getEncoded());
        }
        obj = key;
        if (algorithmparameterspec instanceof IvParameterSpec)
        {
            obj = new ParametersWithIV(key, ((IvParameterSpec)algorithmparameterspec).getIV());
        }
        key = ((Key) (obj));
        if (obj instanceof KeyParameter)
        {
            key = ((Key) (obj));
            if (f != 0)
            {
                g = new byte[f];
                securerandom.nextBytes(g);
                key = new ParametersWithIV(((org.spongycastle.crypto.CipherParameters) (obj)), g);
            }
        }
        switch (i)
        {
        default:
            System.out.println("eeek!");
            return;

        case 3: // '\003'
            d.a(true, key);
            return;

        case 4: // '\004'
            d.a(false, key);
            return;

        case 1: // '\001'
        case 2: // '\002'
            throw new IllegalArgumentException("engine only valid for wrapping");
        }
    }

    protected void engineSetMode(String s)
    {
        throw new NoSuchAlgorithmException((new StringBuilder("can't support mode ")).append(s).toString());
    }

    protected void engineSetPadding(String s)
    {
        throw new NoSuchPaddingException((new StringBuilder("Padding ")).append(s).append(" unknown.").toString());
    }

    protected Key engineUnwrap(byte abyte0[], String s, int i)
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        abyte0 = engineDoFinal(abyte0, 0, abyte0.length);
_L8:
        if (i != 3) goto _L4; else goto _L3
_L3:
        abyte0 = new SecretKeySpec(abyte0, s);
_L6:
        return abyte0;
_L2:
        try
        {
            abyte0 = d.b(abyte0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException(abyte0.getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException(abyte0.getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException(abyte0.getMessage());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!s.equals("") || i != 2)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        PrivateKeyInfo privatekeyinfo;
        try
        {
            privatekeyinfo = PrivateKeyInfo.a(abyte0);
            s = BouncyCastleProvider.a(privatekeyinfo);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException("Invalid key encoding.");
        }
        abyte0 = s;
        if (s != null) goto _L6; else goto _L5
_L5:
        throw new InvalidKeyException((new StringBuilder("algorithm ")).append(privatekeyinfo.c().d()).append(" not supported").toString());
        try
        {
            s = KeyFactory.getInstance(s, BouncyCastleProvider.a);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(abyte0.getMessage()).toString());
        }
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        return s.generatePublic(new X509EncodedKeySpec(abyte0));
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        abyte0 = s.generatePrivate(new PKCS8EncodedKeySpec(abyte0));
        return abyte0;
        throw new InvalidKeyException((new StringBuilder("Unknown key type ")).append(i).toString());
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        throw new RuntimeException("not supported for wrapping");
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        throw new RuntimeException("not supported for wrapping");
    }

    protected byte[] engineWrap(Key key)
    {
        key = key.getEncoded();
        if (key == null)
        {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try
        {
            if (d == null)
            {
                return engineDoFinal(key, 0, key.length);
            }
            key = d.a(key, key.length);
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new IllegalBlockSizeException(key.getMessage());
        }
        return key;
    }
}
