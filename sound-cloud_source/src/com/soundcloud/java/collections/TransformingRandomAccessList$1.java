// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.java.collections;

import com.soundcloud.java.functions.Function;
import java.util.ListIterator;

// Referenced classes of package com.soundcloud.java.collections:
//            TransformedListIterator, TransformingRandomAccessList

class this._cls0 extends TransformedListIterator
{

    final TransformingRandomAccessList this$0;

    Object transform(Object obj)
    {
        return function.apply(obj);
    }

    (ListIterator listiterator)
    {
        this$0 = TransformingRandomAccessList.this;
        super(listiterator);
    }
}
