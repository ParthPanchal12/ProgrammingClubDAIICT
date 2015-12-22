// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p, aB, s, P, 
//            h, B, i, g, 
//            n, y, x, L, 
//            C, c, A

public static final class f extends p
    implements f
{
    public static final class a extends p.a
        implements aB.b
    {

        private int a;
        private d b;
        private Object c;
        private b d;
        private L e;

        static a D()
        {
            return F();
        }

        private void E()
        {
            if (aB.a.z())
            {
                G();
            }
        }

        private static a F()
        {
            return new a();
        }

        private L G()
        {
            if (e == null)
            {
                e = new L(d, aE(), aD());
                d = null;
            }
            return e;
        }

        public static final k.a k()
        {
            return aB.b();
        }

        public a A()
        {
            a = a & -3;
            c = aB.a.h().r();
            aF();
            return this;
        }

        public a B()
        {
            if (e == null)
            {
                d = b.h();
                aF();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public b.a C()
        {
            a = a | 4;
            aF();
            return (b.a)G().e();
        }

        public k.a J()
        {
            return aB.b();
        }

        public y Q()
        {
            return w();
        }

        public x R()
        {
            return w();
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

        public a a(b.a a1)
        {
            if (e == null)
            {
                d = a1.B();
                aF();
            } else
            {
                e.a(a1.B());
            }
            a = a | 4;
            return this;
        }

        public a a(b b1)
        {
            if (e == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                }
                d = b1;
                aF();
            } else
            {
                e.a(b1);
            }
            a = a | 4;
            return this;
        }

        public a a(d d1)
        {
            if (d1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 1;
                b = d1;
                aF();
                return this;
            }
        }

        public a a(aB.a a1)
        {
            if (a1 == aB.a.h())
            {
                return this;
            }
            if (a1.o())
            {
                a(a1.p());
            }
            if (a1.q())
            {
                a = a | 2;
                c = aB.a.b(a1);
                aF();
            }
            if (a1.t())
            {
                b(a1.u());
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
                a = a | 2;
                c = s1;
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
            return y();
        }

        public x ak()
        {
            return x();
        }

        public y al()
        {
            return y();
        }

        public y am()
        {
            return x();
        }

        public a b(b b1)
        {
            if (e == null)
            {
                if ((a & 4) == 4 && d != b.h())
                {
                    d = b.a(d).a(b1).C();
                } else
                {
                    d = b1;
                }
                aF();
            } else
            {
                e.b(b1);
            }
            a = a | 4;
            return this;
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
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
            if (x1 instanceof aB.a)
            {
                return a((aB.a)x1);
            } else
            {
                super.a(x1);
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
                a = a | 2;
                c = g1;
                aF();
                return this;
            }
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (aB.a)aB.a.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (aB.a)n1.a();
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
            return n();
        }

        public y.a g()
        {
            return n();
        }

        public y.a h()
        {
            return m();
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
            return aB.c().a(com/umeng/message/proguard/aB$a, com/umeng/message/proguard/aB$a$a);
        }

        public a m()
        {
            super.ah();
            b = d.a;
            a = a & -2;
            c = "";
            a = a & -3;
            if (e == null)
            {
                d = b.h();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public a n()
        {
            return F().a(y());
        }

        public boolean o()
        {
            return (a & 1) == 1;
        }

        public d p()
        {
            return b;
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public String r()
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

        public g s()
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

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public b u()
        {
            if (e == null)
            {
                return d;
            } else
            {
                return (b)e.c();
            }
        }

        public c v()
        {
            if (e != null)
            {
                return (c)e.f();
            } else
            {
                return d;
            }
        }

        public aB.a w()
        {
            return aB.a.h();
        }

        public aB.a x()
        {
            aB.a a1 = y();
            if (!a1.a())
            {
                throw b(a1);
            } else
            {
                return a1;
            }
        }

        public aB.a y()
        {
            int i1 = 1;
            aB.a a1 = new aB.a(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            aB.a.a(a1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            aB.a.a(a1, c);
            if ((k1 & 4) == 4)
            {
                i1 = j1 | 4;
            } else
            {
                i1 = j1;
            }
            if (e == null)
            {
                aB.a.a(a1, d);
            } else
            {
                aB.a.a(a1, (b)e.d());
            }
            aB.a.a(a1, i1);
            aB();
            return a1;
        }

        public a z()
        {
            a = a & -2;
            b = d.a;
            aF();
            return this;
        }

        private a()
        {
            b = d.a;
            c = "";
            d = b.h();
            E();
        }

        private a(p.b b1)
        {
            super(b1);
            b = d.a;
            c = "";
            d = b.h();
            E();
        }

        a(p.b b1, aB._cls1 _pcls1)
        {
            this(b1);
        }
    }

    public static final class b extends p
        implements c
    {

        public static B a = new com.umeng.message.proguard.c() {

            public b c(h h1, n n1)
                throws s
            {
                return new b(h1, n1, null);
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
        private static final b g;
        private static final long r = 0L;
        private final P h;
        private int i;
        private int j;
        private int k;
        private Object l;
        private int n;
        private Object o;
        private byte p;
        private int q;

        public static a A()
        {
            return a.I();
        }

        static boolean D()
        {
            return m;
        }

        private void E()
        {
            j = 0;
            k = 0;
            l = "";
            n = 0;
            o = "";
        }

        static int a(b b1, int i1)
        {
            b1.j = i1;
            return i1;
        }

        public static a a(b b1)
        {
            return A().a(b1);
        }

        public static b a(g g1)
            throws s
        {
            return (b)a.d(g1);
        }

        public static b a(g g1, n n1)
            throws s
        {
            return (b)a.d(g1, n1);
        }

        public static b a(h h1)
            throws IOException
        {
            return (b)a.d(h1);
        }

        public static b a(h h1, n n1)
            throws IOException
        {
            return (b)a.b(h1, n1);
        }

        public static b a(InputStream inputstream)
            throws IOException
        {
            return (b)a.h(inputstream);
        }

        public static b a(InputStream inputstream, n n1)
            throws IOException
        {
            return (b)a.h(inputstream, n1);
        }

        public static b a(byte abyte0[])
            throws s
        {
            return (b)a.d(abyte0);
        }

        public static b a(byte abyte0[], n n1)
            throws s
        {
            return (b)a.d(abyte0, n1);
        }

        static Object a(b b1, Object obj)
        {
            b1.l = obj;
            return obj;
        }

        static int b(b b1, int i1)
        {
            b1.k = i1;
            return i1;
        }

        public static b b(InputStream inputstream)
            throws IOException
        {
            return (b)a.f(inputstream);
        }

        public static b b(InputStream inputstream, n n1)
            throws IOException
        {
            return (b)a.f(inputstream, n1);
        }

        static Object b(b b1)
        {
            return b1.l;
        }

        static Object b(b b1, Object obj)
        {
            b1.o = obj;
            return obj;
        }

        static int c(b b1, int i1)
        {
            b1.n = i1;
            return i1;
        }

        static Object c(b b1)
        {
            return b1.o;
        }

        static int d(b b1, int i1)
        {
            b1.i = i1;
            return i1;
        }

        public static b h()
        {
            return g;
        }

        public static final k.a n()
        {
            return aB.d();
        }

        public a B()
        {
            return A();
        }

        public a C()
        {
            return a(this);
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return C();
        }

        public x.a N()
        {
            return B();
        }

        public y.a O()
        {
            return C();
        }

        public y.a P()
        {
            return B();
        }

        public y Q()
        {
            return k();
        }

        public x R()
        {
            return k();
        }

        protected a a(p.b b1)
        {
            return new a(b1, null);
        }

        public void a(i i1)
            throws IOException
        {
            d();
            if ((i & 1) == 1)
            {
                i1.a(1, j);
            }
            if ((i & 2) == 2)
            {
                i1.a(2, k);
            }
            if ((i & 4) == 4)
            {
                i1.a(3, u());
            }
            if ((i & 8) == 8)
            {
                i1.a(4, n);
            }
            if ((i & 0x10) == 16)
            {
                i1.a(5, z());
            }
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = p;
            if (byte0 != -1)
            {
                return byte0 == 1;
            } else
            {
                p = 1;
                return true;
            }
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return h;
        }

        public int d()
        {
            int i1 = q;
            if (i1 != -1)
            {
                return i1;
            }
            int j1 = 0;
            if ((i & 1) == 1)
            {
                j1 = 0 + com.umeng.message.proguard.i.g(1, j);
            }
            i1 = j1;
            if ((i & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.g(2, k);
            }
            j1 = i1;
            if ((i & 4) == 4)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(3, u());
            }
            i1 = j1;
            if ((i & 8) == 8)
            {
                i1 = j1 + com.umeng.message.proguard.i.g(4, n);
            }
            j1 = i1;
            if ((i & 0x10) == 16)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(5, z());
            }
            i1 = j1 + b_().d();
            q = i1;
            return i1;
        }

        public b k()
        {
            return g;
        }

        protected p.g l()
        {
            return aB.e().a(com/umeng/message/proguard/aB$a$b, com/umeng/message/proguard/aB$a$b$a);
        }

        public B m()
        {
            return a;
        }

        public boolean o()
        {
            return (i & 1) == 1;
        }

        public int p()
        {
            return j;
        }

        public boolean q()
        {
            return (i & 2) == 2;
        }

        public int r()
        {
            return k;
        }

        public boolean s()
        {
            return (i & 4) == 4;
        }

        public String t()
        {
            Object obj = l;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (g)obj;
            String s1 = ((g) (obj)).h();
            if (((g) (obj)).i())
            {
                l = s1;
            }
            return s1;
        }

        public g u()
        {
            Object obj = l;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                l = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean v()
        {
            return (i & 8) == 8;
        }

        public int w()
        {
            return n;
        }

        public boolean x()
        {
            return (i & 0x10) == 16;
        }

        public String y()
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

        public g z()
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

        static 
        {
            g = new b(true);
            g.E();
        }

        private b(h h1, n n1)
            throws s
        {
            P.a a1;
            boolean flag;
            p = -1;
            q = -1;
            E();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L11:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 6: default 273
        //                       0: 276
        //                       8: 114
        //                       16: 157
        //                       26: 195
        //                       32: 216
        //                       42: 238;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
            if (!a(h1, a1, n1, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i = i | 1;
            j = h1.g();
            continue; /* Loop/switch isn't completed */
            h1;
            throw h1.a(this);
            h1;
            h = a1.b();
            ad();
            throw h1;
_L6:
            i = i | 2;
            k = h1.g();
            continue; /* Loop/switch isn't completed */
            h1;
            throw (new s(h1.getMessage())).a(this);
_L7:
            i = i | 4;
            l = h1.l();
            continue; /* Loop/switch isn't completed */
_L8:
            i = i | 8;
            n = h1.g();
            continue; /* Loop/switch isn't completed */
_L9:
            i = i | 0x10;
            o = h1.l();
            continue; /* Loop/switch isn't completed */
_L2:
            h = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L11; else goto _L10
_L10:
        }

        b(h h1, n n1, aB._cls1 _pcls1)
            throws s
        {
            this(h1, n1);
        }

        private b(p.a a1)
        {
            super(a1);
            p = -1;
            q = -1;
            h = a1.b_();
        }

        b(p.a a1, aB._cls1 _pcls1)
        {
            this(a1);
        }

        private b(boolean flag)
        {
            p = -1;
            q = -1;
            h = com.umeng.message.proguard.P.c();
        }
    }

    public static final class b.a extends p.a
        implements c
    {

        private int a;
        private int b;
        private int c;
        private Object d;
        private int e;
        private Object f;

        static b.a I()
        {
            return L();
        }

        private void K()
        {
            if (!b.D());
        }

        private static b.a L()
        {
            return new b.a();
        }

        public static final k.a k()
        {
            return aB.d();
        }

        public b A()
        {
            return b.h();
        }

        public b B()
        {
            b b1 = C();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public b C()
        {
            int j1 = 1;
            b b1 = new b(this, null);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            b.a(b1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            b.b(b1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            b.a(b1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            b.c(b1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            b.b(b1, f);
            b.d(b1, j1);
            aB();
            return b1;
        }

        public b.a D()
        {
            a = a & -2;
            b = 0;
            aF();
            return this;
        }

        public b.a E()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public b.a F()
        {
            a = a & -5;
            d = b.h().t();
            aF();
            return this;
        }

        public b.a G()
        {
            a = a & -9;
            e = 0;
            aF();
            return this;
        }

        public b.a H()
        {
            a = a & 0xffffffef;
            f = b.h().y();
            aF();
            return this;
        }

        public k.a J()
        {
            return aB.d();
        }

        public y Q()
        {
            return A();
        }

        public x R()
        {
            return A();
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

        public b.a a(int i1)
        {
            a = a | 1;
            b = i1;
            aF();
            return this;
        }

        public b.a a(b b1)
        {
            if (b1 == b.h())
            {
                return this;
            }
            if (b1.o())
            {
                a(b1.p());
            }
            if (b1.q())
            {
                b(b1.r());
            }
            if (b1.s())
            {
                a = a | 4;
                d = b.b(b1);
                aF();
            }
            if (b1.v())
            {
                c(b1.w());
            }
            if (b1.x())
            {
                a = a | 0x10;
                f = b.c(b1);
                aF();
            }
            d(b1.b_());
            return this;
        }

        public b.a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 4;
                d = s1;
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
            return C();
        }

        public x ak()
        {
            return B();
        }

        public y al()
        {
            return C();
        }

        public y am()
        {
            return B();
        }

        public b.a b(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public b.a b(String s1)
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

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public b.a c(int i1)
        {
            a = a | 8;
            e = i1;
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
            return n();
        }

        public a.a d()
        {
            return n();
        }

        public b.a d(x x1)
        {
            if (x1 instanceof b)
            {
                return a((b)x1);
            } else
            {
                super.a(x1);
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

        public b.a e(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 4;
                d = g1;
                aF();
                return this;
            }
        }

        public b.a e(h h1, n n1)
            throws IOException
        {
            h1 = (b)b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (b)n1.a();
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

        public b.a f(g g1)
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

        public b.a f()
        {
            return n();
        }

        public y.a g()
        {
            return n();
        }

        public y.a h()
        {
            return m();
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
            return aB.e().a(com/umeng/message/proguard/aB$a$b, com/umeng/message/proguard/aB$a$b$a);
        }

        public b.a m()
        {
            super.ah();
            b = 0;
            a = a & -2;
            c = 0;
            a = a & -3;
            d = "";
            a = a & -5;
            e = 0;
            a = a & -9;
            f = "";
            a = a & 0xffffffef;
            return this;
        }

        public b.a n()
        {
            return L().a(C());
        }

        public boolean o()
        {
            return (a & 1) == 1;
        }

        public int p()
        {
            return b;
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

        public String t()
        {
            Object obj = d;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                d = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g u()
        {
            Object obj = d;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                d = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean v()
        {
            return (a & 8) == 8;
        }

        public int w()
        {
            return e;
        }

        public boolean x()
        {
            return (a & 0x10) == 16;
        }

        public String y()
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

        public g z()
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

        private b.a()
        {
            d = "";
            f = "";
            K();
        }

        private b.a(p.b b1)
        {
            super(b1);
            d = "";
            f = "";
            K();
        }

        b.a(p.b b1, aB._cls1 _pcls1)
        {
            this(b1);
        }
    }

    public static interface c
        extends A
    {

        public abstract boolean o();

        public abstract int p();

        public abstract boolean q();

        public abstract int r();

        public abstract boolean s();

        public abstract String t();

        public abstract g u();

        public abstract boolean v();

        public abstract int w();

        public abstract boolean x();

        public abstract String y();

        public abstract g z();
    }

    public static final class d extends Enum
        implements C
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 2;
        private static r.b g = new r.b() {

            public d a(int i1)
            {
                return d.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final d h[] = values();
        private static final d k[];
        private final int i;
        private final int j;

        public static d a(int i1)
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

        public static d a(k.e e1)
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
            return (k.d)aB.a.n().k().get(0);
        }

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/umeng/message/proguard/aB$a$d, s1);
        }

        public static d[] values()
        {
            return (d[])k.clone();
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
            a = new d("SUCCESS", 0, 0, 0);
            b = new d("INVALID_REQUEST", 1, 1, 1);
            c = new d("SERVER_EXCEPTION", 2, 2, 2);
            k = (new d[] {
                a, b, c
            });
        }

        private d(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            i = j1;
            j = k1;
        }
    }


    public static B a = new com.umeng.message.proguard.c() {

        public aB.a c(h h1, n n1)
            throws s
        {
            return new aB.a(h1, n1, null);
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
    private static final _cls1.c e;
    private static final long n = 0L;
    private final P f;
    private int g;
    private d h;
    private Object i;
    private b j;
    private byte k;
    private int l;

    private void A()
    {
        h = d.a;
        i = "";
        j = b.h();
    }

    static int a(b.h h1, int i1)
    {
        h1.g = i1;
        return i1;
    }

    public static a a(g g1)
    {
        return w().a(g1);
    }

    static b a(b b1, b b2)
    {
        b1.j = b2;
        return b2;
    }

    static d a(d d1, d d2)
    {
        d1.h = d2;
        return d2;
    }

    public static h a(g g1)
        throws s
    {
        return (h)a.d(g1);
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
        a1.i = obj;
        return obj;
    }

    public static i b(InputStream inputstream)
        throws IOException
    {
        return (i)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.i;
    }

    public static i h()
    {
        return e;
    }

    public static final e n()
    {
        return aB.b();
    }

    public static a w()
    {
        return a.D();
    }

    static boolean z()
    {
        return m;
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public m M()
    {
        return y();
    }

    public y N()
    {
        return x();
    }

    public x O()
    {
        return y();
    }

    public y P()
    {
        return x();
    }

    public y Q()
    {
        return k();
    }

    public x R()
    {
        return k();
    }

    protected a a(k k1)
    {
        return new a(k1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        if ((g & 1) == 1)
        {
            i1.d(1, h.a());
        }
        if ((g & 2) == 2)
        {
            i1.a(2, s());
        }
        if ((g & 4) == 4)
        {
            i1.c(3, j);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = k;
        if (byte0 != -1)
        {
            return byte0 == 1;
        } else
        {
            k = 1;
            return true;
        }
    }

    protected k b(k k1)
    {
        return a(k1);
    }

    public final P b_()
    {
        return f;
    }

    public int d()
    {
        int i1 = l;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((g & 1) == 1)
        {
            j1 = 0 + com.umeng.message.proguard.i.j(1, h.a());
        }
        i1 = j1;
        if ((g & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(2, s());
        }
        j1 = i1;
        if ((g & 4) == 4)
        {
            j1 = i1 + com.umeng.message.proguard.i.g(3, j);
        }
        i1 = j1 + b_().d();
        l = i1;
        return i1;
    }

    public l k()
    {
        return e;
    }

    protected e l()
    {
        return aB.c().(com/umeng/message/proguard/aB$a, com/umeng/message/proguard/aB$a$a);
    }

    public B m()
    {
        return a;
    }

    public boolean o()
    {
        return (g & 1) == 1;
    }

    public d p()
    {
        return h;
    }

    public boolean q()
    {
        return (g & 2) == 2;
    }

    public String r()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            i = s1;
        }
        return s1;
    }

    public g s()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            i = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean t()
    {
        return (g & 4) == 4;
    }

    public b u()
    {
        return j;
    }

    public c v()
    {
        return j;
    }

    public a x()
    {
        return w();
    }

    public a y()
    {
        return a(this);
    }

    static 
    {
        e = new <init>(true);
        e.A();
    }

    private b(h h1, n n1)
        throws s
    {
        b b1;
        boolean flag;
        k = -1;
        l = -1;
        A();
        b1 = com.umeng.message.proguard.P.b();
        flag = false;
_L16:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 4: default 295
    //                   0: 301
    //                   8: 99
    //                   18: 145
    //                   26: 166;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if (!a(h1, b1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        Object obj;
        i1 = h1.n();
        obj = d.a(i1);
        if (obj != null) goto _L9; else goto _L8
_L8:
        b1.(1, i1);
        continue; /* Loop/switch isn't completed */
_L9:
        g = g | 1;
        h = ((d) (obj));
        continue; /* Loop/switch isn't completed */
_L6:
        g = g | 2;
        i = h1.l();
        continue; /* Loop/switch isn't completed */
_L7:
        if ((g & 4) != 4) goto _L11; else goto _L10
_L10:
        obj = j.C();
_L14:
        j = (b)h1.a(b.a, n1);
        if (obj == null) goto _L13; else goto _L12
_L12:
        ((b.a) (obj)).a(j);
        j = ((b.a) (obj)).C();
_L13:
        g = g | 4;
        continue; /* Loop/switch isn't completed */
_L2:
        f = b1.();
        ad();
        return;
        h1;
        throw h1.a(this);
        h1;
        f = b1.();
        ad();
        throw h1;
        h1;
        throw (new s(h1.getMessage())).a(this);
_L11:
        obj = null;
          goto _L14
_L4:
        flag = true;
        if (true) goto _L16; else goto _L15
_L15:
    }

    it>(h h1, n n1, it> it>)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        k = -1;
        l = -1;
        f = <init>1._();
    }

    _(_ _p, _ _p1)
    {
        this(_p);
    }

    private <init>(boolean flag)
    {
        k = -1;
        l = -1;
        f = com.umeng.message.proguard.P.c();
    }
}
