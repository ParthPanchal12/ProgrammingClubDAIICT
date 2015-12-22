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
//            AppActivity

class this._cls0
    implements android.widget.heckedChangeListener
{

    final AppActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        AppActivity.access$10(AppActivity.this, i);
        if (AppActivity.access$11(AppActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(AppActivity.access$12(AppActivity.this), ((RadioButton)AppActivity.access$11(AppActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            AppActivity.access$13(AppActivity.this).startAnimation(radiogroup);
            AppActivity.access$14(AppActivity.this).setCurrentItem(i);
            AppActivity.access$15(AppActivity.this, ((RadioButton)AppActivity.access$11(AppActivity.this).getChildAt(i)).getLeft());
            radiogroup = AppActivity.access$16(AppActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)AppActivity.access$11(AppActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)AppActivity.access$11(AppActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    ollView()
    {
        this$0 = AppActivity.this;
        super();
    }
}
