// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;

// Referenced classes of package com.umeng.message.proguard:
//            p, x

private static final class i extends i
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
            return ((a)p.a(h, null, new Object[0])).h((x)obj).();
        }
    }

    public  a()
    {
        return ()p.a(h, null, new Object[0]);
    }

    public void a(h h1, Object obj)
    {
        super.a(h1, a(obj));
    }

    public a e(a a1)
    {
        return (a)p.a(i, a1, new Object[0]);
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        h = p.a(a, "newBuilder", new Class[0]);
        i = p.a(class2, (new StringBuilder()).append("get").append(s).append("Builder").toString(), new Class[0]);
    }
}
