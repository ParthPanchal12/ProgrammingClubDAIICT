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
//            b, x, i, o, 
//            P, N, O, A, 
//            n, B, t, h, 
//            S, m, s, g

public abstract class com.umeng.message.proguard.a extends b
    implements x
{
    public static abstract class a extends b.a
        implements x.a
    {

        private static String a(String s1, k.f f1, int k)
        {
            s1 = new StringBuilder(s1);
            if (f1.t())
            {
                s1.append('(').append(f1.d()).append(')');
            } else
            {
                s1.append(f1.c());
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
                k.f f1 = (k.f)iterator.next();
                if (f1.k() && !a1.a_(f1))
                {
                    list.add((new StringBuilder()).append(s1).append(f1.c()).toString());
                }
            } while (true);
            iterator = a1.a_().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                k.f f2 = (k.f)((java.util.Map.Entry) (obj)).getKey();
                obj = ((java.util.Map.Entry) (obj)).getValue();
                if (f2.g() == k.f.a.i)
                {
                    if (f2.n())
                    {
                        int k = 0;
                        obj = ((List)obj).iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            a((A)((Iterator) (obj)).next(), a(s1, f2, k), list);
                            k++;
                        }
                    } else
                    if (a1.a_(f2))
                    {
                        a((A)obj, a(s1, f2, -1), list);
                    }
                }
            } while (true);
        }

        private static void a(g g1, m.b b1, n n1, x.a a1, o o1)
            throws IOException
        {
            k.f f1 = b1.a;
            boolean flag = a(a1, o1, f1);
            if (flag || n.e())
            {
                if (flag)
                {
                    b1 = b(a1, o1, f1).M();
                    b1.d(g1, n1);
                    g1 = b1.aj();
                } else
                {
                    g1 = (x)b1.b.m().c(g1, n1);
                }
                b(a1, o1, f1, g1);
                return;
            }
            g1 = new t(b1.b, n1, g1);
            if (a1 != null)
            {
                if (a1 instanceof p.c)
                {
                    a1.d(f1, g1);
                    return;
                } else
                {
                    a1.d(f1, g1.a());
                    return;
                }
            } else
            {
                o1.a(f1, g1);
                return;
            }
        }

        private static void a(h h1, P.a a1, n n1, k.a a2, x.a a3, o o1)
            throws IOException
        {
            g g1;
            m.b b1;
            int k;
            k = 0;
            b1 = null;
            g1 = null;
_L7:
            int l = h1.a();
            if (l != 0) goto _L2; else goto _L1
_L1:
            h1.a(S.m);
            if (g1 == null || k == 0) goto _L4; else goto _L3
_L3:
            if (b1 == null) goto _L6; else goto _L5
_L5:
            a(g1, b1, n1, a3, o1);
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
                b1 = ((m)n1).a(a2, l);
                k = l;
                break; /* Loop/switch isn't completed */
            }
            if (l != S.o)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k != 0 && b1 != null && n.e())
            {
                a(h1, b1, n1, a3, o1);
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
            a1.a(k, P.b.a().a(g1).a());
            return;
            if (true) goto _L7; else goto _L9
_L9:
        }

        private static void a(h h1, m.b b1, n n1, x.a a1, o o1)
            throws IOException
        {
            k.f f1 = b1.a;
            if (a(a1, o1, f1))
            {
                b1 = b(a1, o1, f1).M();
                h1.a(b1, n1);
                h1 = b1.aj();
            } else
            {
                h1 = (x)h1.a(b1.b.m(), n1);
            }
            if (a1 != null)
            {
                a1.d(f1, h1);
                return;
            } else
            {
                o1.a(f1, h1);
                return;
            }
        }

        private static void a(x.a a1, o o1, k.f f1, x.a a2)
        {
            a1 = b(a1, o1, f1);
            if (a1 != null)
            {
                a2.c(a1);
            }
        }

        private static void a(x.a a1, o o1, k.f f1, Object obj)
        {
            if (a1 != null)
            {
                a1.c(f1, obj);
                return;
            } else
            {
                o1.b(f1, obj);
                return;
            }
        }

        static boolean a(h h1, P.a a1, n n1, k.a a2, x.a a3, o o1, int k)
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
            if (a2.g().o() && k == S.l)
            {
                a(h1, a1, n1, a2, a3, o1);
                return true;
            }
            l = S.a(k);
            j1 = S.b(k);
            if (!a2.a(j1))
            {
                break MISSING_BLOCK_LABEL_203;
            }
            if (!(n1 instanceof m)) goto _L2; else goto _L1
_L1:
            a2 = ((m)n1).a(a2, j1);
            if (a2 != null) goto _L4; else goto _L3
