// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UID;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.bootstrapper:
//            AnalyticsConfigParams

public class AnalyticsInitializer
{

    public static final String PRODUCT_ANALYTICS = "ltvp";
    private static Context a = null;
    private static Map b = new HashMap();
    private static AnalyticsConfigParams c = new AnalyticsConfigParams();
    private static com.inmobi.commons.cache.CacheController.Validator d = new com.inmobi.commons.cache.CacheController.Validator() {

        public boolean validate(Map map)
        {
            return AnalyticsInitializer.a(map);
        }

    };

    public AnalyticsInitializer()
    {
    }

    private static void a(Context context)
    {
        if (context != null && a == null)
        {
            if (a == null)
            {
                a = context.getApplicationContext();
                b = getUidMap(context);
                try
                {
                    context = CacheController.getConfig("ltvp", context, b, d);
                    if (context.getRawData() != null)
                    {
                        b(context.getData());
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.internal("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Exception while retreiving configs due to commons Exception with code ").append(context.getCode()).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.internal("[InMobi]-[Analytics]-4.5.5", "Exception while retreiving configs.", context);
                    return;
                }
            }
        } else
        if (a == null && context == null)
        {
            a.getApplicationContext();
            return;
        }
    }

    static boolean a(Map map)
    {
        return b(map);
    }

    private static void b(Context context)
    {
        a(context);
        b = getUidMap(a);
        try
        {
            CacheController.getConfig("ltvp", context, b, d);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private static boolean b(Map map)
    {
        AnalyticsConfigParams analyticsconfigparams = new AnalyticsConfigParams();
        try
        {
            analyticsconfigparams.setFromMap((Map)map.get("common"));
            c = analyticsconfigparams;
            ThinICE.setConfig(analyticsconfigparams.getThinIceConfig());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Exception while saving configs.", map);
            return false;
        }
        return true;
    }

    public static AnalyticsConfigParams getConfigParams()
    {
        if (InternalSDKUtil.getContext() != null && InMobi.getAppId() != null)
        {
            b(InternalSDKUtil.getContext());
        }
        return c;
    }

    public static AnalyticsConfigParams getRawConfigParams()
    {
        return c;
    }

    public static Map getUidMap(Context context)
    {
        return UID.getInstance().getMapForEncryption(null);
    }

}
