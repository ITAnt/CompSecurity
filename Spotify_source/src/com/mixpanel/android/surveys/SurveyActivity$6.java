// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixpanel.android.surveys;

import android.content.DialogInterface;

// Referenced classes of package com.mixpanel.android.surveys:
//            SurveyActivity

final class a
    implements android.content.nClickListener
{

    private SurveyActivity a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.finish();
    }

    r(SurveyActivity surveyactivity)
    {
        a = surveyactivity;
        super();
    }
}
