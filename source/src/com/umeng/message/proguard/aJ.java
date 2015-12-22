// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;

// Referenced classes of package com.umeng.message.proguard:
//            aO, aI, aK

public final class aJ
{

    private static volatile aK a = null;

    public aJ()
    {
    }

    public static void a(Context context)
    {
        if (a == null)
        {
            a = new aO(aI.m(context), aI.u(context));
        }
    }

    public static void a(String s, String s1)
    {
        if (a != null)
        {
            a.c(s, s1);
        }
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        if (a != null)
        {
            a.c(s, s1, throwable);
        }
    }

    public static void a(boolean flag)
    {
    }

    public static void b(String s, String s1)
    {
        if (a != null)
        {
            a.b(s, s1);
        }
    }

    public static void b(String s, String s1, Throwable throwable)
    {
        if (a != null)
        {
            a.b(s, s1, throwable);
        }
    }

    public static void b(boolean flag)
    {
    }

    public static void c(String s, String s1)
    {
        if (a != null)
        {
            a.a(s, s1);
        }
    }

    public static void c(String s, String s1, Throwable throwable)
    {
        if (a != null)
        {
            a.a(s, s1, throwable);
        }
    }

    public static void d(String s, String s1)
    {
        if (a != null)
        {
            a.d(s, s1);
        }
    }

    public static void d(String s, String s1, Throwable throwable)
    {
        if (a != null)
        {
            a.d(s, s1, throwable);
        }
    }

    public static void e(String s, String s1)
    {
        if (a != null)
        {
            a.e(s, s1);
        }
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if (a != null)
        {
            a.e(s, s1, throwable);
        }
    }

}
