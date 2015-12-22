// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.common.message;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.umeng.message.proguard.an;
import com.umeng.message.proguard.ax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.umeng.common.message:
//            Log

public class DeviceConfig
{

    public static final int DEFAULT_TIMEZONE = 8;
    protected static final String a = com/umeng/common/message/DeviceConfig.getName();
    protected static final String b = "Unknown";
    private static final String c = "2G/3G";
    private static final String d = "Wi-Fi";

    public DeviceConfig()
    {
    }

    private static int a(Object obj, String s)
    {
        int i;
        try
        {
            s = android/util/DisplayMetrics.getDeclaredField(s);
            s.setAccessible(true);
            i = s.getInt(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return -1;
        }
        return i;
    }

    private static Locale a(Context context)
    {
        Object obj = null;
        Configuration configuration;
        configuration = new Configuration();
        android.provider.Settings.System.getConfiguration(context.getContentResolver(), configuration);
        context = ((Context) (obj));
        if (configuration != null)
        {
            try
            {
                context = configuration.locale;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.b(a, "fail to read user config locale");
                context = ((Context) (obj));
            }
        }
        obj = context;
        if (context == null)
        {
            obj = Locale.getDefault();
        }
        return ((Locale) (obj));
    }

    public static boolean checkPermission(Context context, String s)
    {
        return context.getPackageManager().checkPermission(s, context.getPackageName()) == 0;
    }

    public static String getAppLabel(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = null;
        }
        if (context != null)
        {
            context = packagemanager.getApplicationLabel(context);
        } else
        {
            context = "";
        }
        return (String)(String)context;
    }

