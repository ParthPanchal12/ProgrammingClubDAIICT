// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.os.Handler;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.inmobi.commons.thinICE.icedatacollector:
//            BuildSettings, IceDataCollector, Sample, ThinICEListener, 
//            ThinICEConfigSettings

class b
    implements WifiScanListener
{

    final boolean a;
    final boolean b;
    final c c;

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
                b(c);
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

    ( , boolean flag, boolean flag1)
    {
        c = ;
        a = flag;
        b = flag1;
        super();
    }

    // Unreferenced inner class com/inmobi/commons/thinICE/icedatacollector/IceDataCollector$2

/* anonymous class */
    static final class IceDataCollector._cls2
        implements Runnable
    {

        private void a()
        {
            if (IceDataCollector.m() != null)
            {
                IceDataCollector.m().onDataCollected();
            }
        }

        static void a(IceDataCollector._cls2 _pcls2)
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
            int i = IceDataCollector.h().getWifiFlags();
            if (!ThinICEConfigSettings.bitTest(i, 2))
            {
                flag = true;
            }
            flag1 = ThinICEConfigSettings.bitTest(i, 1);
            i = IceDataCollector.h().getCellOpFlags();
            flag2 = ThinICEConfigSettings.bitTest(i, 1);
            flag3 = ThinICEConfigSettings.bitTest(i, 2);
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
                IceDataCollector._cls2._cls1 _lcls1 = new IceDataCollector._cls2._cls1(this, flag, flag1);
                if (!WifiScanner.requestScan(IceDataCollector.j(), _lcls1))
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

    }

}
