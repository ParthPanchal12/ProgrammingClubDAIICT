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
//            B, y, x, h, 
//            n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private boolean b;
    private boolean c;
    private List d;
    private D e;

    static <init> F()
    {
        return H();
    }

    private void G()
    {
        if (p.m)
        {
            K();
        }
    }

    private static K H()
    {
        return new <init>();
    }

    private void I()
    {
        if ((a & 4) != 4)
        {
            d = new ArrayList(d);
            a = a | 4;
        }
    }

    private D K()
    {
        if (e == null)
        {
            List list = d;
            boolean flag;
            if ((a & 4) == 4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e = new D(list, flag, aE(), aD());
            d = null;
        }
        return e;
    }

    public static final e k()
    {
        return com.umeng.message.proguard.j.v();
    }

    public e A()
    {
        return u();
    }

    public u B()
    {
        return m();
    }

    public m C()
    {
        if (e == null)
        {
            d = Collections.emptyList();
            a = a & -5;
            aF();
            return this;
        } else
        {
            e.e();
            return this;
        }
    }

    public e D()
    {
        return (e)K().b(K());
    }

    public List E()
    {
        return K().h();
    }

    public K J()
    {
        return com.umeng.message.proguard.j.v();
    }

    public y Q()
    {
        return v();
    }

    public x R()
    {
        return v();
    }

    public v a(h h1, n n1)
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
        if (e == null)
        {
            return (e)d.get(i1);
        } else
        {
            return (d)e.a(i1);
        }
    }

    public e a(int i1, e e1)
    {
        if (e == null)
        {
            I();
            d.set(i1, e1.G());
            aF();
            return this;
        } else
        {
            e.a(i1, e1.G());
            return this;
        }
    }

    public G a(int i1, G g1)
    {
        if (e == null)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                I();
                d.set(i1, g1);
                aF();
                return this;
            }
        } else
        {
            e.a(i1, g1);
            return this;
        }
    }

    public e a(e e1)
    {
        if (e == null)
        {
            I();
            d.add(e1.G());
            aF();
            return this;
        } else
        {
            e.a(e1.G());
            return this;
        }
    }

    public G a(G g1)
    {
        if (e == null)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                I();
                d.add(g1);
                aF();
                return this;
            }
        } else
        {
            e.a(g1);
            return this;
        }
    }

    public e a(e e1)
    {
        D d1;
        d1 = null;
        if (e1 == e())
        {
            return this;
        }
        if (e1.e())
        {
            a(e1.a());
        }
        if (e1.a())
        {
            b(e1.b());
        }
        if (e != null) goto _L2; else goto _L1
_L1:
        if (!e(e1).isEmpty())
        {
            if (d.isEmpty())
            {
                d = d(e1);
                a = a & -5;
            } else
            {
                I();
                d.addAll(d(e1));
            }
            aF();
        }
_L4:
        a(((a) (e1)));
        d(e1.());
        return this;
_L2:
        if (!(e1).isEmpty())
        {
            if (e.d())
            {
                e.b();
                e = null;
                d = d(e1);
                a = a & -5;
                if (p.m)
                {
                    d1 = K();
                }
                e = d1;
            } else
            {
                e.a(e(e1));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public e a(Iterable iterable)
    {
        if (e == null)
        {
            I();
            I(iterable, d);
            aF();
            return this;
        } else
        {
            e.a(iterable);
            return this;
        }
    }

    public e a(boolean flag)
    {
        a = a | 1;
        b = flag;
        aF();
        return this;
    }

    public final boolean a()
    {
        int i1 = 0;
_L7:
        if (i1 >= t()) goto _L2; else goto _L1
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
        return u();
    }

    public x aj()
    {
        return x();
    }

    public x ak()
    {
        return w();
    }

    public y al()
    {
        return x();
    }

    public y am()
    {
        return w();
    }

    public w b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1)
    {
        if (e == null)
        {
            return (e)d.get(i1);
        } else
        {
            return (d)e.c(i1);
        }
    }

    public e b(int i1, e e1)
    {
        if (e == null)
        {
            I();
            d.add(i1, e1.G());
            aF();
            return this;
        } else
        {
            e.b(i1, e1.G());
            return this;
        }
    }

    public G b(int i1, G g1)
    {
        if (e == null)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                I();
                d.add(i1, g1);
                aF();
                return this;
            }
        } else
        {
            e.b(i1, g1);
            return this;
        }
    }

    public e b(boolean flag)
    {
        a = a | 2;
        c = flag;
        aF();
        return this;
    }

    public aF c(int i1)
    {
        if (e == null)
        {
            I();
            d.remove(i1);
            aF();
            return this;
        } else
        {
            e.d(i1);
            return this;
        }
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
        return u();
    }

    public u d()
    {
        return u();
    }

    public u d(int i1)
    {
        return (u)K().b(i1);
    }

    public K d(x x1)
    {
        if (x1 instanceof K)
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
        return (m)K().c(i1, K());
    }

    public K e(h h1, n n1)
        throws IOException
    {
        h1 = (K)K.d(h1, n1);
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
        return u();
    }

    public u g()
    {
        return u();
    }

    public u h()
    {
        return m();
    }

    public m i()
    {
        return u();
    }

    public u j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.w().m(com/umeng/message/proguard/j$u, com/umeng/message/proguard/j$u$a);
    }

    public m m()
    {
        super.m();
        b = false;
        a = a & -2;
        c = false;
        a = a & -3;
        if (e == null)
        {
            d = Collections.emptyList();
            a = a & -5;
            return this;
        } else
        {
            e.e();
            return this;
        }
    }

    public boolean n()
    {
        return (a & 1) == 1;
    }

    public boolean o()
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

    public List r()
    {
        if (e == null)
        {
            return Collections.unmodifiableList(d);
        } else
        {
            return e.g();
        }
    }

    public List s()
    {
        if (e != null)
        {
            return e.i();
        } else
        {
            return Collections.unmodifiableList(d);
        }
    }

    public int t()
    {
        if (e == null)
        {
            return d.size();
        } else
        {
            return e.c();
        }
    }

    public e u()
    {
        return H().a(x());
    }

    public x v()
    {
        return x();
    }

    public x w()
    {
        x x1 = x();
        if (!x1.x())
        {
            throw b(x1);
        } else
        {
            return x1;
        }
    }

    public b x()
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
        if (e == null)
        {
            if ((a & 4) == 4)
            {
                d = Collections.unmodifiableList(d);
                a = a & -5;
            }
            a(b1, d);
        } else
        {
            d(b1, e.f());
        }
        e(b1, j1);
        aB();
        return b1;
    }

    public aB y()
    {
        a = a & -2;
        b = false;
        aF();
        return this;
    }

    public aF z()
    {
        a = a & -3;
        c = false;
        aF();
        return this;
    }

    private ion()
    {
        d = Collections.emptyList();
        G();
    }

    private G(G g1)
    {
        super(g1);
        d = Collections.emptyList();
        G();
    }

    G(G g1, G g2)
    {
        this(g1);
    }
}
