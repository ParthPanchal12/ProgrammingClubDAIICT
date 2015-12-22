// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface

static final class  extends Handler
{

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 30;
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

    ()
    {
    }
}
