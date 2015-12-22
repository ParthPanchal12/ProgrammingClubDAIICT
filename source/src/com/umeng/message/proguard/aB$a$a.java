// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            aB, L, s, B, 
//            g, y, x, h, 
//            n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private aF b;
    private Object c;
    private aF d;
    private L e;

    static <init> D()
    {
        return F();
    }

    private void E()
    {
        if (F())
        {
            G();
        }
    }

    private static G F()
    {
        return new <init>();
    }

    private L G()
    {
        if (e == null)
        {
            e = new L(d, aE(), aD());
            d = null;
        }
        return e;
    }

    public static final e k()
    {
        return aB.b();
    }

    public e A()
    {
        a = a & -3;
        c = c().c();
        aF();
        return this;
    }

    public aF B()
    {
        if (e == null)
        {
            d = h();
            aF();
        } else
        {
            e.g();
        }
        a = a & -5;
        return this;
    }

    public a C()
    {
        a = a | 4;
        aF();
        return (a)G().e();
    }

    public G J()
    {
        return aB.b();
    }

    public y Q()
    {
        return w();
    }

    public x R()
    {
        return w();
    }

    public w a(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e a(x x1)
    {
        return d(x1);
    }

    public a a(a a1)
    {
        if (e == null)
        {
            d = a1.B();
            aF();
        } else
        {
            e.a(a1.B());
        }
        a = a | 4;
        return this;
    }

    public a a(a a1)
    {
        if (e == null)
        {
            if (a1 == null)
            {
                throw new NullPointerException();
            }
            d = a1;
            aF();
        } else
        {
            e.a(a1);
        }
        a = a | 4;
        return this;
    }

    public a a(a a1)
    {
        if (a1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = a | 1;
            b = a1;
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
            a(af.a());
        }
        if (af.a())
        {
            a = a | 2;
            c = c(af);
            aF();
        }
        if (af.aF())
        {
            b(af.b());
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
            a = a | 2;
            c = s1;
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
        return y();
    }

    public x ak()
    {
        return x();
    }

    public y al()
    {
        return y();
    }

    public y am()
    {
        return x();
    }

    public x b(x x1)
    {
        if (e == null)
        {
            if ((a & 4) == 4 && d != h())
            {
                d = a(d).a(x1).C();
            } else
            {
                d = x1;
            }
            aF();
        } else
        {
            e.b(x1);
        }
        a = a | 4;
        return this;
    }

    public a b(h h1, n n1)
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
            a = a | 2;
            c = g1;
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
        return aB.c().m(com/umeng/message/proguard/aB$a, com/umeng/message/proguard/aB$a$a);
    }

    public m m()
    {
        super.m();
        b = a;
        a = a & -2;
        c = "";
        a = a & -3;
        if (e == null)
        {
            d = h();
        } else
        {
            e.g();
        }
        a = a & -5;
        return this;
    }

    public a n()
    {
        return F().a(y());
    }

    public boolean o()
    {
        return (a & 1) == 1;
    }

    public a p()
    {
        return b;
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

    public a u()
    {
        if (e == null)
        {
            return d;
        } else
        {
            return (d)e.c();
        }
    }

    public e v()
    {
        if (e != null)
        {
            return (e)e.f();
        } else
        {
            return d;
        }
    }

    public d w()
    {
        return d();
    }

    public d x()
    {
        d d1 = y();
        if (!d1.y())
        {
            throw b(d1);
        } else
        {
            return d1;
        }
    }

    public b y()
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
        if ((k1 & 4) == 4)
        {
            i1 = j1 | 4;
        } else
        {
            i1 = j1;
        }
        if (e == null)
        {
            e(b1, d);
        } else
        {
            d(b1, (d)e.d());
        }
        e(b1, i1);
        aB();
        return b1;
    }

    public aB z()
    {
        a = a & -2;
        b = a;
        aF();
        return this;
    }

    private on()
    {
        b = a;
        c = "";
        d = h();
        E();
    }

    private E(E e1)
    {
        super(e1);
        b = a;
        c = "";
        d = h();
        E();
    }

    E(E e1, E e2)
    {
        this(e1);
    }
}