    public static String getAppVersionCode(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "Unknown";
        }
        return String.valueOf(i);
    }

    public static String getAppVersionName(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "Unknown";
        }
        return context;
    }

    public static String getAppkey(Context context)
    {
        return getMetaData(context, "UMENG_APPKEY");
    }

    public static String getApplicationLable(Context context)
    {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String getCPU()
    {
        String s;
        String s1;
        s1 = null;
        s = null;
        FileReader filereader = new FileReader("/proc/cpuinfo");
        if (filereader == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        s = s1;
        BufferedReader bufferedreader = new BufferedReader(filereader, 1024);
        s = s1;
        s1 = bufferedreader.readLine();
        String s3;
        s = s1;
        s3 = s1;
        bufferedreader.close();
        s = s1;
        s3 = s1;
        filereader.close();
        s = s1;
_L2:
        String s2 = s;
        if (s != null)
        {
            s2 = s.substring(s.indexOf(':') + 1);
        }
        return s2.trim();
        Object obj;
        obj;
        s3 = s;
        Log.b(a, "Could not read from file /proc/cpuinfo", ((Exception) (obj)));
        continue; /* Loop/switch isn't completed */
        obj;
        s = s3;
_L3:
        Log.b(a, "Could not open file /proc/cpuinfo", ((Exception) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        s = null;
          goto _L3
    }

    public static String getChannel(Context context)
    {
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (((ApplicationInfo) (context)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        context = ((Context) (((ApplicationInfo) (context)).metaData.get("UMENG_CHANNEL")));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        context = context.toString();
        if (context != null)
        {
            return context;
        }
        try
        {
            Log.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            context.printStackTrace();
        }
        return "Unknown";
    }

    public static String getDeviceId(Context context)
    {
        TelephonyManager telephonymanager;
        telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager == null)
        {
            Log.e(a, "No IMEI.");
        }
        if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) goto _L2; else goto _L1
_L1:
        String s1 = telephonymanager.getDeviceId();
_L4:
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            Log.e(a, "No IMEI.");
            s1 = getMac(context);
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                Log.e(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                Log.a(a, (new StringBuilder()).append("getDeviceId: Secure.ANDROID_ID: ").append(s).toString());
            }
        }
        return s;
        Exception exception;
        exception;
        Log.e(a, "No IMEI.", exception);
_L2:
        s1 = "";
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getDeviceIdMD5(Context context)
    {
        return ax.a(getDeviceId(context));
    }

    public static String getDeviceIdUmengMD5(Context context)
    {
        return ax.b(getDeviceId(context));
    }

    public static String getDisplayResolution(Context context)
    {
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager)(WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            int i = displaymetrics.widthPixels;
            int j = displaymetrics.heightPixels;
            context = (new StringBuilder()).append(String.valueOf(j)).append("*").append(String.valueOf(i)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "Unknown";
        }
        return context;
    }

    public static String[] getGPU(GL10 gl10)
    {
        String s;
        try
        {
            s = gl10.glGetString(7936);
            gl10 = gl10.glGetString(7937);
        }
        // Misplaced declaration of an exception variable
        catch (GL10 gl10)
        {
            Log.b(a, "Could not read gpu infor:", gl10);
            return new String[0];
        }
        return (new String[] {
            s, gl10
        });
    }

    public static Set getInstalledPackages(Context context)
    {
        HashSet hashset = new HashSet();
        context = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < context.size(); i++)
        {
            hashset.add(((PackageInfo)context.get(i)).packageName);
        }

        return hashset;
    }

    public static int getIntervalSeconds(Date date, Date date1)
    {
        Date date2;
        long l;
        if (date.after(date1))
        {
            date2 = date1;
            date1 = date;
        } else
        {
            date2 = date;
        }
        l = date2.getTime();
        return (int)((date1.getTime() - l) / 1000L);
    }

    public static String[] getLocaleInfo(Context context)
    {
        String as[] = new String[2];
        try
        {
            context = a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, "error in getLocaleInfo", context);
            return as;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        as[0] = context.getCountry();
        as[1] = context.getLanguage();
        if (TextUtils.isEmpty(as[0]))
        {
            as[0] = "Unknown";
        }
        if (TextUtils.isEmpty(as[1]))
        {
            as[1] = "Unknown";
        }
        return as;
    }

    public static Location getLocation(Context context)
    {
        LocationManager locationmanager;
        Location location;
        locationmanager = (LocationManager)context.getSystemService("location");
        if (!checkPermission(context, "android.permission.ACCESS_FINE_LOCATION"))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        location = locationmanager.getLastKnownLocation("gps");
        if (location != null)
        {
            try
            {
                Log.c(a, (new StringBuilder()).append("get location from gps:").append(location.getLatitude()).append(",").append(location.getLongitude()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.b(a, context.getMessage());
                return null;
            }
            return location;
        }
        if (!checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION"))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        context = locationmanager.getLastKnownLocation("network");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        Log.c(a, (new StringBuilder()).append("get location from network:").append(context.getLatitude()).append(",").append(context.getLongitude()).toString());
        return context;
        Log.c(a, "Could not get location from GPS or Cell-id, lack ACCESS_COARSE_LOCATION or ACCESS_COARSE_LOCATION permission?");
        return null;
    }

    public static String getMac(Context context)
    {
        try
        {
            WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE"))
            {
                return wifimanager.getConnectionInfo().getMacAddress();
            }
            Log.e(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(a, (new StringBuilder()).append("Could not get mac address.").append(context.toString()).toString());
        }
        return "";
    }

    public static String getMetaData(Context context, String s)
    {
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        context = ((ApplicationInfo) (context)).metaData.getString(s);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        context = context.trim();
        return context;
        context;
        context.printStackTrace();
        Log.b(a, String.format("Could not read meta-data %s from AndroidManifest.xml.", new Object[] {
            s
        }));
        return null;
    }

    public static String[] getNetworkAccessMode(Context context)
    {
        String as[];
        as = new String[2];
        as[0] = "Unknown";
        as[1] = "Unknown";
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return as;
        }
        NetworkInfo networkinfo = context.getNetworkInfo(1);
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (networkinfo.getState() == android.net.NetworkInfo.State.CONNECTED)
        {
            as[0] = "Wi-Fi";
            return as;
        }
        context = context.getNetworkInfo(0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (context.getState() != android.net.NetworkInfo.State.CONNECTED)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        as[0] = "2G/3G";
        as[1] = context.getSubtypeName();
        return as;
        context;
        return as;
    }

    public static String getNetworkOperatorName(Context context)
    {
        try
        {
            context = (TelephonyManager)context.getSystemService("phone");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "Unknown";
        }
        if (context == null)
        {
            return "Unknown";
        }
        context = context.getNetworkOperatorName();
        return context;
    }

    public static String getOperator(Context context)
    {
        try
        {
            context = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.a(a, "read carrier fail", context);
            return "Unknown";
        }
        return context;
    }

    public static String getPackageName(Context context)
    {
        return context.getPackageName();
    }

    public static String getResolution(Context context)
    {
        DisplayMetrics displaymetrics;
        displaymetrics = new DisplayMetrics();
        ((WindowManager)(WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        if ((context.getApplicationInfo().flags & 0x2000) != 0) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = a(displaymetrics, "noncompatWidthPixels");
        i = a(displaymetrics, "noncompatHeightPixels");
          goto _L3
_L4:
        int k;
        j = displaymetrics.widthPixels;
        k = displaymetrics.heightPixels;
_L5:
        context = new StringBuffer();
        context.append(j);
        context.append("*");
        context.append(k);
        context = context.toString();
        return context;
        context;
        Log.b(a, "read resolution fail", context);
        return "Unknown";
_L2:
        i = -1;
        j = -1;
_L3:
        if (j == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        if (i != -1) goto _L5; else goto _L4
    }

    public static String getTimeString(Date date)
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(date);
    }

    public static int getTimeZone(Context context)
    {
        context = Calendar.getInstance(a(context));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        int i = context.getTimeZone().getRawOffset() / 0x36ee80;
        return i;
        context;
        Log.a(a, "error in getTimeZone", context);
        return 8;
    }

    public static String getToday()
    {
        Date date = new Date();
        return (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(date);
    }

    public static String getUtdid(Context context)
    {
        try
        {
            context = an.a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, (new StringBuilder()).append("fail to get utdid. ").append(context.getMessage()).toString());
            return "";
        }
        return context;
    }

    public static boolean isAppInstalled(String s, Context context)
    {
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo(s, 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static boolean isChinese(Context context)
    {
        return context.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
    }

    public static boolean isDebug(Context context)
    {
        boolean flag = false;
        int i;
        try
        {
            i = context.getApplicationInfo().flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if ((i & 2) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isOnline(Context context)
    {
        boolean flag;
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        flag = context.isConnectedOrConnecting();
        return flag;
        return false;
    }

    public static boolean isScreenPortrait(Context context)
    {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static boolean isSdCardWrittenable()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isWiFiAvailable(Context context)
    {
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    public static Date toTime(String s)
    {
        try
        {
            s = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

}
