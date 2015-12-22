// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.metric.EventType;

public final class NetworkEventType extends Enum
    implements EventType
{

    public static final NetworkEventType CONNECT_ERROR;
    public static final NetworkEventType FETCH_COMPLETE;
    public static final NetworkEventType RENDER_COMPLETE;
    public static final NetworkEventType RENDER_TIMEOUT;
    public static final NetworkEventType RESPONSE_ERROR;
    private static final NetworkEventType b[];
    private int a;

    private NetworkEventType(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static NetworkEventType valueOf(String s)
    {
        return (NetworkEventType)Enum.valueOf(com/inmobi/monetization/internal/configs/NetworkEventType, s);
    }

    public static NetworkEventType[] values()
    {
        return (NetworkEventType[])b.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        FETCH_COMPLETE = new NetworkEventType("FETCH_COMPLETE", 0, 0);
        RENDER_COMPLETE = new NetworkEventType("RENDER_COMPLETE", 1, 1);
        CONNECT_ERROR = new NetworkEventType("CONNECT_ERROR", 2, 2);
        RESPONSE_ERROR = new NetworkEventType("RESPONSE_ERROR", 3, 3);
        RENDER_TIMEOUT = new NetworkEventType("RENDER_TIMEOUT", 4, 4);
        b = (new NetworkEventType[] {
            FETCH_COMPLETE, RENDER_COMPLETE, CONNECT_ERROR, RESPONSE_ERROR, RENDER_TIMEOUT
        });
    }
}
