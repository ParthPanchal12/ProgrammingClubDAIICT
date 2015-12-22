// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import android.content.Context;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            RequestResponseManager, IMAIClickEventList

class b
    implements Runnable
{

    final Context a;
    final com.inmobi.commons.analytics.net.stCallback b;
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
        int i;
        int j;
        boolean flag;
        boolean flag1;
        if (RequestResponseManager.mNetworkQueue.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (ClickData)RequestResponseManager.mNetworkQueue.remove(0);
        s = ((ClickData) (obj)).getClickUrl();
        i = ((ClickData) (obj)).getRetryCount();
        flag = ((ClickData) (obj)).isPingWv();
        flag1 = ((ClickData) (obj)).isFollowRedirects();
        j = Initializer.getConfigParams().getImai().getRetryInterval();
        if (InternalSDKUtil.checkNetworkAvailibility(a))
        {
            break MISSING_BLOCK_LABEL_215;
        }
        Log.internal("[InMobi]-[Monetization]", "Cannot process click. Network Not available");
        if (i <= 1)
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
        int k = Initializer.getConfigParams().getImai().getMaxRetry();
        if (RequestResponseManager.a().get() || i >= k)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Retrying to ping in background after ").append(j / 1000).append(" secs").toString());
        Thread thread = RequestResponseManager.a;
        thread;
        JVM INSTR monitorenter ;
        RequestResponseManager.a.wait(j);
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
        ((ClickData) (obj)).setRetryCount(i - 1);
        if (i <= 1)
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
        ((ClickData) (obj)).setRetryCount(i - 1);
        if (i <= 1)
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

    lback(RequestResponseManager requestresponsemanager, Context context, com.inmobi.commons.analytics.net.stCallback stcallback)
    {
        c = requestresponsemanager;
        a = context;
        b = stcallback;
        super();
    }
}
