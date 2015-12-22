// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, u, p, D, 
//            L, Q, v, s, 
//            B, g, y, x, 
//            h, n

public static final class <init> extends <init>
    implements <init>
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
    private h o;
    private L p;
    private h q;
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

    private static aU aH()
    {
        return new <init>();
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

    static r az()
    {
        return aH();
    }

    public static final aH k()
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

    public l I()
    {
        return aH().a(O());
    }

    public O J()
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

    public m M()
    {
        return m();
    }

    public m N()
    {
        m m1 = O();
        if (!m1.O())
        {
            throw b(m1);
        } else
        {
            return m1;
        }
    }

    public b O()
    {
        int i1 = 1;
        b b1 = new nit>(this, null);
        int k1 = a;
        int j1;
        if ((k1 & 1) != 1)
        {
            i1 = 0;
        }
        a(b1, b);
        j1 = i1;
        if ((k1 & 2) == 2)
        {
            j1 = i1 | 2;
        }
        b(b1, c);
        if ((a & 4) == 4)
        {
            d = new Q(d);
            a = a & -5;
        }
        a(b1, d);
        if ((a & 8) == 8)
        {
            e = Collections.unmodifiableList(e);
            a = a & -9;
        }
        a(b1, e);
        if ((a & 0x10) == 16)
        {
            f = Collections.unmodifiableList(f);
            a = a & 0xffffffef;
        }
        a(b1, f);
        if (h == null)
        {
            if ((a & 0x20) == 32)
            {
                g = Collections.unmodifiableList(g);
                a = a & 0xffffffdf;
            }
            a(b1, g);
        } else
        {
            g(b1, h.f());
        }
        if (j == null)
        {
            if ((a & 0x40) == 64)
            {
                i = Collections.unmodifiableList(i);
                a = a & 0xffffffbf;
            }
            a(b1, i);
        } else
        {
            i(b1, j.f());
        }
        if (l == null)
        {
            if ((a & 0x80) == 128)
            {
                k = Collections.unmodifiableList(k);
                a = a & 0xffffff7f;
            }
            a(b1, k);
        } else
        {
            k(b1, l.f());
        }
        if (n == null)
        {
            if ((a & 0x100) == 256)
            {
                m = Collections.unmodifiableList(m);
                a = a & 0xfffffeff;
            }
            a(b1, m);
        } else
        {
            m(b1, n.f());
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
            p(b1, o);
        } else
        {
            o(b1, (o)p.d());
        }
        j1 = i1;
        if ((k1 & 0x400) == 1024)
        {
            j1 = i1 | 8;
        }
        if (r == null)
        {
            r(b1, q);
        } else
        {
            q(b1, (q)r.d());
        }
        r(b1, j1);
        aB();
        return b1;
    }

    public aB P()
    {
        a = a & -2;
        b = b().b();
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

    public a U()
    {
        if (p == null)
        {
            return o;
        } else
        {
            return (o)p.c();
        }
    }

    public p V()
    {
        if (p != null)
        {
            return (p)p.f();
        } else
        {
            return o;
        }
    }

    public boolean W()
    {
        return (a & 0x400) == 1024;
    }

    public a X()
    {
        if (r == null)
        {
            return q;
        } else
        {
            return (q)r.c();
        }
    }

    public r Y()
    {
        if (r != null)
        {
            return (r)r.f();
        } else
        {
            return q;
        }
    }

    public q Z()
    {
        a = a & -3;
        c = c().c();
        aF();
        return this;
    }

    public aF a(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e a(x x1)
    {
        return d(x1);
    }

    public d a(int i1, int j1)
    {
        aJ();
        e.set(i1, Integer.valueOf(j1));
        aF();
        return this;
    }

    public aF a(int i1, aF af1)
    {
        if (l == null)
        {
            aP();
            k.set(i1, af1.y());
            aF();
            return this;
        } else
        {
            l.a(i1, af1.y());
            return this;
        }
    }

    public y a(int i1, y y1)
    {
        if (l == null)
        {
            if (y1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aP();
                k.set(i1, y1);
                aF();
                return this;
            }
        } else
        {
            l.a(i1, y1);
            return this;
        }
    }

    public l a(int i1, l l1)
    {
        if (h == null)
        {
            aL();
            g.set(i1, l1.L());
            aF();
            return this;
        } else
        {
            h.a(i1, l1.L());
            return this;
        }
    }

    public L a(int i1, L l1)
    {
        if (h == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aL();
                g.set(i1, l1);
                aF();
                return this;
            }
        } else
        {
            h.a(i1, l1);
            return this;
        }
    }

    public h a(int i1, h h1)
    {
        if (j == null)
        {
            aN();
            i.set(i1, h1.y());
            aF();
            return this;
        } else
        {
            j.a(i1, h1.y());
            return this;
        }
    }

    public y a(int i1, y y1)
    {
        if (j == null)
        {
            if (y1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aN();
                i.set(i1, y1);
                aF();
                return this;
            }
        } else
        {
            j.a(i1, y1);
            return this;
        }
    }

    public j a(int i1, j j1)
    {
        if (n == null)
        {
            aR();
            m.set(i1, j1.L());
            aF();
            return this;
        } else
        {
            n.a(i1, j1.L());
            return this;
        }
    }

    public L a(int i1, L l1)
    {
        if (n == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aR();
                m.set(i1, l1);
                aF();
                return this;
            }
        } else
        {
            n.a(i1, l1);
            return this;
        }
    }

    public n a(int i1, String s1)
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

    public aF a(aF af1)
    {
        if (l == null)
        {
            aP();
            k.add(af1.y());
            aF();
            return this;
        } else
        {
            l.a(af1.y());
            return this;
        }
    }

    public y a(y y1)
    {
        if (l == null)
        {
            if (y1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aP();
                k.add(y1);
                aF();
                return this;
            }
        } else
        {
            l.a(y1);
            return this;
        }
    }

    public l a(l l1)
    {
        if (r == null)
        {
            q = l1.s();
            aF();
        } else
        {
            r.a(l1.s());
        }
        a = a | 0x400;
        return this;
    }

    public a a(a a1)
    {
        if (r == null)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            }
            q = a1;
            aF();
        } else
        {
            r.a(a1);
        }
        a = a | 0x400;
        return this;
    }

    public a a(a a1)
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

    public L a(L l1)
    {
        if (h == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aL();
                g.add(l1);
                aF();
                return this;
            }
        } else
        {
            h.a(l1);
            return this;
        }
    }

    public h a(h h1)
    {
        if (j == null)
        {
            aN();
            i.add(h1.y());
            aF();
            return this;
        } else
        {
            j.a(h1.y());
            return this;
        }
    }

    public y a(y y1)
    {
        if (j == null)
        {
            if (y1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aN();
                i.add(y1);
                aF();
                return this;
            }
        } else
        {
            j.a(y1);
            return this;
        }
    }

    public j a(j j1)
    {
        if (n == null)
        {
            aR();
            m.add(j1.L());
            aF();
            return this;
        } else
        {
            n.a(j1.L());
            return this;
        }
    }

    public L a(L l1)
    {
        if (n == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aR();
                m.add(l1);
                aF();
                return this;
            }
        } else
        {
            n.a(l1);
            return this;
        }
    }

    public n a(n n1)
    {
        Object obj = null;
        if (n1 == n())
        {
            return this;
        }
        if (n1.n())
        {
            a = a | 1;
            b = b(n1);
            aF();
        }
        if (n1.aF())
        {
            a = a | 2;
            c = c(n1);
            aF();
        }
        if (!aF(n1).isEmpty())
        {
            if (d.isEmpty())
            {
                d = d(n1);
                a = a & -5;
            } else
            {
                aI();
                d.addAll(ll(n1));
            }
            aF();
        }
        if (!aF(n1).isEmpty())
        {
            if (e.isEmpty())
            {
                e = e(n1);
                a = a & -9;
            } else
            {
                aJ();
                e.addAll(e(n1));
            }
            aF();
        }
        if (!aF(n1).isEmpty())
        {
            if (f.isEmpty())
            {
                f = f(n1);
                a = a & 0xffffffef;
            } else
            {
                aK();
                f.addAll(f(n1));
            }
            aF();
        }
        if (h == null)
        {
            if (!h(n1).isEmpty())
            {
                if (g.isEmpty())
                {
                    g = g(n1);
                    a = a & 0xffffffdf;
                } else
                {
                    aL();
                    g.addAll(g(n1));
                }
                aF();
            }
        } else
        if (!aF(n1).isEmpty())
        {
            if (h.d())
            {
                h.b();
                h = null;
                g = g(n1);
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
                h.a(h(n1));
            }
        }
        if (j == null)
        {
            if (!j(n1).isEmpty())
            {
                if (i.isEmpty())
                {
                    i = i(n1);
                    a = a & 0xffffffbf;
                } else
                {
                    aN();
                    i.addAll(i(n1));
                }
                aF();
            }
        } else
        if (!aF(n1).isEmpty())
        {
            if (j.d())
            {
                j.b();
                j = null;
                i = i(n1);
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
                j.a(j(n1));
            }
        }
        if (l == null)
        {
            if (!l(n1).isEmpty())
            {
                if (k.isEmpty())
                {
                    k = k(n1);
                    a = a & 0xffffff7f;
                } else
                {
                    aP();
                    k.addAll(k(n1));
                }
                aF();
            }
        } else
        if (!aF(n1).isEmpty())
        {
            if (l.d())
            {
                l.b();
                l = null;
                k = k(n1);
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
                l.a(l(n1));
            }
        }
        if (n == null)
        {
            if (!n(n1).isEmpty())
            {
                if (m.isEmpty())
                {
                    m = m(n1);
                    a = a & 0xfffffeff;
                } else
                {
                    aR();
                    m.addAll(m(n1));
                }
                aF();
            }
        } else
        if (!aF(n1).isEmpty())
        {
            if (n.d())
            {
                n.b();
                n = null;
                m = m(n1);
                a = a & 0xfffffeff;
                D d4 = obj;
                if (p.m)
                {
                    d4 = aS();
                }
                n = d4;
            } else
            {
                n.a(n(n1));
            }
        }
        if (n1.n())
        {
            b(n1.b());
        }
        if (n1.b())
        {
            b(n1.b());
        }
        d(n1.());
        return this;
    }

    public  a( )
    {
        if (p == null)
        {
            o = .N();
            aF();
        } else
        {
            p.a(.N());
        }
        a = a | 0x200;
        return this;
    }

    public a a(a a1)
    {
        if (p == null)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            }
            o = a1;
            aF();
        } else
        {
            p.a(a1);
        }
        a = a | 0x200;
        return this;
    }

    public a a(Iterable iterable)
    {
        aI();
        aI(iterable, d);
        aF();
        return this;
    }

    public aF a(String s1)
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
        if (e(i1).e()) goto _L4; else goto _L3
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
        if (!g(i1).g()) goto _L3; else goto _L5
