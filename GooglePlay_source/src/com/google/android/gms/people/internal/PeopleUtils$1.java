// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.people.internal;


// Referenced classes of package com.google.android.gms.people.internal:
//            PeopleUtils

static final class  extends ThreadLocal
{

    protected final volatile Object initialValue()
    {
        return new StringBuilder();
    }

    ()
    {
    }
}