_L3:
            a2 = null;
            obj = obj1;
_L6:
            k.a a4 = a2;
            a2 = ((k.a) (obj));
            obj = a4;
_L8:
            k.f f1;
            x x1;
            if (a2 == null)
            {
                l = 0;
                flag = true;
            } else
            if (l == o.a(a2.j(), false))
            {
                l = 0;
            } else
            if (a2.p() && l == o.a(a2.j(), true))
            {
                l = 1;
            } else
            {
                l = 0;
                flag = true;
            }
            if (flag)
            {
                return a1.a(k, h1);
            }
            break MISSING_BLOCK_LABEL_277;
_L4:
            f1 = ((m.b) (a2)).a;
            x1 = ((m.b) (a2)).b;
            a2 = x1;
            obj = f1;
            if (x1 != null) goto _L6; else goto _L5
_L5:
            a2 = x1;
            obj = f1;
            if (f1.g() != k.f.a.i) goto _L6; else goto _L7
_L7:
            throw new IllegalStateException((new StringBuilder()).append("Message-typed extension lacked default instance: ").append(f1.d()).toString());
_L2:
            a2 = null;
              goto _L8
            if (a3 != null)
            {
                a2 = a2.b(j1);
            } else
            {
                a2 = null;
            }
              goto _L8
            if (l == 0) goto _L10; else goto _L9
_L9:
            k = h1.f(h1.s());
            if (a2.j() == S.a.n)
            {
                for (; h1.x() > 0; a(a3, o1, ((k.f) (a2)), a1))
                {
                    int i1 = h1.n();
                    a1 = a2.x().a(i1);
                    if (a1 == null)
                    {
                        return true;
                    }
                }

            } else
            {
                for (; h1.x() > 0; a(a3, o1, ((k.f) (a2)), o.a(h1, a2.j()))) { }
            }
            h1.g(k);
_L15:
            return true;
