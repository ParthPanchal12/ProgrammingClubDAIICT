// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.internal.InternalSDKUtil;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader

class a
    implements Runnable
{

    final AdTrackerWebViewLoader a;

    public void run()
    {
        AdTrackerWebViewLoader.a(a, new WebView(InternalSDKUtil.getContext()));
        AdTrackerWebViewLoader.a(a).setWebViewClient(new TrackerWebViewClient(a));
        AdTrackerWebViewLoader.a(a).getSettings().setJavaScriptEnabled(true);
        AdTrackerWebViewLoader.a(a).getSettings().setCacheMode(2);
        AdTrackerWebViewLoader.a(a).addJavascriptInterface(new Interface(), "iatsdk");
    }

    Interface(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        a = adtrackerwebviewloader;
        super();
    }
}
