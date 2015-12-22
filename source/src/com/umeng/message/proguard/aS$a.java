// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import org.android.agoo.net.mtop.MtopHttpChunked;

// Referenced classes of package com.umeng.message.proguard:
//            aS, aJ, bz, aN, 
//            bf

private class <init> extends BroadcastReceiver
{

    private static final String b = "agoo_action_heart";
    final aS a;
    private IntentFilter c;
    private PendingIntent d;
    private Intent e;
    private volatile boolean f;
    private volatile long g;
    private long h;

    static boolean a(r r)
    {
        return r.f;
    }

    static long b(f f1)
    {
        return f1.g;
    }

    static long c(g g1)
    {
        return g1.h;
    }

    public void a()
    {
        try
        {
            c = new IntentFilter();
            c.addAction("agoo_action_heart");
            a.a.registerReceiver(this, c);
            e = new Intent("agoo_action_heart");
            e.setPackage(aS.l(a));
            d = PendingIntent.getBroadcast(a.a, 0x6f5be, e, 0x10000000);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public void a(long l, long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f = true;
        h = l2;
        g = l1;
        aS.a(a, -1L);
        a();
        aS.n(a).cancel(d);
        aS.n(a).setRepeating(1, System.currentTimeMillis(), l, d);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        aS.a(a, -1L);
        f = false;
        aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(a)).append("]heart--->[stopping]").toString());
        if (aS.n(a) != null)
        {
            aS.n(a).cancel(d);
        }
        if (d != null)
        {
            d.cancel();
        }
        if (a.a != null)
        {
            a.a.unregisterReceiver(this);
        }
        aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(a)).append("]heart--->[stoped]").toString());
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        aJ.e("MessagePush", "heart", ((Throwable) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public void onReceive(Context context, Intent intent)
    {
        bz.a(new Runnable(intent, context) {

            final Intent a;
            final Context b;
            final aS.a c;

            private void a(long l)
            {
                aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(c.a)).append("]heart[").append(l).append(" ms]timeout--->[reconnect:").append(aS.m(c.a)).append("ms]").toString());
                aN.a(b, l, aS.a.c(c));
                l = aS.j(c.a);
                if (l != -1L)
                {
                    aS.d(c.a, l, "heart_connect_network_wap");
                    return;
                } else
                {
                    aS.d(c.a, aS.m(c.a), "heart_connect");
                    return;
                }
            }

            public void run()
            {
                if (TextUtils.equals("agoo_action_heart", a.getAction()))
                {
                    bf bf1 = aS.a(c.a).readyState();
                    long l = System.currentTimeMillis() - aS.h(c.a);
                    if (aS.a.a(c) && bf1 == bf.b && aS.h(c.a) > -1L && l > aS.a.b(c))
                    {
                        a(l);
                    }
                }
            }

            
            {
                c = aS.a.this;
                a = intent;
                b = context;
                super();
            }
        });
    }

    private _cls1.b(aS as)
    {
        a = as;
        super();
        c = null;
        d = null;
        e = null;
        f = false;
        g = -1L;
        h = -1L;
    }

    h(aS as, h h1)
    {
        this(as);
    }
}
