// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, TwitterException, Twitter, TwitterListener, 
//            TwitterMethod

class cTask extends cTask
{

    final AsyncTwitterImpl this$0;
    final boolean val$isPublicList;
    final long val$listId;
    final String val$newDescription;
    final String val$newListName;

    public void invoke(List list)
        throws TwitterException
    {
        UserList userlist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).updateUserList(val$listId, val$newListName, val$isPublicList, val$newDescription);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.updatedUserList(userlist);
            }
            catch (Exception exception) { }
        }

    }

    cTask(boolean flag, 
            String s1)
    {
        this$0 = final_asynctwitterimpl;
        val$listId = l;
        val$newListName = String.this;
        val$isPublicList = flag;
        val$newDescription = s1;
        super(final_asynctwitterimpl, final_twittermethod, final_list);
    }
}
