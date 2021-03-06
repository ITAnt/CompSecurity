// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.skippy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NetworkConnectivityListener
{
    private class ConnectivityBroadcastReceiver extends BroadcastReceiver
    {

        final NetworkConnectivityListener this$0;

        public void onReceive(Context context1, Intent intent)
        {
            if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || context == null)
            {
                (new StringBuilder("onReceived() called with ")).append(state.toString()).append(" and ").append(intent);
            } else
            {
                intent = state;
                context1 = (ConnectivityManager)context1.getSystemService("connectivity");
                networkInfo = context1.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected())
                {
                    state = State.CONNECTED;
                } else
                {
                    state = State.NOT_CONNECTED;
                }
                context1 = handlers.keySet().iterator();
                while (context1.hasNext()) 
                {
                    Handler handler = (Handler)context1.next();
                    handler.sendMessage(Message.obtain(handler, ((Integer)handlers.get(handler)).intValue(), intent.ordinal(), state.ordinal(), networkInfo));
                }
            }
        }

        private ConnectivityBroadcastReceiver()
        {
            this$0 = NetworkConnectivityListener.this;
            super();
        }

        ConnectivityBroadcastReceiver(_cls1 _pcls1)
        {
            this();
        }
    }

    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State CONNECTED;
        public static final State NOT_CONNECTED;
        public static final State UNKNOWN;
        public static final State values[] = values();

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/soundcloud/android/skippy/NetworkConnectivityListener$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new State("UNKNOWN", 0);
            CONNECTED = new State("CONNECTED", 1);
            NOT_CONNECTED = new State("NOT_CONNECTED", 2);
            $VALUES = (new State[] {
                UNKNOWN, CONNECTED, NOT_CONNECTED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = "ConnectivityListener";
    private Context context;
    private final Map handlers = new HashMap();
    private NetworkInfo networkInfo;
    private NetworkInfo otherNetworkInfo;
    private final ConnectivityBroadcastReceiver receiver = new ConnectivityBroadcastReceiver(null);
    private State state;

    public NetworkConnectivityListener()
    {
        state = State.UNKNOWN;
    }

    public NetworkInfo getNetworkInfo()
    {
        return networkInfo;
    }

    public NetworkInfo getOtherNetworkInfo()
    {
        return otherNetworkInfo;
    }

    public State getState()
    {
        return state;
    }

    public NetworkConnectivityListener registerHandler(Handler handler, int i)
    {
        handlers.put(handler, Integer.valueOf(i));
        return this;
    }

    public NetworkConnectivityListener startListening(Context context1)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null)
        {
            context = context1;
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context1.registerReceiver(receiver, intentfilter);
        }
        this;
        JVM INSTR monitorexit ;
        return this;
        context1;
        throw context1;
    }

    public void stopListening()
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null)
        {
            context.unregisterReceiver(receiver);
            context = null;
            networkInfo = null;
            otherNetworkInfo = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public NetworkConnectivityListener unregisterHandler(Handler handler)
    {
        handlers.remove(handler);
        return this;
    }




/*
    static State access$202(NetworkConnectivityListener networkconnectivitylistener, State state1)
    {
        networkconnectivitylistener.state = state1;
        return state1;
    }

*/



/*
    static NetworkInfo access$302(NetworkConnectivityListener networkconnectivitylistener, NetworkInfo networkinfo)
    {
        networkconnectivitylistener.networkInfo = networkinfo;
        return networkinfo;
    }

*/

}
