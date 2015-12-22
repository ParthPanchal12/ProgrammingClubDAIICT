// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.monetization.internal:
//            InterstitialAd, AdErrorCode, IMAdListener

static class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        InterstitialAd interstitialad = (InterstitialAd)a.get();
        if (interstitialad != null)
        {
            try
            {
                switch (message.what)
                {
                case 301: 
                    InterstitialAd.b(interstitialad).cancelLoad();
                    InterstitialAd.b(interstitialad).stopLoading();
                    InterstitialAd.b(interstitialad).deinit();
                    InterstitialAd.a(interstitialad, null);
                    long l = System.currentTimeMillis();
                    long l1 = InterstitialAd.c(interstitialad);
                    interstitialad.collectMetrics(InterstitialAd.d(interstitialad), l - l1, NetworkEventType.RENDER_TIMEOUT);
                    if (interstitialad.mAdListener != null)
                    {
                        interstitialad.mAdListener.onAdRequestFailed(AdErrorCode.AD_RENDERING_TIMEOUT);
                        return;
                    }
                    break;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.internal("[InMobi]-[Monetization]", "Exception handling message in Interstitial", message);
                return;
            }
        }
    }

    public entType(InterstitialAd interstitialad)
    {
        a = new WeakReference(interstitialad);
    }
}
