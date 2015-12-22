// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.webkit.WebView;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader

class a
    implements Runnable
{

    final AdTrackerWebViewLoader a;

    public void run()
    {
        if (AdTrackerWebViewLoader.a(a) != null)
        {
            AdTrackerWebViewLoader.a(a).stopLoading();
            AdTrackerWebViewLoader.a(a).destroy();
        }
    }

    (AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        a = adtrackerwebviewloader;
        super();
    }
}
