// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;
import android.widget.Toast;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.upd.b;
import u.upd.l;
import u.upd.n;

// Referenced classes of package com.umeng.update.net:
//            c, e, b, j, 
//            f

public class DownloadingService extends Service
{
    static interface a
    {

        public abstract void a(int i1);

        public abstract void a(int i1, int j1);

        public abstract void a(int i1, Exception exception);

        public abstract void a(int i1, String s1);
    }

    class b extends Thread
    {

        final DownloadingService a;
        private Context b;
        private boolean c;
        private File d;
        private int e;
        private long f;
        private long g;
        private int h;
        private int i;
        private a j;
        private a.a k;

        static Context a(b b1)
        {
            return b1.b;
        }

        private String a(a.a a1)
        {
            Object obj;
            if (k.e != null)
            {
                a1 = (new StringBuilder(String.valueOf(k.e))).append(".apk.tmp").toString();
            } else
            {
                a1 = (new StringBuilder(String.valueOf(u.upd.n.a(k.c)))).append(".apk.tmp").toString();
            }
            obj = a1;
            if (k.a.equalsIgnoreCase("delta_update"))
            {
                obj = a1.replace(".apk", ".patch");
            }
            return ((String) (obj));
        }

        private HttpURLConnection a(URL url, File file)
            throws IOException
        {
            url = (HttpURLConnection)url.openConnection();
            url.setRequestMethod("GET");
            url.setRequestProperty("Accept-Encoding", "identity");
            url.addRequestProperty("Connection", "keep-alive");
            url.setConnectTimeout(5000);
            url.setReadTimeout(10000);
            if (file.exists() && file.length() > 0L)
            {
                u.upd.b.c(DownloadingService.a(), String.format((new StringBuilder(String.valueOf(k.b))).append(" getFileLength: %1$15s").toString(), new Object[] {
                    Long.valueOf(file.length())
                }));
                url.setRequestProperty("Range", (new StringBuilder("bytes=")).append(file.length()).append("-").toString());
            }
            return url;
        }

        private void a()
        {
            u.upd.b.c(DownloadingService.a(), (new StringBuilder("wait for repeating Test network repeat count=")).append(e).toString());
            if (k.g)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            Thread.sleep(8000L);
            if (g < 1L)
            {
                a(false);
                return;
            }
            try
            {
                a(true);
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                a(((Exception) (interruptedexception)));
            }
            DownloadingService.a(a).b(b, i);
            return;
            Object obj = (c.b)com.umeng.update.net.DownloadingService.b().get(i);
            ((c.b) (obj)).f[0] = f;
            ((c.b) (obj)).f[1] = g;
            ((c.b) (obj)).f[2] = e;
            obj = com.umeng.update.net.f.a(i, "continue");
            Intent intent = new Intent(b, com/umeng/update/net/DownloadingService);
            intent.putExtra("com.umeng.broadcast.download.msg", ((String) (obj)));
            DownloadingService.a(a).a(a, intent);
            DownloadingService.a(a, b.getString(u.upd.l.c(b)));
            u.upd.b.c(DownloadingService.a(), "changed play state button on op-notification.");
            return;
        }

