// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;


public class ThinICEConfigSettings
{

    public static final int CELL_OP_FLAG_DISABLE_CURRENT_DETAILS = 2;
    public static final int CELL_OP_FLAG_DISABLE_SIM_DETAILS = 1;
    public static final int WIFI_FLAG_DISABLE_NOMAP_EXCLUSION = 2;
    public static final int WIFI_FLAG_DISABLE_SSID_COLLECTION = 1;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private long i;
    private int j;
    private int k;
    private int l;

    public ThinICEConfigSettings()
    {
        a = true;
        b = true;
        c = true;
        d = true;
        e = true;
        f = true;
        g = true;
        h = 60000L;
        i = 3000L;
        j = 50;
        k = 0;
        l = 0;
    }

    public ThinICEConfigSettings(ThinICEConfigSettings thiniceconfigsettings)
    {
        a = true;
        b = true;
        c = true;
        d = true;
        e = true;
        f = true;
        g = true;
        h = 60000L;
        i = 3000L;
        j = 50;
        k = 0;
        l = 0;
        a = thiniceconfigsettings.a;
        b = thiniceconfigsettings.b;
        c = thiniceconfigsettings.c;
        d = thiniceconfigsettings.d;
        e = thiniceconfigsettings.e;
        f = thiniceconfigsettings.f;
        g = thiniceconfigsettings.g;
        h = thiniceconfigsettings.h;
        i = thiniceconfigsettings.i;
        j = thiniceconfigsettings.j;
        k = thiniceconfigsettings.k;
        l = thiniceconfigsettings.l;
    }

    public static boolean bitTest(int i1, int j1)
    {
        return (i1 & j1) == j1;
    }

    public int getCellOpFlags()
    {
        return l;
    }

    public int getSampleHistorySize()
    {
        return j;
    }

    public long getSampleInterval()
    {
        return h;
    }

    public long getStopRequestTimeout()
    {
        return i;
    }

    public int getWifiFlags()
    {
        return k;
    }

    public boolean isEnabled()
    {
        return a;
    }

    public boolean isSampleCellEnabled()
    {
        return c;
    }

    public boolean isSampleCellOperatorEnabled()
    {
        return b;
    }

    public boolean isSampleConnectedWifiEnabled()
    {
        return d;
    }

    public boolean isSampleLocationEnabled()
    {
        return e;
    }

    public boolean isSampleVisibleCellTowerEnabled()
    {
        return g;
    }

    public boolean isSampleVisibleWifiEnabled()
    {
        return f;
    }

    public ThinICEConfigSettings setCellOpFlags(int i1)
    {
        l = i1;
        return this;
    }

    public ThinICEConfigSettings setEnabled(boolean flag)
    {
        a = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleCellEnabled(boolean flag)
    {
        c = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleCellOperatorEnabled(boolean flag)
    {
        b = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleConnectedWifiEnabled(boolean flag)
    {
        d = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleHistorySize(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("Sample history size must be greater than 0");
        } else
        {
            j = i1;
            return this;
        }
    }

    public ThinICEConfigSettings setSampleInterval(long l1)
    {
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("Sample interval must be greater than 0");
        } else
        {
            h = l1;
            return this;
        }
    }

    public ThinICEConfigSettings setSampleLocationEnabled(boolean flag)
    {
        e = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleVisibleCellTowerEnabled(boolean flag)
    {
        g = flag;
        return this;
    }

    public ThinICEConfigSettings setSampleVisibleWifiEnabled(boolean flag)
    {
        f = flag;
        return this;
    }

    public ThinICEConfigSettings setStopRequestTimeout(long l1)
    {
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("Stop request timeout must be greater than 0");
        } else
        {
            i = l1;
            return this;
        }
    }

    public ThinICEConfigSettings setWifiFlags(int i1)
    {
        k = i1;
        return this;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("mEnabled=").append(a).append(", ");
        stringbuilder.append("mSampleCellOperatorEnabled=").append(b).append(", ");
        stringbuilder.append("mSampleCellEnabled=").append(c).append(", ");
        stringbuilder.append("mSampleConnectedWifiEnabled=").append(d).append(", ");
        stringbuilder.append("mSampleLocationEnabled=").append(e).append(", ");
        stringbuilder.append("mSampleVisibleWifiEnabled=").append(f).append(", ");
        stringbuilder.append("mSampleVisibleCellTowerEnabled=").append(g).append(", ");
        stringbuilder.append("mSampleInterval=").append(h).append(", ");
        stringbuilder.append("mStopRequestTimeout=").append(i).append(", ");
        stringbuilder.append("mWifiFlags=").append(Integer.toBinaryString(k)).append(", ");
        stringbuilder.append("mCellOpFlags=").append(Integer.toBinaryString(l));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
