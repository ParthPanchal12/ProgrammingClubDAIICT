// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;


// Referenced classes of package com.umeng.message:
//            UTrack

class c
    implements Runnable
{

    final String a;
    final int b;
    final long c;
    final UTrack d;

    public void run()
    {
        UTrack.a(d, a, b, c);
    }

    (UTrack utrack, String s, int i, long l)
    {
        d = utrack;
        a = s;
        b = i;
        c = l;
        super();
    }
}
