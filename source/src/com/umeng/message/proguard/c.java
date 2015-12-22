// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.umeng.message.proguard:
//            B, n, b, O, 
//            s, y, g, h

public abstract class c
    implements B
{

    private static final n a = n.g();

    public c()
    {
    }

    private O a(y y1)
    {
        if (y1 instanceof b)
        {
            return ((b)y1).e();
        } else
        {
            return new O(y1);
        }
    }

    private y b(y y1)
        throws s
    {
        if (y1 != null && !y1.a())
        {
            throw a(y1).b().a(y1);
        } else
        {
            return y1;
        }
    }

    public y a(g g1)
        throws s
    {
        return a(g1, a);
    }

    public y a(g g1, n n1)
        throws s
    {
        try
        {
            g1 = g1.k();
            n1 = (y)d(g1, n1);
        }
        // Misplaced declaration of an exception variable
        catch (g g1)
        {
            throw g1;
        }
        g1.a(0);
        return n1;
        g1;
        throw g1.a(n1);
        g1;
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", g1);
    }

    public y a(h h1)
        throws s
    {
        return (y)d(h1, a);
    }

    public y a(h h1, n n1)
        throws s
    {
        return b((y)d(h1, n1));
    }

    public y a(InputStream inputstream)
        throws s
    {
        return a(inputstream, a);
    }

    public y a(InputStream inputstream, n n1)
        throws s
    {
        inputstream = com.umeng.message.proguard.h.a(inputstream);
        n1 = (y)d(inputstream, n1);
        try
        {
            inputstream.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream.a(n1);
        }
        return n1;
    }

    public y a(byte abyte0[])
        throws s
    {
        return a(abyte0, 0, abyte0.length, a);
    }

    public y a(byte abyte0[], int i, int j)
        throws s
    {
        return a(abyte0, i, j, a);
    }

    public y a(byte abyte0[], int i, int j, n n1)
        throws s
    {
        try
        {
            abyte0 = com.umeng.message.proguard.h.a(abyte0, i, j);
            n1 = (y)d(abyte0, n1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        abyte0.a(0);
        return n1;
        abyte0;
        throw abyte0.a(n1);
        abyte0;
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", abyte0);
    }

    public y a(byte abyte0[], n n1)
        throws s
    {
        return a(abyte0, 0, abyte0.length, n1);
    }

    public y b(g g1)
        throws s
    {
        return b(g1, a);
    }

    public y b(g g1, n n1)
        throws s
    {
        return b(a(g1, n1));
    }

    public y b(h h1)
        throws s
    {
        return a(h1, a);
    }

    public y b(InputStream inputstream)
        throws s
    {
        return b(inputstream, a);
    }

    public y b(InputStream inputstream, n n1)
        throws s
    {
        return b(a(inputstream, n1));
    }

    public y b(byte abyte0[])
        throws s
    {
        return b(abyte0, a);
    }

    public y b(byte abyte0[], int i, int j)
        throws s
    {
        return b(abyte0, i, j, a);
    }

    public y b(byte abyte0[], int i, int j, n n1)
        throws s
    {
        return b(a(abyte0, i, j, n1));
    }

    public y b(byte abyte0[], n n1)
        throws s
    {
        return b(abyte0, 0, abyte0.length, n1);
    }

    public Object b(h h1, n n1)
        throws s
    {
        return a(h1, n1);
    }

    public y c(InputStream inputstream)
        throws s
    {
        return c(inputstream, a);
    }

    public y c(InputStream inputstream, n n1)
        throws s
    {
        int i;
        try
        {
            i = inputstream.read();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new s(inputstream.getMessage());
        }
        if (i == -1)
        {
            return null;
        }
        i = com.umeng.message.proguard.h.a(i, inputstream);
        return a(new b.a.a(inputstream, i), n1);
    }

    public Object c(g g1)
        throws s
    {
        return a(g1);
    }

    public Object c(g g1, n n1)
        throws s
    {
        return a(g1, n1);
    }

    public Object c(h h1)
        throws s
    {
        return a(h1);
    }

    public Object c(byte abyte0[])
        throws s
    {
        return a(abyte0);
    }

    public Object c(byte abyte0[], int i, int j)
        throws s
    {
        return a(abyte0, i, j);
    }

    public Object c(byte abyte0[], int i, int j, n n1)
        throws s
    {
        return a(abyte0, i, j, n1);
    }

    public Object c(byte abyte0[], n n1)
        throws s
    {
        return a(abyte0, n1);
    }

    public y d(InputStream inputstream)
        throws s
    {
        return d(inputstream, a);
    }

    public y d(InputStream inputstream, n n1)
        throws s
    {
        return b(c(inputstream, n1));
    }

    public Object d(g g1)
        throws s
    {
        return b(g1);
    }

    public Object d(g g1, n n1)
        throws s
    {
        return b(g1, n1);
    }

    public Object d(h h1)
        throws s
    {
        return b(h1);
    }

    public Object d(byte abyte0[])
        throws s
    {
        return b(abyte0);
    }

    public Object d(byte abyte0[], int i, int j)
        throws s
    {
        return b(abyte0, i, j);
    }

    public Object d(byte abyte0[], int i, int j, n n1)
        throws s
    {
        return b(abyte0, i, j, n1);
    }

    public Object d(byte abyte0[], n n1)
        throws s
    {
        return b(abyte0, n1);
    }

    public Object e(InputStream inputstream)
        throws s
    {
        return c(inputstream);
    }

    public Object e(InputStream inputstream, n n1)
        throws s
    {
        return c(inputstream, n1);
    }

    public Object f(InputStream inputstream)
        throws s
    {
        return d(inputstream);
    }

    public Object f(InputStream inputstream, n n1)
        throws s
    {
        return d(inputstream, n1);
    }

    public Object g(InputStream inputstream)
        throws s
    {
        return a(inputstream);
    }

    public Object g(InputStream inputstream, n n1)
        throws s
    {
        return a(inputstream, n1);
    }

    public Object h(InputStream inputstream)
        throws s
    {
        return b(inputstream);
    }

    public Object h(InputStream inputstream, n n1)
        throws s
    {
        return b(inputstream, n1);
    }

}
