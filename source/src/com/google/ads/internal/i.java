// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.al;
import com.google.ads.am;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.ads.internal:
//            a, d, c, e

public class i extends WebViewClient
{

    private static final a c;
    protected d a;
    protected boolean b;
    private final Map d;
    private final boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    public i(d d1, Map map, boolean flag, boolean flag1)
    {
        a = d1;
        d = map;
        e = flag;
        g = flag1;
        b = false;
        h = false;
        i = false;
    }

    public static i a(d d1, Map map, boolean flag, boolean flag1)
    {
        if (AdUtil.a >= 11)
        {
            return new com.google.ads.util.g.b(d1, map, flag, flag1);
        } else
        {
            return new i(d1, map, flag, flag1);
        }
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public boolean a()
    {
        return f;
    }

    public void b(boolean flag)
    {
        g = flag;
    }

    public void c(boolean flag)
    {
        h = flag;
    }

    public void d(boolean flag)
    {
        i = flag;
    }

    public void onPageFinished(WebView webview, String s)
    {
        f = false;
        if (h)
        {
            s = a.k();
            if (s != null)
            {
                s.c();
            } else
            {
                com.google.ads.util.b.a("adLoader was null while trying to setFinishedLoadingHtml().");
            }
            h = false;
        }
        if (i)
        {
            c.a(webview);
            i = false;
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        f = true;
    }

    public void onReceivedError(WebView webview, int j, String s, String s1)
    {
        f = false;
        webview = a.k();
        if (webview != null)
        {
            webview.a(com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Uri uri;
        com.google.ads.util.b.a((new StringBuilder()).append("shouldOverrideUrlLoading(\"").append(s).append("\")").toString());
        uri = Uri.parse(s);
        if (!c.a(uri))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        c.a(a, d, uri, webview);
        return true;
        if (!g)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (AdUtil.a(uri))
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
        webview = new HashMap();
        webview.put("u", s);
        AdActivity.launchAdActivity(a, new e("intent", webview));
        return true;
        boolean flag = e;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = a.i();
        webview = (Context)((n) (obj)).f.a();
        obj = (al)((n) (obj)).s.a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        if (!((al) (obj)).a(uri))
        {
            break MISSING_BLOCK_LABEL_281;
        }
        webview = ((al) (obj)).a(uri, webview);
_L3:
        s = new HashMap();
        s.put("u", webview.toString());
        AdActivity.launchAdActivity(a, new e("intent", s));
        return true;
        webview;
        com.google.ads.util.b.e((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
        break MISSING_BLOCK_LABEL_281;
_L2:
        try
        {
            com.google.ads.util.b.e((new StringBuilder()).append("URL is not a GMSG and can't handle URL: ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            com.google.ads.util.b.d("An unknown error occurred in shouldOverrideUrlLoading.", webview);
        }
        return true;
        webview = uri;
          goto _L3
    }

    static 
    {
        c = (a)a.a.b();
    }
}
