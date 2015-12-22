// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.animation.Animation;

// Referenced classes of package com.facebook.ads:
//            AdView

class a
    implements android.view.animation..AnimationListener
{

    final AdView a;

    public void onAnimationEnd(Animation animation)
    {
        a.removeView(AdView.f(a));
        AdView.a(a, null);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    mation(AdView adview)
    {
        a = adview;
        super();
    }
}
