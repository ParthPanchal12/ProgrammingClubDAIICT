// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, L, p, D, 
//            s, B, g, y, 
//            x, h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private Object b;
    private List c;
    private D d;
    private List e;
    private D f;
    private List g;
    private D h;
    private List i;
    private D j;
    private List k;
    private D l;
    private j m;
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

    static n an()
    {
        return ap();
    }

    private void ao()
    {
        if (p.m)
        {
            ar();
            at();
            av();
            ax();
            az();
            aG();
        }
    }

    private static aG ap()
    {
        return new <init>();
    }

    private void aq()
    {
        if ((a & 2) != 2)
        {
            c = new ArrayList(c);
            a = a | 2;
        }
    }

    private D ar()
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
            d = new D(list, flag, aE(), aD());
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

    private D at()
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
            f = new D(list, flag, aE(), aD());
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

    private D av()
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
            h = new D(list, flag, aE(), aD());
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

    private D ax()
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
            j = new D(list, flag, aE(), aD());
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

    private D az()
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
            l = new D(list, flag, aE(), aD());
            k = null;
        }
        return l;
    }

    public static final l k()
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

    public a G()
    {
        if (n == null)
        {
            return m;
        } else
        {
            return (m)n.c();
        }
    }

    public n H()
    {
        if (n != null)
        {
            return (n)n.f();
        } else
        {
            return m;
        }
    }

    public m I()
    {
        return ap().a(M());
    }

    public M J()
    {
        return com.umeng.message.proguard.j.f();
    }

    public M K()
    {
        return M();
    }

    public M L()
    {
        M m1 = M();
        if (!m1.M())
        {
            throw b(m1);
        } else
        {
            return m1;
        }
    }

    public b M()
    {
        int i1 = 1;
        b b1 = new nit>(this, null);
        int j1 = a;
        if ((j1 & 1) != 1)
        {
            i1 = 0;
        }
        a(b1, b);
        if (d == null)
        {
            if ((a & 2) == 2)
            {
                c = Collections.unmodifiableList(c);
                a = a & -3;
            }
            a(b1, c);
        } else
        {
            c(b1, d.f());
        }
        if (f == null)
        {
            if ((a & 4) == 4)
            {
                e = Collections.unmodifiableList(e);
                a = a & -5;
            }
            a(b1, e);
        } else
        {
            e(b1, f.f());
        }
        if (h == null)
        {
            if ((a & 8) == 8)
            {
                g = Collections.unmodifiableList(g);
                a = a & -9;
            }
            a(b1, g);
        } else
        {
            g(b1, h.f());
        }
        if (j == null)
        {
            if ((a & 0x10) == 16)
            {
                i = Collections.unmodifiableList(i);
                a = a & 0xffffffef;
            }
            a(b1, i);
        } else
        {
            i(b1, j.f());
        }
        if (l == null)
        {
            if ((a & 0x20) == 32)
            {
                k = Collections.unmodifiableList(k);
                a = a & 0xffffffdf;
            }
            a(b1, k);
        } else
        {
            k(b1, l.f());
        }
        if ((j1 & 0x40) == 64)
        {
            i1 |= 2;
        }
        if (n == null)
        {
            n(b1, m);
        } else
        {
            m(b1, (m)n.d());
        }
        n(b1, i1);
        aB();
        return b1;
    }

    public aB N()
    {
        a = a & -2;
        b = b().b();
        aF();
        return this;
    }

    public aF O()
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

    public d P()
    {
        return (d)ar().b(ar());
    }

    public y Q()
    {
        return K();
    }

    public x R()
    {
        return K();
    }

    public List S()
    {
        return ar().h();
    }

    public ar T()
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

    public f U()
    {
        return (f)at().b(at());
    }

    public List V()
    {
        return at().h();
    }

    public at W()
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

    public h X()
    {
        return (h)av().b(av());
    }

    public List Y()
    {
        return av().h();
    }

    public av Z()
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

    public j a(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e a(x x1)
    {
        return d(x1);
    }

    public d a(int i1, d d1)
    {
        if (h == null)
        {
            au();
            g.set(i1, d1.L());
            aF();
            return this;
        } else
        {
            h.a(i1, d1.L());
            return this;
        }
    }

    public a a(int i1, a a1)
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

    public a.t a(int i1, a.t t1)
    {
        if (l == null)
        {
            if (t1 == null)
            {
                throw new NullPointerException();
            } else
            {
                ay();
                k.set(i1, t1);
                aF();
                return this;
            }
        } else
        {
            l.a(i1, t1);
            return this;
        }
    }

    public l a(int i1, l l1)
    {
        if (h == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                au();
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
            aw();
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
                aw();
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
        if (d == null)
        {
            aq();
            c.set(i1, j1.L());
            aF();
            return this;
        } else
        {
            d.a(i1, j1.L());
            return this;
        }
    }

    public L a(int i1, L l1)
    {
        if (d == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aq();
                c.set(i1, l1);
                aF();
                return this;
            }
        } else
        {
            d.a(i1, l1);
            return this;
        }
    }

    public d a(d d1)
    {
        if (h == null)
        {
            au();
            g.add(d1.L());
            aF();
            return this;
        } else
        {
            h.a(d1.L());
            return this;
        }
    }

    public a a(a a1)
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

    public a.t a(a.t t1)
    {
        if (l == null)
        {
            if (t1 == null)
            {
                throw new NullPointerException();
            } else
            {
                ay();
                k.add(t1);
                aF();
                return this;
            }
        } else
        {
            l.a(t1);
            return this;
        }
    }

    public l a(l l1)
    {
        Object obj = null;
        if (l1 == l())
        {
            return this;
        }
        if (l1.l())
        {
            a = a | 1;
            b = b(l1);
            aF();
        }
        if (d == null)
        {
            if (!d(l1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = c(l1);
                    a = a & -3;
                } else
                {
                    aq();
                    c.addAll(c(l1));
                }
                aF();
            }
        } else
        if (!aF(l1).isEmpty())
        {
            if (d.d())
            {
                d.b();
                d = null;
                c = c(l1);
                a = a & -3;
                D d1;
                if (p.m)
                {
                    d1 = ar();
                } else
                {
                    d1 = null;
                }
                d = d1;
            } else
            {
                d.a(d(l1));
            }
        }
        if (f == null)
        {
            if (!f(l1).isEmpty())
            {
                if (e.isEmpty())
                {
                    e = e(l1);
                    a = a & -5;
                } else
                {
                    as();
                    e.addAll(e(l1));
                }
                aF();
            }
        } else
        if (!aF(l1).isEmpty())
        {
            if (f.d())
            {
                f.b();
                f = null;
                e = e(l1);
                a = a & -5;
                D d2;
                if (p.m)
                {
                    d2 = at();
                } else
                {
                    d2 = null;
                }
                f = d2;
            } else
            {
                f.a(f(l1));
            }
        }
        if (h == null)
        {
            if (!h(l1).isEmpty())
            {
                if (g.isEmpty())
                {
                    g = g(l1);
                    a = a & -9;
                } else
                {
                    au();
                    g.addAll(g(l1));
                }
                aF();
            }
        } else
        if (!aF(l1).isEmpty())
        {
            if (h.d())
            {
                h.b();
                h = null;
                g = g(l1);
                a = a & -9;
                D d3;
                if (p.m)
                {
                    d3 = av();
                } else
                {
                    d3 = null;
                }
                h = d3;
            } else
            {
                h.a(h(l1));
            }
        }
        if (j == null)
        {
            if (!j(l1).isEmpty())
            {
                if (i.isEmpty())
                {
                    i = i(l1);
                    a = a & 0xffffffef;
                } else
                {
                    aw();
                    i.addAll(i(l1));
                }
                aF();
            }
        } else
        if (!aF(l1).isEmpty())
        {
            if (j.d())
            {
                j.b();
                j = null;
                i = i(l1);
                a = a & 0xffffffef;
                D d4;
                if (p.m)
                {
                    d4 = ax();
                } else
                {
                    d4 = null;
                }
                j = d4;
            } else
            {
                j.a(j(l1));
            }
        }
        if (l == null)
        {
            if (!l(l1).isEmpty())
            {
                if (k.isEmpty())
                {
                    k = k(l1);
                    a = a & 0xffffffdf;
                } else
                {
                    ay();
                    k.addAll(k(l1));
                }
                aF();
            }
        } else
        if (!aF(l1).isEmpty())
        {
            if (l.d())
            {
                l.b();
                l = null;
                k = k(l1);
                a = a & 0xffffffdf;
                D d5 = obj;
                if (p.m)
                {
                    d5 = az();
                }
                l = d5;
            } else
            {
                l.a(l(l1));
            }
        }
        if (l1.l())
        {
            b(l1.b());
        }
        d(l1.());
        return this;
    }

    public  a( )
    {
        if (j == null)
        {
            aw();
            i.add(.y());
            aF();
            return this;
        } else
        {
            j.a(.y());
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
                aw();
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
        if (d == null)
        {
            aq();
            c.add(j1.L());
            aF();
            return this;
        } else
        {
            d.a(j1.L());
            return this;
        }
    }

    public L a(L l1)
    {
        if (d == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aq();
                c.add(l1);
                aF();
                return this;
            }
        } else
        {
            d.a(l1);
            return this;
        }
    }

    public d a(d d1)
    {
        if (n == null)
        {
            m = d1.w();
            aF();
        } else
        {
            n.a(d1.w());
        }
        a = a | 0x40;
        return this;
    }

    public a a(a a1)
    {
        if (n == null)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            }
            m = a1;
            aF();
        } else
        {
            n.a(a1);
        }
        a = a | 0x40;
        return this;
    }

    public a a(Iterable iterable)
    {
        if (d == null)
        {
            aq();
            aq(iterable, c);
            aF();
            return this;
        } else
        {
            d.a(iterable);
            return this;
        }
    }

    public d a(String s1)
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

    public aF a(int i1)
    {
        if (d == null)
        {
            return (d)c.get(i1);
        } else
        {
            return (c)d.a(i1);
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
        if (!c(i1).c()) goto _L3; else goto _L5
_L5:
        i1++;
          goto _L6
        i1 = 0;
_L8:
        if (i1 >= y())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (!e(i1).e()) goto _L3; else goto _L7
_L7:
        i1++;
          goto _L8
        i1 = 0;
_L10:
        if (i1 >= B())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!g(i1).g()) goto _L3; else goto _L9
_L9:
        i1++;
          goto _L10
        if (F() && !G().G()) goto _L3; else goto _L11
_L11:
        return true;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public G aa()
    {
        return (G)ax().b(ax());
    }

    public List ab()
    {
        return ax().h();
    }

    public ax ac()
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

    public a ad()
    {
        return (a)az().b(h());
    }

    public List ae()
    {
        return az().h();
    }

    public az af()
    {
        if (n == null)
        {
            m = m();
            aF();
        } else
        {
            n.g();
        }
        a = a & 0xffffffbf;
        return this;
    }

    public a ag()
    {
        a = a | 0x40;
        aF();
        return (aF)aG().e();
    }

    public aG ah()
    {
        return m();
    }

    public m ai()
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

    public L b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1, e e1)
    {
        if (h == null)
        {
            au();
            g.add(i1, e1.L());
            aF();
            return this;
        } else
        {
            h.b(i1, e1.L());
            return this;
        }
    }

    public a b(int i1, a a1)
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

    public a.t b(int i1, a.t t1)
    {
        if (l == null)
        {
            if (t1 == null)
            {
                throw new NullPointerException();
            } else
            {
                ay();
                k.add(i1, t1);
                aF();
                return this;
            }
        } else
        {
            l.b(i1, t1);
            return this;
        }
    }

    public l b(int i1, l l1)
    {
        if (h == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                au();
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
            aw();
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
                aw();
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
        if (d == null)
        {
            aq();
            c.add(i1, j1.L());
            aF();
            return this;
        } else
        {
            d.b(i1, j1.L());
            return this;
        }
    }

    public L b(int i1, L l1)
    {
        if (d == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                aq();
                c.add(i1, l1);
                aF();
                return this;
            }
        } else
        {
            d.b(i1, l1);
            return this;
        }
    }

    public d b(d d1)
    {
        if (h == null)
        {
            if (d1 == null)
            {
                throw new NullPointerException();
            } else
            {
                au();
                g.add(d1);
                aF();
                return this;
            }
        } else
        {
            h.a(d1);
            return this;
        }
    }

    public h b(h h1)
    {
        if (f == null)
        {
            as();
            e.add(h1.L());
            aF();
            return this;
        } else
        {
            f.a(h1.L());
            return this;
        }
    }

    public L b(L l1)
    {
        if (f == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                as();
                e.add(l1);
                aF();
                return this;
            }
        } else
        {
            f.a(l1);
            return this;
        }
    }

    public f b(f f1)
    {
        if (n == null)
        {
            if ((a & 0x40) == 64 && m != m())
            {
                m = m(m).a(f1).x();
            } else
            {
                m = f1;
            }
            aF();
        } else
        {
            n.b(f1);
        }
        a = a | 0x40;
        return this;
    }

    public a b(Iterable iterable)
    {
        if (f == null)
        {
            as();
            as(iterable, e);
            aF();
            return this;
        } else
        {
            f.a(iterable);
            return this;
        }
    }

    public f b(int i1)
    {
        if (d == null)
        {
            return (d)c.get(i1);
        } else
        {
            return (c)d.c(i1);
        }
    }

    public d c(int i1, d d1)
    {
        if (f == null)
        {
            as();
            e.set(i1, d1.L());
            aF();
            return this;
        } else
        {
            f.a(i1, d1.L());
            return this;
        }
    }

    public L c(int i1, L l1)
    {
        if (f == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                as();
                e.set(i1, l1);
                aF();
                return this;
            }
        } else
        {
            f.a(i1, l1);
            return this;
        }
    }

    public f c(Iterable iterable)
    {
        if (h == null)
        {
            au();
            au(iterable, g);
            aF();
            return this;
        } else
        {
            h.a(iterable);
            return this;
        }
    }

    public h c(int i1)
    {
        if (f == null)
        {
            return (f)e.get(i1);
        } else
        {
            return (e)f.a(i1);
        }
    }

    public f c(x x1)
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

    public I d()
    {
        return I();
    }

    public I d(int i1, I j1)
    {
        if (f == null)
        {
            as();
            e.add(i1, j1.L());
            aF();
            return this;
        } else
        {
            f.b(i1, j1.L());
            return this;
        }
    }

    public L d(int i1, L l1)
    {
        if (f == null)
        {
            if (l1 == null)
            {
                throw new NullPointerException();
            } else
            {
                as();
                e.add(i1, l1);
                aF();
                return this;
            }
        } else
        {
            f.b(i1, l1);
            return this;
        }
    }

    public f d(x x1)
    {
        if (x1 instanceof f)
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
        if (j == null)
        {
            aw();
            aw(iterable, i);
            aF();
            return this;
        } else
        {
            j.a(iterable);
            return this;
        }
    }

    public j d(int i1)
    {
        if (f == null)
        {
            return (f)e.get(i1);
        } else
        {
            return (e)f.c(i1);
        }
    }

    public f d(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e e()
    {
        return m();
    }

    public m e(g g1)
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
        if (l == null)
        {
            ay();
            ay(iterable, k);
            aF();
            return this;
        } else
        {
            l.a(iterable);
            return this;
        }
    }

    public l e(int i1)
    {
        if (h == null)
        {
            return (h)g.get(i1);
        } else
        {
            return (g)h.a(i1);
        }
    }

    public h f()
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

    public h g(int i1)
    {
        if (j == null)
        {
            return (j)i.get(i1);
        } else
        {
            return (i)j.a(i1);
        }
    }

    public j g()
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

    public d l(int i1)
    {
        return (d)ar().b(i1);
    }

    protected ar l()
    {
        return com.umeng.message.proguard.j.g().ar(com/umeng/message/proguard/j$a, com/umeng/message/proguard/j$a$a);
    }

    public ar m()
    {
        super.();
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
            m = m();
        } else
        {
            n.g();
        }
        a = a & 0xffffffbf;
        return this;
    }

    public a m(int i1)
    {
        return (a)ar().c(i1, ar());
    }

    public ar n(int i1)
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

    public a o(int i1)
    {
        return (a)at().b(i1);
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
        return (b)at().c(i1, at());
    }

    public at q(int i1)
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

    public d r(int i1)
    {
        return (d)av().b(i1);
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

    public d s(int i1)
    {
        return (d)av().c(i1, av());
    }

    public av t(int i1)
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

    public f u(int i1)
    {
        return (f)ax().b(i1);
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

    public f v(int i1)
    {
        return (f)ax().c(i1, ax());
    }

    public ax w(int i1)
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

    public a x(int i1)
    {
        return (a)az().b(i1);
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

    public a y(int i1)
    {
        return (a)az().c(i1, h());
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

    private a()
    {
        b = "";
        c = Collections.emptyList();
        e = Collections.emptyList();
        g = Collections.emptyList();
        i = Collections.emptyList();
        k = Collections.emptyList();
        m = m();
        ao();
    }

    private ao(ao ao1)
    {
        super(ao1);
        b = "";
        c = Collections.emptyList();
        e = Collections.emptyList();
        g = Collections.emptyList();
        i = Collections.emptyList();
        k = Collections.emptyList();
        m = m();
        ao();
    }

    ao(ao ao1, ao ao2)
    {
        this(ao1);
    }
}
