// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class j extends Metadata
{

    private final MetadataBundle ED;

    public j(MetadataBundle metadatabundle)
    {
        ED = metadatabundle;
    }

    protected Object a(MetadataField metadatafield)
    {
        return ED.a(metadatafield);
    }

    public Metadata fB()
    {
        return new j(MetadataBundle.a(ED));
    }

    public Object freeze()
    {
        return fB();
    }

    public boolean isDataValid()
    {
        return ED != null;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Metadata [mImpl=").append(ED).append("]").toString();
    }
}
