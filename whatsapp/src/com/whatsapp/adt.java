// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;

import com.whatsapp.protocol.a;
import com.whatsapp.protocol.c4;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.whatsapp:
//            adk, ContactInfo, og, App

class adt extends adk
{

    final ContactInfo a;

    adt(ContactInfo contactinfo)
    {
        a = contactinfo;
        super();
    }

    public void a(c4 c4_1, int i)
    {
        if (c4_1 != null && c4_1.y.a.equals(com.whatsapp.ContactInfo.a(a).a) && !c4_1.y.b && (c4_1.w == 1 || c4_1.w == 3 || c4_1.w == 2) && i == 3)
        {
            ContactInfo.d(a);
        }
    }

    public void a(Collection collection, Map map)
    {
        int i = App.am;
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            map = (c4)collection.next();
            if (!((c4) (map)).y.a.equals(com.whatsapp.ContactInfo.a(a).a) || ((c4) (map)).w != 1 && ((c4) (map)).w != 3 && ((c4) (map)).w != 2)
            {
                continue;
            }
            ContactInfo.d(a);
            if (i == 0)
            {
                break;
            }
        } while (i == 0);
    }
}
