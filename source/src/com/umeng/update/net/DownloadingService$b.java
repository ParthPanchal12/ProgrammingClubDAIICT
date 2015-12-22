// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import u.upd.a;
import u.upd.b;
import u.upd.l;
import u.upd.n;

// Referenced classes of package com.umeng.update.net:
//            DownloadingService, j, c, f, 
//            b

class i extends Thread
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
    private opSelf j;
    private opSelf k;

    static Context a(i i1)
    {
        return i1.b;
    }

    private String a(b b1)
    {
        Object obj;
        if (k.k != null)
        {
            b1 = (new StringBuilder(String.valueOf(k.k))).append(".apk.tmp").toString();
        } else
        {
            b1 = (new StringBuilder(String.valueOf(n.a(k.k)))).append(".apk.tmp").toString();
        }
        obj = b1;
        if (k.k.equalsIgnoreCase("delta_update"))
        {
            obj = b1.replace(".apk", ".patch");
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
            u.upd.b.c(com.umeng.update.net.DownloadingService.a(), String.format((new StringBuilder(String.valueOf(k.k))).append(" getFileLength: %1$15s").toString(), new Object[] {
                Long.valueOf(file.length())
            }));
            url.setRequestProperty("Range", (new StringBuilder("bytes=")).append(file.length()).append("-").toString());
        }
        return url;
    }

    private void a()
    {
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("wait for repeating Test network repeat count=")).append(e).toString());
        if (k.k)
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
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
        return;
        Object obj = (i)com.umeng.update.net.DownloadingService.b().get(i);
        ((i) (obj)).i[0] = f;
        ((f) (obj)).f[1] = g;
        ((g) (obj)).g[2] = e;
        obj = com.umeng.update.net.f.a(i, "continue");
        Intent intent = new Intent(b, com/umeng/update/net/DownloadingService);
        intent.putExtra("com.umeng.broadcast.download.msg", ((String) (obj)));
        com.umeng.update.net.DownloadingService.a(a).a(a, intent);
        com.umeng.update.net.DownloadingService.a(a, b.getString(l.c(b)));
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), "changed play state button on op-notification.");
        return;
    }

    private void a(File file, String s)
        throws RemoteException
    {
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("itemMd5 ")).append(k.k).toString());
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("fileMd5 ")).append(n.a(file)).toString());
        if (k.k == null || k.k.equalsIgnoreCase(n.a(file)))
        {
            break MISSING_BLOCK_LABEL_206;
        }
        if (!k.k.equalsIgnoreCase("delta_update"))
        {
            break MISSING_BLOCK_LABEL_227;
        }
        DownloadingService.c(a).cancel(i);
        file = new Bundle();
        file.putString("filename", s);
        s = Message.obtain();
        s.what = 5;
        s.arg1 = 3;
        s.arg2 = i;
        s.setData(file);
        if (DownloadingService.c().get(k) != null)
        {
            ((Messenger)DownloadingService.c().get(k)).send(s);
        }
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
_L1:
        return;
        file;
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
        return;
        ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 5, 0, 0));
        if (!k.k)
        {
            com.umeng.update.net.DownloadingService.a(a).b(b, i);
            file = new Notification(0x1080082, b.getString(l.i(b)), System.currentTimeMillis());
            s = PendingIntent.getActivity(b, 0, new Intent(), 0);
            file.setLatestEventInfo(b, u.upd.a.v(b), (new StringBuilder(String.valueOf(k.k))).append(b.getString(l.i(b))).toString(), s);
            file.flags = ((Notification) (file)).flags | 0x10;
            DownloadingService.c(a).notify(i, file);
            return;
        }
          goto _L1
    }

    private void a(Exception exception)
    {
        u.upd.b.b(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("can not install. ")).append(exception.getMessage()).toString());
        if (j != null)
        {
            j.a(i, exception);
        }
        com.umeng.update.net.DownloadingService.a(a).a(k, f, g, e);
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
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), String.format("saveAPK: url = %1$15s\t|\tfilename = %2$15s", new Object[] {
            k.k, d.getAbsolutePath()
        }));
        obj2 = a(new URL(k.k), d);
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
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), String.format("getFileLength: %1$15s", new Object[] {
            Long.valueOf(f)
        }));
        obj6 = obj;
        obj3 = obj1;
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), String.format("getConnectionLength: %1$15s", new Object[] {
            Integer.valueOf(((HttpURLConnection) (obj2)).getContentLength())
        }));
        obj6 = obj;
        obj3 = obj1;
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), String.format("getContentLength: %1$15s", new Object[] {
            Long.valueOf(g)
        }));
        obj6 = obj;
        obj3 = obj1;
        byte abyte0[] = new byte[4096];
        obj6 = obj;
        obj3 = obj1;
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), (new StringBuilder(String.valueOf(k.k))).append("saveAPK getContentLength ").append(String.valueOf(g)).toString());
        obj6 = obj;
        obj3 = obj1;
        com.umeng.update.net.b.a(b).a(k.k, k.k);
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
        abyte0 = (h)com.umeng.update.net.DownloadingService.b().get(i);
        obj6 = obj;
        obj3 = obj1;
        ((i) (abyte0)).i[0] = f;
        obj6 = obj;
        obj3 = obj1;
        ((f) (abyte0)).f[1] = g;
        obj6 = obj;
        obj3 = obj1;
        ((g) (abyte0)).g[2] = e;
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
        if (!k.k) goto _L8; else goto _L9
