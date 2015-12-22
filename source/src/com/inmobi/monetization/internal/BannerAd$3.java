// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.view.animation.Animation;

// Referenced classes of package com.inmobi.monetization.internal:
//            BannerAd

class a
    implements android.view.animation.nimationListener
{

    final BannerAd a;

    public void onAnimationEnd(Animation animation)
    {
        BannerAd.g(a);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    stener(BannerAd bannerad)
    {
        a = bannerad;
        super();
    }
}
