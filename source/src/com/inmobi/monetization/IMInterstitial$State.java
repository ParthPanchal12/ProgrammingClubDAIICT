// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial

public static final class  extends Enum
{

    public static final UNKNOWN ACTIVE;
    public static final UNKNOWN INIT;
    public static final UNKNOWN LOADING;
    public static final UNKNOWN READY;
    public static final UNKNOWN UNKNOWN;
    private static final UNKNOWN a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/monetization/IMInterstitial$State, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        ACTIVE = new <init>("ACTIVE", 1);
        LOADING = new <init>("LOADING", 2);
        READY = new <init>("READY", 3);
        UNKNOWN = new <init>("UNKNOWN", 4);
        a = (new a[] {
            INIT, ACTIVE, LOADING, READY, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
