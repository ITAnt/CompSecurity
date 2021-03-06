// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.jsontype.impl:
//            TypeSerializerBase

public class AsExternalTypeSerializer extends TypeSerializerBase
{

    protected final String _typePropertyName;

    public AsExternalTypeSerializer(TypeIdResolver typeidresolver, BeanProperty beanproperty, String s)
    {
        super(typeidresolver, beanproperty);
        _typePropertyName = s;
    }

    protected final void _writeArrayPrefix(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeStartArray();
    }

    protected final void _writeArraySuffix(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        jsongenerator.writeEndArray();
        if (s != null)
        {
            jsongenerator.writeStringField(_typePropertyName, s);
        }
    }

    protected final void _writeObjectPrefix(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeStartObject();
    }

    protected final void _writeObjectSuffix(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        jsongenerator.writeEndObject();
        if (s != null)
        {
            jsongenerator.writeStringField(_typePropertyName, s);
        }
    }

    protected final void _writeScalarPrefix(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
    }

    protected final void _writeScalarSuffix(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        if (s != null)
        {
            jsongenerator.writeStringField(_typePropertyName, s);
        }
    }

    public volatile TypeSerializer forProperty(BeanProperty beanproperty)
    {
        return forProperty(beanproperty);
    }

    public AsExternalTypeSerializer forProperty(BeanProperty beanproperty)
    {
        if (_property == beanproperty)
        {
            return this;
        } else
        {
            return new AsExternalTypeSerializer(_idResolver, beanproperty, _typePropertyName);
        }
    }

    public void writeCustomTypePrefixForArray(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        _writeArrayPrefix(obj, jsongenerator);
    }

    public void writeCustomTypePrefixForObject(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        _writeObjectPrefix(obj, jsongenerator);
    }

    public void writeCustomTypeSuffixForArray(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        _writeArraySuffix(obj, jsongenerator, s);
    }

    public void writeCustomTypeSuffixForObject(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException
    {
        _writeObjectSuffix(obj, jsongenerator, s);
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        _writeArrayPrefix(obj, jsongenerator);
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        _writeObjectPrefix(obj, jsongenerator);
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        _writeScalarPrefix(obj, jsongenerator);
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsongenerator, Class class1)
        throws IOException
    {
        _writeScalarPrefix(obj, jsongenerator);
    }

    public void writeTypeSuffixForArray(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        _writeArraySuffix(obj, jsongenerator, idFromValue(obj));
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        _writeObjectSuffix(obj, jsongenerator, idFromValue(obj));
    }

    public void writeTypeSuffixForScalar(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        _writeScalarSuffix(obj, jsongenerator, idFromValue(obj));
    }
}
