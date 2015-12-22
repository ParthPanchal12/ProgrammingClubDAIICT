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
//            m, p, s, P, 
//            h, B, i, y, 
//            g, n, x, c, 
//            D, L, A, C, 
//            u, v, Q

public final class com.umeng.message.proguard.j
{
    public static final class A extends com.umeng.message.proguard.p
        implements B
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public A c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new A(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        private static final A e;
        private static final long n = 0L;
        private final P f;
        private int g;
        private Object h;
        private List i;
        private C j;
        private byte k;
        private int l;

        static int a(A a1, int i1)
        {
            a1.g = i1;
            return i1;
        }

        public static a a(A a1)
        {
            return w().a(a1);
        }

        public static A a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (A)a.d(g1);
        }

        public static A a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (A)a.d(g1, n1);
        }

        public static A a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (A)a.d(h1);
        }

        public static A a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (A)a.b(h1, n1);
        }

        public static A a(InputStream inputstream)
            throws IOException
        {
            return (A)a.h(inputstream);
        }

        public static A a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (A)a.h(inputstream, n1);
        }

        public static A a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (A)a.d(abyte0);
        }

        public static A a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (A)a.d(abyte0, n1);
        }

        static C a(A a1, C c1)
        {
            a1.j = c1;
            return c1;
        }

        static Object a(A a1, Object obj)
        {
            a1.h = obj;
            return obj;
        }

        static List a(A a1, List list)
        {
            a1.i = list;
            return list;
        }

        public static A b(InputStream inputstream)
            throws IOException
        {
            return (A)a.f(inputstream);
        }

        public static A b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (A)a.f(inputstream, n1);
        }

        static Object b(A a1)
        {
            return a1.h;
        }

        static List c(A a1)
        {
            return a1.i;
        }

        public static A h()
        {
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.p();
        }

        public static a w()
        {
            return a.G();
        }

        private void z()
        {
            h = "";
            i = Collections.emptyList();
            j = C.h();
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

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public w a(int i1)
        {
            return (w)i.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            if ((g & 1) == 1)
            {
                i1.a(1, p());
            }
            for (int j1 = 0; j1 < i.size(); j1++)
            {
                i1.c(2, (com.umeng.message.proguard.y)i.get(j1));
            }

            if ((g & 2) == 2)
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
            }
            for (int i1 = 0; i1 < s(); i1++)
            {
                if (!a(i1).a())
                {
                    k = 0;
                    return false;
                }
            }

            if (t() && !u().a())
            {
                k = 0;
                return false;
            } else
            {
                k = 1;
                return true;
            }
        }

        public x b(int i1)
        {
            return (x)i.get(i1);
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
            int j1 = 0;
            int i1 = l;
            if (i1 != -1)
            {
                return i1;
            }
            if ((g & 1) == 1)
            {
                i1 = com.umeng.message.proguard.i.c(1, p()) + 0;
            } else
            {
                i1 = 0;
            }
            while (j1 < i.size()) 
            {
                int k1 = com.umeng.message.proguard.i.g(2, (com.umeng.message.proguard.y)i.get(j1));
                j1++;
                i1 = k1 + i1;
            }
            j1 = i1;
            if ((g & 2) == 2)
            {
                j1 = i1 + com.umeng.message.proguard.i.g(3, j);
            }
            i1 = b_().d() + j1;
            l = i1;
            return i1;
        }

        public A i()
        {
            return e;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.q().a(com/umeng/message/proguard/j$A, com/umeng/message/proguard/j$A$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (g & 1) == 1;
        }

        public String o()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                h = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                h = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public List q()
        {
            return i;
        }

        public List r()
        {
            return i;
        }

        public int s()
        {
            return i.size();
        }

        public boolean t()
        {
            return (g & 2) == 2;
        }

        public C u()
        {
            return j;
        }

        public D v()
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
            e = new A(true);
            e.z();
        }

        private A(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a2;
            int i1;
            int j1;
            j1 = 0;
            super();
            k = -1;
            l = -1;
            z();
            a2 = com.umeng.message.proguard.P.b();
            i1 = 0;
_L17:
            if (j1 != 0) goto _L2; else goto _L1
_L1:
            int k1 = i1;
            int j2 = h1.a();
            j2;
            JVM INSTR lookupswitch 4: default 464
        //                       0: 482
        //                       10: 119
        //                       18: 160
        //                       26: 222;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            k1 = i1;
            C.a a1;
            if (!a(h1, a2, n1, j2))
            {
                k1 = 1;
                j1 = i1;
                i1 = k1;
            } else
            {
                int l1 = i1;
                i1 = j1;
                j1 = l1;
            }
              goto _L8
_L5:
            k1 = i1;
            g = g | 1;
            k1 = i1;
            h = h1.l();
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L8
_L6:
            if ((i1 & 2) == 2)
            {
                break MISSING_BLOCK_LABEL_189;
            }
            k1 = i1;
            i = new ArrayList();
            i1 |= 2;
            i.add(h1.a(w.a, n1));
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L8
_L7:
            k1 = i1;
            if ((g & 2) != 2) goto _L10; else goto _L9
_L9:
            k1 = i1;
            a1 = j.s();
_L16:
            k1 = i1;
            j = (C)h1.a(C.a, n1);
            if (a1 == null) goto _L12; else goto _L11
_L11:
            k1 = i1;
            a1.a(j);
            k1 = i1;
            j = a1.t();
_L12:
            k1 = i1;
            g = g | 2;
            k1 = i1;
            i1 = j1;
            j1 = k1;
            break; /* Loop/switch isn't completed */
            h1;
_L15:
            k1 = i1;
            throw h1.a(this);
            h1;
_L13:
            if ((k1 & 2) == 2)
            {
                i = Collections.unmodifiableList(i);
            }
            f = a2.b();
            ad();
            throw h1;
            h1;
_L14:
            k1 = i1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((i1 & 2) == 2)
            {
                i = Collections.unmodifiableList(i);
            }
            f = a2.b();
            ad();
            return;
            h1;
            k1 = i1;
              goto _L13
            h1;
              goto _L14
            h1;
            if (true) goto _L15; else goto _L10
_L10:
            a1 = null;
            if (true) goto _L16; else goto _L8
_L8:
            int i2 = j1;
            j1 = i1;
            i1 = i2;
              goto _L17
_L4:
            boolean flag = true;
            j1 = i1;
            i1 = ((flag) ? 1 : 0);
              goto _L8
        }


        private A(p.a a1)
        {
            super(a1);
            k = -1;
            l = -1;
            f = a1.b_();
        }


        private A(boolean flag)
        {
            k = -1;
            l = -1;
            f = com.umeng.message.proguard.P.c();
        }
    }

    public static final class A.a extends p.a
        implements B
    {

        private int a;
        private Object b;
        private List c;
        private com.umeng.message.proguard.D d;
        private C e;
        private L f;

        static A.a G()
        {
            return I();
        }

        private void H()
        {
            if (com.umeng.message.proguard.p.m)
            {
                L();
                M();
            }
        }

        private static A.a I()
        {
            return new A.a();
        }

        private void K()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        private com.umeng.message.proguard.D L()
        {
            if (d == null)
            {
                List list = c;
                boolean flag;
                if ((a & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                d = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                c = null;
            }
            return d;
        }

        private L M()
        {
            if (f == null)
            {
                f = new L(e, aE(), aD());
                e = null;
            }
            return f;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.p();
        }

        public A.a A()
        {
            a = a & -2;
            b = A.h().o();
            aF();
            return this;
        }

        public A.a B()
        {
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
                aF();
                return this;
            } else
            {
                d.e();
                return this;
            }
        }

        public w.a C()
        {
            return (w.a)L().b(w.h());
        }

        public List D()
        {
            return L().h();
        }

        public A.a E()
        {
            if (f == null)
            {
                e = C.h();
                aF();
            } else
            {
                f.g();
            }
            a = a & -5;
            return this;
        }

        public C.a F()
        {
            a = a | 4;
            aF();
            return (C.a)M().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.p();
        }

        public com.umeng.message.proguard.y Q()
        {
            return x();
        }

        public com.umeng.message.proguard.x R()
        {
            return x();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public A.a a(int i1, w.a a1)
        {
            if (d == null)
            {
                K();
                c.set(i1, a1.B());
                aF();
                return this;
            } else
            {
                d.a(i1, a1.B());
                return this;
            }
        }

        public A.a a(int i1, w w1)
        {
            if (d == null)
            {
                if (w1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.set(i1, w1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(i1, w1);
                return this;
            }
        }

        public A.a a(A a1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (a1 == A.h())
            {
                return this;
            }
            if (a1.n())
            {
                a = a | 1;
                b = A.b(a1);
                aF();
            }
            if (d != null) goto _L2; else goto _L1
_L1:
            if (!A.c(a1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = A.c(a1);
                    a = a & -3;
                } else
                {
                    K();
                    c.addAll(A.c(a1));
                }
                aF();
            }
_L4:
            if (a1.t())
            {
                b(a1.u());
            }
            d(a1.b_());
            return this;
_L2:
            if (!A.c(a1).isEmpty())
            {
                if (d.d())
                {
                    d.b();
                    d = null;
                    c = A.c(a1);
                    a = a & -3;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = L();
                    }
                    d = d1;
                } else
                {
                    d.a(A.c(a1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public A.a a(C.a a1)
        {
            if (f == null)
            {
                e = a1.s();
                aF();
            } else
            {
                f.a(a1.s());
            }
            a = a | 4;
            return this;
        }

        public A.a a(C c1)
        {
            if (f == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                }
                e = c1;
                aF();
            } else
            {
                f.a(c1);
            }
            a = a | 4;
            return this;
        }

        public A.a a(w.a a1)
        {
            if (d == null)
            {
                K();
                c.add(a1.B());
                aF();
                return this;
            } else
            {
                d.a(a1.B());
                return this;
            }
        }

        public A.a a(w w1)
        {
            if (d == null)
            {
                if (w1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.add(w1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(w1);
                return this;
            }
        }

        public A.a a(Iterable iterable)
        {
            if (d == null)
            {
                K();
                com.umeng.message.proguard.p.a.a(iterable, c);
                aF();
                return this;
            } else
            {
                d.a(iterable);
                return this;
            }
        }

        public A.a a(String s1)
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

        public w a(int i1)
        {
            if (d == null)
            {
                return (w)c.get(i1);
            } else
            {
                return (w)d.a(i1);
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= s()) goto _L2; else goto _L1
_L1:
            if (a(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (t() && !u().a()) goto _L3; else goto _L5
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
            return w();
        }

        public com.umeng.message.proguard.x aj()
        {
            return z();
        }

        public com.umeng.message.proguard.x ak()
        {
            return y();
        }

        public com.umeng.message.proguard.y al()
        {
            return z();
        }

        public com.umeng.message.proguard.y am()
        {
            return y();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public A.a b(int i1, w.a a1)
        {
            if (d == null)
            {
                K();
                c.add(i1, a1.B());
                aF();
                return this;
            } else
            {
                d.b(i1, a1.B());
                return this;
            }
        }

        public A.a b(int i1, w w1)
        {
            if (d == null)
            {
                if (w1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.add(i1, w1);
                    aF();
                    return this;
                }
            } else
            {
                d.b(i1, w1);
                return this;
            }
        }

        public A.a b(C c1)
        {
            if (f == null)
            {
                if ((a & 4) == 4 && e != C.h())
                {
                    e = C.a(e).a(c1).t();
                } else
                {
                    e = c1;
                }
                aF();
            } else
            {
                f.b(c1);
            }
            a = a | 4;
            return this;
        }

        public x b(int i1)
        {
            if (d == null)
            {
                return (x)c.get(i1);
            } else
            {
                return (x)d.c(i1);
            }
        }

        public A.a c(int i1)
        {
            if (d == null)
            {
                K();
                c.remove(i1);
                aF();
                return this;
            } else
            {
                d.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return w();
        }

        public a.a d()
        {
            return w();
        }

        public A.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof A)
            {
                return a((A)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public w.a d(int i1)
        {
            return (w.a)L().b(i1);
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public A.a e(com.umeng.message.proguard.g g1)
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

        public A.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (A)A.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (A)n1.a();
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

        public w.a e(int i1)
        {
            return (w.a)L().c(i1, w.h());
        }

        public b.a f()
        {
            return w();
        }

        public y.a g()
        {
            return w();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return w();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.q().a(com/umeng/message/proguard/j$A, com/umeng/message/proguard/j$A$a);
        }

        public A.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
            } else
            {
                d.e();
            }
            if (f == null)
            {
                e = C.h();
            } else
            {
                f.g();
            }
            a = a & -5;
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public List q()
        {
            if (d == null)
            {
                return Collections.unmodifiableList(c);
            } else
            {
                return d.g();
            }
        }

        public List r()
        {
            if (d != null)
            {
                return d.i();
            } else
            {
                return Collections.unmodifiableList(c);
            }
        }

        public int s()
        {
            if (d == null)
            {
                return c.size();
            } else
            {
                return d.c();
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public C u()
        {
            if (f == null)
            {
                return e;
            } else
            {
                return (C)f.c();
            }
        }

        public D v()
        {
            if (f != null)
            {
                return (D)f.f();
            } else
            {
                return e;
            }
        }

        public A.a w()
        {
            return I().a(z());
        }

        public A x()
        {
            return A.h();
        }

        public A y()
        {
            A a1 = z();
            if (!a1.a())
            {
                throw b(a1);
            } else
            {
                return a1;
            }
        }

        public A z()
        {
            int i1 = 1;
            A a1 = new A(this);
            int j1 = a;
            if ((j1 & 1) != 1)
            {
                i1 = 0;
            }
            A.a(a1, b);
            if (d == null)
            {
                if ((a & 2) == 2)
                {
                    c = Collections.unmodifiableList(c);
                    a = a & -3;
                }
                A.a(a1, c);
            } else
            {
                A.a(a1, d.f());
            }
            if ((j1 & 4) == 4)
            {
                i1 |= 2;
            }
            if (f == null)
            {
                A.a(a1, e);
            } else
            {
                A.a(a1, (C)f.d());
            }
            A.a(a1, i1);
            aB();
            return a1;
        }

        private A.a()
        {
            b = "";
            c = Collections.emptyList();
            e = C.h();
            H();
        }

        private A.a(p.b b1)
        {
            super(b1);
            b = "";
            c = Collections.emptyList();
            e = C.h();
            H();
        }

    }

    public static interface B
        extends com.umeng.message.proguard.A
    {

        public abstract w a(int i1);

        public abstract x b(int i1);

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract List q();

        public abstract List r();

        public abstract int s();

        public abstract boolean t();

        public abstract C u();

        public abstract D v();
    }

    public static final class C extends p.d
        implements D
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public C c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new C(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 999;
        private static final C c;
        private static final long h = 0L;
        private final P d;
        private List e;
        private byte f;
        private int g;

        public static a a(C c1)
        {
            return q().a(c1);
        }

        public static C a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (C)a.d(g1);
        }

        public static C a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (C)a.d(g1, n1);
        }

        public static C a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (C)a.d(h1);
        }

        public static C a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (C)a.b(h1, n1);
        }

        public static C a(InputStream inputstream)
            throws IOException
        {
            return (C)a.h(inputstream);
        }

        public static C a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (C)a.h(inputstream, n1);
        }

        public static C a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (C)a.d(abyte0);
        }

        public static C a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (C)a.d(abyte0, n1);
        }

        static List a(C c1, List list)
        {
            c1.e = list;
            return list;
        }

        public static C b(InputStream inputstream)
            throws IOException
        {
            return (C)a.f(inputstream);
        }

        public static C b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (C)a.f(inputstream, n1);
        }

        static List b(C c1)
        {
            return c1.e;
        }

        public static C h()
        {
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.D();
        }

        public static a q()
        {
            return a.x();
        }

        private void t()
        {
            e = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return s();
        }

        public x.a N()
        {
            return r();
        }

        public y.a O()
        {
            return s();
        }

        public y.a P()
        {
            return r();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public G a(int i1)
        {
            return (G)e.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
            for (int j1 = 0; j1 < e.size(); j1++)
            {
                i1.c(999, (com.umeng.message.proguard.y)e.get(j1));
            }

            a1.a(0x20000000, i1);
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = f;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    f = 0;
                    return false;
                }
            }

            if (!W())
            {
                f = 0;
                return false;
            } else
            {
                f = 1;
                return true;
            }
        }

        public H b(int i1)
        {
            return (H)e.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return d;
        }

        public int d()
        {
            int i1 = g;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            int j1 = 0;
            for (; i1 < e.size(); i1++)
            {
                j1 += com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)e.get(i1));
            }

            i1 = Z() + j1 + b_().d();
            g = i1;
            return i1;
        }

        public C i()
        {
            return c;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.E().a(com/umeng/message/proguard/j$C, com/umeng/message/proguard/j$C$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return e;
        }

        public List o()
        {
            return e;
        }

        public int p()
        {
            return e.size();
        }

        public a r()
        {
            return q();
        }

        public a s()
        {
            return a(this);
        }

        static 
        {
            c = new C(true);
            c.t();
        }

        private C(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            boolean flag2;
            flag2 = false;
            super();
            f = -1;
            g = -1;
            t();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L9:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 2: default 286
        //                       0: 289
        //                       7994: 110;
               goto _L3 _L4 _L5
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!a(h1, a1, n1, i1))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L7; else goto _L6
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            e = new ArrayList();
            i1 = flag | true;
_L7:
            flag3 = i1;
            flag1 = i1;
            flag4 = i1;
            e.add(h1.a(G.a, n1));
            flag = i1;
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag3;
            throw h1.a(this);
            h1;
            if ((flag1 & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            throw h1;
            h1;
            flag1 = flag4;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((flag & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            return;
_L4:
            flag2 = true;
            if (true) goto _L9; else goto _L8
_L8:
        }


        private C(p.c c1)
        {
            super(c1);
            f = -1;
            g = -1;
            d = c1.b_();
        }


        private C(boolean flag)
        {
            f = -1;
            g = -1;
            d = com.umeng.message.proguard.P.c();
        }
    }

    public static final class C.a extends p.c
        implements D
    {

        private int a;
        private List b;
        private com.umeng.message.proguard.D c;

        private void C()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private com.umeng.message.proguard.D D()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.D();
        }

        static C.a x()
        {
            return z();
        }

        private void y()
        {
            if (com.umeng.message.proguard.p.m)
            {
                D();
            }
        }

        private static C.a z()
        {
            return new C.a();
        }

        public p.c A()
        {
            return q();
        }

        public p.c B()
        {
            return m();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.D();
        }

        public com.umeng.message.proguard.y Q()
        {
            return r();
        }

        public com.umeng.message.proguard.x R()
        {
            return r();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public C.a a(int i1, G.a a1)
        {
            if (c == null)
            {
                C();
                b.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.G());
                return this;
            }
        }

        public C.a a(int i1, G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, g1);
                return this;
            }
        }

        public C.a a(C c1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (c1 == C.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!C.b(c1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = C.b(c1);
                    a = a & -2;
                } else
                {
                    C();
                    b.addAll(C.b(c1));
                }
                aF();
            }
_L4:
            a(((p.d) (c1)));
            d(c1.b_());
            return this;
_L2:
            if (!C.b(c1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = C.b(c1);
                    a = a & -2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = D();
                    }
                    c = d1;
                } else
                {
                    c.a(C.b(c1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public C.a a(G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(a1.G());
                aF();
                return this;
            } else
            {
                c.a(a1.G());
                return this;
            }
        }

        public C.a a(G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(g1);
                return this;
            }
        }

        public C.a a(Iterable iterable)
        {
            if (c == null)
            {
                C();
                com.umeng.message.proguard.p.c.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public G a(int i1)
        {
            if (c == null)
            {
                return (G)b.get(i1);
            } else
            {
                return (G)c.a(i1);
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= p()) goto _L2; else goto _L1
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
            return q();
        }

        public com.umeng.message.proguard.x aj()
        {
            return t();
        }

        public com.umeng.message.proguard.x ak()
        {
            return s();
        }

        public com.umeng.message.proguard.y al()
        {
            return t();
        }

        public com.umeng.message.proguard.y am()
        {
            return s();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public C.a b(int i1, G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.G());
                return this;
            }
        }

        public C.a b(int i1, G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, g1);
                return this;
            }
        }

        public H b(int i1)
        {
            if (c == null)
            {
                return (H)b.get(i1);
            } else
            {
                return (H)c.c(i1);
            }
        }

        public C.a c(int i1)
        {
            if (c == null)
            {
                C();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public C.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof C)
            {
                return a((C)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public G.a d(int i1)
        {
            return (G.a)D().b(i1);
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public C.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (C)C.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (C)n1.a();
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

        public G.a e(int i1)
        {
            return (G.a)D().c(i1, G.h());
        }

        public b.a f()
        {
            return q();
        }

        public y.a g()
        {
            return q();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return q();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.E().a(com/umeng/message/proguard/j$C, com/umeng/message/proguard/j$C$a);
        }

        public C.a m()
        {
            super.B();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public C.a q()
        {
            return z().a(t());
        }

        public C r()
        {
            return C.h();
        }

        public C s()
        {
            C c1 = t();
            if (!c1.a())
            {
                throw b(c1);
            } else
            {
                return c1;
            }
        }

        public C t()
        {
            C c1 = new C(this);
            int i1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                C.a(c1, b);
            } else
            {
                C.a(c1, c.f());
            }
            aB();
            return c1;
        }

        public C.a u()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public G.a v()
        {
            return (G.a)D().b(G.h());
        }

        public List w()
        {
            return D().h();
        }

        private C.a()
        {
            b = Collections.emptyList();
            y();
        }

        private C.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

    }

    public static interface D
        extends p.e
    {

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract List n();

        public abstract List o();

        public abstract int p();
    }

    public static final class E extends com.umeng.message.proguard.p
        implements F
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public E c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new E(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        private static final E c;
        private static final long h = 0L;
        private final P d;
        private List e;
        private byte f;
        private int g;

        public static a a(E e1)
        {
            return q().a(e1);
        }

        public static E a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (E)a.d(g1);
        }

        public static E a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (E)a.d(g1, n1);
        }

        public static E a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (E)a.d(h1);
        }

        public static E a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (E)a.b(h1, n1);
        }

        public static E a(InputStream inputstream)
            throws IOException
        {
            return (E)a.h(inputstream);
        }

        public static E a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (E)a.h(inputstream, n1);
        }

        public static E a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (E)a.d(abyte0);
        }

        public static E a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (E)a.d(abyte0, n1);
        }

        static List a(E e1, List list)
        {
            e1.e = list;
            return list;
        }

        public static E b(InputStream inputstream)
            throws IOException
        {
            return (E)a.f(inputstream);
        }

        public static E b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (E)a.f(inputstream, n1);
        }

        static List b(E e1)
        {
            return e1.e;
        }

        public static E h()
        {
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.L();
        }

        public static a q()
        {
            return a.x();
        }

        private void t()
        {
            e = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return s();
        }

        public x.a N()
        {
            return r();
        }

        public y.a O()
        {
            return s();
        }

        public y.a P()
        {
            return r();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public b a(int i1)
        {
            return (b)e.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            for (int j1 = 0; j1 < e.size(); j1++)
            {
                i1.c(1, (com.umeng.message.proguard.y)e.get(j1));
            }

            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = f;
            if (byte0 != -1)
            {
                return byte0 == 1;
            } else
            {
                f = 1;
                return true;
            }
        }

        public c b(int i1)
        {
            return (c)e.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return d;
        }

        public int d()
        {
            int i1 = g;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            int j1 = 0;
            for (; i1 < e.size(); i1++)
            {
                j1 += com.umeng.message.proguard.i.g(1, (com.umeng.message.proguard.y)e.get(i1));
            }

            i1 = b_().d() + j1;
            g = i1;
            return i1;
        }

        public E i()
        {
            return c;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.M().a(com/umeng/message/proguard/j$E, com/umeng/message/proguard/j$E$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return e;
        }

        public List o()
        {
            return e;
        }

        public int p()
        {
            return e.size();
        }

        public a r()
        {
            return q();
        }

        public a s()
        {
            return a(this);
        }

        static 
        {
            c = new E(true);
            c.t();
        }

        private E(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            boolean flag2;
            flag2 = false;
            super();
            f = -1;
            g = -1;
            t();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L9:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 2: default 286
        //                       0: 289
        //                       10: 110;
               goto _L3 _L4 _L5
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!a(h1, a1, n1, i1))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L7; else goto _L6
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            e = new ArrayList();
            i1 = flag | true;
_L7:
            flag3 = i1;
            flag1 = i1;
            flag4 = i1;
            e.add(h1.a(b.a, n1));
            flag = i1;
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag3;
            throw h1.a(this);
            h1;
            if ((flag1 & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            throw h1;
            h1;
            flag1 = flag4;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((flag & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            return;
_L4:
            flag2 = true;
            if (true) goto _L9; else goto _L8
_L8:
        }


        private E(p.a a1)
        {
            super(a1);
            f = -1;
            g = -1;
            d = a1.b_();
        }


        private E(boolean flag)
        {
            f = -1;
            g = -1;
            d = com.umeng.message.proguard.P.c();
        }
    }

    public static final class E.a extends p.a
        implements F
    {

        private int a;
        private List b;
        private com.umeng.message.proguard.D c;

        private void A()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private com.umeng.message.proguard.D B()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.L();
        }

        static E.a x()
        {
            return z();
        }

        private void y()
        {
            if (com.umeng.message.proguard.p.m)
            {
                B();
            }
        }

        private static E.a z()
        {
            return new E.a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.L();
        }

        public com.umeng.message.proguard.y Q()
        {
            return r();
        }

        public com.umeng.message.proguard.x R()
        {
            return r();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public E.a a(int i1, E.b.a a1)
        {
            if (c == null)
            {
                A();
                b.set(i1, a1.z());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.z());
                return this;
            }
        }

        public E.a a(int i1, E.b b1)
        {
            if (c == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.set(i1, b1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, b1);
                return this;
            }
        }

        public E.a a(E.b.a a1)
        {
            if (c == null)
            {
                A();
                b.add(a1.z());
                aF();
                return this;
            } else
            {
                c.a(a1.z());
                return this;
            }
        }

        public E.a a(E.b b1)
        {
            if (c == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.add(b1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(b1);
                return this;
            }
        }

        public E.a a(E e1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (e1 == E.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!E.b(e1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = E.b(e1);
                    a = a & -2;
                } else
                {
                    A();
                    b.addAll(E.b(e1));
                }
                aF();
            }
_L4:
            d(e1.b_());
            return this;
_L2:
            if (!E.b(e1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = E.b(e1);
                    a = a & -2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = B();
                    }
                    c = d1;
                } else
                {
                    c.a(E.b(e1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public E.a a(Iterable iterable)
        {
            if (c == null)
            {
                A();
                com.umeng.message.proguard.p.a.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public E.b a(int i1)
        {
            if (c == null)
            {
                return (E.b)b.get(i1);
            } else
            {
                return (E.b)c.a(i1);
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
            return q();
        }

        public com.umeng.message.proguard.x aj()
        {
            return t();
        }

        public com.umeng.message.proguard.x ak()
        {
            return s();
        }

        public com.umeng.message.proguard.y al()
        {
            return t();
        }

        public com.umeng.message.proguard.y am()
        {
            return s();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public E.a b(int i1, E.b.a a1)
        {
            if (c == null)
            {
                A();
                b.add(i1, a1.z());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.z());
                return this;
            }
        }

        public E.a b(int i1, E.b b1)
        {
            if (c == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.add(i1, b1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, b1);
                return this;
            }
        }

        public E.c b(int i1)
        {
            if (c == null)
            {
                return (E.c)b.get(i1);
            } else
            {
                return (E.c)c.c(i1);
            }
        }

        public E.a c(int i1)
        {
            if (c == null)
            {
                A();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public E.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof E)
            {
                return a((E)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public E.b.a d(int i1)
        {
            return (E.b.a)B().b(i1);
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public E.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (E)E.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (E)n1.a();
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

        public E.b.a e(int i1)
        {
            return (E.b.a)B().c(i1, E.b.h());
        }

        public b.a f()
        {
            return q();
        }

        public y.a g()
        {
            return q();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return q();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.M().a(com/umeng/message/proguard/j$E, com/umeng/message/proguard/j$E$a);
        }

        public E.a m()
        {
            super.ah();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public E.a q()
        {
            return z().a(t());
        }

        public E r()
        {
            return E.h();
        }

        public E s()
        {
            E e1 = t();
            if (!e1.a())
            {
                throw b(e1);
            } else
            {
                return e1;
            }
        }

        public E t()
        {
            E e1 = new E(this);
            int i1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                E.a(e1, b);
            } else
            {
                E.a(e1, c.f());
            }
            aB();
            return e1;
        }

        public E.a u()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public E.b.a v()
        {
            return (E.b.a)B().b(E.b.h());
        }

        public List w()
        {
            return B().h();
        }

        private E.a()
        {
            b = Collections.emptyList();
            y();
        }

        private E.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

    }

    public static final class E.b extends com.umeng.message.proguard.p
        implements E.c
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public E.b c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new E.b(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        private static final E.b f;
        private static final long r = 0L;
        private final P g;
        private int h;
        private List i;
        private int j;
        private List k;
        private int l;
        private Object n;
        private Object o;
        private byte p;
        private int q;

        private void A()
        {
            i = Collections.emptyList();
            k = Collections.emptyList();
            n = "";
            o = "";
        }

        static int a(E.b b1, int i1)
        {
            b1.h = i1;
            return i1;
        }

        public static a a(E.b b1)
        {
            return x().a(b1);
        }

        public static E.b a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (E.b)a.d(g1);
        }

        public static E.b a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (E.b)a.d(g1, n1);
        }

        public static E.b a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (E.b)a.d(h1);
        }

        public static E.b a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (E.b)a.b(h1, n1);
        }

        public static E.b a(InputStream inputstream)
            throws IOException
        {
            return (E.b)a.h(inputstream);
        }

        public static E.b a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (E.b)a.h(inputstream, n1);
        }

        public static E.b a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (E.b)a.d(abyte0);
        }

        public static E.b a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (E.b)a.d(abyte0, n1);
        }

        static Object a(E.b b1, Object obj)
        {
            b1.n = obj;
            return obj;
        }

        static List a(E.b b1, List list)
        {
            b1.i = list;
            return list;
        }

        public static E.b b(InputStream inputstream)
            throws IOException
        {
            return (E.b)a.f(inputstream);
        }

        public static E.b b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (E.b)a.f(inputstream, n1);
        }

        static Object b(E.b b1, Object obj)
        {
            b1.o = obj;
            return obj;
        }

        static List b(E.b b1)
        {
            return b1.i;
        }

        static List b(E.b b1, List list)
        {
            b1.k = list;
            return list;
        }

        static List c(E.b b1)
        {
            return b1.k;
        }

        static Object d(E.b b1)
        {
            return b1.n;
        }

        static Object e(E.b b1)
        {
            return b1.o;
        }

        public static E.b h()
        {
            return f;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.N();
        }

        public static a x()
        {
            return a.F();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return z();
        }

        public x.a N()
        {
            return y();
        }

        public y.a O()
        {
            return z();
        }

        public y.a P()
        {
            return y();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public int a(int i1)
        {
            return ((Integer)i.get(i1)).intValue();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            boolean flag = false;
            d();
            if (n().size() > 0)
            {
                i1.p(10);
                i1.p(j);
            }
            for (int j1 = 0; j1 < i.size(); j1++)
            {
                i1.b(((Integer)i.get(j1)).intValue());
            }

            int k1 = ((flag) ? 1 : 0);
            if (p().size() > 0)
            {
                i1.p(18);
                i1.p(l);
                k1 = ((flag) ? 1 : 0);
            }
            for (; k1 < k.size(); k1++)
            {
                i1.b(((Integer)k.get(k1)).intValue());
            }

            if ((h & 1) == 1)
            {
                i1.a(3, t());
            }
            if ((h & 2) == 2)
            {
                i1.a(4, w());
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

        public int b(int i1)
        {
            return ((Integer)k.get(i1)).intValue();
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return g;
        }

        public int d()
        {
            int k1 = 0;
            int i1 = q;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            int j1 = 0;
            for (; i1 < i.size(); i1++)
            {
                j1 += com.umeng.message.proguard.i.h(((Integer)i.get(i1)).intValue());
            }

            i1 = 0 + j1;
            if (!n().isEmpty())
            {
                i1 = i1 + 1 + com.umeng.message.proguard.i.h(j1);
            }
            j = j1;
            int l1;
            for (j1 = 0; k1 < k.size(); j1 = l1 + j1)
            {
                l1 = com.umeng.message.proguard.i.h(((Integer)k.get(k1)).intValue());
                k1++;
            }

            k1 = i1 + j1;
            i1 = k1;
            if (!p().isEmpty())
            {
                i1 = k1 + 1 + com.umeng.message.proguard.i.h(j1);
            }
            l = j1;
            j1 = i1;
            if ((h & 1) == 1)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(3, t());
            }
            i1 = j1;
            if ((h & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.c(4, w());
            }
            i1 += b_().d();
            q = i1;
            return i1;
        }

        public E.b i()
        {
            return f;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.O().a(com/umeng/message/proguard/j$E$b, com/umeng/message/proguard/j$E$b$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return i;
        }

        public int o()
        {
            return i.size();
        }

        public List p()
        {
            return k;
        }

        public int q()
        {
            return k.size();
        }

        public boolean r()
        {
            return (h & 1) == 1;
        }

        public String s()
        {
            Object obj = n;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                n = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g t()
        {
            Object obj = n;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                n = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean u()
        {
            return (h & 2) == 2;
        }

        public String v()
        {
            Object obj = o;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                o = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g w()
        {
            Object obj = o;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                o = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public a y()
        {
            return x();
        }

        public a z()
        {
            return a(this);
        }

        static 
        {
            f = new E.b(true);
            f.A();
        }

        private E.b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            int i1;
            boolean flag;
            flag = false;
            super();
            j = -1;
            l = -1;
            p = -1;
            q = -1;
            A();
            a1 = com.umeng.message.proguard.P.b();
            i1 = 0;
_L21:
            if (flag) goto _L2; else goto _L1
_L1:
            int j1;
            int k1;
            int l1;
            k1 = i1;
            j1 = i1;
            l1 = i1;
            int i2 = h1.a();
            i2;
            JVM INSTR lookupswitch 7: default 862
        //                       0: 865
        //                       8: 158
        //                       10: 299
        //                       16: 482
        //                       18: 559
        //                       26: 721
        //                       34: 766;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            if (!a(h1, a1, n1, i2))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i2 = i1;
            if ((i1 & 1) == 1) goto _L12; else goto _L11
_L11:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            i = new ArrayList();
            i2 = i1 | 1;
_L12:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            i.add(Integer.valueOf(h1.g()));
            i1 = i2;
            continue; /* Loop/switch isn't completed */
            h1;
            j1 = k1;
            throw h1.a(this);
            h1;
            if ((j1 & 1) == 1)
            {
                i = Collections.unmodifiableList(i);
            }
            if ((j1 & 2) == 2)
            {
                k = Collections.unmodifiableList(k);
            }
            g = a1.b();
            ad();
            throw h1;
_L6:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            int j2 = h1.f(h1.s());
            i2 = i1;
            if ((i1 & 1) == 1)
            {
                break MISSING_BLOCK_LABEL_385;
            }
            k1 = i1;
            j1 = i1;
            i2 = i1;
            l1 = i1;
            if (h1.x() <= 0)
            {
                break MISSING_BLOCK_LABEL_385;
            }
            k1 = i1;
            j1 = i1;
            l1 = i1;
            i = new ArrayList();
            i2 = i1 | 1;
_L15:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            if (h1.x() <= 0) goto _L14; else goto _L13
_L13:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            i.add(Integer.valueOf(h1.g()));
              goto _L15
            h1;
            j1 = l1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L14:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            h1.g(j2);
            i1 = i2;
            continue; /* Loop/switch isn't completed */
_L7:
            i2 = i1;
            if ((i1 & 2) == 2) goto _L17; else goto _L16
_L16:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            k = new ArrayList();
            i2 = i1 | 2;
_L17:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            k.add(Integer.valueOf(h1.g()));
            i1 = i2;
            continue; /* Loop/switch isn't completed */
_L8:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            j2 = h1.f(h1.s());
            i2 = i1;
            if ((i1 & 2) == 2)
            {
                break MISSING_BLOCK_LABEL_645;
            }
            k1 = i1;
            j1 = i1;
            l1 = i1;
            i2 = i1;
            if (h1.x() <= 0)
            {
                break MISSING_BLOCK_LABEL_645;
            }
            k1 = i1;
            j1 = i1;
            l1 = i1;
            k = new ArrayList();
            i2 = i1 | 2;
_L19:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            if (h1.x() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k1 = i2;
            j1 = i2;
            l1 = i2;
            k.add(Integer.valueOf(h1.g()));
            if (true) goto _L19; else goto _L18
_L18:
            k1 = i2;
            j1 = i2;
            l1 = i2;
            h1.g(j2);
            i1 = i2;
            continue; /* Loop/switch isn't completed */
_L9:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            h = h | 1;
            k1 = i1;
            j1 = i1;
            l1 = i1;
            n = h1.l();
            continue; /* Loop/switch isn't completed */
_L10:
            k1 = i1;
            j1 = i1;
            l1 = i1;
            h = h | 2;
            k1 = i1;
            j1 = i1;
            l1 = i1;
            o = h1.l();
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i1 & 1) == 1)
            {
                i = Collections.unmodifiableList(i);
            }
            if ((i1 & 2) == 2)
            {
                k = Collections.unmodifiableList(k);
            }
            g = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L21; else goto _L20
_L20:
        }


        private E.b(p.a a1)
        {
            super(a1);
            j = -1;
            l = -1;
            p = -1;
            q = -1;
            g = a1.b_();
        }


        private E.b(boolean flag)
        {
            j = -1;
            l = -1;
            p = -1;
            q = -1;
            g = com.umeng.message.proguard.P.c();
        }
    }

    public static final class E.b.a extends p.a
        implements E.c
    {

        private int a;
        private List b;
        private List c;
        private Object d;
        private Object e;

        static E.b.a F()
        {
            return H();
        }

        private void G()
        {
            if (!com.umeng.message.proguard.p.m);
        }

        private static E.b.a H()
        {
            return new E.b.a();
        }

        private void I()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private void K()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.N();
        }

        public E.b A()
        {
            int i1 = 1;
            E.b b1 = new E.b(this);
            int k1 = a;
            if ((a & 1) == 1)
            {
                b = Collections.unmodifiableList(b);
                a = a & -2;
            }
            E.b.a(b1, b);
            if ((a & 2) == 2)
            {
                c = Collections.unmodifiableList(c);
                a = a & -3;
            }
            E.b.b(b1, c);
            int j1;
            if ((k1 & 4) != 4)
            {
                i1 = 0;
            }
            E.b.a(b1, d);
            j1 = i1;
            if ((k1 & 8) == 8)
            {
                j1 = i1 | 2;
            }
            E.b.b(b1, e);
            E.b.a(b1, j1);
            aB();
            return b1;
        }

        public E.b.a B()
        {
            b = Collections.emptyList();
            a = a & -2;
            aF();
            return this;
        }

        public E.b.a C()
        {
            c = Collections.emptyList();
            a = a & -3;
            aF();
            return this;
        }

        public E.b.a D()
        {
            a = a & -5;
            d = E.b.h().s();
            aF();
            return this;
        }

        public E.b.a E()
        {
            a = a & -9;
            e = E.b.h().v();
            aF();
            return this;
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.N();
        }

        public com.umeng.message.proguard.y Q()
        {
            return y();
        }

        public com.umeng.message.proguard.x R()
        {
            return y();
        }

        public int a(int i1)
        {
            return ((Integer)b.get(i1)).intValue();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public E.b.a a(int i1, int j1)
        {
            I();
            b.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public E.b.a a(E.b b1)
        {
            if (b1 == E.b.h())
            {
                return this;
            }
            if (!E.b.b(b1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = E.b.b(b1);
                    a = a & -2;
                } else
                {
                    I();
                    b.addAll(E.b.b(b1));
                }
                aF();
            }
            if (!E.b.c(b1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = E.b.c(b1);
                    a = a & -3;
                } else
                {
                    K();
                    c.addAll(E.b.c(b1));
                }
                aF();
            }
            if (b1.r())
            {
                a = a | 4;
                d = E.b.d(b1);
                aF();
            }
            if (b1.u())
            {
                a = a | 8;
                e = E.b.e(b1);
                aF();
            }
            d(b1.b_());
            return this;
        }

        public E.b.a a(Iterable iterable)
        {
            I();
            com.umeng.message.proguard.p.a.a(iterable, b);
            aF();
            return this;
        }

        public E.b.a a(String s1)
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
            return x();
        }

        public com.umeng.message.proguard.x aj()
        {
            return A();
        }

        public com.umeng.message.proguard.x ak()
        {
            return z();
        }

        public com.umeng.message.proguard.y al()
        {
            return A();
        }

        public com.umeng.message.proguard.y am()
        {
            return z();
        }

        public int b(int i1)
        {
            return ((Integer)c.get(i1)).intValue();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public E.b.a b(int i1, int j1)
        {
            K();
            c.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public E.b.a b(Iterable iterable)
        {
            K();
            com.umeng.message.proguard.p.a.a(iterable, c);
            aF();
            return this;
        }

        public E.b.a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 8;
                e = s1;
                aF();
                return this;
            }
        }

        public E.b.a c(int i1)
        {
            I();
            b.add(Integer.valueOf(i1));
            aF();
            return this;
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return x();
        }

        public a.a d()
        {
            return x();
        }

        public E.b.a d(int i1)
        {
            K();
            c.add(Integer.valueOf(i1));
            aF();
            return this;
        }

        public E.b.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof E.b)
            {
                return a((E.b)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public E.b.a e(com.umeng.message.proguard.g g1)
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

        public E.b.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (E.b)E.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (E.b)n1.a();
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
            return x();
        }

        public E.b.a f(com.umeng.message.proguard.g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 8;
                e = g1;
                aF();
                return this;
            }
        }

        public y.a g()
        {
            return x();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return x();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.O().a(com/umeng/message/proguard/j$E$b, com/umeng/message/proguard/j$E$b$a);
        }

        public E.b.a m()
        {
            super.ah();
            b = Collections.emptyList();
            a = a & -2;
            c = Collections.emptyList();
            a = a & -3;
            d = "";
            a = a & -5;
            e = "";
            a = a & -9;
            return this;
        }

        public List n()
        {
            return Collections.unmodifiableList(b);
        }

        public int o()
        {
            return b.size();
        }

        public List p()
        {
            return Collections.unmodifiableList(c);
        }

        public int q()
        {
            return c.size();
        }

        public boolean r()
        {
            return (a & 4) == 4;
        }

        public String s()
        {
            Object obj = d;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                d = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g t()
        {
            Object obj = d;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                d = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean u()
        {
            return (a & 8) == 8;
        }

        public String v()
        {
            Object obj = e;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                e = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g w()
        {
            Object obj = e;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                e = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public E.b.a x()
        {
            return H().a(A());
        }

        public E.b y()
        {
            return E.b.h();
        }

        public E.b z()
        {
            E.b b1 = A();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        private E.b.a()
        {
            b = Collections.emptyList();
            c = Collections.emptyList();
            d = "";
            e = "";
            G();
        }

        private E.b.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            c = Collections.emptyList();
            d = "";
            e = "";
            G();
        }

    }

    public static interface E.c
        extends com.umeng.message.proguard.A
    {

        public abstract int a(int i1);

        public abstract int b(int i1);

        public abstract List n();

        public abstract int o();

        public abstract List p();

        public abstract int q();

        public abstract boolean r();

        public abstract String s();

        public abstract com.umeng.message.proguard.g t();

        public abstract boolean u();

        public abstract String v();

        public abstract com.umeng.message.proguard.g w();
    }

    public static interface F
        extends com.umeng.message.proguard.A
    {

        public abstract E.b a(int i1);

        public abstract E.c b(int i1);

        public abstract List n();

        public abstract List o();

        public abstract int p();
    }

    public static final class G extends com.umeng.message.proguard.p
        implements H
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public G c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new G(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        private static final G i;
        private static final long v = 0L;
        private final P j;
        private int k;
        private List l;
        private Object n;
        private long o;
        private long p;
        private double q;
        private com.umeng.message.proguard.g r;
        private Object s;
        private byte t;
        private int u;

        public static a E()
        {
            return a.U();
        }

        private void H()
        {
            l = Collections.emptyList();
            n = "";
            o = 0L;
            p = 0L;
            q = 0.0D;
            r = com.umeng.message.proguard.g.d;
            s = "";
        }

        static double a(G g1, double d1)
        {
            g1.q = d1;
            return d1;
        }

        static int a(G g1, int i1)
        {
            g1.k = i1;
            return i1;
        }

        static long a(G g1, long l1)
        {
            g1.o = l1;
            return l1;
        }

        static com.umeng.message.proguard.g a(G g1, com.umeng.message.proguard.g g2)
        {
            g1.r = g2;
            return g2;
        }

        public static a a(G g1)
        {
            return E().a(g1);
        }

        public static G a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (G)a.d(g1);
        }

        public static G a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (G)a.d(g1, n1);
        }

        public static G a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (G)a.d(h1);
        }

        public static G a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (G)a.b(h1, n1);
        }

        public static G a(InputStream inputstream)
            throws IOException
        {
            return (G)a.h(inputstream);
        }

        public static G a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (G)a.h(inputstream, n1);
        }

        public static G a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (G)a.d(abyte0);
        }

        public static G a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (G)a.d(abyte0, n1);
        }

        static Object a(G g1, Object obj)
        {
            g1.n = obj;
            return obj;
        }

        static List a(G g1, List list)
        {
            g1.l = list;
            return list;
        }

        static long b(G g1, long l1)
        {
            g1.p = l1;
            return l1;
        }

        public static G b(InputStream inputstream)
            throws IOException
        {
            return (G)a.f(inputstream);
        }

        public static G b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (G)a.f(inputstream, n1);
        }

        static Object b(G g1, Object obj)
        {
            g1.s = obj;
            return obj;
        }

        static List b(G g1)
        {
            return g1.l;
        }

        static Object c(G g1)
        {
            return g1.n;
        }

        static Object d(G g1)
        {
            return g1.s;
        }

        public static G h()
        {
            return i;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.H();
        }

        public com.umeng.message.proguard.g A()
        {
            return r;
        }

        public boolean B()
        {
            return (k & 0x20) == 32;
        }

        public String C()
        {
            Object obj = s;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                s = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g D()
        {
            Object obj = s;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                s = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public a F()
        {
            return E();
        }

        public a G()
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
            return G();
        }

        public x.a N()
        {
            return F();
        }

        public y.a O()
        {
            return G();
        }

        public y.a P()
        {
            return F();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public b a(int i1)
        {
            return (b)l.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            for (int j1 = 0; j1 < l.size(); j1++)
            {
                i1.c(2, (com.umeng.message.proguard.y)l.get(j1));
            }

            if ((k & 1) == 1)
            {
                i1.a(3, s());
            }
            if ((k & 2) == 2)
            {
                i1.a(4, o);
            }
            if ((k & 4) == 4)
            {
                i1.b(5, p);
            }
            if ((k & 8) == 8)
            {
                i1.a(6, q);
            }
            if ((k & 0x10) == 16)
            {
                i1.a(7, r);
            }
            if ((k & 0x20) == 32)
            {
                i1.a(8, D());
            }
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = t;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    t = 0;
                    return false;
                }
            }

            t = 1;
            return true;
        }

        public c b(int i1)
        {
            return (c)l.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return j;
        }

        public int d()
        {
            int i1 = u;
            if (i1 != -1)
            {
                return i1;
            }
            int j1 = 0;
            i1 = 0;
            for (; j1 < l.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(2, (com.umeng.message.proguard.y)l.get(j1));
            }

            j1 = i1;
            if ((k & 1) == 1)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(3, s());
            }
            i1 = j1;
            if ((k & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.f(4, o);
            }
            j1 = i1;
            if ((k & 4) == 4)
            {
                j1 = i1 + com.umeng.message.proguard.i.g(5, p);
            }
            i1 = j1;
            if ((k & 8) == 8)
            {
                i1 = j1 + com.umeng.message.proguard.i.b(6, q);
            }
            j1 = i1;
            if ((k & 0x10) == 16)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(7, r);
            }
            i1 = j1;
            if ((k & 0x20) == 32)
            {
                i1 = j1 + com.umeng.message.proguard.i.c(8, D());
            }
            i1 = b_().d() + i1;
            u = i1;
            return i1;
        }

        public G i()
        {
            return i;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.I().a(com/umeng/message/proguard/j$G, com/umeng/message/proguard/j$G$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return l;
        }

        public List o()
        {
            return l;
        }

        public int p()
        {
            return l.size();
        }

        public boolean q()
        {
            return (k & 1) == 1;
        }

        public String r()
        {
            Object obj = n;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                n = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = n;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                n = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean t()
        {
            return (k & 2) == 2;
        }

        public long u()
        {
            return o;
        }

        public boolean v()
        {
            return (k & 4) == 4;
        }

        public long w()
        {
            return p;
        }

        public boolean x()
        {
            return (k & 8) == 8;
        }

        public double y()
        {
            return q;
        }

        public boolean z()
        {
            return (k & 0x10) == 16;
        }

        static 
        {
            i = new G(true);
            i.H();
        }

        private G(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            boolean flag2;
            flag2 = false;
            super();
            t = -1;
            u = -1;
            H();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L15:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 8: default 607
        //                       0: 610
        //                       18: 158
        //                       26: 281
        //                       32: 347
        //                       40: 392
        //                       49: 437
        //                       58: 483
        //                       66: 529;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!a(h1, a1, n1, i1))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L13; else goto _L12
_L12:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            l = new ArrayList();
            i1 = flag | true;
_L13:
            flag3 = i1;
            flag1 = i1;
            flag4 = i1;
            l.add(h1.a(b.a, n1));
            flag = i1;
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag3;
            throw h1.a(this);
            h1;
            if ((flag1 & true))
            {
                l = Collections.unmodifiableList(l);
            }
            j = a1.b();
            ad();
            throw h1;
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            k = k | 1;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            n = h1.l();
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag4;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L7:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            k = k | 2;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            o = h1.e();
            continue; /* Loop/switch isn't completed */
_L8:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            k = k | 4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            p = h1.f();
            continue; /* Loop/switch isn't completed */
_L9:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            k = k | 8;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            q = h1.c();
            continue; /* Loop/switch isn't completed */
_L10:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            k = k | 0x10;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            r = h1.l();
            continue; /* Loop/switch isn't completed */
_L11:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            k = k | 0x20;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            s = h1.l();
            continue; /* Loop/switch isn't completed */
_L2:
            if ((flag & true))
            {
                l = Collections.unmodifiableList(l);
            }
            j = a1.b();
            ad();
            return;
_L4:
            flag2 = true;
            if (true) goto _L15; else goto _L14
_L14:
        }


        private G(p.a a1)
        {
            super(a1);
            t = -1;
            u = -1;
            j = a1.b_();
        }


        private G(boolean flag)
        {
            t = -1;
            u = -1;
            j = com.umeng.message.proguard.P.c();
        }
    }

    public static final class G.a extends p.a
        implements H
    {

        private int a;
        private List b;
        private com.umeng.message.proguard.D c;
        private Object d;
        private long e;
        private long f;
        private double g;
        private com.umeng.message.proguard.g h;
        private Object i;

        static G.a U()
        {
            return W();
        }

        private void V()
        {
            if (com.umeng.message.proguard.p.m)
            {
                Y();
            }
        }

        private static G.a W()
        {
            return new G.a();
        }

        private void X()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private com.umeng.message.proguard.D Y()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.H();
        }

        public com.umeng.message.proguard.g A()
        {
            return h;
        }

        public boolean B()
        {
            return (a & 0x40) == 64;
        }

        public String C()
        {
            Object obj = i;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                i = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g D()
        {
            Object obj = i;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                i = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public G.a E()
        {
            return W().a(H());
        }

        public G F()
        {
            return G.h();
        }

        public G G()
        {
            G g1 = H();
            if (!g1.a())
            {
                throw b(g1);
            } else
            {
                return g1;
            }
        }

        public G H()
        {
            int j1 = 1;
            G g1 = new G(this);
            int k1 = a;
            int i1;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                G.a(g1, b);
            } else
            {
                G.a(g1, c.f());
            }
            if ((k1 & 2) != 2)
            {
                j1 = 0;
            }
            G.a(g1, d);
            i1 = j1;
            if ((k1 & 4) == 4)
            {
                i1 = j1 | 2;
            }
            G.a(g1, e);
            j1 = i1;
            if ((k1 & 8) == 8)
            {
                j1 = i1 | 4;
            }
            G.b(g1, f);
            i1 = j1;
            if ((k1 & 0x10) == 16)
            {
                i1 = j1 | 8;
            }
            G.a(g1, g);
            j1 = i1;
            if ((k1 & 0x20) == 32)
            {
                j1 = i1 | 0x10;
            }
            G.a(g1, h);
            i1 = j1;
            if ((k1 & 0x40) == 64)
            {
                i1 = j1 | 0x20;
            }
            G.b(g1, i);
            G.a(g1, i1);
            aB();
            return g1;
        }

        public G.a I()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.H();
        }

        public G.b.a K()
        {
            return (G.b.a)Y().b(G.b.h());
        }

        public List L()
        {
            return Y().h();
        }

        public G.a M()
        {
            a = a & -3;
            d = G.h().r();
            aF();
            return this;
        }

        public G.a N()
        {
            a = a & -5;
            e = 0L;
            aF();
            return this;
        }

        public G.a O()
        {
            a = a & -9;
            f = 0L;
            aF();
            return this;
        }

        public G.a P()
        {
            a = a & 0xffffffef;
            g = 0.0D;
            aF();
            return this;
        }

        public com.umeng.message.proguard.y Q()
        {
            return F();
        }

        public com.umeng.message.proguard.x R()
        {
            return F();
        }

        public G.a S()
        {
            a = a & 0xffffffdf;
            h = G.h().A();
            aF();
            return this;
        }

        public G.a T()
        {
            a = a & 0xffffffbf;
            i = G.h().C();
            aF();
            return this;
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G.a a(double d1)
        {
            a = a | 0x10;
            g = d1;
            aF();
            return this;
        }

        public G.a a(int i1, G.b.a a1)
        {
            if (c == null)
            {
                X();
                b.set(i1, a1.u());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.u());
                return this;
            }
        }

        public G.a a(int i1, G.b b1)
        {
            if (c == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    X();
                    b.set(i1, b1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, b1);
                return this;
            }
        }

        public G.a a(long l1)
        {
            a = a | 4;
            e = l1;
            aF();
            return this;
        }

        public G.a a(G.b.a a1)
        {
            if (c == null)
            {
                X();
                b.add(a1.u());
                aF();
                return this;
            } else
            {
                c.a(a1.u());
                return this;
            }
        }

        public G.a a(G.b b1)
        {
            if (c == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    X();
                    b.add(b1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(b1);
                return this;
            }
        }

        public G.a a(G g1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (g1 == G.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!G.b(g1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = G.b(g1);
                    a = a & -2;
                } else
                {
                    X();
                    b.addAll(G.b(g1));
                }
                aF();
            }
_L4:
            if (g1.q())
            {
                a = a | 2;
                d = G.c(g1);
                aF();
            }
            if (g1.t())
            {
                a(g1.u());
            }
            if (g1.v())
            {
                b(g1.w());
            }
            if (g1.x())
            {
                a(g1.y());
            }
            if (g1.z())
            {
                f(g1.A());
            }
            if (g1.B())
            {
                a = a | 0x40;
                i = G.d(g1);
                aF();
            }
            d(g1.b_());
            return this;
_L2:
            if (!G.b(g1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = G.b(g1);
                    a = a & -2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = Y();
                    }
                    c = d1;
                } else
                {
                    c.a(G.b(g1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public G.a a(Iterable iterable)
        {
            if (c == null)
            {
                X();
                com.umeng.message.proguard.p.a.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public G.a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 2;
                d = s1;
                aF();
                return this;
            }
        }

        public G.b a(int i1)
        {
            if (c == null)
            {
                return (G.b)b.get(i1);
            } else
            {
                return (G.b)c.a(i1);
            }
        }

        public final boolean a()
        {
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    return false;
                }
            }

            return true;
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return E();
        }

        public com.umeng.message.proguard.x aj()
        {
            return H();
        }

        public com.umeng.message.proguard.x ak()
        {
            return G();
        }

        public com.umeng.message.proguard.y al()
        {
            return H();
        }

        public com.umeng.message.proguard.y am()
        {
            return G();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public G.a b(int i1, G.b.a a1)
        {
            if (c == null)
            {
                X();
                b.add(i1, a1.u());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.u());
                return this;
            }
        }

        public G.a b(int i1, G.b b1)
        {
            if (c == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    X();
                    b.add(i1, b1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, b1);
                return this;
            }
        }

        public G.a b(long l1)
        {
            a = a | 8;
            f = l1;
            aF();
            return this;
        }

        public G.a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x40;
                i = s1;
                aF();
                return this;
            }
        }

        public G.c b(int i1)
        {
            if (c == null)
            {
                return (G.c)b.get(i1);
            } else
            {
                return (G.c)c.c(i1);
            }
        }

        public G.a c(int i1)
        {
            if (c == null)
            {
                X();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return E();
        }

        public a.a d()
        {
            return E();
        }

        public G.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof G)
            {
                return a((G)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public G.b.a d(int i1)
        {
            return (G.b.a)Y().b(i1);
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.a e(com.umeng.message.proguard.g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 2;
                d = g1;
                aF();
                return this;
            }
        }

        public G.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (G)G.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (G)n1.a();
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

        public G.b.a e(int i1)
        {
            return (G.b.a)Y().c(i1, G.b.h());
        }

        public b.a f()
        {
            return E();
        }

        public G.a f(com.umeng.message.proguard.g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x20;
                h = g1;
                aF();
                return this;
            }
        }

        public G.a g(com.umeng.message.proguard.g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x40;
                i = g1;
                aF();
                return this;
            }
        }

        public y.a g()
        {
            return E();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return E();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.I().a(com/umeng/message/proguard/j$G, com/umeng/message/proguard/j$G$a);
        }

        public G.a m()
        {
            super.ah();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
            } else
            {
                c.e();
            }
            d = "";
            a = a & -3;
            e = 0L;
            a = a & -5;
            f = 0L;
            a = a & -9;
            g = 0.0D;
            a = a & 0xffffffef;
            h = com.umeng.message.proguard.g.d;
            a = a & 0xffffffdf;
            i = "";
            a = a & 0xffffffbf;
            return this;
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public String r()
        {
            Object obj = d;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                d = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = d;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                d = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public long u()
        {
            return e;
        }

        public boolean v()
        {
            return (a & 8) == 8;
        }

        public long w()
        {
            return f;
        }

        public boolean x()
        {
            return (a & 0x10) == 16;
        }

        public double y()
        {
            return g;
        }

        public boolean z()
        {
            return (a & 0x20) == 32;
        }

        private G.a()
        {
            b = Collections.emptyList();
            d = "";
            h = com.umeng.message.proguard.g.d;
            i = "";
            V();
        }

        private G.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            d = "";
            h = com.umeng.message.proguard.g.d;
            i = "";
            V();
        }

    }

    public static final class G.b extends com.umeng.message.proguard.p
        implements G.c
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public G.b c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new G.b(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        private static final G.b d;
        private static final long k = 0L;
        private final P e;
        private int f;
        private Object g;
        private boolean h;
        private byte i;
        private int j;

        static int a(G.b b1, int i1)
        {
            b1.f = i1;
            return i1;
        }

        public static a a(G.b b1)
        {
            return s().a(b1);
        }

        public static G.b a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (G.b)a.d(g1);
        }

        public static G.b a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (G.b)a.d(g1, n1);
        }

        public static G.b a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (G.b)a.d(h1);
        }

        public static G.b a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (G.b)a.b(h1, n1);
        }

        public static G.b a(InputStream inputstream)
            throws IOException
        {
            return (G.b)a.h(inputstream);
        }

        public static G.b a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (G.b)a.h(inputstream, n1);
        }

        public static G.b a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (G.b)a.d(abyte0);
        }

        public static G.b a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (G.b)a.d(abyte0, n1);
        }

        static Object a(G.b b1, Object obj)
        {
            b1.g = obj;
            return obj;
        }

        static boolean a(G.b b1, boolean flag)
        {
            b1.h = flag;
            return flag;
        }

        public static G.b b(InputStream inputstream)
            throws IOException
        {
            return (G.b)a.f(inputstream);
        }

        public static G.b b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (G.b)a.f(inputstream, n1);
        }

        static Object b(G.b b1)
        {
            return b1.g;
        }

        public static G.b h()
        {
            return d;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.J();
        }

        public static a s()
        {
            return a.y();
        }

        private void v()
        {
            g = "";
            h = false;
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return u();
        }

        public x.a N()
        {
            return t();
        }

        public y.a O()
        {
            return u();
        }

        public y.a P()
        {
            return t();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            if ((f & 1) == 1)
            {
                i1.a(1, p());
            }
            if ((f & 2) == 2)
            {
                i1.a(2, h);
            }
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = i;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (!n())
            {
                i = 0;
                return false;
            }
            if (!q())
            {
                i = 0;
                return false;
            } else
            {
                i = 1;
                return true;
            }
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return e;
        }

        public int d()
        {
            int i1 = j;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            if ((f & 1) == 1)
            {
                i1 = 0 + com.umeng.message.proguard.i.c(1, p());
            }
            int j1 = i1;
            if ((f & 2) == 2)
            {
                j1 = i1 + com.umeng.message.proguard.i.b(2, h);
            }
            i1 = j1 + b_().d();
            j = i1;
            return i1;
        }

        public G.b i()
        {
            return d;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.K().a(com/umeng/message/proguard/j$G$b, com/umeng/message/proguard/j$G$b$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (f & 1) == 1;
        }

        public String o()
        {
            Object obj = g;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                g = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = g;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                g = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean q()
        {
            return (f & 2) == 2;
        }

        public boolean r()
        {
            return h;
        }

        public a t()
        {
            return s();
        }

        public a u()
        {
            return a(this);
        }

        static 
        {
            d = new G.b(true);
            d.v();
        }

        private G.b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            i = -1;
            j = -1;
            v();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L8:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 3: default 184
        //                       0: 187
        //                       10: 90
        //                       16: 133;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!a(h1, a1, n1, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            f = f | 1;
            g = h1.l();
            continue; /* Loop/switch isn't completed */
            h1;
            throw h1.a(this);
            h1;
            e = a1.b();
            ad();
            throw h1;
_L6:
            f = f | 2;
            h = h1.j();
            continue; /* Loop/switch isn't completed */
            h1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            e = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L8; else goto _L7
_L7:
        }


        private G.b(p.a a1)
        {
            super(a1);
            i = -1;
            j = -1;
            e = a1.b_();
        }


        private G.b(boolean flag)
        {
            i = -1;
            j = -1;
            e = com.umeng.message.proguard.P.c();
        }
    }

    public static final class G.b.a extends p.a
        implements G.c
    {

        private int a;
        private Object b;
        private boolean c;

        private static G.b.a A()
        {
            return new G.b.a();
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.J();
        }

        static G.b.a y()
        {
            return A();
        }

        private void z()
        {
            if (!com.umeng.message.proguard.p.m);
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.J();
        }

        public com.umeng.message.proguard.y Q()
        {
            return t();
        }

        public com.umeng.message.proguard.x R()
        {
            return t();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G.b.a a(G.b b1)
        {
            if (b1 == G.b.h())
            {
                return this;
            }
            if (b1.n())
            {
                a = a | 1;
                b = G.b.b(b1);
                aF();
            }
            if (b1.q())
            {
                a(b1.r());
            }
            d(b1.b_());
            return this;
        }

        public G.b.a a(String s1)
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

        public G.b.a a(boolean flag)
        {
            a = a | 2;
            c = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            while (!n() || !q()) 
            {
                return false;
            }
            return true;
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return s();
        }

        public com.umeng.message.proguard.x aj()
        {
            return v();
        }

        public com.umeng.message.proguard.x ak()
        {
            return u();
        }

        public com.umeng.message.proguard.y al()
        {
            return v();
        }

        public com.umeng.message.proguard.y am()
        {
            return u();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return s();
        }

        public a.a d()
        {
            return s();
        }

        public G.b.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof G.b)
            {
                return a((G.b)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.b.a e(com.umeng.message.proguard.g g1)
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

        public G.b.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (G.b)G.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (G.b)n1.a();
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
            return s();
        }

        public y.a g()
        {
            return s();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return s();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.K().a(com/umeng/message/proguard/j$G$b, com/umeng/message/proguard/j$G$b$a);
        }

        public G.b.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = false;
            a = a & -3;
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public boolean r()
        {
            return c;
        }

        public G.b.a s()
        {
            return A().a(v());
        }

        public G.b t()
        {
            return G.b.h();
        }

        public G.b u()
        {
            G.b b1 = v();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public G.b v()
        {
            int i1 = 1;
            G.b b1 = new G.b(this);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            G.b.a(b1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            G.b.a(b1, c);
            G.b.a(b1, j1);
            aB();
            return b1;
        }

        public G.b.a w()
        {
            a = a & -2;
            b = G.b.h().o();
            aF();
            return this;
        }

        public G.b.a x()
        {
            a = a & -3;
            c = false;
            aF();
            return this;
        }

        private G.b.a()
        {
            b = "";
            z();
        }

        private G.b.a(p.b b1)
        {
            super(b1);
            b = "";
            z();
        }

    }

    public static interface G.c
        extends com.umeng.message.proguard.A
    {

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract boolean q();

        public abstract boolean r();
    }

    public static interface H
        extends com.umeng.message.proguard.A
    {

        public abstract com.umeng.message.proguard.g A();

        public abstract boolean B();

        public abstract String C();

        public abstract com.umeng.message.proguard.g D();

        public abstract G.b a(int i1);

        public abstract G.c b(int i1);

        public abstract List n();

        public abstract List o();

        public abstract int p();

        public abstract boolean q();

        public abstract String r();

        public abstract com.umeng.message.proguard.g s();

        public abstract boolean t();

        public abstract long u();

        public abstract boolean v();

        public abstract long w();

        public abstract boolean x();

        public abstract double y();

        public abstract boolean z();
    }

    public static final class a extends com.umeng.message.proguard.p
        implements b
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new a(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 6;
        public static final int e = 3;
        public static final int f = 4;
        public static final int g = 5;
        public static final int h = 7;
        private static final a i;
        private static final long v = 0L;
        private final P j;
        private int k;
        private Object l;
        private List n;
        private List o;
        private List p;
        private List q;
        private List r;
        private u s;
        private byte t;
        private int u;

        private void S()
        {
            l = "";
            n = Collections.emptyList();
            o = Collections.emptyList();
            p = Collections.emptyList();
            q = Collections.emptyList();
            r = Collections.emptyList();
            s = u.h();
        }

        static int a(a a1, int i1)
        {
            a1.k = i1;
            return i1;
        }

        public static a a(a a1)
        {
            return c_().a(a1);
        }

        public static a a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (a)a.d(g1);
        }

        public static a a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (a)a.d(g1, n1);
        }

        public static a a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (a)a.d(h1);
        }

        public static a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (a)a.b(h1, n1);
        }

        public static a a(InputStream inputstream)
            throws IOException
        {
            return (a)a.h(inputstream);
        }

        public static a a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (a)a.h(inputstream, n1);
        }

        public static a a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (a)a.d(abyte0);
        }

        public static a a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (a)a.d(abyte0, n1);
        }

        static u a(a a1, u u1)
        {
            a1.s = u1;
            return u1;
        }

        static Object a(a a1, Object obj)
        {
            a1.l = obj;
            return obj;
        }

        static List a(a a1, List list)
        {
            a1.n = list;
            return list;
        }

        public static a b(InputStream inputstream)
            throws IOException
        {
            return (a)a.f(inputstream);
        }

        public static a b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (a)a.f(inputstream, n1);
        }

        static Object b(a a1)
        {
            return a1.l;
        }

        static List b(a a1, List list)
        {
            a1.o = list;
            return list;
        }

        static List c(a a1)
        {
            return a1.n;
        }

        static List c(a a1, List list)
        {
            a1.p = list;
            return list;
        }

        public static a c_()
        {
            return a.an();
        }

        static List d(a a1)
        {
            return a1.o;
        }

        static List d(a a1, List list)
        {
            a1.q = list;
            return list;
        }

        static List e(a a1)
        {
            return a1.p;
        }

        static List e(a a1, List list)
        {
            a1.r = list;
            return list;
        }

        static List f(a a1)
        {
            return a1.q;
        }

        static List g(a a1)
        {
            return a1.r;
        }

        public static a h()
        {
            return i;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.f();
        }

        public List A()
        {
            return q;
        }

        public int B()
        {
            return q.size();
        }

        public List C()
        {
            return r;
        }

        public List D()
        {
            return r;
        }

        public int E()
        {
            return r.size();
        }

        public boolean F()
        {
            return (k & 2) == 2;
        }

        public u G()
        {
            return s;
        }

        public v H()
        {
            return s;
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public a K()
        {
            return c_();
        }

        public a L()
        {
            return a(this);
        }

        public x.a M()
        {
            return L();
        }

        public x.a N()
        {
            return K();
        }

        public y.a O()
        {
            return L();
        }

        public y.a P()
        {
            return K();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public k a(int i1)
        {
            return (k)n.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            boolean flag = false;
            d();
            if ((k & 1) == 1)
            {
                i1.a(1, p());
            }
            for (int j1 = 0; j1 < n.size(); j1++)
            {
                i1.c(2, (com.umeng.message.proguard.y)n.get(j1));
            }

            for (int k1 = 0; k1 < p.size(); k1++)
            {
                i1.c(3, (com.umeng.message.proguard.y)p.get(k1));
            }

            for (int l1 = 0; l1 < q.size(); l1++)
            {
                i1.c(4, (com.umeng.message.proguard.y)q.get(l1));
            }

            int i2 = 0;
            int j2;
            do
            {
                j2 = ((flag) ? 1 : 0);
                if (i2 >= r.size())
                {
                    break;
                }
                i1.c(5, (com.umeng.message.proguard.y)r.get(i2));
                i2++;
            } while (true);
            for (; j2 < o.size(); j2++)
            {
                i1.c(6, (com.umeng.message.proguard.y)o.get(j2));
            }

            if ((k & 2) == 2)
            {
                i1.c(7, s);
            }
            b_().a(i1);
        }

        public final boolean a()
        {
            boolean flag = true;
            byte byte0 = t;
            if (byte0 != -1)
            {
                if (byte0 != 1)
                {
                    flag = false;
                }
                return flag;
            }
            for (int i1 = 0; i1 < s(); i1++)
            {
                if (!a(i1).a())
                {
                    t = 0;
                    return false;
                }
            }

            for (int j1 = 0; j1 < v(); j1++)
            {
                if (!c(j1).a())
                {
                    t = 0;
                    return false;
                }
            }

            for (int k1 = 0; k1 < y(); k1++)
            {
                if (!e(k1).a())
                {
                    t = 0;
                    return false;
                }
            }

            for (int l1 = 0; l1 < B(); l1++)
            {
                if (!g(l1).a())
                {
                    t = 0;
                    return false;
                }
            }

            if (F() && !G().a())
            {
                t = 0;
                return false;
            } else
            {
                t = 1;
                return true;
            }
        }

        public l b(int i1)
        {
            return (l)n.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return j;
        }

        public k c(int i1)
        {
            return (k)o.get(i1);
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
            int k1;
            int l1;
            if ((k & 1) == 1)
            {
                i1 = com.umeng.message.proguard.i.c(1, p()) + 0;
            } else
            {
                i1 = 0;
            }
            for (j1 = 0; j1 < n.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(2, (com.umeng.message.proguard.y)n.get(j1));
            }

            for (j1 = 0; j1 < p.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(3, (com.umeng.message.proguard.y)p.get(j1));
            }

            for (j1 = 0; j1 < q.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(4, (com.umeng.message.proguard.y)q.get(j1));
            }

            k1 = 0;
            do
            {
                l1 = ((flag) ? 1 : 0);
                j1 = i1;
                if (k1 >= r.size())
                {
                    break;
                }
                i1 += com.umeng.message.proguard.i.g(5, (com.umeng.message.proguard.y)r.get(k1));
                k1++;
            } while (true);
            for (; l1 < o.size(); l1++)
            {
                j1 += com.umeng.message.proguard.i.g(6, (com.umeng.message.proguard.y)o.get(l1));
            }

            i1 = j1;
            if ((k & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.g(7, s);
            }
            i1 = b_().d() + i1;
            u = i1;
            return i1;
        }

        public l d(int i1)
        {
            return (l)o.get(i1);
        }

        public a e(int i1)
        {
            return (a)p.get(i1);
        }

        public b f(int i1)
        {
            return (b)p.get(i1);
        }

        public c g(int i1)
        {
            return (c)q.get(i1);
        }

        public d h(int i1)
        {
            return (d)q.get(i1);
        }

        public b i(int i1)
        {
            return (b)r.get(i1);
        }

        public a i()
        {
            return i;
        }

        public c j(int i1)
        {
            return (c)r.get(i1);
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.g().a(com/umeng/message/proguard/j$a, com/umeng/message/proguard/j$a$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (k & 1) == 1;
        }

        public String o()
        {
            Object obj = l;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                l = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = l;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                l = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public List q()
        {
            return n;
        }

        public List r()
        {
            return n;
        }

        public int s()
        {
            return n.size();
        }

        public List t()
        {
            return o;
        }

        public List u()
        {
            return o;
        }

        public int v()
        {
            return o.size();
        }

        public List w()
        {
            return p;
        }

        public List x()
        {
            return p;
        }

        public int y()
        {
            return p.size();
        }

        public List z()
        {
            return q;
        }

        static 
        {
            i = new a(true);
            i.S();
        }

        private a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a2;
            int i1;
            int j1;
            t = -1;
            u = -1;
            S();
            i1 = 0;
            a2 = com.umeng.message.proguard.P.b();
            j1 = 0;
_L41:
            if (j1 != 0) goto _L2; else goto _L1
_L1:
            int k1 = i1;
            int j2 = h1.a();
            j2;
            JVM INSTR lookupswitch 8: default 997
        //                       0: 1015
        //                       10: 151
        //                       18: 192
        //                       26: 262
        //                       34: 335
        //                       42: 408
        //                       50: 481
        //                       58: 551;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
            k1 = i1;
            u.a a1;
            int k2;
            if (!a(h1, a2, n1, j2))
            {
                k1 = 1;
                j1 = i1;
                i1 = k1;
            } else
            {
                int l1 = i1;
                i1 = j1;
                j1 = l1;
            }
              goto _L12
_L5:
            k1 = i1;
            k = k | 1;
            k1 = i1;
            l = h1.l();
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L12
_L6:
            if ((i1 & 2) == 2) goto _L14; else goto _L13
_L13:
            k1 = i1;
            n = new ArrayList();
            k2 = i1 | 2;
_L40:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            n.add(h1.a(k.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L7:
            if ((i1 & 8) == 8) goto _L16; else goto _L15
_L15:
            k1 = i1;
            p = new ArrayList();
            k2 = i1 | 8;
_L39:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            p.add(h1.a(a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L8:
            if ((i1 & 0x10) == 16) goto _L18; else goto _L17
_L17:
            k1 = i1;
            q = new ArrayList();
            k2 = i1 | 0x10;
_L37:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            q.add(h1.a(c.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L9:
            if ((i1 & 0x20) == 32) goto _L20; else goto _L19
_L19:
            k1 = i1;
            r = new ArrayList();
            k2 = i1 | 0x20;
_L35:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            r.add(h1.a(b.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L10:
            if ((i1 & 4) == 4) goto _L22; else goto _L21
_L21:
            k1 = i1;
            o = new ArrayList();
            k2 = i1 | 4;
_L33:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            o.add(h1.a(k.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L11:
            k1 = i1;
            if ((k & 2) != 2) goto _L24; else goto _L23
_L23:
            k1 = i1;
            a1 = s.w();
_L31:
            k1 = i1;
            s = (u)h1.a(u.a, n1);
            if (a1 == null) goto _L26; else goto _L25
_L25:
            k1 = i1;
            a1.a(s);
            k1 = i1;
            s = a1.x();
_L26:
            k1 = i1;
            k = k | 2;
            k1 = i1;
            i1 = j1;
            j1 = k1;
            break; /* Loop/switch isn't completed */
            h1;
_L29:
            k1 = i1;
            throw h1.a(this);
            h1;
_L27:
            if ((k1 & 2) == 2)
            {
                n = Collections.unmodifiableList(n);
            }
            if ((k1 & 8) == 8)
            {
                p = Collections.unmodifiableList(p);
            }
            if ((k1 & 0x10) == 16)
            {
                q = Collections.unmodifiableList(q);
            }
            if ((k1 & 0x20) == 32)
            {
                r = Collections.unmodifiableList(r);
            }
            if ((k1 & 4) == 4)
            {
                o = Collections.unmodifiableList(o);
            }
            j = a2.b();
            ad();
            throw h1;
            h1;
_L28:
            k1 = i1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((i1 & 2) == 2)
            {
                n = Collections.unmodifiableList(n);
            }
            if ((i1 & 8) == 8)
            {
                p = Collections.unmodifiableList(p);
            }
            if ((i1 & 0x10) == 16)
            {
                q = Collections.unmodifiableList(q);
            }
            if ((i1 & 0x20) == 32)
            {
                r = Collections.unmodifiableList(r);
            }
            if ((i1 & 4) == 4)
            {
                o = Collections.unmodifiableList(o);
            }
            j = a2.b();
            ad();
            return;
            h1;
            k1 = i1;
              goto _L27
            h1;
            i1 = k1;
              goto _L28
            h1;
            i1 = j2;
            if (true) goto _L29; else goto _L24
_L24:
            a1 = null;
            if (true) goto _L31; else goto _L30
_L30:
            break; /* Loop/switch isn't completed */
_L22:
            k2 = i1;
            if (true) goto _L33; else goto _L32
_L32:
            break; /* Loop/switch isn't completed */
_L20:
            k2 = i1;
            if (true) goto _L35; else goto _L34
_L34:
            break; /* Loop/switch isn't completed */
_L18:
            k2 = i1;
            if (true) goto _L37; else goto _L36
_L36:
            break; /* Loop/switch isn't completed */
_L16:
            k2 = i1;
            if (true) goto _L39; else goto _L38
_L38:
            break; /* Loop/switch isn't completed */
_L14:
            k2 = i1;
            if (true) goto _L40; else goto _L12
_L12:
            int i2 = j1;
            j1 = i1;
            i1 = i2;
              goto _L41
_L4:
            boolean flag = true;
            j1 = i1;
            i1 = ((flag) ? 1 : 0);
              goto _L12
        }


        private a(p.a a1)
        {
            super(a1);
            t = -1;
            u = -1;
            j = a1.b_();
        }


        private a(boolean flag)
        {
            t = -1;
            u = -1;
            j = com.umeng.message.proguard.P.c();
        }
    }

    public static final class a.a extends p.a
        implements b
    {

        private int a;
        private Object b;
        private List c;
        private com.umeng.message.proguard.D d;
        private List e;
        private com.umeng.message.proguard.D f;
        private List g;
        private com.umeng.message.proguard.D h;
        private List i;
        private com.umeng.message.proguard.D j;
        private List k;
        private com.umeng.message.proguard.D l;
        private u m;
        private L n;

        private L aG()
        {
            if (n == null)
            {
                n = new L(m, aE(), aD());
                m = null;
            }
            return n;
        }

        static a.a an()
        {
            return ap();
        }

        private void ao()
        {
            if (com.umeng.message.proguard.p.m)
            {
                ar();
                at();
                av();
                ax();
                az();
                aG();
            }
        }

        private static a.a ap()
        {
            return new a.a();
        }

        private void aq()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        private com.umeng.message.proguard.D ar()
        {
            if (d == null)
            {
                List list = c;
                boolean flag;
                if ((a & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                d = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                c = null;
            }
            return d;
        }

        private void as()
        {
            if ((a & 4) != 4)
            {
                e = new ArrayList(e);
                a = a | 4;
            }
        }

        private com.umeng.message.proguard.D at()
        {
            if (f == null)
            {
                List list = e;
                boolean flag;
                if ((a & 4) == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                e = null;
            }
            return f;
        }

        private void au()
        {
            if ((a & 8) != 8)
            {
                g = new ArrayList(g);
                a = a | 8;
            }
        }

        private com.umeng.message.proguard.D av()
        {
            if (h == null)
            {
                List list = g;
                boolean flag;
                if ((a & 8) == 8)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                h = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                g = null;
            }
            return h;
        }

        private void aw()
        {
            if ((a & 0x10) != 16)
            {
                i = new ArrayList(i);
                a = a | 0x10;
            }
        }

        private com.umeng.message.proguard.D ax()
        {
            if (j == null)
            {
                List list = i;
                boolean flag;
                if ((a & 0x10) == 16)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                i = null;
            }
            return j;
        }

        private void ay()
        {
            if ((a & 0x20) != 32)
            {
                k = new ArrayList(k);
                a = a | 0x20;
            }
        }

        private com.umeng.message.proguard.D az()
        {
            if (l == null)
            {
                List list = k;
                boolean flag;
                if ((a & 0x20) == 32)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                l = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                k = null;
            }
            return l;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.f();
        }

        public List A()
        {
            if (j != null)
            {
                return j.i();
            } else
            {
                return Collections.unmodifiableList(i);
            }
        }

        public int B()
        {
            if (j == null)
            {
                return i.size();
            } else
            {
                return j.c();
            }
        }

        public List C()
        {
            if (l == null)
            {
                return Collections.unmodifiableList(k);
            } else
            {
                return l.g();
            }
        }

        public List D()
        {
            if (l != null)
            {
                return l.i();
            } else
            {
                return Collections.unmodifiableList(k);
            }
        }

        public int E()
        {
            if (l == null)
            {
                return k.size();
            } else
            {
                return l.c();
            }
        }

        public boolean F()
        {
            return (a & 0x40) == 64;
        }

        public u G()
        {
            if (n == null)
            {
                return m;
            } else
            {
                return (u)n.c();
            }
        }

        public v H()
        {
            if (n != null)
            {
                return (v)n.f();
            } else
            {
                return m;
            }
        }

        public a.a I()
        {
            return ap().a(M());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.f();
        }

        public a K()
        {
            return a.h();
        }

        public a L()
        {
            a a1 = M();
            if (!a1.a())
            {
                throw b(a1);
            } else
            {
                return a1;
            }
        }

        public a M()
        {
            int i1 = 1;
            a a1 = new a(this);
            int j1 = a;
            if ((j1 & 1) != 1)
            {
                i1 = 0;
            }
            a.a(a1, b);
            if (d == null)
            {
                if ((a & 2) == 2)
                {
                    c = Collections.unmodifiableList(c);
                    a = a & -3;
                }
                a.a(a1, c);
            } else
            {
                a.a(a1, d.f());
            }
            if (f == null)
            {
                if ((a & 4) == 4)
                {
                    e = Collections.unmodifiableList(e);
                    a = a & -5;
                }
                a.b(a1, e);
            } else
            {
                a.b(a1, f.f());
            }
            if (h == null)
            {
                if ((a & 8) == 8)
                {
                    g = Collections.unmodifiableList(g);
                    a = a & -9;
                }
                a.c(a1, g);
            } else
            {
                a.c(a1, h.f());
            }
            if (j == null)
            {
                if ((a & 0x10) == 16)
                {
                    i = Collections.unmodifiableList(i);
                    a = a & 0xffffffef;
                }
                a.d(a1, i);
            } else
            {
                a.d(a1, j.f());
            }
            if (l == null)
            {
                if ((a & 0x20) == 32)
                {
                    k = Collections.unmodifiableList(k);
                    a = a & 0xffffffdf;
                }
                a.e(a1, k);
            } else
            {
                a.e(a1, l.f());
            }
            if ((j1 & 0x40) == 64)
            {
                i1 |= 2;
            }
            if (n == null)
            {
                a.a(a1, m);
            } else
            {
                a.a(a1, (u)n.d());
            }
            a.a(a1, i1);
            aB();
            return a1;
        }

        public a.a N()
        {
            a = a & -2;
            b = a.h().o();
            aF();
            return this;
        }

        public a.a O()
        {
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
                aF();
                return this;
            } else
            {
                d.e();
                return this;
            }
        }

        public k.a P()
        {
            return (k.a)ar().b(k.h());
        }

        public com.umeng.message.proguard.y Q()
        {
            return K();
        }

        public com.umeng.message.proguard.x R()
        {
            return K();
        }

        public List S()
        {
            return ar().h();
        }

        public a.a T()
        {
            if (f == null)
            {
                e = Collections.emptyList();
                a = a & -5;
                aF();
                return this;
            } else
            {
                f.e();
                return this;
            }
        }

        public k.a U()
        {
            return (k.a)at().b(k.h());
        }

        public List V()
        {
            return at().h();
        }

        public a.a W()
        {
            if (h == null)
            {
                g = Collections.emptyList();
                a = a & -9;
                aF();
                return this;
            } else
            {
                h.e();
                return this;
            }
        }

        public a.a X()
        {
            return (a.a)av().b(a.h());
        }

        public List Y()
        {
            return av().h();
        }

        public a.a Z()
        {
            if (j == null)
            {
                i = Collections.emptyList();
                a = a & 0xffffffef;
                aF();
                return this;
            } else
            {
                j.e();
                return this;
            }
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public a.a a(int i1, a.a a1)
        {
            if (h == null)
            {
                au();
                g.set(i1, a1.L());
                aF();
                return this;
            } else
            {
                h.a(i1, a1.L());
                return this;
            }
        }

        public a.a a(int i1, a.b.a a1)
        {
            if (l == null)
            {
                ay();
                k.set(i1, a1.t());
                aF();
                return this;
            } else
            {
                l.a(i1, a1.t());
                return this;
            }
        }

        public a.a a(int i1, a.b b1)
        {
            if (l == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ay();
                    k.set(i1, b1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(i1, b1);
                return this;
            }
        }

        public a.a a(int i1, a a1)
        {
            if (h == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    au();
                    g.set(i1, a1);
                    aF();
                    return this;
                }
            } else
            {
                h.a(i1, a1);
                return this;
            }
        }

        public a.a a(int i1, c.a a1)
        {
            if (j == null)
            {
                aw();
                i.set(i1, a1.y());
                aF();
                return this;
            } else
            {
                j.a(i1, a1.y());
                return this;
            }
        }

        public a.a a(int i1, c c1)
        {
            if (j == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aw();
                    i.set(i1, c1);
                    aF();
                    return this;
                }
            } else
            {
                j.a(i1, c1);
                return this;
            }
        }

        public a.a a(int i1, k.a a1)
        {
            if (d == null)
            {
                aq();
                c.set(i1, a1.L());
                aF();
                return this;
            } else
            {
                d.a(i1, a1.L());
                return this;
            }
        }

        public a.a a(int i1, k k1)
        {
            if (d == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aq();
                    c.set(i1, k1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(i1, k1);
                return this;
            }
        }

        public a.a a(a.a a1)
        {
            if (h == null)
            {
                au();
                g.add(a1.L());
                aF();
                return this;
            } else
            {
                h.a(a1.L());
                return this;
            }
        }

        public a.a a(a.b.a a1)
        {
            if (l == null)
            {
                ay();
                k.add(a1.t());
                aF();
                return this;
            } else
            {
                l.a(a1.t());
                return this;
            }
        }

        public a.a a(a.b b1)
        {
            if (l == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ay();
                    k.add(b1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(b1);
                return this;
            }
        }

        public a.a a(a a1)
        {
            Object obj = null;
            if (a1 == a.h())
            {
                return this;
            }
            if (a1.n())
            {
                a = a | 1;
                b = a.b(a1);
                aF();
            }
            if (d == null)
            {
                if (!a.c(a1).isEmpty())
                {
                    if (c.isEmpty())
                    {
                        c = a.c(a1);
                        a = a & -3;
                    } else
                    {
                        aq();
                        c.addAll(a.c(a1));
                    }
                    aF();
                }
            } else
            if (!a.c(a1).isEmpty())
            {
                if (d.d())
                {
                    d.b();
                    d = null;
                    c = a.c(a1);
                    a = a & -3;
                    com.umeng.message.proguard.D d1;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = ar();
                    } else
                    {
                        d1 = null;
                    }
                    d = d1;
                } else
                {
                    d.a(a.c(a1));
                }
            }
            if (f == null)
            {
                if (!a.d(a1).isEmpty())
                {
                    if (e.isEmpty())
                    {
                        e = a.d(a1);
                        a = a & -5;
                    } else
                    {
                        as();
                        e.addAll(a.d(a1));
                    }
                    aF();
                }
            } else
            if (!a.d(a1).isEmpty())
            {
                if (f.d())
                {
                    f.b();
                    f = null;
                    e = a.d(a1);
                    a = a & -5;
                    com.umeng.message.proguard.D d2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d2 = at();
                    } else
                    {
                        d2 = null;
                    }
                    f = d2;
                } else
                {
                    f.a(a.d(a1));
                }
            }
            if (h == null)
            {
                if (!a.e(a1).isEmpty())
                {
                    if (g.isEmpty())
                    {
                        g = a.e(a1);
                        a = a & -9;
                    } else
                    {
                        au();
                        g.addAll(a.e(a1));
                    }
                    aF();
                }
            } else
            if (!a.e(a1).isEmpty())
            {
                if (h.d())
                {
                    h.b();
                    h = null;
                    g = a.e(a1);
                    a = a & -9;
                    com.umeng.message.proguard.D d3;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d3 = av();
                    } else
                    {
                        d3 = null;
                    }
                    h = d3;
                } else
                {
                    h.a(a.e(a1));
                }
            }
            if (j == null)
            {
                if (!a.f(a1).isEmpty())
                {
                    if (i.isEmpty())
                    {
                        i = a.f(a1);
                        a = a & 0xffffffef;
                    } else
                    {
                        aw();
                        i.addAll(a.f(a1));
                    }
                    aF();
                }
            } else
            if (!a.f(a1).isEmpty())
            {
                if (j.d())
                {
                    j.b();
                    j = null;
                    i = a.f(a1);
                    a = a & 0xffffffef;
                    com.umeng.message.proguard.D d4;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d4 = ax();
                    } else
                    {
                        d4 = null;
                    }
                    j = d4;
                } else
                {
                    j.a(a.f(a1));
                }
            }
            if (l == null)
            {
                if (!a.g(a1).isEmpty())
                {
                    if (k.isEmpty())
                    {
                        k = a.g(a1);
                        a = a & 0xffffffdf;
                    } else
                    {
                        ay();
                        k.addAll(a.g(a1));
                    }
                    aF();
                }
            } else
            if (!a.g(a1).isEmpty())
            {
                if (l.d())
                {
                    l.b();
                    l = null;
                    k = a.g(a1);
                    a = a & 0xffffffdf;
                    com.umeng.message.proguard.D d5 = obj;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d5 = az();
                    }
                    l = d5;
                } else
                {
                    l.a(a.g(a1));
                }
            }
            if (a1.F())
            {
                b(a1.G());
            }
            d(a1.b_());
            return this;
        }

        public a.a a(c.a a1)
        {
            if (j == null)
            {
                aw();
                i.add(a1.y());
                aF();
                return this;
            } else
            {
                j.a(a1.y());
                return this;
            }
        }

        public a.a a(c c1)
        {
            if (j == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aw();
                    i.add(c1);
                    aF();
                    return this;
                }
            } else
            {
                j.a(c1);
                return this;
            }
        }

        public a.a a(k.a a1)
        {
            if (d == null)
            {
                aq();
                c.add(a1.L());
                aF();
                return this;
            } else
            {
                d.a(a1.L());
                return this;
            }
        }

        public a.a a(k k1)
        {
            if (d == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aq();
                    c.add(k1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(k1);
                return this;
            }
        }

        public a.a a(u.a a1)
        {
            if (n == null)
            {
                m = a1.w();
                aF();
            } else
            {
                n.a(a1.w());
            }
            a = a | 0x40;
            return this;
        }

        public a.a a(u u1)
        {
            if (n == null)
            {
                if (u1 == null)
                {
                    throw new NullPointerException();
                }
                m = u1;
                aF();
            } else
            {
                n.a(u1);
            }
            a = a | 0x40;
            return this;
        }

        public a.a a(Iterable iterable)
        {
            if (d == null)
            {
                aq();
                com.umeng.message.proguard.p.a.a(iterable, c);
                aF();
                return this;
            } else
            {
                d.a(iterable);
                return this;
            }
        }

        public a.a a(String s1)
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

        public k a(int i1)
        {
            if (d == null)
            {
                return (k)c.get(i1);
            } else
            {
                return (k)d.a(i1);
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L13:
            if (i1 >= s()) goto _L2; else goto _L1
_L1:
            if (a(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            i1 = 0;
_L6:
            if (i1 >= v())
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (!c(i1).a()) goto _L3; else goto _L5
_L5:
            i1++;
              goto _L6
            i1 = 0;
_L8:
            if (i1 >= y())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            if (!e(i1).a()) goto _L3; else goto _L7
_L7:
            i1++;
              goto _L8
            i1 = 0;
_L10:
            if (i1 >= B())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!g(i1).a()) goto _L3; else goto _L9
_L9:
            i1++;
              goto _L10
            if (F() && !G().a()) goto _L3; else goto _L11
_L11:
            return true;
            if (true) goto _L13; else goto _L12
_L12:
        }

        public c.a aa()
        {
            return (c.a)ax().b(c.h());
        }

        public List ab()
        {
            return ax().h();
        }

        public a.a ac()
        {
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xffffffdf;
                aF();
                return this;
            } else
            {
                l.e();
                return this;
            }
        }

        public a.b.a ad()
        {
            return (a.b.a)az().b(a.b.h());
        }

        public List ae()
        {
            return az().h();
        }

        public a.a af()
        {
            if (n == null)
            {
                m = u.h();
                aF();
            } else
            {
                n.g();
            }
            a = a & 0xffffffbf;
            return this;
        }

        public u.a ag()
        {
            a = a | 0x40;
            aF();
            return (u.a)aG().e();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return I();
        }

        public com.umeng.message.proguard.x aj()
        {
            return M();
        }

        public com.umeng.message.proguard.x ak()
        {
            return L();
        }

        public com.umeng.message.proguard.y al()
        {
            return M();
        }

        public com.umeng.message.proguard.y am()
        {
            return L();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a b(int i1, a.a a1)
        {
            if (h == null)
            {
                au();
                g.add(i1, a1.L());
                aF();
                return this;
            } else
            {
                h.b(i1, a1.L());
                return this;
            }
        }

        public a.a b(int i1, a.b.a a1)
        {
            if (l == null)
            {
                ay();
                k.add(i1, a1.t());
                aF();
                return this;
            } else
            {
                l.b(i1, a1.t());
                return this;
            }
        }

        public a.a b(int i1, a.b b1)
        {
            if (l == null)
            {
                if (b1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ay();
                    k.add(i1, b1);
                    aF();
                    return this;
                }
            } else
            {
                l.b(i1, b1);
                return this;
            }
        }

        public a.a b(int i1, a a1)
        {
            if (h == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    au();
                    g.add(i1, a1);
                    aF();
                    return this;
                }
            } else
            {
                h.b(i1, a1);
                return this;
            }
        }

        public a.a b(int i1, c.a a1)
        {
            if (j == null)
            {
                aw();
                i.add(i1, a1.y());
                aF();
                return this;
            } else
            {
                j.b(i1, a1.y());
                return this;
            }
        }

        public a.a b(int i1, c c1)
        {
            if (j == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aw();
                    i.add(i1, c1);
                    aF();
                    return this;
                }
            } else
            {
                j.b(i1, c1);
                return this;
            }
        }

        public a.a b(int i1, k.a a1)
        {
            if (d == null)
            {
                aq();
                c.add(i1, a1.L());
                aF();
                return this;
            } else
            {
                d.b(i1, a1.L());
                return this;
            }
        }

        public a.a b(int i1, k k1)
        {
            if (d == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aq();
                    c.add(i1, k1);
                    aF();
                    return this;
                }
            } else
            {
                d.b(i1, k1);
                return this;
            }
        }

        public a.a b(a a1)
        {
            if (h == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    au();
                    g.add(a1);
                    aF();
                    return this;
                }
            } else
            {
                h.a(a1);
                return this;
            }
        }

        public a.a b(k.a a1)
        {
            if (f == null)
            {
                as();
                e.add(a1.L());
                aF();
                return this;
            } else
            {
                f.a(a1.L());
                return this;
            }
        }

        public a.a b(k k1)
        {
            if (f == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    as();
                    e.add(k1);
                    aF();
                    return this;
                }
            } else
            {
                f.a(k1);
                return this;
            }
        }

        public a.a b(u u1)
        {
            if (n == null)
            {
                if ((a & 0x40) == 64 && m != u.h())
                {
                    m = u.a(m).a(u1).x();
                } else
                {
                    m = u1;
                }
                aF();
            } else
            {
                n.b(u1);
            }
            a = a | 0x40;
            return this;
        }

        public a.a b(Iterable iterable)
        {
            if (f == null)
            {
                as();
                com.umeng.message.proguard.p.a.a(iterable, e);
                aF();
                return this;
            } else
            {
                f.a(iterable);
                return this;
            }
        }

        public l b(int i1)
        {
            if (d == null)
            {
                return (l)c.get(i1);
            } else
            {
                return (l)d.c(i1);
            }
        }

        public a.a c(int i1, k.a a1)
        {
            if (f == null)
            {
                as();
                e.set(i1, a1.L());
                aF();
                return this;
            } else
            {
                f.a(i1, a1.L());
                return this;
            }
        }

        public a.a c(int i1, k k1)
        {
            if (f == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    as();
                    e.set(i1, k1);
                    aF();
                    return this;
                }
            } else
            {
                f.a(i1, k1);
                return this;
            }
        }

        public a.a c(Iterable iterable)
        {
            if (h == null)
            {
                au();
                com.umeng.message.proguard.p.a.a(iterable, g);
                aF();
                return this;
            } else
            {
                h.a(iterable);
                return this;
            }
        }

        public k c(int i1)
        {
            if (f == null)
            {
                return (k)e.get(i1);
            } else
            {
                return (k)f.a(i1);
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public a.a d(int i1, k.a a1)
        {
            if (f == null)
            {
                as();
                e.add(i1, a1.L());
                aF();
                return this;
            } else
            {
                f.b(i1, a1.L());
                return this;
            }
        }

        public a.a d(int i1, k k1)
        {
            if (f == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    as();
                    e.add(i1, k1);
                    aF();
                    return this;
                }
            } else
            {
                f.b(i1, k1);
                return this;
            }
        }

        public a.a d(com.umeng.message.proguard.x x1)
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

        public a.a d(Iterable iterable)
        {
            if (j == null)
            {
                aw();
                com.umeng.message.proguard.p.a.a(iterable, i);
                aF();
                return this;
            } else
            {
                j.a(iterable);
                return this;
            }
        }

        public l d(int i1)
        {
            if (f == null)
            {
                return (l)e.get(i1);
            } else
            {
                return (l)f.c(i1);
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public a.a e(com.umeng.message.proguard.g g1)
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

        public a.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public a.a e(Iterable iterable)
        {
            if (l == null)
            {
                ay();
                com.umeng.message.proguard.p.a.a(iterable, k);
                aF();
                return this;
            } else
            {
                l.a(iterable);
                return this;
            }
        }

        public a e(int i1)
        {
            if (h == null)
            {
                return (a)g.get(i1);
            } else
            {
                return (a)h.a(i1);
            }
        }

        public b.a f()
        {
            return I();
        }

        public b f(int i1)
        {
            if (h == null)
            {
                return (b)g.get(i1);
            } else
            {
                return (b)h.c(i1);
            }
        }

        public c g(int i1)
        {
            if (j == null)
            {
                return (c)i.get(i1);
            } else
            {
                return (c)j.a(i1);
            }
        }

        public y.a g()
        {
            return I();
        }

        public d h(int i1)
        {
            if (j == null)
            {
                return (d)i.get(i1);
            } else
            {
                return (d)j.c(i1);
            }
        }

        public y.a h()
        {
            return m();
        }

        public a.b i(int i1)
        {
            if (l == null)
            {
                return (a.b)k.get(i1);
            } else
            {
                return (a.b)l.a(i1);
            }
        }

        public x.a i()
        {
            return I();
        }

        public a.c j(int i1)
        {
            if (l == null)
            {
                return (a.c)k.get(i1);
            } else
            {
                return (a.c)l.c(i1);
            }
        }

        public x.a j()
        {
            return m();
        }

        public a.a k(int i1)
        {
            if (d == null)
            {
                aq();
                c.remove(i1);
                aF();
                return this;
            } else
            {
                d.d(i1);
                return this;
            }
        }

        public k.a l(int i1)
        {
            return (k.a)ar().b(i1);
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.g().a(com/umeng/message/proguard/j$a, com/umeng/message/proguard/j$a$a);
        }

        public a.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
            } else
            {
                d.e();
            }
            if (f == null)
            {
                e = Collections.emptyList();
                a = a & -5;
            } else
            {
                f.e();
            }
            if (h == null)
            {
                g = Collections.emptyList();
                a = a & -9;
            } else
            {
                h.e();
            }
            if (j == null)
            {
                i = Collections.emptyList();
                a = a & 0xffffffef;
            } else
            {
                j.e();
            }
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xffffffdf;
            } else
            {
                l.e();
            }
            if (n == null)
            {
                m = u.h();
            } else
            {
                n.g();
            }
            a = a & 0xffffffbf;
            return this;
        }

        public k.a m(int i1)
        {
            return (k.a)ar().c(i1, k.h());
        }

        public a.a n(int i1)
        {
            if (f == null)
            {
                as();
                e.remove(i1);
                aF();
                return this;
            } else
            {
                f.d(i1);
                return this;
            }
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public k.a o(int i1)
        {
            return (k.a)at().b(i1);
        }

        public String o()
        {
            Object obj = b;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public k.a p(int i1)
        {
            return (k.a)at().c(i1, k.h());
        }

        public a.a q(int i1)
        {
            if (h == null)
            {
                au();
                g.remove(i1);
                aF();
                return this;
            } else
            {
                h.d(i1);
                return this;
            }
        }

        public List q()
        {
            if (d == null)
            {
                return Collections.unmodifiableList(c);
            } else
            {
                return d.g();
            }
        }

        public a.a r(int i1)
        {
            return (a.a)av().b(i1);
        }

        public List r()
        {
            if (d != null)
            {
                return d.i();
            } else
            {
                return Collections.unmodifiableList(c);
            }
        }

        public int s()
        {
            if (d == null)
            {
                return c.size();
            } else
            {
                return d.c();
            }
        }

        public a.a s(int i1)
        {
            return (a.a)av().c(i1, a.h());
        }

        public a.a t(int i1)
        {
            if (j == null)
            {
                aw();
                i.remove(i1);
                aF();
                return this;
            } else
            {
                j.d(i1);
                return this;
            }
        }

        public List t()
        {
            if (f == null)
            {
                return Collections.unmodifiableList(e);
            } else
            {
                return f.g();
            }
        }

        public c.a u(int i1)
        {
            return (c.a)ax().b(i1);
        }

        public List u()
        {
            if (f != null)
            {
                return f.i();
            } else
            {
                return Collections.unmodifiableList(e);
            }
        }

        public int v()
        {
            if (f == null)
            {
                return e.size();
            } else
            {
                return f.c();
            }
        }

        public c.a v(int i1)
        {
            return (c.a)ax().c(i1, c.h());
        }

        public a.a w(int i1)
        {
            if (l == null)
            {
                ay();
                k.remove(i1);
                aF();
                return this;
            } else
            {
                l.d(i1);
                return this;
            }
        }

        public List w()
        {
            if (h == null)
            {
                return Collections.unmodifiableList(g);
            } else
            {
                return h.g();
            }
        }

        public a.b.a x(int i1)
        {
            return (a.b.a)az().b(i1);
        }

        public List x()
        {
            if (h != null)
            {
                return h.i();
            } else
            {
                return Collections.unmodifiableList(g);
            }
        }

        public int y()
        {
            if (h == null)
            {
                return g.size();
            } else
            {
                return h.c();
            }
        }

        public a.b.a y(int i1)
        {
            return (a.b.a)az().c(i1, a.b.h());
        }

        public List z()
        {
            if (j == null)
            {
                return Collections.unmodifiableList(i);
            } else
            {
                return j.g();
            }
        }

        private a.a()
        {
            b = "";
            c = Collections.emptyList();
            e = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = u.h();
            ao();
        }

        private a.a(p.b b1)
        {
            super(b1);
            b = "";
            c = Collections.emptyList();
            e = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = u.h();
            ao();
        }

    }

    public static final class a.b extends com.umeng.message.proguard.p
        implements a.c
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public a.b c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new a.b(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        private static final a.b d;
        private static final long k = 0L;
        private final P e;
        private int f;
        private int g;
        private int h;
        private byte i;
        private int j;

        static int a(a.b b1, int i1)
        {
            b1.g = i1;
            return i1;
        }

        public static a a(a.b b1)
        {
            return r().a(b1);
        }

        public static a.b a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (a.b)a.d(g1);
        }

        public static a.b a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (a.b)a.d(g1, n1);
        }

        public static a.b a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (a.b)a.d(h1);
        }

        public static a.b a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (a.b)a.b(h1, n1);
        }

        public static a.b a(InputStream inputstream)
            throws IOException
        {
            return (a.b)a.h(inputstream);
        }

        public static a.b a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (a.b)a.h(inputstream, n1);
        }

        public static a.b a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (a.b)a.d(abyte0);
        }

        public static a.b a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (a.b)a.d(abyte0, n1);
        }

        static int b(a.b b1, int i1)
        {
            b1.h = i1;
            return i1;
        }

        public static a.b b(InputStream inputstream)
            throws IOException
        {
            return (a.b)a.f(inputstream);
        }

        public static a.b b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (a.b)a.f(inputstream, n1);
        }

        static int c(a.b b1, int i1)
        {
            b1.f = i1;
            return i1;
        }

        public static a.b h()
        {
            return d;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.h();
        }

        public static a r()
        {
            return a.x();
        }

        private void u()
        {
            g = 0;
            h = 0;
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return t();
        }

        public x.a N()
        {
            return s();
        }

        public y.a O()
        {
            return t();
        }

        public y.a P()
        {
            return s();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            if ((f & 1) == 1)
            {
                i1.a(1, g);
            }
            if ((f & 2) == 2)
            {
                i1.a(2, h);
            }
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = i;
            if (byte0 != -1)
            {
                return byte0 == 1;
            } else
            {
                i = 1;
                return true;
            }
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return e;
        }

        public int d()
        {
            int i1 = j;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            if ((f & 1) == 1)
            {
                i1 = 0 + com.umeng.message.proguard.i.g(1, g);
            }
            int j1 = i1;
            if ((f & 2) == 2)
            {
                j1 = i1 + com.umeng.message.proguard.i.g(2, h);
            }
            i1 = j1 + b_().d();
            j = i1;
            return i1;
        }

        public a.b i()
        {
            return d;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.i().a(com/umeng/message/proguard/j$a$b, com/umeng/message/proguard/j$a$b$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (f & 1) == 1;
        }

        public int o()
        {
            return g;
        }

        public boolean p()
        {
            return (f & 2) == 2;
        }

        public int q()
        {
            return h;
        }

        public a s()
        {
            return r();
        }

        public a t()
        {
            return a(this);
        }

        static 
        {
            d = new a.b(true);
            d.u();
        }

        private a.b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            i = -1;
            j = -1;
            u();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L8:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 3: default 184
        //                       0: 187
        //                       8: 90
        //                       16: 133;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!a(h1, a1, n1, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            f = f | 1;
            g = h1.g();
            continue; /* Loop/switch isn't completed */
            h1;
            throw h1.a(this);
            h1;
            e = a1.b();
            ad();
            throw h1;
_L6:
            f = f | 2;
            h = h1.g();
            continue; /* Loop/switch isn't completed */
            h1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            e = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L8; else goto _L7
_L7:
        }


        private a.b(p.a a1)
        {
            super(a1);
            i = -1;
            j = -1;
            e = a1.b_();
        }


        private a.b(boolean flag)
        {
            i = -1;
            j = -1;
            e = com.umeng.message.proguard.P.c();
        }
    }

    public static final class a.b.a extends p.a
        implements a.c
    {

        private int a;
        private int b;
        private int c;

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.h();
        }

        static a.b.a x()
        {
            return z();
        }

        private void y()
        {
            if (!com.umeng.message.proguard.p.m);
        }

        private static a.b.a z()
        {
            return new a.b.a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.h();
        }

        public com.umeng.message.proguard.y Q()
        {
            return s();
        }

        public com.umeng.message.proguard.x R()
        {
            return s();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
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
            if (b1.n())
            {
                a(b1.o());
            }
            if (b1.p())
            {
                b(b1.q());
            }
            d(b1.b_());
            return this;
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
            return r();
        }

        public com.umeng.message.proguard.x aj()
        {
            return u();
        }

        public com.umeng.message.proguard.x ak()
        {
            return t();
        }

        public com.umeng.message.proguard.y al()
        {
            return u();
        }

        public com.umeng.message.proguard.y am()
        {
            return t();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.b.a b(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return r();
        }

        public a.a d()
        {
            return r();
        }

        public a.b.a d(com.umeng.message.proguard.x x1)
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

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public a.b.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public b.a f()
        {
            return r();
        }

        public y.a g()
        {
            return r();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return r();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.i().a(com/umeng/message/proguard/j$a$b, com/umeng/message/proguard/j$a$b$a);
        }

        public a.b.a m()
        {
            super.ah();
            b = 0;
            a = a & -2;
            c = 0;
            a = a & -3;
            return this;
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public int o()
        {
            return b;
        }

        public boolean p()
        {
            return (a & 2) == 2;
        }

        public int q()
        {
            return c;
        }

        public a.b.a r()
        {
            return z().a(u());
        }

        public a.b s()
        {
            return a.b.h();
        }

        public a.b t()
        {
            a.b b1 = u();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public a.b u()
        {
            int i1 = 1;
            a.b b1 = new a.b(this);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            a.b.a(b1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            a.b.b(b1, c);
            a.b.c(b1, j1);
            aB();
            return b1;
        }

        public a.b.a v()
        {
            a = a & -2;
            b = 0;
            aF();
            return this;
        }

        public a.b.a w()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        private a.b.a()
        {
            y();
        }

        private a.b.a(p.b b1)
        {
            super(b1);
            y();
        }

    }

    public static interface a.c
        extends com.umeng.message.proguard.A
    {

        public abstract boolean n();

        public abstract int o();

        public abstract boolean p();

        public abstract int q();
    }

    public static interface b
        extends com.umeng.message.proguard.A
    {

        public abstract List A();

        public abstract int B();

        public abstract List C();

        public abstract List D();

        public abstract int E();

        public abstract boolean F();

        public abstract u G();

        public abstract v H();

        public abstract k a(int i1);

        public abstract l b(int i1);

        public abstract k c(int i1);

        public abstract l d(int i1);

        public abstract a e(int i1);

        public abstract b f(int i1);

        public abstract c g(int i1);

        public abstract d h(int i1);

        public abstract a.b i(int i1);

        public abstract a.c j(int i1);

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract List q();

        public abstract List r();

        public abstract int s();

        public abstract List t();

        public abstract List u();

        public abstract int v();

        public abstract List w();

        public abstract List x();

        public abstract int y();

        public abstract List z();
    }

    public static final class c extends com.umeng.message.proguard.p
        implements d
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public c c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new c(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        private static final c e;
        private static final long n = 0L;
        private final P f;
        private int g;
        private Object h;
        private List i;
        private e j;
        private byte k;
        private int l;

        static int a(c c1, int i1)
        {
            c1.g = i1;
            return i1;
        }

        public static a a(c c1)
        {
            return w().a(c1);
        }

        public static c a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (c)a.d(g1);
        }

        public static c a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (c)a.d(g1, n1);
        }

        public static c a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (c)a.d(h1);
        }

        public static c a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (c)a.b(h1, n1);
        }

        public static c a(InputStream inputstream)
            throws IOException
        {
            return (c)a.h(inputstream);
        }

        public static c a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (c)a.h(inputstream, n1);
        }

        public static c a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (c)a.d(abyte0);
        }

        public static c a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (c)a.d(abyte0, n1);
        }

        static e a(c c1, e e1)
        {
            c1.j = e1;
            return e1;
        }

        static Object a(c c1, Object obj)
        {
            c1.h = obj;
            return obj;
        }

        static List a(c c1, List list)
        {
            c1.i = list;
            return list;
        }

        public static c b(InputStream inputstream)
            throws IOException
        {
            return (c)a.f(inputstream);
        }

        public static c b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (c)a.f(inputstream, n1);
        }

        static Object b(c c1)
        {
            return c1.h;
        }

        static List c(c c1)
        {
            return c1.i;
        }

        public static c h()
        {
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.l();
        }

        public static a w()
        {
            return a.G();
        }

        private void z()
        {
            h = "";
            i = Collections.emptyList();
            j = e.h();
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

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public g a(int i1)
        {
            return (g)i.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            if ((g & 1) == 1)
            {
                i1.a(1, p());
            }
            for (int j1 = 0; j1 < i.size(); j1++)
            {
                i1.c(2, (com.umeng.message.proguard.y)i.get(j1));
            }

            if ((g & 2) == 2)
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
            }
            for (int i1 = 0; i1 < s(); i1++)
            {
                if (!a(i1).a())
                {
                    k = 0;
                    return false;
                }
            }

            if (t() && !u().a())
            {
                k = 0;
                return false;
            } else
            {
                k = 1;
                return true;
            }
        }

        public h b(int i1)
        {
            return (h)i.get(i1);
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
            int j1 = 0;
            int i1 = l;
            if (i1 != -1)
            {
                return i1;
            }
            if ((g & 1) == 1)
            {
                i1 = com.umeng.message.proguard.i.c(1, p()) + 0;
            } else
            {
                i1 = 0;
            }
            while (j1 < i.size()) 
            {
                int k1 = com.umeng.message.proguard.i.g(2, (com.umeng.message.proguard.y)i.get(j1));
                j1++;
                i1 = k1 + i1;
            }
            j1 = i1;
            if ((g & 2) == 2)
            {
                j1 = i1 + com.umeng.message.proguard.i.g(3, j);
            }
            i1 = b_().d() + j1;
            l = i1;
            return i1;
        }

        public c i()
        {
            return e;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.m().a(com/umeng/message/proguard/j$c, com/umeng/message/proguard/j$c$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (g & 1) == 1;
        }

        public String o()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                h = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                h = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public List q()
        {
            return i;
        }

        public List r()
        {
            return i;
        }

        public int s()
        {
            return i.size();
        }

        public boolean t()
        {
            return (g & 2) == 2;
        }

        public e u()
        {
            return j;
        }

        public f v()
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
            e = new c(true);
            e.z();
        }

        private c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a2;
            int i1;
            int j1;
            j1 = 0;
            super();
            k = -1;
            l = -1;
            z();
            a2 = com.umeng.message.proguard.P.b();
            i1 = 0;
