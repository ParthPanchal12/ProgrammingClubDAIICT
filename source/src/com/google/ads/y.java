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

public class y
    implements o
{

    public y()
    {
    }

    public void a(d d, HashMap hashmap, WebView webview)
    {
        d = (String)hashmap.get("string");
        hashmap = (String)hashmap.get("afma_notify_dt");
        b.c((new StringBuilder()).append("Received log message: <\"string\": \"").append(d).append("\", \"afmaNotifyDt\": \"").append(hashmap).append("\">").toString());
    }
}
