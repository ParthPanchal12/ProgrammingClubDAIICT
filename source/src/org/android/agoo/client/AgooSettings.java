// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import java.util.Calendar;

public class AgooSettings
{
    public static abstract class Mode extends Enum
    {

        public static final Mode PREVIEW;
        public static final Mode RELEASE;
        public static final Mode TEST;
        private static final Mode b[];
        private int a;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(org/android/agoo/client/AgooSettings$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])b.clone();
        }

        public abstract String getPushApollIp();

        public abstract int getPushApollPort();

        public int getValue()
        {
            return a;
        }

        static 
        {
            TEST = new Mode("TEST", 0, -1) {

                public String getPushApollIp()
                {
                    return "110.75.120.15";
                }

                public int getPushApollPort()
                {
                    return 80;
                }

            };
            PREVIEW = new Mode("PREVIEW", 1, 0) {

                public String getPushApollIp()
                {
                    return "110.75.40.7";
                }

                public int getPushApollPort()
                {
                    return 6080;
                }

            };
            RELEASE = new Mode("RELEASE", 2, 1) {

                public String getPushApollIp()
                {
                    return "42.120.111.1";
                }

                public int getPushApollPort()
                {
                    return 80;
                }

            };
            b = (new Mode[] {
                TEST, PREVIEW, RELEASE
            });
        }

        private Mode(String s, int k, int l)
        {
            super(s, k);
            a = l;
        }

    }


    private static final String a = "42.120.111.1";
    private static final String b = "110.75.40.7";
    private static final String c = "110.75.120.15";
    private static final String d = "agoo_mode";
    private static final String e = "agoo_security_mode";
    private static final long f = 0x1332d94L;
    private static final String g = "AGOO_MTOP_DOMAIN";
    private static final String h = "AGOO_APOLL_DOMAIN";
    private static final String i = "agoo_start_time";
    private static final String j = "agoo_end_time";

    public AgooSettings()
    {
    }

    public static long getAgooReleaseTime()
    {
        return 0x1332d94L;
    }

    public static String getApollUrl(Context context)
    {
        return String.format("http://%s/activeip/", new Object[] {
            aI.g(context).getString("AGOO_APOLL_DOMAIN", "upoll.umengcloud.com")
        });
    }

    public static Mode getMode(Context context)
    {
        org/android/agoo/client/AgooSettings;
        JVM INSTR monitorenter ;
        context = aI.g(context).getString("AGOO_MTOP_DOMAIN", "utop.umengcloud.com");
        if (TextUtils.indexOf(context, "waptest") == -1) goto _L2; else goto _L1
_L1:
        context = Mode.TEST;
_L4:
        org/android/agoo/client/AgooSettings;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (TextUtils.indexOf(context, "wapa") != -1)
        {
            context = Mode.PREVIEW;
            continue; /* Loop/switch isn't completed */
        }
        context = Mode.RELEASE;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public static String getPullUrl(Context context)
    {
        return String.format("http://%s/rest/api3.do", new Object[] {
            aI.g(context).getString("AGOO_MTOP_DOMAIN", "utop.umengcloud.com")
        });
    }

    public static long getTargetTime(Context context)
    {
        return getTargetTime(context, System.currentTimeMillis());
    }

    public static long getTargetTime(Context context, long l)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return -1L;
_L2:
        int k;
        int i1;
        int j1;
        context = aI.g(context);
        k = context.getInt("agoo_start_time", -1);
        i1 = context.getInt("agoo_end_time", -1);
        if (k == -1 || i1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = Calendar.getInstance();
        context.setTimeInMillis(l);
        j1 = context.get(11) * 60 * 60 + context.get(12) * 60 + context.get(13);
        if (j1 >= k)
        {
            continue; /* Loop/switch isn't completed */
        }
        context.add(13, k - j1);
_L4:
        return context.getTimeInMillis();
        if (j1 <= i1) goto _L1; else goto _L3
_L3:
        context.add(13, (k - j1) + 0x15180);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static boolean isAgooSoSecurityMode(Context context)
    {
        return aI.g(context).getBoolean("agoo_security_mode", false);
    }

    public static boolean isAgooTestMode(Context context)
    {
        return getMode(context) != Mode.RELEASE;
    }

    public static void setAgooMode(Context context, Mode mode)
    {
    }

    public static void setAgooSecurityMode(Context context, boolean flag)
    {
        if (context != null)
        {
            context = aI.g(context).edit();
            context.putBoolean("agoo_security_mode", flag);
            context.commit();
        }
    }

    public static void setAvailableTime(Context context, int k, int l, int i1, int j1)
    {
        if (context != null)
        {
            context = aI.g(context).edit();
            context.putInt("agoo_start_time", k * 60 * 60 + l * 60 + 0);
            context.putInt("agoo_end_time", i1 * 60 * 60 + j1 * 60 + 0);
            context.commit();
        }
    }

    public static void setDebugMode(boolean flag)
    {
        aJ.b(flag);
    }

    public static void setDomain(Context context, String s, String s1)
    {
        if (context != null)
        {
            context = aI.g(context).edit();
            context.putString("AGOO_MTOP_DOMAIN", s);
            context.putString("AGOO_APOLL_DOMAIN", s1);
            context.commit();
        }
    }

    public static void setLog(Context context, boolean flag, boolean flag1)
    {
        aI.a(context, flag, flag1);
        aJ.a(context);
    }

    public static void setLog2File(boolean flag)
    {
        aJ.a(flag);
    }

    public static void setUTVersion(Context context, String s)
    {
        aI.a(context, s);
    }
}
