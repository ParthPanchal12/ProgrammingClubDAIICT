// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.umeng.update.util.DeltaUpdate;
import com.umeng.update.util.b;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import u.upd.a;
import u.upd.j;
import u.upd.k;
import u.upd.l;
import u.upd.n;

// Referenced classes of package com.umeng.update.net:
//            f, DownloadingService, e, j

class com.umeng.update.net.c
{
    static class a extends com.umeng.update.util.b
    {

        public a a()
        {
            c.contentView.setViewVisibility(j.e(b), 8);
            c.contentView.setViewVisibility(j.g(b), 8);
            return this;
        }

        public a a(int i, int i1, boolean flag)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                d.setProgress(i, i1, flag);
            }
            c.contentView.setProgressBar(j.c(b), 100, i1, false);
            return this;
        }

        public a a(PendingIntent pendingintent, PendingIntent pendingintent1)
        {
            c.contentView.setOnClickPendingIntent(j.e(b), pendingintent);
            c.contentView.setViewVisibility(j.e(b), 0);
            c.contentView.setViewVisibility(j.g(b), 0);
            c.contentView.setOnClickPendingIntent(j.g(b), pendingintent1);
            return this;
        }

        public a a(RemoteViews remoteviews)
        {
            c.contentView = remoteviews;
            return this;
        }

        public a a(CharSequence charsequence)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                d.setContentText(charsequence);
            }
            c.contentView.setTextViewText(j.a(b), charsequence);
            return this;
        }

        public void a(int i, String s, PendingIntent pendingintent)
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                d.addAction(i, s, pendingintent);
            }
        }

        public a b()
        {
            int i = j.e(b);
            c.contentView.setTextViewText(i, b.getResources().getString(l.e(b.getApplicationContext())));
            c.contentView.setInt(i, "setBackgroundResource", u.upd.c.a(b).c("umeng_common_gradient_green"));
            return this;
        }

        public a b(CharSequence charsequence)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                d.setContentTitle(charsequence);
            }
            c.contentView.setTextViewText(j.d(b), charsequence);
            return this;
        }

        public a c()
        {
            int i = j.e(b);
            c.contentView.setTextViewText(i, b.getResources().getString(l.d(b.getApplicationContext())));
            c.contentView.setInt(i, "setBackgroundResource", u.upd.c.a(b).c("umeng_common_gradient_orange"));
            return this;
        }

        public Notification d()
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                return d.build();
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                return d.getNotification();
            } else
            {
                return c;
            }
        }

        public a(Context context)
        {
            super(context);
        }
    }

    static class b
    {

        DownloadingService.b a;
        a b;
        int c;
        int d;
        a.a e;
        long f[];

        public void a(SparseArray sparsearray)
        {
            sparsearray.put(c, this);
        }

        public void b(SparseArray sparsearray)
        {
            if (sparsearray.indexOfKey(c) >= 0)
            {
                sparsearray.remove(c);
            }
        }

        public b(a.a a1, int i)
        {
            f = new long[3];
            c = i;
            e = a1;
        }
    }

    class c extends AsyncTask
    {

        public int a;
        public String b;
        final com.umeng.update.net.c c;
        private a.a d;
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

        public c(Context context, int i, a.a a1, String s)
        {
            c = com.umeng.update.net.c.this;
            super();
            e = context.getApplicationContext();
            f = (NotificationManager)e.getSystemService("notification");
            a = i;
            d = a1;
            b = s;
        }
    }


    static final int a = 0;
    static final int b = 1;
    static final int c = 1;
    static final int d = 2;
    private static final String e = com/umeng/update/net/c.getName();
    private SparseArray f;
    private Map g;
    private e h;

    public com.umeng.update.net.c(SparseArray sparsearray, Map map, e e1)
    {
        f = sparsearray;
        g = map;
        h = e1;
    }

    static String a()
    {
        return e;
    }

    static Map a(com.umeng.update.net.c c1)
    {
        return c1.g;
    }

    int a(a.a a1)
    {
        return Math.abs((int)((long)((a1.b.hashCode() >> 2) + (a1.c.hashCode() >> 3)) + System.currentTimeMillis()));
    }

    a a(Context context, a.a a1, int i, int i1)
    {
        context = context.getApplicationContext();
        a a2 = new a(context);
        Object obj = PendingIntent.getActivity(context, 0, new Intent(), 0x8000000);
        a2.d(context.getString(l.j(context))).a(0x1080081).a(((PendingIntent) (obj))).a(System.currentTimeMillis());
        obj = new RemoteViews(context.getPackageName(), k.a(context));
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            int j1 = context.getResources().getDimensionPixelSize(0x1050005);
            int j2 = context.getResources().getDimensionPixelSize(0x1050006);
            ((RemoteViews) (obj)).setInt(j.b(context), "setWidth", j1);
            ((RemoteViews) (obj)).setInt(j.b(context), "setHeight", j2);
            try
            {
                Field field = Class.forName("com.android.internal.R$drawable").getDeclaredField("notify_panel_notification_icon_bg_tile");
                field.setAccessible(true);
                int k1 = field.getInt(null);
                ((RemoteViews) (obj)).setInt(j.b(context), "setBackgroundResource", k1);
            }
            catch (Exception exception)
            {
                u.upd.b.a(e, "No notification icon background found:", exception);
            }
        } else
        {
            try
            {
                Field field1 = Class.forName("com.android.internal.R$drawable").getDeclaredField("status_bar_notification_icon_bg");
                field1.setAccessible(true);
                int l1 = field1.getInt(null);
                ((RemoteViews) (obj)).setInt(j.b(context), "setBackgroundResource", l1);
            }
            catch (Exception exception1)
            {
                try
                {
                    Object obj1 = Class.forName("com.android.internal.R$dimen");
                    Field field2 = ((Class) (obj1)).getDeclaredField("status_bar_edge_ignore");
                    field2.setAccessible(true);
                    int i2 = field2.getInt(null);
                    i2 = context.getResources().getDimensionPixelSize(i2);
                    obj1 = ((Class) (obj1)).getDeclaredField("status_bar_height");
                    ((Field) (obj1)).setAccessible(true);
                    int l2 = ((Field) (obj1)).getInt(null);
                    int k2 = context.getResources().getDimensionPixelSize(l2);
                    l2 = context.getResources().getDimensionPixelSize(l2);
                    ((RemoteViews) (obj)).setInt(j.b(context), "setWidth", l2 + (i2 + 0 + k2));
                }
                catch (Exception exception2)
                {
                    u.upd.b.a(e, "No notification size found:", exception2);
                }
            }
        }
        a2.a(((RemoteViews) (obj)));
        a2.b((new StringBuilder(String.valueOf(context.getResources().getString(l.g(context))))).append(a1.b).toString()).a((new StringBuilder(String.valueOf(i1))).append("%").toString()).a(100, i1, false);
        if (a1.g)
        {
            a2.b(((RemoteViews) (obj)));
            a2.e();
            a1 = com.umeng.update.net.f.b(context, com.umeng.update.net.f.a(i, "continue"));
            obj = com.umeng.update.net.f.b(context, com.umeng.update.net.f.a(i, "cancel"));
            a(context, a2, i, 2);
            a2.a(a1, ((PendingIntent) (obj))).c().a(true).b(false);
            return a2;
        } else
        {
            a2.a().a(true).b(false);
            return a2;
        }
    }

    void a(Context context, int i)
    {
        context = context.getApplicationContext();
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        b b1 = (b)f.get(i);
        b1.b.e();
        a(context, b1.b, i, 1);
        b1.b.b((new StringBuilder(String.valueOf(context.getResources().getString(l.h(context))))).append(b1.e.b).toString()).b().a(false).b(true);
        notificationmanager.notify(i, b1.b.d());
    }

    void a(Context context, a a1, int i, int i1)
    {
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L2; else goto _L1
_L1:
        PendingIntent pendingintent;
        PendingIntent pendingintent1;
        pendingintent = com.umeng.update.net.f.b(context, com.umeng.update.net.f.a(i, "continue"));
        pendingintent1 = com.umeng.update.net.f.b(context, com.umeng.update.net.f.a(i, "cancel"));
        i1;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 77
    //                   2 100;
           goto _L3 _L4 _L5
_L3:
        a1.a(0x1080038, context.getResources().getString(l.f(context)), pendingintent1);
_L2:
        return;
_L4:
        a1.a(0x1080024, context.getResources().getString(l.e(context)), pendingintent);
        continue; /* Loop/switch isn't completed */
_L5:
        a1.a(0x1080023, context.getResources().getString(l.d(context)), pendingintent);
        if (true) goto _L3; else goto _L6
_L6:
    }

    void a(a.a a1, long l1, long l2, long l3)
    {
        if (a1.f != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("dsize", String.valueOf(l1));
            hashmap.put("dtime", n.a().split(" ")[1]);
            float f1 = 0.0F;
            if (l2 > 0L)
            {
                f1 = (float)l1 / (float)l2;
            }
            hashmap.put("dpcent", String.valueOf((int)(f1 * 100F)));
            hashmap.put("ptimes", String.valueOf(l3));
            a(((Map) (hashmap)), false, a1.f);
        }
    }

    final void a(Map map, boolean flag, String as[])
    {
        (new Thread(new Runnable(as, flag, map) {

            final com.umeng.update.net.c a;
            private final String b[];
            private final boolean c;
            private final Map d;

            public void run()
            {
                int i1 = (new Random()).nextInt(1000);
                if (b != null) goto _L2; else goto _L1
_L1:
                u.upd.b.a(com.umeng.update.net.c.a(), (new StringBuilder(String.valueOf(i1))).append("service report: urls is null").toString());
_L4:
                return;
_L2:
                String as1[];
                int i;
                int j1;
                as1 = b;
                j1 = as1.length;
                i = 0;
_L9:
                if (i >= j1) goto _L4; else goto _L3
_L3:
                String s;
                Object obj;
                Object obj2;
                s = as1[i];
                obj = n.a();
                obj2 = ((String) (obj)).split(" ")[0];
                String s1 = ((String) (obj)).split(" ")[1];
                long l1 = System.currentTimeMillis();
                obj = new StringBuilder(s);
                ((StringBuilder) (obj)).append("&data=").append(((String) (obj2)));
                ((StringBuilder) (obj)).append("&time=").append(s1);
                ((StringBuilder) (obj)).append("&ts=").append(l1);
                int k1;
                if (c)
                {
                    ((StringBuilder) (obj)).append("&action_type=").append(1);
                } else
                {
                    ((StringBuilder) (obj)).append("&action_type=").append(-2);
                }
                if (d == null) goto _L6; else goto _L5
_L5:
                obj2 = d.keySet().iterator();
_L10:
                if (((Iterator) (obj2)).hasNext()) goto _L7; else goto _L6
_L6:
                u.upd.b.a(com.umeng.update.net.c.a(), (new StringBuilder(String.valueOf(i1))).append(": service report:\tget: ").append(((StringBuilder) (obj)).toString()).toString());
                obj = new HttpGet(((StringBuilder) (obj)).toString());
                obj2 = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj2)), 10000);
                HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj2)), 20000);
                obj = (new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj2)))).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
                u.upd.b.a(com.umeng.update.net.c.a(), (new StringBuilder(String.valueOf(i1))).append(": service report:status code:  ").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
                k1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
                if (k1 == 200) goto _L4; else goto _L8
_L8:
                i++;
                  goto _L9
_L7:
                String s2 = (String)((Iterator) (obj2)).next();
                ((StringBuilder) (obj)).append("&").append(s2).append("=").append((String)d.get(s2));
                  goto _L10
                Object obj1;
                obj1;
                u.upd.b.c(com.umeng.update.net.c.a(), (new StringBuilder(String.valueOf(i1))).append(": service report:\tClientProtocolException,Failed to send message.").append(s).toString(), ((Exception) (obj1)));
                  goto _L8
                obj1;
                u.upd.b.c(com.umeng.update.net.c.a(), (new StringBuilder(String.valueOf(i1))).append(": service report:\tIOException,Failed to send message.").append(s).toString(), ((Exception) (obj1)));
                  goto _L8
            }

            
            {
                a = com.umeng.update.net.c.this;
                b = as;
                c = flag;
                d = map;
                super();
            }
        })).start();
    }

    boolean a(Context context)
    {
        Object obj = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        context = context.getPackageName();
        obj = ((List) (obj)).iterator();
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                return false;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        } while (runningappprocessinfo.importance != 100 || !runningappprocessinfo.processName.equals(context));
        return true;
    }

    boolean a(DownloadingService downloadingservice, Intent intent)
    {
        Context context;
        Object obj;
        int i;
        context = downloadingservice.getApplicationContext();
        intent = intent.getExtras().getString("com.umeng.broadcast.download.msg").split(":");
        i = Integer.parseInt(intent[0]);
        obj = intent[1].trim();
        if (i == 0) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(((CharSequence) (obj))) || f.indexOfKey(i) < 0) goto _L2; else goto _L3
