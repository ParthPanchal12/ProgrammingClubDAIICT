// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.ServiceProvider;
import com.inmobi.commons.network.abstraction.INetworkListener;

// Referenced classes of package com.inmobi.monetization.internal:
//            c

class a
{

    private static a c = null;
    private ServiceProvider a;
    private INetworkListener b;

    private a()
    {
        a = ServiceProvider.getInstance();
    }

    public static a a()
    {
        if (c == null)
        {
            c = new a();
        }
        return c;
    }

    public void a(String s, c c1, INetworkListener inetworklistener)
    {
        b = inetworklistener;
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            Log.internal("[InMobi]-[Monetization]", "Fetching  Ads");
            a.executeTask(c1, inetworklistener);
        } else
        if (b != null)
        {
            s = new Response(ErrorCode.NETWORK_ERROR);
            b.onRequestFailed(c1, s);
            return;
        }
    }

}
