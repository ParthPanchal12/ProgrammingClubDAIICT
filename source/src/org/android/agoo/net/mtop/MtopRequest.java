// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import java.util.HashMap;
import java.util.Map;

public class MtopRequest
{

    public static final String SPLIT_STR = "&";
    private volatile String a;
    private volatile String b;
    private volatile String c;
    private volatile String d;
    private volatile String e;
    private volatile String f;
    private volatile String g;
    private volatile long h;
    private volatile boolean i;
    private String j;
    private Map k;
    private Map l;

    public MtopRequest()
    {
        h = -1L;
        i = true;
        k = null;
        l = null;
        k = new HashMap();
        l = new HashMap();
    }

    public String getApi()
    {
        return a;
    }

    public String getAppKey()
    {
        return f;
    }

    public String getAppSecret()
    {
        return j;
    }

    public String getDeviceId()
    {
        return g;
    }

    public String getEcode()
    {
        return e;
    }

    public Map getParams()
    {
        return k;
    }

    public String getSId()
    {
        return d;
    }

    public Map getSysParams()
    {
        return l;
    }

    public long getTime()
    {
        return h;
    }

    public String getTtId()
    {
        return c;
    }

    public String getV()
    {
        return b;
    }

    public boolean isHasSigin()
    {
        return i;
    }

    public void putParams(String s, Object obj)
    {
        k.put(s, obj);
    }

    public void putSysParams(String s, String s1)
    {
        k.put(s, s1);
    }

    public void setApi(String s)
    {
        a = s;
    }

    public void setAppKey(String s)
    {
        f = s;
    }

    public void setAppSecret(String s)
    {
        j = s;
    }

    public void setDeviceId(String s)
    {
        g = s;
    }

    public void setEcode(String s)
    {
        e = s;
    }

    public void setHasSigin(boolean flag)
    {
        i = flag;
    }

    public void setSId(String s)
    {
        d = s;
    }

    public void setTime(long l1)
    {
        h = l1;
    }

    public void setTtId(String s)
    {
        c = s;
    }

    public void setV(String s)
    {
        b = s;
    }
}
