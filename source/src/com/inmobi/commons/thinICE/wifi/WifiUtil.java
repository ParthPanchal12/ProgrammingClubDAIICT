// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.thinICE.wifi:
//            WifiInfo

public final class WifiUtil
{

    private static final String a[] = {
        "android.permission.ACCESS_WIFI_STATE"
    };
    private static final String b[] = {
        "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"
    };
    private static final String c[] = {
        "android.permission.WAKE_LOCK"
    };

    public WifiUtil()
    {
    }

    private static long a(byte byte0)
    {
        return (long)byte0 & 255L;
    }

    private static long a(byte abyte0[])
    {
        long l1 = 0L;
        long l = l1;
        if (abyte0 != null)
        {
            l = l1;
            if (abyte0.length == 6)
            {
                l = a(abyte0[5]) | a(abyte0[4]) << 8 | a(abyte0[3]) << 16 | a(abyte0[2]) << 24 | a(abyte0[1]) << 32 | a(abyte0[0]) << 40;
            }
        }
        return l;
    }

    private static boolean a(boolean flag, String s)
    {
        return flag && s != null && s.endsWith("_nomap");
    }

    public static com.inmobi.commons.thinICE.wifi.WifiInfo getConnectedWifiInfo(Context context)
    {
        int i = IceDataCollector.getConfig().getWifiFlags();
        boolean flag;
        if (!ThinICEConfigSettings.bitTest(i, 2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return getConnectedWifiInfo(context, flag, ThinICEConfigSettings.bitTest(i, 1));
    }

    public static com.inmobi.commons.thinICE.wifi.WifiInfo getConnectedWifiInfo(Context context, boolean flag, boolean flag1)
    {
        WifiInfo wifiinfo = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
        if (wifiinfo != null)
        {
            com.inmobi.commons.thinICE.wifi.WifiInfo wifiinfo1 = new com.inmobi.commons.thinICE.wifi.WifiInfo();
            String s = wifiinfo.getBSSID();
            context = wifiinfo.getSSID();
            if (s != null && !a(flag, context))
            {
                wifiinfo1.bssid = macToLong(s);
                if (flag1)
                {
                    context = null;
                }
                wifiinfo1.ssid = context;
                wifiinfo1.rssi = wifiinfo.getRssi();
                wifiinfo1.ip = wifiinfo.getIpAddress();
                return wifiinfo1;
            }
        }
        return null;
    }

    public static boolean hasGetConnectedWifiInfoPermission(Context context)
    {
        String as[] = a;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (context.checkCallingOrSelfPermission(as[i]) != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean hasWifiScanPermission(Context context, boolean flag)
    {
        String as[];
        int i;
        int k;
        as = b;
        k = as.length;
        i = 0;
_L7:
        if (i >= k) goto _L2; else goto _L1
_L1:
        if (context.checkCallingOrSelfPermission(as[i]) == 0) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
label0:
        {
            if (!flag)
            {
                break label0;
            }
            String as1[] = c;
            int l = as1.length;
            int j = 0;
            do
            {
                if (j >= l)
                {
                    break label0;
                }
                if (context.checkCallingOrSelfPermission(as1[j]) != 0)
                {
                    break;
                }
                j++;
            } while (true);
        }
        if (true) goto _L3; else goto _L5
_L5:
        return true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static long macToLong(String s)
    {
        s = s.split("\\:");
        byte abyte0[] = new byte[6];
        for (int i = 0; i < 6; i++)
        {
            abyte0[i] = (byte)Integer.parseInt(s[i], 16);
        }

        return a(abyte0);
    }

    public static com.inmobi.commons.thinICE.wifi.WifiInfo scanResultToWifiInfo(ScanResult scanresult, boolean flag)
    {
        String s = null;
        if (scanresult == null)
        {
            return null;
        }
        com.inmobi.commons.thinICE.wifi.WifiInfo wifiinfo = new com.inmobi.commons.thinICE.wifi.WifiInfo();
        wifiinfo.bssid = macToLong(scanresult.BSSID);
        if (!flag)
        {
            s = scanresult.SSID;
        }
        wifiinfo.ssid = s;
        wifiinfo.rssi = scanresult.level;
        return wifiinfo;
    }

    public static List scanResultsToWifiInfos(List list, boolean flag, boolean flag1)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ScanResult scanresult = (ScanResult)list.next();
            if (!a(flag, scanresult.SSID))
            {
                arraylist.add(scanResultToWifiInfo(scanresult, flag1));
            }
        } while (true);
        return arraylist;
    }

}
