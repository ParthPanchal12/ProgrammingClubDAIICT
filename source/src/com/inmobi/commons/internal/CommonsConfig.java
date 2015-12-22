// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDMapConfigParams;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.internal:
//            InternalSDKUtil, Log

public class CommonsConfig
{

    private static Log.INTERNAL_LOG_LEVEL a;
    private static Log.INTERNAL_LOG_LEVEL b;
    private MetricConfigParams c;

    public CommonsConfig()
    {
        c = new MetricConfigParams();
    }

    protected static int getLogLevelConfig()
    {
        return b.getValue();
    }

    public MetricConfigParams getApiStatsConfig()
    {
        return c;
    }

    public final void setFromMap(Map map)
        throws Exception
    {
        map = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
        UIDMapConfigParams uidmapconfigparams = new UIDMapConfigParams();
        uidmapconfigparams.setMap(InternalSDKUtil.getObjectFromMap(map, "ids"));
        UID.getInstance().setCommonsDeviceIdMaskMap(uidmapconfigparams.getMap());
        b = Log.getLogLevelValue(InternalSDKUtil.getIntFromMap(map, "ll", 0, 2L));
        c.setFromMap((Map)map.get("api"));
    }

    static 
    {
        a = Log.INTERNAL_LOG_LEVEL.NONE;
        b = a;
    }
}
