// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.leanplum.messagetemplates;

import android.content.Context;
import android.graphics.Bitmap;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;

// Referenced classes of package com.leanplum.messagetemplates:
//            BaseMessageOptions

public class CenterPopupOptions extends BaseMessageOptions
{

    private int a;
    private int b;

    public CenterPopupOptions(ActionContext actioncontext)
    {
        super(actioncontext);
        a = actioncontext.numberNamed("Layout.Width").intValue();
        b = actioncontext.numberNamed("Layout.Height").intValue();
    }

    public static ActionArgs toArgs(Context context)
    {
        return BaseMessageOptions.toArgs(context).with("Layout.Width", Integer.valueOf(300)).with("Layout.Height", Integer.valueOf(250));
    }

    public volatile void accept()
    {
        super.accept();
    }

    public volatile int getAcceptButtonBackgroundColor()
    {
        return super.getAcceptButtonBackgroundColor();
    }

    public volatile String getAcceptButtonText()
    {
        return super.getAcceptButtonText();
    }

    public volatile int getAcceptButtonTextColor()
    {
        return super.getAcceptButtonTextColor();
    }

    public volatile int getBackgroundColor()
    {
        return super.getBackgroundColor();
    }

    public volatile Bitmap getBackgroundImage()
    {
        return super.getBackgroundImage();
    }

    public volatile Bitmap getBackgroundImageRounded(int i)
    {
        return super.getBackgroundImageRounded(i);
    }

    public int getHeight()
    {
        return b;
    }

    public volatile int getMessageColor()
    {
        return super.getMessageColor();
    }

    public volatile String getMessageText()
    {
        return super.getMessageText();
    }

    public volatile String getTitle()
    {
        return super.getTitle();
    }

    public volatile int getTitleColor()
    {
        return super.getTitleColor();
    }

    public int getWidth()
    {
        return a;
    }
}
