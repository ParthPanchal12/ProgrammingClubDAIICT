// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AutomaticCaptureConfig
{

    private boolean a;
    private boolean b;
    private boolean c;

    public AutomaticCaptureConfig()
    {
        a = true;
        b = false;
        c = false;
    }

    public boolean isAutoLocationCaptureEnabled()
    {
        return c;
    }

    public boolean isAutoPurchaseCaptureEnabled()
    {
        return b;
    }

    public boolean isAutoSessionCaptureEnabled()
    {
        return a;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getBooleanFromMap(map, "session");
        b = InternalSDKUtil.getBooleanFromMap(map, "purchase");
        c = InternalSDKUtil.getBooleanFromMap(map, "location");
    }
}
