// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Arrays;
import java.util.Stack;

// Referenced classes of package com.umeng.message.proguard:
//            E, g

private static class <init>
{

    private final Stack a;

    private int a(int i)
    {
        int j = Arrays.binarySearch(E.b(), i);
        i = j;
        if (j < 0)
        {
            i = -(j + 1) - 1;
        }
        return i;
    }

    static g a(<init> <init>1, g g1, g g2)
    {
        return <init>1.a(g1, g2);
    }

    private g a(g g1, g g2)
    {
        a(g1);
        a(g2);
        for (g1 = (g)a.pop(); !a.isEmpty(); g1 = new E((g)a.pop(), g1, null)) { }
        return g1;
    }

    private void a(g g1)
    {
        if (g1.n())
        {
            b(g1);
            return;
        }
        if (g1 instanceof E)
        {
            g1 = (E)g1;
            a(E.a(g1));
            a(E.b(g1));
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Has a new type of ByteString been created? Found ").append(g1.getClass()).toString());
        }
    }

    private void b(g g1)
    {
        int i = a(g1.a());
        int k = E.b()[i + 1];
        if (a.isEmpty() || ((g)a.peek()).a() >= k)
        {
            a.push(g1);
            return;
        }
        i = E.b()[i];
        Object obj;
        for (obj = (g)a.pop(); !a.isEmpty() && ((g)a.peek()).a() < i; obj = new E((g)a.pop(), ((g) (obj)), null)) { }
        g1 = new E(((g) (obj)), g1, null);
        do
        {
            if (a.isEmpty())
            {
                break;
            }
            int j = a(g1.a());
            j = E.b()[j + 1];
            if (((g)a.peek()).a() >= j)
            {
                break;
            }
            g1 = new E((g)a.pop(), g1, null);
        } while (true);
        a.push(g1);
    }

    private ion()
    {
        a = new Stack();
    }

    a(a a1)
    {
        this();
    }
}
