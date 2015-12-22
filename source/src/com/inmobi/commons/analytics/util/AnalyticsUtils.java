// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class AnalyticsUtils
{

    public static final String ANALYTICS_LOGGING_TAG = "[InMobi]-[Analytics]-4.5.5";
    public static final String INITIALIZE_NOT_CALLED = "Please call InMobi.initialize or startSession before calling any events API";
    private static String a;
    private static boolean b;

    public AnalyticsUtils()
    {
    }

    public static void asyncPingInternal(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        obj = obj2;
        s = s.replaceAll("%25", "%");
        obj = obj2;
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Pinging URL: ").append(s).toString());
        obj = obj2;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setConnectTimeout(20000);
        s.setRequestMethod("GET");
        s.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Async Ping Connection Response Code: ").append(s.getResponseCode()).toString());
        if (s != null)
        {
            s.disconnect();
        }
_L2:
        return;
        obj;
        s = ((String) (obj1));
        obj1 = obj;
_L5:
        obj = s;
        Log.debug("[InMobi]-[Analytics]-4.5.5", "Error doing async Ping. ", ((Throwable) (obj1)));
        if (s == null) goto _L2; else goto _L1
_L1:
        s.disconnect();
        return;
        Exception exception;
        exception;
        s = ((String) (obj));
        obj = exception;
_L4:
        if (s != null)
        {
            s.disconnect();
        }
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
          goto _L5
    }

    public static String compressPayload(String s)
    {
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            Base64OutputStream base64outputstream = new Base64OutputStream(bytearrayoutputstream, 0);
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(base64outputstream);
            gzipoutputstream.write(s.getBytes("UTF-8"));
            gzipoutputstream.close();
            base64outputstream.close();
            s = bytearrayoutputstream.toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Exception compress sdk payload.", s);
            return null;
        }
        return s;
    }

    public static String convertItemType(com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType imitemtype)
    {
        String s = null;
        if (imitemtype == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType.CONSUMABLE)
        {
            s = "1";
        } else
        {
            if (imitemtype == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType.DURABLE)
            {
                return "2";
            }
            if (imitemtype == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType.PERSONALIZATION)
            {
                return "3";
            }
        }
        return s;
    }

    public static String convertLevelStatus(com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus imsectionstatus)
    {
        String s = null;
        if (imsectionstatus == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus.COMPLETED)
        {
            s = "1";
        } else
        {
            if (imsectionstatus == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus.FAILED)
            {
                return "2";
            }
            if (imsectionstatus == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus.CANCELED)
            {
                return "3";
            }
        }
        return s;
    }

    public static String convertToJSON(Map map)
    {
        if (map.size() > getExtraParamsLimit())
        {
            Log.verbose("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Analytics events - number of key-value pairs in attribute map exceeds ").append(getExtraParamsLimit()).toString());
            return null;
        }
        JSONObject jsonobject;
        Iterator iterator;
        jsonobject = new JSONObject();
        iterator = map.keySet().iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (s.length() <= 0 || s.length() > getMaxparamskey()) goto _L4; else goto _L3
_L3:
        String s1 = (String)map.get(s);
        if (s1.length() > getMaxstring()) goto _L6; else goto _L5
_L5:
        jsonobject.put(s, map.get(s));
          goto _L7
        map;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Unable to convert map to JSON");
_L10:
        map = null;
_L8:
        return map;
_L6:
        Log.verbose("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Analytics events - value : ").append(s1).append(" ,exceeds inmobi's limitation of ").append(getMaxstring()).append(" characters.").toString());
        return null;
_L4:
        Log.verbose("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Analytics events - key : ").append(s).append(" ,exceeds inmobi's limitation of ").append(getMaxparamskey()).append(" characters.").toString());
        return null;
_L2:
        if (jsonobject.length() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        map = jsonobject.toString();
          goto _L8
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String getAppVersion(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Error retrieving application version");
            return null;
        }
        return context;
    }

    public static String getApplicationName(Context context)
    {
        try
        {
            PackageManager packagemanager = context.getPackageManager();
            context = (String)packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(context.getPackageName(), 0));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Error retrieving application name");
            return null;
        }
        return context;
    }

    public static Object getCountryISO(Context context)
    {
label0:
        {
            Object obj = (TelephonyManager)context.getSystemService("phone");
            new Object();
            if (((TelephonyManager) (obj)).getNetworkCountryIso().equals(""))
            {
                try
                {
                    context = context.getResources().getConfiguration().locale.getISO3Country();
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context = null;
                }
            } else
            {
                try
                {
                    context = ((TelephonyManager) (obj)).getNetworkCountryIso();
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context = null;
                }
            }
            if (context != null)
            {
                obj = context;
                if (!context.equals(""))
                {
                    break label0;
                }
            }
            obj = null;
        }
        return obj;
    }

    public static float getDeviceDensity(Context context)
    {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getEventUrl()
    {
        return AnalyticsInitializer.getConfigParams().getEndPoints().getEventsUrl();
    }

    public static int getExtraParamsLimit()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getExtraParamsLimit();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getMaxRetryBeforeDiscard()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxRetryBeforeCacheDiscard();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static long getMaxdbcount()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxDbEvents();
        long l = i;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getMaxevents()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        String s = (new StringBuilder()).append(AnalyticsInitializer.getConfigParams().getGetParamsLimit()).append("").toString();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getMaxparamskey()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxKeyLength();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getMaxstring()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxValLength();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getScreenHeight(Context context)
    {
        int i = context.getResources().getDisplayMetrics().heightPixels;
        return (new StringBuilder()).append("").append(i).toString();
    }

    public static String getScreenWidth(Context context)
    {
        int i = context.getResources().getDisplayMetrics().widthPixels;
        return (new StringBuilder()).append("").append(i).toString();
    }

    public static boolean getStartHandle()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        boolean flag = b;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static long getTimeinterval()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getPingInterval();
        long l = i;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getWebviewUserAgent()
    {
        return a;
    }

    public static void setStartHandle(boolean flag)
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        b = flag;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setWebviewUserAgent(String s)
    {
        a = s;
    }
}
