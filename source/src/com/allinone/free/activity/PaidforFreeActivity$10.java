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
//            PaidforFreeActivity

class this._cls0
    implements android.widget.ngeListener
{

    final PaidforFreeActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        PaidforFreeActivity.access$15(PaidforFreeActivity.this, i);
        if (PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(PaidforFreeActivity.access$17(PaidforFreeActivity.this), ((RadioButton)PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            PaidforFreeActivity.access$18(PaidforFreeActivity.this).startAnimation(radiogroup);
            PaidforFreeActivity.access$19(PaidforFreeActivity.this).setCurrentItem(i);
            PaidforFreeActivity.access$20(PaidforFreeActivity.this, ((RadioButton)PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildAt(i)).getLeft());
            radiogroup = PaidforFreeActivity.access$21(PaidforFreeActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    ()
    {
        this$0 = PaidforFreeActivity.this;
        super();
    }
}
