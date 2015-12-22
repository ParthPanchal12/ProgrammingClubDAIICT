// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.yeahmobi.android.common.util.AsyncTasks;
import com.yeahmobi.android.common.util.DateAndTime;
import com.yeahmobi.android.common.util.DeviceUtils;
import com.yeahmobi.android.common.util.IntentUtils;
import com.yeahmobi.android.common.util.YMLog;
import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.common:
//            AdCommonTask, IAdInfo, AdManager

public class AdClickHandler
{
    private static final class ClickDestinationUrlResolutionListener
        implements UrlResolutionTask.UrlResolutionListener
    {

        private final SoftReference mAdClickHandler;

        public void onFailure()
        {
            YMLog.d("Failed to resolve URL for click.");
        }

        public void onSuccess(String s)
        {
            YMLog.d((new StringBuilder()).append("Success to resolve URL for : ").append(s).toString());
            if (mAdClickHandler != null && mAdClickHandler.get() != null)
            {
                ((AdClickHandler)mAdClickHandler.get()).visitUrl(s);
            }
        }

        public ClickDestinationUrlResolutionListener(AdClickHandler adclickhandler)
        {
            mAdClickHandler = new SoftReference(adclickhandler);
        }
    }


    public static final String GOOGLE_PLAY_PACKAGENAME = "com.android.vending";
    private int TIME_OUT;
    private WebView clickWebView;
    private boolean findDest;
    private RelativeLayout jumpView;
    private IAdInfo mAdInfo;
    private final Context mContext;
    private ProgressBar mProgressBar;
    private Handler timeoutHandler;
    private Runnable timeoutRunnable;
    private WindowManager wManager;
    private boolean webViewShow;

