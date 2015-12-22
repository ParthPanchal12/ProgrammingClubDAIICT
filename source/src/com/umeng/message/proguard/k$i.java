// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


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
    private b f;
    private b g;

    private void a(<init> <init>1)
    {
        b = <init>1;
    }

    static void a(b b1)
        throws b
    {
        b1.j();
    }

    static void a(j j1, j j2)
    {
        j1.a(j2);
    }

    private void j()
        throws c
    {
        c c1 = a(d).a(b.r(), this, c.a);
        if (!(c1 instanceof c.a))
        {
            throw new <init>(this, (new StringBuilder()).append('"').append(b.r()).append("\" is not a message type.").toString(), null);
        }
        f = (f)c1;
        c1 = a(d).a(b.u(), this, c.a);
        if (!(c1 instanceof c.a))
        {
            throw new <init>(this, (new StringBuilder()).append('"').append(b.u()).append("\" is not a message type.").toString(), null);
        } else
        {
            g = (g)c1;
            return;
        }
    }

    public int a()
    {
        return a;
    }

    public a b()
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
        return e;
    }

    public e g()
    {
        return f;
    }

    public f h()
    {
        return g;
    }

    public g i()
    {
        return b.x();
    }

    public x l()
    {
        return b();
    }

    private c(c c1, c c2, c c3, int i1)
        throws c
    {
        a = i1;
        b = c1;
        d = c2;
        e = c3;
        c = (new StringBuilder()).append(c3.d()).append('.').append(c1.o()).toString();
        a(c2).c(this);
    }

    c(c c1, c c2, c c3, int i1, c c4)
        throws c
    {
        this(c1, c2, c3, i1);
    }
}
