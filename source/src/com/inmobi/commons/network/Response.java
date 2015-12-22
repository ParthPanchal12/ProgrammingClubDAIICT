// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;

import java.util.Map;

// Referenced classes of package com.inmobi.commons.network:
//            ErrorCode

public class Response
{

    String a;
    int b;
    Map c;
    ErrorCode d;

    public Response(ErrorCode errorcode)
    {
        a = null;
        b = 0;
        c = null;
        d = errorcode;
    }

    public Response(String s, int i, Map map)
    {
        a = null;
        b = 0;
        c = null;
        a = s;
        b = i;
        c = map;
    }

    public ErrorCode getError()
    {
        return d;
    }

    public Map getHeaders()
    {
        return c;
    }

    public String getResponseBody()
    {
        return a;
    }

    public int getStatusCode()
    {
        return b;
    }
}
