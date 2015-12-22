// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            AdultActivity

class this._cls0
    implements android.support.v4.view.ChangeListener
{

    final AdultActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        AdultActivity.access$14(AdultActivity.this, i);
        if (AdultActivity.access$15(AdultActivity.this) != null && AdultActivity.access$15(AdultActivity.this).getChildCount() > i)
        {
            ((RadioButton)AdultActivity.access$15(AdultActivity.this).getChildAt(i)).performClick();
        }
    }

    ngeListener()
    {
        this$0 = AdultActivity.this;
        super();
    }
}
