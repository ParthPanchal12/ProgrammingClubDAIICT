// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p, aC, s, P, 
//            h, g, B, i, 
//            n, y, x, C, 
//            c

public static final class k extends p
    implements k
{
    public static final class a extends p.a
        implements aC.b
    {

        private int a;
        private Object b;
        private Object c;
        private int d;
        private int e;
        private Object f;
        private Object g;
        private b h;
        private g i;

        static a W()
        {
            return Y();
        }

        private void X()
        {
            if (!aC.a.T());
        }

        private static a Y()
        {
            return new a();
        }

        public static final k.a k()
        {
            return aC.b();
        }

        public g A()
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

        public boolean B()
        {
            return (a & 0x20) == 32;
        }

        public String C()
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

        public g D()
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

        public boolean E()
        {
            return (a & 0x40) == 64;
        }

        public b F()
        {
            return h;
        }

        public boolean G()
        {
            return (a & 0x80) == 128;
        }

        public g H()
        {
            return i;
        }

        public aC.a I()
        {
            return aC.a.h();
        }

        public k.a J()
        {
            return aC.b();
        }

        public aC.a K()
        {
            aC.a a1 = L();
            if (!a1.a())
            {
                throw b(a1);
            } else
            {
                return a1;
            }
        }

        public aC.a L()
        {
            int j1 = 1;
            aC.a a1 = new aC.a(this, null);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            aC.a.a(a1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            aC.a.b(a1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            aC.a.a(a1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            aC.a.b(a1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            aC.a.c(a1, f);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            aC.a.d(a1, g);
            j1 = i1;
            if ((k1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            aC.a.a(a1, h);
            i1 = j1;
            if ((k1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            }
            aC.a.a(a1, i);
            aC.a.c(a1, i1);
            aB();
            return a1;
        }

        public a M()
        {
            a = a & -2;
            b = aC.a.h().p();
            aF();
            return this;
        }

        public a N()
        {
            a = a & -3;
            c = aC.a.h().s();
            aF();
            return this;
        }

        public a O()
        {
            a = a & -5;
            d = 0;
            aF();
            return this;
        }

        public a P()
        {
            a = a & -9;
            e = 0;
            aF();
            return this;
        }

        public y Q()
        {
            return I();
        }

        public x R()
        {
            return I();
        }

        public a S()
        {
            a = a & 0xffffffef;
            f = aC.a.h().z();
            aF();
            return this;
        }

        public a T()
        {
            a = a & 0xffffffdf;
            g = aC.a.h().C();
            aF();
            return this;
        }

        public a U()
        {
            a = a & 0xffffffbf;
            h = b.a;
            aF();
            return this;
        }

        public a V()
        {
            a = a & 0xffffff7f;
            i = aC.a.h().H();
            aF();
            return this;
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
            a = a | 4;
            d = i1;
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
                a = a | 0x40;
                h = b1;
                aF();
                return this;
            }
        }

        public a a(aC.a a1)
        {
            if (a1 == aC.a.h())
            {
                return this;
            }
            if (a1.o())
            {
                a = a | 1;
                b = aC.a.b(a1);
                aF();
            }
            if (a1.r())
            {
                a = a | 2;
                c = aC.a.c(a1);
                aF();
            }
            if (a1.u())
            {
                a(a1.v());
            }
            if (a1.w())
            {
                b(a1.x());
            }
            if (a1.y())
            {
                a = a | 0x10;
                f = aC.a.d(a1);
                aF();
            }
            if (a1.B())
            {
                a = a | 0x20;
                g = aC.a.e(a1);
                aF();
            }
            if (a1.E())
            {
                a(a1.F());
            }
            if (a1.G())
            {
                i(a1.H());
            }
            d(a1.b_());
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
            return true;
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return n();
        }

        public x aj()
        {
            return L();
        }

        public x ak()
        {
            return K();
        }

        public y al()
        {
            return L();
        }

        public y am()
        {
            return K();
        }

        public a b(int i1)
        {
            a = a | 8;
            e = i1;
            aF();
            return this;
        }

        public a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 2;
                c = s1;
                aF();
                return this;
            }
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a c(String s1)
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
            return n();
        }

        public a.a d()
        {
            return n();
        }

        public a d(x x1)
        {
            if (x1 instanceof aC.a)
            {
                return a((aC.a)x1);
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
                a = a | 0x20;
                g = s1;
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
            h1 = (aC.a)aC.a.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (aC.a)n1.a();
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

        public a f(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 2;
                c = g1;
                aF();
                return this;
            }
        }

        public b.a f()
        {
            return n();
        }

        public a g(g g1)
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

        public y.a g()
        {
            return n();
        }

        public a h(g g1)
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

        public y.a h()
        {
            return m();
        }

        public a i(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x80;
                i = g1;
                aF();
                return this;
            }
        }

        public x.a i()
        {
            return n();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return aC.c().a(com/umeng/message/proguard/aC$a, com/umeng/message/proguard/aC$a$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = 0;
            a = a & -5;
            e = 0;
            a = a & -9;
            f = "";
            a = a & 0xffffffef;
            g = "";
            a = a & 0xffffffdf;
            h = b.a;
            a = a & 0xffffffbf;
            i = g.d;
            a = a & 0xffffff7f;
            return this;
        }

        public a n()
        {
            return Y().a(L());
        }

        public boolean o()
        {
            return (a & 1) == 1;
        }

        public String p()
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

        public g q()
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

        public boolean r()
        {
            return (a & 2) == 2;
        }

        public String s()
        {
            Object obj = c;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                c = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g t()
        {
            Object obj = c;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                c = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean u()
        {
            return (a & 4) == 4;
        }

        public int v()
        {
            return d;
        }

        public boolean w()
        {
            return (a & 8) == 8;
        }

        public int x()
        {
            return e;
        }

        public boolean y()
        {
            return (a & 0x10) == 16;
        }

        public String z()
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

        private a()
        {
            b = "";
            c = "";
            f = "";
            g = "";
            h = b.a;
            i = g.d;
            X();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            f = "";
            g = "";
            h = b.a;
            i = g.d;
            X();
        }

        a(p.b b1, aC._cls1 _pcls1)
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
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 2;
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

            case 0: // '\0'
                return a;

            case 1: // '\001'
                return b;

            case 2: // '\002'
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
            return (k.d)aC.a.n().k().get(0);
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/umeng/message/proguard/aC$a$b, s1);
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
            a = new b("JSON", 0, 0, 0);
            b = new b("JSON_AES", 1, 1, 1);
            c = new b("JSON_RSA", 2, 2, 2);
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


    public static B a = new c() {

        public aC.a c(h h1, n n1)
            throws s
        {
            return new aC.a(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    private static final _cls1.c j;
    private static final long x = 0L;
    private final P k;
    private int l;
    private Object n;
    private Object o;
    private int p;
    private int q;
    private Object r;
    private Object s;
    private b t;
    private g u;
    private byte v;
    private int w;

    public static a K()
    {
        return a.W();
    }

    static boolean T()
    {
        return m;
    }

    private void U()
    {
        n = "";
        o = "";
        p = 0;
        q = 0;
        r = "";
        s = "";
        t = b.a;
        u = g.d;
    }

    static int a(u u1, int i1)
    {
        u1.p = i1;
        return i1;
    }

    public static a a(p p1)
    {
        return K().a(p1);
    }

    static b a(b b1, b b2)
    {
        b1.t = b2;
        return b2;
    }

    public static t a(g g1)
        throws s
    {
        return (t)a.d(g1);
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

    static g a(a a1, g g1)
    {
        a1.u = g1;
        return g1;
    }

    static Object a(u u1, Object obj)
    {
        u1.n = obj;
        return obj;
    }

    static int b(n n1, int i1)
    {
        n1.q = i1;
        return i1;
    }

    public static q b(InputStream inputstream)
        throws IOException
    {
        return (q)a.f(inputstream);
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
        n1.o = obj;
        return obj;
    }

    static int c(o o1, int i1)
    {
        o1.l = i1;
        return i1;
    }

    static Object c(l l1)
    {
        return l1.o;
    }

    static Object c(o o1, Object obj)
    {
        o1.r = obj;
        return obj;
    }

    static Object d(r r1)
    {
        return r1.r;
    }

    static Object d(r r1, Object obj)
    {
        r1.s = obj;
        return obj;
    }

    static Object e(s s1)
    {
        return s1.s;
    }

    public static s h()
    {
        return j;
    }

    public static final j n()
    {
        return aC.b();
    }

    public g A()
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

    public boolean B()
    {
        return (l & 0x20) == 32;
    }

    public String C()
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

    public g D()
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

    public boolean E()
    {
        return (l & 0x40) == 64;
    }

    public b F()
    {
        return t;
    }

    public boolean G()
    {
        return (l & 0x80) == 128;
    }

    public g H()
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
        return k();
    }

    public x R()
    {
        return k();
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
            i1.a(1, q());
        }
        if ((l & 2) == 2)
        {
            i1.a(2, t());
        }
        if ((l & 4) == 4)
        {
            i1.a(3, p);
        }
        if ((l & 8) == 8)
        {
            i1.a(4, q);
        }
        if ((l & 0x10) == 16)
        {
            i1.a(5, A());
        }
        if ((l & 0x20) == 32)
        {
            i1.a(6, D());
        }
        if ((l & 0x40) == 64)
        {
            i1.d(7, t.a());
        }
        if ((l & 0x80) == 128)
        {
            i1.a(8, u);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = v;
        if (byte0 != -1)
        {
            return byte0 == 1;
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
            j1 = 0 + com.umeng.message.proguard.i.c(1, q());
        }
        i1 = j1;
        if ((l & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(2, t());
        }
        j1 = i1;
        if ((l & 4) == 4)
        {
            j1 = i1 + com.umeng.message.proguard.i.g(3, p);
        }
        i1 = j1;
        if ((l & 8) == 8)
        {
            i1 = j1 + com.umeng.message.proguard.i.g(4, q);
        }
        j1 = i1;
        if ((l & 0x10) == 16)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(5, A());
        }
        i1 = j1;
        if ((l & 0x20) == 32)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(6, D());
        }
        j1 = i1;
        if ((l & 0x40) == 64)
        {
            j1 = i1 + com.umeng.message.proguard.i.j(7, t.a());
        }
        i1 = j1;
        if ((l & 0x80) == 128)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(8, u);
        }
        i1 += b_().d();
        w = i1;
        return i1;
    }

    public w k()
    {
        return j;
    }

    protected j l()
    {
        return aC.c().(com/umeng/message/proguard/aC$a, com/umeng/message/proguard/aC$a$a);
    }

    public B m()
    {
        return a;
    }

    public boolean o()
    {
        return (l & 1) == 1;
    }

    public String p()
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

    public g q()
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

    public boolean r()
    {
        return (l & 2) == 2;
    }

    public String s()
    {
        Object obj = o;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            o = s1;
        }
        return s1;
    }

    public g t()
    {
        Object obj = o;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            o = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean u()
    {
        return (l & 4) == 4;
    }

    public int v()
    {
        return p;
    }

    public boolean w()
    {
        return (l & 8) == 8;
    }

    public int x()
    {
        return q;
    }

    public boolean y()
    {
        return (l & 0x10) == 16;
    }

    public String z()
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

    static 
    {
        j = new <init>(true);
        j.U();
    }

    private b(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        v = -1;
        w = -1;
        U();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L16:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 9: default 392
    //                   0: 395
    //                   10: 138
    //                   18: 181
    //                   24: 219
    //                   32: 240
    //                   42: 262
    //                   50: 284
    //                   56: 306
    //                   66: 356;
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
        h1;
        throw h1.a(this);
        h1;
        k = _lcls1.();
        ad();
        throw h1;
_L6:
        l = l | 2;
        o = h1.l();
        continue; /* Loop/switch isn't completed */
        h1;
        throw (new s(h1.getMessage())).a(this);
_L7:
        l = l | 4;
        p = h1.g();
        continue; /* Loop/switch isn't completed */
_L8:
        l = l | 8;
        q = h1.g();
        continue; /* Loop/switch isn't completed */
_L9:
        l = l | 0x10;
        r = h1.l();
        continue; /* Loop/switch isn't completed */
_L10:
        l = l | 0x20;
        s = h1.l();
        continue; /* Loop/switch isn't completed */
_L11:
        b b1;
        i1 = h1.n();
        b1 = b.a(i1);
        if (b1 != null) goto _L14; else goto _L13
_L13:
        _lcls1.(7, i1);
        continue; /* Loop/switch isn't completed */
_L14:
        l = l | 0x40;
        t = b1;
        continue; /* Loop/switch isn't completed */
_L12:
        l = l | 0x80;
        u = h1.l();
        continue; /* Loop/switch isn't completed */
_L2:
        k = _lcls1.();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L16; else goto _L15
_L15:
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
        k = <init>1._();
    }

    _(_ _p, _ _p1)
    {
        this(_p);
    }

    private <init>(boolean flag)
    {
        v = -1;
        w = -1;
        k = com.umeng.message.proguard.P.c();
    }
}
