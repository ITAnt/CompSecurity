// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.api.service;

import com.contextlogic.wish.api.core.ApiMalformedDataException;
import com.contextlogic.wish.api.core.WishApiCallback;
import com.contextlogic.wish.api.core.WishApiRequest;
import com.contextlogic.wish.api.core.WishApiResponse;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.contextlogic.wish.api.service:
//            InitiateStripePaymentService

class ccessCallback
    implements WishApiCallback
{

    final InitiateStripePaymentService this$0;
    final ilureCallback val$failureCallback;
    final ccessCallback val$successCallback;

    public void onFailure(WishApiRequest wishapirequest, WishApiResponse wishapiresponse)
    {
        Object obj = null;
        handleFailureResponse(wishapirequest, wishapiresponse);
        InitiateStripePaymentService.access$002(InitiateStripePaymentService.this, null);
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
        InitiateStripePaymentService.access$002(InitiateStripePaymentService.this, null);
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
        {
            try
            {
                wishapirequest = wishapiresponse.getData().getString("transaction_id");
                if (val$successCallback != null)
                {
                    val$successCallback.onServiceSucceeded(wishapirequest);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (WishApiRequest wishapirequest)
            {
                if (val$failureCallback != null)
                {
                    val$failureCallback.onServiceFailed(null);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (WishApiRequest wishapirequest)
            {
                if (val$failureCallback != null)
                {
                    val$failureCallback.onServiceFailed(null);
                    return;
                }
            }
        }
    }

    ccessCallback()
    {
        this$0 = final_initiatestripepaymentservice;
        val$failureCallback = ilurecallback;
        val$successCallback = ccessCallback.this;
        super();
    }
}
