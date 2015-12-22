// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.message.tag.TagManager;
import java.util.Random;
import org.android.agoo.client.AgooSettings;
import org.json.JSONException;

// Referenced classes of package com.umeng.message:
//            UmengMessageHandler, UmengNotificationClickHandler, UTrack, MessageSharedPrefs, 
//            UmengRegistrar, MsgConstant, UHandler, IUmengRegisterCallback, 
//            IUmengUnregisterCallback

public class PushAgent
{

    public static boolean DEBUG = false;
    private static PushAgent a;
    private static boolean d = false;
    private static final String e = com/umeng/message/PushAgent.getName();
    private TagManager b;
    private Context c;
    private UHandler f;
    private UHandler g;
    private Object h;
    private IUmengRegisterCallback i;
    private IUmengUnregisterCallback j;

    private PushAgent(Context context)
    {
        try
        {
            c = context;
            b = TagManager.getInstance(context);
            f = new UmengMessageHandler();
            g = new UmengNotificationClickHandler();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(e, context.getMessage());
        }
    }

    public static PushAgent getInstance(Context context)
    {
        com/umeng/message/PushAgent;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new PushAgent(context.getApplicationContext());
        }
        context = a;
        com/umeng/message/PushAgent;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static boolean isAppLaunchByMessage()
    {
        return d;
    }

    public static void setAppLaunchByMessage()
    {
        d = true;
    }

    public boolean addAlias(String s, String s1)
        throws com.umeng.message.proguard.aD.e, JSONException, Exception
    {
        return UTrack.getInstance(c).addAlias(s, s1);
    }

