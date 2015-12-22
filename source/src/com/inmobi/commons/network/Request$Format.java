// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;


// Referenced classes of package com.inmobi.commons.network:
//            Request

public static final class  extends Enum
{

    public static final JSON JSON;
    public static final JSON KEY_VAL;
    private static final JSON a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/network/Request$Format, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        KEY_VAL = new <init>("KEY_VAL", 0);
        JSON = new <init>("JSON", 1);
        a = (new a[] {
            KEY_VAL, JSON
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
