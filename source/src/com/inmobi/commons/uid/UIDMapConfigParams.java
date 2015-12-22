// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class UIDMapConfigParams
{

    private Map a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;

    public UIDMapConfigParams()
    {
        b = true;
        c = true;
        d = false;
        e = true;
        f = true;
        g = true;
        h = true;
        i = true;
        j = true;
    }

    public boolean getAIDL()
    {
        return j;
    }

    public boolean getFacebookID()
    {
        return d;
    }

    public boolean getGPID()
    {
        return h;
    }

    public boolean getIMID()
    {
        return i;
    }

    public boolean getLTVID()
    {
        return g;
    }

    public boolean getLoginID()
    {
        return b;
    }

    public Map getMap()
    {
        return a;
    }

    public boolean getODIN1()
    {
        return e;
    }

    public boolean getSessionID()
    {
        return c;
    }

    public boolean getUM5()
    {
        return f;
    }

    public void setAIDL(boolean flag)
    {
        j = flag;
    }

    public void setFacebookID(boolean flag)
    {
        d = flag;
    }

    public void setGPID(boolean flag)
    {
        h = flag;
    }

    public void setIMID(boolean flag)
    {
        i = flag;
    }

    public void setLTVID(boolean flag)
    {
        g = flag;
    }

    public void setLoginID(boolean flag)
    {
        b = flag;
    }

    public void setMap(Object obj)
    {
        Map map = (Map)obj;
        b = InternalSDKUtil.getBooleanFromMap(map, "LID");
        c = InternalSDKUtil.getBooleanFromMap(map, "SID");
        d = InternalSDKUtil.getBooleanFromMap(map, "FBA");
        e = InternalSDKUtil.getBooleanFromMap(map, "O1");
        f = InternalSDKUtil.getBooleanFromMap(map, "UM5");
        g = InternalSDKUtil.getBooleanFromMap(map, "LTVID");
        h = InternalSDKUtil.getBooleanFromMap(map, "GPID");
        i = InternalSDKUtil.getBooleanFromMap(map, "IMID");
        j = InternalSDKUtil.getBooleanFromMap(map, "AIDL");
        a = (Map)obj;
    }

    public void setODIN1(boolean flag)
    {
        e = flag;
    }

    public void setSessionID(boolean flag)
    {
        c = flag;
    }

    public void setUM5(boolean flag)
    {
        f = flag;
    }
}
