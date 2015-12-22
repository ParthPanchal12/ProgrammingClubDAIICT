// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.carb.CARB;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            LtvpRuleProcessor, c, AdErrorCode, IMAdListener, 
//            InvalidManifestConfigException, b, ConnBroadcastReciever, a

public abstract class Ad
{
    protected static final class AD_FORMAT extends Enum
    {

        public static final AD_FORMAT IMAI;
        public static final AD_FORMAT NATIVE;
        private static final AD_FORMAT a[];

        public static AD_FORMAT valueOf(String s)
        {
            return (AD_FORMAT)Enum.valueOf(com/inmobi/monetization/internal/Ad$AD_FORMAT, s);
        }

        public static AD_FORMAT[] values()
        {
            return (AD_FORMAT[])a.clone();
        }

        static 
        {
            IMAI = new AD_FORMAT("IMAI", 0);
            NATIVE = new AD_FORMAT("NATIVE", 1);
            a = (new AD_FORMAT[] {
                IMAI, NATIVE
            });
        }

        private AD_FORMAT(String s, int i1)
        {
            super(s, i1);
        }
    }

    static class a extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            Ad ad = (Ad)a.get();
            if (ad != null)
            {
                long l1;
                switch (message.what)
                {
                default:
                    return;

                case 101: // 'e'
                    l1 = System.currentTimeMillis();
                    break;
                }
                long l2 = ad.mFetchStartTime;
                message = new JSONObject();
                try
                {
                    message.put("t", l1 - l2);
                    message.put("m", 1);
                    Ad.a(ad, message, NetworkEventType.CONNECT_ERROR);
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Error creating metric logs for error at ").append(System.currentTimeMillis()).toString());
                }
                ad.setDownloadingNewAd(false);
                if (ad.mAdListener != null)
                {
                    ad.mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
                    return;
                }
            }
        }

        public a(Ad ad)
        {
            a = new WeakReference(ad);
        }
    }


    public static final String AD_TYPE_NATIVE = "native";
    protected static final String DEFAULT_NO_OF_ADS = "1";
    protected static final String KEY_AD_FORMAT = "format";
    protected static final String KEY_AD_SIZE = "mk-ad-slot";
    protected static final String KEY_NO_OF_ADS = "mk-ads";
    protected static final String KEY_PLACEMENT_SIZE = "placement-size";
    private static ConnBroadcastReciever e = null;
    boolean a;
    private String b;
    private long c;
    private AtomicBoolean d;
    private Map f;
    private String g;
    private String h;
    private String i;
    private c j;
    private a k;
    private LtvpRuleProcessor.ActionsRule l;
    private HashMap m;
    protected IMAdListener mAdListener;
    protected boolean mEnableHardwareAcceleration;
    protected long mFetchStartTime;
    protected String mImpressionId;

    public Ad(long l1)
    {
        b = null;
        c = 0L;
        mEnableHardwareAcceleration = true;
        d = new AtomicBoolean();
        mFetchStartTime = 0L;
        g = null;
        h = null;
        i = null;
        j = null;
        k = new a(this);
        mImpressionId = null;
        l = LtvpRuleProcessor.ActionsRule.MEDIATION;
        m = null;
        mAdListener = null;
        a = false;
        c = l1;
    }

    public Ad(String s)
    {
        b = null;
        c = 0L;
        mEnableHardwareAcceleration = true;
        d = new AtomicBoolean();
        mFetchStartTime = 0L;
        g = null;
        h = null;
        i = null;
        j = null;
        k = new a(this);
        mImpressionId = null;
        l = LtvpRuleProcessor.ActionsRule.MEDIATION;
        m = null;
        mAdListener = null;
        a = false;
        if (s == null || "".equals(s.trim()))
        {
            b = InMobi.getAppId();
            return;
        } else
        {
            b = s;
            return;
        }
    }

    private Map a()
    {
        HashMap hashmap = new HashMap();
        if (hashmap != null)
        {
            if (m != null)
            {
                String s;
                for (Iterator iterator = m.keySet().iterator(); iterator.hasNext(); hashmap.put(s, m.get(s)))
                {
                    s = (String)iterator.next();
                }

            }
            if (h != null && i != null)
            {
                hashmap.put(h, i);
            }
            if (g != null)
            {
                hashmap.put("p-keywords", g);
            }
        }
        return hashmap;
    }

    static void a(Ad ad, JSONObject jsonobject, NetworkEventType networkeventtype)
    {
        ad.a(jsonobject, networkeventtype);
    }

    private void a(JSONObject jsonobject, NetworkEventType networkeventtype)
    {
        if (a)
        {
            Initializer.getLogger().logEvent(new EventLog(networkeventtype, jsonobject));
        }
    }

    static boolean a(Ad ad)
    {
        return ad.b();
    }

    static a b(Ad ad)
    {
        return ad.k;
    }

    private boolean b()
    {
        return d.get();
    }

    private LtvpRuleProcessor.ActionsRule c()
    {
        return LtvpRuleProcessor.getInstance().getLtvpRuleConfig(c);
    }

    static LtvpRuleProcessor.ActionsRule c(Ad ad)
    {
        return ad.l;
    }

    protected void collectMetrics(Response response, long l1, NetworkEventType networkeventtype)
    {
        JSONObject jsonobject;
        if (!a)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        jsonobject = new JSONObject();
        if (response.getStatusCode() <= 400) goto _L2; else goto _L1
_L1:
        jsonobject.put("m", response.getError());
_L3:
        jsonobject.put("t", l1);
        Initializer.getLogger().logEvent(new EventLog(networkeventtype, jsonobject));
        return;
_L2:
label0:
        {
            if (response.getStatusCode() == 200)
            {
                break label0;
            }
            jsonobject.put("m", response.getStatusCode());
        }
          goto _L3
        try
        {
            response = response.getHeaders();
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Error creating metric logs for ad fetch at ").append(System.currentTimeMillis()).toString());
            return;
        }
        if (response == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        mImpressionId = (String)((List)response.get("im-id")).get(0);
        response = (String)((List)response.get("im-ec")).get(0);
        if (response == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Sandbox error Id: ").append(response).toString());
        jsonobject.put("ad", mImpressionId);
          goto _L3
    }

    public void destroy()
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
            return;
        } else
        {
            e = null;
            return;
        }
    }

    protected abstract Map getAdFormatParams();

    protected Response getDecryptedResponse(c c1, Response response)
    {
        try
        {
            c1 = new Response(new String(EncryptionUtils.DeAe(Base64.decode(response.getResponseBody().getBytes(), 0), c1.b(), c1.a())), response.getStatusCode(), response.getHeaders());
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            c1.printStackTrace();
            return null;
        }
        return c1;
    }

    protected void handleError(c c1, Response response)
    {
        long l1;
label0:
        {
            l1 = System.currentTimeMillis() - mFetchStartTime;
            if (mAdListener != null)
            {
                if (response.getStatusCode() != 204)
                {
                    break label0;
                }
                mAdListener.onAdRequestFailed(AdErrorCode.NO_FILL);
                collectMetrics(response, l1, NetworkEventType.RESPONSE_ERROR);
            }
            return;
        }
        if (response.getStatusCode() == 400)
        {
            Log.debug("[InMobi]-[Monetization]", "Check the app Id passed in the ad");
            mAdListener.onAdRequestFailed(AdErrorCode.INVALID_APP_ID);
            collectMetrics(response, l1, NetworkEventType.RESPONSE_ERROR);
            return;
        }
        if (response.getError() != null)
        {
            c1 = response.getError();
            if (c1.equals(ErrorCode.INTERNAL_ERROR))
            {
                mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            } else
            if (c1.equals(ErrorCode.INVALID_REQUEST))
            {
                mAdListener.onAdRequestFailed(AdErrorCode.INVALID_REQUEST);
            } else
            if (c1.equals(ErrorCode.NETWORK_ERROR))
            {
                mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
            } else
            if (!c1.equals(ErrorCode.CONNECTION_ERROR));
            collectMetrics(response, l1, NetworkEventType.CONNECT_ERROR);
            return;
        } else
        {
            mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            return;
        }
    }

    protected abstract void handleResponse(c c1, Response response);

    protected boolean initialize()
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
            return false;
        }
        if ((b == null || "".equals(b.trim())) && 0L == c)
        {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create an instance of  ad with valid appId/ slotid");
            return false;
        }
        try
        {
            ThinICE.start(InternalSDKUtil.getContext());
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Cannot start ice. Activity is null");
        }
        try
        {
            com.inmobi.monetization.internal.b.a(InternalSDKUtil.getContext());
        }
        catch (InvalidManifestConfigException invalidmanifestconfigexception)
        {
            Log.internal("[InMobi]-[Monetization]", "IMConfigException occured while initializing interstitial while validating adView", invalidmanifestconfigexception);
        }
        InternalSDKUtil.getUserAgent();
        CARB.getInstance().startCarb();
        UID.getInstance().printPublisherTestId();
        IMWebView.setIMAIController(com/inmobi/monetization/internal/imai/IMAIController);
        if (e == null)
        {
            e = new ConnBroadcastReciever();
        }
        InternalSDKUtil.getContext().registerReceiver(e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (c > 0L)
        {
            l = c();
        }
        return true;
    }

    protected void loadAd()
    {
        if (InternalSDKUtil.isInitializedSuccessfully()) goto _L2; else goto _L1
_L1:
        Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
        if (mAdListener != null)
        {
            mAdListener.onAdRequestFailed(AdErrorCode.INVALID_REQUEST);
        }
_L4:
        return;
_L2:
        DeviceInfo.updateDeviceInfo();
        UID.getInstance().printPublisherTestId();
        Log.debug("[InMobi]-[Monetization]", " >>>> Start loading new Ad <<<<");
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (mAdListener == null) goto _L4; else goto _L3
_L3:
        Exception exception;
        mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
        return;
        if (!b())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        if (mAdListener == null) goto _L4; else goto _L5
_L5:
        mAdListener.onAdRequestFailed(AdErrorCode.AD_DOWNLOAD_IN_PROGRESS);
        return;
        if (getAdFormatParams() != null) goto _L7; else goto _L6
_L6:
        f = new HashMap();
_L12:
        if (!f.containsKey("format"))
        {
            f.put("format", AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
        }
        if (!f.containsKey("mk-ads"))
        {
            f.put("mk-ads", "1");
        }
        if (b != null && !"".equals(b))
        {
            f.put("mk-siteid", b);
        }
        j = new c();
        j.b(a());
        if (c <= 0L)
        {
            break MISSING_BLOCK_LABEL_556;
        }
        l = c();
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_556;
        }
        static class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[LtvpRuleProcessor.ActionsRule.values().length];
                try
                {
                    a[LtvpRuleProcessor.ActionsRule.ACTIONS_ONLY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[LtvpRuleProcessor.ActionsRule.MEDIATION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[LtvpRuleProcessor.ActionsRule.NO_ADS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[l.ordinal()];
        JVM INSTR tableswitch 1 4: default 629
    //                   1 403
    //                   2 403
    //                   3 512
    //                   4 534;
           goto _L8 _L9 _L9 _L10 _L11
_L8:
        if (mAdListener != null)
        {
            mAdListener.onAdRequestFailed(AdErrorCode.NO_FILL);
        }
_L15:
        if (l != LtvpRuleProcessor.ActionsRule.ACTIONS_ONLY && l != LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION)
        {
            Log.internal("[InMobi]-[Monetization]", "No actions returned by rule");
            return;
        }
        break MISSING_BLOCK_LABEL_556;
_L7:
        try
        {
            f = getAdFormatParams();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            handleError(j, new Response(ErrorCode.INTERNAL_ERROR));
            Log.debug("[InMobi]-[Monetization]", "Error in loading ad ", exception);
            return;
        }
          goto _L12
_L9:
        int i1;
        f.put("mk-site-slotid", Long.toString(c));
        f.put("rule-id", LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).getLtvpRuleId());
        i1 = ActivityRecognitionManager.getDetectedActivity();
        if (i1 == -1) goto _L14; else goto _L13
_L13:
        f.put("u-activity-type", (new StringBuilder()).append(i1).append("").toString());
_L14:
        if (j != null)
        {
            j.setUrl(AnalyticsInitializer.getConfigParams().getEndPoints().getHouseUrl());
        }
          goto _L15
_L10:
        if (mAdListener == null) goto _L15; else goto _L16
_L16:
        mAdListener.onAdRequestFailed(AdErrorCode.DO_MONETIZE);
          goto _L15
_L11:
        if (mAdListener == null) goto _L15; else goto _L17
_L17:
        mAdListener.onAdRequestFailed(AdErrorCode.DO_NOTHING);
          goto _L15
        j.a(f);
        setDownloadingNewAd(true);
        com.inmobi.monetization.internal.a.a().a(b, j, new INetworkListener() {

            final Ad a;

            public void onRequestFailed(Request request, Response response)
            {
                if (Ad.a(a))
                {
                    if (Ad.c(a) == LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION)
                    {
                        if (a.mAdListener != null)
                        {
                            a.mAdListener.onAdRequestFailed(AdErrorCode.DO_MONETIZE);
                        }
                    } else
                    {
                        a.handleError((c)request, response);
                    }
                    a.setDownloadingNewAd(false);
                }
            }

            public void onRequestSucceded(Request request, Response response)
            {
                if (Ad.a(a))
                {
                    Response response1 = a.getDecryptedResponse((c)request, response);
                    long l1;
                    long l2;
                    if (response1 == null)
                    {
                        a.handleError((c)request, response);
                    } else
                    {
                        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Raw Ad Response: ").append(response1.getResponseBody()).toString());
                        a.handleResponse((c)request, response1);
                    }
                    l1 = System.currentTimeMillis();
                    l2 = a.mFetchStartTime;
                    a.collectMetrics(response, l1 - l2, NetworkEventType.FETCH_COMPLETE);
                    a.setDownloadingNewAd(false);
                    Ad.b(a).removeMessages(101);
                }
            }

            
            {
                a = Ad.this;
                super();
            }
        });
        mFetchStartTime = System.currentTimeMillis();
        k.sendEmptyMessageDelayed(101, Initializer.getConfigParams().getFetchTimeOut());
        a = Initializer.getLogger().startNewSample();
        return;
          goto _L12
    }

    public void setAdListener(IMAdListener imadlistener)
    {
        mAdListener = imadlistener;
    }

    protected void setAdRequest(c c1)
    {
        j = c1;
    }

    public void setAppId(String s)
    {
        if (s != null && !"".equals(s))
        {
            b = s;
            return;
        } else
        {
            Log.debug("[InMobi]-[Monetization]", "AppId cannot be null or blank.");
            return;
        }
    }

    protected void setDownloadingNewAd(boolean flag)
    {
        d.set(flag);
    }

    public void setKeywords(String s)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
        } else
        if (s != null && !"".equals(s))
        {
            g = s;
            return;
        }
    }

    public void setRequestParams(Map map)
    {
        if (InternalSDKUtil.isInitializedSuccessfully()) goto _L2; else goto _L1
_L1:
        Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
_L4:
        return;
_L2:
        if (map != null && !map.isEmpty())
        {
            if (m == null)
            {
                m = new HashMap();
            }
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                m.put(s, map.get(s));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSlotId(long l1)
    {
        if (l1 > 0L)
        {
            c = l1;
            return;
        } else
        {
            Log.debug("[InMobi]-[Monetization]", "Invalid slot id");
            return;
        }
    }

    public void stopLoading()
    {
        if (b())
        {
            if (k != null && k.hasMessages(101))
            {
                k.removeMessages(101);
            }
            setDownloadingNewAd(false);
            Log.debug("[InMobi]-[Monetization]", "Stopped loading an ad");
            if (mAdListener != null)
            {
                mAdListener.onAdRequestFailed(AdErrorCode.ADREQUEST_CANCELLED);
            }
        }
    }

}
