// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.service.logging.uiaction;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.uiaction.model.RemoveFromPlaylistEndedEvent;

// Referenced classes of package com.netflix.mediaclient.service.logging.uiaction:
//            BaseUIActionSession

public final class RemoveFromPlaylistSession extends BaseUIActionSession
{

    public static final String NAME = "removeFromPlaylist";

    public RemoveFromPlaylistSession(com.netflix.mediaclient.servicemgr.UserActionLogging.CommandName commandname, com.netflix.mediaclient.servicemgr.IClientLogging.ModalView modalview)
    {
        super(commandname, modalview);
    }

    public RemoveFromPlaylistEndedEvent createEndedEvent(com.netflix.mediaclient.servicemgr.IClientLogging.CompletionReason completionreason, UIError uierror)
    {
        long l = System.currentTimeMillis();
        long l1 = mStarted;
        completionreason = new RemoveFromPlaylistEndedEvent(mId, l - l1, mView, mAction, completionreason, uierror);
        completionreason.setCategory(getCategory());
        completionreason.setSessionId(mId);
        return completionreason;
    }

    public String getName()
    {
        return "removeFromPlaylist";
    }
}
