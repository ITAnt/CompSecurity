// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.commerce.ocr.loyalty.fragments;

import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.google.android.libraries.commerce.ocr.loyalty.fragments:
//            BarcodeBundleModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final BarcodeBundleModule module;

    public final Float get()
    {
        return Float.valueOf(module.provideEdgeFinderWidthToOuterBoundingBoxEdgeLengthRatio());
    }

    public final volatile Object get()
    {
        return get();
    }

    public (BarcodeBundleModule barcodebundlemodule)
    {
        super("@com.google.android.libraries.commerce.ocr.annotations.IntentAnnotations$EdgeFinderWidthToOuterBoundingBoxEdgeLengthRatio()/java.lang.Float", false, "com.google.android.libraries.commerce.ocr.loyalty.fragments.BarcodeBundleModule", "provideEdgeFinderWidthToOuterBoundingBoxEdgeLengthRatio");
        module = barcodebundlemodule;
        setLibrary(true);
    }
}
