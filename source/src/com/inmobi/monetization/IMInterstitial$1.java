// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial

class a
    implements IMAdListener
{

    final IMInterstitial a;

    public void onAdInteraction(Map map)
    {
        IMInterstitial.a(a, 105, null, map);
    }

    public void onAdRequestFailed(AdErrorCode aderrorcode)
    {
        IMInterstitial.a(a, ate.INIT);
        IMInterstitial.a(a, 101, aderrorcode, null);
    }

    public void onAdRequestSucceeded()
    {
        IMInterstitial.a(a, ate.READY);
        IMInterstitial.a(a, 100, null, null);
    }

    public void onDismissAdScreen()
    {
        IMInterstitial.a(a, ate.INIT);
        IMInterstitial.a(a, 103, null, null);
    }

    public void onIncentCompleted(Map map)
    {
        IMInterstitial.a(a, 106, null, map);
    }

    public void onLeaveApplication()
    {
        IMInterstitial.a(a, 104, null, null);
    }

    public void onShowAdScreen()
    {
        IMInterstitial.a(a, ate.ACTIVE);
        IMInterstitial.a(a, 102, null, null);
    }

    ode(IMInterstitial iminterstitial)
    {
        a = iminterstitial;
        super();
    }
}
