// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader, AdTrackerRequestResponseBuilder

public class AdTrackerNetworkInterface
{
    static final class a extends Handler
    {

        static final int a = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryInterval();
        static final int b = AdTrackerInitializer.getConfigParams().getReferrerWaitTime();
        static final int c = AdTrackerInitializer.getConfigParams().getWebviewTimeout();

        public void handleMessage(Message message)
        {
            int i1;
            int j1;
            boolean flag;
            j1 = 0;
            i1 = 0;
            flag = true;
            message.what;
            JVM INSTR tableswitch 2 12: default 72
        //                       2 289
        //                       3 660
        //                       4 891
        //                       5 1196
        //                       6 743
        //                       7 796
        //                       8 979
        //                       9 1279
        //                       10 1384
        //                       11 1607
        //                       12 1636;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
            Object obj;
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Enqueuing message goal ...");
            obj = (Goal)AdTrackerNetworkInterface.f().get(message.arg1);
            if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) goto _L14; else goto _L13
_L13:
            obj.state = com.inmobi.commons.analytics.iat.impl.Goal.State.ENQUEUE_PENDING;
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "Network Unavailable. Aborting attempt to report goal ...");
            sendEmptyMessage(12);
_L20:
            return;
_L14:
            AdTrackerNetworkInterface.f().saveGoals();
            AdTrackerNetworkInterface.a(AdTrackerInitializer.getLogger().startNewSample());
            if (com.inmobi.commons.analytics.iat.impl.Goal.State.ENQUEUE_REQUESTED != ((Goal) (obj)).state) goto _L16; else goto _L15
_L15:
            if (message.arg1 != 0) goto _L18; else goto _L17
_L17:
            obj.state = com.inmobi.commons.analytics.iat.impl.Goal.State.ENQUEUE_SUCCEEDED;
            Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Goal ").append(((Goal) (obj)).name).append(" enqueued successfully for reporting").toString());
            long l1 = AdTrackerNetworkInterface.a(((Goal) (obj)), flag);
            i1 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
            obj = Message.obtain();
            obj.what = 2;
            obj.arg1 = message.arg1;
            obj.arg2 = i1 + 1;
            obj.obj = (String)message.obj;
            sendMessageDelayed(((Message) (obj)), l1);
            return;
_L18:
            Object obj1 = (Goal)AdTrackerNetworkInterface.f().get(message.arg1 - 1);
            if (com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_COMPLETED == ((Goal) (obj1)).state) goto _L17; else goto _L16
_L16:
            flag = false;
              goto _L17
_L2:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Trying to fetch referrer ...");
            ((Goal)AdTrackerNetworkInterface.f().get(message.arg1)).state = com.inmobi.commons.analytics.iat.impl.Goal.State.REFERRER_REQUESTED;
            if (!AdTrackerNetworkInterface.g())
            {
                if (!AdTrackerNetworkInterface.h())
                {
                    j1 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
                    int k1 = message.arg2 - 1;
                    message.arg2 = k1;
                    if (k1 == 0)
                    {
                        if (AdTrackerNetworkInterface.i() || AdTrackerNetworkInterface.g())
                        {
                            i1 = 1;
                        }
                        if (i1 != 0)
                        {
                            obj = Message.obtain();
                            obj.what = 4;
                            obj.arg1 = message.arg1;
                            obj.obj = (String)message.obj;
                            sendMessage(((Message) (obj)));
                            return;
                        } else
                        {
                            obj = Message.obtain();
                            obj.what = 3;
                            obj.arg1 = message.arg1;
                            obj.arg2 = b;
                            obj.obj = (String)message.obj;
                            sendMessageDelayed(((Message) (obj)), b);
                            return;
                        }
                    } else
                    {
                        obj = Message.obtain();
                        obj.what = 2;
                        obj.arg1 = message.arg1;
                        obj.arg2 = k1;
                        obj.obj = (String)message.obj;
                        sendMessageDelayed(((Message) (obj)), ((j1 + 1) - k1) * a);
                        return;
                    }
                }
                if (!AdTrackerNetworkInterface.i())
                {
                    long l3 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime");
                    obj = Message.obtain();
                    obj.what = 3;
                    obj.arg1 = message.arg1;
                    long l2;
                    if (l3 < 0L)
                    {
                        l2 = b;
                    } else
                    {
                        l2 = l3;
                    }
                    obj.arg2 = (int)l2;
                    obj.obj = (String)message.obj;
                    sendMessageDelayed(((Message) (obj)), l3);
                    return;
                } else
                {
                    obj = Message.obtain();
                    obj.what = 4;
                    obj.arg1 = message.arg1;
                    obj.obj = (String)message.obj;
                    sendMessage(((Message) (obj)));
                    return;
                }
            } else
            {
                obj = Message.obtain();
                obj.what = 4;
                obj.arg1 = message.arg1;
                obj.obj = (String)message.obj;
                sendMessage(((Message) (obj)));
                return;
            }
_L3:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Referrer wait timed out. MESSAGE_GET_REFERRER received ...");
            if (!AdTrackerNetworkInterface.i())
            {
                obj = Message.obtain();
                obj.what = 5;
                obj.arg1 = message.arg1;
                obj.obj = (String)message.obj;
                sendMessage(((Message) (obj)));
                return;
            } else
            {
                obj = Message.obtain();
                obj.what = 4;
                obj.arg1 = message.arg1;
                obj.obj = (String)message.obj;
                sendMessage(((Message) (obj)));
                return;
            }
_L6:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Reporting Goal via network ...");
            obj = (Goal)AdTrackerNetworkInterface.f().get(message.arg1);
            message = (String)message.obj;
            obj.state = com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_REQUESTED;
            AdTrackerRequestResponseBuilder.reportGoalOverHttp(message, ((Goal) (obj)), FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids"));
            return;
_L7:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Reporting Goal via webview");
            obj1 = (Goal)AdTrackerNetworkInterface.f().get(message.arg1);
            obj1.state = com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_REQUESTED;
            obj = (String)message.obj;
            AdTrackerNetworkInterface.a(new AdTrackerWebViewLoader());
            AdTrackerRequestResponseBuilder.saveWebviewRequestParam(((String) (obj)), ((Goal) (obj1)));
            AdTrackerNetworkInterface.j().loadWebview(((String) (obj)), ((Goal) (obj1)));
            obj1 = Message.obtain();
            obj1.what = 9;
            obj1.arg1 = message.arg1;
            obj1.obj = obj;
            sendMessageDelayed(((Message) (obj1)), c);
            return;
_L4:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "GET_REFFERRER_SUCCEEDED message received");
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer", true);
            ((Goal)AdTrackerNetworkInterface.f().get(message.arg1)).state = com.inmobi.commons.analytics.iat.impl.Goal.State.REFERRER_ACQUIRED;
            obj = Message.obtain();
            obj.arg1 = message.arg1;
            obj.obj = (String)message.obj;
            if (AdTrackerNetworkInterface.k())
            {
                obj.what = 6;
            } else
            {
                obj.what = 7;
            }
            sendMessage(((Message) (obj)));
            return;
_L8:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Reporting Goal succeeded...");
            obj = (Goal)message.obj;
            if (com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_REQUESTED != ((Goal) (obj)).state) goto _L20; else goto _L19
_L19:
            obj.state = com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_COMPLETED;
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, ((Goal) (obj)), 1, message.arg2, 0, null);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "goalPingSuccess", true);
            if ("download".equals(((Goal) (obj)).name))
            {
                AdTrackerUtils.updateStatus();
            }
            message = message.getData().getString("appId");
            obj1 = AdTrackerNetworkInterface.f().iterator();
            i1 = 0;
            do
            {
                if (!((Iterator) (obj1)).hasNext() || ((Goal)((Iterator) (obj1)).next()).equals(obj))
                {
                    obj = Message.obtain();
                    if (i1 == AdTrackerNetworkInterface.f().size() - 1)
                    {
                        obj.what = 11;
                        obj.arg1 = i1;
                        obj.obj = message;
                    } else
                    {
                        obj.what = 1;
                        obj.arg1 = i1 + 1;
                        obj.obj = message;
                        ((Goal)AdTrackerNetworkInterface.f().get(((Message) (obj)).arg1)).state = com.inmobi.commons.analytics.iat.impl.Goal.State.ENQUEUE_REQUESTED;
                    }
                    AdTrackerNetworkInterface.a(0);
                    sendMessage(((Message) (obj)));
                    return;
                }
                i1++;
            } while (true);
