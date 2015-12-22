// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.common.message.b;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.aD;
import com.umeng.message.proguard.aE;
import com.umeng.message.proguard.ax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            MsgLogStore, PushAgent, MsgConstant, UmengRegistrar, 
//            MessageSharedPrefs, UmengMessageHandler

public class UTrack
{

    private static final String a = com/umeng/message/UTrack.getName();
    private static UTrack c;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private JSONObject b;
    private ScheduledThreadPoolExecutor d;
    private Context e;

    private UTrack(Context context)
    {
        e = context.getApplicationContext();
        b();
        d = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
    }

    static Context a(UTrack utrack)
    {
        return utrack.e;
    }

    static String a()
    {
        return a;
    }

    private JSONObject a(JSONObject jsonobject, String s)
        throws com.umeng.message.proguard.aD.e, JSONException, Exception
    {
        String s1 = aD.c(s).H().r("application/json").i(jsonobject.toString()).b("UTF-8");
        Log.c(a, (new StringBuilder()).append("sendRequest() url=").append(s).append("\n request = ").append(jsonobject).append("\n response = ").append(s1).toString());
        return new JSONObject(s1);
    }

    static void a(UTrack utrack, String s, int i, long l)
    {
        utrack.b(s, i, l);
    }

    private void a(String s, int i, long l)
    {
        if (!c())
        {
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            Log.b(a, "trackMsgLog: empty msgId");
            return;
        }
        long l1 = System.currentTimeMillis();
        MsgLogStore.getInstance(e).addLog(s, i, l1);
        Runnable runnable = new Runnable(s, i, l1) {

            final String a;
            final int b;
            final long c;
            final UTrack d;

            public void run()
            {
                UTrack.a(d, a, b, c);
            }

            
            {
                d = UTrack.this;
                a = s;
                b = i;
                c = l;
                super();
            }
        };
        if (l > 0L && i != 1)
        {
            l1 = Math.abs((new Random()).nextLong() % l);
        } else
        {
            l1 = 0L;
        }
        Log.c(a, String.format("trackMsgLog(msgId=%s, actionType=%d, random=%d, delay=%d)", new Object[] {
            s, Integer.valueOf(i), Long.valueOf(l), Long.valueOf(l1)
        }));
        d.schedule(runnable, l1, TimeUnit.MILLISECONDS);
    }

    static boolean a(boolean flag)
    {
        f = flag;
        return flag;
    }

    static JSONObject b(UTrack utrack)
        throws JSONException
    {
        return utrack.e();
    }

