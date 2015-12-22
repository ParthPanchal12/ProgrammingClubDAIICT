// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


// Referenced classes of package com.inmobi.re.container:
//            IMWebView

private static final class  extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k l[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/re/container/IMWebView$b, s);
    }

    public static [] values()
    {
        return ([])l.clone();
    }

    static 
    {
        a = new <init>("UNKNOWN_ERROR", 0);
        b = new <init>("MISSING_PARAMETER", 1);
        c = new <init>("CONETNT_ID_ERROR", 2);
        d = new <init>("CONTENT_URL_ERROR", 3);
        e = new <init>("CONTENT_URL_NOT_FOUND", 4);
        f = new <init>("NOT_SUPPORTED_SDK", 5);
        g = new <init>("CONTENT_TYPE_NOT_SUPPORTED", 6);
        h = new <init>("CONTENT_SIZE_NOT_SUPPORTED", 7);
        i = new <init>("NETWORK_ERROR", 8);
        j = new <init>("PERMISSION_ERROR", 9);
        k = new <init>("SD_CARD_ERROR", 10);
        l = (new l[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
