// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzhl

public class zzhn
{

    private final Context mContext;
    private int mState;
    private String zzGo;
    private float zzGp;
    private float zzGq;
    private float zzGr;
    private final float zzyV;

    public zzhn(Context context)
    {
        mState = 0;
        mContext = context;
        zzyV = context.getResources().getDisplayMetrics().density;
    }

    public zzhn(Context context, String s)
    {
        this(context);
        zzGo = s;
    }

    private void showDialog()
    {
        if (!(mContext instanceof Activity))
        {
            zzb.zzaA("Can not create dialog without Activity Context");
            return;
        }
        Object obj;
        if (!TextUtils.isEmpty(zzGo))
        {
            Object obj1 = (new android.net.Uri.Builder()).encodedQuery(zzGo).build();
            obj = new StringBuilder();
            obj1 = zzo.zzbv().zzd(((android.net.Uri) (obj1)));
            String s;
            for (Iterator iterator = ((Map) (obj1)).keySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(s).append(" = ").append((String)((Map) (obj1)).get(s)).append("\n\n"))
            {
                s = (String)iterator.next();
            }

            obj = ((StringBuilder) (obj)).toString().trim();
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj = "No debug information";
            }
        } else
        {
            obj = "No debug information";
        }
        obj1 = new android.app.AlertDialog.Builder(mContext);
        ((android.app.AlertDialog.Builder) (obj1)).setMessage(((CharSequence) (obj)));
        ((android.app.AlertDialog.Builder) (obj1)).setTitle("Ad Information");
        ((android.app.AlertDialog.Builder) (obj1)).setPositiveButton("Share", new android.content.DialogInterface.OnClickListener(((String) (obj))) {

            final String zzGs;
            final zzhn zzGt;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                zzhn.zza(zzGt).startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", zzGs), "Share via"));
            }

            
            {
                zzGt = zzhn.this;
                zzGs = s;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj1)).setNegativeButton("Close", new android.content.DialogInterface.OnClickListener() {

            final zzhn zzGt;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                zzGt = zzhn.this;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj1)).create().show();
    }

    static Context zza(zzhn zzhn1)
    {
        return zzhn1.mContext;
    }

    void zza(int i, float f, float f1)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        mState = 0;
        zzGp = f;
        zzGq = f1;
        zzGr = f1;
_L4:
        return;
_L2:
        if (mState == -1) goto _L4; else goto _L3
_L3:
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f1 <= zzGq) goto _L6; else goto _L5
_L5:
        zzGq = f1;
_L8:
        if (zzGq - zzGr > 30F * zzyV)
        {
            mState = -1;
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (f1 < zzGr)
        {
            zzGr = f1;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (mState == 0 || mState == 2)
        {
            if (f - zzGp >= 50F * zzyV)
            {
                zzGp = f;
                mState = mState + 1;
            }
        } else
        if ((mState == 1 || mState == 3) && f - zzGp <= -50F * zzyV)
        {
            zzGp = f;
            mState = mState + 1;
        }
        if (mState != 1 && mState != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f <= zzGp) goto _L4; else goto _L9
_L9:
        zzGp = f;
        return;
        if (mState != 2 || f >= zzGp) goto _L4; else goto _L10
_L10:
        zzGp = f;
        return;
        if (i != 1 || mState != 4) goto _L4; else goto _L11
_L11:
        showDialog();
        return;
    }

    public void zzaw(String s)
    {
        zzGo = s;
    }

    public void zzd(MotionEvent motionevent)
    {
        int j = motionevent.getHistorySize();
        for (int i = 0; i < j; i++)
        {
            zza(motionevent.getActionMasked(), motionevent.getHistoricalX(0, i), motionevent.getHistoricalY(0, i));
        }

        zza(motionevent.getActionMasked(), motionevent.getX(), motionevent.getY());
    }
}
