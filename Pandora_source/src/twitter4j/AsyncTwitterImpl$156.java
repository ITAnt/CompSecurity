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
    final String val$oauthVerifier;

    public void invoke(List list)
        throws TwitterException
    {
        twitter4j.auth.AccessToken accesstoken = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).getOAuthAccessToken(val$oauthVerifier);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.gotOAuthAccessToken(accesstoken);
            }
            catch (Exception exception) { }
        }

    }

    cTask(List list, String s)
    {
        this$0 = final_asynctwitterimpl;
        val$oauthVerifier = s;
        super(final_asynctwitterimpl, TwitterMethod.this, list);
    }
}
