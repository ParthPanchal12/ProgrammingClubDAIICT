// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.doubleclick;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.internal.h;
import com.google.ads.n;

public class DfpAdView extends AdView
{

    public DfpAdView(Activity activity, AdSize adsize, String s)
    {
        super(activity, adsize, s);
    }

    public DfpAdView(Activity activity, AdSize aadsize[], String s)
    {
        super(activity, aadsize, s);
    }

    public DfpAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public DfpAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void enableManualImpressions(boolean flag)
    {
        a.i().t.a(Boolean.valueOf(flag));
    }

    public void recordImpression()
    {
        a.z();
    }

    public void resize(AdSize adsize)
    {
        a.l().setAdSize(adsize);
        ((h)a.i().g.a()).b(adsize);
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        super.setAppEventListener(appeventlistener);
    }

    public transient void setSupportedAdSizes(AdSize aadsize[])
    {
        super.setSupportedAdSizes(aadsize);
    }
}
