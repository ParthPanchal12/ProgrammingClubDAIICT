// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.events;


// Referenced classes of package com.inmobi.commons.analytics.events:
//            AnalyticsEventsWrapper

public static final class  extends Enum
{

    public static final PERSONALIZATION CONSUMABLE;
    public static final PERSONALIZATION DURABLE;
    public static final PERSONALIZATION PERSONALIZATION;
    private static final PERSONALIZATION a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/analytics/events/AnalyticsEventsWrapper$IMItemType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        CONSUMABLE = new <init>("CONSUMABLE", 0);
        DURABLE = new <init>("DURABLE", 1);
        PERSONALIZATION = new <init>("PERSONALIZATION", 2);
        a = (new a[] {
            CONSUMABLE, DURABLE, PERSONALIZATION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