    private void b()
    {
        b b1;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        b1 = new b();
        b1.b(e, new String[0]);
        b1.a(e, new String[] {
            PushAgent.getInstance(e).getMessageAppkey(), PushAgent.getInstance(e).getMessageChannel()
        });
        b = new JSONObject();
        b1.b(b);
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    private void b(String s, int i, long l)
    {
        Object obj;
        try
        {
            obj = e();
            ((JSONObject) (obj)).put("msg_id", s);
            ((JSONObject) (obj)).put("action_type", i);
            ((JSONObject) (obj)).put("ts", l);
            aE ae = new aE(e);
            obj = ae.a(ae.a(((JSONObject) (obj))), MsgConstant.LOG_ENDPOINT);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        if (!((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a))
        {
            break MISSING_BLOCK_LABEL_112;
        }
        MsgLogStore.getInstance(e).removeLog(s, i);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        MsgLogStore.getInstance(e).removeLogIdType(s);
    }

    static boolean b(boolean flag)
    {
        g = flag;
        return flag;
    }

    static String c(UTrack utrack)
    {
        return utrack.d();
    }

    private boolean c()
    {
        if (TextUtils.isEmpty(DeviceConfig.getUtdid(e)))
        {
            Log.b(a, "UTDID is empty");
            return false;
        }
        if (TextUtils.isEmpty(UmengRegistrar.getRegistrationId(e)))
        {
            Log.b(a, "RegistrationId is empty");
            return false;
        } else
        {
            return true;
        }
    }

    static boolean c(boolean flag)
    {
        h = flag;
        return flag;
    }

    private String d()
    {
        Object obj;
        BufferedReader bufferedreader;
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            return null;
        }
        String s;
        boolean flag;
        try
        {
            obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/data/").append(e.getPackageName()).append("/").toString();
            Log.c(a, (new StringBuilder()).append("path=").append(((String) (obj))).toString());
            obj = new File(((String) (obj)), "umeng-message.config");
            flag = ((File) (obj)).exists();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        bufferedreader = new BufferedReader(new FileReader(((File) (obj))));
_L4:
        obj = bufferedreader;
        s = bufferedreader.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = bufferedreader;
        if (!s.startsWith("sign=")) goto _L4; else goto _L3
_L3:
        obj = bufferedreader;
        s = s.substring("sign=".length());
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        bufferedreader.close();
_L5:
        return s;
        obj;
        ((IOException) (obj)).printStackTrace();
        if (true) goto _L5; else goto _L2
_L2:
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        bufferedreader.close();
        return null;
        obj;
        ((IOException) (obj)).printStackTrace();
        return null;
        Object obj1;
        obj1;
        bufferedreader = null;
_L12:
        obj = bufferedreader;
        ((FileNotFoundException) (obj1)).printStackTrace();
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        bufferedreader.close();
        return null;
        obj;
        ((IOException) (obj)).printStackTrace();
        return null;
        obj1;
        bufferedreader = null;
_L10:
        obj = bufferedreader;
        ((IOException) (obj1)).printStackTrace();
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        bufferedreader.close();
        return null;
        obj;
        ((IOException) (obj)).printStackTrace();
        return null;
        Exception exception;
        exception;
        obj = null;
_L8:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        ((BufferedReader) (obj)).close();
_L6:
        throw exception;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
          goto _L6
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        obj1;
        if (true) goto _L10; else goto _L9
_L9:
        obj1;
        if (true) goto _L12; else goto _L11
_L11:
        return null;
    }

    private JSONObject e()
        throws JSONException
    {
        String s = UmengRegistrar.getRegistrationId(e);
        String s1 = DeviceConfig.getUtdid(e);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("header", b);
        jsonobject.put("utdid", s1);
        jsonobject.put("device_token", s);
        return jsonobject;
    }

    public static UTrack getInstance(Context context)
    {
        com/umeng/message/UTrack;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c = new UTrack(context);
        }
        context = c;
        com/umeng/message/UTrack;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    void a(UMessage umessage)
    {
        if (umessage == null || umessage.msg_id == null)
        {
            return;
        } else
        {
            a(umessage.msg_id, 0, umessage.random_min * 60000L);
            return;
        }
    }

    public boolean addAlias(String s, String s1)
        throws com.umeng.message.proguard.aD.e, JSONException, Exception
    {
        if (TextUtils.isEmpty(s1))
        {
            Log.b(a, "addAlias: empty type");
        } else
        if (c())
        {
            if (MessageSharedPrefs.getInstance(e).isAliasSet(s, s1))
            {
                Log.c(a, String.format("addAlias: <%s, %s> has been synced to the server before. Ingore this request.", new Object[] {
                    s, s1
                }));
                return true;
            }
            if (MessageSharedPrefs.getInstance(e).getAliasCount() >= 20 && !MessageSharedPrefs.getInstance(e).isAliaseTypeSet(s1))
            {
                Log.b(a, String.format("addAlias: <%s, %s>, More than 20 types of alias have been added. Ignore this request", new Object[] {
                    s, s1
                }));
                return false;
            }
            Object obj = e();
            ((JSONObject) (obj)).put("alias", s);
            ((JSONObject) (obj)).put("type", s1);
            ((JSONObject) (obj)).put("last_alias", MessageSharedPrefs.getInstance(e).getLastAlias(s1));
            ((JSONObject) (obj)).put("ts", System.currentTimeMillis());
            aE ae = new aE(e);
            obj = ae.a(ae.a(((JSONObject) (obj))), MsgConstant.ALIAS_ENDPOINT);
            Log.c(a, (new StringBuilder()).append("addAlias: ").append(((com.umeng.message.proguard.aB.a) (obj)).p()).toString());
            if (obj != null && ((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a))
            {
                MessageSharedPrefs.getInstance(e).addAlias(s, s1);
                return true;
            }
        }
        return false;
    }

    public JSONObject getHeader()
    {
        return b;
    }

    public boolean removeAlias(String s, String s1)
        throws com.umeng.message.proguard.aD.e, JSONException, Exception
    {
        if (TextUtils.isEmpty(s1))
        {
            Log.b(a, "removeAlias: empty type");
        } else
        if (c())
        {
            Object obj = e();
            ((JSONObject) (obj)).put("alias", s);
            ((JSONObject) (obj)).put("type", s1);
            ((JSONObject) (obj)).put("ts", System.currentTimeMillis());
            aE ae = new aE(e);
            obj = ae.a(ae.a(((JSONObject) (obj))), MsgConstant.DELETE_ALIAS_ENDPOINT);
            Log.c(a, (new StringBuilder()).append("removeAlias: ").append(((com.umeng.message.proguard.aB.a) (obj)).p()).toString());
            if (obj != null && ((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a))
            {
                MessageSharedPrefs.getInstance(e).removeAlias(s, s1);
                return true;
            }
        }
        return false;
    }

    public void sendCachedMsgLog(long l)
    {
        if (!c())
        {
            return;
        }
        if (f)
        {
            Log.c(a, "sendCachedMsgLog already in queue, abort this request.");
            return;
        } else
        {
            Log.c(a, "sendCachedMsgLog start, set cacheLogSending flag");
            f = true;
            Runnable runnable = new Runnable() {

                final UTrack a;

                public void run()
                {
                    for (Object obj = MsgLogStore.getInstance(UTrack.a(a)).getMsgLogs(1); ((ArrayList) (obj)).size() > 0; obj = MsgLogStore.getInstance(UTrack.a(a)).getMsgLogs(1))
                    {
                        obj = (MsgLogStore.MsgLog)((ArrayList) (obj)).get(0);
                        UTrack.a(a, ((MsgLogStore.MsgLog) (obj)).msgId, ((MsgLogStore.MsgLog) (obj)).actionType, ((MsgLogStore.MsgLog) (obj)).time);
                    }

                    Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
                    UTrack.a(false);
                    return;
                    Object obj1;
                    obj1;
                    ((Throwable) (obj1)).printStackTrace();
                    Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
                    UTrack.a(false);
                    return;
                    obj1;
                    Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
                    UTrack.a(false);
                    throw obj1;
                }

            
            {
                a = UTrack.this;
                super();
            }
            };
            Log.c(a, String.format("sendCachedMsgLog(delay=%d)", new Object[] {
                Long.valueOf(l)
            }));
            d.schedule(runnable, l, TimeUnit.MILLISECONDS);
            return;
        }
    }

    public void trackAppLaunch(long l)
    {
        if (!c())
        {
            return;
        }
        if (g)
        {
            Log.c(a, "trackAppLaunch already in queue, abort this request.");
            return;
        } else
        {
            Log.c(a, "trackAppLaunch start, set appLaunchSending flag");
            g = true;
            Runnable runnable = new Runnable() {

                final UTrack a;

                public void run()
                {
                    byte byte0 = -1;
                    Object obj;
                    obj = com.umeng.message.UTrack.b(a);
                    aE ae = new aE(UTrack.a(a));
                    obj = ae.a(ae.a(((JSONObject) (obj))), MsgConstant.LAUNCH_ENDPOINT);
                    if (obj == null) goto _L2; else goto _L1
_L1:
                    if (!((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a)) goto _L2; else goto _L3
_L3:
                    MessageSharedPrefs.getInstance(UTrack.a(a)).setAppLaunchLogSentAt(System.currentTimeMillis());
                    if (!((com.umeng.message.proguard.aB.a) (obj)).t() || !((com.umeng.message.proguard.aB.a) (obj)).u().o()) goto _L5; else goto _L4
_L4:
                    int i;
                    i = ((com.umeng.message.proguard.aB.a) (obj)).u().p();
                    Log.c(UTrack.a(), (new StringBuilder()).append("launch_policy:").append(i).toString());
_L8:
                    int j = byte0;
                    if (!((com.umeng.message.proguard.aB.a) (obj)).t())
                    {
                        break MISSING_BLOCK_LABEL_182;
                    }
                    j = byte0;
                    if (((com.umeng.message.proguard.aB.a) (obj)).u().q())
                    {
                        j = ((com.umeng.message.proguard.aB.a) (obj)).u().r();
                        Log.c(UTrack.a(), (new StringBuilder()).append("tag_policy:").append(j).toString());
                    }
                    if (i <= 0)
                    {
                        break MISSING_BLOCK_LABEL_200;
                    }
                    MessageSharedPrefs.getInstance(UTrack.a(a)).setAppLaunchLogSendPolicy(i);
                    if (j <= 0) goto _L2; else goto _L6
_L6:
                    MessageSharedPrefs.getInstance(UTrack.a(a)).setTagSendPolicy(j);
_L2:
                    com.umeng.message.UTrack.b(false);
                    return;
                    Object obj1;
                    obj1;
                    ((JSONException) (obj1)).printStackTrace();
                    com.umeng.message.UTrack.b(false);
                    return;
                    obj1;
                    ((Exception) (obj1)).printStackTrace();
                    com.umeng.message.UTrack.b(false);
                    return;
                    obj1;
                    com.umeng.message.UTrack.b(false);
                    throw obj1;
_L5:
                    i = -1;
                    if (true) goto _L8; else goto _L7
_L7:
                }

            
            {
                a = UTrack.this;
                super();
            }
            };
            Log.c(a, String.format("trackAppLaunch(delay=%d)", new Object[] {
                Long.valueOf(l)
            }));
            d.schedule(runnable, l, TimeUnit.MILLISECONDS);
            return;
        }
    }

    public void trackMsgClick(UMessage umessage)
    {
        if (umessage == null || umessage.msg_id == null)
        {
            return;
        } else
        {
            a(umessage.msg_id, 1, umessage.random_min * 60000L);
            ((UmengMessageHandler)PushAgent.getInstance(e).getMessageHandler()).setPrevMessage(null);
            return;
        }
    }

    public void trackMsgDismissed(UMessage umessage)
    {
        if (umessage == null || umessage.msg_id == null)
        {
            return;
        } else
        {
            a(umessage.msg_id, 2, umessage.random_min * 60000L);
            ((UmengMessageHandler)PushAgent.getInstance(e).getMessageHandler()).setPrevMessage(null);
            return;
        }
    }

    public void trackRegister()
    {
        if (!c())
        {
            return;
        }
        if (h)
        {
            Log.c(a, "sendRegisterLog already in queue, abort this request.");
            return;
        } else
        {
            Log.c(a, "trackRegisterLog start, set registerSending flag");
            h = true;
            Runnable runnable = new Runnable() {

                final UTrack a;

                public void run()
                {
                    Object obj;
                    obj = com.umeng.message.UTrack.b(a);
                    Object obj2 = UTrack.c(a);
                    if (!ax.d(((String) (obj2))))
                    {
                        Log.c(UTrack.a(), (new StringBuilder()).append("TestDevice sign =").append(((String) (obj2))).toString());
                        ((JSONObject) (obj)).put("TD", obj2);
                    }
                    obj2 = new aE(UTrack.a(a));
                    obj = ((aE) (obj2)).a(((aE) (obj2)).a(((JSONObject) (obj))), MsgConstant.REGISTER_ENDPOINT);
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_112;
                    }
                    if (((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a))
                    {
                        UmengRegistrar.a(UTrack.a(a), true);
                    }
                    UTrack.c(false);
                    return;
                    Object obj1;
                    obj1;
                    ((com.umeng.message.proguard.aD.e) (obj1)).printStackTrace();
                    UTrack.c(false);
                    return;
                    obj1;
                    ((Exception) (obj1)).printStackTrace();
                    UTrack.c(false);
                    return;
                    obj1;
                    UTrack.c(false);
                    throw obj1;
                }

            
            {
                a = UTrack.this;
                super();
            }
            };
            Log.c(a, String.format("trackRegister(delay=%d)", new Object[] {
                Integer.valueOf(0)
            }));
            d.schedule(runnable, 0L, TimeUnit.MILLISECONDS);
            return;
        }
    }

}