_L17:
            if (j1 != 0) goto _L2; else goto _L1
_L1:
            int k1 = i1;
            int j2 = h1.a();
            j2;
            JVM INSTR lookupswitch 4: default 464
        //                       0: 482
        //                       10: 119
        //                       18: 160
        //                       26: 222;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            k1 = i1;
            e.a a1;
            if (!a(h1, a2, n1, j2))
            {
                k1 = 1;
                j1 = i1;
                i1 = k1;
            } else
            {
                int l1 = i1;
                i1 = j1;
                j1 = l1;
            }
              goto _L8
_L5:
            k1 = i1;
            g = g | 1;
            k1 = i1;
            h = h1.l();
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L8
_L6:
            if ((i1 & 2) == 2)
            {
                break MISSING_BLOCK_LABEL_189;
            }
            k1 = i1;
            i = new ArrayList();
            i1 |= 2;
            i.add(h1.a(g.a, n1));
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L8
_L7:
            k1 = i1;
            if ((g & 2) != 2) goto _L10; else goto _L9
_L9:
            k1 = i1;
            a1 = j.u();
_L16:
            k1 = i1;
            j = (e)h1.a(e.a, n1);
            if (a1 == null) goto _L12; else goto _L11
_L11:
            k1 = i1;
            a1.a(j);
            k1 = i1;
            j = a1.v();
