// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.realtime.network;

import android.os.Message;

// Referenced classes of package com.google.android.gms.games.realtime.network:
//            PeerStateMachine

private final class jid extends jid
{

    public final String jid;
    final PeerStateMachine this$0;

    public final void dispatch()
    {
        dispatchMessageByJid(jid, msg);
    }

    public (Message message, String s)
    {
        this$0 = PeerStateMachine.this;
        super(PeerStateMachine.this, message);
        jid = s;
    }
}
