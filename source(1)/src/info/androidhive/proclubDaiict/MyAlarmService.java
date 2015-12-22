// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MainActivity

public class MyAlarmService extends Service
{

    private NotificationManager mManager;

    public MyAlarmService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onStart(Intent intent, int i)
    {
        super.onStart(intent, i);
        intent = getApplicationContext();
        getApplicationContext();
        mManager = (NotificationManager)intent.getSystemService("notification");
        Object obj = new Intent(getApplicationContext(), info/androidhive/proclubDaiict/MainActivity);
        intent = new Notification(0x7f020005, "This is a test message!", System.currentTimeMillis());
        ((Intent) (obj)).addFlags(0x4000000);
        obj = PendingIntent.getActivity(getApplicationContext(), 0, ((Intent) (obj)), 0x8000000);
        intent.flags = ((Notification) (intent)).flags | 0x10;
        intent.setLatestEventInfo(getApplicationContext(), "AlarmManagerDemo", "This is a test message!", ((PendingIntent) (obj)));
    }
}
