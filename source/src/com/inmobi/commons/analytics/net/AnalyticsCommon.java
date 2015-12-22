// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.util.Log;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class AnalyticsCommon
{
    public static interface HttpRequestCallback
    {

        public static final int HTTP_FAILURE = 1;
        public static final int HTTP_SUCCESS = 0;

        public abstract void notifyResult(int i, Object obj);
    }


    public AnalyticsCommon()
    {
    }

    private static void a(HttpURLConnection httpurlconnection)
        throws ProtocolException
    {
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpurlconnection.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
    }

    public static String getURLEncoded(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public void closeResource(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        IOException ioexception;
        ioexception;
        Log.d("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("Exception closing resource: ").append(closeable).toString(), ioexception);
        return;
    }

    public void postData(HttpURLConnection httpurlconnection, String s)
        throws IOException
    {
        httpurlconnection.setRequestProperty("Content-Length", Integer.toString(s.length()));
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(httpurlconnection.getOutputStream()));
        bufferedwriter.write(s);
        closeResource(bufferedwriter);
        return;
        httpurlconnection;
        s = null;
_L2:
        closeResource(s);
        throw httpurlconnection;
        httpurlconnection;
        s = bufferedwriter;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public HttpURLConnection setupConnection(String s)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        a(s);
        return s;
    }
}
