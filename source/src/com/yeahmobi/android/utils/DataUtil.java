// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.utils;


// Referenced classes of package com.yeahmobi.android.utils:
//            StringUtils

public class DataUtil
{

    public static final String __BRACE_LEFT = "\\{";
    public static final String __BRACE_RIGHT = "\\}";

    public DataUtil()
    {
    }

    public static String macroNameWrapper(String s)
    {
        String s1 = "";
        if (!StringUtils.isNullOrEmpty(s))
        {
            s1 = (new StringBuilder()).append("\\{").append(s).append("\\}").toString();
        }
        return s1;
    }

    public static String macroNameWrapper2(String s)
    {
        String s1 = "";
        if (!StringUtils.isNullOrEmpty(s))
        {
            s1 = (new StringBuilder()).append("\\$\\{").append(s).append("\\}").toString();
        }
        return s1;
    }

    public static String nullToEmpty(String s)
    {
        String s1 = s;
        if (StringUtils.isNullOrEmpty(s))
        {
            s1 = "";
        }
        return s1;
    }
}
