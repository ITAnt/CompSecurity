// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.photos.uploadtoalbum.UploadContentActivity;

public final class jdj
    implements android.view.View.OnClickListener
{

    private UploadContentActivity a;

    public jdj(UploadContentActivity uploadcontentactivity)
    {
        a = uploadcontentactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.finish();
    }
}
