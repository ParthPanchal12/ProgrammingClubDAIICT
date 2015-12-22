// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

// Referenced classes of package com.umeng.message.proguard:
//            g, w

public static final class e extends OutputStream
{

    private static final byte a[] = new byte[0];
    private final int b;
    private final ArrayList c;
    private int d;
    private byte e[];
    private int f;

    private void a(int i)
    {
        c.add(new w(e));
        d = d + e.length;
        e = new byte[Math.max(b, Math.max(i, d >>> 1))];
        f = 0;
    }

    private byte[] a(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[i];
        System.arraycopy(abyte0, 0, abyte1, 0, Math.min(abyte0.length, i));
        return abyte1;
    }

    private void d()
    {
        if (f < e.length)
        {
            if (f > 0)
            {
                byte abyte0[] = a(e, f);
                c.add(new w(abyte0));
            }
        } else
        {
            c.add(new w(e));
            e = a;
        }
        d = d + f;
        f = 0;
    }

    public g a()
    {
        this;
        JVM INSTR monitorenter ;
        g g1;
        d();
        g1 = g.a(c);
        this;
        JVM INSTR monitorexit ;
        return g1;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(OutputStream outputstream)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        g ag[];
        byte abyte0[];
        int j;
        ag = (g[])c.toArray(new g[c.size()]);
        abyte0 = e;
        j = f;
        this;
        JVM INSTR monitorexit ;
        int k = ag.length;
        for (int i = 0; i < k; i++)
        {
            ag[i].a(outputstream);
        }

        break MISSING_BLOCK_LABEL_72;
        outputstream;
        this;
        JVM INSTR monitorexit ;
        throw outputstream;
        outputstream.write(a(abyte0, j));
        return;
    }

    public int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = d;
        j = f;
        this;
        JVM INSTR monitorexit ;
        return i + j;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        c.clear();
        d = 0;
        f = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        return String.format("<ByteString.Output@%s size=%d>", new Object[] {
            Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b())
        });
    }

    public void write(int i)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        int j;
        if (f == e.length)
        {
            a(1);
        }
        abyte0 = e;
        j = f;
        f = j + 1;
        abyte0[j] = (byte)i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void write(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (j > e.length - f) goto _L2; else goto _L1
_L1:
        System.arraycopy(abyte0, i, e, f, j);
        f = f + j;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int k;
        k = e.length - f;
        System.arraycopy(abyte0, i, e, f, k);
        j -= k;
        a(j);
        System.arraycopy(abyte0, i + k, e, 0, j);
        f = j;
        if (true) goto _L4; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }


    ion(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Buffer size < 0");
        } else
        {
            b = i;
            c = new ArrayList();
            e = new byte[i];
            return;
        }
    }
}
