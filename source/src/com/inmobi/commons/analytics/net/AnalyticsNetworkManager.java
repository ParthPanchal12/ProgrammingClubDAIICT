// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.AutomaticCaptureConfig;
import com.inmobi.commons.analytics.db.AnalyticsDatabaseManager;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

// Referenced classes of package com.inmobi.commons.analytics.net:
//            AnalyticsCommon, AnalyticsPayload, AnalyticsConnectivityReceiver, AnalyticsPayloadBuilder

public final class AnalyticsNetworkManager
{
    class a extends Thread
    {

        final AnalyticsNetworkManager a;

        public void run()
        {
            Looper.prepare();
            AnalyticsNetworkManager.a(new Handler(new android.os.Handler.Callback(this) {

                final a a;

                public boolean handleMessage(Message message)
                {
label0:
                    {
                        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("NetworkManager->handleMessag: msg:").append(message).toString());
                        if (message.what == 1001)
                        {
                            if (AnalyticsInitializer.getConfigParams().getAutomaticCapture().isAutoSessionCaptureEnabled() || AnalyticsEventsWrapper.isEventsUser())
                            {
                                break label0;
                            }
                            AnalyticsUtils.setStartHandle(false);
                        }
                        return true;
                    }
                    AnalyticsNetworkManager.a(a.a);
                    return true;
                }

            
            {
                a = a1;
                super();
            }
            }));
            Looper.loop();
        }

        a()
        {
            a = AnalyticsNetworkManager.this;
            super();
        }
    }


    public static final int MESSAGE_PING = 1001;
    private static Handler a;
    private static AnalyticsNetworkManager b;
    private static AnalyticsConnectivityReceiver.a f = new AnalyticsConnectivityReceiver.a() {

        public void a()
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Connectivity came");
            if (AnalyticsNetworkManager.a() != null && !AnalyticsUtils.getStartHandle())
            {
                AnalyticsUtils.setStartHandle(true);
                AnalyticsNetworkManager.a().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
            }
        }

        public void b()
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Connectivity gone");
        }

    };
    private AnalyticsPayloadBuilder c;
    private AnalyticsConnectivityReceiver d;
    private int e;

    private AnalyticsNetworkManager()
    {
        e = 0;
        (new a()).start();
        Log.debug("[InMobi]-[Analytics]-4.5.5", "NetworkManager-> Constructor ");
    }

    static Handler a()
    {
        return a;
    }

    static Handler a(Handler handler)
    {
        a = handler;
        return handler;
    }

    private String a(String s, String s1, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null)
        {
            stringbuilder.append("payload=");
            stringbuilder.append(AnalyticsCommon.getURLEncoded(s));
        }
        if (s1 != null)
        {
            stringbuilder.append("&mk-siteid=");
            stringbuilder.append(s1);
        }
        stringbuilder.append("&c=");
        if (flag)
        {
            stringbuilder.append(1);
        } else
        {
            stringbuilder.append(0);
        }
        s = AnalyticsInitializer.getConfigParams().getDeviceIdMaskMap();
        s = InternalSDKUtil.encodeMapAndconvertToDelimitedString(UID.getInstance().getMapForEncryption(s), "&");
        stringbuilder.append("&");
        stringbuilder.append(s);
        s = (new StringBuilder()).append("pr-SAND-").append(InternalSDKUtil.getInMobiInternalVersion("4.5.5")).append("-").append("20150522").toString();
        stringbuilder.append("&mk-version=");
        stringbuilder.append(s);
        stringbuilder.append("&u-id-adt=");
        if (UID.getInstance().isLimitAdTrackingEnabled())
        {
            stringbuilder.append(1);
        } else
        {
            stringbuilder.append(0);
        }
        return stringbuilder.toString();
    }

    static void a(AnalyticsNetworkManager analyticsnetworkmanager)
    {
        analyticsnetworkmanager.b();
    }

    private void a(AnalyticsPayload analyticspayload, String s)
    {
        Object obj;
        Log.internal("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Ping URL: ").append(AnalyticsUtils.getEventUrl()).toString());
        obj = analyticspayload.getCompletePayload();
        int i = AnalyticsInitializer.getConfigParams().getMinEventsToCompress();
        Log.internal("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Post body: ").append(((String) (obj))).toString());
        if (analyticspayload.getPayloadSize() < i || android.os.Build.VERSION.SDK_INT < 8)
        {
            break MISSING_BLOCK_LABEL_462;
        }
        Log.debug("[InMobi]-[Analytics]-4.5.5", "Compressing the payload");
        boolean flag = true;
        obj = AnalyticsUtils.compressPayload(((String) (obj)));
