// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.os.SystemClock;
import org.apache.http.HttpException;

// Referenced classes of package com.umeng.message.proguard:
//            be, bf, aJ

class b
    implements Runnable
{

    final long a;
    final String b;
    final be c;

    public void run()
    {
        try
        {
            SystemClock.sleep(a);
        }
        catch (Throwable throwable) { }
        if (c.a == bf.a && !c.hasCallError())
        {
            c.callError(true);
            aJ.e("HttpChunked", (new StringBuilder()).append("http chunked connect url: [").append(b).append("] connectId:[").append(c.b()).append("] http Status code==").append(408).toString());
            c.a(408, new HttpException((new StringBuilder()).append("connectId:[").append(c.b()).append("] http Status code==").append(408).toString()));
            be.a(c);
            c.g();
        }
    }

    (be be1, long l, String s)
    {
        c = be1;
        a = l;
        b = s;
        super();
    }
}