        private void a(File file, String s1)
            throws RemoteException
        {
            u.upd.b.c(DownloadingService.a(), (new StringBuilder("itemMd5 ")).append(k.d).toString());
            u.upd.b.c(DownloadingService.a(), (new StringBuilder("fileMd5 ")).append(u.upd.n.a(file)).toString());
            if (k.d == null || k.d.equalsIgnoreCase(u.upd.n.a(file)))
            {
                break MISSING_BLOCK_LABEL_206;
            }
            if (!k.a.equalsIgnoreCase("delta_update"))
            {
                break MISSING_BLOCK_LABEL_227;
            }
            DownloadingService.c(a).cancel(i);
            file = new Bundle();
            file.putString("filename", s1);
            s1 = Message.obtain();
            s1.what = 5;
            s1.arg1 = 3;
            s1.arg2 = i;
            s1.setData(file);
            if (DownloadingService.c().get(k) != null)
            {
                ((Messenger)DownloadingService.c().get(k)).send(s1);
            }
            DownloadingService.a(a).b(b, i);
_L1:
            return;
            file;
            DownloadingService.a(a).b(b, i);
            return;
            ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 5, 0, 0));
            if (!k.h)
            {
                DownloadingService.a(a).b(b, i);
                file = new Notification(0x1080082, b.getString(u.upd.l.i(b)), System.currentTimeMillis());
                s1 = PendingIntent.getActivity(b, 0, new Intent(), 0);
                file.setLatestEventInfo(b, u.upd.a.v(b), (new StringBuilder(String.valueOf(k.b))).append(b.getString(u.upd.l.i(b))).toString(), s1);
                file.flags = ((Notification) (file)).flags | 0x10;
                DownloadingService.c(a).notify(i, file);
                return;
            }
              goto _L1
        }

        private void a(Exception exception)
        {
            u.upd.b.b(DownloadingService.a(), (new StringBuilder("can not install. ")).append(exception.getMessage()).toString());
            if (j != null)
            {
                j.a(i, exception);
            }
            DownloadingService.a(a).a(k, f, g, e);
        }

        private void a(boolean flag)
        {
            Object obj1;
            Object obj2;
            boolean flag1;
            obj1 = null;
            flag1 = false;
            obj2 = d.getName();
            Object obj = new FileOutputStream(d, true);
            if (c || com.umeng.update.net.j.a(d.getAbsolutePath(), 3))
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ((FileOutputStream) (obj)).close();
            obj1 = b.openFileOutput(((String) (obj2)), 32771);
            d = b.getFileStreamPath(((String) (obj2)));
            obj = obj1;
            u.upd.b.c(DownloadingService.a(), String.format("saveAPK: url = %1$15s\t|\tfilename = %2$15s", new Object[] {
                k.c, d.getAbsolutePath()
            }));
            obj2 = a(new URL(k.c), d);
            ((HttpURLConnection) (obj2)).connect();
            obj1 = ((HttpURLConnection) (obj2)).getInputStream();
            Object obj3;
            Object obj6;
            long l1;
            long l2;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_345;
            }
            l2 = 0L;
            l1 = l2;
            obj6 = obj;
            obj3 = obj1;
            if (!d.exists())
            {
                break MISSING_BLOCK_LABEL_217;
            }
            l1 = l2;
            obj6 = obj;
            obj3 = obj1;
            if (d.length() <= 0L)
            {
                break MISSING_BLOCK_LABEL_217;
            }
            obj6 = obj;
            obj3 = obj1;
            l1 = 0L + d.length();
            obj6 = obj;
            obj3 = obj1;
            f = l1;
            obj6 = obj;
            obj3 = obj1;
            g = l1 + (long)((HttpURLConnection) (obj2)).getContentLength();
            obj6 = obj;
            obj3 = obj1;
            u.upd.b.c(DownloadingService.a(), String.format("getFileLength: %1$15s", new Object[] {
                Long.valueOf(f)
            }));
            obj6 = obj;
            obj3 = obj1;
            u.upd.b.c(DownloadingService.a(), String.format("getConnectionLength: %1$15s", new Object[] {
                Integer.valueOf(((HttpURLConnection) (obj2)).getContentLength())
            }));
            obj6 = obj;
            obj3 = obj1;
            u.upd.b.c(DownloadingService.a(), String.format("getContentLength: %1$15s", new Object[] {
                Long.valueOf(g)
            }));
            obj6 = obj;
            obj3 = obj1;
            byte abyte0[] = new byte[4096];
            obj6 = obj;
            obj3 = obj1;
            u.upd.b.c(DownloadingService.a(), (new StringBuilder(String.valueOf(k.b))).append("saveAPK getContentLength ").append(String.valueOf(g)).toString());
            obj6 = obj;
            obj3 = obj1;
            com.umeng.update.net.b.a(b).a(k.a, k.c);
            int i1 = 0;
_L15:
            obj6 = obj;
            obj3 = obj1;
            if (h >= 0)
            {
                break MISSING_BLOCK_LABEL_1935;
            }
            obj6 = obj;
            obj3 = obj1;
            int j1;
            j1 = ((InputStream) (obj1)).read(abyte0);
            break MISSING_BLOCK_LABEL_467;
_L6:
            obj6 = obj;
            obj3 = obj1;
            ((InputStream) (obj1)).close();
            obj6 = obj;
            obj3 = obj1;
            ((FileOutputStream) (obj)).close();
            obj6 = obj;
            obj3 = obj1;
            if (h != 1) goto _L2; else goto _L1
_L1:
            obj6 = obj;
            obj3 = obj1;
            abyte0 = (c.b)com.umeng.update.net.DownloadingService.b().get(i);
            obj6 = obj;
            obj3 = obj1;
            ((c.b) (abyte0)).f[0] = f;
            obj6 = obj;
            obj3 = obj1;
            ((c.b) (abyte0)).f[1] = g;
            obj6 = obj;
            obj3 = obj1;
            ((c.b) (abyte0)).f[2] = e;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_590;
            }
            ((InputStream) (obj1)).close();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_598;
            }
            ((FileOutputStream) (obj)).close();
