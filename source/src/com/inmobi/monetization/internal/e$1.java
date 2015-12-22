// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;

// Referenced classes of package com.inmobi.monetization.internal:
//            e

class a extends WebViewClient
{

    final e a;

    public void onPageFinished(WebView webview, String s)
    {
        Log.internal("[InMobi]-[Monetization]", "Native ad context code loaded");
        e.a(a, true);
        if (e.a(a) != null && !e.a(a).isEmpty())
        {
            for (int i = 0; i < e.a(a).size(); i++)
            {
                a.b((String)e.a(a).get(i));
            }

            e.a(a).clear();
            e.a(a, null);
        }
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