_L5:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Getting referrer timed out...");
            obj = AdTrackerUtils.getReferrerFromLogs();
            if (obj != null)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Saving referrer from logs: ").append(((String) (obj))).toString());
                AdTrackerUtils.setReferrerFromLogs(InternalSDKUtil.getContext(), ((String) (obj)));
            }
            obj = Message.obtain();
            obj.what = 4;
            obj.arg1 = message.arg1;
            obj.obj = (String)message.obj;
            sendMessage(((Message) (obj)));
            return;
_L9:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Reporting message goal timed out...");
            obj = (Goal)AdTrackerNetworkInterface.f().get(message.arg1);
            obj.state = com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_TIMED_OUT;
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, ((Goal) (obj)), 0, 0L, 408, null);
            AdTrackerNetworkInterface.j().deinit(c);
            AdTrackerNetworkInterface.f().increaseRetryTime(((Goal) (obj)).name, ((Goal) (obj)).count, ((Goal) (obj)).isDuplicate);
            obj = Message.obtain();
            obj.what = 1;
            obj.arg1 = message.arg1;
            obj.obj = (String)message.obj;
            sendMessage(((Message) (obj)));
            return;
_L10:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Message report goal failed...");
            obj = (Goal)message.obj;
            if (com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_REQUESTED != ((Goal) (obj)).state) goto _L20; else goto _L21
