// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            M

private class <init> extends AbstractSet
{

    final M a;

    public boolean a(java.util.Entry entry)
    {
        if (!contains(entry))
        {
            a.a((Comparable)entry.getKey(), entry.getValue());
            return true;
        } else
        {
            return false;
        }
    }

    public boolean add(Object obj)
    {
        return a((java.util.Entry)obj);
    }

    public void clear()
    {
        a.clear();
    }

    public boolean contains(Object obj)
    {
        Object obj1 = (java.util.Entry)obj;
        obj = a.get(((java.util.Entry) (obj1)).getKey());
        obj1 = ((java.util.Entry) (obj1)).getValue();
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public Iterator iterator()
    {
        return new <init>(a, null);
    }

    public boolean remove(Object obj)
    {
        obj = (java.util.Entry)obj;
        if (contains(obj))
        {
            a.remove(((java.util.Entry) (obj)).getKey());
            return true;
        } else
        {
            return false;
        }
    }

    public int size()
    {
        return a.size();
    }

    private (M m)
    {
        a = m;
        super();
    }

    a(M m, a a1)
    {
        this(m);
    }
}
