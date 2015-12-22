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
//            RingtoneActivity

class this._cls0
    implements android.widget.dChangeListener
{

    final RingtoneActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        RingtoneActivity.access$2(RingtoneActivity.this, i);
        if (RingtoneActivity.access$3(RingtoneActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(RingtoneActivity.access$4(RingtoneActivity.this), ((RadioButton)RingtoneActivity.access$3(RingtoneActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            RingtoneActivity.access$5(RingtoneActivity.this).startAnimation(radiogroup);
            RingtoneActivity.access$6(RingtoneActivity.this).setCurrentItem(i);
            RingtoneActivity.access$7(RingtoneActivity.this, ((RadioButton)RingtoneActivity.access$3(RingtoneActivity.this).getChildAt(i)).getLeft());
            radiogroup = RingtoneActivity.access$8(RingtoneActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)RingtoneActivity.access$3(RingtoneActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)RingtoneActivity.access$3(RingtoneActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    ew()
    {
        this$0 = RingtoneActivity.this;
        super();
    }
}
