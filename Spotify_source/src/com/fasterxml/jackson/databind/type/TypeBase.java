// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class TypeBase extends JavaType
    implements JsonSerializable
{

    private static final long serialVersionUID = 0xce4d066641f17aa3L;
    volatile transient String _canonicalName;

    protected TypeBase(Class class1, int i, Object obj, Object obj1, boolean flag)
    {
        super(class1, i, obj, obj1, flag);
    }

    protected abstract String buildCanonicalName();

    public Object getTypeHandler()
    {
        return _typeHandler;
    }

    public Object getValueHandler()
    {
        return _valueHandler;
    }

    public void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        jsongenerator.writeString(toCanonical());
    }

    public void serializeWithType(JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
    {
        typeserializer.writeTypePrefixForScalar(this, jsongenerator);
        serialize(jsongenerator, serializerprovider);
        typeserializer.writeTypeSuffixForScalar(this, jsongenerator);
    }

    public String toCanonical()
    {
        String s1 = _canonicalName;
        String s = s1;
        if (s1 == null)
        {
            s = buildCanonicalName();
        }
        return s;
    }
}
