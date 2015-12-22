// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;


public final class ErrorCode extends Enum
{

    public static final ErrorCode CONNECTION_ERROR;
    public static final ErrorCode INTERNAL_ERROR;
    public static final ErrorCode INVALID_REQUEST;
    public static final ErrorCode NETWORK_ERROR;
    private static final ErrorCode b[];
    private String a;

    private ErrorCode(String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }

    public static ErrorCode valueOf(String s)
    {
        return (ErrorCode)Enum.valueOf(com/inmobi/commons/network/ErrorCode, s);
    }

    public static ErrorCode[] values()
    {
        return (ErrorCode[])b.clone();
    }

    public void setMessage(String s)
    {
        a = s;
    }

    public String toString()
    {
        return a;
    }

    static 
    {
        INVALID_REQUEST = new ErrorCode("INVALID_REQUEST", 0, "Invalid request");
        INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 1, "An internal error occurred while fetching");
        CONNECTION_ERROR = new ErrorCode("CONNECTION_ERROR", 2, "Socket timeout exception");
        NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 3, "Network failure. Check your connection");
        b = (new ErrorCode[] {
            INVALID_REQUEST, INTERNAL_ERROR, CONNECTION_ERROR, NETWORK_ERROR
        });
    }
}
