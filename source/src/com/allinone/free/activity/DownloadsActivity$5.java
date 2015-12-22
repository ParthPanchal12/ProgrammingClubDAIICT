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
//            DownloadsActivity

class this._cls0
    implements android.widget.ChangeListener
{

    final DownloadsActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        DownloadsActivity.access$2(DownloadsActivity.this, i);
        if (DownloadsActivity.access$3(DownloadsActivity.this).getChildAt(i) != null)
        {
            radiogroup = new TranslateAnimation(DownloadsActivity.access$4(DownloadsActivity.this), ((RadioButton)DownloadsActivity.access$3(DownloadsActivity.this).getChildAt(i)).getLeft(), 0.0F, 0.0F);
            radiogroup.setInterpolator(new LinearInterpolator());
            radiogroup.setDuration(100L);
            radiogroup.setFillAfter(true);
            DownloadsActivity.access$5(DownloadsActivity.this).startAnimation(radiogroup);
            DownloadsActivity.access$6(DownloadsActivity.this).setCurrentItem(i);
            DownloadsActivity.access$7(DownloadsActivity.this, ((RadioButton)DownloadsActivity.access$3(DownloadsActivity.this).getChildAt(i)).getLeft());
            radiogroup = DownloadsActivity.access$8(DownloadsActivity.this);
            if (i > 1)
            {
                i = ((RadioButton)DownloadsActivity.access$3(DownloadsActivity.this).getChildAt(i)).getLeft();
            } else
            {
                i = 0;
            }
            radiogroup.smoothScrollTo(i - ((RadioButton)DownloadsActivity.access$3(DownloadsActivity.this).getChildAt(1)).getLeft(), 0);
        }
    }

    w()
    {
        this$0 = DownloadsActivity.this;
        super();
    }
}
