// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ubercab.android.partner.funnel.signup.form.model;

import android.os.Parcelable;
import com.ubercab.form.model.FieldComponent;
import java.util.List;

// Referenced classes of package com.ubercab.android.partner.funnel.signup.form.model:
//            Shape_MapComponent

public abstract class MapComponent extends FieldComponent
    implements Parcelable
{

    public static final String TYPE = "map";

    public MapComponent()
    {
    }

    public static MapComponent create()
    {
        return new Shape_MapComponent();
    }

    public abstract List getValues();

    public abstract MapComponent setValues(List list);
}
