// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o, AdActivity

public class ac
    implements o
{

    private static final a a;

    public ac()
    {
    }

    protected int a(HashMap hashmap, String s, int i, DisplayMetrics displaymetrics)
    {
        hashmap = (String)hashmap.get(s);
        int j = i;
        if (hashmap != null)
        {
            float f1;
            try
            {
                f1 = TypedValue.applyDimension(1, Integer.parseInt(hashmap), displaymetrics);
            }
            // Misplaced declaration of an exception variable
            catch (DisplayMetrics displaymetrics)
            {
                b.a((new StringBuilder()).append("Could not parse \"").append(s).append("\" in a video gmsg: ").append(hashmap).toString());
                return i;
            }
            j = (int)f1;
        }
        return j;
    }

    public void a(d d, HashMap hashmap, WebView webview)
    {
        String s = (String)hashmap.get("action");
        if (s == null)
        {
            b.a("No \"action\" parameter in a video gmsg.");
            return;
        }
        AdWebView adwebview;
        if (webview instanceof AdWebView)
        {
            adwebview = (AdWebView)webview;
            webview = adwebview.i();
            if (webview == null)
            {
                b.a("Could not get adActivity for a video gmsg.");
                return;
            }
        } else
        {
            b.a("Could not get adWebView for a video gmsg.");
            return;
        }
        boolean flag = s.equals("new");
        boolean flag1 = s.equals("position");
        if (flag || flag1)
        {
            d = AdUtil.a(webview);
            int i = a(hashmap, "x", 0, ((DisplayMetrics) (d)));
            int k = a(hashmap, "y", 0, ((DisplayMetrics) (d)));
            int i1 = a(hashmap, "w", -1, ((DisplayMetrics) (d)));
            int j1 = a(hashmap, "h", -1, ((DisplayMetrics) (d)));
            if (flag && webview.getAdVideoView() == null)
            {
                webview.newAdVideoView(i, k, i1, j1);
                return;
            } else
            {
                webview.moveAdVideoView(i, k, i1, j1);
                return;
            }
        }
        d = webview.getAdVideoView();
        if (d == null)
        {
            a.a(adwebview, "onVideoEvent", "{'event': 'error', 'what': 'no_video_view'}");
            return;
        }
        if (s.equals("click"))
        {
            webview = AdUtil.a(webview);
            int j = a(hashmap, "x", 0, ((DisplayMetrics) (webview)));
            int l = a(hashmap, "y", 0, ((DisplayMetrics) (webview)));
            long l1 = SystemClock.uptimeMillis();
            d.a(MotionEvent.obtain(l1, l1, 0, j, l, 0));
            return;
        }
        if (s.equals("controls"))
        {
            hashmap = (String)hashmap.get("enabled");
            if (hashmap == null)
            {
                b.a("No \"enabled\" parameter in a controls video gmsg.");
                return;
            }
            if (hashmap.equals("true"))
            {
                d.setMediaControllerEnabled(true);
                return;
            } else
            {
                d.setMediaControllerEnabled(false);
                return;
            }
        }
        if (s.equals("currentTime"))
        {
            hashmap = (String)hashmap.get("time");
            if (hashmap == null)
            {
                b.a("No \"time\" parameter in a currentTime video gmsg.");
                return;
            }
            try
            {
                d.a((int)(Float.parseFloat(hashmap) * 1000F));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (d d)
            {
                b.a((new StringBuilder()).append("Could not parse \"time\" parameter: ").append(hashmap).toString());
            }
            return;
        }
        if (s.equals("hide"))
        {
            d.setVisibility(4);
            return;
        }
        if (s.equals("load"))
        {
            d.b();
            return;
        }
        if (s.equals("pause"))
        {
            d.c();
            return;
        }
        if (s.equals("play"))
        {
            d.d();
            return;
        }
        if (s.equals("show"))
        {
            d.setVisibility(0);
            return;
        }
        if (s.equals("src"))
        {
            d.setSrc((String)hashmap.get("src"));
            return;
        } else
        {
            b.a((new StringBuilder()).append("Unknown video action: ").append(s).toString());
            return;
        }
    }

    static 
    {
        a = (a)a.a.b();
    }
}
