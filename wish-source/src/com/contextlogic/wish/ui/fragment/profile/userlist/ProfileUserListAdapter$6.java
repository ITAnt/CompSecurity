// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.fragment.profile.userlist;


// Referenced classes of package com.contextlogic.wish.ui.fragment.profile.userlist:
//            ProfileUserListAdapter

class this._cls0
    implements com.contextlogic.wish.api.service.k
{

    final ProfileUserListAdapter this$0;

    public void onServiceFailed()
    {
        refreshFollowButtonStates();
    }

    Q()
    {
        this$0 = ProfileUserListAdapter.this;
        super();
    }
}
