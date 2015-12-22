// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            p, A

public class L
    implements p.b
{

    private p.b a;
    private p.a b;
    private p c;
    private boolean d;

    public L(p p1, p.b b1, boolean flag)
    {
        if (p1 == null)
        {
            throw new NullPointerException();
        } else
        {
            c = p1;
            a = b1;
            d = flag;
            return;
        }
    }

    private void h()
    {
        if (b != null)
        {
            c = null;
        }
        if (d && a != null)
        {
            a.a();
            d = false;
        }
    }

    public L a(p p1)
    {
        if (p1 == null)
        {
            throw new NullPointerException();
        }
        c = p1;
        if (b != null)
        {
            b.aA();
            b = null;
        }
        h();
        return this;
    }

    public void a()
    {
        h();
    }

    public L b(p p1)
    {
        if (b == null && c == c.R())
        {
            c = p1;
        } else
        {
            e().a(p1);
        }
        h();
        return this;
    }

    public void b()
    {
        a = null;
    }

    public p c()
    {
        if (c == null)
        {
            c = (p)b.aj();
        }
        return c;
    }

    public p d()
    {
        d = true;
        return c();
    }

    public p.a e()
    {
        if (b == null)
        {
            b = (p.a)c.b(this);
            b.a(c);
            b.aC();
        }
        return b;
    }

    public A f()
    {
        if (b != null)
        {
            return b;
        } else
        {
            return c;
        }
    }

    public L g()
    {
        x x;
        if (c != null)
        {
            x = c.R();
        } else
        {
            x = b.R();
        }
        c = (p)(p)x;
        if (b != null)
        {
            b.aA();
            b = null;
        }
        h();
        return this;
    }
}
