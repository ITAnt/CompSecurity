// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package ch.boye.httpclientandroidlib.message;

import ch.boye.httpclientandroidlib.Header;
import ch.boye.httpclientandroidlib.HeaderIterator;
import ch.boye.httpclientandroidlib.HttpMessage;
import ch.boye.httpclientandroidlib.params.BasicHttpParams;
import ch.boye.httpclientandroidlib.params.HttpParams;

// Referenced classes of package ch.boye.httpclientandroidlib.message:
//            HeaderGroup, BasicHeader

public abstract class AbstractHttpMessage
    implements HttpMessage
{

    protected HeaderGroup headergroup;
    protected HttpParams params;

    protected AbstractHttpMessage()
    {
        this(null);
    }

    protected AbstractHttpMessage(HttpParams httpparams)
    {
        headergroup = new HeaderGroup();
        params = httpparams;
    }

    public void addHeader(Header header)
    {
        headergroup.addHeader(header);
    }

    public void addHeader(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Header name may not be null");
        } else
        {
            headergroup.addHeader(new BasicHeader(s, s1));
            return;
        }
    }

    public boolean containsHeader(String s)
    {
        return headergroup.containsHeader(s);
    }

    public Header[] getAllHeaders()
    {
        return headergroup.getAllHeaders();
    }

    public Header getFirstHeader(String s)
    {
        return headergroup.getFirstHeader(s);
    }

    public Header[] getHeaders(String s)
    {
        return headergroup.getHeaders(s);
    }

    public Header getLastHeader(String s)
    {
        return headergroup.getLastHeader(s);
    }

    public HttpParams getParams()
    {
        if (params == null)
        {
            params = new BasicHttpParams();
        }
        return params;
    }

    public HeaderIterator headerIterator()
    {
        return headergroup.iterator();
    }

    public HeaderIterator headerIterator(String s)
    {
        return headergroup.iterator(s);
    }

    public void removeHeader(Header header)
    {
        headergroup.removeHeader(header);
    }

    public void removeHeaders(String s)
    {
        if (s != null)
        {
            HeaderIterator headeriterator = headergroup.iterator();
            while (headeriterator.hasNext()) 
            {
                if (s.equalsIgnoreCase(headeriterator.nextHeader().getName()))
                {
                    headeriterator.remove();
                }
            }
        }
    }

    public void setHeader(Header header)
    {
        headergroup.updateHeader(header);
    }

    public void setHeader(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Header name may not be null");
        } else
        {
            headergroup.updateHeader(new BasicHeader(s, s1));
            return;
        }
    }

    public void setHeaders(Header aheader[])
    {
        headergroup.setHeaders(aheader);
    }

    public void setParams(HttpParams httpparams)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            params = httpparams;
            return;
        }
    }
}
