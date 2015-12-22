// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;

public final class IMErrorCode extends Enum
{

    public static final IMErrorCode DO_MONETIZE;
    public static final IMErrorCode DO_NOTHING;
    public static final IMErrorCode INTERNAL_ERROR;
    public static final IMErrorCode INVALID_REQUEST;
    public static final IMErrorCode NETWORK_ERROR;
    public static final IMErrorCode NO_FILL;
    private static final IMErrorCode b[];
    private String a;

    private IMErrorCode(String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }

    static IMErrorCode a(AdErrorCode aderrorcode)
    {
        IMErrorCode imerrorcode = INTERNAL_ERROR;
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[AdErrorCode.values().length];
                try
                {
                    a[AdErrorCode.INVALID_REQUEST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[AdErrorCode.AD_CLICK_IN_PROGRESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[AdErrorCode.AD_DOWNLOAD_IN_PROGRESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[AdErrorCode.INVALID_APP_ID.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[AdErrorCode.AD_RENDERING_TIMEOUT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[AdErrorCode.INTERNAL_ERROR.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[AdErrorCode.NO_FILL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[AdErrorCode.NETWORK_ERROR.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdErrorCode.DO_MONETIZE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdErrorCode.DO_NOTHING.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[aderrorcode.ordinal()];
        JVM INSTR tableswitch 1 10: default 68
    //                   1 82
    //                   2 82
    //                   3 82
    //                   4 82
    //                   5 89
    //                   6 89
    //                   7 96
    //                   8 103
    //                   9 110
    //                   10 117;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L3 _L4 _L5 _L6 _L7
_L1:
        imerrorcode = INTERNAL_ERROR;
_L9:
        imerrorcode.setMessage(aderrorcode.toString());
        return imerrorcode;
_L2:
        imerrorcode = INVALID_REQUEST;
        continue; /* Loop/switch isn't completed */
_L3:
        imerrorcode = INTERNAL_ERROR;
        continue; /* Loop/switch isn't completed */
_L4:
        imerrorcode = NO_FILL;
        continue; /* Loop/switch isn't completed */
_L5:
        imerrorcode = NETWORK_ERROR;
        continue; /* Loop/switch isn't completed */
_L6:
        imerrorcode = DO_MONETIZE;
        continue; /* Loop/switch isn't completed */
_L7:
        imerrorcode = DO_NOTHING;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static IMErrorCode valueOf(String s)
    {
        return (IMErrorCode)Enum.valueOf(com/inmobi/monetization/IMErrorCode, s);
    }

    public static IMErrorCode[] values()
    {
        return (IMErrorCode[])b.clone();
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
        INVALID_REQUEST = new IMErrorCode("INVALID_REQUEST", 0, "Invalid ad request");
        INTERNAL_ERROR = new IMErrorCode("INTERNAL_ERROR", 1, "An error occurred while fetching the ad");
        NO_FILL = new IMErrorCode("NO_FILL", 2, "The ad request was successful, but no ad was returned");
        DO_MONETIZE = new IMErrorCode("DO_MONETIZE", 3, "Please load a mediation network");
        DO_NOTHING = new IMErrorCode("DO_NOTHING", 4, "No Ads");
        NETWORK_ERROR = new IMErrorCode("NETWORK_ERROR", 5, "Ad network failed to retrieve ad");
        b = (new IMErrorCode[] {
            INVALID_REQUEST, INTERNAL_ERROR, NO_FILL, DO_MONETIZE, DO_NOTHING, NETWORK_ERROR
        });
    }
}
