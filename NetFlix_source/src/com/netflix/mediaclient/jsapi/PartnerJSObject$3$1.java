// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.jsapi;

import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.partner.Partner;
import com.netflix.mediaclient.partner.PartnerFactory;
import com.netflix.mediaclient.partner.Response;
import com.netflix.mediaclient.partner.ResponseListener;

// Referenced classes of package com.netflix.mediaclient.jsapi:
//            PartnerJSObject

class this._cls1
    implements ResponseListener
{

    final is._cls0 this$1;

    public void onResponseReceived(Response response)
    {
        try
        {
            PartnerJSObject.access$300(_fld0, "nrdpPartner.Signup._handleExternalUserData", response.toJson());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            Log.e("nf_partner", "Failed to get JSON from response", response);
        }
    }

    l.userId()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/netflix/mediaclient/jsapi/PartnerJSObject$3

/* anonymous class */
    class PartnerJSObject._cls3
        implements Runnable
    {

        final PartnerJSObject this$0;
        final int val$idx;
        final String val$service;
        final String val$userId;

        public void run()
        {
            Object obj;
            Log.d("nf_partner", "Find partner");
            obj = PartnerJSObject.access$100(PartnerJSObject.this).getPartner(context, service, PartnerJSObject.access$000(PartnerJSObject.this));
            if (obj == null)
            {
                try
                {
                    Log.e("nf_partner", "Service not found!");
                    PartnerJSObject.access$300(PartnerJSObject.this, "nrdpPartner.Signup._handleExternalUserData", PartnerJSObject.access$200(null, idx, service, "101", "Service not found!"));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.e("nf_partner", "Failed to work with JSON", ((Throwable) (obj)));
                }
                break MISSING_BLOCK_LABEL_131;
            }
            if (((Partner) (obj)).getSignup() == null)
            {
                Log.e("nf_partner", "Service does not support SSO!");
                PartnerJSObject.access$300(PartnerJSObject.this, "nrdpPartner.Signup._handleExternalUserData", PartnerJSObject.access$200(userId, idx, service, "102", "Service does not support Signup!"));
                return;
            }
            break MISSING_BLOCK_LABEL_132;
            return;
            ((Partner) (obj)).getSignup().getExternalUserData(service, userId, idx, new PartnerJSObject._cls3._cls1());
            return;
        }

            
            {
                this$0 = final_partnerjsobject;
                service = s;
                idx = i;
                userId = String.this;
                super();
            }
    }

}
