// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.inmobi.commons.AnimationType;
import com.inmobi.monetization.internal.anim.Rotate3dAnimation;
import com.inmobi.monetization.internal.anim.Rotate3dAnimationVert;

// Referenced classes of package com.inmobi.monetization.internal:
//            BannerAd

class d
{

    private BannerAd a;
    private android.view.animation.Animation.AnimationListener b;

    public d(BannerAd bannerad, android.view.animation.Animation.AnimationListener animationlistener)
    {
        a = bannerad;
        b = animationlistener;
    }

    public void a(AnimationType animationtype)
    {
        if (animationtype != AnimationType.ANIMATION_ALPHA) goto _L2; else goto _L1
_L1:
        animationtype = new AlphaAnimation(0.0F, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.5F, 1.0F);
        animationtype.setDuration(1000L);
        animationtype.setFillAfter(false);
        animationtype.setAnimationListener(b);
        animationtype.setInterpolator(new DecelerateInterpolator());
        alphaanimation.setDuration(500L);
        alphaanimation.setFillAfter(false);
        alphaanimation.setAnimationListener(b);
        alphaanimation.setInterpolator(new DecelerateInterpolator());
        a.a(animationtype);
        a.b(alphaanimation);
_L4:
        a.c(a.a());
        return;
_L2:
        if (animationtype == AnimationType.ROTATE_HORIZONTAL_AXIS)
        {
            animationtype = new Rotate3dAnimation(0.0F, 90F, (float)a.b() / 2.0F, (float)a.c() / 2.0F, 0.0F, true);
            Rotate3dAnimation rotate3danimation = new Rotate3dAnimation(270F, 360F, (float)a.b() / 2.0F, (float)a.c() / 2.0F, 0.0F, true);
            animationtype.setDuration(500L);
            animationtype.setFillAfter(false);
            animationtype.setAnimationListener(b);
            animationtype.setInterpolator(new AccelerateInterpolator());
            rotate3danimation.setDuration(500L);
            rotate3danimation.setFillAfter(false);
            rotate3danimation.setAnimationListener(b);
            rotate3danimation.setInterpolator(new DecelerateInterpolator());
            a.a(animationtype);
            a.b(rotate3danimation);
        } else
        if (animationtype == AnimationType.ROTATE_VERTICAL_AXIS)
        {
            animationtype = new Rotate3dAnimationVert(0.0F, 90F, (float)a.b() / 2.0F, (float)a.c() / 2.0F, 0.0F, true);
            Rotate3dAnimationVert rotate3danimationvert = new Rotate3dAnimationVert(270F, 360F, (float)a.b() / 2.0F, (float)a.c() / 2.0F, 0.0F, true);
            animationtype.setDuration(500L);
            animationtype.setFillAfter(false);
            animationtype.setAnimationListener(b);
            animationtype.setInterpolator(new AccelerateInterpolator());
            rotate3danimationvert.setDuration(500L);
            rotate3danimationvert.setFillAfter(false);
            rotate3danimationvert.setAnimationListener(b);
            rotate3danimationvert.setInterpolator(new DecelerateInterpolator());
            a.a(animationtype);
            a.b(rotate3danimationvert);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
