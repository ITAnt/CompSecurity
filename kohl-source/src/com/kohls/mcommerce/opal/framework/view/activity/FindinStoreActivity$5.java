// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kohls.mcommerce.opal.framework.view.activity;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.kohls.mcommerce.opal.framework.view.activity:
//            FindinStoreActivity

class this._cls0
    implements android.content.kListener
{

    final FindinStoreActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            startActivity(dialoginterface);
        }
    }

    ()
    {
        this$0 = FindinStoreActivity.this;
        super();
    }
}
