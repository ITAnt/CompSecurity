// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android;


// Referenced classes of package com.crashlytics.android:
//            CrashlyticsUncaughtExceptionHandler, ClsFileOutputStream

class this._cls0
    implements Runnable
{

    final CrashlyticsUncaughtExceptionHandler this$0;

    public void run()
    {
        doCleanInvalidTempFiles(CrashlyticsUncaughtExceptionHandler.access$1000(CrashlyticsUncaughtExceptionHandler.this, ClsFileOutputStream.TEMP_FILENAME_FILTER));
    }

    ()
    {
        this$0 = CrashlyticsUncaughtExceptionHandler.this;
        super();
    }
}
