// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.util.Base64;
import com.inmobi.commons.ads.cache.AdData;
import com.inmobi.commons.ads.cache.AdDatabaseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.NativeAdObject;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NativeConfigParams;
import java.util.List;
import org.json.JSONObject;

public class NativeAdsCache
{

    static NativeAdsCache a;

    private NativeAdsCache(Context context)
    {
    }

    public static NativeAdsCache getInstance()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/inmobi/monetization/internal/objects/NativeAdsCache;
        JVM INSTR monitorenter ;
        a = new NativeAdsCache(InternalSDKUtil.getContext());
        com/inmobi/monetization/internal/objects/NativeAdsCache;
        JVM INSTR monitorexit ;
_L2:
        AdDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getNativeSdkConfigParams().getmMaxCacheSize());
        return a;
        Exception exception;
        exception;
        com/inmobi/monetization/internal/objects/NativeAdsCache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public NativeAdObject getCachedAd(String s)
    {
        try
        {
            s = new JSONObject(AdDatabaseManager.getInstance().getAd(s).getContent());
            s = new NativeAdObject((new String(Base64.decode(s.getString("pubContent"), 0))).trim(), s.getString("contextCode"), s.getString("namespace"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception getting cached ad", s);
            return null;
        }
        return s;
    }

    public int getNumCachedAds(String s)
    {
        int i;
        try
        {
            i = AdDatabaseManager.getInstance().getNoOfAds(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public void removeExpiredAds()
    {
        long l = Initializer.getConfigParams().getNativeSdkConfigParams().getTimeToLive();
        AdDatabaseManager.getInstance().removeExpiredAds(l, "native");
    }

    public void saveNativeAds(String s, List list)
    {
        if (list != null && list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                AdData addata = new AdData();
                addata.setContent((String)list.get(i));
                addata.setTimestamp(System.currentTimeMillis());
                addata.setAppId(s);
                addata.setAdType("native");
                AdDatabaseManager.getInstance().insertAd(addata);
            }

        }
    }
}
