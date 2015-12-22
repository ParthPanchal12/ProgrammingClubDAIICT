// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import java.util.HashMap;
import java.util.Map;

public class Result
{

    private volatile boolean a;
    private volatile int b;
    private volatile String c;
    private volatile String d;
    private volatile String e;
    private Map f;

    public Result()
    {
        f = new HashMap();
    }

    public String getData()
    {
        return c;
    }

    public Map getHeaders()
    {
        return f;
    }

    public int getHttpCode()
    {
        return b;
    }

    public String getRetCode()
    {
        return e;
    }

    public String getRetDesc()
    {
        return d;
    }

    public boolean isSuccess()
    {
        return a;
    }

    public void setData(String s)
    {
        c = s;
    }

    public void setHeaders(Map map)
    {
        f.putAll(map);
    }

    public void setHttpCode(int i)
    {
        b = i;
    }

    public void setRetCode(String s)
    {
        e = s;
    }

    public void setRetDesc(String s)
    {
        d = s;
    }

    public void setSuccess(boolean flag)
    {
        a = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Result [isSuccess=").append(a).append(", httpCode=").append(b).append(", data=").append(c).append(", retDesc=").append(d).append(", retCode=").append(e).append(", headers=").append(f).append("]").toString();
    }
}
