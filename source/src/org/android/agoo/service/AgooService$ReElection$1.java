// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.content.Context;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.bs;

// Referenced classes of package org.android.agoo.service:
//            AgooService

class a
    implements Runnable
{

    final Context a;
    final b b;

    public void run()
    {
        aJ.c("AgooService", (new StringBuilder()).append("election---onReceive--->[current-thread-name:").append(Thread.currentThread().getName()).append("][").append(bs.a(System.currentTimeMillis())).append("] ").toString());
        AgooService.a(b.b, a.getPackageName(), "ERROR_NEED_ELECTION");
        a(b, false);
    }

    ( , Context context)
    {
        b = ;
        a = context;
        super();
    }
}
