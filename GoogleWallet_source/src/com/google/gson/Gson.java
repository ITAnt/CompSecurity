// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.gson:
//            FieldNamingPolicy, LongSerializationPolicy, JsonIOException, JsonSyntaxException, 
//            TypeAdapter, TypeAdapterFactory, JsonNull, JsonDeserializationContext, 
//            JsonSerializationContext, FieldNamingStrategy, JsonElement

public final class Gson
{
    static final class FutureTypeAdapter extends TypeAdapter
    {

        private TypeAdapter _flddelegate;

        public final Object read(JsonReader jsonreader)
            throws IOException
        {
            if (_flddelegate == null)
            {
                throw new IllegalStateException();
            } else
            {
                return _flddelegate.read(jsonreader);
            }
        }

        public final void setDelegate(TypeAdapter typeadapter)
        {
            if (_flddelegate != null)
            {
                throw new AssertionError();
            } else
            {
                _flddelegate = typeadapter;
                return;
            }
        }

        public final void write(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            if (_flddelegate == null)
            {
                throw new IllegalStateException();
            } else
            {
                _flddelegate.write(jsonwriter, obj);
                return;
            }
        }

        FutureTypeAdapter()
        {
        }
    }


    private final ThreadLocal calls;
    private final ConstructorConstructor constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map typeTokenCache;

