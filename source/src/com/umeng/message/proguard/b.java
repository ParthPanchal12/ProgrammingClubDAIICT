// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.umeng.message.proguard:
//            y, i, O, g, 
//            v, s, h, n

public abstract class b
    implements y
{
    public static abstract class a
        implements y.a
    {

        protected static O a(y y1)
        {
            return new O(y1);
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

        public a b(g g1, n n1)
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

        public a b(h h1)
            throws IOException
        {
            return b(h1, n.g());
        }

        public abstract a b(h h1, n n1)
            throws IOException;

        public a b(byte abyte0[])
            throws s
        {
            return b(abyte0, 0, abyte0.length);
        }

        public a b(byte abyte0[], int j, int k)
            throws s
        {
            try
            {
                abyte0 = h.a(abyte0, j, k);
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

        public a b(byte abyte0[], int j, int k, n n1)
            throws s
        {
            try
            {
                abyte0 = h.a(abyte0, j, k);
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

        public a b(byte abyte0[], n n1)
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
            int j = inputstream.read();
            if (j == -1)
            {
                return false;
            } else
            {
                c(new a(inputstream, h.a(j, inputstream)), n1);
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

        public a c(InputStream inputstream, n n1)
            throws IOException
        {
            inputstream = h.a(inputstream);
            b(inputstream, n1);
            inputstream.a(0);
            return this;
        }

        public y.a c(g g1)
            throws s
        {
            return b(g1);
        }

        public y.a c(g g1, n n1)
            throws s
        {
            return b(g1, n1);
        }

        public y.a c(h h1)
            throws IOException
        {
            return b(h1);
        }

        public y.a c(h h1, n n1)
            throws IOException
        {
            return b(h1, n1);
        }

        public y.a c(byte abyte0[])
            throws s
        {
            return b(abyte0);
        }

        public y.a c(byte abyte0[], int j, int k)
            throws s
        {
            return b(abyte0, j, k);
        }

        public y.a c(byte abyte0[], int j, int k, n n1)
            throws s
        {
            return b(abyte0, j, k, n1);
        }

        public y.a c(byte abyte0[], n n1)
            throws s
        {
            return b(abyte0, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return f();
        }

        public y.a d(InputStream inputstream)
            throws IOException
        {
            return c(inputstream);
        }

        public y.a d(InputStream inputstream, n n1)
            throws IOException
        {
            return c(inputstream, n1);
        }

        public abstract a f();

        public y.a g()
        {
            return f();
        }

        public a()
        {
        }
    }

    static final class a.a extends FilterInputStream
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
            int j;
            if (a <= 0)
            {
                j = -1;
            } else
            {
                int k = super.read();
                j = k;
                if (k >= 0)
                {
                    a = a - 1;
                    return k;
                }
            }
            return j;
        }

        public int read(byte abyte0[], int j, int k)
            throws IOException
        {
            if (a <= 0)
            {
                j = -1;
            } else
            {
                k = super.read(abyte0, j, Math.min(k, a));
                j = k;
                if (k >= 0)
                {
                    a = a - k;
                    return k;
                }
            }
            return j;
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

        a.a(InputStream inputstream, int j)
        {
            super(inputstream);
            a = j;
        }
    }


    public b()
    {
    }

    public void a(OutputStream outputstream)
        throws IOException
    {
        outputstream = i.a(outputstream, i.a(d()));
        a(((i) (outputstream)));
        outputstream.a();
    }

    public void b(OutputStream outputstream)
        throws IOException
    {
        int j = d();
        outputstream = i.a(outputstream, i.a(i.q(j) + j));
        outputstream.p(j);
        a(outputstream);
        outputstream.a();
    }

    O e()
    {
        return new O(this);
    }

    public g f()
    {
        Object obj;
        try
        {
            obj = com.umeng.message.proguard.g.d(d());
            a(((g.b) (obj)).b());
            obj = ((g.b) (obj)).a();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", ioexception);
        }
        return ((g) (obj));
    }

    public byte[] g()
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[d()];
            i j = i.a(abyte0);
            a(j);
            j.c();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ioexception);
        }
        return abyte0;
    }
}
