// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser.std;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;

// Referenced classes of package org.codehaus.jackson.map.ser.std:
//            ScalarSerializerBase, StdJdkSerializers

public static final class  extends ScalarSerializerBase
{

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        return createSchemaNode("boolean", true);
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((AtomicBoolean)obj, jsongenerator, serializerprovider);
    }

    public void serialize(AtomicBoolean atomicboolean, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeBoolean(atomicboolean.get());
    }

    public ()
    {
        super(java/util/concurrent/atomic/AtomicBoolean, false);
    }
}
