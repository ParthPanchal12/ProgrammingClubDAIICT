// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o

public class v
    implements o
{

    public v()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        webview = (String)hashmap.get("type");
        hashmap = (String)hashmap.get("errors");
        b.e((new StringBuilder()).append("Invalid ").append(webview).append(" request error: ").append(hashmap).toString());
        d1 = d1.k();
        if (d1 != null)
        {
            d1.a(AdRequest.ErrorCode.INVALID_REQUEST);
        }
    }
}