_L3:
        DownloadingService.b b1;
        intent = (b)f.get(i);
        b1 = ((b) (intent)).a;
        if (!"continue".equals(obj)) goto _L5; else goto _L4
_L4:
        if (b1 != null) goto _L7; else goto _L6
_L6:
        u.upd.b.c(e, "Receive action do play click.");
        if (!u.upd.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || u.upd.a.l(context))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        Toast.makeText(context, context.getResources().getString(l.a(context.getApplicationContext())), 1).show();
        return false;
        downloadingservice.getClass();
        downloadingservice = new DownloadingService.b(downloadingservice, context, ((b) (intent)).e, i, ((b) (intent)).d, downloadingservice.q);
        intent.a = downloadingservice;
        downloadingservice.start();
        downloadingservice = Message.obtain();
        downloadingservice.what = 2;
        downloadingservice.arg1 = 7;
        downloadingservice.arg2 = i;
        if (g.get(((b) (intent)).e) != null)
        {
            ((Messenger)g.get(((b) (intent)).e)).send(downloadingservice);
        }
_L9:
        return true;
        downloadingservice;
        u.upd.b.b(e, "", downloadingservice);
        if (true) goto _L9; else goto _L8
_L8:
        downloadingservice;
        downloadingservice.printStackTrace();
