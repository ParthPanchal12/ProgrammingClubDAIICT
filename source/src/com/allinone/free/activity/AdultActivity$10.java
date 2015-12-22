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
//            AdultActivity

class this._cls0
    implements android.widget.kedChangeListener
{

    final AdultActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        AdultActivity.access$14(AdultActivity.this, i);
        if (AdultActivity.access$15(AdultActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(AdultActivity.access$16(AdultActivity.this), ((RadioButton)AdultActivity.access$15(AdultActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            AdultActivity.access$17(AdultActivity.this).startAnimation(radiogroup);
            AdultActivity.access$18(AdultActivity.this).setCurrentItem(i);
            AdultActivity.access$19(AdultActivity.this, ((RadioButton)AdultActivity.access$15(AdultActivity.this).getChildAt(i)).getLeft());
            radiogroup = AdultActivity.access$20(AdultActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)AdultActivity.access$15(AdultActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)AdultActivity.access$15(AdultActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    View()
    {
        this$0 = AdultActivity.this;
        super();
    }
}
