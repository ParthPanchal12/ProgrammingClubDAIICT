// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, L, g, 
//            s, B, y, x, 
//            h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private Object b;
    private int c;
    private a d;
    private a e;
    private Object f;
    private Object g;
    private Object h;
    private a i;
    private L j;

    static <init> Y()
    {
        return aa();
    }

    private void Z()
    {
        if (p.m)
        {
            ab();
        }
    }

    private static ab aa()
    {
        return new <init>();
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

    public static final j k()
    {
        return com.umeng.message.proguard.j.j();
    }

    public String A()
    {
        Object obj = g;
        if (!(obj instanceof String))
        {
            obj = ((g)obj).h();
            g = obj;
            return ((String) (obj));
        } else
        {
            return (String)obj;
        }
    }

    public g B()
    {
        Object obj = g;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            g = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
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
            obj = ((g)obj).h();
            h = obj;
            return ((String) (obj));
        } else
        {
            return (String)obj;
        }
    }

    public g E()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            h = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean F()
    {
        return (a & 0x80) == 128;
    }

    public a G()
    {
        if (j == null)
        {
            return i;
        } else
        {
            return (i)j.c();
        }
    }

    public j H()
    {
        if (j != null)
        {
            return (j)j.f();
        } else
        {
            return i;
        }
    }

    public i I()
    {
        return aa().a(M());
    }

    public M J()
    {
        return com.umeng.message.proguard.j.j();
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
        int j1 = 1;
        b b1 = new nit>(this, null);
        int k1 = a;
        int i1;
        if ((k1 & 1) != 1)
        {
            j1 = 0;
        }
        a(b1, b);
        i1 = j1;
        if ((k1 & 2) == 2)
        {
            i1 = j1 | 2;
        }
        b(b1, c);
        j1 = i1;
        if ((k1 & 4) == 4)
        {
            j1 = i1 | 4;
        }
        c(b1, d);
        i1 = j1;
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        }
        d(b1, e);
        j1 = i1;
        if ((k1 & 0x10) == 16)
        {
            j1 = i1 | 0x10;
        }
        e(b1, f);
        i1 = j1;
        if ((k1 & 0x20) == 32)
        {
            i1 = j1 | 0x20;
        }
        f(b1, g);
        j1 = i1;
        if ((k1 & 0x40) == 64)
        {
            j1 = i1 | 0x40;
        }
        g(b1, h);
        if ((k1 & 0x80) == 128)
        {
            i1 = j1 | 0x80;
        } else
        {
            i1 = j1;
        }
        if (j == null)
        {
            j(b1, i);
        } else
        {
            i(b1, (i)j.d());
        }
        j(b1, i1);
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
        a = a & -3;
        c = 0;
        aF();
        return this;
    }

    public aF P()
    {
        a = a & -5;
        d = a;
        aF();
        return this;
    }

    public y Q()
    {
        return K();
    }

    public x R()
    {
        return K();
    }

    public K S()
    {
        a = a & -9;
        e = a;
        aF();
        return this;
    }

    public aF T()
    {
        a = a & 0xffffffef;
        f = f().f();
        aF();
        return this;
    }

    public aF U()
    {
        a = a & 0xffffffdf;
        g = g().g();
        aF();
        return this;
    }

    public aF V()
    {
        a = a & 0xffffffbf;
        h = h().h();
        aF();
        return this;
    }

    public aF W()
    {
        if (j == null)
        {
            i = i();
            aF();
        } else
        {
            j.g();
        }
        a = a & 0xffffff7f;
        return this;
    }

    public a X()
    {
        a = a | 0x80;
        aF();
        return (aF)ab().e();
    }

    public ab a(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e a(x x1)
    {
        return d(x1);
    }

    public d a(int i1)
    {
        a = a | 2;
        c = i1;
        aF();
        return this;
    }

    public aF a(aF af)
    {
        if (af == null)
        {
            throw new NullPointerException();
        } else
        {
            a = a | 4;
            d = af;
            aF();
            return this;
        }
    }

    public aF a(aF af)
    {
        if (af == null)
        {
            throw new NullPointerException();
        } else
        {
            a = a | 8;
            e = af;
            aF();
            return this;
        }
    }

    public aF a(aF af)
    {
        if (af == aF())
        {
            return this;
        }
        if (af.aF())
        {
            a = a | 1;
            b = b(af);
            aF();
        }
        if (af.aF())
        {
            a(af.a());
        }
        if (af.a())
        {
            a(af.a());
        }
        if (af.a())
        {
            a(af.a());
        }
        if (af.a())
        {
            a = a | 0x10;
            f = f(af);
            aF();
        }
        if (af.aF())
        {
            a = a | 0x20;
            g = g(af);
            aF();
        }
        if (af.aF())
        {
            a = a | 0x40;
            h = h(af);
            aF();
        }
        if (af.aF())
        {
            b(af.b());
        }
        d(af.());
        return this;
    }

    public  a( )
    {
        if (j == null)
        {
            i = .F();
            aF();
        } else
        {
            j.a(.F());
        }
        a = a | 0x80;
        return this;
    }

    public a a(a a1)
    {
        if (j == null)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            }
            i = a1;
            aF();
        } else
        {
            j.a(a1);
        }
        a = a | 0x80;
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

    public final boolean a()
    {
        return !F() || G().G();
    }

    public G ah()
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

    public e b(e e1)
    {
        if (j == null)
        {
            if ((a & 0x80) == 128 && i != i())
            {
                i = i(i).a(e1).G();
            } else
            {
                i = e1;
            }
            aF();
        } else
        {
            j.b(e1);
        }
        a = a | 0x80;
        return this;
    }

    public a b(String s1)
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

    public aF c(String s1)
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

    public I d()
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

    public a d(String s1)
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

    public aF d(h h1, n n1)
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

    public a f()
    {
        return I();
    }

    public I f(g g1)
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

    public aF g(g g1)
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

    public aF g()
    {
        return I();
    }

    public I h(g g1)
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

    public aF h()
    {
        return m();
    }

    public m i()
    {
        return I();
    }

    public I j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.k().m(com/umeng/message/proguard/j$k, com/umeng/message/proguard/j$k$a);
    }

    public m m()
    {
        super.();
        b = "";
        a = a & -2;
        c = 0;
        a = a & -3;
        d = a;
        a = a & -5;
        e = a;
        a = a & -9;
        f = "";
        a = a & 0xffffffef;
        g = "";
        a = a & 0xffffffdf;
        h = "";
        a = a & 0xffffffbf;
        if (j == null)
        {
            i = i();
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

    public a t()
    {
        return d;
    }

    public boolean u()
    {
        return (a & 8) == 8;
    }

    public a v()
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
            obj = ((g)obj).h();
            f = obj;
            return ((String) (obj));
        } else
        {
            return (String)obj;
        }
    }

    public g y()
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

    public boolean z()
    {
        return (a & 0x20) == 32;
    }

    private ion()
    {
        b = "";
        d = a;
        e = a;
        f = "";
        g = "";
        h = "";
        i = i();
        Z();
    }

    private Z(Z z1)
    {
        super(z1);
        b = "";
        d = a;
        e = a;
        f = "";
        g = "";
        h = "";
        i = i();
        Z();
    }

    Z(Z z1, Z z2)
    {
        this(z1);
    }
}
