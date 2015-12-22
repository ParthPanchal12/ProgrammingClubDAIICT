// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UIDMapConfigParams;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization.internal.configs:
//            IMAIConfigParams, NativeConfigParams, PlayableAdsConfigParams

public class ConfigParams
{

    int a;
    int b;
    int c;
    int d;
    IMAIConfigParams e;
    MetricConfigParams f;
    NativeConfigParams g;
    PlayableAdsConfigParams h;
    private UIDMapConfigParams i;

    public ConfigParams()
    {
        a = 20;
        b = 60;
        c = 60;
        d = 60;
        e = new IMAIConfigParams();
        f = new MetricConfigParams();
        i = new UIDMapConfigParams();
        g = new NativeConfigParams();
        h = new PlayableAdsConfigParams();
    }

    public int getDefaultRefreshRate()
    {
        return b;
    }

    public Map getDeviceIdMaskMap()
    {
        return i.getMap();
    }

    public int getFetchTimeOut()
    {
        return c * 1000;
    }

    public IMAIConfigParams getImai()
    {
        return e;
    }

    public MetricConfigParams getMetric()
    {
        return f;
    }

    public int getMinimumRefreshRate()
    {
        return a;
    }

    public NativeConfigParams getNativeSdkConfigParams()
    {
        return g;
    }

    public PlayableAdsConfigParams getPlayableConfigParams()
    {
        return h;
    }

    public int getRenderTimeOut()
    {
        return d * 1000;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getIntFromMap(map, "mrr", 1, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "drr", -1, 0x7fffffffL);
        c = InternalSDKUtil.getIntFromMap(map, "fto", 1, 0x7fffffffL);
        d = InternalSDKUtil.getIntFromMap(map, "rto", 1, 0x7fffffffL);
        e.setFromMap((Map)map.get("imai"));
        f.setFromMap((Map)map.get("metric"));
        i.setMap(InternalSDKUtil.getObjectFromMap(map, "ids"));
        g.setFromMap((Map)map.get("native"));
        h.setFromMap((Map)map.get("playable"));
    }
}
