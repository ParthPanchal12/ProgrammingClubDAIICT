// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


// Referenced classes of package com.inmobi.monetization.internal:
//            NativeAd

private static final class  extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/monetization/internal/NativeAd$a, s);
    }

    public static [] values()
    {
        return ([])g.clone();
    }

    static 
    {
        a = new <init>("INIT", 0);
        b = new <init>("LOADING", 1);
        c = new <init>("READY", 2);
        d = new <init>("ATTACHED", 3);
        e = new <init>("ERROR", 4);
        f = new <init>("UNKNOWN", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
