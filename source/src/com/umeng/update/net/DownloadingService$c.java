// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.widget.Toast;
import java.util.Map;
import u.upd.a;
import u.upd.b;
import u.upd.l;

// Referenced classes of package com.umeng.update.net:
//            DownloadingService, c, f

class a extends Handler
{

    final DownloadingService a;

    public void handleMessage(Message message)
    {
        b.c(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("IncomingHandler(msg.what:")).append(message.what).append(" msg.arg1:").append(message.arg1).append(" msg.arg2:").append(message.arg2).append(" msg.replyTo:").append(message.replyTo).toString());
        Object obj;
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 4: // '\004'
            obj = message.getData();
            break;
        }
        b.c(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("IncomingHandler(msg.getData():")).append(obj).toString());
        obj = com.umeng.update.net.a(((android.os.Bundle) (obj)));
        if (com.umeng.update.net.DownloadingService.a(a).a(((a) (obj)), DownloadingService.r, message.replyTo))
        {
            b.a(com.umeng.update.net.DownloadingService.a(), (new StringBuilder(String.valueOf(((a) (obj)).a))).append(" is already in downloading list. ").toString());
            int i = com.umeng.update.net.DownloadingService.a(a).b(((a) (obj)));
            if (i != -1 && ((a)com.umeng.update.net.DownloadingService.b().get(i)).a == null)
            {
                message = com.umeng.update.net.f.a(i, "continue");
                obj = new Intent(com.umeng.update.net.DownloadingService.b(a), com/umeng/update/net/DownloadingService);
                ((Intent) (obj)).putExtra("com.umeng.broadcast.download.msg", message);
                com.umeng.update.net.DownloadingService.a(a).a(a, ((Intent) (obj)));
                return;
            }
            Toast.makeText(com.umeng.update.net.DownloadingService.b(a), l.b(com.umeng.update.net.DownloadingService.b(a)), 0).show();
            obj = Message.obtain();
            obj.what = 2;
            obj.arg1 = 2;
            obj.arg2 = 0;
            try
            {
                message.replyTo.send(((Message) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
            }
            return;
        }
        if (u.upd.a.l(a.getApplicationContext()))
        {
            DownloadingService.c().put(obj, message.replyTo);
            Message message1 = Message.obtain();
            message1.what = 1;
            message1.arg1 = 1;
            message1.arg2 = 0;
            try
            {
                message.replyTo.send(message1);
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
            }
            com.umeng.update.net.DownloadingService.a(a, ((a) (obj)));
            return;
        }
        Toast.makeText(com.umeng.update.net.DownloadingService.b(a), l.a(com.umeng.update.net.DownloadingService.b(a)), 0).show();
        obj = Message.obtain();
        obj.what = 2;
        obj.arg1 = 4;
        obj.arg2 = 0;
        try
        {
            message.replyTo.send(((Message) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            message.printStackTrace();
        }
    }

    (DownloadingService downloadingservice)
    {
        a = downloadingservice;
        super();
    }
}
