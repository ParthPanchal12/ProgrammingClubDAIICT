// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.os.AsyncTask;
import com.yeahmobi.android.common.util.AsyncTasks;
import com.yeahmobi.android.common.util.IntentUtils;
import com.yeahmobi.android.common.util.YMLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlResolutionTask extends AsyncTask
{
    public static interface UrlResolutionListener
    {

        public abstract void onFailure();

        public abstract void onSuccess(String s);
    }


    private static final int REDIRECT_LIMIT = 10;
    private final UrlResolutionListener mListener;

    UrlResolutionTask(UrlResolutionListener urlresolutionlistener)
    {
        mListener = urlresolutionlistener;
    }

    private String checkJsRedirect(String s)
    {
        int j = s.indexOf("location.replace");
        int i = j;
        if (-1 == j)
        {
            i = s.indexOf("LOCATION.REPLACE");
        }
        if (-1 != i)
        {
            int l = "location.replace(".length() + i + 1;
            int k = s.indexOf('\'', l);
            i = k;
            if (-1 == k)
            {
                i = s.indexOf('"', l);
            }
            if (-1 != i)
            {
                return s.substring(l, i);
            }
        }
        return null;
    }

    private String checkMetaOrJsRedirect(String s)
    {
        if (s != null && s.length() != 0)
        {
            String s2 = checkMetaRedirect(s);
            String s1 = s2;
            if (s2 == null)
            {
                s1 = checkJsRedirect(s);
            }
            return s1;
        } else
        {
            return null;
        }
    }

    private String checkMetaRedirect(String s)
    {
        int j = s.indexOf("<meta");
        int i = j;
        if (-1 == j)
        {
            i = s.indexOf("<META");
        }
        if (-1 != i)
        {
            int k = s.indexOf("URL=", i + 5);
            i = k;
            if (-1 == k)
            {
                i = s.indexOf("url=");
            }
            if (-1 != i)
            {
                int i1 = s.indexOf('"', i + 4);
                int l = i1;
                if (-1 == i1)
                {
                    l = s.indexOf('\'', i + 4);
                }
                if (-1 != l)
                {
                    return xmlElementDecode(s.substring(i + 4, l));
                }
            }
        }
        return null;
    }

    private String getRedirectLocation(String s)
        throws IOException
    {
        Object obj;
        obj = new URL(s);
        s = null;
        HttpURLConnection httpurlconnection = (HttpURLConnection)((URL) (obj)).openConnection();
        s = httpurlconnection;
        httpurlconnection.setConnectTimeout(5000);
        s = httpurlconnection;
        httpurlconnection.setInstanceFollowRedirects(false);
        s = httpurlconnection;
        int i = httpurlconnection.getResponseCode();
        if (i < 300 || i >= 400) goto _L2; else goto _L1
_L1:
        s = httpurlconnection;
        obj = httpurlconnection.getHeaderField("Location");
        s = ((String) (obj));
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            s = ((String) (obj));
        }
_L6:
        return s;
_L2:
        if (i != 200)
        {
            break; /* Loop/switch isn't completed */
        }
        s = httpurlconnection;
        obj = httpurlconnection.getInputStream();
        s = httpurlconnection;
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
        s = httpurlconnection;
        StringBuilder stringbuilder = new StringBuilder();
_L4:
        s = httpurlconnection;
        String s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = httpurlconnection;
        stringbuilder.append(s1);
        if (true) goto _L4; else goto _L3
        obj;
        if (s != null)
        {
            s.disconnect();
        }
        throw obj;
_L3:
        s = httpurlconnection;
        ((InputStream) (obj)).close();
        s = httpurlconnection;
        obj = checkMetaOrJsRedirect(stringbuilder.toString());
        s = ((String) (obj));
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return ((String) (obj));
        }
        if (true) goto _L6; else goto _L5
_L5:
        s = null;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return null;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public static void getResolvedUrl(String s, UrlResolutionListener urlresolutionlistener)
    {
        UrlResolutionTask urlresolutiontask = new UrlResolutionTask(urlresolutionlistener);
        try
        {
            AsyncTasks.safeExecuteOnExecutor(urlresolutiontask, new String[] {
                s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            YMLog.d("Failed to resolve url", s);
        }
        urlresolutionlistener.onFailure();
    }

    private String xmlElementDecode(String s)
    {
        if (s != null && s.length() != 0)
        {
            return s.replaceAll("&amp;", "&");
        } else
        {
            return null;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((String) (obj));
_L2:
        int i;
        obj = null;
        as = as[0];
        i = 0;
_L6:
        if (as == null || i >= 10)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = as;
        if (IntentUtils.isAppStoreUrl(as)) goto _L4; else goto _L3
_L3:
        obj = as;
        if (!IntentUtils.isHttpUrl(as)) goto _L4; else goto _L5
_L5:
        obj = as;
        try
        {
            as = getRedirectLocation(as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return null;
        }
        i++;
          goto _L6
        return ((String) (obj));
    }

    protected void onCancelled()
    {
        super.onCancelled();
        mListener.onFailure();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (isCancelled() || s == null)
        {
            onCancelled();
            return;
        } else
        {
            mListener.onSuccess(s);
            return;
        }
    }
}
