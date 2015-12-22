// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.umeng.common.message.Log;
import com.umeng.message.entity.UMessage;
import java.lang.reflect.Method;
import org.android.agoo.client.BaseIntentService;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            PushAgent, UpdateActionReceiver, UmengService, UTrack, 
//            MsgLogStore, IUmengRegisterCallback, IUmengUnregisterCallback

public abstract class UmengBaseIntentService extends BaseIntentService
{

    private static final String a = com/umeng/message/UmengBaseIntentService.getName();
    private static final String b = "android.intent.action.BOOT_COMPLETED";

    public UmengBaseIntentService()
    {
    }

    private void a(Context context, UMessage umessage)
    {
        if (!PushAgent.getInstance(context).isIncludesUmengUpdateSDK())
        {
            break MISSING_BLOCK_LABEL_154;
        }
        umessage = new UpdateActionReceiver(umessage);
        IntentFilter intentfilter = new IntentFilter("com.umeng.message.action.autoupdate");
        LocalBroadcastManager.getInstance(context).registerReceiver(umessage, intentfilter);
        umessage = Class.forName("com.umeng.update.UmengUpdateAgent");
        Method method = umessage.getMethod("setUpdateAutoPopup", new Class[] {
            Boolean.TYPE
        });
        Method method1 = umessage.getMethod("update", new Class[] {
            android/content/Context
        });
        Method method2 = umessage.getMethod("setUpdateFromPushMessage", new Class[] {
            Boolean.TYPE
        });
        method.invoke(umessage, new Object[] {
            Boolean.valueOf(false)
        });
        method2.invoke(umessage, new Object[] {
            Boolean.valueOf(true)
        });
        method1.invoke(umessage, new Object[] {
            context
        });
        Log.c(a, "autoUpdate");
        return;
        context;
        context.printStackTrace();
        Log.c(a, context.toString());
        return;
    }

    protected final Class getAgooService()
    {
        return com/umeng/message/UmengService.getClass();
    }

    protected void onError(Context context, String s)
    {
        Log.c(a, (new StringBuilder()).append("onError()[").append(s).append("]").toString());
    }

    protected void onMessage(Context context, Intent intent)
    {
        if (Process.getElapsedCpuTime() < 3000L)
        {
            Log.a(a, "App is launched by push message");
            PushAgent.setAppLaunchByMessage();
        }
        intent = intent.getStringExtra("body");
        Log.c(a, (new StringBuilder()).append("onMessage():[").append(intent).append("]").toString());
        try
        {
            intent = new UMessage(new JSONObject(intent));
            UTrack.getInstance(getApplicationContext()).a(intent);
            MsgLogStore.getInstance(context).addLogIdType(((UMessage) (intent)).msg_id, ((UMessage) (intent)).display_type);
            if (TextUtils.equals("autoupdate", ((UMessage) (intent)).display_type))
            {
                a(context, intent);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    protected void onRegistered(Context context, String s)
    {
        Log.c(a, (new StringBuilder()).append("onRegistered()[").append(s).append("]").toString());
        try
        {
            UTrack.getInstance(getApplicationContext()).trackRegister();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        try
        {
            context = PushAgent.getInstance(context).getRegisterCallback();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        context.onRegistered(s);
    }

    protected void onUnregistered(Context context, String s)
    {
        Log.c(a, (new StringBuilder()).append("onUnregistered()[").append(s).append("]").toString());
        try
        {
            context = PushAgent.getInstance(context).getUnregisterCallback();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        context.onUnregistered(s);
    }

    protected boolean shouldProcessMessage(Context context, Intent intent)
    {
        return PushAgent.getInstance(context).isEnabled();
    }

}
