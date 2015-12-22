// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            IMAICore, RequestResponseManager, IMAIClickEventList

class a
    implements com.inmobi.commons.analytics.net.on.HttpRequestCallback
{

    final a a;

    public void notifyResult(int i, Object obj)
    {
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Got PING IN WEBVIEW callback. Status: ").append(i).toString());
        if (i == 0)
        {
            try
            {
                IMAICore.firePingInWebViewSuccessful(a.a, a.a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.internal("[InMobi]-[Monetization]", "Exception", ((Throwable) (obj)));
            }
            break MISSING_BLOCK_LABEL_77;
        }
        IMAICore.fireErrorEvent(a.a, "IMAI Ping in webview failed", "pingInWebview", a.a);
        return;
    }

    tList(tList tlist)
    {
        a = tlist;
        super();
    }

    // Unreferenced inner class com/inmobi/monetization/internal/imai/IMAICore$3

/* anonymous class */
    static final class IMAICore._cls3
        implements Runnable
    {

        final String a;
        final boolean b;
        final WeakReference c;

        public void run()
        {
            try
            {
                int i = Initializer.getConfigParams().getImai().getMaxRetry();
                ClickData clickdata = new ClickData(a, b, true, i);
                RequestResponseManager requestresponsemanager = new RequestResponseManager();
                requestresponsemanager.init();
                RequestResponseManager.mNetworkQueue.add(0, clickdata);
                requestresponsemanager.processClick(InternalSDKUtil.getContext(), new IMAICore._cls3._cls1(this));
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Monetization]", "Exception ping in background", exception);
            }
        }

            
            {
                a = s;
                b = flag;
                c = weakreference;
                super();
            }
    }

}
