// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

public interface DateTimePrinter
{

    public abstract int estimatePrintedLength();

    public abstract void printTo(Writer writer, long l, Chronology chronology, int i, DateTimeZone datetimezone, Locale locale)
        throws IOException;

    public abstract void printTo(Writer writer, ReadablePartial readablepartial, Locale locale)
        throws IOException;

    public abstract void printTo(StringBuffer stringbuffer, long l, Chronology chronology, int i, DateTimeZone datetimezone, Locale locale);

    public abstract void printTo(StringBuffer stringbuffer, ReadablePartial readablepartial, Locale locale);
}
