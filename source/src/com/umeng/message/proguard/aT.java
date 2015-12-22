// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            bw

class aT
{

    private boolean a;
    private String b;

    aT(boolean flag, String s)
    {
        a = false;
        a = flag;
        b = s;
    }

    long a()
    {
        return !a ? 0x493e0L : 40000L;
    }

    long a(long l1)
    {
        l1 = bw.a(l1, b);
        if (l1 <= 2000L)
        {
            return 2000L;
        } else
        {
            return l1;
        }
    }

    long b()
    {
        return !a ? 0x1d4c0L : 20000L;
    }

    long c()
    {
        return !a ? 2000L : 1000L;
    }

    long d()
    {
        if (a)
        {
            return a(5000L);
        } else
        {
            return a(10000L);
        }
    }

    long e()
    {
        if (a)
        {
            return a(2000L);
        } else
        {
            return a(5000L);
        }
    }

    long f()
    {
        if (a)
        {
            return a(2000L);
        } else
        {
            return a(5000L);
        }
    }

    long g()
    {
        if (a)
        {
            return a(5000L);
        } else
        {
            return a(20000L);
        }
    }

    long h()
    {
        if (a)
        {
            return a(5000L);
        } else
        {
            return a(15000L);
        }
    }

    public long i()
    {
        return !a ? 40000L : 5000L;
    }

    long j()
    {
        return !a ? 10000L : 5000L;
    }

    long k()
    {
        return !a ? 10000L : 5000L;
    }

    long l()
    {
        return !a ? 0x1b7740L : 0x927c0L;
    }

    long m()
    {
        return !a ? 60000L : 10000L;
    }
}
