// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.facebook:
//            AppEventsLogger, FacebookTimeSpentData, LoggingBehavior

static class _cls1
{

    private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
    private static final Runnable appSessionInfoFlushRunnable = new Runnable() {

        public void run()
        {
            AppEventsLogger.PersistedAppSessionInfo.saveAppSessionInformation(AppEventsLogger.access$0());
        }

    };
    private static Map appSessionInfoMap;
    private static boolean hasChanges = false;
    private static boolean isLoaded = false;
    private static final Object staticLock = new Object();

    private static FacebookTimeSpentData getTimeSpentData(Context context, _cls1 _pcls1)
    {
        restoreAppSessionInformation(context);
        FacebookTimeSpentData facebooktimespentdata = (FacebookTimeSpentData)appSessionInfoMap.get(_pcls1);
        context = facebooktimespentdata;
        if (facebooktimespentdata == null)
        {
            context = new FacebookTimeSpentData();
            appSessionInfoMap.put(_pcls1, context);
        }
        return context;
    }

    static void onResume(Context context, appSessionInfoMap appsessioninfomap, AppEventsLogger appeventslogger, long l, String s)
    {
        synchronized (staticLock)
        {
            getTimeSpentData(context, appsessioninfomap).onResume(appeventslogger, l, s);
            onTimeSpentDataUpdate();
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void onSuspend(Context context, onTimeSpentDataUpdate ontimespentdataupdate, AppEventsLogger appeventslogger, long l)
    {
        synchronized (staticLock)
        {
            getTimeSpentData(context, ontimespentdataupdate).onSuspend(appeventslogger, l);
            onTimeSpentDataUpdate();
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void onTimeSpentDataUpdate()
    {
        if (!hasChanges)
        {
            hasChanges = true;
            AppEventsLogger.access$2().schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
        }
    }

    private static void restoreAppSessionInformation(Context context)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        obj3 = null;
        obj1 = null;
        obj2 = null;
        Object obj4 = staticLock;
        obj4;
        JVM INSTR monitorenter ;
        boolean flag = isLoaded;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Object obj = new ObjectInputStream(context.openFileInput("AppEventsLogger.persistedsessioninfo"));
        appSessionInfoMap = (HashMap)((ObjectInputStream) (obj)).readObject();
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info loaded");
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (appSessionInfoMap == null)
        {
            appSessionInfoMap = new HashMap();
        }
        isLoaded = true;
        hasChanges = false;
_L1:
        obj4;
        JVM INSTR monitorexit ;
        return;
_L5:
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (appSessionInfoMap == null)
        {
            appSessionInfoMap = new HashMap();
        }
        isLoaded = true;
        hasChanges = false;
          goto _L1
_L2:
        obj4;
        JVM INSTR monitorexit ;
        throw context;
        obj2;
        obj = obj3;
_L4:
        obj1 = obj;
        Log.d(AppEventsLogger.access$1(), (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj2)).toString()).toString());
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (appSessionInfoMap == null)
        {
            appSessionInfoMap = new HashMap();
        }
        isLoaded = true;
        hasChanges = false;
          goto _L1
_L3:
        Utility.closeQuietly(((java.io.Closeable) (obj1)));
        context.deleteFile("AppEventsLogger.persistedsessioninfo");
        if (appSessionInfoMap == null)
        {
            appSessionInfoMap = new HashMap();
        }
        isLoaded = true;
        hasChanges = false;
        throw obj;
        context;
          goto _L2
        obj2;
        obj1 = obj;
        obj = obj2;
          goto _L3
        obj2;
          goto _L4
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
          goto _L5
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = ((FileNotFoundException) (obj2));
          goto _L5
        context;
          goto _L2
        filenotfoundexception;
          goto _L3
    }

    static void saveAppSessionInformation(Context context)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        Object obj2 = staticLock;
        obj2;
        JVM INSTR monitorenter ;
        boolean flag = hasChanges;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        context = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
        context.writeObject(appSessionInfoMap);
        hasChanges = false;
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
        Utility.closeQuietly(context);
_L1:
        obj2;
        JVM INSTR monitorexit ;
        return;
        obj;
        context = ((Context) (obj1));
        obj1 = obj;
_L4:
        obj = context;
        Log.d(AppEventsLogger.access$1(), (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj1)).toString()).toString());
        Utility.closeQuietly(context);
          goto _L1
_L2:
        obj2;
        JVM INSTR monitorexit ;
        throw context;
        context;
_L3:
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        throw context;
        context;
          goto _L2
        obj1;
        obj = context;
        context = ((Context) (obj1));
          goto _L3
        obj1;
          goto _L4
        context;
          goto _L2
    }


    _cls1()
    {
    }
}
