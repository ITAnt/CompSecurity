// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.consumerphotoeditor.core.Renderer;

final class bet
    implements Runnable
{

    private bem a;

    bet(bem bem1)
    {
        a = bem1;
        super();
    }

    public final void run()
    {
        bem.n(a).b.loadLookupTable();
    }
}
