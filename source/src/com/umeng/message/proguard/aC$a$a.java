// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            aC, g, s, B, 
//            y, x, h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private Object b;
    private Object c;
    private int d;
    private int e;
    private Object f;
    private Object g;
    private f h;
    private g i;

    static <init> W()
    {
        return Y();
    }

    private void X()
    {
        if (!Y());
    }

    private static Y Y()
    {
        return new <init>();
    }

    public static final <init> k()
    {
        return aC.b();
    }

    public g A()
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

    public boolean B()
    {
        return (a & 0x20) == 32;
    }

    public String C()
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

    public g D()
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

    public boolean E()
    {
        return (a & 0x40) == 64;
    }

    public a F()
    {
        return h;
    }

    public boolean G()
    {
        return (a & 0x80) == 128;
    }

    public g H()
    {
        return i;
    }

    public i I()
    {
        return i();
    }

    public i J()
    {
        return aC.b();
    }

    public i K()
    {
        i i1 = L();
        if (!i1.L())
        {
            throw b(i1);
        } else
        {
            return i1;
        }
    }

    public b L()
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
        i1 = j1;
        if ((k1 & 0x80) == 128)
        {
            i1 = j1 | 0x80;
        }
        h(b1, i);
        i(b1, i1);
        aB();
        return b1;
    }

    public aB M()
    {
        a = a & -2;
        b = b().b();
        aF();
        return this;
    }

    public aF N()
    {
        a = a & -3;
        c = c().c();
        aF();
        return this;
    }

    public aF O()
    {
        a = a & -5;
        d = 0;
        aF();
        return this;
    }

    public aF P()
    {
        a = a & -9;
        e = 0;
        aF();
        return this;
    }

    public y Q()
    {
        return I();
    }

    public x R()
    {
        return I();
    }

    public I S()
    {
        a = a & 0xffffffef;
        f = f().f();
        aF();
        return this;
    }

    public aF T()
    {
        a = a & 0xffffffdf;
        g = g().g();
        aF();
        return this;
    }

    public aF U()
    {
        a = a & 0xffffffbf;
        h = a;
        aF();
        return this;
    }

    public aF V()
    {
        a = a & 0xffffff7f;
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

    public d a(int i1)
    {
        a = a | 4;
        d = i1;
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
            a = a | 0x40;
            h = af;
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
            a = a | 2;
            c = c(af);
            aF();
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
            a(af.a());
        }
        if (af.a())
        {
            i(af.i());
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
            a = a | 1;
            b = s1;
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
        return L();
    }

    public x ak()
    {
        return K();
    }

    public y al()
    {
        return L();
    }

    public y am()
    {
        return K();
    }

    public K b(int i1)
    {
        a = a | 8;
        e = i1;
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
            a = a | 2;
            c = s1;
            aF();
            return this;
        }
    }

    public aF b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e c(String s1)
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

    public a d(String s1)
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

    public a f(g g1)
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

    public aF f()
    {
        return n();
    }

    public n g(g g1)
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

    public aF g()
    {
        return n();
    }

    public n h(g g1)
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

    public aF h()
    {
        return m();
    }

    public m i(g g1)
    {
        if (g1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = a | 0x80;
            i = g1;
            aF();
            return this;
        }
    }

    public aF i()
    {
        return n();
    }

    public n j()
    {
        return m();
    }

    protected m l()
    {
        return aC.c().m(com/umeng/message/proguard/aC$a, com/umeng/message/proguard/aC$a$a);
    }

    public m m()
    {
        super.m();
        b = "";
        a = a & -2;
        c = "";
        a = a & -3;
        d = 0;
        a = a & -5;
        e = 0;
        a = a & -9;
        f = "";
        a = a & 0xffffffef;
        g = "";
        a = a & 0xffffffdf;
        h = a;
        a = a & 0xffffffbf;
        i = g.d;
        a = a & 0xffffff7f;
        return this;
    }

    public a n()
    {
        return Y().a(L());
    }

    public boolean o()
    {
        return (a & 1) == 1;
    }

    public String p()
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

    public g q()
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

    public boolean r()
    {
        return (a & 2) == 2;
    }

    public String s()
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

    public g t()
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

    public boolean u()
    {
        return (a & 4) == 4;
    }

    public int v()
    {
        return d;
    }

    public boolean w()
    {
        return (a & 8) == 8;
    }

    public int x()
    {
        return e;
    }

    public boolean y()
    {
        return (a & 0x10) == 16;
    }

    public String z()
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

    private on()
    {
        b = "";
        c = "";
        f = "";
        g = "";
        h = a;
        i = g.d;
        X();
    }

    private X(X x1)
    {
        super(x1);
        b = "";
        c = "";
        f = "";
        g = "";
        h = a;
        i = g.d;
        X();
    }

    X(X x1, X x2)
    {
        this(x1);
    }
}
