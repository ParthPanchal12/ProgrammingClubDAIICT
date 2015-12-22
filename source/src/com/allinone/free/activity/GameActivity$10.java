// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.view.ViewPager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.allinone.free.views.SyncHorizontalScrollView;

// Referenced classes of package com.allinone.free.activity:
//            GameActivity

class this._cls0
    implements android.widget.ckedChangeListener
{

    final GameActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        GameActivity.access$15(GameActivity.this, i);
        if (GameActivity.access$16(GameActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(GameActivity.access$17(GameActivity.this), ((RadioButton)GameActivity.access$16(GameActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            GameActivity.access$18(GameActivity.this).startAnimation(radiogroup);
            GameActivity.access$19(GameActivity.this).setCurrentItem(i);
            GameActivity.access$20(GameActivity.this, ((RadioButton)GameActivity.access$16(GameActivity.this).getChildAt(i)).getLeft());
            radiogroup = GameActivity.access$21(GameActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)GameActivity.access$16(GameActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)GameActivity.access$16(GameActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    lView()
    {
        this$0 = GameActivity.this;
        super();
    }
}
