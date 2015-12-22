// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.banner;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.SoftReference;

// Referenced classes of package com.yeahmobi.android.banner:
//            AdBannerView

private class mWebView extends WebViewClient
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

    (WebView webview)
    {
        this$0 = AdBannerView.this;
        super();
        mWebView = new SoftReference(webview);
    }
}
