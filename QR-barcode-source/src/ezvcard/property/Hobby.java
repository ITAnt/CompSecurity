// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.parameter.HobbyLevel;
import ezvcard.parameter.VCardParameters;
import java.util.EnumSet;
import java.util.Set;

// Referenced classes of package ezvcard.property:
//            TextProperty, HasAltId

public class Hobby extends TextProperty
    implements HasAltId
{

    public Hobby(String s)
    {
        super(s);
    }

    public Set _supportedVersions()
    {
        return EnumSet.of(VCardVersion.V4_0);
    }

    public String getAltId()
    {
        return parameters.getAltId();
    }

    public Integer getIndex()
    {
        return super.getIndex();
    }

    public String getLanguage()
    {
        return super.getLanguage();
    }

    public HobbyLevel getLevel()
    {
        String s = parameters.getLevel();
        if (s == null)
        {
            return null;
        } else
        {
            return HobbyLevel.get(s);
        }
    }

    public Integer getPref()
    {
        return super.getPref();
    }

    public String getType()
    {
        return parameters.getType();
    }

    public void setAltId(String s)
    {
        parameters.setAltId(s);
    }

    public void setIndex(Integer integer)
    {
        super.setIndex(integer);
    }

    public void setLanguage(String s)
    {
        super.setLanguage(s);
    }

    public void setLevel(HobbyLevel hobbylevel)
    {
        parameters.setLevel(hobbylevel.getValue());
    }

    public void setPref(Integer integer)
    {
        super.setPref(integer);
    }

    public void setType(String s)
    {
        parameters.setType(s);
    }
}
