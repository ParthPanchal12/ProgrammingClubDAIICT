// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            y

public class n
{
    private static final class a
    {

        private final Object a;
        private final int b;

        public boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (a == ((a) (obj = (a)obj)).a && b == ((a) (obj)).b)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return System.identityHashCode(a) * 65535 + b;
        }

        a(Object obj, int i)
        {
            a = obj;
            b = i;
        }
    }


    private static volatile boolean a = false;
    private static final n c = new n(true);
    private final Map b;

    n()
    {
        b = new HashMap();
    }

    n(n n1)
    {
        if (n1 == c)
        {
            b = Collections.emptyMap();
            return;
        } else
        {
            b = Collections.unmodifiableMap(n1.b);
            return;
        }
    }

    private n(boolean flag)
    {
        b = Collections.emptyMap();
    }

    public static void a(boolean flag)
    {
        a = flag;
    }

    public static boolean e()
    {
        return a;
    }

    public static n f()
    {
        return new n();
    }

    public static n g()
    {
        return c;
    }

    public q.f a(y y, int i)
    {
        return (q.f)b.get(new a(y, i));
    }

    public final void a(q.f f1)
    {
        b.put(new a(f1.a(), f1.b()), f1);
    }

    public n d()
    {
        return new n(this);
    }

}
