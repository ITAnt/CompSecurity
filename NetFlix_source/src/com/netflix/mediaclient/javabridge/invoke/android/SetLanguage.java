// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.javabridge.invoke.android;

import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.javabridge.invoke.BaseInvoke;
import org.json.JSONException;
import org.json.JSONObject;

public class SetLanguage extends BaseInvoke
{

    private static final String METHOD = "setLanguage";
    private static final String PROPERTY_LANGUAGE = "language";
    private static final String TARGET = "android";

    public SetLanguage(String s)
    {
        super("android", "setLanguage");
        setArguments(s);
    }

    private void setArguments(String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("language", s);
            arguments = jsonobject.toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        break MISSING_BLOCK_LABEL_26;
        s;
        Log.e("nf_invoke", "Failed to create JSON object", s);
        return;
    }
}
