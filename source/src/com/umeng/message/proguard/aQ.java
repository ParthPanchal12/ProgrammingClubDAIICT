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
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.client.AgooSettings;
import org.android.agoo.net.mtop.IMtopAsynClient;
import org.android.agoo.net.mtop.MtopAsyncClientV3;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopResponseHandler;

// Referenced classes of package com.umeng.message.proguard:
//            aP, aJ, bw, aR

public class aQ extends aP
{
    private class a extends BroadcastReceiver
    {

        final aQ a;
        private Context b;
        private IntentFilter c;
        private String d;

        public void a()
        {
            if (this != null && b != null)
            {
                b.unregisterReceiver(this);
            }
        }

        public void a(long l1)
        {
            this;
            JVM INSTR monitorenter ;
            aJ.c("AnnouncementControl", (new StringBuilder()).append("AnnouncementControl--->[start][targetTime:").append(aQ.a(l1)).append("][interval:").append(0xa4cb80L).append(" ms]").toString());
            AlarmManager alarmmanager = (AlarmManager)b.getSystemService("alarm");
            Intent intent = new Intent("action_announcement_message");
            intent.setPackage(d);
            alarmmanager.setRepeating(1, l1, 0xa4cb80L, PendingIntent.getBroadcast(aQ.b(a), 0xa274a7e, intent, 0x8000000));
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onReceive(Context context, Intent intent)
        {
            if ("action_announcement_message".equals(intent.getAction()))
            {
                aQ.a(a);
            }
        }

        private a(Context context)
        {
            a = aQ.this;
            super();
            c = null;
            d = null;
            b = context;
            d = context.getPackageName();
            c = new IntentFilter();
            c.addAction("action_announcement_message");
            context.registerReceiver(this, c);
        }

    }


    private static final String e = "AnnouncementControl";
    private static final String f = "action_announcement_message";
    private static final long g = 0xa4cb80L;
    private static final long h = 7200L;
    private static final String m = "ANNOUNCEMENT_NEWEST_STORAGE";
    private static final String n = "ANNOUNCEMENT_NEWEST_ID";
    private volatile Context i;
    private AtomicBoolean j;
    private volatile a k;
    private IMtopAsynClient l;

    public aQ(Context context, aR ar)
    {
        super(context, ar);
        j = new AtomicBoolean(false);
        k = null;
        i = context;
        j.set(false);
        k = new a(context);
        l = new MtopAsyncClientV3();
        l.setBaseUrl(AgooSettings.getPullUrl(context));
    }

    private static long a(int i1, int j1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, i1);
        calendar.set(12, j1);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    static String a(long l1)
    {
        return b(l1);
    }

    private String a(Context context)
    {
        return context.getSharedPreferences("ANNOUNCEMENT_NEWEST_STORAGE", 4).getString("ANNOUNCEMENT_NEWEST_ID", null);
    }

    static void a(aQ aq)
    {
        aq.i();
    }

    static Context b(aQ aq)
    {
        return aq.i;
    }

    private static String b(long l1)
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Long.valueOf(l1));
    }

    private void i()
    {
        MtopRequest mtoprequest = new MtopRequest();
        mtoprequest.setApi("mtop.push.msg.announcement");
        mtoprequest.setV("5.0");
        mtoprequest.setAppKey(super.b());
        mtoprequest.setAppSecret(super.a());
        mtoprequest.setTtId(super.c());
        String s = a(i);
        if (!TextUtils.isEmpty(s))
        {
            aJ.c("AnnouncementControl", (new StringBuilder()).append("synMessage newestId[").append(s).append("]").toString());
            mtoprequest.putParams("Newest_id", s);
        }
        l.getV3(a, mtoprequest, new MtopResponseHandler() {

            final aQ a;

            public void onFailure(Throwable throwable, String s1)
            {
                a.e(s1);
            }

            public void onSuccess(String s1)
            {
                a.f(s1);
            }

            
            {
                a = aQ.this;
                super();
            }
        });
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        if (!j.get()) goto _L2; else goto _L1
_L1:
        aJ.c("AnnouncementControl", "AnnouncementControl [started]");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l1 = a(23, 30);
        long l2 = bw.a(7200L, null);
        k.a(l1 + l2);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean f()
    {
        return false;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        aJ.c("AnnouncementControl", "AnnouncementControl--->[destroy]");
        h();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void h()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = j.get();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        aJ.c("AnnouncementControl", "AnnouncementControl--->[stop]");
        j.set(false);
        if (k != null)
        {
            k.a();
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
