// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.common;

import android.content.Context;
import android.content.SharedPreferences;

public class b
{

    private static b a;
    private static Context b;
    private final String c = "fb_push_switch";
    private final String d = "fb_welcome_info";
    private final String e = "fb_welcome_info_switch";
    private final String f = "fb_audio_switch";
    private final String g = "fb_push_switch_key";
    private final String h = "fb_welcome_info_key";
    private final String i = "fb_welcome_info_switch_key";
    private final String j = "fb_audio_switch_key";
    private SharedPreferences k;
    private SharedPreferences l;
    private SharedPreferences m;
    private SharedPreferences n;

    private b(Context context)
    {
        b = context;
        k = b.getSharedPreferences("fb_push_switch", 0);
        l = b.getSharedPreferences("fb_welcome_info", 0);
        m = b.getSharedPreferences("fb_welcome_info_switch", 0);
        n = b.getSharedPreferences("fb_audio_switch", 0);
    }

    public static b a(Context context)
    {
        if (a == null)
        {
            a = new b(context);
        }
        return a;
    }

    public void a(String s)
    {
        b(true);
        if (s != null)
        {
            l.edit().putString("fb_welcome_info_key", s).apply();
        }
    }

    public void a(boolean flag)
    {
        k.edit().putBoolean("fb_push_switch_key", flag).apply();
    }

    public boolean a()
    {
        return k.getBoolean("fb_push_switch_key", true);
    }

    public void b(boolean flag)
    {
        m.edit().putBoolean("fb_welcome_info_switch_key", flag).apply();
    }

    public boolean b()
    {
        return m.getBoolean("fb_welcome_info_switch_key", true);
    }

    public String c()
    {
        return l.getString("fb_welcome_info_key", null);
    }

    public void c(boolean flag)
    {
        n.edit().putBoolean("fb_audio_switch_key", flag).apply();
    }

    public boolean d()
    {
        return n.getBoolean("fb_audio_switch_key", true);
    }
}
