// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;


// Referenced classes of package com.whatsapp:
//            GroupChatInfo

class aok
    implements Runnable
{

    final GroupChatInfo a;

    aok(GroupChatInfo groupchatinfo)
    {
        a = groupchatinfo;
        super();
    }

    public void run()
    {
        a.c();
    }
}
