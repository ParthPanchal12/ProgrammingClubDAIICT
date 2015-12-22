// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            q, o, y, i

protected class <init>
{

    final c a;
    private final Iterator b;
    private java.util.try c;
    private final boolean d;

    public void a(int j, i k)
        throws IOException
    {
        while (c != null && ((c)c.getKey()).c() < j) 
        {
            <init> <init>1 = (c)c.getKey();
            if (d && <init>1.d() == d && !<init>1.d())
            {
                k.d(<init>1.d(), (y)c.getValue());
            } else
            {
                o.a(<init>1, c.getValue(), k);
            }
            if (b.hasNext())
            {
                c = (java.util.try)b.next();
            } else
            {
                c = null;
            }
        }
    }

    private ( , boolean flag)
    {
        a = ;
        super();
        b = b(a).h();
        if (b.hasNext())
        {
            c = (java.util.try)b.next();
        }
        d = flag;
    }

    d(d d1, boolean flag, d d2)
    {
        this(d1, flag);
    }
}
