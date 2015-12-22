// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;


// Referenced classes of package com.inmobi.commons.analytics.iat.impl:
//            AdTrackerConstants

public static final class I extends Enum
{

    public static final RELOAD_WEBVIEW_ERROR APP_ANALYTICS_PREVIOUSLY_UPLOADED;
    public static final RELOAD_WEBVIEW_ERROR APP_ANALYTICS_UPLOAD_FAILURE;
    public static final RELOAD_WEBVIEW_ERROR APP_ANALYTICS_UPLOAD_SUCCESS;
    public static final RELOAD_WEBVIEW_ERROR APP_CONTEXT_NULL;
    public static final RELOAD_WEBVIEW_ERROR APP_NOT_CONNECTED;
    public static final RELOAD_WEBVIEW_ERROR ODIN1_NULL;
    public static final RELOAD_WEBVIEW_ERROR RELOAD_WEBVIEW_ERROR;
    private static final RELOAD_WEBVIEW_ERROR a[];

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/inmobi/commons/analytics/iat/impl/AdTrackerConstants$StatusCode, s);
    }

    public static I[] values()
    {
        return (I[])a.clone();
    }

    static 
    {
        APP_ANALYTICS_UPLOAD_SUCCESS = new <init>("APP_ANALYTICS_UPLOAD_SUCCESS", 0);
        APP_CONTEXT_NULL = new <init>("APP_CONTEXT_NULL", 1);
        APP_ANALYTICS_PREVIOUSLY_UPLOADED = new <init>("APP_ANALYTICS_PREVIOUSLY_UPLOADED", 2);
        ODIN1_NULL = new <init>("ODIN1_NULL", 3);
        APP_ANALYTICS_UPLOAD_FAILURE = new <init>("APP_ANALYTICS_UPLOAD_FAILURE", 4);
        APP_NOT_CONNECTED = new <init>("APP_NOT_CONNECTED", 5);
        RELOAD_WEBVIEW_ERROR = new <init>("RELOAD_WEBVIEW_ERROR", 6);
        a = (new a[] {
            APP_ANALYTICS_UPLOAD_SUCCESS, APP_CONTEXT_NULL, APP_ANALYTICS_PREVIOUSLY_UPLOADED, ODIN1_NULL, APP_ANALYTICS_UPLOAD_FAILURE, APP_NOT_CONNECTED, RELOAD_WEBVIEW_ERROR
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
