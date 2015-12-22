// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import com.umeng.message.proguard.aP;
import com.umeng.message.proguard.bz;

// Referenced classes of package org.android.agoo.service:
//            AgooService

class e.Stub extends e.Stub
{

    final AgooService a;

    public boolean ping()
        throws RemoteException
    {
        if (AgooService.a(a) == null)
        {
            return false;
        } else
        {
            return AgooService.a(a).f();
        }
    }

    public void probe()
        throws RemoteException
    {
        bz.a(new Runnable() {

            final AgooService._cls1 a;

            public void run()
            {
                aJ.c("AgooService", (new StringBuilder()).append("messageServiceBinder probe--->[thread_name:").append(Thread.currentThread().getName()).append("]").toString());
                String s = aI.d(AgooService.b(a.a));
                if (!TextUtils.isEmpty(s) && TextUtils.equals(AgooService.c(a.a), s) && AgooService.a(a.a) != null && AgooService.a(a.a).f())
                {
                    aJ.c("AgooService", "messageService connect[ok]");
                    return;
                }
                if (TextUtils.isEmpty(AgooService.d(a.a)) && !TextUtils.equals(AgooService.d(a.a), AgooService.e(a.a).getPackageName()))
                {
                    aN.a(AgooService.f(a.a), AgooService.d(a.a));
                }
                aJ.c("AgooService", "messageServiceBinder[need_election]");
                AgooService.a(a.a, AgooService.g(a.a).getPackageName(), "ERROR_NEED_ELECTION");
            }

            
            {
                a = AgooService._cls1.this;
                super();
            }
        });
    }

    _cls1.a(AgooService agooservice)
    {
        a = agooservice;
        super();
    }
}
