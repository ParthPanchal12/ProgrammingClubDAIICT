// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.NoSuchElementException;

// Referenced classes of package com.umeng.message.proguard:
//            f

private class <init>
    implements <init>
{

    final f a;
    private int b;
    private final int c;

    public Byte a()
    {
        return Byte.valueOf(b());
    }

    public byte b()
    {
        if (b >= c)
        {
            throw new NoSuchElementException();
        } else
        {
            byte abyte0[] = a.f;
            int i = b;
            b = i + 1;
            return abyte0[i];
        }
    }

    public boolean hasNext()
    {
        return b < c;
    }

    public Object next()
    {
        return a();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    private xception(f f1)
    {
        a = f1;
        super();
        b = f1.b();
        c = b + f1.a();
    }

    b(f f1, b b1)
    {
        this(f1);
    }
}
