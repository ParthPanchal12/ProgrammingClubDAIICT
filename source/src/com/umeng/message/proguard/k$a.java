// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            k, x

public static final class <init>
    implements <init>
{

    private final int a;
    private b b;
    private final String c;
    private final b d;
    private final b e;
    private final b f[];
    private final b g[];
    private final b h[];
    private final b i[];

    private void a(<init> <init>1)
    {
        boolean flag = false;
        b = <init>1;
        for (int i1 = 0; i1 < f.length; i1++)
        {
            f[i1].a(<init>1.e(i1));
        }

        for (int j1 = 0; j1 < g.length; j1++)
        {
            a(g[j1], <init>1.g(j1));
        }

        int k1 = 0;
        int l1;
        do
        {
            l1 = ((flag) ? 1 : 0);
            if (k1 >= h.length)
            {
                break;
            }
            a(h[k1], <init>1.a(k1));
            k1++;
        } while (true);
        for (; l1 < i.length; l1++)
        {
            a(i[l1], <init>1.c(l1));
        }

    }

    static void a(c c1)
        throws c
    {
        c1.m();
    }

    static void a(m m1, m m2)
    {
        m1.a(m2);
    }

    private void m()
        throws a
    {
        boolean flag = false;
        Object aobj[] = f;
        int l1 = aobj.length;
        for (int i1 = 0; i1 < l1; i1++)
        {
            aobj[i1].m();
        }

        aobj = h;
        l1 = aobj.length;
        for (int j1 = 0; j1 < l1; j1++)
        {
            b(aobj[j1]);
        }

        aobj = i;
        l1 = aobj.length;
        for (int k1 = ((flag) ? 1 : 0); k1 < l1; k1++)
        {
            b(aobj[k1]);
        }

    }

    public int a()
    {
        return a;
    }

    public a a(String s)
    {
        s = a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
        if (s != null && (s instanceof g))
        {
            return (g)s;
        } else
        {
            return null;
        }
    }

    public boolean a(int i1)
    {
        for (Iterator iterator = b.C().iterator(); iterator.hasNext();)
        {
            b b1 = (b)iterator.next();
            if (b1.o() <= i1 && i1 < b1.q())
            {
                return true;
            }
        }

        return false;
    }

    public b.q b()
    {
        return b;
    }

    public b b(String s)
    {
        s = a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
        if (s != null && (s instanceof g))
        {
            return (g)s;
        } else
        {
            return null;
        }
    }

    public g b(int i1)
    {
        return (g)a(a(d)).get(new a(this, i1));
    }

    public a c(String s)
    {
        s = a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
        if (s != null && (s instanceof g))
        {
            return (g)s;
        } else
        {
            return null;
        }
    }

    public String c()
    {
        return b.o();
    }

    public String d()
    {
        return c;
    }

    public c e()
    {
        return d;
    }

    public d f()
    {
        return e;
    }

    public e g()
    {
        return b.G();
    }

    public List h()
    {
        return Collections.unmodifiableList(Arrays.asList(h));
    }

    public List i()
    {
        return Collections.unmodifiableList(Arrays.asList(i));
    }

    public List j()
    {
        return Collections.unmodifiableList(Arrays.asList(f));
    }

    public List k()
    {
        return Collections.unmodifiableList(Arrays.asList(g));
    }

    public x l()
    {
        return b();
    }

    private a(a a1, a a2, a a3, int i1)
        throws a
    {
        a = i1;
        b = a1;
        c = com.umeng.message.proguard.k.a(a2, a3, a1.o());
        d = a2;
        e = a3;
        f = new f[a1.y()];
        for (i1 = 0; i1 < a1.y(); i1++)
        {
            f[i1] = new <init>(a1.e(i1), a2, this, i1);
        }

        g = new g[a1.B()];
        for (i1 = 0; i1 < a1.B(); i1++)
        {
            g[i1] = new <init>(a1.g(i1), a2, this, i1, null);
        }

        h = new h[a1.s()];
        for (i1 = 0; i1 < a1.s(); i1++)
        {
            h[i1] = new <init>(a1.a(i1), a2, this, i1, false, null);
        }

        i = new i[a1.v()];
        for (i1 = 0; i1 < a1.v(); i1++)
        {
            i[i1] = new <init>(a1.c(i1), a2, this, i1, true, null);
        }

        a(a2).c(this);
    }

    c(c c1, c c2, c c3, int i1, c c4)
        throws c
    {
        this(c1, c2, c3, i1);
    }
}
