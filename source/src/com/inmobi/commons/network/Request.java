// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.network:
//            RequestBuilderUtils

public class Request
{
    public static final class Format extends Enum
    {

        public static final Format JSON;
        public static final Format KEY_VAL;
        private static final Format a[];

        public static Format valueOf(String s)
        {
            return (Format)Enum.valueOf(com/inmobi/commons/network/Request$Format, s);
        }

        public static Format[] values()
        {
            return (Format[])a.clone();
        }

        static 
        {
            KEY_VAL = new Format("KEY_VAL", 0);
            JSON = new Format("JSON", 1);
            a = (new Format[] {
                KEY_VAL, JSON
            });
        }

        private Format(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Method extends Enum
    {

        public static final Method GET;
        public static final Method POST;
        public static final Method PUT;
        private static final Method a[];

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(com/inmobi/commons/network/Request$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])a.clone();
        }

        static 
        {
            GET = new Method("GET", 0);
            POST = new Method("POST", 1);
            PUT = new Method("PUT", 2);
            a = (new Method[] {
                GET, POST, PUT
            });
        }

        private Method(String s, int i)
        {
            super(s, i);
        }
    }


    protected static HashMap mHeaders;
    private Format a;
    private final String b = "User-Agent";
    private String c;
    private Method d;
    private int e;
    protected HashMap mReqParams;

    public Request(String s, Format format, Method method)
    {
        a = Format.KEY_VAL;
        c = null;
        d = Method.POST;
        e = 0;
        mReqParams = new HashMap();
        mHeaders = new HashMap();
        RequestBuilderUtils.fillIdentityMap(mReqParams, null, true);
        mHeaders.put("User-Agent", InternalSDKUtil.getUserAgent());
        a = format;
        c = s;
        d = method;
    }

    private String a()
    {
        Map map = InternalSDKUtil.getEncodedMap(mReqParams);
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Format.values().length];
                try
                {
                    a[Format.KEY_VAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Format.JSON.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return InternalSDKUtil.encodeMapAndconvertToDelimitedString(mReqParams, "&");

        case 2: // '\002'
            return (new JSONObject(map)).toString();
        }
    }

    public void fillAppInfo()
    {
        RequestBuilderUtils.fillAppInfoMap(mReqParams);
    }

    public void fillCustomInfo(Map map)
    {
        if (map != null)
        {
            mReqParams.putAll(map);
        }
    }

    public void fillDemogInfo()
    {
        RequestBuilderUtils.fillDemogMap(mReqParams);
    }

    public void fillDeviceInfo()
    {
        RequestBuilderUtils.fillDeviceMap(mReqParams);
    }

    public void fillLocationInfo()
    {
        RequestBuilderUtils.fillLocationMap(mReqParams);
    }

    public Map getHeaders()
    {
        return InternalSDKUtil.getEncodedMap(mHeaders);
    }

    protected String getPostBody()
    {
        if (d != Method.GET)
        {
            return a();
        } else
        {
            return null;
        }
    }

    protected String getQueryParams()
    {
        if (d == Method.GET)
        {
            return a();
        } else
        {
            return null;
        }
    }

    protected Method getRequestMethod()
    {
        return d;
    }

    public int getTimeout()
    {
        return e;
    }

    protected String getUrl()
    {
        return c;
    }

    public void setTimeout(int i)
    {
        e = i;
    }

    protected void setUrl(String s)
    {
        boolean flag1 = true;
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ("".equals(s.trim()))
        {
            flag1 = false;
        }
        if (flag & flag1)
        {
            c = s;
        }
    }
}
