// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a.a.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.a.a.f;
import b.a.a.a.q;

// Referenced classes of package b.a.a.a.a.b:
//            l

public final class j
{

    public j()
    {
    }

    public static String a(Context context)
    {
        String s1 = b(context);
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = null;
            int k = l.a(context, "io.fabric.ApiKey", "string");
            int i = k;
            if (k == 0)
            {
                f.c().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
                i = l.a(context, "com.crashlytics.ApiKey", "string");
            }
            if (i != 0)
            {
                s = context.getResources().getString(i);
            }
        }
        if (TextUtils.isEmpty(s))
        {
            if (f.d() || l.i(context))
            {
                throw new IllegalArgumentException("Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
            }
            f.c().d("Fabric", "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
        }
        return s;
    }

    private static String b(Context context)
    {
        String s1 = null;
        Object obj = null;
        String s = s1;
        Object obj1;
        try
        {
            obj1 = context.getPackageName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            f.c().a("Fabric", (new StringBuilder("Caught non-fatal exception while retrieving apiKey: ")).append(context).toString());
            return s;
        }
        s = s1;
        obj1 = context.getPackageManager().getApplicationInfo(((String) (obj1)), 128).metaData;
        context = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        s = s1;
        s1 = ((Bundle) (obj1)).getString("io.fabric.ApiKey");
        context = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        s = s1;
        f.c().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
        s = s1;
        context = ((Bundle) (obj1)).getString("com.crashlytics.ApiKey");
        return context;
    }
}
