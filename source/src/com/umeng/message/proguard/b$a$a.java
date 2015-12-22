// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.umeng.message.proguard:
//            b

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

    (InputStream inputstream, int i)
    {
        super(inputstream);
        a = i;
    }
}
