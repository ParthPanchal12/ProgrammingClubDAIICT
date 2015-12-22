// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


// Referenced classes of package com.inmobi.monetization.internal:
//            Ad

protected static final class  extends Enum
{

    public static final NATIVE IMAI;
    public static final NATIVE NATIVE;
    private static final NATIVE a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/monetization/internal/Ad$AD_FORMAT, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        IMAI = new <init>("IMAI", 0);
        NATIVE = new <init>("NATIVE", 1);
        a = (new a[] {
            IMAI, NATIVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
