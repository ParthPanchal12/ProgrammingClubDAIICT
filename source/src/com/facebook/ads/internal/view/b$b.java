// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.util.g;

// Referenced classes of package com.facebook.ads.internal.view:
//            b

private class <init> extends WebViewClient
{

    final b a;

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

    private (b b1)
    {
        a = b1;
        super();
    }

    (b b1,  )
    {
        this(b1);
    }
}
