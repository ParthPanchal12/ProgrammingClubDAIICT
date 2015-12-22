// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.text.TextUtils;
import com.umeng.common.message.Log;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            PushAgent, UHandler, MessageSharedPrefs

public class UmengDownloadResourceService extends Service
{
    public class DownloadResourceTask extends AsyncTask
    {

        UMessage a;
        ArrayList b;
        int c;
        final UmengDownloadResourceService d;

        protected transient Boolean a(Void avoid[])
        {
            avoid = b.iterator();
            boolean flag;
            for (flag = true; avoid.hasNext(); flag = download((String)avoid.next()) & flag) { }
            return Boolean.valueOf(flag);
        }

        protected void a(Boolean boolean1)
        {
            super.onPostExecute(boolean1);
            d.c.remove(a.msg_id);
            if (boolean1.booleanValue() || c <= 0)
            {
                MessageSharedPrefs.getInstance(d.b).c(a.msg_id);
                boolean1 = a.getRaw().toString();
                Intent intent = new Intent(d.b, com/umeng/message/UmengDownloadResourceService);
                intent.putExtra("body", boolean1);
                intent.putExtra("OPERATIOIN", 1);
                intent.putExtra("RETRY_TIME", c);
                d.startService(intent);
            } else
            if (d.c.size() == 0)
            {
                d.stopSelf();
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        public boolean download(String s)
        {
            Object obj;
            Exception exception = null;
            Object obj1 = null;
            if (TextUtils.isEmpty(s))
            {
                return true;
            }
            Exception exception1;
            File file;
            Object obj2;
            int i1;
            boolean flag;
            try
            {
                obj2 = (new StringBuilder()).append(s.hashCode()).append("").toString();
                obj = UmengDownloadResourceService.getMessageResourceFolder(d.b, a);
                file = new File(((String) (obj)), (new StringBuilder()).append(((String) (obj2))).append(".tmp").toString());
                obj2 = new File(((String) (obj)), ((String) (obj2)));
                flag = ((File) (obj2)).exists();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                s = null;
                continue; /* Loop/switch isn't completed */
            }
            finally
            {
                s = null;
                obj1 = exception;
            }
_L4:
            if (flag)
            {
                d.close(null);
                d.close(null);
                return true;
            }
            obj = new File(((String) (obj)));
            if (!((File) (obj)).exists())
            {
                ((File) (obj)).mkdirs();
            }
            if (file.exists())
            {
                file.delete();
            }
            s = (new URL((new URI(s)).toASCIIString())).openStream();
            obj = new FileOutputStream(file);
            obj1 = new byte[10240];
_L3:
            i1 = s.read(((byte []) (obj1)));
            if (i1 <= 0) goto _L2; else goto _L1
_L1:
            ((FileOutputStream) (obj)).write(((byte []) (obj1)), 0, i1);
              goto _L3
            exception;
            obj1 = obj;
            obj = exception;
_L7:
            ((Exception) (obj)).printStackTrace();
            d.close(s);
            d.close(((Closeable) (obj1)));
            return false;
_L2:
            file.renameTo(((File) (obj2)));
            d.close(s);
            d.close(((Closeable) (obj)));
            return true;
_L5:
            d.close(s);
            d.close(((Closeable) (obj1)));
            throw obj;
            obj;
            obj1 = exception;
            continue; /* Loop/switch isn't completed */
            exception1;
            obj1 = obj;
            obj = exception1;
            continue; /* Loop/switch isn't completed */
            obj;
            if (true) goto _L5; else goto _L4
            obj;
            if (true) goto _L7; else goto _L6
_L6:
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

        public DownloadResourceTask(UMessage umessage, int i1)
        {
            d = UmengDownloadResourceService.this;
            super();
            a = umessage;
            b = new ArrayList();
            if (umessage.isLargeIconFromInternet())
            {
                b.add(umessage.img);
            }
            if (umessage.isSoundFromInternet())
            {
                b.add(umessage.sound);
            }
            c = i1;
        }
    }


    public static final String TAG = com/umeng/message/UmengDownloadResourceService.getSimpleName();
    private static final String d = ".tmp";
    private static final String e = "RETRY_TIME";
    private static final String f = "OPERATIOIN";
    private static final int g = 1;
    private static final int h = 2;
    private static final long i = 0x100000L;
    private static final long j = 0x5265c00L;
    private static final int k = 0x493e0;
    private static final int l = 3;
    private static Thread m;
    ScheduledThreadPoolExecutor a;
    Context b;
    ArrayList c;

    public UmengDownloadResourceService()
    {
    }

    private static long a(File file)
    {
        if (file != null && file.exists() && file.isDirectory()) goto _L2; else goto _L1
_L1:
        long l2 = 0L;
_L4:
        return l2;
_L2:
        Stack stack = new Stack();
        stack.clear();
        stack.push(file);
        long l1 = 0L;
        do
        {
            l2 = l1;
            if (stack.isEmpty())
            {
                continue;
            }
            file = ((File)stack.pop()).listFiles();
            int j1 = file.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                File file1 = file[i1];
                long l3 = l1;
                if (!file1.isDirectory())
                {
                    l3 = l1 + file1.length();
                }
                i1++;
                l1 = l3;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private PendingIntent a(UMessage umessage, int i1)
    {
        Object obj = umessage.getRaw().toString();
        int j1 = umessage.msg_id.hashCode();
        Intent intent = new Intent(b, com/umeng/message/UmengDownloadResourceService);
        intent.putExtra("body", ((String) (obj)));
        intent.putExtra("OPERATIOIN", 2);
        intent.putExtra("RETRY_TIME", i1);
        obj = PendingIntent.getService(b, j1, intent, 0x8000000);
        Log.a(TAG, (new StringBuilder()).append("PendingIntent: msgId:").append(umessage.msg_id).append(",requestCode:").append(j1).append(",retryTime:").append(i1).toString());
        return ((PendingIntent) (obj));
    }

    static Thread a(Thread thread)
    {
        m = thread;
        return thread;
    }

    static void a(File file, long l1)
    {
        b(file, l1);
    }

    private static void b(File file, long l1)
    {
        if (file != null && file.exists() && file.canWrite() && file.isDirectory())
        {
            file = file.listFiles();
            int j1 = file.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                File file1 = file[i1];
                if (!file1.isDirectory() && System.currentTimeMillis() - file1.lastModified() > l1)
                {
                    file1.delete();
                }
                i1++;
            }
        }
    }

    public static void checkDir(File file, long l1, long l2)
        throws IOException
    {
        if (file.exists() && a(file.getCanonicalFile()) > l1)
        {
            if (m == null)
            {
                m = new Thread(new Runnable(file, l2) {

                    final File a;
                    final long b;

                    public void run()
                    {
                        UmengDownloadResourceService.a(a, b);
                        UmengDownloadResourceService.a(null);
                    }

            
            {
                a = file;
                b = l1;
                super();
            }
                });
            }
            synchronized (m)
            {
                m.start();
            }
            return;
        } else
        {
            return;
        }
        exception;
        file;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getMessageResourceFolder(Context context, UMessage umessage)
    {
        String s = (new StringBuilder()).append(context.getCacheDir()).append("/umeng_push/").toString();
        context = s;
        if (umessage != null)
        {
            context = s;
            if (umessage.msg_id != null)
            {
                context = (new StringBuilder()).append(s).append(umessage.msg_id).append("/").toString();
            }
        }
        return context;
    }

    public void checkCache()
    {
        try
        {
            checkDir(new File(getMessageResourceFolder(b, null)), 0x100000L, 0x5265c00L);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public void close(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        closeable.printStackTrace();
        return;
    }

    public void deleteAlarm(UMessage umessage, int i1)
    {
        Log.a(TAG, "deleteAlarm");
        umessage = a(umessage, i1);
        ((AlarmManager)getSystemService("alarm")).cancel(umessage);
    }

    public void downloadResource(UMessage umessage, int i1)
    {
        umessage = new DownloadResourceTask(umessage, i1);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            umessage.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            umessage.execute(new Void[0]);
            return;
        }
    }

    public void notification(UMessage umessage)
    {
        UHandler uhandler = PushAgent.getInstance(this).getMessageHandler();
        if (uhandler != null)
        {
            uhandler.handleMessage(this, umessage);
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
        b = this;
        c = new ArrayList();
    }

    public int onStartCommand(Intent intent, int i1, int j1)
    {
        Object obj;
        int k1;
        int i2;
        if (intent == null)
        {
            return super.onStartCommand(intent, i1, j1);
        }
        k1 = intent.getIntExtra("OPERATIOIN", 2);
        i2 = intent.getIntExtra("RETRY_TIME", 3);
        obj = intent.getStringExtra("body");
        obj = new UMessage(new JSONObject(((String) (obj))));
        if (c.contains(((UMessage) (obj)).msg_id))
        {
            return super.onStartCommand(intent, i1, j1);
        }
        c.add(((UMessage) (obj)).msg_id);
        k1;
        JVM INSTR tableswitch 1 2: default 116
    //                   1 172
    //                   2 124;
           goto _L1 _L2 _L3
_L1:
        return super.onStartCommand(intent, i1, j1);
_L3:
        Log.a(TAG, "Start Download Resource");
        int l1 = i2 - 1;
        try
        {
            setAlarm(((UMessage) (obj)), l1);
            checkCache();
            downloadResource(((UMessage) (obj)), l1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
          goto _L1
_L2:
        deleteAlarm(((UMessage) (obj)), i2);
        Log.a(TAG, "Show Notification After Downloaded Resource");
        notification(((UMessage) (obj)));
        c.remove(((UMessage) (obj)).msg_id);
        if (c.size() == 0)
        {
            stopSelf();
        }
          goto _L1
    }

    public void setAlarm(UMessage umessage, int i1)
    {
        Log.a(TAG, "setAlarm");
        umessage = a(umessage, i1);
        ((AlarmManager)getSystemService("alarm")).set(1, System.currentTimeMillis() + 0x493e0L, umessage);
    }

}
