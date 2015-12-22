// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsEvent

public static final class a extends Enum
{

    public static final REFUNDED FAILED;
    public static final REFUNDED INVALID;
    public static final REFUNDED PURCHASED;
    public static final REFUNDED REFUNDED;
    public static final REFUNDED RESTORED;
    private static final REFUNDED b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE, s);
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
        INVALID = new <init>("INVALID", 0, -1);
        PURCHASED = new <init>("PURCHASED", 1, 1);
        FAILED = new <init>("FAILED", 2, 2);
        RESTORED = new <init>("RESTORED", 3, 3);
        REFUNDED = new <init>("REFUNDED", 4, 4);
        b = (new b[] {
            INVALID, PURCHASED, FAILED, RESTORED, REFUNDED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
