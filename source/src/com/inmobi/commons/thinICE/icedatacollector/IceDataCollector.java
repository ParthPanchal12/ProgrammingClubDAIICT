// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.location.LocationUtil;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.thinICE.wifi.WifiScanListener;
import com.inmobi.commons.thinICE.wifi.WifiScanner;
import com.inmobi.commons.thinICE.wifi.WifiUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.inmobi.commons.thinICE.icedatacollector:
//            ThinICEConfigSettings, BuildSettings, Sample, ThinICEListener

public final class IceDataCollector
{
    public static interface ThinIceDataCollectedListener
    {

        public abstract void onDataCollected();
    }


    public static final String TAG = "IceDataCollector";
    private static Context a = null;
    private static ThinICEConfigSettings b = new ThinICEConfigSettings();
    private static Looper c = null;
    private static Handler d = null;
    private static boolean e = false;
    private static Activity f = null;
    private static Runnable g = new Runnable() {

        public void run()
        {
            com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
            JVM INSTR monitorenter ;
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "** stop runnable");
            }
            if (IceDataCollector.a())
            {
                break MISSING_BLOCK_LABEL_41;
            }
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "ignoring, stop not requested");
            }
            com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
            JVM INSTR monitorexit ;
            return;
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "terminating sampling and flushing");
            }
            IceDataCollector.b();
            IceDataCollector.flush();
            IceDataCollector.a(null);
            IceDataCollector.a(null);
            IceDataCollector.a(null);
            com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
            JVM INSTR monitorexit ;
            throw exception;
        }

    };
    private static LinkedList h = new LinkedList();
    private static Sample i = null;
    private static final Object j = new Object();
    private static ThinICEListener k = null;
    private static ThinIceDataCollectedListener l = null;
    private static Runnable m = new Runnable() {

        private void a()
        {
            if (IceDataCollector.m() != null)
            {
                IceDataCollector.m().onDataCollected();
            }
        }

        static void a(_cls2 _pcls2)
        {
            _pcls2.a();
        }

        public void run()
        {
            boolean flag;
            flag = false;
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "** sample runnable");
            }
            if (IceDataCollector.c() != null) goto _L2; else goto _L1
_L1:
            if (BuildSettings.DEBUG)
            {
                Log.w("IceDataCollector", "sampling when looper is null, exiting");
            }
_L21:
            return;
_L2:
            Object obj;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (android.os.Build.VERSION.SDK_INT < 14 && !IceDataCollector.d().hasWindowFocus())
            {
                if (BuildSettings.DEBUG)
                {
                    Log.d("IceDataCollector", "activity no longer has focus, terminating");
                }
                IceDataCollector.b();
                LinkedList linkedlist = IceDataCollector.e();
                IceDataCollector.flush();
                IceDataCollector.a(null);
                IceDataCollector.a(null);
                if (IceDataCollector.f() != null)
                {
                    IceDataCollector.f().onSamplingTerminated(linkedlist);
                }
                IceDataCollector.a(null);
                return;
            }
            IceDataCollector.i().postDelayed(IceDataCollector.g(), IceDataCollector.h().getSampleInterval());
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", (new StringBuilder()).append("next sample in ").append(IceDataCollector.h().getSampleInterval()).append(" ms").toString());
            }
            obj = new Sample();
            int i1 = IceDataCollector.h().getWifiFlags();
            if (!ThinICEConfigSettings.bitTest(i1, 2))
            {
                flag = true;
            }
            flag1 = ThinICEConfigSettings.bitTest(i1, 1);
            i1 = IceDataCollector.h().getCellOpFlags();
            flag2 = ThinICEConfigSettings.bitTest(i1, 1);
            flag3 = ThinICEConfigSettings.bitTest(i1, 2);
            if (!IceDataCollector.h().isSampleCellOperatorEnabled())
            {
                break MISSING_BLOCK_LABEL_309;
            }
            Object obj1 = CellUtil.getCellNetworkInfo(IceDataCollector.j());
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_258;
            }
            obj1.simMcc = -1;
            obj1.simMnc = -1;
            if (!flag3)
            {
                break MISSING_BLOCK_LABEL_273;
            }
            obj1.currentMcc = -1;
            obj1.currentMnc = -1;
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", (new StringBuilder()).append("-- cell operator: ").append(obj1).toString());
            }
            obj.cellOperator = ((CellOperatorInfo) (obj1));
_L16:
            if (!IceDataCollector.h().isSampleCellEnabled()) goto _L4; else goto _L3
