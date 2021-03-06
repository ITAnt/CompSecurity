// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.mobile.android.spotlets.appprotocol.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotify.mobile.android.cosmos.JacksonModel;
import com.spotify.mobile.android.cosmos.player.v2.PlayerState;
import com.spotify.mobile.android.cosmos.player.v2.PlayerTrack;
import com.spotify.mobile.android.service.media.MediaAction;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.spotify.mobile.android.spotlets.appprotocol.model:
//            AppProtocol

public class imageId
    implements JacksonModel
{

    public static final String TYPE_NO_TRACK = "no_track";
    public static final String TYPE_TRACK = "track";
    public imageId album;
    public imageId artist;
    public boolean canMute;
    public boolean canPause;
    public boolean canPeekNext;
    public boolean canPeekPrev;
    public boolean canRate;
    public boolean canResume;
    public boolean canSave;
    public boolean canSeek;
    public boolean canShowMoreAlbums;
    public boolean canSkipNext;
    public boolean canSkipPrev;
    public boolean canStartRadio;
    public int durationMs;
    public String imageId;
    public String name;
    public int rated;
    public boolean saved;
    public int trackNumber;
    public String type;
    public String uri;

    public static imageId trackDataFor(PlayerState playerstate, List list)
    {
        if (playerstate == null)
        {
            return AppProtocol.a;
        }
        Object obj = playerstate.track();
        if (obj == null)
        {
            return AppProtocol.a;
        }
        Map map = ((PlayerTrack) (obj)).metadata();
        imageId imageid = new t>((String)map.get("album_title"), (String)map.get("album_uri"));
        imageId imageid1 = new it>((String)map.get("artist_name"), (String)map.get("artist_uri"));
        int i = 0;
        String s;
        int j;
        int k;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if (list.contains(MediaAction.h))
        {
            i = 1;
        } else
        if (list.contains(MediaAction.j))
        {
            i = -1;
        }
        s = (String)playerstate.track().metadata().get("album_track_number");
        k = (int)playerstate.duration();
        playerstate = (String)map.get("title");
        if (s == null)
        {
            j = 0;
        } else
        {
            j = Integer.parseInt(s);
        }
        obj = ((PlayerTrack) (obj)).uri();
        flag4 = list.contains(MediaAction.m);
        if (list.contains(MediaAction.m) || list.contains(MediaAction.l))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (list.contains(MediaAction.i) || list.contains(MediaAction.g) || list.contains(MediaAction.h))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag5 = list.contains(MediaAction.k);
        flag6 = list.contains(MediaAction.c);
        flag7 = list.contains(MediaAction.d);
        if (list.contains(MediaAction.a) || list.contains(MediaAction.b))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (list.contains(MediaAction.a) || list.contains(MediaAction.b))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        return new <init>(imageid, imageid1, k, playerstate, j, "track", ((String) (obj)), flag4, i, flag, flag1, flag5, false, flag6, flag7, flag2, flag3, false, (String)map.get("image_url"));
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (<init>)obj;
        if (trackNumber != ((trackNumber) (obj)).trackNumber)
        {
            return false;
        }
        if (saved != ((saved) (obj)).saved)
        {
            return false;
        }
        if (rated != ((rated) (obj)).rated)
        {
            return false;
        }
        if (canSave != ((canSave) (obj)).canSave)
        {
            return false;
        }
        if (canRate != ((canRate) (obj)).canRate)
        {
            return false;
        }
        if (canStartRadio != ((canStartRadio) (obj)).canStartRadio)
        {
            return false;
        }
        if (canShowMoreAlbums != ((canShowMoreAlbums) (obj)).canShowMoreAlbums)
        {
            return false;
        }
        if (canSkipNext != ((canSkipNext) (obj)).canSkipNext)
        {
            return false;
        }
        if (canSkipPrev != ((canSkipPrev) (obj)).canSkipPrev)
        {
            return false;
        }
        if (canPeekNext != ((canPeekNext) (obj)).canPeekNext)
        {
            return false;
        }
        if (canPeekPrev != ((canPeekPrev) (obj)).canPeekPrev)
        {
            return false;
        }
        if (canPause != ((canPause) (obj)).canPause)
        {
            return false;
        }
        if (canResume != ((canResume) (obj)).canResume)
        {
            return false;
        }
        if (canSeek != ((canSeek) (obj)).canSeek)
        {
            return false;
        }
        if (canMute != ((canMute) (obj)).canMute)
        {
            return false;
        }
        if (type == null ? ((type) (obj)).type != null : !type.equals(((type) (obj)).type))
        {
            return false;
        }
        if (uri == null ? ((uri) (obj)).uri != null : !uri.equals(((uri) (obj)).uri))
        {
            return false;
        }
        if (imageId == null) goto _L4; else goto _L3
_L3:
        if (imageId.equals(((imageId) (obj)).imageId)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((imageId) (obj)).imageId == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int k3 = 1;
        int l3 = 0;
        int i4 = trackNumber;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int j4;
        if (type != null)
        {
            i = type.hashCode();
        } else
        {
            i = 0;
        }
        if (uri != null)
        {
            j = uri.hashCode();
        } else
        {
            j = 0;
        }
        if (saved)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        j4 = rated;
        if (canSave)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (canRate)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (canStartRadio)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (canShowMoreAlbums)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (canSkipNext)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (canSkipPrev)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        if (canPeekNext)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        if (canPeekPrev)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (canPause)
        {
            l2 = 1;
        } else
        {
            l2 = 0;
        }
        if (canResume)
        {
            i3 = 1;
        } else
        {
            i3 = 0;
        }
        if (canSeek)
        {
            j3 = 1;
        } else
        {
            j3 = 0;
        }
        if (!canMute)
        {
            k3 = 0;
        }
        if (imageId != null)
        {
            l3 = imageId.hashCode();
        }
        return ((j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + ((k + (j + (i + i4 * 31) * 31) * 31) * 31 + j4) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k3) * 31 + l3;
    }

    public String toString()
    {
        String s;
        try
        {
            s = AppProtocol.a().writeValueAsString(this);
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            return (new StringBuilder("{")).append(getClass().getSimpleName()).append("}").toString();
        }
        return s;
    }

    public Q(Q q, Q q1, int i, String s, int j, String s1, String s2, 
            boolean flag, int k, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            boolean flag6, boolean flag7, boolean flag8, boolean flag9, String s3)
    {
        album = q;
        artist = q1;
        durationMs = i;
        name = s;
        trackNumber = j;
        type = s1;
        uri = s2;
        saved = flag;
        rated = k;
        canSave = flag1;
        canRate = flag2;
        canStartRadio = flag3;
        canShowMoreAlbums = flag4;
        canSkipNext = flag5;
        canSkipPrev = flag6;
        canPause = flag7;
        canResume = flag8;
        canSeek = flag9;
        imageId = s3;
    }
}
