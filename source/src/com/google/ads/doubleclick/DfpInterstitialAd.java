// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.doubleclick;

import android.app.Activity;
import com.google.ads.AppEventListener;
import com.google.ads.InterstitialAd;

public class DfpInterstitialAd extends InterstitialAd
{

    public DfpInterstitialAd(Activity activity, String s)
    {
        super(activity, s);
    }

    public DfpInterstitialAd(Activity activity, String s, boolean flag)
    {
        super(activity, s, flag);
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        super.setAppEventListener(appeventlistener);
    }
}
