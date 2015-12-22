// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, s, B, 
//            y, x, h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private int b;
    private int c;

    public static final <init> k()
    {
        return com.umeng.message.proguard.j.h();
    }

    static <init> x()
    {
        return z();
    }

    private void y()
    {
        if (!p.m);
    }

    private static z z()
    {
        return new <init>();
    }

    public <init> J()
    {
        return com.umeng.message.proguard.j.h();
    }

    public y Q()
    {
        return s();
    }

    public x R()
    {
        return s();
    }

    public s a(h h1, n n1)
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
        d(af.());
        return this;
    }

    public final boolean a()
    {
        return true;
    }

    public  ah()
    {
        return m();
    }

    public m ai()
    {
        return r();
    }

    public x aj()
    {
        return u();
    }

    public x ak()
    {
        return t();
    }

    public y al()
    {
        return u();
    }

    public y am()
    {
        return t();
    }

    public t b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1)
    {
        a = a | 2;
        c = i1;
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
        return r();
    }

    public r d()
    {
        return r();
    }

    public r d(x x1)
    {
        if (x1 instanceof r)
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

    public m e(h h1, n n1)
        throws IOException
    {
        h1 = (m)m.d(h1, n1);
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
        return r();
    }

    public r g()
    {
        return r();
    }

    public r h()
    {
        return m();
    }

    public m i()
    {
        return r();
    }

    public r j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.i().m(com/umeng/message/proguard/j$a$b, com/umeng/message/proguard/j$a$b$a);
    }

    public m m()
    {
        super.m();
        b = 0;
        a = a & -2;
        c = 0;
        a = a & -3;
        return this;
    }

    public boolean n()
    {
        return (a & 1) == 1;
    }

    public int o()
    {
        return b;
    }

    public boolean p()
    {
        return (a & 2) == 2;
    }

    public int q()
    {
        return c;
    }

    public c r()
    {
        return z().a(u());
    }

    public u s()
    {
        return u();
    }

    public u t()
    {
        u u1 = u();
        if (!u1.u())
        {
            throw b(u1);
        } else
        {
            return u1;
        }
    }

    public b u()
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

    public aB v()
    {
        a = a & -2;
        b = 0;
        aF();
        return this;
    }

    public aF w()
    {
        a = a & -3;
        c = 0;
        aF();
        return this;
    }

    private n()
    {
        y();
    }

    private y(y y1)
    {
        super(y1);
        y();
    }

    y(y y1, y y2)
    {
        this(y1);
    }
}
