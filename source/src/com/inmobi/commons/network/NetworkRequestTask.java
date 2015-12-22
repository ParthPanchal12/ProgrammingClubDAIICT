// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;

import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.abstraction.INetworkListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.commons.network:
//            Response, ErrorCode, Request

public class NetworkRequestTask
    implements Runnable
{

    private Request a;
    private INetworkListener b;
    private HttpURLConnection c;

    NetworkRequestTask(Request request, INetworkListener inetworklistener)
    {
        a = request;
        b = inetworklistener;
    }

    private HttpURLConnection a(String s)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        a(((HttpURLConnection) (s)));
        return s;
    }

    private void a()
    {
        Object obj1 = null;
        int i;
        Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("Http Status Code: ").append(c.getResponseCode()).toString());
        i = c.getResponseCode();
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Status Code: ").append(i).toString());
        if (i != 200) goto _L2; else goto _L1
_L1:
        Object obj = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
        obj1 = new StringBuilder();
_L5:
        Object obj2 = ((BufferedReader) (obj)).readLine();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj1)).append(((String) (obj2))).append("\n");
          goto _L5
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L11:
        c.disconnect();
        a(((Closeable) (obj1)));
        throw obj;
        obj;
        Log.internal("[InMobi]-4.5.5", "Failed to retrieve response", ((Throwable) (obj)));
        obj = new Response(ErrorCode.CONNECTION_ERROR);
        if (b != null)
        {
            b.onRequestFailed(a, ((Response) (obj)));
        }
_L7:
        return;
_L4:
        obj1 = ((StringBuilder) (obj1)).toString();
        Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("Response: ").append(((String) (obj1))).toString());
        obj1 = new Response(((String) (obj1)), c.getResponseCode(), c.getHeaderFields());
        if (b != null)
        {
            b.onRequestSucceded(a, ((Response) (obj1)));
        }
_L9:
        c.disconnect();
        a(((Closeable) (obj)));
        return;
        obj;
        Log.internal("[InMobi]-4.5.5", "Out of memory error received while retieving network response", ((Throwable) (obj)));
        obj = new Response(ErrorCode.INTERNAL_ERROR);
        if (b == null) goto _L7; else goto _L6
_L6:
        b.onRequestFailed(a, ((Response) (obj)));
        return;
_L2:
        exception = new Response(null, c.getResponseCode(), c.getHeaderFields());
        obj = obj1;
        if (b == null) goto _L9; else goto _L8
_L8:
        b.onRequestFailed(a, exception);
        obj = obj1;
          goto _L9
        obj;
        obj1 = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        IOException ioexception;
        ioexception;
        Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("Exception closing resource: ").append(closeable).toString(), ioexception);
        return;
    }

    private void a(HttpURLConnection httpurlconnection)
        throws ProtocolException
    {
        httpurlconnection.setConnectTimeout(a.getTimeout());
        httpurlconnection.setReadTimeout(a.getTimeout());
        String s;
        for (Iterator iterator = a.getHeaders().keySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty(s, (String)a.getHeaders().get(s)))
        {
            s = (String)iterator.next();
        }

        httpurlconnection.setUseCaches(false);
        Request.Method method = a.getRequestMethod();
        if (method != Request.Method.GET)
        {
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setDoInput(true);
        }
        httpurlconnection.setRequestMethod(method.toString());
        httpurlconnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
    }

    private void b(String s)
        throws IOException
    {
        c.setRequestProperty("Content-Length", Integer.toString(s.length()));
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
        bufferedwriter.write(s);
        a(bufferedwriter);
        return;
        s;
        bufferedwriter = null;
_L2:
        a(bufferedwriter);
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void run()
    {
        String s;
        String s1;
        String s2;
        String s3;
        try
        {
            s3 = a.getQueryParams();
            s2 = a.getPostBody();
            s1 = a.getUrl();
        }
        catch (Exception exception)
        {
            Response response = new Response(ErrorCode.NETWORK_ERROR);
            if (b != null)
            {
                b.onRequestFailed(a, response);
            }
            Log.debug("[InMobi]-4.5.5", "Failed to make network request", exception);
            return;
        }
        s = s1;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        s = s1;
        if (!"".equals(s3.trim()))
        {
            s = (new StringBuilder()).append(s1).append("?").append(s3).toString();
        }
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("URL:").append(s).toString());
        c = a(s);
        if (a.getRequestMethod() == Request.Method.GET)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (!"".equals(s2))
        {
            break MISSING_BLOCK_LABEL_159;
        }
        b.onRequestFailed(a, new Response(ErrorCode.INTERNAL_ERROR));
        return;
        if (a.getRequestMethod() != Request.Method.GET)
        {
            Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("Post body:").append(s2).toString());
            b(s2);
        }
        a();
        return;
    }
}
