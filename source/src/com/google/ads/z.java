// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o

public class z
    implements o
{

    private AdActivity.StaticMethodWrapper a;

    public z()
    {
        this(new AdActivity.StaticMethodWrapper());
    }

    public z(AdActivity.StaticMethodWrapper staticmethodwrapper)
    {
        a = staticmethodwrapper;
    }

    public void a(d d, HashMap hashmap, WebView webview)
    {
        webview = (String)hashmap.get("a");
        if (webview == null)
        {
            b.a("Could not get the action parameter for open GMSG.");
            return;
        }
        if (webview.equals("webapp"))
        {
            a.launchAdActivity(d, new e("webapp", hashmap));
            return;
        }
        if (webview.equals("expand"))
        {
            a.launchAdActivity(d, new e("expand", hashmap));
            return;
        } else
        {
            a.launchAdActivity(d, new e("intent", hashmap));
            return;
        }
    }
}
