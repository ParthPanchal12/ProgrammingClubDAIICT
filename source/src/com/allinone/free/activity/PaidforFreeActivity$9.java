// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            PaidforFreeActivity

class this._cls0
    implements android.support.v4.view.Listener
{

    final PaidforFreeActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        PaidforFreeActivity.access$15(PaidforFreeActivity.this, i);
        if (PaidforFreeActivity.access$16(PaidforFreeActivity.this) != null && PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildCount() > i)
        {
            ((RadioButton)PaidforFreeActivity.access$16(PaidforFreeActivity.this).getChildAt(i)).performClick();
        }
    }

    tener()
    {
        this$0 = PaidforFreeActivity.this;
        super();
    }
}
