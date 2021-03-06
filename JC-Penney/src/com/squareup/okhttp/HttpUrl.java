// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import c.f;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class HttpUrl
{

    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    private static final char HEX_DIGITS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final String password;
    private final List pathSegments;
    private final int port;
    private final List queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    private HttpUrl(Builder builder)
    {
        Object obj1 = null;
        super();
        scheme = builder.scheme;
        username = percentDecode(builder.encodedUsername);
        password = percentDecode(builder.encodedPassword);
        host = builder.host;
        port = builder.effectivePort();
        pathSegments = percentDecode(builder.encodedPathSegments);
        Object obj;
        if (builder.encodedQueryNamesAndValues != null)
        {
            obj = percentDecode(builder.encodedQueryNamesAndValues);
        } else
        {
            obj = null;
        }
        queryNamesAndValues = ((List) (obj));
        obj = obj1;
        if (builder.encodedFragment != null)
        {
            obj = percentDecode(builder.encodedFragment);
        }
        fragment = ((String) (obj));
        url = builder.toString();
    }

    HttpUrl(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String canonicalize(String s, int i, int j, String s1, boolean flag, boolean flag1)
    {
        int l;
        for (int k = i; k < j; k += Character.charCount(l))
        {
            l = s.codePointAt(k);
            if (l < 32 || l >= 127 || s1.indexOf(l) != -1 || l == 37 && !flag || flag1 && l == 43)
            {
                f f1 = new f();
                f1.a(s, i, k);
                canonicalize(f1, s, k, j, s1, flag, flag1);
                return f1.q();
            }
        }

        return s.substring(i, j);
    }

    static String canonicalize(String s, String s1, boolean flag, boolean flag1)
    {
        return canonicalize(s, 0, s.length(), s1, flag, flag1);
    }

    static void canonicalize(f f1, String s, int i, int j, String s1, boolean flag, boolean flag1)
    {
        Object obj = null;
_L2:
        f f3;
        int k;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        k = s.codePointAt(i);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        f3 = obj;
        if (k != 9)
        {
            f3 = obj;
            if (k != 10)
            {
                f3 = obj;
                if (k != 12)
                {
                    if (k != 13)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    f3 = obj;
                }
            }
        }
_L3:
        i += Character.charCount(k);
        obj = f3;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (!flag1 || k != 43)
            {
                break label0;
            }
            String s2;
            if (flag)
            {
                s2 = "%20";
            } else
            {
                s2 = "%2B";
            }
            f1.a(s2);
            f3 = obj;
        }
          goto _L3
        f f2;
        if (k >= 32 && k < 127 && s1.indexOf(k) == -1 && (k != 37 || flag))
        {
            break MISSING_BLOCK_LABEL_247;
        }
        f2 = obj;
        if (obj == null)
        {
            f2 = new f();
        }
        f2.a(k);
_L5:
        f3 = f2;
        if (f2.f()) goto _L3; else goto _L4
_L4:
        int l = f2.i() & 0xff;
        f1.b(37);
        f1.b(HEX_DIGITS[l >> 4 & 0xf]);
        f1.b(HEX_DIGITS[l & 0xf]);
          goto _L5
        f1.a(k);
        f3 = obj;
          goto _L3
    }

    static int decodeHexDigit(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f')
        {
            return (c - 97) + 10;
        }
        if (c >= 'A' && c <= 'F')
        {
            return (c - 65) + 10;
        } else
        {
            return -1;
        }
    }

    public static int defaultPort(String s)
    {
        if (s.equals("http"))
        {
            return 80;
        }
        return !s.equals("https") ? -1 : 443;
    }

    private static int delimiterOffset(String s, int i, int j, String s1)
    {
        do
        {
label0:
            {
                int k = j;
                if (i < j)
                {
                    if (s1.indexOf(s.charAt(i)) == -1)
                    {
                        break label0;
                    }
                    k = i;
                }
                return k;
            }
            i++;
        } while (true);
    }

    public static HttpUrl get(URI uri1)
    {
        return parse(uri1.toString());
    }

    public static HttpUrl get(URL url1)
    {
        return parse(url1.toString());
    }

    static void namesAndValuesToQueryString(StringBuilder stringbuilder, List list)
    {
        int j = list.size();
        for (int i = 0; i < j; i += 2)
        {
            String s = (String)list.get(i);
            String s1 = (String)list.get(i + 1);
            if (i > 0)
            {
                stringbuilder.append('&');
            }
            stringbuilder.append(s);
            if (s1 != null)
            {
                stringbuilder.append('=');
                stringbuilder.append(s1);
            }
        }

    }

    public static HttpUrl parse(String s)
    {
        return (new Builder()).parse(null, s);
    }

    static void pathSegmentsToString(StringBuilder stringbuilder, List list)
    {
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append('/');
            stringbuilder.append((String)list.get(i));
        }

    }

    static String percentDecode(String s)
    {
        return percentDecode(s, 0, s.length());
    }

    static String percentDecode(String s, int i, int j)
    {
        for (int k = i; k < j; k++)
        {
            if (s.charAt(k) == '%')
            {
                f f1 = new f();
                f1.a(s, i, k);
                percentDecode(f1, s, k, j);
                return f1.q();
            }
        }

        return s.substring(i, j);
    }

    private List percentDecode(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (String)iterator.next();
            if (list != null)
            {
                list = percentDecode(((String) (list)));
            } else
            {
                list = null;
            }
            arraylist.add(list);
        }
        return Collections.unmodifiableList(arraylist);
    }

    static void percentDecode(f f1, String s, int i, int j)
    {
_L8:
        if (i >= j) goto _L2; else goto _L1
_L1:
        int k = s.codePointAt(i);
        if (k != 37 || i + 2 >= j) goto _L4; else goto _L3
_L3:
        int l;
        int i1;
        l = decodeHexDigit(s.charAt(i + 1));
        i1 = decodeHexDigit(s.charAt(i + 2));
        if (l == -1 || i1 == -1) goto _L4; else goto _L5
_L5:
        f1.b((l << 4) + i1);
        i += 2;
_L6:
        i += Character.charCount(k);
        continue; /* Loop/switch isn't completed */
_L4:
        f1.a(k);
        if (true) goto _L6; else goto _L2
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static List queryStringToNamesAndValues(String s)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i <= s.length()) 
        {
            int k = s.indexOf('&', i);
            int j = k;
            if (k == -1)
            {
                j = s.length();
            }
            k = s.indexOf('=', i);
            if (k == -1 || k > j)
            {
                arraylist.add(s.substring(i, j));
                arraylist.add(null);
            } else
            {
                arraylist.add(s.substring(i, k));
                arraylist.add(s.substring(k + 1, j));
            }
            i = j + 1;
        }
        return arraylist;
    }

    public String encodedFragment()
    {
        if (fragment == null)
        {
            return null;
        } else
        {
            int i = url.indexOf('#');
            return url.substring(i + 1);
        }
    }

    public String encodedPassword()
    {
        if (password.isEmpty())
        {
            return "";
        } else
        {
            int i = url.indexOf(':', scheme.length() + 3);
            int j = url.indexOf('@');
            return url.substring(i + 1, j);
        }
    }

    public String encodedPath()
    {
        int i = url.indexOf('/', scheme.length() + 3);
        int j = delimiterOffset(url, i, url.length(), "?#");
        return url.substring(i, j);
    }

    public List encodedPathSegments()
    {
        int i = url.indexOf('/', scheme.length() + 3);
        int j = delimiterOffset(url, i, url.length(), "?#");
        ArrayList arraylist = new ArrayList();
        while (i < j) 
        {
            int k = i + 1;
            i = delimiterOffset(url, k, j, "/");
            arraylist.add(url.substring(k, i));
        }
        return arraylist;
    }

    public String encodedQuery()
    {
        if (queryNamesAndValues == null)
        {
            return null;
        } else
        {
            int i = url.indexOf('?') + 1;
            int j = delimiterOffset(url, i + 1, url.length(), "#");
            return url.substring(i, j);
        }
    }

    public String encodedUsername()
    {
        if (username.isEmpty())
        {
            return "";
        } else
        {
            int i = scheme.length() + 3;
            int j = delimiterOffset(url, i, url.length(), ":@");
            return url.substring(i, j);
        }
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof HttpUrl) && ((HttpUrl)obj).url.equals(url);
    }

    public String fragment()
    {
        return fragment;
    }

    public int hashCode()
    {
        return url.hashCode();
    }

    public String host()
    {
        return host;
    }

    public boolean isHttps()
    {
        return scheme.equals("https");
    }

    public Builder newBuilder()
    {
        Builder builder = new Builder();
        builder.scheme = scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = host;
        if (port == defaultPort(scheme))
        {
            builder.port = -1;
        } else
        {
            builder.port = port;
        }
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public String password()
    {
        return password;
    }

    public List pathSegments()
    {
        return pathSegments;
    }

    public int pathSize()
    {
        return pathSegments.size();
    }

    public int port()
    {
        return port;
    }

    public String query()
    {
        if (queryNamesAndValues == null)
        {
            return null;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            namesAndValuesToQueryString(stringbuilder, queryNamesAndValues);
            return stringbuilder.toString();
        }
    }

    public String queryParameter(String s)
    {
        if (queryNamesAndValues != null)
        {
            int i = 0;
            int j = queryNamesAndValues.size();
            while (i < j) 
            {
                if (s.equals(queryNamesAndValues.get(i)))
                {
                    return (String)queryNamesAndValues.get(i + 1);
                }
                i += 2;
            }
        }
        return null;
    }

    public String queryParameterName(int i)
    {
        return (String)queryNamesAndValues.get(i * 2);
    }

    public Set queryParameterNames()
    {
        if (queryNamesAndValues == null)
        {
            return Collections.emptySet();
        }
        LinkedHashSet linkedhashset = new LinkedHashSet();
        int i = 0;
        for (int j = queryNamesAndValues.size(); i < j; i += 2)
        {
            linkedhashset.add(queryNamesAndValues.get(i));
        }

        return Collections.unmodifiableSet(linkedhashset);
    }

    public String queryParameterValue(int i)
    {
        return (String)queryNamesAndValues.get(i * 2 + 1);
    }

    public List queryParameterValues(String s)
    {
        if (queryNamesAndValues == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        for (int j = queryNamesAndValues.size(); i < j; i += 2)
        {
            if (s.equals(queryNamesAndValues.get(i)))
            {
                arraylist.add(queryNamesAndValues.get(i + 1));
            }
        }

        return Collections.unmodifiableList(arraylist);
    }

    public int querySize()
    {
        if (queryNamesAndValues != null)
        {
            return queryNamesAndValues.size() / 2;
        } else
        {
            return 0;
        }
    }

    public HttpUrl resolve(String s)
    {
        return (new Builder()).parse(this, s);
    }

    public String scheme()
    {
        return scheme;
    }

    public String toString()
    {
        return url;
    }

    public URI uri()
    {
        URI uri1;
        try
        {
            uri1 = new URI(url);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("not valid as a java.net.URI: ").append(url).toString());
        }
        return uri1;
    }

    public URL url()
    {
        URL url1;
        try
        {
            url1 = new URL(url);
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return url1;
    }

    public String username()
    {
        return username;
    }






    private class Builder
    {

        String encodedFragment;
        String encodedPassword;
        final List encodedPathSegments = new ArrayList();
        List encodedQueryNamesAndValues;
        String encodedUsername;
        String host;
        int port;
        String scheme;

        private static String canonicalizeHost(String s, int i, int j)
        {
            s = HttpUrl.percentDecode(s, i, j);
            if (!s.startsWith("[") || !s.endsWith("]")) goto _L2; else goto _L1
_L1:
            s = decodeIpv6(s, 1, s.length() - 1);
            if (s != null) goto _L4; else goto _L3
_L3:
            return null;
_L4:
            s = s.getAddress();
            if (s.length == 16)
            {
                return inet6AddressToAscii(s);
            } else
            {
                throw new AssertionError();
            }
_L2:
            s = domainToAscii(s);
            if (s != null)
            {
                i = s.length();
                if (HttpUrl.delimiterOffset(s, 0, i, "\000\t\n\r #%/:?@[\\]") == i)
                {
                    return s;
                }
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        private static boolean decodeIpv4Suffix(String s, int i, int j, byte abyte0[], int k)
        {
            int i1 = k;
            for (int l = i; l < j;)
            {
                if (i1 == abyte0.length)
                {
                    return false;
                }
                i = l;
                if (i1 != k)
                {
                    if (s.charAt(l) != '.')
                    {
                        return false;
                    }
                    i = l + 1;
                }
                int j1 = 0;
                l = i;
label0:
                do
                {
                    char c;
label1:
                    {
                        if (l < j)
                        {
                            c = s.charAt(l);
                            if (c >= '0' && c <= '9')
                            {
                                break label1;
                            }
                        }
                        if (l - i == 0)
                        {
                            return false;
                        }
                        break label0;
                    }
                    if (j1 == 0 && i != l)
                    {
                        return false;
                    }
                    j1 = (j1 * 10 + c) - 48;
                    if (j1 > 255)
                    {
                        return false;
                    }
                    l++;
                } while (true);
                abyte0[i1] = (byte)j1;
                i1++;
            }

            return i1 == k + 4;
        }

        private static InetAddress decodeIpv6(String s, int i, int j)
        {
            byte abyte0[];
            int k;
            int l;
            int i1;
            int l1;
            abyte0 = new byte[16];
            l1 = -1;
            l = -1;
            k = 0;
            i1 = i;
_L13:
            int j1;
            j1 = l;
            i = k;
            if (i1 >= j) goto _L2; else goto _L1
_L1:
            if (k == abyte0.length)
            {
                return null;
            }
            if (i1 + 2 > j || !s.regionMatches(i1, "::", 0, 2)) goto _L4; else goto _L3
_L3:
            if (l != -1)
            {
                return null;
            }
            i = i1 + 2;
            k += 2;
            if (i != j)
            {
                break MISSING_BLOCK_LABEL_360;
            }
            i = k;
            j1 = k;
              goto _L2
_L4:
            int k1;
            i = i1;
            j1 = l;
            k1 = k;
            if (k == 0) goto _L6; else goto _L5
_L5:
            if (!s.regionMatches(i1, ":", 0, 1)) goto _L8; else goto _L7
_L7:
            i = i1 + 1;
            k1 = k;
            j1 = l;
_L6:
            l = 0;
            k = i;
_L12:
            if (k >= j) goto _L10; else goto _L9
_L9:
            i1 = HttpUrl.decodeHexDigit(s.charAt(k));
            if (i1 != -1) goto _L11; else goto _L10
_L8:
            if (s.regionMatches(i1, ".", 0, 1))
            {
                if (!decodeIpv4Suffix(s, l1, j, abyte0, k - 2))
                {
                    return null;
                }
                i = k + 2;
                j1 = l;
            } else
            {
                return null;
            }
              goto _L2
_L11:
            l = (l << 4) + i1;
            k++;
              goto _L12
_L10:
            i1 = k - i;
            if (i1 == 0 || i1 > 4)
            {
                return null;
            }
            i1 = k1 + 1;
            abyte0[k1] = (byte)(l >>> 8 & 0xff);
            k1 = i1 + 1;
            abyte0[i1] = (byte)(l & 0xff);
            i1 = k;
            l = j1;
            k = k1;
            l1 = i;
              goto _L13
_L2:
            if (i != abyte0.length)
            {
                if (j1 == -1)
                {
                    return null;
                }
                System.arraycopy(abyte0, j1, abyte0, abyte0.length - (i - j1), i - j1);
                Arrays.fill(abyte0, j1, (abyte0.length - i) + j1, (byte)0);
            }
            try
            {
                s = InetAddress.getByAddress(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new AssertionError();
            }
            return s;
            k1 = k;
            j1 = k;
              goto _L6
        }

        private static String domainToAscii(String s)
        {
            boolean flag;
            try
            {
                s = IDN.toASCII(s).toLowerCase(Locale.US);
                flag = s.isEmpty();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            if (flag)
            {
                return null;
            } else
            {
                return s;
            }
        }

        private static String inet6AddressToAscii(byte abyte0[])
        {
            boolean flag = false;
            int k = 0;
            int l = -1;
            for (int i = 0; i < abyte0.length;)
            {
                int i1;
                for (i1 = i; i1 < 16 && abyte0[i1] == 0 && abyte0[i1 + 1] == 0; i1 += 2) { }
                int l1 = i1 - i;
                int k1 = k;
                if (l1 > k)
                {
                    k1 = l1;
                    l = i;
                }
                i = i1 + 2;
                k = k1;
            }

            f f1 = new f();
            int j = ((flag) ? 1 : 0);
            do
            {
                if (j >= abyte0.length)
                {
                    break;
                }
                if (j == l)
                {
                    f1.b(58);
                    int j1 = j + k;
                    j = j1;
                    if (j1 == 16)
                    {
                        f1.b(58);
                        j = j1;
                    }
                } else
                {
                    if (j > 0)
                    {
                        f1.b(58);
                    }
                    f1.i((abyte0[j] & 0xff) << 8 | abyte0[j + 1] & 0xff);
                    j += 2;
                }
            } while (true);
            return f1.q();
        }

        private boolean isDot(String s)
        {
            return s.equals(".") || s.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String s)
        {
            return s.equals("..") || s.equalsIgnoreCase("%2e.") || s.equalsIgnoreCase(".%2e") || s.equalsIgnoreCase("%2e%2e");
        }

        private static int parsePort(String s, int i, int j)
        {
            try
            {
                i = Integer.parseInt(HttpUrl.canonicalize(s, i, j, "", false, false));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return -1;
            }
            if (i > 0 && i <= 65535)
            {
                return i;
            } else
            {
                return -1;
            }
        }

        private void pop()
        {
            if (((String)encodedPathSegments.remove(encodedPathSegments.size() - 1)).isEmpty() && !encodedPathSegments.isEmpty())
            {
                encodedPathSegments.set(encodedPathSegments.size() - 1, "");
                return;
            } else
            {
                encodedPathSegments.add("");
                return;
            }
        }

        private static int portColonOffset(String s, int i, int j)
        {
_L6:
            if (i >= j) goto _L2; else goto _L1
_L1:
            int k;
            int l;
            k = i;
            l = i;
            s.charAt(i);
            JVM INSTR lookupswitch 2: default 40
        //                       58: 80
        //                       91: 49;
               goto _L3 _L4 _L5
_L3:
            k = i;
_L8:
            i = k + 1;
              goto _L6
_L5:
            i = k + 1;
            k = i;
            if (i >= j) goto _L8; else goto _L7
_L7:
            k = i;
            if (s.charAt(i) != ']') goto _L5; else goto _L9
_L9:
            k = i;
              goto _L8
_L2:
            l = j;
_L4:
            return l;
        }

        private void push(String s, int i, int j, boolean flag, boolean flag1)
        {
            s = HttpUrl.canonicalize(s, i, j, " \"<>^`{}|/\\?#", flag1, false);
            if (!isDot(s))
            {
                if (isDotDot(s))
                {
                    pop();
                    return;
                }
                if (((String)encodedPathSegments.get(encodedPathSegments.size() - 1)).isEmpty())
                {
                    encodedPathSegments.set(encodedPathSegments.size() - 1, s);
                } else
                {
                    encodedPathSegments.add(s);
                }
                if (flag)
                {
                    encodedPathSegments.add("");
                    return;
                }
            }
        }

        private void removeAllCanonicalQueryParameters(String s)
        {
            int i = encodedQueryNamesAndValues.size() - 2;
            do
            {
label0:
                {
                    if (i >= 0)
                    {
                        if (!s.equals(encodedQueryNamesAndValues.get(i)))
                        {
                            break label0;
                        }
                        encodedQueryNamesAndValues.remove(i + 1);
                        encodedQueryNamesAndValues.remove(i);
                        if (!encodedQueryNamesAndValues.isEmpty())
                        {
                            break label0;
                        }
                        encodedQueryNamesAndValues = null;
                    }
                    return;
                }
                i -= 2;
            } while (true);
        }

        private void resolvePath(String s, int i, int j)
        {
            if (i != j)
            {
                char c = s.charAt(i);
                if (c == '/' || c == '\\')
                {
                    encodedPathSegments.clear();
                    encodedPathSegments.add("");
                    i++;
                } else
                {
                    encodedPathSegments.set(encodedPathSegments.size() - 1, "");
                }
                while (i < j) 
                {
                    int k = HttpUrl.delimiterOffset(s, i, j, "/\\");
                    boolean flag;
                    if (k < j)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    push(s, i, k, flag, true);
                    i = k;
                    if (flag)
                    {
                        i = k + 1;
                    }
                }
            }
        }

        private static int schemeDelimiterOffset(String s, int i, int j)
        {
            if (j - i >= 2) goto _L2; else goto _L1
_L1:
            char c;
            return -1;
_L2:
            if ((c = s.charAt(i)) >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            {
                i++;
                while (i < j) 
                {
                    c = s.charAt(i);
                    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != '+' && c != '-' && c != '.')
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    i++;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
            if (c != ':') goto _L1; else goto _L4
_L4:
            return i;
        }

        private int skipLeadingAsciiWhitespace(String s, int i, int j)
        {
            do
            {
label0:
                {
                    int k = j;
                    if (i < j)
                    {
                        switch (s.charAt(i))
                        {
                        default:
                            k = i;
                            break;

                        case 9: // '\t'
                        case 10: // '\n'
                        case 12: // '\f'
                        case 13: // '\r'
                        case 32: // ' '
                            break label0;
                        }
                    }
                    return k;
                }
                i++;
            } while (true);
        }

        private int skipTrailingAsciiWhitespace(String s, int i, int j)
        {
            j--;
            do
            {
label0:
                {
                    int k = i;
                    if (j >= i)
                    {
                        switch (s.charAt(j))
                        {
                        default:
                            k = j + 1;
                            break;

                        case 9: // '\t'
                        case 10: // '\n'
                        case 12: // '\f'
                        case 13: // '\r'
                        case 32: // ' '
                            break label0;
                        }
                    }
                    return k;
                }
                j--;
            } while (true);
        }

        private static int slashCount(String s, int i, int j)
        {
            int k = 0;
            do
            {
                if (i >= j)
                {
                    break;
                }
                char c = s.charAt(i);
                if (c != '\\' && c != '/')
                {
                    break;
                }
                k++;
                i++;
            } while (true);
            return k;
        }

        public Builder addEncodedPathSegment(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedPathSegment == null");
            } else
            {
                push(s, 0, s.length(), false, true);
                return this;
            }
        }

        public Builder addEncodedQueryParameter(String s, String s1)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (encodedQueryNamesAndValues == null)
            {
                encodedQueryNamesAndValues = new ArrayList();
            }
            encodedQueryNamesAndValues.add(HttpUrl.canonicalize(s, " \"'<>#&=", true, true));
            List list = encodedQueryNamesAndValues;
            if (s1 != null)
            {
                s = HttpUrl.canonicalize(s1, " \"'<>#&=", true, true);
            } else
            {
                s = null;
            }
            list.add(s);
            return this;
        }

        public Builder addPathSegment(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("pathSegment == null");
            } else
            {
                push(s, 0, s.length(), false, false);
                return this;
            }
        }

        public Builder addQueryParameter(String s, String s1)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("name == null");
            }
            if (encodedQueryNamesAndValues == null)
            {
                encodedQueryNamesAndValues = new ArrayList();
            }
            encodedQueryNamesAndValues.add(HttpUrl.canonicalize(s, " \"'<>#&=", false, true));
            List list = encodedQueryNamesAndValues;
            if (s1 != null)
            {
                s = HttpUrl.canonicalize(s1, " \"'<>#&=", false, true);
            } else
            {
                s = null;
            }
            list.add(s);
            return this;
        }

        public HttpUrl build()
        {
            if (scheme == null)
            {
                throw new IllegalStateException("scheme == null");
            }
            if (host == null)
            {
                throw new IllegalStateException("host == null");
            } else
            {
                return new HttpUrl(this, null);
            }
        }

        int effectivePort()
        {
            if (port != -1)
            {
                return port;
            } else
            {
                return HttpUrl.defaultPort(scheme);
            }
        }

        public Builder encodedFragment(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedFragment == null");
            } else
            {
                encodedFragment = HttpUrl.canonicalize(s, "", true, false);
                return this;
            }
        }

        public Builder encodedPassword(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedPassword == null");
            } else
            {
                encodedPassword = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", true, false);
                return this;
            }
        }

        public Builder encodedPath(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedPath == null");
            }
            if (!s.startsWith("/"))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("unexpected encodedPath: ").append(s).toString());
            } else
            {
                resolvePath(s, 0, s.length());
                return this;
            }
        }

        public Builder encodedQuery(String s)
        {
            if (s != null)
            {
                s = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(s, " \"'<>#", true, true));
            } else
            {
                s = null;
            }
            encodedQueryNamesAndValues = s;
            return this;
        }

        public Builder encodedUsername(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedUsername == null");
            } else
            {
                encodedUsername = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", true, false);
                return this;
            }
        }

        public Builder fragment(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("fragment == null");
            } else
            {
                encodedFragment = HttpUrl.canonicalize(s, "", false, false);
                return this;
            }
        }

        public Builder host(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("host == null");
            }
            String s1 = canonicalizeHost(s, 0, s.length());
            if (s1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("unexpected host: ").append(s).toString());
            } else
            {
                host = s1;
                return this;
            }
        }

        HttpUrl parse(HttpUrl httpurl, String s)
        {
            int i;
            boolean flag;
            int k;
            int l1;
            int i2;
            i = skipLeadingAsciiWhitespace(s, 0, s.length());
            i2 = skipTrailingAsciiWhitespace(s, i, s.length());
            int l;
            if (schemeDelimiterOffset(s, i, i2) != -1)
            {
                if (s.regionMatches(true, i, "https:", 0, 6))
                {
                    scheme = "https";
                    i += "https:".length();
                } else
                if (s.regionMatches(true, i, "http:", 0, 5))
                {
                    scheme = "http";
                    i += "http:".length();
                } else
                {
                    return null;
                }
            } else
            if (httpurl != null)
            {
                scheme = httpurl.scheme;
            } else
            {
                return null;
            }
            l = slashCount(s, i, i2);
            if (l < 2 && httpurl != null && httpurl.scheme.equals(scheme)) goto _L2; else goto _L1
_L1:
            k = 0;
            flag = false;
            l = i + l;
            i = k;
            k = l;
_L3:
            l1 = HttpUrl.delimiterOffset(s, k, i2, "@/\\?#");
            int i1;
            if (l1 != i2)
            {
                i1 = s.charAt(l1);
            } else
            {
                i1 = -1;
            }
            switch (i1)
            {
            default:
                i1 = i;
                i = k;
                k = i1;
                break;

            case -1: 
            case 35: // '#'
            case 47: // '/'
            case 63: // '?'
            case 92: // '\\'
                break MISSING_BLOCK_LABEL_470;

            case 64: // '@'
                break MISSING_BLOCK_LABEL_304;
            }
_L4:
            i1 = k;
            k = i;
            i = i1;
              goto _L3
            int k1;
            if (i == 0)
            {
                int j1 = HttpUrl.delimiterOffset(s, k, l1, ":");
                String s1 = HttpUrl.canonicalize(s, k, j1, " \"':;<=>@[]^`{}|/\\?#", true, false);
                httpurl = s1;
                if (flag)
                {
                    httpurl = (new StringBuilder()).append(encodedUsername).append("%40").append(s1).toString();
                }
                encodedUsername = httpurl;
                if (j1 != l1)
                {
                    i = 1;
                    encodedPassword = HttpUrl.canonicalize(s, j1 + 1, l1, " \"':;<=>@[]^`{}|/\\?#", true, false);
                }
                flag = true;
            } else
            {
                encodedPassword = (new StringBuilder()).append(encodedPassword).append("%40").append(HttpUrl.canonicalize(s, k, l1, " \"':;<=>@[]^`{}|/\\?#", true, false)).toString();
            }
            k1 = l1 + 1;
            k = i;
            i = k1;
              goto _L4
            int j;
            i = portColonOffset(s, k, l1);
            if (i + 1 < l1)
            {
                host = canonicalizeHost(s, k, i);
                port = parsePort(s, i + 1, l1);
                if (port == -1)
                {
                    return null;
                }
            } else
            {
                host = canonicalizeHost(s, k, i);
                port = HttpUrl.defaultPort(scheme);
            }
            if (host == null)
            {
                return null;
            }
            j = l1;
_L6:
            i = HttpUrl.delimiterOffset(s, j, i2, "?#");
            resolvePath(s, j, i);
            if (i < i2 && s.charAt(i) == '?')
            {
                j = HttpUrl.delimiterOffset(s, i, i2, "#");
                encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(s, i + 1, j, " \"'<>#", true, true));
                i = j;
            }
            if (i < i2 && s.charAt(i) == '#')
            {
                encodedFragment = HttpUrl.canonicalize(s, i + 1, i2, "", true, false);
            }
            return build();
