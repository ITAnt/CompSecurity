// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.android.camera.exposure;

import com.google.zxing.client.android.common.PlatformSupportManager;

// Referenced classes of package com.google.zxing.client.android.camera.exposure:
//            ExposureInterface, DefaultExposureInterface

public final class ExposureManager extends PlatformSupportManager
{

    public ExposureManager()
    {
        super(com/google/zxing/client/android/camera/exposure/ExposureInterface, new DefaultExposureInterface());
        addImplementationClass(8, "com.google.zxing.client.android.camera.exposure.FroyoExposureInterface");
    }
}
