// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.gen;

import com.skype.Translator;

// Referenced classes of package com.skype.android.gen:
//            TranslatorListener

public static class _status
{

    private int _convId;
    private Translator _sender;
    private com.skype.atusChanged._status _status;

    public int getConvId()
    {
        return _convId;
    }

    public Translator getSender()
    {
        return _sender;
    }

    public com.skype.atusChanged getStatus()
    {
        return _status;
    }

    public (Translator translator, int i, com.skype.atusChanged atuschanged)
    {
        _sender = translator;
        _convId = i;
        _status = atuschanged;
    }
}
