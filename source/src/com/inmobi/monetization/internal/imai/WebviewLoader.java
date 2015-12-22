// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            RequestResponseManager

public class WebviewLoader
{
    protected static class MyWebViewClient extends WebViewClient
    {

        public void onPageFinished(WebView webview, String s)
        {
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("On page Finished ").append(s).toString());
            if (!WebviewLoader.b.compareAndSet(true, false))
            {
                break MISSING_BLOCK_LABEL_56;
            }
            RequestResponseManager.c.set(true);
            synchronized (RequestResponseManager.a)
            {
                RequestResponseManager.a.notify();
            }
            try
            {
                super.onPageFinished(webview, s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Log.internal("[InMobi]-[Monetization]", "Exception onPageFinished", webview);
            }
            break MISSING_BLOCK_LABEL_77;
            webview;
            thread;
            JVM INSTR monitorexit ;
            throw webview;
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Processing click in webview error ").append(i).append(" Failing url: ").append(s1).append("Error description ").append(s).toString());
            WebviewLoader.b.set(false);
            RequestResponseManager.c.set(false);
            super.onReceivedError(webview, i, s, s1);
            synchronized (RequestResponseManager.a)
            {
                RequestResponseManager.a.notify();
            }
            return;
            s;
            webview;
            JVM INSTR monitorexit ;
            try
            {
                throw s;
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Log.internal("[InMobi]-[Monetization]", "Exception onReceived error callback webview", webview);
            }
            return;
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("SSL Error.Webview will proceed ").append(sslerror).toString());
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Should override ").append(s).toString());
            webview.loadUrl(s);
            return true;
        }

        protected MyWebViewClient()
        {
        }
    }


    static boolean a = false;
    static AtomicBoolean b = null;
    private WebView c;

    public WebviewLoader(Context context)
    {
        c = null;
        RequestResponseManager.b.post(new Runnable(context) {

            final Context a;
            final WebviewLoader b;

            public void run()
            {
                try
                {
                    WebviewLoader.a(b, new WebView(a));
                    WebviewLoader.b = new AtomicBoolean(false);
                    WebviewLoader.a(b).setWebViewClient(new MyWebViewClient());
                    WebviewLoader.a(b).getSettings().setJavaScriptEnabled(true);
                    WebviewLoader.a(b).getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON);
                    WebviewLoader.a(b).getSettings().setCacheMode(2);
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[Monetization]", "Exception init webview", exception);
                }
            }

            
            {
                b = WebviewLoader.this;
                a = context;
                super();
            }
        });
    }

    static WebView a(WebviewLoader webviewloader)
    {
        return webviewloader.c;
    }

    static WebView a(WebviewLoader webviewloader, WebView webview)
    {
        webviewloader.c = webview;
        return webview;
    }

    public void deinit(int i)
    {
        RequestResponseManager.b.postDelayed(new Runnable() {

            final WebviewLoader a;

            public void run()
            {
                try
                {
                    if (WebviewLoader.a(a) != null)
                    {
                        WebviewLoader.a(a).stopLoading();
                        WebviewLoader.a(a).destroy();
                        WebviewLoader.a(a, null);
                        WebviewLoader.b.set(false);
                    }
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[Monetization]", "Exception deinit webview ", exception);
                }
            }

            
            {
                a = WebviewLoader.this;
                super();
            }
        }, i);
    }

    public void loadInWebview(String s, HashMap hashmap)
    {
        RequestResponseManager.b.post(new Runnable(s, hashmap) {

            final String a;
            final HashMap b;
            final WebviewLoader c;

            public void run()
            {
                try
                {
                    WebviewLoader.b.set(true);
                    WebviewLoader.a(c).loadUrl(a, b);
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[Monetization]", "Exception load in webview", exception);
                }
            }

            
            {
                c = WebviewLoader.this;
                a = s;
                b = hashmap;
                super();
            }
        });
    }

    public void stopLoading()
    {
        RequestResponseManager.b.post(new Runnable() {

            final WebviewLoader a;

            public void run()
            {
                try
                {
                    if (WebviewLoader.a(a) != null)
                    {
                        WebviewLoader.b.set(false);
                    }
                    WebviewLoader.a(a).stopLoading();
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[Monetization]", "Exception stop loading", exception);
                }
            }

            
            {
                a = WebviewLoader.this;
                super();
            }
        });
    }

}
