// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.google.ads.util:
//            b

public abstract class i
{
    public abstract class a
    {

        protected Object a;
        protected final String b;
        final i c;

        public String toString()
        {
            return (new StringBuilder()).append(c.toString()).append(".").append(b).append(" = ").append(a).toString();
        }

        private a(String s)
        {
            this(s, null);
        }


        private a(String s, Object obj)
        {
            c = i.this;
            super();
            b = s;
            i.a(i.this, this);
            a = obj;
        }

    }

    public final class b extends a
    {

        final i d;

        public Object a()
        {
            return a;
        }

        public String toString()
        {
            return (new StringBuilder()).append(super.toString()).append(" (!)").toString();
        }

        public b(String s, Object obj)
        {
            d = i.this;
            super(s, obj);
        }
    }

    public final class c extends a
    {

        final i d;
        private boolean e;

        public Object a()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = a;
            this;
            JVM INSTR monitorexit ;
            return obj;
            Exception exception;
            exception;
            throw exception;
        }

        public void a(Object obj)
        {
            this;
            JVM INSTR monitorenter ;
            com.google.ads.util.b.d((new StringBuilder()).append("State changed - ").append(d.toString()).append(".").append(b).append(": '").append(obj).append("' <-- '").append(a).append("'.").toString());
            a = obj;
            e = true;
            this;
            JVM INSTR monitorexit ;
            return;
            obj;
            throw obj;
        }

        public String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder()).append(super.toString());
            String s;
            if (e)
            {
                s = " (*)";
            } else
            {
                s = "";
            }
            return stringbuilder.append(s).toString();
        }

        public c(String s)
        {
            d = i.this;
            super(s);
            e = false;
            e = false;
        }

        public c(String s, Object obj)
        {
            d = i.this;
            super(s, obj);
            e = false;
            e = false;
        }
    }

    public final class d extends a
    {

        final i d;

        public Object a()
        {
            return ((WeakReference)a).get();
        }

        public String toString()
        {
            return (new StringBuilder()).append(d.toString()).append(".").append(b).append(" = ").append(a()).append(" (?)").toString();
        }

        public d(String s, Object obj)
        {
            d = i.this;
            super(s, new WeakReference(obj));
        }
    }


    private static final Object a = new Object();
    private static int b = 0;
    private static HashMap c = new HashMap();
    private final ArrayList d;
    public final int u;

    public i()
    {
        d = new ArrayList();
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Integer integer;
        int j = b;
        b = j + 1;
        u = j;
        integer = (Integer)c.get(getClass());
        if (integer != null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        c.put(getClass(), Integer.valueOf(1));
_L1:
        obj;
        JVM INSTR monitorexit ;
        com.google.ads.util.b.d((new StringBuilder()).append("State created: ").append(toString()).toString());
        return;
        c.put(getClass(), Integer.valueOf(integer.intValue() + 1));
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(a a1)
    {
        d.add(a1);
    }

    static void a(i j, a a1)
    {
        j.a(a1);
    }

    protected void finalize()
        throws Throwable
    {
        synchronized (a)
        {
            c.put(getClass(), Integer.valueOf(((Integer)c.get(getClass())).intValue() - 1));
        }
        super.finalize();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("[").append(u).append("]").toString();
    }

}
