// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ae
    implements Runnable
{

    private final Context a;
    private final String b;

    public ae(String s, Context context)
    {
        b = s;
        a = context;
    }

    protected HttpURLConnection a(URL url)
        throws IOException
    {
        return (HttpURLConnection)url.openConnection();
    }

    public void run()
    {
        HttpURLConnection httpurlconnection;
        com.google.ads.util.b.a((new StringBuilder()).append("Pinging URL: ").append(b).toString());
        httpurlconnection = a(new URL(b));
        int i;
        AdUtil.a(httpurlconnection, a);
        httpurlconnection.setInstanceFollowRedirects(true);
        httpurlconnection.connect();
        i = httpurlconnection.getResponseCode();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        com.google.ads.util.b.e((new StringBuilder()).append("Did not receive 2XX (got ").append(i).append(") from pinging URL: ").append(b).toString());
        Exception exception;
        try
        {
            httpurlconnection.disconnect();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.ads.util.b.d((new StringBuilder()).append("Unable to ping the URL: ").append(b).toString(), throwable);
        }
        break MISSING_BLOCK_LABEL_150;
        exception;
        httpurlconnection.disconnect();
        throw exception;
    }
}
