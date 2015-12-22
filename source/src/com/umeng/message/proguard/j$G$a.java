// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, g, p, D, 
//            s, B, y, x, 
//            h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private List b;
    private D c;
    private Object d;
    private long e;
    private long f;
    private double g;
    private g h;
    private Object i;

    static <init> U()
    {
        return W();
    }

    private void V()
    {
        if (p.m)
        {
            Y();
        }
    }

    private static Y W()
    {
        return new <init>();
    }

    private void X()
    {
        if ((a & 1) != 1)
        {
            b = new ArrayList(b);
            a = a | 1;
        }
    }

    private D Y()
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

    public static final c k()
    {
        return com.umeng.message.proguard.j.H();
    }

    public g A()
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
            obj = ((g)obj).h();
            i = obj;
            return ((String) (obj));
        } else
        {
            return (String)obj;
        }
    }

    public g D()
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

    public i E()
    {
        return W().a(H());
    }

    public H F()
    {
        return H();
    }

    public H G()
    {
        H h1 = H();
        if (!h1.H())
        {
            throw b(h1);
        } else
        {
            return h1;
        }
    }

    public b H()
    {
        int j1 = 1;
        b b1 = new nit>(this, null);
        int k1 = a;
        int i1;
        if (c == null)
        {
            if ((a & 1) == 1)
            {
                b = Collections.unmodifiableList(b);
                a = a & -2;
            }
            a(b1, b);
        } else
        {
            b(b1, c.f());
        }
        if ((k1 & 2) != 2)
        {
            j1 = 0;
        }
        c(b1, d);
        i1 = j1;
        if ((k1 & 4) == 4)
        {
            i1 = j1 | 2;
        }
        d(b1, e);
        j1 = i1;
        if ((k1 & 8) == 8)
        {
            j1 = i1 | 4;
        }
        e(b1, f);
        i1 = j1;
        if ((k1 & 0x10) == 16)
        {
            i1 = j1 | 8;
        }
        f(b1, g);
        j1 = i1;
        if ((k1 & 0x20) == 32)
        {
            j1 = i1 | 0x10;
        }
        g(b1, h);
        i1 = j1;
        if ((k1 & 0x40) == 64)
        {
            i1 = j1 | 0x20;
        }
        h(b1, i);
        i(b1, i1);
        aB();
        return b1;
    }

    public aB I()
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

    public c J()
    {
        return com.umeng.message.proguard.j.H();
    }

    public a K()
    {
        return (a)Y().b(h());
    }

    public List L()
    {
        return Y().h();
    }

    public Y M()
    {
        a = a & -3;
        d = d().d();
        aF();
        return this;
    }

    public aF N()
    {
        a = a & -5;
        e = 0L;
        aF();
        return this;
    }

    public aF O()
    {
        a = a & -9;
        f = 0L;
        aF();
        return this;
    }

    public aF P()
    {
        a = a & 0xffffffef;
        g = 0.0D;
        aF();
        return this;
    }

    public y Q()
    {
        return F();
    }

    public x R()
    {
        return F();
    }

    public F S()
    {
        a = a & 0xffffffdf;
        h = h().h();
        aF();
        return this;
    }

    public aF T()
    {
        a = a & 0xffffffbf;
        i = i().i();
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

    public d a(double d1)
    {
        a = a | 0x10;
        g = d1;
        aF();
        return this;
    }

    public a a(int i1, a a1)
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

    public a.u a(int i1, a.u u1)
    {
        if (c == null)
        {
            if (u1 == null)
            {
                throw new NullPointerException();
            } else
            {
                X();
                b.set(i1, u1);
                aF();
                return this;
            }
        } else
        {
            c.a(i1, u1);
            return this;
        }
    }

    public c a(long l1)
    {
        a = a | 4;
        e = l1;
        aF();
        return this;
    }

    public a a(a a1)
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

    public a.u a(a.u u1)
    {
        if (c == null)
        {
            if (u1 == null)
            {
                throw new NullPointerException();
            } else
            {
                X();
                b.add(u1);
                aF();
                return this;
            }
        } else
        {
            c.a(u1);
            return this;
        }
    }

    public c a(c c1)
    {
        D d1;
        d1 = null;
        if (c1 == c())
        {
            return this;
        }
        if (c != null) goto _L2; else goto _L1
_L1:
        if (!c(c1).isEmpty())
        {
            if (b.isEmpty())
            {
                b = b(c1);
                a = a & -2;
            } else
            {
                X();
                b.addAll(b(c1));
            }
            aF();
        }
_L4:
        if (c1.aF())
        {
            a = a | 2;
            d = d(c1);
            aF();
        }
        if (c1.aF())
        {
            a(c1.a());
        }
        if (c1.a())
        {
            b(c1.b());
        }
        if (c1.b())
        {
            a(c1.a());
        }
        if (c1.a())
        {
            f(c1.f());
        }
        if (c1.f())
        {
            a = a | 0x40;
            i = i(c1);
            aF();
        }
        d(c1.());
        return this;
_L2:
        if (!(c1).isEmpty())
        {
            if (c.d())
            {
                c.b();
                c = null;
                b = b(c1);
                a = a & -2;
                if (p.m)
                {
                    d1 = Y();
                }
                c = d1;
            } else
            {
                c.a(c(c1));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public c a(Iterable iterable)
    {
        if (c == null)
        {
            X();
            X(iterable, b);
            aF();
            return this;
        } else
        {
            c.a(iterable);
            return this;
        }
    }

    public c a(String s1)
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

    public aF a(int i1)
    {
        if (c == null)
        {
            return (c)b.get(i1);
        } else
        {
            return (b)c.a(i1);
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

    public a ah()
    {
        return m();
    }

    public m ai()
    {
        return E();
    }

    public x aj()
    {
        return H();
    }

    public x ak()
    {
        return G();
    }

    public y al()
    {
        return H();
    }

    public y am()
    {
        return G();
    }

    public G b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public a b(int i1, a a1)
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

    public a.u b(int i1, a.u u1)
    {
        if (c == null)
        {
            if (u1 == null)
            {
                throw new NullPointerException();
            } else
            {
                X();
                b.add(i1, u1);
                aF();
                return this;
            }
        } else
        {
            c.b(i1, u1);
            return this;
        }
    }

    public c b(long l1)
    {
        a = a | 8;
        f = l1;
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
            a = a | 0x40;
            i = s1;
            aF();
            return this;
        }
    }

    public aF b(int i1)
    {
        if (c == null)
        {
            return (c)b.get(i1);
        } else
        {
            return (b)c.c(i1);
        }
    }

    public c c(int i1)
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

    public c c(x x1)
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
        return E();
    }

    public E d()
    {
        return E();
    }

    public E d(x x1)
    {
        if (x1 instanceof E)
        {
            return a((a)x1);
        } else
        {
            super.a(x1);
            return this;
        }
    }

    public a d(int i1)
    {
        return (a)Y().b(i1);
    }

    public Y d(h h1, n n1)
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
            a = a | 2;
            d = g1;
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

    public a e(int i1)
    {
        return (a)Y().c(i1, h());
    }

    public h f()
    {
        return E();
    }

    public E f(g g1)
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

    public aF g(g g1)
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

    public aF g()
    {
        return E();
    }

    public E h()
    {
        return m();
    }

    public m i()
    {
        return E();
    }

    public E j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.I().m(com/umeng/message/proguard/j$G, com/umeng/message/proguard/j$G$a);
    }

    public m m()
    {
        super.();
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
        h = g.d;
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
            obj = ((g)obj).h();
            d = obj;
            return ((String) (obj));
        } else
        {
            return (String)obj;
        }
    }

    public g s()
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

    private a()
    {
        b = Collections.emptyList();
        d = "";
        h = g.d;
        i = "";
        V();
    }

    private V(V v1)
    {
        super(v1);
        b = Collections.emptyList();
        d = "";
        h = g.d;
        i = "";
        V();
    }

    V(V v1, V v2)
    {
        this(v1);
    }
}
