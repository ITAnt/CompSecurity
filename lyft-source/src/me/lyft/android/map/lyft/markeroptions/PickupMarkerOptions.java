// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.map.lyft.markeroptions;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import me.lyft.android.map.core.markers.IMarker;
import me.lyft.android.map.core.markers.MarkerOptions;
import me.lyft.android.map.lyft.markers.Marker;
import me.lyft.android.map.lyft.markers.PickupPinMarker;

public class PickupMarkerOptions extends MarkerOptions
{

    private static final float MAP_PIN_X_OFFSET = 0.275F;
    private static final float MAP_PIN_Y_OFFSET = 1F;
    private static final String PICKUP_PIN_ID = "pickup_pin";

    public PickupMarkerOptions()
    {
        setAnchor(0.275F, 1.0F);
        setIcon(BitmapDescriptorFactory.a(0x7f020181));
    }

    public volatile Marker create(IMarker imarker)
    {
        return create(imarker);
    }

    public PickupPinMarker create(IMarker imarker)
    {
        return new PickupPinMarker(getMarkerId(), imarker);
    }

    public String getMarkerId()
    {
        return "pickup_pin";
    }

    public Class getMarkerType()
    {
        return me/lyft/android/map/lyft/markers/PickupPinMarker;
    }
}
