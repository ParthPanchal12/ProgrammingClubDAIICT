// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.text.TextUtils;
import android.util.Log;

public class com.google.ads.util.a
{
    public static class a extends Error
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static boolean a = Log.isLoggable("GoogleAdsAssertion", 3);

    public static void a(Object obj)
    {
        boolean flag;
        if (obj == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag, "Assertion that an object is null failed.");
    }

    public static void a(Object obj, Object obj1)
    {
        boolean flag;
        if (obj == obj1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag, (new StringBuilder()).append("Assertion that 'a' and 'b' refer to the same object failed.a: ").append(obj).append(", b: ").append(obj1).toString());
    }

    public static void a(String s)
    {
        boolean flag;
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag, (new StringBuilder()).append("Expected a non empty string, got: ").append(s).toString());
    }

    public static void a(boolean flag)
    {
        c(flag, "Assertion failed.");
    }

    public static void a(boolean flag, String s)
    {
        c(flag, s);
    }

    public static void b(Object obj)
    {
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag, "Assertion that an object is not null failed.");
    }

    public static void b(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag, "Assertion failed.");
    }

    public static void b(boolean flag, String s)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag, s);
    }

    private static void c(boolean flag, String s)
    {
        while (!Log.isLoggable("GoogleAdsAssertion", 3) && !a || flag) 
        {
            return;
        }
        a a1 = new a(s);
        Log.d("GoogleAdsAssertion", s, a1);
        throw a1;
    }

}
