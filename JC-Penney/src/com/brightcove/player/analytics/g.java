// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightcove.player.analytics;

import com.brightcove.player.event.Event;
import com.brightcove.player.event.EventListener;
import java.util.Map;

// Referenced classes of package com.brightcove.player.analytics:
//            Analytics

class g
    implements EventListener
{

    final Analytics a;

    g(Analytics analytics)
    {
        a = analytics;
        super();
    }

    public void processEvent(Event event)
    {
        int i = ((Integer)event.properties.get("duration")).intValue();
        if (i > 0)
        {
            Analytics.a(a, i);
        }
    }
}
