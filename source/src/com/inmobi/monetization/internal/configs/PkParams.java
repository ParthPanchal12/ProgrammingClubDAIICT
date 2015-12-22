// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public class PkParams
{

    public static String SK_ALGORITHM = "";
    public static String SK_EXPONENT = "";
    public static String SK_MODULUS = "";
    public static String SK_VERSION = "";
    private Map a;

    public PkParams()
    {
    }

    public String getAlgorithm()
    {
        return SK_ALGORITHM;
    }

    public Map getDeviceIdMaskMap()
    {
        return a;
    }

    public String getExponent()
    {
        return SK_EXPONENT;
    }

    public String getModulus()
    {
        return SK_MODULUS;
    }

    public String getVersion()
    {
        return SK_VERSION;
    }

    public void setFromMap(Map map)
    {
        map = (Map)map.get("pk");
        SK_VERSION = InternalSDKUtil.getStringFromMap(map, "ver");
        if (SK_VERSION.equals(""))
        {
            Log.internal("[InMobi]-4.5.5", "Key ver has illegal value");
            throw new IllegalArgumentException();
        }
        SK_ALGORITHM = InternalSDKUtil.getStringFromMap(map, "alg");
        if (SK_ALGORITHM.equals(""))
        {
            Log.internal("[InMobi]-4.5.5", "Key alg has illegal value");
            throw new IllegalArgumentException();
        }
        if (SK_ALGORITHM.equalsIgnoreCase("rsa"))
        {
            map = (Map)map.get("val");
            SK_EXPONENT = InternalSDKUtil.getStringFromMap(map, "e");
            SK_MODULUS = InternalSDKUtil.getStringFromMap(map, "m");
            if (SK_MODULUS.equals(""))
            {
                Log.internal("[InMobi]-4.5.5", "Key m has illegal value");
                throw new IllegalArgumentException();
            }
            if (SK_EXPONENT.equals(""))
            {
                Log.internal("[InMobi]-4.5.5", "Key e has illegal value");
                throw new IllegalArgumentException();
            }
            if (!InternalSDKUtil.isHexString(SK_EXPONENT))
            {
                Log.internal("[InMobi]-4.5.5", "Key e has illegal value");
                throw new IllegalArgumentException();
            }
            if (!InternalSDKUtil.isHexString(SK_MODULUS))
            {
                Log.internal("[InMobi]-4.5.5", "Key m has illegal value");
                throw new IllegalArgumentException();
            }
        }
    }

}
