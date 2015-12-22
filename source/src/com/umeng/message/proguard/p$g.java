// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p, x

public static final class a
{
    private static interface a
    {

        public abstract x.a a();

        public abstract Object a(p.a a1);

        public abstract Object a(p.a a1, int i);

        public abstract Object a(p p1);

        public abstract Object a(p p1, int i);

        public abstract void a(p.a a1, int i, Object obj);

        public abstract void a(p.a a1, Object obj);

        public abstract void b(p.a a1, Object obj);

        public abstract boolean b(p.a a1);

        public abstract boolean b(p p1);

        public abstract int c(p.a a1);

        public abstract int c(p p1);

        public abstract void d(p.a a1);

        public abstract x.a e(p.a a1);
    }

    private static final class b extends c
    {

        private final Method k;
        private final Method l;

        public Object a(p.a a1)
        {
            ArrayList arraylist = new ArrayList();
            Object obj;
            for (a1 = ((List)super.a(a1)).iterator(); a1.hasNext(); arraylist.add(p.a(l, obj, new Object[0])))
            {
                obj = a1.next();
            }

            return Collections.unmodifiableList(arraylist);
        }

        public Object a(p.a a1, int i)
        {
            return p.a(l, super.a(a1, i), new Object[0]);
        }

        public Object a(p p1)
        {
            ArrayList arraylist = new ArrayList();
            Object obj;
            for (p1 = ((List)super.a(p1)).iterator(); p1.hasNext(); arraylist.add(p.a(l, obj, new Object[0])))
            {
                obj = p1.next();
            }

            return Collections.unmodifiableList(arraylist);
        }

        public Object a(p p1, int i)
        {
            return p.a(l, super.a(p1, i), new Object[0]);
        }

        public void a(p.a a1, int i, Object obj)
        {
            super.a(a1, i, p.a(k, null, new Object[] {
                obj
            }));
        }

        public void b(p.a a1, Object obj)
        {
            super.b(a1, p.a(k, null, new Object[] {
                obj
            }));
        }

        b(k.f f1, String s, Class class1, Class class2)
        {
            super(f1, s, class1, class2);
            k = p.a(a, "valueOf", new Class[] {
                com/umeng/message/proguard/k$e
            });
            l = p.a(a, "getValueDescriptor", new Class[0]);
        }
    }

    private static class c
        implements a
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

        public x.a a()
        {
            throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        }

        public Object a(p.a a1)
        {
            return p.a(c, a1, new Object[0]);
        }

