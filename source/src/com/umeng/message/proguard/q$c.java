// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            q, o, h, n, 
//            y, i

public static abstract class a extends q
    implements a
{
    protected class a
    {

        final q.c a;
        private final Iterator b;
        private java.util.Map.Entry c;
        private final boolean d;

        public void a(int i1, i j1)
            throws IOException
        {
            while (c != null && ((q.e)c.getKey()).f() < i1) 
            {
                q.e e = (q.e)c.getKey();
                if (d && e.h() == S.b.i && !e.n())
                {
                    j1.d(e.f(), (y)c.getValue());
                } else
                {
                    o.a(e, c.getValue(), j1);
                }
                if (b.hasNext())
                {
                    c = (java.util.Map.Entry)b.next();
                } else
                {
                    c = null;
                }
            }
        }

        private a(boolean flag)
        {
            a = q.c.this;
            super();
            b = q.c.a(a).h();
            if (b.hasNext())
            {
                c = (java.util.Map.Entry)b.next();
            }
            d = flag;
        }

        a(boolean flag, q._cls1 _pcls1)
        {
            this(flag);
        }
    }


    private final o a;

    static o a(a.c c1)
    {
        return c1.a;
    }

    private void d(a a1)
    {
        if (a1.a() != Q())
        {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        } else
        {
            return;
        }
    }

    public final Object a(ion ion, int i1)
    {
        d(ion);
        return a.a(a(ion), i1);
    }

    protected boolean a(h h1, n n, int i1)
        throws IOException
    {
        return q.a(a, Q(), h1, n, i1);
    }

    public final boolean a(Q q1)
    {
        d(q1);
        return a.a(a(q1));
    }

    public final int b(a a1)
    {
        d(a1);
        return a.d(a(a1));
    }

    protected void b()
    {
        a.c();
    }

    public final Object c(a a1)
    {
        d(a1);
        Object obj1 = a.b(a(a1));
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = b(a1);
        }
        return obj;
    }

    protected boolean h()
    {
        return a.i();
    }

    protected a i()
    {
        return new a(false, null);
    }

    protected a j()
    {
        return new a(true, null);
    }

    protected int k()
    {
        return a.j();
    }

    protected int l()
    {
        return a.k();
    }

    protected a()
    {
        a = o.a();
    }

    protected a(a a1)
    {
        a = a(a1);
    }
}
