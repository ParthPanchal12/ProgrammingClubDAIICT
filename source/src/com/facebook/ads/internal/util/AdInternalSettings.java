// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import java.util.Map;

public class AdInternalSettings
{

    private static Map a;

    public AdInternalSettings()
    {
    }

    public static Map getCustomInitParams()
    {
        return a;
    }

    public static void setCustomInitParams(Map map)
    {
        a = map;
    }
}
