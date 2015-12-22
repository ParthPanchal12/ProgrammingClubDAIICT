// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p, x, C

public static final class <init>
{

    private c a;
    private final Class b;
    private final x c;
    private final Method d;
    private final Method e;

    static Object a(<init> <init>1, Object obj)
    {
        return <init>1.a(obj);
    }

    private Object a(Object obj)
    {
label0:
        {
            Object obj1;
label1:
            {
                a a1 = a();
                if (!a1.n())
                {
                    break label0;
                }
                if (a1.g() != a.i)
                {
                    obj1 = obj;
                    if (a1.g() != a.h)
                    {
                        break label1;
                    }
                }
                obj1 = new ArrayList();
                for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); ((List) (obj1)).add(b(((Iterator) (obj)).next()))) { }
            }
            return obj1;
        }
        return b(obj);
    }

    static Object b(b b1, Object obj)
    {
        return b1.b(obj);
    }

    private Object b(Object obj)
    {
        b b1 = a();
        a[b1.g().ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 42
    //                   2 77;
           goto _L1 _L2 _L3
_L1:
        return obj;
_L2:
        if (!b.isInstance(obj))
        {
            return c.N().c((x)obj).ak();
        }
          goto _L1
_L3:
        return p.a(d, null, new Object[] {
            (d)obj
        });
    }

    static Object c(d d1, Object obj)
    {
        return d1.c(obj);
    }

    private Object c(Object obj)
    {
        c c1 = a();
        if (c1.n())
        {
            Object obj1 = obj;
            if (c1.g() == a.h)
            {
                obj1 = new ArrayList();
                for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); ((List) (obj1)).add(d(((Iterator) (obj)).next()))) { }
            }
            return obj1;
        } else
        {
            return d(obj);
        }
    }

    static Object d(d d1, Object obj)
    {
        return d1.d(obj);
    }

    private Object d(Object obj)
    {
        d d1 = a();
        switch (a[d1.g().ordinal()])
        {
        default:
            return obj;

        case 2: // '\002'
            return p.a(e, obj, new Object[0]);
        }
    }

    public e a()
    {
        if (a == null)
        {
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        } else
        {
            return a.a();
        }
    }

    public void a(a a1)
    {
        if (a != null)
        {
            throw new IllegalStateException("Already initialized.");
        } else
        {
            a = new p.f(a1) {

                final k.f a;
                final p.h b;

                public k.f a()
                {
                    return a;
                }

            
            {
                b = p.h.this;
                a = f;
                super();
            }
            };
            return;
        }
    }

    public x b()
    {
        return c;
    }

    private _cls1.a(_cls1.a a1, Class class1, x x1)
    {
        if (com/umeng/message/proguard/x.isAssignableFrom(class1) && !class1.isInstance(x1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad messageDefaultInstance for ").append(class1.getName()).toString());
        }
        a = a1;
        b = class1;
        c = x1;
        if (com/umeng/message/proguard/C.isAssignableFrom(class1))
        {
            d = p.a(class1, "valueOf", new Class[] {
                com/umeng/message/proguard/k$e
            });
            e = p.a(class1, "getValueDescriptor", new Class[0]);
            return;
        } else
        {
            d = null;
            e = null;
            return;
        }
    }

    e(e e1, Class class1, x x1, e e2)
    {
        this(e1, class1, x1);
    }
}
