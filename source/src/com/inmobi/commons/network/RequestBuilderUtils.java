// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;

import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RequestBuilderUtils
{

    public static final String KEY_MK_SITE_ID = "mk-siteid";
    public static final String KEY_MK_SITE_SLOT_ID = "mk-site-slotid";
    public static final String RULE_ID = "rule-id";

    public RequestBuilderUtils()
    {
    }

    private static String a(Calendar calendar)
    {
        String s = null;
        if (calendar != null)
        {
            s = (new StringBuilder()).append(calendar.get(1)).append("-").append(calendar.get(2) + 1).append("-").append(calendar.get(5)).toString();
        }
        return s;
    }

    public static void fillAppInfoMap(Map map)
    {
        if (AppInfo.getAppBId() != null)
        {
            map.put("u-appbid", AppInfo.getAppBId());
        }
        if (AppInfo.getAppDisplayName() != null)
        {
            map.put("u-appDNM", AppInfo.getAppDisplayName());
        }
        if (AppInfo.getAppVer() != null)
        {
            map.put("u-appver", AppInfo.getAppVer());
        }
    }

    public static void fillDemogMap(Map map)
    {
        if (map != null)
        {
            if (DemogInfo.getAge().intValue() > 0)
            {
                map.put("u-age", DemogInfo.getAge());
            }
            if (DemogInfo.getPostalCode() != null)
            {
                map.put("u-postalCode", DemogInfo.getPostalCode());
            }
            if (DemogInfo.getAreaCode() != null)
            {
                map.put("u-areaCode", DemogInfo.getAreaCode());
            }
            if (DemogInfo.getDateOfBirth() != null)
            {
                map.put("u-dateOfBirth", a(DemogInfo.getDateOfBirth()));
            }
            if (DemogInfo.getEducation() != null)
            {
                map.put("u-education", DemogInfo.getEducation().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getEthnicity() != null)
            {
                map.put("u-ethnicity", DemogInfo.getEthnicity().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getGender() != null)
            {
                map.put("u-gender", DemogInfo.getGender().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getHasChildren() != null)
            {
                map.put("u-haschildren", DemogInfo.getHasChildren().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getIncome().intValue() > 0)
            {
                map.put("u-income", DemogInfo.getIncome());
            }
            if (DemogInfo.getInterests() != null)
            {
                map.put("u-interests", DemogInfo.getInterests());
            }
            if (DemogInfo.getLanguage() != null)
            {
                map.put("u-language", DemogInfo.getLanguage());
            }
            if (DemogInfo.getLocationWithCityStateCountry() != null)
            {
                map.put("u-location", DemogInfo.getLocationWithCityStateCountry());
            }
            if (DemogInfo.getMaritalStatus() != null)
            {
                map.put("u-marital", DemogInfo.getMaritalStatus().toString().toLowerCase(Locale.getDefault()));
            }
            if (DemogInfo.getSexualOrientation() != null)
            {
                map.put("u-sexualorientation", DemogInfo.getSexualOrientation().toString().toLowerCase(Locale.getDefault()));
            }
        }
    }

    public static void fillDeviceMap(Map map)
    {
        if (map != null)
        {
            if (DeviceInfo.getScreenDensity() != null)
            {
                map.put("d-device-screen-density", DeviceInfo.getScreenDensity());
            }
            if (DeviceInfo.getScreenSize() != null)
            {
                map.put("d-device-screen-size", DeviceInfo.getScreenSize());
            }
            map.put("d-orientation", Integer.valueOf(DeviceInfo.getOrientation()));
            if (DeviceInfo.getNetworkType() != null)
            {
                map.put("d-netType", DeviceInfo.getNetworkType());
            }
            if (DeviceInfo.getLocalization() != null)
            {
                map.put("d-localization", DeviceInfo.getLocalization());
            }
        }
    }

    public static void fillIdentityMap(Map map, Map map1, boolean flag)
    {
        if (map != null)
        {
            map.put("mk-siteid", InMobi.getAppId());
            String s = (new StringBuilder()).append("pr-SAND-").append(InternalSDKUtil.getInMobiInternalVersion("4.5.5")).append("-").append("20150522").toString();
            map.put("mk-version", s);
            map.put("mk-rel-version", s);
            if (DeviceInfo.getPhoneDefaultUserAgent() != null && !"".equals(DeviceInfo.getPhoneDefaultUserAgent()))
            {
                map.put("h-user-agent", DeviceInfo.getPhoneDefaultUserAgent());
            }
            int i;
            if (UID.getInstance().isLimitAdTrackingEnabled())
            {
                map.put("u-id-adt", Integer.valueOf(1));
            } else
            {
                map.put("u-id-adt", Integer.valueOf(0));
            }
            if (flag)
            {
                map1 = UID.getInstance().getMapForEncryption(map1);
                if (map1 != null)
                {
                    map.putAll(map1);
                }
            } else
            {
                map.remove("u-id-key");
                map.remove("u-key-ver");
                map.put("u-id-map", UID.getInstance().getJSON(map1));
            }
            map1 = Calendar.getInstance();
            System.currentTimeMillis();
            map.put("ts", Long.valueOf(map1.getTimeInMillis()));
            i = map1.get(15);
            map.put("tz", Integer.valueOf(map1.get(16) + i));
            if (InternalSDKUtil.getLtvpSessionId() != null && !InternalSDKUtil.getLtvpSessionId().equals(""))
            {
                map.put("u-s-id", InternalSDKUtil.getLtvpSessionId());
            }
        }
    }

    public static void fillLocationMap(Map map)
    {
        if (map == null) goto _L2; else goto _L1
_L1:
        Object obj = LocationInfo.currentLocationStr();
        if (obj != null && !"".equals(obj))
        {
            map.put("u-latlong-accu", obj);
            if (LocationInfo.getGeoTS() > 0L)
            {
                map.put("u-ll-ts", Long.valueOf(LocationInfo.getGeoTS()));
            }
            map.put("sdk-collected", Integer.valueOf(LocationInfo.isSDKSetLocation()));
        }
        WifiInfo wifiinfo;
        int i;
        if (DemogInfo.isLocationInquiryAllowed())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        map.put("loc-allowed", Integer.valueOf(i));
        obj = null;
        wifiinfo = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
        obj = wifiinfo;
_L5:
        if (obj != null)
        {
            map.put("c-ap-bssid", Long.valueOf(((WifiInfo) (obj)).bssid));
        }
        obj = IceDataCollector.getVisbleWifiInfoBssId(InternalSDKUtil.getContext());
        if (obj != null)
        {
            try
            {
                if (((List) (obj)).size() != 0)
                {
                    map.put("v-ap-bssid", InternalSDKUtil.convertListToDelimitedString(((List) (obj)), ","));
                }
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.5.5", "Couldn't get cell tower info in Request Builder", exception);
            }
        }
        obj = CellUtil.getVisibleCellTowerIds(InternalSDKUtil.getContext());
        Exception exception2;
        if (obj != null)
        {
            try
            {
                if (((List) (obj)).size() != 0)
                {
                    map.put("v-sid", InternalSDKUtil.convertListToDelimitedString(((List) (obj)), ","));
                }
            }
            catch (Exception exception1)
            {
                Log.internal("[InMobi]-4.5.5", "Couldn't get cell tower info in Request Builder", exception1);
            }
        }
        try
        {
            obj = CellUtil.getCurrentCellTower(InternalSDKUtil.getContext()).id;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.internal("[InMobi]-4.5.5", "Couldn't get cell tower info in Request Builder", map);
            return;
        }
        if (obj == null) goto _L2; else goto _L3
_L3:
        if (!"".equals(obj))
        {
            map.put("c-sid", obj);
        }
_L2:
        return;
        exception2;
        Log.internal("[InMobi]-4.5.5", "No wifi permissions set, unable to send wifi data");
        if (true) goto _L5; else goto _L4
_L4:
    }
}
