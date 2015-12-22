// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.umeng.message.proguard:
//            p, P, x, h, 
//            n

public static abstract class a extends a
{
    private class a
        implements p.b
    {

        final p.a a;

        public void a()
        {
            a.aF();
        }

        private a()
        {
            a = p.a.this;
            super();
        }

        a(p._cls1 _pcls1)
        {
            this();
        }
    }


    private ah a;
    private a b;
    private boolean c;
    private P d;

    static Map a(aF af)
    {
        return af.k();
    }

    private Map k()
    {
        TreeMap treemap = new TreeMap();
        Iterator iterator = a(l()).h().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            k k1 = (h)iterator.next();
            if (k1.n())
            {
                List list = (List)b(k1);
                if (!list.isEmpty())
                {
                    treemap.put(k1, list);
                }
            } else
            if (a_(k1))
            {
                treemap.put(k1, b(k1));
            }
        } while (true);
        return treemap;
    }

    public b J()
    {
        return a(l());
    }

    public l a(P p1)
    {
        return d(p1);
    }

    public d a(d d1, int i1, Object obj)
    {
        a(l(), d1).a(this, i1, obj);
        return this;
    }

    public a.a a(a.a a1, Object obj)
    {
        a(l(), a1).a(this, obj);
        return this;
    }

    public a.a a(a.a a1)
    {
        return a(l(), a1).e(this);
    }

    public Object a(a.e e1, int i1)
    {
        return a(l(), e1).a(this, i1);
    }

    public boolean a()
    {
        Iterator iterator = J().h().iterator();
_L2:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_134;
            }
            obj = (h)iterator.next();
            if (((h) (obj)).k() && !a_(((a_) (obj))))
            {
                return false;
            }
        } while (((a_) (obj)).g() != a.i);
        if (!((a.i) (obj)).n())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List)b(((b) (obj)))).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        if (((x)((Iterator) (obj)).next()).a()) goto _L4; else goto _L3
_L3:
        return false;
        if (!a_(((a_) (obj))) || ((x)b(((b) (obj)))).a()) goto _L2; else goto _L5
_L5:
        return false;
        return true;
    }

    protected boolean a(h h1, b b1, n n, int i1)
        throws IOException
    {
        return b1.a(i1, h1);
    }

    void aA()
    {
        a = null;
    }

    protected void aB()
    {
        if (a != null)
        {
            aC();
        }
    }

    protected void aC()
    {
        c = true;
    }

    protected boolean aD()
    {
        return c;
    }

    protected c aE()
    {
        if (b == null)
        {
            b = new a(null);
        }
        return b;
    }

    protected final void aF()
    {
        if (c && a != null)
        {
            a.a();
            c = false;
        }
    }

    public Map a_()
    {
        return Collections.unmodifiableMap(k());
    }

    public boolean a_(k k1)
    {
        return a(l(), k1).b(this);
    }

    public a.b ah()
    {
        d = P.c();
        aF();
        return this;
    }

    public aF ai()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public xception b(xception xception, Object obj)
    {
        a(l(), xception).b(this, obj);
        return this;
    }

    public a.b b(P p1)
    {
        return d(p1);
    }

    public d b(d d1, int i1, Object obj)
    {
        return a(d1, i1, obj);
    }

    public Object b(a a1)
    {
        Object obj1 = a(l(), a1).a(this);
        Object obj = obj1;
        if (a1.n())
        {
            obj = Collections.unmodifiableList((List)obj1);
        }
        return obj;
    }

    public final P b_()
    {
        return d;
    }

    public int c(d d1)
    {
        return a(l(), d1).c(this);
    }

    public final a.c c(P p1)
    {
        d = p1;
        aF();
        return this;
    }

    public aF c(aF af, Object obj)
    {
        return b(af, obj);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return ai();
    }

    public ai d()
    {
        return ai();
    }

    public final ai d(P p1)
    {
        d = P.a(d).a(p1).b();
        aF();
        return this;
    }

    public aF d(aF af)
    {
        a(l(), af).d(this);
        return this;
    }

    public a.d d(a.d d1, Object obj)
    {
        return a(d1, obj);
    }

    public a e()
    {
        return ah();
    }

    public ah e(P p1)
    {
        return c(p1);
    }

    public c f()
    {
        return ai();
    }

    public ai f(ai ai1)
    {
        return d(ai1);
    }

    public d g(d d1)
    {
        return a(l(), d1).a();
    }

    public a.a g()
    {
        return ai();
    }

    public ai h()
    {
        return ah();
    }

    public ah i()
    {
        return ai();
    }

    public ai j()
    {
        return ah();
    }

    protected abstract ah l();

    protected a()
    {
        this(null);
    }

    protected <init>(<init> <init>1)
    {
        d = P.c();
        a = <init>1;
    }
}
