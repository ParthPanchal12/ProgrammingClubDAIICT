// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.configs;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UID;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization.internal.configs:
//            ConfigParams

public class Initializer
{

    public static final String PRODUCT_ADNETWORK = "adNetwork";
    private static Context a = null;
    private static Map b = new HashMap();
    private static Logger c = new Logger(1, "network");
    private static ConfigParams d = new ConfigParams();
    private static com.inmobi.commons.cache.CacheController.Validator e = new com.inmobi.commons.cache.CacheController.Validator() {

        public boolean validate(Map map)
        {
            return Initializer.a(map);
        }

    };

    public Initializer()
    {
    }

    private static void a(Context context)
    {
        if (context == null || a != null) goto _L2; else goto _L1
_L1:
        if (a == null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        a = context.getApplicationContext();
        b = getUidMap(context);
        try
        {
            b(CacheController.getConfig("adNetwork", context, b, e).getData());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
_L2:
        if (a == null && context == null)
        {
            throw new NullPointerException();
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    static boolean a(Map map)
    {
        return b(map);
    }

    private static void b(Context context)
    {
        a(context);
        try
        {
            CacheController.getConfig("adNetwork", context, b, e);
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
        b = getUidMap(a);
        try
        {
            map = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
            ConfigParams configparams = new ConfigParams();
            configparams.setFromMap(map);
            d = configparams;
            c.setMetricConfigParams(configparams.getMetric());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.internal("[InMobi]-[Monetization]", "Config couldn't be parsed", map);
            return false;
        }
        return true;
    }

    public static ConfigParams getConfigParams()
    {
        if (InternalSDKUtil.getContext() != null && InMobi.getAppId() != null)
        {
            b(InternalSDKUtil.getContext());
        }
        return d;
    }

    public static Logger getLogger()
    {
        return c;
    }

    public static Map getUidMap(Context context)
    {
        return UID.getInstance().getMapForEncryption(d.getDeviceIdMaskMap());
    }

}