        public Object a(p.a a1, int k)
        {
            return p.a(e, a1, new Object[] {
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

        public void a(p.a a1, int k, Object obj)
        {
            p.a(f, a1, new Object[] {
                Integer.valueOf(k), obj
            });
        }

        public void a(p.a a1, Object obj)
        {
            d(a1);
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); b(a1, ((Iterator) (obj)).next())) { }
        }

        public void b(p.a a1, Object obj)
        {
            p.a(g, a1, new Object[] {
                obj
            });
        }

        public boolean b(p.a a1)
        {
            throw new UnsupportedOperationException("hasField() called on a repeated field.");
        }

        public boolean b(p p1)
        {
            throw new UnsupportedOperationException("hasField() called on a repeated field.");
        }

        public int c(p.a a1)
        {
            return ((Integer)p.a(i, a1, new Object[0])).intValue();
        }

        public int c(p p1)
        {
            return ((Integer)p.a(h, p1, new Object[0])).intValue();
        }

        public void d(p.a a1)
        {
            p.a(j, a1, new Object[0]);
        }

        public x.a e(p.a a1)
        {
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        }

        c(k.f f1, String s, Class class1, Class class2)
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

    private static final class d extends c
    {

        private final Method k;

        private Object a(Object obj)
        {
            if (a.isInstance(obj))
            {
                return obj;
            } else
            {
                return ((x.a)p.a(k, null, new Object[0])).c((x)obj).ak();
            }
        }

        public x.a a()
        {
            return (x.a)p.a(k, null, new Object[0]);
        }

        public void a(p.a a1, int i, Object obj)
        {
            super.a(a1, i, a(obj));
        }

        public void b(p.a a1, Object obj)
        {
            super.b(a1, a(obj));
        }

        d(k.f f1, String s, Class class1, Class class2)
        {
            super(f1, s, class1, class2);
            k = p.a(a, "newBuilder", new Class[0]);
        }
    }

    private static final class e extends f
    {

        private Method h;
        private Method i;

        public Object a(p.a a1)
        {
            return p.a(i, super.a(a1), new Object[0]);
        }

        public Object a(p p1)
        {
            return p.a(i, super.a(p1), new Object[0]);
        }

        public void a(p.a a1, Object obj)
        {
            super.a(a1, p.a(h, null, new Object[] {
                obj
            }));
        }

        e(k.f f1, String s, Class class1, Class class2)
        {
            super(f1, s, class1, class2);
            h = p.a(a, "valueOf", new Class[] {
                com/umeng/message/proguard/k$e
            });
            i = p.a(a, "getValueDescriptor", new Class[0]);
        }
    }

    private static class f
        implements a
    {

        protected final Class a;
        protected final Method b;
        protected final Method c;
        protected final Method d;
        protected final Method e;
        protected final Method f;
        protected final Method g;

        public x.a a()
        {
            throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        }

        public Object a(p.a a1)
        {
            return p.a(c, a1, new Object[0]);
        }

        public Object a(p.a a1, int i)
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

        public void a(p.a a1, int i, Object obj)
        {
            throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
        }

        public void a(p.a a1, Object obj)
        {
            p.a(d, a1, new Object[] {
                obj
            });
        }

        public void b(p.a a1, Object obj)
        {
            throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
        }

        public boolean b(p.a a1)
        {
            return ((Boolean)p.a(f, a1, new Object[0])).booleanValue();
        }

        public boolean b(p p1)
        {
            return ((Boolean)p.a(e, p1, new Object[0])).booleanValue();
        }

        public int c(p.a a1)
        {
            throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        }

        public int c(p p1)
        {
            throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        }

        public void d(p.a a1)
        {
            p.a(g, a1, new Object[0]);
        }

        public x.a e(p.a a1)
        {
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        }

        f(k.f f1, String s, Class class1, Class class2)
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

    private static final class g extends f
    {

        private final Method h;
        private final Method i;

        private Object a(Object obj)
        {
            if (a.isInstance(obj))
            {
                return obj;
            } else
            {
                return ((x.a)p.a(h, null, new Object[0])).c((x)obj).aj();
            }
        }

        public x.a a()
        {
            return (x.a)p.a(h, null, new Object[0]);
        }

        public void a(p.a a1, Object obj)
        {
            super.a(a1, a(obj));
        }

        public x.a e(p.a a1)
        {
            return (x.a)p.a(i, a1, new Object[0]);
        }

        g(k.f f1, String s, Class class1, Class class2)
        {
            super(f1, s, class1, class2);
            h = p.a(a, "newBuilder", new Class[0]);
            i = p.a(class2, (new StringBuilder()).append("get").append(s).append("Builder").toString(), new Class[0]);
        }
    }


    private final c a;
    private final a b[];
    private String c[];
    private volatile boolean d;

    static g.i a(g.i i)
    {
        return i.a;
    }

    private a a(a a1)
    {
        if (a1.u() != a)
        {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        if (a1.t())
        {
            throw new IllegalArgumentException("This type does not have extensions.");
        } else
        {
            return b[a1.a()];
        }
    }

    static a a(a a1, a a2)
    {
        return a1.a(a2);
    }

    public a a(Class class1, Class class2)
    {
        if (d)
        {
            return this;
        }
        this;
        JVM INSTR monitorenter ;
        if (!d)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        this;
        JVM INSTR monitorexit ;
        return this;
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        int i = 0;
_L2:
        a a1;
        if (i >= b.length)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        a1 = (b)a.h().get(i);
        if (!a1.n())
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (a1.g() == a.i)
        {
            b[i] = new d(a1, c[i], class1, class2);
            break MISSING_BLOCK_LABEL_281;
        }
        if (a1.g() == a.h)
        {
            b[i] = new b(a1, c[i], class1, class2);
            break MISSING_BLOCK_LABEL_281;
        }
        b[i] = new c(a1, c[i], class1, class2);
        break MISSING_BLOCK_LABEL_281;
        if (a1.g() == a.i)
        {
            b[i] = new g(a1, c[i], class1, class2);
            break MISSING_BLOCK_LABEL_281;
        }
        if (a1.g() == a.h)
        {
            b[i] = new e(a1, c[i], class1, class2);
            break MISSING_BLOCK_LABEL_281;
        }
        b[i] = new f(a1, c[i], class1, class2);
        break MISSING_BLOCK_LABEL_281;
        d = true;
        c = null;
        this;
        JVM INSTR monitorexit ;
        return this;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public g(g g1, String as[])
    {
        a = g1;
        c = as;
        b = new a[g1.h().size()];
        d = false;
    }

    public d(d d1, String as[], Class class1, Class class2)
    {
        this(d1, as);
        a(class1, class2);
    }
}
