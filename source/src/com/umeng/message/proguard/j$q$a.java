// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, D, p, s, 
//            B, y, x, h, 
//            n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private List b;
    private D c;

    private void A()
    {
        if ((a & 1) != 1)
        {
            b = new ArrayList(b);
            a = a | 1;
        }
    }

    private D B()
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
        return com.umeng.message.proguard.j.b();
    }

    static c x()
    {
        return z();
    }

    private void y()
    {
        if (p.m)
        {
            B();
        }
    }

    private static B z()
    {
        return new <init>();
    }

    public <init> J()
    {
        return com.umeng.message.proguard.j.b();
    }

    public y Q()
    {
        return r();
    }

    public x R()
    {
        return r();
    }

    public r a(h h1, n n1)
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
        if (c == null)
        {
            return (c)b.get(i1);
        } else
        {
            return (b)c.a(i1);
        }
    }

    public c a(int i1, c c1)
    {
        if (c == null)
        {
            A();
            b.set(i1, c1.N());
            aF();
            return this;
        } else
        {
            c.a(i1, c1.N());
            return this;
        }
    }

    public N a(int i1, N n1)
    {
        if (c == null)
        {
            if (n1 == null)
            {
                throw new NullPointerException();
            } else
            {
                A();
                b.set(i1, n1);
                aF();
                return this;
            }
        } else
        {
            c.a(i1, n1);
            return this;
        }
    }

    public c a(c c1)
    {
        if (c == null)
        {
            A();
            b.add(c1.N());
            aF();
            return this;
        } else
        {
            c.a(c1.N());
            return this;
        }
    }

    public N a(N n1)
    {
        if (c == null)
        {
            if (n1 == null)
            {
                throw new NullPointerException();
            } else
            {
                A();
                b.add(n1);
                aF();
                return this;
            }
        } else
        {
            c.a(n1);
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
                A();
                b.addAll(b(c1));
            }
            aF();
        }
_L4:
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
                    d1 = B();
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
            A();
            A(iterable, b);
            aF();
            return this;
        } else
        {
            c.a(iterable);
            return this;
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
        return q();
    }

    public x aj()
    {
        return t();
    }

    public x ak()
    {
        return s();
    }

    public y al()
    {
        return t();
    }

    public y am()
    {
        return s();
    }

    public s b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1)
    {
        if (c == null)
        {
            return (c)b.get(i1);
        } else
        {
            return (b)c.c(i1);
        }
    }

    public c b(int i1, c c1)
    {
        if (c == null)
        {
            A();
            b.add(i1, c1.N());
            aF();
            return this;
        } else
        {
            c.b(i1, c1.N());
            return this;
        }
    }

    public N b(int i1, N n1)
    {
        if (c == null)
        {
            if (n1 == null)
            {
                throw new NullPointerException();
            } else
            {
                A();
                b.add(i1, n1);
                aF();
                return this;
            }
        } else
        {
            c.b(i1, n1);
            return this;
        }
    }

    public c c(int i1)
    {
        if (c == null)
        {
            A();
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
        return q();
    }

    public q d()
    {
        return q();
    }

    public q d(int i1)
    {
        return (q)B().b(i1);
    }

    public B d(x x1)
    {
        if (x1 instanceof B)
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

    public m e(int i1)
    {
        return (m)B().c(i1, B());
    }

    public B e(h h1, n n1)
        throws IOException
    {
        h1 = (B)B.d(h1, n1);
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
        return q();
    }

    public q g()
    {
        return q();
    }

    public q h()
    {
        return m();
    }

    public m i()
    {
        return q();
    }

    public q j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.c().m(com/umeng/message/proguard/j$q, com/umeng/message/proguard/j$q$a);
    }

    public m m()
    {
        super.();
        if (c == null)
        {
            b = Collections.emptyList();
            a = a & -2;
            return this;
        } else
        {
            c.e();
            return this;
        }
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

    public c q()
    {
        return z().a(t());
    }

    public t r()
    {
        return t();
    }

    public t s()
    {
        t t1 = t();
        if (!t1.t())
        {
            throw b(t1);
        } else
        {
            return t1;
        }
    }

    public b t()
    {
        b b1 = new nit>(this, null);
        int i1 = a;
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
        aB();
        return b1;
    }

    public aB u()
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

    public c v()
    {
        return (c)B().b(B());
    }

    public List w()
    {
        return B().h();
    }

    private ion()
    {
        b = Collections.emptyList();
        y();
    }

    private y(y y1)
    {
        super(y1);
        b = Collections.emptyList();
        y();
    }

    y(y y1, y y2)
    {
        this(y1);
    }
}
