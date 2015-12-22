// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization.internal:
//            Ad, IMAdListener, AdErrorCode, b, 
//            c

public class InterstitialAd extends Ad
    implements com.inmobi.monetization.internal.imai.IMAIController.InterstitialAdStateListener
{
    static class a extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            InterstitialAd interstitialad = (InterstitialAd)a.get();
            if (interstitialad != null)
            {
                try
                {
                    switch (message.what)
                    {
                    case 301: 
                        InterstitialAd.b(interstitialad).cancelLoad();
                        InterstitialAd.b(interstitialad).stopLoading();
                        InterstitialAd.b(interstitialad).deinit();
                        InterstitialAd.a(interstitialad, null);
                        long l1 = System.currentTimeMillis();
                        long l2 = InterstitialAd.c(interstitialad);
                        interstitialad.collectMetrics(InterstitialAd.d(interstitialad), l1 - l2, NetworkEventType.RENDER_TIMEOUT);
                        if (interstitialad.mAdListener != null)
                        {
                            interstitialad.mAdListener.onAdRequestFailed(AdErrorCode.AD_RENDERING_TIMEOUT);
                            return;
                        }
                        break;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.internal("[InMobi]-[Monetization]", "Exception handling message in Interstitial", message);
                    return;
                }
            }
        }

        public a(InterstitialAd interstitialad)
        {
            a = new WeakReference(interstitialad);
        }
    }


    long b;
    boolean c;
    private Activity d;
    private long e;
    private IMWebView f;
    private long g;
    private Object h;
    private Response i;
    private boolean j;
    private boolean k;
    private a l;
    private com.inmobi.re.container.IMWebView.IMWebViewListener m = new com.inmobi.re.container.IMWebView.IMWebViewListener() {

        final InterstitialAd a;

        public void onDismissAdScreen()
        {
            a.destroy();
            if (a.mAdListener != null)
            {
                a.mAdListener.onDismissAdScreen();
            }
        }

        public void onDisplayFailed()
        {
            InterstitialAd.f(a);
        }

        public void onError()
        {
            Log.debug("[InMobi]-[Monetization]", "Error loading the interstitial ad ");
            InterstitialAd.e(a).removeMessages(301);
            InterstitialAd.a(a, null);
            if (a.mAdListener != null)
            {
                a.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            }
        }

        public void onExpand()
        {
        }

        public void onExpandClose()
        {
        }

        public void onIncentCompleted(Map map)
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onIncentCompleted(map);
            }
        }

        public void onLeaveApplication()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onLeaveApplication();
            }
        }

        public void onResize(ResizeDimensions resizedimensions)
        {
        }

        public void onResizeClose()
        {
        }

        public void onShowAdScreen()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onShowAdScreen();
            }
        }

        public void onUserInteraction(Map map)
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onAdInteraction(map);
            }
        }

            
            {
                a = InterstitialAd.this;
                super();
            }
    };

    public InterstitialAd(Activity activity, long l1)
    {
        super(l1);
        g = 0L;
        h = null;
        b = 0L;
        c = true;
        i = null;
        j = false;
        k = false;
        l = new a(this);
        d = activity;
        j = initialize();
    }

    public InterstitialAd(Activity activity, String s)
    {
        super(s);
        g = 0L;
        h = null;
        b = 0L;
        c = true;
        i = null;
        j = false;
        k = false;
        l = new a(this);
        d = activity;
        j = initialize();
    }

    private static int a()
    {
        byte byte0 = 14;
        if (DeviceInfo.isTablet(InternalSDKUtil.getContext()))
        {
            byte0 = 17;
        }
        return byte0;
    }

    static IMWebView a(InterstitialAd interstitialad, IMWebView imwebview)
    {
        interstitialad.f = imwebview;
        return imwebview;
    }

    static void a(InterstitialAd interstitialad)
    {
        interstitialad.c();
    }

    private boolean a(Object obj)
    {
        boolean flag;
        try
        {
            Field field = obj.getClass().getDeclaredField("mIsPlayableReady");
            field.setAccessible(true);
            flag = ((Boolean)field.get(obj)).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return flag;
    }

    static IMWebView b(InterstitialAd interstitialad)
    {
        return interstitialad.f;
    }

    private void b()
    {
        try
        {
            if (mAdListener != null)
            {
                mAdListener.onShowAdScreen();
            }
            Intent intent = new Intent(d, com/inmobi/androidsdk/IMBrowserActivity);
            intent.putExtra("extra_browser_type", 101);
            intent.putExtra("isAnimationEnabledOnDimiss", g);
            IMBrowserActivity.setWebview(f);
            IMBrowserActivity.setOriginalActivity(d);
            d.startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Error showing ad ", exception);
        }
    }

    private void b(Object obj)
    {
        try
        {
            Method method = obj.getClass().getDeclaredMethod("show", new Class[] {
                com/inmobi/monetization/internal/IMAdListener
            });
            method.setAccessible(true);
            method.invoke(obj, new Object[] {
                mAdListener
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.internal("[InMobi]-[Monetization]", "Failed to display playable ad");
        }
        b();
    }

    static long c(InterstitialAd interstitialad)
    {
        return interstitialad.e;
    }

    private void c()
    {
        if (!k)
        {
            long l1 = System.currentTimeMillis();
            long l2 = mFetchStartTime;
            String s;
            if (i != null)
            {
                s = i.getResponseBody();
            } else
            {
                s = null;
            }
            if (s != null)
            {
                s = s.replace("@__imm_aft@", (new StringBuilder()).append("").append(l1 - l2).toString());
                if (android.os.Build.VERSION.SDK_INT <= 8)
                {
                    s.replaceAll("%", "%25");
                }
                e = System.currentTimeMillis();
                l.sendEmptyMessageDelayed(301, Initializer.getConfigParams().getRenderTimeOut());
                f.loadDataWithBaseURL("", s, "text/html", null, null);
            } else
            {
                Log.debug("[InMobi]-[Monetization]", "Cannot load Ad. Invalid Ad Response");
                if (mAdListener != null)
                {
                    mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
                    return;
                }
            }
        }
    }

    static Response d(InterstitialAd interstitialad)
    {
        return interstitialad.i;
    }

    private boolean d()
    {
        try
        {
            Class.forName("com.inmobi.monetization.internal.thirdparty.PlayableAdsManager");
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    static a e(InterstitialAd interstitialad)
    {
        return interstitialad.l;
    }

    private Object e()
    {
        Object obj;
        try
        {
            obj = Class.forName("com.inmobi.monetization.internal.thirdparty.PlayableAdsManager").getConstructor(new Class[] {
                android/app/Activity, com/inmobi/re/container/IMWebView
            }).newInstance(new Object[] {
                d, f
            });
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception creating playable ads", exception);
            return null;
        }
        return obj;
    }

    private void f()
    {
        f = new IMWebView(d, m, true, false);
        if (!c)
        {
            f.disableHardwareAcceleration();
        }
        IMAIController imaicontroller = new IMAIController(f);
        imaicontroller.setInterstitialAdStateListener(this);
        f.addJavascriptInterface(imaicontroller, "imaiController");
    }

    static void f(InterstitialAd interstitialad)
    {
        interstitialad.b();
    }

    public void destroy()
    {
        super.destroy();
        if (f != null)
        {
            f.destroy();
        }
    }

    public void disableHardwareAcceleration()
    {
        if (!j)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        } else
        {
            c = false;
            if (f != null)
            {
                f.disableHardwareAcceleration();
                return;
            }
        }
    }

    protected Map getAdFormatParams()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("format", Ad.AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
        hashmap.put("mk-ads", "1");
        hashmap.put("mk-ad-slot", String.valueOf(a()));
        hashmap.put("adtype", "int");
        if (d())
        {
            hashmap.put("playable", String.valueOf(1));
        }
        return hashmap;
    }

    public void handleResponse(c c1, Response response)
    {
        i = response;
        d.runOnUiThread(new Runnable() {

            final InterstitialAd a;

            public void run()
            {
                InterstitialAd.a(a);
            }

            
            {
                a = InterstitialAd.this;
                super();
            }
        });
_L1:
        return;
        c1;
        Log.debug("[InMobi]-[Monetization]", "Error retrieving ad ", c1);
        if (mAdListener != null)
        {
            mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            return;
        }
          goto _L1
    }

    protected boolean initialize()
    {
        if (d == null)
        {
            Log.debug("[InMobi]-[Monetization]", "Activity cannot be null");
            return false;
        } else
        {
            d = com.inmobi.monetization.internal.b.a(d);
            return super.initialize();
        }
    }

    public void loadAd()
    {
        if (!j)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        k = false;
        destroy();
        f();
        if (d())
        {
            h = e();
        }
        super.loadAd();
    }

    public void onAdFailed()
    {
        l.removeMessages(301);
        if (!k && mAdListener != null)
        {
            mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    public void onAdReady()
    {
        long l1 = System.currentTimeMillis();
        long l2 = e;
        collectMetrics(i, l1 - l2, NetworkEventType.RENDER_COMPLETE);
        if (!k)
        {
            l.removeMessages(301);
            if (mAdListener != null)
            {
                mAdListener.onAdRequestSucceeded();
            }
        }
    }

    public void show()
    {
        try
        {
            if (!j)
            {
                Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
                return;
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Error showing ad ", exception);
            return;
        }
        Log.debug("[InMobi]-[Monetization]", "Showing the Interstitial Ad. ");
        if (d() && h != null && a(h))
        {
            b(h);
            return;
        }
        b();
        return;
    }

    public void show(long l1)
    {
        if (!j)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        } else
        {
            g = l1;
            show();
            return;
        }
    }

    public void stopLoading()
    {
        if (!j)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        super.stopLoading();
        if (l != null && l.hasMessages(301))
        {
            l.removeMessages(301);
        }
        k = true;
    }
}
