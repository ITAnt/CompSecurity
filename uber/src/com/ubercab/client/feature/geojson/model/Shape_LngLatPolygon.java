// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ubercab.client.feature.geojson.model;

import java.util.List;

// Referenced classes of package com.ubercab.client.feature.geojson.model:
//            LngLatPolygon, BasePolygon

public final class Shape_LngLatPolygon extends LngLatPolygon
{

    private List coordinates;
    private String type;

    Shape_LngLatPolygon()
    {
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (LngLatPolygon)obj;
            if (((LngLatPolygon) (obj)).getType() == null ? getType() != null : !((LngLatPolygon) (obj)).getType().equals(getType()))
            {
                return false;
            }
            if (((LngLatPolygon) (obj)).getCoordinates() == null ? getCoordinates() != null : !((LngLatPolygon) (obj)).getCoordinates().equals(getCoordinates()))
            {
                return false;
            }
        }
        return true;
    }

    public final volatile Object getCoordinates()
    {
        return getCoordinates();
    }

    public final List getCoordinates()
    {
        return coordinates;
    }

    public final String getType()
    {
        return type;
    }

    public final int hashCode()
    {
        int j = 0;
        int i;
        if (type == null)
        {
            i = 0;
        } else
        {
            i = type.hashCode();
        }
        if (coordinates != null)
        {
            j = coordinates.hashCode();
        }
        return (i ^ 0xf4243) * 0xf4243 ^ j;
    }

    final volatile BasePolygon setCoordinates(List list)
    {
        return setCoordinates(list);
    }

    final LngLatPolygon setCoordinates(List list)
    {
        coordinates = list;
        return this;
    }

    final volatile BasePolygon setType(String s)
    {
        return setType(s);
    }

    final LngLatPolygon setType(String s)
    {
        type = s;
        return this;
    }

    public final String toString()
    {
        return (new StringBuilder("LngLatPolygon{type=")).append(type).append(", coordinates=").append(coordinates).append("}").toString();
    }
}
