// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import io.card.payment.DataEntryActivity;

public final class htt
    implements android.view.View.OnClickListener
{

    private DataEntryActivity a;

    public htt(DataEntryActivity dataentryactivity)
    {
        a = dataentryactivity;
        super();
    }

    public final void onClick(View view)
    {
        DataEntryActivity.a(a);
    }
}
