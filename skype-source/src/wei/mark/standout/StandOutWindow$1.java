// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wei.mark.standout;


// Referenced classes of package wei.mark.standout:
//            StandOutWindow

final class a
    implements Runnable
{

    final StandOutWindow a;

    public final void run()
    {
        a.closeAll();
    }

    (StandOutWindow standoutwindow)
    {
        a = standoutwindow;
        super();
    }
}
