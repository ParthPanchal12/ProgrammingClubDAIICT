// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

// Referenced classes of package com.umeng.message.proguard:
//            v, Q, g

public class u extends AbstractList
    implements v, RandomAccess
{

    public static final v a = new Q(new u());
    private final List b;

    public u()
    {
        b = new ArrayList();
    }

    public u(v v1)
    {
        b = new ArrayList(v1.size());
        addAll(v1);
    }

    public u(List list)
    {
        b = new ArrayList(list);
    }

    private String a(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            return ((g)obj).h();
        }
    }

    public String a(int i)
    {
        Object obj = b.get(i);
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            b.set(i, s);
        }
        return s;
    }

    public String a(int i, String s)
    {
        return a(b.set(i, s));
    }

    public List a()
    {
        return Collections.unmodifiableList(b);
    }

    public void a(g g1)
    {
        b.add(g1);
        modCount = modCount + 1;
    }

    public void add(int i, Object obj)
    {
        b(i, (String)obj);
    }

    public boolean addAll(int i, Collection collection)
    {
        Object obj = collection;
        if (collection instanceof v)
        {
            obj = ((v)collection).a();
        }
        boolean flag = b.addAll(i, ((Collection) (obj)));
        modCount = modCount + 1;
        return flag;
    }

    public boolean addAll(Collection collection)
    {
        return addAll(size(), collection);
    }

    public String b(int i)
    {
        Object obj = b.remove(i);
        modCount = modCount + 1;
        return a(obj);
    }

    public void b(int i, String s)
    {
        b.add(i, s);
        modCount = modCount + 1;
    }

    public g c(int i)
    {
        Object obj = b.get(i);
        if (obj instanceof String)
        {
            obj = g.a((String)obj);
            b.set(i, obj);
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public void clear()
    {
        b.clear();
        modCount = modCount + 1;
    }

    public Object get(int i)
    {
        return a(i);
    }

    public Object remove(int i)
    {
        return b(i);
    }

    public Object set(int i, Object obj)
    {
        return a(i, (String)obj);
    }

    public int size()
    {
        return b.size();
    }

}
