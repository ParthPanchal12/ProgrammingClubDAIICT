// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.allinone.free.activity:
//            AppActivity

class this._cls0
    implements android.view.animation.ationListener
{

    final AppActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        AppActivity.access$4(AppActivity.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    nListener()
    {
        this$0 = AppActivity.this;
        super();
    }
}
