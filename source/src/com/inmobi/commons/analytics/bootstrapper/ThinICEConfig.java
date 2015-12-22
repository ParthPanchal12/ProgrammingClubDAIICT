// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class ThinICEConfig
{

    public static final int CELL_OP_FLAGS_DEFAULT = 0;
    public static final boolean ENABLED_DEFAULT = true;
    public static final String END_POINT_DEFAULT = "https://sdkm.w.inmobi.com/user/e.asm";
    public static final long MAX_RETRY_DEFAULT = 3L;
    public static final long RETRY_INTERVAL = 3L;
    public static final boolean SAMPLE_CELL_CONNECTED_WIFI_ENABLED_DEFAULT = true;
    public static final boolean SAMPLE_CELL_ENABLED_DEFAULT = true;
    public static final boolean SAMPLE_CELL_OPERATOR_ENABLED_DEFAULT = true;
    public static final boolean SAMPLE_CELL_VISIBLE_CELL_TOWER_ENABLED_DEFAULT = true;
    public static final boolean SAMPLE_CELL_VISIBLE_WIFI_ENABLED_DEFAULT = true;
    public static final int SAMPLE_HISTORY_SIZE_DEFAULT = 50;
    public static final long SAMPLE_INTERVAL_DEFAULT = 60L;
    public static final long STOP_REQUEST_TIMEOUT_DEFAULT = 3L;
    public static final int WIFI_FLAGS_DEFAULT = 0;
    private long a;
    private long b;
    private long c;
    private long d;
    private int e;
    private int f;
    private int g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private long p;
    private long q;

    public ThinICEConfig()
    {
        a = 60L;
        b = 3L;
        c = 3L;
        d = 3L;
        e = 50;
        f = 0;
        g = 0;
        h = "https://sdkm.w.inmobi.com/user/e.asm";
        i = true;
        j = true;
        k = true;
        l = true;
        m = true;
        n = true;
        o = false;
        p = 180L;
        q = 50L;
    }

    public long getActivityDetectionInterval()
    {
        return p * 1000L;
    }

    public long getActivityDetectionMaxSize()
    {
        return q;
    }

    public int getCellOpsFlag()
    {
        return g;
    }

    public String getEndpointUrl()
    {
        return h;
    }

    public long getMaxRetry()
    {
        return d;
    }

    public long getRetryInterval()
    {
        return c;
    }

    public int getSampleHistorySize()
    {
        return e;
    }

    public long getSampleInterval()
    {
        return a;
    }

    public long getStopRequestTimeout()
    {
        return b;
    }

    public int getWifiFlags()
    {
        return f;
    }

    public boolean isActivityDetectionEnabled()
    {
        return o;
    }

    public boolean isCellEnabled()
    {
        return k;
    }

    public boolean isConnectedWifiEnabled()
    {
        return l;
    }

    public boolean isEnabled()
    {
        return i;
    }

    public boolean isOperatorEnabled()
    {
        return j;
    }

    public boolean isVisibleCellTowerEnabled()
    {
        return n;
    }

    public boolean isVisibleWifiEnabled()
    {
        return m;
    }

    public final void setFromMap(Map map)
    {
        a = InternalSDKUtil.getLongFromMap(map, "si", 1L, 0x7fffffffffffffffL);
        b = InternalSDKUtil.getLongFromMap(map, "srt", 1L, 0x7fffffffffffffffL);
        e = InternalSDKUtil.getIntFromMap(map, "shs", 1, 0x7fffffffL);
        f = InternalSDKUtil.getIntFromMap(map, "wfd", 0, 15L);
        g = InternalSDKUtil.getIntFromMap(map, "cof", 0, 15L);
        i = InternalSDKUtil.getBooleanFromMap(map, "e");
        l = InternalSDKUtil.getBooleanFromMap(map, "sccw");
        k = InternalSDKUtil.getBooleanFromMap(map, "sced");
        j = InternalSDKUtil.getBooleanFromMap(map, "scoe");
        m = InternalSDKUtil.getBooleanFromMap(map, "scvw");
        n = InternalSDKUtil.getBooleanFromMap(map, "scvc");
        h = InternalSDKUtil.getStringFromMap(map, "ep");
        d = InternalSDKUtil.getLongFromMap(map, "mr", 0L, 0x7fffffffffffffffL);
        c = InternalSDKUtil.getLongFromMap(map, "ri", 1L, 0x7fffffffffffffffL);
        o = InternalSDKUtil.getBooleanFromMap(map, "as");
        p = InternalSDKUtil.getLongFromMap(map, "assi", 1L, 0x7fffffffffffffffL);
        q = InternalSDKUtil.getLongFromMap(map, "asm", 1L, 0x7fffffffffffffffL);
    }
}
