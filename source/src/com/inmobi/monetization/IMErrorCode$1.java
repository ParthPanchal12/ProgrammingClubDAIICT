// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;

// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode

static class orCode
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
