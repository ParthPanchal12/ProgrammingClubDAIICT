// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message.proguard:
//            N, A, P, g, 
//            x

private static final class <init>
{

    boolean a;
    boolean b;

    static <init> a(<init> <init>1, boolean flag)
    {
        return <init>1.a(flag);
    }

    private a a(boolean flag)
    {
        a = flag;
        return this;
    }

    private void a(int i, int j, List list, a a1)
        throws IOException
    {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = ((List) (iterator.next()));
            a1.a(String.valueOf(i));
            a1.a(": ");
            N.a(j, list, a1);
            if (a)
            {
                list = " ";
            } else
            {
                list = "\n";
            }
            a1.a(list);
        }
    }

    private void a(A a1, a a2)
        throws IOException
    {
        java.util.Entry entry;
        for (Iterator iterator = a1.a_().entrySet().iterator(); iterator.hasNext(); a((a)entry.getKey(), entry.getValue(), a2))
        {
            entry = (java.util.Entry)iterator.next();
        }

        a(a1.b_(), a2);
    }

    static void a( , A a1,  1)
        throws IOException
    {
        .a(a1, 1);
    }

    static void a(a a1, P p, a a2)
        throws IOException
    {
        a1.a(p, a2);
    }

    static void a(a a1, a a2, Object obj, a a3)
        throws IOException
    {
        a1.a(a2, obj, a3);
    }

    private void a(P p, a a1)
        throws IOException
    {
        for (p = p.h().entrySet().iterator(); p.hasNext();)
        {
            java.util.Entry entry = (java.util.Entry)p.next();
            int i = ((Integer)entry.getKey()).intValue();
            Object obj = (a)entry.getValue();
            a(i, 0, ((a) (obj)).c(), a1);
            a(i, 5, ((a) (obj)).d(), a1);
            a(i, 1, ((a) (obj)).e(), a1);
            a(i, 2, ((a) (obj)).f(), a1);
            obj = ((f) (obj)).g().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                P p1 = (P)((Iterator) (obj)).next();
                a1.a(((Integer)entry.getKey()).toString());
                if (a)
                {
                    a1.a(" { ");
                } else
                {
                    a1.a(" {\n");
                    a1.a();
                }
                a(p1, a1);
                if (a)
                {
                    a1.a("} ");
                } else
                {
                    a1.b();
                    a1.a("}\n");
                }
            }
        }

    }

    private void a(a a1, Object obj, a a2)
        throws IOException
    {
        if (a1.n())
        {
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); b(a1, ((Iterator) (obj)).next(), a2)) { }
        } else
        {
            b(a1, obj, a2);
        }
    }

    static b b(b b1, boolean flag)
    {
        return b1.b(flag);
    }

    private b b(boolean flag)
    {
        b = flag;
        return this;
    }

    static void b(b b1, b b2, Object obj, b b3)
        throws IOException
    {
        b1.c(b2, obj, b3);
    }

    private void b(c c1, Object obj, c c2)
        throws IOException
    {
        if (c1.t())
        {
            c2.a("[");
            if (c1.u().g().o() && c1.i() == b.k && c1.m() && c1.v() == c1.w())
            {
                c2.a(c1.w().d());
            } else
            {
                c2.a(c1.d());
            }
            c2.a("]");
        } else
        if (c1.i() == b.j)
        {
            c2.a(c1.w().c());
        } else
        {
            c2.a(c1.c());
        }
        if (c1.g() == a.i)
        {
            if (a)
            {
                c2.a(" { ");
            } else
            {
                c2.a(" {\n");
                c2.a();
            }
        } else
        {
            c2.a(": ");
        }
        c(c1, obj, c2);
        if (c1.g() == a.i)
        {
            if (a)
            {
                c2.a("} ");
                return;
            } else
            {
                c2.b();
                c2.a("}\n");
                return;
            }
        }
        if (a)
        {
            c2.a(" ");
            return;
        } else
        {
            c2.a("\n");
            return;
        }
    }

    private void c(a a1, Object obj, a a2)
        throws IOException
    {
        switch (a[a1.i().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            a2.a(((Integer)obj).toString());
            return;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            a2.a(((Long)obj).toString());
            return;

        case 7: // '\007'
            a2.a(((Boolean)obj).toString());
            return;

        case 8: // '\b'
            a2.a(((Float)obj).toString());
            return;

        case 9: // '\t'
            a2.a(((Double)obj).toString());
            return;

        case 10: // '\n'
        case 11: // '\013'
            a2.a(N.a(((Integer)obj).intValue()));
            return;

        case 12: // '\f'
        case 13: // '\r'
            a2.a(N.a(((Long)obj).longValue()));
            return;

        case 14: // '\016'
            a2.a("\"");
            if (b)
            {
                a1 = N.a((String)obj);
            } else
            {
                a1 = (String)obj;
            }
            a2.a(a1);
            a2.a("\"");
            return;

        case 15: // '\017'
            a2.a("\"");
            a2.a(N.a((g)obj));
            a2.a("\"");
            return;

        case 16: // '\020'
            a2.a(((a)obj).c());
            return;

        case 17: // '\021'
        case 18: // '\022'
            a((x)obj, a2);
            return;
        }
    }

    private a()
    {
        a = false;
        b = true;
    }

    b(b b1)
    {
        this();
    }
}
