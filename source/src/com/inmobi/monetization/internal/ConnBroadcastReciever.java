// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.RequestResponseManager;

public class ConnBroadcastReciever extends BroadcastReceiver
{

    public ConnBroadcastReciever()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || !InternalSDKUtil.checkNetworkAvailibility(context))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Log.internal("[InMobi]-[Monetization]", "Received CONNECTIVITY BROADCAST");
        intent = new RequestResponseManager();
        intent.init();
        intent.processClick(context.getApplicationContext(), null);
        return;
        context;
        Log.internal("[InMobi]-[Monetization]", "Connectivity receiver exception", context);
        return;
    }
}
