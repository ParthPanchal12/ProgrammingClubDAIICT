// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

// Referenced classes of package com.umeng.update.net:
//            DownloadingService, d

public class com.umeng.update.net.a
{
    static class a
    {

        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f[];
        public boolean g;
        public boolean h;
        public boolean i;

        public static a a(Bundle bundle)
        {
            a a1 = new a(bundle.getString("mComponentName"), bundle.getString("mTitle"), bundle.getString("mUrl"));
            a1.d = bundle.getString("mMd5");
            a1.e = bundle.getString("mTargetMd5");
            a1.f = bundle.getStringArray("reporturls");
            a1.g = bundle.getBoolean("rich_notification");
            a1.h = bundle.getBoolean("mSilent");
            a1.i = bundle.getBoolean("mWifiOnly");
            return a1;
        }

        public Bundle a()
        {
            Bundle bundle = new Bundle();
            bundle.putString("mComponentName", a);
            bundle.putString("mTitle", b);
            bundle.putString("mUrl", c);
            bundle.putString("mMd5", d);
            bundle.putString("mTargetMd5", e);
            bundle.putStringArray("reporturls", f);
            bundle.putBoolean("rich_notification", g);
            bundle.putBoolean("mSilent", h);
            bundle.putBoolean("mWifiOnly", i);
            return bundle;
        }

        public a(String s, String s1, String s2)
        {
            f = null;
            g = false;
            h = false;
            i = false;
            a = s;
            b = s1;
            c = s2;
        }
    }

    class b extends Handler
    {

        final com.umeng.update.net.a a;

        public void handleMessage(Message message)
        {
            u.upd.b.c(com.umeng.update.net.a.b(), (new StringBuilder("DownloadAgent.handleMessage(")).append(message.what).append("): ").toString());
            message.what;
            JVM INSTR tableswitch 1 5: default 289
        //                       1 74
        //                       2 272
        //                       3 140
        //                       4 68
        //                       5 167;
               goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
            super.handleMessage(message);
            return;
_L2:
            try
            {
                if (com.umeng.update.net.a.k(a) != null)
                {
                    com.umeng.update.net.a.k(a).d();
                    return;
                }
                break; /* Loop/switch isn't completed */
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                u.upd.b.c(com.umeng.update.net.a.b(), (new StringBuilder("DownloadAgent.handleMessage(")).append(message.what).append("): ").append(exception.getMessage()).toString());
                return;
            }
_L4:
            if (com.umeng.update.net.a.k(a) != null)
            {
                com.umeng.update.net.a.k(a).a(message.arg1);
                return;
            }
            break; /* Loop/switch isn't completed */
_L5:
            com.umeng.update.net.a.l(a).unbindService(com.umeng.update.net.a.m(a));
            if (com.umeng.update.net.a.k(a) == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (message.arg1 == 1 || message.arg1 == 3 || message.arg1 == 5)
            {
                com.umeng.update.net.a.k(a).a(message.arg1, message.arg2, message.getData().getString("filename"));
                return;
            }
            com.umeng.update.net.a.k(a).a(0, 0, null);
            u.upd.b.c(com.umeng.update.net.a.b(), "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
            return;
_L3:
            com.umeng.update.net.a.k(a).b(message.arg1);
            return;
        }

        b()
        {
            a = com.umeng.update.net.a.this;
            super();
        }
    }


    private static final String b = com/umeng/update/net/a.getName();
    final Messenger a = new Messenger(new b());
    private Context c;
    private d d;
    private Messenger e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k[];
    private boolean l;
    private boolean m;
    private boolean n;
    private ServiceConnection o;

    public com.umeng.update.net.a(Context context, String s, String s1, String s2, d d1)
    {
        l = false;
        m = false;
        n = false;
        o = new ServiceConnection() {

            final com.umeng.update.net.a a;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                u.upd.b.c(com.umeng.update.net.a.b(), "ServiceConnection.onServiceConnected");
                com.umeng.update.net.a.a(a, new Messenger(ibinder));
                try
                {
                    componentname = Message.obtain(null, 4);
                    ibinder = new a(com.umeng.update.net.a.a(a), com.umeng.update.net.a.b(a), com.umeng.update.net.a.c(a));
                    ibinder.d = com.umeng.update.net.a.d(a);
                    ibinder.e = com.umeng.update.net.a.e(a);
                    ibinder.f = com.umeng.update.net.a.f(a);
                    ibinder.g = com.umeng.update.net.a.g(a);
                    ibinder.h = com.umeng.update.net.a.h(a);
                    ibinder.i = com.umeng.update.net.a.i(a);
                    componentname.setData(ibinder.a());
                    componentname.replyTo = a.a;
                    com.umeng.update.net.a.j(a).send(componentname);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ComponentName componentname)
                {
                    return;
                }
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                u.upd.b.c(com.umeng.update.net.a.b(), "ServiceConnection.onServiceDisconnected");
                com.umeng.update.net.a.a(a, null);
            }

            
            {
                a = com.umeng.update.net.a.this;
                super();
            }
        };
        c = context.getApplicationContext();
        f = s;
        g = s1;
        h = s2;
        d = d1;
    }

    static String a(com.umeng.update.net.a a1)
    {
        return a1.f;
    }

    static void a(com.umeng.update.net.a a1, Messenger messenger)
    {
        a1.e = messenger;
    }

    static String b()
    {
        return b;
    }

    static String b(com.umeng.update.net.a a1)
    {
        return a1.g;
    }

    static String c(com.umeng.update.net.a a1)
    {
        return a1.h;
    }

    static String d(com.umeng.update.net.a a1)
    {
        return a1.i;
    }

    static String e(com.umeng.update.net.a a1)
    {
        return a1.j;
    }

    static String[] f(com.umeng.update.net.a a1)
    {
        return a1.k;
    }

    static boolean g(com.umeng.update.net.a a1)
    {
        return a1.l;
    }

    static boolean h(com.umeng.update.net.a a1)
    {
        return a1.m;
    }

    static boolean i(com.umeng.update.net.a a1)
    {
        return a1.n;
    }

    static Messenger j(com.umeng.update.net.a a1)
    {
        return a1.e;
    }

    static d k(com.umeng.update.net.a a1)
    {
        return a1.d;
    }

    static Context l(com.umeng.update.net.a a1)
    {
        return a1.c;
    }

    static ServiceConnection m(com.umeng.update.net.a a1)
    {
        return a1.o;
    }

    public void a()
    {
        Intent intent = new Intent(c, com/umeng/update/net/DownloadingService);
        c.bindService(intent, o, 1);
        c.startService(new Intent(c, com/umeng/update/net/DownloadingService));
    }

    public void a(String s)
    {
        i = s;
    }

    public void a(boolean flag)
    {
        l = flag;
    }

    public void a(String as[])
    {
        k = as;
    }

    public void b(String s)
    {
        j = s;
    }

    public void b(boolean flag)
    {
        m = flag;
    }

    public void c(boolean flag)
    {
        n = flag;
    }

}
