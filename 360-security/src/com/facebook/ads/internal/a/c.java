// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.j;
import com.facebook.ads.internal.util.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.a:
//            a

public class c extends a
{

    private static final String a = com/facebook/ads/internal/a/c.getSimpleName();
    private final Context b;
    private final Uri c;

    public c(Context context, Uri uri)
    {
        b = context;
        c = uri;
    }

    private Intent a(j j1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        if (!t.a(j1.a()) && !t.a(j1.b()))
        {
            intent.setComponent(new ComponentName(j1.a(), j1.b()));
        }
        if (!t.a(j1.c()))
        {
            intent.setData(Uri.parse(j1.c()));
        }
        return intent;
    }

    private Intent b(j j1)
    {
        Object obj;
        Object obj1;
label0:
        {
            if (t.a(j1.a()))
            {
                return null;
            }
            if (!g.a(b, j1.a()))
            {
                return null;
            }
            obj = j1.c();
            if (!t.a(((String) (obj))) && (((String) (obj)).startsWith("tel:") || ((String) (obj)).startsWith("telprompt:")))
            {
                return new Intent("android.intent.action.CALL", Uri.parse(((String) (obj))));
            }
            obj1 = b.getPackageManager();
            if (t.a(j1.b()) && t.a(((String) (obj))))
            {
                return ((PackageManager) (obj1)).getLaunchIntentForPackage(j1.a());
            }
            obj = a(j1);
            obj1 = ((PackageManager) (obj1)).queryIntentActivities(((Intent) (obj)), 0x10000);
            if (((Intent) (obj)).getComponent() != null)
            {
                break label0;
            }
            Iterator iterator = ((List) (obj1)).iterator();
            ResolveInfo resolveinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                resolveinfo = (ResolveInfo)iterator.next();
            } while (!resolveinfo.activityInfo.packageName.equals(j1.a()));
            ((Intent) (obj)).setComponent(new ComponentName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name));
        }
        if (((List) (obj1)).isEmpty() || ((Intent) (obj)).getComponent() == null)
        {
            return null;
        } else
        {
            return ((Intent) (obj));
        }
    }

    private List f()
    {
        Object obj = c.getQueryParameter("appsite_data");
        if (!t.a(((String) (obj))) && !"[]".equals(obj)) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray;
        int i;
        try
        {
            jsonarray = (new JSONObject(((String) (obj)))).optJSONArray("android");
        }
        catch (JSONException jsonexception)
        {
            Log.w(a, "Error parsing appsite_data", jsonexception);
            return arraylist;
        }
        obj = arraylist;
        if (jsonarray == null) goto _L4; else goto _L3
_L3:
        i = 0;
_L6:
        obj = arraylist;
        if (i >= jsonarray.length()) goto _L4; else goto _L5
_L5:
        obj = j.a(jsonarray.optJSONObject(i));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        arraylist.add(obj);
        i++;
          goto _L6
    }

    public com.facebook.ads.internal.util.b.a a()
    {
        return com.facebook.ads.internal.util.b.a.a;
    }

    public void b()
    {
        a(b, c);
        Object obj = d();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                Intent intent = (Intent)((Iterator) (obj)).next();
                try
                {
                    b.startActivity(intent);
                    return;
                }
                catch (Exception exception)
                {
                    Log.d(a, "Failed to open app intent, falling back", exception);
                }
            }

        }
        e();
    }

    protected Uri c()
    {
        String s = c.getQueryParameter("store_url");
        if (!t.a(s))
        {
            return Uri.parse(s);
        } else
        {
            return Uri.parse(String.format("market://details?id=%s", new Object[] {
                c.getQueryParameter("store_id")
            }));
        }
    }

    protected List d()
    {
        Object obj = f();
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Intent intent = b((j)((Iterator) (obj)).next());
                if (intent != null)
                {
                    arraylist.add(intent);
                }
            } while (true);
        }
        return arraylist;
    }

    public void e()
    {
        Intent intent;
        intent = new Intent("android.intent.action.VIEW", c());
        intent.addFlags(0x10000000);
        b.startActivity(intent);
_L1:
        return;
        Exception exception;
        exception;
        Log.d(a, (new StringBuilder()).append("Failed to open market url: ").append(c.toString()).toString(), exception);
        String s = c.getQueryParameter("store_url_web_fallback");
        if (s != null && s.length() > 0)
        {
            Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
            intent1.addFlags(0x10000000);
            try
            {
                b.startActivity(intent1);
                return;
            }
            catch (Exception exception1)
            {
                Log.d(a, (new StringBuilder()).append("Failed to open fallback url: ").append(s).toString(), exception1);
            }
            return;
        }
          goto _L1
    }

}
