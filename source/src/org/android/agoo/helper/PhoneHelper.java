// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.umeng.message.proguard.aI;
import java.lang.reflect.Method;
import java.util.Random;

public class PhoneHelper
{

    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    public static final String MACADDRESS = "mac_address";

    public PhoneHelper()
    {
    }

    private static String a()
    {
        StringBuffer stringbuffer = new StringBuffer();
        long l = System.currentTimeMillis();
        Object obj = Long.toString(l);
        stringbuffer.append(((String) (obj)).substring(((String) (obj)).length() - 5));
        obj = new StringBuffer();
        ((StringBuffer) (obj)).append(Build.MODEL.replaceAll(" ", ""));
        for (; ((StringBuffer) (obj)).length() < 6; ((StringBuffer) (obj)).append('0')) { }
        stringbuffer.append(((StringBuffer) (obj)).substring(0, 6));
        obj = new Random(l);
        for (l = 0L; l < 4096L; l = ((Random) (obj)).nextLong()) { }
        stringbuffer.append(Long.toHexString(l).substring(0, 4));
        return stringbuffer.toString();
    }

    public static String getAndroidId(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getImei(Context context)
    {
        Object obj;
label0:
        {
            SharedPreferences sharedpreferences;
label1:
            {
                sharedpreferences = aI.f(context);
                String s = sharedpreferences.getString("imei", null);
                if (s != null)
                {
                    obj = s;
                    if (s.length() != 0)
                    {
                        break label0;
                    }
                }
                obj = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
                if (obj != null)
                {
                    context = ((Context) (obj));
                    if (((String) (obj)).length() != 0)
                    {
                        break label1;
                    }
                }
                context = a();
            }
            for (context = context.replaceAll(" ", "").trim(); context.length() < 15; context = (new StringBuilder()).append("0").append(context).toString()) { }
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("imei", context);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            obj = context;
        }
        return ((String) (obj)).trim();
    }

    public static String getImsi(Context context)
    {
        Object obj;
label0:
        {
            SharedPreferences sharedpreferences;
label1:
            {
                sharedpreferences = aI.f(context);
                String s = sharedpreferences.getString("imsi", null);
                if (s != null)
                {
                    obj = s;
                    if (s.length() != 0)
                    {
                        break label0;
                    }
                }
                obj = ((TelephonyManager)context.getSystemService("phone")).getSubscriberId();
                if (obj != null)
                {
                    context = ((Context) (obj));
                    if (((String) (obj)).length() != 0)
                    {
                        break label1;
                    }
                }
                context = a();
            }
            for (context = context.replaceAll(" ", "").trim(); context.length() < 15; context = (new StringBuilder()).append("0").append(context).toString()) { }
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("imsi", context);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            obj = context;
        }
        return ((String) (obj));
    }

    public static String getLocalMacAddress(Context context)
    {
        String s = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (s == null || "".equals(s))
        {
            return aI.f(context).getString("mac_address", "");
        } else
        {
            context = aI.f(context).edit();
            context.putString("mac_address", s);
            context.commit();
            return s;
        }
    }

    public static String getOriginalImei(Context context)
    {
        context = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        if (context != null)
        {
            context.trim();
        }
        return "umeng";
    }

    public static String getOriginalImsi(Context context)
    {
        context = ((TelephonyManager)context.getSystemService("phone")).getSubscriberId();
        if (context != null)
        {
            context.trim();
        }
        return "umeng";
    }

    public static String getSerialNum()
    {
        Object obj;
        try
        {
            obj = Class.forName("android.os.SystemProperties");
            obj = (String)(String)((Class) (obj)).getMethod("get", new Class[] {
                java/lang/String, java/lang/String
            }).invoke(obj, new Object[] {
                "ro.serialno", "unknown"
            });
        }
        catch (Throwable throwable)
        {
            return null;
        }
        return ((String) (obj));
    }
}
