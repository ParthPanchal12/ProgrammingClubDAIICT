// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message.proguard:
//            M

private class <init>
    implements Iterator
{

    final M a;
    private int b;
    private boolean c;
    private Iterator d;

    private Iterator b()
    {
        if (d == null)
        {
            d = M.c(a).entrySet().iterator();
        }
        return d;
    }

    public java.util.Entry a()
    {
        c = true;
        int i = b + 1;
        b = i;
        if (i < M.b(a).size())
        {
            return (java.util.Entry)M.b(a).get(b);
        } else
        {
            return (java.util.Entry)b().next();
        }
    }

    public boolean hasNext()
    {
        return b + 1 < M.b(a).size() || b().hasNext();
    }

    public Object next()
    {
        return a();
    }

    public void remove()
    {
        if (!c)
        {
            throw new IllegalStateException("remove() was called before next()");
        }
        c = false;
        M.a(a);
        if (b < M.b(a).size())
        {
            M m = a;
            int i = b;
            b = i - 1;
            M.a(m, i);
            return;
        } else
        {
            b().remove();
            return;
        }
    }

    private (M m)
    {
        a = m;
        super();
        b = -1;
    }

    b(M m, b b1)
    {
        this(m);
    }
}
