// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import bde;
import bdn;
import bdo;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource
    implements bdo
{

    private final bdn a;
    private RandomAccessFile b;
    private String c;
    private long d;
    private boolean e;

    public FileDataSource()
    {
        this(null);
    }

    public FileDataSource(bdn bdn1)
    {
        a = bdn1;
    }

    public final int a(byte abyte0[], int i, int j)
    {
        if (d == 0L)
        {
            i = -1;
        } else
        {
            try
            {
                j = b.read(abyte0, i, (int)Math.min(d, j));
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new FileDataSourceException(abyte0);
            }
            i = j;
            if (j > 0)
            {
                d = d - (long)j;
                i = j;
                if (a != null)
                {
                    a.a(j);
                    return j;
                }
            }
        }
        return i;
    }

    public final long a(bde bde1)
    {
        long l;
        c = bde1.a.toString();
        b = new RandomAccessFile(bde1.a.getPath(), "r");
        b.seek(bde1.c);
        if (bde1.d != -1L)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        l = b.length() - bde1.c;
_L1:
        d = l;
        if (d < 0L)
        {
            throw new EOFException();
        }
        break MISSING_BLOCK_LABEL_106;
        try
        {
            l = bde1.d;
        }
        // Misplaced declaration of an exception variable
        catch (bde bde1)
        {
            throw new FileDataSourceException(bde1);
        }
          goto _L1
        e = true;
        if (a != null)
        {
            a.b();
        }
        return d;
    }

    public final String a()
    {
        return c;
    }

    public final void b()
    {
        c = null;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        b.close();
        b = null;
        if (e)
        {
            e = false;
            if (a != null)
            {
                a.c();
            }
        }
        return;
        Object obj;
        obj;
        throw new FileDataSourceException(((IOException) (obj)));
        obj;
        b = null;
        if (e)
        {
            e = false;
            if (a != null)
            {
                a.c();
            }
        }
        throw obj;
    }

    private class FileDataSourceException extends IOException
    {

        public FileDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }
    }

}
