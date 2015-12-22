// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;

// Referenced classes of package com.umeng.message.proguard:
//            p, x

private static final class a extends a
{

    private final Method k;

    private Object a(Object obj)
    {
        if (a.isInstance(obj))
        {
            return obj;
        } else
        {
            return ((a)p.a(k, null, new Object[0])).k((x)obj).();
        }
    }

    public  a()
    {
        return ()p.a(k, null, new Object[0]);
    }

    public void a(k k1, int i, Object obj)
    {
        super.a(k1, i, a(obj));
    }

    public void b(a a1, Object obj)
    {
        super.b(a1, a(obj));
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        k = p.a(a, "newBuilder", new Class[0]);
    }
}