_L3:
        int j = AnalyticsInitializer.getConfigParams().getMaxAppIdLength();
        Object obj1 = s;
        if (s.length() > j)
        {
            obj1 = s.substring(0, j);
        }
        s = a(((String) (obj)), ((String) (obj1)), flag);
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Post body: ").append(s).toString());
        obj = new AnalyticsCommon();
        obj1 = ((AnalyticsCommon) (obj)).setupConnection(AnalyticsUtils.getEventUrl());
        ((AnalyticsCommon) (obj)).postData(((HttpURLConnection) (obj1)), s);
        Object obj2;
        String s1;
        try
        {
            j = ((HttpURLConnection) (obj1)).getResponseCode();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            j = 401;
        }
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Http Status Code: ").append(j).toString());
        if (j != 200)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        e = 0;
        AnalyticsDatabaseManager.getInstance().deleteEvents(analyticspayload.getTableIdList());
_L2:
        try
        {
            s = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream(), "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                s = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getErrorStream(), "UTF-8"));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = null;
            }
        }
        obj2 = new StringBuilder();
_L1:
        s1 = s.readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        ((StringBuilder) (obj2)).append(s1).append("\n");
          goto _L1
        e = e + 1;
        if (e >= AnalyticsUtils.getMaxRetryBeforeDiscard())
        {
            e = 0;
            AnalyticsDatabaseManager.getInstance().deleteEvents(analyticspayload.getTableIdList());
        }
          goto _L2
        try
        {
            obj2 = ((StringBuilder) (obj2)).toString();
            Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Ping Response: ").append(((String) (obj2))).toString());
            ((HttpURLConnection) (obj1)).disconnect();
            ((AnalyticsCommon) (obj)).closeResource(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                Log.internal("[InMobi]-[Analytics]-4.5.5", "Unable to read from stream");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.debug("[InMobi]-[Analytics]-4.5.5", "Exception Pinging", s);
            }
        }
        e = e + 1;
        if (e >= AnalyticsUtils.getMaxRetryBeforeDiscard())
        {
            e = 0;
            AnalyticsDatabaseManager.getInstance().deleteEvents(analyticspayload.getTableIdList());
            return;
        } else
        {
            return;
        }
        flag = false;
          goto _L3
    }

    private void b()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        if (d != null)
        {
            flag = flag1;
            if (d.isConnected())
            {
                flag = flag1;
                if (c != null)
                {
                    AnalyticsPayload analyticspayload = c.getPayloadList(AnalyticsDatabaseManager.getInstance().getEvents(), InternalSDKUtil.getContext());
                    flag = flag1;
                    if (analyticspayload.getCompletePayload() != null)
                    {
                        a(analyticspayload, SessionInfo.getAppId(InternalSDKUtil.getContext()));
                        flag = false;
                    }
                }
            }
        }
        if (!flag)
        {
            a.sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
            return;
        } else
        {
            AnalyticsUtils.setStartHandle(false);
            return;
        }
    }

    public static Handler getHandler()
    {
        return a;
    }

    public static AnalyticsNetworkManager startInstance()
    {
        com/inmobi/commons/analytics/net/AnalyticsNetworkManager;
        JVM INSTR monitorenter ;
        AnalyticsNetworkManager analyticsnetworkmanager;
        if (b == null)
        {
            b = new AnalyticsNetworkManager();
        }
        if (b.c == null)
        {
            b.c = new AnalyticsPayloadBuilder();
        }
        if (b.d == null)
        {
            b.d = new AnalyticsConnectivityReceiver(InternalSDKUtil.getContext(), f);
        }
        analyticsnetworkmanager = b;
        com/inmobi/commons/analytics/net/AnalyticsNetworkManager;
        JVM INSTR monitorexit ;
        return analyticsnetworkmanager;
        Exception exception;
        exception;
        throw exception;
    }

}