_L3:
            if (!CellUtil.hasGetCurrentServingCellPermission(IceDataCollector.j())) goto _L6; else goto _L5
_L5:
            obj.connectedCellTowerInfo = CellUtil.getCurrentCellTower(IceDataCollector.j());
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", (new StringBuilder()).append("-- current serving cell: ").append(((Sample) (obj)).connectedCellTowerInfo.id).toString());
            }
_L4:
            if (!IceDataCollector.h().isSampleVisibleCellTowerEnabled()) goto _L8; else goto _L7
_L7:
            if (!CellUtil.hasGetVisibleCellTowerPermission(IceDataCollector.j())) goto _L10; else goto _L9
_L9:
            obj.visibleCellTowerInfo = CellUtil.getVisibleCellTower(IceDataCollector.j());
_L8:
            obj.connectedWifiAp = IceDataCollector.getConnectedWifiInfo(IceDataCollector.j());
            if (!IceDataCollector.h().isSampleLocationEnabled()) goto _L12; else goto _L11
_L11:
            if (!LocationUtil.hasLocationPermission(IceDataCollector.j())) goto _L14; else goto _L13
_L13:
            obj1 = LocationUtil.getLastKnownLocations(IceDataCollector.j());
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "-- locations:");
                LocationInfo locationinfo;
                for (Iterator iterator = ((HashMap) (obj1)).values().iterator(); iterator.hasNext(); Log.d("IceDataCollector", (new StringBuilder()).append("   + ").append(locationinfo).toString()))
                {
                    locationinfo = (LocationInfo)iterator.next();
                }

            }
              goto _L15
_L12:
            obj1 = IceDataCollector.k();
            obj1;
            JVM INSTR monitorenter ;
            IceDataCollector.a(((Sample) (obj)));
            if (IceDataCollector.e() != null)
            {
                IceDataCollector.e().add(obj);
                for (; IceDataCollector.e().size() > IceDataCollector.h().getSampleHistorySize(); IceDataCollector.e().removeFirst()) { }
            }
            break MISSING_BLOCK_LABEL_705;
            obj;
            obj1;
            JVM INSTR monitorexit ;
            throw obj;
            obj1;
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting cell operator data", ((Throwable) (obj1)));
            }
              goto _L16
_L6:
            if (!BuildSettings.DEBUG) goto _L4; else goto _L17
_L17:
            Log.w("IceDataCollector", "application does not have permission to access current serving cell");
              goto _L4
            obj1;
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting cell data", ((Throwable) (obj1)));
            }
              goto _L4
_L10:
            if (!BuildSettings.DEBUG) goto _L8; else goto _L18
_L18:
            Log.w("IceDataCollector", "application does not have permission to access current serving cell");
              goto _L8
            obj1;
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting cell data", ((Throwable) (obj1)));
            }
              goto _L8
_L15:
            try
            {
                obj.lastKnownLocations = ((HashMap) (obj1));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                if (BuildSettings.DEBUG)
                {
                    Log.e("IceDataCollector", "Error getting location data", ((Throwable) (obj1)));
                }
            }
              goto _L12
_L14:
            if (!BuildSettings.DEBUG) goto _L12; else goto _L19
