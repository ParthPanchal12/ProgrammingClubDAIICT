// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.util.Log;

public final class com.google.ads.util.b
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a g[];
        public final int f;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/ads/util/b$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("VERBOSE", 0, 2);
            b = new a("DEBUG", 1, 3);
            c = new a("INFO", 2, 4);
            d = new a("WARN", 3, 5);
            e = new a("ERROR", 4, 6);
            g = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            f = j;
        }
    }

    public static interface b
    {

        public abstract void a(a a1, String s, Throwable throwable);
    }


    public static b a = null;
    private static int b = 5;

    private static void a(a a1, String s)
    {
        a(a1, s, null);
    }

    private static void a(a a1, String s, Throwable throwable)
    {
        if (a != null)
        {
            a.a(a1, s, throwable);
        }
    }

    public static void a(String s)
    {
        if (a("Ads", 3))
        {
            Log.d("Ads", s);
        }
        a(a.b, s);
    }

    public static void a(String s, Throwable throwable)
    {
        if (a("Ads", 3))
        {
            Log.d("Ads", s, throwable);
        }
        a(a.b, s, throwable);
    }

    private static boolean a(int i)
    {
        return i >= b;
    }

    public static boolean a(String s, int i)
    {
        return a(i) || Log.isLoggable(s, i);
    }

    public static void b(String s)
    {
        if (a("Ads", 6))
        {
            Log.e("Ads", s);
        }
        a(a.e, s);
    }

    public static void b(String s, Throwable throwable)
    {
        if (a("Ads", 6))
        {
            Log.e("Ads", s);
            Log.i("Ads", "The following was caught and handled:", throwable);
        }
        a(a.e, s, throwable);
    }

    public static void c(String s)
    {
        if (a("Ads", 4))
        {
            Log.i("Ads", s);
        }
        a(a.c, s);
    }

    public static void c(String s, Throwable throwable)
    {
        if (a("Ads", 4))
        {
            Log.i("Ads", s, throwable);
        }
        a(a.c, s, throwable);
    }

    public static void d(String s)
    {
        if (a("Ads", 2))
        {
            Log.v("Ads", s);
        }
        a(a.a, s);
    }

    public static void d(String s, Throwable throwable)
    {
        if (a("Ads", 5))
        {
            Log.w("Ads", s);
            Log.i("Ads", "The following was caught and handled:", throwable);
        }
        a(a.d, s, throwable);
    }

    public static void e(String s)
    {
        if (a("Ads", 5))
        {
            Log.w("Ads", s);
        }
        a(a.d, s);
    }

}
