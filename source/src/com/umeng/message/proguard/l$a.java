// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            l, o, P, s, 
//            O, y, x

public static final class <init> extends <init>
{

    private final a a;
    private o b;
    private P c;

    static l a(<init> <init>1)
        throws s
    {
        return <init>1.p();
    }

    private void h(p p1)
    {
        if (p1.u() != a)
        {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        } else
        {
            return;
        }
    }

    private l p()
        throws s
    {
        if (!a())
        {
            throw b(new l(a, b, c, null)).b();
        } else
        {
            return m();
        }
    }

    private void q()
    {
        if (b.d())
        {
            b = b.e();
        }
    }

    public b J()
    {
        return a;
    }

    public y Q()
    {
        return o();
    }

    public x R()
    {
        return o();
    }

    public o a(P p1)
    {
        return d(p1);
    }

    public d a(x x)
    {
        return d(x);
    }

    public d a(d d1, int i1, Object obj)
    {
        h(d1);
        q();
        b.a(d1, i1, obj);
        return this;
    }

    public b a(b b1, Object obj)
    {
        h(b1);
        q();
        b.a(b1, obj);
        return this;
    }

    public b a(b b1)
    {
        throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }

    public Object a(xception xception, int i1)
    {
        h(xception);
        return b.a(xception, i1);
    }

    public boolean a()
    {
        return com.umeng.message.proguard.l.a(a, b);
    }

    public Map a_()
    {
        return b.g();
    }

    public boolean a_(b b1)
    {
        h(b1);
        return b.a(b1);
    }

    public x aj()
    {
        return m();
    }

    public x ak()
    {
        return l();
    }

    public y al()
    {
        return m();
    }

    public y am()
    {
        return l();
    }

    public l b(l l1, Object obj)
    {
        h(l1);
        q();
        b.b(l1, obj);
        return this;
    }

    public b b(P p1)
    {
        return d(p1);
    }

    public d b(d d1, int i1, Object obj)
    {
        return a(d1, i1, obj);
    }

    public Object b(a a1)
    {
label0:
        {
            h(a1);
            Object obj1 = b.b(a1);
            Object obj = obj1;
            if (obj1 == null)
            {
                if (a1.g() != a.i)
                {
                    break label0;
                }
                obj = com.umeng.message.proguard.l.a(a1.w());
            }
            return obj;
        }
        return a1.r();
    }

    public P b_()
    {
        return c;
    }

    public int c(c c1)
    {
        h(c1);
        return b.d(c1);
    }

    public b c(P p1)
    {
        c = p1;
        return this;
    }

    public c c(c c1, Object obj)
    {
        return b(c1, obj);
    }

    public b c(x x)
    {
        return d(x);
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

    public n d(P p1)
    {
        c = P.a(c).a(p1).b();
        return this;
    }

    public b d(b b1)
    {
        h(b1);
        if (b1.g() != a.i)
        {
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        } else
        {
            return new <init>(b1.w());
        }
    }

    public w d(x x)
    {
        if (x instanceof l)
        {
            x = (l)x;
            if (com.umeng.message.proguard.l.a(x) != a)
            {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            } else
            {
                q();
                b.a(com.umeng.message.proguard.l.b(x));
                d(com.umeng.message.proguard.l.c(x));
                return this;
            }
        } else
        {
            return (d)super.a(x);
        }
    }

    public a d(a a1, Object obj)
    {
        return a(a1, obj);
    }

    public a e()
    {
        return k();
    }

    public k e(k k1)
    {
        h(k1);
        q();
        b.c(k1);
        return this;
    }

    public b e(P p1)
    {
        return c(p1);
    }

    public c f()
    {
        return n();
    }

    public n f(n n1)
    {
        return e(n1);
    }

    public e g(e e1)
    {
        return d(e1);
    }

    public d g()
    {
        return n();
    }

    public n h()
    {
        return k();
    }

    public k i()
    {
        return n();
    }

    public n j()
    {
        return k();
    }

    public k k()
    {
        if (b.d())
        {
            b = com.umeng.message.proguard.o.a();
        } else
        {
            b.f();
        }
        c = P.c();
        return this;
    }

    public l l()
    {
        if (!a())
        {
            throw b(new l(a, b, c, null));
        } else
        {
            return m();
        }
    }

    public l m()
    {
        b.c();
        return new l(a, b, c, null);
    }

    public c n()
    {
        c c1 = new <init>(a);
        c1.b.a(b);
        c1.d(c);
        return c1;
    }

    public l o()
    {
        return com.umeng.message.proguard.l.a(a);
    }

    private ption(ption ption)
    {
        a = ption;
        b = com.umeng.message.proguard.o.a();
        c = P.c();
    }

    c(c c1, c c2)
    {
        this(c1);
    }
}
