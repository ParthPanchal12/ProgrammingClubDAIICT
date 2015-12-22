// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.inmobi.commons.internal.Log;
import java.util.GregorianCalendar;
import java.util.UUID;

public class SessionInfo
{

    private static String a;
    private static long b;
    private static String c;
    private static int d;

    public SessionInfo()
    {
    }

    public static String getAppId(Context context)
    {
        try
        {
            if (c != null)
            {
                return c;
            }
            context = context.getSharedPreferences("inmobiAppAnalyticsAppId", 0).getString("APP_ID", null);
            c = context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Exception getting app id", context);
            return null;
        }
        return context;
    }

    public static int getFirstTime()
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        int i = d;
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getSessionId(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        if (a == null) goto _L2; else goto _L1
_L1:
        context = a;
_L4:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return context;
_L2:
        try
        {
            context = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("SESSION_ID", null);
            a = context;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally
        {
            com/inmobi/commons/analytics/util/SessionInfo;
        }
        Log.internal("[InMobi]-4.5.5", "Exception getting session id", context);
        context = null;
        if (true) goto _L4; else goto _L3
_L3:
        throw context;
    }

    public static long getSessionTime(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        if (b == 0L) goto _L2; else goto _L1
_L1:
        long l = b;
_L4:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return l;
_L2:
        try
        {
            l = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).getLong("SESSION_TIME", 0L);
            b = l;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally
        {
            com/inmobi/commons/analytics/util/SessionInfo;
        }
        Log.internal("[InMobi]-4.5.5", "Exception getting session time", context);
        l = 0L;
        if (true) goto _L4; else goto _L3
_L3:
        throw context;
    }

    public static boolean isUpdatedFromOldSDK(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        boolean flag = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).getBoolean("UPDATED_FROM_OLD_SDK", false);
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return flag;
        context;
        throw context;
    }

    public static void removeSessionId(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        a = null;
        b = 0L;
        context = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
        context.putString("SESSION_ID", null);
        context.putString("SESSION_TIME", null);
        context.commit();
_L2:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        context;
        Log.internal("[InMobi]-4.5.5", "Exception removing session id", context);
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }

    public static void resetFirstTime()
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        d = 0;
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void storeAppId(Context context, String s)
    {
        try
        {
            c = s;
            context = context.getSharedPreferences("inmobiAppAnalyticsAppId", 0).edit();
            context.putString("APP_ID", s);
            context.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Exception storing app id", context);
        }
    }

    public static void storeFirstTime(Context context)
    {
        int j = 0;
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        long l;
        SharedPreferences sharedpreferences = context.getSharedPreferences("inmobiAppAnalyticsSession", 0);
        context = sharedpreferences.edit();
        l = sharedpreferences.getLong("SESSION_TIMEM", -1L);
        if (l == -1L) goto _L2; else goto _L1
_L1:
        GregorianCalendar gregoriancalendar;
        GregorianCalendar gregoriancalendar1;
        gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTimeInMillis(l);
        gregoriancalendar.setFirstDayOfWeek(2);
        gregoriancalendar1 = new GregorianCalendar();
        l = gregoriancalendar1.getTimeInMillis();
        gregoriancalendar1.setFirstDayOfWeek(2);
        int i;
        if (gregoriancalendar.get(6) != gregoriancalendar1.get(6))
        {
            j = 1;
        }
        i = j;
        if (gregoriancalendar.get(3) != gregoriancalendar1.get(3))
        {
            i = j | 2;
        }
        j = i;
        if (gregoriancalendar.get(2) != gregoriancalendar1.get(2))
        {
            j = i | 4;
        }
        i = j;
          goto _L3
_L7:
        context.putLong("SESSION_TIMEM", l);
        context.commit();
        d = i;
_L5:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
_L2:
        l = (new GregorianCalendar()).getTimeInMillis();
        i = 15;
        continue; /* Loop/switch isn't completed */
        context;
        Log.internal("[InMobi]-4.5.5", "Exception storing session data first time", context);
        if (true) goto _L5; else goto _L4
_L4:
        context;
        throw context;
_L3:
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void storeSessionId(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        a = UUID.randomUUID().toString();
        b = System.currentTimeMillis() / 1000L;
        context = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
        context.putString("SESSION_ID", a);
        context.putString("APP_SESSION_ID", a);
        context.putLong("SESSION_TIME", b);
        context.commit();
_L2:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        context;
        Log.internal("[InMobi]-4.5.5", "Exception putting session id", context);
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }

    public static void updatedFromOldSDK(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        context = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
        context.putBoolean("UPDATED_FROM_OLD_SDK", true);
        context.commit();
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }
}
