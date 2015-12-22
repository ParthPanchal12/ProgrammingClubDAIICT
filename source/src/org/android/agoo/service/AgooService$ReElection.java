// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.bs;
import com.umeng.message.proguard.bz;
import java.util.Random;

// Referenced classes of package org.android.agoo.service:
//            AgooService

private class g extends BroadcastReceiver
{

    private static final int b = 0x2b80359;
    private static final String c = "agoo_action_re_election";
    final AgooService a;
    private IntentFilter d;
    private PendingIntent e;
    private Intent f;
    private volatile boolean g;

    private void a()
    {
        try
        {
            if (g)
            {
                return;
            }
        }
        catch (Throwable throwable)
        {
            return;
        }
        d = new IntentFilter();
        d.addAction("agoo_action_re_election");
        AgooService.h(a).registerReceiver(this, d);
        return;
    }

    static boolean a(d d1, boolean flag)
    {
        d1.g = flag;
        return flag;
    }

    public void destory()
    {
        try
        {
            if (AgooService.l(a) != null)
            {
                a.unregisterReceiver(this);
            }
            if (e != null)
            {
                e.cancel();
            }
            if (AgooService.j(a) != null)
            {
                AgooService.j(a).cancel(e);
            }
            e = null;
            AgooService.a(a, null);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (TextUtils.equals("agoo_action_re_election", intent.getAction()))
            {
                bz.a(new Runnable(context) {

                    final Context a;
                    final AgooService.ReElection b;

                    public void run()
                    {
                        aJ.c("AgooService", (new StringBuilder()).append("election---onReceive--->[current-thread-name:").append(Thread.currentThread().getName()).append("][").append(bs.a(System.currentTimeMillis())).append("] ").toString());
                        AgooService.a(b.a, a.getPackageName(), "ERROR_NEED_ELECTION");
                        AgooService.ReElection.a(b, false);
                    }

            
            {
                b = AgooService.ReElection.this;
                a = context;
                super();
            }
                });
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.e("AgooService", "onReceive", context);
        }
    }

    public void start()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i;
        long l1;
        g = true;
        a();
        f = new Intent("agoo_action_re_election");
        f.setPackage(AgooService.c(a));
        i = (new Random()).nextInt(120);
        l1 = System.currentTimeMillis();
        long l2 = i + 1320;
        long l;
        l = aI.c(AgooService.i(a));
        aJ.c("AgooService", (new StringBuilder()).append("re_election_start[timeout:").append(l).append("]").toString());
        Object obj;
        if (l <= System.currentTimeMillis() + 0x1b7740L)
        {
            l = l1 + l2 * 60L * 1000L;
        }
        if (e != null)
        {
            e.cancel();
            AgooService.j(a).cancel(e);
        }
        e = PendingIntent.getBroadcast(AgooService.k(a), 0x2b80359, f, 0x8000000);
        aJ.c("AgooService", (new StringBuilder()).append("election next time[current-thread-name:").append(Thread.currentThread().getName()).append("][").append(bs.a(l)).append("] ").toString());
        AgooService.j(a).set(1, l, e);
        continue; /* Loop/switch isn't completed */
        obj;
        aJ.e("AgooService", "ReElection start", ((Throwable) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public _cls1.a(AgooService agooservice)
    {
        a = agooservice;
        super();
        d = null;
        e = null;
        f = null;
        g = false;
        try
        {
            g = false;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AgooService agooservice)
        {
            return;
        }
    }
}
