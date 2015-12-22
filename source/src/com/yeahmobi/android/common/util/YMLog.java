// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.util.Log;

public class YMLog
{

    private static final String LOGTAG = "YMLog";

    public YMLog()
    {
    }

    public static int d(String s)
    {
        return d(s, null);
    }

    public static int d(String s, Throwable throwable)
    {
        return Log.d("YMLog", s, throwable);
    }

    public static int e(String s)
    {
        return e(s, null);
    }

    public static int e(String s, Throwable throwable)
    {
        return Log.e("YMLog", s, throwable);
    }

    public static int w(String s)
    {
        return w(s, null);
    }

    public static int w(String s, Throwable throwable)
    {
        return Log.w("YMLog", s, throwable);
    }
}
