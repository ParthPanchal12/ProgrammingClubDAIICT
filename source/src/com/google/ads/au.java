// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.google.ads:
//            av

public final class au
{
    public static class a extends IOException
    {

        a()
        {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }


    private final byte a[];
    private final int b;
    private int c;
    private int d;
    private final OutputStream e;

    private au(OutputStream outputstream, byte abyte0[])
    {
        d = 0;
        e = outputstream;
        a = abyte0;
        c = 0;
        b = abyte0.length;
    }

    public static au a(OutputStream outputstream)
    {
        return a(outputstream, 4096);
    }

    public static au a(OutputStream outputstream, int i)
    {
        return new au(outputstream, new byte[i]);
    }

    private void b()
        throws IOException
    {
        if (e == null)
        {
            throw new a();
        } else
        {
            e.write(a, 0, c);
            c = 0;
            return;
        }
    }

    public void a()
        throws IOException
    {
        if (e != null)
        {
            b();
        }
    }

    public void a(byte byte0)
        throws IOException
    {
        if (c == b)
        {
            b();
        }
        byte abyte0[] = a;
        int i = c;
        c = i + 1;
        abyte0[i] = byte0;
        d = d + 1;
    }

    public void a(int i)
        throws IOException
    {
        a((byte)i);
    }

    public void a(int i, int j)
        throws IOException
    {
        b(av.a(i, j));
    }

    public void a(int i, long l)
        throws IOException
    {
        a(i, 0);
        a(l);
    }

    public void a(int i, String s)
        throws IOException
    {
        a(i, 2);
        a(s);
    }

    public void a(long l)
        throws IOException
    {
        b(l);
    }

    public void a(String s)
        throws IOException
    {
        s = s.getBytes("UTF-8");
        b(s.length);
        a(((byte []) (s)));
    }

    public void a(byte abyte0[])
        throws IOException
    {
        a(abyte0, 0, abyte0.length);
    }

    public void a(byte abyte0[], int i, int j)
        throws IOException
    {
        if (b - c >= j)
        {
            System.arraycopy(abyte0, i, a, c, j);
            c = c + j;
            d = d + j;
            return;
        }
        int k = b - c;
        System.arraycopy(abyte0, i, a, c, k);
        i += k;
        j -= k;
        c = b;
        d = k + d;
        b();
        if (j <= b)
        {
            System.arraycopy(abyte0, i, a, 0, j);
            c = j;
        } else
        {
            e.write(abyte0, i, j);
        }
        d = d + j;
    }

    public void b(int i)
        throws IOException
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                a(i);
                return;
            }
            a(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    public void b(long l)
        throws IOException
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                a((int)l);
                return;
            }
            a((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }
}
