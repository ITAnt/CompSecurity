// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nbcsports.liveextra.content.models.overlay.premierleague;

import java.util.List;

public class Plays
{
    public class PlayByPlay
    {

        String eid;
        int minute;
        int period;
        List pids;
        String playDesc;
        int second;
        final Plays this$0;
        String timeStamp;

        public String getEid()
        {
            return eid;
        }

        public int getMinute()
        {
            return minute;
        }

        public int getPeriod()
        {
            return period;
        }

        public List getPids()
        {
            return pids;
        }

        public String getPlayDesc()
        {
            return playDesc;
        }

        public int getSecond()
        {
            return second;
        }

        public String getTimeStamp()
        {
            return timeStamp;
        }

        public PlayByPlay()
        {
            this$0 = Plays.this;
            super();
        }
    }


    List plays;

    public Plays()
    {
    }

    public List getPlays()
    {
        return plays;
    }
}
