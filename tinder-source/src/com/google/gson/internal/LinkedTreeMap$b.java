// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.google.gson.internal:
//            LinkedTreeMap

final class a extends AbstractSet
{

    final LinkedTreeMap a;

    public final void clear()
    {
        a.clear();
    }

    public final boolean contains(Object obj)
    {
        return a.containsKey(obj);
    }

    public final Iterator iterator()
    {
        return new LinkedTreeMap.c() {

            final LinkedTreeMap.b a;

            public final Object next()
            {
                return a().f;
            }

            
            {
                a = LinkedTreeMap.b.this;
                super(LinkedTreeMap.b.this.a, (byte)0);
            }
        };
    }

    public final boolean remove(Object obj)
    {
        return a.a(obj) != null;
    }

    public final int size()
    {
        return a.c;
    }

    a(LinkedTreeMap linkedtreemap)
    {
        a = linkedtreemap;
        super();
    }
}
