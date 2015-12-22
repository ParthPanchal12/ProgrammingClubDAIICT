// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

// Referenced classes of package com.umeng.message.proguard:
//            bc, bb

class aW
{
    private static class a extends HttpEntityWrapper
    {

        public InputStream getContent()
            throws IOException
        {
            return new GZIPInputStream(wrappedEntity.getContent());
        }

        public long getContentLength()
        {
            return -1L;
        }

        public a(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }


    private static final int a = 10;
    private static final int b = 10000;
    private static final int c = 3;
    private static final int d = 8192;
    private static final String e = "Accept-Encoding";
    private static final String f = "gzip";
    private static int g = 10;
    private static int h = 10000;
    private final DefaultHttpClient i;
    private final HttpContext j = new SyncBasicHttpContext(new BasicHttpContext());
    private final Map k = new HashMap();

    public aW()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basichttpparams, h);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(g));
        ConnManagerParams.setMaxTotalConnections(basichttpparams, 10);
        HttpConnectionParams.setSoTimeout(basichttpparams, h);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, h);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basichttpparams, String.format("Agoo-sdk-%s", new Object[] {
            Double.valueOf(2D)
        }));
        i = new DefaultHttpClient(basichttpparams);
        i.addRequestInterceptor(new HttpRequestInterceptor() {

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

            
            {
                a = aW.this;
                super();
            }
        });
        i.addResponseInterceptor(new HttpResponseInterceptor() {

            final aW a;

            public void process(HttpResponse httpresponse, HttpContext httpcontext)
            {
                httpcontext = httpresponse.getEntity();
                if (httpcontext != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if ((httpcontext = httpcontext.getContentEncoding()) != null)
                {
                    httpcontext = httpcontext.getElements();
                    int i1 = httpcontext.length;
                    int l = 0;
                    while (l < i1) 
                    {
                        if (httpcontext[l].getName().equalsIgnoreCase("gzip"))
                        {
                            httpresponse.setEntity(new a(httpresponse.getEntity()));
                            return;
                        }
                        l++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                a = aW.this;
                super();
            }
        });
        i.setHttpRequestRetryHandler(new bc(3));
    }

    static Map a(aW aw)
    {
        return aw.k;
    }

    protected String a(String s, bb bb1)
    {
        String s1 = s;
        if (bb1 != null)
        {
            bb1 = bb1.c();
            s1 = (new StringBuilder()).append(s).append("?").append(bb1).toString();
        }
        return s1;
    }

    public void addHeader(String s, String s1)
    {
        k.put(s, s1);
    }

    public void addRequestInterceptor(HttpRequestInterceptor httprequestinterceptor)
    {
        i.addRequestInterceptor(httprequestinterceptor);
    }

    public DefaultHttpClient getHttpClient()
    {
        return i;
    }

    public HttpContext getHttpContext()
    {
        return j;
    }

    public void setBasicAuth(String s, String s1)
    {
        setBasicAuth(s, s1, AuthScope.ANY);
    }

    public void setBasicAuth(String s, String s1, AuthScope authscope)
    {
        s = new UsernamePasswordCredentials(s, s1);
        i.getCredentialsProvider().setCredentials(authscope, s);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        j.setAttribute("http.cookie-store", cookiestore);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        i.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslsocketfactory, 443));
    }

    public void setTimeout(int l)
    {
        org.apache.http.params.HttpParams httpparams = i.getParams();
        ConnManagerParams.setTimeout(httpparams, l);
        HttpConnectionParams.setSoTimeout(httpparams, l);
        HttpConnectionParams.setConnectionTimeout(httpparams, l);
    }

    public void setUserAgent(String s)
    {
        HttpProtocolParams.setUserAgent(i.getParams(), s);
    }

}
