// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.List;

// Referenced classes of package com.inmobi.commons.data:
//            DemogInfo

public class LocationInfo
{

    public static int LOCATION_SET_BY_PUB = 0;
    public static int LOCATION_SET_BY_SDK;
    private static LocationManager a;
    private static double b;
    private static double c;
    private static double d;
    private static boolean e;
    private static long f;
    private static int g;

    public LocationInfo()
    {
    }

    private static LocationManager a()
    {
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorenter ;
        LocationManager locationmanager = a;
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorexit ;
        return locationmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private static void a(double d1)
    {
        b = d1;
    }

    private static void a(long l)
    {
        f = l;
    }

    static void a(Location location)
    {
        if (location != null)
        {
            a(true);
            a(location.getLatitude());
            b(location.getLongitude());
            c(location.getAccuracy());
            a(location.getTime());
            return;
        } else
        {
            a(false);
            return;
        }
    }

    private static void a(LocationManager locationmanager)
    {
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorenter ;
        a = locationmanager;
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorexit ;
        return;
        locationmanager;
        throw locationmanager;
    }

    static void a(boolean flag)
    {
        e = flag;
    }

    private static void b(double d1)
    {
        c = d1;
    }

    private static boolean b()
    {
        if (a() == null)
        {
            a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
        }
        if (a() == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = a();
        obj1 = new Criteria();
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto _L4; else goto _L3
_L3:
        ((Criteria) (obj1)).setAccuracy(1);
_L19:
        ((Criteria) (obj1)).setCostAllowed(false);
        obj1 = ((LocationManager) (obj)).getBestProvider(((Criteria) (obj1)), true);
        if (obj1 == null) goto _L2; else goto _L5
_L5:
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto _L7; else goto _L6
_L6:
        boolean flag = ((LocationManager) (obj)).isProviderEnabled("network");
_L13:
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto _L9; else goto _L8
_L8:
        boolean flag1 = ((LocationManager) (obj)).isProviderEnabled("gps");
          goto _L10
_L4:
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
        {
            ((Criteria) (obj1)).setAccuracy(2);
        }
        continue; /* Loop/switch isn't completed */
_L15:
        try
        {
            obj1 = ((LocationManager) (obj)).getLastKnownLocation(((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.debug("[InMobi]-4.5.5", "Error getting the Location Info ", ((Throwable) (obj)));
            return false;
        }
        obj = obj1;
        if (obj1 != null) goto _L12; else goto _L11
_L11:
        obj = c();
        Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("lastKnownLocation: ").append(obj).toString());
          goto _L12
_L17:
        Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("lastBestKnownLocation: ").append(obj).toString());
        a(((Location) (obj)));
        return true;
_L2:
        return true;
_L9:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L7:
        flag = false;
          goto _L13
_L10:
        if (flag || flag1) goto _L15; else goto _L14
_L14:
        return false;
_L12:
        if (obj != null) goto _L17; else goto _L16
_L16:
        return false;
        if (true) goto _L19; else goto _L18
_L18:
    }

    private static Location c()
    {
        if (a() == null)
        {
            a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
        }
        if (a() != null)
        {
            LocationManager locationmanager = a();
            List list = locationmanager.getProviders(true);
            for (int i = list.size() - 1; i >= 0; i--)
            {
                Object obj = (String)list.get(i);
                if (!locationmanager.isProviderEnabled(((String) (obj))))
                {
                    continue;
                }
                obj = locationmanager.getLastKnownLocation(((String) (obj)));
                if (obj != null)
                {
                    return ((Location) (obj));
                }
            }

        }
        return null;
    }

    private static void c(double d1)
    {
        d = d1;
    }

    public static void collectLocationInfo()
    {
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorenter ;
        if (!isLocationPermissionsDenied() && b())
        {
            setSDKLocation(LOCATION_SET_BY_SDK);
        }
_L2:
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.internal("[InMobi]-4.5.5", "Exception updating loc info", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public static String currentLocationStr()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!DemogInfo.isLocationInquiryAllowed())
        {
            if (DemogInfo.getCurrentLocation() != null)
            {
                a(DemogInfo.getCurrentLocation());
            } else
            {
                a(((Location) (null)));
            }
            setSDKLocation(LOCATION_SET_BY_PUB);
        } else
        if (!isValidGeoInfo() && DemogInfo.getCurrentLocation() != null)
        {
            a(DemogInfo.getCurrentLocation());
            setSDKLocation(LOCATION_SET_BY_PUB);
        }
        if (stringbuilder != null && isValidGeoInfo())
        {
            stringbuilder.append(getLat());
            stringbuilder.append(",");
            stringbuilder.append(getLon());
            stringbuilder.append(",");
            stringbuilder.append((int)getLocAccuracy());
            return stringbuilder.toString();
        } else
        {
            return "";
        }
    }

    public static long getGeoTS()
    {
        return f;
    }

    public static double getLat()
    {
        return b;
    }

    public static double getLocAccuracy()
    {
        return d;
    }

    public static double getLon()
    {
        return c;
    }

    public static boolean isLocationPermissionsDenied()
    {
        int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        int j = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        return i != 0 && j != 0;
    }

    public static int isSDKSetLocation()
    {
        return g;
    }

    public static boolean isValidGeoInfo()
    {
        return e;
    }

    public static void setSDKLocation(int i)
    {
        g = i;
    }

    static 
    {
        LOCATION_SET_BY_SDK = 1;
        g = LOCATION_SET_BY_SDK;
    }
}
