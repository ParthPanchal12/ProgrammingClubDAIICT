// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.allinone.free.activity:
//            GameActivity

class this._cls0
    implements android.view.animation.tionListener
{

    final GameActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        GameActivity.access$4(GameActivity.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    Listener()
    {
        this$0 = GameActivity.this;
        super();
    }
}
