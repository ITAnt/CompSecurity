// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.b.b.a.a;
import org.b.b.b.b;

public class MovieFragmentRandomAccessOffsetBox extends AbstractFullBox
{

    public static final String TYPE = "mfro";
    private static final org.b.a.a.a ajc$tjp_0;
    private static final org.b.a.a.a ajc$tjp_1;
    private long mfraSize;

    public MovieFragmentRandomAccessOffsetBox()
    {
        super("mfro");
    }

    private static void ajc$preClinit()
    {
        b b1 = new b("MovieFragmentRandomAccessOffsetBox.java", com/coremedia/iso/boxes/fragment/MovieFragmentRandomAccessOffsetBox);
        ajc$tjp_0 = b1.a("method-execution", b1.a("1", "getMfraSize", "com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox", "", "", "", "long"), 56);
        ajc$tjp_1 = b1.a("method-execution", b1.a("1", "setMfraSize", "com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox", "long", "mfraSize", "", "void"), 60);
    }

    public void _parseDetails(ByteBuffer bytebuffer)
    {
        parseVersionAndFlags(bytebuffer);
        mfraSize = IsoTypeReader.readUInt32(bytebuffer);
    }

    protected void getContent(ByteBuffer bytebuffer)
    {
        writeVersionAndFlags(bytebuffer);
        IsoTypeWriter.writeUInt32(bytebuffer, mfraSize);
    }

    protected long getContentSize()
    {
        return 8L;
    }

    public long getMfraSize()
    {
        org.b.a.a a1 = b.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.aspectOf().before(a1);
        return mfraSize;
    }

    public void setMfraSize(long l)
    {
        org.b.a.a a1 = b.a(ajc$tjp_1, this, this, a.a(l));
        RequiresParseDetailAspect.aspectOf().before(a1);
        mfraSize = l;
    }

    static 
    {
        ajc$preClinit();
    }
}
