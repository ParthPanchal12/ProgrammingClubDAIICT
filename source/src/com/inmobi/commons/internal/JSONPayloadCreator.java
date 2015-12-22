// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.internal:
//            PayloadCreator, InternalSDKUtil, Log

public class JSONPayloadCreator
    implements PayloadCreator
{

    public JSONPayloadCreator()
    {
    }

    private JSONObject a(NeighboringCellInfo neighboringcellinfo)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", neighboringcellinfo.getCid());
            if (neighboringcellinfo.getRssi() != 0)
            {
                jsonobject.put("ss", neighboringcellinfo.getRssi());
            }
        }
        // Misplaced declaration of an exception variable
        catch (NeighboringCellInfo neighboringcellinfo)
        {
            return null;
        }
        return jsonobject;
    }

    private JSONObject a(ActivityRecognitionSampler.ActivitySample activitysample)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("t", 3);
            jsonobject.put("ts", activitysample.getTimestamp());
            jsonobject.put("a", activitysample.getActivity());
        }
        // Misplaced declaration of an exception variable
        catch (ActivityRecognitionSampler.ActivitySample activitysample)
        {
            return null;
        }
        return jsonobject;
    }

    private JSONObject a(CellTowerInfo celltowerinfo)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", celltowerinfo.id);
            if (celltowerinfo.signalStrength != 0)
            {
                jsonobject.put("ss", celltowerinfo.signalStrength);
            }
        }
        // Misplaced declaration of an exception variable
        catch (CellTowerInfo celltowerinfo)
        {
            return null;
        }
        return jsonobject;
    }

    private JSONObject a(Sample sample, ThinICEConfig thiniceconfig)
    {
        JSONObject jsonobject;
        Object obj;
        Object obj1;
        jsonobject = new JSONObject();
        jsonobject.put("t", 1);
        if (thiniceconfig.isConnectedWifiEnabled())
        {
            jsonobject.put("c-ap", a(sample.connectedWifiAp));
        }
        if (thiniceconfig.isCellEnabled())
        {
            jsonobject.put("c-sc", a(sample.connectedCellTowerInfo));
        }
        if (!thiniceconfig.isVisibleCellTowerEnabled())
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = new JSONArray();
        if (sample.visibleCellTowerInfo == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj1 = sample.visibleCellTowerInfo.iterator();
_L1:
        JSONObject jsonobject1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        jsonobject1 = a((NeighboringCellInfo)((Iterator) (obj1)).next());
        if (jsonobject1 != null)
        {
            try
            {
                ((JSONArray) (obj)).put(jsonobject1);
            }
            // Misplaced declaration of an exception variable
            catch (Sample sample)
            {
                return null;
            }
        }
          goto _L1
        if (((JSONArray) (obj)).length() > 0)
        {
            jsonobject.put("v-sc", obj);
        }
        if (!thiniceconfig.isVisibleWifiEnabled())
        {
            break MISSING_BLOCK_LABEL_242;
        }
        thiniceconfig = new JSONArray();
        if (sample.visibleWifiAp == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj = sample.visibleWifiAp.iterator();
_L2:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_227;
            }
            obj1 = a((WifiInfo)((Iterator) (obj)).next());
        } while (obj1 == null);
        thiniceconfig.put(obj1);
          goto _L2
        if (thiniceconfig.length() > 0)
        {
            jsonobject.put("v-ap", thiniceconfig);
        }
        if (jsonobject.length() <= 1)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        jsonobject.put("ts", sample.utc);
        return jsonobject;
        return null;
    }

    private JSONObject a(WifiInfo wifiinfo)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("bssid", wifiinfo.bssid);
            jsonobject.put("essid", wifiinfo.ssid);
        }
        // Misplaced declaration of an exception variable
        catch (WifiInfo wifiinfo)
        {
            return null;
        }
        return jsonobject;
    }

    public String toPayloadString(List list, List list1, Context context)
    {
        Object obj = AnalyticsInitializer.getConfigParams().getDeviceIdMaskMap();
        obj = new JSONObject(InternalSDKUtil.getEncodedMap(UID.getInstance().getMapForEncryption(((java.util.Map) (obj)))));
        JSONArray jsonarray = new JSONArray();
        ThinICEConfig thiniceconfig = AnalyticsInitializer.getConfigParams().getThinIceConfig();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj1 = (Sample)list.next();
            if (obj1 != null)
            {
                obj1 = a(((Sample) (obj1)), thiniceconfig);
                if (obj1 != null)
                {
                    jsonarray.put(obj1);
                }
            }
        } while (true);
        list = list1.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            list1 = (ActivityRecognitionSampler.ActivitySample)list.next();
            if (list1 != null)
            {
                list1 = a(list1);
                if (list1 != null)
                {
                    jsonarray.put(list1);
                }
            }
        } while (true);
        int i;
        long l;
        try
        {
            if (jsonarray.length() > 0)
            {
                ((JSONObject) (obj)).put("payload", jsonarray);
            }
            list = CellUtil.getCellNetworkInfo(context);
            if (thiniceconfig.isOperatorEnabled())
            {
                if (!ThinICEConfigSettings.bitTest(thiniceconfig.getCellOpsFlag(), 1) && (((CellOperatorInfo) (list)).simMcc != -1 || ((CellOperatorInfo) (list)).simMnc != -1))
                {
                    ((JSONObject) (obj)).put("s-ho", (new StringBuilder()).append(((CellOperatorInfo) (list)).simMcc).append("_").append(((CellOperatorInfo) (list)).simMnc).toString());
                }
                if (!ThinICEConfigSettings.bitTest(thiniceconfig.getCellOpsFlag(), 2) && (((CellOperatorInfo) (list)).currentMcc != -1 || ((CellOperatorInfo) (list)).currentMnc != -1))
                {
                    ((JSONObject) (obj)).put("s-co", (new StringBuilder()).append(((CellOperatorInfo) (list)).currentMcc).append("_").append(((CellOperatorInfo) (list)).currentMnc).toString());
                }
            }
            list = Calendar.getInstance();
            System.currentTimeMillis();
            ((JSONObject) (obj)).put("tz", list.get(15) + list.get(16));
            ((JSONObject) (obj)).put("ts", list.getTimeInMillis());
            ((JSONObject) (obj)).put("mk-version", (new StringBuilder()).append("pr-SAND-").append(InternalSDKUtil.getInMobiInternalVersion("4.5.5")).append("-").append("20150522").toString());
            list = LocationInfo.currentLocationStr();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Log.internal("[InMobi]-4.5.5", "Unable to create payload for sending ThinICE params");
            return null;
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_459;
        }
        if ("".equals(list))
        {
            break MISSING_BLOCK_LABEL_459;
        }
        ((JSONObject) (obj)).put("u-latlong-accu", list);
        if (!LocationInfo.isValidGeoInfo())
        {
            break MISSING_BLOCK_LABEL_459;
        }
        l = LocationInfo.getGeoTS();
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_459;
        }
        ((JSONObject) (obj)).put("u-ll-ts", l);
        if (InternalSDKUtil.getLtvpSessionId() != null && !InternalSDKUtil.getLtvpSessionId().equals(""))
        {
            ((JSONObject) (obj)).put("u-s-id", InternalSDKUtil.getLtvpSessionId());
        }
        if (DemogInfo.isLocationInquiryAllowed())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        ((JSONObject) (obj)).put("loc-allowed", i);
        ((JSONObject) (obj)).put("sdk-collected", LocationInfo.isSDKSetLocation());
        return ((JSONObject) (obj)).toString();
    }
}
