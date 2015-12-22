// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import java.util.Iterator;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface, AdTrackerRequestResponseBuilder, AdTrackerWebViewLoader

static final class der extends Handler
{

    static final int a = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryInterval();
    static final int b = AdTrackerInitializer.getConfigParams().getReferrerWaitTime();
    static final int c = AdTrackerInitializer.getConfigParams().getWebviewTimeout();

    public void handleMessage(Message message)
    {
        int i;
        int j;
        boolean flag;
        j = 0;
        i = 0;
        flag = true;
        message.what;
        JVM INSTR tableswitch 2 12: default 72
    //                   2 289
    //                   3 660
    //                   4 891
    //                   5 1196
    //                   6 743
    //                   7 796
    //                   8 979
    //                   9 1279
    //                   10 1384
    //                   11 1607
    //                   12 1636;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        Object obj;
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Enqueuing message goal ...");
        obj = (Goal)AdTrackerNetworkInterface.f().get(message.arg1);
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) goto _L14; else goto _L13
_L13:
        obj.state = com.inmobi.commons.analytics.iat.impl.ty;
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "Network Unavailable. Aborting attempt to report goal ...");
        sendEmptyMessage(12);
_L20:
        return;
_L14:
        AdTrackerNetworkInterface.f().saveGoals();
        AdTrackerNetworkInterface.a(AdTrackerInitializer.getLogger().startNewSample());
        if (com.inmobi.commons.analytics.iat.impl. != ((Goal) (obj)).state) goto _L16; else goto _L15
_L15:
        if (message.arg1 != 0) goto _L18; else goto _L17
_L17:
        obj.state = com.inmobi.commons.analytics.iat.impl.;
        Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Goal ").append(((Goal) (obj)).name).append(" enqueued successfully for reporting").toString());
        long l = AdTrackerNetworkInterface.a(((Goal) (obj)), flag);
        i = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
        obj = Message.obtain();
        obj.what = 2;
        obj.arg1 = message.arg1;
        obj.arg2 = i + 1;
        obj.obj = (String)message.obj;
        sendMessageDelayed(((Message) (obj)), l);
        return;
_L18:
        Object obj1 = (Goal)AdTrackerNetworkInterface.f().get(message.arg1 - 1);
        if (com.inmobi.commons.analytics.iat.impl.ED == ((Goal) (obj1)).state) goto _L17; else goto _L16
_L16:
        flag = false;
          goto _L17
_L2:
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Trying to fetch referrer ...");
        ((Goal)AdTrackerNetworkInterface.f().get(message.arg1)).state = com.inmobi.commons.analytics.iat.impl.D;
        if (!AdTrackerNetworkInterface.g())
        {
            if (!AdTrackerNetworkInterface.h())
            {
                j = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
                int k = message.arg2 - 1;
                message.arg2 = k;
                if (k == 0)
                {
                    if (AdTrackerNetworkInterface.i() || AdTrackerNetworkInterface.g())
                    {
                        i = 1;
                    }
                    if (i != 0)
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
                    obj.arg2 = k;
                    obj.obj = (String)message.obj;
                    sendMessageDelayed(((Message) (obj)), ((j + 1) - k) * a);
                    return;
                }
            }
            if (!AdTrackerNetworkInterface.i())
            {
                long l2 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime");
                obj = Message.obtain();
                obj.what = 3;
                obj.arg1 = message.arg1;
                long l1;
                if (l2 < 0L)
                {
                    l1 = b;
                } else
                {
                    l1 = l2;
                }
                obj.arg2 = (int)l1;
                obj.obj = (String)message.obj;
                sendMessageDelayed(((Message) (obj)), l2);
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
        obj.state = com.inmobi.commons.analytics.iat.impl.ED;
        AdTrackerRequestResponseBuilder.reportGoalOverHttp(message, ((Goal) (obj)), FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids"));
        return;
_L7:
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Reporting Goal via webview");
        obj1 = (Goal)AdTrackerNetworkInterface.f().get(message.arg1);
        obj1.state = com.inmobi.commons.analytics.iat.impl.ED;
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
        ((Goal)AdTrackerNetworkInterface.f().get(message.arg1)).state = com.inmobi.commons.analytics.iat.impl.;
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
        if (com.inmobi.commons.analytics.iat.impl.ED != ((Goal) (obj)).state) goto _L20; else goto _L19
_L19:
        obj.state = com.inmobi.commons.analytics.iat.impl.ED;
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, ((Goal) (obj)), 1, message.arg2, 0, null);
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "goalPingSuccess", true);
        if ("download".equals(((Goal) (obj)).name))
        {
            AdTrackerUtils.updateStatus();
        }
        message = message.getData().getString("appId");
        obj1 = AdTrackerNetworkInterface.f().iterator();
        i = 0;
        do
        {
            if (!((Iterator) (obj1)).hasNext() || ((Goal)((Iterator) (obj1)).next()).equals(obj))
            {
                obj = Message.obtain();
                if (i == AdTrackerNetworkInterface.f().size() - 1)
                {
                    obj.what = 11;
                    obj.arg1 = i;
                    obj.obj = message;
                } else
                {
                    obj.what = 1;
                    obj.arg1 = i + 1;
                    obj.obj = message;
                    ((Goal)AdTrackerNetworkInterface.f().get(((Message) (obj)).arg1)).state = com.inmobi.commons.analytics.iat.impl.;
                }
                AdTrackerNetworkInterface.a(0);
                sendMessage(((Message) (obj)));
                return;
            }
            i++;
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
        obj.state = com.inmobi.commons.analytics.iat.impl.UT;
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
        if (com.inmobi.commons.analytics.iat.impl.ED != ((Goal) (obj)).state) goto _L20; else goto _L21
_L21:
        obj.state = com.inmobi.commons.analytics.iat.impl.ED;
        obj1 = AdTrackerNetworkInterface.f().iterator();
        i = j;
_L23:
        do
        {
            if (!((Iterator) (obj1)).hasNext() || ((Goal)((Iterator) (obj1)).next()).equals(obj))
            {
                Message message1 = Message.obtain();
                message1.arg1 = i;
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
            i++;
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
                if (com.inmobi.commons.analytics.iat.impl.ED == goal.state)
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


    public der(Looper looper)
    {
        super(looper);
    }
}
