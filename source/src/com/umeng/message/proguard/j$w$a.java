// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, L, s, 
//            B, g, y, x, 
//            h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private Object b;
    private Object c;
    private Object d;
    private C e;
    private L f;

    static <init> I()
    {
        return L();
    }

    private void K()
    {
        if (p.m)
        {
            M();
        }
    }

    private static M L()
    {
        return new <init>();
    }

    private L M()
    {
        if (f == null)
        {
            f = new L(e, aE(), aD());
            e = null;
        }
        return f;
    }

    public static final f k()
    {
        return com.umeng.message.proguard.j.r();
    }

    public f A()
    {
        return f();
    }

    public f B()
    {
        f f1 = C();
        if (!f1.C())
        {
            throw b(f1);
        } else
        {
            return f1;
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
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        } else
        {
            i1 = j1;
        }
        if (f == null)
        {
            f(b1, e);
        } else
        {
            e(b1, (e)f.d());
        }
        f(b1, i1);
        aB();
        return b1;
    }

    public aB D()
    {
        a = a & -2;
        b = b().b();
        aF();
        return this;
    }

    public aF E()
    {
        a = a & -3;
        c = c().c();
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
        if (f == null)
        {
            e = e();
            aF();
        } else
        {
            f.g();
        }
        a = a & -9;
        return this;
    }

    public a H()
    {
        a = a | 8;
        aF();
        return (aF)M().e();
    }

    public M J()
    {
        return com.umeng.message.proguard.j.r();
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
            a = a | 2;
            c = c(d1);
            aF();
        }
        if (d1.aF())
        {
            a = a | 4;
            d = d(d1);
            aF();
        }
        if (d1.aF())
        {
            b(d1.b());
        }
        d(d1.());
        return this;
    }

    public  a( )
    {
        if (f == null)
        {
            e = .s();
            aF();
        } else
        {
            f.a(.s());
        }
        a = a | 8;
        return this;
    }

    public a a(a a1)
    {
        if (f == null)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            }
            e = a1;
            aF();
        } else
        {
            f.a(a1);
        }
        a = a | 8;
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
        return !w() || x().x();
    }

    public x ah()
    {
        return m();
    }

    public m ai()
    {
        return z();
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

    public B b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(e e1)
    {
        if (f == null)
        {
            if ((a & 8) == 8 && e != e())
            {
                e = e(e).a(e1).t();
            } else
            {
                e = e1;
            }
            aF();
        } else
        {
            f.b(e1);
        }
        a = a | 8;
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

    public aF c(String s1)
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
        return z();
    }

    public z d()
    {
        return z();
    }

    public z d(x x1)
    {
        if (x1 instanceof z)
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
        return z();
    }

    public z f(g g1)
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

    public aF g(g g1)
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

    public aF g()
    {
        return z();
    }

    public z h()
    {
        return m();
    }

    public m i()
    {
        return z();
    }

    public z j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.s().m(com/umeng/message/proguard/j$w, com/umeng/message/proguard/j$w$a);
    }

    public m m()
    {
        super.();
        b = "";
        a = a & -2;
        c = "";
        a = a & -3;
        d = "";
        a = a & -5;
        if (f == null)
        {
            e = e();
        } else
        {
            f.g();
        }
        a = a & -9;
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

    public boolean t()
    {
        return (a & 4) == 4;
    }

    public String u()
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

    public g v()
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

    public boolean w()
    {
        return (a & 8) == 8;
    }

    public a x()
    {
        if (f == null)
        {
            return e;
        } else
        {
            return (e)f.c();
        }
    }

    public f y()
    {
        if (f != null)
        {
            return (f)f.f();
        } else
        {
            return e;
        }
    }

    public e z()
    {
        return L().a(C());
    }

    private ion()
    {
        b = "";
        c = "";
        d = "";
        e = e();
        K();
    }

    private K(K k1)
    {
        super(k1);
        b = "";
        c = "";
        d = "";
        e = e();
        K();
    }

    K(K k1, K k2)
    {
        this(k1);
    }
}
