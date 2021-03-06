// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl
    implements Events
{
    private static abstract class LoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.event.Events.LoadEventsResult O(Status status)
        {
            return new com.google.android.gms.games.event.Events.LoadEventsResult(this, status) {

                final Status CW;
                final LoadImpl Ys;

                public EventBuffer getEvents()
                {
                    return new EventBuffer(DataHolder.as(14));
                }

                public Status getStatus()
                {
                    return CW;
                }

                public void release()
                {
                }

            
            {
                Ys = loadimpl;
                CW = status;
                super();
            }
            };
        }

        public Result c(Status status)
        {
            return O(status);
        }

        private LoadImpl()
        {
        }

    }

    private static abstract class UpdateImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public Result c(Status status)
        {
            return new Result(this, status) {

                final Status CW;
                final UpdateImpl Yt;

                public Status getStatus()
                {
                    return CW;
                }

            
            {
                Yt = updateimpl;
                CW = status;
                super();
            }
            };
        }

        private UpdateImpl()
        {
        }

    }


    public EventsImpl()
    {
    }

    public void increment(GoogleApiClient googleapiclient, String s, int i)
    {
        GamesClientImpl gamesclientimpl = Games.d(googleapiclient);
        if (gamesclientimpl.isConnected())
        {
            gamesclientimpl.n(s, i);
            return;
        } else
        {
            googleapiclient.b(new UpdateImpl(s, i) {

                final EventsImpl Yp;
                final String Yq;
                final int Yr;

                public volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((GamesClientImpl)a1);
                }

                public void a(GamesClientImpl gamesclientimpl1)
                {
                    gamesclientimpl1.n(Yq, Yr);
                }

            
            {
                Yp = EventsImpl.this;
                Yq = s;
                Yr = i;
                super();
            }
            });
            return;
        }
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new LoadImpl(flag) {

            final boolean Yf;
            final EventsImpl Yp;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((GamesClientImpl)a1);
            }

            public void a(GamesClientImpl gamesclientimpl)
            {
                gamesclientimpl.d(this, Yf);
            }

            
            {
                Yp = EventsImpl.this;
                Yf = flag;
                super();
            }
        });
    }

    public transient PendingResult loadByIds(GoogleApiClient googleapiclient, boolean flag, String as[])
    {
        return googleapiclient.a(new LoadImpl(flag, as) {

            final boolean Yf;
            final String Yo[];
            final EventsImpl Yp;

            public volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((GamesClientImpl)a1);
            }

            public void a(GamesClientImpl gamesclientimpl)
            {
                gamesclientimpl.a(this, Yf, Yo);
            }

            
            {
                Yp = EventsImpl.this;
                Yf = flag;
                Yo = as;
                super();
            }
        });
    }
}
