// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.google.common.collect:
//            TreeRangeMap, Maps

class this._cls2 extends this._cls2
{

    final this._cls2 this$2;

    public boolean remove(Object obj)
    {
        return move(obj) != null;
    }

    public boolean retainAll(Collection collection)
    {
        return cess._mth400(this._cls2.this, Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
    }

    (Map map)
    {
        this$2 = this._cls2.this;
        super(map);
    }
}
