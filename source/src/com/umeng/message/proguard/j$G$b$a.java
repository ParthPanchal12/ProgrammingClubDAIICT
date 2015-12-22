// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, s, B, 
//            g, y, x, h, 
//            n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private Object b;
    private boolean c;

    private static <init> A()
    {
        return new <init>();
    }

    public static final <init> k()
    {
        return com.umeng.message.proguard.j.J();
    }

    static <init> y()
    {
        return A();
    }

    private void z()
    {
        if (!p.m);
    }

    public A J()
    {
        return com.umeng.message.proguard.j.J();
    }

    public y Q()
    {
        return t();
    }

    public x R()
    {
        return t();
    }

    public t a(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e a(x x1)
    {
        return d(x1);
    }

    public d a(d d1)
    {
        if (d1 == d())
        {
            return this;
        }
        if (d1.d())
        {
            a = a | 1;
            b = b(d1);
            aF();
        }
        if (d1.aF())
        {
            a(d1.a());
        }
        d(d1.());
        return this;
    }

    public  a(String s1)
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

    public aF a(boolean flag)
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

    public q ah()
    {
        return m();
    }

    public m ai()
    {
        return s();
    }

    public x aj()
    {
        return v();
    }

    public x ak()
    {
        return u();
    }

    public y al()
    {
        return v();
    }

    public y am()
    {
        return u();
    }

    public u b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e c(x x1)
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
        return s();
    }

    public s d()
    {
        return s();
    }

    public s d(x x1)
    {
        if (x1 instanceof s)
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
        return s();
    }

    public s g()
    {
        return s();
    }

    public s h()
    {
        return m();
    }

    public m i()
    {
        return s();
    }

    public s j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.K().m(com/umeng/message/proguard/j$G$b, com/umeng/message/proguard/j$G$b$a);
    }

    public m m()
    {
        super.m();
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

    public boolean r()
    {
        return c;
    }

    public c s()
    {
        return A().a(v());
    }

    public v t()
    {
        return v();
    }

    public v u()
    {
        v v1 = v();
        if (!v1.v())
        {
            throw b(v1);
        } else
        {
            return v1;
        }
    }

    public b v()
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
        c(b1, j1);
        aB();
        return b1;
    }

    public aB w()
    {
        a = a & -2;
        b = b().b();
        aF();
        return this;
    }

    public aF x()
    {
        a = a & -3;
        c = false;
        aF();
        return this;
    }

    private n()
    {
        b = "";
        z();
    }

    private z(z z1)
    {
        super(z1);
        b = "";
        z();
    }

    z(z z1, z z2)
    {
        this(z1);
    }
}
