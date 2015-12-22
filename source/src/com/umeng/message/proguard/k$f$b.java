// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            k

public static final class s extends Enum
{

    public static final r a;
    public static final r b;
    public static final r c;
    public static final r d;
    public static final r e;
    public static final r f;
    public static final r g;
    public static final r h;
    public static final r i;
    public static final r j;
    public static final r k;
    public static final r l;
    public static final r m;
    public static final r n;
    public static final r o;
    public static final r p;
    public static final r q;
    public static final r r;
    private static final r t[];
    private r s;

    public static s a(s s1)
    {
        return values()[s1.a() - 1];
    }

    public static a valueOf(String s1)
    {
        return (a)Enum.valueOf(com/umeng/message/proguard/k$f$b, s1);
    }

    public static a[] values()
    {
        return (a[])t.clone();
    }

    public ne a()
    {
        return a(ordinal() + 1);
    }

    public ordinal b()
    {
        return s;
    }

    static 
    {
        a = new <init>("DOUBLE", 0, d);
        b = new <init>("FLOAT", 1, c);
        c = new <init>("INT64", 2, b);
        d = new <init>("UINT64", 3, b);
        e = new <init>("INT32", 4, a);
        f = new <init>("FIXED64", 5, b);
        g = new <init>("FIXED32", 6, a);
        h = new <init>("BOOL", 7, e);
        i = new <init>("STRING", 8, f);
        j = new <init>("GROUP", 9, i);
        k = new <init>("MESSAGE", 10, i);
        l = new <init>("BYTES", 11, g);
        m = new <init>("UINT32", 12, a);
        n = new <init>("ENUM", 13, h);
        o = new <init>("SFIXED32", 14, a);
        p = new <init>("SFIXED64", 15, b);
        q = new <init>("SINT32", 16, a);
        r = new <init>("SINT64", 17, b);
        t = (new t[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r
        });
    }

    private (String s1, int i1,  )
    {
        super(s1, i1);
        s = ;
    }
}
