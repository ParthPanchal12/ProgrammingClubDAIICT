// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.RequestBuilderUtils;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import com.inmobi.monetization.internal.configs.PkParams;
import java.util.HashMap;
import java.util.Map;

class c extends Request
{

    protected static String a = "http://i.w.inmobi.com/showad.asm";
    private static byte e[];
    String b;
    String c;
    String d;
    private byte f[];
    private byte g[];

    public c()
    {
        super(a, com.inmobi.commons.network.Request.Format.KEY_VAL, com.inmobi.commons.network.Request.Method.POST);
        b = "";
        c = "";
        d = "";
        RequestBuilderUtils.fillIdentityMap(mReqParams, Initializer.getConfigParams().getDeviceIdMaskMap(), false);
        RequestBuilderUtils.fillAppInfoMap(mReqParams);
        RequestBuilderUtils.fillDemogMap(mReqParams);
        RequestBuilderUtils.fillDeviceMap(mReqParams);
        RequestBuilderUtils.fillLocationMap(mReqParams);
        setTimeout(Initializer.getConfigParams().getFetchTimeOut());
    }

    String a(String s)
    {
        HashMap hashmap = new HashMap();
        g = EncryptionUtils.generateKey(8);
        f = EncryptionUtils.generateKey(16);
        e = EncryptionUtils.keag();
        b = PkInitilaizer.getConfigParams().getExponent();
        c = PkInitilaizer.getConfigParams().getModulus();
        d = PkInitilaizer.getConfigParams().getVersion();
        if (b.equals("") || c.equals("") || d.equals(""))
        {
            Log.debug("[InMobi]-[Monetization]", "Exception retreiving Ad due to key problem");
            return null;
        } else
        {
            hashmap.put("sm", EncryptionUtils.SeMeGe(s, e, f, g, c, b));
            hashmap.put("sn", d);
            return InternalSDKUtil.encodeMapAndconvertToDelimitedString(hashmap, "&");
        }
    }

    void a(Map map)
    {
        if (mReqParams != null && map != null && !map.isEmpty())
        {
            mReqParams.putAll(map);
        }
    }

    byte[] a()
    {
        return f;
    }

    void b(Map map)
    {
        if (mReqParams != null && map != null)
        {
            mReqParams.putAll(map);
        }
    }

    byte[] b()
    {
        return e;
    }

    protected String getPostBody()
    {
        String s = super.getPostBody();
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Raw Postbody: ").append(s).toString());
        return a(s);
    }

    protected void setUrl(String s)
    {
        super.setUrl(s);
    }

}
