// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import com.umeng.message.proguard.aU;
import com.umeng.message.proguard.bp;
import com.umeng.message.proguard.br;
import com.umeng.message.proguard.bu;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.by;
import com.umeng.message.proguard.bz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.android.agoo.helper.PhoneHelper;
import org.android.agoo.net.mtop.IMtopSynClient;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopSyncClientV3;
import org.android.agoo.net.mtop.Result;
import org.android.agoo.service.AgooService;
import org.android.agoo.service.IElectionService;
import org.android.agoo.service.IMessageService;
import org.json.JSONObject;

// Referenced classes of package org.android.agoo.client:
//            BaseRegistrar, MessageService, IntentHelper, AgooSettings

public abstract class BaseIntentService extends IntentService
{

    private static final String a = "SERVICE_NOT_AVAILABLE";
    private static final String f = "report";
    private static final String g = "time";
    private static final String h = "BaseIntentService";
    private static final String i = "AGOO_LIB";
    private static volatile android.os.PowerManager.WakeLock j;
    private static final Object k = org/android/agoo/client/BaseIntentService;
    private static final Random l = new Random();
    private static final int m = 0x36ee80;
    private volatile IMtopSynClient b;
    private volatile String c;
    private volatile String d;
    private volatile String e;
    private volatile IElectionService n;
    private ServiceConnection o;
    private volatile boolean p;
    private volatile IMessageService q;
    private ServiceConnection r;

