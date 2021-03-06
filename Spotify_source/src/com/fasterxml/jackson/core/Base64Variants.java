// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core;


// Referenced classes of package com.fasterxml.jackson.core:
//            Base64Variant

public final class Base64Variants
{

    public static final Base64Variant MIME;
    public static final Base64Variant MIME_NO_LINEFEEDS;
    public static final Base64Variant MODIFIED_FOR_URL;
    public static final Base64Variant PEM;

    public static Base64Variant getDefaultVariant()
    {
        return MIME_NO_LINEFEEDS;
    }

    public static Base64Variant valueOf(String s)
    {
        if (MIME._name.equals(s))
        {
            return MIME;
        }
        if (MIME_NO_LINEFEEDS._name.equals(s))
        {
            return MIME_NO_LINEFEEDS;
        }
        if (PEM._name.equals(s))
        {
            return PEM;
        }
        if (MODIFIED_FOR_URL._name.equals(s))
        {
            return MODIFIED_FOR_URL;
        }
        if (s == null)
        {
            s = "<null>";
        } else
        {
            s = (new StringBuilder("'")).append(s).append("'").toString();
        }
        throw new IllegalArgumentException((new StringBuilder("No Base64Variant with name ")).append(s).toString());
    }

    static 
    {
        MIME = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        MIME_NO_LINEFEEDS = new Base64Variant(MIME, "MIME-NO-LINEFEEDS", 0x7fffffff);
        PEM = new Base64Variant(MIME, "PEM", true, '=', 64);
        StringBuilder stringbuilder = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringbuilder.setCharAt(stringbuilder.indexOf("+"), '-');
        stringbuilder.setCharAt(stringbuilder.indexOf("/"), '_');
        MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", stringbuilder.toString(), false, '\0', 0x7fffffff);
    }
}
