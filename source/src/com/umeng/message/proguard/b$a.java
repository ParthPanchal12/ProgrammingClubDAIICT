// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            b, O, v, s, 
//            g, h, n, y

public static abstract class a.a
    implements a.a
{
    static final class a extends FilterInputStream
    {

        private int a;

        public int available()
            throws IOException
        {
            return Math.min(super.available(), a);
        }

        public int read()
            throws IOException
        {
            int i;
            if (a <= 0)
            {
                i = -1;
            } else
            {
                int j = super.read();
                i = j;
                if (j >= 0)
                {
                    a = a - 1;
                    return j;
                }
            }
            return i;
        }

        public int read(byte abyte0[], int i, int j)
            throws IOException
        {
            if (a <= 0)
            {
                i = -1;
            } else
            {
                j = super.read(abyte0, i, Math.min(j, a));
                i = j;
                if (j >= 0)
                {
                    a = a - j;
                    return j;
                }
            }
            return i;
        }

        public long skip(long l)
            throws IOException
        {
            l = super.skip(Math.min(l, a));
            if (l >= 0L)
            {
                a = (int)((long)a - l);
            }
            return l;
        }

        a(InputStream inputstream, int i)
        {
            super(inputstream);
            a = i;
        }
    }


    protected static O a(y y)
    {
        return new O(y);
    }

    private static void a(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext();)
        {
            if (iterable.next() == null)
            {
                throw new NullPointerException();
            }
        }

    }

    protected static void a(Iterable iterable, Collection collection)
    {
        if (iterable instanceof v)
        {
            a(((Iterable) (((v)iterable).a())));
        } else
        {
            a(iterable);
        }
        if (iterable instanceof Collection)
        {
            collection.addAll((Collection)iterable);
        } else
        {
            iterable = iterable.iterator();
            while (iterable.hasNext()) 
            {
                collection.add(iterable.next());
            }
        }
    }

    public a b(g g1)
        throws s
    {
        try
        {
            g1 = g1.k();
            b(((h) (g1)));
            g1.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (g g1)
        {
            throw g1;
        }
        // Misplaced declaration of an exception variable
        catch (g g1)
        {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", g1);
        }
        return this;
    }

    public t> b(g g1, n n1)
        throws s
    {
        try
        {
            g1 = g1.k();
            b(((h) (g1)), n1);
            g1.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (g g1)
        {
            throw g1;
        }
        // Misplaced declaration of an exception variable
        catch (g g1)
        {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", g1);
        }
        return this;
    }

    public t> b(h h1)
        throws IOException
    {
        return b(h1, n.g());
    }

    public abstract b b(h h1, n n1)
        throws IOException;

    public b b(byte abyte0[])
        throws s
    {
        return b(abyte0, 0, abyte0.length);
    }

    public b b(byte abyte0[], int i, int j)
        throws s
    {
        try
        {
            abyte0 = h.a(abyte0, i, j);
            b(((h) (abyte0)));
            abyte0.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", abyte0);
        }
        return this;
    }

    public t> b(byte abyte0[], int i, int j, n n1)
        throws s
    {
        try
        {
            abyte0 = h.a(abyte0, i, j);
            b(((h) (abyte0)), n1);
            abyte0.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", abyte0);
        }
        return this;
    }

    public t> b(byte abyte0[], n n1)
        throws s
    {
        return b(abyte0, 0, abyte0.length, n1);
    }

    public boolean b(InputStream inputstream)
        throws IOException
    {
        return b(inputstream, n.g());
    }

    public boolean b(InputStream inputstream, n n1)
        throws IOException
    {
        int i = inputstream.read();
        if (i == -1)
        {
            return false;
        } else
        {
            c(new a(inputstream, h.a(i, inputstream)), n1);
            return true;
        }
    }

    public a c(InputStream inputstream)
        throws IOException
    {
        inputstream = h.a(inputstream);
        b(inputstream);
        inputstream.a(0);
        return this;
    }

    public b c(InputStream inputstream, n n1)
        throws IOException
    {
        inputstream = h.a(inputstream);
        b(inputstream, n1);
        inputstream.a(0);
        return this;
    }

    public b c(g g1)
        throws s
    {
        return b(g1);
    }

    public b c(g g1, n n1)
        throws s
    {
        return b(g1, n1);
    }

    public b c(h h1)
        throws IOException
    {
        return b(h1);
    }

    public b c(h h1, n n1)
        throws IOException
    {
        return b(h1, n1);
    }

    public b c(byte abyte0[])
        throws s
    {
        return b(abyte0);
    }

    public b c(byte abyte0[], int i, int j)
        throws s
    {
        return b(abyte0, i, j);
    }

    public b c(byte abyte0[], int i, int j, n n1)
        throws s
    {
        return b(abyte0, i, j, n1);
    }

    public b c(byte abyte0[], n n1)
        throws s
    {
        return b(abyte0, n1);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return f();
    }

    public f d(InputStream inputstream)
        throws IOException
    {
        return c(inputstream);
    }

    public c d(InputStream inputstream, n n1)
        throws IOException
    {
        return c(inputstream, n1);
    }

    public abstract c f();

    public c g()
    {
        return f();
    }

    public a.a()
    {
    }
}
