// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.android.gms.tagmanager:
//            ar, bh, at, cx

class as extends Thread
    implements ar
{

    private static as afF;
    private final LinkedBlockingQueue afE = new LinkedBlockingQueue();
    private volatile at afG;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean uI;

    private as(Context context)
    {
        super("GAThread");
        uI = false;
        mClosed = false;
        if (context != null)
        {
            mContext = context.getApplicationContext();
        } else
        {
            mContext = context;
        }
        start();
    }

    static as M(Context context)
    {
        if (afF == null)
        {
            afF = new as(context);
        }
        return afF;
    }

    static at a(as as1)
    {
        return as1.afG;
    }

    static at a(as as1, at at)
    {
        as1.afG = at;
        return at;
    }

    private String a(Throwable throwable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        printstream.flush();
        return new String(bytearrayoutputstream.toByteArray());
    }

    static Context b(as as1)
    {
        return as1.mContext;
    }

    public void a(Runnable runnable)
    {
        afE.add(runnable);
    }

    void b(String s, long l)
    {
        a(new Runnable(this, l, s) {

            final ar afH;
            final long afI;
            final String afJ;
            final as afK;

            public void run()
            {
                if (as.a(afK) == null)
                {
                    cx cx1 = cx.mL();
                    cx1.a(as.b(afK), afH);
                    as.a(afK, cx1.mM());
                }
                as.a(afK).f(afI, afJ);
            }

            
            {
                afK = as.this;
                afH = ar1;
                afI = l;
                afJ = s;
                super();
            }
        });
    }

    public void bU(String s)
    {
        b(s, System.currentTimeMillis());
    }

    public void run()
    {
_L2:
        if (mClosed)
        {
            break; /* Loop/switch isn't completed */
        }
        Runnable runnable = (Runnable)afE.take();
        if (!uI)
        {
            runnable.run();
        }
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        try
        {
            bh.B(interruptedexception.toString());
        }
        catch (Throwable throwable)
        {
            bh.A((new StringBuilder()).append("Error on GAThread: ").append(a(throwable)).toString());
            bh.A("Google Analytics is shutting down.");
            uI = true;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
