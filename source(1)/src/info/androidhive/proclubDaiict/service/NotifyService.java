// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import info.androidhive.proclubDaiict.SecondActivity;

public class NotifyService extends Service
{
    public class ServiceBinder extends Binder
    {

        final NotifyService this$0;

        NotifyService getService()
        {
            return NotifyService.this;
        }

        public ServiceBinder()
        {
            this$0 = NotifyService.this;
            super();
        }
    }


    public static final String INTENT_NOTIFY = "info.androidhive.slidingmenu.service.INTENT_NOTIFY";
    private static final int NOTIFICATION = 123;
    private final IBinder mBinder = new ServiceBinder();
    private NotificationManager mNM;

    public NotifyService()
    {
    }

    private void showNotification(String s)
    {
        Notification notification = new Notification(0x1080027, s, System.currentTimeMillis());
        notification.setLatestEventInfo(this, s, s, PendingIntent.getActivity(this, 0, new Intent(this, info/androidhive/proclubDaiict/SecondActivity), 0));
        notification.flags = notification.flags | 0x10;
        mNM.notify(123, notification);
        stopSelf();
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onCreate()
    {
        Log.i("NotifyService", "onCreate()");
        mNM = (NotificationManager)getSystemService("notification");
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.i("LocalService", (new StringBuilder()).append("Received start id ").append(j).append(": ").append(intent).toString());
        if (intent.getBooleanExtra("info.androidhive.slidingmenu.service.INTENT_NOTIFY", false))
        {
            showNotification(intent.getStringExtra("Details"));
        }
        return 2;
    }
}
