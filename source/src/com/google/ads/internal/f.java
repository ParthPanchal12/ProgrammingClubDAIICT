// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdSize;
import com.google.ads.l;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.google.ads.internal:
//            c, d

public final class f
    implements Runnable
{
    public static interface a
    {

        public abstract HttpURLConnection a(URL url)
            throws IOException;
    }


    private final l a;
    private final a b;
    private volatile boolean c;
    private boolean d;
    private String e;
    private Thread f;

    f(l l1)
    {
        this(l1, new a() {

            public HttpURLConnection a(URL url)
                throws IOException
            {
                return (HttpURLConnection)url.openConnection();
            }

        });
    }

    f(l l1, a a1)
    {
        f = null;
        a = l1;
        b = a1;
    }

    private void a(Context context, HttpURLConnection httpurlconnection)
    {
label0:
        {
            context = PreferenceManager.getDefaultSharedPreferences(context).getString("drt", "");
            if (d && !TextUtils.isEmpty(context))
            {
                if (AdUtil.a != 8)
                {
                    break label0;
                }
                httpurlconnection.addRequestProperty("X-Afma-drt-Cookie", context);
            }
            return;
        }
        httpurlconnection.addRequestProperty("Cookie", context);
    }

    private void a(HttpURLConnection httpurlconnection)
    {
        b(httpurlconnection);
        f(httpurlconnection);
        g(httpurlconnection);
        h(httpurlconnection);
        i(httpurlconnection);
        e(httpurlconnection);
        j(httpurlconnection);
        k(httpurlconnection);
        l(httpurlconnection);
        d(httpurlconnection);
        c(httpurlconnection);
        m(httpurlconnection);
        n(httpurlconnection);
    }

    private void a(HttpURLConnection httpurlconnection, int i1)
        throws IOException
    {
        if (300 <= i1 && i1 < 400)
        {
            String s = httpurlconnection.getHeaderField("Location");
            if (s == null)
            {
                com.google.ads.util.b.c((new StringBuilder()).append("Could not get redirect location from a ").append(i1).append(" redirect.").toString());
                ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
                a();
                return;
            } else
            {
                a(httpurlconnection);
                e = s;
                return;
            }
        }
        if (i1 == 200)
        {
            a(httpurlconnection);
            httpurlconnection = AdUtil.a(new InputStreamReader(httpurlconnection.getInputStream())).trim();
            com.google.ads.util.b.a((new StringBuilder()).append("Response content is: ").append(httpurlconnection).toString());
            if (TextUtils.isEmpty(httpurlconnection))
            {
                com.google.ads.util.b.a((new StringBuilder()).append("Response message is null or zero length: ").append(httpurlconnection).toString());
                ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.NO_FILL);
                a();
                return;
            } else
            {
                ((c)a.b.a()).a(httpurlconnection, e);
                a();
                return;
            }
        }
        if (i1 == 400)
        {
            com.google.ads.util.b.c("Bad request");
            ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST);
            a();
            return;
        } else
        {
            com.google.ads.util.b.c((new StringBuilder()).append("Invalid response code: ").append(i1).toString());
            ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            a();
            return;
        }
    }

    private void b()
        throws MalformedURLException, IOException
    {
_L2:
        Object obj;
        if (c)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new URL(e);
        obj = b.a(((URL) (obj)));
        a((Context)((n)a.a.a()).f.a(), ((HttpURLConnection) (obj)));
        AdUtil.a(((HttpURLConnection) (obj)), (Context)((n)a.a.a()).f.a());
        ((HttpURLConnection) (obj)).setInstanceFollowRedirects(false);
        ((HttpURLConnection) (obj)).connect();
        a(((HttpURLConnection) (obj)), ((HttpURLConnection) (obj)).getResponseCode());
        ((HttpURLConnection) (obj)).disconnect();
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        ((HttpURLConnection) (obj)).disconnect();
        throw exception;
_L1:
    }

    private void b(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Debug-Dialog");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            ((c)a.b.a()).f(httpurlconnection);
        }
    }

    private void c(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("Content-Type");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            ((c)a.b.a()).b(httpurlconnection);
        }
    }

    private void d(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Mediation");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            ((c)a.b.a()).b(Boolean.valueOf(httpurlconnection).booleanValue());
        }
    }

    private void e(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Interstitial-Timeout");
        if (TextUtils.isEmpty(httpurlconnection))
        {
            break MISSING_BLOCK_LABEL_51;
        }
        float f1 = Float.parseFloat(httpurlconnection);
        ((d)((n)a.a.a()).b.a()).a((long)(f1 * 1000F));
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        com.google.ads.util.b.d((new StringBuilder()).append("Could not get timeout value: ").append(httpurlconnection).toString(), numberformatexception);
        return;
    }

    private void f(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Tracking-Urls");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            httpurlconnection = httpurlconnection.trim().split("\\s+");
            int j1 = httpurlconnection.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String s = httpurlconnection[i1];
                ((d)((n)a.a.a()).b.a()).b(s);
            }

        }
    }

    private void g(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Manual-Tracking-Urls");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            httpurlconnection = httpurlconnection.trim().split("\\s+");
            int j1 = httpurlconnection.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String s = httpurlconnection[i1];
                ((d)((n)a.a.a()).b.a()).c(s);
            }

        }
    }

    private void h(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Click-Tracking-Urls");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            httpurlconnection = httpurlconnection.trim().split("\\s+");
            int j1 = httpurlconnection.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                String s = httpurlconnection[i1];
                ((c)a.b.a()).a(s);
            }

        }
    }

    private void i(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Refresh-Rate");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            float f1;
            try
            {
                f1 = Float.parseFloat(httpurlconnection);
            }
            catch (NumberFormatException numberformatexception)
            {
                com.google.ads.util.b.d((new StringBuilder()).append("Could not get refresh value: ").append(httpurlconnection).toString(), numberformatexception);
                return;
            }
            httpurlconnection = (d)((n)a.a.a()).b.a();
            if (f1 > 0.0F)
            {
                httpurlconnection.a(f1);
                if (!httpurlconnection.t())
                {
                    httpurlconnection.g();
                }
            } else
            if (httpurlconnection.t())
            {
                httpurlconnection.f();
                return;
            }
        }
    }

    private void j(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Orientation");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            if (httpurlconnection.equals("portrait"))
            {
                ((c)a.b.a()).a(AdUtil.b());
            } else
            if (httpurlconnection.equals("landscape"))
            {
                ((c)a.b.a()).a(AdUtil.a());
                return;
            }
        }
    }

    private void k(HttpURLConnection httpurlconnection)
    {
        if (TextUtils.isEmpty(httpurlconnection.getHeaderField("X-Afma-Doritos-Cache-Life")))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        long l1 = Long.parseLong(httpurlconnection.getHeaderField("X-Afma-Doritos-Cache-Life"));
        ((d)((n)a.a.a()).b.a()).b(l1);
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        com.google.ads.util.b.e((new StringBuilder()).append("Got bad value of Doritos cookie cache life from header: ").append(httpurlconnection.getHeaderField("X-Afma-Doritos-Cache-Life")).append(". Using default value instead.").toString());
        return;
    }

    private void l(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            ((c)a.b.a()).c(httpurlconnection);
        }
    }

    private void m(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Ad-Size");
        if (TextUtils.isEmpty(httpurlconnection))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        String as[];
        as = httpurlconnection.split("x", 2);
        if (as.length != 2)
        {
            com.google.ads.util.b.e((new StringBuilder()).append("Could not parse size header: ").append(httpurlconnection).toString());
            return;
        }
        int i1;
        int j1;
        i1 = Integer.parseInt(as[0]);
        j1 = Integer.parseInt(as[1]);
        ((c)a.b.a()).a(new AdSize(i1, j1));
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        com.google.ads.util.b.e((new StringBuilder()).append("Could not parse size header: ").append(httpurlconnection).toString());
    }

    private void n(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getHeaderField("X-Afma-Disable-Activation-And-Scroll");
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            ((c)a.b.a()).a(httpurlconnection.equals("1"));
        }
    }

    void a()
    {
        c = true;
    }

    void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (f == null)
        {
            e = s;
            c = false;
            f = new Thread(this);
            f.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    public void run()
    {
        try
        {
            b();
            return;
        }
        catch (MalformedURLException malformedurlexception)
        {
            com.google.ads.util.b.b("Received malformed ad url from javascript.", malformedurlexception);
            ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        catch (IOException ioexception)
        {
            com.google.ads.util.b.b("IOException connecting to ad url.", ioexception);
            ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR);
            return;
        }
        catch (Throwable throwable)
        {
            com.google.ads.util.b.b("An unknown error occurred in AdResponseLoader.", throwable);
        }
        ((c)a.b.a()).a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
    }
}
