// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            F, I, x

static final class c
    implements F
{

    final Class a;
    final x b;
    final F c;

    public void a(x x1)
    {
        x x2 = (x)a.cast(x1);
        x1 = x2;
_L2:
        c.a(x1);
        return;
        ClassCastException classcastexception;
        classcastexception;
        x1 = I.a(b, x1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile void a(Object obj)
    {
        a((x)obj);
    }

    (Class class1, x x1, F f)
    {
        a = class1;
        b = x1;
        c = f;
        super();
    }
}
