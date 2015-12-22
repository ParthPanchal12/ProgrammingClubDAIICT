// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message.proguard:
//            be, aJ

public class bg extends be
{

    private static final String l = "HttpURLChunked";
    private volatile HttpURLConnection m;

    public bg()
    {
        m = null;
    }

    private String a(List list)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append((String)list.get(i));
            if (i < j - 1)
            {
                stringbuffer.append(",");
            }
        }

        return stringbuffer.toString();
    }

    private Map a(HttpURLConnection httpurlconnection)
    {
        HashMap hashmap = new HashMap();
        httpurlconnection = httpurlconnection.getHeaderFields().entrySet().iterator();
        do
        {
            if (!httpurlconnection.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)httpurlconnection.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            if (!TextUtils.isEmpty(s))
            {
                obj = a((List)((java.util.Map.Entry) (obj)).getValue());
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    hashmap.put(s, obj);
                }
            }
        } while (true);
        return hashmap;
    }

    private void b(HttpURLConnection httpurlconnection)
        throws IOException
    {
        if (httpurlconnection == null)
        {
            throw new IOException();
        } else
        {
            b = httpurlconnection.getInputStream();
            return;
        }
    }

    protected void a(String s)
    {
        aJ.c("HttpURLChunked", (new StringBuilder()).append("http chunked connectId:[").append(b()).append("]==>").append(s).toString());
        s = new URL(s);
        if (!k()) goto _L2; else goto _L1
_L1:
        m = (HttpURLConnection)s.openConnection(new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByName(super.i()), super.j())));
_L4:
        m.setRequestProperty("User-agent", String.format("Agoo-sdk-%s", new Object[] {
            Double.valueOf(2D)
        }));
        if (f != null)
        {
            String s1;
            for (s = f.keySet().iterator(); s.hasNext(); m.setRequestProperty(s1, (String)f.get(s1)))
            {
                s1 = (String)s.next();
            }

        }
        break MISSING_BLOCK_LABEL_252;
_L2:
        try
        {
            m = (HttpURLConnection)s.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (!hasCallError())
            {
                callError(true);
                aJ.d("HttpURLChunked", (new StringBuilder()).append("http chunked connectId:[").append(b()).append("]==>[Throwable]").toString(), s);
                a(504, ((Throwable) (s)));
            }
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        int i;
        m.connect();
        i = m.getResponseCode();
        s = a(m);
        if (200 != i)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        b(m);
        a(((Map) (s)));
        e();
        return;
        a(i, ((Map) (s)));
        f();
        return;
    }

    public volatile void addHeader(String s, String s1)
    {
        super.addHeader(s, s1);
    }

    protected void c()
    {
        if (m != null)
        {
            m.disconnect();
            m = null;
        }
    }

    public volatile void callError(boolean flag)
    {
        super.callError(flag);
    }

    protected void d()
    {
        if (m != null)
        {
            m.disconnect();
            m = null;
        }
    }

    public volatile boolean hasCallError()
    {
        return super.hasCallError();
    }
}
