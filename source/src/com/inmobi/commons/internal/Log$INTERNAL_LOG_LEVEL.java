// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;


// Referenced classes of package com.inmobi.commons.internal:
//            Log

public static final class a extends Enum
{

    public static final INTERNAL DEBUG;
    public static final INTERNAL INTERNAL;
    public static final INTERNAL NONE;
    public static final INTERNAL NOT_SET;
    public static final INTERNAL VERBOSE;
    private static final INTERNAL b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL, s);
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
        NOT_SET = new <init>("NOT_SET", 0, -1);
        NONE = new <init>("NONE", 1, 0);
        DEBUG = new <init>("DEBUG", 2, 1);
        VERBOSE = new <init>("VERBOSE", 3, 2);
        INTERNAL = new <init>("INTERNAL", 4, 3);
        b = (new b[] {
            NOT_SET, NONE, DEBUG, VERBOSE, INTERNAL
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