    public Gson()
    {
        this(Excluder.DEFAULT, ((FieldNamingStrategy) (FieldNamingPolicy.IDENTITY)), Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldnamingstrategy, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, LongSerializationPolicy longserializationpolicy, List list)
    {
        calls = new ThreadLocal();
        typeTokenCache = Collections.synchronizedMap(new HashMap());
        deserializationContext = new JsonDeserializationContext() {

            final Gson this$0;

            
            {
                this$0 = Gson.this;
                super();
            }
        };
        serializationContext = new JsonSerializationContext() {

            final Gson this$0;

            
            {
                this$0 = Gson.this;
                super();
            }
        };
        constructorConstructor = new ConstructorConstructor(map);
        serializeNulls = flag;
        generateNonExecutableJson = flag2;
        htmlSafe = flag3;
        prettyPrinting = flag4;
        map = new ArrayList();
        map.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        map.add(ObjectTypeAdapter.FACTORY);
        map.add(excluder);
        map.addAll(list);
        map.add(TypeAdapters.STRING_FACTORY);
        map.add(TypeAdapters.INTEGER_FACTORY);
        map.add(TypeAdapters.BOOLEAN_FACTORY);
        map.add(TypeAdapters.BYTE_FACTORY);
        map.add(TypeAdapters.SHORT_FACTORY);
        map.add(TypeAdapters.newFactory(Long.TYPE, java/lang/Long, longAdapter(longserializationpolicy)));
        map.add(TypeAdapters.newFactory(Double.TYPE, java/lang/Double, doubleAdapter(flag5)));
        map.add(TypeAdapters.newFactory(Float.TYPE, java/lang/Float, floatAdapter(flag5)));
        map.add(TypeAdapters.NUMBER_FACTORY);
        map.add(TypeAdapters.CHARACTER_FACTORY);
        map.add(TypeAdapters.STRING_BUILDER_FACTORY);
        map.add(TypeAdapters.STRING_BUFFER_FACTORY);
        map.add(TypeAdapters.newFactory(java/math/BigDecimal, TypeAdapters.BIG_DECIMAL));
        map.add(TypeAdapters.newFactory(java/math/BigInteger, TypeAdapters.BIG_INTEGER));
        map.add(TypeAdapters.URL_FACTORY);
        map.add(TypeAdapters.URI_FACTORY);
        map.add(TypeAdapters.UUID_FACTORY);
        map.add(TypeAdapters.LOCALE_FACTORY);
        map.add(TypeAdapters.INET_ADDRESS_FACTORY);
        map.add(TypeAdapters.BIT_SET_FACTORY);
        map.add(DateTypeAdapter.FACTORY);
        map.add(TypeAdapters.CALENDAR_FACTORY);
        map.add(TimeTypeAdapter.FACTORY);
        map.add(SqlDateTypeAdapter.FACTORY);
        map.add(TypeAdapters.TIMESTAMP_FACTORY);
        map.add(ArrayTypeAdapter.FACTORY);
        map.add(TypeAdapters.ENUM_FACTORY);
        map.add(TypeAdapters.CLASS_FACTORY);
        map.add(new CollectionTypeAdapterFactory(constructorConstructor));
        map.add(new MapTypeAdapterFactory(constructorConstructor, flag1));
        map.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldnamingstrategy, excluder));
        factories = Collections.unmodifiableList(map);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonreader)
    {
        if (obj != null)
        {
            try
            {
                if (jsonreader.peek() != JsonToken.END_DOCUMENT)
                {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new JsonSyntaxException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new JsonIOException(((Throwable) (obj)));
            }
        }
    }

    private static void checkValidFloatingPoint(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        } else
        {
            return;
        }
    }

    private TypeAdapter doubleAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.DOUBLE;
        } else
        {
            return new TypeAdapter() {

                final Gson this$0;

                private static Double read(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Double.valueOf(jsonreader.nextDouble());
                    }
                }

                private void write(JsonWriter jsonwriter, Number number)
                    throws IOException
                {
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        double d = number.doubleValue();
                        Gson.checkValidFloatingPoint(Gson.this, d);
                        jsonwriter.value(number);
                        return;
                    }
                }

                public final volatile Object read(JsonReader jsonreader)
                    throws IOException
                {
                    return read(jsonreader);
                }

                public final volatile void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    write(jsonwriter, (Number)obj);
                }

            
            {
                this$0 = Gson.this;
                super();
            }
            };
        }
    }

    private TypeAdapter floatAdapter(boolean flag)
    {
        if (flag)
        {
            return TypeAdapters.FLOAT;
        } else
        {
            return new TypeAdapter() {

                final Gson this$0;

                private static Float read(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Float.valueOf((float)jsonreader.nextDouble());
                    }
                }

                private void write(JsonWriter jsonwriter, Number number)
                    throws IOException
                {
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        float f = number.floatValue();
                        Gson.checkValidFloatingPoint(Gson.this, (double)f);
                        jsonwriter.value(number);
                        return;
                    }
                }

                public final volatile Object read(JsonReader jsonreader)
                    throws IOException
                {
                    return read(jsonreader);
                }

                public final volatile void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    write(jsonwriter, (Number)obj);
                }

            
            {
                this$0 = Gson.this;
                super();
            }
            };
        }
    }

    private Object fromJson(JsonReader jsonreader, Type type)
        throws JsonIOException, JsonSyntaxException
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = jsonreader.isLenient();
        jsonreader.setLenient(true);
        jsonreader.peek();
        flag = false;
        type = ((Type) (getAdapter(TypeToken.get(type)).read(jsonreader)));
        jsonreader.setLenient(flag1);
        return type;
        type;
        if (flag)
        {
            jsonreader.setLenient(flag1);
            return null;
        }
        throw new JsonSyntaxException(type);
        type;
        jsonreader.setLenient(flag1);
        throw type;
        type;
        throw new JsonSyntaxException(type);
        type;
        throw new JsonSyntaxException(type);
    }

    private Object fromJson(Reader reader, Type type)
        throws JsonIOException, JsonSyntaxException
    {
        reader = new JsonReader(reader);
        type = ((Type) (fromJson(((JsonReader) (reader)), type)));
        assertFullConsumption(type, reader);
        return type;
    }

    private Object fromJson(String s, Type type)
        throws JsonSyntaxException
    {
        if (s == null)
        {
            return null;
        } else
        {
            return fromJson(((Reader) (new StringReader(s))), type);
        }
    }

    private TypeAdapter longAdapter(LongSerializationPolicy longserializationpolicy)
    {
        if (longserializationpolicy == LongSerializationPolicy.DEFAULT)
        {
            return TypeAdapters.LONG;
        } else
        {
            return new TypeAdapter() {

                final Gson this$0;

                private static Number read(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Long.valueOf(jsonreader.nextLong());
                    }
                }

                private static void write(JsonWriter jsonwriter, Number number)
                    throws IOException
                {
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        jsonwriter.value(number.toString());
                        return;
                    }
                }

                public final volatile Object read(JsonReader jsonreader)
                    throws IOException
                {
                    return read(jsonreader);
                }

                public final volatile void write(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    write(jsonwriter, (Number)obj);
                }

            
            {
                this$0 = Gson.this;
                super();
            }
            };
        }
    }

    private JsonWriter newJsonWriter(Writer writer)
        throws IOException
    {
        if (generateNonExecutableJson)
        {
            writer.write(")]}'\n");
        }
        writer = new JsonWriter(writer);
        if (prettyPrinting)
        {
            writer.setIndent("  ");
        }
        writer.setSerializeNulls(serializeNulls);
        return writer;
    }

    private String toJson(JsonElement jsonelement)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(jsonelement, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    private String toJson(Object obj, Type type)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(obj, type, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    private void toJson(JsonElement jsonelement, JsonWriter jsonwriter)
        throws JsonIOException
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(htmlSafe);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(serializeNulls);
        Streams.write(jsonelement, jsonwriter);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        jsonelement;
        throw new JsonIOException(jsonelement);
        jsonelement;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw jsonelement;
    }

    private void toJson(JsonElement jsonelement, Appendable appendable)
        throws JsonIOException
    {
        try
        {
            toJson(jsonelement, newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JsonElement jsonelement)
        {
            throw new RuntimeException(jsonelement);
        }
    }

    private void toJson(Object obj, Type type, JsonWriter jsonwriter)
        throws JsonIOException
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        type = getAdapter(TypeToken.get(type));
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(htmlSafe);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(serializeNulls);
        type.write(jsonwriter, obj);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        obj;
        throw new JsonIOException(((Throwable) (obj)));
        obj;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw obj;
    }

    private void toJson(Object obj, Type type, Appendable appendable)
        throws JsonIOException
    {
        try
        {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new JsonIOException(((Throwable) (obj)));
        }
    }

    public final Object fromJson(String s, Class class1)
        throws JsonSyntaxException
    {
        s = ((String) (fromJson(s, ((Type) (class1)))));
        return Primitives.wrap(class1).cast(s);
    }

    public final TypeAdapter getAdapter(TypeToken typetoken)
    {
        Object obj;
        boolean flag;
        obj = (TypeAdapter)typeTokenCache.get(typetoken);
        if (obj != null)
        {
            return ((TypeAdapter) (obj));
        }
        Object obj1 = (Map)calls.get();
        flag = false;
        obj = obj1;
        if (obj1 == null)
        {
            obj = new HashMap();
            calls.set(obj);
            flag = true;
        }
        obj1 = (FutureTypeAdapter)((Map) (obj)).get(typetoken);
        if (obj1 != null)
        {
            return ((TypeAdapter) (obj1));
        }
        FutureTypeAdapter futuretypeadapter;
        Iterator iterator;
        futuretypeadapter = new FutureTypeAdapter();
        ((Map) (obj)).put(typetoken, futuretypeadapter);
        iterator = factories.iterator();
        TypeAdapter typeadapter;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_180;
            }
            typeadapter = ((TypeAdapterFactory)iterator.next()).create(this, typetoken);
        } while (typeadapter == null);
        futuretypeadapter.setDelegate(typeadapter);
        typeTokenCache.put(typetoken, typeadapter);
        ((Map) (obj)).remove(typetoken);
        if (flag)
        {
            calls.remove();
        }
        return typeadapter;
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(typetoken).toString());
        Exception exception;
        exception;
        ((Map) (obj)).remove(typetoken);
        if (flag)
        {
            calls.remove();
        }
        throw exception;
    }

    public final TypeAdapter getAdapter(Class class1)
    {
        return getAdapter(TypeToken.get(class1));
    }

    public final TypeAdapter getDelegateAdapter(TypeAdapterFactory typeadapterfactory, TypeToken typetoken)
    {
        boolean flag = false;
        for (Iterator iterator = factories.iterator(); iterator.hasNext();)
        {
            Object obj = (TypeAdapterFactory)iterator.next();
            if (!flag)
            {
                if (obj == typeadapterfactory)
                {
                    flag = true;
                }
            } else
            {
                obj = ((TypeAdapterFactory) (obj)).create(this, typetoken);
                if (obj != null)
                {
                    return ((TypeAdapter) (obj));
                }
            }
        }

        throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(typetoken).toString());
    }

    public final String toJson(Object obj)
    {
        if (obj == null)
        {
            return toJson(((JsonElement) (JsonNull.INSTANCE)));
        } else
        {
            return toJson(obj, ((Type) (obj.getClass())));
        }
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(serializeNulls).append("factories:").append(factories).append(",instanceCreators:").append(constructorConstructor).append("}").toString();
    }

}
