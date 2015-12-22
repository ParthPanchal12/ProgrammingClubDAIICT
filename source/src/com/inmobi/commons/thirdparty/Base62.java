// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thirdparty;

import com.inmobi.commons.internal.Log;

public class Base62
{

    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int BASE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length();

    private Base62()
    {
    }

    private static int a(int i, int j)
    {
        return (int)Math.pow(BASE, j) * i;
    }

    private static int a(char ac[])
    {
        int j = 0;
        for (int i = ac.length - 1; i >= 0; i--)
        {
            j += a("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ac[i]), i);
        }

        return j;
    }

    private static long a(long l, StringBuilder stringbuilder)
    {
        stringbuilder.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int)(l % (long)BASE)));
        return l / (long)BASE;
    }

    public static String fromBase10(long l)
    {
        Object obj;
        try
        {
            obj = new StringBuilder("");
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to convert to base 62", exception);
            return null;
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        l = a(l, ((StringBuilder) (obj)));
        break MISSING_BLOCK_LABEL_10;
        obj = ((StringBuilder) (obj)).reverse().toString();
        return ((String) (obj));
    }

    public static int toBase10(String s)
    {
        return a((new StringBuilder(s)).reverse().toString().toCharArray());
    }

}
