// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class NativeConfigParams
{

    int a;
    int b;
    int c;
    long d;

    public NativeConfigParams()
    {
        a = 100;
        b = 1;
        c = 2;
        d = 3300L;
    }

    public long getTimeToLive()
    {
        return d;
    }

    public int getmFetchLimit()
    {
        return c;
    }

    public int getmMaxCacheSize()
    {
        return a;
    }

    public int getmMinLimit()
    {
        return b;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getIntFromMap(map, "mcl", 1, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "mt", 1, 0x7fffffffL);
        c = InternalSDKUtil.getIntFromMap(map, "fl", 1, 0x7fffffffL);
        d = InternalSDKUtil.getLongFromMap(map, "ttl", 1L, 0x7fffffffffffffffL);
    }
}
