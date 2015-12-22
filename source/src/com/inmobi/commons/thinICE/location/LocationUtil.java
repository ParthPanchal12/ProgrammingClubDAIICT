// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.HashMap;

// Referenced classes of package com.inmobi.commons.thinICE.location:
//            LocationInfo

public final class LocationUtil
{

    public LocationUtil()
    {
    }

    private static LocationInfo a(Context context, String s)
    {
        context = ((LocationManager)context.getSystemService("location")).getLastKnownLocation(s);
        if (context == null)
        {
            return null;
        } else
        {
            s = new LocationInfo();
            s.time = context.getTime();
            s.provider = context.getProvider();
            s.latitude = context.getLatitude();
            s.longitude = context.getLongitude();
            s.accuracy = context.getAccuracy();
            return s;
        }
    }

    public static HashMap getLastKnownLocations(Context context)
    {
        HashMap hashmap = new HashMap();
        if (hasFineLocationPermission(context))
        {
            hashmap.put("gps", a(context, "gps"));
        }
        if (hasCoarseLocationPermission(context))
        {
            hashmap.put("network", a(context, "network"));
        }
        return hashmap;
    }

    public static boolean hasCoarseLocationPermission(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean hasFineLocationPermission(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean hasLocationPermission(Context context)
    {
        return hasFineLocationPermission(context) || hasCoarseLocationPermission(context);
    }
}
