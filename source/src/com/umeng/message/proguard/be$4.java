// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            be, aJ

class a
    implements Runnable
{

    final be a;

    public void run()
    {
        try
        {
            a.disconnect(a.b());
            aJ.c("HttpChunked", "http chunked closing");
            a.d();
            aJ.c("HttpChunked", "http chunked closed");
            be.a(a);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    (be be1)
    {
        a = be1;
        super();
    }
}
