// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.uid:
//            a, AdvertisingId

public class UID
{

    public static final String KEY_AID = "AID";
    public static final String KEY_APPENDED_ID = "AIDL";
    public static final String KEY_FACEBOOK_ID = "FBA";
    public static final String KEY_GPID = "GPID";
    public static final String KEY_IMID = "IMID";
    public static final String KEY_LOGIN_ID = "LID";
    public static final String KEY_LTVID = "LTVID";
    public static final String KEY_ODIN1 = "O1";
    public static final String KEY_SESSION_ID = "SID";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_UM5_ID = "UM5";
    private static UID a;
    private Map b;
    private Map c;
    private Map d;
    private String e;
    private String f;

    private UID()
    {
        f = null;
        d = new HashMap();
        d.put("FBA", Boolean.valueOf(false));
        d.put("GPID", Boolean.valueOf(true));
        d.put("LID", Boolean.valueOf(true));
        d.put("LTVID", Boolean.valueOf(true));
        d.put("O1", Boolean.valueOf(true));
        d.put("SID", Boolean.valueOf(true));
        d.put("UM5", Boolean.valueOf(true));
        d.put("IMID", Boolean.valueOf(true));
        d.put("AIDL", Boolean.valueOf(true));
    }

    private String a()
    {
        return e;
    }

    private Map a(int i)
    {
        HashMap hashmap = new HashMap();
        if ((i & 4) == 4 || i == 0)
        {
            hashmap.put("FBA", Boolean.valueOf(false));
        }
        if ((i & 2) == 2 || i == 0)
        {
            hashmap.put("O1", Boolean.valueOf(false));
        }
        if ((i & 8) == 8 || i == 0)
        {
            hashmap.put("UM5", Boolean.valueOf(false));
        }
        return hashmap;
    }

    private Map a(Map map)
    {
        HashMap hashmap = new HashMap(d);
        if (map == null && c == null && b == null)
        {
            return hashmap;
        }
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        if (c == null)
        {
            c = new HashMap();
        }
        if (b == null)
        {
            b = new HashMap();
        }
        map = c.keySet().iterator();
        while (map.hasNext()) 
        {
            String s = (String)map.next();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (c.get(s) == null)
            {
                flag = true;
            } else
            {
                flag = ((Boolean)c.get(s)).booleanValue();
            }
            if (b.get(s) == null)
            {
                flag1 = true;
            } else
            {
                flag1 = ((Boolean)b.get(s)).booleanValue();
            }
            if (((Map) (obj)).get(s) == null)
            {
                flag2 = true;
            } else
            {
                flag2 = ((Boolean)((Map) (obj)).get(s)).booleanValue();
            }
            hashmap.put(s, Boolean.valueOf(Boolean.valueOf(flag2).booleanValue() & Boolean.valueOf(flag).booleanValue() & Boolean.valueOf(flag1).booleanValue()));
        }
        return hashmap;
    }

    public static UID getInstance()
    {
        if (a == null)
        {
            a = new UID();
        }
        return a;
    }

    public String getEncodedJSON(Map map)
    {
        map = getUidMap(map, null, false);
        InternalSDKUtil.getEncodedMap(map);
        return (new JSONObject(map)).toString();
    }

    public String getEncryptedJSON(Map map)
    {
        return (new JSONObject(InternalSDKUtil.getEncodedMap(getMapForEncryption(map)))).toString();
    }

    public String getJSON(Map map)
    {
        return (new JSONObject(getRawUidMap(map))).toString();
    }

