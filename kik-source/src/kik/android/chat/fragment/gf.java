// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.chat.fragment;


// Referenced classes of package kik.android.chat.fragment:
//            ge, KikChatFragment

final class gf
    implements Runnable
{

    final ge a;

    gf(ge ge1)
    {
        a = ge1;
        super();
    }

    public final void run()
    {
        KikChatFragment.k(a.a, false);
    }
}
