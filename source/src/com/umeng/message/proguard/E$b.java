// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

// Referenced classes of package com.umeng.message.proguard:
//            E, w, g

private static class <init>
    implements Iterator
{

    private final Stack a;
    private w b;

    private w a(g g)
    {
        for (; g instanceof E; g = E.a(g))
        {
            g = (E)g;
            a.push(g);
        }

        return (w)g;
    }

    private w b()
    {
        w w1;
        do
        {
            if (a.isEmpty())
            {
                return null;
            }
            w1 = a(E.b((E)a.pop()));
        } while (w1.d());
        return w1;
    }

    public w a()
    {
        if (b == null)
        {
            throw new NoSuchElementException();
        } else
        {
            w w1 = b;
            b = b();
            return w1;
        }
    }

    public boolean hasNext()
    {
        return b != null;
    }

    public Object next()
    {
        return a();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    private xception(g g)
    {
        a = new Stack();
        b = a(g);
    }

    a(g g, a a1)
    {
        this(g);
    }
}
