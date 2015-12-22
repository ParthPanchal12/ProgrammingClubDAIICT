// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.umeng.message.proguard:
//            E, w

private class a extends InputStream
{

    final E a;
    private a b;
    private w c;
    private int d;
    private int e;
    private int f;
    private int g;

    private int a(byte abyte0[], int i, int j)
    {
        int k = j;
        int i1 = i;
        i = k;
        for (int l = i1; i > 0; l = i1)
        {
            b();
            if (c == null)
            {
                if (i == j)
                {
                    return -1;
                }
                break;
            }
            int j1 = Math.min(d - e, i);
            i1 = l;
            if (abyte0 != null)
            {
                c.b(abyte0, e, l, j1);
                i1 = l + j1;
            }
            e = e + j1;
            i -= j1;
        }

        return j - i;
    }

    private void a()
    {
        b = new <init>(a, null);
        c = b.a();
        d = c.a();
        e = 0;
        f = 0;
    }

    private void b()
    {
label0:
        {
            if (c != null && e == d)
            {
                f = f + d;
                e = 0;
                if (!b.hasNext())
                {
                    break label0;
                }
                c = b.a();
                d = c.a();
            }
            return;
        }
        c = null;
        d = 0;
    }

    public int available()
        throws IOException
    {
        int i = f;
        int j = e;
        return a.a() - (i + j);
    }

    public void mark(int i)
    {
        g = f + e;
    }

    public boolean markSupported()
    {
        return true;
    }

    public int read()
        throws IOException
    {
        b();
        if (c == null)
        {
            return -1;
        } else
        {
            w w1 = c;
            int i = e;
            e = i + 1;
            return w1.a(i) & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (i < 0 || j < 0 || j > abyte0.length - i)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return a(abyte0, i, j);
        }
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        a();
        a(null, 0, g);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long skip(long l)
    {
        if (l < 0L)
        {
            throw new IndexOutOfBoundsException();
        }
        long l1 = l;
        if (l > 0x7fffffffL)
        {
            l1 = 0x7fffffffL;
        }
        return (long)a(null, 0, (int)l1);
    }

    public tion(E e1)
    {
        a = e1;
        super();
        a();
    }
}