_L5:
        i1++;
          goto _L6
        i1 = 0;
_L8:
        if (i1 >= H())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (!i(i1).i()) goto _L3; else goto _L7
_L7:
        i1++;
          goto _L8
        i1 = 0;
_L10:
        if (i1 >= S())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!k(i1).k()) goto _L3; else goto _L9
_L9:
        i1++;
          goto _L10
        if (T() && !U().U()) goto _L3; else goto _L11
_L11:
        return true;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public U aa()
    {
        d = u.a;
        a = a & -5;
        aF();
        return this;
    }

    public aF ab()
    {
        e = Collections.emptyList();
        a = a & -9;
        aF();
        return this;
    }

    public aF ac()
    {
        f = Collections.emptyList();
        a = a & 0xffffffef;
        aF();
        return this;
    }

    public aF ad()
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

    public h ae()
    {
        return (h)aM().b(aM());
    }

    public List af()
    {
        return aM().h();
    }

    public aM ag()
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

    public j ah()
    {
        return m();
    }

    public m ai()
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

    public N an()
    {
        return (N)aO().b(aO());
    }

    public List ao()
    {
        return aO().h();
    }

    public aO ap()
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

    public l aq()
    {
        return (l)aQ().b(aQ());
    }

    public List ar()
    {
        return aQ().h();
    }

    public aQ as()
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

    public n at()
    {
        return (n)aS().b(aS());
    }

    public List au()
    {
        return aS().h();
    }

    public aS av()
    {
        if (p == null)
        {
            o = o();
            aF();
        } else
        {
            p.g();
        }
        a = a & 0xfffffdff;
        return this;
    }

    public a aw()
    {
        a = a | 0x200;
        aF();
        return (aF)aT().e();
    }

    public aT ax()
    {
        if (r == null)
        {
            q = q();
            aF();
        } else
        {
            r.g();
        }
        a = a & 0xfffffbff;
        return this;
    }

    public a ay()
    {
        a = a | 0x400;
        aF();
        return (aF)aU().e();
    }

    public aU b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public g b(int i1)
    {
        return d.c(i1);
    }

    public d b(int i1, int j1)
    {
        aK();
        f.set(i1, Integer.valueOf(j1));
        aF();
        return this;
    }

    public aF b(int i1, aF af1)
    {
        if (l == null)
        {
            aP();
            k.add(i1, af1.y());
            aF();
            return this;
        } else
        {
            l.b(i1, af1.y());
            return this;
        }
    }

    public y b(int i1, y y1)
    {
        if (l == null)
        {
            if (y1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aP();
                k.add(i1, y1);
                aF();
                return this;
            }
        } else
        {
            l.b(i1, y1);
            return this;
        }
    }

    public l b(int i1, l l1)
    {
        if (h == null)
        {
            aL();
            g.add(i1, l1.L());
            aF();
            return this;
        } else
        {
            h.b(i1, l1.L());
            return this;
        }
    }

    public L b(int i1, L l1)
    {
        if (h == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aL();
                g.add(i1, l1);
                aF();
                return this;
            }
        } else
        {
            h.b(i1, l1);
            return this;
        }
    }

    public h b(int i1, h h1)
    {
        if (j == null)
        {
            aN();
            i.add(i1, h1.y());
            aF();
            return this;
        } else
        {
            j.b(i1, h1.y());
            return this;
        }
    }

    public y b(int i1, y y1)
    {
        if (j == null)
        {
            if (y1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aN();
                i.add(i1, y1);
                aF();
                return this;
            }
        } else
        {
            j.b(i1, y1);
            return this;
        }
    }

    public j b(int i1, j j1)
    {
        if (n == null)
        {
            aR();
            m.add(i1, j1.L());
            aF();
            return this;
        } else
        {
            n.b(i1, j1.L());
            return this;
        }
    }

    public L b(int i1, L l1)
    {
        if (n == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aR();
                m.add(i1, l1);
                aF();
                return this;
            }
        } else
        {
            n.b(i1, l1);
            return this;
        }
    }

    public n b(n n1)
    {
        if (r == null)
        {
            if ((a & 0x400) == 1024 && q != q())
            {
                q = q(q).a(n1).t();
            } else
            {
                q = n1;
            }
            aF();
        } else
        {
            r.b(n1);
        }
        a = a | 0x400;
        return this;
    }

    public a b(a a1)
    {
        if (p == null)
        {
            if ((a & 0x200) == 512 && o != o())
            {
                o = o(o).a(a1).O();
            } else
            {
                o = a1;
            }
            aF();
        } else
        {
            p.b(a1);
        }
        a = a | 0x200;
        return this;
    }

    public a b(Iterable iterable)
    {
        aJ();
        aJ(iterable, e);
        aF();
        return this;
    }

    public aF b(String s1)
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

    public e c(Iterable iterable)
    {
        aK();
        aK(iterable, f);
        aF();
        return this;
    }

    public aF c(String s1)
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

    public aF c(x x1)
    {
        return d(x1);
    }

    public d c(h h1, n n1)
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

    public f d()
    {
        return I();
    }

    public I d(x x1)
    {
        if (x1 instanceof I)
        {
            return a((a)x1);
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
            aL(iterable, g);
            aF();
            return this;
        } else
        {
            h.a(iterable);
            return this;
        }
    }

    public h d(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e e()
    {
        return m();
    }

    public m e(int i1)
    {
        if (h == null)
        {
            return (h)g.get(i1);
        } else
        {
            return (g)h.a(i1);
        }
    }

    public h e(g g1)
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

    public aF e(h h1, n n1)
        throws IOException
    {
        h1 = (aF)aF.d(h1, n1);
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

    public a e(Iterable iterable)
    {
        if (j == null)
        {
            aN();
            aN(iterable, i);
            aF();
            return this;
        } else
        {
            j.a(iterable);
            return this;
        }
    }

    public j f()
    {
        return I();
    }

    public I f(int i1)
    {
        if (h == null)
        {
            return (h)g.get(i1);
        } else
        {
            return (g)h.c(i1);
        }
    }

    public h f(g g1)
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

    public aF f(Iterable iterable)
    {
        if (l == null)
        {
            aP();
            aP(iterable, k);
            aF();
            return this;
        } else
        {
            l.a(iterable);
            return this;
        }
    }

    public l g(int i1)
    {
        if (j == null)
        {
            return (j)i.get(i1);
        } else
        {
            return (i)j.a(i1);
        }
    }

    public j g(g g1)
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

    public aF g(Iterable iterable)
    {
        if (n == null)
        {
            aR();
            aR(iterable, m);
            aF();
            return this;
        } else
        {
            n.a(iterable);
            return this;
        }
    }

    public n g()
    {
        return I();
    }

    public I h(int i1)
    {
        if (j == null)
        {
            return (j)i.get(i1);
        } else
        {
            return (i)j.c(i1);
        }
    }

    public j h()
    {
        return m();
    }

    public m i(int i1)
    {
        if (l == null)
        {
            return (l)k.get(i1);
        } else
        {
            return (k)l.a(i1);
        }
    }

    public l i()
    {
        return I();
    }

    public I j(int i1)
    {
        if (l == null)
        {
            return (l)k.get(i1);
        } else
        {
            return (k)l.c(i1);
        }
    }

    public l j()
    {
        return m();
    }

    public m k(int i1)
    {
        if (n == null)
        {
            return (n)m.get(i1);
        } else
        {
            return (m)n.a(i1);
        }
    }

    public n l(int i1)
    {
        if (n == null)
        {
            return (n)m.get(i1);
        } else
        {
            return (m)n.c(i1);
        }
    }

    protected n l()
    {
        return com.umeng.message.proguard.j.e().n(com/umeng/message/proguard/j$o, com/umeng/message/proguard/j$o$a);
    }

    public n m()
    {
        super.();
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
            o = o();
        } else
        {
            p.g();
        }
        a = a & 0xfffffdff;
        if (r == null)
        {
            q = q();
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

    public aF n(int i1)
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

    public b p(int i1)
    {
        return (b)aM().b(i1);
    }

    public aM q(int i1)
    {
        return (aM)aM().c(i1, aM());
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

    public c s(int i1)
    {
        return (c)aO().b(i1);
    }

    public aO t(int i1)
    {
        return (aO)aO().c(i1, aO());
    }

    public List t()
    {
        return Collections.unmodifiableList(d);
    }

    public int u()
    {
        return d.size();
    }

    public  u(int i1)
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

    public l v(int i1)
    {
        return (l)aQ().b(i1);
    }

    public List v()
    {
        return Collections.unmodifiableList(e);
    }

    public int w()
    {
        return e.size();
    }

    public e w(int i1)
    {
        return (e)aQ().c(i1, aQ());
    }

    public aQ x(int i1)
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

    public f y(int i1)
    {
        return (f)aS().b(i1);
    }

    public aS z(int i1)
    {
        return (aS)aS().c(i1, aS());
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

    private ion()
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
        o = o();
        q = q();
        aG();
    }

    private aG(aG ag1)
    {
        super(ag1);
        b = "";
        c = "";
        d = u.a;
        e = Collections.emptyList();
        f = Collections.emptyList();
        g = Collections.emptyList();
        i = Collections.emptyList();
        k = Collections.emptyList();
        m = Collections.emptyList();
        o = o();
        q = q();
        aG();
    }

    aG(aG ag1, aG ag2)
    {
        this(ag1);
    }
}