_L2:
        return false;
_L7:
        u.upd.b.c(e, "Receive action do play click.");
        b1.a(1);
        intent.a = null;
        a(context, i);
        downloadingservice = Message.obtain();
        downloadingservice.what = 2;
        downloadingservice.arg1 = 6;
        downloadingservice.arg2 = i;
        if (g.get(((b) (intent)).e) != null)
        {
            ((Messenger)g.get(((b) (intent)).e)).send(downloadingservice);
        }
_L10:
        return true;
        downloadingservice;
        u.upd.b.b(e, "", downloadingservice);
          goto _L10
_L5:
        if (!"cancel".equals(obj)) goto _L2; else goto _L11
_L11:
        u.upd.b.c(e, "Receive action do stop click.");
        if (b1 == null) goto _L13; else goto _L12
_L12:
        b1.a(2);
_L14:
        downloadingservice = Message.obtain();
        downloadingservice.what = 5;
        downloadingservice.arg1 = 5;
        downloadingservice.arg2 = i;
        if (g.get(((b) (intent)).e) != null)
        {
            ((Messenger)g.get(((b) (intent)).e)).send(downloadingservice);
        }
        b(context, i);
_L15:
        return true;
_L13:
        long l1 = ((b) (intent)).f[0];
        long l2 = ((b) (intent)).f[1];
        long l3 = ((b) (intent)).f[2];
        a(((b) (intent)).e, l1, l2, l3);
          goto _L14
        downloadingservice;
        downloadingservice = Message.obtain();
        downloadingservice.what = 5;
        downloadingservice.arg1 = 5;
        downloadingservice.arg2 = i;
        if (g.get(((b) (intent)).e) != null)
        {
            ((Messenger)g.get(((b) (intent)).e)).send(downloadingservice);
        }
        b(context, i);
          goto _L15
        downloadingservice;
        b(context, i);
          goto _L15
        downloadingservice;
        obj = Message.obtain();
        obj.what = 5;
        obj.arg1 = 5;
        obj.arg2 = i;
        if (g.get(((b) (intent)).e) != null)
        {
            ((Messenger)g.get(((b) (intent)).e)).send(((Message) (obj)));
        }
        b(context, i);