    public AdClickHandler(Context context)
    {
        TIME_OUT = 15;
        mContext = context;
        findDest = false;
        jumpView = new RelativeLayout(context);
        jumpView.setGravity(16);
        clickWebView = new WebView(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        clickWebView.setLayoutParams(layoutparams);
        clickWebView.setOnKeyListener(new android.view.View.OnKeyListener() {

            final AdClickHandler this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                switch (i)
                {
                default:
                    return false;

                case 4: // '\004'
                    onFailGetTargetUrl();
                    break;
                }
                return true;
            }

            
            {
                this$0 = AdClickHandler.this;
                super();
            }
        });
        jumpView.addView(clickWebView);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        mProgressBar = new ProgressBar(context);
        mProgressBar.setLayoutParams(layoutparams);
        jumpView.addView(mProgressBar);
        clickWebView.getSettings().setJavaScriptEnabled(true);
        clickWebView.setWebViewClient(new WebViewClient() {

            final AdClickHandler this$0;

            public void onPageFinished(WebView webview, String s)
            {
                if (mProgressBar != null)
                {
                    mProgressBar.setVisibility(4);
                }
                super.onPageFinished(webview, s);
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                onFailGetTargetUrl();
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s != null)
                {
                    AdClickHandler adclickhandler = AdClickHandler.this;
                    boolean flag;
                    if (IntentUtils.isAppStoreUrl(s) || IntentUtils.isDeepLink(s))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    adclickhandler.findDest = flag;
                    if (findDest)
                    {
                        onSuccessGetTargetUrl(s);
                        return true;
                    }
                    if (webview != null)
                    {
                        webview.loadUrl(s);
                        return false;
                    }
                }
                return false;
            }

            
            {
                this$0 = AdClickHandler.this;
                super();
            }
        });
        timeoutRunnable = new Runnable() {

            final AdClickHandler this$0;

            public void run()
            {
                onFailGetTargetUrl();
            }

            
            {
                this$0 = AdClickHandler.this;
                super();
            }
        };
    }

    private void onFailGetTargetUrl()
    {
        if (jumpView != null && jumpView.getParent() != null)
        {
            wManager.removeView(jumpView);
        }
        if (clickWebView != null)
        {
            clickWebView.stopLoading();
        }
    }

    private void onSuccessGetTargetUrl(String s)
    {
        visitUrl(s);
    }

    public static void sendTrackOutside(String s, Context context)
    {
        AdCommonTask adcommontask;
        Log.d("AdViewController", (new StringBuilder()).append("Track for:").append(s).toString());
        if (!DeviceUtils.isNetworkAvailable(context))
        {
            Log.i("AdClickHandler", "Network not available,cancel sendTrackOutside");
            return;
        }
        adcommontask = new AdCommonTask();
        AsyncTasks.safeExecuteOnExecutor(adcommontask, new String[] {
            s
        });
        updateAdInfoForShef(context, "", "");
        return;
        s;
        Log.d("AdClickHandler", "Error executing sendTrackOutside", s);
        updateAdInfoForShef(context, "", "");
        return;
        s;
        updateAdInfoForShef(context, "", "");
        throw s;
    }

    private static void updateAdInfoForShef(Context context, String s, String s1)
    {
        try
        {
            context = context.getSharedPreferences("YMAdInfo", 0).edit();
            context.putString("downPackageName", s);
            context.putString("conversionTrackUrl", s1);
            context.putLong("conversionRecordTime", Math.abs(DateAndTime.now().getTime()));
            context.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("AdClickHandler", "Error executing updateAdInfoForShef", context);
        }
    }

    public void checkAppInstall()
    {
        String s = mAdInfo.getPackageName();
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        if (AdManager.checkExistApp(mContext, s))
        {
            Log.d("AdClickHandler", (new StringBuilder()).append("App has been installed for: ").append(s).toString());
            return;
        } else
        {
            updateAdInfoForShef(mContext, mAdInfo.getPackageName(), mAdInfo.getConversionTrackUrl());
            return;
        }
    }

    public IAdInfo getmAdInfo()
    {
        return mAdInfo;
    }

    public boolean isWebViewShow()
    {
        return webViewShow;
    }

    public void jumpToClickDestinationUrl()
    {
        if (mAdInfo != null && mContext != null)
        {
            timeoutHandler = new Handler();
            timeoutHandler.postDelayed(timeoutRunnable, TIME_OUT * 1000);
            if (!TextUtils.isEmpty(mAdInfo.getClickRecordUrl()))
            {
                sendEventToTrackUrl(mAdInfo.getClickRecordUrl());
            }
            String s = mAdInfo.getClickDestinationUrl();
            if (!TextUtils.isEmpty(s))
            {
                if (IntentUtils.isAppStoreUrl(s) || IntentUtils.isDeepLink(s))
                {
                    visitUrl(s);
                    return;
                } else
                {
                    jumpToTargetUrl(mAdInfo.getClickDestinationUrl());
                    return;
                }
            }
        }
    }

    public void jumpToTargetUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        if (webViewShow)
        {
            android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
            layoutparams.height = -1;
            layoutparams.width = -1;
            layoutparams.gravity = 17;
            wManager = (WindowManager)mContext.getSystemService("window");
            wManager.addView(jumpView, layoutparams);
            clickWebView.setVisibility(0);
            mProgressBar.setVisibility(0);
        }
        clickWebView.loadUrl(s);
    }

    public void sendConversionTrack()
    {
        if (mAdInfo != null && !"".equals(mAdInfo.getConversionTrackUrl()))
        {
            sendEventToTrackUrl(mAdInfo.getConversionTrackUrl());
        }
    }

    public void sendEventToTrackUrl(String s)
    {
        Log.d("AdViewController", (new StringBuilder()).append("Track for:").append(s).toString());
        if (!DeviceUtils.isNetworkAvailable(mContext))
        {
            Log.i("AdClickHandler", "Network not available,cancel sendEventToTrackUrl");
            return;
        }
        AdCommonTask adcommontask = new AdCommonTask();
        try
        {
            AsyncTasks.safeExecuteOnExecutor(adcommontask, new String[] {
                s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("AdClickHandler", "Error executing sendEventToTrackUrl", s);
        }
    }

    public void sendImpressionTrack()
    {
        if (mAdInfo != null && !"".equals(mAdInfo.getImpressionTrackUrl()))
        {
            sendEventToTrackUrl(mAdInfo.getImpressionTrackUrl());
        }
    }

    public void setAdInfo(IAdInfo iadinfo)
    {
        mAdInfo = iadinfo;
    }

    public void setWebViewShow(boolean flag)
    {
        webViewShow = flag;
    }

    public void visitUrl(String s)
    {
        Intent intent;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        flag = false;
        if (!IntentUtils.isAppStoreUrl(s))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addFlags(0x800000);
        intent.addFlags(0x10000000);
        intent.addFlags(0x40000000);
        intent.addFlags(0x10000);
        Iterator iterator = mContext.getPackageManager().queryIntentActivities(intent, 0x10000).iterator();
_L2:
        flag2 = flag;
        flag1 = flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        flag2 = flag;
        if (!((ResolveInfo)iterator.next()).activityInfo.packageName.equals("com.android.vending")) goto _L2; else goto _L1
_L1:
        flag2 = flag;
        intent.setPackage("com.android.vending");
        flag2 = flag;
        mContext.startActivity(intent);
        flag2 = flag;
        ((Activity)mContext).overridePendingTransition(0, 0);
        flag = true;
          goto _L2
        Exception exception;
        exception;
        exception.printStackTrace();
        flag1 = flag2;
        if (!flag1)
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            s.addFlags(0x800000);
            s.addFlags(0x10000000);
            s.addFlags(0x40000000);
            s.addFlags(0x10000);
            mContext.startActivity(s);
        }
        if (webViewShow && jumpView.getParent() != null)
        {
            wManager.removeView(jumpView);
        }
        return;
    }




/*
    static boolean access$102(AdClickHandler adclickhandler, boolean flag)
    {
        adclickhandler.findDest = flag;
        return flag;
    }

*/


}
