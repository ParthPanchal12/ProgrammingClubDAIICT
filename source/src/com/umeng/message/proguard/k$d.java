// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            k, x

public static final class <init>
    implements <init>, <init>
{

    private final int a;
    private b b;
    private final String c;
    private final b d;
    private final b e;
    private b f[];

    private void a(<init> <init>1)
    {
        b = <init>1;
        for (int i = 0; i < f.length; i++)
        {
            a(f[i], <init>1.a(i));
        }

    }

    static void a(a a1, a a2)
    {
        a1.a(a2);
    }

    public int a()
    {
        return a;
    }

    public a a(int i)
    {
        return (a)b(a(d)).get(new a(this, i));
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

    public g b()
    {
        return b;
    }

    public b b(int i)
    {
        return a(i);
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
        return b.u();
    }

    public List h()
    {
        return Collections.unmodifiableList(Arrays.asList(f));
    }

    public x l()
    {
        return b();
    }

    private a(a a1, a a2, a a3, int i)
        throws a
    {
        a = i;
        b = a1;
        c = k.a(a2, a3, a1.o());
        d = a2;
        e = a3;
        if (a1.s() == 0)
        {
            throw new <init>(this, "Enums must contain at least one value.", null);
        }
        f = new f[a1.s()];
        for (i = 0; i < a1.s(); i++)
        {
            f[i] = new <init>(a1.a(i), a2, this, i, null);
        }

        a(a2).c(this);
    }

    c(c c1, c c2, c c3, int i, c c4)
        throws c
    {
        this(c1, c2, c3, i);
    }
}
