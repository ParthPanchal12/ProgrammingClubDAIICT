// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o

public class p
    implements o
{

    public p()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        webview = (String)hashmap.get("name");
        if (webview == null)
        {
            b.b("Error: App event with no name parameter.");
            return;
        } else
        {
            d1.a(webview, (String)hashmap.get("info"));
            return;
        }
    }
}
