// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


public final class AdErrorCode extends Enum
{

    public static final AdErrorCode ADREQUEST_CANCELLED;
    public static final AdErrorCode AD_CLICK_IN_PROGRESS;
    public static final AdErrorCode AD_DOWNLOAD_IN_PROGRESS;
    public static final AdErrorCode AD_RENDERING_TIMEOUT;
    public static final AdErrorCode DO_MONETIZE;
    public static final AdErrorCode DO_NOTHING;
    public static final AdErrorCode INTERNAL_ERROR;
    public static final AdErrorCode INVALID_APP_ID;
    public static final AdErrorCode INVALID_REQUEST;
    public static final AdErrorCode NETWORK_ERROR;
    public static final AdErrorCode NO_FILL;
    private static final AdErrorCode b[];
    private String a;

    private AdErrorCode(String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }

    public static AdErrorCode valueOf(String s)
    {
        return (AdErrorCode)Enum.valueOf(com/inmobi/monetization/internal/AdErrorCode, s);
    }

    public static AdErrorCode[] values()
    {
        return (AdErrorCode[])b.clone();
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
        INVALID_REQUEST = new AdErrorCode("INVALID_REQUEST", 0, "Invalid ad request");
        INTERNAL_ERROR = new AdErrorCode("INTERNAL_ERROR", 1, "An error occurred while fetching the ad");
        NO_FILL = new AdErrorCode("NO_FILL", 2, "The ad request was successful, but no ad was returned");
        AD_CLICK_IN_PROGRESS = new AdErrorCode("AD_CLICK_IN_PROGRESS", 3, "Ad click is in progress, cannot load new ad");
        AD_DOWNLOAD_IN_PROGRESS = new AdErrorCode("AD_DOWNLOAD_IN_PROGRESS", 4, "Ad download is in progress, cannot load new ad");
        INVALID_APP_ID = new AdErrorCode("INVALID_APP_ID", 5, "Invalid App Id");
        ADREQUEST_CANCELLED = new AdErrorCode("ADREQUEST_CANCELLED", 6, "Stop loading invoked on the ad");
        AD_RENDERING_TIMEOUT = new AdErrorCode("AD_RENDERING_TIMEOUT", 7, "Failed to render ad");
        DO_MONETIZE = new AdErrorCode("DO_MONETIZE", 8, "Please load a mediation network");
        DO_NOTHING = new AdErrorCode("DO_NOTHING", 9, "No Ads");
        NETWORK_ERROR = new AdErrorCode("NETWORK_ERROR", 10, "Ad network failed to retrieve ad");
        b = (new AdErrorCode[] {
            INVALID_REQUEST, INTERNAL_ERROR, NO_FILL, AD_CLICK_IN_PROGRESS, AD_DOWNLOAD_IN_PROGRESS, INVALID_APP_ID, ADREQUEST_CANCELLED, AD_RENDERING_TIMEOUT, DO_MONETIZE, DO_NOTHING, 
            NETWORK_ERROR
        });
    }
}
