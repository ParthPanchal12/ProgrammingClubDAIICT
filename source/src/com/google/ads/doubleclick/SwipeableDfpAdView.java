// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.doubleclick;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdSize;
import com.google.ads.SwipeableAdListener;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.d;
import com.google.ads.n;

// Referenced classes of package com.google.ads.doubleclick:
//            DfpAdView

public class SwipeableDfpAdView extends DfpAdView
{

    public SwipeableDfpAdView(Activity activity, AdSize adsize, String s)
    {
        super(activity, adsize, s);
    }

    public SwipeableDfpAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SwipeableDfpAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void resize(AdSize adsize)
    {
        super.resize(adsize);
        if (((ActivationOverlay)a.i().e.a()).b())
        {
            a.a(-1, -1, adsize.getWidth(), adsize.getHeight());
        }
    }

    public void setSwipeableEventListener(SwipeableAdListener swipeableadlistener)
    {
        super.setSwipeableEventListener(swipeableadlistener);
    }
}
