// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.aa;
import com.google.ads.ab;
import com.google.ads.ac;
import com.google.ads.o;
import com.google.ads.p;
import com.google.ads.q;
import com.google.ads.r;
import com.google.ads.s;
import com.google.ads.t;
import com.google.ads.u;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import com.google.ads.v;
import com.google.ads.w;
import com.google.ads.x;
import com.google.ads.y;
import com.google.ads.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.ads.internal:
//            d

public class a
{

    public static final f a = new f() {

        public a a()
        {
            return a.a();
        }

        public Object b()
        {
            return a();
        }

    };
    public static final Map b = Collections.unmodifiableMap(new HashMap() {

            
            {
                put("/invalidRequest", new v());
                put("/loadAdURL", new w());
                put("/loadSdkConstants", new x());
                put("/log", new y());
            }
    });
    public static final Map c = Collections.unmodifiableMap(new HashMap() {

            
            {
                put("/log", new y());
                put("/setNativeActivationOverlay", new aa());
            }
    });
    public static final Map d = Collections.unmodifiableMap(new HashMap() {

            
            {
                put("/open", new z());
                put("/canOpenURLs", new q());
                put("/close", new s());
                put("/customClose", new t());
                put("/appEvent", new p());
                put("/log", new y());
                put("/click", new r());
                put("/httpTrack", new u());
                put("/touch", new ab());
                put("/video", new ac());
            }
    });
    private static final a e = new a();

    public a()
    {
    }

    static a a()
    {
        return e;
    }

    public String a(Uri uri, HashMap hashmap)
    {
        if (c(uri))
        {
            String s = uri.getHost();
            if (s == null)
            {
                com.google.ads.util.b.e("An error occurred while parsing the AMSG parameters.");
                return null;
            }
            if (s.equals("launch"))
            {
                hashmap.put("a", "intent");
                hashmap.put("u", hashmap.get("url"));
                hashmap.remove("url");
                return "/open";
            }
            if (s.equals("closecanvas"))
            {
                return "/close";
            }
            if (s.equals("log"))
            {
                return "/log";
            } else
            {
                com.google.ads.util.b.e((new StringBuilder()).append("An error occurred while parsing the AMSG: ").append(uri.toString()).toString());
                return null;
            }
        }
        if (b(uri))
        {
            return uri.getPath();
        } else
        {
            com.google.ads.util.b.e("Message was neither a GMSG nor an AMSG.");
            return null;
        }
    }

    public void a(WebView webview)
    {
        a(webview, "onshow", "{'version': 'afma-sdk-a-v6.4.1'}");
    }

    public void a(WebView webview, String s)
    {
        com.google.ads.util.b.a((new StringBuilder()).append("Sending JS to a WebView: ").append(s).toString());
        webview.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
    }

    public void a(WebView webview, String s, String s1)
    {
        if (s1 != null)
        {
            a(webview, (new StringBuilder()).append("AFMA_ReceiveMessage").append("('").append(s).append("', ").append(s1).append(");").toString());
            return;
        } else
        {
            a(webview, (new StringBuilder()).append("AFMA_ReceiveMessage").append("('").append(s).append("');").toString());
            return;
        }
    }

    public void a(WebView webview, Map map)
    {
        a(webview, "openableURLs", (new JSONObject(map)).toString());
    }

    public void a(d d1, Map map, Uri uri, WebView webview)
    {
        HashMap hashmap = AdUtil.b(uri);
        if (hashmap == null)
        {
            com.google.ads.util.b.e("An error occurred while parsing the message parameters.");
            return;
        }
        uri = a(uri, hashmap);
        if (uri == null)
        {
            com.google.ads.util.b.e("An error occurred while parsing the message.");
            return;
        }
        map = (o)map.get(uri);
        if (map == null)
        {
            com.google.ads.util.b.e((new StringBuilder()).append("No AdResponse found, <message: ").append(uri).append(">").toString());
            return;
        } else
        {
            map.a(d1, hashmap, webview);
            return;
        }
    }

    public boolean a(Uri uri)
    {
        while (uri == null || !uri.isHierarchical() || !b(uri) && !c(uri)) 
        {
            return false;
        }
        return true;
    }

    public void b(WebView webview)
    {
        a(webview, "onhide", null);
    }

    public boolean b(Uri uri)
    {
        String s = uri.getScheme();
        if (s != null && s.equals("gmsg"))
        {
            if ((uri = uri.getAuthority()) != null && uri.equals("mobileads.google.com"))
            {
                return true;
            }
        }
        return false;
    }

    public boolean c(Uri uri)
    {
        uri = uri.getScheme();
        return uri != null && uri.equals("admob");
    }

}
