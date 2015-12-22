// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.umeng.message.proguard:
//            y, s, i, g, 
//            N, h, B, S, 
//            m, n, c

public final class P
    implements y
{
    public static final class a
        implements y.a
    {

        private Map a;
        private int b;
        private b.a c;

        private b.a b(int i1)
        {
            if (c != null)
            {
                if (i1 == b)
                {
                    return c;
                }
                b(b, c.a());
            }
            if (i1 == 0)
            {
                return null;
            }
            b b1 = (b)a.get(Integer.valueOf(i1));
            b = i1;
            c = b.a();
            if (b1 != null)
            {
                c.a(b1);
            }
            return c;
        }

        static a j()
        {
            return k();
        }

        private static a k()
        {
            a a1 = new a();
            a1.l();
            return a1;
        }

        private void l()
        {
            a = Collections.emptyMap();
            b = 0;
            c = null;
        }

        public y Q()
        {
            return e();
        }

        public a a(int i1, int j1)
        {
            if (i1 == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            } else
            {
                b(i1).a(j1);
                return this;
            }
        }

        public a a(int i1, b b1)
        {
            if (i1 == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (a(i1))
            {
                b(i1).a(b1);
                return this;
            } else
            {
                b(i1, b1);
                return this;
            }
        }

        public a a(P p)
        {
            if (p != P.c())
            {
                java.util.Map.Entry entry;
                for (p = P.b(p).entrySet().iterator(); p.hasNext(); a(((Integer)entry.getKey()).intValue(), (b)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)p.next();
                }

            }
            return this;
        }

        public a a(g g1)
            throws s
        {
            try
            {
                g1 = g1.k();
                a(((h) (g1)));
                g1.a(0);
            }
            // Misplaced declaration of an exception variable
            catch (g g1)
            {
                throw g1;
            }
            // Misplaced declaration of an exception variable
            catch (g g1)
            {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", g1);
            }
            return this;
        }

        public a a(g g1, n n)
            throws s
        {
            return a(g1);
        }

        public a a(h h1)
            throws IOException
        {
            int i1;
            do
            {
                i1 = h1.a();
            } while (i1 != 0 && a(i1, h1));
            return this;
        }

        public a a(h h1, n n)
            throws IOException
        {
            return a(h1);
        }

        public a a(InputStream inputstream)
            throws IOException
        {
            inputstream = com.umeng.message.proguard.h.a(inputstream);
            a(((h) (inputstream)));
            inputstream.a(0);
            return this;
        }

        public a a(InputStream inputstream, n n)
            throws IOException
        {
            return a(inputstream);
        }

        public a a(byte abyte0[])
            throws s
        {
            try
            {
                abyte0 = com.umeng.message.proguard.h.a(abyte0);
                a(((h) (abyte0)));
                abyte0.a(0);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw abyte0;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", abyte0);
            }
            return this;
        }

        public a a(byte abyte0[], int i1, int j1)
            throws s
        {
            try
            {
                abyte0 = com.umeng.message.proguard.h.a(abyte0, i1, j1);
                a(((h) (abyte0)));
                abyte0.a(0);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw abyte0;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", abyte0);
            }
            return this;
        }

        public a a(byte abyte0[], int i1, int j1, n n)
            throws s
        {
            return a(abyte0, i1, j1);
        }

        public a a(byte abyte0[], n n)
            throws s
        {
            return a(abyte0);
        }

        public boolean a()
        {
            return true;
        }

        public boolean a(int i1)
        {
            if (i1 == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            return i1 == b || a.containsKey(Integer.valueOf(i1));
        }

        public boolean a(int i1, h h1)
            throws IOException
        {
            int j1 = S.b(i1);
            switch (S.a(i1))
            {
            default:
                throw s.g();

            case 0: // '\0'
                b(j1).a(h1.f());
                return true;

            case 1: // '\001'
                b(j1).b(h1.h());
                return true;

            case 2: // '\002'
                b(j1).a(h1.l());
                return true;

            case 3: // '\003'
                a a1 = P.b();
                h1.a(j1, a1, com.umeng.message.proguard.m.b());
                b(j1).a(a1.b());
                return true;

            case 4: // '\004'
                return false;

            case 5: // '\005'
                b(j1).a(h1.i());
                break;
            }
            return true;
        }

        public y al()
        {
            return c();
        }

        public y am()
        {
            return b();
        }

        public a b(int i1, b b1)
        {
            if (i1 == 0)
            {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (c != null && b == i1)
            {
                c = null;
                b = 0;
            }
            if (a.isEmpty())
            {
                a = new TreeMap();
            }
            a.put(Integer.valueOf(i1), b1);
            return this;
        }

        public P b()
        {
            b(0);
            P p;
            if (a.isEmpty())
            {
                p = P.c();
            } else
            {
                p = new P(Collections.unmodifiableMap(a));
            }
            a = null;
            return p;
        }

        public boolean b(InputStream inputstream)
            throws IOException
        {
            int i1 = inputstream.read();
            if (i1 == -1)
            {
                return false;
            } else
            {
                a(new b.a.a(inputstream, com.umeng.message.proguard.h.a(i1, inputstream)));
                return true;
            }
        }

        public boolean b(InputStream inputstream, n n)
            throws IOException
        {
            return b(inputstream);
        }

        public P c()
        {
            return b();
        }

        public y.a c(g g1)
            throws s
        {
            return a(g1);
        }

        public y.a c(g g1, n n)
            throws s
        {
            return a(g1, n);
        }

        public y.a c(h h1)
            throws IOException
        {
            return a(h1);
        }

        public y.a c(h h1, n n)
            throws IOException
        {
            return a(h1, n);
        }

        public y.a c(byte abyte0[])
            throws s
        {
            return a(abyte0);
        }

        public y.a c(byte abyte0[], int i1, int j1)
            throws s
        {
            return a(abyte0, i1, j1);
        }

        public y.a c(byte abyte0[], int i1, int j1, n n)
            throws s
        {
            return a(abyte0, i1, j1, n);
        }

        public y.a c(byte abyte0[], n n)
            throws s
        {
            return a(abyte0, n);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return d();
        }

        public a d()
        {
            b(0);
            return P.b().a(new P(a));
        }

        public y.a d(InputStream inputstream)
            throws IOException
        {
            return a(inputstream);
        }

        public y.a d(InputStream inputstream, n n)
            throws IOException
        {
            return a(inputstream, n);
        }

        public P e()
        {
            return P.c();
        }

        public a f()
        {
            l();
            return this;
        }

        public y.a g()
        {
            return d();
        }

        public y.a h()
        {
            return f();
        }

        public Map i()
        {
            b(0);
            return Collections.unmodifiableMap(a);
        }

        private a()
        {
        }
    }

    public static final class b
    {

        private static final b a = a().a();
        private List b;
        private List c;
        private List d;
        private List e;
        private List f;

        public static a a()
        {
            return a.c();
        }

        public static a a(b b1)
        {
            return a().a(b1);
        }

        static List a(b b1, List list)
        {
            b1.b = list;
            return list;
        }

        public static b b()
        {
            return a;
        }

        static List b(b b1)
        {
            return b1.b;
        }

        static List b(b b1, List list)
        {
            b1.c = list;
            return list;
        }

        static List c(b b1)
        {
            return b1.c;
        }

        static List c(b b1, List list)
        {
            b1.d = list;
            return list;
        }

        static List d(b b1)
        {
            return b1.d;
        }

        static List d(b b1, List list)
        {
            b1.e = list;
            return list;
        }

        static List e(b b1)
        {
            return b1.e;
        }

        static List e(b b1, List list)
        {
            b1.f = list;
            return list;
        }

        static List f(b b1)
        {
            return b1.f;
        }

        private Object[] h()
        {
            return (new Object[] {
                b, c, d, e, f
            });
        }

        public int a(int i1)
        {
            Iterator iterator = b.iterator();
            int j1;
            for (j1 = 0; iterator.hasNext(); j1 = com.umeng.message.proguard.i.f(i1, ((Long)iterator.next()).longValue()) + j1) { }
            for (Iterator iterator1 = c.iterator(); iterator1.hasNext();)
            {
                j1 += com.umeng.message.proguard.i.h(i1, ((Integer)iterator1.next()).intValue());
            }

            for (Iterator iterator2 = d.iterator(); iterator2.hasNext();)
            {
                j1 += com.umeng.message.proguard.i.h(i1, ((Long)iterator2.next()).longValue());
            }

            for (Iterator iterator3 = e.iterator(); iterator3.hasNext();)
            {
                j1 += com.umeng.message.proguard.i.c(i1, (g)iterator3.next());
            }

            for (Iterator iterator4 = f.iterator(); iterator4.hasNext();)
            {
                j1 += com.umeng.message.proguard.i.e(i1, (P)iterator4.next());
            }

            return j1;
        }

        public void a(int i1, i j1)
            throws IOException
        {
            for (Iterator iterator = b.iterator(); iterator.hasNext(); j1.a(i1, ((Long)iterator.next()).longValue())) { }
            for (Iterator iterator1 = c.iterator(); iterator1.hasNext(); j1.b(i1, ((Integer)iterator1.next()).intValue())) { }
            for (Iterator iterator2 = d.iterator(); iterator2.hasNext(); j1.c(i1, ((Long)iterator2.next()).longValue())) { }
            for (Iterator iterator3 = e.iterator(); iterator3.hasNext(); j1.a(i1, (g)iterator3.next())) { }
            for (Iterator iterator4 = f.iterator(); iterator4.hasNext(); j1.a(i1, (P)iterator4.next())) { }
        }

        public int b(int i1)
        {
            Iterator iterator = e.iterator();
            int j1;
            for (j1 = 0; iterator.hasNext(); j1 = com.umeng.message.proguard.i.d(i1, (g)iterator.next()) + j1) { }
            return j1;
        }

        public void b(int i1, i j1)
            throws IOException
        {
            for (Iterator iterator = e.iterator(); iterator.hasNext(); j1.b(i1, (g)iterator.next())) { }
        }

        public List c()
        {
            return b;
        }

        public List d()
        {
            return c;
        }

        public List e()
        {
            return d;
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (!(obj instanceof b))
            {
                return false;
            } else
            {
                return Arrays.equals(h(), ((b)obj).h());
            }
        }

        public List f()
        {
            return e;
        }

        public List g()
        {
            return f;
        }

        public int hashCode()
        {
            return Arrays.hashCode(h());
        }


        private b()
        {
        }

    }

    public static final class b.a
    {

        private b a;

        static b.a c()
        {
            return d();
        }

        private static b.a d()
        {
            b.a a1 = new b.a();
            a1.a = new b();
            return a1;
        }

        public b.a a(int i1)
        {
            if (b.c(a) == null)
            {
                b.b(a, new ArrayList());
            }
            b.c(a).add(Integer.valueOf(i1));
            return this;
        }

        public b.a a(long l1)
        {
            if (b.b(a) == null)
            {
                b.a(a, new ArrayList());
            }
            b.b(a).add(Long.valueOf(l1));
            return this;
        }

        public b.a a(b b1)
        {
            if (!b.b(b1).isEmpty())
            {
                if (b.b(a) == null)
                {
                    b.a(a, new ArrayList());
                }
                b.b(a).addAll(b.b(b1));
            }
            if (!b.c(b1).isEmpty())
            {
                if (b.c(a) == null)
                {
                    b.b(a, new ArrayList());
                }
                b.c(a).addAll(b.c(b1));
            }
            if (!b.d(b1).isEmpty())
            {
                if (b.d(a) == null)
                {
                    b.c(a, new ArrayList());
                }
                b.d(a).addAll(b.d(b1));
            }
            if (!b.e(b1).isEmpty())
            {
                if (b.e(a) == null)
                {
                    b.d(a, new ArrayList());
                }
                b.e(a).addAll(b.e(b1));
            }
            if (!b.f(b1).isEmpty())
            {
                if (b.f(a) == null)
                {
                    b.e(a, new ArrayList());
                }
                b.f(a).addAll(b.f(b1));
            }
            return this;
        }

        public b.a a(P p)
        {
            if (b.f(a) == null)
            {
                b.e(a, new ArrayList());
            }
            b.f(a).add(p);
            return this;
        }

        public b.a a(g g1)
        {
            if (b.e(a) == null)
            {
                b.d(a, new ArrayList());
            }
            b.e(a).add(g1);
            return this;
        }

        public b a()
        {
            b b1;
            if (b.b(a) == null)
            {
                b.a(a, Collections.emptyList());
            } else
            {
                b.a(a, Collections.unmodifiableList(b.b(a)));
            }
            if (b.c(a) == null)
            {
                b.b(a, Collections.emptyList());
            } else
            {
                b.b(a, Collections.unmodifiableList(b.c(a)));
            }
            if (b.d(a) == null)
            {
                b.c(a, Collections.emptyList());
            } else
            {
                b.c(a, Collections.unmodifiableList(b.d(a)));
            }
            if (b.e(a) == null)
            {
                b.d(a, Collections.emptyList());
            } else
            {
                b.d(a, Collections.unmodifiableList(b.e(a)));
            }
            if (b.f(a) == null)
            {
                b.e(a, Collections.emptyList());
            } else
            {
                b.e(a, Collections.unmodifiableList(b.f(a)));
            }
            b1 = a;
            a = null;
            return b1;
        }

        public b.a b()
        {
            a = new b();
            return this;
        }

        public b.a b(long l1)
        {
            if (b.d(a) == null)
            {
                b.c(a, new ArrayList());
            }
            b.d(a).add(Long.valueOf(l1));
            return this;
        }

        private b.a()
        {
        }
    }

    public static final class c extends com.umeng.message.proguard.c
    {

        public P c(h h1, n n)
            throws s
        {
            n = P.b();
            try
            {
                n.a(h1);
            }
            // Misplaced declaration of an exception variable
            catch (h h1)
            {
                throw h1.a(n.c());
            }
            // Misplaced declaration of an exception variable
            catch (h h1)
            {
                throw (new s(h1.getMessage())).a(n.c());
            }
            return n.c();
        }

        public Object d(h h1, n n)
            throws s
        {
            return c(h1, n);
        }

        public c()
        {
        }
    }


    private static final P a = new P(Collections.emptyMap());
    private static final c c = new c();
    private Map b;

    private P()
    {
    }

    private P(Map map)
    {
        b = map;
    }


    public static a a(P p)
    {
        return b().a(p);
    }

    public static P a(g g1)
        throws s
    {
        return b().a(g1).b();
    }

    public static P a(h h1)
        throws IOException
    {
        return b().a(h1).b();
    }

    public static P a(InputStream inputstream)
        throws IOException
    {
        return b().a(inputstream).b();
    }

    public static P a(byte abyte0[])
        throws s
    {
        return b().a(abyte0).b();
    }

    public static a b()
    {
        return a.j();
    }

    static Map b(P p)
    {
        return p.b;
    }

    public static P c()
    {
        return a;
    }

    public y.a O()
    {
        return k();
    }

    public y.a P()
    {
        return j();
    }

    public y Q()
    {
        return e();
    }

    public void a(i i1)
        throws IOException
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); ((b)entry.getValue()).a(((Integer)entry.getKey()).intValue(), i1))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public void a(OutputStream outputstream)
        throws IOException
    {
        outputstream = com.umeng.message.proguard.i.a(outputstream);
        a(((i) (outputstream)));
        outputstream.a();
    }

    public boolean a()
    {
        return true;
    }

    public boolean a(int i1)
    {
        return b.containsKey(Integer.valueOf(i1));
    }

    public b b(int i1)
    {
        b b2 = (b)b.get(Integer.valueOf(i1));
        b b1 = b2;
        if (b2 == null)
        {
            b1 = b.b();
        }
        return b1;
    }

    public void b(i i1)
        throws IOException
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); ((b)entry.getValue()).b(((Integer)entry.getKey()).intValue(), i1))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public void b(OutputStream outputstream)
        throws IOException
    {
        outputstream = com.umeng.message.proguard.i.a(outputstream);
        outputstream.p(d());
        a(outputstream);
        outputstream.a();
    }

    public int d()
    {
        Iterator iterator = b.entrySet().iterator();
        java.util.Map.Entry entry;
        int i1;
        for (i1 = 0; iterator.hasNext(); i1 = ((b)entry.getValue()).a(((Integer)entry.getKey()).intValue()) + i1)
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return i1;
    }

    public P e()
    {
        return a;
    }

    public boolean equals(Object obj)
    {
        while (this == obj || (obj instanceof P) && b.equals(((P)obj).b)) 
        {
            return true;
        }
        return false;
    }

    public g f()
    {
        Object obj;
        try
        {
            obj = com.umeng.message.proguard.g.d(d());
            a(((g.b) (obj)).b());
            obj = ((g.b) (obj)).a();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", ioexception);
        }
        return ((g) (obj));
    }

    public byte[] g()
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[d()];
            i i1 = com.umeng.message.proguard.i.a(abyte0);
            a(i1);
            i1.c();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ioexception);
        }
        return abyte0;
    }

    public Map h()
    {
        return b;
    }

    public int hashCode()
    {
        return b.hashCode();
    }

    public int i()
    {
        Iterator iterator = b.entrySet().iterator();
        java.util.Map.Entry entry;
        int i1;
        for (i1 = 0; iterator.hasNext(); i1 = ((b)entry.getValue()).b(((Integer)entry.getKey()).intValue()) + i1)
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return i1;
    }

    public a j()
    {
        return b();
    }

    public a k()
    {
        return b().a(this);
    }

    public final c l()
    {
        return c;
    }

    public B m()
    {
        return l();
    }

    public String toString()
    {
        return N.b(this);
    }

}
