// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            k, x

public static final class <init>
    implements <init>
{

    private final int a;
    private b b;
    private final String c;
    private final b d;
    private b e[];

    private void a(<init> <init>1)
    {
        b = <init>1;
        for (int i = 0; i < e.length; i++)
        {
            a(e[i], <init>1.a(i));
        }

    }

    static void a(a a1)
        throws a
    {
        a1.h();
    }

    static void a(h h1, h h2)
    {
        h1.a(h2);
    }

    private void h()
        throws a
    {
        a aa[] = e;
        int i1 = aa.length;
        for (int i = 0; i < i1; i++)
        {
            a(aa[i]);
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

    public g b()
    {
        return b;
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
        return b.u();
    }

    public List g()
    {
        return Collections.unmodifiableList(Arrays.asList(e));
    }

    public x l()
    {
        return b();
    }

    private ( ,  1, int i)
        throws 
    {
        a = i;
        b = ;
        c = k.a(1, null, .o());
        d = 1;
        e = new e[.s()];
        for (i = 0; i < .s(); i++)
        {
            e[i] = new <init>(.a(i), 1, this, i, null);
        }

        a(1).c(this);
    }

    c(c c1, c c2, int i, c c3)
        throws c
    {
        this(c1, c2, i);
    }
}
