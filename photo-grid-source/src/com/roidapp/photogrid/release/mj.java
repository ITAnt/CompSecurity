// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.roidapp.photogrid.release;

import android.content.DialogInterface;

// Referenced classes of package com.roidapp.photogrid.release:
//            PhotoGridActivity

final class mj
    implements android.content.DialogInterface.OnClickListener
{

    final PhotoGridActivity a;

    mj(PhotoGridActivity photogridactivity)
    {
        a = photogridactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        PhotoGridActivity.a(a);
        a.d(17);
        dialoginterface.dismiss();
    }
}
