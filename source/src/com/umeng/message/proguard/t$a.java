// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            t, y

static class <init>
    implements java.util.Entry
{

    private java.util.Entry a;

    public t a()
    {
        return (t)a.getValue();
    }

    public Object getKey()
    {
        return a.getKey();
    }

    public Object getValue()
    {
        t t1 = (t)a.getValue();
        if (t1 == null)
        {
            return null;
        } else
        {
            return t1.a();
        }
    }

    public Object setValue(Object obj)
    {
        if (!(obj instanceof y))
        {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        } else
        {
            return ((t)a.getValue()).a((y)obj);
        }
    }

    private ion(java.util.Entry entry)
    {
        a = entry;
    }

    a(java.util.Entry entry, a a1)
    {
        this(entry);
    }
}
