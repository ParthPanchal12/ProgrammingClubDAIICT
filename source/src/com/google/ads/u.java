// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o, ae, n

public class u
    implements o
{

    public u()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        hashmap = (String)hashmap.get("u");
        if (TextUtils.isEmpty(hashmap))
        {
            b.e("Could not get URL from track gmsg.");
            return;
        } else
        {
            (new Thread(new ae(hashmap, (Context)d1.i().f.a()))).start();
            return;
        }
    }
}
