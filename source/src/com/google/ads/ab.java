// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o, n, ak

public class ab
    implements o
{

    public ab()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        if ((Activity)d1.i().c.a() != null) goto _L2; else goto _L1
_L1:
        b.e("Activity was null while responding to touch gmsg.");
_L4:
        return;
_L2:
        String s;
        webview = (String)hashmap.get("tx");
        s = (String)hashmap.get("ty");
        hashmap = (String)hashmap.get("td");
        int i;
        int j;
        int k;
        i = Integer.parseInt(webview);
        j = Integer.parseInt(s);
        k = Integer.parseInt(hashmap);
        d1 = (ak)d1.i().r.a();
        if (d1 != null)
        {
            try
            {
                d1.a(i, j, k);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                b.e("Could not parse touch parameters from gmsg.");
            }
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
