// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.roidapp.cloudlib.flickr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.roidapp.cloudlib.aq;
import com.roidapp.cloudlib.ar;
import com.roidapp.cloudlib.as;
import com.roidapp.cloudlib.at;
import com.roidapp.cloudlib.common.a;
import com.roidapp.cloudlib.common.c;
import java.io.File;

// Referenced classes of package com.roidapp.cloudlib.flickr:
//            FlickrListCloud, o

final class q extends BaseAdapter
{

    final FlickrListCloud a;
    private Context b;
    private LayoutInflater c;

    public q(FlickrListCloud flickrlistcloud, Context context)
    {
        a = flickrlistcloud;
        super();
        b = context;
        c = LayoutInflater.from(context);
    }

    public final int getCount()
    {
        return 2;
    }

    public final Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return 0L;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = c.inflate(as.h, null);
        }
        Object obj = (TextView)viewgroup.findViewById(ar.cG);
        view = (ImageView)viewgroup.findViewById(ar.bd);
        switch (i)
        {
        default:
            return viewgroup;

        case 0: // '\0'
            if (com.roidapp.cloudlib.common.a.g(b).trim().equals(""))
            {
                ((TextView) (obj)).setText(at.M);
                view.setImageResource(aq.j);
                return viewgroup;
            }
            ((TextView) (obj)).setText(com.roidapp.cloudlib.common.a.g(b));
            obj = com.roidapp.cloudlib.common.a.i(b);
            FlickrListCloud flickrlistcloud = a;
            if (!com.roidapp.cloudlib.common.c.a())
            {
                Toast.makeText(flickrlistcloud, flickrlistcloud.getString(at.ag), 0).show();
                return viewgroup;
            }
            Object obj1 = new File(com.roidapp.baselib.d.a.a());
            if (!((File) (obj1)).exists())
            {
                ((File) (obj1)).mkdirs();
            }
            obj1 = com.roidapp.baselib.d.a.b(((String) (obj)));
            obj1 = (new StringBuilder()).append(com.roidapp.baselib.d.a.a()).append(File.separator).append(((String) (obj1))).toString();
            File file = new File(((String) (obj1)));
            if (file.exists() && file.isFile())
            {
                file.delete();
            }
            (new o(flickrlistcloud, ((String) (obj1)), ((String) (obj)), view)).start();
            return viewgroup;

        case 1: // '\001'
            view.setImageResource(aq.G);
            ((TextView) (obj)).setText(at.L);
            return viewgroup;
        }
    }
}
