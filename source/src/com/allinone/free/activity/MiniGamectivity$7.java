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
//            MiniGamectivity

class this._cls0
    implements android.widget.edChangeListener
{

    final MiniGamectivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        MiniGamectivity.access$8(MiniGamectivity.this, i);
        if (MiniGamectivity.access$9(MiniGamectivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(MiniGamectivity.access$10(MiniGamectivity.this), ((RadioButton)MiniGamectivity.access$9(MiniGamectivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            MiniGamectivity.access$11(MiniGamectivity.this).startAnimation(radiogroup);
            MiniGamectivity.access$12(MiniGamectivity.this).setCurrentItem(i);
            MiniGamectivity.access$13(MiniGamectivity.this, ((RadioButton)MiniGamectivity.access$9(MiniGamectivity.this).getChildAt(i)).getLeft());
            radiogroup = MiniGamectivity.access$14(MiniGamectivity.this);
            if (i > 1)
            {
                i = ((RadioButton)MiniGamectivity.access$9(MiniGamectivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)MiniGamectivity.access$9(MiniGamectivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    iew()
    {
        this$0 = MiniGamectivity.this;
        super();
    }
}
