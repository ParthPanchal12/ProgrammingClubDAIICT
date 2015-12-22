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
//            h, B, i, y, 
//            g, n, x, L, 
//            D, c, A

public static final class j extends p
    implements j
{
    public static final class a extends p.a
        implements j.b
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
        private j.u m;
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

        static a an()
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

        private static a ap()
        {
            return new a();
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

        public j.u G()
        {
            if (n == null)
            {
                return m;
            } else
            {
                return (j.u)n.c();
            }
        }

        public j.v H()
        {
            if (n != null)
            {
                return (j.v)n.f();
            } else
            {
                return m;
            }
        }

        public a I()
        {
            return ap().a(M());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.f();
        }

        public j.a K()
        {
            return j.a.h();
        }

        public j.a L()
        {
            j.a a1 = M();
            if (!a1.a())
            {
                throw b(a1);
            } else
            {
                return a1;
            }
        }

        public j.a M()
        {
            int i1 = 1;
            j.a a1 = new j.a(this, null);
            int j1 = a;
            if ((j1 & 1) != 1)
            {
                i1 = 0;
            }
            j.a.a(a1, b);
            if (d == null)
            {
                if ((a & 2) == 2)
                {
                    c = Collections.unmodifiableList(c);
                    a = a & -3;
                }
                j.a.a(a1, c);
            } else
            {
                j.a.a(a1, d.f());
            }
            if (f == null)
            {
                if ((a & 4) == 4)
                {
                    e = Collections.unmodifiableList(e);
                    a = a & -5;
                }
                j.a.b(a1, e);
            } else
            {
                j.a.b(a1, f.f());
            }
            if (h == null)
            {
                if ((a & 8) == 8)
                {
                    g = Collections.unmodifiableList(g);
                    a = a & -9;
                }
                j.a.c(a1, g);
            } else
            {
                j.a.c(a1, h.f());
            }
            if (j == null)
            {
                if ((a & 0x10) == 16)
                {
                    i = Collections.unmodifiableList(i);
                    a = a & 0xffffffef;
                }
                j.a.d(a1, i);
            } else
            {
                j.a.d(a1, j.f());
            }
            if (l == null)
            {
                if ((a & 0x20) == 32)
                {
                    k = Collections.unmodifiableList(k);
                    a = a & 0xffffffdf;
                }
                j.a.e(a1, k);
            } else
            {
                j.a.e(a1, l.f());
            }
            if ((j1 & 0x40) == 64)
            {
                i1 |= 2;
            }
            if (n == null)
            {
                j.a.a(a1, m);
            } else
            {
                j.a.a(a1, (j.u)n.d());
            }
            j.a.a(a1, i1);
            aB();
            return a1;
        }

        public a N()
        {
            a = a & -2;
            b = j.a.h().o();
            aF();
            return this;
        }

        public a O()
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

        public j.k.a P()
        {
            return (j.k.a)ar().b(com.umeng.message.proguard.j.k.h());
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

        public a T()
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

        public j.k.a U()
        {
            return (j.k.a)at().b(com.umeng.message.proguard.j.k.h());
        }

        public List V()
        {
            return at().h();
        }

        public a W()
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

        public a X()
        {
            return (a)av().b(j.a.h());
        }

        public List Y()
        {
            return av().h();
        }

        public a Z()
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

        public a.a a(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(x x1)
        {
            return d(x1);
        }

        public a a(int i1, a a1)
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

        public a a(int i1, b.a a1)
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

        public a a(int i1, b b1)
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

        public a a(int i1, j.a a1)
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

        public a a(int i1, j.c.a a1)
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

        public a a(int i1, j.c c1)
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

        public a a(int i1, j.k.a a1)
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

        public a a(int i1, j.k k1)
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

        public a a(a a1)
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

        public a a(b.a a1)
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

        public a a(b b1)
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

        public a a(j.a a1)
        {
            Object obj = null;
            if (a1 == j.a.h())
            {
                return this;
            }
            if (a1.n())
            {
                a = a | 1;
                b = j.a.b(a1);
                aF();
            }
            if (d == null)
            {
                if (!j.a.c(a1).isEmpty())
                {
                    if (c.isEmpty())
                    {
                        c = j.a.c(a1);
                        a = a & -3;
                    } else
                    {
                        aq();
                        c.addAll(j.a.c(a1));
                    }
                    aF();
                }
            } else
            if (!j.a.c(a1).isEmpty())
            {
                if (d.d())
                {
                    d.b();
                    d = null;
                    c = j.a.c(a1);
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
                    d.a(j.a.c(a1));
                }
            }
            if (f == null)
            {
                if (!j.a.d(a1).isEmpty())
                {
                    if (e.isEmpty())
                    {
                        e = j.a.d(a1);
                        a = a & -5;
                    } else
                    {
                        as();
                        e.addAll(j.a.d(a1));
                    }
                    aF();
                }
            } else
            if (!j.a.d(a1).isEmpty())
            {
                if (f.d())
                {
                    f.b();
                    f = null;
                    e = j.a.d(a1);
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
                    f.a(j.a.d(a1));
                }
            }
            if (h == null)
            {
                if (!j.a.e(a1).isEmpty())
                {
                    if (g.isEmpty())
                    {
                        g = j.a.e(a1);
                        a = a & -9;
                    } else
                    {
                        au();
                        g.addAll(j.a.e(a1));
                    }
                    aF();
                }
            } else
            if (!j.a.e(a1).isEmpty())
            {
                if (h.d())
                {
                    h.b();
                    h = null;
                    g = j.a.e(a1);
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
                    h.a(j.a.e(a1));
                }
            }
            if (j == null)
            {
                if (!j.a.f(a1).isEmpty())
                {
                    if (i.isEmpty())
                    {
                        i = j.a.f(a1);
                        a = a & 0xffffffef;
                    } else
                    {
                        aw();
                        i.addAll(j.a.f(a1));
                    }
                    aF();
                }
            } else
            if (!j.a.f(a1).isEmpty())
            {
                if (j.d())
                {
                    j.b();
                    j = null;
                    i = j.a.f(a1);
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
                    j.a(j.a.f(a1));
                }
            }
            if (l == null)
            {
                if (!j.a.g(a1).isEmpty())
                {
                    if (k.isEmpty())
                    {
                        k = j.a.g(a1);
                        a = a & 0xffffffdf;
                    } else
                    {
                        ay();
                        k.addAll(j.a.g(a1));
                    }
                    aF();
                }
            } else
            if (!j.a.g(a1).isEmpty())
            {
                if (l.d())
                {
                    l.b();
                    l = null;
                    k = j.a.g(a1);
                    a = a & 0xffffffdf;
                    D d5 = obj;
                    if (p.m)
                    {
                        d5 = az();
                    }
                    l = d5;
                } else
                {
                    l.a(j.a.g(a1));
                }
            }
            if (a1.F())
            {
                b(a1.G());
            }
            d(a1.b_());
            return this;
        }

        public a a(j.c.a a1)
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

        public a a(j.c c1)
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

        public a a(j.k.a a1)
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

        public a a(j.k k1)
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

        public a a(j.u.a a1)
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

        public a a(j.u u1)
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

        public a a(Iterable iterable)
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

        public j.k a(int i1)
        {
            if (d == null)
            {
                return (j.k)c.get(i1);
            } else
            {
                return (j.k)d.a(i1);
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

        public j.c.a aa()
        {
            return (j.c.a)ax().b(com.umeng.message.proguard.j.c.h());
        }

        public List ab()
        {
            return ax().h();
        }

        public a ac()
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

        public b.a ad()
        {
            return (b.a)az().b(b.h());
        }

        public List ae()
        {
            return az().h();
        }

        public a af()
        {
            if (n == null)
            {
                m = com.umeng.message.proguard.j.u.h();
                aF();
            } else
            {
                n.g();
            }
            a = a & 0xffffffbf;
            return this;
        }

        public j.u.a ag()
        {
            a = a | 0x40;
            aF();
            return (j.u.a)aG().e();
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

        public a b(int i1, a a1)
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

        public a b(int i1, b.a a1)
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

        public a b(int i1, b b1)
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

        public a b(int i1, j.a a1)
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

        public a b(int i1, j.c.a a1)
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

        public a b(int i1, j.c c1)
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

        public a b(int i1, j.k.a a1)
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

        public a b(int i1, j.k k1)
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

        public a b(j.a a1)
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

        public a b(j.k.a a1)
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

        public a b(j.k k1)
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

        public a b(j.u u1)
        {
            if (n == null)
            {
                if ((a & 0x40) == 64 && m != com.umeng.message.proguard.j.u.h())
                {
                    m = com.umeng.message.proguard.j.u.a(m).a(u1).x();
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

        public a b(Iterable iterable)
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

        public j.l b(int i1)
        {
            if (d == null)
            {
                return (j.l)c.get(i1);
            } else
            {
                return (j.l)d.c(i1);
            }
        }

        public a c(int i1, j.k.a a1)
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

        public a c(int i1, j.k k1)
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

        public a c(Iterable iterable)
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

        public j.k c(int i1)
        {
            if (f == null)
            {
                return (j.k)e.get(i1);
            } else
            {
                return (j.k)f.a(i1);
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

        public a d(int i1, j.k.a a1)
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

        public a d(int i1, j.k k1)
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

        public a d(x x1)
        {
            if (x1 instanceof j.a)
            {
                return a((j.a)x1);
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
                com.umeng.message.proguard.p.a.a(iterable, i);
                aF();
                return this;
            } else
            {
                j.a(iterable);
                return this;
            }
        }

        public j.l d(int i1)
        {
            if (f == null)
            {
                return (j.l)e.get(i1);
            } else
            {
                return (j.l)f.c(i1);
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
            h1 = (j.a)j.a.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.a)n1.a();
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
                com.umeng.message.proguard.p.a.a(iterable, k);
                aF();
                return this;
            } else
            {
                l.a(iterable);
                return this;
            }
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

        public b i(int i1)
        {
            if (l == null)
            {
                return (b)k.get(i1);
            } else
            {
                return (b)l.a(i1);
            }
        }

        public x.a i()
        {
            return I();
        }

        public c j(int i1)
        {
            if (l == null)
            {
                return (c)k.get(i1);
            } else
            {
                return (c)l.c(i1);
            }
        }

        public x.a j()
        {
            return m();
        }

        public a k(int i1)
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

        public j.k.a l(int i1)
        {
            return (j.k.a)ar().b(i1);
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.g().a(com/umeng/message/proguard/j$a, com/umeng/message/proguard/j$a$a);
        }

        public a m()
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
                m = com.umeng.message.proguard.j.u.h();
            } else
            {
                n.g();
            }
            a = a & 0xffffffbf;
            return this;
        }

        public j.k.a m(int i1)
        {
            return (j.k.a)ar().c(i1, com.umeng.message.proguard.j.k.h());
        }

        public a n(int i1)
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

        public j.k.a o(int i1)
        {
            return (j.k.a)at().b(i1);
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

        public j.k.a p(int i1)
        {
            return (j.k.a)at().c(i1, com.umeng.message.proguard.j.k.h());
        }

        public a q(int i1)
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

        public a r(int i1)
        {
            return (a)av().b(i1);
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

        public a s(int i1)
        {
            return (a)av().c(i1, j.a.h());
        }

        public a t(int i1)
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

        public j.c.a u(int i1)
        {
            return (j.c.a)ax().b(i1);
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

        public j.c.a v(int i1)
        {
            return (j.c.a)ax().c(i1, com.umeng.message.proguard.j.c.h());
        }

        public a w(int i1)
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

        public b.a x(int i1)
        {
            return (b.a)az().b(i1);
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

        public b.a y(int i1)
        {
            return (b.a)az().c(i1, b.h());
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
            m = com.umeng.message.proguard.j.u.h();
            ao();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            c = Collections.emptyList();
            e = Collections.emptyList();
            g = Collections.emptyList();
            i = Collections.emptyList();
            k = Collections.emptyList();
            m = com.umeng.message.proguard.j.u.h();
            ao();
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
        private static final b d;
        private static final long k = 0L;
        private final P e;
        private int f;
        private int g;
        private int h;
        private byte i;
        private int j;

        static int a(b b1, int i1)
        {
            b1.g = i1;
            return i1;
        }

        public static a a(b b1)
        {
            return r().a(b1);
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

        static int b(b b1, int i1)
        {
            b1.h = i1;
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

        static int c(b b1, int i1)
        {
            b1.f = i1;
            return i1;
        }

        public static b h()
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

        public y Q()
        {
            return i();
        }

        public x R()
        {
            return i();
        }

        protected a a(p.b b1)
        {
            return new a(b1, null);
        }

        public void a(i i1)
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

        public b i()
        {
            return d;
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.i().a(com/umeng/message/proguard/j$a$b, com/umeng/message/proguard/j$a$b$a);
        }

        public B m()
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
            d = new b(true);
            d.u();
        }

        private b(h h1, n n1)
            throws s
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
            throw (new s(h1.getMessage())).a(this);
_L2:
            e = a1.b();
            ad();
            return;
_L4:
            flag = true;
            if (true) goto _L8; else goto _L7
_L7:
        }

        b(h h1, n n1, j._cls1 _pcls1)
            throws s
        {
            this(h1, n1);
        }

        private b(p.a a1)
        {
            super(a1);
            i = -1;
            j = -1;
            e = a1.b_();
        }

        b(p.a a1, j._cls1 _pcls1)
        {
            this(a1);
        }

        private b(boolean flag)
        {
            i = -1;
            j = -1;
            e = com.umeng.message.proguard.P.c();
        }
    }

    public static final class b.a extends p.a
        implements c
    {

        private int a;
        private int b;
        private int c;

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.h();
        }

        static b.a x()
        {
            return z();
        }

        private void y()
        {
            if (!p.m);
        }

        private static b.a z()
        {
            return new b.a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.h();
        }

        public y Q()
        {
            return s();
        }

        public x R()
        {
            return s();
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

        public x aj()
        {
            return u();
        }

        public x ak()
        {
            return t();
        }

        public y al()
        {
            return u();
        }

        public y am()
        {
            return t();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public b.a b(int i1)
        {
            a = a | 2;
            c = i1;
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
            return r();
        }

        public a.a d()
        {
            return r();
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

        public b.a m()
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

        public b.a r()
        {
            return z().a(u());
        }

        public b s()
        {
            return b.h();
        }

        public b t()
        {
            b b1 = u();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public b u()
        {
            int i1 = 1;
            b b1 = new b(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            b.a(b1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            b.b(b1, c);
            b.c(b1, j1);
            aB();
            return b1;
        }

        public b.a v()
        {
            a = a & -2;
            b = 0;
            aF();
            return this;
        }

        public b.a w()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        private b.a()
        {
            y();
        }

        private b.a(p.b b1)
        {
            super(b1);
            y();
        }

        b.a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }

    public static interface c
        extends A
    {

        public abstract boolean n();

        public abstract int o();

        public abstract boolean p();

        public abstract int q();
    }


    public static B a = new com.umeng.message.proguard.c() {

        public j.a c(h h1, n n1)
            throws s
        {
            return new j.a(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
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
    private static final _cls1.c i;
    private static final long v = 0L;
    private final P j;
    private int k;
    private Object l;
    private List n;
    private List o;
    private List p;
    private List q;
    private List r;
    private _cls1.c s;
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
        s = h();
    }

    static int a(h h1, int i1)
    {
        h1.k = i1;
        return i1;
    }

    public static a a(k k1)
    {
        return c_().a(k1);
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
        a1.s = a2;
        return a2;
    }

    static Object a(s s1, Object obj)
    {
        s1.l = obj;
        return obj;
    }

    static List a(l l1, List list)
    {
        l1.n = list;
        return list;
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
        return a1.l;
    }

    static List b(l l1, List list)
    {
        l1.o = list;
        return list;
    }

    static List c(o o1)
    {
        return o1.n;
    }

    static List c(n n1, List list)
    {
        n1.p = list;
        return list;
    }

    public static a c_()
    {
        return a.an();
    }

    static List d(a.an an)
    {
        return an.o;
    }

    static List d(o o1, List list)
    {
        o1.q = list;
        return list;
    }

    static List e(q q1)
    {
        return q1.p;
    }

    static List e(p p1, List list)
    {
        p1.r = list;
        return list;
    }

    static List f(r r1)
    {
        return r1.q;
    }

    static List g(q q1)
    {
        return q1.r;
    }

    public static r h()
    {
        return i;
    }

    public static final i k()
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

    public k G()
    {
        return s;
    }

    public s H()
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

    public a M()
    {
        return L();
    }

    public L N()
    {
        return K();
    }

    public K O()
    {
        return L();
    }

    public L P()
    {
        return K();
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

    public a a(int i1)
    {
        return (a)n.get(i1);
    }

    public void a(i i1)
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
            i1.c(2, (y)n.get(j1));
        }

        for (int k1 = 0; k1 < p.size(); k1++)
        {
            i1.c(3, (y)p.get(k1));
        }

        for (int l1 = 0; l1 < q.size(); l1++)
        {
            i1.c(4, (y)q.get(l1));
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
            i1.c(5, (y)r.get(i2));
            i2++;
        } while (true);
        for (; j2 < o.size(); j2++)
        {
            i1.c(6, (y)o.get(j2));
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

    public t b(int i1)
    {
        return (t)n.get(i1);
    }

    protected n b(n n1)
    {
        return a(n1);
    }

    public final P b_()
    {
        return j;
    }

    public j c(int i1)
    {
        return (j)o.get(i1);
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
            i1 += com.umeng.message.proguard.i.g(2, (y)n.get(j1));
        }

        for (j1 = 0; j1 < p.size(); j1++)
        {
            i1 += com.umeng.message.proguard.i.g(3, (y)p.get(j1));
        }

        for (j1 = 0; j1 < q.size(); j1++)
        {
            i1 += com.umeng.message.proguard.i.g(4, (y)q.get(j1));
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
            i1 += com.umeng.message.proguard.i.g(5, (y)r.get(k1));
            k1++;
        } while (true);
        for (; l1 < o.size(); l1++)
        {
            j1 += com.umeng.message.proguard.i.g(6, (y)o.get(l1));
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

    public u d(int i1)
    {
        return (u)o.get(i1);
    }

    public o e(int i1)
    {
        return (o)p.get(i1);
    }

    public p f(int i1)
    {
        return (p)p.get(i1);
    }

    public p g(int i1)
    {
        return (p)q.get(i1);
    }

    public q h(int i1)
    {
        return (q)q.get(i1);
    }

    public b i(int i1)
    {
        return (b)r.get(i1);
    }

    public r i()
    {
        return i;
    }

    public c j(int i1)
    {
        return (c)r.get(i1);
    }

    protected r l()
    {
        return com.umeng.message.proguard.j.g().a(com/umeng/message/proguard/j$a, com/umeng/message/proguard/j$a$a);
    }

    public B m()
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
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            l = s1;
        }
        return s1;
    }

    public g p()
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
        i = new <init>(true);
        i.S();
    }

    private a(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        int j1;
        t = -1;
        u = -1;
        S();
        i1 = 0;
        _lcls1 = com.umeng.message.proguard.P.b();
        j1 = 0;
_L41:
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        int k1 = i1;
        int j2 = h1.a();
        j2;
        JVM INSTR lookupswitch 8: default 997
    //                   0: 1015
    //                   10: 151
    //                   18: 192
    //                   26: 262
    //                   34: 335
    //                   42: 408
    //                   50: 481
    //                   58: 551;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        k1 = i1;
        a a1;
        int k2;
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
        n.add(h1.a(a, n1));
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
        q.add(h1.a(a, n1));
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
        o.add(h1.a(a, n1));
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
        s = (s)h1.a(a, n1);
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
        j = _lcls1.b();
        ad();
        throw h1;
        h1;
_L28:
        k1 = i1;
        throw (new s(h1.getMessage())).a(this);
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
        j = _lcls1.b();
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
