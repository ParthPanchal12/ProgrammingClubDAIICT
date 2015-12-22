// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import info.androidhive.proclubDaiict.service.task.AlarmTask;
import java.util.Calendar;

public class ScheduleService extends Service
{
    public class ServiceBinder extends Binder
    {

        final ScheduleService this$0;

        ScheduleService getService()
        {
            return ScheduleService.this;
        }

        public ServiceBinder()
        {
            this$0 = ScheduleService.this;
            super();
        }
    }


    private final IBinder mBinder = new ServiceBinder();

    public ScheduleService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.i("ScheduleService", (new StringBuilder()).append("Received start id ").append(j).append(": ").append(intent).toString());
        return 1;
    }

    public void setAlarm(Calendar calendar, String s)
    {
        (new AlarmTask(this, calendar, s)).run();
    }
}
