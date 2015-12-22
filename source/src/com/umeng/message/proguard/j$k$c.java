// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            C, j

public static final class N extends Enum
    implements C
{

    public static final int A = 9;
    public static final int B = 10;
    public static final int C = 11;
    public static final int D = 12;
    public static final int E = 13;
    public static final int F = 14;
    public static final int G = 15;
    public static final int H = 16;
    public static final int I = 17;
    public static final int J = 18;
    private static r K = new r.b() {

        public j.k.c a(int i1)
        {
            return j.k.c.a(i1);
        }

        public r.a b(int i1)
        {
            return a(i1);
        }

    };
    private static final _cls1.a L[] = values();
    private static final values O[];
    public static final values a;
    public static final values b;
    public static final values c;
    public static final values d;
    public static final values e;
    public static final values f;
    public static final values g;
    public static final values h;
    public static final values i;
    public static final values j;
    public static final values k;
    public static final values l;
    public static final values m;
    public static final values n;
    public static final values o;
    public static final values p;
    public static final values q;
    public static final values r;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;
    public static final int w = 5;
    public static final int x = 6;
    public static final int y = 7;
    public static final int z = 8;
    private final int M;
    private final int N;

    public static N a(int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            return a;

        case 2: // '\002'
            return b;

        case 3: // '\003'
            return c;

        case 4: // '\004'
            return d;

        case 5: // '\005'
            return e;

        case 6: // '\006'
            return f;

        case 7: // '\007'
            return g;

        case 8: // '\b'
            return h;

        case 9: // '\t'
            return i;

        case 10: // '\n'
            return j;

        case 11: // '\013'
            return k;

        case 12: // '\f'
            return l;

        case 13: // '\r'
            return m;

        case 14: // '\016'
            return n;

        case 15: // '\017'
            return o;

        case 16: // '\020'
            return p;

        case 17: // '\021'
            return q;

        case 18: // '\022'
            return r;
        }
    }

    public static r a(r r1)
    {
        if (r1.r() != e())
        {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else
        {
            return L[r1.L()];
        }
    }

    public static L b()
    {
        return K;
    }

    public static final K e()
    {
        return (K)K().K().get(0);
    }

    public static K valueOf(String s1)
    {
        return (K)Enum.valueOf(com/umeng/message/proguard/j$k$c, s1);
    }

    public static K[] values()
    {
        return (K[])O.clone();
    }

    public final int a()
    {
        return N;
    }

    public final N c()
    {
        return (N)e().e().get(M);
    }

    public final M d()
    {
        return e();
    }

    static 
    {
        a = new <init>("TYPE_DOUBLE", 0, 0, 1);
        b = new <init>("TYPE_FLOAT", 1, 1, 2);
        c = new <init>("TYPE_INT64", 2, 2, 3);
        d = new <init>("TYPE_UINT64", 3, 3, 4);
        e = new <init>("TYPE_INT32", 4, 4, 5);
        f = new <init>("TYPE_FIXED64", 5, 5, 6);
        g = new <init>("TYPE_FIXED32", 6, 6, 7);
        h = new <init>("TYPE_BOOL", 7, 7, 8);
        i = new <init>("TYPE_STRING", 8, 8, 9);
        j = new <init>("TYPE_GROUP", 9, 9, 10);
        k = new <init>("TYPE_MESSAGE", 10, 10, 11);
        l = new <init>("TYPE_BYTES", 11, 11, 12);
        m = new <init>("TYPE_UINT32", 12, 12, 13);
        n = new <init>("TYPE_ENUM", 13, 13, 14);
        o = new <init>("TYPE_SFIXED32", 14, 14, 15);
        p = new <init>("TYPE_SFIXED64", 15, 15, 16);
        q = new <init>("TYPE_SINT32", 16, 16, 17);
        r = new <init>("TYPE_SINT64", 17, 17, 18);
        O = (new O[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r
        });
    }

    private _cls1(String s1, int i1, int j1, int k1)
    {
        super(s1, i1);
        M = j1;
        N = k1;
    }
}
