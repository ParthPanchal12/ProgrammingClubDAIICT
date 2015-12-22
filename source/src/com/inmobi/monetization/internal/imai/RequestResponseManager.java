// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import android.content.Context;
import android.os.Handler;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            IMAIClickEventList, WebviewLoader

public final class RequestResponseManager
{

    static Thread a;
    static Handler b = new Handler();
    static AtomicBoolean c = null;
    private static AtomicBoolean g = null;
    private static AtomicBoolean i = null;
    public static AtomicBoolean isSynced;
    public static IMAIClickEventList mDBWriterQueue = new IMAIClickEventList();
    public static IMAIClickEventList mNetworkQueue = null;
    String d;
    String e;
    String f;
    private WebviewLoader h;

    public RequestResponseManager()
    {
        h = null;
        d = "";
        e = "";
        f = "";
    }

    static AtomicBoolean a()
    {
        return i;
    }

    public void deinit()
    {
        try
        {
            if (g != null)
            {
                g.set(false);
            }
            if (mDBWriterQueue != null)
            {
                mDBWriterQueue.saveClickEvents();
                mDBWriterQueue.clear();
            }
            isSynced.set(false);
            if (mNetworkQueue != null)
            {
                mNetworkQueue.clear();
            }
            mNetworkQueue = null;
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Request Response Manager deinit failed", exception);
        }
    }

    public void init()
    {
        try
        {
            if (mNetworkQueue == null)
            {
                mNetworkQueue = IMAIClickEventList.getLoggedClickEvents();
            }
            if (g == null)
            {
                g = new AtomicBoolean(false);
            }
            i = new AtomicBoolean(true);
            isSynced = new AtomicBoolean(false);
            c = new AtomicBoolean(false);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Request Response Manager init failed", exception);
        }
    }

