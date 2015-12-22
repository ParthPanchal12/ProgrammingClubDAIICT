// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p

private static class j
    implements j
{

    protected final Class a;
    protected final Method b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;
    protected final Method h;
    protected final Method i;
    protected final Method j;

    public j a()
    {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    public Object a(eption eption)
    {
        return p.a(c, eption, new Object[0]);
    }

    public Object a(c c1, int k)
    {
        return p.a(e, c1, new Object[] {
            Integer.valueOf(k)
        });
    }

    public Object a(p p1)
    {
        return p.a(b, p1, new Object[0]);
    }

    public Object a(p p1, int k)
    {
        return p.a(d, p1, new Object[] {
            Integer.valueOf(k)
        });
    }

    public void a(d d1, int k, Object obj)
    {
        p.a(f, d1, new Object[] {
            Integer.valueOf(k), obj
        });
    }

    public void a(f f1, Object obj)
    {
        d(f1);
        for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); b(f1, ((Iterator) (obj)).next())) { }
    }

    public void b(b b1, Object obj)
    {
        p.a(g, b1, new Object[] {
            obj
        });
    }

    public boolean b(g g1)
    {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    public boolean b(p p1)
    {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    public int c(eption eption)
    {
        return ((Integer)p.a(i, eption, new Object[0])).intValue();
    }

    public int c(p p1)
    {
        return ((Integer)p.a(h, p1, new Object[0])).intValue();
    }

    public void d(h h1)
    {
        p.a(j, h1, new Object[0]);
    }

    public j e(j j1)
    {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    eption(eption eption, String s, Class class1, Class class2)
    {
        b = p.a(class1, (new StringBuilder()).append("get").append(s).append("List").toString(), new Class[0]);
        c = p.a(class2, (new StringBuilder()).append("get").append(s).append("List").toString(), new Class[0]);
        d = p.a(class1, (new StringBuilder()).append("get").append(s).toString(), new Class[] {
            Integer.TYPE
        });
        e = p.a(class2, (new StringBuilder()).append("get").append(s).toString(), new Class[] {
            Integer.TYPE
        });
        a = d.getReturnType();
        f = p.a(class2, (new StringBuilder()).append("set").append(s).toString(), new Class[] {
            Integer.TYPE, a
        });
        g = p.a(class2, (new StringBuilder()).append("add").append(s).toString(), new Class[] {
            a
        });
        h = p.a(class1, (new StringBuilder()).append("get").append(s).append("Count").toString(), new Class[0]);
        i = p.a(class2, (new StringBuilder()).append("get").append(s).append("Count").toString(), new Class[0]);
        j = p.a(class2, (new StringBuilder()).append("clear").append(s).toString(), new Class[0]);
    }
}
