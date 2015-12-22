// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class this._cls0
    implements android.view.animation.ionListener
{

    final HomeFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        HomeFragment.access$4(HomeFragment.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    stener()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