_L12:
            k1 = i1;
            g = g | 2;
            k1 = i1;
            i1 = j1;
            j1 = k1;
            break; /* Loop/switch isn't completed */
            h1;
_L15:
            k1 = i1;
            throw h1.a(this);
            h1;
_L13:
            if ((k1 & 2) == 2)
            {
                i = Collections.unmodifiableList(i);
            }
            f = a2.b();
            ad();
            throw h1;
            h1;
_L14:
            k1 = i1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((i1 & 2) == 2)
            {
                i = Collections.unmodifiableList(i);
            }
            f = a2.b();
            ad();
            return;
            h1;
            k1 = i1;
              goto _L13
            h1;
              goto _L14
            h1;
            if (true) goto _L15; else goto _L10
_L10:
            a1 = null;
            if (true) goto _L16; else goto _L8
_L8:
            int i2 = j1;
            j1 = i1;
            i1 = i2;
              goto _L17
_L4:
            boolean flag = true;
            j1 = i1;
            i1 = ((flag) ? 1 : 0);
              goto _L8
        }


        private c(p.a a1)
        {
            super(a1);
            k = -1;
            l = -1;
            f = a1.b_();
        }


        private c(boolean flag)
        {
            k = -1;
            l = -1;
            f = com.umeng.message.proguard.P.c();
        }
    }

    public static final class c.a extends p.a
        implements d
    {

        private int a;
        private Object b;
        private List c;
        private com.umeng.message.proguard.D d;
        private e e;
        private L f;

        static c.a G()
        {
            return I();
        }

        private void H()
        {
            if (com.umeng.message.proguard.p.m)
            {
                L();
                M();
            }
        }

        private static c.a I()
        {
            return new c.a();
        }

        private void K()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        private com.umeng.message.proguard.D L()
        {
            if (d == null)
            {
                List list = c;
                boolean flag;
                if ((a & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                d = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                c = null;
            }
            return d;
        }

        private L M()
        {
            if (f == null)
            {
                f = new L(e, aE(), aD());
                e = null;
            }
            return f;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.l();
        }

        public c.a A()
        {
            a = a & -2;
            b = c.h().o();
            aF();
            return this;
        }

        public c.a B()
        {
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
                aF();
                return this;
            } else
            {
                d.e();
                return this;
            }
        }

        public g.a C()
        {
            return (g.a)L().b(g.h());
        }

        public List D()
        {
            return L().h();
        }

        public c.a E()
        {
            if (f == null)
            {
                e = e.h();
                aF();
            } else
            {
                f.g();
            }
            a = a & -5;
            return this;
        }

        public e.a F()
        {
            a = a | 4;
            aF();
            return (e.a)M().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.l();
        }

        public com.umeng.message.proguard.y Q()
        {
            return x();
        }

        public com.umeng.message.proguard.x R()
        {
            return x();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public c.a a(int i1, g.a a1)
        {
            if (d == null)
            {
                K();
                c.set(i1, a1.x());
                aF();
                return this;
            } else
            {
                d.a(i1, a1.x());
                return this;
            }
        }

        public c.a a(int i1, g g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(i1, g1);
                return this;
            }
        }

        public c.a a(c c1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (c1 == c.h())
            {
                return this;
            }
            if (c1.n())
            {
                a = a | 1;
                b = c.b(c1);
                aF();
            }
            if (d != null) goto _L2; else goto _L1
_L1:
            if (!c.c(c1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = c.c(c1);
                    a = a & -3;
                } else
                {
                    K();
                    c.addAll(c.c(c1));
                }
                aF();
            }
_L4:
            if (c1.t())
            {
                b(c1.u());
            }
            d(c1.b_());
            return this;
_L2:
            if (!c.c(c1).isEmpty())
            {
                if (d.d())
                {
                    d.b();
                    d = null;
                    c = c.c(c1);
                    a = a & -3;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = L();
                    }
                    d = d1;
                } else
                {
                    d.a(c.c(c1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public c.a a(e.a a1)
        {
            if (f == null)
            {
                e = a1.u();
                aF();
            } else
            {
                f.a(a1.u());
            }
            a = a | 4;
            return this;
        }

        public c.a a(e e1)
        {
            if (f == null)
            {
                if (e1 == null)
                {
                    throw new NullPointerException();
                }
                e = e1;
                aF();
            } else
            {
                f.a(e1);
            }
            a = a | 4;
            return this;
        }

        public c.a a(g.a a1)
        {
            if (d == null)
            {
                K();
                c.add(a1.x());
                aF();
                return this;
            } else
            {
                d.a(a1.x());
                return this;
            }
        }

        public c.a a(g g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(g1);
                return this;
            }
        }

        public c.a a(Iterable iterable)
        {
            if (d == null)
            {
                K();
                com.umeng.message.proguard.p.a.a(iterable, c);
                aF();
                return this;
            } else
            {
                d.a(iterable);
                return this;
            }
        }

        public c.a a(String s1)
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

        public g a(int i1)
        {
            if (d == null)
            {
                return (g)c.get(i1);
            } else
            {
                return (g)d.a(i1);
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= s()) goto _L2; else goto _L1
_L1:
            if (a(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (t() && !u().a()) goto _L3; else goto _L5
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
            return w();
        }

        public com.umeng.message.proguard.x aj()
        {
            return z();
        }

        public com.umeng.message.proguard.x ak()
        {
            return y();
        }

        public com.umeng.message.proguard.y al()
        {
            return z();
        }

        public com.umeng.message.proguard.y am()
        {
            return y();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public c.a b(int i1, g.a a1)
        {
            if (d == null)
            {
                K();
                c.add(i1, a1.x());
                aF();
                return this;
            } else
            {
                d.b(i1, a1.x());
                return this;
            }
        }

        public c.a b(int i1, g g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                d.b(i1, g1);
                return this;
            }
        }

        public c.a b(e e1)
        {
            if (f == null)
            {
                if ((a & 4) == 4 && e != e.h())
                {
                    e = e.a(e).a(e1).v();
                } else
                {
                    e = e1;
                }
                aF();
            } else
            {
                f.b(e1);
            }
            a = a | 4;
            return this;
        }

        public h b(int i1)
        {
            if (d == null)
            {
                return (h)c.get(i1);
            } else
            {
                return (h)d.c(i1);
            }
        }

        public c.a c(int i1)
        {
            if (d == null)
            {
                K();
                c.remove(i1);
                aF();
                return this;
            } else
            {
                d.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return w();
        }

        public a.a d()
        {
            return w();
        }

        public c.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof c)
            {
                return a((c)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public g.a d(int i1)
        {
            return (g.a)L().b(i1);
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public c.a e(com.umeng.message.proguard.g g1)
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

        public c.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (c)c.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (c)n1.a();
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

        public g.a e(int i1)
        {
            return (g.a)L().c(i1, g.h());
        }

        public b.a f()
        {
            return w();
        }

        public y.a g()
        {
            return w();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return w();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.m().a(com/umeng/message/proguard/j$c, com/umeng/message/proguard/j$c$a);
        }

        public c.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
            } else
            {
                d.e();
            }
            if (f == null)
            {
                e = e.h();
            } else
            {
                f.g();
            }
            a = a & -5;
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public List q()
        {
            if (d == null)
            {
                return Collections.unmodifiableList(c);
            } else
            {
                return d.g();
            }
        }

        public List r()
        {
            if (d != null)
            {
                return d.i();
            } else
            {
                return Collections.unmodifiableList(c);
            }
        }

        public int s()
        {
            if (d == null)
            {
                return c.size();
            } else
            {
                return d.c();
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public e u()
        {
            if (f == null)
            {
                return e;
            } else
            {
                return (e)f.c();
            }
        }

        public f v()
        {
            if (f != null)
            {
                return (f)f.f();
            } else
            {
                return e;
            }
        }

        public c.a w()
        {
            return I().a(z());
        }

        public c x()
        {
            return c.h();
        }

        public c y()
        {
            c c1 = z();
            if (!c1.a())
            {
                throw b(c1);
            } else
            {
                return c1;
            }
        }

        public c z()
        {
            int i1 = 1;
            c c1 = new c(this);
            int j1 = a;
            if ((j1 & 1) != 1)
            {
                i1 = 0;
            }
            c.a(c1, b);
            if (d == null)
            {
                if ((a & 2) == 2)
                {
                    c = Collections.unmodifiableList(c);
                    a = a & -3;
                }
                c.a(c1, c);
            } else
            {
                c.a(c1, d.f());
            }
            if ((j1 & 4) == 4)
            {
                i1 |= 2;
            }
            if (f == null)
            {
                c.a(c1, e);
            } else
            {
                c.a(c1, (e)f.d());
            }
            c.a(c1, i1);
            aB();
            return c1;
        }

        private c.a()
        {
            b = "";
            c = Collections.emptyList();
            e = e.h();
            H();
        }

        private c.a(p.b b1)
        {
            super(b1);
            b = "";
            c = Collections.emptyList();
            e = e.h();
            H();
        }

    }

    public static interface d
        extends com.umeng.message.proguard.A
    {

        public abstract g a(int i1);

        public abstract h b(int i1);

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract List q();

        public abstract List r();

        public abstract int s();

        public abstract boolean t();

        public abstract e u();

        public abstract f v();
    }

    public static final class e extends p.d
        implements f
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public e c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new e(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 2;
        public static final int c = 999;
        private static final e d;
        private static final long k = 0L;
        private final P e;
        private int f;
        private boolean g;
        private List h;
        private byte i;
        private int j;

        static int a(e e1, int i1)
        {
            e1.f = i1;
            return i1;
        }

        public static a a(e e1)
        {
            return s().a(e1);
        }

        public static e a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (e)a.d(g1);
        }

        public static e a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (e)a.d(g1, n1);
        }

        public static e a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (e)a.d(h1);
        }

        public static e a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (e)a.b(h1, n1);
        }

        public static e a(InputStream inputstream)
            throws IOException
        {
            return (e)a.h(inputstream);
        }

        public static e a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (e)a.h(inputstream, n1);
        }

        public static e a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (e)a.d(abyte0);
        }

        public static e a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (e)a.d(abyte0, n1);
        }

        static List a(e e1, List list)
        {
            e1.h = list;
            return list;
        }

        static boolean a(e e1, boolean flag)
        {
            e1.g = flag;
            return flag;
        }

        public static e b(InputStream inputstream)
            throws IOException
        {
            return (e)a.f(inputstream);
        }

        public static e b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (e)a.f(inputstream, n1);
        }

        static List b(e e1)
        {
            return e1.h;
        }

        public static e h()
        {
            return d;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.z();
        }

        public static a s()
        {
            return a.C();
        }

        private void v()
        {
            g = true;
            h = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return u();
        }

        public x.a N()
        {
            return t();
        }

        public y.a O()
        {
            return u();
        }

        public y.a P()
        {
            return t();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public G a(int i1)
        {
            return (G)h.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
            if ((f & 1) == 1)
            {
                i1.a(2, g);
            }
            for (int j1 = 0; j1 < h.size(); j1++)
            {
                i1.c(999, (com.umeng.message.proguard.y)h.get(j1));
            }

            a1.a(0x20000000, i1);
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = i;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < r(); i1++)
            {
                if (!a(i1).a())
                {
                    i = 0;
                    return false;
                }
            }

            if (!W())
            {
                i = 0;
                return false;
            } else
            {
                i = 1;
                return true;
            }
        }

        public H b(int i1)
        {
            return (H)h.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return e;
        }

        public int d()
        {
            int j1 = 0;
            int i1 = j;
            if (i1 != -1)
            {
                return i1;
            }
            if ((f & 1) == 1)
            {
                i1 = com.umeng.message.proguard.i.b(2, g) + 0;
            } else
            {
                i1 = 0;
            }
            while (j1 < h.size()) 
            {
                int k1 = com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)h.get(j1));
                j1++;
                i1 = k1 + i1;
            }
            i1 = Z() + i1 + b_().d();
            j = i1;
            return i1;
        }

        public e i()
        {
            return d;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.A().a(com/umeng/message/proguard/j$e, com/umeng/message/proguard/j$e$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (f & 1) == 1;
        }

        public boolean o()
        {
            return g;
        }

        public List p()
        {
            return h;
        }

        public List q()
        {
            return h;
        }

        public int r()
        {
            return h.size();
        }

        public a t()
        {
            return s();
        }

        public a u()
        {
            return a(this);
        }

        static 
        {
            d = new e(true);
            d.v();
        }

        private e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            int i1;
            boolean flag;
            flag = false;
            super();
            i = -1;
            j = -1;
            v();
            a1 = com.umeng.message.proguard.P.b();
            i1 = 0;
_L10:
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
            JVM INSTR lookupswitch 3: default 339
        //                       0: 342
        //                       16: 118
        //                       7994: 208;
               goto _L3 _L4 _L5 _L6
_L3:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            if (!a(h1, a1, n1, j1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            f = f | 1;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            g = h1.j();
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = l1;
            throw h1.a(this);
            h1;
            if ((k1 & 2) == 2)
            {
                h = Collections.unmodifiableList(h);
            }
            e = a1.b();
            ad();
            throw h1;
_L6:
            j1 = i1;
            if ((i1 & 2) == 2) goto _L8; else goto _L7
_L7:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            h = new ArrayList();
            j1 = i1 | 2;
_L8:
            l1 = j1;
            k1 = j1;
            i2 = j1;
            h.add(h1.a(G.a, n1));
            i1 = j1;
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = i2;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((i1 & 2) == 2)
            {
                h = Collections.unmodifiableList(h);
            }
            e = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L10; else goto _L9
_L9:
        }


        private e(p.c c1)
        {
            super(c1);
            i = -1;
            j = -1;
            e = c1.b_();
        }


        private e(boolean flag)
        {
            i = -1;
            j = -1;
            e = com.umeng.message.proguard.P.c();
        }
    }

    public static final class e.a extends p.c
        implements f
    {

        private int a;
        private boolean b;
        private List c;
        private com.umeng.message.proguard.D d;

        static e.a C()
        {
            return E();
        }

        private void D()
        {
            if (com.umeng.message.proguard.p.m)
            {
                G();
            }
        }

        private static e.a E()
        {
            return new e.a();
        }

        private void F()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        private com.umeng.message.proguard.D G()
        {
            if (d == null)
            {
                List list = c;
                boolean flag;
                if ((a & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                d = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                c = null;
            }
            return d;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.z();
        }

        public p.c A()
        {
            return s();
        }

        public p.c B()
        {
            return m();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.z();
        }

        public com.umeng.message.proguard.y Q()
        {
            return t();
        }

        public com.umeng.message.proguard.x R()
        {
            return t();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G a(int i1)
        {
            if (d == null)
            {
                return (G)c.get(i1);
            } else
            {
                return (G)d.a(i1);
            }
        }

        public e.a a(int i1, G.a a1)
        {
            if (d == null)
            {
                F();
                c.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                d.a(i1, a1.G());
                return this;
            }
        }

        public e.a a(int i1, G g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    F();
                    c.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(i1, g1);
                return this;
            }
        }

        public e.a a(G.a a1)
        {
            if (d == null)
            {
                F();
                c.add(a1.G());
                aF();
                return this;
            } else
            {
                d.a(a1.G());
                return this;
            }
        }

        public e.a a(G g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    F();
                    c.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(g1);
                return this;
            }
        }

        public e.a a(e e1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (e1 == e.h())
            {
                return this;
            }
            if (e1.n())
            {
                a(e1.o());
            }
            if (d != null) goto _L2; else goto _L1
_L1:
            if (!e.b(e1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = e.b(e1);
                    a = a & -3;
                } else
                {
                    F();
                    c.addAll(e.b(e1));
                }
                aF();
            }
_L4:
            a(((p.d) (e1)));
            d(e1.b_());
            return this;
_L2:
            if (!e.b(e1).isEmpty())
            {
                if (d.d())
                {
                    d.b();
                    d = null;
                    c = e.b(e1);
                    a = a & -3;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = G();
                    }
                    d = d1;
                } else
                {
                    d.a(e.b(e1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public e.a a(Iterable iterable)
        {
            if (d == null)
            {
                F();
                com.umeng.message.proguard.p.c.a(iterable, c);
                aF();
                return this;
            } else
            {
                d.a(iterable);
                return this;
            }
        }

        public e.a a(boolean flag)
        {
            a = a | 1;
            b = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= r()) goto _L2; else goto _L1
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
            return s();
        }

        public com.umeng.message.proguard.x aj()
        {
            return v();
        }

        public com.umeng.message.proguard.x ak()
        {
            return u();
        }

        public com.umeng.message.proguard.y al()
        {
            return v();
        }

        public com.umeng.message.proguard.y am()
        {
            return u();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public H b(int i1)
        {
            if (d == null)
            {
                return (H)c.get(i1);
            } else
            {
                return (H)d.c(i1);
            }
        }

        public e.a b(int i1, G.a a1)
        {
            if (d == null)
            {
                F();
                c.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                d.b(i1, a1.G());
                return this;
            }
        }

        public e.a b(int i1, G g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    F();
                    c.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                d.b(i1, g1);
                return this;
            }
        }

        public e.a c(int i1)
        {
            if (d == null)
            {
                F();
                c.remove(i1);
                aF();
                return this;
            } else
            {
                d.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return s();
        }

        public a.a d()
        {
            return s();
        }

        public G.a d(int i1)
        {
            return (G.a)G().b(i1);
        }

        public e.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof e)
            {
                return a((e)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.a e(int i1)
        {
            return (G.a)G().c(i1, G.h());
        }

        public e.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (e)e.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (e)n1.a();
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
            return s();
        }

        public y.a g()
        {
            return s();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return s();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.A().a(com/umeng/message/proguard/j$e, com/umeng/message/proguard/j$e$a);
        }

        public e.a m()
        {
            super.B();
            b = true;
            a = a & -2;
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
                return this;
            } else
            {
                d.e();
                return this;
            }
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public boolean o()
        {
            return b;
        }

        public List p()
        {
            if (d == null)
            {
                return Collections.unmodifiableList(c);
            } else
            {
                return d.g();
            }
        }

        public List q()
        {
            if (d != null)
            {
                return d.i();
            } else
            {
                return Collections.unmodifiableList(c);
            }
        }

        public int r()
        {
            if (d == null)
            {
                return c.size();
            } else
            {
                return d.c();
            }
        }

        public e.a s()
        {
            return E().a(v());
        }

        public e t()
        {
            return e.h();
        }

        public e u()
        {
            e e1 = v();
            if (!e1.a())
            {
                throw b(e1);
            } else
            {
                return e1;
            }
        }

        public e v()
        {
            int i1 = 1;
            e e1 = new e(this);
            if ((a & 1) != 1)
            {
                i1 = 0;
            }
            e.a(e1, b);
            if (d == null)
            {
                if ((a & 2) == 2)
                {
                    c = Collections.unmodifiableList(c);
                    a = a & -3;
                }
                e.a(e1, c);
            } else
            {
                e.a(e1, d.f());
            }
            e.a(e1, i1);
            aB();
            return e1;
        }

        public e.a w()
        {
            a = a & -2;
            b = true;
            aF();
            return this;
        }

        public e.a x()
        {
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
                aF();
                return this;
            } else
            {
                d.e();
                return this;
            }
        }

        public G.a y()
        {
            return (G.a)G().b(G.h());
        }

        public List z()
        {
            return G().h();
        }

        private e.a()
        {
            b = true;
            c = Collections.emptyList();
            D();
        }

        private e.a(p.b b1)
        {
            super(b1);
            b = true;
            c = Collections.emptyList();
            D();
        }

    }

    public static interface f
        extends p.e
    {

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract boolean n();

        public abstract boolean o();

        public abstract List p();

        public abstract List q();

        public abstract int r();
    }

    public static final class g extends com.umeng.message.proguard.p
        implements h
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public g c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new g(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        private static final g e;
        private static final long n = 0L;
        private final P f;
        private int g;
        private Object h;
        private int i;
        private i j;
        private byte k;
        private int l;

        static int a(g g1, int i1)
        {
            g1.i = i1;
            return i1;
        }

        public static a a(g g1)
        {
            return v().a(g1);
        }

        public static g a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (g)a.d(g1);
        }

        public static g a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (g)a.d(g1, n1);
        }

        public static g a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (g)a.d(h1);
        }

        public static g a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (g)a.b(h1, n1);
        }

        public static g a(InputStream inputstream)
            throws IOException
        {
            return (g)a.h(inputstream);
        }

        public static g a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (g)a.h(inputstream, n1);
        }

        public static g a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (g)a.d(abyte0);
        }

        public static g a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (g)a.d(abyte0, n1);
        }

        static i a(g g1, i i1)
        {
            g1.j = i1;
            return i1;
        }

        static Object a(g g1, Object obj)
        {
            g1.h = obj;
            return obj;
        }

        static int b(g g1, int i1)
        {
            g1.g = i1;
            return i1;
        }

        public static g b(InputStream inputstream)
            throws IOException
        {
            return (g)a.f(inputstream);
        }

        public static g b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (g)a.f(inputstream, n1);
        }

        static Object b(g g1)
        {
            return g1.h;
        }

        public static g h()
        {
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.n();
        }

        public static a v()
        {
            return a.D();
        }

        private void y()
        {
            h = "";
            i = 0;
            j = i.h();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return x();
        }

        public x.a N()
        {
            return w();
        }

        public y.a O()
        {
            return x();
        }

        public y.a P()
        {
            return w();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            if ((g & 1) == 1)
            {
                i1.a(1, p());
            }
            if ((g & 2) == 2)
            {
                i1.a(2, i);
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
            }
            if (s() && !t().a())
            {
                k = 0;
                return false;
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
                j1 = 0 + com.umeng.message.proguard.i.c(1, p());
            }
            i1 = j1;
            if ((g & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.g(2, i);
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

        public g i()
        {
            return e;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.o().a(com/umeng/message/proguard/j$g, com/umeng/message/proguard/j$g$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (g & 1) == 1;
        }

        public String o()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                h = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                h = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean q()
        {
            return (g & 2) == 2;
        }

        public int r()
        {
            return i;
        }

        public boolean s()
        {
            return (g & 4) == 4;
        }

        public i t()
        {
            return j;
        }

        public j u()
        {
            return j;
        }

        public a w()
        {
            return v();
        }

        public a x()
        {
            return a(this);
        }

        static 
        {
            e = new g(true);
            e.y();
        }

        private g(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a2;
            boolean flag;
            k = -1;
            l = -1;
            y();
            a2 = com.umeng.message.proguard.P.b();
            flag = false;
_L14:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 4: default 270
        //                       0: 276
        //                       10: 99
        //                       16: 120
        //                       26: 141;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            if (!a(h1, a2, n1, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            g = g | 1;
            h = h1.l();
            continue; /* Loop/switch isn't completed */
_L6:
            g = g | 2;
            i = h1.g();
            continue; /* Loop/switch isn't completed */
_L7:
            if ((g & 4) != 4) goto _L9; else goto _L8
_L8:
            i.a a1 = j.s();
_L12:
            j = (i)h1.a(i.a, n1);
            if (a1 == null) goto _L11; else goto _L10
_L10:
            a1.a(j);
            j = a1.t();
_L11:
            g = g | 4;
            continue; /* Loop/switch isn't completed */
            h1;
            throw h1.a(this);
            h1;
            f = a2.b();
            ad();
            throw h1;
            h1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            f = a2.b();
            ad();
            return;
_L9:
            a1 = null;
              goto _L12
_L4:
            flag = true;
            if (true) goto _L14; else goto _L13
_L13:
        }


        private g(p.a a1)
        {
            super(a1);
            k = -1;
            l = -1;
            f = a1.b_();
        }


        private g(boolean flag)
        {
            k = -1;
            l = -1;
            f = com.umeng.message.proguard.P.c();
        }
    }

    public static final class g.a extends p.a
        implements h
    {

        private int a;
        private Object b;
        private int c;
        private i d;
        private L e;

        static g.a D()
        {
            return F();
        }

        private void E()
        {
            if (com.umeng.message.proguard.p.m)
            {
                G();
            }
        }

        private static g.a F()
        {
            return new g.a();
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
            return com.umeng.message.proguard.j.n();
        }

        public g.a A()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public g.a B()
        {
            if (e == null)
            {
                d = i.h();
                aF();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public i.a C()
        {
            a = a | 4;
            aF();
            return (i.a)G().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.n();
        }

        public com.umeng.message.proguard.y Q()
        {
            return w();
        }

        public com.umeng.message.proguard.x R()
        {
            return w();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public g.a a(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public g.a a(g g1)
        {
            if (g1 == g.h())
            {
                return this;
            }
            if (g1.n())
            {
                a = a | 1;
                b = g.b(g1);
                aF();
            }
            if (g1.q())
            {
                a(g1.r());
            }
            if (g1.s())
            {
                b(g1.t());
            }
            d(g1.b_());
            return this;
        }

        public g.a a(i.a a1)
        {
            if (e == null)
            {
                d = a1.s();
                aF();
            } else
            {
                e.a(a1.s());
            }
            a = a | 4;
            return this;
        }

        public g.a a(i i1)
        {
            if (e == null)
            {
                if (i1 == null)
                {
                    throw new NullPointerException();
                }
                d = i1;
                aF();
            } else
            {
                e.a(i1);
            }
            a = a | 4;
            return this;
        }

        public g.a a(String s1)
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
            return !s() || t().a();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return v();
        }

        public com.umeng.message.proguard.x aj()
        {
            return y();
        }

        public com.umeng.message.proguard.x ak()
        {
            return x();
        }

        public com.umeng.message.proguard.y al()
        {
            return y();
        }

        public com.umeng.message.proguard.y am()
        {
            return x();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public g.a b(i i1)
        {
            if (e == null)
            {
                if ((a & 4) == 4 && d != i.h())
                {
                    d = i.a(d).a(i1).t();
                } else
                {
                    d = i1;
                }
                aF();
            } else
            {
                e.b(i1);
            }
            a = a | 4;
            return this;
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return v();
        }

        public a.a d()
        {
            return v();
        }

        public g.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof g)
            {
                return a((g)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public g.a e(com.umeng.message.proguard.g g1)
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

        public g.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (g)g.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (g)n1.a();
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
            return v();
        }

        public y.a g()
        {
            return v();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return v();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.o().a(com/umeng/message/proguard/j$g, com/umeng/message/proguard/j$g$a);
        }

        public g.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = 0;
            a = a & -3;
            if (e == null)
            {
                d = i.h();
            } else
            {
                e.g();
            }
            a = a & -5;
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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

        public i t()
        {
            if (e == null)
            {
                return d;
            } else
            {
                return (i)e.c();
            }
        }

        public j u()
        {
            if (e != null)
            {
                return (j)e.f();
            } else
            {
                return d;
            }
        }

        public g.a v()
        {
            return F().a(y());
        }

        public g w()
        {
            return g.h();
        }

        public g x()
        {
            g g1 = y();
            if (!g1.a())
            {
                throw b(g1);
            } else
            {
                return g1;
            }
        }

        public g y()
        {
            int i1 = 1;
            g g1 = new g(this);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            g.a(g1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            g.a(g1, c);
            if ((k1 & 4) == 4)
            {
                i1 = j1 | 4;
            } else
            {
                i1 = j1;
            }
            if (e == null)
            {
                g.a(g1, d);
            } else
            {
                g.a(g1, (i)e.d());
            }
            g.b(g1, i1);
            aB();
            return g1;
        }

        public g.a z()
        {
            a = a & -2;
            b = g.h().o();
            aF();
            return this;
        }

        private g.a()
        {
            b = "";
            d = i.h();
            E();
        }

        private g.a(p.b b1)
        {
            super(b1);
            b = "";
            d = i.h();
            E();
        }

    }

    public static interface h
        extends com.umeng.message.proguard.A
    {

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract boolean q();

        public abstract int r();

        public abstract boolean s();

        public abstract i t();

        public abstract j u();
    }

    public static final class i extends p.d
        implements j
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public i c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new i(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 999;
        private static final i c;
        private static final long h = 0L;
        private final P d;
        private List e;
        private byte f;
        private int g;

        public static a a(i i1)
        {
            return q().a(i1);
        }

        public static i a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (i)a.d(g1);
        }

        public static i a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (i)a.d(g1, n1);
        }

        public static i a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (i)a.d(h1);
        }

        public static i a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (i)a.b(h1, n1);
        }

        public static i a(InputStream inputstream)
            throws IOException
        {
            return (i)a.h(inputstream);
        }

        public static i a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (i)a.h(inputstream, n1);
        }

        public static i a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (i)a.d(abyte0);
        }

        public static i a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (i)a.d(abyte0, n1);
        }

        static List a(i i1, List list)
        {
            i1.e = list;
            return list;
        }

        public static i b(InputStream inputstream)
            throws IOException
        {
            return (i)a.f(inputstream);
        }

        public static i b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (i)a.f(inputstream, n1);
        }

        static List b(i i1)
        {
            return i1.e;
        }

        public static i h()
        {
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.B();
        }

        public static a q()
        {
            return a.x();
        }

        private void t()
        {
            e = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return s();
        }

        public x.a N()
        {
            return r();
        }

        public y.a O()
        {
            return s();
        }

        public y.a P()
        {
            return r();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public G a(int i1)
        {
            return (G)e.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
            for (int j1 = 0; j1 < e.size(); j1++)
            {
                i1.c(999, (com.umeng.message.proguard.y)e.get(j1));
            }

            a1.a(0x20000000, i1);
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = f;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    f = 0;
                    return false;
                }
            }

            if (!W())
            {
                f = 0;
                return false;
            } else
            {
                f = 1;
                return true;
            }
        }

        public H b(int i1)
        {
            return (H)e.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return d;
        }

        public int d()
        {
            int i1 = g;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            int j1 = 0;
            for (; i1 < e.size(); i1++)
            {
                j1 += com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)e.get(i1));
            }

            i1 = Z() + j1 + b_().d();
            g = i1;
            return i1;
        }

        public i i()
        {
            return c;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.C().a(com/umeng/message/proguard/j$i, com/umeng/message/proguard/j$i$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return e;
        }

        public List o()
        {
            return e;
        }

        public int p()
        {
            return e.size();
        }

        public a r()
        {
            return q();
        }

        public a s()
        {
            return a(this);
        }

        static 
        {
            c = new i(true);
            c.t();
        }

        private i(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            boolean flag2;
            flag2 = false;
            super();
            f = -1;
            g = -1;
            t();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L9:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 2: default 286
        //                       0: 289
        //                       7994: 110;
               goto _L3 _L4 _L5
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!a(h1, a1, n1, i1))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L7; else goto _L6
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            e = new ArrayList();
            i1 = flag | true;
_L7:
            flag3 = i1;
            flag1 = i1;
            flag4 = i1;
            e.add(h1.a(G.a, n1));
            flag = i1;
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag3;
            throw h1.a(this);
            h1;
            if ((flag1 & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            throw h1;
            h1;
            flag1 = flag4;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((flag & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            return;
_L4:
            flag2 = true;
            if (true) goto _L9; else goto _L8
_L8:
        }


        private i(p.c c1)
        {
            super(c1);
            f = -1;
            g = -1;
            d = c1.b_();
        }


        private i(boolean flag)
        {
            f = -1;
            g = -1;
            d = com.umeng.message.proguard.P.c();
        }
    }

    public static final class i.a extends p.c
        implements j
    {

        private int a;
        private List b;
        private com.umeng.message.proguard.D c;

        private void C()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private com.umeng.message.proguard.D D()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.B();
        }

        static i.a x()
        {
            return z();
        }

        private void y()
        {
            if (com.umeng.message.proguard.p.m)
            {
                D();
            }
        }

        private static i.a z()
        {
            return new i.a();
        }

        public p.c A()
        {
            return q();
        }

        public p.c B()
        {
            return m();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.B();
        }

        public com.umeng.message.proguard.y Q()
        {
            return r();
        }

        public com.umeng.message.proguard.x R()
        {
            return r();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G a(int i1)
        {
            if (c == null)
            {
                return (G)b.get(i1);
            } else
            {
                return (G)c.a(i1);
            }
        }

        public i.a a(int i1, G.a a1)
        {
            if (c == null)
            {
                C();
                b.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.G());
                return this;
            }
        }

        public i.a a(int i1, G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, g1);
                return this;
            }
        }

        public i.a a(G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(a1.G());
                aF();
                return this;
            } else
            {
                c.a(a1.G());
                return this;
            }
        }

        public i.a a(G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(g1);
                return this;
            }
        }

        public i.a a(i i1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (i1 == i.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!i.b(i1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = i.b(i1);
                    a = a & -2;
                } else
                {
                    C();
                    b.addAll(i.b(i1));
                }
                aF();
            }
_L4:
            a(((p.d) (i1)));
            d(i1.b_());
            return this;
_L2:
            if (!i.b(i1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = i.b(i1);
                    a = a & -2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = D();
                    }
                    c = d1;
                } else
                {
                    c.a(i.b(i1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public i.a a(Iterable iterable)
        {
            if (c == null)
            {
                C();
                com.umeng.message.proguard.p.c.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= p()) goto _L2; else goto _L1
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
            return q();
        }

        public com.umeng.message.proguard.x aj()
        {
            return t();
        }

        public com.umeng.message.proguard.x ak()
        {
            return s();
        }

        public com.umeng.message.proguard.y al()
        {
            return t();
        }

        public com.umeng.message.proguard.y am()
        {
            return s();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public H b(int i1)
        {
            if (c == null)
            {
                return (H)b.get(i1);
            } else
            {
                return (H)c.c(i1);
            }
        }

        public i.a b(int i1, G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.G());
                return this;
            }
        }

        public i.a b(int i1, G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, g1);
                return this;
            }
        }

        public i.a c(int i1)
        {
            if (c == null)
            {
                C();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public G.a d(int i1)
        {
            return (G.a)D().b(i1);
        }

        public i.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof i)
            {
                return a((i)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.a e(int i1)
        {
            return (G.a)D().c(i1, G.h());
        }

        public i.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (i)i.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (i)n1.a();
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
            return q();
        }

        public y.a g()
        {
            return q();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return q();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.C().a(com/umeng/message/proguard/j$i, com/umeng/message/proguard/j$i$a);
        }

        public i.a m()
        {
            super.B();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public i.a q()
        {
            return z().a(t());
        }

        public i r()
        {
            return i.h();
        }

        public i s()
        {
            i i1 = t();
            if (!i1.a())
            {
                throw b(i1);
            } else
            {
                return i1;
            }
        }

        public i t()
        {
            i i1 = new i(this);
            int j1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                i.a(i1, b);
            } else
            {
                i.a(i1, c.f());
            }
            aB();
            return i1;
        }

        public i.a u()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public G.a v()
        {
            return (G.a)D().b(G.h());
        }

        public List w()
        {
            return D().h();
        }

        private i.a()
        {
            b = Collections.emptyList();
            y();
        }

        private i.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

    }

    public static interface j
        extends p.e
    {

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract List n();

        public abstract List o();

        public abstract int p();
    }

    public static final class k extends com.umeng.message.proguard.p
        implements l
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public k c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new k(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
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
        private static final k j;
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
        private m u;
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
            u = m.h();
        }

        static int a(k k1, int i1)
        {
            k1.o = i1;
            return i1;
        }

        public static a a(k k1)
        {
            return K().a(k1);
        }

        static b a(k k1, b b1)
        {
            k1.p = b1;
            return b1;
        }

        static c a(k k1, c c1)
        {
            k1.q = c1;
            return c1;
        }

        public static k a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (k)a.d(g1);
        }

        public static k a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (k)a.d(g1, n1);
        }

        public static k a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (k)a.d(h1);
        }

        public static k a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (k)a.b(h1, n1);
        }

        public static k a(InputStream inputstream)
            throws IOException
        {
            return (k)a.h(inputstream);
        }

        public static k a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (k)a.h(inputstream, n1);
        }

        public static k a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (k)a.d(abyte0);
        }

        public static k a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (k)a.d(abyte0, n1);
        }

        static m a(k k1, m m1)
        {
            k1.u = m1;
            return m1;
        }

        static Object a(k k1, Object obj)
        {
            k1.n = obj;
            return obj;
        }

        static int b(k k1, int i1)
        {
            k1.l = i1;
            return i1;
        }

        public static k b(InputStream inputstream)
            throws IOException
        {
            return (k)a.f(inputstream);
        }

        public static k b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (k)a.f(inputstream, n1);
        }

        static Object b(k k1)
        {
            return k1.n;
        }

        static Object b(k k1, Object obj)
        {
            k1.r = obj;
            return obj;
        }

        static Object c(k k1)
        {
            return k1.r;
        }

        static Object c(k k1, Object obj)
        {
            k1.s = obj;
            return obj;
        }

        static Object d(k k1)
        {
            return k1.s;
        }

        static Object d(k k1, Object obj)
        {
            k1.t = obj;
            return obj;
        }

        static Object e(k k1)
        {
            return k1.t;
        }

        public static k h()
        {
            return j;
        }

        public static final k.a k()
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
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                s = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g B()
        {
            Object obj = s;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                s = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                t = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g E()
        {
            Object obj = t;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                t = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean F()
        {
            return (l & 0x80) == 128;
        }

        public m G()
        {
            return u;
        }

        public n H()
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

        public x.a M()
        {
            return S();
        }

        public x.a N()
        {
            return L();
        }

        public y.a O()
        {
            return S();
        }

        public y.a P()
        {
            return L();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public a S()
        {
            return a(this);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
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

        protected x.a b(p.b b1)
        {
            return a(b1);
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

        public k i()
        {
            return j;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.k().a(com/umeng/message/proguard/j$k, com/umeng/message/proguard/j$k$a);
        }

        public com.umeng.message.proguard.B m()
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
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                n = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = n;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                n = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                r = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g y()
        {
            Object obj = r;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                r = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean z()
        {
            return (l & 0x20) == 32;
        }

        static 
        {
            j = new k(true);
            j.T();
        }

        private k(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            v = -1;
            w = -1;
            T();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L23:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 9: default 475
        //                       0: 481
        //                       10: 139
        //                       18: 160
        //                       24: 182
        //                       32: 203
        //                       40: 249
        //                       50: 296
        //                       58: 318
        //                       66: 340;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
            if (!a(h1, a1, n1, i1))
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
            a1.a(4, i1);
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
            a1.a(5, i1);
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
            u = (m)h1.a(m.a, n1);
            if (obj == null) goto _L20; else goto _L19
_L19:
            ((m.a) (obj)).a(u);
            u = ((m.a) (obj)).G();
_L20:
            l = l | 0x80;
            continue; /* Loop/switch isn't completed */
            h1;
            throw h1.a(this);
            h1;
            k = a1.b();
            ad();
            throw h1;
            h1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            k = a1.b();
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


        private k(p.a a1)
        {
            super(a1);
            v = -1;
            w = -1;
            k = a1.b_();
        }


        private k(boolean flag)
        {
            v = -1;
            w = -1;
            k = com.umeng.message.proguard.P.c();
        }
    }

    public static final class k.a extends p.a
        implements l
    {

        private int a;
        private Object b;
        private int c;
        private k.b d;
        private k.c e;
        private Object f;
        private Object g;
        private Object h;
        private m i;
        private L j;

        static k.a Y()
        {
            return aa();
        }

        private void Z()
        {
            if (com.umeng.message.proguard.p.m)
            {
                ab();
            }
        }

        private static k.a aa()
        {
            return new k.a();
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                g = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g B()
        {
            Object obj = g;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                g = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                h = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g E()
        {
            Object obj = h;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                h = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean F()
        {
            return (a & 0x80) == 128;
        }

        public m G()
        {
            if (j == null)
            {
                return i;
            } else
            {
                return (m)j.c();
            }
        }

        public n H()
        {
            if (j != null)
            {
                return (n)j.f();
            } else
            {
                return i;
            }
        }

        public k.a I()
        {
            return aa().a(M());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.j();
        }

        public k K()
        {
            return k.h();
        }

        public k L()
        {
            k k1 = M();
            if (!k1.a())
            {
                throw b(k1);
            } else
            {
                return k1;
            }
        }

        public k M()
        {
            int j1 = 1;
            k k1 = new k(this);
            int l1 = a;
            int i1;
            if ((l1 & 1) != 1)
            {
                j1 = 0;
            }
            k.a(k1, b);
            i1 = j1;
            if ((l1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            k.a(k1, c);
            j1 = i1;
            if ((l1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            k.a(k1, d);
            i1 = j1;
            if ((l1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            k.a(k1, e);
            j1 = i1;
            if ((l1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            k.b(k1, f);
            i1 = j1;
            if ((l1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            k.c(k1, g);
            j1 = i1;
            if ((l1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            k.d(k1, h);
            if ((l1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            } else
            {
                i1 = j1;
            }
            if (j == null)
            {
                k.a(k1, i);
            } else
            {
                k.a(k1, (m)j.d());
            }
            k.b(k1, i1);
            aB();
            return k1;
        }

        public k.a N()
        {
            a = a & -2;
            b = k.h().o();
            aF();
            return this;
        }

        public k.a O()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public k.a P()
        {
            a = a & -5;
            d = k.b.a;
            aF();
            return this;
        }

        public com.umeng.message.proguard.y Q()
        {
            return K();
        }

        public com.umeng.message.proguard.x R()
        {
            return K();
        }

        public k.a S()
        {
            a = a & -9;
            e = k.c.a;
            aF();
            return this;
        }

        public k.a T()
        {
            a = a & 0xffffffef;
            f = k.h().x();
            aF();
            return this;
        }

        public k.a U()
        {
            a = a & 0xffffffdf;
            g = k.h().A();
            aF();
            return this;
        }

        public k.a V()
        {
            a = a & 0xffffffbf;
            h = k.h().D();
            aF();
            return this;
        }

        public k.a W()
        {
            if (j == null)
            {
                i = m.h();
                aF();
            } else
            {
                j.g();
            }
            a = a & 0xffffff7f;
            return this;
        }

        public m.a X()
        {
            a = a | 0x80;
            aF();
            return (m.a)ab().e();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public k.a a(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public k.a a(k.b b1)
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

        public k.a a(k.c c1)
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

        public k.a a(k k1)
        {
            if (k1 == k.h())
            {
                return this;
            }
            if (k1.n())
            {
                a = a | 1;
                b = k.b(k1);
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
                f = k.c(k1);
                aF();
            }
            if (k1.z())
            {
                a = a | 0x20;
                g = k.d(k1);
                aF();
            }
            if (k1.C())
            {
                a = a | 0x40;
                h = k.e(k1);
                aF();
            }
            if (k1.F())
            {
                b(k1.G());
            }
            d(k1.b_());
            return this;
        }

        public k.a a(m.a a1)
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

        public k.a a(m m1)
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

        public k.a a(String s1)
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

        public com.umeng.message.proguard.x aj()
        {
            return M();
        }

        public com.umeng.message.proguard.x ak()
        {
            return L();
        }

        public com.umeng.message.proguard.y al()
        {
            return M();
        }

        public com.umeng.message.proguard.y am()
        {
            return L();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public k.a b(m m1)
        {
            if (j == null)
            {
                if ((a & 0x80) == 128 && i != m.h())
                {
                    i = m.a(i).a(m1).G();
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

        public k.a b(String s1)
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

        public k.a c(String s1)
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

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public k.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof k)
            {
                return a((k)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public k.a d(String s1)
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

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public k.a e(com.umeng.message.proguard.g g1)
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

        public k.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (k)k.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (k)n1.a();
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

        public k.a f(com.umeng.message.proguard.g g1)
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

        public k.a g(com.umeng.message.proguard.g g1)
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

        public k.a h(com.umeng.message.proguard.g g1)
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

        public k.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = 0;
            a = a & -3;
            d = k.b.a;
            a = a & -5;
            e = k.c.a;
            a = a & -9;
            f = "";
            a = a & 0xffffffef;
            g = "";
            a = a & 0xffffffdf;
            h = "";
            a = a & 0xffffffbf;
            if (j == null)
            {
                i = m.h();
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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

        public k.b t()
        {
            return d;
        }

        public boolean u()
        {
            return (a & 8) == 8;
        }

        public k.c v()
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                f = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g y()
        {
            Object obj = f;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                f = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean z()
        {
            return (a & 0x20) == 32;
        }

        private k.a()
        {
            b = "";
            d = k.b.a;
            e = k.c.a;
            f = "";
            g = "";
            h = "";
            i = m.h();
            Z();
        }

        private k.a(p.b b1)
        {
            super(b1);
            b = "";
            d = k.b.a;
            e = k.c.a;
            f = "";
            g = "";
            h = "";
            i = m.h();
            Z();
        }

    }

    public static final class k.b extends Enum
        implements com.umeng.message.proguard.C
    {

        public static final k.b a;
        public static final k.b b;
        public static final k.b c;
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static r.b g = new r.b() {

            public k.b a(int i1)
            {
                return k.b.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final k.b h[] = values();
        private static final k.b k[];
        private final int i;
        private final int j;

        public static k.b a(int i1)
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

        public static k.b a(k.e e1)
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
            return (k.d)k.k().k().get(1);
        }

        public static k.b valueOf(String s1)
        {
            return (k.b)Enum.valueOf(com/umeng/message/proguard/j$k$b, s1);
        }

        public static k.b[] values()
        {
            return (k.b[])k.clone();
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
            a = new k.b("LABEL_OPTIONAL", 0, 0, 1);
            b = new k.b("LABEL_REQUIRED", 1, 1, 2);
            c = new k.b("LABEL_REPEATED", 2, 2, 3);
            k = (new k.b[] {
                a, b, c
            });
        }

        private k.b(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            i = j1;
            j = k1;
        }
    }

    public static final class k.c extends Enum
        implements com.umeng.message.proguard.C
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

            public k.c a(int i1)
            {
                return k.c.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final k.c L[] = values();
        private static final k.c O[];
        public static final k.c a;
        public static final k.c b;
        public static final k.c c;
        public static final k.c d;
        public static final k.c e;
        public static final k.c f;
        public static final k.c g;
        public static final k.c h;
        public static final k.c i;
        public static final k.c j;
        public static final k.c k;
        public static final k.c l;
        public static final k.c m;
        public static final k.c n;
        public static final k.c o;
        public static final k.c p;
        public static final k.c q;
        public static final k.c r;
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

        public static k.c a(int i1)
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

        public static k.c a(k.e e1)
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
            return (k.d)k.k().k().get(0);
        }

        public static k.c valueOf(String s1)
        {
            return (k.c)Enum.valueOf(com/umeng/message/proguard/j$k$c, s1);
        }

        public static k.c[] values()
        {
            return (k.c[])O.clone();
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
            a = new k.c("TYPE_DOUBLE", 0, 0, 1);
            b = new k.c("TYPE_FLOAT", 1, 1, 2);
            c = new k.c("TYPE_INT64", 2, 2, 3);
            d = new k.c("TYPE_UINT64", 3, 3, 4);
            e = new k.c("TYPE_INT32", 4, 4, 5);
            f = new k.c("TYPE_FIXED64", 5, 5, 6);
            g = new k.c("TYPE_FIXED32", 6, 6, 7);
            h = new k.c("TYPE_BOOL", 7, 7, 8);
            i = new k.c("TYPE_STRING", 8, 8, 9);
            j = new k.c("TYPE_GROUP", 9, 9, 10);
            k = new k.c("TYPE_MESSAGE", 10, 10, 11);
            l = new k.c("TYPE_BYTES", 11, 11, 12);
            m = new k.c("TYPE_UINT32", 12, 12, 13);
            n = new k.c("TYPE_ENUM", 13, 13, 14);
            o = new k.c("TYPE_SFIXED32", 14, 14, 15);
            p = new k.c("TYPE_SFIXED64", 15, 15, 16);
            q = new k.c("TYPE_SINT32", 16, 16, 17);
            r = new k.c("TYPE_SINT64", 17, 17, 18);
            O = (new k.c[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r
            });
        }

        private k.c(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            M = j1;
            N = k1;
        }
    }

    public static interface l
        extends com.umeng.message.proguard.A
    {

        public abstract String A();

        public abstract com.umeng.message.proguard.g B();

        public abstract boolean C();

        public abstract String D();

        public abstract com.umeng.message.proguard.g E();

        public abstract boolean F();

        public abstract m G();

        public abstract n H();

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract boolean q();

        public abstract int r();

        public abstract boolean s();

        public abstract k.b t();

        public abstract boolean u();

        public abstract k.c v();

        public abstract boolean w();

        public abstract String x();

        public abstract com.umeng.message.proguard.g y();

        public abstract boolean z();
    }

    public static final class m extends p.d
        implements n
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public m c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new m(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
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
        private static final m i;
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

        static int a(m m1, int i1)
        {
            m1.k = i1;
            return i1;
        }

        public static a a(m m1)
        {
            return D().a(m1);
        }

        static b a(m m1, b b1)
        {
            m1.l = b1;
            return b1;
        }

        public static m a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (m)a.d(g1);
        }

        public static m a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (m)a.d(g1, n1);
        }

        public static m a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (m)a.d(h1);
        }

        public static m a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (m)a.b(h1, n1);
        }

        public static m a(InputStream inputstream)
            throws IOException
        {
            return (m)a.h(inputstream);
        }

        public static m a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (m)a.h(inputstream, n1);
        }

        public static m a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (m)a.d(abyte0);
        }

        public static m a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (m)a.d(abyte0, n1);
        }

        static Object a(m m1, Object obj)
        {
            m1.q = obj;
            return obj;
        }

        static List a(m m1, List list)
        {
            m1.s = list;
            return list;
        }

        static boolean a(m m1, boolean flag)
        {
            m1.n = flag;
            return flag;
        }

        public static m b(InputStream inputstream)
            throws IOException
        {
            return (m)a.f(inputstream);
        }

        public static m b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (m)a.f(inputstream, n1);
        }

        static Object b(m m1)
        {
            return m1.q;
        }

        static boolean b(m m1, boolean flag)
        {
            m1.o = flag;
            return flag;
        }

        static List c(m m1)
        {
            return m1.s;
        }

        static boolean c(m m1, boolean flag)
        {
            m1.p = flag;
            return flag;
        }

        static boolean d(m m1, boolean flag)
        {
            m1.r = flag;
            return flag;
        }

        public static m h()
        {
            return i;
        }

        public static final k.a k()
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

        public x.a M()
        {
            return F();
        }

        public x.a N()
        {
            return E();
        }

        public y.a O()
        {
            return F();
        }

        public y.a P()
        {
            return E();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public G a(int i1)
        {
            return (G)s.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
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
                i1.c(999, (com.umeng.message.proguard.y)s.get(j1));
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

        public H b(int i1)
        {
            return (H)s.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
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
                int k1 = com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)s.get(j1));
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

        public m i()
        {
            return i;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.y().a(com/umeng/message/proguard/j$m, com/umeng/message/proguard/j$m$a);
        }

        public com.umeng.message.proguard.B m()
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
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                q = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g x()
        {
            Object obj = q;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                q = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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
            i = new m(true);
            i.G();
        }

        private m(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            int i1;
            boolean flag;
            flag = false;
            super();
            t = -1;
            u = -1;
            G();
            a1 = com.umeng.message.proguard.P.b();
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
        //                       0: 680
        //                       8: 158
        //                       16: 334
        //                       24: 379
        //                       40: 425
        //                       74: 470
        //                       80: 516
        //                       7994: 562;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            if (!a(h1, a1, n1, j1))
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
            a1.a(1, j1);
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = l1;
            throw h1.a(this);
            h1;
            if ((k1 & 0x40) == 64)
            {
                s = Collections.unmodifiableList(s);
            }
            j = a1.b();
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
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
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
            s.add(h1.a(G.a, n1));
            i1 = j1;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i1 & 0x40) == 64)
            {
                s = Collections.unmodifiableList(s);
            }
            j = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L17; else goto _L16
_L16:
        }


        private m(p.c c1)
        {
            super(c1);
            t = -1;
            u = -1;
            j = c1.b_();
        }


        private m(boolean flag)
        {
            t = -1;
            u = -1;
            j = com.umeng.message.proguard.P.c();
        }
    }

    public static final class m.a extends p.c
        implements n
    {

        private int a;
        private m.b b;
        private boolean c;
        private boolean d;
        private boolean e;
        private Object f;
        private boolean g;
        private List h;
        private com.umeng.message.proguard.D i;

        static m.a T()
        {
            return V();
        }

        private void U()
        {
            if (com.umeng.message.proguard.p.m)
            {
                X();
            }
        }

        private static m.a V()
        {
            return new m.a();
        }

        private void W()
        {
            if ((a & 0x40) != 64)
            {
                h = new ArrayList(h);
                a = a | 0x40;
            }
        }

        private com.umeng.message.proguard.D X()
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
                i = new com.umeng.message.proguard.D(list, flag, aE(), aD());
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

        public m.a D()
        {
            return V().a(G());
        }

        public m E()
        {
            return m.h();
        }

        public m F()
        {
            m m1 = G();
            if (!m1.a())
            {
                throw b(m1);
            } else
            {
                return m1;
            }
        }

        public m G()
        {
            int j1 = 1;
            m m1 = new m(this);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            m.a(m1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            m.a(m1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            m.b(m1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            m.c(m1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            m.a(m1, f);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            m.d(m1, g);
            if (i == null)
            {
                if ((a & 0x40) == 64)
                {
                    h = Collections.unmodifiableList(h);
                    a = a & 0xffffffbf;
                }
                m.a(m1, h);
            } else
            {
                m.a(m1, i.f());
            }
            m.a(m1, i1);
            aB();
            return m1;
        }

        public m.a H()
        {
            a = a & -2;
            b = m.b.a;
            aF();
            return this;
        }

        public m.a I()
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

        public m.a K()
        {
            a = a & -5;
            d = false;
            aF();
            return this;
        }

        public m.a L()
        {
            a = a & -9;
            e = false;
            aF();
            return this;
        }

        public m.a M()
        {
            a = a & 0xffffffef;
            f = m.h().w();
            aF();
            return this;
        }

        public m.a N()
        {
            a = a & 0xffffffdf;
            g = false;
            aF();
            return this;
        }

        public m.a O()
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

        public G.a P()
        {
            return (G.a)X().b(G.h());
        }

        public com.umeng.message.proguard.y Q()
        {
            return E();
        }

        public com.umeng.message.proguard.x R()
        {
            return E();
        }

        public List S()
        {
            return X().h();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G a(int i1)
        {
            if (i == null)
            {
                return (G)h.get(i1);
            } else
            {
                return (G)i.a(i1);
            }
        }

        public m.a a(int i1, G.a a1)
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

        public m.a a(int i1, G g1)
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

        public m.a a(G.a a1)
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

        public m.a a(G g1)
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

        public m.a a(m.b b1)
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

        public m.a a(m m1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (m1 == m.h())
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
                f = m.b(m1);
                aF();
            }
            if (m1.y())
            {
                d(m1.z());
            }
            if (i != null) goto _L2; else goto _L1
_L1:
            if (!m.c(m1).isEmpty())
            {
                if (h.isEmpty())
                {
                    h = m.c(m1);
                    a = a & 0xffffffbf;
                } else
                {
                    W();
                    h.addAll(m.c(m1));
                }
                aF();
            }
_L4:
            a(((p.d) (m1)));
            d(m1.b_());
            return this;
_L2:
            if (!m.c(m1).isEmpty())
            {
                if (i.d())
                {
                    i.b();
                    i = null;
                    h = m.c(m1);
                    a = a & 0xffffffbf;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = X();
                    }
                    i = d1;
                } else
                {
                    i.a(m.c(m1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public m.a a(Iterable iterable)
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

        public m.a a(String s1)
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

        public m.a a(boolean flag)
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

        public com.umeng.message.proguard.x aj()
        {
            return G();
        }

        public com.umeng.message.proguard.x ak()
        {
            return F();
        }

        public com.umeng.message.proguard.y al()
        {
            return G();
        }

        public com.umeng.message.proguard.y am()
        {
            return F();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public H b(int i1)
        {
            if (i == null)
            {
                return (H)h.get(i1);
            } else
            {
                return (H)i.c(i1);
            }
        }

        public m.a b(int i1, G.a a1)
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

        public m.a b(int i1, G g1)
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

        public m.a b(boolean flag)
        {
            a = a | 4;
            d = flag;
            aF();
            return this;
        }

        public m.a c(int i1)
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

        public m.a c(boolean flag)
        {
            a = a | 8;
            e = flag;
            aF();
            return this;
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public G.a d(int i1)
        {
            return (G.a)X().b(i1);
        }

        public m.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof m)
            {
                return a((m)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public m.a d(boolean flag)
        {
            a = a | 0x20;
            g = flag;
            aF();
            return this;
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public G.a e(int i1)
        {
            return (G.a)X().c(i1, G.h());
        }

        public m.a e(com.umeng.message.proguard.g g1)
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

        public m.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (m)m.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (m)n1.a();
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

        public m.a m()
        {
            super.B();
            b = m.b.a;
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

        public m.b o()
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                f = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g x()
        {
            Object obj = f;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                f = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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

        private m.a()
        {
            b = m.b.a;
            f = "";
            h = Collections.emptyList();
            U();
        }

        private m.a(p.b b1)
        {
            super(b1);
            b = m.b.a;
            f = "";
            h = Collections.emptyList();
            U();
        }

    }

    public static final class m.b extends Enum
        implements com.umeng.message.proguard.C
    {

        public static final m.b a;
        public static final m.b b;
        public static final m.b c;
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 2;
        private static r.b g = new r.b() {

            public m.b a(int i1)
            {
                return m.b.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final m.b h[] = values();
        private static final m.b k[];
        private final int i;
        private final int j;

        public static m.b a(int i1)
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

        public static m.b a(k.e e1)
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
            return (k.d)m.k().k().get(0);
        }

        public static m.b valueOf(String s1)
        {
            return (m.b)Enum.valueOf(com/umeng/message/proguard/j$m$b, s1);
        }

        public static m.b[] values()
        {
            return (m.b[])k.clone();
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
            a = new m.b("STRING", 0, 0, 0);
            b = new m.b("CORD", 1, 1, 1);
            c = new m.b("STRING_PIECE", 2, 2, 2);
            k = (new m.b[] {
                a, b, c
            });
        }

        private m.b(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            i = j1;
            j = k1;
        }
    }

    public static interface n
        extends p.e
    {

        public abstract int C();

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract List d_();

        public abstract List e_();

        public abstract boolean n();

        public abstract m.b o();

        public abstract boolean p();

        public abstract boolean q();

        public abstract boolean r();

        public abstract boolean s();

        public abstract boolean t();

        public abstract boolean u();

        public abstract boolean v();

        public abstract String w();

        public abstract com.umeng.message.proguard.g x();

        public abstract boolean y();

        public abstract boolean z();
    }

    public static final class o extends com.umeng.message.proguard.p
        implements p
    {

        private static final long D = 0L;
        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public o c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new o(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 10;
        public static final int f = 11;
        public static final int g = 4;
        public static final int h = 5;
        public static final int i = 6;
        public static final int j = 7;
        public static final int k = 8;
        public static final int l = 9;
        private static final o n;
        private E A;
        private byte B;
        private int C;
        private final P o;
        private int p;
        private Object q;
        private Object r;
        private com.umeng.message.proguard.v s;
        private List t;
        private List u;
        private List v;
        private List w;
        private List x;
        private List y;
        private s z;

        public static a Z()
        {
            return a.az();
        }

        static int a(o o1, int i1)
        {
            o1.p = i1;
            return i1;
        }

        static E a(o o1, E e1)
        {
            o1.A = e1;
            return e1;
        }

        public static a a(o o1)
        {
            return Z().a(o1);
        }

        public static o a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (o)a.d(g1);
        }

        public static o a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (o)a.d(g1, n1);
        }

        public static o a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (o)a.d(h1);
        }

        public static o a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (o)a.b(h1, n1);
        }

        public static o a(InputStream inputstream)
            throws IOException
        {
            return (o)a.h(inputstream);
        }

        public static o a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (o)a.h(inputstream, n1);
        }

        public static o a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (o)a.d(abyte0);
        }

        public static o a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (o)a.d(abyte0, n1);
        }

        static s a(o o1, s s1)
        {
            o1.z = s1;
            return s1;
        }

        static com.umeng.message.proguard.v a(o o1, com.umeng.message.proguard.v v1)
        {
            o1.s = v1;
            return v1;
        }

        static Object a(o o1, Object obj)
        {
            o1.q = obj;
            return obj;
        }

        static List a(o o1, List list)
        {
            o1.t = list;
            return list;
        }

        private void ae()
        {
            q = "";
            r = "";
            s = com.umeng.message.proguard.u.a;
            t = Collections.emptyList();
            u = Collections.emptyList();
            v = Collections.emptyList();
            w = Collections.emptyList();
            x = Collections.emptyList();
            y = Collections.emptyList();
            z = s.h();
            A = E.h();
        }

        public static o b(InputStream inputstream)
            throws IOException
        {
            return (o)a.f(inputstream);
        }

        public static o b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (o)a.f(inputstream, n1);
        }

        static Object b(o o1)
        {
            return o1.q;
        }

        static Object b(o o1, Object obj)
        {
            o1.r = obj;
            return obj;
        }

        static List b(o o1, List list)
        {
            o1.u = list;
            return list;
        }

        static Object c(o o1)
        {
            return o1.r;
        }

        static List c(o o1, List list)
        {
            o1.v = list;
            return list;
        }

        static com.umeng.message.proguard.v d(o o1)
        {
            return o1.s;
        }

        static List d(o o1, List list)
        {
            o1.w = list;
            return list;
        }

        static List e(o o1)
        {
            return o1.t;
        }

        static List e(o o1, List list)
        {
            o1.x = list;
            return list;
        }

        static List f(o o1)
        {
            return o1.u;
        }

        static List f(o o1, List list)
        {
            o1.y = list;
            return list;
        }

        static List g(o o1)
        {
            return o1.v;
        }

        public static o h()
        {
            return n;
        }

        static List h(o o1)
        {
            return o1.w;
        }

        static List i(o o1)
        {
            return o1.x;
        }

        static List j(o o1)
        {
            return o1.y;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.d();
        }

        public List A()
        {
            return v;
        }

        public int B()
        {
            return v.size();
        }

        public List C()
        {
            return w;
        }

        public List D()
        {
            return w;
        }

        public int E()
        {
            return w.size();
        }

        public List F()
        {
            return x;
        }

        public List G()
        {
            return x;
        }

        public int H()
        {
            return x.size();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public List K()
        {
            return y;
        }

        public List L()
        {
            return y;
        }

        public x.a M()
        {
            return ab();
        }

        public x.a N()
        {
            return aa();
        }

        public y.a O()
        {
            return ab();
        }

        public y.a P()
        {
            return aa();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public int S()
        {
            return y.size();
        }

        public boolean T()
        {
            return (p & 4) == 4;
        }

        public s U()
        {
            return z;
        }

        public t V()
        {
            return z;
        }

        public boolean W()
        {
            return (p & 8) == 8;
        }

        public E X()
        {
            return A;
        }

        public F Y()
        {
            return A;
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public String a(int i1)
        {
            return (String)s.get(i1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            boolean flag = false;
            d();
            if ((p & 1) == 1)
            {
                i1.a(1, p());
            }
            if ((p & 2) == 2)
            {
                i1.a(2, s());
            }
            for (int j1 = 0; j1 < s.size(); j1++)
            {
                i1.a(3, s.c(j1));
            }

            for (int k1 = 0; k1 < v.size(); k1++)
            {
                i1.c(4, (com.umeng.message.proguard.y)v.get(k1));
            }

            for (int l1 = 0; l1 < w.size(); l1++)
            {
                i1.c(5, (com.umeng.message.proguard.y)w.get(l1));
            }

            for (int i2 = 0; i2 < x.size(); i2++)
            {
                i1.c(6, (com.umeng.message.proguard.y)x.get(i2));
            }

            for (int j2 = 0; j2 < y.size(); j2++)
            {
                i1.c(7, (com.umeng.message.proguard.y)y.get(j2));
            }

            if ((p & 4) == 4)
            {
                i1.c(8, z);
            }
            if ((p & 8) == 8)
            {
                i1.c(9, A);
            }
            int k2 = 0;
            int l2;
            do
            {
                l2 = ((flag) ? 1 : 0);
                if (k2 >= t.size())
                {
                    break;
                }
                i1.a(10, ((Integer)t.get(k2)).intValue());
                k2++;
            } while (true);
            for (; l2 < u.size(); l2++)
            {
                i1.a(11, ((Integer)u.get(l2)).intValue());
            }

            b_().a(i1);
        }

        public final boolean a()
        {
            boolean flag = true;
            byte byte0 = B;
            if (byte0 != -1)
            {
                if (byte0 != 1)
                {
                    flag = false;
                }
                return flag;
            }
            for (int i1 = 0; i1 < B(); i1++)
            {
                if (!e(i1).a())
                {
                    B = 0;
                    return false;
                }
            }

            for (int j1 = 0; j1 < E(); j1++)
            {
                if (!g(j1).a())
                {
                    B = 0;
                    return false;
                }
            }

            for (int k1 = 0; k1 < H(); k1++)
            {
                if (!i(k1).a())
                {
                    B = 0;
                    return false;
                }
            }

            for (int l1 = 0; l1 < S(); l1++)
            {
                if (!k(l1).a())
                {
                    B = 0;
                    return false;
                }
            }

            if (T() && !U().a())
            {
                B = 0;
                return false;
            } else
            {
                B = 1;
                return true;
            }
        }

        public a aa()
        {
            return Z();
        }

        public a ab()
        {
            return a(this);
        }

        public com.umeng.message.proguard.g b(int i1)
        {
            return s.c(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return o;
        }

        public int c(int i1)
        {
            return ((Integer)t.get(i1)).intValue();
        }

        public int d()
        {
            int l1 = 0;
            int i1 = C;
            if (i1 != -1)
            {
                return i1;
            }
            int j1;
            int k1;
            int i2;
            if ((p & 1) == 1)
            {
                i1 = com.umeng.message.proguard.i.c(1, p()) + 0;
            } else
            {
                i1 = 0;
            }
            j1 = i1;
            if ((p & 2) == 2)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(2, s());
            }
            k1 = 0;
            i1 = 0;
            for (; k1 < s.size(); k1++)
            {
                i1 += com.umeng.message.proguard.i.b(s.c(k1));
            }

            i2 = t().size();
            k1 = 0;
            i1 = j1 + i1 + i2 * 1;
            for (j1 = k1; j1 < v.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(4, (com.umeng.message.proguard.y)v.get(j1));
            }

            for (j1 = 0; j1 < w.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(5, (com.umeng.message.proguard.y)w.get(j1));
            }

            for (j1 = 0; j1 < x.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(6, (com.umeng.message.proguard.y)x.get(j1));
            }

            for (j1 = 0; j1 < y.size(); j1++)
            {
                i1 += com.umeng.message.proguard.i.g(7, (com.umeng.message.proguard.y)y.get(j1));
            }

            j1 = i1;
            if ((p & 4) == 4)
            {
                j1 = i1 + com.umeng.message.proguard.i.g(8, z);
            }
            i1 = j1;
            if ((p & 8) == 8)
            {
                i1 = j1 + com.umeng.message.proguard.i.g(9, A);
            }
            k1 = 0;
            j1 = 0;
            for (; k1 < t.size(); k1++)
            {
                j1 += com.umeng.message.proguard.i.h(((Integer)t.get(k1)).intValue());
            }

            i2 = v().size();
            int j2;
            for (k1 = 0; l1 < u.size(); k1 = j2 + k1)
            {
                j2 = com.umeng.message.proguard.i.h(((Integer)u.get(l1)).intValue());
                l1++;
            }

            i1 = i1 + j1 + i2 * 1 + k1 + x().size() * 1 + b_().d();
            C = i1;
            return i1;
        }

        public int d(int i1)
        {
            return ((Integer)u.get(i1)).intValue();
        }

        public a e(int i1)
        {
            return (a)v.get(i1);
        }

        public b f(int i1)
        {
            return (b)v.get(i1);
        }

        public c g(int i1)
        {
            return (c)w.get(i1);
        }

        public d h(int i1)
        {
            return (d)w.get(i1);
        }

        public A i(int i1)
        {
            return (A)x.get(i1);
        }

        public o i()
        {
            return n;
        }

        public B j(int i1)
        {
            return (B)x.get(i1);
        }

        public k k(int i1)
        {
            return (k)y.get(i1);
        }

        public l l(int i1)
        {
            return (l)y.get(i1);
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.e().a(com/umeng/message/proguard/j$o, com/umeng/message/proguard/j$o$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (p & 1) == 1;
        }

        public String o()
        {
            Object obj = q;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                q = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = q;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                q = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean q()
        {
            return (p & 2) == 2;
        }

        public String r()
        {
            Object obj = r;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                r = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = r;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                r = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public List t()
        {
            return s;
        }

        public int u()
        {
            return s.size();
        }

        public List v()
        {
            return t;
        }

        public int w()
        {
            return t.size();
        }

        public List x()
        {
            return u;
        }

        public int y()
        {
            return u.size();
        }

        public List z()
        {
            return v;
        }

        static 
        {
            n = new o(true);
            n.ae();
        }

        private o(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            int i1;
            int j1;
            B = -1;
            C = -1;
            ae();
            i1 = 0;
            a1 = com.umeng.message.proguard.P.b();
            j1 = 0;
_L73:
            if (j1 != 0) goto _L2; else goto _L1
_L1:
            int k1 = i1;
            int j2 = h1.a();
            j2;
            JVM INSTR lookupswitch 14: default 1747
        //                       0: 1765
        //                       10: 199
        //                       18: 240
        //                       26: 281
        //                       34: 346
        //                       42: 419
        //                       50: 492
        //                       58: 568
        //                       66: 644
        //                       74: 747
        //                       80: 853
        //                       82: 925
        //                       88: 1242
        //                       90: 1314;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L3:
            k1 = i1;
            Object obj;
            int k2;
            int l2;
            if (!a(h1, a1, n1, j2))
            {
                k1 = 1;
                j1 = i1;
                i1 = k1;
            } else
            {
                int l1 = i1;
                i1 = j1;
                j1 = l1;
            }
              goto _L18
_L5:
            k1 = i1;
            p = p | 1;
            k1 = i1;
            q = h1.l();
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L18
_L6:
            k1 = i1;
            p = p | 2;
            k1 = i1;
            r = h1.l();
            k1 = i1;
            i1 = j1;
            j1 = k1;
              goto _L18
_L7:
            if ((i1 & 4) == 4) goto _L20; else goto _L19
_L19:
            k1 = i1;
            s = new com.umeng.message.proguard.u();
            k2 = i1 | 4;
_L72:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            s.a(h1.l());
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L8:
            if ((i1 & 0x20) == 32) goto _L22; else goto _L21
_L21:
            k1 = i1;
            v = new ArrayList();
            k2 = i1 | 0x20;
_L71:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            v.add(h1.a(a.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L9:
            if ((i1 & 0x40) == 64) goto _L24; else goto _L23
_L23:
            k1 = i1;
            w = new ArrayList();
            k2 = i1 | 0x40;
_L69:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            w.add(h1.a(c.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L10:
            if ((i1 & 0x80) == 128) goto _L26; else goto _L25
_L25:
            k1 = i1;
            x = new ArrayList();
            k2 = i1 | 0x80;
_L67:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            x.add(h1.a(A.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L11:
            if ((i1 & 0x100) == 256) goto _L28; else goto _L27
_L27:
            k1 = i1;
            y = new ArrayList();
            k2 = i1 | 0x100;
_L65:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            y.add(h1.a(k.a, n1));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L12:
            k1 = i1;
            if ((p & 4) != 4) goto _L30; else goto _L29
_L29:
            k1 = i1;
            obj = z.V();
_L63:
            k1 = i1;
            z = (s)h1.a(s.a, n1);
            if (obj == null) goto _L32; else goto _L31
_L31:
            k1 = i1;
            ((s.a) (obj)).a(z);
            k1 = i1;
            z = ((s.a) (obj)).O();
_L32:
            k1 = i1;
            p = p | 4;
            k1 = i1;
            i1 = j1;
            j1 = k1;
            break; /* Loop/switch isn't completed */
_L13:
            k1 = i1;
            if ((p & 8) != 8) goto _L34; else goto _L33
_L33:
            k1 = i1;
            obj = A.s();
_L61:
            k1 = i1;
            A = (E)h1.a(E.a, n1);
            if (obj == null) goto _L36; else goto _L35
_L35:
            k1 = i1;
            ((E.a) (obj)).a(A);
            k1 = i1;
            A = ((E.a) (obj)).t();
_L36:
            k1 = i1;
            p = p | 8;
            k1 = i1;
            i1 = j1;
            j1 = k1;
            break; /* Loop/switch isn't completed */
_L14:
            if ((i1 & 8) == 8) goto _L38; else goto _L37
_L37:
            k1 = i1;
            t = new ArrayList();
            k2 = i1 | 8;
_L59:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            t.add(Integer.valueOf(h1.g()));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L15:
            k1 = i1;
            l2 = h1.f(h1.s());
            if ((i1 & 8) == 8) goto _L40; else goto _L39
_L39:
            k1 = i1;
            if (h1.x() <= 0) goto _L40; else goto _L41
_L41:
            k1 = i1;
            t = new ArrayList();
            k2 = i1 | 8;
_L57:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            if (h1.x() <= 0) goto _L43; else goto _L42
_L42:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            t.add(Integer.valueOf(h1.g()));
            continue; /* Loop/switch isn't completed */
            h1;
_L54:
            k1 = i1;
            throw h1.a(this);
            h1;
_L52:
            if ((k1 & 4) == 4)
            {
                s = new Q(s);
            }
            if ((k1 & 0x20) == 32)
            {
                v = Collections.unmodifiableList(v);
            }
            if ((k1 & 0x40) == 64)
            {
                w = Collections.unmodifiableList(w);
            }
            if ((k1 & 0x80) == 128)
            {
                x = Collections.unmodifiableList(x);
            }
            if ((k1 & 0x100) == 256)
            {
                y = Collections.unmodifiableList(y);
            }
            if ((k1 & 8) == 8)
            {
                t = Collections.unmodifiableList(t);
            }
            if ((k1 & 0x10) == 16)
            {
                u = Collections.unmodifiableList(u);
            }
            o = a1.b();
            ad();
            throw h1;
_L43:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            h1.g(l2);
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L16:
            if ((i1 & 0x10) == 16) goto _L45; else goto _L44
_L44:
            k1 = i1;
            u = new ArrayList();
            k2 = i1 | 0x10;
_L55:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            u.add(Integer.valueOf(h1.g()));
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L17:
            k1 = i1;
            l2 = h1.f(h1.s());
            if ((i1 & 0x10) == 16) goto _L47; else goto _L46
_L46:
            k1 = i1;
            if (h1.x() <= 0) goto _L47; else goto _L48
_L48:
            k1 = i1;
            u = new ArrayList();
            k2 = i1 | 0x10;
_L51:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            if (h1.x() <= 0) goto _L50; else goto _L49
_L49:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            u.add(Integer.valueOf(h1.g()));
              goto _L51
            h1;
            i1 = k1;
_L53:
            k1 = i1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L50:
            i1 = k2;
            k1 = k2;
            j2 = k2;
            h1.g(l2);
            i1 = j1;
            j1 = k2;
            break; /* Loop/switch isn't completed */
_L2:
            if ((i1 & 4) == 4)
            {
                s = new Q(s);
            }
            if ((i1 & 0x20) == 32)
            {
                v = Collections.unmodifiableList(v);
            }
            if ((i1 & 0x40) == 64)
            {
                w = Collections.unmodifiableList(w);
            }
            if ((i1 & 0x80) == 128)
            {
                x = Collections.unmodifiableList(x);
            }
            if ((i1 & 0x100) == 256)
            {
                y = Collections.unmodifiableList(y);
            }
            if ((i1 & 8) == 8)
            {
                t = Collections.unmodifiableList(t);
            }
            if ((i1 & 0x10) == 16)
            {
                u = Collections.unmodifiableList(u);
            }
            o = a1.b();
            ad();
            return;
            h1;
            k1 = j2;
              goto _L52
            h1;
              goto _L53
            h1;
              goto _L54
_L47:
            k2 = i1;
              goto _L51
_L45:
            k2 = i1;
              goto _L55
_L40:
            k2 = i1;
            if (true) goto _L57; else goto _L56
_L56:
            break; /* Loop/switch isn't completed */
_L38:
            k2 = i1;
            if (true) goto _L59; else goto _L58
_L58:
            break; /* Loop/switch isn't completed */
_L34:
            obj = null;
            if (true) goto _L61; else goto _L60
_L60:
            break; /* Loop/switch isn't completed */
_L30:
            obj = null;
            if (true) goto _L63; else goto _L62
_L62:
            break; /* Loop/switch isn't completed */
_L28:
            k2 = i1;
            if (true) goto _L65; else goto _L64
_L64:
            break; /* Loop/switch isn't completed */
_L26:
            k2 = i1;
            if (true) goto _L67; else goto _L66
_L66:
            break; /* Loop/switch isn't completed */
_L24:
            k2 = i1;
            if (true) goto _L69; else goto _L68
_L68:
            break; /* Loop/switch isn't completed */
_L22:
            k2 = i1;
            if (true) goto _L71; else goto _L70
_L70:
            break; /* Loop/switch isn't completed */
_L20:
            k2 = i1;
            if (true) goto _L72; else goto _L18
_L18:
            int i2 = j1;
            j1 = i1;
            i1 = i2;
              goto _L73
_L4:
            boolean flag = true;
            j1 = i1;
            i1 = ((flag) ? 1 : 0);
              goto _L18
        }


        private o(p.a a1)
        {
            super(a1);
            B = -1;
            C = -1;
            o = a1.b_();
        }


        private o(boolean flag)
        {
            B = -1;
            C = -1;
            o = com.umeng.message.proguard.P.c();
        }
    }

    public static final class o.a extends p.a
        implements p
    {

        private int a;
        private Object b;
        private Object c;
        private com.umeng.message.proguard.v d;
        private List e;
        private List f;
        private List g;
        private com.umeng.message.proguard.D h;
        private List i;
        private com.umeng.message.proguard.D j;
        private List k;
        private com.umeng.message.proguard.D l;
        private List m;
        private com.umeng.message.proguard.D n;
        private s o;
        private L p;
        private E q;
        private L r;

        private void aG()
        {
            if (com.umeng.message.proguard.p.m)
            {
                aM();
                aO();
                aQ();
                aS();
                aT();
                aU();
            }
        }

        private static o.a aH()
        {
            return new o.a();
        }

        private void aI()
        {
            if ((a & 4) != 4)
            {
                d = new com.umeng.message.proguard.u(d);
                a = a | 4;
            }
        }

        private void aJ()
        {
            if ((a & 8) != 8)
            {
                e = new ArrayList(e);
                a = a | 8;
            }
        }

        private void aK()
        {
            if ((a & 0x10) != 16)
            {
                f = new ArrayList(f);
                a = a | 0x10;
            }
        }

        private void aL()
        {
            if ((a & 0x20) != 32)
            {
                g = new ArrayList(g);
                a = a | 0x20;
            }
        }

        private com.umeng.message.proguard.D aM()
        {
            if (h == null)
            {
                List list = g;
                boolean flag;
                if ((a & 0x20) == 32)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                h = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                g = null;
            }
            return h;
        }

        private void aN()
        {
            if ((a & 0x40) != 64)
            {
                i = new ArrayList(i);
                a = a | 0x40;
            }
        }

        private com.umeng.message.proguard.D aO()
        {
            if (j == null)
            {
                List list = i;
                boolean flag;
                if ((a & 0x40) == 64)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                i = null;
            }
            return j;
        }

        private void aP()
        {
            if ((a & 0x80) != 128)
            {
                k = new ArrayList(k);
                a = a | 0x80;
            }
        }

        private com.umeng.message.proguard.D aQ()
        {
            if (l == null)
            {
                List list = k;
                boolean flag;
                if ((a & 0x80) == 128)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                l = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                k = null;
            }
            return l;
        }

        private void aR()
        {
            if ((a & 0x100) != 256)
            {
                m = new ArrayList(m);
                a = a | 0x100;
            }
        }

        private com.umeng.message.proguard.D aS()
        {
            if (n == null)
            {
                List list = m;
                boolean flag;
                if ((a & 0x100) == 256)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                n = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                m = null;
            }
            return n;
        }

        private L aT()
        {
            if (p == null)
            {
                p = new L(o, aE(), aD());
                o = null;
            }
            return p;
        }

        private L aU()
        {
            if (r == null)
            {
                r = new L(q, aE(), aD());
                q = null;
            }
            return r;
        }

        static o.a az()
        {
            return aH();
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.d();
        }

        public List A()
        {
            if (h != null)
            {
                return h.i();
            } else
            {
                return Collections.unmodifiableList(g);
            }
        }

        public int B()
        {
            if (h == null)
            {
                return g.size();
            } else
            {
                return h.c();
            }
        }

        public List C()
        {
            if (j == null)
            {
                return Collections.unmodifiableList(i);
            } else
            {
                return j.g();
            }
        }

        public List D()
        {
            if (j != null)
            {
                return j.i();
            } else
            {
                return Collections.unmodifiableList(i);
            }
        }

        public int E()
        {
            if (j == null)
            {
                return i.size();
            } else
            {
                return j.c();
            }
        }

        public List F()
        {
            if (l == null)
            {
                return Collections.unmodifiableList(k);
            } else
            {
                return l.g();
            }
        }

        public List G()
        {
            if (l != null)
            {
                return l.i();
            } else
            {
                return Collections.unmodifiableList(k);
            }
        }

        public int H()
        {
            if (l == null)
            {
                return k.size();
            } else
            {
                return l.c();
            }
        }

        public o.a I()
        {
            return aH().a(O());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.d();
        }

        public List K()
        {
            if (n == null)
            {
                return Collections.unmodifiableList(m);
            } else
            {
                return n.g();
            }
        }

        public List L()
        {
            if (n != null)
            {
                return n.i();
            } else
            {
                return Collections.unmodifiableList(m);
            }
        }

        public o M()
        {
            return o.h();
        }

        public o N()
        {
            o o1 = O();
            if (!o1.a())
            {
                throw b(o1);
            } else
            {
                return o1;
            }
        }

        public o O()
        {
            int i1 = 1;
            o o1 = new o(this);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            o.a(o1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            o.b(o1, c);
            if ((a & 4) == 4)
            {
                d = new Q(d);
                a = a & -5;
            }
            o.a(o1, d);
            if ((a & 8) == 8)
            {
                e = Collections.unmodifiableList(e);
                a = a & -9;
            }
            o.a(o1, e);
            if ((a & 0x10) == 16)
            {
                f = Collections.unmodifiableList(f);
                a = a & 0xffffffef;
            }
            o.b(o1, f);
            if (h == null)
            {
                if ((a & 0x20) == 32)
                {
                    g = Collections.unmodifiableList(g);
                    a = a & 0xffffffdf;
                }
                o.c(o1, g);
            } else
            {
                o.c(o1, h.f());
            }
            if (j == null)
            {
                if ((a & 0x40) == 64)
                {
                    i = Collections.unmodifiableList(i);
                    a = a & 0xffffffbf;
                }
                o.d(o1, i);
            } else
            {
                o.d(o1, j.f());
            }
            if (l == null)
            {
                if ((a & 0x80) == 128)
                {
                    k = Collections.unmodifiableList(k);
                    a = a & 0xffffff7f;
                }
                o.e(o1, k);
            } else
            {
                o.e(o1, l.f());
            }
            if (n == null)
            {
                if ((a & 0x100) == 256)
                {
                    m = Collections.unmodifiableList(m);
                    a = a & 0xfffffeff;
                }
                o.f(o1, m);
            } else
            {
                o.f(o1, n.f());
            }
            if ((k1 & 0x200) == 512)
            {
                i1 = j1 | 4;
            } else
            {
                i1 = j1;
            }
            if (p == null)
            {
                o.a(o1, o);
            } else
            {
                o.a(o1, (s)p.d());
            }
            j1 = i1;
            if ((k1 & 0x400) == 1024)
            {
                j1 = i1 | 8;
            }
            if (r == null)
            {
                o.a(o1, q);
            } else
            {
                o.a(o1, (E)r.d());
            }
            o.a(o1, j1);
            aB();
            return o1;
        }

        public o.a P()
        {
            a = a & -2;
            b = o.h().o();
            aF();
            return this;
        }

        public com.umeng.message.proguard.y Q()
        {
            return M();
        }

        public com.umeng.message.proguard.x R()
        {
            return M();
        }

        public int S()
        {
            if (n == null)
            {
                return m.size();
            } else
            {
                return n.c();
            }
        }

        public boolean T()
        {
            return (a & 0x200) == 512;
        }

        public s U()
        {
            if (p == null)
            {
                return o;
            } else
            {
                return (s)p.c();
            }
        }

        public t V()
        {
            if (p != null)
            {
                return (t)p.f();
            } else
            {
                return o;
            }
        }

        public boolean W()
        {
            return (a & 0x400) == 1024;
        }

        public E X()
        {
            if (r == null)
            {
                return q;
            } else
            {
                return (E)r.c();
            }
        }

        public F Y()
        {
            if (r != null)
            {
                return (F)r.f();
            } else
            {
                return q;
            }
        }

        public o.a Z()
        {
            a = a & -3;
            c = o.h().r();
            aF();
            return this;
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public o.a a(int i1, int j1)
        {
            aJ();
            e.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public o.a a(int i1, A.a a1)
        {
            if (l == null)
            {
                aP();
                k.set(i1, a1.y());
                aF();
                return this;
            } else
            {
                l.a(i1, a1.y());
                return this;
            }
        }

        public o.a a(int i1, A a1)
        {
            if (l == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aP();
                    k.set(i1, a1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(i1, a1);
                return this;
            }
        }

        public o.a a(int i1, a.a a1)
        {
            if (h == null)
            {
                aL();
                g.set(i1, a1.L());
                aF();
                return this;
            } else
            {
                h.a(i1, a1.L());
                return this;
            }
        }

        public o.a a(int i1, a a1)
        {
            if (h == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aL();
                    g.set(i1, a1);
                    aF();
                    return this;
                }
            } else
            {
                h.a(i1, a1);
                return this;
            }
        }

        public o.a a(int i1, c.a a1)
        {
            if (j == null)
            {
                aN();
                i.set(i1, a1.y());
                aF();
                return this;
            } else
            {
                j.a(i1, a1.y());
                return this;
            }
        }

        public o.a a(int i1, c c1)
        {
            if (j == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aN();
                    i.set(i1, c1);
                    aF();
                    return this;
                }
            } else
            {
                j.a(i1, c1);
                return this;
            }
        }

        public o.a a(int i1, k.a a1)
        {
            if (n == null)
            {
                aR();
                m.set(i1, a1.L());
                aF();
                return this;
            } else
            {
                n.a(i1, a1.L());
                return this;
            }
        }

        public o.a a(int i1, k k1)
        {
            if (n == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aR();
                    m.set(i1, k1);
                    aF();
                    return this;
                }
            } else
            {
                n.a(i1, k1);
                return this;
            }
        }

        public o.a a(int i1, String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aI();
                d.set(i1, s1);
                aF();
                return this;
            }
        }

        public o.a a(A.a a1)
        {
            if (l == null)
            {
                aP();
                k.add(a1.y());
                aF();
                return this;
            } else
            {
                l.a(a1.y());
                return this;
            }
        }

        public o.a a(A a1)
        {
            if (l == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aP();
                    k.add(a1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(a1);
                return this;
            }
        }

        public o.a a(E.a a1)
        {
            if (r == null)
            {
                q = a1.s();
                aF();
            } else
            {
                r.a(a1.s());
            }
            a = a | 0x400;
            return this;
        }

        public o.a a(E e1)
        {
            if (r == null)
            {
                if (e1 == null)
                {
                    throw new NullPointerException();
                }
                q = e1;
                aF();
            } else
            {
                r.a(e1);
            }
            a = a | 0x400;
            return this;
        }

        public o.a a(a.a a1)
        {
            if (h == null)
            {
                aL();
                g.add(a1.L());
                aF();
                return this;
            } else
            {
                h.a(a1.L());
                return this;
            }
        }

        public o.a a(a a1)
        {
            if (h == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aL();
                    g.add(a1);
                    aF();
                    return this;
                }
            } else
            {
                h.a(a1);
                return this;
            }
        }

        public o.a a(c.a a1)
        {
            if (j == null)
            {
                aN();
                i.add(a1.y());
                aF();
                return this;
            } else
            {
                j.a(a1.y());
                return this;
            }
        }

        public o.a a(c c1)
        {
            if (j == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aN();
                    i.add(c1);
                    aF();
                    return this;
                }
            } else
            {
                j.a(c1);
                return this;
            }
        }

        public o.a a(k.a a1)
        {
            if (n == null)
            {
                aR();
                m.add(a1.L());
                aF();
                return this;
            } else
            {
                n.a(a1.L());
                return this;
            }
        }

        public o.a a(k k1)
        {
            if (n == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aR();
                    m.add(k1);
                    aF();
                    return this;
                }
            } else
            {
                n.a(k1);
                return this;
            }
        }

        public o.a a(o o1)
        {
            Object obj = null;
            if (o1 == o.h())
            {
                return this;
            }
            if (o1.n())
            {
                a = a | 1;
                b = o.b(o1);
                aF();
            }
            if (o1.q())
            {
                a = a | 2;
                c = o.c(o1);
                aF();
            }
            if (!o.d(o1).isEmpty())
            {
                if (d.isEmpty())
                {
                    d = o.d(o1);
                    a = a & -5;
                } else
                {
                    aI();
                    d.addAll(o.d(o1));
                }
                aF();
            }
            if (!o.e(o1).isEmpty())
            {
                if (e.isEmpty())
                {
                    e = o.e(o1);
                    a = a & -9;
                } else
                {
                    aJ();
                    e.addAll(o.e(o1));
                }
                aF();
            }
            if (!o.f(o1).isEmpty())
            {
                if (f.isEmpty())
                {
                    f = o.f(o1);
                    a = a & 0xffffffef;
                } else
                {
                    aK();
                    f.addAll(o.f(o1));
                }
                aF();
            }
            if (h == null)
            {
                if (!o.g(o1).isEmpty())
                {
                    if (g.isEmpty())
                    {
                        g = o.g(o1);
                        a = a & 0xffffffdf;
                    } else
                    {
                        aL();
                        g.addAll(o.g(o1));
                    }
                    aF();
                }
            } else
            if (!o.g(o1).isEmpty())
            {
                if (h.d())
                {
                    h.b();
                    h = null;
                    g = o.g(o1);
                    a = a & 0xffffffdf;
                    com.umeng.message.proguard.D d1;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = aM();
                    } else
                    {
                        d1 = null;
                    }
                    h = d1;
                } else
                {
                    h.a(o.g(o1));
                }
            }
            if (j == null)
            {
                if (!o.h(o1).isEmpty())
                {
                    if (i.isEmpty())
                    {
                        i = o.h(o1);
                        a = a & 0xffffffbf;
                    } else
                    {
                        aN();
                        i.addAll(o.h(o1));
                    }
                    aF();
                }
            } else
            if (!o.h(o1).isEmpty())
            {
                if (j.d())
                {
                    j.b();
                    j = null;
                    i = o.h(o1);
                    a = a & 0xffffffbf;
                    com.umeng.message.proguard.D d2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d2 = aO();
                    } else
                    {
                        d2 = null;
                    }
                    j = d2;
                } else
                {
                    j.a(o.h(o1));
                }
            }
            if (l == null)
            {
                if (!o.i(o1).isEmpty())
                {
                    if (k.isEmpty())
                    {
                        k = o.i(o1);
                        a = a & 0xffffff7f;
                    } else
                    {
                        aP();
                        k.addAll(o.i(o1));
                    }
                    aF();
                }
            } else
            if (!o.i(o1).isEmpty())
            {
                if (l.d())
                {
                    l.b();
                    l = null;
                    k = o.i(o1);
                    a = a & 0xffffff7f;
                    com.umeng.message.proguard.D d3;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d3 = aQ();
                    } else
                    {
                        d3 = null;
                    }
                    l = d3;
                } else
                {
                    l.a(o.i(o1));
                }
            }
            if (n == null)
            {
                if (!o.j(o1).isEmpty())
                {
                    if (m.isEmpty())
                    {
                        m = o.j(o1);
                        a = a & 0xfffffeff;
                    } else
                    {
                        aR();
                        m.addAll(o.j(o1));
                    }
                    aF();
                }
            } else
            if (!o.j(o1).isEmpty())
            {
                if (n.d())
                {
                    n.b();
                    n = null;
                    m = o.j(o1);
                    a = a & 0xfffffeff;
                    com.umeng.message.proguard.D d4 = obj;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d4 = aS();
                    }
                    n = d4;
                } else
                {
                    n.a(o.j(o1));
                }
            }
            if (o1.T())
            {
                b(o1.U());
            }
            if (o1.W())
            {
                b(o1.X());
            }
            d(o1.b_());
            return this;
        }

        public o.a a(s.a a1)
        {
            if (p == null)
            {
                o = a1.N();
                aF();
            } else
            {
                p.a(a1.N());
            }
            a = a | 0x200;
            return this;
        }

        public o.a a(s s1)
        {
            if (p == null)
            {
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                o = s1;
                aF();
            } else
            {
                p.a(s1);
            }
            a = a | 0x200;
            return this;
        }

        public o.a a(Iterable iterable)
        {
            aI();
            com.umeng.message.proguard.p.a.a(iterable, d);
            aF();
            return this;
        }

        public o.a a(String s1)
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

        public String a(int i1)
        {
            return (String)d.get(i1);
        }

        public final boolean a()
        {
            int i1 = 0;
_L13:
            if (i1 >= B()) goto _L2; else goto _L1
_L1:
            if (e(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            i1 = 0;
_L6:
            if (i1 >= E())
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (!g(i1).a()) goto _L3; else goto _L5
_L5:
            i1++;
              goto _L6
            i1 = 0;
_L8:
            if (i1 >= H())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            if (!i(i1).a()) goto _L3; else goto _L7
_L7:
            i1++;
              goto _L8
            i1 = 0;
_L10:
            if (i1 >= S())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!k(i1).a()) goto _L3; else goto _L9
_L9:
            i1++;
              goto _L10
            if (T() && !U().a()) goto _L3; else goto _L11
_L11:
            return true;
            if (true) goto _L13; else goto _L12
_L12:
        }

        public o.a aa()
        {
            d = com.umeng.message.proguard.u.a;
            a = a & -5;
            aF();
            return this;
        }

        public o.a ab()
        {
            e = Collections.emptyList();
            a = a & -9;
            aF();
            return this;
        }

        public o.a ac()
        {
            f = Collections.emptyList();
            a = a & 0xffffffef;
            aF();
            return this;
        }

        public o.a ad()
        {
            if (h == null)
            {
                g = Collections.emptyList();
                a = a & 0xffffffdf;
                aF();
                return this;
            } else
            {
                h.e();
                return this;
            }
        }

        public a.a ae()
        {
            return (a.a)aM().b(a.h());
        }

        public List af()
        {
            return aM().h();
        }

        public o.a ag()
        {
            if (j == null)
            {
                i = Collections.emptyList();
                a = a & 0xffffffbf;
                aF();
                return this;
            } else
            {
                j.e();
                return this;
            }
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return I();
        }

        public com.umeng.message.proguard.x aj()
        {
            return O();
        }

        public com.umeng.message.proguard.x ak()
        {
            return N();
        }

        public com.umeng.message.proguard.y al()
        {
            return O();
        }

        public com.umeng.message.proguard.y am()
        {
            return N();
        }

        public c.a an()
        {
            return (c.a)aO().b(c.h());
        }

        public List ao()
        {
            return aO().h();
        }

        public o.a ap()
        {
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xffffff7f;
                aF();
                return this;
            } else
            {
                l.e();
                return this;
            }
        }

        public A.a aq()
        {
            return (A.a)aQ().b(A.h());
        }

        public List ar()
        {
            return aQ().h();
        }

        public o.a as()
        {
            if (n == null)
            {
                m = Collections.emptyList();
                a = a & 0xfffffeff;
                aF();
                return this;
            } else
            {
                n.e();
                return this;
            }
        }

        public k.a at()
        {
            return (k.a)aS().b(k.h());
        }

        public List au()
        {
            return aS().h();
        }

        public o.a av()
        {
            if (p == null)
            {
                o = s.h();
                aF();
            } else
            {
                p.g();
            }
            a = a & 0xfffffdff;
            return this;
        }

        public s.a aw()
        {
            a = a | 0x200;
            aF();
            return (s.a)aT().e();
        }

        public o.a ax()
        {
            if (r == null)
            {
                q = E.h();
                aF();
            } else
            {
                r.g();
            }
            a = a & 0xfffffbff;
            return this;
        }

        public E.a ay()
        {
            a = a | 0x400;
            aF();
            return (E.a)aU().e();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public com.umeng.message.proguard.g b(int i1)
        {
            return d.c(i1);
        }

        public o.a b(int i1, int j1)
        {
            aK();
            f.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public o.a b(int i1, A.a a1)
        {
            if (l == null)
            {
                aP();
                k.add(i1, a1.y());
                aF();
                return this;
            } else
            {
                l.b(i1, a1.y());
                return this;
            }
        }

        public o.a b(int i1, A a1)
        {
            if (l == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aP();
                    k.add(i1, a1);
                    aF();
                    return this;
                }
            } else
            {
                l.b(i1, a1);
                return this;
            }
        }

        public o.a b(int i1, a.a a1)
        {
            if (h == null)
            {
                aL();
                g.add(i1, a1.L());
                aF();
                return this;
            } else
            {
                h.b(i1, a1.L());
                return this;
            }
        }

        public o.a b(int i1, a a1)
        {
            if (h == null)
            {
                if (a1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aL();
                    g.add(i1, a1);
                    aF();
                    return this;
                }
            } else
            {
                h.b(i1, a1);
                return this;
            }
        }

        public o.a b(int i1, c.a a1)
        {
            if (j == null)
            {
                aN();
                i.add(i1, a1.y());
                aF();
                return this;
            } else
            {
                j.b(i1, a1.y());
                return this;
            }
        }

        public o.a b(int i1, c c1)
        {
            if (j == null)
            {
                if (c1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aN();
                    i.add(i1, c1);
                    aF();
                    return this;
                }
            } else
            {
                j.b(i1, c1);
                return this;
            }
        }

        public o.a b(int i1, k.a a1)
        {
            if (n == null)
            {
                aR();
                m.add(i1, a1.L());
                aF();
                return this;
            } else
            {
                n.b(i1, a1.L());
                return this;
            }
        }

        public o.a b(int i1, k k1)
        {
            if (n == null)
            {
                if (k1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    aR();
                    m.add(i1, k1);
                    aF();
                    return this;
                }
            } else
            {
                n.b(i1, k1);
                return this;
            }
        }

        public o.a b(E e1)
        {
            if (r == null)
            {
                if ((a & 0x400) == 1024 && q != E.h())
                {
                    q = E.a(q).a(e1).t();
                } else
                {
                    q = e1;
                }
                aF();
            } else
            {
                r.b(e1);
            }
            a = a | 0x400;
            return this;
        }

        public o.a b(s s1)
        {
            if (p == null)
            {
                if ((a & 0x200) == 512 && o != s.h())
                {
                    o = s.a(o).a(s1).O();
                } else
                {
                    o = s1;
                }
                aF();
            } else
            {
                p.b(s1);
            }
            a = a | 0x200;
            return this;
        }

        public o.a b(Iterable iterable)
        {
            aJ();
            com.umeng.message.proguard.p.a.a(iterable, e);
            aF();
            return this;
        }

        public o.a b(String s1)
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

        public int c(int i1)
        {
            return ((Integer)e.get(i1)).intValue();
        }

        public o.a c(Iterable iterable)
        {
            aK();
            com.umeng.message.proguard.p.a.a(iterable, f);
            aF();
            return this;
        }

        public o.a c(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aI();
                d.add(s1);
                aF();
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return I();
        }

        public int d(int i1)
        {
            return ((Integer)f.get(i1)).intValue();
        }

        public a.a d()
        {
            return I();
        }

        public o.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof o)
            {
                return a((o)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public o.a d(Iterable iterable)
        {
            if (h == null)
            {
                aL();
                com.umeng.message.proguard.p.a.a(iterable, g);
                aF();
                return this;
            } else
            {
                h.a(iterable);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public a e(int i1)
        {
            if (h == null)
            {
                return (a)g.get(i1);
            } else
            {
                return (a)h.a(i1);
            }
        }

        public o.a e(com.umeng.message.proguard.g g1)
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

        public o.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (o)o.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (o)n1.a();
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

        public o.a e(Iterable iterable)
        {
            if (j == null)
            {
                aN();
                com.umeng.message.proguard.p.a.a(iterable, i);
                aF();
                return this;
            } else
            {
                j.a(iterable);
                return this;
            }
        }

        public b.a f()
        {
            return I();
        }

        public b f(int i1)
        {
            if (h == null)
            {
                return (b)g.get(i1);
            } else
            {
                return (b)h.c(i1);
            }
        }

        public o.a f(com.umeng.message.proguard.g g1)
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

        public o.a f(Iterable iterable)
        {
            if (l == null)
            {
                aP();
                com.umeng.message.proguard.p.a.a(iterable, k);
                aF();
                return this;
            } else
            {
                l.a(iterable);
                return this;
            }
        }

        public c g(int i1)
        {
            if (j == null)
            {
                return (c)i.get(i1);
            } else
            {
                return (c)j.a(i1);
            }
        }

        public o.a g(com.umeng.message.proguard.g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aI();
                d.a(g1);
                aF();
                return this;
            }
        }

        public o.a g(Iterable iterable)
        {
            if (n == null)
            {
                aR();
                com.umeng.message.proguard.p.a.a(iterable, m);
                aF();
                return this;
            } else
            {
                n.a(iterable);
                return this;
            }
        }

        public y.a g()
        {
            return I();
        }

        public d h(int i1)
        {
            if (j == null)
            {
                return (d)i.get(i1);
            } else
            {
                return (d)j.c(i1);
            }
        }

        public y.a h()
        {
            return m();
        }

        public A i(int i1)
        {
            if (l == null)
            {
                return (A)k.get(i1);
            } else
            {
                return (A)l.a(i1);
            }
        }

        public x.a i()
        {
            return I();
        }

        public B j(int i1)
        {
            if (l == null)
            {
                return (B)k.get(i1);
            } else
            {
                return (B)l.c(i1);
            }
        }

        public x.a j()
        {
            return m();
        }

        public k k(int i1)
        {
            if (n == null)
            {
                return (k)m.get(i1);
            } else
            {
                return (k)n.a(i1);
            }
        }

        public l l(int i1)
        {
            if (n == null)
            {
                return (l)m.get(i1);
            } else
            {
                return (l)n.c(i1);
            }
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.e().a(com/umeng/message/proguard/j$o, com/umeng/message/proguard/j$o$a);
        }

        public o.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = com.umeng.message.proguard.u.a;
            a = a & -5;
            e = Collections.emptyList();
            a = a & -9;
            f = Collections.emptyList();
            a = a & 0xffffffef;
            if (h == null)
            {
                g = Collections.emptyList();
                a = a & 0xffffffdf;
            } else
            {
                h.e();
            }
            if (j == null)
            {
                i = Collections.emptyList();
                a = a & 0xffffffbf;
            } else
            {
                j.e();
            }
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xffffff7f;
            } else
            {
                l.e();
            }
            if (n == null)
            {
                m = Collections.emptyList();
                a = a & 0xfffffeff;
            } else
            {
                n.e();
            }
            if (p == null)
            {
                o = s.h();
            } else
            {
                p.g();
            }
            a = a & 0xfffffdff;
            if (r == null)
            {
                q = E.h();
            } else
            {
                r.g();
            }
            a = a & 0xfffffbff;
            return this;
        }

        public o.a m(int i1)
        {
            aJ();
            e.add(Integer.valueOf(i1));
            aF();
            return this;
        }

        public o.a n(int i1)
        {
            aK();
            f.add(Integer.valueOf(i1));
            aF();
            return this;
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public o.a o(int i1)
        {
            if (h == null)
            {
                aL();
                g.remove(i1);
                aF();
                return this;
            } else
            {
                h.d(i1);
                return this;
            }
        }

        public String o()
        {
            Object obj = b;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public a.a p(int i1)
        {
            return (a.a)aM().b(i1);
        }

        public a.a q(int i1)
        {
            return (a.a)aM().c(i1, a.h());
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public o.a r(int i1)
        {
            if (j == null)
            {
                aN();
                i.remove(i1);
                aF();
                return this;
            } else
            {
                j.d(i1);
                return this;
            }
        }

        public String r()
        {
            Object obj = c;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                c = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = c;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                c = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public c.a s(int i1)
        {
            return (c.a)aO().b(i1);
        }

        public c.a t(int i1)
        {
            return (c.a)aO().c(i1, c.h());
        }

        public List t()
        {
            return Collections.unmodifiableList(d);
        }

        public int u()
        {
            return d.size();
        }

        public o.a u(int i1)
        {
            if (l == null)
            {
                aP();
                k.remove(i1);
                aF();
                return this;
            } else
            {
                l.d(i1);
                return this;
            }
        }

        public A.a v(int i1)
        {
            return (A.a)aQ().b(i1);
        }

        public List v()
        {
            return Collections.unmodifiableList(e);
        }

        public int w()
        {
            return e.size();
        }

        public A.a w(int i1)
        {
            return (A.a)aQ().c(i1, A.h());
        }

        public o.a x(int i1)
        {
            if (n == null)
            {
                aR();
                m.remove(i1);
                aF();
                return this;
            } else
            {
                n.d(i1);
                return this;
            }
        }

        public List x()
        {
            return Collections.unmodifiableList(f);
        }

        public int y()
        {
            return f.size();
        }

        public k.a y(int i1)
        {
            return (k.a)aS().b(i1);
        }

        public k.a z(int i1)
        {
            return (k.a)aS().c(i1, k.h());
        }

        public List z()
        {
            if (h == null)
            {
                return Collections.unmodifiableList(g);
            } else
            {
                return h.g();
            }
        }

        private o.a()
        {
            b = "";
            c = "";
            d = com.umeng.message.proguard.u.a;
            e = Collections.emptyList();
            f = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = Collections.emptyList();
            o = s.h();
            q = E.h();
            aG();
        }

        private o.a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            d = com.umeng.message.proguard.u.a;
            e = Collections.emptyList();
            f = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = Collections.emptyList();
            o = s.h();
            q = E.h();
            aG();
        }

    }

    public static interface p
        extends com.umeng.message.proguard.A
    {

        public abstract List A();

        public abstract int B();

        public abstract List C();

        public abstract List D();

        public abstract int E();

        public abstract List F();

        public abstract List G();

        public abstract int H();

        public abstract List K();

        public abstract List L();

        public abstract int S();

        public abstract boolean T();

        public abstract s U();

        public abstract t V();

        public abstract boolean W();

        public abstract E X();

        public abstract F Y();

        public abstract String a(int i1);

        public abstract com.umeng.message.proguard.g b(int i1);

        public abstract int c(int i1);

        public abstract int d(int i1);

        public abstract a e(int i1);

        public abstract b f(int i1);

        public abstract c g(int i1);

        public abstract d h(int i1);

        public abstract A i(int i1);

        public abstract B j(int i1);

        public abstract k k(int i1);

        public abstract l l(int i1);

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract boolean q();

        public abstract String r();

        public abstract com.umeng.message.proguard.g s();

        public abstract List t();

        public abstract int u();

        public abstract List v();

        public abstract int w();

        public abstract List x();

        public abstract int y();

        public abstract List z();
    }

    public static final class q extends com.umeng.message.proguard.p
        implements r
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public q c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new q(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        private static final q c;
        private static final long h = 0L;
        private final P d;
        private List e;
        private byte f;
        private int g;

        public static a a(q q1)
        {
            return q().a(q1);
        }

        public static q a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (q)a.d(g1);
        }

        public static q a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (q)a.d(g1, n1);
        }

        public static q a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (q)a.d(h1);
        }

        public static q a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (q)a.b(h1, n1);
        }

        public static q a(InputStream inputstream)
            throws IOException
        {
            return (q)a.h(inputstream);
        }

        public static q a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (q)a.h(inputstream, n1);
        }

        public static q a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (q)a.d(abyte0);
        }

        public static q a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (q)a.d(abyte0, n1);
        }

        static List a(q q1, List list)
        {
            q1.e = list;
            return list;
        }

        public static q b(InputStream inputstream)
            throws IOException
        {
            return (q)a.f(inputstream);
        }

        public static q b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (q)a.f(inputstream, n1);
        }

        static List b(q q1)
        {
            return q1.e;
        }

        public static q h()
        {
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.b();
        }

        public static a q()
        {
            return a.x();
        }

        private void t()
        {
            e = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return s();
        }

        public x.a N()
        {
            return r();
        }

        public y.a O()
        {
            return s();
        }

        public y.a P()
        {
            return r();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public o a(int i1)
        {
            return (o)e.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            for (int j1 = 0; j1 < e.size(); j1++)
            {
                i1.c(1, (com.umeng.message.proguard.y)e.get(j1));
            }

            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = f;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    f = 0;
                    return false;
                }
            }

            f = 1;
            return true;
        }

        public p b(int i1)
        {
            return (p)e.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return d;
        }

        public int d()
        {
            int i1 = g;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            int j1 = 0;
            for (; i1 < e.size(); i1++)
            {
                j1 += com.umeng.message.proguard.i.g(1, (com.umeng.message.proguard.y)e.get(i1));
            }

            i1 = b_().d() + j1;
            g = i1;
            return i1;
        }

        public q i()
        {
            return c;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.c().a(com/umeng/message/proguard/j$q, com/umeng/message/proguard/j$q$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return e;
        }

        public List o()
        {
            return e;
        }

        public int p()
        {
            return e.size();
        }

        public a r()
        {
            return q();
        }

        public a s()
        {
            return a(this);
        }

        static 
        {
            c = new q(true);
            c.t();
        }

        private q(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            boolean flag2;
            flag2 = false;
            super();
            f = -1;
            g = -1;
            t();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L9:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 2: default 286
        //                       0: 289
        //                       10: 110;
               goto _L3 _L4 _L5
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!a(h1, a1, n1, i1))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L7; else goto _L6
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            e = new ArrayList();
            i1 = flag | true;
_L7:
            flag3 = i1;
            flag1 = i1;
            flag4 = i1;
            e.add(h1.a(o.a, n1));
            flag = i1;
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag3;
            throw h1.a(this);
            h1;
            if ((flag1 & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            throw h1;
_L2:
            if ((flag & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            return;
            h1;
            flag1 = flag4;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L4:
            flag2 = true;
            if (true) goto _L9; else goto _L8
_L8:
        }


        private q(p.a a1)
        {
            super(a1);
            f = -1;
            g = -1;
            d = a1.b_();
        }


        private q(boolean flag)
        {
            f = -1;
            g = -1;
            d = com.umeng.message.proguard.P.c();
        }
    }

    public static final class q.a extends p.a
        implements r
    {

        private int a;
        private List b;
        private com.umeng.message.proguard.D c;

        private void A()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private com.umeng.message.proguard.D B()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.b();
        }

        static q.a x()
        {
            return z();
        }

        private void y()
        {
            if (com.umeng.message.proguard.p.m)
            {
                B();
            }
        }

        private static q.a z()
        {
            return new q.a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.b();
        }

        public com.umeng.message.proguard.y Q()
        {
            return r();
        }

        public com.umeng.message.proguard.x R()
        {
            return r();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public o a(int i1)
        {
            if (c == null)
            {
                return (o)b.get(i1);
            } else
            {
                return (o)c.a(i1);
            }
        }

        public q.a a(int i1, o.a a1)
        {
            if (c == null)
            {
                A();
                b.set(i1, a1.N());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.N());
                return this;
            }
        }

        public q.a a(int i1, o o1)
        {
            if (c == null)
            {
                if (o1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.set(i1, o1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, o1);
                return this;
            }
        }

        public q.a a(o.a a1)
        {
            if (c == null)
            {
                A();
                b.add(a1.N());
                aF();
                return this;
            } else
            {
                c.a(a1.N());
                return this;
            }
        }

        public q.a a(o o1)
        {
            if (c == null)
            {
                if (o1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.add(o1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(o1);
                return this;
            }
        }

        public q.a a(q q1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (q1 == q.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!q.b(q1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = q.b(q1);
                    a = a & -2;
                } else
                {
                    A();
                    b.addAll(q.b(q1));
                }
                aF();
            }
_L4:
            d(q1.b_());
            return this;
_L2:
            if (!q.b(q1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = q.b(q1);
                    a = a & -2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = B();
                    }
                    c = d1;
                } else
                {
                    c.a(q.b(q1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public q.a a(Iterable iterable)
        {
            if (c == null)
            {
                A();
                com.umeng.message.proguard.p.a.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public final boolean a()
        {
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    return false;
                }
            }

            return true;
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return q();
        }

        public com.umeng.message.proguard.x aj()
        {
            return t();
        }

        public com.umeng.message.proguard.x ak()
        {
            return s();
        }

        public com.umeng.message.proguard.y al()
        {
            return t();
        }

        public com.umeng.message.proguard.y am()
        {
            return s();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public p b(int i1)
        {
            if (c == null)
            {
                return (p)b.get(i1);
            } else
            {
                return (p)c.c(i1);
            }
        }

        public q.a b(int i1, o.a a1)
        {
            if (c == null)
            {
                A();
                b.add(i1, a1.N());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.N());
                return this;
            }
        }

        public q.a b(int i1, o o1)
        {
            if (c == null)
            {
                if (o1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.add(i1, o1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, o1);
                return this;
            }
        }

        public q.a c(int i1)
        {
            if (c == null)
            {
                A();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public o.a d(int i1)
        {
            return (o.a)B().b(i1);
        }

        public q.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof q)
            {
                return a((q)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public o.a e(int i1)
        {
            return (o.a)B().c(i1, o.h());
        }

        public q.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (q)q.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (q)n1.a();
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
            return q();
        }

        public y.a g()
        {
            return q();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return q();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.c().a(com/umeng/message/proguard/j$q, com/umeng/message/proguard/j$q$a);
        }

        public q.a m()
        {
            super.ah();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public q.a q()
        {
            return z().a(t());
        }

        public q r()
        {
            return q.h();
        }

        public q s()
        {
            q q1 = t();
            if (!q1.a())
            {
                throw b(q1);
            } else
            {
                return q1;
            }
        }

        public q t()
        {
            q q1 = new q(this);
            int i1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                q.a(q1, b);
            } else
            {
                q.a(q1, c.f());
            }
            aB();
            return q1;
        }

        public q.a u()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public o.a v()
        {
            return (o.a)B().b(o.h());
        }

        public List w()
        {
            return B().h();
        }

        private q.a()
        {
            b = Collections.emptyList();
            y();
        }

        private q.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

    }

    public static interface r
        extends com.umeng.message.proguard.A
    {

        public abstract o a(int i1);

        public abstract p b(int i1);

        public abstract List n();

        public abstract List o();

        public abstract int p();
    }

    public static final class s extends p.d
        implements t
    {

        private static final long B = 0L;
        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public s c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new s(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 8;
        public static final int d = 10;
        public static final int e = 20;
        public static final int f = 9;
        public static final int g = 11;
        public static final int h = 16;
        public static final int i = 17;
        public static final int j = 18;
        public static final int k = 999;
        private static final s l;
        private int A;
        private final P n;
        private int o;
        private Object p;
        private Object q;
        private boolean r;
        private boolean s;
        private b t;
        private Object u;
        private boolean v;
        private boolean w;
        private boolean x;
        private List y;
        private byte z;

        public static a T()
        {
            return a.ae();
        }

        static int a(s s1, int i1)
        {
            s1.o = i1;
            return i1;
        }

        public static a a(s s1)
        {
            return T().a(s1);
        }

        static b a(s s1, b b1)
        {
            s1.t = b1;
            return b1;
        }

        public static s a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (s)a.d(g1);
        }

        public static s a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (s)a.d(g1, n1);
        }

        public static s a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (s)a.d(h1);
        }

        public static s a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (s)a.b(h1, n1);
        }

        public static s a(InputStream inputstream)
            throws IOException
        {
            return (s)a.h(inputstream);
        }

        public static s a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (s)a.h(inputstream, n1);
        }

        public static s a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (s)a.d(abyte0);
        }

        public static s a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (s)a.d(abyte0, n1);
        }

        static Object a(s s1, Object obj)
        {
            s1.p = obj;
            return obj;
        }

        static List a(s s1, List list)
        {
            s1.y = list;
            return list;
        }

        static boolean a(s s1, boolean flag)
        {
            s1.r = flag;
            return flag;
        }

        private void ae()
        {
            p = "";
            q = "";
            r = false;
            s = false;
            t = b.a;
            u = "";
            v = false;
            w = false;
            x = false;
            y = Collections.emptyList();
        }

        public static s b(InputStream inputstream)
            throws IOException
        {
            return (s)a.f(inputstream);
        }

        public static s b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (s)a.f(inputstream, n1);
        }

        static Object b(s s1)
        {
            return s1.p;
        }

        static Object b(s s1, Object obj)
        {
            s1.q = obj;
            return obj;
        }

        static boolean b(s s1, boolean flag)
        {
            s1.s = flag;
            return flag;
        }

        static Object c(s s1)
        {
            return s1.q;
        }

        static Object c(s s1, Object obj)
        {
            s1.u = obj;
            return obj;
        }

        static boolean c(s s1, boolean flag)
        {
            s1.v = flag;
            return flag;
        }

        static Object d(s s1)
        {
            return s1.u;
        }

        static boolean d(s s1, boolean flag)
        {
            s1.w = flag;
            return flag;
        }

        static List e(s s1)
        {
            return s1.y;
        }

        static boolean e(s s1, boolean flag)
        {
            s1.x = flag;
            return flag;
        }

        public static s h()
        {
            return l;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.t();
        }

        public boolean C()
        {
            return (o & 0x40) == 64;
        }

        public boolean D()
        {
            return v;
        }

        public boolean E()
        {
            return (o & 0x80) == 128;
        }

        public boolean F()
        {
            return w;
        }

        public boolean G()
        {
            return (o & 0x100) == 256;
        }

        public boolean H()
        {
            return x;
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public List K()
        {
            return y;
        }

        public List L()
        {
            return y;
        }

        public x.a M()
        {
            return V();
        }

        public x.a N()
        {
            return U();
        }

        public y.a O()
        {
            return V();
        }

        public y.a P()
        {
            return U();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public int S()
        {
            return y.size();
        }

        public a U()
        {
            return T();
        }

        public a V()
        {
            return a(this);
        }

        public G a(int i1)
        {
            return (G)y.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
            if ((o & 1) == 1)
            {
                i1.a(1, p());
            }
            if ((o & 2) == 2)
            {
                i1.a(8, s());
            }
            if ((o & 0x10) == 16)
            {
                i1.d(9, t.a());
            }
            if ((o & 4) == 4)
            {
                i1.a(10, r);
            }
            if ((o & 0x20) == 32)
            {
                i1.a(11, g_());
            }
            if ((o & 0x40) == 64)
            {
                i1.a(16, v);
            }
            if ((o & 0x80) == 128)
            {
                i1.a(17, w);
            }
            if ((o & 0x100) == 256)
            {
                i1.a(18, x);
            }
            if ((o & 8) == 8)
            {
                i1.a(20, s);
            }
            for (int j1 = 0; j1 < y.size(); j1++)
            {
                i1.c(999, (com.umeng.message.proguard.y)y.get(j1));
            }

            a1.a(0x20000000, i1);
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = z;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < S(); i1++)
            {
                if (!a(i1).a())
                {
                    z = 0;
                    return false;
                }
            }

            if (!W())
            {
                z = 0;
                return false;
            } else
            {
                z = 1;
                return true;
            }
        }

        public H b(int i1)
        {
            return (H)y.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return n;
        }

        public int d()
        {
            boolean flag = false;
            int i1 = A;
            if (i1 != -1)
            {
                return i1;
            }
            int j1;
            if ((o & 1) == 1)
            {
                j1 = com.umeng.message.proguard.i.c(1, p()) + 0;
            } else
            {
                j1 = 0;
            }
            i1 = j1;
            if ((o & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.c(8, s());
            }
            j1 = i1;
            if ((o & 0x10) == 16)
            {
                j1 = i1 + com.umeng.message.proguard.i.j(9, t.a());
            }
            i1 = j1;
            if ((o & 4) == 4)
            {
                i1 = j1 + com.umeng.message.proguard.i.b(10, r);
            }
            j1 = i1;
            if ((o & 0x20) == 32)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(11, g_());
            }
            i1 = j1;
            if ((o & 0x40) == 64)
            {
                i1 = j1 + com.umeng.message.proguard.i.b(16, v);
            }
            j1 = i1;
            if ((o & 0x80) == 128)
            {
                j1 = i1 + com.umeng.message.proguard.i.b(17, w);
            }
            i1 = j1;
            if ((o & 0x100) == 256)
            {
                i1 = j1 + com.umeng.message.proguard.i.b(18, x);
            }
            j1 = i1;
            if ((o & 8) == 8)
            {
                j1 = i1 + com.umeng.message.proguard.i.b(20, s);
            }
            i1 = j1;
            for (j1 = ((flag) ? 1 : 0); j1 < y.size();)
            {
                int k1 = com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)y.get(j1));
                j1++;
                i1 = k1 + i1;
            }

            i1 = Z() + i1 + b_().d();
            A = i1;
            return i1;
        }

        public String f_()
        {
            Object obj = u;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                u = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g g_()
        {
            Object obj = u;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                u = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public s i()
        {
            return l;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.u().a(com/umeng/message/proguard/j$s, com/umeng/message/proguard/j$s$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (o & 1) == 1;
        }

        public String o()
        {
            Object obj = p;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                p = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = p;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                p = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean q()
        {
            return (o & 2) == 2;
        }

        public String r()
        {
            Object obj = q;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                q = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = q;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                q = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean t()
        {
            return (o & 4) == 4;
        }

        public boolean u()
        {
            return r;
        }

        public boolean v()
        {
            return (o & 8) == 8;
        }

        public boolean w()
        {
            return s;
        }

        public boolean x()
        {
            return (o & 0x10) == 16;
        }

        public b y()
        {
            return t;
        }

        public boolean z()
        {
            return (o & 0x20) == 32;
        }

        static 
        {
            l = new s(true);
            l.ae();
        }

        private s(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            int i1;
            boolean flag;
            flag = false;
            super();
            z = -1;
            A = -1;
            ae();
            a1 = com.umeng.message.proguard.P.b();
            i1 = 0;
_L20:
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
            JVM INSTR lookupswitch 11: default 849
        //                       0: 852
        //                       10: 182
        //                       66: 276
        //                       72: 342
        //                       80: 452
        //                       90: 497
        //                       128: 543
        //                       136: 589
        //                       144: 636
        //                       160: 683
        //                       7994: 729;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L3:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            if (!a(h1, a1, n1, j1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 1;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            p = h1.l();
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = l1;
            throw h1.a(this);
            h1;
            if ((k1 & 0x200) == 512)
            {
                y = Collections.unmodifiableList(y);
            }
            n = a1.b();
            ad();
            throw h1;
_L6:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 2;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            q = h1.l();
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = i2;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L7:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            j1 = h1.n();
            l1 = i1;
            k1 = i1;
            i2 = i1;
            b b1 = b.a(j1);
            if (b1 != null) goto _L16; else goto _L15
_L15:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            a1.a(9, j1);
            continue; /* Loop/switch isn't completed */
_L16:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 0x10;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            t = b1;
            continue; /* Loop/switch isn't completed */
_L8:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 4;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            r = h1.j();
            continue; /* Loop/switch isn't completed */
_L9:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 0x20;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            u = h1.l();
            continue; /* Loop/switch isn't completed */
_L10:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 0x40;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            v = h1.j();
            continue; /* Loop/switch isn't completed */
_L11:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 0x80;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            w = h1.j();
            continue; /* Loop/switch isn't completed */
_L12:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 0x100;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            x = h1.j();
            continue; /* Loop/switch isn't completed */
_L13:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            o = o | 8;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            s = h1.j();
            continue; /* Loop/switch isn't completed */
_L14:
            j1 = i1;
            if ((i1 & 0x200) == 512) goto _L18; else goto _L17
_L17:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            y = new ArrayList();
            j1 = i1 | 0x200;
_L18:
            l1 = j1;
            k1 = j1;
            i2 = j1;
            y.add(h1.a(G.a, n1));
            i1 = j1;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i1 & 0x200) == 512)
            {
                y = Collections.unmodifiableList(y);
            }
            n = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L20; else goto _L19
_L19:
        }


        private s(p.c c1)
        {
            super(c1);
            z = -1;
            A = -1;
            n = c1.b_();
        }


        private s(boolean flag)
        {
            z = -1;
            A = -1;
            n = com.umeng.message.proguard.P.c();
        }
    }

    public static final class s.a extends p.c
        implements t
    {

        private int a;
        private Object b;
        private Object c;
        private boolean d;
        private boolean e;
        private s.b f;
        private Object g;
        private boolean h;
        private boolean i;
        private boolean j;
        private List k;
        private com.umeng.message.proguard.D l;

        static s.a ae()
        {
            return an();
        }

        private void ag()
        {
            if (com.umeng.message.proguard.p.m)
            {
                ap();
            }
        }

        private static s.a an()
        {
            return new s.a();
        }

        private void ao()
        {
            if ((a & 0x200) != 512)
            {
                k = new ArrayList(k);
                a = a | 0x200;
            }
        }

        private com.umeng.message.proguard.D ap()
        {
            if (l == null)
            {
                List list = k;
                boolean flag;
                if ((a & 0x200) == 512)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                l = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                k = null;
            }
            return l;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.t();
        }

        public p.c A()
        {
            return I();
        }

        public p.c B()
        {
            return m();
        }

        public boolean C()
        {
            return (a & 0x40) == 64;
        }

        public boolean D()
        {
            return h;
        }

        public boolean E()
        {
            return (a & 0x80) == 128;
        }

        public boolean F()
        {
            return i;
        }

        public boolean G()
        {
            return (a & 0x100) == 256;
        }

        public boolean H()
        {
            return j;
        }

        public s.a I()
        {
            return an().a(O());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.t();
        }

        public List K()
        {
            if (l == null)
            {
                return Collections.unmodifiableList(k);
            } else
            {
                return l.g();
            }
        }

        public List L()
        {
            if (l != null)
            {
                return l.i();
            } else
            {
                return Collections.unmodifiableList(k);
            }
        }

        public s M()
        {
            return s.h();
        }

        public s N()
        {
            s s1 = O();
            if (!s1.a())
            {
                throw b(s1);
            } else
            {
                return s1;
            }
        }

        public s O()
        {
            int j1 = 1;
            s s1 = new s(this);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            s.a(s1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            s.b(s1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            s.a(s1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            s.b(s1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            s.a(s1, f);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            s.c(s1, g);
            j1 = i1;
            if ((k1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            s.c(s1, h);
            i1 = j1;
            if ((k1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            }
            s.d(s1, i);
            j1 = i1;
            if ((k1 & 0x100) == 256)
            {
                j1 = i1 | 0x100;
            }
            s.e(s1, j);
            if (l == null)
            {
                if ((a & 0x200) == 512)
                {
                    k = Collections.unmodifiableList(k);
                    a = a & 0xfffffdff;
                }
                s.a(s1, k);
            } else
            {
                s.a(s1, l.f());
            }
            s.a(s1, j1);
            aB();
            return s1;
        }

        public s.a P()
        {
            a = a & -2;
            b = s.h().o();
            aF();
            return this;
        }

        public com.umeng.message.proguard.y Q()
        {
            return M();
        }

        public com.umeng.message.proguard.x R()
        {
            return M();
        }

        public int S()
        {
            if (l == null)
            {
                return k.size();
            } else
            {
                return l.c();
            }
        }

        public s.a T()
        {
            a = a & -3;
            c = s.h().r();
            aF();
            return this;
        }

        public s.a U()
        {
            a = a & -5;
            d = false;
            aF();
            return this;
        }

        public s.a V()
        {
            a = a & -9;
            e = false;
            aF();
            return this;
        }

        public s.a W()
        {
            a = a & 0xffffffef;
            f = s.b.a;
            aF();
            return this;
        }

        public s.a X()
        {
            a = a & 0xffffffdf;
            g = s.h().f_();
            aF();
            return this;
        }

        public s.a Y()
        {
            a = a & 0xffffffbf;
            h = false;
            aF();
            return this;
        }

        public s.a Z()
        {
            a = a & 0xffffff7f;
            i = false;
            aF();
            return this;
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G a(int i1)
        {
            if (l == null)
            {
                return (G)k.get(i1);
            } else
            {
                return (G)l.a(i1);
            }
        }

        public s.a a(int i1, G.a a1)
        {
            if (l == null)
            {
                ao();
                k.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                l.a(i1, a1.G());
                return this;
            }
        }

        public s.a a(int i1, G g1)
        {
            if (l == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ao();
                    k.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(i1, g1);
                return this;
            }
        }

        public s.a a(G.a a1)
        {
            if (l == null)
            {
                ao();
                k.add(a1.G());
                aF();
                return this;
            } else
            {
                l.a(a1.G());
                return this;
            }
        }

        public s.a a(G g1)
        {
            if (l == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ao();
                    k.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(g1);
                return this;
            }
        }

        public s.a a(s.b b1)
        {
            if (b1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x10;
                f = b1;
                aF();
                return this;
            }
        }

        public s.a a(s s1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (s1 == s.h())
            {
                return this;
            }
            if (s1.n())
            {
                a = a | 1;
                b = s.b(s1);
                aF();
            }
            if (s1.q())
            {
                a = a | 2;
                c = s.c(s1);
                aF();
            }
            if (s1.t())
            {
                a(s1.u());
            }
            if (s1.v())
            {
                b(s1.w());
            }
            if (s1.x())
            {
                a(s1.y());
            }
            if (s1.z())
            {
                a = a | 0x20;
                g = s.d(s1);
                aF();
            }
            if (s1.C())
            {
                c(s1.D());
            }
            if (s1.E())
            {
                d(s1.F());
            }
            if (s1.G())
            {
                e(s1.H());
            }
            if (l != null) goto _L2; else goto _L1
_L1:
            if (!s.e(s1).isEmpty())
            {
                if (k.isEmpty())
                {
                    k = s.e(s1);
                    a = a & 0xfffffdff;
                } else
                {
                    ao();
                    k.addAll(s.e(s1));
                }
                aF();
            }
_L4:
            a(((p.d) (s1)));
            d(s1.b_());
            return this;
_L2:
            if (!s.e(s1).isEmpty())
            {
                if (l.d())
                {
                    l.b();
                    l = null;
                    k = s.e(s1);
                    a = a & 0xfffffdff;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = ap();
                    }
                    l = d1;
                } else
                {
                    l.a(s.e(s1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public s.a a(Iterable iterable)
        {
            if (l == null)
            {
                ao();
                com.umeng.message.proguard.p.c.a(iterable, k);
                aF();
                return this;
            } else
            {
                l.a(iterable);
                return this;
            }
        }

        public s.a a(String s1)
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

        public s.a a(boolean flag)
        {
            a = a | 4;
            d = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= S()) goto _L2; else goto _L1
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

        public s.a aa()
        {
            a = a & 0xfffffeff;
            j = false;
            aF();
            return this;
        }

        public s.a ab()
        {
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xfffffdff;
                aF();
                return this;
            } else
            {
                l.e();
                return this;
            }
        }

        public G.a ac()
        {
            return (G.a)ap().b(G.h());
        }

        public List ad()
        {
            return ap().h();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return I();
        }

        public com.umeng.message.proguard.x aj()
        {
            return O();
        }

        public com.umeng.message.proguard.x ak()
        {
            return N();
        }

        public com.umeng.message.proguard.y al()
        {
            return O();
        }

        public com.umeng.message.proguard.y am()
        {
            return N();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public H b(int i1)
        {
            if (l == null)
            {
                return (H)k.get(i1);
            } else
            {
                return (H)l.c(i1);
            }
        }

        public s.a b(int i1, G.a a1)
        {
            if (l == null)
            {
                ao();
                k.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                l.b(i1, a1.G());
                return this;
            }
        }

        public s.a b(int i1, G g1)
        {
            if (l == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ao();
                    k.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                l.b(i1, g1);
                return this;
            }
        }

        public s.a b(String s1)
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

        public s.a b(boolean flag)
        {
            a = a | 8;
            e = flag;
            aF();
            return this;
        }

        public s.a c(int i1)
        {
            if (l == null)
            {
                ao();
                k.remove(i1);
                aF();
                return this;
            } else
            {
                l.d(i1);
                return this;
            }
        }

        public s.a c(String s1)
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

        public s.a c(boolean flag)
        {
            a = a | 0x40;
            h = flag;
            aF();
            return this;
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
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

        public G.a d(int i1)
        {
            return (G.a)ap().b(i1);
        }

        public s.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof s)
            {
                return a((s)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public s.a d(boolean flag)
        {
            a = a | 0x80;
            i = flag;
            aF();
            return this;
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.a e(int i1)
        {
            return (G.a)ap().c(i1, G.h());
        }

        public s.a e(com.umeng.message.proguard.g g1)
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

        public s.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (s)s.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (s)n1.a();
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

        public s.a e(boolean flag)
        {
            a = a | 0x100;
            j = flag;
            aF();
            return this;
        }

        public b.a f()
        {
            return I();
        }

        public s.a f(com.umeng.message.proguard.g g1)
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

        public String f_()
        {
            Object obj = g;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                g = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public s.a g(com.umeng.message.proguard.g g1)
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

        public com.umeng.message.proguard.g g_()
        {
            Object obj = g;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                g = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
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
            return com.umeng.message.proguard.j.u().a(com/umeng/message/proguard/j$s, com/umeng/message/proguard/j$s$a);
        }

        public s.a m()
        {
            super.B();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = false;
            a = a & -5;
            e = false;
            a = a & -9;
            f = s.b.a;
            a = a & 0xffffffef;
            g = "";
            a = a & 0xffffffdf;
            h = false;
            a = a & 0xffffffbf;
            i = false;
            a = a & 0xffffff7f;
            j = false;
            a = a & 0xfffffeff;
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xfffffdff;
                return this;
            } else
            {
                l.e();
                return this;
            }
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                c = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = c;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                c = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public boolean u()
        {
            return d;
        }

        public boolean v()
        {
            return (a & 8) == 8;
        }

        public boolean w()
        {
            return e;
        }

        public boolean x()
        {
            return (a & 0x10) == 16;
        }

        public s.b y()
        {
            return f;
        }

        public boolean z()
        {
            return (a & 0x20) == 32;
        }

        private s.a()
        {
            b = "";
            c = "";
            f = s.b.a;
            g = "";
            k = Collections.emptyList();
            ag();
        }

        private s.a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            f = s.b.a;
            g = "";
            k = Collections.emptyList();
            ag();
        }

    }

    public static final class s.b extends Enum
        implements com.umeng.message.proguard.C
    {

        public static final s.b a;
        public static final s.b b;
        public static final s.b c;
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static r.b g = new r.b() {

            public s.b a(int i1)
            {
                return s.b.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final s.b h[] = values();
        private static final s.b k[];
        private final int i;
        private final int j;

        public static s.b a(int i1)
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

        public static s.b a(k.e e1)
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
            return (k.d)s.k().k().get(0);
        }

        public static s.b valueOf(String s1)
        {
            return (s.b)Enum.valueOf(com/umeng/message/proguard/j$s$b, s1);
        }

        public static s.b[] values()
        {
            return (s.b[])k.clone();
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
            a = new s.b("SPEED", 0, 0, 1);
            b = new s.b("CODE_SIZE", 1, 1, 2);
            c = new s.b("LITE_RUNTIME", 2, 2, 3);
            k = (new s.b[] {
                a, b, c
            });
        }

        private s.b(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            i = j1;
            j = k1;
        }
    }

    public static interface t
        extends p.e
    {

        public abstract boolean C();

        public abstract boolean D();

        public abstract boolean E();

        public abstract boolean F();

        public abstract boolean G();

        public abstract boolean H();

        public abstract List K();

        public abstract List L();

        public abstract int S();

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract String f_();

        public abstract com.umeng.message.proguard.g g_();

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract boolean q();

        public abstract String r();

        public abstract com.umeng.message.proguard.g s();

        public abstract boolean t();

        public abstract boolean u();

        public abstract boolean v();

        public abstract boolean w();

        public abstract boolean x();

        public abstract s.b y();

        public abstract boolean z();
    }

    public static final class u extends p.d
        implements v
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public u c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new u(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 999;
        private static final u e;
        private static final long n = 0L;
        private final P f;
        private int g;
        private boolean h;
        private boolean i;
        private List j;
        private byte k;
        private int l;

        static int a(u u1, int i1)
        {
            u1.g = i1;
            return i1;
        }

        public static a a(u u1)
        {
            return u().a(u1);
        }

        public static u a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (u)a.d(g1);
        }

        public static u a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (u)a.d(g1, n1);
        }

        public static u a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (u)a.d(h1);
        }

        public static u a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (u)a.b(h1, n1);
        }

        public static u a(InputStream inputstream)
            throws IOException
        {
            return (u)a.h(inputstream);
        }

        public static u a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (u)a.h(inputstream, n1);
        }

        public static u a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (u)a.d(abyte0);
        }

        public static u a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (u)a.d(abyte0, n1);
        }

        static List a(u u1, List list)
        {
            u1.j = list;
            return list;
        }

        static boolean a(u u1, boolean flag)
        {
            u1.h = flag;
            return flag;
        }

        public static u b(InputStream inputstream)
            throws IOException
        {
            return (u)a.f(inputstream);
        }

        public static u b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (u)a.f(inputstream, n1);
        }

        static List b(u u1)
        {
            return u1.j;
        }

        static boolean b(u u1, boolean flag)
        {
            u1.i = flag;
            return flag;
        }

        public static u h()
        {
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.v();
        }

        public static a u()
        {
            return a.F();
        }

        private void x()
        {
            h = false;
            i = false;
            j = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return w();
        }

        public x.a N()
        {
            return v();
        }

        public y.a O()
        {
            return w();
        }

        public y.a P()
        {
            return v();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public G a(int i1)
        {
            return (G)j.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
            if ((g & 1) == 1)
            {
                i1.a(1, h);
            }
            if ((g & 2) == 2)
            {
                i1.a(2, i);
            }
            for (int j1 = 0; j1 < j.size(); j1++)
            {
                i1.c(999, (com.umeng.message.proguard.y)j.get(j1));
            }

            a1.a(0x20000000, i1);
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = k;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < t(); i1++)
            {
                if (!a(i1).a())
                {
                    k = 0;
                    return false;
                }
            }

            if (!W())
            {
                k = 0;
                return false;
            } else
            {
                k = 1;
                return true;
            }
        }

        public H b(int i1)
        {
            return (H)j.get(i1);
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
            boolean flag = false;
            int i1 = l;
            if (i1 != -1)
            {
                return i1;
            }
            int j1;
            if ((g & 1) == 1)
            {
                i1 = com.umeng.message.proguard.i.b(1, h) + 0;
            } else
            {
                i1 = 0;
            }
            j1 = i1;
            if ((g & 2) == 2)
            {
                j1 = i1 + com.umeng.message.proguard.i.b(2, i);
            }
            i1 = j1;
            for (int k1 = ((flag) ? 1 : 0); k1 < j.size();)
            {
                int l1 = com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)j.get(k1));
                k1++;
                i1 = l1 + i1;
            }

            i1 = Z() + i1 + b_().d();
            l = i1;
            return i1;
        }

        public u i()
        {
            return e;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.w().a(com/umeng/message/proguard/j$u, com/umeng/message/proguard/j$u$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (g & 1) == 1;
        }

        public boolean o()
        {
            return h;
        }

        public boolean p()
        {
            return (g & 2) == 2;
        }

        public boolean q()
        {
            return i;
        }

        public List r()
        {
            return j;
        }

        public List s()
        {
            return j;
        }

        public int t()
        {
            return j.size();
        }

        public a v()
        {
            return u();
        }

        public a w()
        {
            return a(this);
        }

        static 
        {
            e = new u(true);
            e.x();
        }

        private u(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            int i1;
            boolean flag;
            flag = false;
            super();
            k = -1;
            l = -1;
            x();
            a1 = com.umeng.message.proguard.P.b();
            i1 = 0;
_L11:
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
            JVM INSTR lookupswitch 4: default 392
        //                       0: 395
        //                       8: 126
        //                       16: 216
        //                       7994: 282;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            if (!a(h1, a1, n1, j1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            g = g | 1;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            h = h1.j();
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = l1;
            throw h1.a(this);
            h1;
            if ((k1 & 4) == 4)
            {
                j = Collections.unmodifiableList(j);
            }
            f = a1.b();
            ad();
            throw h1;
_L6:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            g = g | 2;
            l1 = i1;
            k1 = i1;
            i2 = i1;
            i = h1.j();
            continue; /* Loop/switch isn't completed */
            h1;
            k1 = i2;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L7:
            j1 = i1;
            if ((i1 & 4) == 4) goto _L9; else goto _L8
_L8:
            l1 = i1;
            k1 = i1;
            i2 = i1;
            j = new ArrayList();
            j1 = i1 | 4;
_L9:
            l1 = j1;
            k1 = j1;
            i2 = j1;
            j.add(h1.a(G.a, n1));
            i1 = j1;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i1 & 4) == 4)
            {
                j = Collections.unmodifiableList(j);
            }
            f = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L11; else goto _L10
_L10:
        }


        private u(p.c c1)
        {
            super(c1);
            k = -1;
            l = -1;
            f = c1.b_();
        }


        private u(boolean flag)
        {
            k = -1;
            l = -1;
            f = com.umeng.message.proguard.P.c();
        }
    }

    public static final class u.a extends p.c
        implements v
    {

        private int a;
        private boolean b;
        private boolean c;
        private List d;
        private com.umeng.message.proguard.D e;

        static u.a F()
        {
            return H();
        }

        private void G()
        {
            if (com.umeng.message.proguard.p.m)
            {
                K();
            }
        }

        private static u.a H()
        {
            return new u.a();
        }

        private void I()
        {
            if ((a & 4) != 4)
            {
                d = new ArrayList(d);
                a = a | 4;
            }
        }

        private com.umeng.message.proguard.D K()
        {
            if (e == null)
            {
                List list = d;
                boolean flag;
                if ((a & 4) == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                e = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                d = null;
            }
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.v();
        }

        public p.c A()
        {
            return u();
        }

        public p.c B()
        {
            return m();
        }

        public u.a C()
        {
            if (e == null)
            {
                d = Collections.emptyList();
                a = a & -5;
                aF();
                return this;
            } else
            {
                e.e();
                return this;
            }
        }

        public G.a D()
        {
            return (G.a)K().b(G.h());
        }

        public List E()
        {
            return K().h();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.v();
        }

        public com.umeng.message.proguard.y Q()
        {
            return v();
        }

        public com.umeng.message.proguard.x R()
        {
            return v();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G a(int i1)
        {
            if (e == null)
            {
                return (G)d.get(i1);
            } else
            {
                return (G)e.a(i1);
            }
        }

        public u.a a(int i1, G.a a1)
        {
            if (e == null)
            {
                I();
                d.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                e.a(i1, a1.G());
                return this;
            }
        }

        public u.a a(int i1, G g1)
        {
            if (e == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    I();
                    d.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                e.a(i1, g1);
                return this;
            }
        }

        public u.a a(G.a a1)
        {
            if (e == null)
            {
                I();
                d.add(a1.G());
                aF();
                return this;
            } else
            {
                e.a(a1.G());
                return this;
            }
        }

        public u.a a(G g1)
        {
            if (e == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    I();
                    d.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                e.a(g1);
                return this;
            }
        }

        public u.a a(u u1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (u1 == u.h())
            {
                return this;
            }
            if (u1.n())
            {
                a(u1.o());
            }
            if (u1.p())
            {
                b(u1.q());
            }
            if (e != null) goto _L2; else goto _L1
_L1:
            if (!u.b(u1).isEmpty())
            {
                if (d.isEmpty())
                {
                    d = u.b(u1);
                    a = a & -5;
                } else
                {
                    I();
                    d.addAll(u.b(u1));
                }
                aF();
            }
_L4:
            a(((p.d) (u1)));
            d(u1.b_());
            return this;
_L2:
            if (!u.b(u1).isEmpty())
            {
                if (e.d())
                {
                    e.b();
                    e = null;
                    d = u.b(u1);
                    a = a & -5;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = K();
                    }
                    e = d1;
                } else
                {
                    e.a(u.b(u1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public u.a a(Iterable iterable)
        {
            if (e == null)
            {
                I();
                com.umeng.message.proguard.p.c.a(iterable, d);
                aF();
                return this;
            } else
            {
                e.a(iterable);
                return this;
            }
        }

        public u.a a(boolean flag)
        {
            a = a | 1;
            b = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= t()) goto _L2; else goto _L1
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
            return u();
        }

        public com.umeng.message.proguard.x aj()
        {
            return x();
        }

        public com.umeng.message.proguard.x ak()
        {
            return w();
        }

        public com.umeng.message.proguard.y al()
        {
            return x();
        }

        public com.umeng.message.proguard.y am()
        {
            return w();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public H b(int i1)
        {
            if (e == null)
            {
                return (H)d.get(i1);
            } else
            {
                return (H)e.c(i1);
            }
        }

        public u.a b(int i1, G.a a1)
        {
            if (e == null)
            {
                I();
                d.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                e.b(i1, a1.G());
                return this;
            }
        }

        public u.a b(int i1, G g1)
        {
            if (e == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    I();
                    d.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                e.b(i1, g1);
                return this;
            }
        }

        public u.a b(boolean flag)
        {
            a = a | 2;
            c = flag;
            aF();
            return this;
        }

        public u.a c(int i1)
        {
            if (e == null)
            {
                I();
                d.remove(i1);
                aF();
                return this;
            } else
            {
                e.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return u();
        }

        public a.a d()
        {
            return u();
        }

        public G.a d(int i1)
        {
            return (G.a)K().b(i1);
        }

        public u.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof u)
            {
                return a((u)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.a e(int i1)
        {
            return (G.a)K().c(i1, G.h());
        }

        public u.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (u)u.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (u)n1.a();
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
            return u();
        }

        public y.a g()
        {
            return u();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return u();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.w().a(com/umeng/message/proguard/j$u, com/umeng/message/proguard/j$u$a);
        }

        public u.a m()
        {
            super.B();
            b = false;
            a = a & -2;
            c = false;
            a = a & -3;
            if (e == null)
            {
                d = Collections.emptyList();
                a = a & -5;
                return this;
            } else
            {
                e.e();
                return this;
            }
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public boolean o()
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

        public List r()
        {
            if (e == null)
            {
                return Collections.unmodifiableList(d);
            } else
            {
                return e.g();
            }
        }

        public List s()
        {
            if (e != null)
            {
                return e.i();
            } else
            {
                return Collections.unmodifiableList(d);
            }
        }

        public int t()
        {
            if (e == null)
            {
                return d.size();
            } else
            {
                return e.c();
            }
        }

        public u.a u()
        {
            return H().a(x());
        }

        public u v()
        {
            return u.h();
        }

        public u w()
        {
            u u1 = x();
            if (!u1.a())
            {
                throw b(u1);
            } else
            {
                return u1;
            }
        }

        public u x()
        {
            int i1 = 1;
            u u1 = new u(this);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            u.a(u1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            u.b(u1, c);
            if (e == null)
            {
                if ((a & 4) == 4)
                {
                    d = Collections.unmodifiableList(d);
                    a = a & -5;
                }
                u.a(u1, d);
            } else
            {
                u.a(u1, e.f());
            }
            u.a(u1, j1);
            aB();
            return u1;
        }

        public u.a y()
        {
            a = a & -2;
            b = false;
            aF();
            return this;
        }

        public u.a z()
        {
            a = a & -3;
            c = false;
            aF();
            return this;
        }

        private u.a()
        {
            d = Collections.emptyList();
            G();
        }

        private u.a(p.b b1)
        {
            super(b1);
            d = Collections.emptyList();
            G();
        }

    }

    public static interface v
        extends p.e
    {

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract boolean n();

        public abstract boolean o();

        public abstract boolean p();

        public abstract boolean q();

        public abstract List r();

        public abstract List s();

        public abstract int t();
    }

    public static final class w extends com.umeng.message.proguard.p
        implements x
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public w c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new w(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        private static final w f;
        private static final long p = 0L;
        private final P g;
        private int h;
        private Object i;
        private Object j;
        private Object k;
        private y l;
        private byte n;
        private int o;

        private void C()
        {
            i = "";
            j = "";
            k = "";
            l = y.h();
        }

        static int a(w w1, int i1)
        {
            w1.h = i1;
            return i1;
        }

        public static a a(w w1)
        {
            return z().a(w1);
        }

        public static w a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (w)a.d(g1);
        }

        public static w a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (w)a.d(g1, n1);
        }

        public static w a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (w)a.d(h1);
        }

        public static w a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (w)a.b(h1, n1);
        }

        public static w a(InputStream inputstream)
            throws IOException
        {
            return (w)a.h(inputstream);
        }

        public static w a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (w)a.h(inputstream, n1);
        }

        public static w a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (w)a.d(abyte0);
        }

        public static w a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (w)a.d(abyte0, n1);
        }

        static y a(w w1, y y1)
        {
            w1.l = y1;
            return y1;
        }

        static Object a(w w1, Object obj)
        {
            w1.i = obj;
            return obj;
        }

        public static w b(InputStream inputstream)
            throws IOException
        {
            return (w)a.f(inputstream);
        }

        public static w b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (w)a.f(inputstream, n1);
        }

        static Object b(w w1)
        {
            return w1.i;
        }

        static Object b(w w1, Object obj)
        {
            w1.j = obj;
            return obj;
        }

        static Object c(w w1)
        {
            return w1.j;
        }

        static Object c(w w1, Object obj)
        {
            w1.k = obj;
            return obj;
        }

        static Object d(w w1)
        {
            return w1.k;
        }

        public static w h()
        {
            return f;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.r();
        }

        public static a z()
        {
            return a.I();
        }

        public a A()
        {
            return z();
        }

        public a B()
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
            return B();
        }

        public x.a N()
        {
            return A();
        }

        public y.a O()
        {
            return B();
        }

        public y.a P()
        {
            return A();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            if ((h & 1) == 1)
            {
                i1.a(1, p());
            }
            if ((h & 2) == 2)
            {
                i1.a(2, s());
            }
            if ((h & 4) == 4)
            {
                i1.a(3, v());
            }
            if ((h & 8) == 8)
            {
                i1.c(4, l);
            }
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = n;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (w() && !x().a())
            {
                n = 0;
                return false;
            } else
            {
                n = 1;
                return true;
            }
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return g;
        }

        public int d()
        {
            int i1 = o;
            if (i1 != -1)
            {
                return i1;
            }
            int j1 = 0;
            if ((h & 1) == 1)
            {
                j1 = 0 + com.umeng.message.proguard.i.c(1, p());
            }
            i1 = j1;
            if ((h & 2) == 2)
            {
                i1 = j1 + com.umeng.message.proguard.i.c(2, s());
            }
            j1 = i1;
            if ((h & 4) == 4)
            {
                j1 = i1 + com.umeng.message.proguard.i.c(3, v());
            }
            i1 = j1;
            if ((h & 8) == 8)
            {
                i1 = j1 + com.umeng.message.proguard.i.g(4, l);
            }
            i1 += b_().d();
            o = i1;
            return i1;
        }

        public w i()
        {
            return f;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.s().a(com/umeng/message/proguard/j$w, com/umeng/message/proguard/j$w$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public boolean n()
        {
            return (h & 1) == 1;
        }

        public String o()
        {
            Object obj = i;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                i = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = i;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                i = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean q()
        {
            return (h & 2) == 2;
        }

        public String r()
        {
            Object obj = j;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                j = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = j;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                j = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean t()
        {
            return (h & 4) == 4;
        }

        public String u()
        {
            Object obj = k;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (com.umeng.message.proguard.g)obj;
            String s1 = ((com.umeng.message.proguard.g) (obj)).h();
            if (((com.umeng.message.proguard.g) (obj)).i())
            {
                k = s1;
            }
            return s1;
        }

        public com.umeng.message.proguard.g v()
        {
            Object obj = k;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                k = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean w()
        {
            return (h & 8) == 8;
        }

        public y x()
        {
            return l;
        }

        public z y()
        {
            return l;
        }

        static 
        {
            f = new w(true);
            f.C();
        }

        private w(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a2;
            boolean flag;
            n = -1;
            o = -1;
            C();
            a2 = com.umeng.message.proguard.P.b();
            flag = false;
_L15:
            if (flag) goto _L2; else goto _L1
_L1:
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 5: default 302
        //                       0: 308
        //                       10: 107
        //                       18: 128
        //                       26: 149
        //                       34: 170;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            if (!a(h1, a2, n1, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            h = h | 1;
            i = h1.l();
            continue; /* Loop/switch isn't completed */
_L6:
            h = h | 2;
            j = h1.l();
            continue; /* Loop/switch isn't completed */
_L7:
            h = h | 4;
            k = h1.l();
            continue; /* Loop/switch isn't completed */
_L8:
            if ((h & 8) != 8) goto _L10; else goto _L9
_L9:
            y.a a1 = l.s();
_L13:
            l = (y)h1.a(y.a, n1);
            if (a1 == null) goto _L12; else goto _L11
_L11:
            a1.a(l);
            l = a1.t();
_L12:
            h = h | 8;
            continue; /* Loop/switch isn't completed */
            h1;
            throw h1.a(this);
            h1;
            g = a2.b();
            ad();
            throw h1;
            h1;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            g = a2.b();
            ad();
            return;
_L10:
            a1 = null;
              goto _L13
_L4:
            flag = true;
            if (true) goto _L15; else goto _L14
_L14:
        }


        private w(p.a a1)
        {
            super(a1);
            n = -1;
            o = -1;
            g = a1.b_();
        }


        private w(boolean flag)
        {
            n = -1;
            o = -1;
            g = com.umeng.message.proguard.P.c();
        }
    }

    public static final class w.a extends p.a
        implements x
    {

        private int a;
        private Object b;
        private Object c;
        private Object d;
        private y e;
        private L f;

        static w.a I()
        {
            return L();
        }

        private void K()
        {
            if (com.umeng.message.proguard.p.m)
            {
                M();
            }
        }

        private static w.a L()
        {
            return new w.a();
        }

        private L M()
        {
            if (f == null)
            {
                f = new L(e, aE(), aD());
                e = null;
            }
            return f;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.r();
        }

        public w A()
        {
            return w.h();
        }

        public w B()
        {
            w w1 = C();
            if (!w1.a())
            {
                throw b(w1);
            } else
            {
                return w1;
            }
        }

        public w C()
        {
            int j1 = 1;
            w w1 = new w(this);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            w.a(w1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            w.b(w1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            w.c(w1, d);
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            } else
            {
                i1 = j1;
            }
            if (f == null)
            {
                w.a(w1, e);
            } else
            {
                w.a(w1, (y)f.d());
            }
            w.a(w1, i1);
            aB();
            return w1;
        }

        public w.a D()
        {
            a = a & -2;
            b = w.h().o();
            aF();
            return this;
        }

        public w.a E()
        {
            a = a & -3;
            c = w.h().r();
            aF();
            return this;
        }

        public w.a F()
        {
            a = a & -5;
            d = w.h().u();
            aF();
            return this;
        }

        public w.a G()
        {
            if (f == null)
            {
                e = y.h();
                aF();
            } else
            {
                f.g();
            }
            a = a & -9;
            return this;
        }

        public y.a H()
        {
            a = a | 8;
            aF();
            return (y.a)M().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.r();
        }

        public com.umeng.message.proguard.y Q()
        {
            return A();
        }

        public com.umeng.message.proguard.x R()
        {
            return A();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public w.a a(w w1)
        {
            if (w1 == w.h())
            {
                return this;
            }
            if (w1.n())
            {
                a = a | 1;
                b = w.b(w1);
                aF();
            }
            if (w1.q())
            {
                a = a | 2;
                c = w.c(w1);
                aF();
            }
            if (w1.t())
            {
                a = a | 4;
                d = w.d(w1);
                aF();
            }
            if (w1.w())
            {
                b(w1.x());
            }
            d(w1.b_());
            return this;
        }

        public w.a a(y.a a1)
        {
            if (f == null)
            {
                e = a1.s();
                aF();
            } else
            {
                f.a(a1.s());
            }
            a = a | 8;
            return this;
        }

        public w.a a(y y1)
        {
            if (f == null)
            {
                if (y1 == null)
                {
                    throw new NullPointerException();
                }
                e = y1;
                aF();
            } else
            {
                f.a(y1);
            }
            a = a | 8;
            return this;
        }

        public w.a a(String s1)
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
            return !w() || x().a();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return z();
        }

        public com.umeng.message.proguard.x aj()
        {
            return C();
        }

        public com.umeng.message.proguard.x ak()
        {
            return B();
        }

        public com.umeng.message.proguard.y al()
        {
            return C();
        }

        public com.umeng.message.proguard.y am()
        {
            return B();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public w.a b(y y1)
        {
            if (f == null)
            {
                if ((a & 8) == 8 && e != y.h())
                {
                    e = y.a(e).a(y1).t();
                } else
                {
                    e = y1;
                }
                aF();
            } else
            {
                f.b(y1);
            }
            a = a | 8;
            return this;
        }

        public w.a b(String s1)
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

        public w.a c(String s1)
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

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return z();
        }

        public a.a d()
        {
            return z();
        }

        public w.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof w)
            {
                return a((w)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public w.a e(com.umeng.message.proguard.g g1)
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

        public w.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (w)w.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (w)n1.a();
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
            return z();
        }

        public w.a f(com.umeng.message.proguard.g g1)
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

        public w.a g(com.umeng.message.proguard.g g1)
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

        public y.a g()
        {
            return z();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return z();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.s().a(com/umeng/message/proguard/j$w, com/umeng/message/proguard/j$w$a);
        }

        public w.a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = "";
            a = a & -5;
            if (f == null)
            {
                e = y.h();
            } else
            {
                f.g();
            }
            a = a & -9;
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
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
                obj = ((com.umeng.message.proguard.g)obj).h();
                c = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g s()
        {
            Object obj = c;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                c = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public String u()
        {
            Object obj = d;
            if (!(obj instanceof String))
            {
                obj = ((com.umeng.message.proguard.g)obj).h();
                d = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public com.umeng.message.proguard.g v()
        {
            Object obj = d;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                d = obj;
                return ((com.umeng.message.proguard.g) (obj));
            } else
            {
                return (com.umeng.message.proguard.g)obj;
            }
        }

        public boolean w()
        {
            return (a & 8) == 8;
        }

        public y x()
        {
            if (f == null)
            {
                return e;
            } else
            {
                return (y)f.c();
            }
        }

        public z y()
        {
            if (f != null)
            {
                return (z)f.f();
            } else
            {
                return e;
            }
        }

        public w.a z()
        {
            return L().a(C());
        }

        private w.a()
        {
            b = "";
            c = "";
            d = "";
            e = y.h();
            K();
        }

        private w.a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            d = "";
            e = y.h();
            K();
        }

    }

    public static interface x
        extends com.umeng.message.proguard.A
    {

        public abstract boolean n();

        public abstract String o();

        public abstract com.umeng.message.proguard.g p();

        public abstract boolean q();

        public abstract String r();

        public abstract com.umeng.message.proguard.g s();

        public abstract boolean t();

        public abstract String u();

        public abstract com.umeng.message.proguard.g v();

        public abstract boolean w();

        public abstract y x();

        public abstract z y();
    }

    public static final class y extends p.d
        implements z
    {

        public static com.umeng.message.proguard.B a = new com.umeng.message.proguard.c() {

            public y c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return new y(h1, n1);
            }

            public Object d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
                throws com.umeng.message.proguard.s
            {
                return c(h1, n1);
            }

        };
        public static final int b = 999;
        private static final y c;
        private static final long h = 0L;
        private final P d;
        private List e;
        private byte f;
        private int g;

        public static a a(y y1)
        {
            return q().a(y1);
        }

        public static y a(com.umeng.message.proguard.g g1)
            throws com.umeng.message.proguard.s
        {
            return (y)a.d(g1);
        }

        public static y a(com.umeng.message.proguard.g g1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (y)a.d(g1, n1);
        }

        public static y a(com.umeng.message.proguard.h h1)
            throws IOException
        {
            return (y)a.d(h1);
        }

        public static y a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (y)a.b(h1, n1);
        }

        public static y a(InputStream inputstream)
            throws IOException
        {
            return (y)a.h(inputstream);
        }

        public static y a(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (y)a.h(inputstream, n1);
        }

        public static y a(byte abyte0[])
            throws com.umeng.message.proguard.s
        {
            return (y)a.d(abyte0);
        }

        public static y a(byte abyte0[], com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            return (y)a.d(abyte0, n1);
        }

        static List a(y y1, List list)
        {
            y1.e = list;
            return list;
        }

        public static y b(InputStream inputstream)
            throws IOException
        {
            return (y)a.f(inputstream);
        }

        public static y b(InputStream inputstream, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return (y)a.f(inputstream, n1);
        }

        static List b(y y1)
        {
            return y1.e;
        }

        public static y h()
        {
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.F();
        }

        public static a q()
        {
            return a.x();
        }

        private void t()
        {
            e = Collections.emptyList();
        }

        protected Object I()
            throws ObjectStreamException
        {
            return super.I();
        }

        public x.a M()
        {
            return s();
        }

        public x.a N()
        {
            return r();
        }

        public y.a O()
        {
            return s();
        }

        public y.a P()
        {
            return r();
        }

        public com.umeng.message.proguard.y Q()
        {
            return i();
        }

        public com.umeng.message.proguard.x R()
        {
            return i();
        }

        public G a(int i1)
        {
            return (G)e.get(i1);
        }

        protected a a(p.b b1)
        {
            return new a(b1);
        }

        public void a(com.umeng.message.proguard.i i1)
            throws IOException
        {
            d();
            p.d.a a1 = X();
            for (int j1 = 0; j1 < e.size(); j1++)
            {
                i1.c(999, (com.umeng.message.proguard.y)e.get(j1));
            }

            a1.a(0x20000000, i1);
            b_().a(i1);
        }

        public final boolean a()
        {
            byte byte0 = f;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    f = 0;
                    return false;
                }
            }

            if (!W())
            {
                f = 0;
                return false;
            } else
            {
                f = 1;
                return true;
            }
        }

        public H b(int i1)
        {
            return (H)e.get(i1);
        }

        protected x.a b(p.b b1)
        {
            return a(b1);
        }

        public final P b_()
        {
            return d;
        }

        public int d()
        {
            int i1 = g;
            if (i1 != -1)
            {
                return i1;
            }
            i1 = 0;
            int j1 = 0;
            for (; i1 < e.size(); i1++)
            {
                j1 += com.umeng.message.proguard.i.g(999, (com.umeng.message.proguard.y)e.get(i1));
            }

            i1 = Z() + j1 + b_().d();
            g = i1;
            return i1;
        }

        public y i()
        {
            return c;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.G().a(com/umeng/message/proguard/j$y, com/umeng/message/proguard/j$y$a);
        }

        public com.umeng.message.proguard.B m()
        {
            return a;
        }

        public List n()
        {
            return e;
        }

        public List o()
        {
            return e;
        }

        public int p()
        {
            return e.size();
        }

        public a r()
        {
            return q();
        }

        public a s()
        {
            return a(this);
        }

        static 
        {
            c = new y(true);
            c.t();
        }

        private y(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws com.umeng.message.proguard.s
        {
            P.a a1;
            boolean flag;
            boolean flag2;
            flag2 = false;
            super();
            f = -1;
            g = -1;
            t();
            a1 = com.umeng.message.proguard.P.b();
            flag = false;
_L9:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i1 = h1.a();
            i1;
            JVM INSTR lookupswitch 2: default 286
        //                       0: 289
        //                       7994: 110;
               goto _L3 _L4 _L5
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!a(h1, a1, n1, i1))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L7; else goto _L6
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            e = new ArrayList();
            i1 = flag | true;
_L7:
            flag3 = i1;
            flag1 = i1;
            flag4 = i1;
            e.add(h1.a(G.a, n1));
            flag = i1;
            continue; /* Loop/switch isn't completed */
            h1;
            flag1 = flag3;
            throw h1.a(this);
            h1;
            if ((flag1 & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            throw h1;
            h1;
            flag1 = flag4;
            throw (new com.umeng.message.proguard.s(h1.getMessage())).a(this);
_L2:
            if ((flag & true))
            {
                e = Collections.unmodifiableList(e);
            }
            d = a1.b();
            ad();
            return;
_L4:
            flag2 = true;
            if (true) goto _L9; else goto _L8
_L8:
        }


        private y(p.c c1)
        {
            super(c1);
            f = -1;
            g = -1;
            d = c1.b_();
        }


        private y(boolean flag)
        {
            f = -1;
            g = -1;
            d = com.umeng.message.proguard.P.c();
        }
    }

    public static final class y.a extends p.c
        implements z
    {

        private int a;
        private List b;
        private com.umeng.message.proguard.D c;

        private void C()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private com.umeng.message.proguard.D D()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new com.umeng.message.proguard.D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.F();
        }

        static y.a x()
        {
            return z();
        }

        private void y()
        {
            if (com.umeng.message.proguard.p.m)
            {
                D();
            }
        }

        private static y.a z()
        {
            return new y.a();
        }

        public p.c A()
        {
            return q();
        }

        public p.c B()
        {
            return m();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.F();
        }

        public com.umeng.message.proguard.y Q()
        {
            return r();
        }

        public com.umeng.message.proguard.x R()
        {
            return r();
        }

        public a.a a(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public G a(int i1)
        {
            if (c == null)
            {
                return (G)b.get(i1);
            } else
            {
                return (G)c.a(i1);
            }
        }

        public y.a a(int i1, G.a a1)
        {
            if (c == null)
            {
                C();
                b.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.G());
                return this;
            }
        }

        public y.a a(int i1, G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, g1);
                return this;
            }
        }

        public y.a a(G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(a1.G());
                aF();
                return this;
            } else
            {
                c.a(a1.G());
                return this;
            }
        }

        public y.a a(G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(g1);
                return this;
            }
        }

        public y.a a(y y1)
        {
            com.umeng.message.proguard.D d1;
            d1 = null;
            if (y1 == y.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!y.b(y1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = y.b(y1);
                    a = a & -2;
                } else
                {
                    C();
                    b.addAll(y.b(y1));
                }
                aF();
            }
_L4:
            a(((p.d) (y1)));
            d(y1.b_());
            return this;
_L2:
            if (!y.b(y1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = y.b(y1);
                    a = a & -2;
                    if (com.umeng.message.proguard.p.m)
                    {
                        d1 = D();
                    }
                    c = d1;
                } else
                {
                    c.a(y.b(y1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public y.a a(Iterable iterable)
        {
            if (c == null)
            {
                C();
                com.umeng.message.proguard.p.c.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= p()) goto _L2; else goto _L1
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
            return q();
        }

        public com.umeng.message.proguard.x aj()
        {
            return t();
        }

        public com.umeng.message.proguard.x ak()
        {
            return s();
        }

        public com.umeng.message.proguard.y al()
        {
            return t();
        }

        public com.umeng.message.proguard.y am()
        {
            return s();
        }

        public b.a b(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public H b(int i1)
        {
            if (c == null)
            {
                return (H)b.get(i1);
            } else
            {
                return (H)c.c(i1);
            }
        }

        public y.a b(int i1, G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.G());
                return this;
            }
        }

        public y.a b(int i1, G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, g1);
                return this;
            }
        }

        public y.a c(int i1)
        {
            if (c == null)
            {
                C();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
                return this;
            }
        }

        public x.a c(com.umeng.message.proguard.x x1)
        {
            return d(x1);
        }

        public y.a c(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public G.a d(int i1)
        {
            return (G.a)D().b(i1);
        }

        public y.a d(com.umeng.message.proguard.x x1)
        {
            if (x1 instanceof y)
            {
                return a((y)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public G.a e(int i1)
        {
            return (G.a)D().c(i1, G.h());
        }

        public y.a e(com.umeng.message.proguard.h h1, com.umeng.message.proguard.n n1)
            throws IOException
        {
            h1 = (y)y.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (y)n1.a();
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
            return q();
        }

        public y.a g()
        {
            return q();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return q();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.G().a(com/umeng/message/proguard/j$y, com/umeng/message/proguard/j$y$a);
        }

        public y.a m()
        {
            super.B();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public y.a q()
        {
            return z().a(t());
        }

        public y r()
        {
            return y.h();
        }

        public y s()
        {
            y y1 = t();
            if (!y1.a())
            {
                throw b(y1);
            } else
            {
                return y1;
            }
        }

        public y t()
        {
            y y1 = new y(this);
            int i1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                y.a(y1, b);
            } else
            {
                y.a(y1, c.f());
            }
            aB();
            return y1;
        }

        public y.a u()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public G.a v()
        {
            return (G.a)D().b(G.h());
        }

        public List w()
        {
            return D().h();
        }

        private y.a()
        {
            b = Collections.emptyList();
            y();
        }

        private y.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

    }

    public static interface z
        extends p.e
    {

        public abstract G a(int i1);

        public abstract H b(int i1);

        public abstract List n();

        public abstract List o();

        public abstract int p();
    }


    private static k.a A;
    private static p.g B;
    private static k.a C;
    private static p.g D;
    private static k.a E;
    private static p.g F;
    private static k.a G;
    private static p.g H;
    private static k.a I;
    private static p.g J;
    private static k.a K;
    private static p.g L;
    private static k.a M;
    private static p.g N;
    private static k.g O;
    private static k.a a;
    private static p.g b;
    private static k.a c;
    private static p.g d;
    private static k.a e;
    private static p.g f;
    private static k.a g;
    private static p.g h;
    private static k.a i;
    private static p.g j;
    private static k.a k;
    private static p.g l;
    private static k.a m;
    private static p.g n;
    private static k.a o;
    private static p.g p;
    private static k.a q;
    private static p.g r;
    private static k.a s;
    private static p.g t;
    private static k.a u;
    private static p.g v;
    private static k.a w;
    private static p.g x;
    private static k.a y;
    private static p.g z;

    private com.umeng.message.proguard.j()
    {
    }

    static p.g A()
    {
        return z;
    }

    static k.a B()
    {
        return A;
    }

    static p.g C()
    {
        return B;
    }

    static k.a D()
    {
        return C;
    }

    static p.g E()
    {
        return D;
    }

    static k.a F()
    {
        return E;
    }

    static p.g G()
    {
        return F;
    }

    static k.a H()
    {
        return G;
    }

    static p.g I()
    {
        return H;
    }

    static k.a J()
    {
        return I;
    }

    static p.g K()
    {
        return J;
    }

    static k.a L()
    {
        return K;
    }

    static p.g M()
    {
        return L;
    }

    static k.a N()
    {
        return M;
    }

    static p.g O()
    {
        return N;
    }

    static k.a a(k.a a1)
    {
        a = a1;
        return a1;
    }

    public static k.g a()
    {
        return O;
    }

    static k.g a(k.g g1)
    {
        O = g1;
        return g1;
    }

    static p.g a(p.g g1)
    {
        b = g1;
        return g1;
    }

    public static void a(com.umeng.message.proguard.m m1)
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

    static p.g b(p.g g1)
    {
        d = g1;
        return g1;
    }

    static k.a c(k.a a1)
    {
        e = a1;
        return a1;
    }

    static p.g c()
    {
        return b;
    }

    static p.g c(p.g g1)
    {
        f = g1;
        return g1;
    }

    static k.a d()
    {
        return c;
    }

    static k.a d(k.a a1)
    {
        g = a1;
        return a1;
    }

    static p.g d(p.g g1)
    {
        h = g1;
        return g1;
    }

    static k.a e(k.a a1)
    {
        i = a1;
        return a1;
    }

    static p.g e()
    {
        return d;
    }

    static p.g e(p.g g1)
    {
        j = g1;
        return g1;
    }

    static k.a f()
    {
        return e;
    }

    static k.a f(k.a a1)
    {
        k = a1;
        return a1;
    }

    static p.g f(p.g g1)
    {
        l = g1;
        return g1;
    }

    static k.a g(k.a a1)
    {
        m = a1;
        return a1;
    }

    static p.g g()
    {
        return f;
    }

    static p.g g(p.g g1)
    {
        n = g1;
        return g1;
    }

    static k.a h()
    {
        return g;
    }

    static k.a h(k.a a1)
    {
        o = a1;
        return a1;
    }

    static p.g h(p.g g1)
    {
        p = g1;
        return g1;
    }

    static k.a i(k.a a1)
    {
        q = a1;
        return a1;
    }

    static p.g i()
    {
        return h;
    }

    static p.g i(p.g g1)
    {
        r = g1;
        return g1;
    }

    static k.a j()
    {
        return i;
    }

    static k.a j(k.a a1)
    {
        s = a1;
        return a1;
    }

    static p.g j(p.g g1)
    {
        t = g1;
        return g1;
    }

    static k.a k(k.a a1)
    {
        u = a1;
        return a1;
    }

    static p.g k()
    {
        return j;
    }

    static p.g k(p.g g1)
    {
        v = g1;
        return g1;
    }

    static k.a l()
    {
        return k;
    }

    static k.a l(k.a a1)
    {
        w = a1;
        return a1;
    }

    static p.g l(p.g g1)
    {
        x = g1;
        return g1;
    }

    static k.a m(k.a a1)
    {
        y = a1;
        return a1;
    }

    static p.g m()
    {
        return l;
    }

    static p.g m(p.g g1)
    {
        z = g1;
        return g1;
    }

    static k.a n()
    {
        return m;
    }

    static k.a n(k.a a1)
    {
        A = a1;
        return a1;
    }

    static p.g n(p.g g1)
    {
        B = g1;
        return g1;
    }

    static k.a o(k.a a1)
    {
        C = a1;
        return a1;
    }

    static p.g o()
    {
        return n;
    }

    static p.g o(p.g g1)
    {
        D = g1;
        return g1;
    }

    static k.a p()
    {
        return o;
    }

    static k.a p(k.a a1)
    {
        E = a1;
        return a1;
    }

    static p.g p(p.g g1)
    {
        F = g1;
        return g1;
    }

    static k.a q(k.a a1)
    {
        G = a1;
        return a1;
    }

    static p.g q()
    {
        return p;
    }

    static p.g q(p.g g1)
    {
        H = g1;
        return g1;
    }

    static k.a r()
    {
        return q;
    }

    static k.a r(k.a a1)
    {
        I = a1;
        return a1;
    }

    static p.g r(p.g g1)
    {
        J = g1;
        return g1;
    }

    static k.a s(k.a a1)
    {
        K = a1;
        return a1;
    }

    static p.g s()
    {
        return r;
    }

    static p.g s(p.g g1)
    {
        L = g1;
        return g1;
    }

    static k.a t()
    {
        return s;
    }

    static k.a t(k.a a1)
    {
        M = a1;
        return a1;
    }

    static p.g t(p.g g1)
    {
        N = g1;
        return g1;
    }

    static p.g u()
    {
        return t;
    }

    static k.a v()
    {
        return u;
    }

    static p.g w()
    {
        return v;
    }

    static k.a x()
    {
        return w;
    }

    static p.g y()
    {
        return x;
    }

    static k.a z()
    {
        return y;
    }

    static 
    {
        k.g.a a1 = new k.g.a() {

            public com.umeng.message.proguard.m a(k.g g1)
            {
                com.umeng.message.proguard.j.a(g1);
                com.umeng.message.proguard.j.a((k.a)com.umeng.message.proguard.j.a().e().get(0));
                com.umeng.message.proguard.j.a(new p.g(com.umeng.message.proguard.j.b(), new String[] {
                    "File"
                }));
                com.umeng.message.proguard.j.b((k.a)com.umeng.message.proguard.j.a().e().get(1));
                com.umeng.message.proguard.j.b(new p.g(com.umeng.message.proguard.j.d(), new String[] {
                    "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", 
                    "SourceCodeInfo"
                }));
                com.umeng.message.proguard.j.c((k.a)com.umeng.message.proguard.j.a().e().get(2));
                com.umeng.message.proguard.j.c(new p.g(com.umeng.message.proguard.j.f(), new String[] {
                    "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"
                }));
                com.umeng.message.proguard.j.d((k.a)com.umeng.message.proguard.j.f().j().get(0));
                com.umeng.message.proguard.j.d(new p.g(com.umeng.message.proguard.j.h(), new String[] {
                    "Start", "End"
                }));
                com.umeng.message.proguard.j.e((k.a)com.umeng.message.proguard.j.a().e().get(3));
                com.umeng.message.proguard.j.e(new p.g(com.umeng.message.proguard.j.j(), new String[] {
                    "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"
                }));
                com.umeng.message.proguard.j.f((k.a)com.umeng.message.proguard.j.a().e().get(4));
                com.umeng.message.proguard.j.f(new p.g(com.umeng.message.proguard.j.l(), new String[] {
                    "Name", "Value", "Options"
                }));
                com.umeng.message.proguard.j.g((k.a)com.umeng.message.proguard.j.a().e().get(5));
                com.umeng.message.proguard.j.g(new p.g(com.umeng.message.proguard.j.n(), new String[] {
                    "Name", "Number", "Options"
                }));
                com.umeng.message.proguard.j.h((k.a)com.umeng.message.proguard.j.a().e().get(6));
                com.umeng.message.proguard.j.h(new p.g(com.umeng.message.proguard.j.p(), new String[] {
                    "Name", "Method", "Options"
                }));
                com.umeng.message.proguard.j.i((k.a)com.umeng.message.proguard.j.a().e().get(7));
                com.umeng.message.proguard.j.i(new p.g(com.umeng.message.proguard.j.r(), new String[] {
                    "Name", "InputType", "OutputType", "Options"
                }));
                com.umeng.message.proguard.j.j((k.a)com.umeng.message.proguard.j.a().e().get(8));
                com.umeng.message.proguard.j.j(new p.g(com.umeng.message.proguard.j.t(), new String[] {
                    "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.k((k.a)com.umeng.message.proguard.j.a().e().get(9));
                com.umeng.message.proguard.j.k(new p.g(com.umeng.message.proguard.j.v(), new String[] {
                    "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.l((k.a)com.umeng.message.proguard.j.a().e().get(10));
                com.umeng.message.proguard.j.l(new p.g(com.umeng.message.proguard.j.x(), new String[] {
                    "Ctype", "Packed", "Lazy", "Deprecated", "ExperimentalMapKey", "Weak", "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.m((k.a)com.umeng.message.proguard.j.a().e().get(11));
                com.umeng.message.proguard.j.m(new p.g(com.umeng.message.proguard.j.z(), new String[] {
                    "AllowAlias", "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.n((k.a)com.umeng.message.proguard.j.a().e().get(12));
                com.umeng.message.proguard.j.n(new p.g(com.umeng.message.proguard.j.B(), new String[] {
                    "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.o((k.a)com.umeng.message.proguard.j.a().e().get(13));
                com.umeng.message.proguard.j.o(new p.g(com.umeng.message.proguard.j.D(), new String[] {
                    "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.p((k.a)com.umeng.message.proguard.j.a().e().get(14));
                com.umeng.message.proguard.j.p(new p.g(com.umeng.message.proguard.j.F(), new String[] {
                    "UninterpretedOption"
                }));
                com.umeng.message.proguard.j.q((k.a)com.umeng.message.proguard.j.a().e().get(15));
                com.umeng.message.proguard.j.q(new p.g(com.umeng.message.proguard.j.H(), new String[] {
                    "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"
                }));
                com.umeng.message.proguard.j.r((k.a)com.umeng.message.proguard.j.H().j().get(0));
                com.umeng.message.proguard.j.r(new p.g(com.umeng.message.proguard.j.J(), new String[] {
                    "NamePart", "IsExtension"
                }));
                com.umeng.message.proguard.j.s((k.a)com.umeng.message.proguard.j.a().e().get(16));
                com.umeng.message.proguard.j.s(new p.g(com.umeng.message.proguard.j.L(), new String[] {
                    "Location"
                }));
                com.umeng.message.proguard.j.t((k.a)com.umeng.message.proguard.j.L().j().get(0));
                com.umeng.message.proguard.j.t(new p.g(com.umeng.message.proguard.j.N(), new String[] {
                    "Path", "Span", "LeadingComments", "TrailingComments"
                }));
                return null;
            }

        };
        com.umeng.message.proguard.k.g.a(new String[] {
            "\n google/protobuf/descriptor.proto\022\017google.protobuf\"G\n\021FileDescriptorSet\0222\n\004file\030\001 \003(\0132$.google.protobuf.FileDescriptorProto\"\313\003\n\023FileDescriptorProto\022\f\n\004name\030\001 \001(\t\022\017\n\007package\030\002 \001(\t\022\022\n\ndependency\030\003 \003(\t\022\031\n\021public_dependency\030\n \003(\005\022\027\n\017weak_dependency\030\013 \003(\005\0226\n\fmessage_type\030\004 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\005 \003(\0132$.google.protobuf.EnumDescriptorProto\0228\n\007service\030\006 \003(\0132'.google.protobuf.", "ServiceDescriptorProto\0228\n\textension\030\007 \003(\0132%.google.protobuf.FieldDescriptorProto\022-\n\007options\030\b \001(\0132\034.google.protobuf.FileOptions\0229\n\020source_code_info\030\t \001(\0132\037.google.protobuf.SourceCodeInfo\"\251\003\n\017DescriptorProto\022\f\n\004name\030\001 \001(\t\0224\n\005field\030\002 \003(\0132%.google.protobuf.FieldDescriptorProto\0228\n\textension\030\006 \003(\0132%.google.protobuf.FieldDescriptorProto\0225\n\013nested_type\030\003 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type", "\030\004 \003(\0132$.google.protobuf.EnumDescriptorProto\022H\n\017extension_range\030\005 \003(\0132/.google.protobuf.DescriptorProto.ExtensionRange\0220\n\007options\030\007 \001(\0132\037.google.protobuf.MessageOptions\032,\n\016ExtensionRange\022\r\n\005start\030\001 \001(\005\022\013\n\003end\030\002 \001(\005\"\224\005\n\024FieldDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\003 \001(\005\022:\n\005label\030\004 \001(\0162+.google.protobuf.FieldDescriptorProto.Label\0228\n\004type\030\005 \001(\0162*.google.protobuf.FieldDescriptorProto.Type\022\021\n\ttype_name", "\030\006 \001(\t\022\020\n\bextendee\030\002 \001(\t\022\025\n\rdefault_value\030\007 \001(\t\022.\n\007options\030\b \001(\0132\035.google.protobuf.FieldOptions\"\266\002\n\004Type\022\017\n\013TYPE_DOUBLE\020\001\022\016\n\nTYPE_FLOAT\020\002\022\016\n\nTYPE_INT64\020\003\022\017\n\013TYPE_UINT64\020\004\022\016\n\nTYPE_INT32\020\005\022\020\n\fTYPE_FIXED64\020\006\022\020\n\fTYPE_FIXED32\020\007\022\r\n\tTYPE_BOOL\020\b\022\017\n\013TYPE_STRING\020\t\022\016\n\nTYPE_GROUP\020\n\022\020\n\fTYPE_MESSAGE\020\013\022\016\n\nTYPE_BYTES\020\f\022\017\n\013TYPE_UINT32\020\r\022\r\n\tTYPE_ENUM\020\016\022\021\n\rTYPE_SFIXED32\020\017\022\021\n\rTYPE_SFIXED64\020\020\022\017\n\013TYPE_SINT32\020\021\022\017\n\013TYPE_", "SINT64\020\022\"C\n\005Label\022\022\n\016LABEL_OPTIONAL\020\001\022\022\n\016LABEL_REQUIRED\020\002\022\022\n\016LABEL_REPEATED\020\003\"\214\001\n\023EnumDescriptorProto\022\f\n\004name\030\001 \001(\t\0228\n\005value\030\002 \003(\0132).google.protobuf.EnumValueDescriptorProto\022-\n\007options\030\003 \001(\0132\034.google.protobuf.EnumOptions\"l\n\030EnumValueDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\002 \001(\005\0222\n\007options\030\003 \001(\0132!.google.protobuf.EnumValueOptions\"\220\001\n\026ServiceDescriptorProto\022\f\n\004name\030\001 \001(\t\0226\n\006method\030\002 \003(\0132&.google.pro", "tobuf.MethodDescriptorProto\0220\n\007options\030\003 \001(\0132\037.google.protobuf.ServiceOptions\"\177\n\025MethodDescriptorProto\022\f\n\004name\030\001 \001(\t\022\022\n\ninput_type\030\002 \001(\t\022\023\n\013output_type\030\003 \001(\t\022/\n\007options\030\004 \001(\0132\036.google.protobuf.MethodOptions\"\351\003\n\013FileOptions\022\024\n\fjava_package\030\001 \001(\t\022\034\n\024java_outer_classname\030\b \001(\t\022\"\n\023java_multiple_files\030\n \001(\b:\005false\022,\n\035java_generate_equals_and_hash\030\024 \001(\b:\005false\022F\n\foptimize_for\030\t \001(\0162).google.protobuf.Fil", "eOptions.OptimizeMode:\005SPEED\022\022\n\ngo_package\030\013 \001(\t\022\"\n\023cc_generic_services\030\020 \001(\b:\005false\022$\n\025java_generic_services\030\021 \001(\b:\005false\022\"\n\023py_generic_services\030\022 \001(\b:\005false\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\022\t\n\005SPEED\020\001\022\r\n\tCODE_SIZE\020\002\022\020\n\fLITE_RUNTIME\020\003*\t\b\350\007\020\200\200\200\200\002\"\270\001\n\016MessageOptions\022&\n\027message_set_wire_format\030\001 \001(\b:\005false\022.\n\037no_standard_descriptor_accessor\030\002 \001(\b:\005", "false\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"\276\002\n\fFieldOptions\022:\n\005ctype\030\001 \001(\0162#.google.protobuf.FieldOptions.CType:\006STRING\022\016\n\006packed\030\002 \001(\b\022\023\n\004lazy\030\005 \001(\b:\005false\022\031\n\ndeprecated\030\003 \001(\b:\005false\022\034\n\024experimental_map_key\030\t \001(\t\022\023\n\004weak\030\n \001(\b:\005false\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption\"/\n\005CType\022\n\n\006STRING\020\000\022\b\n\004CORD\020\001\022\020\n\fSTRING_PIECE\020\002*\t\b\350\007", "\020\200\200\200\200\002\"x\n\013EnumOptions\022\031\n\013allow_alias\030\002 \001(\b:\004true\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"b\n\020EnumValueOptions\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"`\n\016ServiceOptions\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"_\n\rMethodOptions\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.Uninter", "pretedOption*\t\b\350\007\020\200\200\200\200\002\"\236\002\n\023UninterpretedOption\022;\n\004name\030\002 \003(\0132-.google.protobuf.UninterpretedOption.NamePart\022\030\n\020identifier_value\030\003 \001(\t\022\032\n\022positive_int_value\030\004 \001(\004\022\032\n\022negative_int_value\030\005 \001(\003\022\024\n\fdouble_value\030\006 \001(\001\022\024\n\fstring_value\030\007 \001(\f\022\027\n\017aggregate_value\030\b \001(\t\0323\n\bNamePart\022\021\n\tname_part\030\001 \002(\t\022\024\n\fis_extension\030\002 \002(\b\"\261\001\n\016SourceCodeInfo\022:\n\blocation\030\001 \003(\0132(.google.protobuf.SourceCodeInfo.Location\032c\n\bLocat", 
            "ion\022\020\n\004path\030\001 \003(\005B\002\020\001\022\020\n\004span\030\002 \003(\005B\002\020\001\022\030\n\020leading_comments\030\003 \001(\t\022\031\n\021trailing_comments\030\004 \001(\tB)\n\023com.google.protobufB\020DescriptorProtosH\001"
        }, new k.g[0], a1);
    }
}
