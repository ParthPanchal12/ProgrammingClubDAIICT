// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.yeahmobi.android.common.util.IntentUtils;

// Referenced classes of package com.yeahmobi.android.common:
//            AdClickHandler

class this._cls0 extends WebViewClient
{

    final AdClickHandler this$0;

    public void onPageFinished(WebView webview, String s)
    {
        if (AdClickHandler.access$300(AdClickHandler.this) != null)
        {
            AdClickHandler.access$300(AdClickHandler.this).setVisibility(4);
        }
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        AdClickHandler.access$000(AdClickHandler.this);
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
            AdClickHandler.access$102(adclickhandler, flag);
            if (AdClickHandler.access$100(AdClickHandler.this))
            {
                AdClickHandler.access$200(AdClickHandler.this, s);
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

    ()
    {
        this$0 = AdClickHandler.this;
        super();
    }
}