    public void disable()
    {
        try
        {
            MessageSharedPrefs.getInstance(c).f();
            if (UmengRegistrar.isRegistered(c))
            {
                UmengRegistrar.unregister(c);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.b(e, exception.getMessage());
        }
    }

    public void disable(IUmengUnregisterCallback iumengunregistercallback)
    {
        setUnregisterCallback(iumengunregistercallback);
        disable();
    }

    public void enable()
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            Log.b(e, "Push SDK does not work for Android Verion < 8");
            return;
        }
        try
        {
            MessageSharedPrefs.getInstance(c).e();
            Log.c(e, "enable(): register");
            UmengRegistrar.register(c, getMessageAppkey(), getMessageSecret());
            return;
        }
        catch (Exception exception)
        {
            Log.b(e, exception.getMessage());
        }
        return;
    }

    public void enable(IUmengRegisterCallback iumengregistercallback)
    {
        setRegisterCallback(iumengregistercallback);
        enable();
    }

    public boolean getMergeNotificaiton()
    {
        return MessageSharedPrefs.getInstance(c).getMergeNotificaiton();
    }

    public String getMessageAppkey()
    {
        String s1 = MessageSharedPrefs.getInstance(c).getMessageAppKey();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = DeviceConfig.getAppkey(c);
        }
        return s;
    }

    public String getMessageChannel()
    {
        String s1 = MessageSharedPrefs.getInstance(c).getMessageChannel();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = DeviceConfig.getChannel(c);
        }
        return s;
    }

    public UHandler getMessageHandler()
    {
        return f;
    }

    public String getMessageSecret()
    {
        String s1 = MessageSharedPrefs.getInstance(c).getMessageAppSecret();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = DeviceConfig.getMetaData(c, "UMENG_MESSAGE_SECRET");
        }
        return s;
    }

    public int getMuteDurationSeconds()
    {
        return MessageSharedPrefs.getInstance(c).k();
    }

    public int getNoDisturbEndHour()
    {
        return MessageSharedPrefs.getInstance(c).c();
    }

    public int getNoDisturbEndMinute()
    {
        return MessageSharedPrefs.getInstance(c).d();
    }

    public int getNoDisturbStartHour()
    {
        return MessageSharedPrefs.getInstance(c).a();
    }

    public int getNoDisturbStartMinute()
    {
        return MessageSharedPrefs.getInstance(c).b();
    }

    public UHandler getNotificationClickHandler()
    {
        return g;
    }

    public boolean getNotificationOnForeground()
    {
        return MessageSharedPrefs.getInstance(c).getNotificaitonOnForeground();
    }

    public String getPushIntentServiceClass()
    {
        return MessageSharedPrefs.getInstance(c).getPushIntentServiceClass();
    }

    public IUmengRegisterCallback getRegisterCallback()
    {
        return i;
    }

    public String getRegistrationId()
    {
        return UmengRegistrar.getRegistrationId(c);
    }

    public TagManager getTagManager()
    {
        return b;
    }

    public IUmengUnregisterCallback getUnregisterCallback()
    {
        return j;
    }

    public Object getUpdateResponse()
    {
        return h;
    }

    public boolean isEnabled()
    {
        boolean flag;
        try
        {
            flag = MessageSharedPrefs.getInstance(c).g();
        }
        catch (Exception exception)
        {
            Log.b(e, exception.getMessage());
            return false;
        }
        return flag;
    }

    public boolean isIncludesUmengUpdateSDK()
    {
        Class class1;
        try
        {
            class1 = Class.forName("com.umeng.update.UmengUpdateAgent");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            classnotfoundexception.printStackTrace();
            classnotfoundexception = null;
        }
        return class1 != null;
    }

    public boolean isRegistered()
    {
        return UmengRegistrar.isRegistered(c);
    }

    public void onAppStart()
    {
        long l;
        l = 0L;
        UmengRegistrar.checkRegisteredToUmeng(c);
        if (!UmengRegistrar.isRegistered(c))
        {
            return;
        }
        if (MessageSharedPrefs.getInstance(c).getAppLaunchLogSendPolicy() != 1) goto _L2; else goto _L1
_L1:
        Log.c(e, "launch_policy=1, skip sending app launch info.");
_L4:
        if (isAppLaunchByMessage())
        {
            l = Math.abs((new Random()).nextLong() % MsgConstant.a);
        }
        UTrack.getInstance(c).sendCachedMsgLog(l);
        return;
_L2:
        if (!MessageSharedPrefs.getInstance(c).hasAppLaunchLogSentToday())
        {
            UTrack.getInstance(c).trackAppLaunch(0L);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean removeAlias(String s, String s1)
        throws com.umeng.message.proguard.aD.e, JSONException, Exception
    {
        return UTrack.getInstance(c).removeAlias(s, s1);
    }

    public void setAppkeyAndSecret(String s, String s1)
    {
        MessageSharedPrefs.getInstance(c).setMessageAppKey(s);
        MessageSharedPrefs.getInstance(c).setMessageAppSecret(s1);
    }

    public void setDebugMode(boolean flag)
    {
        AgooSettings.setDebugMode(flag);
        Log.LOG = flag;
        AgooSettings.setLog(c, true, false);
    }

    public void setMergeNotificaiton(boolean flag)
    {
        MessageSharedPrefs.getInstance(c).setMergeNotificaiton(flag);
    }

    public void setMessageChannel(String s)
    {
        MessageSharedPrefs.getInstance(c).setMessageChannel(s);
    }

    public void setMessageHandler(UHandler uhandler)
    {
        f = uhandler;
    }

    public void setMuteDurationSeconds(int k)
    {
        MessageSharedPrefs.getInstance(c).a(k);
    }

    public void setNoDisturbMode(int k, int l, int i1, int j1)
    {
        MessageSharedPrefs.getInstance(c).a(k, l, i1, j1);
    }

    public void setNotificaitonOnForeground(boolean flag)
    {
        MessageSharedPrefs.getInstance(c).setNotificaitonOnForeground(flag);
    }

    public void setNotificationClickHandler(UHandler uhandler)
    {
        g = uhandler;
    }

    public void setPushIntentServiceClass(Class class1)
    {
        MessageSharedPrefs.getInstance(c).setPushIntentServiceClass(class1);
    }

    public void setRegisterCallback(IUmengRegisterCallback iumengregistercallback)
    {
        i = iumengregistercallback;
    }

    public void setUnregisterCallback(IUmengUnregisterCallback iumengunregistercallback)
    {
        j = iumengunregistercallback;
    }

    public void setUpdateResponse(Object obj)
    {
        h = obj;
    }

}
