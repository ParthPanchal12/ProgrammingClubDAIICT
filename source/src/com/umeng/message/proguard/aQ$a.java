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

// Referenced classes of package com.umeng.message.proguard:
//            aQ, aJ

private class <init> extends BroadcastReceiver
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

    public void a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        aJ.c("AnnouncementControl", (new StringBuilder()).append("AnnouncementControl--->[start][targetTime:").append(aQ.a(l)).append("][interval:").append(0xa4cb80L).append(" ms]").toString());
        AlarmManager alarmmanager = (AlarmManager)b.getSystemService("alarm");
        Intent intent = new Intent("action_announcement_message");
        intent.setPackage(d);
        alarmmanager.setRepeating(1, l, 0xa4cb80L, PendingIntent.getBroadcast(aQ.b(a), 0xa274a7e, intent, 0x8000000));
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

    private r(aQ aq, Context context)
    {
        a = aq;
        super();
        c = null;
        d = null;
        b = context;
        d = context.getPackageName();
        c = new IntentFilter();
        c.addAction("action_announcement_message");
        context.registerReceiver(this, c);
    }

    c(aQ aq, Context context, c c1)
    {
        this(aq, context);
    }
}
