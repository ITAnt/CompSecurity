// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.Parcel;

// Referenced classes of package com.facebook:
//            AccessToken

static final class or
    implements android.os.ator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new AccessToken(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new AccessToken[i];
    }

    or()
    {
    }
}
