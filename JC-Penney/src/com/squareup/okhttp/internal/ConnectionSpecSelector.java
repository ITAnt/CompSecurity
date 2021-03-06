// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.squareup.okhttp.internal:
//            Internal

public final class ConnectionSpecSelector
{

    private final List connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List list)
    {
        nextModeIndex = 0;
        connectionSpecs = list;
    }

    private boolean isFallbackPossible(SSLSocket sslsocket)
    {
        for (int i = nextModeIndex; i < connectionSpecs.size(); i++)
        {
            if (((ConnectionSpec)connectionSpecs.get(i)).isCompatible(sslsocket))
            {
                return true;
            }
        }

        return false;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sslsocket)
    {
        int i;
        int j;
        i = nextModeIndex;
        j = connectionSpecs.size();
_L3:
        ConnectionSpec connectionspec;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        connectionspec = (ConnectionSpec)connectionSpecs.get(i);
        if (!connectionspec.isCompatible(sslsocket)) goto _L2; else goto _L1
_L1:
        nextModeIndex = i + 1;
_L4:
        if (connectionspec == null)
        {
            throw new UnknownServiceException((new StringBuilder()).append("Unable to find acceptable protocols. isFallback=").append(isFallback).append(", modes=").append(connectionSpecs).append(", supported protocols=").append(Arrays.toString(sslsocket.getEnabledProtocols())).toString());
        } else
        {
            isFallbackPossible = isFallbackPossible(sslsocket);
            Internal.instance.apply(connectionspec, sslsocket, isFallback);
            return connectionspec;
        }
_L2:
        i++;
          goto _L3
        connectionspec = null;
          goto _L4
    }

    public boolean connectionFailed(IOException ioexception)
    {
        boolean flag = true;
        for (isFallback = true; (ioexception instanceof ProtocolException) || (ioexception instanceof InterruptedIOException) || (ioexception instanceof SSLHandshakeException) && (ioexception.getCause() instanceof CertificateException) || (ioexception instanceof SSLPeerUnverifiedException);)
        {
            return false;
        }

        if (!(ioexception instanceof SSLHandshakeException) && !(ioexception instanceof SSLProtocolException) || !isFallbackPossible)
        {
            flag = false;
        }
        return flag;
    }
}
