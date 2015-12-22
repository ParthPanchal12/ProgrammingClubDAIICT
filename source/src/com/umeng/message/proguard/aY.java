// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.umeng.message.proguard:
//            ba, aJ, aZ, aU

class aY
    implements Runnable
{

    private static final String a = "AsyncHttp.request";
    private final AbstractHttpClient b;
    private final HttpContext c;
    private final HttpUriRequest d;
    private final aZ e;
    private volatile boolean f;
    private int g;
    private Context h;

    public aY(Context context, AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpHost httphost, HttpUriRequest httpurirequest, aZ az)
    {
        b = abstracthttpclient;
        c = httpcontext;
        h = context;
        d = httpurirequest;
        e = az;
        if (httphost != null)
        {
            abstracthttpclient.getParams().setParameter("http.route.default-proxy", httphost);
        }
        if (az instanceof ba)
        {
            f = true;
        }
    }

    private void a()
        throws IOException
    {
        if (!Thread.currentThread().isInterrupted())
        {
            HttpResponse httpresponse = b.execute(d, c);
            aJ.b("AsyncHttp.request", (new StringBuilder()).append("http request:[").append(d.getURI().toString()).append("]===response[:").append(httpresponse.getStatusLine().getStatusCode()).append("]").toString());
            if (e != null)
            {
                e.a(httpresponse);
            }
        }
    }

    private void b()
        throws ConnectException
    {
        boolean flag = true;
        Object obj = null;
        Object obj1 = b.getHttpRequestRetryHandler();
        while (flag) 
        {
            try
            {
                a();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aJ.e("AsyncHttp.request", "http request makeRequestWithRetries", ((Throwable) (obj)));
                int i = g + 1;
                g = i;
                flag = ((HttpRequestRetryHandler) (obj1)).retryRequest(((IOException) (obj)), i, c);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aJ.e("AsyncHttp.request", "", ((Throwable) (obj)));
                obj = new IOException((new StringBuilder()).append("NPE in HttpClient").append(((NullPointerException) (obj)).getMessage()).toString());
                int j = g + 1;
                g = j;
                flag = ((HttpRequestRetryHandler) (obj1)).retryRequest(((IOException) (obj)), j, c);
            }
        }
        obj1 = new ConnectException();
        ((ConnectException) (obj1)).initCause(((Throwable) (obj)));
        throw obj1;
    }

    public void run()
    {
        if (e != null)
        {
            e.a();
        }
        if (aU.a(h))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        e.a(new RuntimeException((new StringBuilder()).append("http request network connection error[").append(d.getURI().toString()).append("]").toString()), (byte[])null);
_L2:
        if (e != null)
        {
            e.b();
            return;
        }
        break MISSING_BLOCK_LABEL_154;
        b();
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        ioexception;
        aJ.e("AsyncHttp.request", "http request io", ioexception);
        if (e != null)
        {
            e.b();
            if (f)
            {
                e.a(ioexception, (byte[])null);
                return;
            }
            e.a(ioexception, ioexception.getMessage());
        }
    }
}
