// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import java.io.File;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0 extends BroadcastReceiver
{

    final MyMainActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        int i;
        intent.getAction();
        i = intent.getIntExtra("level", 0);
        Log.e("qqq", (new StringBuilder("intLevel=")).append(i).toString());
        if (i >= 35 || MyMainActivity.access$17(MyMainActivity.this) != 0) goto _L2; else goto _L1
_L1:
        context = MyMainActivity.this;
        MyMainActivity.access$18(context, MyMainActivity.access$17(context) + 1);
        context = null;
        intent = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        context = intent;
_L3:
        if (context == null)
        {
            context = new Notification();
            context.flags = 16;
            context.icon = 0x7f020115;
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(MyMainActivity.access$19(MyMainActivity.this)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
            context.contentIntent = PendingIntent.getActivity(MyMainActivity.this, 52, intent, 0x8000000);
            context.contentView = new RemoteViews(getPackageName(), 0x7f030077);
            MyMainActivity.access$20(MyMainActivity.this).notify(52, context);
        }
        return;
        intent;
        intent.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        MyMainActivity.access$20(MyMainActivity.this).cancel(52);
        return;
    }

    ndException()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
