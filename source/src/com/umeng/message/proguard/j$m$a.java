// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, D, s, 
//            B, g, y, x, 
//            h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private g b;
    private boolean c;
    private boolean d;
    private boolean e;
    private Object f;
    private boolean g;
    private List h;
    private D i;

    static <init> T()
    {
        return V();
    }

    private void U()
    {
        if (p.m)
        {
            X();
        }
    }

    private static X V()
    {
        return new <init>();
    }

    private void W()
    {
        if ((a & 0x40) != 64)
        {
            h = new ArrayList(h);
            a = a | 0x40;
        }
    }

    private D X()
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
            i = new D(list, flag, aE(), aD());
            h = null;
        }
        return i;
    }

    public static final i k()
    {
        return com.umeng.message.proguard.j.x();
    }

    public i A()
    {
        return D();
    }

    public D B()
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

    public i D()
    {
        return V().a(G());
    }

    public G E()
    {
        return G();
    }

    public G F()
    {
        G g1 = G();
        if (!g1.G())
        {
            throw b(g1);
        } else
        {
            return g1;
        }
    }

    public b G()
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
        if (i == null)
        {
            if ((a & 0x40) == 64)
            {
                h = Collections.unmodifiableList(h);
                a = a & 0xffffffbf;
            }
            a(b1, h);
        } else
        {
            h(b1, i.f());
        }
        i(b1, i1);
        aB();
        return b1;
    }

    public aB H()
    {
        a = a & -2;
        b = a;
        aF();
        return this;
    }

    public aF I()
    {
        a = a & -3;
        c = false;
        aF();
        return this;
    }

    public aF J()
    {
        return com.umeng.message.proguard.j.x();
    }

    public aF K()
    {
        a = a & -5;
        d = false;
        aF();
        return this;
    }

    public aF L()
    {
        a = a & -9;
        e = false;
        aF();
        return this;
    }

    public aF M()
    {
        a = a & 0xffffffef;
        f = f().f();
        aF();
        return this;
    }

    public aF N()
    {
        a = a & 0xffffffdf;
        g = false;
        aF();
        return this;
    }

    public aF O()
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

    public i P()
    {
        return (i)X().b(X());
    }

    public y Q()
    {
        return E();
    }

    public x R()
    {
        return E();
    }

    public List S()
    {
        return X().h();
    }

    public X a(h h1, n n1)
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
        if (i == null)
        {
            return (i)h.get(i1);
        } else
        {
            return (h)i.a(i1);
        }
    }

    public i a(int i1, i j1)
    {
        if (i == null)
        {
            W();
            h.set(i1, j1.G());
            aF();
            return this;
        } else
        {
            i.a(i1, j1.G());
            return this;
        }
    }

    public G a(int i1, G g1)
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

    public i a(i i1)
    {
        if (i == null)
        {
            W();
            h.add(i1.G());
            aF();
            return this;
        } else
        {
            i.a(i1.G());
            return this;
        }
    }

    public G a(G g1)
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

    public i a(i i1)
    {
        if (i1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = a | 1;
            b = i1;
            aF();
            return this;
        }
    }

    public aF a(aF af)
    {
        D d1;
        d1 = null;
        if (af == aF())
        {
            return this;
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
            b(af.b());
        }
        if (af.b())
        {
            c(af.c());
        }
        if (af.c())
        {
            a = a | 0x10;
            f = f(af);
            aF();
        }
        if (af.aF())
        {
            d(af.d());
        }
        if (i != null) goto _L2; else goto _L1
_L1:
        if (!i(af).isEmpty())
        {
            if (h.isEmpty())
            {
                h = h(af);
                a = a & 0xffffffbf;
            } else
            {
                W();
                h.addAll(h(af));
            }
            aF();
        }
_L4:
        a(((a) (af)));
        d(af.());
        return this;
_L2:
        if (!(af).isEmpty())
        {
            if (i.d())
            {
                i.b();
                i = null;
                h = h(af);
                a = a & 0xffffffbf;
                if (p.m)
                {
                    d1 = X();
                }
                i = d1;
            } else
            {
                i.a(i(af));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public i a(Iterable iterable)
    {
        if (i == null)
        {
            W();
            W(iterable, h);
            aF();
            return this;
        } else
        {
            i.a(iterable);
            return this;
        }
    }

    public i a(String s1)
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

    public aF a(boolean flag)
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

    public af ah()
    {
        return m();
    }

    public m ai()
    {
        return D();
    }

    public x aj()
    {
        return G();
    }

    public x ak()
    {
        return F();
    }

    public y al()
    {
        return G();
    }

    public y am()
    {
        return F();
    }

    public F b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1)
    {
        if (i == null)
        {
            return (i)h.get(i1);
        } else
        {
            return (h)i.c(i1);
        }
    }

    public i b(int i1, i j1)
    {
        if (i == null)
        {
            W();
            h.add(i1, j1.G());
            aF();
            return this;
        } else
        {
            i.b(i1, j1.G());
            return this;
        }
    }

    public G b(int i1, G g1)
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

    public i b(boolean flag)
    {
        a = a | 4;
        d = flag;
        aF();
        return this;
    }

    public aF c(int i1)
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

    public i c(boolean flag)
    {
        a = a | 8;
        e = flag;
        aF();
        return this;
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
        return D();
    }

    public D d()
    {
        return D();
    }

    public D d(int i1)
    {
        return (D)X().b(i1);
    }

    public X d(x x1)
    {
        if (x1 instanceof X)
        {
            return a((a)x1);
        } else
        {
            super.a(x1);
            return this;
        }
    }

    public a d(boolean flag)
    {
        a = a | 0x20;
        g = flag;
        aF();
        return this;
    }

    public aF d(h h1, n n1)
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

    public i e()
    {
        return m();
    }

    public m e(int i1)
    {
        return (m)X().c(i1, X());
    }

    public X e(g g1)
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

    public h f()
    {
        return D();
    }

    public D g()
    {
        return D();
    }

    public D h()
    {
        return m();
    }

    public m i()
    {
        return D();
    }

    public D j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.y().m(com/umeng/message/proguard/j$m, com/umeng/message/proguard/j$m$a);
    }

    public m m()
    {
        super.m();
        b = a;
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

    public a o()
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
            obj = ((g)obj).h();
            f = obj;
            return ((String) (obj));
        } else
        {
            return (String)obj;
        }
    }

    public g x()
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

    public boolean y()
    {
        return (a & 0x20) == 32;
    }

    public boolean z()
    {
        return g;
    }

    private ion()
    {
        b = a;
        f = "";
        h = Collections.emptyList();
        U();
    }

    private U(U u1)
    {
        super(u1);
        b = a;
        f = "";
        h = Collections.emptyList();
        U();
    }

    U(U u1, U u2)
    {
        this(u1);
    }
}
