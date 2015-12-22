// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import java.util.Date;
import java.util.TimeZone;

public class DateAndTime
{

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final int JUDGE_CONVERSION_TIME = 30;
    private static final int TIME_HOURSES = 24;
    private static final int TIME_MILLISECONDS = 1000;
    private static final int TIME_NUMBERS = 60;
    protected static DateAndTime instance = new DateAndTime();

    public DateAndTime()
    {
    }

    public static TimeZone localTimeZone()
    {
        return instance.internalLocalTimeZone();
    }

    public static Date now()
    {
        return instance.internalNow();
    }

    public static void setInstance(DateAndTime dateandtime)
    {
        instance = dateandtime;
    }

    public static boolean withinHalfHour(long l)
    {
        return (int)(Math.abs((new Date()).getTime() - l) / 1000L / 60L) < 30;
    }

    public TimeZone internalLocalTimeZone()
    {
        return TimeZone.getDefault();
    }

    public Date internalNow()
    {
        return new Date();
    }

}