_L19:
            Log.w("IceDataCollector", "application does not have permission to access location");
              goto _L12
            obj1;
            JVM INSTR monitorexit ;
            if (!IceDataCollector.h().isSampleVisibleWifiEnabled())
            {
                break; /* Loop/switch isn't completed */
            }
            Exception exception;
            if (WifiUtil.hasWifiScanPermission(IceDataCollector.j(), false))
            {
                WifiScanListener wifiscanlistener = new WifiScanListener(this, flag, flag1) {

                    final boolean a;
                    final boolean b;
                    final _cls2 c;

                    public void onResultsReceived(List list)
                    {
                        if (BuildSettings.DEBUG)
                        {
                            Log.d("IceDataCollector", (new StringBuilder()).append("Received Wi-Fi scan results ").append(list.size()).toString());
                        }
                        list = WifiUtil.scanResultsToWifiInfos(list, a, b);
                        if (BuildSettings.DEBUG)
                        {
                            Log.d("IceDataCollector", "-- wifi scan:");
                            WifiInfo wifiinfo;
                            for (Iterator iterator = list.iterator(); iterator.hasNext(); Log.d("IceDataCollector", (new StringBuilder()).append("   + ").append(wifiinfo).toString()))
                            {
                                wifiinfo = (WifiInfo)iterator.next();
                            }

                        }
                        synchronized (IceDataCollector.k())
                        {
                            if (IceDataCollector.l() != null)
                            {
                                IceDataCollector.l().visibleWifiAp = list;
                                _cls2.a(c);
                            }
                        }
                        return;
                        list;
                        obj;
                        JVM INSTR monitorexit ;
                        throw list;
                    }

                    public void onTimeout()
                    {
                        if (BuildSettings.DEBUG)
                        {
                            Log.w("IceDataCollector", "Received Wi-Fi scan timeout");
                        }
                    }

            
            {
                c = _pcls2;
                a = flag;
                b = flag1;
                super();
            }
                };
                if (!WifiScanner.requestScan(IceDataCollector.j(), wifiscanlistener))
                {
                    a();
                    return;
                }
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                a();
                if (BuildSettings.DEBUG)
                {
                    Log.w("IceDataCollector", "application does not have permission to scan for wifi access points");
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                if (BuildSettings.DEBUG)
                {
                    Log.e("IceDataCollector", "Error scanning for wifi", exception);
                    return;
                }
            }
            if (true) goto _L21; else goto _L20
_L20:
            a();
            return;
        }

    };

    public IceDataCollector()
    {
    }

    static Activity a(Activity activity)
    {
        f = activity;
        return activity;
    }

    static Context a(Context context)
    {
        a = context;
        return context;
    }

    static Sample a(Sample sample)
    {
        i = sample;
        return sample;
    }

    static ThinICEListener a(ThinICEListener thinicelistener)
    {
        k = thinicelistener;
        return thinicelistener;
    }

    static boolean a()
    {
        return e;
    }

    private static final boolean a(ThinICEConfigSettings thiniceconfigsettings, ThinICEConfigSettings thiniceconfigsettings1)
    {
        return thiniceconfigsettings.isEnabled() != thiniceconfigsettings1.isEnabled() || thiniceconfigsettings.getSampleInterval() != thiniceconfigsettings1.getSampleInterval();
    }

    static void b()
    {
        o();
    }

    static Looper c()
    {
        return c;
    }

    static Activity d()
    {
        return f;
    }

    static LinkedList e()
    {
        return h;
    }

    static ThinICEListener f()
    {
        return k;
    }

    public static void flush()
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- flush()");
        }
        synchronized (j)
        {
            i = null;
            h = new LinkedList();
        }
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static Runnable g()
    {
        return m;
    }

    public static ThinICEConfigSettings getConfig()
    {
        return new ThinICEConfigSettings(b);
    }

    public static WifiInfo getConnectedWifiInfo(Context context)
    {
        Object obj = null;
        int i1 = b.getWifiFlags();
        Context context1;
        boolean flag;
        boolean flag1;
        if (!ThinICEConfigSettings.bitTest(i1, 2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = ThinICEConfigSettings.bitTest(i1, 1);
        context1 = obj;
        if (!b.isSampleConnectedWifiEnabled())
        {
            break MISSING_BLOCK_LABEL_98;
        }
label0:
        {
            if (WifiUtil.hasGetConnectedWifiInfoPermission(context))
            {
                context = WifiUtil.getConnectedWifiInfo(context, flag, flag1);
                break label0;
            }
            try
            {
                if (BuildSettings.DEBUG)
                {
                    Log.w("IceDataCollector", "application does not have permission to access connected wifi ap");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context1 = obj;
                if (BuildSettings.DEBUG)
                {
                    Log.e("IceDataCollector", "Error getting wifi data", context);
                    return null;
                }
                break MISSING_BLOCK_LABEL_98;
            }
            context = null;
        }
        context1 = context;
        return context1;
    }

    public static List getData()
    {
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- getData()");
        }
        LinkedList linkedlist;
        synchronized (j)
        {
            linkedlist = h;
            flush();
        }
        return linkedlist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int getSampleCount()
    {
        int i1;
        synchronized (j)
        {
            i1 = h.size();
        }
        return i1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static List getVisbleWifiInfoBssId(Context context)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        context = null;
        obj = obj1;
        if (!b.isSampleVisibleWifiEnabled()) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (i == null) goto _L2; else goto _L3
_L3:
        List list = i.visibleWifiAp;
        obj = obj1;
        if (list == null) goto _L2; else goto _L4
_L4:
        obj = obj1;
        if (list.size() == 0) goto _L2; else goto _L5
_L5:
        obj = new ArrayList();
        int i1 = 0;
_L7:
        if (i1 >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((List) (obj)).add(Long.valueOf(((WifiInfo)list.get(i1)).bssid));
        i1++;
        if (true) goto _L7; else goto _L6
        Exception exception;
        exception;
_L8:
        obj = context;
        if (BuildSettings.DEBUG)
        {
            Log.e("IceDataCollector", "Error getting wifi data", exception);
            obj = context;
        }
_L2:
        return ((List) (obj));
        exception;
        context = ((Context) (obj));
        if (true) goto _L8; else goto _L6
_L6:
        return ((List) (obj));
    }

    static ThinICEConfigSettings h()
    {
        return b;
    }

    static Handler i()
    {
        return d;
    }

    static Context j()
    {
        return a;
    }

    static Object k()
    {
        return j;
    }

    static Sample l()
    {
        return i;
    }

    static ThinIceDataCollectedListener m()
    {
        return l;
    }

    private static void n()
    {
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "startSampling()");
        }
        if (c != null)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "ignoring, already sampling");
            }
        } else
        {
            HandlerThread handlerthread = new HandlerThread("IDC");
            handlerthread.start();
            c = handlerthread.getLooper();
            d = new Handler(c);
            d.postDelayed(m, b.getSampleInterval() / 2L);
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", (new StringBuilder()).append("next sample in ").append(b.getSampleInterval() / 2L).append(" ms").toString());
                return;
            }
        }
    }

    private static void o()
    {
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "stopSampling()");
        }
        if (c == null)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "ignoring, not currently sampling");
            }
        } else
        {
            d.removeCallbacks(m);
            d = null;
            c.quit();
            c = null;
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "sampling stopped");
                return;
            }
        }
    }

    public static void setConfig(ThinICEConfigSettings thiniceconfigsettings)
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder()).append("-- setConfig(").append(thiniceconfigsettings).append(")").toString());
        }
        if (thiniceconfigsettings != null) goto _L2; else goto _L1
