// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.service.browse;

import android.os.Handler;
import com.netflix.mediaclient.servicemgr.VideoList;

// Referenced classes of package com.netflix.mediaclient.service.browse:
//            BrowseAgent, BrowseAgentCallback, SimpleBrowseAgentCallback

class val.statusCode
    implements Runnable
{

    final val.statusCode this$2;
    final int val$statusCode;
    final VideoList val$videoList;

    public void run()
    {
        allback().onSimilarVideosFetched(val$videoList, val$statusCode);
    }

    is._cls1()
    {
        this$2 = final__pcls1;
        val$videoList = videolist;
        val$statusCode = I.this;
        super();
    }

    // Unreferenced inner class com/netflix/mediaclient/service/browse/BrowseAgent$FetchSimilarVideosForPersonTask$1

/* anonymous class */
    class BrowseAgent.FetchSimilarVideosForPersonTask._cls1 extends SimpleBrowseAgentCallback
    {

        final BrowseAgent.FetchSimilarVideosForPersonTask this$1;

        public void onSimilarVideosFetched(final VideoList videoList, int i)
        {
            updateCacheIfNecessary(videoList, i);
            BrowseAgent.access$5200(this$0).post(i. new BrowseAgent.FetchSimilarVideosForPersonTask._cls1._cls1());
        }

            
            {
                this$1 = BrowseAgent.FetchSimilarVideosForPersonTask.this;
                super();
            }
    }

}
