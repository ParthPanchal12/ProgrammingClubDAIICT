// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;
import com.inmobi.monetization.internal.imai.db.ClickDatabaseManager;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import java.util.Random;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            RequestResponseManager, IMAIClickEventList

public class IMAICore
{

    static Random a = new Random();

    public IMAICore()
    {
    }

    public static void fireErrorEvent(WeakReference weakreference, String s, String s1, String s2)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Fire error event IMAI for action: ").append(s1).append(" ").append(s).toString());
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder()).append("window._im_imai.broadcastEvent('error','").append(s).append("'").append(",'").append(s1).append("'").append(",'").append(s2).append("'").append(")").toString());
        }
        return;
        weakreference;
        Log.internal("[InMobi]-[Monetization]", "Exception", weakreference);
        return;
    }

    public static void fireOpenEmbeddedSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Monetization]", "fireOpenEmbeddedSuccessful");
            if (!((IMWebView)weakreference.get()).mWebViewIsBrowserActivity && !((IMWebView)weakreference.get()).mIsInterstitialAd)
            {
                IMBrowserActivity.requestOnAdDismiss(((IMWebView)weakreference.get()).getWebviewHandler().obtainMessage(((IMWebView)weakreference.get()).getDismissMessage()));
                ((IMWebView)weakreference.get()).fireOnShowAdScreen();
            }
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder()).append("window._im_imai.broadcastEvent('openEmbeddedSuccessful','").append(s).append("')").toString());
        }
        return;
        weakreference;
        Log.internal("[InMobi]-[Monetization]", "Exception", weakreference);
        return;
    }

    public static void fireOpenExternalSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Monetization]", "fireOpenExternalSuccessful");
            ((IMWebView)weakreference.get()).fireOnLeaveApplication();
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder()).append("window._im_imai.broadcastEvent('openExternalSuccessful','").append(s).append("')").toString());
        }
        return;
        weakreference;
        Log.internal("[InMobi]-[Monetization]", "Exception", weakreference);
        return;
    }

    public static void firePingInWebViewSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Monetization]", "firePingInWebViewSuccessful");
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder()).append("window._im_imai.broadcastEvent('pingInWebViewSuccessful','").append(s).append("')").toString());
        }
        return;
        weakreference;
        Log.internal("[InMobi]-[Monetization]", "Exception", weakreference);
        return;
    }

    public static void firePingSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Monetization]", "firePingSuccessful");
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder()).append("window._im_imai.broadcastEvent('pingSuccessful','").append(s).append("')").toString());
        }
        return;
        weakreference;
        Log.internal("[InMobi]-[Monetization]", "Exception", weakreference);
        return;
    }

    public static int getRandomNumber()
    {
        return a.nextInt();
    }

    public static void initialize()
    {
        (new RequestResponseManager()).init();
        ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
    }

    public static void injectJavaScript(IMWebView imwebview, String s)
    {
        try
        {
            imwebview.getActivity().runOnUiThread(new Runnable(imwebview, s) {

                final IMWebView a;
                final String b;

                public void run()
                {
                    a.injectJavaScript(b);
                }

            
            {
                a = imwebview;
                b = s;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IMWebView imwebview)
        {
            Log.internal("[InMobi]-[Monetization]", "Error injecting javascript ", imwebview);
        }
    }

    public static void launchEmbeddedBrowser(WeakReference weakreference, String s)
    {
        Intent intent = new Intent(((IMWebView)weakreference.get()).getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
        intent.putExtra("extra_url", s);
        intent.putExtra("extra_browser_type", 100);
        intent.setFlags(0x10000000);
        IMBrowserActivity.setWebViewListener(((IMWebView)weakreference.get()).mListener);
        if (!((IMWebView)weakreference.get()).mWebViewIsBrowserActivity && !((IMWebView)weakreference.get()).mIsInterstitialAd && ((IMWebView)weakreference.get()).getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.DEFAULT)
        {
            intent.putExtra("FIRST_INSTANCE", true);
        }
        ((IMWebView)weakreference.get()).getActivity().getApplicationContext().startActivity(intent);
    }

    public static void launchExternalApp(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        intent.setFlags(0x10000000);
        InternalSDKUtil.getContext().startActivity(intent);
    }

    public static void ping(WeakReference weakreference, String s, boolean flag)
    {
        try
        {
            ((IMWebView)weakreference.get()).getActivity().runOnUiThread(new Runnable(s, flag, weakreference) {

                final String a;
                final boolean b;
                final WeakReference c;

                public void run()
                {
                    try
                    {
                        int i = Initializer.getConfigParams().getImai().getMaxRetry();
                        ClickData clickdata = new ClickData(a, b, false, i);
                        RequestResponseManager requestresponsemanager = new RequestResponseManager();
                        requestresponsemanager.init();
                        RequestResponseManager.mNetworkQueue.add(0, clickdata);
                        requestresponsemanager.processClick(InternalSDKUtil.getContext(), new com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback(this) {

                            final _cls2 a;

                            public void notifyResult(int i, Object obj)
                            {
                                Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Got PING callback. Status: ").append(i).toString());
                                if (i == 0)
                                {
                                    try
                                    {
                                        IMAICore.firePingSuccessful(a.c, a.a);
                                        return;
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (Object obj)
                                    {
                                        Log.internal("[InMobi]-[Monetization]", "Exception", ((Throwable) (obj)));
                                    }
                                    break MISSING_BLOCK_LABEL_77;
                                }
                                IMAICore.fireErrorEvent(a.c, "IMAI Ping in http client failed", "ping", a.a);
                                return;
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.internal("[InMobi]-[Monetization]", "Exception ping in background", exception);
                    }
                }

            
            {
                a = s;
                b = flag;
                c = weakreference;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WeakReference weakreference)
        {
            Log.internal("[InMobi]-[Monetization]", "Failed to ping", weakreference);
        }
    }

    public static void pingInWebview(WeakReference weakreference, String s, boolean flag)
    {
        try
        {
            ((IMWebView)weakreference.get()).getActivity().runOnUiThread(new Runnable(s, flag, weakreference) {

                final String a;
                final boolean b;
                final WeakReference c;

                public void run()
                {
                    try
                    {
                        int i = Initializer.getConfigParams().getImai().getMaxRetry();
                        ClickData clickdata = new ClickData(a, b, true, i);
                        RequestResponseManager requestresponsemanager = new RequestResponseManager();
                        requestresponsemanager.init();
                        RequestResponseManager.mNetworkQueue.add(0, clickdata);
                        requestresponsemanager.processClick(InternalSDKUtil.getContext(), new com.inmobi.commons.analytics.net.AnalyticsCommon.HttpRequestCallback(this) {

                            final _cls3 a;

                            public void notifyResult(int i, Object obj)
                            {
                                Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Got PING IN WEBVIEW callback. Status: ").append(i).toString());
                                if (i == 0)
                                {
                                    try
                                    {
                                        IMAICore.firePingInWebViewSuccessful(a.c, a.a);
                                        return;
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (Object obj)
                                    {
                                        Log.internal("[InMobi]-[Monetization]", "Exception", ((Throwable) (obj)));
                                    }
                                    break MISSING_BLOCK_LABEL_77;
                                }
                                IMAICore.fireErrorEvent(a.c, "IMAI Ping in webview failed", "pingInWebview", a.a);
                                return;
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.internal("[InMobi]-[Monetization]", "Exception ping in background", exception);
                    }
                }

            
            {
                a = s;
                b = flag;
                c = weakreference;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WeakReference weakreference)
        {
            Log.internal("[InMobi]-[Monetization]", "Failed to ping in webview", weakreference);
        }
    }

    public static boolean validateURL(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.internal("[InMobi]-[Monetization]", "Null url passed");
            return false;
        } else
        {
            return true;
        }
    }

}
