// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.yeahmobi.android.common.AdClickHandler;
import com.yeahmobi.android.common.AdManager;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Dips;
import com.yeahmobi.android.common.util.Utils;
import com.yeahmobi.android.interfaces.AdInterfaces;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdBannerView extends FrameLayout
{
    public static class AdBannerFactory
    {

        public static AdBannerView create(Context context, boolean flag, long l)
        {
            return new AdBannerView(context, flag, l);
        }

        public AdBannerFactory()
        {
        }
    }

    protected static class YMWebView extends WebView
    {

        private final SoftReference mClickHandler;

        public boolean onTouchEvent(MotionEvent motionevent)
        {
            motionevent.getAction();
            JVM INSTR tableswitch 1 1: default 24
        //                       1 26;
               goto _L1 _L2
_L1:
            return true;
_L2:
            ((AdClickHandler)mClickHandler.get()).jumpToClickDestinationUrl();
            if (true) goto _L1; else goto _L3
_L3:
        }

        public YMWebView(Context context, AdClickHandler adclickhandler)
        {
            super(context);
            mClickHandler = new SoftReference(adclickhandler);
        }
    }

    private class YMWebViewClient extends WebViewClient
    {

        SoftReference mWebView;
        final AdBannerView this$0;

        public void onPageFinished(WebView webview, String s)
        {
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            webview = (WebView)mWebView.get();
            if (webview == null)
            {
                return false;
            } else
            {
                webview.loadUrl(s);
                return true;
            }
        }

        YMWebViewClient(WebView webview)
        {
            this$0 = AdBannerView.this;
            super();
            mWebView = new SoftReference(webview);
        }
    }


    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private final long MONITOR_INV;
    private final boolean PRELOAD;
    private AdManager adManager;
    private int adNum;
    private FrameLayout adView;
    private String appId;
    private Timer flushTimer;
    private boolean isRequestingAd;
    private AdClickHandler mAdClickHandler;
    private AdResponse mAdResponse;
    private ArrayList mAdResponses;
    private Context mContext;
    private WebView mWebView;
    private YMWebViewClient mWebViewClient;
    private String slotId;

    public AdBannerView(Context context)
    {
        super(context);
        isRequestingAd = false;
        mAdResponses = new ArrayList();
        MONITOR_INV = 10000L;
        PRELOAD = true;
        setup(context);
    }

    public AdBannerView(Context context, long l)
    {
        super(context);
        isRequestingAd = false;
        mAdResponses = new ArrayList();
        MONITOR_INV = l;
        PRELOAD = true;
        setup(context);
    }

    public AdBannerView(Context context, boolean flag)
    {
        super(context);
        isRequestingAd = false;
        mAdResponses = new ArrayList();
        MONITOR_INV = 20000L;
        PRELOAD = flag;
        setup(context);
    }

    public AdBannerView(Context context, boolean flag, long l)
    {
        super(context);
        isRequestingAd = false;
        mAdResponses = new ArrayList();
        MONITOR_INV = l;
        PRELOAD = flag;
        setup(context);
    }

    private void flushAds()
    {
        this;
        JVM INSTR monitorenter ;
        mainHandler.post(new Runnable() {

            final AdBannerView this$0;

            public void run()
            {
                flushAdsInMain();
            }

            
            {
                this$0 = AdBannerView.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void flushAdsInMain()
    {
        if (mAdResponses.size() < 1)
        {
            requestAds();
        }
        if (mAdResponses.size() == 0)
        {
            return;
        }
        mAdResponse = (AdResponse)mAdResponses.get(0);
        mWebView.loadDataWithBaseURL("http://native.ymtrack.com/", mAdResponse.getHtmlSnippet(), "text/html", "utf-8", null);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
        android.widget.FrameLayout.LayoutParams layoutparams;
        int i;
        int j;
        if (mAdResponse != null)
        {
            i = mAdResponse.getWidth();
        } else
        {
            i = 0;
        }
        if (mAdResponse != null)
        {
            j = mAdResponse.getHeight();
        } else
        {
            j = 0;
        }
        layoutparams = layoutparams1;
        if (i > 0)
        {
            layoutparams = layoutparams1;
            if (j > 0)
            {
                layoutparams = new android.widget.FrameLayout.LayoutParams(Dips.asIntPixels(i, mContext), Dips.asIntPixels(j, mContext), 17);
            }
        }
        adView.removeAllViews();
        adView.addView(mWebView, layoutparams);
        mAdClickHandler.setAdInfo(mAdResponse);
        mAdResponses.remove(0);
    }

    private void initWebView()
    {
        mWebView = new YMWebView(mContext.getApplicationContext(), mAdClickHandler);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setHorizontalScrollbarOverlay(false);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setVerticalScrollbarOverlay(false);
        mWebView.getSettings().setSupportZoom(false);
        mWebView.getSettings().setJavaScriptEnabled(false);
        mWebView.setBackgroundColor(0);
        mWebViewClient = new YMWebViewClient(mWebView);
        mWebView.setWebViewClient(mWebViewClient);
    }

    private void requestAds()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isRequestingAd;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        isRequestingAd = true;
        OnAdReceiveListener onadreceivelistener = new OnAdReceiveListener() {

            final AdBannerView this$0;

            public void onAdFail(String s)
            {
                Log.e("AdFail:", s);
            }

            public void onAdReceive(List list)
            {
                if (list.size() > 0)
                {
                    mAdResponses = (ArrayList)list;
                    for (int i = 0; i < mAdResponses.size(); i++)
                    {
                        list = (AdResponse)mAdResponses.get(i);
                        if (Utils.isInstalled(mContext, list.getPackageName()))
                        {
                            mAdResponses.remove(i);
                        }
                        if (PRELOAD && list.preload())
                        {
                            UrlResolutionTask.getResolvedUrl(list.getClickDestinationUrl(), list. new com.yeahmobi.android.common.UrlResolutionTask.UrlResolutionListener() {

                                final _cls3 this$1;
                                final AdResponse val$ad;

                                public void onFailure()
                                {
                                }

                                public void onSuccess(String s)
                                {
                                    ad.setClickTrackUrl(s);
                                }

            
            {
                this$1 = final__pcls3;
                ad = AdResponse.this;
                super();
            }
                            });
                        }
                    }

                    flushAds();
                    isRequestingAd = false;
                }
            }

            
            {
                this$0 = AdBannerView.this;
                super();
            }
        };
        adManager = new AdManager(mContext);
        adManager.setAppId(Long.valueOf(appId).longValue());
        adManager.setSlotId(Long.valueOf(slotId).longValue());
        adManager.setAdNum(adNum);
        adManager.setAdReceiveListener(onadreceivelistener);
        if (!PRELOAD)
        {
            break; /* Loop/switch isn't completed */
        }
        adManager.setCallType(22);
_L4:
        adManager.setShowType(20);
        adManager.loadAd();
        if (true) goto _L1; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        adManager.setCallType(21);
          goto _L4
    }

    private void setup(Context context)
    {
        slotId = AdInterfaces.mSlotId;
        appId = AdInterfaces.mAppId;
        adNum = AdInterfaces.mAdNum;
        adView = this;
        mContext = context;
        mAdClickHandler = new AdClickHandler(context);
        initWebView();
        requestAds();
        flushTimer = new Timer();
        flushTimer.schedule(new TimerTask() {

            final AdBannerView this$0;

            public void run()
            {
                flushAds();
            }

            
            {
                this$0 = AdBannerView.this;
                super();
            }
        }, 0L, MONITOR_INV);
    }






/*
    static ArrayList access$202(AdBannerView adbannerview, ArrayList arraylist)
    {
        adbannerview.mAdResponses = arraylist;
        return arraylist;
    }

*/




/*
    static boolean access$502(AdBannerView adbannerview, boolean flag)
    {
        adbannerview.isRequestingAd = flag;
        return flag;
    }

*/
}