_L21:
            obj.state = com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_FAILED;
            obj1 = AdTrackerNetworkInterface.f().iterator();
            i1 = j1;
_L23:
            do
            {
                if (!((Iterator) (obj1)).hasNext() || ((Goal)((Iterator) (obj1)).next()).equals(obj))
                {
                    Message message1 = Message.obtain();
                    message1.arg1 = i1;
                    message1.obj = message.getData().getString("appId");
                    if (6001 == message.arg2)
                    {
                        message1.what = 7;
                    } else
                    {
                        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, ((Goal) (obj)), 1, 0L, message.arg2, null);
                        AdTrackerNetworkInterface.f().increaseRetryTime(((Goal) (obj)).name, ((Goal) (obj)).count, ((Goal) (obj)).isDuplicate);
                        if (((Goal) (obj)).retryTime > 0L)
                        {
                            Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Retrying goalname: ").append(obj).append(" after ").append(((Goal) (obj)).retryTime / 1000L).append(" second").toString());
                        }
                        message1.what = 1;
                    }
                    sendMessage(message1);
                    return;
                }
                i1++;
            } while (true);
_L11:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "No more goals to report ...");
            AdTrackerNetworkInterface.f().clear();
            AdTrackerNetworkInterface.f().saveGoals();
            AdTrackerNetworkInterface.l().sendEmptyMessage(1);
            return;
_L12:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Message report goal aborted...");
            AdTrackerNetworkInterface.a(1);
            if (AdTrackerNetworkInterface.f() != null && !AdTrackerNetworkInterface.f().isEmpty())
            {
                message = AdTrackerNetworkInterface.f().iterator();
                do
                {
                    if (!message.hasNext())
                    {
                        break;
                    }
                    Goal goal = (Goal)message.next();
                    if (com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_COMPLETED == goal.state)
                    {
                        message.remove();
                    }
                } while (true);
                AdTrackerNetworkInterface.f().saveGoals();
            }
            AdTrackerNetworkInterface.a(null);
            AdTrackerNetworkInterface.l().sendEmptyMessage(1);
            return;
            if (true) goto _L23; else goto _L22
