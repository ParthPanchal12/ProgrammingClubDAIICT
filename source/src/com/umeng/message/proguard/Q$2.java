// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            Q, v

class erator
    implements Iterator
{

    Iterator a;
    final Q b;

    public String a()
    {
        return (String)a.next();
    }

    public boolean hasNext()
    {
        return a.hasNext();
    }

    public Object next()
    {
        return a();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    xception(Q q)
    {
        b = q;
        super();
        a = Q.a(b).iterator();
    }
}
