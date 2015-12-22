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
//            p

private static final class a extends a
{

    private final Method k;
    private final Method l;

    public Object a(a a1)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        for (a1 = ((List)super.a(a1)).iterator(); a1.hasNext(); arraylist.add(p.a(l, obj, new Object[0])))
        {
            obj = a1.next();
        }

        return Collections.unmodifiableList(arraylist);
    }

    public Object a(eList elist, int i)
    {
        return p.a(l, super.a(elist, i), new Object[0]);
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

    public void a(a a1, int i, Object obj)
    {
        super.a(a1, i, p.a(k, null, new Object[] {
            obj
        }));
    }

    public void b(k k1, Object obj)
    {
        super.b(k1, p.a(k, null, new Object[] {
            obj
        }));
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        k = p.a(a, "valueOf", new Class[] {
            com/umeng/message/proguard/k$e
        });
        l = p.a(a, "getValueDescriptor", new Class[0]);
    }
}
