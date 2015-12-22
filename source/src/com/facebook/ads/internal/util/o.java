// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.util.Log;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.facebook.ads.internal.util:
//            s, g, a

public class o extends AsyncTask
{

    private static final String a = com/facebook/ads/internal/util/o.getSimpleName();
    private Map b;

    public o()
    {
        b = null;
    }

    public o(Map map)
    {
        b = map;
    }

    private String a(String s1, String s2, String s3)
    {
        if (s.a(s1) || s.a(s2) || s.a(s3))
        {
            return s1;
        }
        String s4;
        if (s1.contains("?"))
        {
            s4 = "&";
        } else
        {
            s4 = "?";
        }
        return (new StringBuilder()).append(s1).append(s4).append(s2).append("=").append(URLEncoder.encode(s3)).toString();
    }

    private boolean a(String s1)
    {
        boolean flag = false;
        HttpClient httpclient = g.b();
        HttpGet httpget = new HttpGet(s1);
        int i;
        try
        {
            i = httpclient.execute(httpget).getStatusLine().getStatusCode();
        }
        catch (Exception exception)
        {
            Log.e(a, (new StringBuilder()).append("Error opening url: ").append(s1).toString(), exception);
            return false;
        }
        if (i == 200)
        {
            flag = true;
        }
        return flag;
    }

    private String b(String s1)
    {
        String s2;
        try
        {
            s2 = a(s1, "analog", g.a(com.facebook.ads.internal.util.a.a()));
        }
        catch (Exception exception)
        {
            return s1;
        }
        return s2;
    }

    protected transient Void a(String as[])
    {
        as = as[0];
        if (!s.a(as) && !as.equals("#"))
        {
            as = b(as);
            Object obj = as;
            if (b != null)
            {
                obj = as;
                if (!b.isEmpty())
                {
                    for (obj = b.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                        as = a(((String) (as)), (String)entry.getKey(), (String)b.get(entry.getValue()));
                    }

                    obj = as;
                }
            }
            int i = 1;
            while (i <= 2 && !a(((String) (obj)))) 
            {
                i++;
            }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

}
