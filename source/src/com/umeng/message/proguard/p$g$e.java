// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.lang.reflect.Method;

// Referenced classes of package com.umeng.message.proguard:
//            p

private static final class a extends a
{

    private Method h;
    private Method i;

    public Object a(a a1)
    {
        return p.a(i, super.a(a1), new Object[0]);
    }

    public Object a(p p1)
    {
        return p.a(i, super.a(p1), new Object[0]);
    }

    public void a(a a1, Object obj)
    {
        super.a(a1, p.a(h, null, new Object[] {
            obj
        }));
    }

    ( , String s, Class class1, Class class2)
    {
        super(, s, class1, class2);
        h = p.a(a, "valueOf", new Class[] {
            com/umeng/message/proguard/k$e
        });
        i = p.a(a, "getValueDescriptor", new Class[0]);
    }
}
