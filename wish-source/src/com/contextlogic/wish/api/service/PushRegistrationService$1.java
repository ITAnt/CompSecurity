// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.api.service;

import com.contextlogic.wish.api.core.WishApiCallback;
import com.contextlogic.wish.api.core.WishApiRequest;
import com.contextlogic.wish.api.core.WishApiResponse;

// Referenced classes of package com.contextlogic.wish.api.service:
//            PushRegistrationService

class ccessCallback
    implements WishApiCallback
{

    final PushRegistrationService this$0;
    final  val$failureCallback;
    final ccessCallback val$successCallback;

    public void onFailure(WishApiRequest wishapirequest, WishApiResponse wishapiresponse)
    {
        PushRegistrationService.access$002(PushRegistrationService.this, null);
        if (val$failureCallback != null)
        {
            val$failureCallback.onServiceFailed();
        }
    }

    public void onSuccess(WishApiRequest wishapirequest, WishApiResponse wishapiresponse)
    {
        PushRegistrationService.access$002(PushRegistrationService.this, null);
        if (wishapiresponse.isErrorResponse())
        {
            if (val$failureCallback != null)
            {
                val$failureCallback.onServiceFailed();
            }
        } else
        if (val$successCallback != null)
        {
            val$successCallback.onServiceSucceeded();
            return;
        }
    }

    ccessCallback()
    {
        this$0 = final_pushregistrationservice;
        val$failureCallback = ;
        val$successCallback = ccessCallback.this;
        super();
    }
}
