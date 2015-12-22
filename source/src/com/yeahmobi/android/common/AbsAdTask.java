// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class AbsAdTask extends AsyncTask
{

    protected HttpClient mHttpClient;

    public AbsAdTask()
    {
        mHttpClient = new DefaultHttpClient();
    }

    protected boolean isResponseValid(HttpResponse httpresponse)
    {
        if (httpresponse == null || httpresponse.getEntity() == null)
        {
            Log.d("YeahMobi", "MoPub server returned null response.");
            return false;
        }
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i >= 400)
        {
            Log.d("YeahMobi", (new StringBuilder()).append("Server error: returned HTTP status code ").append(Integer.toString(i)).append(". Please try again.").toString());
            return false;
        }
        if (i != 200)
        {
            Log.d("YeahMobi", (new StringBuilder()).append("MoPub server returned invalid response: HTTP status code ").append(Integer.toString(i)).append(".").toString());
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean isStateValid()
    {
        return !isCancelled();
    }

    protected String readFromStream(InputStream inputstream)
        throws IOException
    {
        int i = 0;
        StringBuffer stringbuffer = new StringBuffer();
        byte abyte0[] = new byte[4096];
        for (; i != -1; i = inputstream.read(abyte0))
        {
            stringbuffer.append(new String(abyte0, 0, i));
        }

        inputstream.close();
        return stringbuffer.toString();
    }

    protected void shutdownHttpClient()
    {
        if (mHttpClient != null)
        {
            ClientConnectionManager clientconnectionmanager = mHttpClient.getConnectionManager();
            if (clientconnectionmanager != null)
            {
                clientconnectionmanager.shutdown();
            }
            mHttpClient = null;
        }
    }
}
