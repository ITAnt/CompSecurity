// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.qihoo.security.locale.fragment;

import android.view.View;
import com.qihoo.security.dialog.i;
import com.qihoo360.common.utils.Utils;

// Referenced classes of package com.qihoo.security.locale.fragment:
//            LanguagePacketFragment

class a
    implements android.view.uagePacketFragment._cls11
{

    final i a;
    final LanguagePacketFragment b;

    public void onClick(View view)
    {
        Utils.dismissDialog(a);
    }

    (LanguagePacketFragment languagepacketfragment, i i)
    {
        b = languagepacketfragment;
        a = i;
        super();
    }
}
