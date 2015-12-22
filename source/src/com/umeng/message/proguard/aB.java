// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            m, p, s, P, 
//            h, B, i, g, 
//            n, y, x, c, 
//            L, C, A

public final class aB
{
    public static final class a extends p
        implements b
    {

        public static B a = new com.umeng.message.proguard.c() {

            public a c(h h, n n)
                throws s
            {
                return new a(h, n);
            }

            public Object d(h h, n n)
                throws s
            {
                return c(h, n);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        private static final a e;
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

        static int a(a a1, int i1)
        {
            a1.g = i1;
            return i1;
        }

        public static a a(a a1)
        {
            return w().a(a1);
        }

        static b a(a a1, b b1)
        {
            a1.j = b1;
            return b1;
        }

        static d a(a a1, d d1)
        {
            a1.h = d1;
            return d1;
        }

        public static a a(g g1)
            throws s
        {
            return (a)a.d(g1);
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

        public static a b(InputStream inputstream)
            throws IOException
        {
            return (a)a.f(inputstream);
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

        public static a h()
        {
            return e;
        }

        public static final k.a n()
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

        public x.a M()
        {
            return y();
        }

        public x.a N()
        {
            return x();
        }

        public y.a O()
        {
            return y();
        }

        public y.a P()
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

        protected a a(p.b b1)
        {
            return new a(b1);
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

        protected x.a b(p.b b1)
        {
            return a(b1);
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

        public a k()
        {
            return e;
        }

        protected p.g l()
        {
            return aB.c().a(com/umeng/message/proguard/aB$a, com/umeng/message/proguard/aB$a$a);
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
            e = new a(true);
            e.A();
        }

        private a(h h1, n n1)
            throws s
        {
            P.a a1;
            boolean flag;
            k = -1;
            l = -1;
            A();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L16:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 4: default 295
        //                       0: 301
        //                       8: 99
        //                       18: 145
        //                       26: 166;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            if (!a(h1, a1, n1, i1))
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
            a1.a(1, i1);
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
            f = a1.b();
            ad();
            return;
            h1;
            throw h1.a(this);
            h1;
            f = a1.b();
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


        private a(p.a a1)
        {
            super(a1);
            k = -1;
            l = -1;
            f = a1.b_();
        }


        private a(boolean flag)
        {
            k = -1;
            l = -1;
            f = com.umeng.message.proguard.P.c();
        }
    }

    public static final class a.a extends p.a
        implements b
    {

        private int a;
        private a.d b;
        private Object c;
        private a.b d;
        private L e;

        static a.a D()
        {
            return F();
        }

        private void E()
        {
            if (a.z())
            {
                G();
            }
        }

        private static a.a F()
        {
            return new a.a();
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

        public a.a A()
        {
            a = a & -3;
            c = a.h().r();
            aF();
            return this;
        }

        public a.a B()
        {
            if (e == null)
            {
                d = a.b.h();
                aF();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public a.b.a C()
        {
            a = a | 4;
            aF();
            return (a.b.a)G().e();
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

        public a.a a(a.b.a a1)
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

        public a.a a(a.b b1)
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

        public a.a a(a.d d1)
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

        public a.a a(a a1)
        {
            if (a1 == a.h())
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
                c = a.b(a1);
                aF();
            }
            if (a1.t())
            {
                b(a1.u());
            }
            d(a1.b_());
            return this;
        }

        public a.a a(String s1)
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

        public a.a b(a.b b1)
        {
            if (e == null)
            {
                if ((a & 4) == 4 && d != a.b.h())
                {
                    d = a.b.a(d).a(b1).C();
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

        public a.a d(x x1)
        {
            if (x1 instanceof a)
            {
                return a((a)x1);
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

        public a.a e(g g1)
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

        public a.a e(h h1, n n1)
            throws IOException
        {
            h1 = (a)a.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (a)n1.a();
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

        public a.a m()
        {
            super.ah();
            b = a.d.a;
            a = a & -2;
            c = "";
            a = a & -3;
            if (e == null)
            {
                d = a.b.h();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public a.a n()
        {
            return F().a(y());
        }

        public boolean o()
        {
            return (a & 1) == 1;
        }

        public a.d p()
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

        public a.b u()
        {
            if (e == null)
            {
                return d;
            } else
            {
                return (a.b)e.c();
            }
        }

        public a.c v()
        {
            if (e != null)
            {
                return (a.c)e.f();
            } else
            {
                return d;
            }
        }

        public a w()
        {
            return a.h();
        }

        public a x()
        {
            a a1 = y();
            if (!a1.a())
            {
                throw b(a1);
            } else
            {
                return a1;
            }
        }

        public a y()
        {
            int i1 = 1;
            a a1 = new a(this);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            a.a(a1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            a.a(a1, c);
            if ((k1 & 4) == 4)
            {
                i1 = j1 | 4;
            } else
            {
                i1 = j1;
            }
            if (e == null)
            {
                a.a(a1, d);
            } else
            {
                a.a(a1, (a.b)e.d());
            }
            a.a(a1, i1);
            aB();
            return a1;
        }

        public a.a z()
        {
            a = a & -2;
            b = a.d.a;
            aF();
            return this;
        }

        private a.a()
        {
            b = a.d.a;
            c = "";
            d = a.b.h();
            E();
        }

        private a.a(p.b b1)
        {
            super(b1);
            b = a.d.a;
            c = "";
            d = a.b.h();
            E();
        }

    }

    public static final class a.b extends p
        implements a.c
    {

        public static B a = new com.umeng.message.proguard.c() {

            public a.b c(h h, n n)
                throws s
            {
                return new a.b(h, n);
            }

            public Object d(h h, n n)
                throws s
            {
                return c(h, n);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        private static final a.b g;
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

        static int a(a.b b1, int i1)
        {
            b1.j = i1;
            return i1;
        }

        public static a a(a.b b1)
        {
            return A().a(b1);
        }

        public static a.b a(g g1)
            throws s
        {
            return (a.b)a.d(g1);
        }

        public static a.b a(g g1, n n1)
            throws s
        {
            return (a.b)a.d(g1, n1);
        }

        public static a.b a(h h1)
            throws IOException
        {
            return (a.b)a.d(h1);
        }

        public static a.b a(h h1, n n1)
            throws IOException
        {
            return (a.b)a.b(h1, n1);
        }

        public static a.b a(InputStream inputstream)
            throws IOException
        {
            return (a.b)a.h(inputstream);
        }

        public static a.b a(InputStream inputstream, n n1)
            throws IOException
        {
            return (a.b)a.h(inputstream, n1);
        }

        public static a.b a(byte abyte0[])
            throws s
        {
            return (a.b)a.d(abyte0);
        }

        public static a.b a(byte abyte0[], n n1)
            throws s
        {
            return (a.b)a.d(abyte0, n1);
        }

        static Object a(a.b b1, Object obj)
        {
            b1.l = obj;
            return obj;
        }

        static int b(a.b b1, int i1)
        {
            b1.k = i1;
            return i1;
        }

        public static a.b b(InputStream inputstream)
            throws IOException
        {
            return (a.b)a.f(inputstream);
        }

        public static a.b b(InputStream inputstream, n n1)
            throws IOException
        {
            return (a.b)a.f(inputstream, n1);
        }

        static Object b(a.b b1)
        {
            return b1.l;
        }

        static Object b(a.b b1, Object obj)
        {
            b1.o = obj;
            return obj;
        }

        static int c(a.b b1, int i1)
        {
            b1.n = i1;
            return i1;
        }

        static Object c(a.b b1)
        {
            return b1.o;
        }

        static int d(a.b b1, int i1)
        {
            b1.i = i1;
            return i1;
        }

        public static a.b h()
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
            return new a(b1);
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

        public a.b k()
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
            g = new a.b(true);
            g.E();
        }

        private a.b(h h1, n n1)
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


        private a.b(p.a a1)
        {
            super(a1);
            p = -1;
            q = -1;
            h = a1.b_();
        }


        private a.b(boolean flag)
        {
            p = -1;
            q = -1;
            h = com.umeng.message.proguard.P.c();
        }
    }

    public static final class a.b.a extends p.a
        implements a.c
    {

        private int a;
        private int b;
        private int c;
        private Object d;
        private int e;
        private Object f;

        static a.b.a I()
        {
            return L();
        }

        private void K()
        {
            if (!a.b.D());
        }

        private static a.b.a L()
        {
            return new a.b.a();
        }

        public static final k.a k()
        {
            return aB.d();
        }

        public a.b A()
        {
            return a.b.h();
        }

        public a.b B()
        {
            a.b b1 = C();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public a.b C()
        {
            int j1 = 1;
            a.b b1 = new a.b(this);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            a.b.a(b1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            a.b.b(b1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            a.b.a(b1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            a.b.c(b1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            a.b.b(b1, f);
            a.b.d(b1, j1);
            aB();
            return b1;
        }

        public a.b.a D()
        {
            a = a & -2;
            b = 0;
            aF();
            return this;
        }

        public a.b.a E()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public a.b.a F()
        {
            a = a & -5;
            d = a.b.h().t();
            aF();
            return this;
        }

        public a.b.a G()
        {
            a = a & -9;
            e = 0;
            aF();
            return this;
        }

        public a.b.a H()
        {
            a = a & 0xffffffef;
            f = a.b.h().y();
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

        public a.b.a a(int i1)
        {
            a = a | 1;
            b = i1;
            aF();
            return this;
        }

        public a.b.a a(a.b b1)
        {
            if (b1 == a.b.h())
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
                d = a.b.b(b1);
                aF();
            }
            if (b1.v())
            {
                c(b1.w());
            }
            if (b1.x())
            {
                a = a | 0x10;
                f = a.b.c(b1);
                aF();
            }
            d(b1.b_());
            return this;
        }

        public a.b.a a(String s1)
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

        public a.b.a b(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public a.b.a b(String s1)
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

        public a.b.a c(int i1)
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

        public a.b.a d(x x1)
        {
            if (x1 instanceof a.b)
            {
                return a((a.b)x1);
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

        public a.b.a e(g g1)
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

        public a.b.a e(h h1, n n1)
            throws IOException
        {
            h1 = (a.b)a.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (a.b)n1.a();
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

        public a.b.a f(g g1)
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

        public a.b.a m()
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

        public a.b.a n()
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

        private a.b.a()
        {
            d = "";
            f = "";
            K();
        }

        private a.b.a(p.b b1)
        {
            super(b1);
            d = "";
            f = "";
            K();
        }

    }

    public static interface a.c
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

    public static final class a.d extends Enum
        implements C
    {

        public static final a.d a;
        public static final a.d b;
        public static final a.d c;
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 2;
        private static r.b g = new r.b() {

            public a.d a(int i)
            {
                return a.d.a(i);
            }

            public r.a b(int i)
            {
                return a(i);
            }

        };
        private static final a.d h[] = values();
        private static final a.d k[];
        private final int i;
        private final int j;

        public static a.d a(int l)
        {
            switch (l)
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

        public static a.d a(k.e e1)
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
            return (k.d)a.n().k().get(0);
        }

        public static a.d valueOf(String s)
        {
            return (a.d)Enum.valueOf(com/umeng/message/proguard/aB$a$d, s);
        }

        public static a.d[] values()
        {
            return (a.d[])k.clone();
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
            a = new a.d("SUCCESS", 0, 0, 0);
            b = new a.d("INVALID_REQUEST", 1, 1, 1);
            c = new a.d("SERVER_EXCEPTION", 2, 2, 2);
            k = (new a.d[] {
                a, b, c
            });
        }

        private a.d(String s, int l, int i1, int j1)
        {
            super(s, l);
            i = i1;
            j = j1;
        }
    }

    public static interface b
        extends A
    {

        public abstract boolean o();

        public abstract a.d p();

        public abstract boolean q();

        public abstract String r();

        public abstract g s();

        public abstract boolean t();

        public abstract a.b u();

        public abstract a.c v();
    }


    private static k.a a;
    private static p.g b;
    private static k.a c;
    private static p.g d;
    private static k.g e;

    private aB()
    {
    }

    static k.a a(k.a a1)
    {
        a = a1;
        return a1;
    }

    public static k.g a()
    {
        return e;
    }

    static k.g a(k.g g)
    {
        e = g;
        return g;
    }

    static p.g a(p.g g)
    {
        b = g;
        return g;
    }

    public static void a(m m)
    {
    }

    static k.a b()
    {
        return a;
    }

    static k.a b(k.a a1)
    {
        c = a1;
        return a1;
    }

    static p.g b(p.g g)
    {
        d = g;
        return g;
    }

    static p.g c()
    {
        return b;
    }

    static k.a d()
    {
        return c;
    }

    static p.g e()
    {
        return d;
    }

    static 
    {
        k.g.a a1 = new k.g.a() {

            public m a(k.g g)
            {
                aB.a(g);
                aB.a((k.a)aB.a().e().get(0));
                aB.a(new p.g(aB.b(), new String[] {
                    "Code", "Description", "Info"
                }));
                aB.b((k.a)aB.b().j().get(0));
                aB.b(new p.g(aB.d(), new String[] {
                    "LaunchPolicy", "TagPolicy", "DeviceTokens", "TagRemainCount", "Tags"
                }));
                return null;
            }

        };
        k.g.a(new String[] {
            "\n0com/umeng/message/protobuffer/PushResponse.proto\022\035com.umeng.message.protobuffer\"\340\002\n\fPushResponse\022F\n\004code\030\001 \001(\01628.com.umeng.message.protobuffer.PushResponse.responseCode\022\023\n\013description\030\002 \001(\t\022>\n\004info\030\003 \001(\01320.com.umeng.message.protobuffer.PushResponse.Info\032k\n\004Info\022\024\n\flaunchPolicy\030\001 \001(\005\022\021\n\ttagPolicy\030\002 \001(\005\022\024\n\fdeviceTokens\030\003 \001(\t\022\026\n\016tagRemainCount\030\004 \001(\005\022\f\n\004tags\030\005 \001(\t\"F\n\fresponseCode\022\013\n\007SUCCESS\020\000\022\023\n\017INV", "ALID_REQUEST\020\001\022\024\n\020SERVER_EXCEPTION\020\002B0\n\035com.umeng.message.protobufferB\017MessageResponse"
        }, new k.g[0], a1);
    }
}
