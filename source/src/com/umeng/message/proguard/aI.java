// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

// Referenced classes of package com.umeng.message.proguard:
//            aJ, bp

public class aI
{

    public static final long A = 2000L;
    public static final long B = 20000L;
    public static final long C = 5000L;
    public static final long D = 5000L;
    public static final long E = 40000L;
    private static final String F = "Config";
    private static final long G = 0x493e0L;
    private static final String H = "AppStore";
    private static final String I = "app_key";
    private static final String J = "app_sercet";
    private static final String K = "app_tt_id";
    private static final String L = "app_disable";
    private static final String M = "app_device_token";
    private static final String N = "old_app_device_token";
    private static final String O = "app_version";
    private static final String P = "backoff_ms";
    private static final String Q = "app_dye_start_time";
    private static final String R = "app_dye_interval";
    private static final String S = "app_sudo_pack";
    private static final String T = "app_election_source";
    private static final String U = "app_sudo_pack_timeout";
    private static final String V = "app_agoo_multiplex";
    private static final String W = "app_last_election_time";
    private static final String X = "app_debug";
    private static final String Y = "app_log_to_file";
    private static final String Z = "app_agoo_command_uptime_time";
    public static final int a = 0x493e0;
    private static final int aa = 3000;
    private static final String ab = "logger_class_name";
    public static final int b = 120;
    public static final int c = 1320;
    public static final int d = 0x1b7740;
    public static final long e = 10000L;
    public static final long f = 0x927c0L;
    public static final long g = 0x493e0L;
    public static final long h = 40000L;
    public static final long i = 0x1d4c0L;
    public static final long j = 20000L;
    public static final long k = 60000L;
    public static final long l = 10000L;
    public static final long m = 2000L;
    public static final long n = 15000L;
    public static final long o = 5000L;
    public static final long p = 2000L;
    public static final long q = 1000L;
    public static final long r = 10000L;
    public static final long s = 5000L;
    public static final long t = 10000L;
    public static final long u = 5000L;
    public static final long v = 0x1b7740L;
    public static final long w = 0x927c0L;
    public static final long x = 5000L;
    public static final long y = 2000L;
    public static final long z = 5000L;

    public aI()
    {
    }

    public static final void a(Context context, int i1)
    {
        context = x(context).edit();
        context.putInt("backoff_ms", i1);
        context.commit();
    }

