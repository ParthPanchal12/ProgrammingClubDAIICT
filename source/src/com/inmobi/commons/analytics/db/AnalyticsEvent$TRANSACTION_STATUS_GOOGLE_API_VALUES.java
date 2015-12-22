// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsEvent

public static final class a extends Enum
{

    public static final REFUNDED FAILED;
    public static final REFUNDED PURCHASED;
    public static final REFUNDED REFUNDED;
    private static final REFUNDED b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES, s);
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
        PURCHASED = new <init>("PURCHASED", 0, 0);
        FAILED = new <init>("FAILED", 1, 1);
        REFUNDED = new <init>("REFUNDED", 2, 2);
        b = (new b[] {
            PURCHASED, FAILED, REFUNDED
        });
    }

    private Y(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
