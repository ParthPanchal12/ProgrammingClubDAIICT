// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.content.Context;
import android.content.SharedPreferences;
import u.upd.a;
import u.upd.b;

public class UpdateConfig
{

    public static final String a = "update";
    public static final String b = "2.4.2.20140520";
    public static final String c = "1.4";
    public static final String d = "com.umeng.update.net.DownloadingService";
    public static final String e = "com.umeng.update.UpdateDialogActivity";
    public static final String f = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String g = "android.permission.ACCESS_NETWORK_STATE";
    public static final String h = "android.permission.INTERNET";
    public static final String i = "UMUpdateCheck";
    private static final String j = "umeng_update";
    private static final String k = "ignore";
    private static String l;
    private static String m;
    private static boolean n = true;
    private static boolean o = true;
    private static boolean p = false;
    private static boolean q = true;
    private static boolean r = false;
    private static boolean s = true;
    private static boolean t = true;
    private static int u = 0;

    public UpdateConfig()
    {
    }

    public static String getAppkey(Context context)
    {
        if (l == null)
        {
            l = u.upd.a.o(context);
        }
        return l;
    }

    public static String getChannel(Context context)
    {
        if (m == null)
        {
            m = u.upd.a.t(context);
        }
        return m;
    }

    public static String getIgnoreMd5(Context context)
    {
        String s1 = context.getApplicationContext().getSharedPreferences("umeng_update", 0).getString("ignore", "");
        context = s1;
        if ("".equals(s1))
        {
            context = null;
        }
        return context;
    }

    public static int getStyle()
    {
        return u;
    }

    public static boolean isDeltaUpdate()
    {
        return q;
    }

    public static boolean isRichNotification()
    {
        return t;
    }

    public static boolean isSilentDownload()
    {
        return r;
    }

    public static boolean isUpdateAutoPopup()
    {
        return o;
    }

    public static boolean isUpdateCheck()
    {
        return s;
    }

    public static boolean isUpdateForce()
    {
        return p;
    }

    public static boolean isUpdateOnlyWifi()
    {
        return n;
    }

    public static void saveIgnoreMd5(Context context, String s1)
    {
        context.getApplicationContext().getSharedPreferences("umeng_update", 0).edit().putString("ignore", s1).commit();
    }

    public static void setAppkey(String s1)
    {
        l = s1;
    }

    public static void setChannel(String s1)
    {
        m = s1;
    }

    public static void setDebug(boolean flag)
    {
        b.a = flag;
    }

    public static void setDeltaUpdate(boolean flag)
    {
        q = flag;
    }

    public static void setRichNotification(boolean flag)
    {
        t = flag;
    }

    public static void setSilentDownload(boolean flag)
    {
        r = flag;
    }

    public static void setStyle(int i1)
    {
        u = i1;
    }

    public static void setUpdateAutoPopup(boolean flag)
    {
        o = flag;
    }

    public static void setUpdateCheck(boolean flag)
    {
        s = flag;
    }

    public static void setUpdateForce(boolean flag)
    {
        p = flag;
    }

    public static void setUpdateOnlyWifi(boolean flag)
    {
        n = flag;
    }

}
