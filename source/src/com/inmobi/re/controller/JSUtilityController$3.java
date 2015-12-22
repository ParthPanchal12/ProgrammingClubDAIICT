// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a extends Thread
{

    final String a;
    final JSUtilityController b;

    public void run()
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        obj = obj1;
        String s = a.replaceAll("%25", "%");
        obj = obj1;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Pinging URL: ").append(s).toString());
        obj = obj1;
        obj1 = (HttpURLConnection)(new URL(s)).openConnection();
        ((HttpURLConnection) (obj1)).setConnectTimeout(20000);
        ((HttpURLConnection) (obj1)).setRequestMethod("GET");
        ((HttpURLConnection) (obj1)).setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Async Ping Connection Response Code: ").append(((HttpURLConnection) (obj1)).getResponseCode()).toString());
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
_L2:
        return;
        obj;
        obj1 = obj2;
        obj2 = obj;
_L5:
        obj = obj1;
        Log.debug("[InMobi]-[RE]-4.5.5", "Error doing async Ping. ", ((Throwable) (obj2)));
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        ((HttpURLConnection) (obj1)).disconnect();
        return;
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L4:
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
          goto _L5
    }

    (JSUtilityController jsutilitycontroller, String s)
    {
        b = jsutilitycontroller;
        a = s;
        super();
    }
}
