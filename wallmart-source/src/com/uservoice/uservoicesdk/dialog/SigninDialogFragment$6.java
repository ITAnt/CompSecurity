// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uservoice.uservoicesdk.dialog;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.model.AccessToken;
import com.uservoice.uservoicesdk.model.AccessTokenResult;
import com.uservoice.uservoicesdk.model.User;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestResult;
import com.uservoice.uservoicesdk.ui.DefaultCallback;

// Referenced classes of package com.uservoice.uservoicesdk.dialog:
//            SigninDialogFragment

class val.activity
    implements Runnable
{

    final SigninDialogFragment this$0;
    final Activity val$activity;

    public void run()
    {
        if (SigninDialogFragment.access$600(SigninDialogFragment.this).getVisibility() == 0)
        {
            User.findOrCreate(SigninDialogFragment.access$200(SigninDialogFragment.this).getText().toString(), SigninDialogFragment.access$600(SigninDialogFragment.this).getText().toString(), new DefaultCallback(getActivity()) {

                final SigninDialogFragment._cls6 this$1;

                public void onModel(AccessTokenResult accesstokenresult)
                {
                    Session.getInstance().setUser((User)accesstokenresult.getModel());
                    Session.getInstance().setAccessToken(activity, accesstokenresult.getAccessToken());
                    Babayaga.track(com.uservoice.uservoicesdk.babayaga.Babayaga.Event.AUTHENTICATE);
                    dismiss();
                    SigninDialogFragment.access$800(this$0).run();
                }

                public volatile void onModel(Object obj)
                {
                    onModel((AccessTokenResult)obj);
                }

            
            {
                this$1 = SigninDialogFragment._cls6.this;
                super(context);
            }
            });
            return;
        } else
        {
            AccessToken.authorize(SigninDialogFragment.access$200(SigninDialogFragment.this).getText().toString(), SigninDialogFragment.access$700(SigninDialogFragment.this).getText().toString(), new Callback() {

                final SigninDialogFragment._cls6 this$1;

                public void onError(RestResult restresult)
                {
                    Toast.makeText(activity, com.uservoice.uservoicesdk.R.string.uv_failed_signin_error, 0).show();
                }

                public void onModel(AccessToken accesstoken)
                {
                    Session.getInstance().setAccessToken(activity, accesstoken);
                    User.loadCurrentUser(new DefaultCallback(getActivity()) {

                        final _cls2 this$2;

                        public void onModel(User user)
                        {
                            Session.getInstance().setUser(user);
                            Babayaga.track(com.uservoice.uservoicesdk.babayaga.Babayaga.Event.AUTHENTICATE);
                            dismiss();
                            SigninDialogFragment.access$800(this$0).run();
                        }

                        public volatile void onModel(Object obj)
                        {
                            onModel((User)obj);
                        }

            
            {
                this$2 = _cls2.this;
                super(context);
            }
                    });
                }

                public volatile void onModel(Object obj)
                {
                    onModel((AccessToken)obj);
                }

            
            {
                this$1 = SigninDialogFragment._cls6.this;
                super();
            }
            });
            return;
        }
    }

    _cls2.this._cls1()
    {
        this$0 = final_signindialogfragment;
        val$activity = Activity.this;
        super();
    }
}
