// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.umeng.message.proguard:
//            aW, aU, aJ, bb

public class bd extends aW
{
    public static class a
    {

        public int a;
        public String b;

        public a()
        {
        }
    }


    private static final String a = "SyncHttp.client";

    public bd()
    {
    }

    public volatile void addHeader(String s, String s1)
    {
        super.addHeader(s, s1);
    }

    public volatile void addRequestInterceptor(HttpRequestInterceptor httprequestinterceptor)
    {
        super.addRequestInterceptor(httprequestinterceptor);
    }

    public a get(Context context, String s, bb bb)
        throws Exception
    {
        return get(context, null, s, bb);
    }

    public a get(Context context, HttpHost httphost, String s, bb bb)
        throws Exception
    {
        Object obj;
        obj = null;
        try
        {
            bb = new HttpGet(a(s, bb));
            if (!aU.a(context))
            {
                aJ.c("SyncHttp.client", (new StringBuilder()).append("network connection error[").append(bb.getURI().toString()).append("]").toString());
                throw new RuntimeException((new StringBuilder()).append("network connection error[").append(bb.getURI().toString()).append("]").toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aJ.e("SyncHttp.client", (new StringBuilder()).append("request url error:[").append(s).append("]").toString(), context);
            throw context;
        }
        context = getHttpClient();
        if (httphost == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        context.getParams().setParameter("http.route.default-proxy", httphost);
        StatusLine statusline;
        context = context.execute(bb);
        httphost = new a();
        statusline = context.getStatusLine();
        httphost.a = statusline.getStatusCode();
        if (statusline.getStatusCode() < 300)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        aJ.c("SyncHttp.client", (new StringBuilder()).append("request url [").append(bb.getURI().toString()).append("]  result code:[").append(statusline.getStatusCode()).append("]").toString());
        return httphost;
        org.apache.http.HttpEntity httpentity = context.getEntity();
        context = obj;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        context = EntityUtils.toString(new BufferedHttpEntity(httpentity), "UTF-8");
        httphost.b = context;
        aJ.c("SyncHttp.client", (new StringBuilder()).append("request url:[").append(bb.getURI().toString()).append("] : result code [").append(statusline.getStatusCode()).append("]:[").append(context).append("]").toString());
        return httphost;
    }

    public volatile DefaultHttpClient getHttpClient()
    {
        return super.getHttpClient();
    }

    public volatile HttpContext getHttpContext()
    {
        return super.getHttpContext();
    }

    public volatile void setBasicAuth(String s, String s1)
    {
        super.setBasicAuth(s, s1);
    }

    public volatile void setBasicAuth(String s, String s1, AuthScope authscope)
    {
        super.setBasicAuth(s, s1, authscope);
    }

    public volatile void setCookieStore(CookieStore cookiestore)
    {
        super.setCookieStore(cookiestore);
    }

    public volatile void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        super.setSSLSocketFactory(sslsocketfactory);
    }

    public volatile void setTimeout(int i)
    {
        super.setTimeout(i);
    }

    public volatile void setUserAgent(String s)
    {
        super.setUserAgent(s);
    }
}
