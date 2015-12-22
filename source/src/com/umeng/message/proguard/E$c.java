// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            E, w

private class <init>
    implements <init>
{

    int a;
    final E b;
    private final xception c;
    private xception d;

    public Byte a()
    {
        return Byte.valueOf(b());
    }

    public byte b()
    {
        if (!d.hasNext())
        {
            d = c.a().c();
        }
        a = a - 1;
        return d.b();
    }

    public boolean hasNext()
    {
        return a > 0;
    }

    public Object next()
    {
        return a();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    private xception(E e)
    {
        b = e;
        super();
        c = new <init>(e, null);
        d = c.a().c();
        a = e.a();
    }

    a(E e, a a1)
    {
        this(e);
    }
}
