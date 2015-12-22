// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            AppActivity

class this._cls0
    implements android.support.v4.view.geChangeListener
{

    final AppActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        AppActivity.access$10(AppActivity.this, i);
        if (AppActivity.access$11(AppActivity.this) != null && AppActivity.access$11(AppActivity.this).getChildCount() > i)
        {
            ((RadioButton)AppActivity.access$11(AppActivity.this).getChildAt(i)).performClick();
        }
    }

    hangeListener()
    {
        this$0 = AppActivity.this;
        super();
    }
}
