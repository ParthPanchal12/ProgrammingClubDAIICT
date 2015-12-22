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
//            h, u, v, Q, 
//            B, i, y, g, 
//            n, x, D, L, 
//            c

public static final class o extends p
    implements o
{
    public static final class a extends p.a
        implements j.p
    {

        private int a;
        private Object b;
        private Object c;
        private v d;
        private List e;
        private List f;
        private List g;
        private D h;
        private List i;
        private D j;
        private List k;
        private D l;
        private List m;
        private D n;
        private j.s o;
        private L p;
        private j.E q;
        private L r;

        private void aG()
        {
            if (p.m)
            {
                aM();
                aO();
                aQ();
                aS();
                aT();
                aU();
            }
        }

        private static a aH()
        {
            return new a();
        }

        private void aI()
        {
            if ((a & 4) != 4)
            {
                d = new u(d);
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

        private D aM()
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
                h = new D(list, flag, aE(), aD());
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

        private D aO()
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
                j = new D(list, flag, aE(), aD());
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

        private D aQ()
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
                l = new D(list, flag, aE(), aD());
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

        private D aS()
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
                n = new D(list, flag, aE(), aD());
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

        static a az()
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

        public a I()
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

        public j.o M()
        {
            return j.o.h();
        }

        public j.o N()
        {
            j.o o1 = O();
            if (!o1.a())
            {
                throw b(o1);
            } else
            {
                return o1;
            }
        }

        public j.o O()
        {
            int i1 = 1;
            j.o o1 = new j.o(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            j.o.a(o1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            j.o.b(o1, c);
            if ((a & 4) == 4)
            {
                d = new Q(d);
                a = a & -5;
            }
            j.o.a(o1, d);
            if ((a & 8) == 8)
            {
                e = Collections.unmodifiableList(e);
                a = a & -9;
            }
            j.o.a(o1, e);
            if ((a & 0x10) == 16)
            {
                f = Collections.unmodifiableList(f);
                a = a & 0xffffffef;
            }
            j.o.b(o1, f);
            if (h == null)
            {
                if ((a & 0x20) == 32)
                {
                    g = Collections.unmodifiableList(g);
                    a = a & 0xffffffdf;
                }
                j.o.c(o1, g);
            } else
            {
                j.o.c(o1, h.f());
            }
            if (j == null)
            {
                if ((a & 0x40) == 64)
                {
                    i = Collections.unmodifiableList(i);
                    a = a & 0xffffffbf;
                }
                j.o.d(o1, i);
            } else
            {
                j.o.d(o1, j.f());
            }
            if (l == null)
            {
                if ((a & 0x80) == 128)
                {
                    k = Collections.unmodifiableList(k);
                    a = a & 0xffffff7f;
                }
                j.o.e(o1, k);
            } else
            {
                j.o.e(o1, l.f());
            }
            if (n == null)
            {
                if ((a & 0x100) == 256)
                {
                    m = Collections.unmodifiableList(m);
                    a = a & 0xfffffeff;
                }
                j.o.f(o1, m);
            } else
            {
                j.o.f(o1, n.f());
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
                j.o.a(o1, o);
            } else
            {
                j.o.a(o1, (j.s)p.d());
            }
            j1 = i1;
            if ((k1 & 0x400) == 1024)
            {
                j1 = i1 | 8;
            }
            if (r == null)
            {
                j.o.a(o1, q);
            } else
            {
                j.o.a(o1, (j.E)r.d());
            }
            j.o.a(o1, j1);
            aB();
            return o1;
        }

        public a P()
        {
            a = a & -2;
            b = j.o.h().o();
            aF();
            return this;
        }

        public y Q()
        {
            return M();
        }

        public x R()
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

        public j.s U()
        {
            if (p == null)
            {
                return o;
            } else
            {
                return (j.s)p.c();
            }
        }

        public j.t V()
        {
            if (p != null)
            {
                return (j.t)p.f();
            } else
            {
                return o;
            }
        }

        public boolean W()
        {
            return (a & 0x400) == 1024;
        }

        public j.E X()
        {
            if (r == null)
            {
                return q;
            } else
            {
                return (j.E)r.c();
            }
        }

        public j.F Y()
        {
            if (r != null)
            {
                return (j.F)r.f();
            } else
            {
                return q;
            }
        }

        public a Z()
        {
            a = a & -3;
            c = j.o.h().r();
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

        public a a(int i1, int j1)
        {
            aJ();
            e.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public a a(int i1, j.A.a a1)
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

        public a a(int i1, j.A a1)
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

        public a a(int i1, j.a.a a1)
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

        public a a(int i1, j.a a1)
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

        public a a(int i1, j.c.a a1)
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

        public a a(int i1, j.c c1)
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

        public a a(int i1, j.k.a a1)
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

        public a a(int i1, j.k k1)
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

        public a a(int i1, String s1)
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

        public a a(j.A.a a1)
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

        public a a(j.A a1)
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

        public a a(j.E.a a1)
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

        public a a(j.E e1)
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

        public a a(j.a.a a1)
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

        public a a(j.a a1)
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

        public a a(j.c.a a1)
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

        public a a(j.c c1)
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

        public a a(j.k.a a1)
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

        public a a(j.k k1)
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

        public a a(j.o o1)
        {
            Object obj = null;
            if (o1 == j.o.h())
            {
                return this;
            }
            if (o1.n())
            {
                a = a | 1;
                b = j.o.b(o1);
                aF();
            }
            if (o1.q())
            {
                a = a | 2;
                c = j.o.c(o1);
                aF();
            }
            if (!j.o.d(o1).isEmpty())
            {
                if (d.isEmpty())
                {
                    d = j.o.d(o1);
                    a = a & -5;
                } else
                {
                    aI();
                    d.addAll(j.o.d(o1));
                }
                aF();
            }
            if (!j.o.e(o1).isEmpty())
            {
                if (e.isEmpty())
                {
                    e = j.o.e(o1);
                    a = a & -9;
                } else
                {
                    aJ();
                    e.addAll(j.o.e(o1));
                }
                aF();
            }
            if (!j.o.f(o1).isEmpty())
            {
                if (f.isEmpty())
                {
                    f = j.o.f(o1);
                    a = a & 0xffffffef;
                } else
                {
                    aK();
                    f.addAll(j.o.f(o1));
                }
                aF();
            }
            if (h == null)
            {
                if (!j.o.g(o1).isEmpty())
                {
                    if (g.isEmpty())
                    {
                        g = j.o.g(o1);
                        a = a & 0xffffffdf;
                    } else
                    {
                        aL();
                        g.addAll(j.o.g(o1));
                    }
                    aF();
                }
            } else
            if (!j.o.g(o1).isEmpty())
            {
                if (h.d())
                {
                    h.b();
                    h = null;
                    g = j.o.g(o1);
                    a = a & 0xffffffdf;
                    D d1;
                    if (p.m)
                    {
                        d1 = aM();
                    } else
                    {
                        d1 = null;
                    }
                    h = d1;
                } else
                {
                    h.a(j.o.g(o1));
                }
            }
            if (j == null)
            {
                if (!j.o.h(o1).isEmpty())
                {
                    if (i.isEmpty())
                    {
                        i = j.o.h(o1);
                        a = a & 0xffffffbf;
                    } else
                    {
                        aN();
                        i.addAll(j.o.h(o1));
                    }
                    aF();
                }
            } else
            if (!j.o.h(o1).isEmpty())
            {
                if (j.d())
                {
                    j.b();
                    j = null;
                    i = j.o.h(o1);
                    a = a & 0xffffffbf;
                    D d2;
                    if (p.m)
                    {
                        d2 = aO();
                    } else
                    {
                        d2 = null;
                    }
                    j = d2;
                } else
                {
                    j.a(j.o.h(o1));
                }
            }
            if (l == null)
            {
                if (!j.o.i(o1).isEmpty())
                {
                    if (k.isEmpty())
                    {
                        k = j.o.i(o1);
                        a = a & 0xffffff7f;
                    } else
                    {
                        aP();
                        k.addAll(j.o.i(o1));
                    }
                    aF();
                }
            } else
            if (!j.o.i(o1).isEmpty())
            {
                if (l.d())
                {
                    l.b();
                    l = null;
                    k = j.o.i(o1);
                    a = a & 0xffffff7f;
                    D d3;
                    if (p.m)
                    {
                        d3 = aQ();
                    } else
                    {
                        d3 = null;
                    }
                    l = d3;
                } else
                {
                    l.a(j.o.i(o1));
                }
            }
            if (n == null)
            {
                if (!j.o.j(o1).isEmpty())
                {
                    if (m.isEmpty())
                    {
                        m = j.o.j(o1);
                        a = a & 0xfffffeff;
                    } else
                    {
                        aR();
                        m.addAll(j.o.j(o1));
                    }
                    aF();
                }
            } else
            if (!j.o.j(o1).isEmpty())
            {
                if (n.d())
                {
                    n.b();
                    n = null;
                    m = j.o.j(o1);
                    a = a & 0xfffffeff;
                    D d4 = obj;
                    if (p.m)
                    {
                        d4 = aS();
                    }
                    n = d4;
                } else
                {
                    n.a(j.o.j(o1));
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

        public a a(j.s.a a1)
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

        public a a(j.s s1)
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

        public a a(Iterable iterable)
        {
            aI();
            com.umeng.message.proguard.p.a.a(iterable, d);
            aF();
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

        public a aa()
        {
            d = u.a;
            a = a & -5;
            aF();
            return this;
        }

        public a ab()
        {
            e = Collections.emptyList();
            a = a & -9;
            aF();
            return this;
        }

        public a ac()
        {
            f = Collections.emptyList();
            a = a & 0xffffffef;
            aF();
            return this;
        }

        public a ad()
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

        public j.a.a ae()
        {
            return (j.a.a)aM().b(com.umeng.message.proguard.j.a.h());
        }

        public List af()
        {
            return aM().h();
        }

        public a ag()
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

        public x aj()
        {
            return O();
        }

        public x ak()
        {
            return N();
        }

        public y al()
        {
            return O();
        }

        public y am()
        {
            return N();
        }

        public j.c.a an()
        {
            return (j.c.a)aO().b(com.umeng.message.proguard.j.c.h());
        }

        public List ao()
        {
            return aO().h();
        }

        public a ap()
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

        public j.A.a aq()
        {
            return (j.A.a)aQ().b(com.umeng.message.proguard.j.A.h());
        }

        public List ar()
        {
            return aQ().h();
        }

        public a as()
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

        public j.k.a at()
        {
            return (j.k.a)aS().b(com.umeng.message.proguard.j.k.h());
        }

        public List au()
        {
            return aS().h();
        }

        public a av()
        {
            if (p == null)
            {
                o = com.umeng.message.proguard.j.s.h();
                aF();
            } else
            {
                p.g();
            }
            a = a & 0xfffffdff;
            return this;
        }

        public j.s.a aw()
        {
            a = a | 0x200;
            aF();
            return (j.s.a)aT().e();
        }

        public a ax()
        {
            if (r == null)
            {
                q = com.umeng.message.proguard.j.E.h();
                aF();
            } else
            {
                r.g();
            }
            a = a & 0xfffffbff;
            return this;
        }

        public j.E.a ay()
        {
            a = a | 0x400;
            aF();
            return (j.E.a)aU().e();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public g b(int i1)
        {
            return d.c(i1);
        }

        public a b(int i1, int j1)
        {
            aK();
            f.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public a b(int i1, j.A.a a1)
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

        public a b(int i1, j.A a1)
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

        public a b(int i1, j.a.a a1)
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

        public a b(int i1, j.a a1)
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

        public a b(int i1, j.c.a a1)
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

        public a b(int i1, j.c c1)
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

        public a b(int i1, j.k.a a1)
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

        public a b(int i1, j.k k1)
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

        public a b(j.E e1)
        {
            if (r == null)
            {
                if ((a & 0x400) == 1024 && q != com.umeng.message.proguard.j.E.h())
                {
                    q = com.umeng.message.proguard.j.E.a(q).a(e1).t();
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

        public a b(j.s s1)
        {
            if (p == null)
            {
                if ((a & 0x200) == 512 && o != com.umeng.message.proguard.j.s.h())
                {
                    o = com.umeng.message.proguard.j.s.a(o).a(s1).O();
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

        public a b(Iterable iterable)
        {
            aJ();
            com.umeng.message.proguard.p.a.a(iterable, e);
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

        public int c(int i1)
        {
            return ((Integer)e.get(i1)).intValue();
        }

        public a c(Iterable iterable)
        {
            aK();
            com.umeng.message.proguard.p.a.a(iterable, f);
            aF();
            return this;
        }

        public a c(String s1)
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

        public int d(int i1)
        {
            return ((Integer)f.get(i1)).intValue();
        }

        public a.a d()
        {
            return I();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.o)
            {
                return a((j.o)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public a d(Iterable iterable)
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

        public x.a d(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public j.a e(int i1)
        {
            if (h == null)
            {
                return (j.a)g.get(i1);
            } else
            {
                return (j.a)h.a(i1);
            }
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
            h1 = (j.o)j.o.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.o)n1.a();
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

        public a e(Iterable iterable)
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

        public j.b f(int i1)
        {
            if (h == null)
            {
                return (j.b)g.get(i1);
            } else
            {
                return (j.b)h.c(i1);
            }
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

        public a f(Iterable iterable)
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

        public j.c g(int i1)
        {
            if (j == null)
            {
                return (j.c)i.get(i1);
            } else
            {
                return (j.c)j.a(i1);
            }
        }

        public a g(g g1)
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

        public a g(Iterable iterable)
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

        public j.d h(int i1)
        {
            if (j == null)
            {
                return (j.d)i.get(i1);
            } else
            {
                return (j.d)j.c(i1);
            }
        }

        public y.a h()
        {
            return m();
        }

        public j.A i(int i1)
        {
            if (l == null)
            {
                return (j.A)k.get(i1);
            } else
            {
                return (j.A)l.a(i1);
            }
        }

        public x.a i()
        {
            return I();
        }

        public j.B j(int i1)
        {
            if (l == null)
            {
                return (j.B)k.get(i1);
            } else
            {
                return (j.B)l.c(i1);
            }
        }

        public x.a j()
        {
            return m();
        }

        public j.k k(int i1)
        {
            if (n == null)
            {
                return (j.k)m.get(i1);
            } else
            {
                return (j.k)n.a(i1);
            }
        }

        public j.l l(int i1)
        {
            if (n == null)
            {
                return (j.l)m.get(i1);
            } else
            {
                return (j.l)n.c(i1);
            }
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.e().a(com/umeng/message/proguard/j$o, com/umeng/message/proguard/j$o$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = u.a;
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
                o = com.umeng.message.proguard.j.s.h();
            } else
            {
                p.g();
            }
            a = a & 0xfffffdff;
            if (r == null)
            {
                q = com.umeng.message.proguard.j.E.h();
            } else
            {
                r.g();
            }
            a = a & 0xfffffbff;
            return this;
        }

        public a m(int i1)
        {
            aJ();
            e.add(Integer.valueOf(i1));
            aF();
            return this;
        }

        public a n(int i1)
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

        public a o(int i1)
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

        public j.a.a p(int i1)
        {
            return (j.a.a)aM().b(i1);
        }

        public j.a.a q(int i1)
        {
            return (j.a.a)aM().c(i1, com.umeng.message.proguard.j.a.h());
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public a r(int i1)
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

        public j.c.a s(int i1)
        {
            return (j.c.a)aO().b(i1);
        }

        public j.c.a t(int i1)
        {
            return (j.c.a)aO().c(i1, com.umeng.message.proguard.j.c.h());
        }

        public List t()
        {
            return Collections.unmodifiableList(d);
        }

        public int u()
        {
            return d.size();
        }

        public a u(int i1)
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

        public j.A.a v(int i1)
        {
            return (j.A.a)aQ().b(i1);
        }

        public List v()
        {
            return Collections.unmodifiableList(e);
        }

        public int w()
        {
            return e.size();
        }

        public j.A.a w(int i1)
        {
            return (j.A.a)aQ().c(i1, com.umeng.message.proguard.j.A.h());
        }

        public a x(int i1)
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

        public j.k.a y(int i1)
        {
            return (j.k.a)aS().b(i1);
        }

        public j.k.a z(int i1)
        {
            return (j.k.a)aS().c(i1, com.umeng.message.proguard.j.k.h());
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

        private a()
        {
            b = "";
            c = "";
            d = u.a;
            e = Collections.emptyList();
            f = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = Collections.emptyList();
            o = com.umeng.message.proguard.j.s.h();
            q = com.umeng.message.proguard.j.E.h();
            aG();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            d = u.a;
            e = Collections.emptyList();
            f = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = Collections.emptyList();
            o = com.umeng.message.proguard.j.s.h();
            q = com.umeng.message.proguard.j.E.h();
            aG();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    private static final long D = 0L;
    public static B a = new c() {

        public j.o c(h h1, n n1)
            throws s
        {
            return new j.o(h1, n1, null);
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
    public static final int e = 10;
    public static final int f = 11;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 8;
    public static final int l = 9;
    private static final _cls1.c n;
    private _cls1.c A;
    private byte B;
    private int C;
    private final P o;
    private int p;
    private Object q;
    private Object r;
    private v s;
    private List t;
    private List u;
    private List v;
    private List w;
    private List x;
    private List y;
    private _cls1.c z;

    public static a Z()
    {
        return a.az();
    }

    static int a(a.az az, int i1)
    {
        az.p = i1;
        return i1;
    }

    static p a(p p1, p p2)
    {
        p1.A = p2;
        return p2;
    }

    public static a a(A a1)
    {
        return Z().a(a1);
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

    static a a(a a1, a a2)
    {
        a1.z = a2;
        return a2;
    }

    static v a(z z1, v v1)
    {
        z1.s = v1;
        return v1;
    }

    static Object a(s s1, Object obj)
    {
        s1.q = obj;
        return obj;
    }

    static List a(q q1, List list)
    {
        q1.t = list;
        return list;
    }

    private void ae()
    {
        q = "";
        r = "";
        s = u.a;
        t = Collections.emptyList();
        u = Collections.emptyList();
        v = Collections.emptyList();
        w = Collections.emptyList();
        x = Collections.emptyList();
        y = Collections.emptyList();
        z = h();
        A = h();
    }

    public static h b(InputStream inputstream)
        throws IOException
    {
        return (h)a.f(inputstream);
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

    static Object b(q q1, Object obj)
    {
        q1.r = obj;
        return obj;
    }

    static List b(r r1, List list)
    {
        r1.u = list;
        return list;
    }

    static Object c(u u1)
    {
        return u1.r;
    }

    static List c(r r1, List list)
    {
        r1.v = list;
        return list;
    }

    static v d(v v1)
    {
        return v1.s;
    }

    static List d(s s1, List list)
    {
        s1.w = list;
        return list;
    }

    static List e(w w1)
    {
        return w1.t;
    }

    static List e(t t1, List list)
    {
        t1.x = list;
        return list;
    }

    static List f(x x1)
    {
        return x1.u;
    }

    static List f(u u1, List list)
    {
        u1.y = list;
        return list;
    }

    static List g(y y1)
    {
        return y1.v;
    }

    public static v h()
    {
        return n;
    }

    static List h(n n1)
    {
        return n1.w;
    }

    static List i(w w1)
    {
        return w1.x;
    }

    static List j(x x1)
    {
        return x1.y;
    }

    public static final y k()
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

    public y M()
    {
        return ab();
    }

    public ab N()
    {
        return aa();
    }

    public aa O()
    {
        return ab();
    }

    public ab P()
    {
        return aa();
    }

    public y Q()
    {
        return i();
    }

    public x R()
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

    public p U()
    {
        return z;
    }

    public z V()
    {
        return z;
    }

    public boolean W()
    {
        return (p & 8) == 8;
    }

    public p X()
    {
        return A;
    }

    public A Y()
    {
        return A;
    }

    protected a a(A a1)
    {
        return new a(a1, null);
    }

    public String a(int i1)
    {
        return (String)s.get(i1);
    }

    public void a(i i1)
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
            i1.c(4, (y)v.get(k1));
        }

        for (int l1 = 0; l1 < w.size(); l1++)
        {
            i1.c(5, (y)w.get(l1));
        }

        for (int i2 = 0; i2 < x.size(); i2++)
        {
            i1.c(6, (y)x.get(i2));
        }

        for (int j2 = 0; j2 < y.size(); j2++)
        {
            i1.c(7, (y)y.get(j2));
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

    public g b(int i1)
    {
        return s.c(i1);
    }

    protected s b(s s1)
    {
        return a(s1);
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
            i1 += com.umeng.message.proguard.i.g(4, (y)v.get(j1));
        }

        for (j1 = 0; j1 < w.size(); j1++)
        {
            i1 += com.umeng.message.proguard.i.g(5, (y)w.get(j1));
        }

        for (j1 = 0; j1 < x.size(); j1++)
        {
            i1 += com.umeng.message.proguard.i.g(6, (y)x.get(j1));
        }

        for (j1 = 0; j1 < y.size(); j1++)
        {
            i1 += com.umeng.message.proguard.i.g(7, (y)y.get(j1));
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

    public u e(int i1)
    {
        return (u)v.get(i1);
    }

    public v f(int i1)
    {
        return (v)v.get(i1);
    }

    public v g(int i1)
    {
        return (v)w.get(i1);
    }

    public w h(int i1)
    {
        return (w)w.get(i1);
    }

    public w i(int i1)
    {
        return (w)x.get(i1);
    }

    public x i()
    {
        return n;
    }

    public n j(int i1)
    {
        return (n)x.get(i1);
    }

    public x k(int i1)
    {
        return (x)y.get(i1);
    }

    public y l(int i1)
    {
        return (y)y.get(i1);
    }

    protected y l()
    {
        return com.umeng.message.proguard.j.e().a(com/umeng/message/proguard/j$o, com/umeng/message/proguard/j$o$a);
    }

    public B m()
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
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            q = s1;
        }
        return s1;
    }

    public g p()
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
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            r = s1;
        }
        return s1;
    }

    public g s()
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
        n = new <init>(true);
        n.ae();
    }

    private a(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        int j1;
        B = -1;
        C = -1;
        ae();
        i1 = 0;
        _lcls1 = com.umeng.message.proguard.P.b();
        j1 = 0;
_L73:
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        int k1 = i1;
        int j2 = h1.a();
        j2;
        JVM INSTR lookupswitch 14: default 1747
    //                   0: 1765
    //                   10: 199
    //                   18: 240
    //                   26: 281
    //                   34: 346
    //                   42: 419
    //                   50: 492
    //                   58: 568
    //                   66: 644
    //                   74: 747
    //                   80: 853
    //                   82: 925
    //                   88: 1242
    //                   90: 1314;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L3:
        k1 = i1;
        Object obj;
        int k2;
        int l2;
        if (!a(h1, _lcls1, n1, j2))
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
        s = new u();
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
        v.add(h1.a(a, n1));
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
        w.add(h1.a(a, n1));
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
        x.add(h1.a(a, n1));
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
        y.add(h1.a(a, n1));
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
        z = (z)h1.a(a, n1);
        if (obj == null) goto _L32; else goto _L31
_L31:
        k1 = i1;
        ((a) (obj)).a(z);
        k1 = i1;
        z = ((a) (obj)).O();
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
        A = (A)h1.a(a, n1);
        if (obj == null) goto _L36; else goto _L35
_L35:
        k1 = i1;
        ((a) (obj)).a(A);
        k1 = i1;
        A = ((a) (obj)).t();
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
        o = _lcls1.b();
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
        throw (new s(h1.getMessage())).a(this);
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
        o = _lcls1.b();
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

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        B = -1;
        C = -1;
        o = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        B = -1;
        C = -1;
        o = com.umeng.message.proguard.P.c();
    }
}
