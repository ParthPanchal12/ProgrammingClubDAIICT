// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import com.google.ads.internal.d;

// Referenced classes of package com.google.ads:
//            Ad, n, AdRequest, AdListener, 
//            AppEventListener

public class InterstitialAd
    implements Ad
{

    private d a;

    public InterstitialAd(Activity activity, String s)
    {
        this(activity, s, false);
    }

    public InterstitialAd(Activity activity, String s, boolean flag)
    {
        a = new d(this, activity, null, s, null, flag);
    }

    public boolean isReady()
    {
        return a.s();
    }

    public void loadAd(AdRequest adrequest)
    {
        a.a(adrequest);
    }

    public void setAdListener(AdListener adlistener)
    {
        a.i().o.a(adlistener);
    }

    protected void setAppEventListener(AppEventListener appeventlistener)
    {
        a.i().p.a(appeventlistener);
    }

    public void show()
    {
        a.B();
    }

    public void stopLoading()
    {
        a.C();
    }
}
