// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.appevents:
//            AppEventsLogger

static class anonymousAppDeviceGUID
{

    public static final String ENCODED_EVENTS_KEY = "encoded_events";
    public static final String EVENT_COUNT_KEY = "event_count";
    public static final String NUM_SKIPPED_KEY = "num_skipped";
    private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
    private List accumulatedEvents;
    private String anonymousAppDeviceGUID;
    private AttributionIdentifiers attributionIdentifiers;
    private List inFlightEvents;
    private int numSkippedEventsDueToFullBuffer;
    private String packageName;

    private byte[] getStringAsByteArray(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utility.logd("Encoding exception: ", s);
            return null;
        }
        return s;
    }

    private void populateRequest(GraphRequest graphrequest, int i, JSONArray jsonarray, boolean flag)
    {
        JSONObject jsonobject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(com.facebook.internal.vityType.CUSTOM_APP_EVENTS, attributionIdentifiers, anonymousAppDeviceGUID, flag, AppEventsLogger.access$0());
        Object obj = jsonobject;
        if (numSkippedEventsDueToFullBuffer <= 0)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        jsonobject.put("num_skipped_events", i);
        obj = jsonobject;
_L2:
        graphrequest.setGraphObject(((JSONObject) (obj)));
        Bundle bundle = graphrequest.getParameters();
        obj = bundle;
        if (bundle == null)
        {
            obj = new Bundle();
        }
        jsonarray = jsonarray.toString();
        if (jsonarray != null)
        {
            ((Bundle) (obj)).putByteArray("custom_events_file", getStringAsByteArray(jsonarray));
            graphrequest.setTag(jsonarray);
        }
        graphrequest.setParameters(((Bundle) (obj)));
        return;
        JSONException jsonexception;
        jsonexception;
        jsonexception = new JSONObject();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void accumulatePersistedEvents(List list)
    {
        this;
        JVM INSTR monitorenter ;
        accumulatedEvents.addAll(list);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public void addEvent(accumulatedEvents accumulatedevents)
    {
        this;
        JVM INSTR monitorenter ;
        if (accumulatedEvents.size() + inFlightEvents.size() < 1000) goto _L2; else goto _L1
_L1:
        numSkippedEventsDueToFullBuffer = numSkippedEventsDueToFullBuffer + 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        accumulatedEvents.add(accumulatedevents);
        if (true) goto _L4; else goto _L3
_L3:
        accumulatedevents;
        throw accumulatedevents;
    }

    public void clearInFlightAndStats(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        accumulatedEvents.addAll(inFlightEvents);
        inFlightEvents.clear();
        numSkippedEventsDueToFullBuffer = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int getAccumulatedEventCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = accumulatedEvents.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public List getEventsToPersist()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        list = accumulatedEvents;
        accumulatedEvents = new ArrayList();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public int populateRequest(GraphRequest graphrequest, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        Iterator iterator;
        int i;
        i = numSkippedEventsDueToFullBuffer;
        inFlightEvents.addAll(accumulatedEvents);
        accumulatedEvents.clear();
        jsonarray = new JSONArray();
        iterator = inFlightEvents.iterator();
_L5:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() != 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        this;
        JVM INSTR monitorexit ;
        return 0;
_L2:
        accumulatedEvents accumulatedevents = (inFlightEvents)iterator.next();
        if (flag) goto _L4; else goto _L3
_L3:
        if (accumulatedevents.cit()) goto _L5; else goto _L4
_L4:
        jsonarray.put(accumulatedevents.ect());
          goto _L5
        graphrequest;
        this;
        JVM INSTR monitorexit ;
        throw graphrequest;
        this;
        JVM INSTR monitorexit ;
        populateRequest(graphrequest, i, jsonarray, flag1);
        return jsonarray.length();
    }

    public ityType(AttributionIdentifiers attributionidentifiers, String s, String s1)
    {
        accumulatedEvents = new ArrayList();
        inFlightEvents = new ArrayList();
        attributionIdentifiers = attributionidentifiers;
        packageName = s;
        anonymousAppDeviceGUID = s1;
    }
}
