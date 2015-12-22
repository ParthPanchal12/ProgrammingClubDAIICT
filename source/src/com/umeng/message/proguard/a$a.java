// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message.proguard:
//            a, A, n, x, 
//            B, t, o, h, 
//            S, m, O, P, 
//            s, g

public static abstract class ption extends ption
    implements ption
{

    private static String a(String s1, ption ption, int k)
    {
        s1 = new StringBuilder(s1);
        if (ption.t())
        {
            s1.append('(').append(ption.d()).append(')');
        } else
        {
            s1.append(ption.c());
        }
        if (k != -1)
        {
            s1.append('[').append(k).append(']');
        }
        s1.append('.');
        return s1.toString();
    }

    static List a(A a1)
    {
        return b(a1);
    }

    private static void a(A a1, String s1, List list)
    {
        Iterator iterator = a1.J().h().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (h)iterator.next();
            if (b1.k() && !a1.a_(b1))
            {
                list.add((new StringBuilder()).append(s1).append(b1.c()).toString());
            }
        } while (true);
        iterator = a1.a_().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Entry)iterator.next();
            b b2 = ()((java.util.Entry) (obj)).getKey();
            obj = ((java.util.Entry) (obj)).getValue();
            if (b2.g() == a.i)
            {
                if (b2.n())
                {
                    int k = 0;
                    obj = ((List)obj).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        a((A)((Iterator) (obj)).next(), a(s1, b2, k), list);
                        k++;
                    }
                } else
                if (a1.a_(b2))
                {
                    a((A)obj, a(s1, b2, -1), list);
                }
            }
        } while (true);
    }

    private static void a(g g1, a a1, n n1, a a2, o o1)
        throws IOException
    {
        a a3 = a1.a;
        boolean flag = a(a2, o1, a3);
        if (flag || n.e())
        {
            if (flag)
            {
                a1 = b(a2, o1, a3).M();
                a1.d(g1, n1);
                g1 = a1.aj();
            } else
            {
                g1 = (x)a1.b.m().c(g1, n1);
            }
            b(a2, o1, a3, g1);
            return;
        }
        g1 = new t(a1.b, n1, g1);
        if (a2 != null)
        {
            if (a2 instanceof b)
            {
                a2.d(a3, g1);
                return;
            } else
            {
                a2.d(a3, g1.a());
                return;
            }
        } else
        {
            o1.a(a3, g1);
            return;
        }
    }

    private static void a(h h1, d d1, n n1, d d2, d d3, o o1)
        throws IOException
    {
        g g1;
        d d4;
        int k;
        k = 0;
        d4 = null;
        g1 = null;
_L7:
        int l = h1.a();
        if (l != 0) goto _L2; else goto _L1
_L1:
        h1.a(S.m);
        if (g1 == null || k == 0) goto _L4; else goto _L3
_L3:
        if (d4 == null) goto _L6; else goto _L5
_L5:
        a(g1, d4, n1, d3, o1);
_L4:
        return;
_L2:
        if (l == S.n)
        {
            l = h1.m();
            k = l;
            if (l == 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = l;
            if (!(n1 instanceof m))
            {
                break; /* Loop/switch isn't completed */
            }
            d4 = ((m)n1).a(d2, l);
            k = l;
            break; /* Loop/switch isn't completed */
        }
        if (l != S.o)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k != 0 && d4 != null && n.e())
        {
            a(h1, d4, n1, d3, o1);
            g1 = null;
        } else
        {
            g1 = h1.l();
        }
        break; /* Loop/switch isn't completed */
        if (h1.b(l)) goto _L7; else goto _L1
_L6:
        if (g1 == null) goto _L4; else goto _L8
_L8:
        d1.a(k, a().a(g1).a());
        return;
        if (true) goto _L7; else goto _L9
_L9:
    }

    private static void a(h h1, a.a a1, n n1, a.a a2, o o1)
        throws IOException
    {
        a.a a3 = a1.a;
        if (a(a2, o1, a3))
        {
            a1 = b(a2, o1, a3).M();
            h1.a(a1, n1);
            h1 = a1.aj();
        } else
        {
            h1 = (x)h1.a(a1.b.m(), n1);
        }
        if (a2 != null)
        {
            a2.d(a3, h1);
            return;
        } else
        {
            o1.a(a3, h1);
            return;
        }
    }

    private static void a(d d1, o o1, d d2, d d3)
    {
        d1 = b(d1, o1, d2);
        if (d1 != null)
        {
            d3.c(d1);
        }
    }

    private static void a(c c1, o o1, c c2, Object obj)
    {
        if (c1 != null)
        {
            c1.c(c2, obj);
            return;
        } else
        {
            o1.b(c2, obj);
            return;
        }
    }

    static boolean a(h h1, c c1, n n1, c c2, c c3, o o1, int k)
        throws IOException
    {
        Object obj;
        Object obj1;
        int l;
        boolean flag;
        int j1;
        obj = null;
        obj1 = null;
        flag = false;
        if (c2.g().o() && k == S.l)
        {
            a(h1, c1, n1, c2, c3, o1);
            return true;
        }
        l = S.a(k);
        j1 = S.b(k);
        if (!c2.a(j1))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        if (!(n1 instanceof m)) goto _L2; else goto _L1
_L1:
        c2 = ((m)n1).a(c2, j1);
        if (c2 != null) goto _L4; else goto _L3
_L3:
        c2 = null;
        obj = obj1;
_L6:
        c c4 = c2;
        c2 = ((a) (obj));
        obj = c4;
_L8:
        c c5;
        x x1;
        if (c2 == null)
        {
            l = 0;
            flag = true;
        } else
        if (l == o.a(c2.j(), false))
        {
            l = 0;
        } else
        if (c2.p() && l == o.a(c2.j(), true))
        {
            l = 1;
        } else
        {
            l = 0;
            flag = true;
        }
        if (flag)
        {
            return c1.a(k, h1);
        }
        break MISSING_BLOCK_LABEL_277;
_L4:
        c5 = ((a) (c2)).a;
        x1 = ((a) (c2)).b;
        c2 = x1;
        obj = c5;
        if (x1 != null) goto _L6; else goto _L5
_L5:
        c2 = x1;
        obj = c5;
        if (c5.g() != a.i) goto _L6; else goto _L7
_L7:
        throw new IllegalStateException((new StringBuilder()).append("Message-typed extension lacked default instance: ").append(c5.d()).toString());
_L2:
        c2 = null;
          goto _L8
        if (c3 != null)
        {
            c2 = c2.b(j1);
        } else
        {
            c2 = null;
        }
          goto _L8
        if (l == 0) goto _L10; else goto _L9
_L9:
        k = h1.f(h1.s());
        if (c2.j() == n)
        {
            for (; h1.x() > 0; a(c3, o1, ((a) (c2)), c1))
            {
                int i1 = h1.n();
                c1 = c2.x().a(i1);
                if (c1 == null)
                {
                    return true;
                }
            }

        } else
        {
            for (; h1.x() > 0; a(c3, o1, ((a) (c2)), o.a(h1, c2.j()))) { }
        }
        h1.g(k);
_L15:
        return true;
_L10:
        a[c2.i().ordinal()];
        JVM INSTR tableswitch 1 3: default 416
    //                   1 444
    //                   2 505
    //                   3 562;
           goto _L11 _L12 _L13 _L14
_L11:
        h1 = ((h) (o.a(h1, c2.j())));
_L16:
        if (c2.n())
        {
            a(c3, o1, ((a) (c2)), h1);
        } else
        {
            b(c3, o1, c2, h1);
        }
        if (true) goto _L15; else goto _L12
_L12:
        if (obj != null)
        {
            c1 = ((x) (obj)).N();
        } else
        {
            c1 = c3.g(c2);
        }
        if (!c2.n())
        {
            a(c3, o1, ((a) (c2)), ((a) (c1)));
        }
        h1.a(c2.f(), c1, n1);
        h1 = c1.aj();
          goto _L16
_L13:
        if (obj != null)
        {
            c1 = ((x) (obj)).N();
        } else
        {
            c1 = c3.g(c2);
        }
        if (!c2.n())
        {
            a(c3, o1, ((a) (c2)), ((a) (c1)));
        }
        h1.a(c1, n1);
        h1 = c1.aj();
          goto _L16
_L14:
        k = h1.n();
        n1 = c2.x().a(k);
        h1 = n1;
        if (n1 == null)
        {
            c1.a(j1, k);
            return true;
        }
          goto _L16
    }

    private static boolean a(a a1, o o1, a a2)
    {
        if (a1 != null)
        {
            return a1.a_(a2);
        } else
        {
            return o1.a(a2);
        }
    }

    protected static O b(x x1)
    {
        return new O(b(((A) (x1))));
    }

    private static x b(b b1, o o1, b b2)
    {
        if (b1 != null)
        {
            return (x)b1.b(b2);
        } else
        {
            return (x)o1.b(b2);
        }
    }

    private static List b(A a1)
    {
        ArrayList arraylist = new ArrayList();
        a(a1, "", arraylist);
        return arraylist;
    }

    private static void b(a a1, o o1, a a2, Object obj)
    {
        if (a1 != null)
        {
            a1.d(a2, obj);
            return;
        } else
        {
            o1.a(a2, obj);
            return;
        }
    }

    public d a(P p)
    {
        e(P.a(b_()).a(p).b());
        return this;
    }

    public b a(g g1)
        throws s
    {
        return (b)super.b(g1);
    }

    public b a(g g1, n n1)
        throws s
    {
        return (b)super.b(g1, n1);
    }

    public b a(h h1)
        throws IOException
    {
        return a(h1, ((n) (m.b())));
    }

    public a a(h h1, n n1)
        throws IOException
    {
        a a1 = P.a(b_());
        do
        {
            int k = h1.a();
            while (k == 0 || !a(h1, a1, n1, J(), ((J) (this)), null, k)) 
            {
                e(a1.b());
                return this;
            }
        } while (true);
    }

    public b a(x x1)
    {
        if (x1.J() != J())
        {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        for (Iterator iterator = x1.a_().entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Entry)iterator.next();
            b b1 = ()((java.util.Entry) (obj)).getKey();
            if (b1.n())
            {
                obj = ((List)((java.util.Entry) (obj)).getValue()).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    c(b1, ((Iterator) (obj)).next());
                }
            } else
            if (b1.g() == a.i)
            {
                x x2 = (x)b(b1);
                if (x2 == x2.R())
                {
                    d(b1, ((java.util.Entry) (obj)).getValue());
                } else
                {
                    d(b1, x2.N().c(x2).c((x)((java.util.Entry) (obj)).getValue()).ak());
                }
            } else
            {
                d(b1, ((java.util.Entry) (obj)).getValue());
            }
        }

        a(x1.b_());
        return this;
    }

    public  a(InputStream inputstream)
        throws IOException
    {
        return ()super.c(inputstream);
    }

    public c a(InputStream inputstream, n n1)
        throws IOException
    {
        return (c)super.c(inputstream, n1);
    }

    public c a(byte abyte0[])
        throws s
    {
        return (c)super.b(abyte0);
    }

    public b a(byte abyte0[], int k, int l)
        throws s
    {
        return (b)super.b(abyte0, k, l);
    }

    public b a(byte abyte0[], int k, int l, n n1)
        throws s
    {
        return (b)super.b(abyte0, k, l, n1);
    }

    public b a(byte abyte0[], n n1)
        throws s
    {
        return (b)super.b(abyte0, n1);
    }

    public b a(b b1)
    {
        throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }

    public xception b(g g1)
        throws s
    {
        return a(g1);
    }

    public a b(g g1, n n1)
        throws s
    {
        return a(g1, n1);
    }

    public a b(h h1)
        throws IOException
    {
        return a(h1);
    }

    public a b(h h1, n n1)
        throws IOException
    {
        return a(h1, n1);
    }

    public a b(byte abyte0[])
        throws s
    {
        return a(abyte0);
    }

    public a b(byte abyte0[], int k, int l)
        throws s
    {
        return a(abyte0, k, l);
    }

    public a b(byte abyte0[], int k, int l, n n1)
        throws s
    {
        return a(abyte0, k, l, n1);
    }

    public a b(byte abyte0[], n n1)
        throws s
    {
        return a(abyte0, n1);
    }

    public a b(P p)
    {
        return a(p);
    }

    public List b()
    {
        return b(((A) (this)));
    }

    public boolean b(InputStream inputstream)
        throws IOException
    {
        return super.b(inputstream);
    }

    public boolean b(InputStream inputstream, n n1)
        throws IOException
    {
        return super.b(inputstream, n1);
    }

    public b c(InputStream inputstream)
        throws IOException
    {
        return a(inputstream);
    }

    public a c(InputStream inputstream, n n1)
        throws IOException
    {
        return a(inputstream, n1);
    }

    public a c(x x1)
    {
        return a(x1);
    }

    public a c(g g1)
        throws s
    {
        return a(g1);
    }

    public a c(g g1, n n1)
        throws s
    {
        return a(g1, n1);
    }

    public a c(h h1)
        throws IOException
    {
        return a(h1);
    }

    public a c(h h1, n n1)
        throws IOException
    {
        return a(h1, n1);
    }

    public a c(byte abyte0[])
        throws s
    {
        return a(abyte0);
    }

    public a c(byte abyte0[], int k, int l)
        throws s
    {
        return a(abyte0, k, l);
    }

    public a c(byte abyte0[], int k, int l, n n1)
        throws s
    {
        return a(abyte0, k, l, n1);
    }

    public a c(byte abyte0[], n n1)
        throws s
    {
        return a(abyte0, n1);
    }

    public String c()
    {
        return com.umeng.message.proguard.a.b(b());
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return d();
    }

    public abstract d d();

    public d d(g g1)
        throws s
    {
        return a(g1);
    }

    public a d(g g1, n n1)
        throws s
    {
        return a(g1, n1);
    }

    public a d(h h1)
        throws IOException
    {
        return a(h1);
    }

    public a d(h h1, n n1)
        throws IOException
    {
        return a(h1, n1);
    }

    public a d(byte abyte0[])
        throws s
    {
        return a(abyte0);
    }

    public a d(byte abyte0[], int k, int l)
        throws s
    {
        return a(abyte0, k, l);
    }

    public a d(byte abyte0[], int k, int l, n n1)
        throws s
    {
        return a(abyte0, k, l, n1);
    }

    public a d(byte abyte0[], n n1)
        throws s
    {
        return a(abyte0, n1);
    }

    public a d(InputStream inputstream)
        throws IOException
    {
        return a(inputstream);
    }

    public a d(InputStream inputstream, n n1)
        throws IOException
    {
        return a(inputstream, n1);
    }

    public a e()
    {
        for (Iterator iterator = a_().entrySet().iterator(); iterator.hasNext(); f((f)((java.util.Entry)iterator.next()).getKey())) { }
        return this;
    }

    public f e(InputStream inputstream)
        throws IOException
    {
        return a(inputstream);
    }

    public a e(InputStream inputstream, n n1)
        throws IOException
    {
        return a(inputstream, n1);
    }

    public a f()
    {
        return d();
    }

    public d g()
    {
        return d();
    }

    public d h()
    {
        return e();
    }

    public e i()
    {
        return d();
    }

    public d j()
    {
        return e();
    }

    public ption()
    {
    }
}
