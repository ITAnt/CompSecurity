// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            il

public final class id
{

    public final String a;
    public final String b;
    public final List c;
    public final String d;
    public final String e;
    public final List f;
    public final List g;
    public final String h;
    public final List i;
    public final List j;

    public id(JSONObject jsonobject)
    {
        Object obj1 = null;
        super();
        b = jsonobject.getString("id");
        Object obj = jsonobject.getJSONArray("adapters");
        ArrayList arraylist = new ArrayList(((JSONArray) (obj)).length());
        for (int k = 0; k < ((JSONArray) (obj)).length(); k++)
        {
            arraylist.add(((JSONArray) (obj)).getString(k));
        }

        c = Collections.unmodifiableList(arraylist);
        d = jsonobject.optString("allocation_id", null);
        zzp.zzbH();
        f = il.a(jsonobject, "clickurl");
        zzp.zzbH();
        g = il.a(jsonobject, "imp_urls");
        zzp.zzbH();
        i = il.a(jsonobject, "video_start_urls");
        zzp.zzbH();
        j = il.a(jsonobject, "video_complete_urls");
        obj = jsonobject.optJSONObject("ad");
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = null;
        }
        a = ((String) (obj));
        obj = jsonobject.optJSONObject("data");
        if (obj != null)
        {
            jsonobject = ((JSONObject) (obj)).toString();
        } else
        {
            jsonobject = null;
        }
        h = jsonobject;
        jsonobject = obj1;
        if (obj != null)
        {
            jsonobject = ((JSONObject) (obj)).optString("class_name");
        }
        e = jsonobject;
    }
}
