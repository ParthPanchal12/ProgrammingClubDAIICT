// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.util.g;

public class com.facebook.ads.internal.view.b extends WebView
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i);

        public abstract void a(String s);
    }

    private class b extends WebViewClient
    {

        final com.facebook.ads.internal.view.b a;

        public void onLoadResource(WebView webview, String s)
        {
            com.facebook.ads.internal.view.b.a(a).a();
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            if (g.a())
            {
                sslerrorhandler.proceed();
                return;
            } else
            {
                sslerrorhandler.cancel();
                return;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            com.facebook.ads.internal.view.b.a(a).a(s);
            return true;
        }

        private b()
        {
            a = com.facebook.ads.internal.view.b.this;
            super();
        }

    }

    public static class c
    {

        private static final String a = com/facebook/ads/internal/view/b$c.getSimpleName();


        public c()
        {
        }
    }


    private final a a;

    public com.facebook.ads.internal.view.b(Context context, a a1)
    {
        super(context);
        a = a1;
        a();
    }

    static a a(com.facebook.ads.internal.view.b b1)
    {
        return b1.a;
    }

    private void a()
    {
        setWebViewClient(new b());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new c(), "AdControl");
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (a != null)
        {
            a.a(i);
        }
    }
}
