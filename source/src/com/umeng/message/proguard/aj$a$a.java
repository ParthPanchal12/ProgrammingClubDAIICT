// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.umeng.message.proguard:
//            aj

public final class c
    implements c
{

    final a a;
    private final Map b = new HashMap();
    private boolean c;

    public c a()
    {
        this;
        JVM INSTR monitorenter ;
        c = true;
        this;
        JVM INSTR monitorexit ;
        return this;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public c a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(s, this);
        this;
        JVM INSTR monitorexit ;
        return this;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public b a(String s, float f)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(s, Float.valueOf(f));
        this;
        JVM INSTR monitorexit ;
        return this;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public b a(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(s, Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
        return this;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public b a(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(s, Long.valueOf(l));
        this;
        JVM INSTR monitorexit ;
        return this;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public b a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(s, s1);
        this;
        JVM INSTR monitorexit ;
        return this;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public b a(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        b.put(s, Boolean.valueOf(flag));
        this;
        JVM INSTR monitorexit ;
        return this;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean b()
    {
        boolean flag = false;
        Object obj1 = aj.a();
        obj1;
        JVM INSTR monitorenter ;
        if (b(a).size() > 0)
        {
            flag = true;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = new ArrayList();
        Object obj = new HashSet(a(a).keySet());
_L6:
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (c)
        {
            c(a).clear();
            c = false;
        }
        iterator = b.entrySet().iterator();
_L4:
        String s1;
        Object obj2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        obj2 = (java.util.ry)iterator.next();
        s1 = (String)((java.util.ry) (obj2)).getKey();
        obj2 = ((java.util.ry) (obj2)).getValue();
        if (obj2 != this)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        b(a).remove(s1);
_L5:
        if (!flag) goto _L4; else goto _L3
_L3:
        arraylist.add(s1);
          goto _L4
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        a(a).put(s1, obj2);
          goto _L5
        b.clear();
        this;
        JVM INSTR monitorexit ;
        boolean flag1 = b(a);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        a.a(true);
        obj1;
        JVM INSTR monitorexit ;
        if (flag)
        {
label0:
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                String s = (String)arraylist.get(i);
                Iterator iterator1 = ((Set) (obj)).iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    b b1 = (a)iterator1.next();
                    if (b1 != null)
                    {
                        b1.a(a, s);
                    }
                } while (true);
            }

        }
        return flag1;
_L2:
        obj = null;
        arraylist = null;
          goto _L6
    }

    public ( )
    {
        a = ;
        super();
        c = false;
    }
}
