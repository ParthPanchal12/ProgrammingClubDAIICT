// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;


// Referenced classes of package com.inmobi.commons.network:
//            Request

public static final class  extends Enum
{

    public static final PUT GET;
    public static final PUT POST;
    public static final PUT PUT;
    private static final PUT a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/network/Request$Method, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        GET = new <init>("GET", 0);
        POST = new <init>("POST", 1);
        PUT = new <init>("PUT", 2);
        a = (new a[] {
            GET, POST, PUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
