// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dominos.dialogs;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.dominos.dialogs:
//            LoginDialogFragment

class this._cls0
    implements android.view.ment._cls5
{

    final LoginDialogFragment this$0;

    public void onClick(View view)
    {
        showLoading();
        executeLogin(mPasswordEntry.getText().toString());
    }

    ()
    {
        this$0 = LoginDialogFragment.this;
        super();
    }
}
