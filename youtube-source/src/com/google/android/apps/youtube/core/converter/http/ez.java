// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.core.converter.http;

import com.google.android.apps.youtube.common.e.l;
import com.google.android.apps.youtube.core.converter.o;
import com.google.android.apps.youtube.core.utils.ag;
import com.google.android.apps.youtube.datalib.legacy.model.ba;
import org.xml.sax.Attributes;

final class ez extends o
{

    ez()
    {
    }

    public final void a(l l1, Attributes attributes, String s)
    {
        int i = ag.a(s.trim());
        ((ba)l1.a(com/google/android/apps/youtube/datalib/legacy/model/ba)).a(i / 1000);
    }
}
