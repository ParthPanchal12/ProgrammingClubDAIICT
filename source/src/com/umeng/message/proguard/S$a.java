// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            S

public static class <init> extends Enum
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
    private static final r u[];
    private final r s;
    private final int t;

    public static <init> valueOf(String s1)
    {
        return (<init>)Enum.valueOf(com/umeng/message/proguard/S$a, s1);
    }

    public static <init>[] values()
    {
        return (<init>[])u.clone();
    }

    public lone a()
    {
        return s;
    }

    public int b()
    {
        return t;
    }

    public boolean c()
    {
        return true;
    }

    static 
    {
        a = new <init>("DOUBLE", 0, d, 1);
        b = new <init>("FLOAT", 1, c, 5);
        c = new <init>("INT64", 2, b, 0);
        d = new <init>("UINT64", 3, b, 0);
        e = new <init>("INT32", 4, a, 0);
        f = new <init>("FIXED64", 5, b, 1);
        g = new <init>("FIXED32", 6, a, 5);
        h = new <init>("BOOL", 7, e, 0);
        i = new S.a("STRING", 8, f, 2) {

            public boolean c()
            {
                return false;
            }

        };
        j = new S.a("GROUP", 9, i, 3) {

            public boolean c()
            {
                return false;
            }

        };
        k = new S.a("MESSAGE", 10, i, 2) {

            public boolean c()
            {
                return false;
            }

        };
        l = new S.a("BYTES", 11, g, 2) {

            public boolean c()
            {
                return false;
            }

        };
        m = new <init>("UINT32", 12, a, 0);
        n = new <init>("ENUM", 13, h, 0);
        o = new <init>("SFIXED32", 14, a, 5);
        p = new <init>("SFIXED64", 15, b, 1);
        q = new <init>("SINT32", 16, a, 0);
        r = new <init>("SINT64", 17, b, 0);
        u = (new u[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r
        });
    }

    private _cls4(String s1, int i1, _cls4 _pcls4, int j1)
    {
        super(s1, i1);
        s = _pcls4;
        t = j1;
    }

    t(String s1, int i1, t t1, int j1, t t2)
    {
        this(s1, i1, t1, j1);
    }
}