    public void processClick(Context context, com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback httprequestcallback)
    {
        try
        {
            if (g.compareAndSet(false, true))
            {
                a = new Thread(new Runnable(context, httprequestcallback) {

                    final Context a;
                    final com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback b;
                    final RequestResponseManager c;

                    public void run()
                    {
_L10:
                        if (RequestResponseManager.isSynced.get())
                        {
                            break MISSING_BLOCK_LABEL_643;
                        }
                        RequestResponseManager.isSynced.set(true);
                        if (RequestResponseManager.mNetworkQueue != null && !RequestResponseManager.mNetworkQueue.isEmpty())
                        {
                            break MISSING_BLOCK_LABEL_77;
                        }
                        if (RequestResponseManager.mDBWriterQueue == null && RequestResponseManager.mDBWriterQueue.isEmpty())
                        {
                            Log.internal("[InMobi]-[Monetization]", "Click event list empty");
                            c.deinit();
                            return;
                        }
                        RequestResponseManager.mNetworkQueue.addAll(RequestResponseManager.mDBWriterQueue);
                        RequestResponseManager.mDBWriterQueue.clear();
_L5:
                        Object obj;
                        String s;
                        int j;
                        int k;
                        boolean flag;
                        boolean flag1;
                        if (RequestResponseManager.mNetworkQueue.isEmpty())
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                        obj = (ClickData)RequestResponseManager.mNetworkQueue.remove(0);
                        s = ((ClickData) (obj)).getClickUrl();
                        j = ((ClickData) (obj)).getRetryCount();
                        flag = ((ClickData) (obj)).isPingWv();
                        flag1 = ((ClickData) (obj)).isFollowRedirects();
                        k = Initializer.getConfigParams().getImai().getRetryInterval();
                        if (InternalSDKUtil.checkNetworkAvailibility(a))
                        {
                            break MISSING_BLOCK_LABEL_215;
                        }
                        Log.internal("[InMobi]-[Monetization]", "Cannot process click. Network Not available");
                        if (j <= 1)
                        {
                            break MISSING_BLOCK_LABEL_162;
                        }
                        RequestResponseManager.mDBWriterQueue.add(obj);
                        Exception exception;
                        if (b != null)
                        {
                            b.notifyResult(1, null);
                        }
                        c.deinit();
                        return;
                        int l = Initializer.getConfigParams().getImai().getMaxRetry();
                        if (RequestResponseManager.a().get() || j >= l)
                        {
                            break MISSING_BLOCK_LABEL_292;
                        }
                        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Retrying to ping in background after ").append(k / 1000).append(" secs").toString());
                        Thread thread = RequestResponseManager.a;
                        thread;
                        JVM INSTR monitorenter ;
                        RequestResponseManager.a.wait(k);
_L6:
                        try
                        {
                            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Processing click in background: ").append(s).toString());
                        }
                        // Misplaced declaration of an exception variable
                        catch (Exception exception)
                        {
                            try
                            {
                                Log.internal("[InMobi]-[Monetization]", "Exception pinging click in background", exception);
                                c.deinit();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Exception exception)
                            {
                                Log.internal("[InMobi]-[Monetization]", "Exception ping to server ", exception);
                            }
                            return;
                        }
                        if (!flag) goto _L2; else goto _L1
_L1:
                        if (!c.processClickUrlInWebview(s)) goto _L4; else goto _L3
_L3:
                        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ping in webview successful: ").append(s).toString());
                        if (b != null)
                        {
                            b.notifyResult(0, null);
                        }
_L7:
                        if (RequestResponseManager.mDBWriterQueue.size() > Initializer.getConfigParams().getImai().getmDefaultEventsBatch())
                        {
                            RequestResponseManager.mDBWriterQueue.saveClickEvents();
                            RequestResponseManager.mDBWriterQueue.clear();
                        }
                          goto _L5
                        InterruptedException interruptedexception;
                        interruptedexception;
                        Log.internal("[InMobi]-[Monetization]", "Network thread wait failure", interruptedexception);
                          goto _L6
                        obj;
                        thread;
                        JVM INSTR monitorexit ;
                        throw obj;
_L4:
                        ((ClickData) (obj)).setRetryCount(j - 1);
                        if (j <= 1)
                        {
                            break MISSING_BLOCK_LABEL_449;
                        }
                        RequestResponseManager.mDBWriterQueue.add(obj);
                        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ping in webview failed: ").append(s).toString());
                        if (b != null)
                        {
                            b.notifyResult(1, null);
                        }
                          goto _L7
_L2:
label0:
                        {
                            if (!c.processClickHttpClient(s, flag1))
                            {
                                break label0;
                            }
                            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ping successful: ").append(s).toString());
                            if (b != null)
                            {
                                b.notifyResult(0, null);
                            }
                        }
                          goto _L7
                        ((ClickData) (obj)).setRetryCount(j - 1);
                        if (j <= 1)
                        {
                            break MISSING_BLOCK_LABEL_574;
                        }
                        RequestResponseManager.mDBWriterQueue.add(obj);
                        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ping  failed: ").append(s).toString());
                        if (b != null)
                        {
                            b.notifyResult(1, null);
                        }
                        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ping failed: ").append(s).toString());
                          goto _L7
                        c.deinit();
                        return;
                        if (true) goto _L5; else goto _L8
_L8:
                        if (true) goto _L10; else goto _L9
_L9:
                    }

            
            {
                c = RequestResponseManager.this;
                a = context;
                b = httprequestcallback;
                super();
            }
                });
                a.setPriority(1);
                a.start();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception ping ", context);
        }
    }

    public boolean processClickHttpClient(String s, boolean flag)
    {
        Object obj = null;
        int j;
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Processing click in http client ").append(s).toString());
        j = Initializer.getConfigParams().getImai().getPingTimeOut();
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setInstanceFollowRedirects(flag);
        s.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        s.setConnectTimeout(j);
        s.setReadTimeout(j);
        s.setUseCaches(false);
        s.setRequestProperty("user-agent", InternalSDKUtil.getSavedUserAgent());
        s.setRequestMethod("GET");
        j = s.getResponseCode();
        Exception exception1;
        boolean flag1;
        if (j < 400)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        i.set(true);
_L11:
        if (s == null) goto _L4; else goto _L3
_L3:
        s.disconnect();
        flag1 = flag;
_L6:
        return flag1;
_L2:
        try
        {
            i.set(false);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            obj = s;
            s = exception;
            continue; /* Loop/switch isn't completed */
        }
_L9:
        i.set(false);
        Log.internal("[InMobi]-[Monetization]", "Click in background exception", ((Throwable) (obj)));
        flag1 = flag;
        if (s == null) goto _L6; else goto _L5
_L5:
        s.disconnect();
        return flag;
        s;
_L8:
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw s;
        exception1;
        obj = s;
        s = exception1;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        flag = false;
        s = null;
          goto _L9
        obj;
        flag = false;
          goto _L9
_L4:
        return flag;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public boolean processClickUrlInWebview(String s)
    {
        int j;
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Processing click in webview ").append(s).toString());
        h = new WebviewLoader(InternalSDKUtil.getContext());
        j = Initializer.getConfigParams().getImai().getPingTimeOut();
        h.loadInWebview(s, null);
        s = a;
        s;
        JVM INSTR monitorenter ;
        a.wait(j);
_L1:
        if (!c.get())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        i.set(true);
_L2:
        boolean flag;
        h.deinit(j);
        flag = c.get();
        return flag;
        Object obj;
        obj;
        Log.internal("[InMobi]-[Monetization]", "Network thread wait failure", ((Throwable) (obj)));
          goto _L1
        obj;
        s;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Monetization]", "ping in webview exception", s);
        }
        return c.get();
        i.set(false);
        WebviewLoader.b.set(false);
          goto _L2
    }

}
