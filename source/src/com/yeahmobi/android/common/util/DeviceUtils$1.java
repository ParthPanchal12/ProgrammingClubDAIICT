// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;


// Referenced classes of package com.yeahmobi.android.common.util:
//            DeviceUtils

static class 
{

    static final int $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP[];

    static 
    {
        $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP = new int[.values().length];
        try
        {
            $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP[.IPv4.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$yeahmobi$android$common$util$DeviceUtils$IP[.IPv6.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