_L10:
            static class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[k.f.b.values().length];
                    try
                    {
                        a[k.f.b.j.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[k.f.b.k.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[k.f.b.n.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1.a[a2.i().ordinal()];
            JVM INSTR tableswitch 1 3: default 416
        //                       1 444
        //                       2 505
        //                       3 562;
               goto _L11 _L12 _L13 _L14
_L11:
            h1 = ((h) (o.a(h1, a2.j())));
_L16:
            if (a2.n())
            {
                a(a3, o1, ((k.f) (a2)), h1);
            } else
            {
                b(a3, o1, a2, h1);
            }
            if (true) goto _L15; else goto _L12
_L12:
            if (obj != null)
            {
                a1 = ((x) (obj)).N();
            } else
            {
                a1 = a3.g(a2);
            }
            if (!a2.n())
            {
                a(a3, o1, ((k.f) (a2)), ((x.a) (a1)));
            }
            h1.a(a2.f(), a1, n1);
            h1 = a1.aj();
              goto _L16
_L13:
            if (obj != null)
            {
                a1 = ((x) (obj)).N();
            } else
            {
                a1 = a3.g(a2);
            }
            if (!a2.n())
            {
                a(a3, o1, ((k.f) (a2)), ((x.a) (a1)));
            }
            h1.a(a1, n1);
            h1 = a1.aj();
              goto _L16
_L14:
            k = h1.n();
            n1 = a2.x().a(k);
            h1 = n1;
            if (n1 == null)
            {
                a1.a(j1, k);
                return true;
            }
              goto _L16
        }

        private static boolean a(x.a a1, o o1, k.f f1)
        {
            if (a1 != null)
            {
                return a1.a_(f1);
            } else
            {
                return o1.a(f1);
            }
        }

        protected static O b(x x1)
        {
            return new O(b(((A) (x1))));
        }

        private static x b(x.a a1, o o1, k.f f1)
        {
            if (a1 != null)
            {
                return (x)a1.b(f1);
            } else
            {
                return (x)o1.b(f1);
            }
        }

        private static List b(A a1)
        {
            ArrayList arraylist = new ArrayList();
            a(a1, "", arraylist);
            return arraylist;
        }

        private static void b(x.a a1, o o1, k.f f1, Object obj)
        {
            if (a1 != null)
            {
                a1.d(f1, obj);
                return;
            } else
            {
                o1.a(f1, obj);
                return;
            }
        }

        public a a(P p)
        {
            e(P.a(b_()).a(p).b());
            return this;
        }

        public a a(g g1)
            throws s
        {
            return (a)super.b(g1);
        }

        public a a(g g1, n n1)
            throws s
        {
            return (a)super.b(g1, n1);
        }

        public a a(h h1)
            throws IOException
        {
            return a(h1, ((n) (m.b())));
        }

        public a a(h h1, n n1)
            throws IOException
        {
            P.a a1 = P.a(b_());
            do
            {
                int k = h1.a();
                while (k == 0 || !a(h1, a1, n1, J(), ((x.a) (this)), null, k)) 
                {
                    e(a1.b());
                    return this;
                }
            } while (true);
        }

        public a a(x x1)
        {
            if (x1.J() != J())
            {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Iterator iterator = x1.a_().entrySet().iterator(); iterator.hasNext();)
            {
                Object obj = (java.util.Map.Entry)iterator.next();
                k.f f1 = (k.f)((java.util.Map.Entry) (obj)).getKey();
                if (f1.n())
                {
                    obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        c(f1, ((Iterator) (obj)).next());
                    }
                } else
                if (f1.g() == k.f.a.i)
                {
                    x x2 = (x)b(f1);
                    if (x2 == x2.R())
                    {
                        d(f1, ((java.util.Map.Entry) (obj)).getValue());
                    } else
                    {
                        d(f1, x2.N().c(x2).c((x)((java.util.Map.Entry) (obj)).getValue()).ak());
                    }
                } else
                {
                    d(f1, ((java.util.Map.Entry) (obj)).getValue());
                }
            }

            a(x1.b_());
            return this;
        }

        public a a(InputStream inputstream)
            throws IOException
        {
            return (a)super.c(inputstream);
        }

        public a a(InputStream inputstream, n n1)
            throws IOException
        {
            return (a)super.c(inputstream, n1);
        }

        public a a(byte abyte0[])
            throws s
        {
            return (a)super.b(abyte0);
        }

        public a a(byte abyte0[], int k, int l)
            throws s
        {
            return (a)super.b(abyte0, k, l);
        }

        public a a(byte abyte0[], int k, int l, n n1)
            throws s
        {
            return (a)super.b(abyte0, k, l, n1);
        }

        public a a(byte abyte0[], n n1)
            throws s
        {
            return (a)super.b(abyte0, n1);
        }

        public x.a a(k.f f1)
        {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        public b.a b(g g1)
            throws s
        {
            return a(g1);
        }

        public b.a b(g g1, n n1)
            throws s
        {
            return a(g1, n1);
        }

        public b.a b(h h1)
            throws IOException
        {
            return a(h1);
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return a(h1, n1);
        }

        public b.a b(byte abyte0[])
            throws s
        {
            return a(abyte0);
        }

        public b.a b(byte abyte0[], int k, int l)
            throws s
        {
            return a(abyte0, k, l);
        }

        public b.a b(byte abyte0[], int k, int l, n n1)
            throws s
        {
            return a(abyte0, k, l, n1);
        }

        public b.a b(byte abyte0[], n n1)
            throws s
        {
            return a(abyte0, n1);
        }

        public x.a b(P p)
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

        public b.a c(InputStream inputstream)
            throws IOException
        {
            return a(inputstream);
        }

        public b.a c(InputStream inputstream, n n1)
            throws IOException
        {
            return a(inputstream, n1);
        }

        public x.a c(x x1)
        {
            return a(x1);
        }

        public y.a c(g g1)
            throws s
        {
            return a(g1);
        }

        public y.a c(g g1, n n1)
            throws s
        {
            return a(g1, n1);
        }

        public y.a c(h h1)
            throws IOException
        {
            return a(h1);
        }

        public y.a c(h h1, n n1)
            throws IOException
        {
            return a(h1, n1);
        }

        public y.a c(byte abyte0[])
            throws s
        {
            return a(abyte0);
        }

        public y.a c(byte abyte0[], int k, int l)
            throws s
        {
            return a(abyte0, k, l);
        }

        public y.a c(byte abyte0[], int k, int l, n n1)
            throws s
        {
            return a(abyte0, k, l, n1);
        }

        public y.a c(byte abyte0[], n n1)
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

        public abstract a d();

        public x.a d(g g1)
            throws s
        {
            return a(g1);
        }

        public x.a d(g g1, n n1)
            throws s
        {
            return a(g1, n1);
        }

        public x.a d(h h1)
            throws IOException
        {
            return a(h1);
        }

        public x.a d(h h1, n n1)
            throws IOException
        {
            return a(h1, n1);
        }

        public x.a d(byte abyte0[])
            throws s
        {
            return a(abyte0);
        }

        public x.a d(byte abyte0[], int k, int l)
            throws s
        {
            return a(abyte0, k, l);
        }

        public x.a d(byte abyte0[], int k, int l, n n1)
            throws s
        {
            return a(abyte0, k, l, n1);
        }

        public x.a d(byte abyte0[], n n1)
            throws s
        {
            return a(abyte0, n1);
        }

        public y.a d(InputStream inputstream)
            throws IOException
        {
            return a(inputstream);
        }

        public y.a d(InputStream inputstream, n n1)
            throws IOException
        {
            return a(inputstream, n1);
        }

        public a e()
        {
            for (Iterator iterator = a_().entrySet().iterator(); iterator.hasNext(); f((k.f)((java.util.Map.Entry)iterator.next()).getKey())) { }
            return this;
        }

        public x.a e(InputStream inputstream)
            throws IOException
        {
            return a(inputstream);
        }

        public x.a e(InputStream inputstream, n n1)
            throws IOException
        {
            return a(inputstream, n1);
        }

        public b.a f()
        {
            return d();
        }

        public y.a g()
        {
            return d();
        }

        public y.a h()
        {
            return e();
        }

        public x.a i()
        {
            return d();
        }

        public x.a j()
        {
            return e();
        }

        public a()
        {
        }
    }


    private int a;

    public com.umeng.message.proguard.a()
    {
        a = -1;
    }

    protected static int a(long l)
    {
        return (int)(l >>> 32 ^ l);
    }

    protected static int a(r.a a1)
    {
        return a1.a();
    }

    protected static int a(List list)
    {
        list = list.iterator();
        int j;
        for (j = 1; list.hasNext(); j = a((r.a)list.next()) + j * 31) { }
        return j;
    }

    protected static int a(boolean flag)
    {
        return !flag ? 1237 : 1231;
    }

    static String b(List list)
    {
        return c(list);
    }

    private static String c(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(s))
        {
            s = (String)list.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.toString();
    }

    protected int a(int j, Map map)
    {
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            Object obj = (java.util.Map.Entry)map.next();
            k.f f = (k.f)((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            j = j * 37 + f.f();
            if (f.i() != k.f.b.n)
            {
                j = j * 53 + obj.hashCode();
            } else
            if (f.n())
            {
                j = j * 53 + a((List)obj);
            } else
            {
                j = j * 53 + a((r.a)obj);
            }
        }

        return j;
    }

    public void a(i j)
        throws IOException
    {
        boolean flag = J().g().o();
        for (Iterator iterator = a_().entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            k.f f = (k.f)((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if (flag && f.t() && f.i() == k.f.b.k && !f.n())
            {
                j.d(f.f(), (x)obj);
            } else
            {
                o.a(f, obj, j);
            }
        }

        P p = b_();
        if (flag)
        {
            p.b(j);
            return;
        } else
        {
            p.a(j);
            return;
        }
    }

    public boolean a()
    {
        Iterator iterator1;
        for (Iterator iterator = J().h().iterator(); iterator.hasNext();)
        {
            k.f f = (k.f)iterator.next();
            if (f.k() && !a_(f))
            {
                return false;
            }
        }

        iterator1 = a_().entrySet().iterator();
_L2:
        Object obj;
        k.f f1;
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_172;
            }
            obj = (java.util.Map.Entry)iterator1.next();
            f1 = (k.f)((java.util.Map.Entry) (obj)).getKey();
        } while (f1.g() != k.f.a.i);
        if (!f1.n())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        if (((x)((Iterator) (obj)).next()).a()) goto _L4; else goto _L3
_L3:
        return false;
        if (((x)((java.util.Map.Entry) (obj)).getValue()).a()) goto _L2; else goto _L5
_L5:
        return false;
        return true;
    }

    public List b()
    {
        return a.a(this);
    }

    public String c()
    {
        return c(b());
    }

    public int d()
    {
        int j = a;
        if (j != -1)
        {
            return j;
        }
        boolean flag = J().g().o();
        Object obj = a_().entrySet().iterator();
        j = 0;
        while (((Iterator) (obj)).hasNext()) 
        {
            Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            k.f f = (k.f)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            if (flag && f.t() && f.i() == k.f.b.k && !f.n())
            {
                j = i.h(f.f(), (x)obj1) + j;
            } else
            {
                j = o.c(f, obj1) + j;
            }
        }
        obj = b_();
        if (flag)
        {
            j = ((P) (obj)).i() + j;
        } else
        {
            j = ((P) (obj)).d() + j;
        }
        a = j;
        return j;
    }

    O e()
    {
        return a.b(this);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof x))
            {
                return false;
            }
            obj = (x)obj;
            if (J() != ((x) (obj)).J())
            {
                return false;
            }
            if (!a_().equals(((x) (obj)).a_()) || !b_().equals(((x) (obj)).b_()))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return a(J().hashCode() + 779, a_()) * 29 + b_().hashCode();
    }

    public final String toString()
    {
        return N.b(this);
    }
}
