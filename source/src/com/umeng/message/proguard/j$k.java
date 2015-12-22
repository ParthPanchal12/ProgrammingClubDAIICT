// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p, j, s, P, 
//            h, B, g, i, 
//            n, y, x, L, 
//            C, c

public static final class k extends p
    implements k
{
    public static final class a extends p.a
        implements j.l
    {

        private int a;
        private Object b;
        private int c;
        private b d;
        private c e;
        private Object f;
        private Object g;
        private Object h;
        private j.m i;
        private L j;

        static a Y()
        {
            return aa();
        }

        private void Z()
        {
            if (p.m)
            {
                ab();
            }
        }

        private static a aa()
        {
            return new a();
        }

        private L ab()
        {
            if (j == null)
            {
                j = new L(i, aE(), aD());
                i = null;
            }
            return j;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.j();
        }

        public String A()
        {
            Object obj = g;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                g = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g B()
        {
            Object obj = g;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                g = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean C()
        {
            return (a & 0x40) == 64;
        }

        public String D()
        {
            Object obj = h;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                h = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g E()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                h = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean F()
        {
            return (a & 0x80) == 128;
        }

        public j.m G()
        {
            if (j == null)
            {
                return i;
            } else
            {
                return (j.m)j.c();
            }
        }

        public j.n H()
        {
            if (j != null)
            {
                return (j.n)j.f();
            } else
            {
                return i;
            }
        }

        public a I()
        {
            return aa().a(M());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.j();
        }

        public j.k K()
        {
            return j.k.h();
        }

        public j.k L()
        {
            j.k k1 = M();
            if (!k1.a())
            {
                throw b(k1);
            } else
            {
                return k1;
            }
        }

        public j.k M()
        {
            int j1 = 1;
            j.k k1 = new j.k(this, null);
            int l1 = a;
            int i1;
            if ((l1 & 1) != 1)
            {
                j1 = 0;
            }
            j.k.a(k1, b);
            i1 = j1;
            if ((l1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            j.k.a(k1, c);
            j1 = i1;
            if ((l1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            j.k.a(k1, d);
            i1 = j1;
            if ((l1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            j.k.a(k1, e);
            j1 = i1;
            if ((l1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            j.k.b(k1, f);
            i1 = j1;
            if ((l1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            j.k.c(k1, g);
            j1 = i1;
            if ((l1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            j.k.d(k1, h);
            if ((l1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            } else
            {
                i1 = j1;
            }
            if (j == null)
            {
                j.k.a(k1, i);
            } else
            {
                j.k.a(k1, (j.m)j.d());
            }
            j.k.b(k1, i1);
            aB();
            return k1;
        }

        public a N()
        {
            a = a & -2;
            b = j.k.h().o();
            aF();
            return this;
        }

        public a O()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public a P()
        {
            a = a & -5;
            d = b.a;
            aF();
            return this;
        }

        public y Q()
        {
            return K();
        }

        public x R()
        {
            return K();
        }

        public a S()
        {
            a = a & -9;
            e = c.a;
            aF();
            return this;
        }

        public a T()
        {
            a = a & 0xffffffef;
            f = j.k.h().x();
            aF();
            return this;
        }

        public a U()
        {
            a = a & 0xffffffdf;
            g = j.k.h().A();
            aF();
            return this;
        }

        public a V()
        {
            a = a & 0xffffffbf;
            h = j.k.h().D();
            aF();
            return this;
        }

        public a W()
        {
            if (j == null)
            {
                i = com.umeng.message.proguard.j.m.h();
                aF();
            } else
            {
                j.g();
            }
            a = a & 0xffffff7f;
            return this;
        }

        public j.m.a X()
        {
            a = a | 0x80;
            aF();
            return (j.m.a)ab().e();
        }

        public a.a a(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(x x1)
        {
            return d(x1);
        }

        public a a(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public a a(b b1)
        {
            if (b1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 4;
                d = b1;
                aF();
                return this;
            }
        }

        public a a(c c1)
        {
            if (c1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 8;
                e = c1;
                aF();
                return this;
            }
        }

        public a a(j.k k1)
        {
            if (k1 == j.k.h())
            {
                return this;
            }
            if (k1.n())
            {
                a = a | 1;
                b = j.k.b(k1);
                aF();
            }
            if (k1.q())
            {
                a(k1.r());
            }
            if (k1.s())
            {
                a(k1.t());
            }
            if (k1.u())
            {
                a(k1.v());
            }
            if (k1.w())
            {
                a = a | 0x10;
                f = j.k.c(k1);
                aF();
            }
            if (k1.z())
            {
                a = a | 0x20;
                g = j.k.d(k1);
                aF();
            }
            if (k1.C())
            {
                a = a | 0x40;
                h = j.k.e(k1);
                aF();
            }
            if (k1.F())
            {
                b(k1.G());
            }
            d(k1.b_());
            return this;
        }

        public a a(j.m.a a1)
        {
            if (j == null)
            {
                i = a1.F();
                aF();
            } else
            {
                j.a(a1.F());
            }
            a = a | 0x80;
            return this;
        }

        public a a(j.m m1)
        {
            if (j == null)
            {
                if (m1 == null)
                {
                    throw new NullPointerException();
                }
                i = m1;
                aF();
            } else
            {
                j.a(m1);
            }
            a = a | 0x80;
            return this;
        }

        public a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 1;
                b = s1;
                aF();
                return this;
            }
        }

        public final boolean a()
        {
            return !F() || G().a();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return I();
        }

        public x aj()
        {
            return M();
        }

        public x ak()
        {
            return L();
        }

        public y al()
        {
            return M();
        }

        public y am()
        {
            return L();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(j.m m1)
        {
            if (j == null)
            {
                if ((a & 0x80) == 128 && i != com.umeng.message.proguard.j.m.h())
                {
                    i = com.umeng.message.proguard.j.m.a(i).a(m1).G();
                } else
                {
                    i = m1;
                }
                aF();
            } else
            {
                j.b(m1);
            }
            a = a | 0x80;
            return this;
        }

        public a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x10;
                f = s1;
                aF();
                return this;
            }
        }

        public a c(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x20;
                g = s1;
                aF();
                return this;
            }
        }

        public x.a c(x x1)
        {
            return d(x1);
        }

        public y.a c(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return I();
        }

        public a.a d()
        {
            return I();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.k)
            {
                return a((j.k)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public a d(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x40;
                h = s1;
                aF();
                return this;
            }
        }

        public x.a d(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public a e(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 1;
                b = g1;
                aF();
                return this;
            }
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.k)j.k.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.k)n1.a();
            throw n1;
            n1;
_L2:
            if (h1 != null)
            {
                a(h1);
            }
            throw n1;
            n1;
            h1 = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public b.a f()
        {
            return I();
        }

        public a f(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x10;
                f = g1;
                aF();
                return this;
            }
        }

        public a g(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x20;
                g = g1;
                aF();
                return this;
            }
        }

        public y.a g()
        {
            return I();
        }

        public a h(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x40;
                h = g1;
                aF();
                return this;
            }
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return I();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.k().a(com/umeng/message/proguard/j$k, com/umeng/message/proguard/j$k$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = 0;
            a = a & -3;
            d = b.a;
            a = a & -5;
            e = c.a;
            a = a & -9;
            f = "";
            a = a & 0xffffffef;
            g = "";
            a = a & 0xffffffdf;
            h = "";
            a = a & 0xffffffbf;
            if (j == null)
            {
                i = com.umeng.message.proguard.j.m.h();
            } else
            {
                j.g();
            }
            a = a & 0xffffff7f;
            return this;
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public String o()
        {
            Object obj = b;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public int r()
        {
            return c;
        }

        public boolean s()
        {
            return (a & 4) == 4;
        }

        public b t()
        {
            return d;
        }

        public boolean u()
        {
            return (a & 8) == 8;
        }

        public c v()
        {
            return e;
        }

        public boolean w()
        {
            return (a & 0x10) == 16;
        }

        public String x()
        {
            Object obj = f;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                f = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g y()
        {
            Object obj = f;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                f = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean z()
        {
            return (a & 0x20) == 32;
        }

        private a()
        {
            b = "";
            d = b.a;
            e = c.a;
            f = "";
            g = "";
            h = "";
            i = com.umeng.message.proguard.j.m.h();
            Z();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            d = b.a;
            e = c.a;
            f = "";
            g = "";
            h = "";
            i = com.umeng.message.proguard.j.m.h();
            Z();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }

    public static final class b extends Enum
        implements C
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static r.b g = new r.b() {

            public b a(int i1)
            {
                return b.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final b h[] = values();
        private static final b k[];
        private final int i;
        private final int j;

        public static b a(int i1)
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
            }
        }

        public static b a(k.e e1)
        {
            if (e1.g() != e())
            {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else
            {
                return h[e1.b()];
            }
        }

        public static r.b b()
        {
            return g;
        }

        public static final k.d e()
        {
            return (k.d)j.k.k().k().get(1);
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/umeng/message/proguard/j$k$b, s1);
        }

        public static b[] values()
        {
            return (b[])k.clone();
        }

        public final int a()
        {
            return j;
        }

        public final k.e c()
        {
            return (k.e)e().h().get(i);
        }

        public final k.d d()
        {
            return e();
        }

        static 
        {
            a = new b("LABEL_OPTIONAL", 0, 0, 1);
            b = new b("LABEL_REQUIRED", 1, 1, 2);
            c = new b("LABEL_REPEATED", 2, 2, 3);
            k = (new b[] {
                a, b, c
            });
        }

        private b(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            i = j1;
            j = k1;
        }
    }

    public static final class c extends Enum
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
        private static r.b K = new r.b() {

            public c a(int i1)
            {
                return c.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final c L[] = values();
        private static final c O[];
        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        public static final c f;
        public static final c g;
        public static final c h;
        public static final c i;
        public static final c j;
        public static final c k;
        public static final c l;
        public static final c m;
        public static final c n;
        public static final c o;
        public static final c p;
        public static final c q;
        public static final c r;
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

        public static c a(int i1)
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

        public static c a(k.e e1)
        {
            if (e1.g() != e())
            {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else
            {
                return L[e1.b()];
            }
        }

        public static r.b b()
        {
            return K;
        }

        public static final k.d e()
        {
            return (k.d)j.k.k().k().get(0);
        }

        public static c valueOf(String s1)
        {
            return (c)Enum.valueOf(com/umeng/message/proguard/j$k$c, s1);
        }

        public static c[] values()
        {
            return (c[])O.clone();
        }

        public final int a()
        {
            return N;
        }

        public final k.e c()
        {
            return (k.e)e().h().get(M);
        }

        public final k.d d()
        {
            return e();
        }

        static 
        {
            a = new c("TYPE_DOUBLE", 0, 0, 1);
            b = new c("TYPE_FLOAT", 1, 1, 2);
            c = new c("TYPE_INT64", 2, 2, 3);
            d = new c("TYPE_UINT64", 3, 3, 4);
            e = new c("TYPE_INT32", 4, 4, 5);
            f = new c("TYPE_FIXED64", 5, 5, 6);
            g = new c("TYPE_FIXED32", 6, 6, 7);
            h = new c("TYPE_BOOL", 7, 7, 8);
            i = new c("TYPE_STRING", 8, 8, 9);
            j = new c("TYPE_GROUP", 9, 9, 10);
            k = new c("TYPE_MESSAGE", 10, 10, 11);
            l = new c("TYPE_BYTES", 11, 11, 12);
            m = new c("TYPE_UINT32", 12, 12, 13);
            n = new c("TYPE_ENUM", 13, 13, 14);
            o = new c("TYPE_SFIXED32", 14, 14, 15);
            p = new c("TYPE_SFIXED64", 15, 15, 16);
            q = new c("TYPE_SINT32", 16, 16, 17);
            r = new c("TYPE_SINT64", 17, 17, 18);
            O = (new c[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r
            });
        }

        private c(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            M = j1;
            N = k1;
        }
    }


    public static B a = new com.umeng.message.proguard.c() {

        public j.k c(h h1, n n1)
            throws s
        {
            return new j.k(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 2;
    public static final int h = 7;
    public static final int i = 8;
    private static final _cls1.c j;
    private static final long x = 0L;
    private final P k;
    private int l;
    private Object n;
    private int o;
    private b p;
    private c q;
    private Object r;
    private Object s;
    private Object t;
    private c u;
    private byte v;
    private int w;

    public static a K()
    {
        return a.Y();
    }

    private void T()
    {
        n = "";
        o = 0;
        p = b.a;
        q = c.a;
        r = "";
        s = "";
        t = "";
        u = h();
    }

    static int a(h h1, int i1)
    {
        h1.o = i1;
        return i1;
    }

    public static a a(o o1)
    {
        return K().a(o1);
    }

    static b a(b b1, b b2)
    {
        b1.p = b2;
        return b2;
    }

    static c a(c c1, c c2)
    {
        c1.q = c2;
        return c2;
    }

    public static q a(g g1)
        throws s
    {
        return (q)a.d(g1);
    }

    public static a a(g g1, n n1)
        throws s
    {
        return (a)a.d(g1, n1);
    }

    public static a a(h h1)
        throws IOException
    {
        return (a)a.d(h1);
    }

    public static a a(h h1, n n1)
        throws IOException
    {
        return (a)a.b(h1, n1);
    }

    public static a a(InputStream inputstream)
        throws IOException
    {
        return (a)a.h(inputstream);
    }

    public static a a(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.h(inputstream, n1);
    }

    public static a a(byte abyte0[])
        throws s
    {
        return (a)a.d(abyte0);
    }

    public static a a(byte abyte0[], n n1)
        throws s
    {
        return (a)a.d(abyte0, n1);
    }

    static a a(a a1, a a2)
    {
        a1.u = a2;
        return a2;
    }

    static Object a(u u1, Object obj)
    {
        u1.n = obj;
        return obj;
    }

    static int b(n n1, int i1)
    {
        n1.l = i1;
        return i1;
    }

    public static l b(InputStream inputstream)
        throws IOException
    {
        return (l)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.n;
    }

    static Object b(n n1, Object obj)
    {
        n1.r = obj;
        return obj;
    }

    static Object c(r r1)
    {
        return r1.r;
    }

    static Object c(r r1, Object obj)
    {
        r1.s = obj;
        return obj;
    }

    static Object d(s s1)
    {
        return s1.s;
    }

    static Object d(s s1, Object obj)
    {
        s1.t = obj;
        return obj;
    }

    static Object e(t t1)
    {
        return t1.t;
    }

    public static t h()
    {
        return j;
    }

    public static final j k()
    {
        return com.umeng.message.proguard.j.j();
    }

    public String A()
    {
        Object obj = s;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            s = s1;
        }
        return s1;
    }

    public g B()
    {
        Object obj = s;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            s = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean C()
    {
        return (l & 0x40) == 64;
    }

    public String D()
    {
        Object obj = t;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            t = s1;
        }
        return s1;
    }

    public g E()
    {
        Object obj = t;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            t = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean F()
    {
        return (l & 0x80) == 128;
    }

    public l G()
    {
        return u;
    }

    public u H()
    {
        return u;
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public a L()
    {
        return K();
    }

    public K M()
    {
        return S();
    }

    public S N()
    {
        return L();
    }

    public L O()
    {
        return S();
    }

    public S P()
    {
        return L();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    public a S()
    {
        return a(this);
    }

    protected a a(a a1)
    {
        return new a(a1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        if ((l & 1) == 1)
        {
            i1.a(1, p());
        }
        if ((l & 0x20) == 32)
        {
            i1.a(2, B());
        }
        if ((l & 2) == 2)
        {
            i1.a(3, o);
        }
        if ((l & 4) == 4)
        {
            i1.d(4, p.a());
        }
        if ((l & 8) == 8)
        {
            i1.d(5, q.a());
        }
        if ((l & 0x10) == 16)
        {
            i1.a(6, y());
        }
        if ((l & 0x40) == 64)
        {
            i1.a(7, E());
        }
        if ((l & 0x80) == 128)
        {
            i1.c(8, u);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = v;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        if (F() && !G().a())
        {
            v = 0;
            return false;
        } else
        {
            v = 1;
            return true;
        }
    }

    protected v b(v v1)
    {
        return a(v1);
    }

    public final P b_()
    {
        return k;
    }

    public int d()
    {
        int i1 = w;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((l & 1) == 1)
        {
            j1 = 0 + com.umeng.message.proguard.i.c(1, p());
        }
        i1 = j1;
        if ((l & 0x20) == 32)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(2, B());
        }
        j1 = i1;
        if ((l & 2) == 2)
        {
            j1 = i1 + com.umeng.message.proguard.i.g(3, o);
        }
        i1 = j1;
        if ((l & 4) == 4)
        {
            i1 = j1 + com.umeng.message.proguard.i.j(4, p.a());
        }
        j1 = i1;
        if ((l & 8) == 8)
        {
            j1 = i1 + com.umeng.message.proguard.i.j(5, q.a());
        }
        i1 = j1;
        if ((l & 0x10) == 16)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(6, y());
        }
        j1 = i1;
        if ((l & 0x40) == 64)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(7, E());
        }
        i1 = j1;
        if ((l & 0x80) == 128)
        {
            i1 = j1 + com.umeng.message.proguard.i.g(8, u);
        }
        i1 += b_().d();
        w = i1;
        return i1;
    }

    public w i()
    {
        return j;
    }

    protected j l()
    {
        return com.umeng.message.proguard.j.k().a(com/umeng/message/proguard/j$k, com/umeng/message/proguard/j$k$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (l & 1) == 1;
    }

    public String o()
    {
        Object obj = n;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            n = s1;
        }
        return s1;
    }

    public g p()
    {
        Object obj = n;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            n = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean q()
    {
        return (l & 2) == 2;
    }

    public int r()
    {
        return o;
    }

    public boolean s()
    {
        return (l & 4) == 4;
    }

    public b t()
    {
        return p;
    }

    public boolean u()
    {
        return (l & 8) == 8;
    }

    public c v()
    {
        return q;
    }

    public boolean w()
    {
        return (l & 0x10) == 16;
    }

    public String x()
    {
        Object obj = r;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            r = s1;
        }
        return s1;
    }

    public g y()
    {
        Object obj = r;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            r = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean z()
    {
        return (l & 0x20) == 32;
    }

    static 
    {
        j = new <init>(true);
        j.T();
    }

    private a(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        v = -1;
        w = -1;
        T();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L23:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 9: default 475
    //                   0: 481
    //                   10: 139
    //                   18: 160
    //                   24: 182
    //                   32: 203
    //                   40: 249
    //                   50: 296
    //                   58: 318
    //                   66: 340;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
        if (!a(h1, _lcls1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        l = l | 1;
        n = h1.l();
        continue; /* Loop/switch isn't completed */
_L6:
        l = l | 0x20;
        s = h1.l();
        continue; /* Loop/switch isn't completed */
_L7:
        l = l | 2;
        o = h1.g();
        continue; /* Loop/switch isn't completed */
_L8:
        Object obj;
        i1 = h1.n();
        obj = b.a(i1);
        if (obj != null) goto _L14; else goto _L13
_L13:
        _lcls1.a(4, i1);
        continue; /* Loop/switch isn't completed */
_L14:
        l = l | 4;
        p = ((b) (obj));
        continue; /* Loop/switch isn't completed */
_L9:
        i1 = h1.n();
        obj = c.a(i1);
        if (obj != null) goto _L16; else goto _L15
_L15:
        _lcls1.a(5, i1);
        continue; /* Loop/switch isn't completed */
_L16:
        l = l | 8;
        q = ((c) (obj));
        continue; /* Loop/switch isn't completed */
_L10:
        l = l | 0x10;
        r = h1.l();
        continue; /* Loop/switch isn't completed */
_L11:
        l = l | 0x40;
        t = h1.l();
        continue; /* Loop/switch isn't completed */
_L12:
        if ((l & 0x80) != 128) goto _L18; else goto _L17
_L17:
        obj = u.F();
_L21:
        u = (u)h1.a(a, n1);
        if (obj == null) goto _L20; else goto _L19
_L19:
        ((a) (obj)).a(u);
        u = ((a) (obj)).G();
_L20:
        l = l | 0x80;
        continue; /* Loop/switch isn't completed */
        h1;
        throw h1.a(this);
        h1;
        k = _lcls1.b();
        ad();
        throw h1;
        h1;
        throw (new s(h1.getMessage())).a(this);
_L2:
        k = _lcls1.b();
        ad();
        return;
_L18:
        obj = null;
          goto _L21
_L4:
        flag = true;
        if (true) goto _L23; else goto _L22
_L22:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        v = -1;
        w = -1;
        k = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        v = -1;
        w = -1;
        k = com.umeng.message.proguard.P.c();
    }
}
