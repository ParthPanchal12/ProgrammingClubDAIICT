// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.yeahmobi.android.common.util:
//            Utils, VersionCode

public class DeviceUtils
{
    public static final class IP extends Enum
    {

        private static final IP $VALUES[];
        public static final IP IPv4;
        public static final IP IPv6;

        private boolean matches(String s)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP[];

                static 
                {
                    $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP = new int[IP.values().length];
                    try
                    {
                        $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP[IP.IPv4.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP[IP.IPv6.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.yeahmobi.android.common.util.DeviceUtils.IP[ordinal()])
            {
            default:
                return false;

            case 1: // '\001'
                return InetAddressUtils.isIPv4Address(s);

            case 2: // '\002'
                return InetAddressUtils.isIPv6Address(s);
            }
        }

        private String toString(String s)
        {
            String s1 = s;
            switch (_cls1..SwitchMap.com.yeahmobi.android.common.util.DeviceUtils.IP[ordinal()])
            {
            default:
                s1 = null;
                // fall through

            case 1: // '\001'
                return s1;

            case 2: // '\002'
                return s.split("%")[0];
            }
        }

        public static IP valueOf(String s)
        {
            return (IP)Enum.valueOf(com/yeahmobi/android/common/util/DeviceUtils$IP, s);
        }

        public static IP[] values()
        {
            return (IP[])$VALUES.clone();
        }

        static 
        {
            IPv4 = new IP("IPv4", 0);
            IPv6 = new IP("IPv6", 1);
            $VALUES = (new IP[] {
                IPv4, IPv6
            });
        }



        private IP(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int MAX_DISK_CACHE_SIZE = 0x6400000;
    private static final int MAX_MEMORY_CACHE_SIZE = 0x1e00000;
    private static final int MIN_DISK_CACHE_SIZE = 0x1e00000;

    private DeviceUtils()
    {
    }

    public static long diskCacheSizeBytes(File file)
    {
        long l = 0x1e00000L;
        long l1;
        file = new StatFs(file.getAbsolutePath());
        l1 = ((long)file.getBlockCount() * (long)file.getBlockSize()) / 50L;
        l = l1;
_L2:
        return Math.max(Math.min(l, 0x6400000L), 0x1e00000L);
        file;
        Log.d("YeahMobi", "Unable to calculate 2% of available disk space, defaulting to minimum");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getHashedUdid(Context context)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return Utils.sha1(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
        }
    }

    public static String getIpAddress(IP ip)
        throws SocketException
    {
        Iterator iterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
_L2:
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        iterator1 = Collections.list(((NetworkInterface)iterator.next()).getInetAddresses()).iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (InetAddress)iterator1.next();
        if (((InetAddress) (obj)).isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        obj = ((InetAddress) (obj)).getHostAddress().toUpperCase();
        if (!ip.matches(((String) (obj)))) goto _L4; else goto _L5
_L5:
        return ip.toString(((String) (obj)));
        return null;
    }

    public static String getUserAgent()
    {
        return System.getProperty("http.agent");
    }

    public static boolean isNetworkAvailable(Context context)
    {
        while (context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) 
        {
            return false;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static int memoryCacheSizeBytes(Context context)
    {
        ActivityManager activitymanager;
        long l;
        long l1;
        activitymanager = (ActivityManager)context.getSystemService("activity");
        l1 = activitymanager.getMemoryClass();
        l = l1;
        if (!VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        int i = android/content/pm/ApplicationInfo.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
        l = l1;
        if (!Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, i))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        i = ((Integer)(new Reflection.MethodBuilder(activitymanager, "getLargeMemoryClass")).execute()).intValue();
        l = i;
_L2:
        return (int)Math.min(0x1e00000L, (l / 8L) * 1024L * 1024L);
        context;
        Log.d("YeahMobi", "Unable to reflectively determine large heap size on Honeycomb and above.");
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
