// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import java.io.File;

// Referenced classes of package bo.app:
//            hz, if

public abstract class hy
    implements hz
{

    protected File a;
    private if b;

    public hy(File file, if if1)
    {
        if (file == null)
        {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[] {
                "cacheDir"
            }));
        }
        if (if1 == null)
        {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[] {
                "fileNameGenerator"
            }));
        } else
        {
            a = file;
            b = if1;
            return;
        }
    }

    public File a(String s)
    {
        s = b.a(s);
        return new File(a, s);
    }
}
