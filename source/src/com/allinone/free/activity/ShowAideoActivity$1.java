// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.allinone.free.utils.ProgressWheel;

// Referenced classes of package com.allinone.free.activity:
//            ShowAideoActivity

class this._cls0 extends WebViewClient
{

    final ShowAideoActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        ShowAideoActivity.access$0(ShowAideoActivity.this).setVisibility(8);
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        ShowAideoActivity.access$0(ShowAideoActivity.this).setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    ()
    {
        this$0 = ShowAideoActivity.this;
        super();
    }
}
