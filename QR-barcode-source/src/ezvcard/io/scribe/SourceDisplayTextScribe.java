// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package ezvcard.io.scribe;

import ezvcard.property.SourceDisplayText;
import ezvcard.property.VCardProperty;

// Referenced classes of package ezvcard.io.scribe:
//            StringPropertyScribe

public class SourceDisplayTextScribe extends StringPropertyScribe
{

    public SourceDisplayTextScribe()
    {
        super(ezvcard/property/SourceDisplayText, "NAME");
    }

    protected SourceDisplayText _parseValue(String s)
    {
        return new SourceDisplayText(s);
    }

    protected volatile VCardProperty _parseValue(String s)
    {
        return _parseValue(s);
    }
}