_L9:
        obj6 = obj;
        obj3 = obj1;
        u.upd.b.b(com.umeng.update.net.DownloadingService.a(), "no wifi");
        obj6 = obj;
        obj3 = obj1;
        throw new IOException("no wifi");
        abyte0;
_L31:
        u.upd.b.c(com.umeng.update.net.DownloadingService.a(), abyte0.getMessage(), abyte0);
        i1 = e + 1;
        e = i1;
        if (i1 <= 3) goto _L11; else goto _L10
_L10:
        flag = k.k;
        if (flag) goto _L11; else goto _L12
_L12:
        u.upd.b.b(com.umeng.update.net.DownloadingService.a(), "Download Fail out of max repeat count");
        ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 5, 0, 0));
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
        a(((Exception) (abyte0)));
        DownloadingService.d(a).post(new Runnable() {

            final DownloadingService.b a;

            public void run()
            {
                Toast.makeText(com.umeng.update.net.DownloadingService.b.b(a), l.i(com.umeng.update.net.DownloadingService.b.a(a)), 0).show();
            }

            
            {
                a = DownloadingService.b.this;
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
        com.umeng.update.net.b.a(b).a(k.k, k.k, j1);
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
        com.umeng.update.net.DownloadingService.a(a).a(k, f, g, e);
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
        u.upd.b.b(com.umeng.update.net.DownloadingService.a(), (new StringBuilder("Download Fail repeat count=")).append(e).toString());
        obj6 = obj;
        obj3 = obj1;
        ((Messenger)DownloadingService.c().get(k)).send(Message.obtain(null, 5, 0, 0));
        obj6 = obj;
        obj3 = obj1;
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
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
        String s = abyte0.getAbsolutePath();
        obj6 = obj;
        obj3 = obj1;
        a(((File) (abyte0)), s);
        obj6 = obj;
        obj3 = obj1;
        if (j == null) goto _L23; else goto _L22
_L22:
        obj6 = obj;
        obj3 = obj1;
        j.a(i, s);
          goto _L23
        abyte0;
_L30:
        obj6 = obj;
        obj3 = obj1;
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
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
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
        a(((Exception) (abyte0)));
        DownloadingService.d(a).post(new _cls1());
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
        com.umeng.update.net.DownloadingService.a(a).b(b, i);
        a(((Exception) (abyte0)));
        DownloadingService.d(a).post(new _cls1());
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

    static DownloadingService b(a a1)
    {
        return a1.a;
    }

    private void b()
    {
        if (k.k != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("dsize", String.valueOf(g));
            hashmap.put("dtime", n.a().split(" ")[1]);
            hashmap.put("ptimes", String.valueOf(e));
            com.umeng.update.net.DownloadingService.a(a).a(hashmap, true, k.k);
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
            u.upd.b.b(com.umeng.update.net.DownloadingService.a(), String.format("Service Client for downloading %1$15s is dead. Removing messenger from the service", new Object[] {
                k.k
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

    public _cls1.a(DownloadingService downloadingservice, Context context, _cls1.a a1, int i1, int j1, _cls1.a a2)
    {
        a = downloadingservice;
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
        downloadingservice = ((e)com.umeng.update.net.DownloadingService.b().get(i1)).e;
        if (downloadingservice == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (downloadingservice.length > 1)
        {
            f = downloadingservice[0];
            g = downloadingservice[1];
        }
        j = a2;
        i = i1;
        downloadingservice = new boolean[1];
        d = com.umeng.update.net.j.a("/apk", context, downloadingservice);
        c = downloadingservice[0];
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
            d = new File(d, downloadingservice);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DownloadingService downloadingservice)
        {
            u.upd.b.c(com.umeng.update.net.DownloadingService.a(), downloadingservice.getMessage(), downloadingservice);
        }
        j.a(i, downloadingservice);
        return;
    }
}
