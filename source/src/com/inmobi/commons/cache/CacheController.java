// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.cache:
//            ProductCacheConfig, LocalCache, ProductConfig

public final class CacheController
{
    public static interface Committer
    {

        public abstract void onCommit();
    }

    public static interface Validator
    {

        public abstract boolean validate(Map map);
    }


    private static Map a = new HashMap();
    private static ProductCacheConfig b = null;
    private static boolean c = true;
    private static Map d = new HashMap();
    private static Map e = new HashMap();

    private CacheController()
    {
    }

    static void a()
    {
        Map map = d;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = d.keySet().iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_133;
        }
        s = (String)iterator.next();
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) goto _L2; else goto _L1
_L1:
        Map map1;
        synchronized (e)
        {
            map1 = (Map)e.get(s);
        }
        getConfig(s, null, map1, (Validator)d.get(s));
          goto _L2
_L3:
        Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Unable to reinitialize product ").append(s).toString());
          goto _L2
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L3
        map;
        JVM INSTR monitorexit ;
        if (b != null)
        {
            b.getData((Validator)null);
        }
        return;
    }

    static boolean a(Map map)
    {
        return b(map);
    }

    static Map b()
    {
        return a;
    }

    private static boolean b(Map map)
    {
        try
        {
            map = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
            c(map);
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = map.get((String)iterator.next());
                if (obj instanceof Map)
                {
                    c((Map)obj);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return true;
    }

    static void c()
    {
        f();
    }

    private static void c(Map map)
    {
        InternalSDKUtil.getIntFromMap(map, "expiry", 1, 0x7fffffffL);
        InternalSDKUtil.getIntFromMap(map, "maxRetry", 0, 0x7fffffffL);
        InternalSDKUtil.getIntFromMap(map, "retryInterval", 1, 0x7fffffffL);
        InternalSDKUtil.getStringFromMap(map, "url");
        InternalSDKUtil.getStringFromMap(map, "protocol");
    }

    private static void d()
    {
        InternalSDKUtil.getContext().registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent)
            {
                CacheController.a();
            }

        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static void e()
    {
        Iterator iterator;
        Log.internal("[InMobi]-4.5.5", "Bootstrapping cache.");
        LocalCache.initRoot();
        iterator = LocalCache.getRoot().keys();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        Object obj;
        ProductCacheConfig productcacheconfig;
        obj = LocalCache.getRoot().get(s);
        if (!(obj instanceof JSONObject))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new ProductCacheConfig((JSONObject)obj, new Committer(s) {

            final String a;

            public void onCommit()
            {
                ProductCacheConfig productcacheconfig1 = (ProductCacheConfig)CacheController.b().get(a);
                if (productcacheconfig1 == null)
                {
                    return;
                }
                try
                {
                    LocalCache.addToCache(a, productcacheconfig1.toJSON());
                    return;
                }
                catch (JSONException jsonexception1)
                {
                    Log.internal("[InMobi]-4.5.5", "Unable to add json to persistent memory", jsonexception1);
                }
                return;
            }

            
            {
                a = s;
                super();
            }
        });
        productcacheconfig = (ProductCacheConfig)a.get(s);
        if (productcacheconfig == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        ((ProductCacheConfig) (obj)).setValidator(productcacheconfig.getValidator());
        ((ProductCacheConfig) (obj)).setMap(productcacheconfig.getMap());
        a.put(s, obj);
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        Log.internal("[InMobi]-4.5.5", "Unable to dump config from persistent memory to products in memory", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
        if (b == null)
        {
            b = new ProductCacheConfig(LocalCache.getRoot(), new Committer() {

                public void onCommit()
                {
                    CacheController.c();
                }

            });
            b.getData(UID.getInstance().getMapForEncryption(null), new Validator() {

                public boolean validate(Map map)
                {
                    return CacheController.a(map);
                }

            });
        } else
        {
            b.loadFromJSON(LocalCache.getRoot());
        }
        InternalSDKUtil.initialize(InternalSDKUtil.getContext());
        return;
    }

    private static void f()
    {
        JSONObject jsonobject;
        Iterator iterator;
        Object obj;
        Object obj1;
        Object obj2;
        try
        {
            jsonobject = new JSONObject(b.getRawData());
            jsonobject = InternalSDKUtil.populateToNewJSON(jsonobject.getJSONObject("AND"), jsonobject.getJSONObject("common"), true);
        }
        catch (JSONException jsonexception)
        {
            return;
        }
        try
        {
            jsonobject.put("timestamp", (int)(System.currentTimeMillis() / 1000L));
        }
        catch (JSONException jsonexception1)
        {
            Log.internal("[InMobi]-4.5.5", "Unable to add timestamp to JSON");
        }
        iterator = jsonobject.keys();
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_177;
        }
        obj2 = (String)iterator.next();
        obj = LocalCache.getRoot().get(((String) (obj2)));
        if (!(obj instanceof JSONObject))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = (ProductCacheConfig)a.get(obj2);
        if (obj2 != null)
        {
            try
            {
                ((JSONObject)obj).put("timestamp", 0);
                ((JSONObject)obj).put("data", ((ProductCacheConfig) (obj2)).getRawData());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Error while merging data -> ").append(((Exception) (obj1)).getMessage()).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        LocalCache.saveRoot(jsonobject);
        e();
        a();
        return;
        obj1;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_52;
_L1:
    }

    public static ProductConfig getConfig(String s, Context context, Map map, Validator validator)
        throws CommonsException
    {
        if (validator != null)
        {
            synchronized (d)
            {
                d.put(s, validator);
            }
        }
        if (map != null)
        {
            synchronized (e)
            {
                e.put(s, map);
            }
        }
        if (!c)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (InternalSDKUtil.getContext() != null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (context == null)
        {
            throw new CommonsException(1);
        }
        break MISSING_BLOCK_LABEL_89;
        s;
        map1;
        JVM INSTR monitorexit ;
        throw s;
        s;
        map1;
        JVM INSTR monitorexit ;
        throw s;
        InternalSDKUtil.setContext(context);
        c = false;
        e();
        d();
        b.getData((Validator)null);
        s = (ProductCacheConfig)a.get(s);
        if (s == null)
        {
            throw new CommonsException(2);
        } else
        {
            s.getData(map, validator);
            return s;
        }
    }

}
