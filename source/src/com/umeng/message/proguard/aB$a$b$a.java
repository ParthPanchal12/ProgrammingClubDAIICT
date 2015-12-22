// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            aB, s, B, g, 
//            y, x, h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private int b;
    private int c;
    private Object d;
    private int e;
    private Object f;

    static <init> I()
    {
        return L();
    }

    private void K()
    {
        if (!L());
    }

    private static L L()
    {
        return new <init>();
    }

    public static final <init> k()
    {
        return aB.d();
    }

    public <init> A()
    {
        return <init>();
    }

    public <init> B()
    {
        <init> <init>1 = C();
        if (!<init>1.C())
        {
            throw b(<init>1);
        } else
        {
            return <init>1;
        }
    }

    public b C()
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
        f(b1, j1);
        aB();
        return b1;
    }

    public aB D()
    {
        a = a & -2;
        b = 0;
        aF();
        return this;
    }

    public aF E()
    {
        a = a & -3;
        c = 0;
        aF();
        return this;
    }

    public aF F()
    {
        a = a & -5;
        d = d().d();
        aF();
        return this;
    }

    public aF G()
    {
        a = a & -9;
        e = 0;
        aF();
        return this;
    }

    public aF H()
    {
        a = a & 0xffffffef;
        f = f().f();
        aF();
        return this;
    }

    public aF J()
    {
        return aB.d();
    }

    public y Q()
    {
        return A();
    }

    public x R()
    {
        return A();
    }

    public A a(h h1, n n1)
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
        a = a | 1;
        b = i1;
        aF();
        return this;
    }

    public aF a(aF af)
    {
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
            b(af.b());
        }
        if (af.b())
        {
            a = a | 4;
            d = d(af);
            aF();
        }
        if (af.aF())
        {
            c(af.c());
        }
        if (af.c())
        {
            a = a | 0x10;
            f = f(af);
            aF();
        }
        d(af.());
        return this;
    }

    public  a(String s1)
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
        return n();
    }

    public x aj()
    {
        return C();
    }

    public x ak()
    {
        return B();
    }

    public y al()
    {
        return C();
    }

    public y am()
    {
        return B();
    }

    public B b(int i1)
    {
        a = a | 2;
        c = i1;
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
            a = a | 0x10;
            f = s1;
            aF();
            return this;
        }
    }

    public aF b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e c(int i1)
    {
        a = a | 8;
        e = i1;
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
        return n();
    }

    public n d()
    {
        return n();
    }

    public n d(x x1)
    {
        if (x1 instanceof n)
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

    public a f(g g1)
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

    public aF f()
    {
        return n();
    }

    public n g()
    {
        return n();
    }

    public n h()
    {
        return m();
    }

    public m i()
    {
        return n();
    }

    public n j()
    {
        return m();
    }

    protected m l()
    {
        return aB.e().m(com/umeng/message/proguard/aB$a$b, com/umeng/message/proguard/aB$a$b$a);
    }

    public m m()
    {
        super.m();
        b = 0;
        a = a & -2;
        c = 0;
        a = a & -3;
        d = "";
        a = a & -5;
        e = 0;
        a = a & -9;
        f = "";
        a = a & 0xffffffef;
        return this;
    }

    public a n()
    {
        return L().a(C());
    }

    public boolean o()
    {
        return (a & 1) == 1;
    }

    public int p()
    {
        return b;
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

    public String t()
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

    public g u()
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

    public boolean v()
    {
        return (a & 8) == 8;
    }

    public int w()
    {
        return e;
    }

    public boolean x()
    {
        return (a & 0x10) == 16;
    }

    public String y()
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

    public g z()
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

    private ()
    {
        d = "";
        f = "";
        K();
    }

    private K(K k1)
    {
        super(k1);
        d = "";
        f = "";
        K();
    }

    K(K k1, K k2)
    {
        this(k1);
    }
}