    public static void a(Context context, long l1)
    {
        try
        {
            android.provider.Settings.System.putLong(context.getContentResolver(), "app_last_election_time", l1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.d("Config", "setLastElectionTime", context);
        }
    }

    public static void a(Context context, long l1, int i1)
    {
        context = x(context).edit();
        context.putLong("app_dye_start_time", l1);
        context.putLong("app_dye_interval", (long)i1 * 60L * 1000L);
        context.commit();
    }

    public static void a(Context context, String s1)
    {
        context = x(context).edit();
        context.putString("logger_class_name", s1);
        context.commit();
    }

    public static void a(Context context, String s1, long l1, String s2)
    {
        context = x(context).edit();
        context.putString("app_sudo_pack", s1);
        context.putLong("app_sudo_pack_timeout", l1);
        context.putString("app_election_source", s2);
        context.commit();
    }

    public static void a(Context context, String s1, String s2, String s3)
    {
        try
        {
            Object obj = x(context);
            String s4 = ((SharedPreferences) (obj)).getString("app_key", null);
            String s5 = ((SharedPreferences) (obj)).getString("app_device_token", null);
            obj = ((SharedPreferences) (obj)).edit();
            if (!TextUtils.isEmpty(s4) && !TextUtils.isEmpty(s1) && !TextUtils.equals(s1, s4))
            {
                i(context);
            }
            if (!TextUtils.isEmpty(s5))
            {
                ((android.content.SharedPreferences.Editor) (obj)).putString("old_app_device_token", s5);
            }
            ((android.content.SharedPreferences.Editor) (obj)).putString("app_key", s1);
            ((android.content.SharedPreferences.Editor) (obj)).putString("app_tt_id", s3);
            if (!TextUtils.isEmpty(s2))
            {
                ((android.content.SharedPreferences.Editor) (obj)).putString("app_sercet", s2);
            }
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static void a(Context context, boolean flag)
    {
        context = x(context).edit();
        context.putInt("app_version", 0x80000000);
        if (flag)
        {
            context.putString("app_key", null);
            context.putString("app_sercet", null);
            context.putString("app_tt_id", null);
        }
        context.putString("app_device_token", null);
        context.putInt("backoff_ms", 3000);
        context.commit();
    }

    public static void a(Context context, boolean flag, long l1)
    {
        context = x(context).edit();
        context.putBoolean("app_agoo_multiplex", flag);
        context.putLong("app_agoo_command_uptime_time", l1);
        context.commit();
    }

    public static void a(Context context, boolean flag, boolean flag1)
    {
        context = x(context).edit();
        context.putBoolean("app_debug", flag);
        context.putBoolean("app_log_to_file", flag);
        context.commit();
    }

    public static boolean a(Context context)
    {
        int i1;
        int j1;
        long l1;
        i1 = x(context).getInt("app_version", 0x80000000);
        j1 = bp.b(context);
        l1 = android.provider.Settings.System.getLong(context.getContentResolver(), "app_last_election_time");
        if (i1 != 0x80000000 && i1 != j1)
        {
            return true;
        }
        if (l1 == -1L)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        long l2 = System.currentTimeMillis();
        if (l2 - l1 <= 0x493e0L)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_69;
        context;
        return true;
    }

    private static boolean a(Context context, String s1, boolean flag)
    {
        s1 = x(context);
        boolean flag1 = s1.getBoolean("app_disable", false);
        if (flag)
        {
            int i1 = s1.getInt("app_version", 0x80000000);
            int j1 = bp.b(context);
            if (i1 != 0x80000000 && i1 != j1)
            {
                t(context);
                i(context);
                return false;
            }
        }
        return flag1;
    }

    public static String b(Context context)
    {
        return x(context).getString("app_election_source", "local");
    }

    public static void b(Context context, String s1)
    {
        SharedPreferences sharedpreferences = x(context);
        int i1 = bp.b(context);
        context = sharedpreferences.edit();
        context.putString("app_device_token", s1);
        context.putInt("app_version", i1);
        context.commit();
    }

    public static boolean b(Context context, boolean flag)
    {
        return a(context, context.getPackageName(), flag);
    }

    public static long c(Context context)
    {
        return x(context).getLong("app_sudo_pack_timeout", -1L);
    }

    public static String d(Context context)
    {
        return x(context).getString("app_sudo_pack", null);
    }

    public static SharedPreferences e(Context context)
    {
        return context.getSharedPreferences("AppStore", 4);
    }

    public static SharedPreferences f(Context context)
    {
        return context.getSharedPreferences("AppStore", 4);
    }

    public static SharedPreferences g(Context context)
    {
        return context.getSharedPreferences("AppStore", 4);
    }

    public static String h(Context context)
    {
        return x(context).getString("logger_class_name", null);
    }

    public static void i(Context context)
    {
        a(context, false);
    }

    public static final void j(Context context)
    {
        a(context, 3000);
    }

    public static final int k(Context context)
    {
        return x(context).getInt("backoff_ms", 3000);
    }

    public static boolean l(Context context)
    {
        return x(context).getBoolean("app_log_to_file", false);
    }

    public static boolean m(Context context)
    {
        return x(context).getBoolean("app_debug", false);
    }

    public static String n(Context context)
    {
        return x(context).getString("app_key", null);
    }

    public static String o(Context context)
    {
        return x(context).getString("app_tt_id", null);
    }

    public static String p(Context context)
    {
        return x(context).getString("app_sercet", null);
    }

    public static String q(Context context)
    {
        String s1;
        int i1;
        int j1;
        SharedPreferences sharedpreferences;
        try
        {
            sharedpreferences = x(context);
            s1 = sharedpreferences.getString("app_device_token", null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        try
        {
            i1 = sharedpreferences.getInt("app_version", 0x80000000);
            j1 = bp.b(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s1;
        }
        if (i1 != 0x80000000) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(s1)) goto _L3; else goto _L2
_L3:
        aJ.c("Config", (new StringBuilder()).append("oldVersion:[").append(i1).append("]newVersion[").append(j1).append("]DeviceToken:[").append(s1).append("]").toString());
        i(context);
        return null;
_L2:
        while (i1 == 0x80000000 || i1 == j1) 
        {
            return s1;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static String r(Context context)
    {
        try
        {
            context = x(context).getString("old_app_device_token", null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static void s(Context context)
    {
        context = x(context).edit();
        context.putBoolean("app_disable", true);
        context.commit();
    }

    public static void t(Context context)
    {
        context = x(context).edit();
        context.putBoolean("app_disable", false);
        context.commit();
    }

    public static boolean u(Context context)
    {
        return b(context, false);
    }

    public static boolean v(Context context)
    {
        if (context != null)
        {
            context = x(context);
            long l1 = context.getLong("app_dye_start_time", -1L);
            long l2 = context.getLong("app_dye_start_time", -1L);
            if (System.currentTimeMillis() > l1 + l2)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean w(Context context)
    {
        SharedPreferences sharedpreferences = x(context);
        boolean flag = sharedpreferences.getBoolean("app_agoo_multiplex", true);
        long l1 = sharedpreferences.getLong("app_agoo_command_uptime_time", -1L);
        int i1 = sharedpreferences.getInt("app_version", 0x80000000);
        int j1 = bp.b(context);
        if (i1 != 0x80000000 && i1 != j1)
        {
            a(context, true, -1L);
        } else
        if (l1 != -1L && l1 > System.currentTimeMillis())
        {
            return flag;
        }
        return true;
    }

    private static SharedPreferences x(Context context)
    {
        return context.getSharedPreferences("AppStore", 4);
    }
}
