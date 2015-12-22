// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            b, S, n, h, 
//            o, y, B, i, 
//            z, s

public abstract class q extends com.umeng.message.proguard.b
    implements Serializable
{
    public static abstract class a extends b.a
    {

        public y Q()
        {
            return d();
        }

        public abstract a a(q q1);

        protected boolean a(h h1, n n1, int i)
            throws IOException
        {
            return h1.b(i);
        }

        public a b()
        {
            return this;
        }

        public a c()
        {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return c();
        }

        public abstract q d();

        public b.a f()
        {
            return c();
        }

        public y.a g()
        {
            return c();
        }

        public y.a h()
        {
            return b();
        }

        protected a()
        {
        }
    }

    public static abstract class b extends a
        implements d
    {

        private o a;
        private boolean b;

        static o a(b b1)
        {
            return b1.l();
        }

        private void e(f f1)
        {
            if (f1.a() != d())
            {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            } else
            {
                return;
            }
        }

        private void k()
        {
            if (!b)
            {
                a = a.e();
                b = true;
            }
        }

        private o l()
        {
            a.c();
            b = false;
            return a;
        }

        public final b a(f f1, int i1, Object obj)
        {
            e(f1);
            k();
            a.a(f.a(f1), i1, obj);
            return this;
        }

        public final b a(f f1, Object obj)
        {
            e(f1);
            k();
            a.a(f.a(f1), obj);
            return this;
        }

        public final Object a(f f1, int i1)
        {
            e(f1);
            return a.a(f.a(f1), i1);
        }

        protected final void a(c c1)
        {
            k();
            a.a(c.a(c1));
        }

        protected boolean a(h h1, n n1, int i1)
            throws IOException
        {
            k();
            return q.a(a, d(), h1, n1, i1);
        }

        public final boolean a(f f1)
        {
            e(f1);
            return a.a(f.a(f1));
        }

        public final int b(f f1)
        {
            e(f1);
            return a.d(f.a(f1));
        }

        public a b()
        {
            return e();
        }

        public final b b(f f1, Object obj)
        {
            e(f1);
            k();
            a.b(f.a(f1), obj);
            return this;
        }

        public a c()
        {
            return i();
        }

        public final Object c(f f1)
        {
            e(f1);
            Object obj1 = a.b(f.a(f1));
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = f.b(f1);
            }
            return obj;
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return i();
        }

        public final b d(f f1)
        {
            e(f1);
            k();
            a.c(f.a(f1));
            return this;
        }

        public b e()
        {
            a.f();
            b = false;
            return (b)super.b();
        }

        public b.a f()
        {
            return i();
        }

        public y.a g()
        {
            return i();
        }

        public y.a h()
        {
            return e();
        }

        public b i()
        {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean j()
        {
            return a.i();
        }

        protected b()
        {
            a = o.b();
        }
    }

    public static abstract class c extends q
        implements d
    {

        private final o a;

        static o a(c c1)
        {
            return c1.a;
        }

        private void d(f f1)
        {
            if (f1.a() != Q())
            {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            } else
            {
                return;
            }
        }

        public final Object a(f f1, int i1)
        {
            d(f1);
            return a.a(f.a(f1), i1);
        }

        protected boolean a(h h1, n n1, int i1)
            throws IOException
        {
            return q.a(a, Q(), h1, n1, i1);
        }

        public final boolean a(f f1)
        {
            d(f1);
            return a.a(f.a(f1));
        }

        public final int b(f f1)
        {
            d(f1);
            return a.d(f.a(f1));
        }

        protected void b()
        {
            a.c();
        }

        public final Object c(f f1)
        {
            d(f1);
            Object obj1 = a.b(f.a(f1));
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = f.b(f1);
            }
            return obj;
        }

        protected boolean h()
        {
            return a.i();
        }

        protected a i()
        {
            return new a(this, false);
        }

        protected a j()
        {
            return new a(this, true);
        }

        protected int k()
        {
            return a.j();
        }

        protected int l()
        {
            return a.k();
        }

        protected c()
        {
            a = o.a();
        }

        protected c(b b1)
        {
            a = b.a(b1);
        }
    }

    protected class c.a
    {

        final c a;
        private final Iterator b;
        private java.util.Map.Entry c;
        private final boolean d;

        public void a(int j, i k)
            throws IOException
        {
            while (c != null && ((e)c.getKey()).f() < j) 
            {
                e e1 = (e)c.getKey();
                if (d && e1.h() == S.b.i && !e1.n())
                {
                    k.d(e1.f(), (y)c.getValue());
                } else
                {
                    o.a(e1, c.getValue(), k);
                }
                if (b.hasNext())
                {
                    c = (java.util.Map.Entry)b.next();
                } else
                {
                    c = null;
                }
            }
        }

        private c.a(c c1, boolean flag)
        {
            a = c1;
            super();
            b = c.a(a).h();
            if (b.hasNext())
            {
                c = (java.util.Map.Entry)b.next();
            }
            d = flag;
        }

    }

    public static interface d
        extends z
    {

        public abstract Object a(f f1, int i);

        public abstract boolean a(f f1);

        public abstract int b(f f1);

        public abstract Object c(f f1);
    }

    private static final class e
        implements o.a
    {

        private final r.b a;
        private final int b;
        private final S.a c;
        private final boolean d;
        private final boolean e;

        static boolean b(e e1)
        {
            return e1.d;
        }

        static S.a c(e e1)
        {
            return e1.c;
        }

        public int a(e e1)
        {
            return b - e1.b;
        }

        public y.a a(y.a a1, y y1)
        {
            return ((a)a1).a((q)y1);
        }

        public int compareTo(Object obj)
        {
            return a((e)obj);
        }

        public int f()
        {
            return b;
        }

        public S.b h()
        {
            return c.a();
        }

        public S.a j()
        {
            return c;
        }

        public boolean n()
        {
            return d;
        }

        public boolean o()
        {
            return e;
        }

        public r.b y()
        {
            return a;
        }

        private e(r.b b1, int i, S.a a1, boolean flag, boolean flag1)
        {
            a = b1;
            b = i;
            c = a1;
            d = flag;
            e = flag1;
        }

    }

    public static final class f
    {

        private final y a;
        private final Object b;
        private final y c;
        private final e d;

        static e a(f f1)
        {
            return f1.d;
        }

        static Object b(f f1)
        {
            return f1.b;
        }

        static y c(f f1)
        {
            return f1.c;
        }

        public y a()
        {
            return a;
        }

        public int b()
        {
            return d.f();
        }

        public y c()
        {
            return c;
        }

        private f(y y1, Object obj, y y2, e e1)
        {
            if (y1 == null)
            {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (e1.j() == S.a.k && y2 == null)
            {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else
            {
                a = y1;
                b = obj;
                c = y2;
                d = e1;
                return;
            }
        }

    }

    static final class g
        implements Serializable
    {

        private static final long a = 0L;
        private String b;
        private byte c[];

        protected Object a()
            throws ObjectStreamException
        {
            Object obj;
            try
            {
                obj = (y.a)Class.forName(b).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                ((y.a) (obj)).c(c);
                obj = ((y.a) (obj)).al();
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                throw new RuntimeException("Unable to find proto buffer class", classnotfoundexception);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                throw new RuntimeException("Unable to find newBuilder method", nosuchmethodexception);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new RuntimeException("Unable to call newBuilder method", illegalaccessexception);
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                throw new RuntimeException("Error calling newBuilder", invocationtargetexception.getCause());
            }
            catch (s s1)
            {
                throw new RuntimeException("Unable to understand proto buffer", s1);
            }
            return obj;
        }

        g(y y1)
        {
            b = y1.getClass().getName();
            c = y1.g();
        }
    }


    private static final long a = 1L;

    protected q()
    {
    }

    protected q(a a1)
    {
    }

    public static f a(y y1, y y2, r.b b1, int i, S.a a1, boolean flag)
    {
        return new f(y1, Collections.emptyList(), y2, new e(b1, i, a1, true, flag));
    }

    public static f a(y y1, Object obj, y y2, r.b b1, int i, S.a a1)
    {
        return new f(y1, obj, y2, new e(b1, i, a1, false, false));
    }

    static boolean a(o o1, y y1, h h1, n n1, int i)
        throws IOException
    {
        return b(o1, y1, h1, n1, i);
    }

    private static boolean b(o o1, y y1, h h1, n n1, int i)
        throws IOException
    {
        f f1;
        boolean flag;
        flag = false;
        int j = S.a(i);
        f1 = n1.a(y1, S.b(i));
        if (f1 == null)
        {
            j = 1;
        } else
        if (j == o.a(f.a(f1).j(), false))
        {
            j = 0;
        } else
        if (e.b(f.a(f1)) && e.c(f.a(f1)).c() && j == o.a(f.a(f1).j(), true))
        {
            j = 0;
            flag = true;
        } else
        {
            j = 1;
        }
        if (j != 0)
        {
            return h1.b(i);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        i = h1.f(h1.s());
        if (f.a(f1).j() == S.a.n)
        {
            for (; h1.x() > 0; o1.b(f.a(f1), y1))
            {
                int k = h1.n();
                y1 = f.a(f1).y().b(k);
                if (y1 == null)
                {
                    return true;
                }
            }

        } else
        {
            for (; h1.x() > 0; o1.b(f.a(f1), y1))
            {
                y1 = ((y) (o.a(h1, f.a(f1).j())));
            }

        }
        h1.g(i);
_L6:
        return true;
_L2:
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[S.b.values().length];
                try
                {
                    a[S.b.i.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[S.b.h.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[f.a(f1).h().ordinal()];
        JVM INSTR tableswitch 1 2: default 276
    //                   1 313
    //                   2 414;
           goto _L3 _L4 _L5
_L3:
        y1 = ((y) (o.a(h1, f.a(f1).j())));
_L7:
        if (f.a(f1).n())
        {
            o1.b(f.a(f1), y1);
        } else
        {
            o1.a(f.a(f1), y1);
        }
        if (true) goto _L6; else goto _L4
_L4:
        if (f.a(f1).n())
        {
            break MISSING_BLOCK_LABEL_457;
        }
        y1 = (y)o1.b(f.a(f1));
        if (y1 == null)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        y1 = y1.O();
_L8:
        Object obj = y1;
        if (y1 == null)
        {
            obj = f.c(f1).P();
        }
        if (f.a(f1).j() == S.a.j)
        {
            h1.a(f1.b(), ((y.a) (obj)), n1);
        } else
        {
            h1.a(((y.a) (obj)), n1);
        }
        y1 = ((y.a) (obj)).am();
          goto _L7
_L5:
        i = h1.n();
        h1 = f.a(f1).y().b(i);
        y1 = h1;
        if (h1 == null)
        {
            return true;
        }
          goto _L7
        y1 = null;
          goto _L8
    }

    protected boolean a(h h1, n n1, int i)
        throws IOException
    {
        return h1.b(i);
    }

    protected void b()
    {
    }

    protected Object c()
        throws ObjectStreamException
    {
        return new g(this);
    }

    public B m()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
}