    protected BaseIntentService()
    {
        super("AgooDynamicSenderIds");
        b = null;
        n = null;
        o = new ServiceConnection() {

            final BaseIntentService a;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("electionConnection pack[").append(componentname.getPackageName()).append("]").toString());
                try
                {
                    componentname = a.getApplicationContext();
                    BaseIntentService.a(a, org.android.agoo.service.IElectionService.Stub.asInterface(ibinder));
                    if (BaseIntentService.a(a) != null)
                    {
                        BaseIntentService.a(a).election(componentname.getPackageName(), AgooSettings.getAgooReleaseTime(), "token");
                        BaseIntentService.a(a, componentname);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ComponentName componentname)
                {
                    aJ.d("BaseIntentService", "onServiceConnected", componentname);
                }
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("electionDisconnected pack[").append(componentname.getPackageName()).append("]").toString());
                BaseIntentService.a(a, null);
            }

            
            {
                a = BaseIntentService.this;
                super();
            }
        };
        p = false;
        q = null;
        r = new ServiceConnection() {

            final BaseIntentService a;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("messageConnected pack[").append(componentname.getPackageName()).append("]").toString());
                BaseIntentService.a(a, true);
                BaseIntentService.a(a, org.android.agoo.service.IMessageService.Stub.asInterface(ibinder));
                componentname = a.getApplicationContext();
                BaseIntentService.b(a, componentname);
                BaseIntentService.c(a, componentname);
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("messageDisconnected pack[").append(componentname.getPackageName()).append("]").toString());
            }

            
            {
                a = BaseIntentService.this;
                super();
            }
        };
        a();
        setIntentRedelivery(false);
    }

    static IElectionService a(BaseIntentService baseintentservice)
    {
        return baseintentservice.n;
    }

    static IElectionService a(BaseIntentService baseintentservice, IElectionService ielectionservice)
    {
        baseintentservice.n = ielectionservice;
        return ielectionservice;
    }

    static IMessageService a(BaseIntentService baseintentservice, IMessageService imessageservice)
    {
        baseintentservice.q = imessageservice;
        return imessageservice;
    }

    private void a()
    {
        b = new MtopSyncClientV3();
    }

    private void a(Context context, Intent intent)
    {
        if (!BaseRegistrar.isRegistered(context))
        {
            aJ.c("BaseIntentService", "deviceToken is null--->[re-registration]");
            k(context, intent);
            return;
        }
        if (!aU.a(context))
        {
            aJ.c("BaseIntentService", "connectManager[network connectedOrConnecting failed]");
            return;
        }
        MessageService.getSingleton(context).reloadMessageAtTime();
        intent = context.getPackageName();
        String s = aI.d(context);
        if (!TextUtils.isEmpty(intent) && !TextUtils.isEmpty(s) && TextUtils.equals(intent, s))
        {
            a(context, context.getPackageName(), s);
            return;
        } else
        {
            h(context);
            return;
        }
    }

    static void a(Context context, Intent intent, String s)
    {
        synchronized (k)
        {
            if (j == null)
            {
                j = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "AGOO_LIB");
                j.setReferenceCounted(false);
            }
        }
        try
        {
            j.acquire(5000L);
            intent.setClassName(context, s);
            context.startService(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.d("BaseIntentService", "runIntentInService--Throwable", context);
        }
        break MISSING_BLOCK_LABEL_76;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void a(Context context, String s)
    {
        int i1;
        if (!"SERVICE_NOT_AVAILABLE".equals(s))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (!onRecoverableError(context, s))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        i1 = aI.k(context);
        int j1 = i1 / 2;
        j1 = l.nextInt(i1) + j1;
        aJ.c("BaseIntentService", (new StringBuilder()).append("registration retry--->[nextAttempt:").append(j1).append("|backoffTimeMs:").append(i1).append("]").toString());
        s = IntentHelper.createComandIntent(context, "register_retry");
        s.setPackage(context.getPackageName());
        s = PendingIntent.getBroadcast(context, 0, s, 0);
        ((AlarmManager)context.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + (long)j1, s);
        if (i1 < 0x36ee80)
        {
            try
            {
                aI.a(context, i1 * 2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_153;
        aJ.c("BaseIntentService", "Not retrying failed operation");
        return;
        onError(context, s);
    }

    private void a(Context context, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        bz.a(new Runnable(s1, s, context) {

            final String a;
            final String b;
            final Context c;
            final BaseIntentService d;

            public void run()
            {
                if (!TextUtils.isEmpty(a) && TextUtils.equals(a, b))
                {
                    aJ.c("BaseIntentService", (new StringBuilder()).append("restart---->[currentSudoPack:").append(a).append("]:[start]").toString());
                    if (BaseIntentService.b(d))
                    {
                        aJ.c("BaseIntentService", (new StringBuilder()).append("enabledService---->[").append(b).append("/").append(d.getAgooService()).append("]").toString());
                        bx.b(c, d.getAgooService());
                    }
                    by.a(c, d.getAgooService());
                    return;
                }
                aJ.c("BaseIntentService", (new StringBuilder()).append("restart---->[currentSudoPack:").append(a).append("][currentPack:").append(b).append("]:[stop]").toString());
                if (BaseIntentService.b(d))
                {
                    aJ.c("BaseIntentService", (new StringBuilder()).append("disableService---->[").append(b).append("/").append(d.getAgooService()).append("]").toString());
                    bx.a(c, d.getAgooService());
                }
                by.b(c, d.getAgooService());
            }

            
            {
                d = BaseIntentService.this;
                a = s;
                b = s1;
                c = context;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private transient void a(Context context, String s, String as[])
    {
        if (TextUtils.equals(s, "channel"))
        {
            b(context, s, as);
        }
    }

    static void a(BaseIntentService baseintentservice, Context context)
    {
        baseintentservice.g(context);
    }

    private boolean a(Context context)
    {
        String s = aI.n(context);
        String s1 = aI.o(context);
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            c = s;
            d = s1;
            b.setDefaultAppkey(s);
            s = aI.p(context);
            if (!TextUtils.isEmpty(s) || AgooSettings.isAgooSoSecurityMode(context))
            {
                e = s;
                b.setDefaultAppSecret(s);
                b.setBaseUrl(AgooSettings.getPullUrl(context));
                return true;
            }
        }
        return false;
    }

    static boolean a(BaseIntentService baseintentservice, boolean flag)
    {
        baseintentservice.p = flag;
        return flag;
    }

    private void b(Context context)
    {
        Intent intent = IntentHelper.createComandIntent(context, "registration");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    private void b(Context context, Intent intent)
    {
        String s = intent.getStringExtra("id");
        MessageService.getSingleton(context).notice(s);
        onMessage(context, intent);
    }

    private final void b(Context context, String s)
    {
        s = (new JSONObject(s)).getString("device_id");
        if (TextUtils.isEmpty(s))
        {
            a(context, "SERVICE_NOT_AVAILABLE");
            return;
        }
        try
        {
            aI.b(context, s);
            aI.t(context);
            b(context);
            aN.g(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a(context, "SERVICE_NOT_AVAILABLE");
        }
        aN.h(context, "data_parse_error");
        return;
    }

    private transient void b(Context context, String s, String as[])
    {
        if (as == null || 2 > as.length)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (TextUtils.equals(as[0], "multiplex") && !aI.w(context))
        {
            aI.a(context, true, -1L);
            f(context);
            return;
        }
        try
        {
            long l1 = Long.parseLong(as[1]);
            if (TextUtils.equals(as[0], "single") && aI.w(context) && l1 >= System.currentTimeMillis() + 0x493e0L)
            {
                aI.a(context, false, l1);
                if (b())
                {
                    aJ.c("BaseIntentService", (new StringBuilder()).append("enabledService---->[").append(getAgooService()).append("]").toString());
                    bx.b(context, getAgooService());
                }
                by.a(context, getAgooService());
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.d("BaseIntentService", "commandByChannel", context);
        }
    }

    static void b(BaseIntentService baseintentservice, Context context)
    {
        baseintentservice.h(context);
    }

    private boolean b()
    {
        return getAgooService() != null && TextUtils.equals(getAgooService().getSuperclass().getName(), org/android/agoo/service/AgooService.getName());
    }

    static boolean b(BaseIntentService baseintentservice)
    {
        return baseintentservice.b();
    }

    private void c()
    {
        Context context = getApplicationContext();
        String s = aI.d(context);
        if (TextUtils.isEmpty(s))
        {
            aJ.c("BaseIntentService", "onPingMessage:[currentPack==null][retry election]");
            f(context);
            return;
        }
        try
        {
            Intent intent = new Intent();
            intent.setAction("org.agoo.android.intent.action.PING");
            intent.setPackage(s);
            context.bindService(intent, r, 1);
            return;
        }
        catch (Throwable throwable)
        {
            aJ.d("BaseIntentService", "onPingMessage", throwable);
        }
    }

    private void c(Context context)
    {
        if (BaseRegistrar.isRegistered(context) && a(context))
        {
            String s = BaseRegistrar.getRegistrationId(context);
            MtopRequest mtoprequest = new MtopRequest();
            mtoprequest.setApi("mtop.push.device.unregister");
            mtoprequest.setV("4.0");
            mtoprequest.setTtId(d);
            mtoprequest.setDeviceId(s);
            mtoprequest.putParams("app_version", bp.a(context));
            mtoprequest.putParams("sdk_version", Long.valueOf(AgooSettings.getAgooReleaseTime()));
            mtoprequest.putParams("app_pack", context.getPackageName());
            b.setBaseUrl(AgooSettings.getPullUrl(context));
            context = b.getV3(context, mtoprequest);
            aJ.c("BaseIntentService", (new StringBuilder()).append("unregister--->[server result:").append(context.getData()).append("]").toString());
        }
    }

    private void c(Context context, Intent intent)
    {
        intent = intent.getStringExtra("x_command").split(";");
        int j1 = intent.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            CharSequence charsequence = intent[i1];
            if (!TextUtils.isEmpty(charsequence))
            {
                String as[] = charsequence.split("=");
                if (as != null && as.length == 2 && !TextUtils.isEmpty(as[0]) && !TextUtils.isEmpty(as[1]))
                {
                    String as1[] = as[1].split(",");
                    if (as1 != null)
                    {
                        a(context, as[0], as1);
                    }
                }
            }
            i1++;
        }
    }

    private void c(Context context, String s)
    {
        if (BaseRegistrar.isRegistered(context) && a(context))
        {
            String s1 = BaseRegistrar.getRegistrationId(context);
            MtopRequest mtoprequest = new MtopRequest();
            mtoprequest.setApi("mtop.push.device.uninstall");
            mtoprequest.setV("4.0");
            mtoprequest.setTtId(d);
            mtoprequest.setDeviceId(s1);
            mtoprequest.putParams("app_version", bp.a(context));
            mtoprequest.putParams("sdk_version", Long.valueOf(AgooSettings.getAgooReleaseTime()));
            mtoprequest.putParams("app_pack", s);
            b.setBaseUrl(AgooSettings.getPullUrl(context));
            context = b.getV3(context, mtoprequest);
            aJ.c("BaseIntentService", (new StringBuilder()).append("uninstall--->[result:").append(context.getData()).append("]").toString());
        }
    }

    static void c(BaseIntentService baseintentservice, Context context)
    {
        baseintentservice.i(context);
    }

    private void d(Context context)
    {
        Object obj = new MtopRequest();
        ((MtopRequest) (obj)).setApi("mtop.push.device.createAndRegister");
        ((MtopRequest) (obj)).setV("4.0");
        ((MtopRequest) (obj)).setTtId(d);
        ((MtopRequest) (obj)).putParams("new_device", "true");
        ((MtopRequest) (obj)).putParams("device_global_id", aN.c(context));
        ((MtopRequest) (obj)).putParams("c0", Build.BRAND);
        ((MtopRequest) (obj)).putParams("c1", Build.MODEL);
        ((MtopRequest) (obj)).putParams("c2", "umeng");
        ((MtopRequest) (obj)).putParams("c3", "umeng");
        ((MtopRequest) (obj)).putParams("c4", PhoneHelper.getLocalMacAddress(context));
        ((MtopRequest) (obj)).putParams("c5", PhoneHelper.getSerialNum());
        ((MtopRequest) (obj)).putParams("c6", PhoneHelper.getAndroidId(context));
        ((MtopRequest) (obj)).putParams("app_version", bp.a(context));
        ((MtopRequest) (obj)).putParams("sdk_version", Long.valueOf(AgooSettings.getAgooReleaseTime()));
        ((MtopRequest) (obj)).putParams("package_name", context.getPackageName());
        if (BaseRegistrar.isRegistered(context))
        {
            ((MtopRequest) (obj)).putParams("old_device_id", aI.q(context));
        }
        obj = b.getV3(context, ((MtopRequest) (obj)));
        if (obj != null)
        {
            if (((Result) (obj)).isSuccess())
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("register--->[result:").append(((Result) (obj)).getData()).append("]").toString());
                b(context, ((Result) (obj)).getData());
                return;
            }
            if (((Result) (obj)).getHttpCode() == 302)
            {
                aJ.d("BaseIntentService", (new StringBuilder()).append("doRegister---->[failed][").append(((Result) (obj)).getHttpCode()).append("]").toString());
                return;
            }
            obj = ((Result) (obj)).getRetCode();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                aJ.d("BaseIntentService", (new StringBuilder()).append("doRegister---->[").append(((String) (obj))).append("]").toString());
                aN.h(context, ((String) (obj)));
                if (((String) (obj)).indexOf("ERRCODE_AUTH_REJECT") != -1)
                {
                    aI.s(context);
                    return;
                }
            }
        }
        a(context, "SERVICE_NOT_AVAILABLE");
    }

    private void d(Context context, Intent intent)
    {
        h(context);
        if (!intent.getBooleanExtra("x_command_type", false)) goto _L2; else goto _L1
_L1:
        c(context, intent);
_L4:
        return;
_L2:
        String s;
        String s2;
        String s4;
        String s5;
        if (!BaseRegistrar.isRegistered(context))
        {
            aJ.c("BaseIntentService", "handleRemoteMessage[deviceToken==null]");
            return;
        }
        s4 = intent.getStringExtra("id");
        s2 = intent.getStringExtra("body");
        s5 = intent.getStringExtra("type");
        if (TextUtils.isEmpty(s2))
        {
            aJ.c("BaseIntentService", "handleMessage--->[null]");
            aN.e(context, s4);
            return;
        }
        s = s2;
        String s6 = intent.getStringExtra("encrypted");
        String s1;
        s = s2;
        s1 = s2;
        if (!TextUtils.equals("1", s6))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        s = s2;
        s1 = bu.a(BaseRegistrar.getRegistrationId(context), s2, 0);
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = s1;
            try
            {
                aN.b(context, s4, s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                aJ.d("BaseIntentService", (new StringBuilder()).append("encrypt--aesdecrypt[").append(s).append("]").toString(), context);
            }
            return;
        }
        s = s1;
        intent.putExtra("body", s1);
        s = s1;
        s2 = s1;
        if (!TextUtils.equals("2", s6))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        s = s1;
        s2 = bu.a(BaseRegistrar.getRegistrationId(context), s1, 1);
        s = s2;
        if (!TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_259;
        }
        s = s2;
        aN.b(context, s4, s2);
        return;
        s = s2;
        intent.putExtra("body", s2);
        s = s2;
        s1 = s2;
        if (!TextUtils.equals("3", s6))
        {
            break MISSING_BLOCK_LABEL_341;
        }
        s = s2;
        s1 = bu.a(BaseRegistrar.getRegistrationId(context), s2, 2);
        s = s1;
        if (!TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_328;
        }
        s = s1;
        aN.b(context, s4, s1);
        return;
        s = s1;
        intent.putExtra("body", s1);
        s = null;
        s2 = intent.getStringExtra("task_id");
        s = s2;
_L7:
        Throwable throwable;
        int i1;
        int j1;
        long l1;
        try
        {
            String s3 = intent.getStringExtra("message_source");
            String s7 = intent.getStringExtra("report");
            if (MessageService.getSingleton(context).report(s4, s, s7, s3))
            {
                intent.removeExtra("report");
            }
        }
        catch (Throwable throwable1) { }
        aJ.c("BaseIntentService", (new StringBuilder()).append("handleMessage--->[").append(s1).append("]").toString());
        aN.b(context, s4);
        i1 = s1.hashCode();
        if (MessageService.getSingleton(context).hasMessageDuplicate(s4, i1)) goto _L4; else goto _L3
_L3:
        i1 = -1;
        j1 = Integer.parseInt(intent.getStringExtra("notify"));
        i1 = j1;
_L6:
        s = intent.getStringExtra("time");
        if (!TextUtils.isEmpty(s))
        {
            MessageService.getSingleton(context).handleMessageAtTime(s4, s1, s5, s, i1);
            return;
        }
        l1 = AgooSettings.getTargetTime(context);
        if (l1 != -1L)
        {
            MessageService.getSingleton(context).handleMessageAtTime(s4, s1, s5, (new StringBuilder()).append(l1).append("_30").toString(), i1);
            return;
        } else
        {
            MessageService.getSingleton(context).addMessage(s4, s1, s5, i1);
            onMessage(context, intent);
            return;
        }
        throwable;
        if (true) goto _L6; else goto _L5
_L5:
        Throwable throwable2;
        throwable2;
          goto _L7
    }

    private void e(Context context)
    {
        aI.s(context);
    }

    private void e(Context context, Intent intent)
    {
        if (!shouldProcessMessage(context, intent))
        {
            return;
        }
        if (aI.u(context))
        {
            aJ.a("BaseIntentService", (new StringBuilder()).append("handleMessage[").append(context.getPackageName()).append("]--->[disable]").toString());
            return;
        }
        if (intent.getBooleanExtra("local", false))
        {
            b(context, intent);
            return;
        } else
        {
            d(context, intent);
            return;
        }
    }

    private void f(Context context)
    {
        Intent intent = new Intent();
        intent.setAction("org.agoo.android.intent.action.RE_ELECTION_V2");
        intent.setFlags(32);
        context.sendBroadcast(intent);
    }

    private void f(Context context, Intent intent)
    {
        if (!a(context))
        {
            aJ.c("BaseIntentService", "handleAddPackage---->[appkey or appSecret ===null]");
            return;
        }
        if (!BaseRegistrar.isRegistered(context))
        {
            aJ.c("BaseIntentService", "handleAddPackage---->[devicetoken ===null]");
            return;
        } else
        {
            f(context);
            return;
        }
    }

    private void g(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        context.unbindService(o);
        return;
        context;
    }

    private void g(Context context, Intent intent)
    {
        if (intent != null && context != null)
        {
            String s = null;
            Uri uri = intent.getData();
            if (uri != null)
            {
                s = uri.getSchemeSpecificPart();
            }
            if (!TextUtils.isEmpty(s))
            {
                if (!TextUtils.isEmpty(s) && !TextUtils.equals(s, context.getPackageName()))
                {
                    c(context, s);
                }
                String s1 = aI.d(context);
                if (!TextUtils.isEmpty(s1) && !TextUtils.equals(s, context.getPackageName()) && TextUtils.equals(s, s1))
                {
                    i(context, intent);
                    return;
                }
            }
        }
    }

    private void h(Context context)
    {
        if (!p || q == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        boolean flag;
        try
        {
            flag = q.ping();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.d("BaseIntentService", "pingMessage", context);
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        f(context);
        aJ.c("BaseIntentService", (new StringBuilder()).append("pingMessage[ping:").append(flag).append("]").toString());
    }

    private final void h(Context context, Intent intent)
    {
        String s = intent.getStringExtra("command");
        aJ.c("BaseIntentService", (new StringBuilder()).append("command --->[").append(s).append("]").toString());
        if (s.equals("registration"))
        {
            onRegistered(context, BaseRegistrar.getRegistrationId(context));
            f(context, intent);
            return;
        }
        if (s.equals("unregister"))
        {
            m(context, intent);
            return;
        }
        if (s.equals("error"))
        {
            l(context, intent);
            return;
        }
        if (s.equals("register"))
        {
            j(context, intent);
            return;
        }
        if (s.equals("register_retry"))
        {
            k(context, intent);
            return;
        } else
        {
            onUserCommand(context, intent);
            return;
        }
    }

    private void i(Context context)
    {
        try
        {
            context.unbindService(r);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.d("BaseIntentService", "closeElection", context);
        }
    }

    private void i(Context context, Intent intent)
    {
        try
        {
            if (!BaseRegistrar.isRegistered(context))
            {
                aJ.c("BaseIntentService", "handleElection---->[devicetoken == null]");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (aI.u(context))
        {
            aJ.c("BaseIntentService", "handleElection--->[app:disable]");
            return;
        }
        if (!aI.w(context))
        {
            aJ.c("BaseIntentService", "handleElection--->[channel:single]");
            return;
        }
        if (TextUtils.equals(intent.getStringExtra("election_type"), "election_notice"))
        {
            intent = (org.android.agoo.service.ElectionService.ElectionResult)intent.getParcelableExtra("election_result");
            Object obj = intent.getSudoMap();
            long l1 = intent.getTimeout();
            intent = intent.getElectionSource();
            obj = ((HashMap) (obj)).entrySet().iterator();
            String s = context.getPackageName();
            String s1;
            Object obj1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_213;
                }
                obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                s1 = (String)((java.util.Map.Entry) (obj1)).getKey();
                obj1 = (String)((java.util.Map.Entry) (obj1)).getValue();
            } while (!TextUtils.equals(s1, s));
            aI.a(context, ((String) (obj1)), l1, intent);
            a(context, s, ((String) (obj1)));
            return;
        }
        intent = new Intent();
        intent.setAction("org.agoo.android.intent.action.ELECTION_V2");
        context.startService(intent);
        context.bindService(intent, o, 1);
    }

    private void j(Context context, Intent intent)
    {
        if (!a(context))
        {
            aJ.a("BaseIntentService", (new StringBuilder()).append("handleRegister[").append(context.getPackageName()).append("]--->[appkey==null,appSecret==nullttid,ttid==null]").toString());
            e(context);
            return;
        }
        if (!BaseRegistrar.isRegistered(context))
        {
            aJ.a("BaseIntentService", (new StringBuilder()).append("handleRegister[").append(context.getPackageName()).append("]--->[deviceToken==null]").toString());
            aI.t(context);
            br.a(context);
            d(context);
            return;
        }
        if (aI.b(context, true))
        {
            aJ.a("BaseIntentService", (new StringBuilder()).append("handleRegister[").append(context.getPackageName()).append("]--->[disable]").toString());
            return;
        } else
        {
            bx.a(context);
            c();
            return;
        }
    }

    private void k(Context context, Intent intent)
    {
        if (BaseRegistrar.isRegistered(context))
        {
            return;
        } else
        {
            BaseRegistrar.b(context);
            return;
        }
    }

    private void l(Context context, Intent intent)
    {
        intent = intent.getStringExtra("error");
        if (TextUtils.equals(intent, "ERROR_NEED_ELECTION"))
        {
            f(context);
            return;
        }
        if (TextUtils.equals(intent, "ERRCODE_AUTH_REJECT"))
        {
            e(context);
            f(context);
            return;
        }
        if ("ERROR_DEVICETOKEN_NULL".equals(intent))
        {
            aN.g(context, "ERROR_DEVICETOKEN_NULL");
            BaseRegistrar.b(context);
            return;
        }
        if ("ERROR_NEED_REGISTER".equals(intent))
        {
            aN.g(context, "ERROR_NEED_REGISTER");
        }
        if ("ERROR_APPKEY_NULL".equals(intent) || "ERROR_APPSECRET_NULL".equals(intent) || "ERROR_TTID_NULL".equals(intent))
        {
            aN.g(context, "APPKEY_OR_SECRET_IS_NULL");
            onError(context, intent);
            return;
        } else
        {
            onError(context, intent);
            return;
        }
    }

    private void m(Context context, Intent intent)
    {
        intent = context.getPackageName();
        String s = aI.d(context);
        if (TextUtils.isEmpty(s) || TextUtils.equals(intent, s))
        {
            aJ.c("BaseIntentService", (new StringBuilder()).append("handleUnRegister---->[currentPack:").append(intent).append("][currentSudoPack:").append(s).append("]:[retryElection]").toString());
            if (b())
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("disableService---->[").append(getAgooService()).append("]").toString());
                bx.a(context, getAgooService());
            }
            by.b(context, getAgooService());
            f(context);
        }
        c(context);
        intent = aI.q(context);
        aI.j(context);
        aI.a(context, true);
        onUnregistered(context, intent);
    }

    protected Class getAgooService()
    {
        return null;
    }

    protected void onDeletedMessages(Context context, int i1)
    {
    }

    protected abstract void onError(Context context, String s);

    public final void onHandleIntent(Intent intent)
    {
        String s;
        String s1;
        obj = getApplicationContext();
        s = intent.getAction();
        s1 = IntentHelper.getAgooCommand(((Context) (obj)));
        if (!TextUtils.equals("android.intent.action.PACKAGE_REMOVED", s))
        {
            aJ.a(((Context) (obj)));
        }
        if (!TextUtils.equals(s, s1)) goto _L2; else goto _L1
_L1:
        h(((Context) (obj)), intent);
_L3:
        synchronized (k)
        {
            if (j != null)
            {
                j.release();
            }
        }
        return;
_L2:
        if (!TextUtils.equals("android.intent.action.PACKAGE_REMOVED", s))
        {
            break MISSING_BLOCK_LABEL_132;
        }
        g(((Context) (obj)), intent);
          goto _L3
        intent;
        aJ.d("BaseIntentService", "onHandleIntent", intent);
        synchronized (k)
        {
            if (j != null)
            {
                j.release();
            }
        }
        return;
        obj;
        intent;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            aJ.d("BaseIntentService", "wakeLock.release()", intent);
        }
        return;
        if (!TextUtils.equals(s, "org.agoo.android.intent.action.RECEIVE")) goto _L5; else goto _L4
_L4:
        e(((Context) (obj)), intent);
          goto _L3
        intent;
        synchronized (k)
        {
            if (j != null)
            {
                j.release();
            }
        }
_L6:
        throw intent;
_L5:
label0:
        {
            if (!TextUtils.equals(s, "org.agoo.android.intent.action.RE_ELECTION_V2"))
            {
                break label0;
            }
            i(((Context) (obj)), intent);
        }
          goto _L3
label1:
        {
            if (!TextUtils.equals(s, "android.net.conn.CONNECTIVITY_CHANGE") && !TextUtils.equals(s, "android.intent.action.BOOT_COMPLETED") && !TextUtils.equals(s, "android.intent.action.PACKAGE_ADDED") && !TextUtils.equals(s, "android.intent.action.PACKAGE_REPLACED") && !TextUtils.equals(s, "android.intent.action.USER_PRESENT"))
            {
                break label1;
            }
            a(((Context) (obj)), intent);
        }
          goto _L3
        onUserHandleIntent(((Context) (obj)), intent);
          goto _L3
        obj;
        intent;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            aJ.d("BaseIntentService", "wakeLock.release()", intent);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (Throwable throwable)
        {
            aJ.d("BaseIntentService", "wakeLock.release()", throwable);
        }
          goto _L6
    }

    protected abstract void onMessage(Context context, Intent intent);

    protected boolean onRecoverableError(Context context, String s)
    {
        return true;
    }

    protected abstract void onRegistered(Context context, String s);

    protected abstract void onUnregistered(Context context, String s);

    protected void onUserCommand(Context context, Intent intent)
    {
    }

    protected void onUserHandleIntent(Context context, Intent intent)
    {
    }

    protected boolean shouldProcessMessage(Context context, Intent intent)
    {
        return true;
    }

}
