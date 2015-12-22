// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.events;


// Referenced classes of package com.inmobi.commons.analytics.events:
//            AnalyticsEventsWrapper

public static final class  extends Enum
{

    public static final CANCELED CANCELED;
    public static final CANCELED COMPLETED;
    public static final CANCELED FAILED;
    private static final CANCELED a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/analytics/events/AnalyticsEventsWrapper$IMSectionStatus, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        COMPLETED = new <init>("COMPLETED", 0);
        FAILED = new <init>("FAILED", 1);
        CANCELED = new <init>("CANCELED", 2);
        a = (new a[] {
            COMPLETED, FAILED, CANCELED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
