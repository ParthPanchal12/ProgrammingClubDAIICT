// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsEvent

public static final class a extends Enum
{

    public static final SUBSCRIPTION INAPP;
    public static final SUBSCRIPTION INVALID;
    public static final SUBSCRIPTION SUBSCRIPTION;
    private static final SUBSCRIPTION b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_ITEM_TYPE, s);
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
        INAPP = new <init>("INAPP", 1, 1);
        SUBSCRIPTION = new <init>("SUBSCRIPTION", 2, 2);
        b = (new b[] {
            INVALID, INAPP, SUBSCRIPTION
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
