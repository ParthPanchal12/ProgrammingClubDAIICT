// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras
    implements NetworkExtras
{

    private boolean a;
    private Map b;

    public AdMobAdapterExtras()
    {
        a = false;
        clearExtras();
    }

    public AdMobAdapterExtras(AdMobAdapterExtras admobadapterextras)
    {
        this();
        if (admobadapterextras != null)
        {
            a = admobadapterextras.a;
            b.putAll(admobadapterextras.b);
        }
    }

    public AdMobAdapterExtras addExtra(String s, Object obj)
    {
        b.put(s, obj);
        return this;
    }

    public AdMobAdapterExtras clearExtras()
    {
        b = new HashMap();
        return this;
    }

    public Map getExtras()
    {
        return b;
    }

    public boolean getPlusOneOptOut()
    {
        return false;
    }

    public boolean getUseExactAdSize()
    {
        return a;
    }

    public AdMobAdapterExtras setExtras(Map map)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("Argument 'extras' may not be null");
        } else
        {
            b = map;
            return this;
        }
    }

    public AdMobAdapterExtras setPlusOneOptOut(boolean flag)
    {
        return this;
    }

    public AdMobAdapterExtras setUseExactAdSize(boolean flag)
    {
        a = flag;
        return this;
    }
}
