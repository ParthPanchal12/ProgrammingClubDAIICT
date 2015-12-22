// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, s, B, 
//            g, y, x, h, 
//            n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private List b;
    private List c;
    private Object d;
    private Object e;

    static <init> F()
    {
        return H();
    }

    private void G()
    {
        if (!p.m);
    }

    private static H H()
    {
        return new <init>();
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

    public static final a k()
    {
        return com.umeng.message.proguard.j.N();
    }

    public a A()
    {
        int i1 = 1;
        a a1 = new nit>(this, null);
        int k1 = a;
        if ((a & 1) == 1)
        {
            b = Collections.unmodifiableList(b);
            a = a & -2;
        }
        a(a1, b);
        if ((a & 2) == 2)
        {
            c = Collections.unmodifiableList(c);
            a = a & -3;
        }
        a(a1, c);
        int j1;
        if ((k1 & 4) != 4)
        {
            i1 = 0;
        }
        c(a1, d);
        j1 = i1;
        if ((k1 & 8) == 8)
        {
            j1 = i1 | 2;
        }
        d(a1, e);
        e(a1, j1);
        aB();
        return a1;
    }

    public aB B()
    {
        b = Collections.emptyList();
        a = a & -2;
        aF();
        return this;
    }

    public aF C()
    {
        c = Collections.emptyList();
        a = a & -3;
        aF();
        return this;
    }

    public aF D()
    {
        a = a & -5;
        d = d().d();
        aF();
        return this;
    }

    public aF E()
    {
        a = a & -9;
        e = e().e();
        aF();
        return this;
    }

    public aF J()
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

    public b a(h h1, n n1)
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
        I();
        b.set(i1, Integer.valueOf(j1));
        aF();
        return this;
    }

    public aF a(aF af)
    {
        if (af == aF())
        {
            return this;
        }
        if (!aF(af).isEmpty())
        {
            if (b.isEmpty())
            {
                b = b(af);
                a = a & -2;
            } else
            {
                I();
                b.addAll(b(af));
            }
            aF();
        }
        if (!aF(af).isEmpty())
        {
            if (c.isEmpty())
            {
                c = c(af);
                a = a & -3;
            } else
            {
                K();
                c.addAll(c(af));
            }
            aF();
        }
        if (af.aF())
        {
            a = a | 4;
            d = d(af);
            aF();
        }
        if (af.aF())
        {
            a = a | 8;
            e = e(af);
            aF();
        }
        d(af.());
        return this;
    }

    public  a(Iterable iterable)
    {
        I();
        I(iterable, b);
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

    public aF ah()
    {
        return m();
    }

    public m ai()
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

    public c b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1, int j1)
    {
        K();
        c.set(i1, Integer.valueOf(j1));
        aF();
        return this;
    }

    public aF b(Iterable iterable)
    {
        K();
        K(iterable, c);
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
            a = a | 8;
            e = s1;
            aF();
            return this;
        }
    }

    public aF c(int i1)
    {
        I();
        b.add(Integer.valueOf(i1));
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
        return x();
    }

    public x d()
    {
        return x();
    }

    public x d(int i1)
    {
        K();
        c.add(Integer.valueOf(i1));
        aF();
        return this;
    }

    public aF d(x x1)
    {
        if (x1 instanceof aF)
        {
            return a((a)x1);
        } else
        {
            super.a(x1);
            return this;
        }
    }

    public a d(h h1, n n1)
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
            a = a | 4;
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

    public a f()
    {
        return x();
    }

    public x f(g g1)
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

    public aF g()
    {
        return x();
    }

    public x h()
    {
        return m();
    }

    public m i()
    {
        return x();
    }

    public x j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.O().m(com/umeng/message/proguard/j$E$b, com/umeng/message/proguard/j$E$b$a);
    }

    public m m()
    {
        super.m();
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

    public e x()
    {
        return H().a(A());
    }

    public A y()
    {
        return A();
    }

    public A z()
    {
        A a1 = A();
        if (!a1.A())
        {
            throw b(a1);
        } else
        {
            return a1;
        }
    }

    private n()
    {
        b = Collections.emptyList();
        c = Collections.emptyList();
        d = "";
        e = "";
        G();
    }

    private G(G g1)
    {
        super(g1);
        b = Collections.emptyList();
        c = Collections.emptyList();
        d = "";
        e = "";
        G();
    }

    G(G g1, G g2)
    {
        this(g1);
    }
}
