// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader, AdTrackerNetworkInterface

protected final class a extends WebViewClient
{

    final AdTrackerWebViewLoader a;

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        webview = AdTrackerNetworkInterface.c();
        if (webview != null && webview.hasMessages(9))
        {
            webview.removeMessages(9);
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Webview Received Error");
            s = Message.obtain();
            s.what = 10;
            s.arg2 = i;
            s.obj = AdTrackerWebViewLoader.c(a);
            webview.sendMessage(s);
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        webview = AdTrackerNetworkInterface.c();
        if (webview.hasMessages(9))
        {
            webview.removeMessages(9);
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Webview Received SSL Error");
            sslerrorhandler = Message.obtain();
            sslerrorhandler.what = 10;
            sslerrorhandler.arg2 = sslerror.getPrimaryError();
            sslerrorhandler.obj = AdTrackerWebViewLoader.c(a);
            webview.sendMessage(sslerrorhandler);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Handler handler = AdTrackerNetworkInterface.c();
        if (handler.hasMessages(9))
        {
            handler.removeMessages(9);
            AdTrackerWebViewLoader.b(a, System.currentTimeMillis() - AdTrackerWebViewLoader.b(a));
            if (s.contains("iat"))
            {
                Object obj = s.substring(7);
                obj = AdTrackerWebViewLoader.a(a, ((String) (obj)));
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "errcode", Integer.toString(a(((a) (obj)))));
                Message message = Message.obtain();
                message.what = 10;
                message.arg2 = a(((a) (obj)));
                message.obj = AdTrackerWebViewLoader.c(a);
                Bundle bundle = new Bundle();
                bundle.putString("appId", AdTrackerWebViewLoader.d(a));
                message.setData(bundle);
                if (5000 == a(((a) (obj))))
                {
                    int i = AdTrackerWebViewLoader.b(a, a(((a) (obj))));
                    if (6000 == i)
                    {
                        message.what = 8;
                        message.arg2 = (int)AdTrackerWebViewLoader.e(a);
                    } else
                    {
                        message.arg2 = i;
                    }
                }
                handler.sendMessage(message);
            }
        }
        webview.loadUrl(s);
        return true;
    }

    protected (AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        a = adtrackerwebviewloader;
        super();
    }
}
