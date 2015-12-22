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
//            p, j, s, P, 
//            h, B, y, i, 
//            n, g, x, D, 
//            c, A

public static final class d extends p
    implements d
{
    public static final class a extends p.a
        implements j.F
    {

        private int a;
        private List b;
        private D c;

        private void A()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private D B()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.L();
        }

        static a x()
        {
            return z();
        }

        private void y()
        {
            if (p.m)
            {
                B();
            }
        }

        private static a z()
        {
            return new a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.L();
        }

        public y Q()
        {
            return r();
        }

        public x R()
        {
            return r();
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

        public a a(int i1, b.a a1)
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

        public a a(int i1, b b1)
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

        public a a(b.a a1)
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

        public a a(b b1)
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

        public a a(j.E e1)
        {
            D d1;
            d1 = null;
            if (e1 == j.E.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!j.E.b(e1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = j.E.b(e1);
                    a = a & -2;
                } else
                {
                    A();
                    b.addAll(j.E.b(e1));
                }
                aF();
            }
_L4:
            d(e1.b_());
            return this;
_L2:
            if (!j.E.b(e1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = j.E.b(e1);
                    a = a & -2;
                    if (p.m)
                    {
                        d1 = B();
                    }
                    c = d1;
                } else
                {
                    c.a(j.E.b(e1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(Iterable iterable)
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

        public b a(int i1)
        {
            if (c == null)
            {
                return (b)b.get(i1);
            } else
            {
                return (b)c.a(i1);
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

        public x aj()
        {
            return t();
        }

        public x ak()
        {
            return s();
        }

        public y al()
        {
            return t();
        }

        public y am()
        {
            return s();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(int i1, b.a a1)
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

        public a b(int i1, b b1)
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

        public c b(int i1)
        {
            if (c == null)
            {
                return (c)b.get(i1);
            } else
            {
                return (c)c.c(i1);
            }
        }

        public a c(int i1)
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
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.E)
            {
                return a((j.E)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public b.a d(int i1)
        {
            return (b.a)B().b(i1);
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

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.E)j.E.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.E)n1.a();
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

        public b.a e(int i1)
        {
            return (b.a)B().c(i1, b.h());
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

        public a m()
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

        public a q()
        {
            return z().a(t());
        }

        public j.E r()
        {
            return j.E.h();
        }

        public j.E s()
        {
            j.E e1 = t();
            if (!e1.a())
            {
                throw b(e1);
            } else
            {
                return e1;
            }
        }

        public j.E t()
        {
            j.E e1 = new j.E(this, null);
            int i1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                j.E.a(e1, b);
            } else
            {
                j.E.a(e1, c.f());
            }
            aB();
            return e1;
        }

        public a u()
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

        public b.a v()
        {
            return (b.a)B().b(b.h());
        }

        public List w()
        {
            return B().h();
        }

        private a()
        {
            b = Collections.emptyList();
            y();
        }

        private a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

        a(p.b b1, j._cls1 _pcls1)
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
        private static final b f;
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

        static int a(b b1, int i1)
        {
            b1.h = i1;
            return i1;
        }

        public static a a(b b1)
        {
            return x().a(b1);
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
            b1.n = obj;
            return obj;
        }

        static List a(b b1, List list)
        {
            b1.i = list;
            return list;
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

        static Object b(b b1, Object obj)
        {
            b1.o = obj;
            return obj;
        }

        static List b(b b1)
        {
            return b1.i;
        }

        static List b(b b1, List list)
        {
            b1.k = list;
            return list;
        }

        static List c(b b1)
        {
            return b1.k;
        }

        static Object d(b b1)
        {
            return b1.n;
        }

        static Object e(b b1)
        {
            return b1.o;
        }

        public static b h()
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

        public y Q()
        {
            return i();
        }

        public x R()
        {
            return i();
        }

        public int a(int i1)
        {
            return ((Integer)i.get(i1)).intValue();
        }

        protected a a(p.b b1)
        {
            return new a(b1, null);
        }

        public void a(i i1)
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

        public b i()
        {
            return f;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.O().a(com/umeng/message/proguard/j$E$b, com/umeng/message/proguard/j$E$b$a);
        }

        public B m()
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
            obj = (g)obj;
            String s1 = ((g) (obj)).h();
            if (((g) (obj)).i())
            {
                n = s1;
            }
            return s1;
        }

        public g t()
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
            obj = (g)obj;
            String s1 = ((g) (obj)).h();
            if (((g) (obj)).i())
            {
                o = s1;
            }
            return s1;
        }

        public g w()
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
            f = new b(true);
            f.A();
        }

        private b(h h1, n n1)
            throws s
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
            throw (new s(h1.getMessage())).a(this);
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

        b(h h1, n n1, j._cls1 _pcls1)
            throws s
        {
            this(h1, n1);
        }

        private b(p.a a1)
        {
            super(a1);
            j = -1;
            l = -1;
            p = -1;
            q = -1;
            g = a1.b_();
        }

        b(p.a a1, j._cls1 _pcls1)
        {
            this(a1);
        }

        private b(boolean flag)
        {
            j = -1;
            l = -1;
            p = -1;
            q = -1;
            g = com.umeng.message.proguard.P.c();
        }
    }

    public static final class b.a extends p.a
        implements c
    {

        private int a;
        private List b;
        private List c;
        private Object d;
        private Object e;

        static b.a F()
        {
            return H();
        }

        private void G()
        {
            if (!p.m);
        }

        private static b.a H()
        {
            return new b.a();
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

        public b A()
        {
            int i1 = 1;
            b b1 = new b(this, null);
            int k1 = a;
            if ((a & 1) == 1)
            {
                b = Collections.unmodifiableList(b);
                a = a & -2;
            }
            b.a(b1, b);
            if ((a & 2) == 2)
            {
                c = Collections.unmodifiableList(c);
                a = a & -3;
            }
            b.b(b1, c);
            int j1;
            if ((k1 & 4) != 4)
            {
                i1 = 0;
            }
            b.a(b1, d);
            j1 = i1;
            if ((k1 & 8) == 8)
            {
                j1 = i1 | 2;
            }
            b.b(b1, e);
            b.a(b1, j1);
            aB();
            return b1;
        }

        public b.a B()
        {
            b = Collections.emptyList();
            a = a & -2;
            aF();
            return this;
        }

        public b.a C()
        {
            c = Collections.emptyList();
            a = a & -3;
            aF();
            return this;
        }

        public b.a D()
        {
            a = a & -5;
            d = b.h().s();
            aF();
            return this;
        }

        public b.a E()
        {
            a = a & -9;
            e = b.h().v();
            aF();
            return this;
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.N();
        }

        public y Q()
        {
            return y();
        }

        public x R()
        {
            return y();
        }

        public int a(int i1)
        {
            return ((Integer)b.get(i1)).intValue();
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

        public b.a a(int i1, int j1)
        {
            I();
            b.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public b.a a(b b1)
        {
            if (b1 == b.h())
            {
                return this;
            }
            if (!b.b(b1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = b.b(b1);
                    a = a & -2;
                } else
                {
                    I();
                    b.addAll(b.b(b1));
                }
                aF();
            }
            if (!b.c(b1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = b.c(b1);
                    a = a & -3;
                } else
                {
                    K();
                    c.addAll(b.c(b1));
                }
                aF();
            }
            if (b1.r())
            {
                a = a | 4;
                d = b.d(b1);
                aF();
            }
            if (b1.u())
            {
                a = a | 8;
                e = b.e(b1);
                aF();
            }
            d(b1.b_());
            return this;
        }

        public b.a a(Iterable iterable)
        {
            I();
            com.umeng.message.proguard.p.a.a(iterable, b);
            aF();
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
            return x();
        }

        public x aj()
        {
            return A();
        }

        public x ak()
        {
            return z();
        }

        public y al()
        {
            return A();
        }

        public y am()
        {
            return z();
        }

        public int b(int i1)
        {
            return ((Integer)c.get(i1)).intValue();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public b.a b(int i1, int j1)
        {
            K();
            c.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public b.a b(Iterable iterable)
        {
            K();
            com.umeng.message.proguard.p.a.a(iterable, c);
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
                a = a | 8;
                e = s1;
                aF();
                return this;
            }
        }

        public b.a c(int i1)
        {
            I();
            b.add(Integer.valueOf(i1));
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
            return x();
        }

        public a.a d()
        {
            return x();
        }

        public b.a d(int i1)
        {
            K();
            c.add(Integer.valueOf(i1));
            aF();
            return this;
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

        public b.a f()
        {
            return x();
        }

        public b.a f(g g1)
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

        public b.a m()
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
                obj = ((g)obj).h();
                d = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g t()
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

        public boolean u()
        {
            return (a & 8) == 8;
        }

        public String v()
        {
            Object obj = e;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                e = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g w()
        {
            Object obj = e;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                e = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public b.a x()
        {
            return H().a(A());
        }

        public b y()
        {
            return b.h();
        }

        public b z()
        {
            b b1 = A();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        private b.a()
        {
            b = Collections.emptyList();
            c = Collections.emptyList();
            d = "";
            e = "";
            G();
        }

        private b.a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            c = Collections.emptyList();
            d = "";
            e = "";
            G();
        }

        b.a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }

    public static interface c
        extends A
    {

        public abstract int a(int i1);

        public abstract int b(int i1);

        public abstract List n();

        public abstract int o();

        public abstract List p();

        public abstract int q();

        public abstract boolean r();

        public abstract String s();

        public abstract g t();

        public abstract boolean u();

        public abstract String v();

        public abstract g w();
    }


    public static B a = new com.umeng.message.proguard.c() {

        public j.E c(h h1, n n1)
            throws s
        {
            return new j.E(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    private static final _cls1.c c;
    private static final long h = 0L;
    private final P d;
    private List e;
    private byte f;
    private int g;

    public static a a(c c1)
    {
        return q().a(c1);
    }

    public static a.a a(g g1)
        throws s
    {
        return (a.a)a.d(g1);
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

    static List a(a a1, List list)
    {
        a1.e = list;
        return list;
    }

    public static e b(InputStream inputstream)
        throws IOException
    {
        return (e)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static List b(a a1)
    {
        return a1.e;
    }

    public static e h()
    {
        return c;
    }

    public static final c k()
    {
        return j.L();
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

    public  M()
    {
        return s();
    }

    public s N()
    {
        return r();
    }

    public r O()
    {
        return s();
    }

    public s P()
    {
        return r();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    protected a a(i i1)
    {
        return new a(i1, null);
    }

    public b a(int i1)
    {
        return (b)e.get(i1);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        for (int j1 = 0; j1 < e.size(); j1++)
        {
            i1.c(1, (y)e.get(j1));
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

    protected e b(e e1)
    {
        return a(e1);
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
            j1 += com.umeng.message.proguard.i.g(1, (y)e.get(i1));
        }

        i1 = b_().d() + j1;
        g = i1;
        return i1;
    }

    public g i()
    {
        return c;
    }

    protected c l()
    {
        return j.M().a(com/umeng/message/proguard/j$E, com/umeng/message/proguard/j$E$a);
    }

    public B m()
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
        c = new <init>(true);
        c.t();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        boolean flag2;
        flag2 = false;
        super();
        f = -1;
        g = -1;
        t();
        _lcls1 = com.umeng.message.proguard.P.b();
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
    //                   0: 289
    //                   10: 110;
           goto _L3 _L4 _L5
_L3:
        flag3 = flag;
        flag1 = flag;
        flag4 = flag;
        if (!a(h1, _lcls1, n1, i1))
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
        d = _lcls1.b();
        ad();
        throw h1;
        h1;
        flag1 = flag4;
        throw (new s(h1.getMessage())).a(this);
_L2:
        if ((flag & true))
        {
            e = Collections.unmodifiableList(e);
        }
        d = _lcls1.b();
        ad();
        return;
_L4:
        flag2 = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        f = -1;
        g = -1;
        d = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        f = -1;
        g = -1;
        d = com.umeng.message.proguard.P.c();
    }
}
