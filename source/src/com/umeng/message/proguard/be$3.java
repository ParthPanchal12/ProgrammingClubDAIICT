// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            be, aJ

class a
    implements Runnable
{

    final int a;
    final be b;

    public void run()
    {
        try
        {
            b.f();
            b.g();
            aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect[").append(a).append("] connection disconnecting").toString());
            b.c();
            aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect[").append(a).append("] connection disconnected").toString());
            b.h();
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    (be be1, int i)
    {
        b = be1;
        a = i;
        super();
    }
}
