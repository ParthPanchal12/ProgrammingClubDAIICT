// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsFunctions

public static final class  extends Enum
{

    public static final PI CE;
    public static final PI ES;
    public static final PI LB;
    public static final PI LE;
    public static final PI PI;
    public static final PI SS;
    private static final PI a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsFunctions$FunctionName, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        SS = new <init>("SS", 0);
        ES = new <init>("ES", 1);
        LB = new <init>("LB", 2);
        LE = new <init>("LE", 3);
        CE = new <init>("CE", 4);
        PI = new <init>("PI", 5);
        a = (new a[] {
            SS, ES, LB, LE, CE, PI
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
