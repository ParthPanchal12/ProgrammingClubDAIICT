// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0
    implements android.view.animation.nListener
{

    final MyMainActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        MyMainActivity.access$12(MyMainActivity.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    tener()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
