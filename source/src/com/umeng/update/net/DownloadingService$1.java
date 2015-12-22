// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import u.upd.a;
import u.upd.b;
import u.upd.l;

// Referenced classes of package com.umeng.update.net:
//            DownloadingService, j, c

class a extends Handler
{

    final DownloadingService a;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 5 6: default 28
    //                   5 29
    //                   6 471;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        a a1;
        int i;
        a1 = (a)message.obj;
        i = message.arg2;
        String s;
        Intent intent;
        PendingIntent pendingintent;
        s = message.getData().getString("filename");
        com.umeng.update.net.j.a(s, 39, -1, -1);
        b.c(com.umeng.update.net.DownloadingService.a(), "Cancel old notification....");
        intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        intent.setDataAndType(Uri.fromFile(new File(s)), "application/vnd.android.package-archive");
        pendingintent = PendingIntent.getActivity(com.umeng.update.net.DownloadingService.b(a), 0, intent, 0x8000000);
        if (!a1.a) goto _L5; else goto _L4
_L4:
        message = new Notification(0x1080082, com.umeng.update.net.DownloadingService.b(a).getString(l.m(com.umeng.update.net.DownloadingService.b(a))), System.currentTimeMillis());
        message.setLatestEventInfo(com.umeng.update.net.DownloadingService.b(a), a1.a, com.umeng.update.net.DownloadingService.b(a).getString(l.m(com.umeng.update.net.DownloadingService.b(a))), pendingintent);
_L8:
        boolean flag;
        message.flags = 16;
        com.umeng.update.net.DownloadingService.a(a, (NotificationManager)a.getSystemService("notification"));
        DownloadingService.c(a).notify(i + 1, message);
        b.c(com.umeng.update.net.DownloadingService.a(), "Show new  notification....");
        flag = com.umeng.update.net.DownloadingService.a(a).a(com.umeng.update.net.DownloadingService.b(a));
        b.c(com.umeng.update.net.DownloadingService.a(), String.format("isAppOnForeground = %1$B", new Object[] {
            Boolean.valueOf(flag)
        }));
        if (!flag) goto _L7; else goto _L6
_L6:
        if (!a1.a)
        {
            DownloadingService.c(a).cancel(i + 1);
            com.umeng.update.net.DownloadingService.b(a).startActivity(intent);
        }
_L7:
        b.a(com.umeng.update.net.DownloadingService.a(), String.format("%1$10s downloaded. Saved to: %2$s", new Object[] {
            a1.a, s
        }));
        return;
_L5:
        try
        {
            message = new Notification(0x1080082, com.umeng.update.net.DownloadingService.b(a).getString(l.k(com.umeng.update.net.DownloadingService.b(a))), System.currentTimeMillis());
            message.setLatestEventInfo(com.umeng.update.net.DownloadingService.b(a), a1.a, com.umeng.update.net.DownloadingService.b(a).getString(l.k(com.umeng.update.net.DownloadingService.b(a))), pendingintent);
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            b.b(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("can not install. ")).append(message.getMessage()).toString());
            DownloadingService.c(a).cancel(i + 1);
            return;
        }
          goto _L8
_L3:
        a a2 = (a)message.obj;
        int k = message.arg2;
        message = message.getData().getString("filename");
        DownloadingService.c(a).cancel(k);
        Object obj = new Notification(0x1080081, com.umeng.update.net.DownloadingService.b(a).getString(l.n(com.umeng.update.net.DownloadingService.b(a))), System.currentTimeMillis());
        Object obj1 = PendingIntent.getActivity(com.umeng.update.net.DownloadingService.b(a), 0, new Intent(), 0x8000000);
        ((Notification) (obj)).setLatestEventInfo(com.umeng.update.net.DownloadingService.b(a), u.upd.a.v(com.umeng.update.net.DownloadingService.b(a)), com.umeng.update.net.DownloadingService.b(a).getString(l.n(com.umeng.update.net.DownloadingService.b(a))), ((PendingIntent) (obj1)));
        DownloadingService.c(a).notify(k + 1, ((Notification) (obj)));
        obj = message.replace(".patch", ".apk");
        obj1 = DeltaUpdate.a(a);
        c c1 = com.umeng.update.net.DownloadingService.a(a);
        c1.getClass();
        (new a(c1, com.umeng.update.net.DownloadingService.b(a), k, a2, ((String) (obj)))).a(new String[] {
            obj1, obj, message
        });
        return;
    }

    (DownloadingService downloadingservice)
    {
        a = downloadingservice;
        super();
    }
}