_L22:
        }


        public a(Looper looper)
        {
            super(looper);
        }
    }

    static final class b extends Handler
    {

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 30;
               goto _L1 _L2
_L1:
            super.handleMessage(message);
_L4:
            return;
_L2:
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "All goals reported ... De-initializing AdTrackerNetworkInterface!");
            if (AdTrackerNetworkInterface.d() != null)
            {
                AdTrackerNetworkInterface.e().set(false);
                AdTrackerNetworkInterface.d().quit();
                message = AdTrackerNetworkInterface.d();
                AdTrackerNetworkInterface.a(null);
                message.interrupt();
                AdTrackerNetworkInterface.a(null);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        b()
        {
        }
    }


    private static GoalList a;
    private static AdTrackerWebViewLoader b;
    private static Handler c;
    private static HandlerThread d;
    private static AtomicBoolean e;
    private static int f = 0;
    private static boolean g = false;
    private static String h = "https://d.appsdt.com/download/tracker/?";
    private static String i = "https://d.appsdt.com/sdkdwnldbeacon.html";
    private static String j = "https://d.appsdt.com/download/tracker/iatsdkconfs?";
    private static Handler k;

    public AdTrackerNetworkInterface()
    {
    }

    static int a(int i1)
    {
        f = i1;
        return i1;
    }

    static long a(Goal goal, boolean flag)
    {
        return b(goal, flag);
    }

    static Handler a(Handler handler)
    {
        k = handler;
        return handler;
    }

    static HandlerThread a(HandlerThread handlerthread)
    {
        d = handlerthread;
        return handlerthread;
    }

    static GoalList a(GoalList goallist)
    {
        a = goallist;
        return goallist;
    }

    static AdTrackerWebViewLoader a(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        b = adtrackerwebviewloader;
        return adtrackerwebviewloader;
    }

    static String a()
    {
        return h;
    }

    static boolean a(boolean flag)
    {
        g = flag;
        return flag;
    }

    private static long b(Goal goal, boolean flag)
    {
        String s = goal.name;
        long l2 = goal.retryTime;
        int i1 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
        long l1;
        if (flag)
        {
            l1 = 0L;
        } else
        {
            l1 = l2;
            if (l2 > (long)i1)
            {
                return (long)i1;
            }
        }
        return l1;
    }

    static String b()
    {
        return i;
    }

    static final Handler c()
    {
        return k;
    }

    static HandlerThread d()
    {
        return d;
    }

    static AtomicBoolean e()
    {
        return e;
    }

    static GoalList f()
    {
        return a;
    }

    static boolean g()
    {
        return p();
    }

    public static GoalList getGoalList()
    {
        return a;
    }

    public static Handler getUIHandler()
    {
        return c;
    }

    static boolean h()
    {
        return o();
    }

    static boolean i()
    {
        return n();
    }

    public static void init()
    {
        if (e == null)
        {
            e = new AtomicBoolean(false);
        }
        if (a == null)
        {
            a = GoalList.getLoggedGoals();
        }
        if (c == null)
        {
            c = new b();
        }
        if (d == null)
        {
            d = new HandlerThread("AdTrackerNetworkHandler");
            d.start();
        }
        if (k == null)
        {
            k = new a(d.getLooper());
        }
    }

    public static boolean isMetricSample()
    {
        return g;
    }

    public static int isUnstableNetwork()
    {
        return f;
    }

    static AdTrackerWebViewLoader j()
    {
        return b;
    }

    static boolean k()
    {
        return m();
    }

    static Handler l()
    {
        return c;
    }

    private static boolean m()
    {
        String s = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive");
        String s1 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.getTime().toString();
        if (s != null && s1 != null)
        {
            Date date = calendar.getTime();
            calendar.add(11, Integer.parseInt(s));
            if (calendar.getTime().after(date))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean n()
    {
        return FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer") != null;
    }

    private static boolean o()
    {
        Object obj2 = (new StringBuilder()).append(j).append("t=").append(System.currentTimeMillis()).toString();
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Fetch referrer wait time URL: ").append(((String) (obj2))).toString());
        Object obj = new DefaultHttpClient();
        obj2 = new HttpGet(((String) (obj2)));
        Object obj1;
        int i1;
        long l1;
        try
        {
            obj = ((DefaultHttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
            i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error fetching wait time for referrer", clientprotocolexception);
            return false;
        }
        catch (IOException ioexception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error fetching wait time for referrer", ioexception);
            return false;
        }
        if (200 != i1)
        {
            return false;
        }
        obj = EntityUtils.toString(((HttpResponse) (obj)).getEntity());
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Wait time received for referrer: ").append(((String) (obj))).toString());
        l1 = (new JSONObject(((String) (obj)))).getLong("referrerWaitTime");
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime", l1 * 1000L);
        return true;
        obj1;
        l1 = a.b;
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime", l1);
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error fetching wait time for referrer", ((Throwable) (obj1)));
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Setting default wait time...");
        return true;
        obj1;
        l1 = a.b;
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime", l1);
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error fetching wait time for referrer", ((Throwable) (obj1)));
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Setting default wait time...");
        return true;
        obj1;
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error fetching wait time for referrer", ((Throwable) (obj1)));
        return false;
    }

    public static void onReceiveReferrer(String s)
    {
        Message message = Message.obtain();
        if (c() != null && c().hasMessages(3))
        {
            Message message1 = c().obtainMessage(3);
            message.what = 4;
            message.arg1 = message1.arg1;
            message.obj = s;
            c().removeMessages(3);
            c().sendMessage(message);
        }
    }

    private static boolean p()
    {
        return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer");
    }

    public static void reportToServer(String s)
    {
        com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface;
        JVM INSTR monitorenter ;
        if (a != null && !a.isEmpty()) goto _L2; else goto _L1
_L1:
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "No goals to report");
_L4:
        com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!e.compareAndSet(false, true)) goto _L4; else goto _L3
_L3:
        k.removeMessages(11);
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Goal goal = (Goal)iterator.next();
            if (com.inmobi.commons.analytics.iat.impl.Goal.State.REPORTING_COMPLETED == goal.state)
            {
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_100;
        s;
        throw s;
        for (Iterator iterator1 = a.iterator(); iterator1.hasNext();)
        {
            ((Goal)iterator1.next()).state = com.inmobi.commons.analytics.iat.impl.Goal.State.ENQUEUE_PENDING;
        }

        a.saveGoals();
        ((Goal)a.get(0)).state = com.inmobi.commons.analytics.iat.impl.Goal.State.ENQUEUE_REQUESTED;
        Message message = Message.obtain();
        message.what = 1;
        message.arg1 = 0;
        message.obj = s;
        k.sendMessage(message);
          goto _L4
    }

}
