// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial, IMInterstitialListener, IMErrorCode, IMIncentivisedListener

class c
    implements Runnable
{

    final int a;
    final AdErrorCode b;
    final Map c;
    final IMInterstitial d;

    public void run()
    {
        a;
        JVM INSTR tableswitch 100 106: default 48
    //                   100 61
    //                   101 78
    //                   102 119
    //                   103 102
    //                   104 136
    //                   105 153
    //                   106 174;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        Log.debug("[InMobi]-[Monetization]", b.toString());
_L10:
        return;
_L2:
        IMInterstitial.a(d).onInterstitialLoaded(d);
        return;
_L3:
        IMInterstitial.a(d).onInterstitialFailed(d, IMErrorCode.a(b));
        return;
_L5:
        IMInterstitial.a(d).onDismissInterstitialScreen(d);
        return;
_L4:
        IMInterstitial.a(d).onShowInterstitialScreen(d);
        return;
_L6:
        IMInterstitial.a(d).onLeaveApplication(d);
        return;
_L7:
        IMInterstitial.a(d).onInterstitialInteraction(d, c);
        return;
_L8:
        if (IMInterstitial.b(d) != null)
        {
            IMInterstitial.b(d).onIncentCompleted(d, c);
            return;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    ode(IMInterstitial iminterstitial, int i, AdErrorCode aderrorcode, Map map)
    {
        d = iminterstitial;
        a = i;
        b = aderrorcode;
        c = map;
        super();
    }
}
