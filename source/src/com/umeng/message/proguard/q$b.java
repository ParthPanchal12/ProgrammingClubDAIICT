// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            q, o, h, n

public static abstract class a extends a
    implements a
{

    private o a;
    private boolean b;

    static o a(a a1)
    {
        return a1.l();
    }

    private void e(l l1)
    {
        if (l1.a() != d())
        {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        } else
        {
            return;
        }
    }

    private void k()
    {
        if (!b)
        {
            a = a.e();
            b = true;
        }
    }

    private o l()
    {
        a.c();
        b = false;
        return a;
    }

    public final a a(a a1, int i1, Object obj)
    {
        e(a1);
        k();
        a.a(a(a1), i1, obj);
        return this;
    }

    public final a a(a a1, Object obj)
    {
        e(a1);
        k();
        a.a(a(a1), obj);
        return this;
    }

    public final Object a(a a1, int i1)
    {
        e(a1);
        return a.a(a(a1), i1);
    }

    protected final void a(a a1)
    {
        k();
        a.a(a(a1));
    }

    protected boolean a(h h1, n n, int i1)
        throws IOException
    {
        k();
        return q.a(a, d(), h1, n, i1);
    }

    public final boolean a(d d1)
    {
        e(d1);
        return a.a(a(d1));
    }

    public final int b(a a1)
    {
        e(a1);
        return a.d(a(a1));
    }

    public a b()
    {
        return e();
    }

    public final e b(e e1, Object obj)
    {
        e(e1);
        k();
        a.b(a(e1), obj);
        return this;
    }

    public a c()
    {
        return i();
    }

    public final Object c(i i1)
    {
        e(i1);
        Object obj1 = a.b(a(i1));
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = b(i1);
        }
        return obj;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return i();
    }

    public final i d(i i1)
    {
        e(i1);
        k();
        a.c(a(i1));
        return this;
    }

    public a e()
    {
        a.f();
        b = false;
        return (b)super.b();
    }

    public b f()
    {
        return i();
    }

    public i g()
    {
        return i();
    }

    public i h()
    {
        return e();
    }

    public e i()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean j()
    {
        return a.i();
    }

    protected ption()
    {
        a = o.b();
    }
}
