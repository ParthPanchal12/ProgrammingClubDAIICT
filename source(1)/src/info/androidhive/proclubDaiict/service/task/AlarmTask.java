// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict.service.task;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import info.androidhive.proclubDaiict.service.NotifyService;
import java.util.Calendar;

public class AlarmTask
    implements Runnable
{

    private final AlarmManager am;
    private final Context context;
    private final Calendar date;
    String details;

    public AlarmTask(Context context1, Calendar calendar, String s)
    {
        context = context1;
        details = s;
        am = (AlarmManager)context1.getSystemService("alarm");
        date = calendar;
    }

    public void run()
    {
        Object obj = new Intent(context, info/androidhive/proclubDaiict/service/NotifyService);
        ((Intent) (obj)).putExtra("info.androidhive.slidingmenu.service.INTENT_NOTIFY", true);
        ((Intent) (obj)).putExtra("Details", details);
        obj = PendingIntent.getService(context, 0, ((Intent) (obj)), 0);
        am.set(1, date.getTimeInMillis(), ((PendingIntent) (obj)));
    }
}
