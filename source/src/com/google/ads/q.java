// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o

public class q
    implements o
{

    private static final a a;

    public q()
    {
    }

    public void a(d d, HashMap hashmap, WebView webview)
    {
        d = (String)hashmap.get("urls");
        if (d == null)
        {
            b.e("Could not get the urls param from canOpenURLs gmsg.");
            return;
        }
        hashmap = d.split(",");
        HashMap hashmap1 = new HashMap();
        PackageManager packagemanager = webview.getContext().getPackageManager();
        int j = hashmap.length;
        int i = 0;
        while (i < j) 
        {
            String s = hashmap[i];
            d = s.split(";", 2);
            String s1 = d[0];
            boolean flag;
            if (d.length >= 2)
            {
                d = d[1];
            } else
            {
                d = "android.intent.action.VIEW";
            }
            if (packagemanager.resolveActivity(new Intent(d, Uri.parse(s1)), 0x10000) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hashmap1.put(s, Boolean.valueOf(flag));
            i++;
        }
        a.a(webview, hashmap1);
    }

    static 
    {
        a = (a)a.a.b();
    }
}
