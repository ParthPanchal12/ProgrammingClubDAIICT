// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization.internal:
//            Ad, AdErrorCode, IMAdListener, d, 
//            b, c

public class BannerAd extends Ad
{
    static class a extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            Object obj = (BannerAd)a.get();
            if (obj == null) goto _L2; else goto _L1
_L1:
            int i1 = message.what;
            i1;
            JVM INSTR tableswitch 101 102: default 44
        //                       101 166
        //                       102 50;
               goto _L2 _L3 _L4
_L2:
            super.handleMessage(message);
            return;
_L4:
            long l1 = System.currentTimeMillis();
            long l2 = BannerAd.c(((BannerAd) (obj)));
            ((BannerAd) (obj)).collectMetrics(BannerAd.d(((BannerAd) (obj))), l1 - l2, NetworkEventType.RENDER_TIMEOUT);
            if (!BannerAd.e(((BannerAd) (obj)))) goto _L6; else goto _L5
_L5:
            BannerAd.a(((BannerAd) (obj)), null);
_L7:
            if (((BannerAd) (obj)).mCurrentWebView != null)
            {
                ((BannerAd) (obj)).mCurrentWebView.cancelLoad();
                ((BannerAd) (obj)).mCurrentWebView.stopLoading();
                ((BannerAd) (obj)).mCurrentWebView.deinit();
                obj.mCurrentWebView = null;
            }
            if (((BannerAd) (obj)).mAdListener != null)
            {
                ((BannerAd) (obj)).mAdListener.onAdRequestFailed(AdErrorCode.AD_RENDERING_TIMEOUT);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            BannerAd.b(((BannerAd) (obj)), null);
              goto _L7
_L3:
            if (!BannerAd.f(((BannerAd) (obj))).hasWindowFocus())
            {
                Log.debug("[InMobi]-[Monetization]", "Activity is not in the foreground. New ad will not be loaded.");
                continue; /* Loop/switch isn't completed */
            }
            if (MRAIDInterstitialController.isInterstitialDisplayed.get())
            {
                Log.debug("[InMobi]-[Monetization]", "Ad cannot be loaded.Interstitial Ad is displayed.");
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                BannerAd.a(((BannerAd) (obj)), true);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.internal("[InMobi]-[Monetization]", "Exception hanlde message adview", ((Throwable) (obj)));
            }
            if (true) goto _L2; else goto _L8
_L8:
        }

