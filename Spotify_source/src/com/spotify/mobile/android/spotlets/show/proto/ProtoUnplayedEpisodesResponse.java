// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.mobile.android.spotlets.show.proto;

import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;

public final class ProtoUnplayedEpisodesResponse extends Message
{

    public static final List DEFAULT_ITEM = Collections.emptyList();
    public static final Boolean DEFAULT_LOADING_CONTENTS = Boolean.valueOf(false);
    public static final Integer DEFAULT_UNFILTERED_LENGTH = Integer.valueOf(0);
    public static final Integer DEFAULT_UNRANGED_LENGTH = Integer.valueOf(0);
    public final List item;
    public final Boolean loading_contents;
    public final Integer unfiltered_length;
    public final Integer unranged_length;

    private ProtoUnplayedEpisodesResponse(Builder builder)
    {
        super(builder);
        item = e(builder.item);
        unfiltered_length = builder.unfiltered_length;
        unranged_length = builder.unranged_length;
        loading_contents = builder.loading_contents;
    }

    ProtoUnplayedEpisodesResponse(Builder builder, byte byte0)
    {
        this(builder);
    }

    static List a(List list)
    {
        return d(list);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ProtoUnplayedEpisodesResponse))
            {
                return false;
            }
            obj = (ProtoUnplayedEpisodesResponse)obj;
            if (!a(item, ((ProtoUnplayedEpisodesResponse) (obj)).item) || !a(unfiltered_length, ((ProtoUnplayedEpisodesResponse) (obj)).unfiltered_length) || !a(unranged_length, ((ProtoUnplayedEpisodesResponse) (obj)).unranged_length) || !a(loading_contents, ((ProtoUnplayedEpisodesResponse) (obj)).loading_contents))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i1 = 0;
        int j = hashCode;
        int i = j;
        if (j == 0)
        {
            int k;
            int l;
            if (item != null)
            {
                i = item.hashCode();
            } else
            {
                i = 1;
            }
            if (unfiltered_length != null)
            {
                k = unfiltered_length.hashCode();
            } else
            {
                k = 0;
            }
            if (unranged_length != null)
            {
                l = unranged_length.hashCode();
            } else
            {
                l = 0;
            }
            if (loading_contents != null)
            {
                i1 = loading_contents.hashCode();
            }
            i = (l + (k + i * 37) * 37) * 37 + i1;
            hashCode = i;
        }
        return i;
    }


    private class Builder extends gxc
    {

        public List item;
        public Boolean loading_contents;
        public Integer unfiltered_length;
        public Integer unranged_length;

        public final ProtoUnplayedEpisodesResponse build()
        {
            return new ProtoUnplayedEpisodesResponse(this, (byte)0);
        }

        public final volatile Message build()
        {
            return build();
        }

        public final Builder item(List list)
        {
            item = checkForNulls(list);
            return this;
        }

        public final Builder loading_contents(Boolean boolean1)
        {
            loading_contents = boolean1;
            return this;
        }

        public final Builder unfiltered_length(Integer integer)
        {
            unfiltered_length = integer;
            return this;
        }

        public final Builder unranged_length(Integer integer)
        {
            unranged_length = integer;
            return this;
        }

        public Builder()
        {
        }

        public Builder(ProtoUnplayedEpisodesResponse protounplayedepisodesresponse)
        {
            super(protounplayedepisodesresponse);
            if (protounplayedepisodesresponse == null)
            {
                return;
            } else
            {
                item = ProtoUnplayedEpisodesResponse.a(protounplayedepisodesresponse.item);
                unfiltered_length = protounplayedepisodesresponse.unfiltered_length;
                unranged_length = protounplayedepisodesresponse.unranged_length;
                loading_contents = protounplayedepisodesresponse.loading_contents;
                return;
            }
        }
    }

}
