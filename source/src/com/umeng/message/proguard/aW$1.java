// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.umeng.message.proguard:
//            aW

class a
    implements HttpRequestInterceptor
{

    final aW a;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        String s;
        for (httpcontext = aW.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)aW.a(a).get(s)))
        {
            s = (String)httpcontext.next();
        }

    }

    text(aW aw)
    {
        a = aw;
        super();
    }
}
