// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class LocalCache
{

    public static final String FILENAME = "inmobi.cache";
    private static String a = "{url:'https://inmobisdk-a.akamaihd.net/sdk/configs/400/rootConfig.json'}";
    private static JSONObject b = new JSONObject();

    private LocalCache()
    {
    }

    static void a()
    {
        c();
    }

    public static JSONObject addToCache(String s, JSONObject jsonobject)
        throws JSONException
    {
        synchronized (b)
        {
            if (b.toString().equals("{}"))
            {
                initRoot();
            }
            b.put(s, jsonobject);
        }
        b();
        return null;
        s;
        jsonobject1;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void b()
    {
        (new Thread(new Runnable() {

            public void run()
            {
                LocalCache.a();
            }

        })).start();
    }

    private static void c()
    {
        JSONObject jsonobject = b;
        jsonobject;
        JVM INSTR monitorenter ;
        String s = b.toString();
        FileOperations.writeStringToFile(InternalSDKUtil.getContext(), "inmobi.cache", s, false);
_L1:
        return;
        Object obj;
        obj;
        Log.internal("[InMobi]-4.5.5", "Unable to save all configs to persistent memory", ((Throwable) (obj)));
          goto _L1
        obj;
        jsonobject;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public static JSONObject getCacheForProduct(String s)
    {
        if (b.toString().equals("{}"))
        {
            initRoot();
        }
        try
        {
            s = b.getJSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static JSONObject getRoot()
    {
        return b;
    }

    public static void initRoot()
    {
        if (b.toString().equals("{}")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject = b;
        jsonobject;
        JVM INSTR monitorenter ;
        String s1 = FileOperations.readFileAsString(InternalSDKUtil.getContext(), "inmobi.cache");
        String s;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        s = s1;
        if (!"".equals(s1))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Log.internal("[InMobi]-4.5.5", "Configs not present in persistence. Using default configs.");
        s = a;
        b = new JSONObject(s);
_L3:
        jsonobject;
        JVM INSTR monitorexit ;
        if (b.toString().equals("{}"))
        {
            try
            {
                b = new JSONObject(a);
                return;
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-4.5.5", "Default JSON root is unable to parse? What sorcery is this?", jsonexception);
            }
            return;
        }
          goto _L1
        Object obj;
        obj;
        Log.internal("[InMobi]-4.5.5", "Unable to read configs from persistent memory", ((Throwable) (obj)));
          goto _L3
        obj;
        jsonobject;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        Log.internal("[InMobi]-4.5.5", "Ill formed JSON while parsing from persistent memory", ((Throwable) (obj)));
          goto _L3
    }

    public static void reset()
    {
        b = new JSONObject();
        c();
        initRoot();
    }

    public static void saveRoot(JSONObject jsonobject)
    {
        b = jsonobject;
        b();
    }

}
