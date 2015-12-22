// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMBanner, IMBannerListener, IMErrorCode

class c
    implements Runnable
{

    final int a;
    final AdErrorCode b;
    final Map c;
    final IMBanner d;

    public void run()
    {
        a;
        JVM INSTR tableswitch 100 105: default 180
    //                   100 57
    //                   101 84
    //                   102 125
    //                   103 108
    //                   104 142
    //                   105 159;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        Log.debug("[InMobi]-[Monetization]", b.toString());
        return;
_L2:
        try
        {
            IMBanner.a(d).onBannerRequestSucceeded(d);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Exception giving callback to the publisher ", exception);
        }
        return;
_L3:
        IMBanner.a(d).onBannerRequestFailed(d, IMErrorCode.a(b));
        return;
_L5:
        IMBanner.a(d).onDismissBannerScreen(d);
        return;
_L4:
        IMBanner.a(d).onShowBannerScreen(d);
        return;
_L6:
        IMBanner.a(d).onLeaveApplication(d);
        return;
_L7:
        IMBanner.a(d).onBannerInteraction(d, c);
        return;
    }

    ErrorCode(IMBanner imbanner, int i, AdErrorCode aderrorcode, Map map)
    {
        d = imbanner;
        a = i;
        b = aderrorcode;
        c = map;
        super();
    }
}
