// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;


// Referenced classes of package com.inmobi.commons.data:
//            DeviceInfo

private static final class e extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d f[];
    private int e;

    private int a()
    {
        return e;
    }

    static int a(e e1)
    {
        return e1.a();
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/data/DeviceInfo$a, s);
    }

    public static a[] values()
    {
        return (a[])f.clone();
    }

    static 
    {
        a = new <init>("PORTRAIT", 0, 1);
        b = new <init>("REVERSE_PORTRAIT", 1, 2);
        c = new <init>("LANDSCAPE", 2, 3);
        d = new <init>("REVERSE_LANDSCAPE", 3, 4);
        f = (new f[] {
            a, b, c, d
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        e = j;
    }
}