_L16:
        throw downloadingservice;
        intent;
        b(context, i);
          goto _L16
        downloadingservice;
        b(context, i);
          goto _L15
    }

    boolean a(a.a a1, boolean flag, Messenger messenger)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = (new Random()).nextInt(1000);
        if (g == null) goto _L4; else goto _L3
_L3:
        Iterator iterator = g.keySet().iterator();
_L8:
        if (iterator.hasNext()) goto _L5; else goto _L2
_L2:
        if (g == null)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L5:
        a.a a2 = (a.a)iterator.next();
        u.upd.b.c(e, (new StringBuilder("_")).append(i).append(" downling  ").append(a2.b).append("   ").append(a2.c).toString());
        continue; /* Loop/switch isn't completed */
_L4:
        u.upd.b.c(e, (new StringBuilder("_")).append(i).append("downling  null").toString());
        if (true) goto _L2; else goto _L6
_L6:
        Iterator iterator1 = g.keySet().iterator();
        a.a a3;
        do
        {
            if (!iterator1.hasNext())
            {
                return false;
            }
            a3 = (a.a)iterator1.next();
            if (a1.e != null && a1.e.equals(a3.e))
            {
                g.put(a3, messenger);
                return true;
            }
        } while (!a3.c.equals(a1.c));
        g.put(a3, messenger);
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    int b(a.a a1)
    {
        int i = 0;
        do
        {
            if (i >= f.size())
            {
                return -1;
            }
            int i1 = f.keyAt(i);
            if (a1.e != null && a1.e.equals(((b)f.get(i1)).e.e))
            {
                return ((b)f.get(i1)).c;
            }
            if (((b)f.get(i1)).e.c.equals(a1.c))
            {
                return ((b)f.get(i1)).c;
            }
            i++;
        } while (true);
    }

    void b(Context context, int i)
    {
        context = (NotificationManager)context.getApplicationContext().getSystemService("notification");
        b b1 = (b)f.get(i);
        if (b1 != null)
        {
            u.upd.b.c(e, (new StringBuilder("download service clear cache ")).append(b1.e.b).toString());
            if (b1.a != null)
            {
                b1.a.a(2);
            }
            context.cancel(b1.c);
            if (g.containsKey(b1.e))
            {
                g.remove(b1.e);
            }
            b1.b(f);
            h.b(i);
        }
    }

}
