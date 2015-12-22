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
//            Mp3Activity

class this._cls0
    implements android.widget.heckedChangeListener
{

    final Mp3Activity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        Mp3Activity.access$2(Mp3Activity.this, i);
        if (Mp3Activity.access$3(Mp3Activity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(Mp3Activity.access$4(Mp3Activity.this), ((RadioButton)Mp3Activity.access$3(Mp3Activity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            Mp3Activity.access$5(Mp3Activity.this).startAnimation(radiogroup);
            Mp3Activity.access$6(Mp3Activity.this).setCurrentItem(i);
            Mp3Activity.access$7(Mp3Activity.this, ((RadioButton)Mp3Activity.access$3(Mp3Activity.this).getChildAt(i)).getLeft());
            radiogroup = Mp3Activity.access$8(Mp3Activity.this);
            if (i > 1)
            {
                i = ((RadioButton)Mp3Activity.access$3(Mp3Activity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)Mp3Activity.access$3(Mp3Activity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    ollView()
    {
        this$0 = Mp3Activity.this;
        super();
    }
}
