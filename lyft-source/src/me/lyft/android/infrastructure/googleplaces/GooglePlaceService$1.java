// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.infrastructure.googleplaces;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

// Referenced classes of package me.lyft.android.infrastructure.googleplaces:
//            GooglePlaceService

class this._cls0
    implements Func1
{

    final GooglePlaceService this$0;

    public volatile Object call(Object obj)
    {
        return call((Unit)obj);
    }

    public Observable call(Unit unit)
    {
        return GooglePlaceService.access$000(GooglePlaceService.this);
    }

    ()
    {
        this$0 = GooglePlaceService.this;
        super();
    }
}
