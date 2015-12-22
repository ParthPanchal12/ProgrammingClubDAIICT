// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.proc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import com.umeng.message.proguard.by;
import org.android.agoo.client.IntentHelper;

// Referenced classes of package org.android.agoo.proc:
//            ServiceProtect

public abstract class b extends Service
    implements android.os.Handler.Callback
{

    private static final int b = 0;
    private static final String c = "cockroach";
    private static final String d = "cockroach-PPreotect";
    private static final String e = "pack";
    private static final String f = "SEService";
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private static final int l = -1;
    protected volatile Context a;
    private volatile HandlerThread m;
    private volatile Handler n;
    private volatile boolean o;

    public b()
    {
        m = null;
        n = null;
        o = false;
    }

    private static final int a(int i1, int j1)
    {
        return i1 & 0xff | (0xffff & j1) << 16 | 0;
    }

    private static final void a(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (!ServiceProtect.a())
        {
            ServiceProtect.a(context);
        }
        String s = context.getPackageName();
        String s1 = context.getClass().getName();
        int i1 = a(2, 600);
        String s2 = IntentHelper.getAgooCockroach(context);
        if (ServiceProtect.a())
        {
            aJ.c("SEService", (new StringBuilder()).append("registerNotKill--->[current-thread-name:").append(Thread.currentThread().getName()).append("][action:").append(s2).append("]").toString());
            ServiceProtect.a(context, s, s1, s2, i1);
        }
        return;
        context;
    }

    private final void f()
    {
        if (a != null)
        {
            AlarmManager alarmmanager = (AlarmManager)a.getSystemService("alarm");
            Object obj = new Intent(IntentHelper.getAgooStart(a));
            ((Intent) (obj)).setPackage(a.getPackageName());
            ((Intent) (obj)).putExtra("method", "start");
            ((Intent) (obj)).addFlags(32);
            obj = PendingIntent.getBroadcast(a, 0, ((Intent) (obj)), 0x8000000);
            alarmmanager.set(1, System.currentTimeMillis() + 0x493e0L, ((PendingIntent) (obj)));
        }
    }

    private static final void g()
    {
        try
        {
            aJ.c("SEService", (new StringBuilder()).append("unregisterNotKill--->[current-thread-name:").append(Thread.currentThread().getName()).append("]").toString());
            if (ServiceProtect.a())
            {
                ServiceProtect.b();
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    protected final void a()
    {
        try
        {
            o = false;
            if (n != null)
            {
                n.sendEmptyMessage(1);
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    protected abstract void a(Intent intent, int i1, int j1);

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch -1 4: default 121
    //                   -1 121
    //                   0 44
    //                   1 58
    //                   2 67
    //                   3 95
    //                   4 108;
           goto _L1 _L1 _L2 _L3 _L4 _L5 _L6
_L2:
        o = true;
        a(a);
        return true;
_L3:
        try
        {
            g();
            stopSelf();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return true;
        }
        return true;
_L4:
        a(a);
        a((Intent)message.obj, message.arg1, message.arg2);
        return true;
_L5:
        a(a);
        e();
        return true;
_L6:
        a(a);
        d();
        return true;
_L1:
        return true;
    }

    public boolean hasComeFromCock(Intent intent)
    {
        if (intent != null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        aJ.c("SEService", "hasComeFromCock[intent==null]");
        return false;
        String s;
        s = intent.getAction();
        String s1 = IntentHelper.getAgooCockroach(a);
        if (!TextUtils.isEmpty(s) && TextUtils.equals(s, s1))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        aJ.c("SEService", (new StringBuilder()).append("hasComeFromCock[action==null]or[action!=").append(s1).append("]").toString());
        return false;
        String s2 = intent.getStringExtra("cockroach");
        if (!TextUtils.isEmpty(s2) && TextUtils.equals(s2, "cockroach-PPreotect"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        aJ.c("SEService", (new StringBuilder()).append("hasComeFromCock[cockroach==null]or[cockroach!=").append(s2).append("]").toString());
        return false;
        intent = intent.getStringExtra("pack");
        if (!TextUtils.isEmpty(intent) && TextUtils.equals(intent, getPackageName()))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        aJ.c("SEService", (new StringBuilder()).append("hasComeFromCock[pack==null] or [").append(intent).append("!=").append(getPackageName()).append("]").toString());
        return false;
        try
        {
            aJ.c("SEService", (new StringBuilder()).append("hasComeFromCock[").append(s).append("] [").append(intent).append("==").append(getPackageName()).append("]").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        return true;
    }

    public final void onCreate()
    {
        super.onCreate();
        a = this;
        try
        {
            aJ.a(a);
            aJ.c("SEService", "onCreate()....");
            m = new HandlerThread("se-service");
            m.start();
            n = new Handler(m.getLooper(), this);
            b();
            return;
        }
        catch (Throwable throwable)
        {
            aJ.d("SEService", "se_service_handlerthread", throwable);
        }
    }

    public final void onDestroy()
    {
        aJ.c("SEService", "onDestroy().....");
        if (!o)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        f();
_L1:
        aN.b(a);
        return;
        try
        {
            c();
            by.a(a);
        }
        catch (Throwable throwable)
        {
            return;
        }
          goto _L1
    }

    public final int onStartCommand(Intent intent, int i1, int j1)
    {
        if (n != null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        a();
        return 1;
        if (intent == null)
        {
            Message message;
            try
            {
                n.sendEmptyMessage(4);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                return 1;
            }
            return 1;
        }
        message = Message.obtain();
        message.arg1 = i1;
        message.arg2 = j1;
        message.obj = intent;
        if (!hasComeFromCock(intent))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        message.what = 3;
        n.sendMessage(message);
        return 1;
        message.what = 2;
        n.sendMessage(message);
        return 1;
    }
}
