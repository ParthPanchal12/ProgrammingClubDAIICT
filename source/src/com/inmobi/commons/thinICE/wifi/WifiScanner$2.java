// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

// Referenced classes of package com.inmobi.commons.thinICE.wifi:
//            WifiScanner, WifiScanListener

static final class er extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            context = WifiScanner.a();
            intent = (WifiManager)WifiScanner.c().getSystemService("wifi");
            WifiScanner.b();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        context.onResultsReceived(intent.getScanResults());
    }

    er()
    {
    }
}
