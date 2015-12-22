// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization.internal:
//            InterstitialAd, IMAdListener, AdErrorCode

class a
    implements com.inmobi.re.container.ewListener
{

    final InterstitialAd a;

    public void onDismissAdScreen()
    {
        a.destroy();
        if (a.mAdListener != null)
        {
            a.mAdListener.onDismissAdScreen();
        }
    }

    public void onDisplayFailed()
    {
        InterstitialAd.f(a);
    }

    public void onError()
    {
        Log.debug("[InMobi]-[Monetization]", "Error loading the interstitial ad ");
        InterstitialAd.e(a).removeMessages(301);
        InterstitialAd.a(a, null);
        if (a.mAdListener != null)
        {
            a.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    public void onExpand()
    {
    }

    public void onExpandClose()
    {
    }

    public void onIncentCompleted(Map map)
    {
        if (a.mAdListener != null)
        {
            a.mAdListener.onIncentCompleted(map);
        }
    }

    public void onLeaveApplication()
    {
        if (a.mAdListener != null)
        {
            a.mAdListener.onLeaveApplication();
        }
    }

    public void onResize(ResizeDimensions resizedimensions)
    {
    }

    public void onResizeClose()
    {
    }

    public void onShowAdScreen()
    {
        if (a.mAdListener != null)
        {
            a.mAdListener.onShowAdScreen();
        }
    }

    public void onUserInteraction(Map map)
    {
        if (a.mAdListener != null)
        {
            a.mAdListener.onAdInteraction(map);
        }
    }

    (InterstitialAd interstitialad)
    {
        a = interstitialad;
        super();
    }
}