_L14:
            return;
            if (j1 <= 0)
            {
                break MISSING_BLOCK_LABEL_1935;
            }
            obj6 = obj;
            obj3 = obj1;
            ((FileOutputStream) (obj)).write(abyte0, 0, j1);
            obj6 = obj;
            obj3 = obj1;
            f = f + (long)j1;
            if (i1 % 50 != 0) goto _L4; else goto _L3
_L3:
            j1 = ((flag1) ? 1 : 0);
            obj6 = obj;
            obj3 = obj1;
            if (!u.upd.a.l(b)) goto _L6; else goto _L5
_L5:
            obj6 = obj;
            obj3 = obj1;
            if (u.upd.a.k(b)) goto _L8; else goto _L7
_L7:
            obj6 = obj;
            obj3 = obj1;
            if (!k.i) goto _L8; else goto _L9
_L9:
            obj6 = obj;
            obj3 = obj1;
            u.upd.b.b(DownloadingService.a(), "no wifi");
            obj6 = obj;
            obj3 = obj1;
            throw new IOException("no wifi");
            abyte0;
_L31:
            u.upd.b.c(DownloadingService.a(), abyte0.getMessage(), abyte0);
            i1 = e + 1;
            e = i1;
            if (i1 <= 3) goto _L11; else goto _L10
_L10:
            flag = k.g;
            if (flag) goto _L11; else goto _L12
_L12:
            u.upd.b.b(DownloadingService.a(), "Download Fail out of max repeat count");
            ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 5, 0, 0));
            DownloadingService.a(a).b(b, i);
            a(((Exception) (abyte0)));
            DownloadingService.d(a).post(new Runnable(this) {

                final b a;

                public void run()
                {
                    Toast.makeText(com.umeng.update.net.b.b(a), u.upd.l.i(b.a(a)), 0).show();
                }

            
            {
                a = b1;
                super();
            }
            });
_L25:
            if (obj1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((InputStream) (obj1)).close();
            if (obj == null) goto _L14; else goto _L13
_L13:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
_L8:
            obj6 = obj;
            obj3 = obj1;
            int k1 = (int)(((float)f * 100F) / (float)g);
            j1 = k1;
            if (k1 > 100)
            {
                j1 = 99;
            }
            obj6 = obj;
            obj3 = obj1;
            if (j == null)
            {
                break MISSING_BLOCK_LABEL_944;
            }
            obj6 = obj;
            obj3 = obj1;
            j.a(i, j1);
            obj6 = obj;
            obj3 = obj1;
            b(j1);
            obj6 = obj;
            obj3 = obj1;
            com.umeng.update.net.b.a(b).a(k.a, k.c, j1);
_L4:
            i1++;
              goto _L15
            obj1;
            ((IOException) (obj1)).printStackTrace();
            if (obj == null) goto _L14; else goto _L16
_L16:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj1;
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            obj;
            ((IOException) (obj)).printStackTrace();
            return;
_L2:
            obj6 = obj;
            obj3 = obj1;
            if (h != 2)
            {
                break MISSING_BLOCK_LABEL_1171;
            }
            obj6 = obj;
            obj3 = obj1;
            DownloadingService.a(a).a(k, f, g, e);
            obj6 = obj;
            obj3 = obj1;
            DownloadingService.c(a).cancel(i);
            if (obj1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((InputStream) (obj1)).close();
            if (obj == null) goto _L14; else goto _L17
_L17:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj1;
            ((IOException) (obj1)).printStackTrace();
            if (obj == null) goto _L14; else goto _L18
_L18:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj1;
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            if (j1 != 0) goto _L20; else goto _L19
_L19:
            obj6 = obj;
            obj3 = obj1;
            u.upd.b.b(DownloadingService.a(), (new StringBuilder("Download Fail repeat count=")).append(e).toString());
            obj6 = obj;
            obj3 = obj1;
            ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 5, 0, 0));
            obj6 = obj;
            obj3 = obj1;
            DownloadingService.a(a).b(b, i);
            obj6 = obj;
            obj3 = obj1;
            if (j == null)
            {
                break MISSING_BLOCK_LABEL_1296;
            }
            obj6 = obj;
            obj3 = obj1;
            j.a(i, null);