    public Map getMapForEncryption(Map map)
    {
        String s = Integer.toString((new Random()).nextInt());
        map = InternalSDKUtil.encryptRSA((new JSONObject(getUidMap(map, s, true))).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("u-id-map", map);
        hashmap.put("u-id-key", s);
        hashmap.put("u-key-ver", com.inmobi.commons.uid.a.a());
        return hashmap;
    }

    public Map getRawUidMap(Map map)
    {
        return getUidMap(map, null, false);
    }

    public Map getUidMap(Map map, String s, boolean flag)
    {
        Map map1 = a(map);
        HashMap hashmap = new HashMap();
        if (f == null)
        {
            f = com.inmobi.commons.uid.a.e();
        }
        if (((Boolean)map1.get("O1")).booleanValue() && !com.inmobi.commons.uid.a.h())
        {
            String s1 = com.inmobi.commons.uid.a.a(f);
            map = s1;
            if (flag)
            {
                map = InternalSDKUtil.xorWithKey(s1, s);
            }
            hashmap.put("O1", map);
        }
        if (((Boolean)map1.get("FBA")).booleanValue())
        {
            String s2 = com.inmobi.commons.uid.a.d();
            if (s2 != null)
            {
                map = s2;
                if (flag)
                {
                    map = InternalSDKUtil.xorWithKey(s2, s);
                }
                hashmap.put("FBA", map);
            }
        }
        if (((Boolean)map1.get("UM5")).booleanValue() && !com.inmobi.commons.uid.a.h())
        {
            String s3 = com.inmobi.commons.uid.a.b(f);
            map = s3;
            if (flag)
            {
                map = InternalSDKUtil.xorWithKey(s3, s);
            }
            hashmap.put("UM5", map);
        }
        if (((Boolean)map1.get("LID")).booleanValue())
        {
            String s4 = com.inmobi.commons.uid.a.c();
            if (s4 != null)
            {
                map = s4;
                if (flag)
                {
                    map = InternalSDKUtil.xorWithKey(s4, s);
                }
                hashmap.put("LID", map);
            }
        }
        if (((Boolean)map1.get("SID")).booleanValue())
        {
            String s5 = com.inmobi.commons.uid.a.b();
            if (s5 != null)
            {
                map = s5;
                if (flag)
                {
                    map = InternalSDKUtil.xorWithKey(s5, s);
                }
                hashmap.put("SID", map);
            }
        }
        if (((Boolean)map1.get("LTVID")).booleanValue())
        {
            String s6 = a();
            if (s6 != null)
            {
                map = s6;
                if (flag)
                {
                    map = InternalSDKUtil.xorWithKey(s6, s);
                }
                hashmap.put("LTVID", map);
            }
        }
        if (((Boolean)map1.get("GPID")).booleanValue())
        {
            map = com.inmobi.commons.uid.a.f();
            if (map != null)
            {
                String s7 = map.getAdId();
                if (s7 != null)
                {
                    map = s7;
                    if (flag)
                    {
                        map = InternalSDKUtil.xorWithKey(s7, s);
                    }
                    hashmap.put("GPID", map);
                }
            }
        }
        if (((Boolean)map1.get("IMID")).booleanValue())
        {
            String s8 = com.inmobi.commons.uid.a.b(InternalSDKUtil.getContext());
            if (s8 != null)
            {
                map = s8;
                if (flag)
                {
                    map = InternalSDKUtil.xorWithKey(s8, s);
                }
                hashmap.put("IMID", map);
            }
        }
        if (((Boolean)map1.get("AIDL")).booleanValue())
        {
            String s9 = com.inmobi.commons.uid.a.c(InternalSDKUtil.getContext());
            if (s9 != null)
            {
                map = s9;
                if (flag)
                {
                    map = InternalSDKUtil.xorWithKey(s9, s);
                }
                hashmap.put("AIDL", map);
            }
        }
        return hashmap;
    }

    public void init()
    {
        com.inmobi.commons.uid.a.g();
        printPublisherTestId();
        com.inmobi.commons.uid.a.a(InternalSDKUtil.getContext());
    }

    public boolean isLimitAdTrackingEnabled()
    {
        return com.inmobi.commons.uid.a.i();
    }

    public void printPublisherTestId()
    {
        Object obj;
        if (!com.inmobi.commons.uid.a.h())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = com.inmobi.commons.uid.a.f();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = ((AdvertisingId) (obj)).getAdId();
        if (obj != null)
        {
            try
            {
                Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("Publisher device Id is ").append(((String) (obj))).toString());
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.5.5", "Cannot get publisher device id", exception);
            }
        }
        break MISSING_BLOCK_LABEL_89;
        obj = com.inmobi.commons.uid.a.e();
        Log.debug("[InMobi]-4.5.5", (new StringBuilder()).append("Publisher device Id is ").append(com.inmobi.commons.uid.a.a(((String) (obj)))).toString());
        return;
    }

    public void refresh()
    {
        com.inmobi.commons.uid.a.g();
    }

    public void setCommonsDeviceIdMaskMap(Map map)
    {
        c = map;
    }

    public void setLtvId(String s)
    {
        e = s;
    }

    public void setPublisherDeviceIdMaskMap(int i)
    {
        b = a(i);
    }
}
