// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;

// Referenced classes of package com.umeng.message.proguard:
//            p

private static class g
    implements g
{

    protected final Class a;
    protected final Method b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public g a()
    {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    public Object a(eption eption)
    {
        return p.a(c, eption, new Object[0]);
    }

    public Object a(c c1, int i)
    {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }

    public Object a(p p1)
    {
        return p.a(b, p1, new Object[0]);
    }

    public Object a(p p1, int i)
    {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }

    public void a(eption eption, int i, Object obj)
    {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
    }

    public void a(eption eption, Object obj)
    {
        p.a(d, eption, new Object[] {
            obj
        });
    }

    public void b(d d1, Object obj)
    {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }

    public boolean b(eption eption)
    {
        return ((Boolean)p.a(f, eption, new Object[0])).booleanValue();
    }

    public boolean b(p p1)
    {
        return ((Boolean)p.a(e, p1, new Object[0])).booleanValue();
    }

    public int c(e e1)
    {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }

    public int c(p p1)
    {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }

    public void d(eption eption)
    {
        p.a(g, eption, new Object[0]);
    }

    public g e(g g1)
    {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    eption(eption eption, String s, Class class1, Class class2)
    {
        b = p.a(class1, (new StringBuilder()).append("get").append(s).toString(), new Class[0]);
        c = p.a(class2, (new StringBuilder()).append("get").append(s).toString(), new Class[0]);
        a = b.getReturnType();
        d = p.a(class2, (new StringBuilder()).append("set").append(s).toString(), new Class[] {
            a
        });
        e = p.a(class1, (new StringBuilder()).append("has").append(s).toString(), new Class[0]);
        f = p.a(class2, (new StringBuilder()).append("has").append(s).toString(), new Class[0]);
        g = p.a(class2, (new StringBuilder()).append("clear").append(s).toString(), new Class[0]);
    }
}