_L23:
            if (obj1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((InputStream) (obj1)).close();
            if (obj == null) goto _L14; else goto _L21
_L21:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
_L20:
            obj6 = obj;
            obj3 = obj1;
            b();
            obj6 = obj;
            obj3 = obj1;
            abyte0 = new File(d.getParent(), d.getName().replace(".tmp", ""));
            obj6 = obj;
            obj3 = obj1;
            d.renameTo(abyte0);
            obj6 = obj;
            obj3 = obj1;
            String s1 = abyte0.getAbsolutePath();
            obj6 = obj;
            obj3 = obj1;
            a(((File) (abyte0)), s1);
            obj6 = obj;
            obj3 = obj1;
            if (j == null) goto _L23; else goto _L22
_L22:
            obj6 = obj;
            obj3 = obj1;
            j.a(i, s1);
              goto _L23
            abyte0;
_L30:
            obj6 = obj;
            obj3 = obj1;
            DownloadingService.a(a).b(b, i);
            obj6 = obj;
            obj3 = obj1;
            abyte0.printStackTrace();
            if (obj1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((InputStream) (obj1)).close();
            if (obj == null) goto _L14; else goto _L24
_L24:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj3;
            ((RemoteException) (obj3)).printStackTrace();
            DownloadingService.a(a).b(b, i);
            a(((Exception) (abyte0)));
            DownloadingService.d(a).post(new _cls1(this));
              goto _L25
            obj3;
            abyte0 = ((byte []) (obj1));
            obj1 = obj3;
_L29:
            if (abyte0 == null)
            {
                break MISSING_BLOCK_LABEL_1578;
            }
            abyte0.close();
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            obj3;
            DownloadingService.a(a).b(b, i);
            a(((Exception) (abyte0)));
            DownloadingService.d(a).post(new _cls1(this));
            throw obj3;
_L11:
            a();
              goto _L25
            obj1;
            ((IOException) (obj1)).printStackTrace();
            if (obj == null) goto _L14; else goto _L26
_L26:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj1;
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            obj1;
            ((IOException) (obj1)).printStackTrace();
            if (obj == null) goto _L14; else goto _L27
_L27:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj1;
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            abyte0;
            abyte0.printStackTrace();
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            break MISSING_BLOCK_LABEL_1586;
            obj1;
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            obj1;
            ((IOException) (obj1)).printStackTrace();
            if (obj == null) goto _L14; else goto _L28
_L28:
            try
            {
                ((FileOutputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            return;
            obj1;
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                }
            }
            throw obj1;
            obj1;
            obj = null;
            abyte0 = null;
              goto _L29
            obj1;
            abyte0 = null;
              goto _L29
            obj3;
            obj = obj1;
            abyte0 = null;
            obj1 = obj3;
              goto _L29
            obj1;
            abyte0 = null;
              goto _L29
            obj1;
            obj = obj6;
            abyte0 = ((byte []) (obj3));
              goto _L29
            abyte0;
            obj = null;
            obj1 = null;
              goto _L30
            abyte0;
            obj1 = null;
              goto _L30
            abyte0;
            obj = obj1;
            obj1 = null;
              goto _L30
            abyte0;
            obj1 = null;
              goto _L30
            abyte0;
            Object obj4 = null;
            obj = obj1;
            obj1 = obj4;
              goto _L31
            abyte0;
            obj1 = null;
              goto _L31
            abyte0;
            Object obj5 = null;
            obj = obj1;
            obj1 = obj5;
              goto _L31
            abyte0;
            obj1 = null;
              goto _L31
            j1 = 1;
              goto _L6
        }

        static DownloadingService b(b b1)
        {
            return b1.a;
        }

        private void b()
        {
            if (k.f != null)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("dsize", String.valueOf(g));
                hashmap.put("dtime", u.upd.n.a().split(" ")[1]);
                hashmap.put("ptimes", String.valueOf(e));
                DownloadingService.a(a).a(hashmap, true, k.f);
            }
        }

        private void b(int i1)
            throws RemoteException
        {
            try
            {
                if (DownloadingService.c().get(k) != null)
                {
                    ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 3, i1, 0));
                }
                return;
            }
            catch (DeadObjectException deadobjectexception)
            {
                u.upd.b.b(DownloadingService.a(), String.format("Service Client for downloading %1$15s is dead. Removing messenger from the service", new Object[] {
                    k.b
                }));
            }
            DownloadingService.c().put(k, null);
        }

        public void a(int i1)
        {
            h = i1;
        }

        public void run()
        {
            boolean flag;
            flag = false;
            e = 0;
            if (j != null)
            {
                j.a(i);
            }
            if (f > 0L)
            {
                flag = true;
            }
            try
            {
                a(flag);
                if (DownloadingService.c().size() <= 0)
                {
                    a.stopSelf();
                }
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return;
        }

        public b(Context context, a.a a1, int i1, int j1, a a2)
        {
            a = DownloadingService.this;
            super();
            e = 0;
            f = -1L;
            g = -1L;
            h = -1;
            b = context;
            k = a1;
            e = j1;
            if (com.umeng.update.net.DownloadingService.b().indexOfKey(i1) < 0)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            downloadingservice = ((c.b)com.umeng.update.net.DownloadingService.b().get(i1)).f;
            if (DownloadingService.this == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            if (DownloadingService.this.length > 1)
            {
                f = DownloadingService.this[0];
                g = DownloadingService.this[1];
            }
            j = a2;
            i = i1;
            downloadingservice = new boolean[1];
            d = com.umeng.update.net.j.a("/apk", context, DownloadingService.this);
            c = DownloadingService.this[0];
            long l1;
            if (c)
            {
                l1 = 0x6400000L;
            } else
            {
                l1 = 0xa00000L;
            }
            try
            {
                com.umeng.update.net.j.a(d, l1, 0xf731400L);
                downloadingservice = a(k);
                d = new File(d, DownloadingService.this);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (DownloadingService downloadingservice)
            {
                u.upd.b.c(DownloadingService.a(), getMessage(), DownloadingService.this);
            }
            j.a(i, DownloadingService.this);
            return;
        }
    }

    class c extends Handler
    {

        final DownloadingService a;

        public void handleMessage(Message message)
        {
            u.upd.b.c(DownloadingService.a(), (new StringBuilder("IncomingHandler(msg.what:")).append(message.what).append(" msg.arg1:").append(message.arg1).append(" msg.arg2:").append(message.arg2).append(" msg.replyTo:").append(message.replyTo).toString());
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
            u.upd.b.c(DownloadingService.a(), (new StringBuilder("IncomingHandler(msg.getData():")).append(obj).toString());
            obj = com.umeng.update.net.a.a.a(((Bundle) (obj)));
            if (DownloadingService.a(a).a(((a.a) (obj)), DownloadingService.r, message.replyTo))
            {
                u.upd.b.a(DownloadingService.a(), (new StringBuilder(String.valueOf(((a.a) (obj)).b))).append(" is already in downloading list. ").toString());
                int i1 = DownloadingService.a(a).b(((a.a) (obj)));
                if (i1 != -1 && ((c.b)com.umeng.update.net.DownloadingService.b().get(i1)).a == null)
                {
                    message = com.umeng.update.net.f.a(i1, "continue");
                    obj = new Intent(com.umeng.update.net.DownloadingService.b(a), com/umeng/update/net/DownloadingService);
                    ((Intent) (obj)).putExtra("com.umeng.broadcast.download.msg", message);
                    DownloadingService.a(a).a(a, ((Intent) (obj)));
                    return;
                }
                Toast.makeText(com.umeng.update.net.DownloadingService.b(a), u.upd.l.b(com.umeng.update.net.DownloadingService.b(a)), 0).show();
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
                DownloadingService.a(a, ((a.a) (obj)));
                return;
            }
            Toast.makeText(com.umeng.update.net.DownloadingService.b(a), u.upd.l.a(com.umeng.update.net.DownloadingService.b(a)), 0).show();
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

        c()
        {
            a = DownloadingService.this;
            super();
        }
    }


    private static final long C = 8000L;
    private static final long D = 500L;
    private static Map E = new HashMap();
    private static SparseArray F = new SparseArray();
    private static Boolean I = Boolean.valueOf(false);
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    static final int o = 100;
    static final String p = "filename";
    public static boolean r = false;
    private static final String t = com/umeng/update/net/DownloadingService.getName();
    private static final long w = 0x6400000L;
    private static final long x = 0xa00000L;
    private static final long y = 0xf731400L;
    private static final int z = 3;
    private Context A;
    private Handler B;
    private e G;
    private boolean H;
    a q;
    final Messenger s = new Messenger(new c());
    private NotificationManager u;
    private com.umeng.update.net.c v;

    public DownloadingService()
    {
        H = true;
    }

    static com.umeng.update.net.c a(DownloadingService downloadingservice)
    {
        return downloadingservice.v;
    }

    static String a()
    {
        return t;
    }

    static void a(DownloadingService downloadingservice, NotificationManager notificationmanager)
    {
        downloadingservice.u = notificationmanager;
    }

    static void a(DownloadingService downloadingservice, a.a a1)
    {
        downloadingservice.a(a1);
    }

    static void a(DownloadingService downloadingservice, String s1)
    {
        downloadingservice.a(s1);
    }

    private void a(a.a a1)
    {
        int i1;
        i1 = 0;
        u.upd.b.c(t, (new StringBuilder("startDownload([mComponentName:")).append(a1.a).append(" mTitle:").append(a1.b).append(" mUrl:").append(a1.c).append("])").toString());
        int j1 = v.a(a1);
        b b1 = new b(getApplicationContext(), a1, j1, 0, q);
        a1 = new c.b(a1, j1);
        G.a(j1);
        a1.a(F);
        a1.a = b1;
        b1.start();
        e();
        if (!r) goto _L2; else goto _L1
_L1:
        if (i1 < F.size()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        a1 = (c.b)F.valueAt(i1);
        u.upd.b.c(t, (new StringBuilder("Running task ")).append(((c.b) (a1)).e.b).toString());
        i1++;
        if (true) goto _L1; else goto _L4
_L4:
    }

    static void a(Boolean boolean1)
    {
        I = boolean1;
    }

    private void a(String s1)
    {
        synchronized (I)
        {
            if (!I.booleanValue())
            {
                u.upd.b.c(t, (new StringBuilder("show single toast.[")).append(s1).append("]").toString());
                I = Boolean.valueOf(true);
                B.post(new Runnable(s1) {

                    final DownloadingService a;
                    private final String b;

                    public void run()
                    {
                        Toast.makeText(com.umeng.update.net.DownloadingService.b(a), b, 0).show();
                    }

            
            {
                a = DownloadingService.this;
                b = s1;
                super();
            }
                });
                B.postDelayed(new Runnable() {

                    final DownloadingService a;

                    public void run()
                    {
                        DownloadingService.a(Boolean.valueOf(false));
                    }

            
            {
                a = DownloadingService.this;
                super();
            }
                }, 1200L);
            }
        }
        return;
        s1;
        boolean1;
        JVM INSTR monitorexit ;
        throw s1;
    }

    static Context b(DownloadingService downloadingservice)
    {
        return downloadingservice.A;
    }

    static SparseArray b()
    {
        return F;
    }

    static NotificationManager c(DownloadingService downloadingservice)
    {
        return downloadingservice.u;
    }

    static Map c()
    {
        return E;
    }

    static Handler d(DownloadingService downloadingservice)
    {
        return downloadingservice.B;
    }

    private void d()
    {
        Iterator iterator = G.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Integer integer = (Integer)iterator.next();
            u.cancel(integer.intValue());
        } while (true);
    }

    private void e()
    {
        if (r)
        {
            int i1 = E.size();
            int j1 = F.size();
            u.upd.b.a(t, (new StringBuilder("Client size =")).append(i1).append("   cacheSize = ").append(j1).toString());
            if (i1 != j1)
            {
                throw new RuntimeException((new StringBuilder("Client size =")).append(i1).append("   cacheSize = ").append(j1).toString());
            }
        }
    }

    public IBinder onBind(Intent intent)
    {
        u.upd.b.c(t, "onBind ");
        return s.getBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        if (r)
        {
            u.upd.b.a = true;
            Debug.waitForDebugger();
        }
        u.upd.b.c(t, "onCreate ");
        u = (NotificationManager)getSystemService("notification");
        A = this;
        G = new e(A);
        v = new com.umeng.update.net.c(F, E, G);
        B = new Handler() {

            final DownloadingService a;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 5 6: default 28
            //                           5 29
            //                           6 471;
                   goto _L1 _L2 _L3
_L1:
                return;
_L2:
                a.a a1;
                int i1;
                a1 = (a.a)message.obj;
                i1 = message.arg2;
                String s1;
                Intent intent;
                PendingIntent pendingintent;
                s1 = message.getData().getString("filename");
                com.umeng.update.net.j.a(s1, 39, -1, -1);
                u.upd.b.c(DownloadingService.a(), "Cancel old notification....");
                intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(0x10000000);
                intent.setDataAndType(Uri.fromFile(new File(s1)), "application/vnd.android.package-archive");
                pendingintent = PendingIntent.getActivity(com.umeng.update.net.DownloadingService.b(a), 0, intent, 0x8000000);
                if (!a1.h) goto _L5; else goto _L4
_L4:
                message = new Notification(0x1080082, com.umeng.update.net.DownloadingService.b(a).getString(u.upd.l.m(com.umeng.update.net.DownloadingService.b(a))), System.currentTimeMillis());
                message.setLatestEventInfo(com.umeng.update.net.DownloadingService.b(a), a1.b, com.umeng.update.net.DownloadingService.b(a).getString(u.upd.l.m(com.umeng.update.net.DownloadingService.b(a))), pendingintent);
_L8:
                boolean flag;
                message.flags = 16;
                DownloadingService.a(a, (NotificationManager)a.getSystemService("notification"));
                DownloadingService.c(a).notify(i1 + 1, message);
                u.upd.b.c(DownloadingService.a(), "Show new  notification....");
                flag = DownloadingService.a(a).a(com.umeng.update.net.DownloadingService.b(a));
                u.upd.b.c(DownloadingService.a(), String.format("isAppOnForeground = %1$B", new Object[] {
                    Boolean.valueOf(flag)
                }));
                if (!flag) goto _L7; else goto _L6
_L6:
                if (!a1.h)
                {
                    DownloadingService.c(a).cancel(i1 + 1);
                    com.umeng.update.net.DownloadingService.b(a).startActivity(intent);
                }
_L7:
                u.upd.b.a(DownloadingService.a(), String.format("%1$10s downloaded. Saved to: %2$s", new Object[] {
                    a1.b, s1
                }));
                return;
_L5:
                try
                {
                    message = new Notification(0x1080082, com.umeng.update.net.DownloadingService.b(a).getString(u.upd.l.k(com.umeng.update.net.DownloadingService.b(a))), System.currentTimeMillis());
                    message.setLatestEventInfo(com.umeng.update.net.DownloadingService.b(a), a1.b, com.umeng.update.net.DownloadingService.b(a).getString(u.upd.l.k(com.umeng.update.net.DownloadingService.b(a))), pendingintent);
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    u.upd.b.b(DownloadingService.a(), (new StringBuilder("can not install. ")).append(message.getMessage()).toString());
                    DownloadingService.c(a).cancel(i1 + 1);
                    return;
                }
                  goto _L8
_L3:
                a.a a2 = (a.a)message.obj;
                int j1 = message.arg2;
                message = message.getData().getString("filename");
                DownloadingService.c(a).cancel(j1);
                Object obj = new Notification(0x1080081, com.umeng.update.net.DownloadingService.b(a).getString(u.upd.l.n(com.umeng.update.net.DownloadingService.b(a))), System.currentTimeMillis());
                Object obj1 = PendingIntent.getActivity(com.umeng.update.net.DownloadingService.b(a), 0, new Intent(), 0x8000000);
                ((Notification) (obj)).setLatestEventInfo(com.umeng.update.net.DownloadingService.b(a), u.upd.a.v(com.umeng.update.net.DownloadingService.b(a)), com.umeng.update.net.DownloadingService.b(a).getString(u.upd.l.n(com.umeng.update.net.DownloadingService.b(a))), ((PendingIntent) (obj1)));
                DownloadingService.c(a).notify(j1 + 1, ((Notification) (obj)));
                obj = message.replace(".patch", ".apk");
                obj1 = DeltaUpdate.a(a);
                com.umeng.update.net.c c1 = DownloadingService.a(a);
                c1.getClass();
                (new c.c(c1, com.umeng.update.net.DownloadingService.b(a), j1, a2, ((String) (obj)))).execute(new String[] {
                    obj1, obj, message
                });
                return;
            }

            
            {
                a = DownloadingService.this;
                super();
            }
        };
        q = new a() {

            SparseArray a;
            final DownloadingService b;

            public void a(int i1)
            {
                boolean flag = false;
                if (com.umeng.update.net.DownloadingService.b().indexOfKey(i1) >= 0)
                {
                    c.b b1 = (c.b)com.umeng.update.net.DownloadingService.b().get(i1);
                    long al[] = b1.f;
                    int j1 = ((flag) ? 1 : 0);
                    if (al != null)
                    {
                        j1 = ((flag) ? 1 : 0);
                        if (al[1] > 0L)
                        {
                            int k1 = (int)(((float)al[0] / (float)al[1]) * 100F);
                            j1 = k1;
                            if (k1 > 100)
                            {
                                j1 = 99;
                            }
                        }
                    }
                    if (!b1.e.h)
                    {
                        a.put(i1, Long.valueOf(-1L));
                        c.a a1 = DownloadingService.a(b).a(b, b1.e, i1, j1);
                        b1.b = a1;
                        DownloadingService.c(b).notify(i1, a1.d());
                    }
                }
            }

            public void a(int i1, int j1)
            {
                if (com.umeng.update.net.DownloadingService.b().indexOfKey(i1) >= 0)
                {
                    Object obj = (c.b)com.umeng.update.net.DownloadingService.b().get(i1);
                    a.a a1 = ((c.b) (obj)).e;
                    long l1 = System.currentTimeMillis();
                    if (!a1.h && l1 - ((Long)a.get(i1)).longValue() > 500L)
                    {
                        a.put(i1, Long.valueOf(l1));
                        obj = ((c.b) (obj)).b;
                        ((c.a) (obj)).a(100, j1, false).a((new StringBuilder(String.valueOf(String.valueOf(j1)))).append("%").toString());
                        DownloadingService.c(b).notify(i1, ((c.a) (obj)).d());
                    }
                    u.upd.b.c(DownloadingService.a(), String.format("%3$10s Notification: mNotificationId = %1$15s\t|\tprogress = %2$15s", new Object[] {
                        Integer.valueOf(i1), Integer.valueOf(j1), a1.b
                    }));
                }
            }

            public void a(int i1, Exception exception)
            {
                if (com.umeng.update.net.DownloadingService.b().indexOfKey(i1) >= 0)
                {
                    DownloadingService.a(b).b(com.umeng.update.net.DownloadingService.b(b), i1);
                }
            }

            public void a(int i1, String s1)
            {
                Object obj;
                Bundle bundle;
label0:
                {
                    if (com.umeng.update.net.DownloadingService.b().indexOfKey(i1) >= 0)
                    {
                        obj = (c.b)com.umeng.update.net.DownloadingService.b().get(i1);
                        if (obj != null)
                        {
                            obj = ((c.b) (obj)).e;
                            com.umeng.update.net.b.a(com.umeng.update.net.DownloadingService.b(b)).a(((a.a) (obj)).a, ((a.a) (obj)).c, 100);
                            bundle = new Bundle();
                            bundle.putString("filename", s1);
                            if (!((a.a) (obj)).a.equalsIgnoreCase("delta_update"))
                            {
                                break label0;
                            }
                            s1 = Message.obtain();
                            s1.what = 6;
                            s1.arg1 = 1;
                            s1.obj = obj;
                            s1.arg2 = i1;
                            s1.setData(bundle);
                            DownloadingService.d(b).sendMessage(s1);
                        }
                    }
                    return;
                }
                s1 = Message.obtain();
                s1.what = 5;
                s1.arg1 = 1;
                s1.obj = obj;
                s1.arg2 = i1;
                s1.setData(bundle);
                DownloadingService.d(b).sendMessage(s1);
                s1 = Message.obtain();
                s1.what = 5;
                s1.arg1 = 1;
                s1.arg2 = i1;
                s1.setData(bundle);
                try
                {
                    if (DownloadingService.c().get(obj) != null)
                    {
                        ((Messenger)DownloadingService.c().get(obj)).send(s1);
                    }
                    DownloadingService.a(b).b(com.umeng.update.net.DownloadingService.b(b), i1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    DownloadingService.a(b).b(com.umeng.update.net.DownloadingService.b(b), i1);
                }
            }

            
            {
                b = DownloadingService.this;
                super();
                a = new SparseArray();
            }
        };
    }

    public void onDestroy()
    {
        try
        {
            com.umeng.update.net.b.a(getApplicationContext()).a(0x3f480);
            com.umeng.update.net.b.a(getApplicationContext()).finalize();
        }
        catch (Exception exception)
        {
            u.upd.b.b(t, exception.getMessage());
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i1, int j1)
    {
        if (intent != null && intent.getExtras() != null)
        {
            v.a(this, intent);
        }
        if (android.os.Build.VERSION.SDK_INT >= 19 && (G.b() || H))
        {
            try
            {
                intent = new Intent(getApplicationContext(), getClass());
                intent.setPackage(getPackageName());
                intent = PendingIntent.getService(getApplicationContext(), 1, intent, 0x40000000);
                ((AlarmManager)getApplicationContext().getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 5000L, intent);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
        }
        if (H)
        {
            d();
            H = false;
        }
        return 1;
    }

    static 
    {
        r = false;
    }
}