        public a(BannerAd bannerad)
        {
            a = new WeakReference(bannerad);
        }
    }


    protected static final String KEY_MANUAL_REFRESH = "u-rt";
    protected static final String KEY_TYPE_OF_ADREQ = "requestactivity";
    protected static final String VALUE_OF_ADREQ = "AdRequest";
    AnimationType b;
    private Activity c;
    private IMWebView d;
    private IMWebView e;
    private boolean f;
    private boolean g;
    private int h;
    private long i;
    private boolean j;
    private int k;
    private d l;
    private Animation m;
    public IMWebView mCurrentWebView;
    private Animation n;
    private long o;
    private boolean p;
    private boolean q;
    private AtomicBoolean r;
    private Response s;
    private boolean t;
    private com.inmobi.re.container.IMWebView.IMWebViewListener u = new com.inmobi.re.container.IMWebView.IMWebViewListener() {

        final BannerAd a;

        public void onDismissAdScreen()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onDismissAdScreen();
            }
            BannerAd.b(a).set(false);
        }

        public void onDisplayFailed()
        {
        }

        public void onError()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            }
        }

        public void onExpand()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onShowAdScreen();
            }
        }

        public void onExpandClose()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onDismissAdScreen();
            }
        }

        public void onIncentCompleted(Map map)
        {
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
            if (a.mAdListener != null)
            {
                a.mAdListener.onShowAdScreen();
            }
        }

        public void onResizeClose()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onDismissAdScreen();
            }
        }

        public void onShowAdScreen()
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onShowAdScreen();
            }
            BannerAd.b(a).set(true);
        }

        public void onUserInteraction(Map map)
        {
            if (a.mAdListener != null)
            {
                a.mAdListener.onAdInteraction(map);
            }
        }

            
            {
                a = BannerAd.this;
                super();
            }
    };
    private a v;
    private android.view.animation.Animation.AnimationListener w = new android.view.animation.Animation.AnimationListener() {

        final BannerAd a;

        public void onAnimationEnd(Animation animation)
        {
            BannerAd.g(a);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                a = BannerAd.this;
                super();
            }
    };

    public BannerAd(Activity activity, IMBanner imbanner, long l1, int i1)
    {
        super(l1);
        f = true;
        g = false;
        h = 15;
        i = 0L;
        b = AnimationType.ROTATE_HORIZONTAL_AXIS;
        j = true;
        k = Initializer.getConfigParams().getDefaultRefreshRate();
        o = 0L;
        p = false;
        q = true;
        r = new AtomicBoolean(false);
        s = null;
        t = false;
        v = new a(this);
        h = i1;
        o = l1;
        c = activity;
        t = initialize();
    }

    public BannerAd(Activity activity, IMBanner imbanner, String s1, int i1)
    {
        super(s1);
        f = true;
        g = false;
        h = 15;
        i = 0L;
        b = AnimationType.ROTATE_HORIZONTAL_AXIS;
        j = true;
        k = Initializer.getConfigParams().getDefaultRefreshRate();
        o = 0L;
        p = false;
        q = true;
        r = new AtomicBoolean(false);
        s = null;
        t = false;
        v = new a(this);
        h = i1;
        c = activity;
        t = initialize();
    }

    static IMWebView a(BannerAd bannerad, IMWebView imwebview)
    {
        bannerad.d = imwebview;
        return imwebview;
    }

    static void a(BannerAd bannerad)
    {
        bannerad.i();
    }

    static void a(BannerAd bannerad, boolean flag)
    {
        bannerad.a(flag);
    }

    private void a(boolean flag)
    {
        if (!t)
        {
            t = initialize();
        }
        if (!t)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        } else
        {
            g = false;
            p = flag;
            if (!g())
            {
                super.loadAd();
            } else
            if (mAdListener != null)
            {
                AdErrorCode aderrorcode = AdErrorCode.INVALID_REQUEST;
                aderrorcode.setMessage("Ad click is in progress.Cannot load new ad");
                Log.debug("[InMobi]-[Monetization]", "Ad click is in progress.Cannot load new ad");
                mAdListener.onAdRequestFailed(aderrorcode);
            }
            v.removeMessages(101);
            if (k > 0)
            {
                v.sendEmptyMessageDelayed(101, k * 1000);
                return;
            }
        }
    }

    static IMWebView b(BannerAd bannerad, IMWebView imwebview)
    {
        bannerad.e = imwebview;
        return imwebview;
    }

    static AtomicBoolean b(BannerAd bannerad)
    {
        return bannerad.r;
    }

    private void b(boolean flag)
    {
        f = flag;
        if (flag)
        {
            d.deinit();
            d = null;
            return;
        } else
        {
            e.deinit();
            e = null;
            return;
        }
    }

    static long c(BannerAd bannerad)
    {
        return bannerad.i;
    }

    private ViewGroup d()
    {
        ViewGroup viewgroup1 = (ViewGroup)d.getParent();
        ViewGroup viewgroup = viewgroup1;
        if (viewgroup1 == null)
        {
            viewgroup = (ViewGroup)e.getParent();
        }
        return viewgroup;
    }

    static Response d(BannerAd bannerad)
    {
        return bannerad.s;
    }

    private boolean e()
    {
        return f;
    }

    static boolean e(BannerAd bannerad)
    {
        return bannerad.e();
    }

    static Activity f(BannerAd bannerad)
    {
        return bannerad.c;
    }

    private void f()
    {
        try
        {
            if (e != null)
            {
                e.setBackgroundColor(0);
            }
            if (d != null)
            {
                d.setBackgroundColor(0);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Error setNormalBGColor", exception);
        }
    }

    static void g(BannerAd bannerad)
    {
        bannerad.h();
    }

    private boolean g()
    {
        IMWebView imwebview;
        String s1;
        if (e())
        {
            imwebview = e;
        } else
        {
            imwebview = d;
        }
        s1 = imwebview.getState();
        Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Current Ad State: ").append(s1).toString());
        if (com.inmobi.re.container.IMWebView.ViewState.EXPANDED.toString().equalsIgnoreCase(s1) || com.inmobi.re.container.IMWebView.ViewState.RESIZED.toString().equalsIgnoreCase(s1) || com.inmobi.re.container.IMWebView.ViewState.RESIZING.toString().equalsIgnoreCase(s1) || com.inmobi.re.container.IMWebView.ViewState.EXPANDING.toString().equalsIgnoreCase(s1))
        {
            Log.debug("[InMobi]-[Monetization]", "Current Ad State is neither default nor loading. New ad will not be shown.");
            return true;
        }
        if (imwebview.isBusy())
        {
            Log.debug("[InMobi]-[Monetization]", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
            return true;
        }
        return r.get();
    }

    private void h()
    {
        if (g) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        viewgroup = d();
        viewgroup.removeAllViews();
        if (viewgroup == null) goto _L4; else goto _L3
_L3:
        if (!e()) goto _L6; else goto _L5
_L5:
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        mCurrentWebView = d;
        viewgroup.addView(d, layoutparams);
_L7:
        Object obj;
        boolean flag;
        if (!e())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b(flag);
        f();
_L4:
        if (mAdListener != null)
        {
            mAdListener.onAdRequestSucceeded();
        }
        if (v != null)
        {
            v.removeMessages(102);
        }
_L2:
        return;
_L6:
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        mCurrentWebView = e;
        viewgroup.addView(e, layoutparams1);
          goto _L7
        obj;
        ((Exception) (obj)).printStackTrace();
        Log.debug("[InMobi]-[Monetization]", "Error swapping banner ads", ((Throwable) (obj)));
        if (mAdListener != null)
        {
            mAdListener.onAdRequestSucceeded();
        }
        if (v == null) goto _L2; else goto _L8
_L8:
        v.removeMessages(102);
        return;
        obj;
        if (mAdListener != null)
        {
            mAdListener.onAdRequestSucceeded();
        }
        if (v != null)
        {
            v.removeMessages(102);
        }
        throw obj;
    }

    private void i()
    {
        if (g || s == null) goto _L2; else goto _L1
_L1:
        String s1;
        long l1;
        long l2;
        s1 = s.getResponseBody();
        l1 = System.currentTimeMillis();
        l2 = mFetchStartTime;
        if (s1 == null) goto _L4; else goto _L3
_L3:
        s1 = s1.replace("@__imm_aft@", (new StringBuilder()).append("").append(l1 - l2).toString());
        if (android.os.Build.VERSION.SDK_INT <= 8)
        {
            s1.replaceAll("%", "%25");
        }
        if (e())
        {
            if (d == null)
            {
                d = new IMWebView(c, u, false, false);
                if (!q)
                {
                    d.disableHardwareAcceleration();
                }
            }
            mCurrentWebView = d;
        } else
        {
            if (e == null)
            {
                e = new IMWebView(c, u, false, false);
                if (!q)
                {
                    e.disableHardwareAcceleration();
                }
            }
            mCurrentWebView = e;
        }
        mCurrentWebView.addJavascriptInterface(new IMAIController(mCurrentWebView), "imaiController");
        i = System.currentTimeMillis();
        v.sendEmptyMessageDelayed(102, Initializer.getConfigParams().getRenderTimeOut());
        mCurrentWebView.resetMraid();
        mCurrentWebView.loadDataWithBaseURL("", s1, "text/html", null, null);
        l1 = System.currentTimeMillis();
        l2 = mFetchStartTime;
        collectMetrics(s, l1 - l2, NetworkEventType.RENDER_COMPLETE);
        if (!j) goto _L6; else goto _L5
_L5:
        h();
        j = false;
_L2:
        return;
_L6:
        if (b == AnimationType.ANIMATION_OFF)
        {
            h();
            return;
        } else
        {
            l.a(b);
            return;
        }
_L4:
        Log.debug("[InMobi]-[Monetization]", "Cannot load Ad. Invalid Ad Response");
        if (mAdListener != null)
        {
            mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    Animation a()
    {
        return m;
    }

    void a(Animation animation)
    {
        m = animation;
    }

    int b()
    {
        ViewGroup viewgroup = d();
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        int i1 = viewgroup.getWidth();
        return i1;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Monetization]", "Exception getting width of banner view", exception);
        return 0;
    }

    void b(Animation animation)
    {
        n = animation;
    }

    int c()
    {
        ViewGroup viewgroup = d();
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        int i1 = viewgroup.getHeight();
        return i1;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Monetization]", "Exception getting height of banner view", exception);
        return 0;
    }

    void c(Animation animation)
    {
        ViewGroup viewgroup;
        try
        {
            viewgroup = d();
        }
        // Misplaced declaration of an exception variable
        catch (Animation animation)
        {
            animation.printStackTrace();
            Log.internal("[InMobi]-[Monetization]", "Exception animating  banner view", animation);
            return;
        }
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        viewgroup.startAnimation(animation);
    }

    public void disableHardwareAcceleration()
    {
        if (!t)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        } else
        {
            q = false;
            if (mCurrentWebView != null)
            {
                mCurrentWebView.disableHardwareAcceleration();
                return;
            }
        }
    }

    protected Map getAdFormatParams()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("format", Ad.AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
        hashmap.put("mk-ads", "1");
        hashmap.put("requestactivity", "AdRequest");
        if (p)
        {
            hashmap.put("u-rt", String.valueOf(1));
        } else
        {
            hashmap.put("u-rt", String.valueOf(0));
        }
        if (o > 0L)
        {
            hashmap.put("placement-size", (new StringBuilder()).append(b()).append("x").append(c()).toString());
        }
        hashmap.put("mk-ad-slot", String.valueOf(h));
        return hashmap;
    }

    public View getView()
    {
        return mCurrentWebView;
    }

    public void handleResponse(c c1, Response response)
    {
        if (response == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (c != null)
        {
            s = response;
            c.runOnUiThread(new Runnable() {

                final BannerAd a;

                public void run()
                {
                    BannerAd.a(a);
                }

            
            {
                a = BannerAd.this;
                super();
            }
            });
        }
_L1:
        return;
        c1;
        Log.debug("[InMobi]-[Monetization]", "Failed to render banner ad");
        if (mAdListener != null)
        {
            mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            return;
        }
          goto _L1
    }

    protected boolean initialize()
    {
        if (h < 0)
        {
            Log.debug("[InMobi]-[Monetization]", "Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.monetization.IMBanner' tag of layout XML. For example, adSize=\"yourAdSize\"");
            return false;
        }
        if (c == null)
        {
            Log.debug("[InMobi]-[Monetization]", "Activity cannot be null");
            return false;
        }
        c = com.inmobi.monetization.internal.b.a(c);
        if (d == null)
        {
            d = new IMWebView(c, u, false, false);
            if (!q)
            {
                d.disableHardwareAcceleration();
            }
            d.addJavascriptInterface(new IMAIController(d), "imaiController");
        }
        if (e == null)
        {
            e = new IMWebView(c, u, false, false);
            mCurrentWebView = e;
            if (!q)
            {
                e.disableHardwareAcceleration();
            }
            e.addJavascriptInterface(new IMAIController(e), "imaiController");
        }
        l = new d(this, w);
        return super.initialize();
    }

    public void loadAd()
    {
        a(false);
    }

    public void refreshAd()
    {
        p = true;
        v.removeMessages(101);
        if (k > 0)
        {
            v.sendEmptyMessageDelayed(101, k * 1000);
        }
    }

    public void setAdSize(int i1)
    {
        h = i1;
    }

    public void setAnimation(AnimationType animationtype)
    {
        b = animationtype;
    }

    public void setRefreshInterval(int i1)
    {
        if (!t)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        } else
        {
            int j1 = Initializer.getConfigParams().getMinimumRefreshRate();
            v.removeMessages(101);
            if (i1 <= 0)
            {
                k = 0;
                return;
            }
            if (i1 < j1)
            {
                Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Refresh Interval cannot be less than ").append(j1).append(" seconds. Setting refresh rate to ").append(j1).toString());
                k = j1;
            } else
            {
                k = i1;
            }
            if (k != 0)
            {
                v.sendEmptyMessageDelayed(101, k * 1000);
                return;
            }
        }
    }

    public void stopLoading()
    {
        if (!t)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        super.stopLoading();
        if (v != null && v.hasMessages(102))
        {
            v.removeMessages(102);
        }
        g = true;
    }

    public void stopRefresh()
    {
        if (!t)
        {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        } else
        {
            v.removeMessages(101);
            return;
        }
    }
}
