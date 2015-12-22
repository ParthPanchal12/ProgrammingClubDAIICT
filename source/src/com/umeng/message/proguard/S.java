// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            g

public final class S
{
    public static class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        private static final a u[];
        private final b s;
        private final int t;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/umeng/message/proguard/S$a, s1);
        }

        public static a[] values()
        {
            return (a[])u.clone();
        }

        public b a()
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
            a = new a("DOUBLE", 0, b.d, 1);
            b = new a("FLOAT", 1, b.c, 5);
            c = new a("INT64", 2, b.b, 0);
            d = new a("UINT64", 3, b.b, 0);
            e = new a("INT32", 4, b.a, 0);
            f = new a("FIXED64", 5, b.b, 1);
            g = new a("FIXED32", 6, b.a, 5);
            h = new a("BOOL", 7, b.e, 0);
            i = new a("STRING", 8, b.f, 2) {

                public boolean c()
                {
                    return false;
                }

            };
            j = new a("GROUP", 9, b.i, 3) {

                public boolean c()
                {
                    return false;
                }

            };
            k = new a("MESSAGE", 10, b.i, 2) {

                public boolean c()
                {
                    return false;
                }

            };
            l = new a("BYTES", 11, b.g, 2) {

                public boolean c()
                {
                    return false;
                }

            };
            m = new a("UINT32", 12, b.a, 0);
            n = new a("ENUM", 13, b.h, 0);
            o = new a("SFIXED32", 14, b.a, 5);
            p = new a("SFIXED64", 15, b.b, 1);
            q = new a("SINT32", 16, b.a, 0);
            r = new a("SINT64", 17, b.b, 0);
            u = (new a[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r
            });
        }

        private a(String s1, int i1, b b1, int j1)
        {
            super(s1, i1);
            s = b1;
            t = j1;
        }

    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        private static final b k[];
        private final Object j;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/umeng/message/proguard/S$b, s);
        }

        public static b[] values()
        {
            return (b[])k.clone();
        }

        Object a()
        {
            return j;
        }

        static 
        {
            a = new b("INT", 0, Integer.valueOf(0));
            b = new b("LONG", 1, Long.valueOf(0L));
            c = new b("FLOAT", 2, Float.valueOf(0.0F));
            d = new b("DOUBLE", 3, Double.valueOf(0.0D));
            e = new b("BOOLEAN", 4, Boolean.valueOf(false));
            f = new b("STRING", 5, "");
            g = new b("BYTE_STRING", 6, g.d);
            h = new b("ENUM", 7, null);
            i = new b("MESSAGE", 8, null);
            k = (new b[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private b(String s, int i1, Object obj)
        {
            super(s, i1);
            j = obj;
        }
    }


    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    static final int g = 3;
    static final int h = 7;
    static final int i = 1;
    static final int j = 2;
    static final int k = 3;
    static final int l = a(1, 3);
    static final int m = a(1, 4);
    static final int n = a(2, 0);
    static final int o = a(3, 2);

    private S()
    {
    }

    static int a(int i1)
    {
        return i1 & 7;
    }

    static int a(int i1, int j1)
    {
        return i1 << 3 | j1;
    }

    public static int b(int i1)
    {
        return i1 >>> 3;
    }

}
