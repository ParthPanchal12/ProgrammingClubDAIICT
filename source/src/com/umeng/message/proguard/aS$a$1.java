// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.android.agoo.net.mtop.MtopHttpChunked;

// Referenced classes of package com.umeng.message.proguard:
//            aS, aJ, aN, bf

class b
    implements Runnable
{

    final Intent a;
    final Context b;
    final a c;

    private void a(long l)
    {
        aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(c.c)).append("]heart[").append(l).append(" ms]timeout--->[reconnect:").append(aS.m(c.c)).append("ms]").toString());
        aN.a(b, l, b(c));
        l = aS.j(c.c);
        if (l != -1L)
        {
            aS.d(c.c, l, "heart_connect_network_wap");
            return;
        } else
        {
            aS.d(c.c, aS.m(c.c), "heart_connect");
            return;
        }
    }

    public void run()
    {
        if (TextUtils.equals("agoo_action_heart", a.getAction()))
        {
            bf bf1 = aS.a(c.c).readyState();
            long l = System.currentTimeMillis() - aS.h(c.c);
            if (c(c) && bf1 == bf.b && aS.h(c.c) > -1L && l > c(c))
            {
                a(l);
            }
        }
    }

    Chunked(Chunked chunked, Intent intent, Context context)
    {
        c = chunked;
        a = intent;
        b = context;
        super();
    }
}
