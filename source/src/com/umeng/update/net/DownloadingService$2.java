// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.Map;
import u.upd.b;

// Referenced classes of package com.umeng.update.net:
//            DownloadingService, c, b

class a
    implements a
{

    SparseArray a;
    final DownloadingService b;

    public void a(int i)
    {
        boolean flag = false;
        if (com.umeng.update.net.DownloadingService.b().indexOfKey(i) >= 0)
        {
            a a1 = (a)com.umeng.update.net.DownloadingService.b().get(i);
            long al[] = a1.a;
            int j = ((flag) ? 1 : 0);
            if (al != null)
            {
                j = ((flag) ? 1 : 0);
                if (al[1] > 0L)
                {
                    int k = (int)(((float)al[0] / (float)al[1]) * 100F);
                    j = k;
                    if (k > 100)
                    {
                        j = 99;
                    }
                }
            }
            if (!a1.a.a)
            {
                a.put(i, Long.valueOf(-1L));
                a a2 = DownloadingService.a(b).a(b, a1.b, i, j);
                a1.b = a2;
                DownloadingService.c(b).notify(i, a2.b());
            }
        }
    }

    public void a(int i, int j)
    {
        if (com.umeng.update.net.DownloadingService.b().indexOfKey(i) >= 0)
        {
            Object obj = (b)com.umeng.update.net.DownloadingService.b().get(i);
            b b1 = ((b) (obj)).b;
            long l = System.currentTimeMillis();
            if (!b1.b && l - ((Long)a.get(i)).longValue() > 500L)
            {
                a.put(i, Long.valueOf(l));
                obj = ((a) (obj)).a;
                ((a) (obj)).a(100, j, false).a((new StringBuilder(String.valueOf(String.valueOf(j)))).append("%").toString());
                DownloadingService.c(b).notify(i, ((b) (obj)).b());
            }
            u.upd.b.c(DownloadingService.a(), String.format("%3$10s Notification: mNotificationId = %1$15s\t|\tprogress = %2$15s", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), b1.b
            }));
        }
    }

    public void a(int i, Exception exception)
    {
        if (com.umeng.update.net.DownloadingService.b().indexOfKey(i) >= 0)
        {
            DownloadingService.a(b).b(com.umeng.update.net.DownloadingService.b(b), i);
        }
    }

    public void a(int i, String s)
    {
        Object obj;
        Bundle bundle;
label0:
        {
            if (com.umeng.update.net.DownloadingService.b().indexOfKey(i) >= 0)
            {
                obj = (b)com.umeng.update.net.DownloadingService.b().get(i);
                if (obj != null)
                {
                    obj = ((b) (obj)).b;
                    com.umeng.update.net.b.a(com.umeng.update.net.DownloadingService.b(b)).a(((b) (obj)).b, ((b) (obj)).b, 100);
                    bundle = new Bundle();
                    bundle.putString("filename", s);
                    if (!((b) (obj)).b.equalsIgnoreCase("delta_update"))
                    {
                        break label0;
                    }
                    s = Message.obtain();
                    s.what = 6;
                    s.arg1 = 1;
                    s.obj = obj;
                    s.arg2 = i;
                    s.setData(bundle);
                    DownloadingService.d(b).sendMessage(s);
                }
            }
            return;
        }
        s = Message.obtain();
        s.what = 5;
        s.arg1 = 1;
        s.obj = obj;
        s.arg2 = i;
        s.setData(bundle);
        DownloadingService.d(b).sendMessage(s);
        s = Message.obtain();
        s.what = 5;
        s.arg1 = 1;
        s.arg2 = i;
        s.setData(bundle);
        try
        {
            if (DownloadingService.c().get(obj) != null)
            {
                ((Messenger)DownloadingService.c().get(obj)).send(s);
            }
            DownloadingService.a(b).b(com.umeng.update.net.DownloadingService.b(b), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            DownloadingService.a(b).b(com.umeng.update.net.DownloadingService.b(b), i);
        }
    }

    (DownloadingService downloadingservice)
    {
        b = downloadingservice;
        super();
        a = new SparseArray();
    }
}
