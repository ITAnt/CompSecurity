// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.FilterInputStream;
import java.io.InputStream;

final class cow extends FilterInputStream
{

    private int a;

    private cow(InputStream inputstream)
    {
        super(inputstream);
        a = 0;
    }

    cow(InputStream inputstream, byte byte0)
    {
        this(inputstream);
    }

    static int a(cow cow1)
    {
        return cow1.a;
    }

    public final int read()
    {
        int i = super.read();
        if (i != -1)
        {
            a = a + 1;
        }
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        i = super.read(abyte0, i, j);
        if (i != -1)
        {
            a = a + i;
        }
        return i;
    }
}
