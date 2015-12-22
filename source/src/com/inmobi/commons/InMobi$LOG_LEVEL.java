// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


// Referenced classes of package com.inmobi.commons:
//            InMobi

public static final class a extends Enum
{

    public static final VERBOSE DEBUG;
    public static final VERBOSE NONE;
    public static final VERBOSE VERBOSE;
    private static final VERBOSE b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/InMobi$LOG_LEVEL, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        NONE = new <init>("NONE", 0, 0);
        DEBUG = new <init>("DEBUG", 1, 1);
        VERBOSE = new <init>("VERBOSE", 2, 2);
        b = (new b[] {
            NONE, DEBUG, VERBOSE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
