// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o

public class s
    implements o
{

    public s()
    {
    }

    public void a(d d, HashMap hashmap, WebView webview)
    {
        if (webview instanceof AdWebView)
        {
            ((AdWebView)webview).f();
            return;
        } else
        {
            b.b("Trying to close WebView that isn't an AdWebView");
            return;
        }
    }
}
