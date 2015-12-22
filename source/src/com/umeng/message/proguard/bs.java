// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bs
{

    public bs()
    {
    }

    public static long a(String s)
    {
        long l;
        try
        {
            l = (new SimpleDateFormat("yyyyMMddHHmmss")).parse(s).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    public static String a(long l)
    {
        String s;
        try
        {
            s = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Long.valueOf(l));
        }
        catch (Throwable throwable)
        {
            return "none";
        }
        return s;
    }
}
