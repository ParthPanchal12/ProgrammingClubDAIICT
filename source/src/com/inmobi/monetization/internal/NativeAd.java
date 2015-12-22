// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.os.Handler;
import android.view.ViewGroup;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NativeConfigParams;
import com.inmobi.monetization.internal.objects.NativeAdsCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            Ad, IMAdListener, AdErrorCode, e, 
//            NativeAdObject, c

public class NativeAd extends Ad
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/inmobi/monetization/internal/NativeAd$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("INIT", 0);
            b = new a("LOADING", 1);
            c = new a("READY", 2);
            d = new a("ATTACHED", 3);
            e = new a("ERROR", 4);
            f = new a("UNKNOWN", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String KEY_CONTEXTCODE = "contextCode";
    public static final String KEY_NAMESPACE = "namespace";
    public static final String KEY_PUBCONTENT = "pubContent";
    e b;
    private Handler c;
    private a d;
    private String e;
    public boolean loggingEnabled;
    public Object mImpId;

    public NativeAd(String s)
    {
        super(s);
        d = a.f;
        b = null;
        e = null;
        if (initialize())
        {
            a(a.a);
        }
        e = s;
    }

    private void a()
    {
        NativeAdsCache.getInstance().removeExpiredAds();
        int i = NativeAdsCache.getInstance().getNumCachedAds(e);
        int j = Initializer.getConfigParams().getNativeSdkConfigParams().getmMinLimit();
        if (i == 0)
        {
            super.loadAd();
        } else
        {
            a(a.c);
            if (i <= j)
            {
                super.loadAd();
            }
            if (mAdListener != null)
            {
                mAdListener.onAdRequestSucceeded();
                return;
            }
        }
    }

    private void a(AdErrorCode aderrorcode)
    {
        if (aderrorcode != null)
        {
            Log.debug("[InMobi]-[Monetization]", aderrorcode.toString());
        }
        if (mAdListener != null && b() == a.b)
        {
            mAdListener.onAdRequestFailed(aderrorcode);
        }
        a(a.e);
    }

    private void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        d = a1;
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    static void a(NativeAd nativead, a a1)
    {
        nativead.a(a1);
    }

    private a b()
    {
        this;
        JVM INSTR monitorenter ;
        a a1 = d;
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public void attachToView(ViewGroup viewgroup, String s, String s1)
    {
        if (viewgroup == null)
        {
            static class _cls4
            {

                static final int a[];

                static 
                {
                    a = new int[a.values().length];
                    try
                    {
                        a[a.f.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        a[a.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[a.d.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[a.a.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[a.c.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[a.e.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            try
            {
                Log.debug("[InMobi]-[Monetization]", "Please pass a valid view to attach");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                android.util.Log.e("[InMobi]-[Monetization]", "Please pass a valid view to attach");
            }
            return;
        }
        _cls4.a[b().ordinal()];
        JVM INSTR tableswitch 1 6: default 145
    //                   1 60
    //                   2 129
    //                   3 137
    //                   4 78
    //                   5 86
    //                   6 129;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L3
_L2:
        Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        return;
_L5:
        Log.debug("[InMobi]-[Monetization]", "Please load a native ad before attach");
        return;
_L6:
        if (c == null)
        {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        }
        c.post(new Runnable(viewgroup, s, s1) {

            final ViewGroup a;
            final String b;
            final String c;
            final NativeAd d;

            public void run()
            {
                try
                {
                    d.b = new e(a.getContext(), b, c);
                    a.addView(d.b);
                    return;
                }
                catch (Exception exception)
                {
                    android.util.Log.e("[InMobi]-[Monetization]", "Failed to attach the view");
                }
                NativeAd.a(d, a.e);
            }

            
            {
                d = NativeAd.this;
                a = viewgroup;
                b = s;
                c = s1;
                super();
            }
        });
        a(a.d);
        return;
_L3:
        Log.debug("[InMobi]-[Monetization]", "Cannot attach an ad when it is not loaded");
        return;
_L4:
        Log.debug("[InMobi]-[Monetization]", "Ad is already attached");
        return;
_L1:
    }

    public void detachFromView()
    {
        switch (_cls4.a[b().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;

        case 4: // '\004'
            Log.debug("[InMobi]-[Monetization]", "Please load an ad before calling detach");
            return;

        case 2: // '\002'
        case 6: // '\006'
            Log.debug("[InMobi]-[Monetization]", "Cannot detach an ad when it is not loaded");
            return;

        case 5: // '\005'
            Log.debug("[InMobi]-[Monetization]", "Cannot detach an ad when it is not attached");
            return;

        case 3: // '\003'
            break;
        }
        if (c == null)
        {
            Log.debug("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        } else
        {
            c.post(new Runnable() {

                final NativeAd a;

                public void run()
                {
                    if (a.b != null)
                    {
                        a.b.a();
                        a.b = null;
                        return;
                    }
                    try
                    {
                        android.util.Log.e("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
                        NativeAd.a(a, a.e);
                        return;
                    }
                    catch (Exception exception)
                    {
                        NativeAd.a(a, a.e);
                    }
                    Log.debug("[InMobi]-[Monetization]", "Failed to detach a view");
                    return;
                }

            
            {
                a = NativeAd.this;
                super();
            }
            });
            a(a.a);
            return;
        }
    }

    protected Map getAdFormatParams()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("format", Ad.AD_FORMAT.NATIVE.toString().toLowerCase(Locale.getDefault()));
        hashmap.put("mk-ads", String.valueOf(Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit()));
        return hashmap;
    }

    public Handler getHandler()
    {
        return c;
    }

    public NativeAdObject getNativeAdObject()
    {
        return NativeAdsCache.getInstance().getCachedAd(e);
    }

    public void handleClick(HashMap hashmap)
    {
        switch (_cls4.a[b().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;

        case 2: // '\002'
        case 4: // '\004'
        case 6: // '\006'
            Log.debug("[InMobi]-[Monetization]", "Cannot handle click, native ad not loaded");
            return;

        case 5: // '\005'
            Log.debug("[InMobi]-[Monetization]", "Cannot handle click, native ad not attached");
            return;

        case 3: // '\003'
            break;
        }
        if (c == null)
        {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        } else
        {
            c.post(new Runnable(hashmap) {

                final HashMap a;
                final NativeAd b;

                public void run()
                {
                    try
                    {
                        b.b.a(a);
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.debug("[InMobi]-[Monetization]", "Failed to track click");
                    }
                }

            
            {
                b = NativeAd.this;
                a = hashmap;
                super();
            }
            });
            return;
        }
    }

    public void handleResponse(c c1, Response response)
    {
        if (response == null) goto _L2; else goto _L1
_L1:
        if (response.getStatusCode() != 200) goto _L4; else goto _L3
_L3:
        c1 = (new JSONObject(response.getResponseBody())).getJSONArray("ads");
        if (c1 == null) goto _L6; else goto _L5
_L5:
        int i;
        int j;
        try
        {
            if (c1.length() == 0)
            {
                a(AdErrorCode.NO_FILL);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception retrieving native ad", c1);
            a(AdErrorCode.INTERNAL_ERROR);
            return;
        }
        response = new ArrayList();
        j = c1.length();
        i = Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit();
        JSONObject jsonobject;
        Exception exception;
        String s;
        String s1;
        String s2;
        if (j <= i)
        {
            i = j;
        }
        j = 0;
_L17:
        if (j >= i) goto _L8; else goto _L7
_L7:
        jsonobject = c1.getJSONObject(j);
        s = jsonobject.optString("pubContent");
        s1 = jsonobject.optString("contextCode");
        s2 = jsonobject.optString("namespace");
        if (s == null) goto _L10; else goto _L9
_L9:
        if ("".equals(s.trim()) || s1 == null) goto _L10; else goto _L11
_L11:
        if ("".equals(s1.trim()) || s2 == null) goto _L10; else goto _L12
_L12:
        if (!"".equals(s2.trim()))
        {
            response.add(jsonobject.toString());
        }
          goto _L10
        exception;
        Log.internal("[InMobi]-[Monetization]", "JSON Exception", exception);
          goto _L10
_L8:
        if (response.size() <= 0) goto _L14; else goto _L13
_L13:
        NativeAdsCache.getInstance().saveNativeAds(e, response);
        if (b() == a.b)
        {
            a(a.c);
            if (mAdListener != null)
            {
                mAdListener.onAdRequestSucceeded();
                return;
            }
        }
          goto _L15
_L14:
        a(AdErrorCode.INTERNAL_ERROR);
        return;
_L6:
        a(AdErrorCode.INTERNAL_ERROR);
        return;
_L4:
        if (response.getStatusCode() == 400)
        {
            a(AdErrorCode.INVALID_APP_ID);
            return;
        }
        a(AdErrorCode.INTERNAL_ERROR);
        return;
_L2:
        a(AdErrorCode.INTERNAL_ERROR);
        return;
_L15:
        return;
_L10:
        j++;
        if (true) goto _L17; else goto _L16
_L16:
    }

    protected boolean initialize()
    {
        try
        {
            c = new Handler();
        }
        catch (Throwable throwable)
        {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return false;
        }
        return super.initialize();
    }

    public void loadAd()
    {
        if (c == null)
        {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        }
        switch (_cls4.a[b().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;

        case 2: // '\002'
            Log.debug("[InMobi]-[Monetization]", "Ad is already loading. Please wait");
            return;

        case 3: // '\003'
            detachFromView();
            // fall through

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            Log.debug("[InMobi]-[Monetization]", "Loading native ad");
            break;
        }
        a(a.b);
        a();
    }
}
