// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class cec extends cdz
{

    private static final Set b = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat c = new DecimalFormat("#,###");
    private File d;
    private boolean e;

    public cec(ckw ckw1)
    {
        super(ckw1);
        ckw1 = ckw1.getContext().getCacheDir();
        if (ckw1 == null)
        {
            bka.e("Context.getCacheDir() returned null");
        } else
        {
            d = new File(ckw1, "admobVideoStreams");
            if (!d.isDirectory() && !d.mkdirs())
            {
                bka.e((new StringBuilder("Could not create preload cache directory at ")).append(d.getAbsolutePath()).toString());
                d = null;
                return;
            }
            if (!d.setReadable(true, false) || !d.setExecutable(true, false))
            {
                bka.e((new StringBuilder("Could not set cache file permissions at ")).append(d.getAbsolutePath()).toString());
                d = null;
                return;
            }
        }
    }

    private File a(File file)
    {
        return new File(d, (new StringBuilder()).append(file.getName()).append(".done").toString());
    }

    public final boolean a(String s)
    {
        Object obj1;
        File file2;
        String s2;
        if (d == null)
        {
            a(s, null, "noCacheDir", null);
            return false;
        }
        do
        {
            cax cax;
            int i;
            boolean flag;
            if (d == null)
            {
                i = 0;
            } else
            {
                File afile[] = d.listFiles();
                int k2 = afile.length;
                i = 0;
                int j1 = 0;
                while (j1 < k2) 
                {
                    int i2 = i;
                    if (!afile[j1].getName().endsWith(".done"))
                    {
                        i2 = i + 1;
                    }
                    j1++;
                    i = i2;
                }
            }
            cax = cbb.g;
            if (i <= ((Integer)bkv.n().a(cax)).intValue())
            {
                break;
            }
            if (d == null)
            {
                flag = false;
            } else
            {
                File file = null;
                long l3 = 0x7fffffffffffffffL;
                File afile1[] = d.listFiles();
                int k1 = afile1.length;
                for (int j = 0; j < k1; j++)
                {
                    File file1 = afile1[j];
                    if (file1.getName().endsWith(".done"))
                    {
                        continue;
                    }
                    long l5 = file1.lastModified();
                    if (l5 < l3)
                    {
                        file = file1;
                        l3 = l5;
                    }
                }

                flag = false;
                if (file != null)
                {
                    boolean flag1 = file.delete();
                    file = a(file);
                    flag = flag1;
                    if (file.isFile())
                    {
                        flag = flag1 & file.delete();
                    }
                }
            }
            if (!flag)
            {
                bka.e("Unable to expire stream cache");
                a(s, null, "expireFailed", null);
                return false;
            }
        } while (true);
        bfq.a();
        String s1 = bjz.a(s);
        file2 = new File(d, s1);
        obj1 = a(file2);
        if (file2.isFile() && ((File) (obj1)).isFile())
        {
            int k = (int)file2.length();
            bka.a((new StringBuilder("Stream cache hit at ")).append(s).toString());
            a(s, file2.getAbsolutePath(), k);
            return true;
        }
        s2 = (new StringBuilder()).append(d.getAbsolutePath()).append(s).toString();
        synchronized (b)
        {
            if (!b.contains(s2))
            {
                break MISSING_BLOCK_LABEL_439;
            }
            bka.e((new StringBuilder("Stream cache already in progress at ")).append(s).toString());
            a(s, file2.getAbsolutePath(), "inProgress", null);
        }
        return false;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        b.add(s2);
        set;
        JVM INSTR monitorexit ;
        Object obj3 = null;
        Object obj;
        obj = (new URL(s)).openConnection();
        cax cax1 = cbb.k;
        int l = ((Integer)bkv.n().a(cax1)).intValue();
        ((URLConnection) (obj)).setConnectTimeout(l);
        ((URLConnection) (obj)).setReadTimeout(l);
        if (!(obj instanceof HttpURLConnection)) goto _L2; else goto _L1
_L1:
        int i1 = ((HttpURLConnection)obj).getResponseCode();
        if (i1 < 400) goto _L2; else goto _L3
_L3:
        Object obj2;
        obj2 = "badUrl";
        Object obj4;
        Object obj5;
        cnp cnp1;
        Object obj6;
        Object obj7;
        int l1;
        int j2;
        int l2;
        long l4;
        long l6;
        try
        {
            obj1 = (new StringBuilder("HTTP request failed. Code: ")).append(Integer.toString(i1)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            throw new IOException((new StringBuilder("HTTP status code ")).append(i1).append(" at ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L8:
        try
        {
            ((FileOutputStream) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj4) { }
        // Misplaced declaration of an exception variable
        catch (Object obj4) { }
        if (e)
        {
            bka.c((new StringBuilder("Preload aborted for URL \"")).append(s).append("\"").toString());
        } else
        {
            bka.c((new StringBuilder("Preload failed for URL \"")).append(s).append("\"").toString(), ((Throwable) (obj)));
        }
        if (file2.exists() && !file2.delete())
        {
            bka.e((new StringBuilder("Could not delete partial cache file at ")).append(file2.getAbsolutePath()).toString());
        }
        a(s, file2.getAbsolutePath(), ((String) (obj2)), ((String) (obj1)));
        b.remove(s2);
        return false;
_L2:
        try
        {
            j2 = ((URLConnection) (obj)).getContentLength();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
            obj2 = "error";
            continue; /* Loop/switch isn't completed */
        }
        if (j2 >= 0)
        {
            break MISSING_BLOCK_LABEL_744;
        }
        bka.e((new StringBuilder("Stream cache aborted, missing content-length header at ")).append(s).toString());
        a(s, file2.getAbsolutePath(), "contentLengthMissing", null);
        b.remove(s2);
        return false;
        obj2 = c.format(j2);
        obj5 = cbb.h;
        l2 = ((Integer)bkv.n().a(((cax) (obj5)))).intValue();
        if (j2 <= l2)
        {
            break MISSING_BLOCK_LABEL_860;
        }
        bka.e((new StringBuilder("Content length ")).append(((String) (obj2))).append(" exceeds limit at ").append(s).toString());
        obj = (new StringBuilder("File too big for full file cache. Size: ")).append(((String) (obj2))).toString();
        a(s, file2.getAbsolutePath(), "sizeExceeded", ((String) (obj)));
        b.remove(s2);
        return false;
        bka.a((new StringBuilder("Caching ")).append(((String) (obj2))).append(" bytes from ").append(s).toString());
        obj2 = Channels.newChannel(((URLConnection) (obj)).getInputStream());
        obj = new FileOutputStream(file2);
        obj3 = ((FileOutputStream) (obj)).getChannel();
        obj5 = ByteBuffer.allocate(0x100000);
        cnp1 = bkv.i();
        i1 = 0;
        l4 = cnp1.a();
        obj6 = cbb.j;
        obj6 = new ckd(((Long)bkv.n().a(((cax) (obj6)))).longValue());
        obj7 = cbb.i;
        l6 = ((Long)bkv.n().a(((cax) (obj7)))).longValue();
_L5:
        l1 = ((ReadableByteChannel) (obj2)).read(((ByteBuffer) (obj5)));
        if (l1 < 0)
        {
            break MISSING_BLOCK_LABEL_1257;
        }
        l1 = i1 + l1;
        if (l1 > l2)
        {
            obj3 = "sizeExceeded";
            obj2 = obj3;
            try
            {
                obj1 = (new StringBuilder("File too big for full file cache. Size: ")).append(Integer.toString(l1)).toString();
            }
            catch (IOException ioexception)
            {
                obj1 = null;
                obj4 = obj;
                obj = ioexception;
                continue; /* Loop/switch isn't completed */
            }
            obj2 = obj3;
            try
            {
                throw new IOException("stream cache file size limit exceeded");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj5)
            {
                obj3 = obj;
            }
            obj = obj5;
            continue; /* Loop/switch isn't completed */
        }
        ((ByteBuffer) (obj5)).flip();
        while (((FileChannel) (obj3)).write(((ByteBuffer) (obj5))) > 0) ;
        ((ByteBuffer) (obj5)).clear();
        if (cnp1.a() - l4 <= 1000L * l6)
        {
            break MISSING_BLOCK_LABEL_1171;
        }
        obj3 = "downloadTimeout";
        obj2 = obj3;
        obj1 = (new StringBuilder("Timeout exceeded. Limit: ")).append(Long.toString(l6)).append(" sec").toString();
        obj2 = obj3;
        throw new IOException("stream cache time limit exceeded");
        if (e)
        {
            try
            {
                throw new IOException("abort requested");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                obj2 = "externalAbort";
            }
            obj3 = obj;
            obj5 = null;
            obj = obj1;
            obj1 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        i1 = l1;
        if (!((ckd) (obj6)).a()) goto _L5; else goto _L4
_L4:
        obj7 = file2.getAbsolutePath();
        bjz.a.post(new cdz._cls1(this, s, ((String) (obj7)), l1, j2));
        i1 = l1;
          goto _L5
        ((FileOutputStream) (obj)).close();
        if (bka.a(3))
        {
            obj2 = c.format(i1);
            bka.a((new StringBuilder("Preloaded ")).append(((String) (obj2))).append(" bytes from ").append(s).toString());
        }
        file2.setReadable(true, false);
        if (!((File) (obj1)).isFile())
        {
            break MISSING_BLOCK_LABEL_1358;
        }
        ((File) (obj1)).setLastModified(System.currentTimeMillis());
_L6:
        a(s, file2.getAbsolutePath(), i1);
        b.remove(s2);
        return true;
        try
        {
            ((File) (obj1)).createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L6
        IOException ioexception1;
        ioexception1;
        obj1 = null;
        obj2 = "error";
        obj4 = obj;
        obj = ioexception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void b()
    {
        e = true;
    }

}