_L2:
            encodedUsername = httpurl.encodedUsername();
            encodedPassword = httpurl.encodedPassword();
            host = httpurl.host;
            port = httpurl.port;
            encodedPathSegments.clear();
            encodedPathSegments.addAll(httpurl.encodedPathSegments());
            if (i != i2)
            {
                j = i;
                if (s.charAt(i) != '#')
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            encodedQuery(httpurl.encodedQuery());
            j = i;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public Builder password(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("password == null");
            } else
            {
                encodedPassword = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", false, false);
                return this;
            }
        }

        public Builder port(int i)
        {
            if (i <= 0 || i > 65535)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("unexpected port: ").append(i).toString());
            } else
            {
                port = i;
                return this;
            }
        }

        public Builder query(String s)
        {
            if (s != null)
            {
                s = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(s, " \"'<>#", false, true));
            } else
            {
                s = null;
            }
            encodedQueryNamesAndValues = s;
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (encodedQueryNamesAndValues == null)
            {
                return this;
            } else
            {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(s, " \"'<>#&=", true, true));
                return this;
            }
        }

        public Builder removeAllQueryParameters(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("name == null");
            }
            if (encodedQueryNamesAndValues == null)
            {
                return this;
            } else
            {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(s, " \"'<>#&=", false, true));
                return this;
            }
        }

        public Builder removePathSegment(int i)
        {
            encodedPathSegments.remove(i);
            if (encodedPathSegments.isEmpty())
            {
                encodedPathSegments.add("");
            }
            return this;
        }

        public Builder scheme(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("scheme == null");
            }
            if (s.equalsIgnoreCase("http"))
            {
                scheme = "http";
                return this;
            }
            if (s.equalsIgnoreCase("https"))
            {
                scheme = "https";
                return this;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("unexpected scheme: ").append(s).toString());
            }
        }

        public Builder setEncodedPathSegment(int i, String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            String s1 = HttpUrl.canonicalize(s, 0, s.length(), " \"<>^`{}|/\\?#", true, false);
            encodedPathSegments.set(i, s1);
            if (isDot(s1) || isDotDot(s1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("unexpected path segment: ").append(s).toString());
            } else
            {
                return this;
            }
        }

        public Builder setEncodedQueryParameter(String s, String s1)
        {
            removeAllEncodedQueryParameters(s);
            addEncodedQueryParameter(s, s1);
            return this;
        }

        public Builder setPathSegment(int i, String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("pathSegment == null");
            }
            String s1 = HttpUrl.canonicalize(s, 0, s.length(), " \"<>^`{}|/\\?#", false, false);
            if (isDot(s1) || isDotDot(s1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("unexpected path segment: ").append(s).toString());
            } else
            {
                encodedPathSegments.set(i, s1);
                return this;
            }
        }

        public Builder setQueryParameter(String s, String s1)
        {
            removeAllQueryParameters(s);
            addQueryParameter(s, s1);
            return this;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(scheme);
            stringbuilder.append("://");
            if (!encodedUsername.isEmpty() || !encodedPassword.isEmpty())
            {
                stringbuilder.append(encodedUsername);
                if (!encodedPassword.isEmpty())
                {
                    stringbuilder.append(':');
                    stringbuilder.append(encodedPassword);
                }
                stringbuilder.append('@');
            }
            int i;
            if (host.indexOf(':') != -1)
            {
                stringbuilder.append('[');
                stringbuilder.append(host);
                stringbuilder.append(']');
            } else
            {
                stringbuilder.append(host);
            }
            i = effectivePort();
            if (i != HttpUrl.defaultPort(scheme))
            {
                stringbuilder.append(':');
                stringbuilder.append(i);
            }
            HttpUrl.pathSegmentsToString(stringbuilder, encodedPathSegments);
            if (encodedQueryNamesAndValues != null)
            {
                stringbuilder.append('?');
                HttpUrl.namesAndValuesToQueryString(stringbuilder, encodedQueryNamesAndValues);
            }
            if (encodedFragment != null)
            {
                stringbuilder.append('#');
                stringbuilder.append(encodedFragment);
            }
            return stringbuilder.toString();
        }

        public Builder username(String s)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("username == null");
            } else
            {
                encodedUsername = HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#", false, false);
                return this;
            }
        }

        public Builder()
        {
            encodedUsername = "";
            encodedPassword = "";
            port = -1;
            encodedPathSegments.add("");
        }
    }

}
