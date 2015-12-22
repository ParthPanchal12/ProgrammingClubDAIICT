// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, s, P, h, 
//            B, i, y, g, 
//            n, x, p, D, 
//            C, c

public static final class j extends j
    implements j
{
    public static final class a extends p.c
        implements j.n
    {

        private int a;
        private b b;
        private boolean c;
        private boolean d;
        private boolean e;
        private Object f;
        private boolean g;
        private List h;
        private D i;

        static a T()
        {
            return V();
        }

        private void U()
        {
            if (p.m)
            {
                X();
            }
        }

        private static a V()
        {
            return new a();
        }

        private void W()
        {
            if ((a & 0x40) != 64)
            {
                h = new ArrayList(h);
                a = a | 0x40;
            }
        }

        private D X()
        {
            if (i == null)
            {
                List list = h;
                boolean flag;
                if ((a & 0x40) == 64)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i = new D(list, flag, aE(), aD());
                h = null;
            }
            return i;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.x();
        }

        public p.c A()
        {
            return D();
        }

        public p.c B()
        {
            return m();
        }

        public int C()
        {
            if (i == null)
            {
                return h.size();
            } else
            {
                return i.c();
            }
        }

        public a D()
        {
            return V().a(G());
        }

        public j.m E()
        {
            return j.m.h();
        }

        public j.m F()
        {
            j.m m1 = G();
            if (!m1.a())
            {
                throw b(m1);
            } else
            {
                return m1;
            }
        }

        public j.m G()
        {
            int j1 = 1;
            j.m m1 = new j.m(this, null);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            j.m.a(m1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            j.m.a(m1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            j.m.b(m1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            j.m.c(m1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            j.m.a(m1, f);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            j.m.d(m1, g);
            if (i == null)
            {
                if ((a & 0x40) == 64)
                {
                    h = Collections.unmodifiableList(h);
                    a = a & 0xffffffbf;
                }
                j.m.a(m1, h);
            } else
            {
                j.m.a(m1, i.f());
            }
            j.m.a(m1, i1);
            aB();
            return m1;
        }

        public a H()
        {
            a = a & -2;
            b = b.a;
            aF();
            return this;
        }

        public a I()
        {
            a = a & -3;
            c = false;
            aF();
            return this;
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.x();
        }

        public a K()
        {
            a = a & -5;
            d = false;
            aF();
            return this;
        }

        public a L()
        {
            a = a & -9;
            e = false;
            aF();
            return this;
        }

        public a M()
        {
            a = a & 0xffffffef;
            f = j.m.h().w();
            aF();
            return this;
        }

        public a N()
        {
            a = a & 0xffffffdf;
            g = false;
            aF();
            return this;
        }

        public a O()
        {
            if (i == null)
            {
                h = Collections.emptyList();
                a = a & 0xffffffbf;
                aF();
                return this;
            } else
            {
                i.e();
                return this;
            }
        }

        public j.G.a P()
        {
            return (j.G.a)X().b(com.umeng.message.proguard.j.G.h());
        }

        public y Q()
        {
            return E();
        }

        public x R()
        {
            return E();
        }

        public List S()
        {
            return X().h();
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

        public j.G a(int i1)
        {
            if (i == null)
            {
                return (j.G)h.get(i1);
            } else
            {
                return (j.G)i.a(i1);
            }
        }

        public a a(int i1, j.G.a a1)
        {
            if (i == null)
            {
                W();
                h.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                i.a(i1, a1.G());
                return this;
            }
        }

        public a a(int i1, j.G g1)
        {
            if (i == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    W();
                    h.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                i.a(i1, g1);
                return this;
            }
        }

        public a a(j.G.a a1)
        {
            if (i == null)
            {
                W();
                h.add(a1.G());
                aF();
                return this;
            } else
            {
                i.a(a1.G());
                return this;
            }
        }

        public a a(j.G g1)
        {
            if (i == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    W();
                    h.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                i.a(g1);
                return this;
            }
        }

        public a a(b b1)
        {
            if (b1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 1;
                b = b1;
                aF();
                return this;
            }
        }

        public a a(j.m m1)
        {
            D d1;
            d1 = null;
            if (m1 == j.m.h())
            {
                return this;
            }
            if (m1.n())
            {
                a(m1.o());
            }
            if (m1.p())
            {
                a(m1.q());
            }
            if (m1.r())
            {
                b(m1.s());
            }
            if (m1.t())
            {
                c(m1.u());
            }
            if (m1.v())
            {
                a = a | 0x10;
                f = j.m.b(m1);
                aF();
            }
            if (m1.y())
            {
                d(m1.z());
            }
            if (i != null) goto _L2; else goto _L1
_L1:
            if (!j.m.c(m1).isEmpty())
            {
                if (h.isEmpty())
                {
                    h = j.m.c(m1);
                    a = a & 0xffffffbf;
                } else
                {
                    W();
                    h.addAll(j.m.c(m1));
                }
                aF();
            }
_L4:
            a(((p.d) (m1)));
            d(m1.b_());
            return this;
_L2:
            if (!j.m.c(m1).isEmpty())
            {
                if (i.d())
                {
                    i.b();
                    i = null;
                    h = j.m.c(m1);
                    a = a & 0xffffffbf;
                    if (p.m)
                    {
                        d1 = X();
                    }
                    i = d1;
                } else
                {
                    i.a(j.m.c(m1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(Iterable iterable)
        {
            if (i == null)
            {
                W();
                com.umeng.message.proguard.p.c.a(iterable, h);
                aF();
                return this;
            } else
            {
                i.a(iterable);
                return this;
            }
        }

        public a a(String s1)
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

        public a a(boolean flag)
        {
            a = a | 2;
            c = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= C()) goto _L2; else goto _L1
_L1:
            if (a(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!af()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return D();
        }

        public x aj()
        {
            return G();
        }

        public x ak()
        {
            return F();
        }

        public y al()
        {
            return G();
        }

        public y am()
        {
            return F();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public j.H b(int i1)
        {
            if (i == null)
            {
                return (j.H)h.get(i1);
            } else
            {
                return (j.H)i.c(i1);
            }
        }

        public a b(int i1, j.G.a a1)
        {
            if (i == null)
            {
                W();
                h.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                i.b(i1, a1.G());
                return this;
            }
        }

        public a b(int i1, j.G g1)
        {
            if (i == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    W();
                    h.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                i.b(i1, g1);
                return this;
            }
        }

        public a b(boolean flag)
        {
            a = a | 4;
            d = flag;
            aF();
            return this;
        }

        public a c(int i1)
        {
            if (i == null)
            {
                W();
                h.remove(i1);
                aF();
                return this;
            } else
            {
                i.d(i1);
                return this;
            }
        }

        public a c(boolean flag)
        {
            a = a | 8;
            e = flag;
            aF();
            return this;
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
            return D();
        }

        public a.a d()
        {
            return D();
        }

        public j.G.a d(int i1)
        {
            return (j.G.a)X().b(i1);
        }

        public a d(x x1)
        {
            if (x1 instanceof j.m)
            {
                return a((j.m)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public a d(boolean flag)
        {
            a = a | 0x20;
            g = flag;
            aF();
            return this;
        }

        public x.a d(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public List d_()
        {
            if (i == null)
            {
                return Collections.unmodifiableList(h);
            } else
            {
                return i.g();
            }
        }

        public a.a e()
        {
            return m();
        }

        public j.G.a e(int i1)
        {
            return (j.G.a)X().c(i1, com.umeng.message.proguard.j.G.h());
        }

        public a e(g g1)
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

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.m)j.m.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.m)n1.a();
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

        public List e_()
        {
            if (i != null)
            {
                return i.i();
            } else
            {
                return Collections.unmodifiableList(h);
            }
        }

        public b.a f()
        {
            return D();
        }

        public y.a g()
        {
            return D();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return D();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.y().a(com/umeng/message/proguard/j$m, com/umeng/message/proguard/j$m$a);
        }

        public a m()
        {
            super.B();
            b = b.a;
            a = a & -2;
            c = false;
            a = a & -3;
            d = false;
            a = a & -5;
            e = false;
            a = a & -9;
            f = "";
            a = a & 0xffffffef;
            g = false;
            a = a & 0xffffffdf;
            if (i == null)
            {
                h = Collections.emptyList();
                a = a & 0xffffffbf;
                return this;
            } else
            {
                i.e();
                return this;
            }
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public b o()
        {
            return b;
        }

        public boolean p()
        {
            return (a & 2) == 2;
        }

        public boolean q()
        {
            return c;
        }

        public boolean r()
        {
            return (a & 4) == 4;
        }

        public boolean s()
        {
            return d;
        }

        public boolean t()
        {
            return (a & 8) == 8;
        }

        public boolean u()
        {
            return e;
        }

        public boolean v()
        {
            return (a & 0x10) == 16;
        }

        public String w()
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

        public g x()
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

        public boolean y()
        {
            return (a & 0x20) == 32;
        }

        public boolean z()
        {
            return g;
        }

        private a()
        {
            b = b.a;
            f = "";
            h = Collections.emptyList();
            U();
        }

        private a(p.b b1)
        {
            super(b1);
            b = b.a;
            f = "";
            h = Collections.emptyList();
            U();
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
            return (k.d)j.m.k().k().get(0);
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/umeng/message/proguard/j$m$b, s1);
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
            a = new b("STRING", 0, 0, 0);
            b = new b("CORD", 1, 1, 1);
            c = new b("STRING_PIECE", 2, 2, 2);
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

        public j.m c(h h1, n n1)
            throws s
        {
            return new j.m(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 5;
    public static final int e = 3;
    public static final int f = 9;
    public static final int g = 10;
    public static final int h = 999;
    private static final _cls1.c i;
    private static final long v = 0L;
    private final P j;
    private int k;
    private b l;
    private boolean n;
    private boolean o;
    private boolean p;
    private Object q;
    private boolean r;
    private List s;
    private byte t;
    private int u;

    public static a D()
    {
        return a.T();
    }

    private void G()
    {
        l = b.a;
        n = false;
        o = false;
        p = false;
        q = "";
        r = false;
        s = Collections.emptyList();
    }

    static int a( , int i1)
    {
        .k = i1;
        return i1;
    }

    public static a a(k k1)
    {
        return D().a(k1);
    }

    static b a(b b1, b b2)
    {
        b1.l = b2;
        return b2;
    }

    public static l a(g g1)
        throws s
    {
        return (l)a.d(g1);
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

    static Object a(a a1, Object obj)
    {
        a1.q = obj;
        return obj;
    }

    static List a(q q1, List list)
    {
        q1.s = list;
        return list;
    }

    static boolean a(s s1, boolean flag)
    {
        s1.n = flag;
        return flag;
    }

    public static n b(InputStream inputstream)
        throws IOException
    {
        return (n)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.q;
    }

    static boolean b(q q1, boolean flag)
    {
        q1.o = flag;
        return flag;
    }

    static List c(o o1)
    {
        return o1.s;
    }

    static boolean c(s s1, boolean flag)
    {
        s1.p = flag;
        return flag;
    }

    static boolean d(p p1, boolean flag)
    {
        p1.r = flag;
        return flag;
    }

    public static r h()
    {
        return i;
    }

    public static final i k()
    {
        return com.umeng.message.proguard.j.x();
    }

    public int C()
    {
        return s.size();
    }

    public a E()
    {
        return D();
    }

    public a F()
    {
        return a(this);
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public I M()
    {
        return F();
    }

    public F N()
    {
        return E();
    }

    public E O()
    {
        return F();
    }

    public F P()
    {
        return E();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    public i a(int i1)
    {
        return (i)s.get(i1);
    }

    protected a a(s s1)
    {
        return new a(s1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        a a1 = X();
        if ((k & 1) == 1)
        {
            i1.d(1, l.a());
        }
        if ((k & 2) == 2)
        {
            i1.a(2, n);
        }
        if ((k & 8) == 8)
        {
            i1.a(3, p);
        }
        if ((k & 4) == 4)
        {
            i1.a(5, o);
        }
        if ((k & 0x10) == 16)
        {
            i1.a(9, x());
        }
        if ((k & 0x20) == 32)
        {
            i1.a(10, r);
        }
        for (int j1 = 0; j1 < s.size(); j1++)
        {
            i1.c(999, (y)s.get(j1));
        }

        a1.a(0x20000000, i1);
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = t;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        for (int i1 = 0; i1 < C(); i1++)
        {
            if (!a(i1).a())
            {
                t = 0;
                return false;
            }
        }

        if (!W())
        {
            t = 0;
            return false;
        } else
        {
            t = 1;
            return true;
        }
    }

    public t b(int i1)
    {
        return (t)s.get(i1);
    }

    protected s b(s s1)
    {
        return a(s1);
    }

    public final P b_()
    {
        return j;
    }

    public int d()
    {
        boolean flag = false;
        int i1 = u;
        if (i1 != -1)
        {
            return i1;
        }
        int j1;
        if ((k & 1) == 1)
        {
            j1 = com.umeng.message.proguard.i.j(1, l.a()) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if ((k & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.b(2, n);
        }
        j1 = i1;
        if ((k & 8) == 8)
        {
            j1 = i1 + com.umeng.message.proguard.i.b(3, p);
        }
        i1 = j1;
        if ((k & 4) == 4)
        {
            i1 = j1 + com.umeng.message.proguard.i.b(5, o);
        }
        j1 = i1;
        if ((k & 0x10) == 16)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(9, x());
        }
        i1 = j1;
        if ((k & 0x20) == 32)
        {
            i1 = j1 + com.umeng.message.proguard.i.b(10, r);
        }
        for (j1 = ((flag) ? 1 : 0); j1 < s.size();)
        {
            int k1 = com.umeng.message.proguard.i.g(999, (y)s.get(j1));
            j1++;
            i1 = k1 + i1;
        }

        i1 = Z() + i1 + b_().d();
        u = i1;
        return i1;
    }

    public List d_()
    {
        return s;
    }

    public List e_()
    {
        return s;
    }

    public s i()
    {
        return i;
    }

    protected i l()
    {
        return com.umeng.message.proguard.j.y().a(com/umeng/message/proguard/j$m, com/umeng/message/proguard/j$m$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (k & 1) == 1;
    }

    public b o()
    {
        return l;
    }

    public boolean p()
    {
        return (k & 2) == 2;
    }

    public boolean q()
    {
        return n;
    }

    public boolean r()
    {
        return (k & 4) == 4;
    }

    public boolean s()
    {
        return o;
    }

    public boolean t()
    {
        return (k & 8) == 8;
    }

    public boolean u()
    {
        return p;
    }

    public boolean v()
    {
        return (k & 0x10) == 16;
    }

    public String w()
    {
        Object obj = q;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            q = s1;
        }
        return s1;
    }

    public g x()
    {
        Object obj = q;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            q = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean y()
    {
        return (k & 0x20) == 32;
    }

    public boolean z()
    {
        return r;
    }

    static 
    {
        i = new <init>(true);
        i.G();
    }

    private b(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        boolean flag;
        flag = false;
        super();
        t = -1;
        u = -1;
        G();
        _lcls1 = com.umeng.message.proguard.P.b();
        i1 = 0;
_L17:
        if (flag) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int i2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        int j1 = h1.a();
        j1;
        JVM INSTR lookupswitch 8: default 677
    //                   0: 680
    //                   8: 158
    //                   16: 334
    //                   24: 379
    //                   40: 425
    //                   74: 470
    //                   80: 516
    //                   7994: 562;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if (!a(h1, _lcls1, n1, j1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        j1 = h1.n();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        b b1 = b.a(j1);
        if (b1 != null) goto _L13; else goto _L12
_L12:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        _lcls1.a(1, j1);
        continue; /* Loop/switch isn't completed */
        h1;
        k1 = l1;
        throw h1.a(this);
        h1;
        if ((k1 & 0x40) == 64)
        {
            s = Collections.unmodifiableList(s);
        }
        j = _lcls1.b();
        ad();
        throw h1;
_L13:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = k | 1;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        l = b1;
        continue; /* Loop/switch isn't completed */
        h1;
        k1 = i2;
        throw (new s(h1.getMessage())).a(this);
_L6:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = k | 2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        n = h1.j();
        continue; /* Loop/switch isn't completed */
_L7:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = k | 8;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        p = h1.j();
        continue; /* Loop/switch isn't completed */
_L8:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = k | 4;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = h1.j();
        continue; /* Loop/switch isn't completed */
_L9:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = k | 0x10;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        q = h1.l();
        continue; /* Loop/switch isn't completed */
_L10:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        k = k | 0x20;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        r = h1.j();
        continue; /* Loop/switch isn't completed */
_L11:
        j1 = i1;
        if ((i1 & 0x40) == 64) goto _L15; else goto _L14
_L14:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        s = new ArrayList();
        j1 = i1 | 0x40;
_L15:
        l1 = j1;
        k1 = j1;
        i2 = j1;
        s.add(h1.a(a, n1));
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L2:
        if ((i1 & 0x40) == 64)
        {
            s = Collections.unmodifiableList(s);
        }
        j = _lcls1.b();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L17; else goto _L16
_L16:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        t = -1;
        u = -1;
        j = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        t = -1;
        u = -1;
        j = com.umeng.message.proguard.P.c();
    }
}
