// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.doubleclick;

import com.google.ads.mediation.admob.AdMobAdapterExtras;
import java.util.Map;

public class DfpExtras extends AdMobAdapterExtras
{

    private String a;

    public DfpExtras()
    {
    }

    public DfpExtras(DfpExtras dfpextras)
    {
        super(dfpextras);
        if (dfpextras != null)
        {
            a = dfpextras.a;
        }
    }

    public DfpExtras addExtra(String s, Object obj)
    {
        super.addExtra(s, obj);
        return this;
    }

    public volatile AdMobAdapterExtras addExtra(String s, Object obj)
    {
        return addExtra(s, obj);
    }

    public DfpExtras clearExtras()
    {
        super.clearExtras();
        return this;
    }

    public volatile AdMobAdapterExtras clearExtras()
    {
        return clearExtras();
    }

    public String getPublisherProvidedId()
    {
        return a;
    }

    public DfpExtras setExtras(Map map)
    {
        super.setExtras(map);
        return this;
    }

    public volatile AdMobAdapterExtras setExtras(Map map)
    {
        return setExtras(map);
    }

    public DfpExtras setPlusOneOptOut(boolean flag)
    {
        super.setPlusOneOptOut(flag);
        return this;
    }

    public volatile AdMobAdapterExtras setPlusOneOptOut(boolean flag)
    {
        return setPlusOneOptOut(flag);
    }

    public DfpExtras setPublisherProvidedId(String s)
    {
        a = s;
        return this;
    }

    public DfpExtras setUseExactAdSize(boolean flag)
    {
        super.setUseExactAdSize(flag);
        return this;
    }

    public volatile AdMobAdapterExtras setUseExactAdSize(boolean flag)
    {
        return setUseExactAdSize(flag);
    }
}
