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
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import java.util.Map;
import u.upd.a;
import u.upd.b;
import u.upd.l;
import u.upd.n;

// Referenced classes of package com.umeng.update.net:
//            c, j

class b extends AsyncTask
{

    public int a;
    public String b;
    final c c;
    private eExecute d;
    private Context e;
    private NotificationManager f;

    protected transient Integer a(String as[])
    {
        int i = DeltaUpdate.a(as[0], as[1], as[2]) + 1;
        (new File(as[2])).delete();
        if (i == 1)
        {
            if (!n.a(new File(as[1])).equalsIgnoreCase(d.e))
            {
                u.upd.b.a(com.umeng.update.net.c.a(), "file patch error");
                return Integer.valueOf(0);
            }
            u.upd.b.a(com.umeng.update.net.c.a(), "file patch success");
        } else
        {
            u.upd.b.a(com.umeng.update.net.c.a(), "file patch error");
        }
        return Integer.valueOf(i);
    }

    protected void a(Integer integer)
    {
        if (integer.intValue() == 1)
        {
            com.umeng.update.net.j.a(b, 39, -1, -1);
            integer = new Notification(0x1080082, e.getString(l.l(e)), System.currentTimeMillis());
            Object obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).addFlags(0x10000000);
            ((Intent) (obj)).setDataAndType(Uri.fromFile(new File(b)), "application/vnd.android.package-archive");
            PendingIntent pendingintent = PendingIntent.getActivity(e, 0, ((Intent) (obj)), 0x8000000);
            integer.setLatestEventInfo(e, u.upd.a.v(e), e.getString(l.l(e)), pendingintent);
            integer.flags = 16;
            f.notify(a + 1, integer);
            if (c.a(e) && !d.h)
            {
                f.cancel(a + 1);
                e.startActivity(((Intent) (obj)));
            }
            integer = new Bundle();
            integer.putString("filename", b);
            obj = Message.obtain();
            obj.what = 5;
            obj.arg1 = 1;
            obj.arg2 = a;
            ((Message) (obj)).setData(integer);
            try
            {
                if (com.umeng.update.net.c.a(c).get(d) != null)
                {
                    ((Messenger)com.umeng.update.net.c.a(c).get(d)).send(((Message) (obj)));
                }
                c.b(e, a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Integer integer)
            {
                c.b(e, a);
            }
            return;
        }
        f.cancel(a + 1);
        integer = new Bundle();
        integer.putString("filename", b);
        Message message = Message.obtain();
        message.what = 5;
        message.arg1 = 3;
        message.arg2 = a;
        message.setData(integer);
        try
        {
            if (com.umeng.update.net.c.a(c).get(d) != null)
            {
                ((Messenger)com.umeng.update.net.c.a(c).get(d)).send(message);
            }
            c.b(e, a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Integer integer)
        {
            c.b(e, a);
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    public n(c c1, Context context, int i, n n1, String s)
    {
        c = c1;
        super();
        e = context.getApplicationContext();
        f = (NotificationManager)e.getSystemService("notification");
        a = i;
        d = n1;
        b = s;
    }
}
