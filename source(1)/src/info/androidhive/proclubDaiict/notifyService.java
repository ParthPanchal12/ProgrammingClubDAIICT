// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.io.PrintStream;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MainActivity

public class notifyService
{

    private NotificationManager mManager;

    public notifyService()
    {
    }

    public void creteNotification(Context context, String s)
    {
        System.out.println((new StringBuilder()).append("noti ").append(s).toString());
        mManager = (NotificationManager)context.getSystemService("notification");
        Object obj = new Intent(context, info/androidhive/proclubDaiict/MainActivity);
        Notification notification = new Notification(0x7f020005, s, System.currentTimeMillis());
        notification.defaults = notification.defaults | 2;
        notification.flags = notification.flags | 1;
        notification.ledARGB = 0xff00ff00;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        ((Intent) (obj)).addFlags(0x4000000);
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
        notification.flags = notification.flags | 0x10;
        notification.setLatestEventInfo(context, s, "Coding time!!!", ((PendingIntent) (obj)));
        mManager.notify(0, notification);
    }
}
