// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import com.umeng.message.proguard.aP;
import com.umeng.message.proguard.aR;
import com.umeng.message.proguard.aS;
import com.umeng.message.proguard.bs;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.bz;
import java.util.Iterator;
import java.util.Random;
import org.android.agoo.client.BaseRegistrar;
import org.android.agoo.client.IntentHelper;
import org.android.agoo.proc.b;
import org.json.JSONException;
import org.json.JSONObject;

public class AgooService extends b
    implements aR
{
    private class ReElection extends BroadcastReceiver
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

        static boolean a(ReElection reelection, boolean flag)
        {
            reelection.g = flag;
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
                    bz.a(new Runnable(this, context) {

                        final Context a;
                        final ReElection b;

                        public void run()
                        {
                            aJ.c("AgooService", (new StringBuilder()).append("election---onReceive--->[current-thread-name:").append(Thread.currentThread().getName()).append("][").append(bs.a(System.currentTimeMillis())).append("] ").toString());
                            AgooService.a(b.a, a.getPackageName(), "ERROR_NEED_ELECTION");
                            ReElection.a(b, false);
                        }

            
            {
                b = reelection;
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
            int i1;
            long l2;
            g = true;
            a();
            f = new Intent("agoo_action_re_election");
            f.setPackage(AgooService.c(a));
            i1 = (new Random()).nextInt(120);
            l2 = System.currentTimeMillis();
            long l3 = i1 + 1320;
            long l1;
            l1 = aI.c(AgooService.i(a));
            aJ.c("AgooService", (new StringBuilder()).append("re_election_start[timeout:").append(l1).append("]").toString());
            Object obj;
            if (l1 <= System.currentTimeMillis() + 0x1b7740L)
            {
                l1 = l2 + l3 * 60L * 1000L;
            }
            if (e != null)
            {
                e.cancel();
                AgooService.j(a).cancel(e);
            }
            e = PendingIntent.getBroadcast(AgooService.k(a), 0x2b80359, f, 0x8000000);
            aJ.c("AgooService", (new StringBuilder()).append("election next time[current-thread-name:").append(Thread.currentThread().getName()).append("][").append(bs.a(l1)).append("] ").toString());
            AgooService.j(a).set(1, l1, e);
            continue; /* Loop/switch isn't completed */
            obj;
            aJ.e("AgooService", "ReElection start", ((Throwable) (obj)));
            if (true) goto _L1; else goto _L3
_L3:
            obj;
            throw obj;
        }

        public ReElection()
        {
            a = AgooService.this;
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


    private static final String b = "AgooService";
    private static final String c = "head";
    private volatile aP d;
    private volatile long e;
    private volatile ReElection f;
    private volatile AlarmManager g;
    private volatile String h;
    private volatile String i;
    private volatile String j;
    private volatile String k;
    private volatile String l;
    private volatile String m;
    private final IMessageService.Stub n = new IMessageService.Stub() {

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
            bz.a(new Runnable(this) {

                final _cls1 a;

                public void run()
                {
                    aJ.c("AgooService", (new StringBuilder()).append("messageServiceBinder probe--->[thread_name:").append(Thread.currentThread().getName()).append("]").toString());
                    String s = aI.d(org.android.agoo.service.AgooService.b(a.a));
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
                a = _pcls1;
                super();
            }
            });
        }

            
            {
                a = AgooService.this;
                super();
            }
    };

    public AgooService()
    {
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
    }

    static AlarmManager a(AgooService agooservice, AlarmManager alarmmanager)
    {
        agooservice.g = alarmmanager;
        return alarmmanager;
    }

    static aP a(AgooService agooservice)
    {
        return agooservice.d;
    }

    private void a(String s, Bundle bundle)
    {
        try
        {
            Intent intent = new Intent();
            intent.setAction("org.agoo.android.intent.action.RECEIVE");
            intent.setPackage(s);
            intent.putExtras(bundle);
            intent.putExtra("message_source", "apoll");
            intent.addFlags(32);
            a.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aJ.d("AgooService", "handleMessage", s);
        }
    }

    private void a(String s, String s1)
    {
        try
        {
            Intent intent = IntentHelper.createComandIntent(a, "error");
            intent.setPackage(s);
            intent.putExtra("error", s1);
            a.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aJ.d("AgooService", "handleError", s);
        }
    }

    static void a(AgooService agooservice, String s, String s1)
    {
        agooservice.a(s, s1);
    }

    static Context b(AgooService agooservice)
    {
        return agooservice.a;
    }

    static String c(AgooService agooservice)
    {
        return agooservice.l;
    }

    static String d(AgooService agooservice)
    {
        return agooservice.m;
    }

    static Context e(AgooService agooservice)
    {
        return agooservice.a;
    }

    static Context f(AgooService agooservice)
    {
        return agooservice.a;
    }

    private boolean f()
    {
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        aJ.c("AgooService", "mContext == null");
        return false;
        h = aI.n(a);
        k = aI.q(a);
        i = aI.p(a);
        j = aI.o(a);
        if (!TextUtils.isEmpty(k))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        a(l, "ERROR_DEVICETOKEN_NULL");
        return false;
        try
        {
            if (d == null)
            {
                d = new aS(a, this);
            }
            d.b(h);
            d.a(i);
            d.c(j);
            d.d(k);
        }
        catch (Throwable throwable)
        {
            return false;
        }
        return true;
    }

    static Context g(AgooService agooservice)
    {
        return agooservice.a;
    }

    private boolean g()
    {
        if (!BaseRegistrar.isRegistered(a))
        {
            return true;
        }
        String s;
        s = aI.d(a);
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_36;
        }
        aJ.c("AgooService", "[currentSudoPack==null]");
        return true;
        if (TextUtils.equals(l, s))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        aJ.c("AgooService", (new StringBuilder()).append("[currentSudoPack(").append(s).append(")!=appPackage(").append(l).append(")]").toString());
        return true;
        Throwable throwable;
        throwable;
        return false;
    }

    static Context h(AgooService agooservice)
    {
        return agooservice.a;
    }

    private void h()
    {
        try
        {
            if (d != null)
            {
                d.e();
            }
            if (f != null)
            {
                f.start();
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    static Context i(AgooService agooservice)
    {
        return agooservice.a;
    }

    static AlarmManager j(AgooService agooservice)
    {
        return agooservice.g;
    }

    static Context k(AgooService agooservice)
    {
        return agooservice.a;
    }

    static Context l(AgooService agooservice)
    {
        return agooservice.a;
    }

    protected void a(Intent intent, int i1, int j1)
    {
        String s;
        String s1;
        try
        {
            if (!f())
            {
                a();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
        s = intent.getAction();
        s1 = IntentHelper.getAgooStart(a);
        aJ.c("AgooService", (new StringBuilder()).append("action [").append(s).append("]").toString());
        if (!TextUtils.equals(s, s1))
        {
            break MISSING_BLOCK_LABEL_128;
        }
        intent = intent.getStringExtra("method");
        aJ.c("AgooService", (new StringBuilder()).append("startCommand method--->[").append(intent).append("]").toString());
        if (!TextUtils.isEmpty(intent) && TextUtils.equals(intent, "start"))
        {
            h();
            return;
        }
        a();
    }

    protected void b()
    {
        aJ.c("AgooService", (new StringBuilder()).append("create--->[current-thread-name:").append(Thread.currentThread().getName()).append("]").toString());
        try
        {
            l = a.getPackageName();
            g = (AlarmManager)getSystemService("alarm");
            if (android.os.Build.VERSION.SDK_INT < 18)
            {
                startForeground(-1469, new Notification());
            }
            new Handler(Looper.getMainLooper());
            e = System.currentTimeMillis();
            f = new ReElection();
            d = new aS(a, this);
            bx.a(a);
            return;
        }
        catch (Throwable throwable)
        {
            aJ.d("AgooService", "create", throwable);
        }
    }

    protected void c()
    {
        try
        {
            aJ.c("AgooService", (new StringBuilder()).append("AgooService[current-thread-name:").append(Thread.currentThread().getName()).append("]").toString());
            aJ.c("AgooService", "AgooService destroying");
            aN.a(a, e);
            if (d != null)
            {
                d.g();
            }
            if (f != null)
            {
                f.destory();
            }
            aJ.c("AgooService", "AgooService destroyed");
            return;
        }
        catch (Throwable throwable)
        {
            aJ.d("AgooService", "destroy", throwable);
        }
    }

    protected void d()
    {
        try
        {
            aN.d(a);
            if (g())
            {
                a(l, "ERROR_NEED_ELECTION");
                a();
                return;
            }
        }
        catch (Throwable throwable)
        {
            return;
        }
        if (!f())
        {
            a();
            return;
        }
        h();
        return;
    }

    protected void e()
    {
        try
        {
            aN.d(a);
            if (g())
            {
                a(l, "ERROR_NEED_ELECTION");
                a();
                return;
            }
        }
        catch (Throwable throwable)
        {
            return;
        }
        if (!f())
        {
            a();
            return;
        }
        h();
        return;
    }

    public final IBinder onBind(Intent intent)
    {
        String s = intent.getAction();
        aJ.c("AgooService", (new StringBuilder()).append("onBind:[").append(s).append("]").toString());
        if (TextUtils.isEmpty(s) || !TextUtils.equals(s, "org.agoo.android.intent.action.PING"))
        {
            break MISSING_BLOCK_LABEL_68;
        }
        m = intent.getPackage();
        intent = n;
        return intent;
        intent;
        return null;
    }

    public void onHandleError(String s)
    {
        a(a.getPackageName(), s);
    }

    public final void onHandleMessage(String s)
    {
        Object obj;
        String s1;
        JSONObject jsonobject;
        Object obj1;
        String s2;
        String s4;
        try
        {
            if (TextUtils.isEmpty(s))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aN.d(a, s);
            aJ.d("AgooService", (new StringBuilder()).append("JSONException parse errormessage content[").append(s).append("]").toString(), ((Throwable) (obj)));
            return;
        }
        aJ.c("AgooService", (new StringBuilder()).append("onHandleMessage--->[current-thread-name:").append(Thread.currentThread().getName()).append("]").toString());
        obj = new Bundle();
        jsonobject = new JSONObject(s);
        s1 = jsonobject.getString("pack");
        obj1 = jsonobject.getString("id");
        s2 = jsonobject.getString("type");
        s4 = jsonobject.getString("body");
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(((CharSequence) (obj1))) || TextUtils.isEmpty(s4))
        {
            aN.d(a, s);
            return;
        }
        ((Bundle) (obj)).putString("id", ((String) (obj1)));
        ((Bundle) (obj)).putString("type", s2);
        ((Bundle) (obj)).putString("body", s4);
        jsonobject = jsonobject.getJSONObject("head");
        obj1 = jsonobject.keys();
_L1:
        boolean flag = ((Iterator) (obj1)).hasNext();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        String s3 = (String)((Iterator) (obj1)).next();
        if (!TextUtils.isEmpty(s3))
        {
            String s5 = jsonobject.getString(s3);
            if (!TextUtils.isEmpty(s5))
            {
                ((Bundle) (obj)).putString(s3, s5);
            }
        }
          goto _L1
        JSONException jsonexception;
        jsonexception;
        aJ.e("AgooService", "JSONException parse error[message header]", jsonexception);
          goto _L1
        a(s1, ((Bundle) (obj)));
        return;
    }
}
