// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.a;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads:
//            h, e

class k
    implements MediationInterstitialListener
{

    private final h a;

    k(h h1)
    {
        a = h1;
    }

    public void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        synchronized (a)
        {
            a.j().b(a);
        }
        return;
        exception;
        mediationinterstitialadapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, AdRequest.ErrorCode errorcode)
    {
        h h1 = a;
        h1;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(mediationinterstitialadapter, a.i());
        b.a((new StringBuilder()).append("Mediation adapter ").append(mediationinterstitialadapter.getClass().getName()).append(" failed to receive ad with error code: ").append(errorcode).toString());
        if (!a.c()) goto _L2; else goto _L1
_L1:
        b.b("Got an onFailedToReceiveAd() callback after loadAdTask is done from an interstitial adapter.  Ignoring callback.");
_L4:
        return;
_L2:
        h h2;
        h2 = a;
        if (errorcode != AdRequest.ErrorCode.NO_FILL)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        mediationinterstitialadapter = com.google.ads.g.a.b;
_L5:
        h2.a(false, mediationinterstitialadapter);
        if (true) goto _L4; else goto _L3
_L3:
        mediationinterstitialadapter;
        h1;
        JVM INSTR monitorexit ;
        throw mediationinterstitialadapter;
        mediationinterstitialadapter = g.a.c;
          goto _L5
    }

    public void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        synchronized (a)
        {
            a.j().c(a);
        }
        return;
        exception;
        mediationinterstitialadapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        synchronized (a)
        {
            a.j().a(a);
        }
        return;
        exception;
        mediationinterstitialadapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        h h1 = a;
        h1;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(mediationinterstitialadapter, a.i());
        if (!a.c())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        b.e("Got an onReceivedAd() callback after loadAdTask is done from an interstitial adapter. Ignoring callback.");
_L2:
        return;
        a.a(true, com.google.ads.g.a.a);
        if (true) goto _L2; else goto _L1
_L1:
        mediationinterstitialadapter;
        h1;
        JVM INSTR monitorexit ;
        throw mediationinterstitialadapter;
    }
}
