// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


public class ad
{

    public ad()
    {
    }

    public static String a(Object obj)
    {
        if (obj != null)
        {
            if (obj instanceof String)
            {
                return ((String)obj).toString();
            }
            if (obj instanceof Integer)
            {
                return (new StringBuilder()).append("").append(((Integer)obj).intValue()).toString();
            }
            if (obj instanceof Long)
            {
                return (new StringBuilder()).append("").append(((Long)obj).longValue()).toString();
            }
            if (obj instanceof Double)
            {
                return (new StringBuilder()).append("").append(((Double)obj).doubleValue()).toString();
            }
            if (obj instanceof Float)
            {
                return (new StringBuilder()).append("").append(((Float)obj).floatValue()).toString();
            }
            if (obj instanceof Short)
            {
                return (new StringBuilder()).append("").append(((Short)obj).shortValue()).toString();
            }
            if (obj instanceof Byte)
            {
                return (new StringBuilder()).append("").append(((Byte)obj).byteValue()).toString();
            }
            if (obj instanceof Boolean)
            {
                return ((Boolean)obj).toString();
            }
            if (obj instanceof Character)
            {
                return ((Character)obj).toString();
            } else
            {
                return obj.toString();
            }
        } else
        {
            return "";
        }
    }

    public static boolean a(String s)
    {
        return s == null || s.length() <= 0;
    }

    public static int b(String s)
    {
        int i = 0;
        int j = 0;
        if (s.length() > 0)
        {
            s = s.toCharArray();
            i = 0;
            for (; j < s.length; j++)
            {
                i = i * 31 + s[j];
            }

        }
        return i;
    }
}
