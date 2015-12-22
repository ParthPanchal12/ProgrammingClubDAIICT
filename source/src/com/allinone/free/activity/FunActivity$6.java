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
//            FunActivity

class this._cls0
    implements android.widget.heckedChangeListener
{

    final FunActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        FunActivity.access$6(FunActivity.this, i);
        if (FunActivity.access$7(FunActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(FunActivity.access$8(FunActivity.this), ((RadioButton)FunActivity.access$7(FunActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            FunActivity.access$9(FunActivity.this).startAnimation(radiogroup);
            FunActivity.access$10(FunActivity.this).setCurrentItem(i);
            FunActivity.access$11(FunActivity.this, ((RadioButton)FunActivity.access$7(FunActivity.this).getChildAt(i)).getLeft());
            radiogroup = FunActivity.access$12(FunActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)FunActivity.access$7(FunActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)FunActivity.access$7(FunActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    ollView()
    {
        this$0 = FunActivity.this;
        super();
    }
}
