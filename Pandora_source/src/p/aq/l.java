// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package p.aq;


// Referenced classes of package p.aq:
//            b

class l
    implements Runnable
{

    final String a;
    final b b;

    l(b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }

    public void run()
    {
        p.aq.b.b(b, a);
    }
}