_L1:
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "aborting, config is null");
        }
_L3:
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i1;
        int j1;
        obj = b;
        b = thiniceconfigsettings;
        i1 = ((ThinICEConfigSettings) (obj)).getSampleHistorySize();
        j1 = b.getSampleHistorySize();
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        synchronized (j)
        {
            if (h.size() > j1)
            {
                if (BuildSettings.DEBUG)
                {
                    Log.d("IceDataCollector", "new sample history size, removing samples from start of list");
                }
                h.subList(0, h.size() - j1).clear();
            }
        }
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "not restarting sampling, not currently sampling");
        }
          goto _L3
        thiniceconfigsettings;
        throw thiniceconfigsettings;
        obj;
        thiniceconfigsettings;
        JVM INSTR monitorexit ;
        throw obj;
        if (a(((ThinICEConfigSettings) (obj)), b))
        {
            o();
            if (!b.isEnabled())
            {
                break MISSING_BLOCK_LABEL_205;
            }
            n();
        }
          goto _L3
        flush();
        a = null;
        f = null;
        k = null;
          goto _L3
    }

    public static void setIceDataCollectionListener(ThinIceDataCollectedListener thinicedatacollectedlistener)
    {
        l = thinicedatacollectedlistener;
    }

    public static void setListener(ThinICEListener thinicelistener)
    {
        k = thinicelistener;
    }

    public static void start(Context context)
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- start()");
        }
        if (context != null) goto _L2; else goto _L1
_L1:
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "aborting, context is null");
        }
_L3:
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (b.isEnabled())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "ignoring, data collection is disabled in settings");
        }
          goto _L3
        context;
        throw context;
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                break MISSING_BLOCK_LABEL_114;
            }
            if (context instanceof Activity)
            {
                break label0;
            }
            if (BuildSettings.DEBUG)
            {
                Log.w("IceDataCollector", "aborting, build < 14 and context is not an activity");
            }
        }
          goto _L3
        f = (Activity)context;
        a = context.getApplicationContext();
        n();
        if (e)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "stop previously requested, clearing request");
            }
            e = false;
            d.removeCallbacks(g);
        }
          goto _L3
    }

    public static void stop()
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- stop()");
        }
        if (c != null) goto _L2; else goto _L1
_L1:
        Log.d("IceDataCollector", "ignoring, not currently running");
_L3:
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!e)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        Log.d("IceDataCollector", "ignoring, stop already requested");
          goto _L3
        Exception exception;
        exception;
        throw exception;
        e = true;
        d.postDelayed(g, b.getStopRequestTimeout());
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder()).append("stop requested, occurring in ").append(b.getStopRequestTimeout()).append(" ms").toString());
        }
          goto _L3
    }

}
