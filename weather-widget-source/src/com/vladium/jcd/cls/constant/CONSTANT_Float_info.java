// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

// Referenced classes of package com.vladium.jcd.cls.constant:
//            CONSTANT_literal_info, ICONSTANTVisitor

public final class CONSTANT_Float_info extends CONSTANT_literal_info
{

    public static final byte TAG = 4;
    public float m_value;

    public CONSTANT_Float_info(float f)
    {
        m_value = f;
    }

    protected CONSTANT_Float_info(UDataInputStream udatainputstream)
        throws IOException
    {
        m_value = udatainputstream.readFloat();
    }

    public Object accept(ICONSTANTVisitor iconstantvisitor, Object obj)
    {
        return iconstantvisitor.visit(this, obj);
    }

    public final byte tag()
    {
        return 4;
    }

    public String toString()
    {
        return Float.toString(m_value);
    }

    public void writeInClassFormat(UDataOutputStream udataoutputstream)
        throws IOException
    {
        super.writeInClassFormat(udataoutputstream);
        udataoutputstream.writeFloat(m_value);
    }
}
