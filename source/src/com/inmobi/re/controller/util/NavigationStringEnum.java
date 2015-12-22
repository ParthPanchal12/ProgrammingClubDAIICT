// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;


public final class NavigationStringEnum extends Enum
{

    public static final NavigationStringEnum BACK;
    public static final NavigationStringEnum CLOSE;
    public static final NavigationStringEnum FORWARD;
    public static final NavigationStringEnum NONE;
    public static final NavigationStringEnum REFRESH;
    private static final NavigationStringEnum b[];
    private String a;

    private NavigationStringEnum(String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }

    public static NavigationStringEnum fromString(String s)
    {
        if (s != null)
        {
            NavigationStringEnum anavigationstringenum[] = values();
            int j = anavigationstringenum.length;
            for (int i = 0; i < j; i++)
            {
                NavigationStringEnum navigationstringenum = anavigationstringenum[i];
                if (s.equalsIgnoreCase(navigationstringenum.a))
                {
                    return navigationstringenum;
                }
            }

        }
        return null;
    }

    public static NavigationStringEnum valueOf(String s)
    {
        return (NavigationStringEnum)Enum.valueOf(com/inmobi/re/controller/util/NavigationStringEnum, s);
    }

    public static NavigationStringEnum[] values()
    {
        return (NavigationStringEnum[])b.clone();
    }

    public String getText()
    {
        return a;
    }

    static 
    {
        NONE = new NavigationStringEnum("NONE", 0, "none");
        CLOSE = new NavigationStringEnum("CLOSE", 1, "close");
        BACK = new NavigationStringEnum("BACK", 2, "back");
        FORWARD = new NavigationStringEnum("FORWARD", 3, "forward");
        REFRESH = new NavigationStringEnum("REFRESH", 4, "refresh");
        b = (new NavigationStringEnum[] {
            NONE, CLOSE, BACK, FORWARD, REFRESH
        });
    }
}
