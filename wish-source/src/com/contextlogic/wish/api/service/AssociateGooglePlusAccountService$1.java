// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.api.service;

import com.contextlogic.wish.api.core.WishApiCallback;
import com.contextlogic.wish.api.core.WishApiRequest;
import com.contextlogic.wish.api.core.WishApiResponse;

// Referenced classes of package com.contextlogic.wish.api.service:
//            AssociateGooglePlusAccountService

class ccessCallback
    implements WishApiCallback
{

    final AssociateGooglePlusAccountService this$0;
    final ilureCallback val$failureCallback;
    final ccessCallback val$successCallback;

    public void onFailure(WishApiRequest wishapirequest, WishApiResponse wishapiresponse)
    {
        Object obj = null;
        handleFailureResponse(wishapirequest, wishapiresponse);
        AssociateGooglePlusAccountService.access$002(AssociateGooglePlusAccountService.this, null);
        if (val$failureCallback != null)
        {
            wishapirequest = obj;
            if (wishapiresponse != null)
            {
                wishapirequest = wishapiresponse.getMessage();
            }
            val$failureCallback.onServiceFailed(wishapirequest);
        }
    }

    public void onSuccess(WishApiRequest wishapirequest, WishApiResponse wishapiresponse)
    {
        wishapirequest = null;
        AssociateGooglePlusAccountService.access$002(AssociateGooglePlusAccountService.this, null);
        if (wishapiresponse.isErrorResponse())
        {
            if (val$failureCallback != null)
            {
                if (wishapiresponse != null)
                {
                    wishapirequest = wishapiresponse.getMessage();
                }
                val$failureCallback.onServiceFailed(wishapirequest);
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
        this$0 = final_associategoogleplusaccountservice;
        val$failureCallback = ilurecallback;
        val$successCallback = ccessCallback.this;
        super();
    }
}
