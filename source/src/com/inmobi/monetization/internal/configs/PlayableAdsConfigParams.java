// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class PlayableAdsConfigParams
{

    String a;
    String b;

    public PlayableAdsConfigParams()
    {
        a = "3b3941b6-4683-400a-a542-6ccd3d13abe6";
        b = "f1478eab-8535-4c85-8ab7-5bdf3f2f7706";
    }

    public String getSecretKey()
    {
        return b;
    }

    public String getSecretToken()
    {
        return a;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getStringFromMap(map, "st");
        b = InternalSDKUtil.getStringFromMap(map, "sk");
    }
}
