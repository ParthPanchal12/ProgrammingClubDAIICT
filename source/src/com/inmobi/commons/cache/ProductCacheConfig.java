// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.RequestBuilderUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.cache:
//            ProductConfig, RetryMechanism

public class ProductCacheConfig extends ProductConfig
{
    private class a
    {

        final ProductCacheConfig a;
        private String b;
        private long c;

        static long a(a a1, long l)
        {
            a1.c = l;
            return l;
        }

        static String a(a a1)
        {
            return a1.b;
        }

        static String a(a a1, String s)
        {
            a1.b = s;
            return s;
        }

        static long b(a a1)
        {
            return a1.c;
        }

        private a()
        {
            a = ProductCacheConfig.this;
            super();
        }

    }


    public static final int DEFAULT_EXPIRY = 0x69780;
    public static final int DEFAULT_INTERVAL = 60;
    public static final int DEFAULT_MAX_RETRY = 3;
    private static Timer a = new Timer();
    private AtomicBoolean b;
    private Map c;
    private CacheController.Validator d;
    private RetryMechanism e;
    private CacheController.Committer f;
    private long g;

    public ProductCacheConfig(JSONObject jsonobject)
    {
        b = new AtomicBoolean(false);
        c = new HashMap();
        d = null;
        e = new RetryMechanism(3, 60000, a);
        try
        {
            loadFromJSON(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.internal("[InMobi]-4.5.5", "JSON retrieved is invalid.");
        }
    }

    public ProductCacheConfig(JSONObject jsonobject, CacheController.Committer committer)
    {
        this(jsonobject);
        f = committer;
    }

    private void a()
        throws Exception
    {
        Object obj;
        String s;
        obj = c();
        s = a.a(((a) (obj)));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (!d.validate(a(s))) goto _L2; else goto _L1
_L1:
        setData(s);
_L3:
        setTimestamp((int)(System.currentTimeMillis() / 1000L));
        g = a.b(((a) (obj)));
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Product with url ").append(getUrl()).append(" accepted data ").append(getRawData()).toString());
        f.onCommit();
        return;
_L2:
        try
        {
            throw new IOException("Invalid config.");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Error connecting to url, or ").append(getUrl()).append(" did not return 200. Purge cache update.").toString(), ((Throwable) (obj)));
        }
        throw obj;
        setData(s);
          goto _L3
        setTimestamp((int)(System.currentTimeMillis() / 1000L));
        g = a.b(((a) (obj)));
        f.onCommit();
        return;
    }

    static void a(ProductCacheConfig productcacheconfig)
        throws Exception
    {
        productcacheconfig.a();
    }

    static AtomicBoolean b(ProductCacheConfig productcacheconfig)
    {
        return productcacheconfig.b;
    }

    private void b()
    {
        if (!b.compareAndSet(false, true))
        {
            return;
        } else
        {
            e.rescheduleTimer(new RetryMechanism.RetryRunnable() {

                final ProductCacheConfig a;

                public void completed()
                {
                    ProductCacheConfig.b(a).set(false);
                }

                public void run()
                    throws Exception
                {
                    try
                    {
                        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
                        {
                            ProductCacheConfig.a(a);
                            return;
                        }
                    }
                    catch (Exception exception)
                    {
                        throw exception;
                    }
                    throw new IOException("Network unavailable");
                }

            
            {
                a = ProductCacheConfig.this;
                super();
            }
            });
            return;
        }
    }

    private a c()
        throws IOException
    {
        String s = "";
        Object obj = new HashMap();
        RequestBuilderUtils.fillIdentityMap(((Map) (obj)), null, true);
        RequestBuilderUtils.fillAppInfoMap(((Map) (obj)));
        obj = InternalSDKUtil.encodeMapAndconvertToDelimitedString(((Map) (obj)), "&");
        Object obj1;
        int i;
        if (obj != null && !"".equals(obj))
        {
            if (getUrl().endsWith("?"))
            {
                obj = (new StringBuilder()).append(getUrl()).append(((String) (obj))).toString();
            } else
            if (getUrl().contains("?"))
            {
                obj = (new StringBuilder()).append(getUrl()).append("&").append(((String) (obj))).toString();
            } else
            {
                obj = (new StringBuilder()).append(getUrl()).append("?").append(((String) (obj))).toString();
            }
        } else
        {
            obj = getUrl();
        }
        obj1 = new URL(((String) (obj)));
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Sending request to ").append(((String) (obj))).append(" to retreive cache..").toString());
        obj1 = (HttpURLConnection)((URL) (obj1)).openConnection();
        ((HttpURLConnection) (obj1)).setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        ((HttpURLConnection) (obj1)).setIfModifiedSince(g);
        ((HttpURLConnection) (obj1)).setRequestMethod("GET");
        i = ((HttpURLConnection) (obj1)).getResponseCode();
        if (i == 304)
        {
            obj = new a();
            a.a(((a) (obj)), null);
            a.a(((a) (obj)), ((HttpURLConnection) (obj1)).getLastModified());
            return ((a) (obj));
        }
        if (i != 200)
        {
            throw new IOException("Server did not return 200. ");
        }
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
        obj = s;
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 != null)
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(s1).toString();
            } else
            {
                bufferedreader.close();
                a a1 = new a();
                a.a(a1, ((String) (obj)));
                a.a(a1, ((HttpURLConnection) (obj1)).getLastModified());
                return a1;
            }
        } while (true);
    }

    public ProductConfig getConfig()
    {
        return this;
    }

    public String getData(CacheController.Validator validator)
    {
        if (validator != null)
        {
            d = validator;
        }
        setRetryNumber(0);
        int i = (int)(System.currentTimeMillis() / 1000L);
        if ((getTimestamp() + getExpiry()) - i <= 0)
        {
            b();
        }
        return getRawData();
    }

    public String getData(Map map, CacheController.Validator validator)
    {
        if (map != null)
        {
            c = map;
        }
        return getData(validator);
    }

    public Map getMap()
    {
        return c;
    }

    public CacheController.Validator getValidator()
    {
        return d;
    }

    public final void loadFromJSON(JSONObject jsonobject)
    {
        setExpiry(InternalSDKUtil.getIntFromJSON(jsonobject, "expiry", 0x69780));
        setMaxRetry(InternalSDKUtil.getIntFromJSON(jsonobject, "maxRetry", 3));
        setRetryInterval(InternalSDKUtil.getIntFromJSON(jsonobject, "retryInterval", 60));
        g = InternalSDKUtil.getLongFromJSON(jsonobject, "lastModified", 0L);
        setUrl(InternalSDKUtil.getStringFromJSON(jsonobject, "url", ""));
        setProtocol(InternalSDKUtil.getStringFromJSON(jsonobject, "protocol", "json"));
        e = new RetryMechanism(getMaxRetry(), getRetryInterval() * 1000, a);
        setTimestamp(InternalSDKUtil.getIntFromJSON(jsonobject, "timestamp", 0));
        setData(InternalSDKUtil.getStringFromJSON(jsonobject, "data", null));
    }

    protected void reset()
    {
        setExpiry(0);
        setRetryInterval(0);
        setMaxRetry(0);
        setTimestamp(0);
        setUrl(null);
        setProtocol(null);
        setData(null);
    }

    public void setMap(Map map)
    {
        c = map;
    }

    public void setValidator(CacheController.Validator validator)
    {
        d = validator;
    }

    public JSONObject toJSON()
    {
        Object obj = new JSONObject();
        Object obj1 = new JSONObject((new StringBuilder()).append("{expiry:").append(getExpiry()).append(",").append("maxRetry:").append(getMaxRetry()).append(",").append("retryInterval:").append(getRetryInterval()).append(",").append("protocol:").append(getProtocol()).append(",timestamp:").append(getTimestamp()).append("}").toString());
        ((JSONObject) (obj1)).put("url", getUrl());
        ((JSONObject) (obj1)).put("data", getRawData());
        ((JSONObject) (obj1)).put("lastModified", g);
        return ((JSONObject) (obj1));
        obj1;
_L2:
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Ill formed JSON product(").append(getUrl()).append(") toString").toString(), ((Throwable) (obj1)));
        return ((JSONObject) (obj));
        JSONException jsonexception;
        jsonexception;
        obj = obj1;
        obj1 = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String toString()
    {
        return toJSON().toString();
    }

}
