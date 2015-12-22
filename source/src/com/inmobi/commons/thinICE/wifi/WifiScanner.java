// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;

// Referenced classes of package com.inmobi.commons.thinICE.wifi:
//            WifiScanListener

public final class WifiScanner
{

    private static Context a = null;
    private static WifiScanListener b = null;
    private static Handler c = null;
    private static boolean d = false;
    private static Runnable e = new Runnable() {

        public void run()
        {
            WifiScanListener wifiscanlistener = WifiScanner.a();
            WifiScanner.b();
            if (wifiscanlistener != null)
            {
                wifiscanlistener.onTimeout();
            }
        }

    };
    private static boolean f = false;
    private static final BroadcastReceiver g = new BroadcastReceiver() {

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

    };
    private static final IntentFilter h = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private static android.os.PowerManager.WakeLock i = null;
    private static android.net.wifi.WifiManager.WifiLock j = null;

    public WifiScanner()
    {
    }

    static WifiScanListener a()
    {
        return b;
    }

    static void b()
    {
        d();
    }

    static Context c()
    {
        return a;
    }

    private static void d()
    {
        com/inmobi/commons/thinICE/wifi/WifiScanner;
        JVM INSTR monitorenter ;
        Handler handler = c;
        if (handler != null) goto _L2; else goto _L1
_L1:
        com/inmobi/commons/thinICE/wifi/WifiScanner;
        JVM INSTR monitorexit ;
        return;
_L2:
        c.removeCallbacks(e);
        f();
        if (d)
        {
            h();
            j();
        }
        c = null;
        b = null;
        a = null;
        d = false;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static void e()
    {
        if (f)
        {
            return;
        } else
        {
            f = true;
            a.registerReceiver(g, h, null, c);
            return;
        }
    }

    private static void f()
    {
        if (!f)
        {
            return;
        }
        f = false;
        try
        {
            a.unregisterReceiver(g);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
    }

    private static void g()
    {
        if (i == null)
        {
            i = ((PowerManager)a.getSystemService("power")).newWakeLock(1, "wifiscanrequester.CpuLock");
            i.setReferenceCounted(false);
        }
        if (!i.isHeld())
        {
            i.acquire();
        }
    }

    private static void h()
    {
        if (i != null)
        {
            if (i.isHeld())
            {
                i.release();
            }
            i = null;
        }
    }

    private static void i()
    {
        if (j == null)
        {
            j = ((WifiManager)a.getSystemService("wifi")).createWifiLock(2, "wifiscanrequester.WiFiScanLock");
            j.setReferenceCounted(false);
        }
        if (!j.isHeld())
        {
            j.acquire();
        }
    }

    private static void j()
    {
        if (j != null)
        {
            if (j.isHeld())
            {
                j.release();
            }
            j = null;
        }
    }

    public static boolean requestScan(Context context, WifiScanListener wifiscanlistener)
    {
        return requestScan(Looper.myLooper(), context, wifiscanlistener, 10000L, false);
    }

    public static boolean requestScan(Looper looper, Context context, WifiScanListener wifiscanlistener, long l, boolean flag)
    {
        com/inmobi/commons/thinICE/wifi/WifiScanner;
        JVM INSTR monitorenter ;
        Object obj = c;
        if (obj == null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        com/inmobi/commons/thinICE/wifi/WifiScanner;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj = (WifiManager)context.getSystemService("wifi");
        if (!((WifiManager) (obj)).isWifiEnabled())
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        a = context;
        b = wifiscanlistener;
        d = flag;
        c = new Handler(looper);
        c.postDelayed(e, l);
        if (d)
        {
            i();
            g();
        }
        e();
        flag = ((WifiManager) (obj)).startScan();
        if (true) goto _L4; else goto _L3
_L3:
        looper;
        throw looper;
    }

}
