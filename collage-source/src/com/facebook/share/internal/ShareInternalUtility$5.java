// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;


// Referenced classes of package com.facebook.share.internal:
//            ShareInternalUtility

static final class Attachment
    implements com.facebook.internal.ity._cls5
{

    public volatile Object apply(Object obj)
    {
        return apply((com.facebook.internal.Store.Attachment)obj);
    }

    public String apply(com.facebook.internal.Store.Attachment attachment)
    {
        return attachment.getAttachmentUrl();
    }

    Attachment()
    {
    }
}
