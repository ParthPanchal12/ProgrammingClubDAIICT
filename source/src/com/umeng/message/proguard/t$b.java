// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            t

static class a
    implements Iterator
{

    private Iterator a;

    public java.util.Entry a()
    {
        java.util.Entry entry = (java.util.Entry)a.next();
        Object obj = entry;
        if (entry.getValue() instanceof t)
        {
            obj = new <init>(entry, null);
        }
        return ((java.util.Entry) (obj));
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
        a.remove();
    }

    public (Iterator iterator)
    {
        a = iterator;
    }
}
