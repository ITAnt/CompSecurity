// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.app.Activity;
import com.facebook.model.OpenGraphAction;
import java.util.EnumSet;

public class it> extends it>
{

    protected EnumSet getDialogFeatures()
    {
        return EnumSet.of(OG_MESSAGE_DIALOG);
    }

    public (Activity activity, OpenGraphAction opengraphaction, String s)
    {
        super(activity, opengraphaction, s);
    }
}
